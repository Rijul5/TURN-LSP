package io.typefox.yang.tests.integration;

import com.google.common.collect.Iterables;
import com.google.inject.Injector;
import io.typefox.yang.YangStandaloneSetup;
import io.typefox.yang.parser.antlr.lexer.jflex.JFlexBasedInternalYangLexer;
import java.io.File;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Collection;
import org.antlr.runtime.ANTLRFileStream;
import org.antlr.runtime.Token;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtend.lib.annotations.FinalFieldsConstructor;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.resource.XtextResourceSet;
import org.eclipse.xtext.resource.XtextSyntaxDiagnostic;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IntegerRange;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@FinalFieldsConstructor
@RunWith(Parameterized.class)
@SuppressWarnings("all")
public class IntegrationTest {
  @Parameterized.Parameters(name = "{0}")
  public static Collection<Object[]> getFiles() {
    final ArrayList<Object[]> params = CollectionLiterals.<Object[]>newArrayList();
    File _file = new File("./src/test/resources");
    final Procedure1<File> _function = (File it) -> {
      final Object[] arr = new Object[1];
      arr[0] = it;
      params.add(arr);
    };
    IntegrationTest.scanRecursively(_file, _function);
    return params;
  }
  
  public static void scanRecursively(final File file, final Procedure1<? super File> acceptor) {
    boolean _isDirectory = file.isDirectory();
    if (_isDirectory) {
      File[] _listFiles = file.listFiles();
      for (final File f : _listFiles) {
        IntegrationTest.scanRecursively(f, acceptor);
      }
    } else {
      boolean _endsWith = file.getName().endsWith(".yang");
      if (_endsWith) {
        acceptor.apply(file);
      }
    }
  }
  
  private final File file;
  
  @Test
  public void testLexing() {
    try {
      final JFlexBasedInternalYangLexer lexer = new JFlexBasedInternalYangLexer();
      String _absolutePath = this.file.getAbsolutePath();
      ANTLRFileStream _aNTLRFileStream = new ANTLRFileStream(_absolutePath);
      lexer.setCharStream(_aNTLRFileStream);
      Token t = lexer.nextToken();
      final StringBuffer buffer = new StringBuffer();
      final ArrayList<Token> tokens = CollectionLiterals.<Token>newArrayList();
      while ((t.getType() != JFlexBasedInternalYangLexer.EOF)) {
        {
          int _type = t.getType();
          boolean _tripleEquals = (_type == JFlexBasedInternalYangLexer.RULE_ANY_OTHER);
          if (_tripleEquals) {
            StringConcatenation _builder = new StringConcatenation();
            _builder.append("Lexing ");
            String _name = this.file.getName();
            _builder.append(_name);
            _builder.append(" failed.");
            _builder.newLineIfNotEmpty();
            _builder.append("```");
            _builder.newLine();
            _builder.append("\t");
            _builder.append(buffer, "\t");
            _builder.append(" !");
            String _text = t.getText();
            _builder.append(_text, "\t");
            _builder.append("!");
            final Function1<Integer, Token> _function = (Integer it) -> {
              return lexer.nextToken();
            };
            final Function1<Token, CharSequence> _function_1 = (Token it) -> {
              return it.getText();
            };
            String _join = IterableExtensions.<Token>join(IterableExtensions.<Integer, Token>map(new IntegerRange(1, 5), _function), "", _function_1);
            _builder.append(_join, "\t");
            _builder.append("...");
            _builder.newLineIfNotEmpty();
            _builder.append("```");
            _builder.newLine();
            Assert.fail(_builder.toString());
          }
          try {
            buffer.append(t.getText());
            tokens.add(t);
            t = lexer.nextToken();
          } catch (final Throwable _t) {
            if (_t instanceof Error) {
            } else {
              throw Exceptions.sneakyThrow(_t);
            }
          }
        }
      }
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  private static final Injector injector = new YangStandaloneSetup().createInjectorAndDoEMFRegistration();
  
  private final XtextResourceSet rs = IntegrationTest.injector.<XtextResourceSet>getInstance(XtextResourceSet.class);
  
  @Test
  public void testParsing() {
    try {
      final Resource resource = this.rs.getResource(URI.createFileURI(this.file.getAbsolutePath()), true);
      Iterable<XtextSyntaxDiagnostic> _filter = Iterables.<XtextSyntaxDiagnostic>filter(resource.getErrors(), XtextSyntaxDiagnostic.class);
      for (final XtextSyntaxDiagnostic issue : _filter) {
        {
          byte[] _readAllBytes = Files.readAllBytes(this.file.toPath());
          final String contents = new String(_readAllBytes);
          StringConcatenation _builder = new StringConcatenation();
          String _substring = contents.substring(0, issue.getOffset());
          _builder.append(_substring);
          _builder.append("!");
          int _offset = issue.getOffset();
          int _offset_1 = issue.getOffset();
          int _length = issue.getLength();
          int _plus = (_offset_1 + _length);
          String _substring_1 = contents.substring(_offset, _plus);
          _builder.append(_substring_1);
          _builder.append("!{");
          String _message = issue.getMessage();
          _builder.append(_message);
          _builder.append("}");
          int _offset_2 = issue.getOffset();
          int _length_1 = issue.getLength();
          int _plus_1 = (_offset_2 + _length_1);
          String _substring_2 = contents.substring(_plus_1);
          _builder.append(_substring_2);
          Assert.assertEquals(contents, _builder.toString());
        }
      }
      Assert.assertTrue(IterableExtensions.join(resource.getErrors(), ","), resource.getErrors().isEmpty());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  public IntegrationTest(final File file) {
    super();
    this.file = file;
  }
}

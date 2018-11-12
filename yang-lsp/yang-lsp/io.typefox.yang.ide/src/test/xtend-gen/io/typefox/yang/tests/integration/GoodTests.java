package io.typefox.yang.tests.integration;

import com.google.common.base.Objects;
import java.io.File;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import org.apache.log4j.Logger;
import org.eclipse.emf.common.util.URI;
import org.eclipse.lsp4j.Diagnostic;
import org.eclipse.lsp4j.DiagnosticSeverity;
import org.eclipse.lsp4j.InitializeParams;
import org.eclipse.lsp4j.Position;
import org.eclipse.xtend.lib.annotations.Data;
import org.eclipse.xtend.lib.annotations.FinalFieldsConstructor;
import org.eclipse.xtext.testing.AbstractLanguageServerTest;
import org.eclipse.xtext.util.internal.Log;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.ExclusiveRange;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.InputOutput;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.eclipse.xtext.xbase.lib.Pure;
import org.eclipse.xtext.xbase.lib.util.ToStringBuilder;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@Log
@FinalFieldsConstructor
@RunWith(Parameterized.class)
@SuppressWarnings("all")
public class GoodTests {
  public static class DiagnosticsTest extends AbstractLanguageServerTest {
    public DiagnosticsTest() {
      super("yang");
    }
    
    public Collection<Object[]> getUrisAndDiagnostics() {
      final long before = System.currentTimeMillis();
      final Procedure1<InitializeParams> _function = (InitializeParams it) -> {
        it.setRootUri(new File("./src/test/resources").getAbsoluteFile().toURI().toString());
      };
      this.initialize(_function);
      try {
        final Function1<Map.Entry<String, List<Diagnostic>>, Object[]> _function_1 = (Map.Entry<String, List<Diagnostic>> it) -> {
          final Object[] result = new Object[3];
          result[0] = it.getKey();
          result[1] = it.getValue();
          result[2] = URI.createURI(it.getKey()).lastSegment();
          return result;
        };
        return IterableExtensions.<Object[]>toList(IterableExtensions.<Map.Entry<String, List<Diagnostic>>, Object[]>map(this.getDiagnostics().entrySet(), _function_1));
      } finally {
        long _currentTimeMillis = System.currentTimeMillis();
        long _minus = (_currentTimeMillis - before);
        String _plus = ("Building took " + Long.valueOf(_minus));
        String _plus_1 = (_plus + " ms.");
        InputOutput.<String>println(_plus_1);
      }
    }
  }
  
  @Data
  public static class Insert {
    private final int offset;
    
    private final String content;
    
    public Insert(final int offset, final String content) {
      super();
      this.offset = offset;
      this.content = content;
    }
    
    @Override
    @Pure
    public int hashCode() {
      final int prime = 31;
      int result = 1;
      result = prime * result + this.offset;
      return prime * result + ((this.content== null) ? 0 : this.content.hashCode());
    }
    
    @Override
    @Pure
    public boolean equals(final Object obj) {
      if (this == obj)
        return true;
      if (obj == null)
        return false;
      if (getClass() != obj.getClass())
        return false;
      GoodTests.Insert other = (GoodTests.Insert) obj;
      if (other.offset != this.offset)
        return false;
      if (this.content == null) {
        if (other.content != null)
          return false;
      } else if (!this.content.equals(other.content))
        return false;
      return true;
    }
    
    @Override
    @Pure
    public String toString() {
      ToStringBuilder b = new ToStringBuilder(this);
      b.add("offset", this.offset);
      b.add("content", this.content);
      return b.toString();
    }
    
    @Pure
    public int getOffset() {
      return this.offset;
    }
    
    @Pure
    public String getContent() {
      return this.content;
    }
  }
  
  @Parameterized.Parameters(name = "{2}")
  public static Collection<Object[]> getURIAndDiagnostics() {
    final GoodTests.DiagnosticsTest test = new GoodTests.DiagnosticsTest();
    test.setup();
    return test.getUrisAndDiagnostics();
  }
  
  private final String uri;
  
  private final List<Diagnostic> diagnostics;
  
  protected final String simpleName;
  
  @Test
  public void checkDiagnostics() {
    try {
      boolean _equals = Objects.equal(this.simpleName, "ietf-ipfix-psamp.yang");
      if (_equals) {
        GoodTests.LOG.warn(("Ignored test file: " + this.simpleName));
        return;
      }
      final Function1<Diagnostic, Integer> _function = (Diagnostic it) -> {
        return Integer.valueOf(it.getRange().getStart().getLine());
      };
      final Function1<Diagnostic, Integer> _function_1 = (Diagnostic it) -> {
        return Integer.valueOf(it.getRange().getStart().getCharacter());
      };
      final List<Diagnostic> issues = IterableExtensions.<Diagnostic>toList(IterableExtensions.<Diagnostic, Integer>sortBy(IterableExtensions.<Diagnostic, Integer>sortBy(this.diagnostics, _function), _function_1));
      final ArrayList<GoodTests.Insert> inserts = CollectionLiterals.<GoodTests.Insert>newArrayList();
      String _fileString = URI.createURI(this.uri).toFileString();
      final List<String> lines = Files.readAllLines(new File(_fileString).toPath());
      int _size = issues.size();
      ExclusiveRange _doubleDotLessThan = new ExclusiveRange(0, _size, true);
      for (final Integer issueNo : _doubleDotLessThan) {
        {
          final Diagnostic issue = issues.get((issueNo).intValue());
          DiagnosticSeverity _severity = issue.getSeverity();
          boolean _tripleEquals = (_severity == DiagnosticSeverity.Error);
          if (_tripleEquals) {
            int _offset = this.toOffset(issue.getRange().getStart(), lines);
            GoodTests.Insert _insert = new GoodTests.Insert(_offset, "[");
            inserts.add(_insert);
            int _offset_1 = this.toOffset(issue.getRange().getEnd(), lines);
            String _message = issue.getMessage();
            String _plus = ("](" + _message);
            String _plus_1 = (_plus + ")");
            GoodTests.Insert _insert_1 = new GoodTests.Insert(_offset_1, _plus_1);
            inserts.add(_insert_1);
          }
        }
      }
      final Function1<GoodTests.Insert, Integer> _function_2 = (GoodTests.Insert it) -> {
        return Integer.valueOf(it.offset);
      };
      final List<GoodTests.Insert> sorted = IterableExtensions.<GoodTests.Insert, Integer>sortBy(inserts, _function_2);
      final String original = IterableExtensions.join(lines, "\n");
      String annotated = "";
      int lastInsert = 0;
      for (final GoodTests.Insert insert : sorted) {
        {
          String _annotated = annotated;
          String _substring = original.substring(lastInsert, insert.offset);
          annotated = (_annotated + _substring);
          String _annotated_1 = annotated;
          annotated = (_annotated_1 + insert.content);
          lastInsert = insert.offset;
        }
      }
      String _annotated = annotated;
      String _substring = original.substring(lastInsert);
      annotated = (_annotated + _substring);
      Assert.assertEquals(original, annotated);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  public int toOffset(final Position pos, final List<String> strings) {
    int offset = 0;
    int _size = strings.size();
    ExclusiveRange _doubleDotLessThan = new ExclusiveRange(0, _size, true);
    for (final Integer line : _doubleDotLessThan) {
      int _line = pos.getLine();
      boolean _tripleEquals = (_line == (line).intValue());
      if (_tripleEquals) {
        int _character = pos.getCharacter();
        int _plus = (offset + _character);
        int _line_1 = pos.getLine();
        return (_plus + _line_1);
      } else {
        int _offset = offset;
        int _length = strings.get((line).intValue()).length();
        offset = (_offset + _length);
      }
    }
    throw new IndexOutOfBoundsException();
  }
  
  private static final Logger LOG = Logger.getLogger(GoodTests.class);
  
  public GoodTests(final String uri, final List<Diagnostic> diagnostics, final String simpleName) {
    super();
    this.uri = uri;
    this.diagnostics = diagnostics;
    this.simpleName = simpleName;
  }
}

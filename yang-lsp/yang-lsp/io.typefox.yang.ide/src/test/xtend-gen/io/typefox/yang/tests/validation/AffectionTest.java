package io.typefox.yang.tests.validation;

import io.typefox.yang.tests.AbstractYangLSPTest;
import io.typefox.yang.utils.IterableExtensions2;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import org.eclipse.lsp4j.Diagnostic;
import org.eclipse.lsp4j.DidChangeTextDocumentParams;
import org.eclipse.lsp4j.TextDocumentContentChangeEvent;
import org.eclipse.lsp4j.VersionedTextDocumentIdentifier;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.junit.Assert;
import org.junit.Test;

@SuppressWarnings("all")
public class AffectionTest extends AbstractYangLSPTest {
  @Test
  public void testReferencedModuleRenamed_01() {
    this.initialize();
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("module foo {");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    this.open("inmemory:/foo/foo.yang", _builder.toString());
    final String uri = "inmemory:/foo/bar.yang";
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("module bar {");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("prefix b;");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("namespace urn:b;");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("import foo {");
    _builder_1.newLine();
    _builder_1.append("\t\t");
    _builder_1.append("prefix f;");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    this.open(uri, _builder_1.toString());
    this.expectDiagnostics(uri, "");
    StringConcatenation _builder_2 = new StringConcatenation();
    _builder_2.append("module foo2 {");
    _builder_2.newLine();
    _builder_2.append("\t");
    _builder_2.newLine();
    _builder_2.append("}");
    _builder_2.newLine();
    this.change("inmemory:/foo/foo.yang", _builder_2.toString());
    this.expectDiagnostics(uri, "Couldn\'t resolve reference to AbstractModule \'foo\'.:3");
    StringConcatenation _builder_3 = new StringConcatenation();
    _builder_3.append("module foo {");
    _builder_3.newLine();
    _builder_3.append("\t");
    _builder_3.newLine();
    _builder_3.append("}");
    _builder_3.newLine();
    this.change("inmemory:/foo/foo.yang", _builder_3.toString());
    this.expectDiagnostics(uri, "");
  }
  
  @Test
  public void testReferencedGroupingChanged() {
    this.initialize();
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("module foo {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("grouping bar {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    this.open("inmemory:/foo/foo.yang", _builder.toString());
    final String uri = "inmemory:/foo/bar.yang";
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("module bar {");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("prefix b;");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("namespace urn:b;");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("import foo {");
    _builder_1.newLine();
    _builder_1.append("\t\t");
    _builder_1.append("prefix f;");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("uses f:bar;");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    this.open(uri, _builder_1.toString());
    this.expectDiagnostics(uri, "");
    StringConcatenation _builder_2 = new StringConcatenation();
    _builder_2.append("module foo {");
    _builder_2.newLine();
    _builder_2.append("\t");
    _builder_2.append("grouping bar2 {");
    _builder_2.newLine();
    _builder_2.append("\t");
    _builder_2.append("}");
    _builder_2.newLine();
    _builder_2.append("}");
    _builder_2.newLine();
    this.change("inmemory:/foo/foo.yang", _builder_2.toString());
    this.expectDiagnostics(uri, "Couldn\'t resolve reference to Grouping \'f:bar\'.:7");
    StringConcatenation _builder_3 = new StringConcatenation();
    _builder_3.append("module foo {");
    _builder_3.newLine();
    _builder_3.append("\t");
    _builder_3.append("grouping bar {");
    _builder_3.newLine();
    _builder_3.append("\t");
    _builder_3.append("}");
    _builder_3.newLine();
    _builder_3.append("}");
    _builder_3.newLine();
    this.change("inmemory:/foo/foo.yang", _builder_3.toString());
    this.expectDiagnostics(uri, "");
  }
  
  protected void expectDiagnostics(final String uri, final String expected) {
    final Map<String, List<Diagnostic>> diagnostics = this.getDiagnostics();
    Iterable<? extends Diagnostic> issues = IterableExtensions2.<Diagnostic>nullToEmpty(diagnostics.get(uri));
    final Function1<Diagnostic, Integer> _function = (Diagnostic it) -> {
      return Integer.valueOf(it.getRange().getStart().getLine());
    };
    final Function1<Diagnostic, String> _function_1 = (Diagnostic it) -> {
      return it.getMessage();
    };
    final Function1<Diagnostic, CharSequence> _function_2 = (Diagnostic it) -> {
      String _message = it.getMessage();
      String _plus = (_message + ":");
      int _line = it.getRange().getStart().getLine();
      return (_plus + Integer.valueOf(_line));
    };
    Assert.assertEquals(expected, IterableExtensions.join(IterableExtensions.sortBy(IterableExtensions.sortBy(issues, _function), _function_1), ",\n", _function_2));
  }
  
  protected void change(final String uri, final String content) {
    DidChangeTextDocumentParams _didChangeTextDocumentParams = new DidChangeTextDocumentParams();
    final Procedure1<DidChangeTextDocumentParams> _function = (DidChangeTextDocumentParams it) -> {
      VersionedTextDocumentIdentifier _versionedTextDocumentIdentifier = new VersionedTextDocumentIdentifier();
      final Procedure1<VersionedTextDocumentIdentifier> _function_1 = (VersionedTextDocumentIdentifier it_1) -> {
        it_1.setUri(uri);
      };
      VersionedTextDocumentIdentifier _doubleArrow = ObjectExtensions.<VersionedTextDocumentIdentifier>operator_doubleArrow(_versionedTextDocumentIdentifier, _function_1);
      it.setTextDocument(_doubleArrow);
      TextDocumentContentChangeEvent _textDocumentContentChangeEvent = new TextDocumentContentChangeEvent();
      final Procedure1<TextDocumentContentChangeEvent> _function_2 = (TextDocumentContentChangeEvent it_1) -> {
        it_1.setText(content);
      };
      TextDocumentContentChangeEvent _doubleArrow_1 = ObjectExtensions.<TextDocumentContentChangeEvent>operator_doubleArrow(_textDocumentContentChangeEvent, _function_2);
      it.setContentChanges(Collections.<TextDocumentContentChangeEvent>unmodifiableList(CollectionLiterals.<TextDocumentContentChangeEvent>newArrayList(_doubleArrow_1)));
    };
    DidChangeTextDocumentParams _doubleArrow = ObjectExtensions.<DidChangeTextDocumentParams>operator_doubleArrow(_didChangeTextDocumentParams, _function);
    this.languageServer.didChange(_doubleArrow);
  }
}

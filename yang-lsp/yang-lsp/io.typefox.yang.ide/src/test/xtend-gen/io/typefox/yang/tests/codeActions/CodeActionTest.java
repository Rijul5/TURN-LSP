package io.typefox.yang.tests.codeActions;

import io.typefox.yang.tests.AbstractYangLSPTest;
import java.util.List;
import org.eclipse.lsp4j.CodeAction;
import org.eclipse.lsp4j.Command;
import org.eclipse.lsp4j.TextEdit;
import org.eclipse.lsp4j.WorkspaceEdit;
import org.eclipse.lsp4j.jsonrpc.messages.Either;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.ide.server.Document;
import org.eclipse.xtext.testing.AbstractLanguageServerTest;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.junit.Assert;
import org.junit.Test;

@SuppressWarnings("all")
public class CodeActionTest extends AbstractYangLSPTest {
  @Test
  public void testFixVersion() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("module foo {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("yang-version 2;");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    final Document doc = new Document(Integer.valueOf(1), _builder.toString());
    final Procedure1<AbstractLanguageServerTest.TestCodeActionConfiguration> _function = (AbstractLanguageServerTest.TestCodeActionConfiguration it) -> {
      it.setModel(doc.getContents());
      final Procedure1<List<Either<Command, CodeAction>>> _function_1 = (List<Either<Command, CodeAction>> it_1) -> {
        Object _head = IterableExtensions.<Object>head(IterableExtensions.<Either<Command, CodeAction>>head(it_1).getLeft().getArguments());
        final WorkspaceEdit we = ((WorkspaceEdit) _head);
        StringConcatenation _builder_1 = new StringConcatenation();
        _builder_1.append("module foo {");
        _builder_1.newLine();
        _builder_1.append("\t");
        _builder_1.append("yang-version 1.1;");
        _builder_1.newLine();
        _builder_1.append("}");
        _builder_1.newLine();
        Assert.assertEquals(_builder_1.toString(), doc.applyChanges(IterableExtensions.<List<TextEdit>>head(we.getChanges().values())).getContents());
      };
      it.setAssertCodeActions(_function_1);
    };
    this.testCodeAction(_function);
  }
  
  @Test
  public void testFixVersion_01() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("module foo {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("yang-version \"2\";");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    final Document doc = new Document(Integer.valueOf(1), _builder.toString());
    final Procedure1<AbstractLanguageServerTest.TestCodeActionConfiguration> _function = (AbstractLanguageServerTest.TestCodeActionConfiguration it) -> {
      it.setModel(doc.getContents());
      final Procedure1<List<Either<Command, CodeAction>>> _function_1 = (List<Either<Command, CodeAction>> it_1) -> {
        Object _head = IterableExtensions.<Object>head(IterableExtensions.<Either<Command, CodeAction>>head(it_1).getLeft().getArguments());
        final WorkspaceEdit we = ((WorkspaceEdit) _head);
        StringConcatenation _builder_1 = new StringConcatenation();
        _builder_1.append("module foo {");
        _builder_1.newLine();
        _builder_1.append("\t");
        _builder_1.append("yang-version 1.1;");
        _builder_1.newLine();
        _builder_1.append("}");
        _builder_1.newLine();
        Assert.assertEquals(_builder_1.toString(), doc.applyChanges(IterableExtensions.<List<TextEdit>>head(we.getChanges().values())).getContents());
      };
      it.setAssertCodeActions(_function_1);
    };
    this.testCodeAction(_function);
  }
}

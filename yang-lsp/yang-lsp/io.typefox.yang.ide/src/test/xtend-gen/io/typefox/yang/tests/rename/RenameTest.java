package io.typefox.yang.tests.rename;

import io.typefox.yang.tests.AbstractYangLSPTest;
import org.eclipse.lsp4j.Position;
import org.eclipse.lsp4j.RenameParams;
import org.eclipse.lsp4j.TextDocumentIdentifier;
import org.eclipse.lsp4j.WorkspaceEdit;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.junit.Ignore;
import org.junit.Test;

/**
 * @author koehnlein - Initial contribution and API
 */
@SuppressWarnings("all")
public class RenameTest extends AbstractYangLSPTest {
  @Test
  public void testRenameInput() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("module inputaugment {");
      _builder.newLine();
      _builder.append("    ");
      _builder.append("namespace \"foo:inputaugment\";");
      _builder.newLine();
      _builder.append("    ");
      _builder.append("prefix \"ia\";");
      _builder.newLine();
      _builder.append("    ");
      _builder.append("rpc foo {");
      _builder.newLine();
      _builder.append("        ");
      _builder.append("input {");
      _builder.newLine();
      _builder.append("            ");
      _builder.append("container param {");
      _builder.newLine();
      _builder.append("            ");
      _builder.append("}");
      _builder.newLine();
      _builder.append("        ");
      _builder.append("}");
      _builder.newLine();
      _builder.append("    ");
      _builder.append("}");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      final String model = _builder.toString();
      final String file = this.writeFile("inputaugment.yang", model);
      this.initialize();
      final int line = 5;
      final int column = "            container ".length();
      TextDocumentIdentifier _textDocumentIdentifier = new TextDocumentIdentifier(file);
      Position _position = new Position(line, column);
      final RenameParams params = new RenameParams(_textDocumentIdentifier, _position, "bar");
      final WorkspaceEdit workspaceEdit = this.languageServer.rename(params).get();
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("changes :");
      _builder_1.newLine();
      _builder_1.append("    ");
      _builder_1.append("inputaugment.yang : bar [[");
      _builder_1.append(line, "    ");
      _builder_1.append(", ");
      _builder_1.append(column, "    ");
      _builder_1.append("] .. [");
      _builder_1.append(line, "    ");
      _builder_1.append(", ");
      _builder_1.append((column + 5), "    ");
      _builder_1.append("]]");
      _builder_1.newLineIfNotEmpty();
      _builder_1.append("documentChanges : ");
      _builder_1.newLine();
      this.assertEquals(_builder_1.toString(), this.toExpectation(workspaceEdit));
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  @Ignore("FIXME: ClassCastException thrown")
  public void testRenameInputAugment() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("module inputaugment {");
      _builder.newLine();
      _builder.append("    ");
      _builder.append("namespace \"foo:inputaugment\";");
      _builder.newLine();
      _builder.append("    ");
      _builder.append("prefix \"ia\";");
      _builder.newLine();
      _builder.append("    ");
      _builder.append("augment \"/foo/input/param\" {");
      _builder.newLine();
      _builder.append("        ");
      _builder.append("leaf l {");
      _builder.newLine();
      _builder.append("            ");
      _builder.append("type string;");
      _builder.newLine();
      _builder.append("        ");
      _builder.append("}");
      _builder.newLine();
      _builder.append("    ");
      _builder.append("}");
      _builder.newLine();
      _builder.append("    ");
      _builder.append("rpc foo {");
      _builder.newLine();
      _builder.append("        ");
      _builder.append("input {");
      _builder.newLine();
      _builder.append("            ");
      _builder.append("container param {");
      _builder.newLine();
      _builder.append("            ");
      _builder.append("}");
      _builder.newLine();
      _builder.append("        ");
      _builder.append("}");
      _builder.newLine();
      _builder.append("    ");
      _builder.append("}");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      final String model = _builder.toString();
      final String file = this.writeFile("inputaugment.yang", model);
      this.initialize();
      final int line = 10;
      final int column = "            container ".length();
      final int refColumn = "    augment \"/foo/input/".length();
      TextDocumentIdentifier _textDocumentIdentifier = new TextDocumentIdentifier(file);
      Position _position = new Position(line, column);
      final RenameParams params = new RenameParams(_textDocumentIdentifier, _position, "bar");
      final WorkspaceEdit workspaceEdit = this.languageServer.rename(params).get();
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("changes :");
      _builder_1.newLine();
      _builder_1.append("    ");
      _builder_1.append("inputaugment.yang : bar [[3, ");
      _builder_1.append(refColumn, "    ");
      _builder_1.append("] .. [3, ");
      _builder_1.append((refColumn + 5), "    ");
      _builder_1.append("]]");
      _builder_1.newLineIfNotEmpty();
      _builder_1.append("    ");
      _builder_1.append("inputaugment.yang : bar [[");
      _builder_1.append(line, "    ");
      _builder_1.append(", ");
      _builder_1.append(column, "    ");
      _builder_1.append("] .. [");
      _builder_1.append(line, "    ");
      _builder_1.append(", ");
      _builder_1.append((column + 5), "    ");
      _builder_1.append("]]");
      _builder_1.newLineIfNotEmpty();
      _builder_1.append("documentChanges : ");
      _builder_1.newLine();
      this.assertEquals(_builder_1.toString(), this.toExpectation(workspaceEdit));
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}

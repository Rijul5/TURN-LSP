package io.typefox.yang.tests.linking;

import io.typefox.yang.tests.AbstractYangTest;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.junit.Test;

@SuppressWarnings("all")
public class BugsTest extends AbstractYangTest {
  /**
   * https://github.com/theia-ide/yang-lsp/issues/33
   */
  @Test
  public void testIssue33() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("module moduleName {");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("// yang-version 1.1;");
    _builder.newLine();
    _builder.append("  ");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("//yan");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("y");
    _builder.newLine();
    _builder.append(" ");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("namespace \"urn:someUri\";");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("prefix \"foo\";");
    _builder.newLine();
    _builder.newLine();
    _builder.newLine();
    _builder.newLine();
    _builder.append("description \"bar\";");
    _builder.newLine();
    _builder.newLine();
    _builder.append("organization \"org\";");
    _builder.newLine();
    _builder.newLine();
    _builder.append("grouping foo {");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("list feuillage {");
    _builder.newLine();
    _builder.append("            ");
    _builder.append("description \"Local feuillage docstring\";");
    _builder.newLine();
    _builder.append("            ");
    _builder.append("uses bar {");
    _builder.newLine();
    _builder.append("                ");
    _builder.append("refine blatt {");
    _builder.newLine();
    _builder.append("                    ");
    _builder.append("default \"beech\";");
    _builder.newLine();
    _builder.append("                ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("            ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("            ");
    _builder.append("uses baz {");
    _builder.newLine();
    _builder.append("                ");
    _builder.append("refine \"leaves\" {");
    _builder.newLine();
    _builder.append("                    ");
    _builder.append("default cz;");
    _builder.newLine();
    _builder.append("                ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("                ");
    _builder.append("refine \"leaves/cz/lupen\" {");
    _builder.newLine();
    _builder.append("                    ");
    _builder.append("min-elements 0;");
    _builder.newLine();
    _builder.append("                ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("                ");
    _builder.append("refine \"leaves/dustbin/dustbin/hoja\" {");
    _builder.newLine();
    _builder.append("                    ");
    _builder.append("description \"Refined description of hoja\";");
    _builder.newLine();
    _builder.append("                ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("            ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("            ");
    _builder.append("key \"feuille\";");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("anyxml rubbish;");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("  ");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    this.root(this.loadWithSyntaxErrors(_builder));
  }
}

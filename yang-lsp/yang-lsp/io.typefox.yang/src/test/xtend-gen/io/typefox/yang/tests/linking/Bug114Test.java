package io.typefox.yang.tests.linking;

import io.typefox.yang.tests.AbstractYangTest;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.junit.Test;

@SuppressWarnings("all")
public class Bug114Test extends AbstractYangTest {
  @Test
  public void testDeviationLinking() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("module bug_114 {");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("prefix bug_114;");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("namespace bug_114;");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("list l1 {");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("leaf lf1 {");
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
    _builder.append("deviation l1 {");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("deviate add {");
    _builder.newLine();
    _builder.append("            ");
    _builder.append("unique lf1;");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    this.assertNoErrors(this.load(_builder));
  }
}

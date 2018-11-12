package io.typefox.yang.tests.codeLens;

import io.typefox.yang.tests.AbstractYangLSPTest;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.testing.AbstractLanguageServerTest;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.junit.Test;

@SuppressWarnings("all")
public class CodeLensTest extends AbstractYangLSPTest {
  @Test
  public void testCodeLens() {
    final Procedure1<AbstractLanguageServerTest.TestCodeLensConfiguration> _function = (AbstractLanguageServerTest.TestCodeLensConfiguration it) -> {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("module foo {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("prefix f;");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("leaf x {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("type string;");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("augment x {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      it.setModel(_builder.toString());
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("1 reference [[2, 1] .. [2, 5]]");
      _builder_1.newLine();
      it.setExpectedCodeLensItems(_builder_1.toString());
    };
    this.testCodeLens(_function);
  }
}

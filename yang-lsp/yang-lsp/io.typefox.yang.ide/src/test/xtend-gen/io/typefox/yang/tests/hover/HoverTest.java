package io.typefox.yang.tests.hover;

import io.typefox.yang.tests.AbstractYangLSPTest;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.testing.HoverTestConfiguration;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.junit.Test;

@SuppressWarnings("all")
public class HoverTest extends AbstractYangLSPTest {
  @Test
  public void testHover() {
    final Procedure1<HoverTestConfiguration> _function = (HoverTestConfiguration it) -> {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("module foo {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("description \"   Hello");
      _builder.newLine();
      _builder.append("\t             ");
      _builder.append("This is super.");
      _builder.newLine();
      _builder.append("\t                ");
      _builder.append("test");
      _builder.newLine();
      _builder.append("\t             ");
      _builder.append("Bla blubb\"");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      it.setModel(_builder.toString());
      it.setLine(0);
      it.setColumn(8);
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("[[0, 7] .. [0, 10]]");
      _builder_1.newLine();
      _builder_1.append("   ");
      _builder_1.append("Hello");
      _builder_1.newLine();
      _builder_1.append("This is super.");
      _builder_1.newLine();
      _builder_1.append("   ");
      _builder_1.append("test");
      _builder_1.newLine();
      _builder_1.append("Bla blubb");
      _builder_1.newLine();
      it.setExpectedHover(_builder_1.toString());
    };
    this.testHover(_function);
  }
  
  @Test
  public void testHover_02() {
    final Procedure1<HoverTestConfiguration> _function = (HoverTestConfiguration it) -> {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("module foo {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("description \"   Hello");
      _builder.newLine();
      _builder.append("\t        ");
      _builder.append("This is super.");
      _builder.newLine();
      _builder.append("\t                ");
      _builder.append("test");
      _builder.newLine();
      _builder.append("\t             ");
      _builder.append("Bla blubb\"");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      it.setModel(_builder.toString());
      it.setLine(0);
      it.setColumn(8);
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("[[0, 7] .. [0, 10]]");
      _builder_1.newLine();
      _builder_1.append("   ");
      _builder_1.append("Hello");
      _builder_1.newLine();
      _builder_1.append("This is super.");
      _builder_1.newLine();
      _builder_1.append("   ");
      _builder_1.append("test");
      _builder_1.newLine();
      _builder_1.append("Bla blubb");
      _builder_1.newLine();
      it.setExpectedHover(_builder_1.toString());
    };
    this.testHover(_function);
  }
}

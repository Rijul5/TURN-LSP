package io.typefox.yang.tests.symbols;

import io.typefox.yang.tests.AbstractYangLSPTest;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.testing.DefinitionTestConfiguration;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.junit.Test;

@SuppressWarnings("all")
public class DefinitionTest extends AbstractYangLSPTest {
  @Test
  public void testDefinition() {
    final Procedure1<DefinitionTestConfiguration> _function = (DefinitionTestConfiguration it) -> {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("module foo {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("typedef myType {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("type string;");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("leaf x {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("type myType;");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      it.setModel(_builder.toString());
      it.setLine(5);
      it.setColumn(7);
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("MyModel.yang [[1, 1] .. [3, 2]]");
      _builder_1.newLine();
      it.setExpectedDefinitions(_builder_1.toString());
    };
    this.testDefinition(_function);
  }
  
  @Test
  public void testDefinition_01() {
    final Procedure1<DefinitionTestConfiguration> _function = (DefinitionTestConfiguration it) -> {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("module foo {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("typedef myType {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("type string;");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("leaf x {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("type myType;");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      it.setModel(_builder.toString());
      it.setLine(5);
      it.setColumn(5);
      StringConcatenation _builder_1 = new StringConcatenation();
      it.setExpectedDefinitions(_builder_1.toString());
    };
    this.testDefinition(_function);
  }
  
  @Test
  public void testDefinition_02() {
    final Procedure1<DefinitionTestConfiguration> _function = (DefinitionTestConfiguration it) -> {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("module foo {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("typedef myType {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("type string;");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("leaf x {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("type myType;");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      it.setModel(_builder.toString());
      it.setLine(1);
      it.setColumn(10);
      StringConcatenation _builder_1 = new StringConcatenation();
      it.setExpectedDefinitions(_builder_1.toString());
    };
    this.testDefinition(_function);
  }
}

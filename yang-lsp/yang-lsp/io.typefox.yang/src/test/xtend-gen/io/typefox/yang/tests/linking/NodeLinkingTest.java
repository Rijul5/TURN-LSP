package io.typefox.yang.tests.linking;

import io.typefox.yang.tests.AbstractYangTest;
import io.typefox.yang.validation.IssueCodes;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.junit.Test;

@SuppressWarnings("all")
public class NodeLinkingTest extends AbstractYangTest {
  @Test
  public void testDuplicateNodeNames_01() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("module myModule {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("container foo {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("container foo {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    final Resource m2 = this.load(_builder);
    this.assertError(this.root(m2).getSubstatements().get(1), IssueCodes.DUPLICATE_NAME);
  }
  
  @Test
  public void testDuplicateNodeNames_02() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("module myModule {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("container foo {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("container foo {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    final Resource m2 = this.load(_builder);
    this.validator.assertNoErrors(this.root(m2), IssueCodes.DUPLICATE_NAME);
  }
  
  @Test
  public void testDuplicateNodeNames_03() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("module myModule {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("container foo {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("container bar {");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("container foo {");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    final Resource m2 = this.load(_builder);
    this.validator.assertNoErrors(this.root(m2), IssueCodes.DUPLICATE_NAME);
  }
  
  @Test
  public void testDuplicateNodeNames_04() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("module amodule {");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("namespace \"urn:test:amodule\";");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("prefix \"amodule\";");
    _builder.newLine();
    _builder.newLine();
    _builder.append("  ");
    _builder.append("organization \"organização güi\";");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("contact \"àéïç¢ô\";");
    _builder.newLine();
    _builder.newLine();
    _builder.append("  ");
    _builder.append("grouping x {");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("leaf y { type string; }");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("  ");
    _builder.append("rpc run {");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("input { uses x; }");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("output { uses x; }");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    final Resource m = this.load(_builder);
    this.validator.assertNoErrors(this.root(m), IssueCodes.DUPLICATE_NAME);
  }
}

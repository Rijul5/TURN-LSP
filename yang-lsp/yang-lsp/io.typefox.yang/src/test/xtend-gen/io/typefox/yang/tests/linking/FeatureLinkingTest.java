package io.typefox.yang.tests.linking;

import io.typefox.yang.tests.AbstractYangTest;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.junit.Test;

@SuppressWarnings("all")
public class FeatureLinkingTest extends AbstractYangTest {
  @Test
  public void testLinking() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("module u {");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("yang-version 1.1;");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("namespace urn:u;");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("prefix u;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("  ");
    _builder.append("feature foo;");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("feature bar;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("  ");
    _builder.append("container a {");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("if-feature \"foo and not bar\";");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    final Resource m = this.load(_builder);
    this.assertNoErrors(this.root(m));
  }
}

package io.typefox.yang.tests.validation;

import io.typefox.yang.tests.AbstractYangTest;
import java.util.List;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.validation.Issue;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.junit.Assert;
import org.junit.Test;

@SuppressWarnings("all")
public class DuplicateNameTest extends AbstractYangTest {
  @Test
  public void testBug75() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("module foo {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("yang-version 1.1;");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("prefix f;");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("namespace urn:foo;");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("container x {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("action a {");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("input {}");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("action b {");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("input {}");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    final Resource m = this.load(_builder);
    final List<Issue> validate = this.validator.validate(this.root(m).eResource());
    Assert.assertTrue(IterableExtensions.join(validate, "\n"), validate.isEmpty());
  }
}

package io.typefox.yang.tests.validation;

import com.google.common.collect.Iterators;
import io.typefox.yang.tests.AbstractYangTest;
import io.typefox.yang.validation.IssueCodes;
import io.typefox.yang.yang.Pattern;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.IteratorExtensions;
import org.junit.Test;

@SuppressWarnings("all")
public class RegexpTest extends AbstractYangTest {
  @Test
  public void testLegalPattern_0() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("module foo {");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("yang-version 1.1;");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("namespace urn:ietf:params:xml:ns:yang:foo;");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("prefix foo;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("    \t");
    _builder.append("typedef foo {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("type string  {");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("pattern [a-z0-9];");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    final Resource foo = this.load(_builder);
    this.validator.validate(foo);
    this.assertNoErrors(IteratorExtensions.<Pattern>head(Iterators.<Pattern>filter(foo.getAllContents(), Pattern.class)), IssueCodes.TYPE_ERROR);
  }
  
  @Test
  public void testLegalPattern_1() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("module foo {");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("yang-version 1.1;");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("namespace urn:ietf:params:xml:ns:yang:foo;");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("prefix foo;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("    \t");
    _builder.append("typedef foo {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("type string {");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("pattern [a-zA-_];");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    final Resource foo = this.load(_builder);
    this.validator.validate(foo);
    this.assertNoErrors(IteratorExtensions.<Pattern>head(Iterators.<Pattern>filter(foo.getAllContents(), Pattern.class)), IssueCodes.TYPE_ERROR);
  }
  
  @Test
  public void testIllegalPattern_0() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("module foo {");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("yang-version 1.1;");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("namespace urn:ietf:params:xml:ns:yang:foo;");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("prefix foo;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("    \t");
    _builder.append("typedef foo {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("type string  {");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("pattern [a-z-0];");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    final Resource foo = this.load(_builder);
    this.validator.validate(foo);
    this.assertError(IteratorExtensions.<Pattern>head(Iterators.<Pattern>filter(foo.getAllContents(), Pattern.class)), IssueCodes.TYPE_ERROR);
  }
  
  @Test
  public void testIllegalPattern_1() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("module foo {");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("yang-version 1.1;");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("namespace urn:ietf:params:xml:ns:yang:foo;");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("prefix foo;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("    \t");
    _builder.append("typedef foo {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("type string  {");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("pattern [a-z-_];");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    final Resource foo = this.load(_builder);
    this.validator.validate(foo);
    this.assertError(IteratorExtensions.<Pattern>head(Iterators.<Pattern>filter(foo.getAllContents(), Pattern.class)), IssueCodes.TYPE_ERROR);
  }
}

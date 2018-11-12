package io.typefox.yang.tests.validation;

import com.google.common.collect.Iterables;
import io.typefox.yang.tests.AbstractYangTest;
import io.typefox.yang.validation.IssueCodes;
import io.typefox.yang.yang.BelongsTo;
import io.typefox.yang.yang.Import;
import io.typefox.yang.yang.Include;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.junit.Test;

@SuppressWarnings("all")
public class ImportVersionConstraintTest extends AbstractYangTest {
  @Test
  public void testIncludeVersion_0() {
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
    _builder.append("    ");
    _builder.append("include bar;");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    final Resource foo = this.load(_builder);
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("submodule bar {");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("yang-version 1;");
    _builder_1.newLine();
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("belongs-to foo {");
    _builder_1.newLine();
    _builder_1.append("        ");
    _builder_1.append("prefix \'foo\';");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.newLine();
    final Resource bar = this.load(_builder_1);
    this.validator.validate(foo);
    this.assertError(IterableExtensions.<Include>head(Iterables.<Include>filter(this.root(foo).getSubstatements(), Include.class)), IssueCodes.BAD_INCLUDE_YANG_VERSION);
    this.validator.validate(bar);
    this.assertError(IterableExtensions.<BelongsTo>head(Iterables.<BelongsTo>filter(this.root(bar).getSubstatements(), BelongsTo.class)), IssueCodes.BAD_INCLUDE_YANG_VERSION);
  }
  
  @Test
  public void testIncludeVersion_1() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("module foo {");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("yang-version 1;");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("namespace urn:ietf:params:xml:ns:yang:foo;");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("prefix foo;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("    ");
    _builder.append("include bar;");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    final Resource foo = this.load(_builder);
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("submodule bar {");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("yang-version 1.1;");
    _builder_1.newLine();
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("belongs-to foo {");
    _builder_1.newLine();
    _builder_1.append("        ");
    _builder_1.append("prefix \'foo\';");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.newLine();
    final Resource bar = this.load(_builder_1);
    this.validator.validate(foo);
    this.assertError(IterableExtensions.<Include>head(Iterables.<Include>filter(this.root(foo).getSubstatements(), Include.class)), IssueCodes.BAD_INCLUDE_YANG_VERSION);
    this.validator.validate(bar);
    this.assertError(IterableExtensions.<BelongsTo>head(Iterables.<BelongsTo>filter(this.root(bar).getSubstatements(), BelongsTo.class)), IssueCodes.BAD_INCLUDE_YANG_VERSION);
  }
  
  @Test
  public void testImportVersion() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("module foo {");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("yang-version 1;");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("namespace urn:ietf:params:xml:ns:yang:foo;");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("prefix foo;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("    ");
    _builder.append("import bar {");
    _builder.newLine();
    _builder.append("    \t\t");
    _builder.append("prefix bar;");
    _builder.newLine();
    _builder.append("    \t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    final Resource foo = this.load(_builder);
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("module bar {");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("yang-version 1.1;");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("namespace urn:ietf:params:xml:ns:yang:bar;");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("prefix bar;");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    this.load(_builder_1);
    this.validator.validate(this.root(foo).eResource());
    this.assertError(IterableExtensions.<Import>head(Iterables.<Import>filter(this.root(foo).getSubstatements(), Import.class)), IssueCodes.BAD_IMPORT_YANG_VERSION);
  }
}

package io.typefox.yang.tests.linking;

import com.google.common.collect.Iterators;
import io.typefox.yang.tests.AbstractYangTest;
import io.typefox.yang.validation.IssueCodes;
import io.typefox.yang.yang.BelongsTo;
import io.typefox.yang.yang.Grouping;
import io.typefox.yang.yang.Import;
import io.typefox.yang.yang.Include;
import io.typefox.yang.yang.Revision;
import io.typefox.yang.yang.RevisionDate;
import io.typefox.yang.yang.Statement;
import io.typefox.yang.yang.Uses;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.diagnostics.Diagnostic;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.resource.IResourceDescription;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.IteratorExtensions;
import org.junit.Assert;
import org.junit.Test;

@SuppressWarnings("all")
public class ModuleLinkingTest extends AbstractYangTest {
  @Test
  public void testModuleExport() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("module ietf-foo {");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    final Resource m = this.load(_builder);
    final IResourceDescription desc = this.mnr.getResourceDescription(m);
    Assert.assertEquals("ietf-foo", IterableExtensions.<IEObjectDescription>head(desc.getExportedObjects()).getQualifiedName().toString());
  }
  
  @Test
  public void testModuleImport() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("module ietf-foo {");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    final Resource m = this.load(_builder);
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("module myModule {");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("import ietf-foo {");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    final Resource m2 = this.load(_builder_1);
    Assert.assertSame(this.root(m), IterableExtensions.head(this._yangExtensions.<Import>substatementsOfType(this.root(m2), Import.class)).getModule());
  }
  
  @Test
  public void testModuleImport_NoPefix() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("module a {");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    this.load(_builder);
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("module b {");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("import a;");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    final Resource m = this.load(_builder_1);
    this.assertError(IterableExtensions.<Statement>head(this.root(m).getSubstatements()), IssueCodes.MISSING_PREFIX);
  }
  
  @Test
  public void testModuleImportWithRevision() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("module a {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("revision 2008-01-02 { }");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("grouping a {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("leaf eh {  }");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    this.load(_builder);
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("module a {");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("revision 2008-01-01 { }");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("grouping a {");
    _builder_1.newLine();
    _builder_1.append("\t\t");
    _builder_1.append("leaf eh {  }");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    final Resource m1 = this.load(_builder_1);
    StringConcatenation _builder_2 = new StringConcatenation();
    _builder_2.append("module b {");
    _builder_2.newLine();
    _builder_2.append("\t");
    _builder_2.append("import a {");
    _builder_2.newLine();
    _builder_2.append("\t\t");
    _builder_2.append("prefix p;");
    _builder_2.newLine();
    _builder_2.append("\t\t");
    _builder_2.append("revision-date 2008-01-01;");
    _builder_2.newLine();
    _builder_2.append("\t");
    _builder_2.append("}");
    _builder_2.newLine();
    _builder_2.newLine();
    _builder_2.append("\t");
    _builder_2.append("container bee {");
    _builder_2.newLine();
    _builder_2.append("\t\t");
    _builder_2.append("uses p:a;");
    _builder_2.newLine();
    _builder_2.append("\t");
    _builder_2.append("}");
    _builder_2.newLine();
    _builder_2.append("}");
    _builder_2.newLine();
    final Resource m2 = this.load(_builder_2);
    Assert.assertSame(this.root(m1), IterableExtensions.head(this._yangExtensions.<Import>substatementsOfType(this.root(m2), Import.class)).getModule());
    final Uses uses = IteratorExtensions.<Uses>head(Iterators.<Uses>filter(this.root(m2).eAllContents(), Uses.class));
    Assert.assertSame(IterableExtensions.head(this._yangExtensions.<Grouping>substatementsOfType(this.root(m1), Grouping.class)), uses.getGrouping().getNode());
  }
  
  @Test
  public void testModuleNamespace() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("submodule asub {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("belongs-to a;");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("grouping a {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("leaf eh {  }");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    final Resource m1 = this.load(_builder);
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("module a {");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("include asub;");
    _builder_1.newLine();
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("container bee {");
    _builder_1.newLine();
    _builder_1.append("\t\t");
    _builder_1.append("uses a;");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    final Resource m2 = this.load(_builder_1);
    Assert.assertSame(this.root(m1), IterableExtensions.head(this._yangExtensions.<Include>substatementsOfType(this.root(m2), Include.class)).getModule());
    final Uses uses = IteratorExtensions.<Uses>head(Iterators.<Uses>filter(this.root(m2).eAllContents(), Uses.class));
    Assert.assertSame(IterableExtensions.head(this._yangExtensions.<Grouping>substatementsOfType(this.root(m1), Grouping.class)), uses.getGrouping().getNode());
  }
  
  @Test
  public void testImportGroupingFromSubModule() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("submodule asub {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("belongs-to a;");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("grouping a {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("leaf eh {  }");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    final Resource m1 = this.load(_builder);
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("module a {");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("include asub;");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    this.load(_builder_1);
    StringConcatenation _builder_2 = new StringConcatenation();
    _builder_2.append("module b {");
    _builder_2.newLine();
    _builder_2.append("\t");
    _builder_2.append("import a {");
    _builder_2.newLine();
    _builder_2.append("\t\t");
    _builder_2.append("prefix apref;");
    _builder_2.newLine();
    _builder_2.append("\t");
    _builder_2.append("}");
    _builder_2.newLine();
    _builder_2.append("\t");
    _builder_2.append("container bee {");
    _builder_2.newLine();
    _builder_2.append("\t\t");
    _builder_2.append("uses apref:a;");
    _builder_2.newLine();
    _builder_2.append("\t");
    _builder_2.append("}");
    _builder_2.newLine();
    _builder_2.append("}");
    _builder_2.newLine();
    final Resource m3 = this.load(_builder_2);
    final Uses uses = IteratorExtensions.<Uses>head(Iterators.<Uses>filter(this.root(m3).eAllContents(), Uses.class));
    Assert.assertSame(IterableExtensions.head(this._yangExtensions.<Grouping>substatementsOfType(this.root(m1), Grouping.class)), uses.getGrouping().getNode());
  }
  
  @Test
  public void testModuleBelongsToAnotherOne() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("module a {");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    this.load(_builder);
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("module b {");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("include c;");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    final Resource m1 = this.load(_builder_1);
    StringConcatenation _builder_2 = new StringConcatenation();
    _builder_2.append("submodule c {");
    _builder_2.newLine();
    _builder_2.append("\t");
    _builder_2.append("belongs-to a;");
    _builder_2.newLine();
    _builder_2.append("}");
    _builder_2.newLine();
    this.load(_builder_2);
    this.assertError(IterableExtensions.<Statement>head(this.root(m1).getSubstatements()), IssueCodes.INCLUDED_SUB_MODULE_BELONGS_TO_DIFFERENT_MODULE);
  }
  
  @Test
  public void testSubModuleExport() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("submodule my-submodule {");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    final Resource m = this.load(_builder);
    final IResourceDescription desc = this.mnr.getResourceDescription(m);
    Assert.assertEquals("my-submodule", IterableExtensions.<IEObjectDescription>head(desc.getExportedObjects()).getQualifiedName().toString());
  }
  
  @Test
  public void testSubModuleInclude() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("submodule sub-module {");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    final Resource m = this.load(_builder);
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("module myModule {");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("include sub-module{");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    final Resource m2 = this.load(_builder_1);
    Assert.assertSame(this.root(m), IterableExtensions.head(this._yangExtensions.<Include>substatementsOfType(this.root(m2), Include.class)).getModule());
  }
  
  @Test
  public void testSubModuleCannotbeImported() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("submodule sub-module {");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    this.load(_builder);
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("module myModule {");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("import sub-module{");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    final Resource m2 = this.load(_builder_1);
    final Import imp = IterableExtensions.head(this._yangExtensions.<Import>substatementsOfType(this.root(m2), Import.class));
    this.assertError(imp, IssueCodes.IMPORT_NOT_A_MODULE);
    Assert.assertFalse(imp.getModule().eIsProxy());
  }
  
  @Test
  public void testSubModuleBelongsTo() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("submodule sub-module {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("belongs-to myModule {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    final Resource m = this.load(_builder);
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("module myModule {");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("include sub-module{");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    final Resource m2 = this.load(_builder_1);
    Assert.assertSame(this.root(m), IterableExtensions.head(this._yangExtensions.<Include>substatementsOfType(this.root(m2), Include.class)).getModule());
    Assert.assertSame(this.root(m2), IterableExtensions.head(this._yangExtensions.<BelongsTo>substatementsOfType(this.root(m), BelongsTo.class)).getModule());
  }
  
  @Test
  public void testMultiModuleRevisions() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("module xt11 {");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("namespace \"urn:xt11\";");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("prefix \"xt11\";");
    _builder.newLine();
    _builder.newLine();
    _builder.append("  ");
    _builder.append("import xt10 {");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("prefix x1;");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("revision-date 2009-01-01;");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("  ");
    _builder.append("import xt10 {");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("prefix x2;");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("revision-date \"2009-02-01\";");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    final Resource m = this.load(_builder);
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("module xt10 {");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("revision \"2009-01-01\" {");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    final Resource m2 = this.load(_builder_1);
    StringConcatenation _builder_2 = new StringConcatenation();
    _builder_2.append("module xt10 {");
    _builder_2.newLine();
    _builder_2.append("\t");
    _builder_2.append("revision 2009-02-01 {");
    _builder_2.newLine();
    _builder_2.append("\t");
    _builder_2.append("}");
    _builder_2.newLine();
    _builder_2.append("\t");
    _builder_2.append("revision 2009-01-01 {");
    _builder_2.newLine();
    _builder_2.append("\t");
    _builder_2.append("}");
    _builder_2.newLine();
    _builder_2.append("}");
    _builder_2.newLine();
    final Resource m3 = this.load(_builder_2);
    Assert.assertSame(this.root(m2), ((Import[])Conversions.unwrapArray(this._yangExtensions.<Import>substatementsOfType(this.root(m), Import.class), Import.class))[0].getModule());
    Assert.assertSame(this.root(m3), ((Import[])Conversions.unwrapArray(this._yangExtensions.<Import>substatementsOfType(this.root(m), Import.class), Import.class))[1].getModule());
  }
  
  @Test
  public void testImportNoRevision() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("module foo {");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("namespace foo;");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("prefix foo;");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("revision 2002-02-02;");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("revision 2001-01-01;");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    final Resource foo = this.load(_builder);
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("module bar {");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("namespace bar;");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("prefix bar;");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("import foo {");
    _builder_1.newLine();
    _builder_1.append("\t\t");
    _builder_1.append("prefix foo;");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    final Resource bar = this.load(_builder_1);
    this.validator.validate(foo);
    this.assertNoErrors(this.root(foo));
    this.validator.validate(bar);
    this.assertNoErrors(this.root(bar));
  }
  
  @Test
  public void testImportMaxRevision() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("module foo {");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("namespace foo;");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("prefix foo;");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("revision 2002-02-02;");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("revision 2001-01-01;");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    final Resource foo = this.load(_builder);
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("module bar {");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("namespace bar;");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("prefix bar;");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("import foo {");
    _builder_1.newLine();
    _builder_1.append("\t\t");
    _builder_1.append("prefix foo;");
    _builder_1.newLine();
    _builder_1.append("\t\t");
    _builder_1.append("revision-date 2002-02-02;");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    final Resource bar = this.load(_builder_1);
    this.validator.validate(foo);
    this.assertNoErrors(this.root(foo));
    this.validator.validate(bar);
    this.assertNoErrors(this.root(bar));
    Assert.assertEquals(IteratorExtensions.<Revision>head(Iterators.<Revision>filter(foo.getAllContents(), Revision.class)), IteratorExtensions.<RevisionDate>head(Iterators.<RevisionDate>filter(bar.getAllContents(), RevisionDate.class)).getDate());
  }
  
  @Test
  public void testImportShadwedRevision() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("module foo {");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("namespace foo;");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("prefix foo;");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("revision 2002-02-02;");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("revision 2001-01-01;");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    final Resource foo = this.load(_builder);
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("module bar {");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("namespace bar;");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("prefix bar;");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("import foo {");
    _builder_1.newLine();
    _builder_1.append("\t\t");
    _builder_1.append("prefix foo;");
    _builder_1.newLine();
    _builder_1.append("\t\t");
    _builder_1.append("revision-date 2001-01-01;");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    final Resource bar = this.load(_builder_1);
    this.validator.validate(foo);
    this.assertNoErrors(this.root(foo));
    this.validator.validate(bar);
    this.assertError(IteratorExtensions.<RevisionDate>head(Iterators.<RevisionDate>filter(bar.getAllContents(), RevisionDate.class)), Diagnostic.LINKING_DIAGNOSTIC);
  }
  
  @Test
  public void testImportNonExistingRevision() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("module foo {");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("namespace foo;");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("prefix foo;");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("revision 2002-02-02;");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("revision 2001-01-01;");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    final Resource foo = this.load(_builder);
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("module bar {");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("namespace bar;");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("prefix bar;");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("import foo {");
    _builder_1.newLine();
    _builder_1.append("\t\t");
    _builder_1.append("prefix foo;");
    _builder_1.newLine();
    _builder_1.append("\t\t");
    _builder_1.append("revision-date 2003-03-03;");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    final Resource bar = this.load(_builder_1);
    this.validator.validate(foo);
    this.assertNoErrors(this.root(foo));
    this.validator.validate(bar);
    this.assertError(IteratorExtensions.<RevisionDate>head(Iterators.<RevisionDate>filter(bar.getAllContents(), RevisionDate.class)), Diagnostic.LINKING_DIAGNOSTIC);
    Assert.assertEquals(this.root(foo), IteratorExtensions.<Import>head(Iterators.<Import>filter(bar.getAllContents(), Import.class)).getModule());
  }
  
  @Test
  public void testDuplicateRevision() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("module foo {");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("namespace foo;");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("prefix foo;");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("revision 2002-02-02;");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("revision 2001-01-01;");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    final Resource foo = this.load(_builder);
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("module foo {");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("namespace foo;");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("prefix foo;");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("revision 2002-02-02;");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    this.load(_builder_1);
    StringConcatenation _builder_2 = new StringConcatenation();
    _builder_2.append("module bar {");
    _builder_2.newLine();
    _builder_2.append("\t");
    _builder_2.append("namespace bar;");
    _builder_2.newLine();
    _builder_2.append("\t");
    _builder_2.append("prefix bar;");
    _builder_2.newLine();
    _builder_2.append("\t");
    _builder_2.append("import foo {");
    _builder_2.newLine();
    _builder_2.append("\t\t");
    _builder_2.append("prefix foo;");
    _builder_2.newLine();
    _builder_2.append("\t\t");
    _builder_2.append("revision-date 2002-02-02;");
    _builder_2.newLine();
    _builder_2.append("    ");
    _builder_2.append("}");
    _builder_2.newLine();
    _builder_2.append("}");
    _builder_2.newLine();
    final Resource bar = this.load(_builder_2);
    this.validator.validate(foo);
    this.assertNoErrors(this.root(foo));
    this.validator.validate(bar);
    this.assertWarning(IteratorExtensions.<Import>head(Iterators.<Import>filter(bar.getAllContents(), Import.class)), IssueCodes.AMBIGUOUS_IMPORT);
    Assert.assertEquals(this.root(foo).getName(), IteratorExtensions.<Import>head(Iterators.<Import>filter(bar.getAllContents(), Import.class)).getModule().getName());
  }
}

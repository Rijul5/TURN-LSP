package io.typefox.yang.tests.xpath;

import com.google.common.collect.Iterators;
import io.typefox.yang.tests.AbstractYangTest;
import io.typefox.yang.yang.Must;
import io.typefox.yang.yang.ParentRef;
import io.typefox.yang.yang.RelativePath;
import io.typefox.yang.yang.XpathNameTest;
import io.typefox.yang.yang.XpathStep;
import io.typefox.yang.yang.YangPackage;
import java.io.File;
import java.util.List;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;
import org.eclipse.xtext.workspace.FileProjectConfig;
import org.eclipse.xtext.workspace.ProjectConfigAdapter;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.IteratorExtensions;
import org.junit.Assert;
import org.junit.Test;

@SuppressWarnings("all")
public class XpathResolverTest extends AbstractYangTest {
  /**
   * XPATH_LINKING_ERRORS are enabled for these tests
   */
  @Override
  public Resource load(final CharSequence txt) {
    final File root = new File("./src/test/java/io/typefox/yang/tests/xpath/");
    FileProjectConfig _fileProjectConfig = new FileProjectConfig(root);
    ProjectConfigAdapter.install(this.resourceSet, _fileProjectConfig);
    return super.load(txt);
  }
  
  @Test
  public void testSimple() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("module foo {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("prefix foo;");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("namespace urn:foo;");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("container a {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("must ./b/../b/c;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("container b {");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("leaf c {");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("type string;");
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
    final Resource r = this.load(_builder);
    final Must must = IteratorExtensions.<Must>head(Iterators.<Must>filter(this.root(r).eAllContents(), Must.class));
    final List<XpathNameTest> steps = IteratorExtensions.<XpathNameTest>toList(Iterators.<XpathNameTest>filter(must.eAllContents(), XpathNameTest.class));
    Assert.assertEquals(3, steps.size());
    for (final XpathNameTest e : steps) {
      {
        final List<INode> n = NodeModelUtils.findNodesForFeature(e, YangPackage.Literals.XPATH_NAME_TEST__REF);
        Assert.assertEquals(IterableExtensions.<INode>head(n).getText(), e.getRef().getName());
      }
    }
  }
  
  @Test
  public void testSibling() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("module foo {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("prefix foo;");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("namespace urn:foo;");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("list foo-bar {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("must \"../foo-bar[b = current()/preceding-sibling::foo-bar/b]\";");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("container b {");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("leaf c {");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("type string;");
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
    final Resource r = this.load(_builder);
    this.assertNoErrors(this.root(r));
  }
  
  @Test
  public void testDescendant() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("module foo {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("prefix foo;");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("namespace urn:foo;");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("container a {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("must \"//c\";");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("container b {");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("container c {");
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
    final Resource r = this.load(_builder);
    this.assertNoErrors(this.root(r));
  }
  
  @Test
  public void testGrouping() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("module foo {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("prefix foo;");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("namespace urn:foo;");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("identity MyBase {}");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("grouping ggg {");
    _builder.newLine();
    _builder.append("       ");
    _builder.append("leaf XXX { type int32; }");
    _builder.newLine();
    _builder.append("       ");
    _builder.append("container test-top {");
    _builder.newLine();
    _builder.append("         ");
    _builder.append("typedef MyType { type uint16; }");
    _builder.newLine();
    _builder.append("         ");
    _builder.append("must \"foo:bar < 42\";");
    _builder.newLine();
    _builder.newLine();
    _builder.append("         ");
    _builder.append("must \"bar = 142\";");
    _builder.newLine();
    _builder.append("         ");
    _builder.append("leaf bar { ");
    _builder.newLine();
    _builder.append("           ");
    _builder.append("type uint8;");
    _builder.newLine();
    _builder.append("           ");
    _builder.append("when \"../../foo:XXX =  11\";");
    _builder.newLine();
    _builder.append("         ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("         ");
    _builder.append("leaf baz { ");
    _builder.newLine();
    _builder.append("             ");
    _builder.append("must \"../goo = \'my-identity\'\";");
    _builder.newLine();
    _builder.append("             ");
    _builder.append("type MyType;");
    _builder.newLine();
    _builder.append("         ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("         ");
    _builder.append("leaf goo { ");
    _builder.newLine();
    _builder.append("            ");
    _builder.append("type identityref {");
    _builder.newLine();
    _builder.append("               ");
    _builder.append("base MyBase;");
    _builder.newLine();
    _builder.append("            ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("            ");
    _builder.append("default my-identity;");
    _builder.newLine();
    _builder.append("         ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("         ");
    _builder.append("leaf AA { type MyType; }");
    _builder.newLine();
    _builder.append("         ");
    _builder.append("leaf BB { type foo:MyType; }");
    _builder.newLine();
    _builder.append("      ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("   ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    final Resource r = this.load(_builder);
    this.assertNoErrors(this.root(r));
  }
  
  @Test
  public void testParents() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("module foo {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("prefix foo;");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("namespace urn:foo;");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("leaf c5-leaf {");
    _builder.newLine();
    _builder.append("      ");
    _builder.append("type string;");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("    ");
    _builder.append("list c5-list {");
    _builder.newLine();
    _builder.append("       ");
    _builder.append("key a;");
    _builder.newLine();
    _builder.append("       ");
    _builder.append("leaf a { type string; }");
    _builder.newLine();
    _builder.append("       ");
    _builder.append("leaf b { ");
    _builder.newLine();
    _builder.append("          ");
    _builder.append("type leafref { ");
    _builder.newLine();
    _builder.append("             ");
    _builder.append("path \"../../c5-leaf\"; ");
    _builder.newLine();
    _builder.append("          ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("       ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    final Resource r = this.load(_builder);
    final RelativePath parentRef = IteratorExtensions.<RelativePath>head(Iterators.<RelativePath>filter(this.root(r).eAllContents(), RelativePath.class));
    XpathStep _step = parentRef.getStep();
    Assert.assertEquals("c5-list", ((ParentRef) _step).getRef().getName());
    final XpathNameTest name = IteratorExtensions.<XpathNameTest>head(Iterators.<XpathNameTest>filter(this.root(r).eAllContents(), XpathNameTest.class));
    Assert.assertEquals("c5-leaf", name.getRef().getName());
    this.assertNoErrors(r);
  }
  
  @Test
  public void testMust() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("module foo {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("prefix foo;");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("namespace urn:foo;");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("leaf c5-leaf {");
    _builder.newLine();
    _builder.append("      ");
    _builder.append("type string;");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("container x {");
    _builder.newLine();
    _builder.append("    \t   ");
    _builder.append("must \"child::*[self::chapter or self::appendix]\" {");
    _builder.newLine();
    _builder.append("    \t      ");
    _builder.append("description \"selects the chapter and appendix children of the context node.\";");
    _builder.newLine();
    _builder.append("    \t   ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t   ");
    _builder.append("list a {");
    _builder.newLine();
    _builder.append("\t       ");
    _builder.append("leaf chapter { type string; }");
    _builder.newLine();
    _builder.append("\t   ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t   ");
    _builder.append("list b {");
    _builder.newLine();
    _builder.append("\t       ");
    _builder.append("leaf appendix { type string; }");
    _builder.newLine();
    _builder.append("\t   ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("    \t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    final Resource r = this.load(_builder);
    this.assertNoErrors(this.root(r));
  }
  
  @Test
  public void testRootRef() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("module foo {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("prefix foo;");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("namespace urn:foo;");
    _builder.newLine();
    _builder.append("    ");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("container test1 {");
    _builder.newLine();
    _builder.append("    \t   ");
    _builder.append("must \"boolean(42) + boolean(/test1) + boolean  (  \'test\'  )\";");
    _builder.newLine();
    _builder.append("\t   ");
    _builder.newLine();
    _builder.append("    \t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    final Resource r = this.load(_builder);
    this.assertNoErrors(this.root(r));
  }
}

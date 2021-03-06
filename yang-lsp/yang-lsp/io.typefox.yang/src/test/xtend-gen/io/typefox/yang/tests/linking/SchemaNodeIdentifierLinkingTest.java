package io.typefox.yang.tests.linking;

import com.google.inject.Inject;
import io.typefox.yang.scoping.ScopeContextProvider;
import io.typefox.yang.tests.AbstractYangTest;
import java.util.List;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.junit.Assert;
import org.junit.Test;

@SuppressWarnings("all")
public class SchemaNodeIdentifierLinkingTest extends AbstractYangTest {
  @Inject
  private ScopeContextProvider ctxProvider;
  
  @Test
  public void testLocalAugments() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("module foo {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("namespace \"foo:bar\";");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("prefix x;");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("grouping g2 {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("container c12 {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("uses g2 {");
    _builder.newLine();
    _builder.append("\t\t ");
    _builder.append("augment \"c12\" {");
    _builder.newLine();
    _builder.append("\t\t ");
    _builder.append("container c22 {}");
    _builder.newLine();
    _builder.append("\t\t ");
    _builder.append("leaf lm1 {");
    _builder.newLine();
    _builder.append("\t\t \t");
    _builder.append("type string;");
    _builder.newLine();
    _builder.append("\t\t \t");
    _builder.append("mandatory true;");
    _builder.newLine();
    _builder.append("\t\t \t ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t\t ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("augment \"/c12/c22\" {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("container c32 {}");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    final Resource m1 = this.load(_builder);
    final Function1<IEObjectDescription, QualifiedName> _function = (IEObjectDescription it) -> {
      return it.getName();
    };
    final Function1<QualifiedName, QualifiedName> _function_1 = (QualifiedName it) -> {
      return it;
    };
    final List<QualifiedName> elements = IterableExtensions.<QualifiedName, QualifiedName>sortBy(IterableExtensions.<QualifiedName>toList(IterableExtensions.<IEObjectDescription, QualifiedName>map(this.ctxProvider.getScopeContext(this.root(m1)).getSchemaNodeScope().getLocalOnly().getAllElements(), _function)), _function_1);
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("foo.c12");
    _builder_1.newLine();
    _builder_1.append("foo.c12.foo.c22");
    _builder_1.newLine();
    _builder_1.append("foo.c12.foo.c22.foo.c32");
    _builder_1.newLine();
    _builder_1.append("foo.c12.foo.lm1");
    Assert.assertEquals(_builder_1.toString(), IterableExtensions.join(elements, System.lineSeparator()));
    this.validator.assertNoErrors(m1);
  }
  
  @Test
  public void testMultiModuleAugments() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("module foo {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("namespace \"foo:foo\";");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("prefix x;");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("grouping g2 {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("container c12 {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("uses g2 {");
    _builder.newLine();
    _builder.append("\t\t ");
    _builder.append("augment \"c12\" {");
    _builder.newLine();
    _builder.append("\t\t ");
    _builder.append("container c22 {}");
    _builder.newLine();
    _builder.append("\t\t ");
    _builder.append("leaf lm1 {");
    _builder.newLine();
    _builder.append("\t\t \t");
    _builder.append("type string;");
    _builder.newLine();
    _builder.append("\t\t \t");
    _builder.append("mandatory true;");
    _builder.newLine();
    _builder.append("\t\t \t ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t\t ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    this.load(_builder);
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("module bar {");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("namespace \"foo:bar\";");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("prefix y;");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("import foo {");
    _builder_1.newLine();
    _builder_1.append("\t\t");
    _builder_1.append("prefix f;");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("augment \"/f:c12/f:c22\" {");
    _builder_1.newLine();
    _builder_1.append("\t\t");
    _builder_1.append("container c32 {}");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    final Resource m2 = this.load(_builder_1);
    final Function1<IEObjectDescription, QualifiedName> _function = (IEObjectDescription it) -> {
      return it.getName();
    };
    final Function1<QualifiedName, QualifiedName> _function_1 = (QualifiedName it) -> {
      return it;
    };
    final List<QualifiedName> elements = IterableExtensions.<QualifiedName, QualifiedName>sortBy(IterableExtensions.<QualifiedName>toList(IterableExtensions.<IEObjectDescription, QualifiedName>map(this.ctxProvider.getScopeContext(this.root(m2)).getSchemaNodeScope().getLocalOnly().getAllElements(), _function)), _function_1);
    StringConcatenation _builder_2 = new StringConcatenation();
    _builder_2.append("foo.c12.foo.c22.bar.c32");
    Assert.assertEquals(_builder_2.toString(), IterableExtensions.join(elements, "\n"));
    this.validator.assertNoErrors(m2);
  }
  
  @Test
  public void testImplicitCase() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("module foo {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("namespace \"foo:foo\";");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("prefix f;");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("uses baz {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("refine \"leaves\" {");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("default cz;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("refine \"leaves/cz/lupen\" {");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("min-elements 0;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("refine \"leaves/dustbin/dustbin/hoja\" {");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("description \"Refined description of hoja\";");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("} ");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("grouping baz {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("choice leaves {");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("case cz {");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("leaf-list lupen {");
    _builder.newLine();
    _builder.append("\t\t\t\t\t");
    _builder.append("description \"Base desc. of lupen\";");
    _builder.newLine();
    _builder.append("\t\t\t\t\t");
    _builder.append("type string;");
    _builder.newLine();
    _builder.append("\t\t\t\t\t");
    _builder.append("max-elements 3;");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("list dustbin {");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("key hoja;");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("leaf hoja {");
    _builder.newLine();
    _builder.append("\t\t\t\t\t");
    _builder.append("description \"Base desc. of hoja\";");
    _builder.newLine();
    _builder.append("\t\t\t\t\t");
    _builder.append("type string;");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("}");
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
    final Resource m1 = this.load(_builder);
    this.validator.assertNoErrors(this.root(m1));
  }
}

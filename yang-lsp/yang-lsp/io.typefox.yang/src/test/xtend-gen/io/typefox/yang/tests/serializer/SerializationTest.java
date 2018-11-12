package io.typefox.yang.tests.serializer;

import com.google.common.collect.Iterables;
import io.typefox.yang.tests.AbstractYangTest;
import io.typefox.yang.yang.Contact;
import io.typefox.yang.yang.Container;
import io.typefox.yang.yang.Description;
import io.typefox.yang.yang.Leaf;
import io.typefox.yang.yang.Namespace;
import io.typefox.yang.yang.Organization;
import io.typefox.yang.yang.Prefix;
import io.typefox.yang.yang.Statement;
import io.typefox.yang.yang.YangFactory;
import io.typefox.yang.yang.YangPackage;
import io.typefox.yang.yang.YangVersion;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.serializer.ISerializer;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.junit.Assert;
import org.junit.Test;

@SuppressWarnings("all")
public class SerializationTest extends AbstractYangTest {
  @Test
  public void testSerializeString() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("module foo {");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("yang-version 1.1;");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("prefix f;");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("namespace urn:foo;");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("container x {");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("action a {");
    _builder.newLine();
    _builder.append("            ");
    _builder.append("input {}");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("action b {");
    _builder.newLine();
    _builder.append("            ");
    _builder.append("input {}");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    Resource _load = this.load(_builder);
    final XtextResource resource = ((XtextResource) _load);
    final io.typefox.yang.yang.Module m = IterableExtensions.<io.typefox.yang.yang.Module>head(Iterables.<io.typefox.yang.yang.Module>filter(resource.getContents(), io.typefox.yang.yang.Module.class));
    m.setName("bar");
    Namespace _head = IterableExtensions.<Namespace>head(Iterables.<Namespace>filter(m.getSubstatements(), Namespace.class));
    _head.setUri("bar something");
    final Container s = IterableExtensions.<Container>head(Iterables.<Container>filter(m.getSubstatements(), Container.class));
    Leaf _createLeaf = YangFactory.eINSTANCE.createLeaf();
    final Procedure1<Leaf> _function = (Leaf it) -> {
      it.setName("my-leaf;TEST");
    };
    final Leaf node = ObjectExtensions.<Leaf>operator_doubleArrow(_createLeaf, _function);
    s.getSubstatements().clear();
    s.getSubstatements().add(node);
    ISerializer serializer = resource.getSerializer();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("module bar {");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("yang-version 1.1;");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("prefix f;");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("namespace \'bar something\';");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("container x {");
    _builder_1.newLine();
    _builder_1.append("        ");
    _builder_1.append("leaf \'my-leaf;TEST\';");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    Assert.assertEquals(_builder_1.toString(), serializer.serialize(IterableExtensions.<EObject>head(resource.getContents())));
  }
  
  @Test
  public void testSerializeCompletely() {
    final io.typefox.yang.yang.Module targetModule = YangFactory.eINSTANCE.createModule();
    targetModule.setName("serialize-test");
    YangVersion _create = this.<YangVersion>create(targetModule, YangPackage.Literals.YANG_VERSION, YangVersion.class);
    _create.setYangVersion("1.1");
    Namespace _create_1 = this.<Namespace>create(targetModule, YangPackage.Literals.NAMESPACE, Namespace.class);
    String _name = targetModule.getName();
    String _plus = ("urn:rdns:com:foo:" + _name);
    _create_1.setUri(_plus);
    Prefix _create_2 = this.<Prefix>create(targetModule, YangPackage.Literals.PREFIX, Prefix.class);
    _create_2.setPrefix("serialize-ann");
    Organization _create_3 = this.<Organization>create(targetModule, YangPackage.eINSTANCE.getOrganization(), Organization.class);
    _create_3.setOrganization("foo");
    Contact _create_4 = this.<Contact>create(targetModule, YangPackage.eINSTANCE.getContact(), Contact.class);
    _create_4.setContact("bar");
    Description _create_5 = this.<Description>create(targetModule, YangPackage.eINSTANCE.getDescription(), Description.class);
    _create_5.setDescription("This is a serialize test");
    Resource _createResource = this.resourceSet.createResource(URI.createFileURI("serialize-test.yang"));
    XtextResource moduleResource = ((XtextResource) _createResource);
    moduleResource.getContents().add(targetModule);
    ISerializer serializer = moduleResource.getSerializer();
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("module serialize-test {");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("yang-version 1.1;");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("namespace urn:rdns:com:foo:serialize-test;");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("prefix serialize-ann;");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("organization foo;");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("contact bar;");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("description \'This is a serialize test\';");
    _builder.newLine();
    _builder.append("}");
    Assert.assertEquals(_builder.toString(), serializer.serialize(targetModule));
  }
  
  private <T extends Object> T create(final Statement it, final EClass substmtEClass, final Class<T> clazz) {
    T _xblockexpression = null;
    {
      EObject _create = YangFactory.eINSTANCE.create(substmtEClass);
      final Statement stmt = ((Statement) _create);
      it.getSubstatements().add(stmt);
      _xblockexpression = ((T) stmt);
    }
    return _xblockexpression;
  }
}

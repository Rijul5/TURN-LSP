package io.typefox.yang.tests.serializer;

import com.google.common.collect.Iterables;
import com.google.inject.Inject;
import com.google.inject.Provider;
import io.typefox.yang.tests.YangInjectorProvider;
import io.typefox.yang.tests.serializer.FileLoader;
import io.typefox.yang.yang.AbstractModule;
import io.typefox.yang.yang.Contact;
import io.typefox.yang.yang.Container;
import io.typefox.yang.yang.Description;
import io.typefox.yang.yang.Extension;
import io.typefox.yang.yang.Import;
import io.typefox.yang.yang.Leaf;
import io.typefox.yang.yang.Namespace;
import io.typefox.yang.yang.Organization;
import io.typefox.yang.yang.Prefix;
import io.typefox.yang.yang.Statement;
import io.typefox.yang.yang.Unknown;
import io.typefox.yang.yang.YangFactory;
import io.typefox.yang.yang.YangPackage;
import io.typefox.yang.yang.YangVersion;
import java.io.File;
import java.util.Arrays;
import java.util.List;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.resource.IResourceDescription;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.resource.XtextResourceSet;
import org.eclipse.xtext.testing.InjectWith;
import org.eclipse.xtext.testing.XtextRunner;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(XtextRunner.class)
@InjectWith(YangInjectorProvider.class)
@SuppressWarnings("all")
public class ModuleSerializeTest {
  @Inject
  protected Provider<XtextResourceSet> resourceSetProvider;
  
  @Inject
  protected IResourceDescription.Manager manager;
  
  protected XtextResourceSet resourceSet;
  
  private FileLoader loader;
  
  private io.typefox.yang.yang.Module tCommon;
  
  @Before
  public void beforeTest() {
    this.resourceSet = this.resourceSetProvider.get();
    List<String> _asList = Arrays.<String>asList(new File("src/test/resources/").getAbsolutePath());
    FileLoader _fileLoader = new FileLoader(this.resourceSet, _asList, this.manager);
    this.loader = _fileLoader;
    AbstractModule _loadModuleFile = this.loadModuleFile("t-common.yang");
    this.tCommon = ((io.typefox.yang.yang.Module) _loadModuleFile);
  }
  
  @Test
  public void testTestgrp3() {
    final AbstractModule targetModule = this.loadModuleFile("testgrp3.yang");
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("module testgrp {");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("namespace \"http://netconfcentral.org/ns/testgrp\";");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("prefix \"tgrp\";");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("revision 2010-05-27 {");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("description \"Initial revision.\";");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("grouping testgrp {");
    _builder.newLine();
    _builder.append("      ");
    _builder.append("list a {");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("key g1;");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("leaf g1 { type string; }");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("leaf g2 { type string; }");
    _builder.newLine();
    _builder.append("      ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("   ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    this.assertSerialized(_builder, targetModule);
  }
  
  @Test
  public void testSerializeOriginalXPath() {
    final AbstractModule targetModule = this.loadModuleFile("xpath-serialize.yang");
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("module xpath-serialize {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("namespace xpath;");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("prefix xs;");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("yang-version 1.1;");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("import yangster-test {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("prefix ytest;");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("container cb {");
    _builder.newLine();
    _builder.append("\t    ");
    _builder.append("list lb {");
    _builder.newLine();
    _builder.append("\t        ");
    _builder.append("leaf lfb {");
    _builder.newLine();
    _builder.append("\t            ");
    _builder.append("type leafref {");
    _builder.newLine();
    _builder.append("\t                ");
    _builder.append("path \"/ytest:c1/ytest:l1\";");
    _builder.newLine();
    _builder.append("\t            ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t        ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t        ");
    _builder.append("leaf lfb2 { ");
    _builder.newLine();
    _builder.append("\t        \t");
    _builder.append("type leafref { ");
    _builder.newLine();
    _builder.append("\t        \t\t");
    _builder.append("path \"/ytest:c1\" + \"/ytest:l1\";");
    _builder.newLine();
    _builder.append("\t        \t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t        ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t        ");
    _builder.append("leaf lfb3 { ");
    _builder.newLine();
    _builder.append("\t        \t");
    _builder.append("type leafref { ");
    _builder.newLine();
    _builder.append("\t        \t\t");
    _builder.append("path \"/ytest:c1/\" + \"ytest:l1\";");
    _builder.newLine();
    _builder.append("\t        \t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t        ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t        ");
    _builder.append("leaf lfb4 { ");
    _builder.newLine();
    _builder.append("\t        \t");
    _builder.append("type leafref { ");
    _builder.newLine();
    _builder.append("\t        \t\t");
    _builder.append("path \"/ytest:\" + \"c1/ytest\" + \":l1\";");
    _builder.newLine();
    _builder.append("\t        \t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t        ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t    ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    this.assertSerialized(_builder, targetModule);
    EcoreUtil.resolveAll(targetModule);
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("module xpath-serialize {");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("namespace xpath;");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("prefix xs;");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("yang-version 1.1;");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("import yangster-test {");
    _builder_1.newLine();
    _builder_1.append("\t\t");
    _builder_1.append("prefix ytest;");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("container cb {");
    _builder_1.newLine();
    _builder_1.append("\t    ");
    _builder_1.append("list lb {");
    _builder_1.newLine();
    _builder_1.append("\t        ");
    _builder_1.append("leaf lfb {");
    _builder_1.newLine();
    _builder_1.append("\t            ");
    _builder_1.append("type leafref {");
    _builder_1.newLine();
    _builder_1.append("\t                ");
    _builder_1.append("path \"/ytest:c1/ytest:l1\";");
    _builder_1.newLine();
    _builder_1.append("\t            ");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("\t        ");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("\t        ");
    _builder_1.append("leaf lfb2 { ");
    _builder_1.newLine();
    _builder_1.append("\t        \t");
    _builder_1.append("type leafref { ");
    _builder_1.newLine();
    _builder_1.append("\t        \t\t");
    _builder_1.append("path \"/ytest:c1\" + \"/ytest:l1\";");
    _builder_1.newLine();
    _builder_1.append("\t        \t");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("\t        ");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("\t        ");
    _builder_1.append("leaf lfb3 { ");
    _builder_1.newLine();
    _builder_1.append("\t        \t");
    _builder_1.append("type leafref { ");
    _builder_1.newLine();
    _builder_1.append("\t        \t\t");
    _builder_1.append("path \"/ytest:c1/\" + \"ytest:l1\";");
    _builder_1.newLine();
    _builder_1.append("\t        \t");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("\t        ");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("\t        ");
    _builder_1.append("leaf lfb4 { ");
    _builder_1.newLine();
    _builder_1.append("\t        \t");
    _builder_1.append("type leafref { ");
    _builder_1.newLine();
    _builder_1.append("\t        \t\t");
    _builder_1.append("path \"/ytest:\" + \"c1/ytest\" + \":l1\";");
    _builder_1.newLine();
    _builder_1.append("\t        \t");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("\t        ");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("\t    ");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    this.assertSerialized(_builder_1, targetModule);
  }
  
  @Test
  public void testSerializeDeviationAction() {
    final AbstractModule targetModule = this.loadModuleFile("yangster-action-test.yang");
    Resource _eResource = targetModule.eResource();
    final XtextResource resource = ((XtextResource) _eResource);
    resource.getSerializer().serialize(targetModule);
  }
  
  @Test
  public void testSerializeNewModule() {
    final io.typefox.yang.yang.Module targetModule = YangFactory.eINSTANCE.createModule();
    targetModule.setName("serialize-test");
    YangVersion _create = this.<YangVersion>create(targetModule, YangPackage.eINSTANCE.getYangVersion(), YangVersion.class);
    _create.setYangVersion("1.1");
    Namespace _create_1 = this.<Namespace>create(targetModule, YangPackage.eINSTANCE.getNamespace(), Namespace.class);
    String _name = targetModule.getName();
    String _plus = ("urn:rdns:org:yangster:model:" + _name);
    _create_1.setUri(_plus);
    Prefix _create_2 = this.<Prefix>create(targetModule, YangPackage.eINSTANCE.getPrefix(), Prefix.class);
    _create_2.setPrefix("y");
    Organization _create_3 = this.<Organization>create(targetModule, YangPackage.eINSTANCE.getOrganization(), Organization.class);
    _create_3.setOrganization("Yangster Inc.");
    Contact _create_4 = this.<Contact>create(targetModule, YangPackage.eINSTANCE.getContact(), Contact.class);
    _create_4.setContact("yangster");
    Description _create_5 = this.<Description>create(targetModule, YangPackage.eINSTANCE.getDescription(), Description.class);
    _create_5.setDescription("This is a serialize test");
    final Import tailfImport = this.<Import>create(targetModule, YangPackage.eINSTANCE.getImport(), Import.class);
    tailfImport.setModule(this.loadModuleFile("t-common.yang"));
    Prefix _create_6 = this.<Prefix>create(tailfImport, YangPackage.eINSTANCE.getPrefix(), Prefix.class);
    _create_6.setPrefix("t");
    Resource _createResource = this.resourceSet.createResource(
      URI.createFileURI("serialize-test.yang"));
    XtextResource moduleResource = ((XtextResource) _createResource);
    moduleResource.getContents().add(targetModule);
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("module serialize-test {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("yang-version 1.1;");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("namespace urn:rdns:org:yangster:model:serialize-test;");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("prefix y;");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("organization \'Yangster Inc.\';");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("contact yangster;");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("description \'This is a serialize test\';");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("import t-common {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("prefix t;");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    this.assertSerialized(_builder, targetModule);
  }
  
  @Test
  public void testSerializeUpdatedModule() {
    final AbstractModule targetModule = this.loadModuleFile("yangster-test.yang");
    int ii = targetModule.getSubstatements().indexOf(IterableExtensions.<Import>head(Iterables.<Import>filter(targetModule.getSubstatements(), Import.class)));
    EObject _create = YangFactory.eINSTANCE.create(YangPackage.eINSTANCE.getImport());
    final Import tImport = ((Import) _create);
    tImport.setModule(this.tCommon);
    Prefix _create_1 = this.<Prefix>create(tImport, YangPackage.eINSTANCE.getPrefix(), Prefix.class);
    _create_1.setPrefix("t");
    targetModule.getSubstatements().add((ii + 1), tImport);
    final Function1<Container, Boolean> _function = (Container it) -> {
      return Boolean.valueOf(it.getName().equals("c1"));
    };
    Container c1 = IterableExtensions.<Container>head(IterableExtensions.<Container>filter(Iterables.<Container>filter(targetModule.getSubstatements(), Container.class), _function));
    c1.getSubstatements().add(this.createTailfSuppressEchoProperty());
    final Function1<Leaf, Boolean> _function_1 = (Leaf it) -> {
      return Boolean.valueOf(it.getName().equals("l1"));
    };
    Leaf l1 = IterableExtensions.<Leaf>head(IterableExtensions.<Leaf>filter(Iterables.<Leaf>filter(c1.getSubstatements(), Leaf.class), _function_1));
    l1.getSubstatements().add(this.createTailfMetaDataProperty("static-data", "true"));
    l1.getSubstatements().add(this.createTailfCallpointProperty("static-data-cb"));
    final Function1<Container, Boolean> _function_2 = (Container it) -> {
      return Boolean.valueOf(it.getName().equals("c2"));
    };
    Container c2 = IterableExtensions.<Container>head(IterableExtensions.<Container>filter(Iterables.<Container>filter(targetModule.getSubstatements(), Container.class), _function_2));
    c2.getSubstatements().add(this.createTailfCallpointProperty("is-system-created-cb"));
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("module yangster-test {");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("yang-version 1.1;");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("namespace urn:rdns:org:yangster:model:yangster-test;");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("prefix ytest;");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("import yang-dep {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("prefix ydep;");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("import t-common {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("prefix t;");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("organization \'Yangster Inc.\';");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("contact yangster;");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("description \'This is a serialize test\';");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("// TODO: This is a test");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("container c1 {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("ydep:e1;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("leaf l1 {");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("type string;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("t:meta-data static-data {");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("t:meta-value true;");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("t:callpoint static-data-cb {");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("t:set-hook node;");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("t:suppress-echo true;");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("container c2 {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("t:callpoint is-system-created-cb {");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("t:set-hook node;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    this.assertSerialized(_builder, targetModule);
  }
  
  private Unknown createTailfSuppressEchoProperty() {
    return this.createTailfWithValueProperty("suppress-echo", "true", null, null);
  }
  
  private Unknown createTailfMetaDataProperty(final String name, final String value) {
    return this.createTailfWithValueProperty("meta-data", name, "meta-value", value);
  }
  
  private Unknown createTailfCallpointProperty(final String name) {
    return this.createTailfWithValueProperty("callpoint", name, "set-hook", "node");
  }
  
  private Unknown createTailfWithValueProperty(final String n1, final String v1, final String n2, final String v2) {
    Unknown property = this.createTailfNameProperty(n1);
    if ((v2 != null)) {
      Unknown valueProperty = this.createTailfValueProperty(n2, v2);
      property.getSubstatements().add(valueProperty);
    }
    property.setName(v1);
    return property;
  }
  
  private Unknown createTailfNameProperty(final String name) {
    Unknown _xblockexpression = null;
    {
      Unknown property = YangFactory.eINSTANCE.createUnknown();
      Extension tailfExtension = this.getTailfCommonExtension(name);
      property.setExtension(tailfExtension);
      _xblockexpression = property;
    }
    return _xblockexpression;
  }
  
  private Unknown createTailfValueProperty(final String name, final String value) {
    Unknown _xblockexpression = null;
    {
      Unknown valueProperty = YangFactory.eINSTANCE.createUnknown();
      Extension tailfExtension = this.getTailfCommonExtension(name);
      valueProperty.setExtension(tailfExtension);
      valueProperty.setName(value);
      _xblockexpression = valueProperty;
    }
    return _xblockexpression;
  }
  
  private Extension getTailfCommonExtension(final String extensionName) {
    EList<Statement> _substatements = this.tCommon.getSubstatements();
    Iterable<Extension> _filter = null;
    if (_substatements!=null) {
      _filter=Iterables.<Extension>filter(_substatements, Extension.class);
    }
    Iterable<Extension> _filter_1 = null;
    if (_filter!=null) {
      final Function1<Extension, Boolean> _function = (Extension it) -> {
        return Boolean.valueOf(it.getName().equals(extensionName));
      };
      _filter_1=IterableExtensions.<Extension>filter(_filter, _function);
    }
    Extension _head = null;
    if (_filter_1!=null) {
      _head=IterableExtensions.<Extension>head(_filter_1);
    }
    return _head;
  }
  
  private AbstractModule loadModuleFile(final String moduleFileName) {
    AbstractModule _xblockexpression = null;
    {
      File moduleFile = new File(("src/test/resources/" + moduleFileName));
      _xblockexpression = this.loader.get(moduleFile);
    }
    return _xblockexpression;
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
  
  private void assertSerialized(final CharSequence expected, final AbstractModule targetModule) {
    Resource _eResource = targetModule.eResource();
    final XtextResource resource = ((XtextResource) _eResource);
    final String actual = resource.getSerializer().serialize(targetModule);
    Assert.assertEquals(expected.toString().trim().replaceAll("\\s+", " "), actual.trim().replaceAll("\\s+", " "));
  }
}

package io.typefox.yang.tests.integration;

import com.google.common.collect.Iterables;
import com.google.inject.Injector;
import io.typefox.yang.YangStandaloneSetup;
import io.typefox.yang.utils.YangStringUtils;
import io.typefox.yang.yang.UnparsedXpath;
import io.typefox.yang.yang.XpathExpression;
import io.typefox.yang.yang.YangFactory;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import java.util.function.Consumer;
import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtend.lib.annotations.FinalFieldsConstructor;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;
import org.eclipse.xtext.resource.IReferenceDescription;
import org.eclipse.xtext.resource.IResourceDescriptions;
import org.eclipse.xtext.resource.IResourceDescriptionsProvider;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.resource.XtextResourceSet;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.IteratorExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@FinalFieldsConstructor
@RunWith(Parameterized.class)
@SuppressWarnings("all")
public class SerializationIntegrationTest {
  @Parameterized.Parameters(name = "{0}")
  public static Collection<Object[]> getFiles() {
    final ArrayList<Object[]> params = CollectionLiterals.<Object[]>newArrayList();
    File _file = new File("./src/test/resources");
    final Procedure1<File> _function = (File it) -> {
      final Object[] arr = new Object[1];
      arr[0] = it;
      params.add(arr);
    };
    SerializationIntegrationTest.scanRecursively(_file, _function);
    return params;
  }
  
  private static Injector injector;
  
  private static IResourceDescriptions descriptions;
  
  @BeforeClass
  public static void beforeClass() {
    SerializationIntegrationTest.injector = new YangStandaloneSetup().createInjectorAndDoEMFRegistration();
    final XtextResourceSet rs = SerializationIntegrationTest.injector.<XtextResourceSet>getInstance(XtextResourceSet.class);
    File _file = new File("./src/test/resources");
    final Procedure1<File> _function = (File it) -> {
      rs.getResource(URI.createFileURI(it.getAbsolutePath()), true);
    };
    SerializationIntegrationTest.scanRecursively(_file, _function);
    EcoreUtil.resolveAll(rs);
    SerializationIntegrationTest.descriptions = SerializationIntegrationTest.injector.<IResourceDescriptionsProvider>getInstance(IResourceDescriptionsProvider.class).getResourceDescriptions(rs);
  }
  
  public static void scanRecursively(final File file, final Procedure1<? super File> acceptor) {
    boolean _isDirectory = file.isDirectory();
    if (_isDirectory) {
      File[] _listFiles = file.listFiles();
      for (final File f : _listFiles) {
        SerializationIntegrationTest.scanRecursively(f, acceptor);
      }
    } else {
      boolean _endsWith = file.getName().endsWith(".yang");
      if (_endsWith) {
        acceptor.apply(file);
      }
    }
  }
  
  private final File file;
  
  @Test
  public void testSerializing() {
    try {
      final XtextResource resource = this.loadResources(URI.createFileURI(this.file.getAbsolutePath()));
      this.replaceXpathExpressions(resource);
      this.removeNodeModel(resource);
      final ByteArrayOutputStream s0 = new ByteArrayOutputStream();
      resource.save(s0, null);
      s0.close();
      byte[] _byteArray = s0.toByteArray();
      String _encoding = resource.getEncoding();
      final String text0 = new String(_byteArray, _encoding);
      resource.reparse(text0);
      EcoreUtil.resolveAll(resource);
      boolean _isEmpty = resource.getErrors().isEmpty();
      boolean _not = (!_isEmpty);
      if (_not) {
        System.err.println(text0);
        final Function1<Resource.Diagnostic, String> _function = (Resource.Diagnostic it) -> {
          return it.getMessage();
        };
        Assert.fail(IterableExtensions.join(ListExtensions.<Resource.Diagnostic, String>map(resource.getErrors(), _function), "\n"));
      }
      this.replaceXpathExpressions(resource);
      this.removeNodeModel(resource);
      final ByteArrayOutputStream s1 = new ByteArrayOutputStream();
      resource.save(s1, null);
      s1.close();
      byte[] _byteArray_1 = s1.toByteArray();
      String _encoding_1 = resource.getEncoding();
      final String text1 = new String(_byteArray_1, _encoding_1);
      Assert.assertEquals(text0, text1);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  protected void removeNodeModel(final XtextResource resource) {
    final Procedure1<EObject> _function = (EObject object) -> {
      final ArrayList<Adapter> adapters = CollectionLiterals.<Adapter>newArrayList();
      final Function1<Adapter, Boolean> _function_1 = (Adapter it) -> {
        return Boolean.valueOf((it instanceof INode));
      };
      Iterable<Adapter> _filter = IterableExtensions.<Adapter>filter(object.eAdapters(), _function_1);
      Iterables.<Adapter>addAll(adapters, _filter);
      object.eAdapters().removeAll(adapters);
    };
    IteratorExtensions.<EObject>forEach(resource.getAllContents(), _function);
  }
  
  protected void replaceXpathExpressions(final XtextResource resource) {
    for (final TreeIterator<EObject> i = resource.getAllContents(); i.hasNext();) {
      {
        final EObject next = i.next();
        if ((next instanceof XpathExpression)) {
          final String text = this.fixQuotes(NodeModelUtils.getNode(next).getText().trim());
          final UnparsedXpath unparsed = YangFactory.eINSTANCE.createUnparsedXpath();
          unparsed.setText(text);
          i.prune();
          ((XpathExpression)next).eContainer().eSet(((XpathExpression)next).eContainmentFeature(), unparsed);
        }
      }
    }
  }
  
  private String fixQuotes(final String s) {
    boolean _startsWith = s.startsWith("\"");
    if (_startsWith) {
      boolean _endsWith = s.endsWith("\"");
      boolean _not = (!_endsWith);
      if (_not) {
        return (s + "\"");
      } else {
        return s;
      }
    }
    boolean _startsWith_1 = s.startsWith("\'");
    if (_startsWith_1) {
      boolean _endsWith_1 = s.endsWith("\'");
      boolean _not_1 = (!_endsWith_1);
      if (_not_1) {
        return (s + "\'");
      } else {
        return s;
      }
    }
    return YangStringUtils.addQuotesIfNecessary(s);
  }
  
  private XtextResource loadResources(final URI uri) {
    final HashSet<URI> uris = CollectionLiterals.<URI>newHashSet();
    this.addReferencedURIs(uri, uris);
    final XtextResourceSet newRs = SerializationIntegrationTest.injector.<XtextResourceSet>getInstance(XtextResourceSet.class);
    final Consumer<URI> _function = (URI it) -> {
      newRs.getResource(it, true);
    };
    uris.forEach(_function);
    EcoreUtil.resolveAll(newRs);
    Resource _resource = newRs.getResource(uri, false);
    final XtextResource xtextResource = ((XtextResource) _resource);
    boolean _isEmpty = xtextResource.getErrors().isEmpty();
    boolean _not = (!_isEmpty);
    if (_not) {
      System.err.println(xtextResource.getParseResult().getRootNode().getText());
      final Function1<Resource.Diagnostic, String> _function_1 = (Resource.Diagnostic it) -> {
        return it.getMessage();
      };
      Assert.fail(IterableExtensions.join(ListExtensions.<Resource.Diagnostic, String>map(xtextResource.getErrors(), _function_1), "\n"));
    }
    return xtextResource;
  }
  
  private void addReferencedURIs(final URI uri, final Set<URI> uris) {
    boolean _add = uris.add(uri);
    if (_add) {
      final Consumer<IReferenceDescription> _function = (IReferenceDescription it) -> {
        this.addReferencedURIs(it.getTargetEObjectUri().trimFragment(), uris);
      };
      SerializationIntegrationTest.descriptions.getResourceDescription(uri).getReferenceDescriptions().forEach(_function);
    }
  }
  
  public SerializationIntegrationTest(final File file) {
    super();
    this.file = file;
  }
}

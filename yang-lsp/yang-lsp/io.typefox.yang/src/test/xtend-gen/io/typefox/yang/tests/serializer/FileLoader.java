package io.typefox.yang.tests.serializer;

import io.typefox.yang.yang.AbstractModule;
import java.io.File;
import java.io.FileFilter;
import java.util.Collections;
import java.util.List;
import java.util.function.Consumer;
import org.eclipse.core.runtime.Assert;
import org.eclipse.emf.common.CommonPlugin;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.resource.IResourceDescription;
import org.eclipse.xtext.resource.XtextResourceSet;
import org.eclipse.xtext.resource.impl.ResourceDescriptionsData;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;

/**
 * ModuleLoader only focus on loading URI/File into ResourceSet,
 * and then return AbstractModule.
 */
@SuppressWarnings("all")
public class FileLoader {
  private XtextResourceSet xtextResourceSet;
  
  public FileLoader(final XtextResourceSet resourceSet, final List<String> moduleSearchDirs, final IResourceDescription.Manager manager) {
    Assert.isNotNull(resourceSet);
    this.xtextResourceSet = resourceSet;
    this.prepareXtextResources(moduleSearchDirs);
    this.installIndex(manager);
    EcoreUtil.resolveAll(this.xtextResourceSet);
  }
  
  public AbstractModule get(final File file) {
    final Function1<Resource, Boolean> _function = (Resource r) -> {
      boolean _xblockexpression = false;
      {
        URI rURI = r.getURI();
        boolean _isFile = rURI.isFile();
        boolean _not = (!_isFile);
        if (_not) {
          rURI = CommonPlugin.resolve(r.getURI());
        }
        _xblockexpression = file.getAbsolutePath().equals(rURI.toFileString());
      }
      return Boolean.valueOf(_xblockexpression);
    };
    Resource resource = IterableExtensions.<Resource>findFirst(this.xtextResourceSet.getResources(), _function);
    if ((resource != null)) {
      EObject _get = resource.getContents().get(0);
      return ((AbstractModule) _get);
    }
    return null;
  }
  
  private void prepareXtextResources(final List<String> moduleSearchDirs) {
    final Consumer<String> _function = (String it) -> {
      this.handleDependenciesPath(it);
    };
    moduleSearchDirs.forEach(_function);
  }
  
  private void handleDependenciesPath(final String pathString) {
    File dependenciesPathFile = new File(pathString);
    boolean _isFile = dependenciesPathFile.isFile();
    if (_isFile) {
      this.getOrCreateResource(URI.createFileURI(pathString));
    }
    boolean _isDirectory = dependenciesPathFile.isDirectory();
    if (_isDirectory) {
      this.recursivelyIntoDirectory(dependenciesPathFile);
    }
  }
  
  private void recursivelyIntoDirectory(final File dependenciesPathFile) {
    File[] yangFiles = dependenciesPathFile.listFiles(new FileFilter() {
      @Override
      public boolean accept(final File pathname) {
        return pathname.getName().endsWith(".yang");
      }
    });
    if ((yangFiles == null)) {
      return;
    }
    for (final File yangFile : yangFiles) {
      this.handleDependenciesPath(yangFile.getAbsolutePath());
    }
  }
  
  private void getOrCreateResource(final URI uri) {
    Resource targetResource = this.xtextResourceSet.getResource(uri, true);
    if ((targetResource == null)) {
      this.xtextResourceSet.createResource(uri);
    }
  }
  
  private void installIndex(final IResourceDescription.Manager manager) {
    List<IResourceDescription> _emptyList = Collections.<IResourceDescription>emptyList();
    final ResourceDescriptionsData descriptionData = new ResourceDescriptionsData(_emptyList);
    EList<Resource> _resources = this.xtextResourceSet.getResources();
    for (final Resource resource : _resources) {
      this.addDescription(descriptionData, resource, manager);
    }
    ResourceDescriptionsData.ResourceSetAdapter.installResourceDescriptionsData(this.xtextResourceSet, descriptionData);
  }
  
  private void addDescription(final ResourceDescriptionsData data, final Resource resource, final IResourceDescription.Manager manager) {
    final IResourceDescription resourceDescription = manager.getResourceDescription(resource);
    if ((resourceDescription != null)) {
      data.addDescription(resource.getURI(), resourceDescription);
    }
  }
}

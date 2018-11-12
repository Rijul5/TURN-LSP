package io.typefox.yang.scoping;

import com.google.common.collect.Iterables;
import io.typefox.yang.yang.AbstractImport;
import io.typefox.yang.yang.AbstractModule;
import io.typefox.yang.yang.YangPackage;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;
import org.eclipse.xtext.resource.IDefaultResourceDescriptionStrategy;
import org.eclipse.xtext.resource.IResourceDescription;
import org.eclipse.xtext.resource.IResourceDescriptions;
import org.eclipse.xtext.resource.impl.DefaultResourceDescription;
import org.eclipse.xtext.resource.impl.DefaultResourceDescriptionManager;
import org.eclipse.xtext.util.IResourceScopeCache;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;

@SuppressWarnings("all")
public class YangResourceDescriptionManager extends DefaultResourceDescriptionManager {
  public static class YangResourceDescription extends DefaultResourceDescription {
    private Iterable<QualifiedName> importedModules;
    
    public YangResourceDescription(final Resource resource, final IDefaultResourceDescriptionStrategy strategy, final IResourceScopeCache cache) {
      super(resource, strategy, cache);
      this.importedModules = this.computeImportedModules(resource);
    }
    
    private List<QualifiedName> computeImportedModules(final Resource resource) {
      final EObject module = IterableExtensions.<EObject>head(resource.getContents());
      if ((module instanceof AbstractModule)) {
        final ArrayList<QualifiedName> result = CollectionLiterals.<QualifiedName>newArrayList();
        Iterable<AbstractImport> _filter = Iterables.<AbstractImport>filter(((AbstractModule)module).getSubstatements(), AbstractImport.class);
        for (final AbstractImport imp : _filter) {
          {
            final Function1<INode, CharSequence> _function = (INode it) -> {
              return NodeModelUtils.getTokenText(it);
            };
            final String string = IterableExtensions.<INode>join(NodeModelUtils.findNodesForFeature(imp, YangPackage.Literals.ABSTRACT_IMPORT__MODULE), "", _function);
            result.add(QualifiedName.create(string));
          }
        }
        return result;
      } else {
        return CollectionLiterals.<QualifiedName>emptyList();
      }
    }
    
    @Override
    public Iterable<QualifiedName> getImportedNames() {
      return this.importedModules;
    }
  }
  
  @Override
  public boolean isAffected(final Collection<IResourceDescription.Delta> deltas, final IResourceDescription candidate, final IResourceDescriptions context) {
    final Set<QualifiedName> names = IterableExtensions.<QualifiedName>toSet(candidate.getImportedNames());
    for (final IResourceDescription.Delta d : deltas) {
      boolean _contains = names.contains(QualifiedName.create(d.getUri().trimFileExtension().lastSegment()));
      if (_contains) {
        return true;
      }
    }
    return false;
  }
  
  @Override
  protected IResourceDescription internalGetResourceDescription(final Resource resource, final IDefaultResourceDescriptionStrategy strategy) {
    IResourceScopeCache _cache = this.getCache();
    return new YangResourceDescriptionManager.YangResourceDescription(resource, strategy, _cache);
  }
}

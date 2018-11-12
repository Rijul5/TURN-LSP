package io.typefox.yang.findReferences;

import com.google.common.base.Objects;
import com.google.common.collect.HashMultimap;
import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.Multimap;
import com.google.inject.Inject;
import com.google.inject.Provider;
import java.util.function.Consumer;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtend.lib.annotations.FinalFieldsConstructor;
import org.eclipse.xtext.findReferences.IReferenceFinder;
import org.eclipse.xtext.resource.IReferenceDescription;
import org.eclipse.xtext.resource.IResourceDescription;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.resource.impl.ChunkedResourceDescriptions;
import org.eclipse.xtext.util.CancelIndicator;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.Pair;
import org.eclipse.xtext.xbase.lib.Pure;

@SuppressWarnings("all")
public class YangReferenceFinder {
  @FinalFieldsConstructor
  public static class YangReferenceAcceptor implements IReferenceFinder.Acceptor {
    private final URI uri;
    
    @Accessors
    private final Multimap<URI, Pair<URI, EReference>> references = HashMultimap.<URI, Pair<URI, EReference>>create();
    
    @Override
    public void accept(final IReferenceDescription description) {
      URI _trimFragment = description.getTargetEObjectUri().trimFragment();
      boolean _equals = Objects.equal(_trimFragment, this.uri);
      if (_equals) {
        URI _targetEObjectUri = description.getTargetEObjectUri();
        URI _sourceEObjectUri = description.getSourceEObjectUri();
        EReference _eReference = description.getEReference();
        Pair<URI, EReference> _mappedTo = Pair.<URI, EReference>of(_sourceEObjectUri, _eReference);
        this.references.put(_targetEObjectUri, _mappedTo);
      }
    }
    
    @Override
    public void accept(final EObject source, final URI sourceURI, final EReference eReference, final int index, final EObject targetOrProxy, final URI targetURI) {
      URI _trimFragment = targetURI.trimFragment();
      boolean _equals = Objects.equal(_trimFragment, this.uri);
      if (_equals) {
        Pair<URI, EReference> _mappedTo = Pair.<URI, EReference>of(sourceURI, eReference);
        this.references.put(targetURI, _mappedTo);
      }
    }
    
    public YangReferenceAcceptor(final URI uri) {
      super();
      this.uri = uri;
    }
    
    @Pure
    public Multimap<URI, Pair<URI, EReference>> getReferences() {
      return this.references;
    }
  }
  
  private static final String REFERENCES_KEY = "statement-references";
  
  @Inject
  private IReferenceFinder referenceFinder;
  
  public Multimap<URI, Pair<URI, EReference>> collectReferences(final Resource resource) {
    return this.collectReferences(resource, CancelIndicator.NullImpl);
  }
  
  public Multimap<URI, Pair<URI, EReference>> collectReferences(final Resource resource, final CancelIndicator indicator) {
    final Provider<Multimap<URI, Pair<URI, EReference>>> _function = () -> {
      URI _uRI = resource.getURI();
      final YangReferenceFinder.YangReferenceAcceptor acceptor = new YangReferenceFinder.YangReferenceAcceptor(_uRI);
      this.referenceFinder.findAllReferences(resource, acceptor, new NullProgressMonitor() {
        @Override
        public boolean isCanceled() {
          return indicator.isCanceled();
        }
      });
      final ChunkedResourceDescriptions index = ChunkedResourceDescriptions.findInEmfObject(resource.getResourceSet());
      if ((index != null)) {
        final Function1<IResourceDescription, Iterable<IReferenceDescription>> _function_1 = (IResourceDescription it) -> {
          return it.getReferenceDescriptions();
        };
        final Consumer<Iterable<IReferenceDescription>> _function_2 = (Iterable<IReferenceDescription> it) -> {
          final Consumer<IReferenceDescription> _function_3 = (IReferenceDescription it_1) -> {
            acceptor.accept(it_1);
          };
          it.forEach(_function_3);
        };
        IterableExtensions.<IResourceDescription, Iterable<IReferenceDescription>>map(index.getAllResourceDescriptions(), _function_1).forEach(_function_2);
      }
      return ImmutableMultimap.<URI, Pair<URI, EReference>>copyOf(acceptor.references);
    };
    final Provider<Multimap<URI, Pair<URI, EReference>>> provider = _function;
    if ((resource instanceof XtextResource)) {
      return ((XtextResource)resource).getCache().<Multimap<URI, Pair<URI, EReference>>>get(YangReferenceFinder.REFERENCES_KEY, resource, provider);
    } else {
      return provider.get();
    }
  }
}

package io.typefox.yang.resource;

import com.google.common.base.Objects;
import com.google.inject.Inject;
import io.typefox.yang.scoping.IScopeContext;
import io.typefox.yang.scoping.ScopeContextProvider;
import io.typefox.yang.yang.AbstractModule;
import io.typefox.yang.yang.YangPackage;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.xtext.linking.lazy.LazyLinkingResource;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.util.Triple;
import org.eclipse.xtext.xbase.lib.IterableExtensions;

@SuppressWarnings("all")
public class YangResource extends LazyLinkingResource {
  @Inject
  private ScopeContextProvider provider;
  
  @Override
  protected EObject getEObject(final String uriFragment, final Triple<EObject, EReference, INode> triple) throws AssertionError {
    EObject _xblockexpression = null;
    {
      EObject _head = IterableExtensions.<EObject>head(this.contents);
      final IScopeContext ctx = this.provider.getScopeContext(((AbstractModule) _head));
      EClass _eReferenceType = triple.getSecond().getEReferenceType();
      boolean _matched = false;
      if (Objects.equal(_eReferenceType, YangPackage.Literals.SCHEMA_NODE)) {
        _matched=true;
      }
      if (!_matched) {
        if (Objects.equal(_eReferenceType, YangPackage.Literals.LEAF)) {
          _matched=true;
        }
      }
      if (_matched) {
        ctx.resolveAll();
      }
      if (!_matched) {
        ctx.resolveDefinitionPhase();
      }
      final Object result = triple.getFirst().eGet(triple.getSecond(), false);
      if (((result instanceof EObject) && (!((EObject) result).eIsProxy()))) {
        return ((EObject) result);
      }
      _xblockexpression = super.getEObject(uriFragment, triple);
    }
    return _xblockexpression;
  }
}

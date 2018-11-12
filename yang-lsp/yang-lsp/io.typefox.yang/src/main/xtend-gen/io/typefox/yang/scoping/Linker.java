package io.typefox.yang.scoping;

import com.google.common.base.Objects;
import com.google.inject.Inject;
import io.typefox.yang.validation.LinkingErrorMessageProvider;
import io.typefox.yang.yang.impl.XpathNameTestImpl;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.linking.impl.LinkingHelper;
import org.eclipse.xtext.linking.lazy.LazyURIEncoder;
import org.eclipse.xtext.naming.IQualifiedNameConverter;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.nodemodel.ILeafNode;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;
import org.eclipse.xtext.resource.EObjectDescription;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;

@SuppressWarnings("all")
public class Linker {
  @Inject
  private LinkingHelper linkingHelper;
  
  @Inject
  private LazyURIEncoder lazyURIEncoder;
  
  @Inject
  private IQualifiedNameConverter qualifiedNameConverter;
  
  public static IEObjectDescription ROOT = new EObjectDescription(QualifiedName.EMPTY, null, null);
  
  public <T extends Object> T link(final EObject element, final EReference reference, final Function1<? super QualifiedName, ? extends IEObjectDescription> resolver) {
    Object _eGet = element.eGet(reference, false);
    final EObject proxy = ((EObject) _eGet);
    if (((proxy != null) && ((!proxy.eIsProxy()) || LinkingErrorMessageProvider.isOK(proxy)))) {
      return ((T) proxy);
    }
    final QualifiedName qname = this.getLinkingName(element, reference);
    if ((qname != null)) {
      final IEObjectDescription candidate = resolver.apply(qname);
      if ((candidate == Linker.ROOT)) {
        LinkingErrorMessageProvider.markOK(element);
      } else {
        if ((candidate != null)) {
          final EObject resolved = EcoreUtil.resolve(candidate.getEObjectOrProxy(), element);
          element.eSet(reference, resolved);
          return ((T) resolved);
        }
      }
    }
    Object _eGet_1 = element.eGet(reference, false);
    return ((T) ((InternalEObject) _eGet_1));
  }
  
  public QualifiedName getLinkingName(final EObject element, final EReference reference) {
    Object _eGet = element.eGet(reference, false);
    final InternalEObject proxy = ((InternalEObject) _eGet);
    if ((proxy != null)) {
      boolean _eIsProxy = proxy.eIsProxy();
      if (_eIsProxy) {
        final URI uri = proxy.eProxyURI();
        if ((Objects.equal(uri.trimFragment(), element.eResource().getURI()) && 
          this.lazyURIEncoder.isCrossLinkFragment(element.eResource(), uri.fragment()))) {
          final INode node = this.lazyURIEncoder.getNode(element, uri.fragment());
          final String symbol = this.linkingHelper.getCrossRefNodeAsString(node, true);
          final QualifiedName simpleName = this.qualifiedNameConverter.toQualifiedName(symbol);
          if ((element instanceof XpathNameTestImpl)) {
            String _prefix = ((XpathNameTestImpl)element).getPrefix();
            boolean _tripleNotEquals = (_prefix != null);
            if (_tripleNotEquals) {
              return this.qualifiedNameConverter.toQualifiedName(((XpathNameTestImpl)element).getPrefix()).append(simpleName);
            }
          }
          return simpleName;
        } else {
          element.eGet(reference, true);
        }
      } else {
        final Function1<INode, String> _function = (INode it) -> {
          final Function1<ILeafNode, Boolean> _function_1 = (ILeafNode it_1) -> {
            boolean _isHidden = it_1.isHidden();
            return Boolean.valueOf((!_isHidden));
          };
          final Function1<ILeafNode, String> _function_2 = (ILeafNode it_1) -> {
            return it_1.getText();
          };
          return IterableExtensions.join(IterableExtensions.<ILeafNode, String>map(IterableExtensions.<ILeafNode>filter(it.getLeafNodes(), _function_1), _function_2), "");
        };
        final String symbol_1 = IterableExtensions.join(ListExtensions.<INode, String>map(NodeModelUtils.findNodesForFeature(element, reference), _function), "");
        boolean _isEmpty = symbol_1.isEmpty();
        boolean _not = (!_isEmpty);
        if (_not) {
          return this.qualifiedNameConverter.toQualifiedName(symbol_1);
        }
      }
    }
    return null;
  }
}

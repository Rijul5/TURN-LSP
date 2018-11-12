package io.typefox.yang.scoping;

import com.google.common.base.Objects;
import io.typefox.yang.yang.YangPackage;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.resource.ISelectable;
import org.eclipse.xtext.scoping.IScope;
import org.eclipse.xtext.scoping.impl.SelectableBasedScope;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;

@SuppressWarnings("all")
public class YangModuleScope extends SelectableBasedScope {
  protected YangModuleScope(final IScope outer, final ISelectable selectable) {
    super(outer, selectable, null, YangPackage.Literals.ABSTRACT_MODULE, false);
  }
  
  @Override
  protected Iterable<IEObjectDescription> getLocalElementsByEObject(final EObject object, final URI uri) {
    final Function1<IEObjectDescription, Boolean> _function = (IEObjectDescription input) -> {
      return Boolean.valueOf(((input.getEObjectOrProxy() == object) || Objects.equal(uri, input.getEObjectURI())));
    };
    return IterableExtensions.<IEObjectDescription>filter(this.getAllLocalElements(), _function);
  }
}

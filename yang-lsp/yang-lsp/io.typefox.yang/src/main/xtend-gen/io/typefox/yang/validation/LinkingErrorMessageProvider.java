package io.typefox.yang.validation;

import com.google.inject.Inject;
import io.typefox.yang.validation.IssueCodes;
import io.typefox.yang.yang.CurrentRef;
import io.typefox.yang.yang.ParentRef;
import io.typefox.yang.yang.XpathNameTest;
import java.util.List;
import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.diagnostics.DiagnosticMessage;
import org.eclipse.xtext.diagnostics.Severity;
import org.eclipse.xtext.linking.ILinkingDiagnosticMessageProvider;
import org.eclipse.xtext.linking.impl.LinkingDiagnosticMessageProvider;
import org.eclipse.xtext.util.internal.EmfAdaptable;
import org.eclipse.xtext.validation.IssueSeverities;
import org.eclipse.xtext.validation.IssueSeveritiesProvider;

@SuppressWarnings("all")
public class LinkingErrorMessageProvider extends LinkingDiagnosticMessageProvider {
  @EmfAdaptable
  public static class ItsOK {
    public static class ItsOKAdapter extends AdapterImpl {
      private LinkingErrorMessageProvider.ItsOK element;
      
      public ItsOKAdapter(final LinkingErrorMessageProvider.ItsOK element) {
        this.element = element;
      }
      
      public LinkingErrorMessageProvider.ItsOK get() {
        return this.element;
      }
      
      @Override
      public boolean isAdapterForType(final Object object) {
        return object == LinkingErrorMessageProvider.ItsOK.class;
      }
    }
    
    public static LinkingErrorMessageProvider.ItsOK findInEmfObject(final Notifier emfObject) {
      for (Adapter adapter : emfObject.eAdapters()) {
      	if (adapter instanceof LinkingErrorMessageProvider.ItsOK.ItsOKAdapter) {
      		return ((LinkingErrorMessageProvider.ItsOK.ItsOKAdapter) adapter).get();
      	}
      }
      return null;
    }
    
    public static LinkingErrorMessageProvider.ItsOK removeFromEmfObject(final Notifier emfObject) {
      List<Adapter> adapters = emfObject.eAdapters();
      for(int i = 0, max = adapters.size(); i < max; i++) {
      	Adapter adapter = adapters.get(i);
      	if (adapter instanceof LinkingErrorMessageProvider.ItsOK.ItsOKAdapter) {
      		emfObject.eAdapters().remove(i);
      		return ((LinkingErrorMessageProvider.ItsOK.ItsOKAdapter) adapter).get();
      	}
      }
      return null;
    }
    
    public void attachToEmfObject(final Notifier emfObject) {
      ItsOK result = findInEmfObject(emfObject);
      if (result != null)
      	throw new IllegalStateException("The given EMF object already contains an adapter for ItsOK");
      LinkingErrorMessageProvider.ItsOK.ItsOKAdapter adapter = new LinkingErrorMessageProvider.ItsOK.ItsOKAdapter(this);
      emfObject.eAdapters().add(adapter);
    }
  }
  
  public static void markOK(final EObject obj) {
    LinkingErrorMessageProvider.ItsOK _findInEmfObject = LinkingErrorMessageProvider.ItsOK.findInEmfObject(obj);
    boolean _tripleEquals = (_findInEmfObject == null);
    if (_tripleEquals) {
      new LinkingErrorMessageProvider.ItsOK().attachToEmfObject(obj);
    }
  }
  
  public static boolean isOK(final EObject obj) {
    LinkingErrorMessageProvider.ItsOK _findInEmfObject = LinkingErrorMessageProvider.ItsOK.findInEmfObject(obj);
    return (_findInEmfObject != null);
  }
  
  @Inject
  private IssueSeveritiesProvider severitiesProvider;
  
  @Override
  public DiagnosticMessage getUnresolvedProxyMessage(final ILinkingDiagnosticMessageProvider.ILinkingDiagnosticContext context) {
    DiagnosticMessage _xblockexpression = null;
    {
      boolean _isOK = LinkingErrorMessageProvider.isOK(context.getContext());
      if (_isOK) {
        return null;
      }
      if ((((context.getContext() instanceof XpathNameTest) || (context.getContext() instanceof CurrentRef)) || (context.getContext() instanceof ParentRef))) {
        final IssueSeverities severities = this.severitiesProvider.getIssueSeverities(context.getContext().eResource());
        final Severity severity = severities.getSeverity(IssueCodes.XPATH_LINK_ERROR);
        if (((severity == Severity.ERROR) || (severity == Severity.WARNING))) {
          String _linkText = context.getLinkText();
          String _plus = ("Couldn\'t resolve reference to data node \'" + _linkText);
          final String msg = (_plus + "\'.");
          Severity _severity = severities.getSeverity(IssueCodes.XPATH_LINK_ERROR);
          return new DiagnosticMessage(msg, _severity, IssueCodes.XPATH_LINK_ERROR);
        }
        return null;
      }
      _xblockexpression = super.getUnresolvedProxyMessage(context);
    }
    return _xblockexpression;
  }
}

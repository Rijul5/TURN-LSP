package io.typefox.yang.resource;

import com.google.inject.Inject;
import io.typefox.yang.scoping.ScopeContextProvider;
import java.io.IOException;
import java.io.Writer;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.resource.SaveOptions;
import org.eclipse.xtext.serializer.impl.Serializer;
import org.eclipse.xtext.util.ReplaceRegion;

@SuppressWarnings("all")
public class YangSerializer extends Serializer {
  @Inject
  private ScopeContextProvider scopeContextProvider;
  
  @Override
  public String serialize(final EObject obj) {
    String _xblockexpression = null;
    {
      this.scopeContextProvider.removeScopeContexts(obj.eResource());
      EcoreUtil.resolveAll(obj.eResource());
      _xblockexpression = super.serialize(obj);
    }
    return _xblockexpression;
  }
  
  @Override
  public String serialize(final EObject obj, final SaveOptions options) {
    String _xblockexpression = null;
    {
      this.scopeContextProvider.removeScopeContexts(obj.eResource());
      EcoreUtil.resolveAll(obj.eResource());
      _xblockexpression = super.serialize(obj, options);
    }
    return _xblockexpression;
  }
  
  @Override
  public void serialize(final EObject obj, final Writer writer, final SaveOptions options) throws IOException {
    this.scopeContextProvider.removeScopeContexts(obj.eResource());
    EcoreUtil.resolveAll(obj.eResource());
    super.serialize(obj, writer, options);
  }
  
  @Override
  public ReplaceRegion serializeReplacement(final EObject obj, final SaveOptions options) {
    ReplaceRegion _xblockexpression = null;
    {
      this.scopeContextProvider.removeScopeContexts(obj.eResource());
      EcoreUtil.resolveAll(obj.eResource());
      _xblockexpression = super.serializeReplacement(obj, options);
    }
    return _xblockexpression;
  }
}

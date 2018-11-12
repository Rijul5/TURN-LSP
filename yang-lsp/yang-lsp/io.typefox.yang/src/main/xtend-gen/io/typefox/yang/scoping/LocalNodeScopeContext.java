package io.typefox.yang.scoping;

import com.google.inject.Provider;
import io.typefox.yang.scoping.IScopeContext;
import io.typefox.yang.scoping.LocalScopeContext;
import io.typefox.yang.scoping.ScopeContext;
import org.eclipse.xtext.scoping.IScope;

@SuppressWarnings("all")
public class LocalNodeScopeContext extends LocalScopeContext {
  public LocalNodeScopeContext(final IScopeContext parent) {
    super(parent);
  }
  
  private ScopeContext.MapScope schemaNodeScope;
  
  @Override
  public ScopeContext.MapScope getSchemaNodeScope() {
    if ((this.schemaNodeScope == null)) {
      final Provider<IScope> _function = () -> {
        return this.getParent().getSchemaNodeScope();
      };
      final ScopeContext.LazyScope lazyParent = new ScopeContext.LazyScope(_function);
      this.schemaNodeScope = new ScopeContext.MapScope(lazyParent) {
        @Override
        public boolean allowShadowParent() {
          return true;
        }
      };
      lazyParent.getScope();
    }
    return this.schemaNodeScope;
  }
}

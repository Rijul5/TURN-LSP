package io.typefox.yang.scoping;

import com.google.inject.Provider;
import io.typefox.yang.scoping.IScopeContext;
import io.typefox.yang.scoping.ScopeContext;
import java.util.Map;
import java.util.Set;
import org.eclipse.xtend.lib.annotations.AccessorType;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtend.lib.annotations.Delegate;
import org.eclipse.xtend.lib.annotations.FinalFieldsConstructor;
import org.eclipse.xtext.scoping.IScope;
import org.eclipse.xtext.xbase.lib.Pure;

@FinalFieldsConstructor
@Accessors(AccessorType.PUBLIC_GETTER)
@SuppressWarnings("all")
public class LocalScopeContext implements IScopeContext {
  @Delegate
  private final IScopeContext parent;
  
  private ScopeContext.MapScope groupingScope = new ScopeContext.MapScope(new ScopeContext.LazyScope(((Provider<IScope>) () -> {
    return this.getParent().getGroupingScope();
  })));
  
  private ScopeContext.MapScope typeScope = new ScopeContext.MapScope(new ScopeContext.LazyScope(((Provider<IScope>) () -> {
    return this.getParent().getTypeScope();
  })));
  
  @Override
  public ScopeContext.MapScope getGroupingScope() {
    return this.groupingScope;
  }
  
  @Override
  public ScopeContext.MapScope getTypeScope() {
    return this.typeScope;
  }
  
  public IScope getModuleScope() {
    return this.parent.getModuleScope();
  }
  
  public String getLocalPrefix() {
    return this.parent.getLocalPrefix();
  }
  
  public String getModuleName() {
    return this.parent.getModuleName();
  }
  
  public Map<String, IScopeContext> getImportedModules() {
    return this.parent.getImportedModules();
  }
  
  public Set<IScopeContext> getModuleBelongingSubModules() {
    return this.parent.getModuleBelongingSubModules();
  }
  
  public ScopeContext.MapScope getIdentityScope() {
    return this.parent.getIdentityScope();
  }
  
  public ScopeContext.MapScope getFeatureScope() {
    return this.parent.getFeatureScope();
  }
  
  public ScopeContext.MapScope getExtensionScope() {
    return this.parent.getExtensionScope();
  }
  
  public ScopeContext.MapScope getSchemaNodeScope() {
    return this.parent.getSchemaNodeScope();
  }
  
  public void onResolveDefinitions(final Runnable callback) {
    this.parent.onResolveDefinitions(callback);
  }
  
  public void onComputeNodeScope(final Runnable callback) {
    this.parent.onComputeNodeScope(callback);
  }
  
  public void runAfterAll(final Runnable callback) {
    this.parent.runAfterAll(callback);
  }
  
  public void resolveDefinitionPhase() {
    this.parent.resolveDefinitionPhase();
  }
  
  public void resolveAll() {
    this.parent.resolveAll();
  }
  
  public LocalScopeContext(final IScopeContext parent) {
    super();
    this.parent = parent;
  }
  
  @Pure
  public IScopeContext getParent() {
    return this.parent;
  }
}

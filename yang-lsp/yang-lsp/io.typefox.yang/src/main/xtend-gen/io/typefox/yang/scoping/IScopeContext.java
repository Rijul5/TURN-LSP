package io.typefox.yang.scoping;

import io.typefox.yang.scoping.ScopeContext;
import java.util.Map;
import java.util.Set;
import org.eclipse.xtext.scoping.IScope;

@SuppressWarnings("all")
public interface IScopeContext {
  public abstract IScope getModuleScope();
  
  public abstract String getLocalPrefix();
  
  public abstract String getModuleName();
  
  public abstract Map<String, IScopeContext> getImportedModules();
  
  public abstract Set<IScopeContext> getModuleBelongingSubModules();
  
  public abstract ScopeContext.MapScope getGroupingScope();
  
  public abstract ScopeContext.MapScope getTypeScope();
  
  public abstract ScopeContext.MapScope getIdentityScope();
  
  public abstract ScopeContext.MapScope getFeatureScope();
  
  public abstract ScopeContext.MapScope getExtensionScope();
  
  public abstract ScopeContext.MapScope getSchemaNodeScope();
  
  public abstract void onResolveDefinitions(final Runnable callback);
  
  public abstract void onComputeNodeScope(final Runnable callback);
  
  public abstract void runAfterAll(final Runnable callback);
  
  public abstract void resolveDefinitionPhase();
  
  public abstract void resolveAll();
}

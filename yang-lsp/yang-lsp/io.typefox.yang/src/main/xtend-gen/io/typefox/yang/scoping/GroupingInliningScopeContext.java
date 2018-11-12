package io.typefox.yang.scoping;

import io.typefox.yang.scoping.IScopeContext;
import io.typefox.yang.scoping.ScopeContext;
import java.util.Map;
import java.util.Set;
import org.eclipse.xtend.lib.annotations.Data;
import org.eclipse.xtend.lib.annotations.Delegate;
import org.eclipse.xtext.scoping.IScope;
import org.eclipse.xtext.xbase.lib.Pure;
import org.eclipse.xtext.xbase.lib.util.ToStringBuilder;

/**
 * this context is used when a 'uses' statement is resolved and the schema nodes from the referenced grouping are inlined.
 */
@Data
@SuppressWarnings("all")
public class GroupingInliningScopeContext implements IScopeContext {
  @Delegate
  private final IScopeContext original;
  
  @Override
  public void onResolveDefinitions(final Runnable runnable) {
  }
  
  @Override
  public ScopeContext.MapScope getGroupingScope() {
    return new ScopeContext.MapScope();
  }
  
  @Override
  public ScopeContext.MapScope getTypeScope() {
    return new ScopeContext.MapScope();
  }
  
  @Override
  public ScopeContext.MapScope getIdentityScope() {
    return new ScopeContext.MapScope();
  }
  
  @Override
  public ScopeContext.MapScope getFeatureScope() {
    return new ScopeContext.MapScope();
  }
  
  @Override
  public ScopeContext.MapScope getExtensionScope() {
    return new ScopeContext.MapScope();
  }
  
  public GroupingInliningScopeContext(final IScopeContext original) {
    super();
    this.original = original;
  }
  
  @Override
  @Pure
  public int hashCode() {
    return 31 * 1 + ((this.original== null) ? 0 : this.original.hashCode());
  }
  
  @Override
  @Pure
  public boolean equals(final Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    GroupingInliningScopeContext other = (GroupingInliningScopeContext) obj;
    if (this.original == null) {
      if (other.original != null)
        return false;
    } else if (!this.original.equals(other.original))
      return false;
    return true;
  }
  
  @Override
  @Pure
  public String toString() {
    ToStringBuilder b = new ToStringBuilder(this);
    b.add("original", this.original);
    return b.toString();
  }
  
  @Pure
  public IScopeContext getOriginal() {
    return this.original;
  }
  
  public IScope getModuleScope() {
    return this.original.getModuleScope();
  }
  
  public String getLocalPrefix() {
    return this.original.getLocalPrefix();
  }
  
  public String getModuleName() {
    return this.original.getModuleName();
  }
  
  public Map<String, IScopeContext> getImportedModules() {
    return this.original.getImportedModules();
  }
  
  public Set<IScopeContext> getModuleBelongingSubModules() {
    return this.original.getModuleBelongingSubModules();
  }
  
  public ScopeContext.MapScope getSchemaNodeScope() {
    return this.original.getSchemaNodeScope();
  }
  
  public void onComputeNodeScope(final Runnable callback) {
    this.original.onComputeNodeScope(callback);
  }
  
  public void runAfterAll(final Runnable callback) {
    this.original.runAfterAll(callback);
  }
  
  public void resolveDefinitionPhase() {
    this.original.resolveDefinitionPhase();
  }
  
  public void resolveAll() {
    this.original.resolveAll();
  }
}

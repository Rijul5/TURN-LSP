package io.typefox.yang.scoping;

import com.google.common.collect.Iterables;
import com.google.inject.Provider;
import io.typefox.yang.scoping.IScopeContext;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Consumer;
import org.apache.log4j.Logger;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtend.lib.annotations.AccessorType;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtend.lib.annotations.Data;
import org.eclipse.xtend.lib.annotations.Delegate;
import org.eclipse.xtend.lib.annotations.FinalFieldsConstructor;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.resource.EObjectDescription;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.resource.impl.AliasedEObjectDescription;
import org.eclipse.xtext.scoping.IScope;
import org.eclipse.xtext.scoping.impl.MapBasedScope;
import org.eclipse.xtext.util.internal.Log;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.Pure;
import org.eclipse.xtext.xbase.lib.util.ToStringBuilder;

@Log
@SuppressWarnings("all")
public class ScopeContext implements IScopeContext {
  public static class MapScope extends MapBasedScope {
    private Map<QualifiedName, IEObjectDescription> elements = CollectionLiterals.<QualifiedName, IEObjectDescription>newHashMap();
    
    public MapScope() {
      this(IScope.NULLSCOPE);
    }
    
    public MapScope(final IScope parent) {
      this(parent, CollectionLiterals.<QualifiedName, IEObjectDescription>newHashMap());
    }
    
    public MapScope(final IScope parent, final Map<QualifiedName, IEObjectDescription> elements) {
      super(parent, elements, false);
      this.elements = elements;
    }
    
    /**
     * @return true, if the element could be added
     */
    public boolean tryAddLocal(final QualifiedName name, final EObject element) {
      return this.tryAddLocal(name, element, CollectionLiterals.<String, String>emptyMap());
    }
    
    public boolean tryAddLocal(final QualifiedName name, final EObject element, final Map<String, String> userData) {
      final EObjectDescription description = new EObjectDescription(name, element, userData);
      final IEObjectDescription existingLocal = this.elements.put(name, description);
      if ((existingLocal != null)) {
        this.elements.put(name, existingLocal);
        return false;
      }
      final IEObjectDescription existing = this.getParent().getSingleElement(name);
      if (((existing != null) && (!this.allowShadowParent()))) {
        return false;
      } else {
        return true;
      }
    }
    
    public boolean allowShadowParent() {
      return false;
    }
    
    public IScope getLocalOnly() {
      return new ScopeContext.MapScope(IScope.NULLSCOPE, this.elements);
    }
  }
  
  @Data
  public static class CompositeScope implements IScope {
    private final Iterable<? extends IScope> scopes;
    
    @Override
    public Iterable<IEObjectDescription> getAllElements() {
      final Function1<IScope, Iterable<IEObjectDescription>> _function = (IScope it) -> {
        return it.getAllElements();
      };
      return Iterables.<IEObjectDescription>concat(IterableExtensions.map(this.scopes, _function));
    }
    
    @Override
    public Iterable<IEObjectDescription> getElements(final QualifiedName name) {
      final Function1<IScope, Iterable<IEObjectDescription>> _function = (IScope it) -> {
        return it.getElements(name);
      };
      return Iterables.<IEObjectDescription>concat(IterableExtensions.map(this.scopes, _function));
    }
    
    @Override
    public Iterable<IEObjectDescription> getElements(final EObject object) {
      final Function1<IScope, Iterable<IEObjectDescription>> _function = (IScope it) -> {
        return it.getElements(object);
      };
      return Iterables.<IEObjectDescription>concat(IterableExtensions.map(this.scopes, _function));
    }
    
    @Override
    public IEObjectDescription getSingleElement(final QualifiedName name) {
      final Function1<IScope, IEObjectDescription> _function = (IScope it) -> {
        return it.getSingleElement(name);
      };
      return IterableExtensions.<IEObjectDescription>head(IterableExtensions.<IEObjectDescription>filterNull(IterableExtensions.map(this.scopes, _function)));
    }
    
    @Override
    public IEObjectDescription getSingleElement(final EObject object) {
      final Function1<IScope, IEObjectDescription> _function = (IScope it) -> {
        return it.getSingleElement(object);
      };
      return IterableExtensions.<IEObjectDescription>head(IterableExtensions.<IEObjectDescription>filterNull(IterableExtensions.map(this.scopes, _function)));
    }
    
    public CompositeScope(final Iterable<? extends IScope> scopes) {
      super();
      this.scopes = scopes;
    }
    
    @Override
    @Pure
    public int hashCode() {
      return 31 * 1 + ((this.scopes== null) ? 0 : this.scopes.hashCode());
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
      ScopeContext.CompositeScope other = (ScopeContext.CompositeScope) obj;
      if (this.scopes == null) {
        if (other.scopes != null)
          return false;
      } else if (!this.scopes.equals(other.scopes))
        return false;
      return true;
    }
    
    @Override
    @Pure
    public String toString() {
      ToStringBuilder b = new ToStringBuilder(this);
      b.add("scopes", this.scopes);
      return b.toString();
    }
    
    @Pure
    public Iterable<? extends IScope> getScopes() {
      return this.scopes;
    }
  }
  
  @FinalFieldsConstructor
  public static class LazyScope implements IScope {
    private final Provider<IScope> provider;
    
    private IScope scope;
    
    @Delegate
    public IScope getScope() {
      if ((this.scope == null)) {
        this.scope = this.provider.get();
      }
      return this.scope;
    }
    
    public IEObjectDescription getSingleElement(final QualifiedName arg0) {
      return this.getScope().getSingleElement(arg0);
    }
    
    public Iterable<IEObjectDescription> getElements(final QualifiedName arg0) {
      return this.getScope().getElements(arg0);
    }
    
    public IEObjectDescription getSingleElement(final EObject arg0) {
      return this.getScope().getSingleElement(arg0);
    }
    
    public Iterable<IEObjectDescription> getElements(final EObject arg0) {
      return this.getScope().getElements(arg0);
    }
    
    public Iterable<IEObjectDescription> getAllElements() {
      return this.getScope().getAllElements();
    }
    
    public LazyScope(final Provider<IScope> provider) {
      super();
      this.provider = provider;
    }
  }
  
  @Data
  public static class PrefixingScope implements IScope {
    private final IScope parent;
    
    private final QualifiedName prefix;
    
    @Override
    public Iterable<IEObjectDescription> getAllElements() {
      final Function1<IEObjectDescription, IEObjectDescription> _function = (IEObjectDescription it) -> {
        return this.prependPrefix(it);
      };
      return IterableExtensions.<IEObjectDescription, IEObjectDescription>map(this.parent.getAllElements(), _function);
    }
    
    private IEObjectDescription prependPrefix(final IEObjectDescription desc) {
      int _segmentCount = desc.getName().getSegmentCount();
      boolean _greaterThan = (_segmentCount > 1);
      if (_greaterThan) {
        return desc;
      }
      QualifiedName _append = this.prefix.append(desc.getName());
      return new AliasedEObjectDescription(_append, desc);
    }
    
    @Override
    public Iterable<IEObjectDescription> getElements(final QualifiedName name) {
      if (((name.getSegmentCount() == 2) && name.startsWith(this.prefix))) {
        return this.parent.getElements(name.skipFirst(this.prefix.getSegmentCount()));
      }
      return CollectionLiterals.<IEObjectDescription>emptyList();
    }
    
    @Override
    public Iterable<IEObjectDescription> getElements(final EObject object) {
      final Function1<IEObjectDescription, IEObjectDescription> _function = (IEObjectDescription it) -> {
        return this.prependPrefix(it);
      };
      return IterableExtensions.<IEObjectDescription, IEObjectDescription>map(this.parent.getElements(object), _function);
    }
    
    @Override
    public IEObjectDescription getSingleElement(final QualifiedName name) {
      return IterableExtensions.<IEObjectDescription>head(this.getElements(name));
    }
    
    @Override
    public IEObjectDescription getSingleElement(final EObject object) {
      return IterableExtensions.<IEObjectDescription>head(this.getElements(object));
    }
    
    public PrefixingScope(final IScope parent, final QualifiedName prefix) {
      super();
      this.parent = parent;
      this.prefix = prefix;
    }
    
    @Override
    @Pure
    public int hashCode() {
      final int prime = 31;
      int result = 1;
      result = prime * result + ((this.parent== null) ? 0 : this.parent.hashCode());
      return prime * result + ((this.prefix== null) ? 0 : this.prefix.hashCode());
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
      ScopeContext.PrefixingScope other = (ScopeContext.PrefixingScope) obj;
      if (this.parent == null) {
        if (other.parent != null)
          return false;
      } else if (!this.parent.equals(other.parent))
        return false;
      if (this.prefix == null) {
        if (other.prefix != null)
          return false;
      } else if (!this.prefix.equals(other.prefix))
        return false;
      return true;
    }
    
    @Override
    @Pure
    public String toString() {
      ToStringBuilder b = new ToStringBuilder(this);
      b.add("parent", this.parent);
      b.add("prefix", this.prefix);
      return b.toString();
    }
    
    @Pure
    public IScope getParent() {
      return this.parent;
    }
    
    @Pure
    public QualifiedName getPrefix() {
      return this.prefix;
    }
  }
  
  @Accessors(AccessorType.PUBLIC_GETTER)
  private IScope moduleScope;
  
  @Accessors(AccessorType.PUBLIC_GETTER)
  private ScopeContext.MapScope groupingScope = new ScopeContext.MapScope(new ScopeContext.LazyScope(((Provider<IScope>) () -> {
    final Function1<IScopeContext, ScopeContext.MapScope> _function = (IScopeContext it) -> {
      return it.getGroupingScope();
    };
    return this.computeParentDefinitionScope(_function);
  })));
  
  @Accessors(AccessorType.PUBLIC_GETTER)
  private ScopeContext.MapScope typeScope = new ScopeContext.MapScope(new ScopeContext.LazyScope(((Provider<IScope>) () -> {
    final Function1<IScopeContext, ScopeContext.MapScope> _function = (IScopeContext it) -> {
      return it.getTypeScope();
    };
    return this.computeParentDefinitionScope(_function);
  })));
  
  @Accessors(AccessorType.PUBLIC_GETTER)
  private ScopeContext.MapScope identityScope = new ScopeContext.MapScope(new ScopeContext.LazyScope(((Provider<IScope>) () -> {
    final Function1<IScopeContext, ScopeContext.MapScope> _function = (IScopeContext it) -> {
      return it.getIdentityScope();
    };
    return this.computeParentDefinitionScope(_function);
  })));
  
  @Accessors(AccessorType.PUBLIC_GETTER)
  private ScopeContext.MapScope featureScope = new ScopeContext.MapScope(new ScopeContext.LazyScope(((Provider<IScope>) () -> {
    final Function1<IScopeContext, ScopeContext.MapScope> _function = (IScopeContext it) -> {
      return it.getFeatureScope();
    };
    return this.computeParentDefinitionScope(_function);
  })));
  
  @Accessors(AccessorType.PUBLIC_GETTER)
  private ScopeContext.MapScope extensionScope = new ScopeContext.MapScope(new ScopeContext.LazyScope(((Provider<IScope>) () -> {
    final Function1<IScopeContext, ScopeContext.MapScope> _function = (IScopeContext it) -> {
      return it.getExtensionScope();
    };
    return this.computeParentDefinitionScope(_function);
  })));
  
  private ScopeContext.MapScope schemaNodeScope;
  
  private List<Runnable> resolveDefinitions = CollectionLiterals.<Runnable>newArrayList();
  
  private List<Runnable> computeNodeScope = CollectionLiterals.<Runnable>newArrayList();
  
  private List<Runnable> afterAll = CollectionLiterals.<Runnable>newArrayList();
  
  @Accessors(AccessorType.PUBLIC_GETTER)
  private Map<String, IScopeContext> importedModules = CollectionLiterals.<String, IScopeContext>newHashMap();
  
  @Accessors
  private String localPrefix = null;
  
  @Accessors
  private String moduleName = null;
  
  /**
   * the scopes from other files belonging to the same module
   */
  @Accessors(AccessorType.PUBLIC_GETTER)
  private Set<IScopeContext> moduleBelongingSubModules = new LinkedHashSet<IScopeContext>();
  
  public ScopeContext(final IScope moduleScope, final String prefix, final String moduleName) {
    this.moduleScope = moduleScope;
    this.localPrefix = prefix;
    this.moduleName = moduleName;
  }
  
  @Override
  public ScopeContext.MapScope getSchemaNodeScope() {
    this.resolveDefinitionPhase();
    return this.schemaNodeScope;
  }
  
  @Override
  public void resolveDefinitionPhase() {
    if ((this.resolveDefinitions == null)) {
      return;
    }
    final List<Runnable> copy = this.resolveDefinitions;
    this.resolveDefinitions = null;
    final Consumer<Runnable> _function = (Runnable it) -> {
      it.run();
    };
    copy.forEach(_function);
    final List<Runnable> copy2 = this.computeNodeScope;
    this.computeNodeScope = null;
    IScope _computeParentSchemaNodeScope = this.computeParentSchemaNodeScope();
    ScopeContext.MapScope _mapScope = new ScopeContext.MapScope(_computeParentSchemaNodeScope);
    this.schemaNodeScope = _mapScope;
    final Consumer<Runnable> _function_1 = (Runnable it) -> {
      it.run();
    };
    copy2.forEach(_function_1);
  }
  
  @Override
  public void resolveAll() {
    if ((this.afterAll == null)) {
      return;
    }
    this.resolveDefinitionPhase();
    final List<Runnable> copy = this.afterAll;
    this.afterAll = null;
    final Consumer<Runnable> _function = (Runnable it) -> {
      it.run();
    };
    copy.forEach(_function);
  }
  
  private IScope computeParentSchemaNodeScope() {
    ArrayList<IScope> result = CollectionLiterals.<IScope>newArrayList();
    for (final IScopeContext subModule : this.moduleBelongingSubModules) {
      {
        final ScopeContext.MapScope subModuleScope = subModule.getSchemaNodeScope();
        if ((subModuleScope != null)) {
          result.add(subModuleScope.getLocalOnly());
        }
      }
    }
    Set<Map.Entry<String, IScopeContext>> _entrySet = this.importedModules.entrySet();
    for (final Map.Entry<String, IScopeContext> imported : _entrySet) {
      {
        final ScopeContext.MapScope scope = imported.getValue().getSchemaNodeScope();
        if ((scope != null)) {
          result.add(scope);
        }
      }
    }
    return new ScopeContext.CompositeScope(result);
  }
  
  private IScope computeParentDefinitionScope(final Function1<? super IScopeContext, ? extends ScopeContext.MapScope> fun) {
    ArrayList<IScope> result = CollectionLiterals.<IScope>newArrayList();
    if ((this.localPrefix != null)) {
      final QualifiedName prefix = QualifiedName.create(this.localPrefix);
      IScope _localOnly = fun.apply(this).getLocalOnly();
      ScopeContext.PrefixingScope _prefixingScope = new ScopeContext.PrefixingScope(_localOnly, prefix);
      result.add(_prefixingScope);
    }
    for (final IScopeContext subModule : this.moduleBelongingSubModules) {
      {
        final IScope scope = fun.apply(subModule).getLocalOnly();
        result.add(scope);
        if ((this.localPrefix != null)) {
          final QualifiedName prefix_1 = QualifiedName.create(this.localPrefix);
          ScopeContext.PrefixingScope _prefixingScope_1 = new ScopeContext.PrefixingScope(scope, prefix_1);
          result.add(_prefixingScope_1);
        }
      }
    }
    Set<Map.Entry<String, IScopeContext>> _entrySet = this.importedModules.entrySet();
    for (final Map.Entry<String, IScopeContext> imported : _entrySet) {
      {
        final IScope scope = fun.apply(imported.getValue()).getLocalOnly();
        final QualifiedName prefix_1 = QualifiedName.create(imported.getKey());
        ScopeContext.PrefixingScope _prefixingScope_1 = new ScopeContext.PrefixingScope(scope, prefix_1);
        result.add(_prefixingScope_1);
        Set<IScopeContext> _moduleBelongingSubModules = imported.getValue().getModuleBelongingSubModules();
        for (final IScopeContext submodule : _moduleBelongingSubModules) {
          {
            final IScope subScope = fun.apply(submodule).getLocalOnly();
            ScopeContext.PrefixingScope _prefixingScope_2 = new ScopeContext.PrefixingScope(subScope, prefix_1);
            result.add(_prefixingScope_2);
          }
        }
      }
    }
    return new ScopeContext.CompositeScope(result);
  }
  
  @Override
  public void onResolveDefinitions(final Runnable run) {
    if ((this.resolveDefinitions == null)) {
      if ((this.computeNodeScope == null)) {
        throw new IllegalStateException("Cannot add to phase, since the next phase has already been executed. Ignoring the callback");
      }
      run.run();
    } else {
      this.resolveDefinitions.add(run);
    }
  }
  
  @Override
  public void onComputeNodeScope(final Runnable run) {
    if ((this.computeNodeScope == null)) {
      if ((this.afterAll == null)) {
        throw new IllegalStateException("Cannot add to phase, since the next phase has already been executed. Ignoring the callback");
      }
      run.run();
    } else {
      this.computeNodeScope.add(run);
    }
  }
  
  @Override
  public void runAfterAll(final Runnable run) {
    if ((this.afterAll == null)) {
      run.run();
    } else {
      this.afterAll.add(run);
    }
  }
  
  @Pure
  public IScope getModuleScope() {
    return this.moduleScope;
  }
  
  @Pure
  public ScopeContext.MapScope getGroupingScope() {
    return this.groupingScope;
  }
  
  @Pure
  public ScopeContext.MapScope getTypeScope() {
    return this.typeScope;
  }
  
  @Pure
  public ScopeContext.MapScope getIdentityScope() {
    return this.identityScope;
  }
  
  @Pure
  public ScopeContext.MapScope getFeatureScope() {
    return this.featureScope;
  }
  
  @Pure
  public ScopeContext.MapScope getExtensionScope() {
    return this.extensionScope;
  }
  
  @Pure
  public Map<String, IScopeContext> getImportedModules() {
    return this.importedModules;
  }
  
  @Pure
  public String getLocalPrefix() {
    return this.localPrefix;
  }
  
  public void setLocalPrefix(final String localPrefix) {
    this.localPrefix = localPrefix;
  }
  
  @Pure
  public String getModuleName() {
    return this.moduleName;
  }
  
  public void setModuleName(final String moduleName) {
    this.moduleName = moduleName;
  }
  
  @Pure
  public Set<IScopeContext> getModuleBelongingSubModules() {
    return this.moduleBelongingSubModules;
  }
  
  private static final Logger LOG = Logger.getLogger(ScopeContext.class);
}

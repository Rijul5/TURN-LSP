package io.typefox.yang.scoping;

import com.google.common.base.Objects;
import com.google.common.collect.Iterables;
import com.google.common.collect.LinkedHashMultimap;
import com.google.inject.Inject;
import io.typefox.yang.scoping.GroupingInliningScopeContext;
import io.typefox.yang.scoping.IScopeContext;
import io.typefox.yang.scoping.Linker;
import io.typefox.yang.scoping.LocalNodeScopeContext;
import io.typefox.yang.scoping.LocalScopeContext;
import io.typefox.yang.scoping.ResourceDescriptionStrategy;
import io.typefox.yang.scoping.ScopeContext;
import io.typefox.yang.scoping.Validator;
import io.typefox.yang.scoping.YangModuleScope;
import io.typefox.yang.scoping.xpath.XpathResolver;
import io.typefox.yang.utils.YangExtensions;
import io.typefox.yang.utils.YangPathProvider;
import io.typefox.yang.validation.IssueCodes;
import io.typefox.yang.yang.AbstractImport;
import io.typefox.yang.yang.AbstractModule;
import io.typefox.yang.yang.Action;
import io.typefox.yang.yang.Augment;
import io.typefox.yang.yang.Base;
import io.typefox.yang.yang.BelongsTo;
import io.typefox.yang.yang.Case;
import io.typefox.yang.yang.Choice;
import io.typefox.yang.yang.Config;
import io.typefox.yang.yang.Deviation;
import io.typefox.yang.yang.Feature;
import io.typefox.yang.yang.FeatureReference;
import io.typefox.yang.yang.Grouping;
import io.typefox.yang.yang.GroupingRef;
import io.typefox.yang.yang.Identity;
import io.typefox.yang.yang.Import;
import io.typefox.yang.yang.Include;
import io.typefox.yang.yang.Input;
import io.typefox.yang.yang.KeyReference;
import io.typefox.yang.yang.Must;
import io.typefox.yang.yang.Output;
import io.typefox.yang.yang.Path;
import io.typefox.yang.yang.Prefix;
import io.typefox.yang.yang.Refine;
import io.typefox.yang.yang.Revision;
import io.typefox.yang.yang.RevisionDate;
import io.typefox.yang.yang.Rpc;
import io.typefox.yang.yang.SchemaNode;
import io.typefox.yang.yang.SchemaNodeIdentifier;
import io.typefox.yang.yang.Statement;
import io.typefox.yang.yang.Submodule;
import io.typefox.yang.yang.TypeReference;
import io.typefox.yang.yang.Typedef;
import io.typefox.yang.yang.Unique;
import io.typefox.yang.yang.Unknown;
import io.typefox.yang.yang.Uses;
import io.typefox.yang.yang.When;
import io.typefox.yang.yang.YangPackage;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Consumer;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtend.lib.annotations.Data;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.resource.EObjectDescription;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.resource.IResourceDescription;
import org.eclipse.xtext.resource.IResourceDescriptions;
import org.eclipse.xtext.resource.impl.ResourceDescriptionsData;
import org.eclipse.xtext.resource.impl.ResourceDescriptionsProvider;
import org.eclipse.xtext.scoping.IScope;
import org.eclipse.xtext.util.internal.EmfAdaptable;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.IteratorExtensions;
import org.eclipse.xtext.xbase.lib.Pair;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.eclipse.xtext.xbase.lib.Pure;
import org.eclipse.xtext.xbase.lib.util.ToStringBuilder;

/**
 * Links the imported modules and included submodules, as well as computing the IScopeContext for them.
 */
@SuppressWarnings("all")
public class ScopeContextProvider {
  @EmfAdaptable
  @Data
  private static class Adapter {
    public static class AdapterAdapter extends AdapterImpl {
      private ScopeContextProvider.Adapter element;
      
      public AdapterAdapter(final ScopeContextProvider.Adapter element) {
        this.element = element;
      }
      
      public ScopeContextProvider.Adapter get() {
        return this.element;
      }
      
      @Override
      public boolean isAdapterForType(final Object object) {
        return object == ScopeContextProvider.Adapter.class;
      }
    }
    
    private final IScopeContext scopeContext;
    
    private final QualifiedName nodePath;
    
    public static ScopeContextProvider.Adapter findInEmfObject(final Notifier emfObject) {
      for (org.eclipse.emf.common.notify.Adapter adapter : emfObject.eAdapters()) {
      	if (adapter instanceof ScopeContextProvider.Adapter.AdapterAdapter) {
      		return ((ScopeContextProvider.Adapter.AdapterAdapter) adapter).get();
      	}
      }
      return null;
    }
    
    public static ScopeContextProvider.Adapter removeFromEmfObject(final Notifier emfObject) {
      List<org.eclipse.emf.common.notify.Adapter> adapters = emfObject.eAdapters();
      for(int i = 0, max = adapters.size(); i < max; i++) {
      	org.eclipse.emf.common.notify.Adapter adapter = adapters.get(i);
      	if (adapter instanceof ScopeContextProvider.Adapter.AdapterAdapter) {
      		emfObject.eAdapters().remove(i);
      		return ((ScopeContextProvider.Adapter.AdapterAdapter) adapter).get();
      	}
      }
      return null;
    }
    
    public void attachToEmfObject(final Notifier emfObject) {
      Adapter result = findInEmfObject(emfObject);
      if (result != null)
      	throw new IllegalStateException("The given EMF object already contains an adapter for Adapter");
      ScopeContextProvider.Adapter.AdapterAdapter adapter = new ScopeContextProvider.Adapter.AdapterAdapter(this);
      emfObject.eAdapters().add(adapter);
    }
    
    public Adapter(final IScopeContext scopeContext, final QualifiedName nodePath) {
      super();
      this.scopeContext = scopeContext;
      this.nodePath = nodePath;
    }
    
    @Override
    @Pure
    public int hashCode() {
      final int prime = 31;
      int result = 1;
      result = prime * result + ((this.scopeContext== null) ? 0 : this.scopeContext.hashCode());
      return prime * result + ((this.nodePath== null) ? 0 : this.nodePath.hashCode());
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
      ScopeContextProvider.Adapter other = (ScopeContextProvider.Adapter) obj;
      if (this.scopeContext == null) {
        if (other.scopeContext != null)
          return false;
      } else if (!this.scopeContext.equals(other.scopeContext))
        return false;
      if (this.nodePath == null) {
        if (other.nodePath != null)
          return false;
      } else if (!this.nodePath.equals(other.nodePath))
        return false;
      return true;
    }
    
    @Override
    @Pure
    public String toString() {
      ToStringBuilder b = new ToStringBuilder(this);
      b.add("scopeContext", this.scopeContext);
      b.add("nodePath", this.nodePath);
      return b.toString();
    }
    
    @Pure
    public IScopeContext getScopeContext() {
      return this.scopeContext;
    }
    
    @Pure
    public QualifiedName getNodePath() {
      return this.nodePath;
    }
  }
  
  @Inject
  private Validator validator;
  
  @Inject
  private Linker linker;
  
  @Inject
  private ResourceDescriptionsProvider indexProvider;
  
  @Inject
  @Extension
  private YangExtensions _yangExtensions;
  
  @Inject
  private XpathResolver xpathResolver;
  
  @Inject
  private YangPathProvider yangPathProvider;
  
  public void removeScopeContexts(final Resource resource) {
    final Consumer<Resource> _function = (Resource it) -> {
      final Procedure1<EObject> _function_1 = (EObject it_1) -> {
        ScopeContextProvider.Adapter.removeFromEmfObject(it_1);
      };
      IteratorExtensions.<EObject>forEach(it.getAllContents(), _function_1);
    };
    resource.getResourceSet().getResources().forEach(_function);
  }
  
  public IScopeContext findScopeContext(final EObject node) {
    final AbstractModule module = EcoreUtil2.<AbstractModule>getContainerOfType(node, AbstractModule.class);
    if ((module == null)) {
      throw new IllegalStateException((("Object " + node) + " not contained in a module."));
    }
    IScopeContext result = this.getScopeContext(module);
    EObject current = node;
    do {
      {
        final ScopeContextProvider.Adapter candidate = ScopeContextProvider.Adapter.findInEmfObject(current);
        if ((candidate != null)) {
          return candidate.scopeContext;
        }
        current = current.eContainer();
      }
    } while((current != null));
    return result;
  }
  
  public QualifiedName findSchemaNodeName(final EObject node) {
    final ScopeContextProvider.Adapter adapter = ScopeContextProvider.Adapter.findInEmfObject(node);
    QualifiedName _nodePath = null;
    if (adapter!=null) {
      _nodePath=adapter.getNodePath();
    }
    return _nodePath;
  }
  
  public IScopeContext getScopeContext(final AbstractModule module) {
    final ScopeContextProvider.Adapter existing = ScopeContextProvider.Adapter.findInEmfObject(module);
    if ((existing != null)) {
      return existing.scopeContext;
    }
    final IScope moduleScope = this.getModuleScope(module.eResource());
    String _prefix = this._yangExtensions.getPrefix(module);
    String _elvis = null;
    io.typefox.yang.yang.Module _belongingModule = this.getBelongingModule(module, moduleScope);
    String _name = null;
    if (_belongingModule!=null) {
      _name=_belongingModule.getName();
    }
    if (_name != null) {
      _elvis = _name;
    } else {
      String _name_1 = module.getName();
      _elvis = _name_1;
    }
    final ScopeContext result = new ScopeContext(moduleScope, _prefix, _elvis);
    new ScopeContextProvider.Adapter(result, QualifiedName.EMPTY).attachToEmfObject(module);
    this.handleGeneric(module, QualifiedName.EMPTY, result, true);
    return result;
  }
  
  private IScope getModuleScope(final Resource resource) {
    final IResourceDescriptions index = this.indexProvider.getResourceDescriptions(resource);
    List<IResourceDescription> _yangPath = this.yangPathProvider.getYangPath(resource);
    ResourceDescriptionsData _resourceDescriptionsData = new ResourceDescriptionsData(_yangPath);
    final YangModuleScope yangPathModuleScope = new YangModuleScope(IScope.NULLSCOPE, _resourceDescriptionsData);
    return new YangModuleScope(yangPathModuleScope, index);
  }
  
  private io.typefox.yang.yang.Module _getBelongingModule(final io.typefox.yang.yang.Module module, final IScope moduleScope) {
    return module;
  }
  
  private io.typefox.yang.yang.Module _getBelongingModule(final Submodule submodule, final IScope moduleScope) {
    final BelongsTo belongsTo = IterableExtensions.<BelongsTo>head(Iterables.<BelongsTo>filter(submodule.getSubstatements(), BelongsTo.class));
    if ((belongsTo == null)) {
      return null;
    }
    final Function1<QualifiedName, IEObjectDescription> _function = (QualifiedName name) -> {
      final Iterable<IEObjectDescription> candidates = moduleScope.getElements(name);
      return IterableExtensions.<IEObjectDescription>head(candidates);
    };
    return this.linker.<io.typefox.yang.yang.Module>link(belongsTo, YangPackage.Literals.BELONGS_TO__MODULE, _function);
  }
  
  protected void addToDefinitionScope(final SchemaNode node, final IScopeContext ctx) {
    String _name = node.getName();
    boolean _tripleEquals = (_name == null);
    if (_tripleEquals) {
      return;
    }
    final QualifiedName n = QualifiedName.create(node.getName());
    Pair<ScopeContext.MapScope, String> _switchResult = null;
    boolean _matched = false;
    if (node instanceof Grouping) {
      _matched=true;
      ScopeContext.MapScope _groupingScope = ctx.getGroupingScope();
      _switchResult = Pair.<ScopeContext.MapScope, String>of(_groupingScope, "A grouping");
    }
    if (!_matched) {
      if (node instanceof Typedef) {
        _matched=true;
        ScopeContext.MapScope _typeScope = ctx.getTypeScope();
        _switchResult = Pair.<ScopeContext.MapScope, String>of(_typeScope, "A type");
      }
    }
    if (!_matched) {
      if (node instanceof Identity) {
        _matched=true;
        ScopeContext.MapScope _identityScope = ctx.getIdentityScope();
        _switchResult = Pair.<ScopeContext.MapScope, String>of(_identityScope, "An identity");
      }
    }
    if (!_matched) {
      if (node instanceof io.typefox.yang.yang.Extension) {
        _matched=true;
        ScopeContext.MapScope _extensionScope = ctx.getExtensionScope();
        _switchResult = Pair.<ScopeContext.MapScope, String>of(_extensionScope, "An extension");
      }
    }
    if (!_matched) {
      if (node instanceof Feature) {
        _matched=true;
        ScopeContext.MapScope _featureScope = ctx.getFeatureScope();
        _switchResult = Pair.<ScopeContext.MapScope, String>of(_featureScope, "A feature");
      }
    }
    final Pair<ScopeContext.MapScope, String> scopeAndName = _switchResult;
    if ((scopeAndName != null)) {
      boolean _tryAddLocal = scopeAndName.getKey().tryAddLocal(n, node);
      boolean _not = (!_tryAddLocal);
      if (_not) {
        StringConcatenation _builder = new StringConcatenation();
        String _value = scopeAndName.getValue();
        _builder.append(_value);
        _builder.append(" with the name \'");
        _builder.append(n);
        _builder.append("\' already exists.");
        this.validator.addIssue(node, YangPackage.Literals.SCHEMA_NODE__NAME, _builder.toString(), IssueCodes.DUPLICATE_NAME);
      }
    }
  }
  
  protected void _computeScope(final EObject node, final QualifiedName nodePath, final IScopeContext ctx, final boolean isConfig) {
    this.handleGeneric(node, nodePath, ctx, isConfig);
  }
  
  protected void _computeScope(final Refine node, final QualifiedName nodePath, final IScopeContext ctx, final boolean isConfig) {
    this.doLinkNodeLater(node.getNode(), nodePath, ctx);
    this.handleGeneric(node, nodePath, ctx, isConfig);
  }
  
  protected void _computeScope(final Augment node, final QualifiedName nodePath, final IScopeContext ctx, final boolean isConfig) {
    SchemaNodeIdentifier _path = node.getPath();
    boolean _tripleNotEquals = (_path != null);
    if (_tripleNotEquals) {
      this.doLinkNodeLater(node.getPath(), nodePath, ctx);
    }
    this.handleGeneric(node, nodePath, ctx, isConfig);
  }
  
  private void doLinkNodeLater(final SchemaNodeIdentifier identifier, final QualifiedName prefix, final IScopeContext context) {
    final Runnable _function = () -> {
      this.internalLinkNode(identifier, prefix, context);
    };
    context.runAfterAll(_function);
  }
  
  private QualifiedName internalLinkNode(final SchemaNodeIdentifier identifier, final QualifiedName prefix, final IScopeContext context) {
    SchemaNodeIdentifier _target = identifier.getTarget();
    boolean _tripleNotEquals = (_target != null);
    if (_tripleNotEquals) {
      this.internalLinkNode(identifier.getTarget(), prefix, context);
    }
    final QualifiedName pref = this.internalGetQualifiedName(identifier, prefix, context);
    final Function1<QualifiedName, IEObjectDescription> _function = (QualifiedName it) -> {
      final IEObjectDescription result = context.getSchemaNodeScope().getSingleElement(pref);
      return result;
    };
    this.linker.<Object>link(identifier, YangPackage.Literals.SCHEMA_NODE_IDENTIFIER__SCHEMA_NODE, _function);
    return pref;
  }
  
  protected void _computeScope(final TypeReference node, final QualifiedName nodePath, final IScopeContext ctx, final boolean isConfig) {
    final Runnable _function = () -> {
      final Function1<QualifiedName, IEObjectDescription> _function_1 = (QualifiedName name) -> {
        if (((name.getSegmentCount() == 2) && Objects.equal(name.getFirstSegment(), ctx.getLocalPrefix()))) {
          return ctx.getTypeScope().getSingleElement(name.skipFirst(1));
        }
        return ctx.getTypeScope().getSingleElement(name);
      };
      this.linker.<Object>link(node, YangPackage.Literals.TYPE_REFERENCE__TYPE, _function_1);
    };
    ctx.onResolveDefinitions(_function);
    this.handleGeneric(node, nodePath, ctx, isConfig);
  }
  
  protected void _computeScope(final Uses node, final QualifiedName nodePath, final IScopeContext ctx, final boolean isConfig) {
    this.handleGeneric(node, nodePath, ctx, isConfig);
    final Runnable _function = () -> {
      final GroupingInliningScopeContext inliningCtx = new GroupingInliningScopeContext(ctx);
      GroupingRef _grouping = node.getGrouping();
      Grouping _node = null;
      if (_grouping!=null) {
        _node=_grouping.getNode();
      }
      boolean _tripleNotEquals = (_node != null);
      if (_tripleNotEquals) {
        EList<Statement> _substatements = node.getGrouping().getNode().getSubstatements();
        for (final Statement child : _substatements) {
          this.inlineGrouping(child, nodePath, inliningCtx, isConfig);
        }
      }
    };
    ctx.onComputeNodeScope(_function);
  }
  
  private boolean handleConfig(final Statement statement, final boolean isConfig) {
    if ((statement instanceof Grouping)) {
      return true;
    }
    final Config configStmnt = IterableExtensions.<Config>head(Iterables.<Config>filter(statement.getSubstatements(), Config.class));
    if ((configStmnt == null)) {
      return isConfig;
    }
    String _lowerCase = configStmnt.getIsConfig().trim().toLowerCase();
    boolean _equals = Objects.equal(_lowerCase, "true");
    if (_equals) {
      if ((!isConfig)) {
        this.validator.addIssue(configStmnt, YangPackage.Literals.CONFIG__IS_CONFIG, "Cannot add configuration data as a child of non-config data.", IssueCodes.INVALID_CONFIG);
      }
      return true;
    }
    return false;
  }
  
  private void _inlineGrouping(final Statement statement, final QualifiedName name, final GroupingInliningScopeContext context, final boolean isConfig) {
  }
  
  private void _inlineGrouping(final Grouping statement, final QualifiedName name, final GroupingInliningScopeContext context, final boolean isConfig) {
  }
  
  private void _inlineGrouping(final Typedef statement, final QualifiedName name, final GroupingInliningScopeContext context, final boolean isConfig) {
  }
  
  private void _inlineGrouping(final Uses statement, final QualifiedName name, final GroupingInliningScopeContext context, final boolean isConfig) {
    GroupingRef _grouping = statement.getGrouping();
    boolean _tripleNotEquals = (_grouping != null);
    if (_tripleNotEquals) {
      EList<Statement> _substatements = statement.getGrouping().getNode().getSubstatements();
      for (final Statement subStmnt : _substatements) {
        this.inlineGrouping(subStmnt, name, context, isConfig);
      }
    }
  }
  
  private void _inlineGrouping(final SchemaNode statement, final QualifiedName name, final GroupingInliningScopeContext context, final boolean isConfig) {
    final QualifiedName newPath = this.getQualifiedName(statement, name, context);
    boolean newIsConfig = this.handleConfig(statement, isConfig);
    if (((!Objects.equal(newPath, name)) && (!(statement instanceof Augment)))) {
      this.addToNodeScope(statement, newPath, context, newIsConfig);
    }
    EList<Statement> _substatements = statement.getSubstatements();
    for (final Statement subStmnt : _substatements) {
      this.inlineGrouping(subStmnt, newPath, context, newIsConfig);
    }
  }
  
  protected void _computeScope(final GroupingRef node, final QualifiedName nodePath, final IScopeContext ctx, final boolean isConfig) {
    final Runnable _function = () -> {
      final Function1<QualifiedName, IEObjectDescription> _function_1 = (QualifiedName name) -> {
        if (((name.getSegmentCount() == 2) && Objects.equal(name.getFirstSegment(), ctx.getLocalPrefix()))) {
          return ctx.getGroupingScope().getSingleElement(name.skipFirst(1));
        }
        return ctx.getGroupingScope().getSingleElement(name);
      };
      this.linker.<Object>link(node, YangPackage.Literals.GROUPING_REF__NODE, _function_1);
    };
    ctx.onResolveDefinitions(_function);
    this.handleGeneric(node, nodePath, ctx, isConfig);
  }
  
  protected void _computeScope(final Base node, final QualifiedName nodePath, final IScopeContext ctx, final boolean isConfig) {
    final Runnable _function = () -> {
      final Function1<QualifiedName, IEObjectDescription> _function_1 = (QualifiedName name) -> {
        return ctx.getIdentityScope().getSingleElement(name);
      };
      this.linker.<Object>link(node, YangPackage.Literals.BASE__REFERENCE, _function_1);
    };
    ctx.onResolveDefinitions(_function);
    this.handleGeneric(node, nodePath, ctx, isConfig);
  }
  
  protected void _computeScope(final FeatureReference node, final QualifiedName nodePath, final IScopeContext ctx, final boolean isConfig) {
    final Runnable _function = () -> {
      final Function1<QualifiedName, IEObjectDescription> _function_1 = (QualifiedName name) -> {
        return ctx.getFeatureScope().getSingleElement(name);
      };
      this.linker.<Object>link(node, YangPackage.Literals.FEATURE_REFERENCE__FEATURE, _function_1);
    };
    ctx.onResolveDefinitions(_function);
    this.handleGeneric(node, nodePath, ctx, isConfig);
  }
  
  protected void _computeScope(final Unknown node, final QualifiedName nodePath, final IScopeContext ctx, final boolean isConfig) {
    final Runnable _function = () -> {
      final Function1<QualifiedName, IEObjectDescription> _function_1 = (QualifiedName name) -> {
        return ctx.getExtensionScope().getSingleElement(name);
      };
      this.linker.<Object>link(node, YangPackage.Literals.UNKNOWN__EXTENSION, _function_1);
    };
    ctx.onResolveDefinitions(_function);
    this.handleGeneric(node, nodePath, ctx, isConfig);
  }
  
  protected void _computeScope(final KeyReference node, final QualifiedName nodePath, final IScopeContext ctx, final boolean isConfig) {
    final Runnable _function = () -> {
      final Function1<QualifiedName, IEObjectDescription> _function_1 = (QualifiedName syntaxName) -> {
        final Function1<IEObjectDescription, Boolean> _function_2 = (IEObjectDescription candidate) -> {
          EClass _eClass = candidate.getEClass();
          boolean _tripleNotEquals = (_eClass != YangPackage.Literals.LEAF);
          if (_tripleNotEquals) {
            return Boolean.valueOf(false);
          }
          String _lastSegment = candidate.getName().getLastSegment();
          String _lastSegment_1 = syntaxName.getLastSegment();
          boolean _notEquals = (!Objects.equal(_lastSegment, _lastSegment_1));
          if (_notEquals) {
            return Boolean.valueOf(false);
          }
          final QualifiedName np = nodePath;
          return Boolean.valueOf(candidate.getName().skipLast(2).equals(np));
        };
        final IEObjectDescription result = IterableExtensions.<IEObjectDescription>head(IterableExtensions.<IEObjectDescription>filter(ctx.getSchemaNodeScope().getAllElements(), _function_2));
        if (((result != null) && (Boolean.valueOf(((List<String>)Conversions.doWrapArray(result.getUserDataKeys())).contains(ScopeContextProvider.NO_CONFIG_USER_DATA)) == Boolean.valueOf(isConfig)))) {
          this.validator.addIssue(node, YangPackage.Literals.KEY_REFERENCE__NODE, "The list\'s keys must have the same `config` value as the list itself.", IssueCodes.INVALID_CONFIG);
        }
        return result;
      };
      this.linker.<Object>link(node, YangPackage.Literals.KEY_REFERENCE__NODE, _function_1);
    };
    ctx.runAfterAll(_function);
    this.handleGeneric(node, nodePath, ctx, isConfig);
  }
  
  protected void _computeScope(final Unique node, final QualifiedName nodePath, final IScopeContext ctx, final boolean isConfig) {
    EList<SchemaNodeIdentifier> _references = node.getReferences();
    for (final SchemaNodeIdentifier identifier : _references) {
      this.doLinkNodeLater(identifier, nodePath, ctx);
    }
    this.handleGeneric(node, nodePath, ctx, isConfig);
  }
  
  protected void _computeScope(final Deviation node, final QualifiedName nodePath, final IScopeContext ctx, final boolean isConfig) {
    this.doLinkNodeLater(node.getReference(), nodePath, ctx);
    this.handleGeneric(node, nodePath, ctx, isConfig);
  }
  
  protected void _computeScope(final When when, final QualifiedName nodePath, final IScopeContext ctx, final boolean isConfig) {
    final Runnable _function = () -> {
      this.xpathResolver.doResolve(when.getCondition(), nodePath, ctx);
    };
    ctx.runAfterAll(_function);
    this.handleGeneric(when, nodePath, ctx, isConfig);
  }
  
  protected void _computeScope(final Must must, final QualifiedName nodePath, final IScopeContext ctx, final boolean isConfig) {
    final Runnable _function = () -> {
      this.xpathResolver.doResolve(must.getConstraint(), nodePath, ctx);
    };
    ctx.runAfterAll(_function);
    this.handleGeneric(must, nodePath, ctx, isConfig);
  }
  
  protected void _computeScope(final Path path, final QualifiedName nodePath, final IScopeContext ctx, final boolean isConfig) {
    final Runnable _function = () -> {
      this.xpathResolver.doResolve(path.getReference(), nodePath, ctx);
    };
    ctx.runAfterAll(_function);
    this.handleGeneric(path, nodePath, ctx, isConfig);
  }
  
  protected void handleGeneric(final EObject node, final QualifiedName nodePath, final IScopeContext ctx, final boolean isConfig) {
    boolean newIsConfig = isConfig;
    if ((node instanceof SchemaNode)) {
      this.addToDefinitionScope(((SchemaNode)node), ctx);
    }
    QualifiedName newPath = nodePath;
    if ((node instanceof Statement)) {
      newIsConfig = this.handleConfig(((Statement)node), isConfig);
      newPath = this.getQualifiedName(((Statement)node), nodePath, ctx);
      if ((((((!Objects.equal(newPath, nodePath)) && (!(node instanceof Refine))) && (!(node instanceof Grouping))) && (!(node instanceof Augment))) && (!(node instanceof Deviation)))) {
        this.addToNodeScope(node, newPath, ctx, newIsConfig);
      }
    }
    IScopeContext _switchResult = null;
    boolean _matched = false;
    if (node instanceof Grouping) {
      _matched=true;
      _switchResult = new LocalNodeScopeContext(ctx);
    }
    if (!_matched) {
      if (node instanceof SchemaNode) {
        _matched=true;
        IScopeContext _xblockexpression = null;
        {
          IScopeContext _elvis = null;
          ScopeContextProvider.Adapter _findInEmfObject = ScopeContextProvider.Adapter.findInEmfObject(node);
          IScopeContext _scopeContext = null;
          if (_findInEmfObject!=null) {
            _scopeContext=_findInEmfObject.scopeContext;
          }
          if (_scopeContext != null) {
            _elvis = _scopeContext;
          } else {
            LocalScopeContext _localScopeContext = new LocalScopeContext(ctx);
            _elvis = _localScopeContext;
          }
          final IScopeContext scope = _elvis;
          new ScopeContextProvider.Adapter(scope, newPath).attachToEmfObject(node);
          _xblockexpression = scope;
        }
        _switchResult = _xblockexpression;
      }
    }
    if (!_matched) {
      _switchResult = ctx;
    }
    final IScopeContext context = _switchResult;
    EList<EObject> _eContents = node.eContents();
    for (final EObject child : _eContents) {
      this.computeScope(child, newPath, context, newIsConfig);
    }
  }
  
  private static final String NO_CONFIG_USER_DATA = "NO_CONFIG";
  
  private void addToNodeScope(final EObject node, final QualifiedName name, final IScopeContext ctx, final boolean isConfig) {
    final Runnable _function = () -> {
      Map<String, String> _xifexpression = null;
      if (isConfig) {
        _xifexpression = CollectionLiterals.<String, String>emptyMap();
      } else {
        Pair<String, String> _mappedTo = Pair.<String, String>of(ScopeContextProvider.NO_CONFIG_USER_DATA, "t");
        _xifexpression = Collections.<String, String>unmodifiableMap(CollectionLiterals.<String, String>newHashMap(_mappedTo));
      }
      final Map<String, String> options = _xifexpression;
      boolean _tryAddLocal = ctx.getSchemaNodeScope().tryAddLocal(name, node, options);
      boolean _not = (!_tryAddLocal);
      if (_not) {
        StringConcatenation _builder = new StringConcatenation();
        _builder.append("A schema node with the name \'");
        _builder.append(name);
        _builder.append("\' already exists.");
        this.validator.addIssue(node, YangPackage.Literals.SCHEMA_NODE__NAME, _builder.toString(), IssueCodes.DUPLICATE_NAME);
      }
    };
    ctx.onComputeNodeScope(_function);
  }
  
  protected void _computeScope(final AbstractImport element, final QualifiedName currentPrefix, final IScopeContext ctx, final boolean isConfig) {
    final RevisionDate importedRevisionStatement = IterableExtensions.<RevisionDate>head(Iterables.<RevisionDate>filter(element.getSubstatements(), RevisionDate.class));
    final Function1<QualifiedName, IEObjectDescription> _function = (QualifiedName name) -> {
      final Iterable<IEObjectDescription> candidates = ctx.getModuleScope().getElements(name);
      final LinkedHashMultimap<String, IEObjectDescription> revisionToModule = LinkedHashMultimap.<String, IEObjectDescription>create();
      for (final IEObjectDescription candidate : candidates) {
        {
          final String revision = candidate.getUserData(ResourceDescriptionStrategy.REVISION);
          if ((revision == null)) {
            revisionToModule.put("", candidate);
          } else {
            revisionToModule.put(revision, candidate);
          }
        }
      }
      boolean _isEmpty = revisionToModule.isEmpty();
      if (_isEmpty) {
        return null;
      }
      final ArrayList<IEObjectDescription> matches = CollectionLiterals.<IEObjectDescription>newArrayList();
      if ((importedRevisionStatement != null)) {
        final Function1<QualifiedName, IEObjectDescription> _function_1 = (QualifiedName revisionName) -> {
          final Function1<IEObjectDescription, String> _function_2 = (IEObjectDescription it) -> {
            return it.getEObjectURI().trimFragment().toString();
          };
          List<IEObjectDescription> _sortBy = IterableExtensions.<IEObjectDescription, String>sortBy(revisionToModule.get(revisionName.toString()), _function_2);
          Iterables.<IEObjectDescription>addAll(matches, _sortBy);
          boolean _isEmpty_1 = matches.isEmpty();
          if (_isEmpty_1) {
            return null;
          }
          EObject _resolve = EcoreUtil.resolve(IterableExtensions.<IEObjectDescription>head(matches).getEObjectOrProxy(), element);
          final AbstractModule importedModule = ((AbstractModule) _resolve);
          final Function1<Revision, Boolean> _function_3 = (Revision it) -> {
            String _revision = it.getRevision();
            String _string = revisionName.toString();
            return Boolean.valueOf(Objects.equal(_revision, _string));
          };
          final Revision revisionToBeLinked = IterableExtensions.<Revision>findFirst(Iterables.<Revision>filter(importedModule.getSubstatements(), Revision.class), _function_3);
          if ((revisionToBeLinked == null)) {
            return Linker.ROOT;
          } else {
            return EObjectDescription.create(revisionName, revisionToBeLinked);
          }
        };
        this.linker.<Revision>link(importedRevisionStatement, YangPackage.Literals.REVISION_DATE__DATE, _function_1);
      }
      boolean _isEmpty_1 = matches.isEmpty();
      if (_isEmpty_1) {
        Set<IEObjectDescription> _get = revisionToModule.get(IterableExtensions.<String>max(revisionToModule.keys()));
        Iterables.<IEObjectDescription>addAll(matches, _get);
      }
      final Iterator<IEObjectDescription> iter = matches.iterator();
      IEObjectDescription _xifexpression = null;
      boolean _hasNext = iter.hasNext();
      if (_hasNext) {
        _xifexpression = iter.next();
      }
      final IEObjectDescription result = _xifexpression;
      boolean _hasNext_1 = iter.hasNext();
      if (_hasNext_1) {
        StringConcatenation _builder = new StringConcatenation();
        _builder.append("Multiple modules \'");
        _builder.append(name);
        _builder.append("\' with matching revision are available [");
        final Function1<IEObjectDescription, CharSequence> _function_2 = (IEObjectDescription it) -> {
          return name.toString();
        };
        String _join = IterableExtensions.<IEObjectDescription>join(matches, ", ", _function_2);
        _builder.append(_join);
        _builder.append("]");
        this.validator.addIssue(element, YangPackage.Literals.ABSTRACT_IMPORT__MODULE, _builder.toString(), IssueCodes.AMBIGUOUS_IMPORT);
      }
      return result;
    };
    final AbstractModule importedModule = this.linker.<AbstractModule>link(element, YangPackage.Literals.ABSTRACT_IMPORT__MODULE, _function);
    Prefix _head = IterableExtensions.<Prefix>head(Iterables.<Prefix>filter(element.getSubstatements(), Prefix.class));
    String _prefix = null;
    if (_head!=null) {
      _prefix=_head.getPrefix();
    }
    final String prefix = _prefix;
    if ((importedModule instanceof Submodule)) {
      if ((element instanceof Import)) {
        StringConcatenation _builder = new StringConcatenation();
        _builder.append("The submodule \'");
        String _name = ((Submodule)importedModule).getName();
        _builder.append(_name);
        _builder.append("\' needs to be \'included\' not \'imported\'.");
        this.validator.addIssue(element, null, _builder.toString(), IssueCodes.IMPORT_NOT_A_MODULE);
      }
      final AbstractModule module = this.findContainingModule(element);
      final io.typefox.yang.yang.Module belongingModule = this.getBelongingModule(importedModule, ctx.getModuleScope());
      if (((belongingModule != null) && (belongingModule != module))) {
        StringConcatenation _builder_1 = new StringConcatenation();
        _builder_1.append("The imported submodule \'");
        String _name_1 = ((Submodule)importedModule).getName();
        _builder_1.append(_name_1);
        _builder_1.append("\' belongs to the different module \'");
        String _name_2 = belongingModule.getName();
        _builder_1.append(_name_2);
        _builder_1.append("\'.");
        this.validator.addIssue(element, YangPackage.Literals.ABSTRACT_IMPORT__MODULE, _builder_1.toString(), IssueCodes.INCLUDED_SUB_MODULE_BELONGS_TO_DIFFERENT_MODULE);
      } else {
        ctx.getModuleBelongingSubModules().add(this.getScopeContext(importedModule));
      }
    }
    if ((importedModule instanceof io.typefox.yang.yang.Module)) {
      if ((element instanceof Include)) {
        StringConcatenation _builder_2 = new StringConcatenation();
        _builder_2.append("The module \'");
        String _name_3 = ((io.typefox.yang.yang.Module)importedModule).getName();
        _builder_2.append(_name_3);
        _builder_2.append("\' needs to be \'imported\' not \'included\'.");
        this.validator.addIssue(element, null, _builder_2.toString(), IssueCodes.INCLUDE_NOT_A_SUB_MODULE);
      }
      if ((prefix == null)) {
        this.validator.addIssue(element, YangPackage.Literals.ABSTRACT_IMPORT__MODULE, "The \'prefix\' statement is mandatory.", IssueCodes.MISSING_PREFIX);
      } else {
        ctx.getImportedModules().put(prefix, this.getScopeContext(importedModule));
      }
    }
  }
  
  private AbstractModule findContainingModule(final EObject obj) {
    final AbstractModule candidate = EcoreUtil2.<AbstractModule>getContainerOfType(obj, AbstractModule.class);
    if ((candidate instanceof Submodule)) {
      return IterableExtensions.<BelongsTo>head(Iterables.<BelongsTo>filter(((Submodule)candidate).getSubstatements(), BelongsTo.class)).getModule();
    }
    return candidate;
  }
  
  private QualifiedName _getQualifiedName(final Statement node, final QualifiedName p, final IScopeContext ctx) {
    return p;
  }
  
  private QualifiedName _getQualifiedName(final Grouping node, final QualifiedName p, final IScopeContext ctx) {
    return QualifiedName.EMPTY;
  }
  
  private QualifiedName _getQualifiedName(final io.typefox.yang.yang.Extension node, final QualifiedName p, final IScopeContext ctx) {
    return p;
  }
  
  private QualifiedName _getQualifiedName(final Identity node, final QualifiedName p, final IScopeContext ctx) {
    return p;
  }
  
  private QualifiedName _getQualifiedName(final Feature node, final QualifiedName p, final IScopeContext ctx) {
    return p;
  }
  
  private QualifiedName _getQualifiedName(final Typedef node, final QualifiedName p, final IScopeContext ctx) {
    return p;
  }
  
  private QualifiedName _getQualifiedName(final Input node, final QualifiedName p, final IScopeContext ctx) {
    return p.append(ctx.getModuleName()).append("input");
  }
  
  private QualifiedName _getQualifiedName(final Output node, final QualifiedName p, final IScopeContext ctx) {
    return p.append(ctx.getModuleName()).append("output");
  }
  
  private QualifiedName _getQualifiedName(final SchemaNode node, final QualifiedName p, final IScopeContext ctx) {
    QualifiedName prefix = p;
    if (((node.eContainer() instanceof Choice) && (!(node instanceof Case)))) {
      prefix = p.append(ctx.getModuleName()).append(node.getName());
      this.addToNodeScope(node, prefix, ctx, true);
    }
    final QualifiedName result = prefix.append(ctx.getModuleName()).append(node.getName());
    if (((node instanceof Rpc) || (node instanceof Action))) {
      final Input input = IterableExtensions.<Input>head(Iterables.<Input>filter(node.getSubstatements(), Input.class));
      if ((input == null)) {
        final QualifiedName inputName = result.append(ctx.getModuleName()).append("input");
        this.addToNodeScope(node, inputName, ctx, true);
      }
      final Output output = IterableExtensions.<Output>head(Iterables.<Output>filter(node.getSubstatements(), Output.class));
      if ((output == null)) {
        final QualifiedName outputName = result.append(ctx.getModuleName()).append("output");
        this.addToNodeScope(node, outputName, ctx, true);
      }
    }
    return result;
  }
  
  private QualifiedName _getQualifiedName(final Augment node, final QualifiedName p, final IScopeContext ctx) {
    SchemaNodeIdentifier _path = node.getPath();
    boolean _tripleEquals = (_path == null);
    if (_tripleEquals) {
      return p;
    }
    return this.internalGetQualifiedName(node.getPath(), p, ctx);
  }
  
  private QualifiedName _getQualifiedName(final Deviation node, final QualifiedName p, final IScopeContext ctx) {
    SchemaNodeIdentifier _reference = node.getReference();
    boolean _tripleEquals = (_reference == null);
    if (_tripleEquals) {
      return p;
    }
    return this.internalGetQualifiedName(node.getReference(), p, ctx);
  }
  
  private QualifiedName _getQualifiedName(final Refine node, final QualifiedName p, final IScopeContext ctx) {
    SchemaNodeIdentifier _node = node.getNode();
    boolean _tripleEquals = (_node == null);
    if (_tripleEquals) {
      return p;
    }
    return this.internalGetQualifiedName(node.getNode(), p, ctx);
  }
  
  private QualifiedName internalGetQualifiedName(final SchemaNodeIdentifier identifier, final QualifiedName p, final IScopeContext ctx) {
    QualifiedName _xifexpression = null;
    SchemaNodeIdentifier _target = identifier.getTarget();
    boolean _tripleNotEquals = (_target != null);
    if (_tripleNotEquals) {
      _xifexpression = this.internalGetQualifiedName(identifier.getTarget(), p, ctx);
    } else {
      QualifiedName _xifexpression_1 = null;
      boolean _isIsAbsolute = identifier.isIsAbsolute();
      if (_isIsAbsolute) {
        _xifexpression_1 = QualifiedName.EMPTY;
      } else {
        _xifexpression_1 = p;
      }
      _xifexpression = _xifexpression_1;
    }
    QualifiedName prefix = _xifexpression;
    final QualifiedName qn = this.linker.getLinkingName(identifier, YangPackage.Literals.SCHEMA_NODE_IDENTIFIER__SCHEMA_NODE);
    if ((qn != null)) {
      String firstSeg = ctx.getModuleName();
      int _segmentCount = qn.getSegmentCount();
      boolean _tripleEquals = (_segmentCount == 2);
      if (_tripleEquals) {
        String _elvis = null;
        IScopeContext _get = ctx.getImportedModules().get(qn.getFirstSegment());
        String _moduleName = null;
        if (_get!=null) {
          _moduleName=_get.getModuleName();
        }
        if (_moduleName != null) {
          _elvis = _moduleName;
        } else {
          String _moduleName_1 = ctx.getModuleName();
          _elvis = _moduleName_1;
        }
        firstSeg = _elvis;
      }
      String secondSeg = qn.getLastSegment();
      return prefix.append(firstSeg).append(secondSeg);
    } else {
      if (((identifier.getSchemaNode() != null) && (!identifier.getSchemaNode().eIsProxy()))) {
        AbstractModule _containerOfType = EcoreUtil2.<AbstractModule>getContainerOfType(identifier.getSchemaNode(), AbstractModule.class);
        String _name = null;
        if (_containerOfType!=null) {
          _name=_containerOfType.getName();
        }
        final String moduleName = _name;
        if (((moduleName != null) && (identifier.getSchemaNode().getName() != null))) {
          return prefix.append(moduleName).append(identifier.getSchemaNode().getName());
        }
      }
    }
    return prefix;
  }
  
  private io.typefox.yang.yang.Module getBelongingModule(final AbstractModule module, final IScope moduleScope) {
    if (module instanceof io.typefox.yang.yang.Module) {
      return _getBelongingModule((io.typefox.yang.yang.Module)module, moduleScope);
    } else if (module instanceof Submodule) {
      return _getBelongingModule((Submodule)module, moduleScope);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(module, moduleScope).toString());
    }
  }
  
  protected void computeScope(final EObject element, final QualifiedName currentPrefix, final IScopeContext ctx, final boolean isConfig) {
    if (element instanceof AbstractImport) {
      _computeScope((AbstractImport)element, currentPrefix, ctx, isConfig);
      return;
    } else if (element instanceof Augment) {
      _computeScope((Augment)element, currentPrefix, ctx, isConfig);
      return;
    } else if (element instanceof Base) {
      _computeScope((Base)element, currentPrefix, ctx, isConfig);
      return;
    } else if (element instanceof Deviation) {
      _computeScope((Deviation)element, currentPrefix, ctx, isConfig);
      return;
    } else if (element instanceof Must) {
      _computeScope((Must)element, currentPrefix, ctx, isConfig);
      return;
    } else if (element instanceof Path) {
      _computeScope((Path)element, currentPrefix, ctx, isConfig);
      return;
    } else if (element instanceof Refine) {
      _computeScope((Refine)element, currentPrefix, ctx, isConfig);
      return;
    } else if (element instanceof Unique) {
      _computeScope((Unique)element, currentPrefix, ctx, isConfig);
      return;
    } else if (element instanceof Unknown) {
      _computeScope((Unknown)element, currentPrefix, ctx, isConfig);
      return;
    } else if (element instanceof Uses) {
      _computeScope((Uses)element, currentPrefix, ctx, isConfig);
      return;
    } else if (element instanceof When) {
      _computeScope((When)element, currentPrefix, ctx, isConfig);
      return;
    } else if (element instanceof FeatureReference) {
      _computeScope((FeatureReference)element, currentPrefix, ctx, isConfig);
      return;
    } else if (element instanceof GroupingRef) {
      _computeScope((GroupingRef)element, currentPrefix, ctx, isConfig);
      return;
    } else if (element instanceof KeyReference) {
      _computeScope((KeyReference)element, currentPrefix, ctx, isConfig);
      return;
    } else if (element instanceof TypeReference) {
      _computeScope((TypeReference)element, currentPrefix, ctx, isConfig);
      return;
    } else if (element != null) {
      _computeScope(element, currentPrefix, ctx, isConfig);
      return;
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(element, currentPrefix, ctx, isConfig).toString());
    }
  }
  
  private void inlineGrouping(final Statement statement, final QualifiedName name, final GroupingInliningScopeContext context, final boolean isConfig) {
    if (statement instanceof Grouping) {
      _inlineGrouping((Grouping)statement, name, context, isConfig);
      return;
    } else if (statement instanceof Typedef) {
      _inlineGrouping((Typedef)statement, name, context, isConfig);
      return;
    } else if (statement instanceof Uses) {
      _inlineGrouping((Uses)statement, name, context, isConfig);
      return;
    } else if (statement instanceof SchemaNode) {
      _inlineGrouping((SchemaNode)statement, name, context, isConfig);
      return;
    } else if (statement != null) {
      _inlineGrouping(statement, name, context, isConfig);
      return;
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(statement, name, context, isConfig).toString());
    }
  }
  
  private QualifiedName getQualifiedName(final Statement node, final QualifiedName p, final IScopeContext ctx) {
    if (node instanceof Augment) {
      return _getQualifiedName((Augment)node, p, ctx);
    } else if (node instanceof Deviation) {
      return _getQualifiedName((Deviation)node, p, ctx);
    } else if (node instanceof io.typefox.yang.yang.Extension) {
      return _getQualifiedName((io.typefox.yang.yang.Extension)node, p, ctx);
    } else if (node instanceof Feature) {
      return _getQualifiedName((Feature)node, p, ctx);
    } else if (node instanceof Grouping) {
      return _getQualifiedName((Grouping)node, p, ctx);
    } else if (node instanceof Identity) {
      return _getQualifiedName((Identity)node, p, ctx);
    } else if (node instanceof Input) {
      return _getQualifiedName((Input)node, p, ctx);
    } else if (node instanceof Output) {
      return _getQualifiedName((Output)node, p, ctx);
    } else if (node instanceof Refine) {
      return _getQualifiedName((Refine)node, p, ctx);
    } else if (node instanceof Typedef) {
      return _getQualifiedName((Typedef)node, p, ctx);
    } else if (node instanceof SchemaNode) {
      return _getQualifiedName((SchemaNode)node, p, ctx);
    } else if (node != null) {
      return _getQualifiedName(node, p, ctx);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(node, p, ctx).toString());
    }
  }
}

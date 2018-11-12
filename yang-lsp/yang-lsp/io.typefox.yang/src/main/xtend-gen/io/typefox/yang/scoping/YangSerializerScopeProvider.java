package io.typefox.yang.scoping;

import com.google.common.base.Function;
import com.google.common.base.Objects;
import com.google.common.collect.Iterables;
import com.google.inject.Inject;
import io.typefox.yang.scoping.IScopeContext;
import io.typefox.yang.scoping.YangScopeProvider;
import io.typefox.yang.utils.YangExtensions;
import io.typefox.yang.yang.AbstractImport;
import io.typefox.yang.yang.AbstractModule;
import io.typefox.yang.yang.Action;
import io.typefox.yang.yang.BelongsTo;
import io.typefox.yang.yang.OtherStatement;
import io.typefox.yang.yang.Revision;
import io.typefox.yang.yang.Rpc;
import io.typefox.yang.yang.SchemaNode;
import io.typefox.yang.yang.SchemaNodeIdentifier;
import io.typefox.yang.yang.Statement;
import io.typefox.yang.yang.YangPackage;
import java.util.List;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.xtend.lib.annotations.FinalFieldsConstructor;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.resource.impl.AliasedEObjectDescription;
import org.eclipse.xtext.scoping.IScope;
import org.eclipse.xtext.scoping.IScopeProvider;
import org.eclipse.xtext.scoping.Scopes;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;

@SuppressWarnings("all")
public class YangSerializerScopeProvider implements IScopeProvider {
  @FinalFieldsConstructor
  public static class NameConvertingScope implements IScope {
    private final AbstractModule module;
    
    private final IScope delegate;
    
    private final boolean allowDefaultInputOutput;
    
    @Extension
    private final YangExtensions _yangExtensions;
    
    @Override
    public Iterable<IEObjectDescription> getAllElements() {
      return this.convertNames(this.delegate.getAllElements());
    }
    
    @Override
    public Iterable<IEObjectDescription> getElements(final QualifiedName name) {
      return this.convertNames(this.delegate.getElements(name));
    }
    
    @Override
    public Iterable<IEObjectDescription> getElements(final EObject object) {
      return this.convertNames(this.delegate.getElements(object));
    }
    
    @Override
    public IEObjectDescription getSingleElement(final QualifiedName name) {
      return this.convertName(this.delegate.getSingleElement(name));
    }
    
    @Override
    public IEObjectDescription getSingleElement(final EObject object) {
      return this.convertName(this.delegate.getSingleElement(object));
    }
    
    protected Iterable<IEObjectDescription> convertNames(final Iterable<IEObjectDescription> descs) {
      final Function1<IEObjectDescription, IEObjectDescription> _function = (IEObjectDescription it) -> {
        return this.convertName(it);
      };
      return IterableExtensions.<IEObjectDescription>filterNull(ListExtensions.<IEObjectDescription, IEObjectDescription>map(IterableExtensions.<IEObjectDescription>toList(descs), _function));
    }
    
    protected IEObjectDescription convertName(final IEObjectDescription original) {
      if ((YangPackage.Literals.RPC.isSuperTypeOf(original.getEClass()) || 
        YangPackage.Literals.ACTION.isSuperTypeOf(original.getEClass()))) {
        final String lastSegment = original.getQualifiedName().getLastSegment();
        final boolean isInputOrOutput = (Objects.equal(lastSegment, "input") || Objects.equal(lastSegment, "output"));
        if ((Boolean.valueOf(this.allowDefaultInputOutput) != Boolean.valueOf(isInputOrOutput))) {
          return null;
        }
      }
      int _segmentCount = original.getQualifiedName().getSegmentCount();
      boolean _lessThan = (_segmentCount < 2);
      if (_lessThan) {
        return original;
      }
      final QualifiedName simpleName = QualifiedName.create(original.getQualifiedName().getLastSegment());
      List<String> _segments = original.getQualifiedName().getSegments();
      int _segmentCount_1 = original.getQualifiedName().getSegmentCount();
      int _minus = (_segmentCount_1 - 2);
      final String moduleName = _segments.get(_minus);
      String _name = this.module.getName();
      boolean _equals = Objects.equal(moduleName, _name);
      if (_equals) {
        return new AliasedEObjectDescription(simpleName, original);
      }
      String _name_1 = this.module.getName();
      boolean _equals_1 = Objects.equal(_name_1, moduleName);
      if (_equals_1) {
        return this.toPrefixedDescription(this._yangExtensions.getPrefix(this.module), original);
      }
      EList<Statement> _substatements = this.module.getSubstatements();
      for (final Statement sub : _substatements) {
        boolean _matched = false;
        if (sub instanceof AbstractImport) {
          String _name_2 = ((AbstractImport)sub).getModule().getName();
          boolean _equals_2 = Objects.equal(_name_2, moduleName);
          if (_equals_2) {
            _matched=true;
            return this.toPrefixedDescription(this._yangExtensions.getPrefix(((OtherStatement)sub)), original);
          }
        }
        if (!_matched) {
          if (sub instanceof BelongsTo) {
            String _name_2 = ((BelongsTo)sub).getModule().getName();
            boolean _equals_2 = Objects.equal(_name_2, moduleName);
            if (_equals_2) {
              _matched=true;
              return this.toPrefixedDescription(this._yangExtensions.getPrefix(((OtherStatement)sub)), original);
            }
          }
        }
      }
      final IEObjectDescription simpleNamedElement = this.delegate.getSingleElement(simpleName);
      if (((simpleNamedElement == null) || Objects.equal(simpleNamedElement, original))) {
        return new AliasedEObjectDescription(simpleName, original);
      }
      return null;
    }
    
    protected AliasedEObjectDescription toPrefixedDescription(final String prefix, final IEObjectDescription original) {
      QualifiedName _create = QualifiedName.create(prefix, original.getQualifiedName().getLastSegment());
      return new AliasedEObjectDescription(_create, original);
    }
    
    public NameConvertingScope(final AbstractModule module, final IScope delegate, final boolean allowDefaultInputOutput, final YangExtensions _yangExtensions) {
      super();
      this.module = module;
      this.delegate = delegate;
      this.allowDefaultInputOutput = allowDefaultInputOutput;
      this._yangExtensions = _yangExtensions;
    }
  }
  
  @Inject
  private YangScopeProvider delegate;
  
  @Inject
  @Extension
  private YangExtensions yangExtensions;
  
  @Override
  public IScope getScope(final EObject context, final EReference reference) {
    final IScope delegateScope = this.delegate.getScope(context, reference);
    boolean _isSuperTypeOf = YangPackage.Literals.SCHEMA_NODE.isSuperTypeOf(reference.getEReferenceType());
    if (_isSuperTypeOf) {
      final EObject module = IterableExtensions.<EObject>head(context.eResource().getContents());
      if ((module instanceof AbstractModule)) {
        boolean _xifexpression = false;
        if ((context instanceof SchemaNodeIdentifier)) {
          boolean _or = false;
          SchemaNodeIdentifier _target = ((SchemaNodeIdentifier)context).getTarget();
          SchemaNode _schemaNode = null;
          if (_target!=null) {
            _schemaNode=_target.getSchemaNode();
          }
          if ((_schemaNode instanceof Rpc)) {
            _or = true;
          } else {
            SchemaNodeIdentifier _target_1 = ((SchemaNodeIdentifier)context).getTarget();
            SchemaNode _schemaNode_1 = null;
            if (_target_1!=null) {
              _schemaNode_1=_target_1.getSchemaNode();
            }
            _or = (_schemaNode_1 instanceof Action);
          }
          _xifexpression = _or;
        } else {
          _xifexpression = false;
        }
        final boolean allowDefaultInputOutput = _xifexpression;
        return new YangSerializerScopeProvider.NameConvertingScope(((AbstractModule)module), delegateScope, allowDefaultInputOutput, this.yangExtensions);
      }
    }
    EClass _eReferenceType = reference.getEReferenceType();
    boolean _tripleEquals = (_eReferenceType == YangPackage.Literals.REVISION);
    if (_tripleEquals) {
      final AbstractImport import_ = EcoreUtil2.<AbstractImport>getContainerOfType(context, AbstractImport.class);
      final ResourceSet rs = context.eResource().getResourceSet();
      final IScopeContext ctx = this.delegate.findScopeInAdapters(context, reference);
      final Function1<IEObjectDescription, EObject> _function = (IEObjectDescription it) -> {
        return rs.getEObject(it.getEObjectURI(), true);
      };
      final Function1<AbstractModule, String> _function_1 = (AbstractModule it) -> {
        return it.eResource().getURI().toString();
      };
      final Function1<AbstractModule, Revision> _function_2 = (AbstractModule it) -> {
        return IterableExtensions.<Revision>head(Iterables.<Revision>filter(it.getSubstatements(), Revision.class));
      };
      final Function<Revision, QualifiedName> _function_3 = (Revision it) -> {
        return QualifiedName.create(it.getRevision());
      };
      return Scopes.<Revision>scopeFor(
        IterableExtensions.<Revision>filterNull(ListExtensions.<AbstractModule, Revision>map(IterableExtensions.<AbstractModule, String>sortBy(Iterables.<AbstractModule>filter(IterableExtensions.<IEObjectDescription, EObject>map(ctx.getModuleScope().getElements(QualifiedName.create(import_.getModule().getName())), _function), AbstractModule.class), _function_1), _function_2)), _function_3, IScope.NULLSCOPE);
    }
    return delegateScope;
  }
}

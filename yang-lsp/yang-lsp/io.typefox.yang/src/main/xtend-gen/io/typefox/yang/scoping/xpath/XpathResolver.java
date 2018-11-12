package io.typefox.yang.scoping.xpath;

import com.google.common.base.Objects;
import com.google.common.collect.Iterables;
import com.google.inject.Inject;
import io.typefox.yang.scoping.IScopeContext;
import io.typefox.yang.scoping.Linker;
import io.typefox.yang.scoping.ScopeContext;
import io.typefox.yang.scoping.ScopeContextProvider;
import io.typefox.yang.scoping.Validator;
import io.typefox.yang.scoping.xpath.NodeSetType;
import io.typefox.yang.scoping.xpath.Types;
import io.typefox.yang.scoping.xpath.XpathFunctionLibrary;
import io.typefox.yang.scoping.xpath.XpathType;
import io.typefox.yang.utils.YangExtensions;
import io.typefox.yang.validation.IssueCodes;
import io.typefox.yang.validation.LinkingErrorMessageProvider;
import io.typefox.yang.yang.AbbrevAttributeStep;
import io.typefox.yang.yang.AbsolutePath;
import io.typefox.yang.yang.Case;
import io.typefox.yang.yang.Choice;
import io.typefox.yang.yang.CurrentRef;
import io.typefox.yang.yang.Leaf;
import io.typefox.yang.yang.ParentRef;
import io.typefox.yang.yang.Path;
import io.typefox.yang.yang.ProcessingInstruction;
import io.typefox.yang.yang.RelativePath;
import io.typefox.yang.yang.Type;
import io.typefox.yang.yang.XpathAdditiveOperation;
import io.typefox.yang.yang.XpathAndOperation;
import io.typefox.yang.yang.XpathEqualityOperation;
import io.typefox.yang.yang.XpathExpression;
import io.typefox.yang.yang.XpathFilter;
import io.typefox.yang.yang.XpathFunctionCall;
import io.typefox.yang.yang.XpathLocation;
import io.typefox.yang.yang.XpathMultiplicativeOperation;
import io.typefox.yang.yang.XpathNodeTest;
import io.typefox.yang.yang.XpathNodeType;
import io.typefox.yang.yang.XpathNumberLiteral;
import io.typefox.yang.yang.XpathOrOperation;
import io.typefox.yang.yang.XpathRelationalOperation;
import io.typefox.yang.yang.XpathStep;
import io.typefox.yang.yang.XpathStringLiteral;
import io.typefox.yang.yang.XpathUnaryOperation;
import io.typefox.yang.yang.XpathUnionOperation;
import io.typefox.yang.yang.XpathVariableReference;
import io.typefox.yang.yang.YangPackage;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;
import org.apache.log4j.Logger;
import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtend.lib.annotations.Data;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.util.internal.EmfAdaptable;
import org.eclipse.xtext.util.internal.Log;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.Pure;
import org.eclipse.xtext.xbase.lib.util.ToStringBuilder;

@Log
@SuppressWarnings("all")
public class XpathResolver {
  @Data
  public static class Context {
    private final ScopeContext.MapScope nodeScope;
    
    private final String moduleName;
    
    private final XpathType initial;
    
    public Context(final ScopeContext.MapScope nodeScope, final String moduleName, final XpathType initial) {
      super();
      this.nodeScope = nodeScope;
      this.moduleName = moduleName;
      this.initial = initial;
    }
    
    @Override
    @Pure
    public int hashCode() {
      final int prime = 31;
      int result = 1;
      result = prime * result + ((this.nodeScope== null) ? 0 : this.nodeScope.hashCode());
      result = prime * result + ((this.moduleName== null) ? 0 : this.moduleName.hashCode());
      return prime * result + ((this.initial== null) ? 0 : this.initial.hashCode());
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
      XpathResolver.Context other = (XpathResolver.Context) obj;
      if (this.nodeScope == null) {
        if (other.nodeScope != null)
          return false;
      } else if (!this.nodeScope.equals(other.nodeScope))
        return false;
      if (this.moduleName == null) {
        if (other.moduleName != null)
          return false;
      } else if (!this.moduleName.equals(other.moduleName))
        return false;
      if (this.initial == null) {
        if (other.initial != null)
          return false;
      } else if (!this.initial.equals(other.initial))
        return false;
      return true;
    }
    
    @Override
    @Pure
    public String toString() {
      ToStringBuilder b = new ToStringBuilder(this);
      b.add("nodeScope", this.nodeScope);
      b.add("moduleName", this.moduleName);
      b.add("initial", this.initial);
      return b.toString();
    }
    
    @Pure
    public ScopeContext.MapScope getNodeScope() {
      return this.nodeScope;
    }
    
    @Pure
    public String getModuleName() {
      return this.moduleName;
    }
    
    @Pure
    public XpathType getInitial() {
      return this.initial;
    }
  }
  
  @EmfAdaptable
  @Data
  public static class TypeAdapter {
    public static class TypeAdapterAdapter extends AdapterImpl {
      private XpathResolver.TypeAdapter element;
      
      public TypeAdapterAdapter(final XpathResolver.TypeAdapter element) {
        this.element = element;
      }
      
      public XpathResolver.TypeAdapter get() {
        return this.element;
      }
      
      @Override
      public boolean isAdapterForType(final Object object) {
        return object == XpathResolver.TypeAdapter.class;
      }
    }
    
    private final XpathType type;
    
    public TypeAdapter(final XpathType type) {
      super();
      this.type = type;
    }
    
    @Override
    @Pure
    public int hashCode() {
      return 31 * 1 + ((this.type== null) ? 0 : this.type.hashCode());
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
      XpathResolver.TypeAdapter other = (XpathResolver.TypeAdapter) obj;
      if (this.type == null) {
        if (other.type != null)
          return false;
      } else if (!this.type.equals(other.type))
        return false;
      return true;
    }
    
    @Override
    @Pure
    public String toString() {
      ToStringBuilder b = new ToStringBuilder(this);
      b.add("type", this.type);
      return b.toString();
    }
    
    @Pure
    public XpathType getType() {
      return this.type;
    }
    
    public static XpathResolver.TypeAdapter findInEmfObject(final Notifier emfObject) {
      for (Adapter adapter : emfObject.eAdapters()) {
      	if (adapter instanceof XpathResolver.TypeAdapter.TypeAdapterAdapter) {
      		return ((XpathResolver.TypeAdapter.TypeAdapterAdapter) adapter).get();
      	}
      }
      return null;
    }
    
    public static XpathResolver.TypeAdapter removeFromEmfObject(final Notifier emfObject) {
      List<Adapter> adapters = emfObject.eAdapters();
      for(int i = 0, max = adapters.size(); i < max; i++) {
      	Adapter adapter = adapters.get(i);
      	if (adapter instanceof XpathResolver.TypeAdapter.TypeAdapterAdapter) {
      		emfObject.eAdapters().remove(i);
      		return ((XpathResolver.TypeAdapter.TypeAdapterAdapter) adapter).get();
      	}
      }
      return null;
    }
    
    public void attachToEmfObject(final Notifier emfObject) {
      TypeAdapter result = findInEmfObject(emfObject);
      if (result != null)
      	throw new IllegalStateException("The given EMF object already contains an adapter for TypeAdapter");
      XpathResolver.TypeAdapter.TypeAdapterAdapter adapter = new XpathResolver.TypeAdapter.TypeAdapterAdapter(this);
      emfObject.eAdapters().add(adapter);
    }
  }
  
  public enum Axis {
    CHILDREN,
    
    PARENT,
    
    SIBLINGS,
    
    ANCESTOR,
    
    ANCESTOR_OR_SELF,
    
    DESCENDANTS,
    
    DESCENDANTS_OR_SELF;
  }
  
  @Inject
  private Validator validator;
  
  @Inject
  private Linker linker;
  
  @Inject
  private ScopeContextProvider scopeContextProvider;
  
  @Inject
  @Extension
  private YangExtensions _yangExtensions;
  
  private static final QualifiedName ASTERISK = QualifiedName.create("*");
  
  public XpathType getType(final XpathExpression expr) {
    XpathResolver.TypeAdapter _findInEmfObject = XpathResolver.TypeAdapter.findInEmfObject(expr);
    XpathType _type = null;
    if (_findInEmfObject!=null) {
      _type=_findInEmfObject.type;
    }
    return _type;
  }
  
  private XpathType install(final XpathType type, final EObject obj) {
    XpathResolver.TypeAdapter _findInEmfObject = XpathResolver.TypeAdapter.findInEmfObject(obj);
    boolean _tripleNotEquals = (_findInEmfObject != null);
    if (_tripleNotEquals) {
      return type;
    }
    new XpathResolver.TypeAdapter(type).attachToEmfObject(obj);
    return type;
  }
  
  public XpathType doResolve(final XpathExpression expression, final QualifiedName contextNode, final IScopeContext context) {
    XpathType _xblockexpression = null;
    {
      final IEObjectDescription element = context.getSchemaNodeScope().getSingleElement(contextNode);
      final NodeSetType initialContext = Types.nodeSet(element);
      ScopeContext.MapScope _schemaNodeScope = context.getSchemaNodeScope();
      String _moduleName = context.getModuleName();
      XpathResolver.Context _context = new XpathResolver.Context(_schemaNodeScope, _moduleName, initialContext);
      _xblockexpression = this.internalResolve(expression, initialContext, _context);
    }
    return _xblockexpression;
  }
  
  protected XpathType _internalResolve(final Void e, final XpathType contextType, final XpathResolver.Context ctx) {
    return contextType;
  }
  
  protected XpathType _internalResolve(final XpathExpression e, final XpathType contextType, final XpathResolver.Context ctx) {
    throw new IllegalStateException();
  }
  
  protected XpathType _internalResolve(final XpathOrOperation e, final XpathType contextType, final XpathResolver.Context ctx) {
    this.internalResolve(e.getLeft(), contextType, ctx);
    this.internalResolve(e.getRight(), contextType, ctx);
    return this.install(Types.BOOLEAN, e);
  }
  
  protected XpathType _internalResolve(final XpathAndOperation e, final XpathType contextType, final XpathResolver.Context ctx) {
    this.internalResolve(e.getLeft(), contextType, ctx);
    this.internalResolve(e.getRight(), contextType, ctx);
    return this.install(Types.BOOLEAN, e);
  }
  
  protected XpathType _internalResolve(final XpathEqualityOperation e, final XpathType contextType, final XpathResolver.Context ctx) {
    this.internalResolve(e.getLeft(), contextType, ctx);
    this.internalResolve(e.getRight(), contextType, ctx);
    return this.install(Types.BOOLEAN, e);
  }
  
  protected XpathType _internalResolve(final XpathRelationalOperation e, final XpathType contextType, final XpathResolver.Context ctx) {
    this.internalResolve(e.getLeft(), contextType, ctx);
    this.internalResolve(e.getRight(), contextType, ctx);
    return this.install(Types.BOOLEAN, e);
  }
  
  protected XpathType _internalResolve(final XpathAdditiveOperation e, final XpathType contextType, final XpathResolver.Context ctx) {
    this.internalResolve(e.getLeft(), contextType, ctx);
    this.internalResolve(e.getRight(), contextType, ctx);
    return this.install(Types.NUMBER, e);
  }
  
  protected XpathType _internalResolve(final XpathMultiplicativeOperation e, final XpathType contextType, final XpathResolver.Context ctx) {
    this.internalResolve(e.getLeft(), contextType, ctx);
    this.internalResolve(e.getRight(), contextType, ctx);
    return this.install(Types.NUMBER, e);
  }
  
  protected XpathType _internalResolve(final XpathUnaryOperation e, final XpathType contextType, final XpathResolver.Context ctx) {
    this.internalResolve(e.getTarget(), contextType, ctx);
    return this.install(Types.NUMBER, e);
  }
  
  protected XpathType _internalResolve(final XpathUnionOperation e, final XpathType contextType, final XpathResolver.Context ctx) {
    XpathType left = this.internalResolve(e.getLeft(), contextType, ctx);
    XpathType right = this.internalResolve(e.getRight(), contextType, ctx);
    if (((!(left instanceof NodeSetType)) && (left != Types.ANY))) {
      this.validator.addIssue(e.getLeft(), null, "The operands of a union operation must return a node set.", IssueCodes.INVALID_TYPE);
    }
    if (((!(right instanceof NodeSetType)) && (left != Types.ANY))) {
      this.validator.addIssue(e.getRight(), null, "The operands of a union operation must return a node set.", IssueCodes.INVALID_TYPE);
    }
    return this.install(Types.union(left, right), e);
  }
  
  protected XpathType _internalResolve(final XpathLocation e, final XpathType contextType, final XpathResolver.Context ctx) {
    XpathType newContext = this.internalResolve(e.getTarget(), contextType, ctx);
    return this.install(this.internalResolveStep(e.getStep(), newContext, ctx), e);
  }
  
  protected XpathType _internalResolve(final XpathFilter e, final XpathType contextType, final XpathResolver.Context ctx) {
    XpathType newContext = this.internalResolve(e.getTarget(), contextType, ctx);
    XpathExpression _predicate = e.getPredicate();
    boolean _tripleNotEquals = (_predicate != null);
    if (_tripleNotEquals) {
      this.internalResolve(e.getPredicate(), newContext, ctx);
    }
    return this.install(newContext, e);
  }
  
  protected XpathType _internalResolve(final XpathVariableReference e, final XpathType contextType, final XpathResolver.Context ctx) {
    String _name = e.getName();
    String _plus = ("Unknown variable \'" + _name);
    String _plus_1 = (_plus + "\'.");
    this.validator.addIssue(e, YangPackage.Literals.XPATH_VARIABLE_REFERENCE__NAME, _plus_1, IssueCodes.UNKNOWN_VARIABLE);
    return this.install(Types.ANY, e);
  }
  
  protected XpathType _internalResolve(final XpathStringLiteral e, final XpathType contextType, final XpathResolver.Context ctx) {
    return this.install(Types.STRING, e);
  }
  
  protected XpathType _internalResolve(final XpathNumberLiteral e, final XpathType contextType, final XpathResolver.Context ctx) {
    return this.install(Types.NUMBER, e);
  }
  
  protected XpathType _internalResolve(final XpathFunctionCall e, final XpathType contextType, final XpathResolver.Context ctx) {
    final XpathFunctionLibrary.Function f = XpathFunctionLibrary.FUNCTIONS.get(e.getName());
    if ((f == null)) {
      String _name = e.getName();
      String _plus = ("Unkown function \'" + _name);
      String _plus_1 = (_plus + "()\'.");
      this.validator.addIssue(e, YangPackage.Literals.XPATH_FUNCTION_CALL__NAME, _plus_1, IssueCodes.UNKNOWN_FUNCTION);
      EList<XpathExpression> _args = e.getArgs();
      for (final XpathExpression arg : _args) {
        this.internalResolve(arg, contextType, ctx);
      }
      return this.install(Types.ANY, e);
    }
    String _name_1 = f.getName();
    boolean _equals = Objects.equal(_name_1, "current");
    if (_equals) {
      return this.install(ctx.initial, e);
    }
    String _name_2 = f.getName();
    boolean _equals_1 = Objects.equal(_name_2, "deref");
    if (_equals_1) {
      final XpathType type = this.internalResolve(IterableExtensions.<XpathExpression>head(e.getArgs()), contextType, ctx);
      if ((type instanceof NodeSetType)) {
        final IEObjectDescription desc = IterableExtensions.<IEObjectDescription>head(((NodeSetType)type).getNodes());
        if ((desc != null)) {
          EObject _eObjectOrProxy = desc.getEObjectOrProxy();
          if ((_eObjectOrProxy instanceof Leaf)) {
            EObject _eObjectOrProxy_1 = desc.getEObjectOrProxy();
            final Leaf l = ((Leaf) _eObjectOrProxy_1);
            final Type leafType = IterableExtensions.<Type>head(Iterables.<Type>filter(l.getSubstatements(), Type.class));
            String _builtin = leafType.getTypeRef().getBuiltin();
            boolean _equals_2 = Objects.equal(_builtin, "leafref");
            if (_equals_2) {
              final XpathExpression reference = IterableExtensions.<Path>head(Iterables.<Path>filter(leafType.getSubstatements(), Path.class)).getReference();
              return this.install(this.internalResolve(reference, Types.nodeSet(desc), ctx), e);
            }
          }
        }
      }
      return this.install(Types.nodeSet(Collections.<IEObjectDescription>unmodifiableList(CollectionLiterals.<IEObjectDescription>newArrayList(Linker.ROOT))), e);
    }
    EList<XpathExpression> _args_1 = e.getArgs();
    for (final XpathExpression arg_1 : _args_1) {
      this.internalResolve(arg_1, contextType, ctx);
    }
    XpathType _switchResult = null;
    XpathFunctionLibrary.Type _returnType = f.getReturnType();
    if (_returnType != null) {
      switch (_returnType) {
        case BOOLEAN:
          _switchResult = Types.BOOLEAN;
          break;
        case NUMBER:
          _switchResult = Types.NUMBER;
          break;
        case STRING:
          _switchResult = Types.STRING;
          break;
        default:
          _switchResult = Types.ANY;
          break;
      }
    } else {
      _switchResult = Types.ANY;
    }
    return this.install(_switchResult, e);
  }
  
  protected void checkArity(final XpathFunctionCall e, final int min, final int max) {
    final Function1<Integer, CharSequence> _function = (Integer it) -> {
      StringConcatenation _builder = new StringConcatenation();
      {
        if ((it == Integer.valueOf(0))) {
          _builder.append("no arguments");
        } else {
          if ((it == Integer.valueOf(1))) {
            _builder.append("one argument");
          } else {
            _builder.append(it);
            _builder.append(" arguements");
          }
        }
      }
      return _builder;
    };
    final Function1<Integer, CharSequence> fun = _function;
    int _size = e.getArgs().size();
    boolean _lessThan = (_size < min);
    if (_lessThan) {
      String _name = e.getName();
      String _plus = ("The function \'" + _name);
      String _plus_1 = (_plus + "\' needs at least ");
      CharSequence _apply = fun.apply(Integer.valueOf(min));
      String _plus_2 = (_plus_1 + _apply);
      String _plus_3 = (_plus_2 + ".");
      this.validator.addIssue(e, null, _plus_3, IssueCodes.FUNCTION_ARITY);
    }
    int _size_1 = e.getArgs().size();
    boolean _greaterThan = (_size_1 > max);
    if (_greaterThan) {
      String _name_1 = e.getName();
      String _plus_4 = ("The function \'" + _name_1);
      String _plus_5 = (_plus_4 + "\' can at most have ");
      CharSequence _apply_1 = fun.apply(Integer.valueOf(min));
      String _plus_6 = (_plus_5 + _apply_1);
      String _plus_7 = (_plus_6 + ".");
      this.validator.addIssue(e, null, _plus_7, IssueCodes.FUNCTION_ARITY);
    }
  }
  
  protected XpathType _internalResolve(final RelativePath e, final XpathType contextType, final XpathResolver.Context ctx) {
    return this.install(this.internalResolveStep(e.getStep(), contextType, ctx), e);
  }
  
  protected XpathType _internalResolve(final AbsolutePath e, final XpathType contextType, final XpathResolver.Context ctx) {
    XpathStep _step = e.getStep();
    boolean _tripleEquals = (_step == null);
    if (_tripleEquals) {
      return this.install(Types.nodeSet(Collections.<IEObjectDescription>unmodifiableList(CollectionLiterals.<IEObjectDescription>newArrayList(Linker.ROOT))), e);
    }
    return this.install(this.internalResolveStep(e.getStep(), Types.nodeSet(Collections.<IEObjectDescription>unmodifiableList(CollectionLiterals.<IEObjectDescription>newArrayList(Linker.ROOT))), ctx), e);
  }
  
  protected XpathType _internalResolveStep(final Void e, final XpathType contextType, final XpathResolver.Context ctx) {
    return contextType;
  }
  
  protected XpathType _internalResolveStep(final CurrentRef e, final XpathType contextType, final XpathResolver.Context ctx) {
    final Function1<QualifiedName, IEObjectDescription> _function = (QualifiedName it) -> {
      return this.getEObjectDescription(contextType);
    };
    this.linker.<Object>link(e, YangPackage.Literals.CURRENT_REF__REF, _function);
    return contextType;
  }
  
  protected XpathType _internalResolveStep(final ParentRef e, final XpathType contextType, final XpathResolver.Context ctx) {
    boolean _equals = Objects.equal(contextType, Types.ANY);
    if (_equals) {
      LinkingErrorMessageProvider.markOK(e);
      return contextType;
    }
    final XpathType type = this.computeType(contextType, null, XpathResolver.Axis.PARENT, ctx);
    final Function1<QualifiedName, IEObjectDescription> _function = (QualifiedName it) -> {
      return this.getEObjectDescription(type);
    };
    this.linker.<Object>link(e, YangPackage.Literals.PARENT_REF__REF, _function);
    return type;
  }
  
  protected XpathType _internalResolveStep(final AbbrevAttributeStep e, final XpathType contextType, final XpathResolver.Context ctx) {
    return Types.STRING;
  }
  
  protected XpathType _internalResolveStep(final XpathStep e, final XpathType contextType, final XpathResolver.Context ctx) {
    String _axis = e.getAxis();
    boolean _equals = Objects.equal(_axis, "attribute");
    if (_equals) {
      LinkingErrorMessageProvider.markOK(e.getNode());
      return Types.STRING;
    }
    String _axis_1 = e.getAxis();
    boolean _equals_1 = Objects.equal(_axis_1, "namespace");
    if (_equals_1) {
      LinkingErrorMessageProvider.markOK(e.getNode());
      return Types.STRING;
    }
    if ((((e.getNode() instanceof XpathNodeType) && (!Objects.equal(((XpathNodeType) e.getNode()).getName(), "node"))) || (e.getNode() instanceof ProcessingInstruction))) {
      return Types.BOOLEAN;
    }
    String _axis_2 = e.getAxis();
    boolean _equals_2 = Objects.equal(_axis_2, "self");
    if (_equals_2) {
      if ((contextType == Types.ANY)) {
        LinkingErrorMessageProvider.markOK(e.getNode());
        return contextType;
      }
      if ((contextType instanceof NodeSetType)) {
        XpathNodeTest _node = e.getNode();
        boolean _not = (!(_node instanceof XpathNodeType));
        if (_not) {
          final AtomicReference<XpathType> ref = new AtomicReference<XpathType>();
          final Function1<QualifiedName, IEObjectDescription> _function = (QualifiedName it) -> {
            String _lastSegment = it.getLastSegment();
            boolean _equals_3 = Objects.equal(_lastSegment, "*");
            if (_equals_3) {
              ref.set(contextType);
              return this.getEObjectDescription(contextType);
            } else {
              final Function1<IEObjectDescription, Boolean> _function_1 = (IEObjectDescription it_1) -> {
                String _lastSegment_1 = it_1.getQualifiedName().getLastSegment();
                String _lastSegment_2 = it_1.getQualifiedName().getLastSegment();
                return Boolean.valueOf(Objects.equal(_lastSegment_1, _lastSegment_2));
              };
              final List<IEObjectDescription> descs = IterableExtensions.<IEObjectDescription>toList(IterableExtensions.<IEObjectDescription>filter(((NodeSetType)contextType).getNodes(), _function_1));
              boolean _isEmpty = descs.isEmpty();
              boolean _not_1 = (!_isEmpty);
              if (_not_1) {
                final NodeSetType newType = Types.nodeSet(descs);
                ref.set(newType);
                return this.getEObjectDescription(newType);
              } else {
                return null;
              }
            }
          };
          this.linker.<Object>link(e.getNode(), YangPackage.Literals.XPATH_NAME_TEST__REF, _function);
          return ref.get();
        }
      }
      return contextType;
    }
    XpathResolver.Axis _switchResult = null;
    String _axis_3 = e.getAxis();
    if (_axis_3 != null) {
      switch (_axis_3) {
        case "ancestor":
          _switchResult = XpathResolver.Axis.ANCESTOR;
          break;
        case "ancestor-or-self":
          _switchResult = XpathResolver.Axis.ANCESTOR_OR_SELF;
          break;
        case "child":
          _switchResult = XpathResolver.Axis.CHILDREN;
          break;
        case "descendant":
          _switchResult = XpathResolver.Axis.DESCENDANTS;
          break;
        case "descendant-or-self":
          _switchResult = XpathResolver.Axis.DESCENDANTS_OR_SELF;
          break;
        case "following":
          _switchResult = XpathResolver.Axis.ANCESTOR_OR_SELF;
          break;
        case "preceding":
          _switchResult = XpathResolver.Axis.DESCENDANTS_OR_SELF;
          break;
        case "following-sibling":
          _switchResult = XpathResolver.Axis.SIBLINGS;
          break;
        case "preceding-sibling":
          _switchResult = XpathResolver.Axis.SIBLINGS;
          break;
        case "parent":
          _switchResult = XpathResolver.Axis.PARENT;
          break;
        default:
          _switchResult = XpathResolver.Axis.CHILDREN;
          break;
      }
    } else {
      _switchResult = XpathResolver.Axis.CHILDREN;
    }
    XpathResolver.Axis tempMode = _switchResult;
    XpathResolver.Axis _switchResult_1 = null;
    EObject _eContainer = e.eContainer();
    final EObject c = _eContainer;
    boolean _matched = false;
    if (c instanceof AbsolutePath) {
      boolean _isIsDescendants = ((AbsolutePath)c).isIsDescendants();
      if (_isIsDescendants) {
        _matched=true;
        _switchResult_1 = XpathResolver.Axis.DESCENDANTS_OR_SELF;
      }
    }
    if (!_matched) {
      if (c instanceof XpathLocation) {
        boolean _isIsDescendants = ((XpathLocation)c).isIsDescendants();
        if (_isIsDescendants) {
          _matched=true;
          _switchResult_1 = XpathResolver.Axis.DESCENDANTS_OR_SELF;
        }
      }
    }
    if (!_matched) {
      _switchResult_1 = tempMode;
    }
    final XpathResolver.Axis mode = _switchResult_1;
    XpathNodeTest _node_1 = e.getNode();
    if ((_node_1 instanceof XpathNodeType)) {
      return this.computeType(contextType, XpathResolver.ASTERISK, mode, ctx);
    }
    if ((contextType == Types.ANY)) {
      XpathNodeTest _node_2 = e.getNode();
      boolean _tripleNotEquals = (_node_2 != null);
      if (_tripleNotEquals) {
        LinkingErrorMessageProvider.markOK(e.getNode());
      }
      return contextType;
    }
    XpathNodeTest _node_3 = e.getNode();
    boolean _tripleEquals = (_node_3 == null);
    if (_tripleEquals) {
      return Types.ANY;
    }
    final AtomicReference<XpathType> ref_1 = new AtomicReference<XpathType>();
    final Function1<QualifiedName, IEObjectDescription> _function_1 = (QualifiedName it) -> {
      final XpathType type = this.computeType(contextType, this.resolveModulePrefix(it, e), mode, ctx);
      ref_1.set(type);
      return this.getEObjectDescription(type);
    };
    this.linker.<Object>link(e.getNode(), YangPackage.Literals.XPATH_NAME_TEST__REF, _function_1);
    XpathType _elvis = null;
    XpathType _get = ref_1.get();
    if (_get != null) {
      _elvis = _get;
    } else {
      _elvis = Types.ANY;
    }
    return _elvis;
  }
  
  private QualifiedName resolveModulePrefix(final QualifiedName linkName, final EObject element) {
    int _segmentCount = linkName.getSegmentCount();
    boolean _greaterThan = (_segmentCount > 1);
    if (_greaterThan) {
      final IScopeContext scopeContext = this.scopeContextProvider.findScopeContext(element);
      if ((scopeContext != null)) {
        String _elvis = null;
        IScopeContext _get = scopeContext.getImportedModules().get(linkName.getFirstSegment());
        String _moduleName = null;
        if (_get!=null) {
          _moduleName=_get.getModuleName();
        }
        if (_moduleName != null) {
          _elvis = _moduleName;
        } else {
          String _xifexpression = null;
          String _firstSegment = linkName.getFirstSegment();
          io.typefox.yang.yang.Module _mainModule = null;
          if (element!=null) {
            _mainModule=this._yangExtensions.getMainModule(element);
          }
          String _prefix = null;
          if (_mainModule!=null) {
            _prefix=this._yangExtensions.getPrefix(_mainModule);
          }
          boolean _equals = Objects.equal(_firstSegment, _prefix);
          if (_equals) {
            _xifexpression = scopeContext.getModuleName();
          }
          _elvis = _xifexpression;
        }
        final String moduleName = _elvis;
        if ((moduleName != null)) {
          return QualifiedName.create(moduleName).append(linkName.skipFirst(1));
        }
      }
    }
    return linkName;
  }
  
  protected XpathType computeType(final XpathType type, final QualifiedName name, final XpathResolver.Axis mode, final XpathResolver.Context ctx) {
    if ((type instanceof NodeSetType)) {
      boolean _isEmpty = ((NodeSetType)type).getNodes().isEmpty();
      if (_isEmpty) {
        final List<IEObjectDescription> nodes = this.findNodes(QualifiedName.EMPTY, name, mode, ctx.nodeScope);
        boolean _isEmpty_1 = nodes.isEmpty();
        if (_isEmpty_1) {
          return Types.ANY;
        }
        return Types.nodeSet(nodes);
      }
      final ArrayList<IEObjectDescription> result = CollectionLiterals.<IEObjectDescription>newArrayList();
      List<IEObjectDescription> _nodes = ((NodeSetType)type).getNodes();
      for (final IEObjectDescription n : _nodes) {
        {
          final List<IEObjectDescription> nodes_1 = this.findNodes(n.getQualifiedName(), name, mode, ctx.nodeScope);
          result.addAll(nodes_1);
        }
      }
      boolean _isEmpty_2 = result.isEmpty();
      boolean _not = (!_isEmpty_2);
      if (_not) {
        return Types.nodeSet(result);
      }
    }
    return Types.ANY;
  }
  
  private QualifiedName skipLast(final QualifiedName it) {
    int _segmentCount = it.getSegmentCount();
    boolean _lessThan = (_segmentCount < 2);
    if (_lessThan) {
      return QualifiedName.EMPTY;
    } else {
      return it.skipLast(2);
    }
  }
  
  public List<IEObjectDescription> findNodes(final QualifiedName prefix, final QualifiedName name, final XpathResolver.Axis mode, final ScopeContext.MapScope nodeScope) {
    if ((mode == XpathResolver.Axis.SIBLINGS)) {
      return this.findNodes(this.skipLast(prefix), name, XpathResolver.Axis.CHILDREN, nodeScope);
    } else {
      if ((mode == XpathResolver.Axis.DESCENDANTS_OR_SELF)) {
        return this.findNodes(this.skipLast(prefix), name, XpathResolver.Axis.DESCENDANTS, nodeScope);
      } else {
        boolean _equals = Objects.equal(mode, XpathResolver.Axis.ANCESTOR);
        if (_equals) {
          return this.findNodes(this.skipLast(prefix), name, XpathResolver.Axis.ANCESTOR_OR_SELF, nodeScope);
        } else {
          boolean _equals_1 = Objects.equal(mode, XpathResolver.Axis.ANCESTOR_OR_SELF);
          if (_equals_1) {
            final ArrayList<IEObjectDescription> result = CollectionLiterals.<IEObjectDescription>newArrayList();
            QualifiedName parent = prefix;
            while ((parent.getSegmentCount() >= 2)) {
              {
                if ((((name == null) || Objects.equal(name, XpathResolver.ASTERISK)) || this.endsWith(parent, name))) {
                  final IEObjectDescription p = nodeScope.getSingleElement(parent);
                  if (((p != null) && this.isInstanceNode(p))) {
                    result.add(p);
                  }
                }
                parent = this.skipLast(parent);
              }
            }
            return result;
          } else {
            boolean _equals_2 = Objects.equal(mode, XpathResolver.Axis.PARENT);
            if (_equals_2) {
              QualifiedName parent_1 = prefix;
              while ((parent_1.getSegmentCount() >= 2)) {
                {
                  parent_1 = this.skipLast(parent_1);
                  final IEObjectDescription p = nodeScope.getSingleElement(parent_1);
                  if ((p != null)) {
                    boolean _isInstanceNode = this.isInstanceNode(p);
                    if (_isInstanceNode) {
                      return Collections.<IEObjectDescription>unmodifiableList(CollectionLiterals.<IEObjectDescription>newArrayList(p));
                    }
                  } else {
                    return Collections.<IEObjectDescription>unmodifiableList(CollectionLiterals.<IEObjectDescription>newArrayList(Linker.ROOT));
                  }
                }
              }
              return Collections.<IEObjectDescription>unmodifiableList(CollectionLiterals.<IEObjectDescription>newArrayList(Linker.ROOT));
            } else {
              final Function1<IEObjectDescription, Boolean> _function = (IEObjectDescription it) -> {
                if ((it.getQualifiedName().startsWith(prefix) && (it.getQualifiedName().getSegmentCount() > prefix.getSegmentCount()))) {
                  if ((((name == null) || Objects.equal(name, XpathResolver.ASTERISK)) || this.endsWith(it.getQualifiedName(), name))) {
                    if ((mode == XpathResolver.Axis.DESCENDANTS)) {
                      return Boolean.valueOf(true);
                    } else {
                      QualifiedName parent_2 = this.skipLast(it.getQualifiedName());
                      while ((parent_2.getSegmentCount() > prefix.getSegmentCount())) {
                        {
                          final IEObjectDescription p = nodeScope.getSingleElement(parent_2);
                          if (((p != null) && this.isInstanceNode(p))) {
                            return Boolean.valueOf(false);
                          }
                          parent_2 = this.skipLast(parent_2);
                        }
                      }
                      return Boolean.valueOf(true);
                    }
                  }
                }
                return Boolean.valueOf(false);
              };
              final List<IEObjectDescription> elements = IterableExtensions.<IEObjectDescription>toList(IterableExtensions.<IEObjectDescription>filter(nodeScope.getAllElements(), _function));
              return elements;
            }
          }
        }
      }
    }
  }
  
  private boolean endsWith(final QualifiedName parent, final QualifiedName child) {
    int _segmentCount = parent.getSegmentCount();
    int _segmentCount_1 = child.getSegmentCount();
    final int offset = (_segmentCount - _segmentCount_1);
    if ((offset >= 0)) {
      QualifiedName _skipFirst = parent.skipFirst(offset);
      return Objects.equal(_skipFirst, child);
    } else {
      return false;
    }
  }
  
  protected boolean isInstanceNode(final IEObjectDescription description) {
    boolean _switchResult = false;
    EObject _eObjectOrProxy = description.getEObjectOrProxy();
    boolean _matched = false;
    if (_eObjectOrProxy instanceof Choice) {
      _matched=true;
    }
    if (!_matched) {
      if (_eObjectOrProxy instanceof Case) {
        _matched=true;
      }
    }
    if (_matched) {
      _switchResult = false;
    }
    if (!_matched) {
      _switchResult = true;
    }
    return _switchResult;
  }
  
  protected IEObjectDescription getEObjectDescription(final XpathType type) {
    if ((type instanceof NodeSetType)) {
      return IterableExtensions.<IEObjectDescription>head(((NodeSetType)type).getNodes());
    }
    return null;
  }
  
  protected XpathType internalResolve(final XpathExpression e, final XpathType contextType, final XpathResolver.Context ctx) {
    if (e instanceof AbsolutePath) {
      return _internalResolve((AbsolutePath)e, contextType, ctx);
    } else if (e instanceof RelativePath) {
      return _internalResolve((RelativePath)e, contextType, ctx);
    } else if (e instanceof XpathAdditiveOperation) {
      return _internalResolve((XpathAdditiveOperation)e, contextType, ctx);
    } else if (e instanceof XpathAndOperation) {
      return _internalResolve((XpathAndOperation)e, contextType, ctx);
    } else if (e instanceof XpathEqualityOperation) {
      return _internalResolve((XpathEqualityOperation)e, contextType, ctx);
    } else if (e instanceof XpathFilter) {
      return _internalResolve((XpathFilter)e, contextType, ctx);
    } else if (e instanceof XpathFunctionCall) {
      return _internalResolve((XpathFunctionCall)e, contextType, ctx);
    } else if (e instanceof XpathLocation) {
      return _internalResolve((XpathLocation)e, contextType, ctx);
    } else if (e instanceof XpathMultiplicativeOperation) {
      return _internalResolve((XpathMultiplicativeOperation)e, contextType, ctx);
    } else if (e instanceof XpathNumberLiteral) {
      return _internalResolve((XpathNumberLiteral)e, contextType, ctx);
    } else if (e instanceof XpathOrOperation) {
      return _internalResolve((XpathOrOperation)e, contextType, ctx);
    } else if (e instanceof XpathRelationalOperation) {
      return _internalResolve((XpathRelationalOperation)e, contextType, ctx);
    } else if (e instanceof XpathStringLiteral) {
      return _internalResolve((XpathStringLiteral)e, contextType, ctx);
    } else if (e instanceof XpathUnaryOperation) {
      return _internalResolve((XpathUnaryOperation)e, contextType, ctx);
    } else if (e instanceof XpathUnionOperation) {
      return _internalResolve((XpathUnionOperation)e, contextType, ctx);
    } else if (e instanceof XpathVariableReference) {
      return _internalResolve((XpathVariableReference)e, contextType, ctx);
    } else if (e != null) {
      return _internalResolve(e, contextType, ctx);
    } else if (e == null) {
      return _internalResolve((Void)null, contextType, ctx);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(e, contextType, ctx).toString());
    }
  }
  
  protected XpathType internalResolveStep(final XpathStep e, final XpathType contextType, final XpathResolver.Context ctx) {
    if (e instanceof AbbrevAttributeStep) {
      return _internalResolveStep((AbbrevAttributeStep)e, contextType, ctx);
    } else if (e instanceof CurrentRef) {
      return _internalResolveStep((CurrentRef)e, contextType, ctx);
    } else if (e instanceof ParentRef) {
      return _internalResolveStep((ParentRef)e, contextType, ctx);
    } else if (e != null) {
      return _internalResolveStep(e, contextType, ctx);
    } else if (e == null) {
      return _internalResolveStep((Void)null, contextType, ctx);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(e, contextType, ctx).toString());
    }
  }
  
  private static final Logger LOG = Logger.getLogger(XpathResolver.class);
}

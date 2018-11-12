package io.typefox.yang.ide.completion;

import com.google.common.base.Objects;
import com.google.common.base.Predicate;
import com.google.common.collect.Iterables;
import com.google.common.collect.Iterators;
import com.google.inject.Inject;
import io.typefox.yang.documentation.DocumentationProvider;
import io.typefox.yang.scoping.IScopeContext;
import io.typefox.yang.scoping.Linker;
import io.typefox.yang.scoping.ScopeContext;
import io.typefox.yang.scoping.ScopeContextProvider;
import io.typefox.yang.scoping.xpath.NodeSetType;
import io.typefox.yang.scoping.xpath.XpathFunctionLibrary;
import io.typefox.yang.scoping.xpath.XpathResolver;
import io.typefox.yang.scoping.xpath.XpathType;
import io.typefox.yang.services.YangGrammarAccess;
import io.typefox.yang.utils.YangNameUtils;
import io.typefox.yang.validation.SubstatementGroup;
import io.typefox.yang.validation.SubstatementRuleProvider;
import io.typefox.yang.yang.AbsolutePath;
import io.typefox.yang.yang.AbstractImport;
import io.typefox.yang.yang.AbstractModule;
import io.typefox.yang.yang.Description;
import io.typefox.yang.yang.Prefix;
import io.typefox.yang.yang.Revision;
import io.typefox.yang.yang.SchemaNode;
import io.typefox.yang.yang.SchemaNodeIdentifier;
import io.typefox.yang.yang.Statement;
import io.typefox.yang.yang.XpathExpression;
import io.typefox.yang.yang.XpathLocation;
import io.typefox.yang.yang.XpathStep;
import io.typefox.yang.yang.YangPackage;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.AbstractElement;
import org.eclipse.xtext.Assignment;
import org.eclipse.xtext.CrossReference;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.GrammarUtil;
import org.eclipse.xtext.Keyword;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.formatting.IWhitespaceInformationProvider;
import org.eclipse.xtext.ide.editor.contentassist.ContentAssistContext;
import org.eclipse.xtext.ide.editor.contentassist.ContentAssistEntry;
import org.eclipse.xtext.ide.editor.contentassist.IIdeContentProposalAcceptor;
import org.eclipse.xtext.ide.editor.contentassist.IdeContentProposalProvider;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.resource.EObjectDescription;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.scoping.IScope;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.IteratorExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.eclipse.xtext.xtext.CurrentTypeFinder;

@SuppressWarnings("all")
public class YangContentProposalProvider extends IdeContentProposalProvider {
  private static final Set<String> IGNORED_KEYWORDS = Collections.<String>unmodifiableSet(CollectionLiterals.<String>newHashSet("/", "{", ";", "}", "+", "-", "*", "/", ">=", "<=", ">", "<", "=", "!=", ":", "[", "]", "|", "or", "and", "div", "mod", "$", "(", "@", "processing-instruction"));
  
  @Inject
  @Extension
  private CurrentTypeFinder _currentTypeFinder;
  
  @Inject
  @Extension
  private DocumentationProvider _documentationProvider;
  
  @Inject
  private ScopeContextProvider scopeContextProvider;
  
  @Inject
  private SubstatementRuleProvider ruleProvider;
  
  @Inject
  private YangGrammarAccess grammarAccess;
  
  @Inject
  private IWhitespaceInformationProvider whitespaceInformation;
  
  @Override
  protected void _createProposals(final AbstractElement element, final ContentAssistContext context, final IIdeContentProposalAcceptor acceptor) {
  }
  
  @Override
  protected void _createProposals(final Assignment assignment, final ContentAssistContext context, final IIdeContentProposalAcceptor acceptor) {
    final AbstractElement terminal = assignment.getTerminal();
    if ((terminal instanceof CrossReference)) {
      this.createProposals(terminal, context, acceptor);
    } else {
      Assignment _nameAssignment_4_1 = this.grammarAccess.getXpathPrimaryExprAccess().getNameAssignment_4_1();
      boolean _tripleEquals = (assignment == _nameAssignment_4_1);
      if (_tripleEquals) {
        int _length = context.getPrefix().length();
        boolean _greaterThan = (_length > 0);
        if (_greaterThan) {
          final Function1<XpathFunctionLibrary.Function, Boolean> _function = (XpathFunctionLibrary.Function it) -> {
            return Boolean.valueOf(it.getName().toLowerCase().startsWith(context.getPrefix().toLowerCase()));
          };
          Iterable<XpathFunctionLibrary.Function> _filter = IterableExtensions.<XpathFunctionLibrary.Function>filter(XpathFunctionLibrary.FUNCTIONS.values(), _function);
          for (final XpathFunctionLibrary.Function f : _filter) {
            {
              ContentAssistEntry _contentAssistEntry = new ContentAssistEntry();
              final Procedure1<ContentAssistEntry> _function_1 = (ContentAssistEntry it) -> {
                it.setPrefix(context.getPrefix());
                StringConcatenation _builder = new StringConcatenation();
                String _name = f.getName();
                _builder.append(_name);
                _builder.append("(");
                final Function1<XpathFunctionLibrary.Type, CharSequence> _function_2 = (XpathFunctionLibrary.Type it_1) -> {
                  return it_1.name().toLowerCase();
                };
                String _join = IterableExtensions.<XpathFunctionLibrary.Type>join(((Iterable<XpathFunctionLibrary.Type>)Conversions.doWrapArray(f.getParamTypes())), ", ", _function_2);
                _builder.append(_join);
                _builder.append(")");
                it.setLabel(_builder.toString());
                StringConcatenation _builder_1 = new StringConcatenation();
                String _name_1 = f.getName();
                _builder_1.append(_name_1);
                _builder_1.append("(");
                final Function1<XpathFunctionLibrary.Type, CharSequence> _function_3 = (XpathFunctionLibrary.Type it_1) -> {
                  String _lowerCase = it_1.name().toLowerCase();
                  String _plus = ("${" + _lowerCase);
                  return (_plus + "}");
                };
                String _join_1 = IterableExtensions.<XpathFunctionLibrary.Type>join(((Iterable<XpathFunctionLibrary.Type>)Conversions.doWrapArray(f.getParamTypes())), ", ", _function_3);
                _builder_1.append(_join_1);
                _builder_1.append(")");
                it.setProposal(_builder_1.toString());
                it.setDocumentation(f.getDocumentation());
                it.setKind(ContentAssistEntry.KIND_FUNCTION);
              };
              final ContentAssistEntry entry = ObjectExtensions.<ContentAssistEntry>operator_doubleArrow(_contentAssistEntry, _function_1);
              int _defaultPriority = this.getProposalPriorities().getDefaultPriority(entry);
              int _plus = (_defaultPriority + 1);
              acceptor.accept(entry, _plus);
            }
          }
        }
      }
    }
  }
  
  @Override
  protected void _createProposals(final RuleCall ruleCall, final ContentAssistContext context, final IIdeContentProposalAcceptor acceptor) {
    String _name = ruleCall.getRule().getName();
    boolean _equals = Objects.equal(_name, "BUILTIN_TYPE");
    if (_equals) {
      Iterable<Keyword> _iterable = IteratorExtensions.<Keyword>toIterable(Iterators.<Keyword>filter(EcoreUtil.<Object>getAllContents(ruleCall.getRule(), false), Keyword.class));
      for (final Keyword kw : _iterable) {
        this.createProposals(kw, context, acceptor);
      }
    }
  }
  
  @Override
  protected void _createProposals(final Keyword keyword, final ContentAssistContext context, final IIdeContentProposalAcceptor acceptor) {
    if (((keyword == this.grammarAccess.getXpathExpressionAccess().getLessThanSignLessThanSignLessThanSignLessThanSignKeyword_0_1()) || (keyword == this.grammarAccess.getXpathExpressionAccess().getGreaterThanSignGreaterThanSignGreaterThanSignGreaterThanSignKeyword_0_3()))) {
      return;
    }
    if (((keyword == this.grammarAccess.getImportAccess().getImportKeyword_0()) && this.filterKeyword(keyword, context))) {
      final AbstractModule module = EcoreUtil2.<AbstractModule>getContainerOfType(context.getCurrentModel(), AbstractModule.class);
      final IScopeContext scopeCtx = this.scopeContextProvider.getScopeContext(module);
      final String indentString = this.whitespaceInformation.getIndentationInformation(context.getResource().getURI()).getIndentString();
      Iterable<IEObjectDescription> _allElements = scopeCtx.getModuleScope().getAllElements();
      for (final IEObjectDescription e : _allElements) {
        {
          EObject _resolve = EcoreUtil.resolve(e.getEObjectOrProxy(), context.getResource());
          final AbstractModule m = ((AbstractModule) _resolve);
          if (((m instanceof io.typefox.yang.yang.Module) && (m != module))) {
            final Function1<Revision, String> _function = (Revision it) -> {
              return it.getRevision();
            };
            final Revision rev = IterableExtensions.<Revision>head(ListExtensions.<Revision>reverseView(IterableExtensions.<Revision, String>sortBy(Iterables.<Revision>filter(m.getSubstatements(), Revision.class), _function)));
            ContentAssistEntry _contentAssistEntry = new ContentAssistEntry();
            final Procedure1<ContentAssistEntry> _function_1 = (ContentAssistEntry it) -> {
              it.setPrefix(context.getPrefix());
              QualifiedName _qualifiedName = e.getQualifiedName();
              String _plus = ("import " + _qualifiedName);
              it.setLabel(_plus);
              StringConcatenation _builder = new StringConcatenation();
              _builder.append("import ");
              QualifiedName _qualifiedName_1 = e.getQualifiedName();
              _builder.append(_qualifiedName_1);
              _builder.append(" {");
              _builder.newLineIfNotEmpty();
              _builder.append("\t");
              _builder.append("prefix ");
              Prefix _head = IterableExtensions.<Prefix>head(Iterables.<Prefix>filter(m.getSubstatements(), Prefix.class));
              String _prefix = null;
              if (_head!=null) {
                _prefix=_head.getPrefix();
              }
              _builder.append(_prefix, "\t");
              _builder.append(";");
              _builder.newLineIfNotEmpty();
              {
                if ((rev != null)) {
                  _builder.append("\t");
                  _builder.append("revision-date ");
                  String _revision = rev.getRevision();
                  _builder.append(_revision, "\t");
                  _builder.append(";");
                  _builder.newLineIfNotEmpty();
                }
              }
              _builder.append("}");
              _builder.newLine();
              it.setProposal(_builder.toString().replaceAll("  ", indentString));
              String _name = m.getName();
              String _plus_1 = ("module " + _name);
              it.setDescription(_plus_1);
              it.setDocumentation(this._documentationProvider.getDocumentation(m));
              it.setKind(ContentAssistEntry.KIND_MODULE);
            };
            final ContentAssistEntry entry = ObjectExtensions.<ContentAssistEntry>operator_doubleArrow(_contentAssistEntry, _function_1);
            int _defaultPriority = this.getProposalPriorities().getDefaultPriority(entry);
            int _plus = (_defaultPriority + 1);
            acceptor.accept(entry, _plus);
          }
        }
      }
    }
    super._createProposals(keyword, context, acceptor);
  }
  
  @Override
  protected void _createProposals(final CrossReference reference, final ContentAssistContext context, final IIdeContentProposalAcceptor acceptor) {
    final EClassifier type = this._currentTypeFinder.findCurrentTypeAfter(reference);
    if ((type instanceof EClass)) {
      final EReference ereference = GrammarUtil.getReference(reference, ((EClass)type));
      final EObject currentModel = context.getCurrentModel();
      if (((ereference != null) && (currentModel != null))) {
        if ((YangPackage.Literals.SCHEMA_NODE_IDENTIFIER__SCHEMA_NODE == ereference)) {
          this.computeIdentifierRefProposals(reference, context, acceptor);
        } else {
          if ((YangPackage.Literals.REVISION_DATE__DATE == ereference)) {
            this.computeRevisionProposals(reference, context, acceptor);
          } else {
            if ((((YangPackage.Literals.XPATH_NAME_TEST__REF == ereference) || 
              (YangPackage.Literals.CURRENT_REF__REF == ereference)) || 
              (YangPackage.Literals.PARENT_REF__REF == ereference))) {
              this.computeXpathStep(reference, context, acceptor);
            } else {
              final IScope scope = this.getScopeProvider().getScope(currentModel, ereference);
              this.getCrossrefProposalProvider().lookupCrossReference(scope, reference, context, acceptor, 
                this.getCrossrefFilter(reference, context));
            }
          }
        }
      }
    }
  }
  
  @Inject
  private XpathResolver xpathResolver;
  
  public List<IEObjectDescription> findPathes(final EObject obj, final ContentAssistContext context) {
    if ((obj == null)) {
      return CollectionLiterals.<IEObjectDescription>emptyList();
    }
    boolean _matched = false;
    if (obj instanceof XpathStep) {
      _matched=true;
      EObject _eContainer = ((XpathStep)obj).eContainer();
      final EObject expr = _eContainer;
      boolean _matched_1 = false;
      if (expr instanceof AbsolutePath) {
        _matched_1=true;
        return Collections.<IEObjectDescription>unmodifiableList(CollectionLiterals.<IEObjectDescription>newArrayList(Linker.ROOT));
      }
      if (!_matched_1) {
        if (expr instanceof XpathLocation) {
          _matched_1=true;
          return this.findPathes(((XpathLocation)expr).getTarget(), context);
        }
      }
      return this.findPathes(expr.eContainer(), context);
    }
    if (!_matched) {
      if (obj instanceof XpathExpression) {
        _matched=true;
        final XpathType type = this.xpathResolver.getType(((XpathExpression)obj));
        if ((type instanceof NodeSetType)) {
          return ((NodeSetType)type).getNodes();
        } else {
          if ((obj instanceof XpathLocation)) {
            final List<IEObjectDescription> p = this.findPathes(((XpathLocation)obj).getTarget(), context);
            if ((p != null)) {
              return p;
            }
          } else {
            if ((obj instanceof AbsolutePath)) {
              return Collections.<IEObjectDescription>unmodifiableList(CollectionLiterals.<IEObjectDescription>newArrayList(Linker.ROOT));
            }
          }
          return this.findPathes(((XpathExpression)obj).eContainer(), context);
        }
      }
    }
    if (!_matched) {
      if (obj instanceof SchemaNode) {
        _matched=true;
        String _prefix = context.getPrefix();
        boolean _equals = Objects.equal(_prefix, "/");
        if (_equals) {
          return Collections.<IEObjectDescription>unmodifiableList(CollectionLiterals.<IEObjectDescription>newArrayList(Linker.ROOT));
        }
        QualifiedName _findSchemaNodeName = this.scopeContextProvider.findSchemaNodeName(obj);
        Map<String, String> _emptyMap = CollectionLiterals.<String, String>emptyMap();
        EObjectDescription _eObjectDescription = new EObjectDescription(_findSchemaNodeName, obj, _emptyMap);
        return Collections.<IEObjectDescription>unmodifiableList(CollectionLiterals.<IEObjectDescription>newArrayList(_eObjectDescription));
      }
    }
    return this.findPathes(obj.eContainer(), context);
  }
  
  public XpathResolver.Axis findAxis(final ContentAssistContext context) {
    XpathResolver.Axis _switchResult = null;
    EObject _currentModel = context.getCurrentModel();
    final EObject e = _currentModel;
    boolean _matched = false;
    if (e instanceof XpathLocation) {
      boolean _isIsDescendants = ((XpathLocation)e).isIsDescendants();
      if (_isIsDescendants) {
        _matched=true;
        _switchResult = XpathResolver.Axis.DESCENDANTS;
      }
    }
    if (!_matched) {
      if (e instanceof AbsolutePath) {
        boolean _isIsDescendants = ((AbsolutePath)e).isIsDescendants();
        if (_isIsDescendants) {
          _matched=true;
          _switchResult = XpathResolver.Axis.DESCENDANTS;
        }
      }
    }
    if (!_matched) {
      if (e instanceof XpathStep) {
        _matched=true;
        String _axis = ((XpathStep)e).getAxis();
        if (_axis != null) {
          switch (_axis) {
            case "ancestor":
              return XpathResolver.Axis.ANCESTOR;
            case "ancestor-or-self":
              return XpathResolver.Axis.ANCESTOR_OR_SELF;
            case "descendant":
              return XpathResolver.Axis.DESCENDANTS;
            case "descendant-or-self":
              return XpathResolver.Axis.DESCENDANTS_OR_SELF;
            case "following":
              return XpathResolver.Axis.ANCESTOR;
            case "preceding":
              return XpathResolver.Axis.DESCENDANTS;
            case "following-sibling":
              return XpathResolver.Axis.SIBLINGS;
            case "preceding-sibling":
              return XpathResolver.Axis.SIBLINGS;
          }
        }
        return XpathResolver.Axis.CHILDREN;
      }
    }
    if (!_matched) {
      _switchResult = XpathResolver.Axis.CHILDREN;
    }
    return _switchResult;
  }
  
  public void computeXpathStep(final CrossReference reference, final ContentAssistContext context, final IIdeContentProposalAcceptor acceptor) {
    final List<IEObjectDescription> descs = this.findPathes(context.getCurrentModel(), context);
    final XpathResolver.Axis axis = this.findAxis(context);
    final IScopeContext scopeContext = this.scopeContextProvider.findScopeContext(context.getCurrentModel());
    for (final IEObjectDescription d : descs) {
      {
        final List<IEObjectDescription> candidates = this.xpathResolver.findNodes(d.getQualifiedName(), null, axis, scopeContext.getSchemaNodeScope());
        for (final IEObjectDescription candidate : candidates) {
          {
            final ContentAssistEntry entry = this.getProposalCreator().createProposal(candidate.getQualifiedName().getLastSegment(), context);
            if ((entry != null)) {
              entry.setDocumentation(this._documentationProvider.getDocumentation(candidate.getEObjectOrProxy()));
              entry.setKind(ContentAssistEntry.KIND_VALUE);
              acceptor.accept(entry, this.getProposalPriorities().getDefaultPriority(entry));
            }
          }
        }
      }
    }
  }
  
  public void computeRevisionProposals(final CrossReference reference, final ContentAssistContext context, final IIdeContentProposalAcceptor acceptor) {
    final AbstractImport imp = EcoreUtil2.<AbstractImport>getContainerOfType(context.getCurrentModel(), AbstractImport.class);
    if ((((imp != null) && (imp.getModule() != null)) && (!imp.getModule().eIsProxy()))) {
      Iterable<Revision> _filter = Iterables.<Revision>filter(imp.getModule().getSubstatements(), Revision.class);
      for (final Revision rev : _filter) {
        {
          ContentAssistEntry _createProposal = this.getProposalCreator().createProposal(rev.getRevision(), context);
          final Procedure1<ContentAssistEntry> _function = (ContentAssistEntry it) -> {
            Description _head = IterableExtensions.<Description>head(Iterables.<Description>filter(rev.getSubstatements(), Description.class));
            String _description = null;
            if (_head!=null) {
              _description=_head.getDescription();
            }
            it.setDocumentation(_description);
            it.setKind(ContentAssistEntry.KIND_REFERENCE);
          };
          final ContentAssistEntry entry = ObjectExtensions.<ContentAssistEntry>operator_doubleArrow(_createProposal, _function);
          acceptor.accept(entry, this.getProposalPriorities().getDefaultPriority(entry));
        }
      }
    }
  }
  
  private QualifiedName computeNodeSchemaPrefix(final EObject object, final IScope nodeScope) {
    if ((object instanceof SchemaNodeIdentifier)) {
      if (((((SchemaNodeIdentifier)object).getTarget() == null) || ((SchemaNodeIdentifier)object).getTarget().getSchemaNode().eIsProxy())) {
        return QualifiedName.EMPTY;
      }
      final IEObjectDescription desc = nodeScope.getSingleElement(((SchemaNodeIdentifier)object).getTarget().getSchemaNode());
      if ((desc != null)) {
        return desc.getName();
      }
    } else {
      if ((object instanceof SchemaNode)) {
        final IEObjectDescription desc_1 = nodeScope.getSingleElement(object);
        if ((desc_1 != null)) {
          return desc_1.getName();
        }
      } else {
        EObject _eContainer = object.eContainer();
        boolean _tripleNotEquals = (_eContainer != null);
        if (_tripleNotEquals) {
          return this.computeNodeSchemaPrefix(object.eContainer(), nodeScope);
        }
      }
    }
    return QualifiedName.EMPTY;
  }
  
  public void computeIdentifierRefProposals(final CrossReference reference, final ContentAssistContext context, final IIdeContentProposalAcceptor acceptor) {
    final IScopeContext scopeCtx = this.scopeContextProvider.findScopeContext(context.getCurrentModel());
    final ScopeContext.MapScope nodeScope = scopeCtx.getSchemaNodeScope();
    final QualifiedName prefix = this.computeNodeSchemaPrefix(context.getCurrentModel(), nodeScope);
    EObject _currentModel = context.getCurrentModel();
    final boolean isInPath = (_currentModel instanceof SchemaNodeIdentifier);
    this.computeSchemaNodePathProposals(prefix, nodeScope, scopeCtx, context, acceptor);
    if (((!isInPath) && (prefix.getSegmentCount() > 0))) {
      this.computeSchemaNodePathProposals(QualifiedName.EMPTY, nodeScope, scopeCtx, context, acceptor);
    }
  }
  
  private void computeSchemaNodePathProposals(final QualifiedName prefix, final ScopeContext.MapScope nodeScope, final IScopeContext scopeCtx, final ContentAssistContext context, final IIdeContentProposalAcceptor acceptor) {
    final Function1<IEObjectDescription, Boolean> _function = (IEObjectDescription it) -> {
      return Boolean.valueOf(it.getName().startsWith(prefix));
    };
    Iterable<IEObjectDescription> _filter = IterableExtensions.<IEObjectDescription>filter(nodeScope.getAllElements(), _function);
    for (final IEObjectDescription e : _filter) {
      {
        final QualifiedName suffix = e.getName().skipFirst(prefix.getSegmentCount());
        StringBuilder name = new StringBuilder();
        for (int i = 0; (i < suffix.getSegmentCount()); i++) {
          if (((i % 2) == 0)) {
            final String modulePrefix = suffix.getSegment(i);
            String _moduleName = scopeCtx.getModuleName();
            boolean _notEquals = (!Objects.equal(modulePrefix, _moduleName));
            if (_notEquals) {
              final String moduleName = suffix.getSegment(i);
              final Function1<Map.Entry<String, IScopeContext>, Boolean> _function_1 = (Map.Entry<String, IScopeContext> it) -> {
                String _moduleName_1 = it.getValue().getModuleName();
                return Boolean.valueOf(Objects.equal(_moduleName_1, moduleName));
              };
              final String importPrefix = IterableExtensions.<Map.Entry<String, IScopeContext>>findFirst(scopeCtx.getImportedModules().entrySet(), _function_1).getKey();
              name.append(importPrefix).append(":");
            }
          } else {
            name.append(suffix.getSegment(i));
            int _segmentCount = suffix.getSegmentCount();
            boolean _lessThan = ((i + 1) < _segmentCount);
            if (_lessThan) {
              name.append("/");
            }
          }
        }
        int _length = name.length();
        boolean _greaterThan = (_length > 0);
        if (_greaterThan) {
          String _xifexpression = null;
          int _segmentCount = prefix.getSegmentCount();
          boolean _tripleEquals = (_segmentCount == 0);
          if (_tripleEquals) {
            String _string = name.toString();
            _xifexpression = ("/" + _string);
          } else {
            _xifexpression = name.toString();
          }
          final String proposalName = _xifexpression;
          final Procedure1<ContentAssistEntry> _function_1 = (ContentAssistEntry it) -> {
            it.setDocumentation(this._documentationProvider.getDocumentation(e.getEObjectOrProxy()));
          };
          final ContentAssistEntry entry = this.getProposalCreator().createProposal(proposalName, context, _function_1);
          acceptor.accept(entry, this.getProposalPriorities().getCrossRefPriority(e, entry));
        }
      }
    }
  }
  
  @Override
  protected boolean filterKeyword(final Keyword keyword, final ContentAssistContext context) {
    boolean _isStatement = this.isStatement(keyword);
    if (_isStatement) {
      EObject _currentModel = null;
      if (context!=null) {
        _currentModel=context.getCurrentModel();
      }
      EClass _eClass = null;
      if (_currentModel!=null) {
        _eClass=_currentModel.eClass();
      }
      final SubstatementGroup substatementRule = this.ruleProvider.get(_eClass);
      if ((substatementRule != null)) {
        EObject _currentModel_1 = context.getCurrentModel();
        final Statement container = ((Statement) _currentModel_1);
        int _xifexpression = (int) 0;
        EObject _previousModel = context.getPreviousModel();
        boolean _tripleEquals = (_previousModel == container);
        if (_tripleEquals) {
          _xifexpression = 0;
        } else {
          _xifexpression = container.getSubstatements().indexOf(context.getPreviousModel());
        }
        final int index = _xifexpression;
        if ((index >= 0)) {
          final EClass clazz = YangNameUtils.getEClassForName(keyword.getValue());
          return ((clazz != null) && substatementRule.canInsert(container, clazz, index));
        }
      }
    }
    return (super.filterKeyword(keyword, context) && ((!YangContentProposalProvider.IGNORED_KEYWORDS.contains(keyword.getValue())) || (context.getPrefix().length() > 1)));
  }
  
  private boolean isStatement(final Keyword it) {
    int _length = ((Object[])Conversions.unwrapArray(this.grammarAccess.getSTATEMENT_KEYWORDAccess().findKeywords(it.getValue()), Object.class)).length;
    return (_length > 0);
  }
  
  @Override
  protected Predicate<IEObjectDescription> getCrossrefFilter(final CrossReference reference, final ContentAssistContext context) {
    final IScopeContext scopeCtx = this.scopeContextProvider.findScopeContext(context.getCurrentModel());
    final String localPrefix = scopeCtx.getLocalPrefix();
    final Predicate<IEObjectDescription> _function = (IEObjectDescription desc) -> {
      return ((desc.getName().getSegmentCount() == 1) || (!Objects.equal(desc.getName().getFirstSegment(), localPrefix)));
    };
    return _function;
  }
}

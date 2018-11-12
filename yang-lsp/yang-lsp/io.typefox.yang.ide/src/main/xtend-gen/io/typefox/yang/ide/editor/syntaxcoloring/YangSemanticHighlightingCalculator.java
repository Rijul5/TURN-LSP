package io.typefox.yang.ide.editor.syntaxcoloring;

import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.base.Predicate;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Lists;
import com.google.common.collect.Multimap;
import com.google.inject.Inject;
import com.google.inject.Singleton;
import io.typefox.yang.findReferences.YangReferenceFinder;
import io.typefox.yang.utils.YangExtensions;
import io.typefox.yang.yang.Action;
import io.typefox.yang.yang.Anydata;
import io.typefox.yang.yang.Anyxml;
import io.typefox.yang.yang.Augment;
import io.typefox.yang.yang.Case;
import io.typefox.yang.yang.Choice;
import io.typefox.yang.yang.Container;
import io.typefox.yang.yang.Default;
import io.typefox.yang.yang.Description;
import io.typefox.yang.yang.Deviation;
import io.typefox.yang.yang.Feature;
import io.typefox.yang.yang.Grouping;
import io.typefox.yang.yang.GroupingRef;
import io.typefox.yang.yang.Identity;
import io.typefox.yang.yang.IfFeature;
import io.typefox.yang.yang.Key;
import io.typefox.yang.yang.Leaf;
import io.typefox.yang.yang.LeafList;
import io.typefox.yang.yang.Must;
import io.typefox.yang.yang.Notification;
import io.typefox.yang.yang.Refine;
import io.typefox.yang.yang.Rpc;
import io.typefox.yang.yang.SchemaNode;
import io.typefox.yang.yang.Statement;
import io.typefox.yang.yang.Typedef;
import io.typefox.yang.yang.When;
import io.typefox.yang.yang.YangPackage;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Consumer;
import org.apache.log4j.Logger;
import org.eclipse.core.runtime.OperationCanceledException;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.ide.editor.syntaxcoloring.DefaultSemanticHighlightingCalculator;
import org.eclipse.xtext.ide.editor.syntaxcoloring.IHighlightedPositionAcceptor;
import org.eclipse.xtext.ide.server.semanticHighlight.ISemanticHighlightingStyleToTokenMapper;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;
import org.eclipse.xtext.util.CancelIndicator;
import org.eclipse.xtext.util.internal.Log;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.Pair;
import org.eclipse.xtext.xbase.lib.StringExtensions;

@Log
@Singleton
@SuppressWarnings("all")
public class YangSemanticHighlightingCalculator extends DefaultSemanticHighlightingCalculator implements ISemanticHighlightingStyleToTokenMapper {
  public interface Styles {
    /**
     * 1a
     */
    public static final String NORMAL_DATA_NODE_STYLE = "yang-normal-data-node";
    
    /**
     * 1b
     */
    public static final String ALTERNATIVE_DATA_NODE_STYLE = "yang-alternative-data-node";
    
    /**
     * 1c
     */
    public static final String REUSABLE_DATA_NODE_STYLE = "yang-reusable-data-node";
    
    /**
     * 2
     */
    public static final String EXTENDIBLE_MODULE_STATEMENT_STYLE = "yang-extendible-module-statement";
    
    /**
     * 3a
     */
    public static final String CONDITIONAL_MODULE_STATEMENT_STYLE = "yang-conditional-module-statement";
    
    /**
     * 3b
     */
    public static final String CONSTRAINT_MODULE_STATEMENT_STYLE = "yang-constraint-module-statement";
    
    /**
     * 4
     */
    public static final String INTERFACE_STATEMENT_STYLE = "yang-interface-statement";
    
    /**
     * 5
     */
    public static final String REFERENCEABLE_STATEMENT_STYLE = "yang-referenceable-statement";
    
    /**
     * 6a
     */
    public static final String DESCRIPTION_STYLE = "yang-description-statement";
    
    /**
     * 6b
     */
    public static final String DEFAULT_STYLE = "yang-default-statement";
    
    /**
     * 6c
     */
    public static final String KEY_STYLE = "yang-key-statement,";
  }
  
  public interface Scopes {
    public static final List<String> NORMAL_DATA_NODE_SCOPES = YangSemanticHighlightingCalculator.yang(Collections.<String>unmodifiableList(CollectionLiterals.<String>newArrayList("keyword.control")));
    
    public static final List<String> ALTERNATIVE_DATA_NODE_SCOPES = YangSemanticHighlightingCalculator.yang(Collections.<String>unmodifiableList(CollectionLiterals.<String>newArrayList("beginning.punctuation.definition.list.markdown")));
    
    public static final List<String> REUSABLE_DATA_NODE_SCOPES = YangSemanticHighlightingCalculator.yang(Collections.<String>unmodifiableList(CollectionLiterals.<String>newArrayList("support.type.property-name")));
    
    public static final List<String> EXTENDIBLE_MODULE_STATEMENT_SCOPES = YangSemanticHighlightingCalculator.yang(Collections.<String>unmodifiableList(CollectionLiterals.<String>newArrayList("punctuation.definition.tag")));
    
    public static final List<String> CONDITIONAL_MODULE_STATEMENT_SCOPES = YangSemanticHighlightingCalculator.yang(Collections.<String>unmodifiableList(CollectionLiterals.<String>newArrayList("emphasis")));
    
    public static final List<String> CONSTRAINT_MODULE_STATEMENT_SCOPES = YangSemanticHighlightingCalculator.yang(Collections.<String>unmodifiableList(CollectionLiterals.<String>newArrayList("strong")));
    
    public static final List<String> INTERFACE_STATEMENT_SCOPES = YangSemanticHighlightingCalculator.yang(Collections.<String>unmodifiableList(CollectionLiterals.<String>newArrayList("support.type.property-name")));
    
    public static final List<String> REFERENCEABLE_STATEMENT_SCOPES = YangSemanticHighlightingCalculator.yang(Collections.<String>unmodifiableList(CollectionLiterals.<String>newArrayList("constant.regexp")));
    
    public static final List<String> DESCRIPTION_SCOPES = YangSemanticHighlightingCalculator.yang(Collections.<String>unmodifiableList(CollectionLiterals.<String>newArrayList("keyword.other.unit")));
    
    public static final List<String> DEFAULT_SCOPES = YangSemanticHighlightingCalculator.yang(Collections.<String>unmodifiableList(CollectionLiterals.<String>newArrayList("keyword.operator")));
    
    public static final List<String> KEY_SCOPES = YangSemanticHighlightingCalculator.yang(Collections.<String>unmodifiableList(CollectionLiterals.<String>newArrayList("string.regexp")));
  }
  
  /**
   * The double-quote (&quot;) character.
   */
  private static final char DOUBLE_QUOTE = '\"';
  
  /**
   * The single-quote (&apos;) character.
   */
  private static final char QUOTE = "\'".charAt(0);
  
  /**
   * The space separator character.
   */
  private static final char SPACE_SEPARATOR = ' ';
  
  @Inject
  @Extension
  private YangExtensions _yangExtensions;
  
  @Inject
  @Extension
  private YangReferenceFinder _yangReferenceFinder;
  
  public static final Map<String, List<String>> STYLE_MAPPINGS = Collections.<String, List<String>>unmodifiableMap(CollectionLiterals.<String, List<String>>newHashMap(Pair.<String, List<String>>of(YangSemanticHighlightingCalculator.Styles.NORMAL_DATA_NODE_STYLE, YangSemanticHighlightingCalculator.Scopes.NORMAL_DATA_NODE_SCOPES), Pair.<String, List<String>>of(YangSemanticHighlightingCalculator.Styles.ALTERNATIVE_DATA_NODE_STYLE, YangSemanticHighlightingCalculator.Scopes.ALTERNATIVE_DATA_NODE_SCOPES), Pair.<String, List<String>>of(YangSemanticHighlightingCalculator.Styles.REUSABLE_DATA_NODE_STYLE, YangSemanticHighlightingCalculator.Scopes.REUSABLE_DATA_NODE_SCOPES), Pair.<String, List<String>>of(YangSemanticHighlightingCalculator.Styles.EXTENDIBLE_MODULE_STATEMENT_STYLE, YangSemanticHighlightingCalculator.Scopes.EXTENDIBLE_MODULE_STATEMENT_SCOPES), Pair.<String, List<String>>of(YangSemanticHighlightingCalculator.Styles.CONDITIONAL_MODULE_STATEMENT_STYLE, YangSemanticHighlightingCalculator.Scopes.CONDITIONAL_MODULE_STATEMENT_SCOPES), Pair.<String, List<String>>of(YangSemanticHighlightingCalculator.Styles.CONSTRAINT_MODULE_STATEMENT_STYLE, YangSemanticHighlightingCalculator.Scopes.CONSTRAINT_MODULE_STATEMENT_SCOPES), Pair.<String, List<String>>of(YangSemanticHighlightingCalculator.Styles.INTERFACE_STATEMENT_STYLE, YangSemanticHighlightingCalculator.Scopes.INTERFACE_STATEMENT_SCOPES), Pair.<String, List<String>>of(YangSemanticHighlightingCalculator.Styles.REFERENCEABLE_STATEMENT_STYLE, YangSemanticHighlightingCalculator.Scopes.REFERENCEABLE_STATEMENT_SCOPES), Pair.<String, List<String>>of(YangSemanticHighlightingCalculator.Styles.DESCRIPTION_STYLE, YangSemanticHighlightingCalculator.Scopes.DESCRIPTION_SCOPES), Pair.<String, List<String>>of(YangSemanticHighlightingCalculator.Styles.DEFAULT_STYLE, YangSemanticHighlightingCalculator.Scopes.DEFAULT_SCOPES), Pair.<String, List<String>>of(YangSemanticHighlightingCalculator.Styles.KEY_STYLE, YangSemanticHighlightingCalculator.Scopes.KEY_SCOPES)));
  
  @Override
  protected boolean highlightElement(final EObject object, final IHighlightedPositionAcceptor acceptor, final CancelIndicator cancelIndicator) {
    boolean _isCanceled = cancelIndicator.isCanceled();
    if (_isCanceled) {
      throw new OperationCanceledException();
    }
    this.doHighlightConditionalStatement(object, acceptor);
    return this.doHighlightElement(object, acceptor);
  }
  
  protected boolean _doHighlightElement(final EObject it, final IHighlightedPositionAcceptor acceptor) {
    return false;
  }
  
  /**
   * 1a.
   * Data Def Node (leaf, leaf-list, list, container, anydata, anyxml) are subset of Schema Node, they really exists in the real final data tree.
   */
  protected boolean _doHighlightElement(final Leaf it, final IHighlightedPositionAcceptor acceptor) {
    return this.doHighlightNodeForFeature(it, acceptor, YangPackage.Literals.SCHEMA_NODE__NAME, YangSemanticHighlightingCalculator.Styles.NORMAL_DATA_NODE_STYLE);
  }
  
  protected boolean _doHighlightElement(final LeafList it, final IHighlightedPositionAcceptor acceptor) {
    return this.doHighlightNodeForFeature(it, acceptor, YangPackage.Literals.SCHEMA_NODE__NAME, YangSemanticHighlightingCalculator.Styles.NORMAL_DATA_NODE_STYLE);
  }
  
  protected boolean _doHighlightElement(final io.typefox.yang.yang.List it, final IHighlightedPositionAcceptor acceptor) {
    return this.doHighlightNodeForFeature(it, acceptor, YangPackage.Literals.SCHEMA_NODE__NAME, YangSemanticHighlightingCalculator.Styles.NORMAL_DATA_NODE_STYLE);
  }
  
  protected boolean _doHighlightElement(final Container it, final IHighlightedPositionAcceptor acceptor) {
    return this.doHighlightNodeForFeature(it, acceptor, YangPackage.Literals.SCHEMA_NODE__NAME, YangSemanticHighlightingCalculator.Styles.NORMAL_DATA_NODE_STYLE);
  }
  
  protected boolean _doHighlightElement(final Anydata it, final IHighlightedPositionAcceptor acceptor) {
    return this.doHighlightNodeForFeature(it, acceptor, YangPackage.Literals.SCHEMA_NODE__NAME, YangSemanticHighlightingCalculator.Styles.NORMAL_DATA_NODE_STYLE);
  }
  
  protected boolean _doHighlightElement(final Anyxml it, final IHighlightedPositionAcceptor acceptor) {
    return this.doHighlightNodeForFeature(it, acceptor, YangPackage.Literals.SCHEMA_NODE__NAME, YangSemanticHighlightingCalculator.Styles.NORMAL_DATA_NODE_STYLE);
  }
  
  /**
   * 1b.
   * In Schema node (choice, case and data def node), choice and case defines a set of alternatives of data, so not all cases will appear in
   * the final data tree.
   */
  protected boolean _doHighlightElement(final Choice it, final IHighlightedPositionAcceptor acceptor) {
    return this.doHighlightNodeForFeature(it, acceptor, YangPackage.Literals.SCHEMA_NODE__NAME, YangSemanticHighlightingCalculator.Styles.ALTERNATIVE_DATA_NODE_STYLE);
  }
  
  protected boolean _doHighlightElement(final Case it, final IHighlightedPositionAcceptor acceptor) {
    return this.doHighlightNodeForFeature(it, acceptor, YangPackage.Literals.SCHEMA_NODE__NAME, YangSemanticHighlightingCalculator.Styles.ALTERNATIVE_DATA_NODE_STYLE);
  }
  
  /**
   * 1c.
   * Reusable Node, (grouping: reusable def, uses: reusable reference), grouping only defines reusable data, but until it (grouping) is be
   * 'uses' somewhere else, they (data def in grouping) will not appear in final data tree.
   */
  protected boolean _doHighlightElement(final Grouping it, final IHighlightedPositionAcceptor acceptor) {
    boolean _isReferencedFromUses = this.isReferencedFromUses(it);
    if (_isReferencedFromUses) {
      this.doHighlightNodeForFeature(it, acceptor, YangPackage.Literals.SCHEMA_NODE__NAME, YangSemanticHighlightingCalculator.Styles.REUSABLE_DATA_NODE_STYLE);
    }
    return false;
  }
  
  protected boolean isReferencedFromUses(final Grouping it) {
    final Resource resource = it.eResource();
    final Predicate<Pair<URI, EReference>> _function = (Pair<URI, EReference> it_1) -> {
      final EObject groupingRef = resource.getEObject(it_1.getKey().fragment());
      if ((groupingRef instanceof GroupingRef)) {
        EObject _eContainer = ((GroupingRef)groupingRef).eContainer();
        EClass _eClass = null;
        if (_eContainer!=null) {
          _eClass=_eContainer.eClass();
        }
        return YangPackage.Literals.USES.isSuperTypeOf(_eClass);
      }
      return false;
    };
    return this.isReferencedFrom(it, _function);
  }
  
  /**
   * 2.
   * Extendible module statement:
   * Augment, Refine and Deviation statements have the ability to extend/impact (Add, Replace, Remove, Disable) existing modules.
   * All of them can change specific existing module, and then a new derived module will be used in runtime.
   * The difference between them is that they have their own extending target and extending ways.
   * Therefore, it is important to highlight these extending part of a module.
   */
  protected boolean _doHighlightElement(final Augment it, final IHighlightedPositionAcceptor acceptor) {
    return this.doHighlightNodeForFeature(it, acceptor, YangPackage.Literals.AUGMENT__PATH, YangSemanticHighlightingCalculator.Styles.EXTENDIBLE_MODULE_STATEMENT_STYLE);
  }
  
  protected boolean _doHighlightElement(final Refine it, final IHighlightedPositionAcceptor acceptor) {
    return this.doHighlightNodeForFeature(it, acceptor, YangPackage.Literals.REFINE__NODE, YangSemanticHighlightingCalculator.Styles.EXTENDIBLE_MODULE_STATEMENT_STYLE);
  }
  
  protected boolean _doHighlightElement(final Deviation it, final IHighlightedPositionAcceptor acceptor) {
    return this.doHighlightNodeForFeature(it, acceptor, YangPackage.Literals.DEVIATION__REFERENCE, YangSemanticHighlightingCalculator.Styles.EXTENDIBLE_MODULE_STATEMENT_STYLE);
  }
  
  /**
   * 3.
   * Conditional module statement:
   * In yang modeling language, 'when', 'if-feature' could be used to define conditional schema node. 'must' are used to define constraint
   * of some schema node and operation.
   * They all indicate that those nodes which applied with them (when, if-feature, must) are conditionally enabled/valid/available.
   * So they are also valuable to be highlighted.
   * 
   * For 'when', it is like 'if-feature', but just considering information from other aspect (for example, during system runtime, when a
   * system trying to load yang module). So simply to say, when a schema node has when/if-feature, the schema node will not always be valid/exists,
   * it needs additional information to decide.
   * 
   * For 'must', it is one kind of constraint for schema node. If the defined constraint is violated, there should have some warning/error message.
   * So it will be good to highlight a node when it has 'must'. It will reminder yang module designer or user, there might be waring/error message
   * trigger by that node. Of cause, there is no need to analysis/evaluate these condition/constraint in detail, but just show those nodes which
   * has conditional definition and highlight them to yang designer and user.
   */
  protected void doHighlightConditionalStatement(final EObject it, final IHighlightedPositionAcceptor acceptor) {
    if ((it instanceof SchemaNode)) {
      if (((!IterableExtensions.isNullOrEmpty(this._yangExtensions.<When>substatementsOfType(((Statement)it), When.class))) || (!IterableExtensions.isNullOrEmpty(this._yangExtensions.<IfFeature>substatementsOfType(((Statement)it), IfFeature.class))))) {
        this.doHighlightNodeForFeature(it, acceptor, YangPackage.Literals.SCHEMA_NODE__NAME, YangSemanticHighlightingCalculator.Styles.CONDITIONAL_MODULE_STATEMENT_STYLE);
      }
      boolean _isNullOrEmpty = IterableExtensions.isNullOrEmpty(this._yangExtensions.<Must>substatementsOfType(((Statement)it), Must.class));
      boolean _not = (!_isNullOrEmpty);
      if (_not) {
        this.doHighlightNodeForFeature(it, acceptor, YangPackage.Literals.SCHEMA_NODE__NAME, YangSemanticHighlightingCalculator.Styles.CONSTRAINT_MODULE_STATEMENT_STYLE);
      }
    }
  }
  
  /**
   * 4.
   * Interface statement:
   * There are Action/RPC/Notification statement in yang modeling language. Apparently, they are quite different comparing with data nodes.
   * They are interface (Operation/Notification) definition of some models. It makes sense to distinguish them apart from data nodes.
   */
  protected boolean _doHighlightElement(final Rpc it, final IHighlightedPositionAcceptor acceptor) {
    return this.doHighlightNodeForFeature(it, acceptor, YangPackage.Literals.SCHEMA_NODE__NAME, YangSemanticHighlightingCalculator.Styles.INTERFACE_STATEMENT_STYLE);
  }
  
  protected boolean _doHighlightElement(final Notification it, final IHighlightedPositionAcceptor acceptor) {
    return this.doHighlightNodeForFeature(it, acceptor, YangPackage.Literals.SCHEMA_NODE__NAME, YangSemanticHighlightingCalculator.Styles.INTERFACE_STATEMENT_STYLE);
  }
  
  protected boolean _doHighlightElement(final Action it, final IHighlightedPositionAcceptor acceptor) {
    return this.doHighlightNodeForFeature(it, acceptor, YangPackage.Literals.SCHEMA_NODE__NAME, YangSemanticHighlightingCalculator.Styles.INTERFACE_STATEMENT_STYLE);
  }
  
  /**
   * 5.
   * Referenceable statement:
   * Identify/Feature/Extension/TypeDef are other conceptional definition statement.
   * They will only be valuable or meaningful when they are referenced from other schema node or interface/operation node.
   */
  protected boolean _doHighlightElement(final Identity it, final IHighlightedPositionAcceptor acceptor) {
    return this.doHighlightReferenceableStatement(it, acceptor);
  }
  
  protected boolean _doHighlightElement(final Feature it, final IHighlightedPositionAcceptor acceptor) {
    return this.doHighlightReferenceableStatement(it, acceptor);
  }
  
  protected boolean _doHighlightElement(final io.typefox.yang.yang.Extension it, final IHighlightedPositionAcceptor acceptor) {
    return this.doHighlightReferenceableStatement(it, acceptor);
  }
  
  protected boolean _doHighlightElement(final Typedef it, final IHighlightedPositionAcceptor acceptor) {
    return this.doHighlightReferenceableStatement(it, acceptor);
  }
  
  protected boolean doHighlightReferenceableStatement(final EObject it, final IHighlightedPositionAcceptor acceptor) {
    boolean _isReferencedFromSchemaNode = this.isReferencedFromSchemaNode(it);
    if (_isReferencedFromSchemaNode) {
      this.doHighlightNodeForFeature(it, acceptor, YangPackage.Literals.SCHEMA_NODE__NAME, YangSemanticHighlightingCalculator.Styles.REFERENCEABLE_STATEMENT_STYLE);
    }
    return false;
  }
  
  protected boolean isReferencedFromSchemaNode(final EObject it) {
    final Predicate<Pair<URI, EReference>> _function = (Pair<URI, EReference> it_1) -> {
      return YangPackage.Literals.SCHEMA_NODE.isSuperTypeOf(it_1.getValue().getEReferenceType());
    };
    return this.isReferencedFrom(it, _function);
  }
  
  protected boolean isReferencedFrom(final EObject it, final Predicate<Pair<URI, EReference>> predicate) {
    final Resource resource = it.eResource();
    final URI resourceUri = resource.getURI();
    final Multimap<URI, Pair<URI, EReference>> allReferences = this._yangReferenceFinder.collectReferences(resource);
    final Function1<Pair<URI, EReference>, Boolean> _function = (Pair<URI, EReference> it_1) -> {
      URI _trimFragment = it_1.getKey().trimFragment();
      return Boolean.valueOf(Objects.equal(resourceUri, _trimFragment));
    };
    final Iterable<Pair<URI, EReference>> referencesForObject = IterableExtensions.<Pair<URI, EReference>>filter(allReferences.get(EcoreUtil.getURI(it)), _function);
    boolean _isNullOrEmpty = IterableExtensions.isNullOrEmpty(referencesForObject);
    if (_isNullOrEmpty) {
      return false;
    }
    final Function1<Pair<URI, EReference>, Boolean> _function_1 = (Pair<URI, EReference> it_1) -> {
      return Boolean.valueOf(predicate.apply(it_1));
    };
    return IterableExtensions.<Pair<URI, EReference>>exists(referencesForObject, _function_1);
  }
  
  /**
   * 6.
   * Other statement:
   * Of cause, there are lot's of other statements. From our experience, currently, 'key', 'default' could be considered to be highlighted.
   * Meanwhile 'description' providers most important info for all kinds of nodes, so it is important to make 'description' much readable.
   */
  protected boolean _doHighlightElement(final Description it, final IHighlightedPositionAcceptor acceptor) {
    return this.doHighlightNodeForFeature(it, acceptor, YangPackage.Literals.DESCRIPTION__DESCRIPTION, YangSemanticHighlightingCalculator.Styles.DESCRIPTION_STYLE);
  }
  
  protected boolean _doHighlightElement(final Default it, final IHighlightedPositionAcceptor acceptor) {
    return this.doHighlightNodeForFeature(it, acceptor, YangPackage.Literals.DEFAULT__DEFAULT_STRING_VALUE, YangSemanticHighlightingCalculator.Styles.DEFAULT_STYLE);
  }
  
  protected boolean _doHighlightElement(final Key it, final IHighlightedPositionAcceptor acceptor) {
    return this.doHighlightNodeForFeature(it, acceptor, YangPackage.Literals.KEY__REFERENCES, YangSemanticHighlightingCalculator.Styles.KEY_STYLE);
  }
  
  protected boolean _doHighlightElement(final Void it, final IHighlightedPositionAcceptor acceptor) {
    return true;
  }
  
  protected boolean doHighlightNodeForFeature(final EObject object, final IHighlightedPositionAcceptor acceptor, final EStructuralFeature feature, final String styleId) {
    final List<INode> nodes = NodeModelUtils.findNodesForFeature(object, feature);
    this.acceptNodes(acceptor, nodes, styleId);
    return false;
  }
  
  protected void acceptNode(final IHighlightedPositionAcceptor acceptor, final INode node, final String style, final String... rest) {
    if ((node != null)) {
      final String text = node.getText();
      int length = node.getLength();
      int offset = node.getOffset();
      final int firstQuoteOffset = this.getFirstQuoteOffset(text);
      if ((firstQuoteOffset > 0)) {
        offset = (offset - firstQuoteOffset);
        length = ((length + firstQuoteOffset) + 1);
      }
      acceptor.addPosition(offset, length, ((String[])Conversions.unwrapArray(Lists.<String>asList(style, rest), String.class)));
    }
  }
  
  /**
   * Returns the offset of the first non-whitespace character if that is either a single- or a double-quote and the last character
   * of the {@code text} argument does not equal with the first matching quote.
   * Otherwise, returns {@code 0};
   */
  protected int getFirstQuoteOffset(final String text) {
    boolean _isNullOrEmpty = StringExtensions.isNullOrEmpty(text);
    if (_isNullOrEmpty) {
      return 0;
    }
    int counter = 0;
    for (int i = 0; (i < text.length()); i++) {
      {
        final char c = text.charAt(i);
        if ((YangSemanticHighlightingCalculator.SPACE_SEPARATOR == c)) {
          counter++;
        } else {
          if ((((c == YangSemanticHighlightingCalculator.QUOTE) || (c == YangSemanticHighlightingCalculator.DOUBLE_QUOTE)) && (text.charAt((text.length() - 1)) != c))) {
            return counter;
          }
          return 0;
        }
      }
    }
    return 0;
  }
  
  protected void acceptNodes(final IHighlightedPositionAcceptor acceptor, final Iterable<INode> nodes, final String style, final String... rest) {
    final Consumer<INode> _function = (INode it) -> {
      this.acceptNode(acceptor, it, style, rest);
    };
    nodes.forEach(_function);
  }
  
  @Override
  public Set<String> getAllStyleIds() {
    return ImmutableSet.<String>copyOf(YangSemanticHighlightingCalculator.STYLE_MAPPINGS.keySet());
  }
  
  @Override
  public List<String> toScopes(final String styleId) {
    final List<String> scopes = YangSemanticHighlightingCalculator.STYLE_MAPPINGS.get(styleId);
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("Cannot map style ID \'");
    _builder.append(styleId);
    _builder.append("\' to the corresponding TextMate scopes.");
    Preconditions.<List<String>>checkNotNull(scopes, _builder);
    return scopes;
  }
  
  private static List<String> yang(final List<String> scopes) {
    return ImmutableList.<String>builder().addAll(scopes).add("source.yang").build();
  }
  
  protected boolean doHighlightElement(final EObject it, final IHighlightedPositionAcceptor acceptor) {
    if (it instanceof Anydata) {
      return _doHighlightElement((Anydata)it, acceptor);
    } else if (it instanceof Anyxml) {
      return _doHighlightElement((Anyxml)it, acceptor);
    } else if (it instanceof Case) {
      return _doHighlightElement((Case)it, acceptor);
    } else if (it instanceof Choice) {
      return _doHighlightElement((Choice)it, acceptor);
    } else if (it instanceof Container) {
      return _doHighlightElement((Container)it, acceptor);
    } else if (it instanceof Leaf) {
      return _doHighlightElement((Leaf)it, acceptor);
    } else if (it instanceof LeafList) {
      return _doHighlightElement((LeafList)it, acceptor);
    } else if (it instanceof io.typefox.yang.yang.List) {
      return _doHighlightElement((io.typefox.yang.yang.List)it, acceptor);
    } else if (it instanceof Action) {
      return _doHighlightElement((Action)it, acceptor);
    } else if (it instanceof Augment) {
      return _doHighlightElement((Augment)it, acceptor);
    } else if (it instanceof Default) {
      return _doHighlightElement((Default)it, acceptor);
    } else if (it instanceof Description) {
      return _doHighlightElement((Description)it, acceptor);
    } else if (it instanceof Deviation) {
      return _doHighlightElement((Deviation)it, acceptor);
    } else if (it instanceof io.typefox.yang.yang.Extension) {
      return _doHighlightElement((io.typefox.yang.yang.Extension)it, acceptor);
    } else if (it instanceof Feature) {
      return _doHighlightElement((Feature)it, acceptor);
    } else if (it instanceof Grouping) {
      return _doHighlightElement((Grouping)it, acceptor);
    } else if (it instanceof Identity) {
      return _doHighlightElement((Identity)it, acceptor);
    } else if (it instanceof Key) {
      return _doHighlightElement((Key)it, acceptor);
    } else if (it instanceof Notification) {
      return _doHighlightElement((Notification)it, acceptor);
    } else if (it instanceof Refine) {
      return _doHighlightElement((Refine)it, acceptor);
    } else if (it instanceof Rpc) {
      return _doHighlightElement((Rpc)it, acceptor);
    } else if (it instanceof Typedef) {
      return _doHighlightElement((Typedef)it, acceptor);
    } else if (it != null) {
      return _doHighlightElement(it, acceptor);
    } else if (it == null) {
      return _doHighlightElement((Void)null, acceptor);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(it, acceptor).toString());
    }
  }
  
  private static final Logger LOG = Logger.getLogger(YangSemanticHighlightingCalculator.class);
}

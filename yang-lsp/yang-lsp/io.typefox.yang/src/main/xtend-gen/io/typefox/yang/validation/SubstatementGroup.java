package io.typefox.yang.validation;

import com.google.common.base.Objects;
import com.google.common.base.Splitter;
import com.google.common.collect.Iterables;
import com.google.common.collect.Range;
import io.typefox.yang.utils.YangExtensions;
import io.typefox.yang.utils.YangNameUtils;
import io.typefox.yang.validation.IssueCodes;
import io.typefox.yang.yang.Statement;
import io.typefox.yang.yang.YangPackage;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtend.lib.annotations.Data;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.Keyword;
import org.eclipse.xtext.nodemodel.ILeafNode;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.util.TextRegion;
import org.eclipse.xtext.validation.ValidationMessageAcceptor;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.Functions.Function2;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;
import org.eclipse.xtext.xbase.lib.MapExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure2;
import org.eclipse.xtext.xbase.lib.Pure;
import org.eclipse.xtext.xbase.lib.StringExtensions;

/**
 * YANG sub-statement validation helper for checking sub-statement ordering and cardinality.
 * 
 * @author akos.kitta
 */
@SuppressWarnings("all")
public class SubstatementGroup {
  @Data
  private static class SubstatementConstraint {
    private final String version;
    
    private final EClass clazz;
    
    private final SubstatementGroup.Cardinality cardinality;
    
    @Override
    public String toString() {
      StringConcatenation _builder = new StringConcatenation();
      String _yangName = YangNameUtils.getYangName(this.clazz);
      _builder.append(_yangName);
      _builder.append(" ");
      _builder.append(this.cardinality);
      {
        boolean _isNullOrEmpty = StringExtensions.isNullOrEmpty(this.version);
        boolean _not = (!_isNullOrEmpty);
        if (_not) {
          _builder.append(" [Version: ");
          _builder.append(this.version);
          _builder.append("]");
        }
      }
      return _builder.toString();
    }
    
    public boolean isVersion11() {
      return Objects.equal(YangExtensions.YANG_1_1, this.version);
    }
    
    public SubstatementConstraint(final String version, final EClass clazz, final SubstatementGroup.Cardinality cardinality) {
      super();
      this.version = version;
      this.clazz = clazz;
      this.cardinality = cardinality;
    }
    
    @Override
    @Pure
    public int hashCode() {
      final int prime = 31;
      int result = 1;
      result = prime * result + ((this.version== null) ? 0 : this.version.hashCode());
      result = prime * result + ((this.clazz== null) ? 0 : this.clazz.hashCode());
      return prime * result + ((this.cardinality== null) ? 0 : this.cardinality.hashCode());
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
      SubstatementGroup.SubstatementConstraint other = (SubstatementGroup.SubstatementConstraint) obj;
      if (this.version == null) {
        if (other.version != null)
          return false;
      } else if (!this.version.equals(other.version))
        return false;
      if (this.clazz == null) {
        if (other.clazz != null)
          return false;
      } else if (!this.clazz.equals(other.clazz))
        return false;
      if (this.cardinality == null) {
        if (other.cardinality != null)
          return false;
      } else if (!this.cardinality.equals(other.cardinality))
        return false;
      return true;
    }
    
    @Pure
    public String getVersion() {
      return this.version;
    }
    
    @Pure
    public EClass getClazz() {
      return this.clazz;
    }
    
    @Pure
    public SubstatementGroup.Cardinality getCardinality() {
      return this.cardinality;
    }
  }
  
  private static class Cardinality {
    public static final SubstatementGroup.Cardinality ANY = new SubstatementGroup.Cardinality(Range.<Integer>closed(Integer.valueOf(0), Integer.valueOf(Integer.MAX_VALUE)));
    
    public static final SubstatementGroup.Cardinality OPTIONAL = new SubstatementGroup.Cardinality(Range.<Integer>closed(Integer.valueOf(0), Integer.valueOf(1)));
    
    public static final SubstatementGroup.Cardinality MUST = new SubstatementGroup.Cardinality(Range.<Integer>closed(Integer.valueOf(1), Integer.valueOf(1)));
    
    public static final SubstatementGroup.Cardinality AT_LEAST_ONE = new SubstatementGroup.Cardinality(Range.<Integer>closed(Integer.valueOf(1), Integer.valueOf(Integer.MAX_VALUE)));
    
    private final Range<Integer> delegate;
    
    private Cardinality(final Range<Integer> delegate) {
      this.delegate = delegate;
    }
    
    private boolean contains(final int i) {
      return this.delegate.contains(Integer.valueOf(i));
    }
    
    @Override
    public String toString() {
      Integer _upperEndpoint = this.delegate.upperEndpoint();
      boolean _equals = ((_upperEndpoint).intValue() == Integer.MAX_VALUE);
      if (_equals) {
        StringConcatenation _builder = new StringConcatenation();
        _builder.append("[");
        Integer _lowerEndpoint = this.delegate.lowerEndpoint();
        _builder.append(_lowerEndpoint);
        _builder.append("..*]");
        return _builder.toString();
      }
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append(this.delegate);
      return _builder_1.toString();
    }
  }
  
  private final boolean ordered;
  
  private final Map<SubstatementGroup.SubstatementConstraint, String> orderedConstraint;
  
  private final Map<EClass, SubstatementGroup.SubstatementConstraint> constraintMapping;
  
  private int ordinal = 0;
  
  SubstatementGroup(final boolean ordered) {
    this.ordered = ordered;
    this.orderedConstraint = CollectionLiterals.<SubstatementGroup.SubstatementConstraint, String>newHashMap();
    this.constraintMapping = CollectionLiterals.<EClass, SubstatementGroup.SubstatementConstraint>newHashMap();
  }
  
  public SubstatementGroup any(final EClass clazz) {
    return this.any(null, clazz);
  }
  
  public SubstatementGroup any(final String version, final EClass clazz) {
    return this.add(version, clazz, SubstatementGroup.Cardinality.ANY);
  }
  
  public SubstatementGroup must(final EClass clazz) {
    return this.must(null, clazz);
  }
  
  public SubstatementGroup must(final String version, final EClass clazz) {
    return this.add(version, clazz, SubstatementGroup.Cardinality.MUST);
  }
  
  public SubstatementGroup atLeastOne(final EClass clazz) {
    return this.atLeastOne(null, clazz);
  }
  
  public SubstatementGroup atLeastOne(final String version, final EClass clazz) {
    return this.add(version, clazz, SubstatementGroup.Cardinality.AT_LEAST_ONE);
  }
  
  public SubstatementGroup optional(final EClass clazz) {
    return this.optional(null, clazz);
  }
  
  public SubstatementGroup optional(final String version, final EClass clazz) {
    return this.add(version, clazz, SubstatementGroup.Cardinality.OPTIONAL);
  }
  
  private SubstatementGroup add(final String version, final EClass clazz, final SubstatementGroup.Cardinality cardinality) {
    final SubstatementGroup.SubstatementConstraint constraint = new SubstatementGroup.SubstatementConstraint(version, clazz, cardinality);
    this.constraintMapping.put(clazz, constraint);
    StringConcatenation _builder = new StringConcatenation();
    _builder.append(this.ordinal);
    this.orderedConstraint.put(constraint, _builder.toString());
    if (this.ordered) {
      this.ordinal++;
    }
    return this;
  }
  
  public SubstatementGroup with(final SubstatementGroup ruleGroup) {
    this.constraintMapping.putAll(ruleGroup.constraintMapping);
    final BiConsumer<SubstatementGroup.SubstatementConstraint, String> _function = (SubstatementGroup.SubstatementConstraint constraint, String ordinal) -> {
      String _xifexpression = null;
      if (((!this.ordered) && Objects.equal(Integer.valueOf(this.ordinal).toString(), ordinal))) {
        StringConcatenation _builder = new StringConcatenation();
        _builder.append(this.ordinal);
        _xifexpression = _builder.toString();
      } else {
        StringConcatenation _builder_1 = new StringConcatenation();
        _builder_1.append(this.ordinal);
        _builder_1.append(".");
        _builder_1.append(ordinal);
        _xifexpression = _builder_1.toString();
      }
      final String mergedOrdinal = _xifexpression;
      this.orderedConstraint.put(constraint, mergedOrdinal);
    };
    ruleGroup.orderedConstraint.forEach(_function);
    if (this.ordered) {
      this.ordinal++;
    }
    return this;
  }
  
  public void checkSubstatements(final Statement substatementContainer, final ValidationMessageAcceptor acceptor) {
    final EList<Statement> substatements = substatementContainer.getSubstatements();
    final Function1<Statement, EClass> _function = (Statement it) -> {
      return it.eClass();
    };
    final Map<EClass, Statement> substatementTypes = IterableExtensions.<EClass, Statement>toMap(substatements, _function);
    final Function2<EClass, SubstatementGroup.SubstatementConstraint, Boolean> _function_1 = (EClass clazz, SubstatementGroup.SubstatementConstraint constraint) -> {
      return Boolean.valueOf((constraint.cardinality == SubstatementGroup.Cardinality.MUST));
    };
    final Function1<EClass, Boolean> _function_2 = (EClass it) -> {
      boolean _containsKey = substatementTypes.containsKey(it);
      return Boolean.valueOf((!_containsKey));
    };
    final Consumer<EClass> _function_3 = (EClass it) -> {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("Missing mandatory substatement: \'");
      String _yangName = YangNameUtils.getYangName(it);
      _builder.append(_yangName);
      _builder.append("\'.");
      final String message = _builder.toString();
      final TextRegion range = this.getKeywordRange(substatementContainer);
      acceptor.acceptError(message, substatementContainer, range.getOffset(), range.getLength(), IssueCodes.SUBSTATEMENT_CARDINALITY);
    };
    IterableExtensions.<EClass>filter(MapExtensions.<EClass, SubstatementGroup.SubstatementConstraint>filter(this.constraintMapping, _function_1).keySet(), _function_2).forEach(_function_3);
    final Procedure2<Statement, Integer> _function_4 = (Statement statement, Integer index) -> {
      this.checkStatementInContext(statement, substatementContainer, acceptor);
    };
    IterableExtensions.<Statement>forEach(substatements, _function_4);
  }
  
  private TextRegion getKeywordRange(final Statement stmnt) {
    final Function1<ILeafNode, Boolean> _function = (ILeafNode it) -> {
      EObject _grammarElement = it.getGrammarElement();
      return Boolean.valueOf((_grammarElement instanceof Keyword));
    };
    final ILeafNode node = IterableExtensions.<ILeafNode>findFirst(NodeModelUtils.getNode(stmnt).getLeafNodes(), _function);
    int _offset = node.getOffset();
    int _length = node.getLength();
    return new TextRegion(_offset, _length);
  }
  
  public boolean canInsert(final Statement substatementContainer, final EClass toInsert, final int toInsertIndex) {
    final SubstatementGroup.SubstatementConstraint constraint = this.constraintMapping.get(toInsert);
    if ((constraint == null)) {
      return false;
    }
    final SubstatementGroup.Cardinality cardinality = constraint.cardinality;
    final EList<Statement> substatements = substatementContainer.getSubstatements();
    int _size = IterableExtensions.size(Iterables.filter(substatements, toInsert.getInstanceClass()));
    final int elementCount = (_size + 1);
    boolean _contains = cardinality.contains(elementCount);
    boolean _not = (!_contains);
    if (_not) {
      return false;
    }
    final boolean version11 = this.isVersion11(substatementContainer);
    if ((constraint.isVersion11() && (!version11))) {
      return false;
    }
    boolean _isEmpty = substatements.isEmpty();
    boolean _not_1 = (!_isEmpty);
    if (_not_1) {
      final Statement insertAfterStatement = substatements.get(toInsertIndex);
      final SubstatementGroup.SubstatementConstraint insertAfterConstraint = this.constraintMapping.get(insertAfterStatement.eClass());
      if (((insertAfterStatement.eClass() != YangPackage.Literals.UNKNOWN) && (!Objects.equal(constraint, insertAfterConstraint)))) {
        final String ordinal = this.orderedConstraint.get(constraint);
        final String insertAfterOrdinal = this.orderedConstraint.get(insertAfterConstraint);
        boolean _isGreater = this.isGreater(insertAfterOrdinal, ordinal);
        if (_isGreater) {
          return false;
        } else {
          int _size_1 = substatements.size();
          boolean _lessThan = ((toInsertIndex + 1) < _size_1);
          if (_lessThan) {
            final Statement insertBeforeStatement = substatements.get((toInsertIndex + 1));
            final SubstatementGroup.SubstatementConstraint insertBeforeConstraint = this.constraintMapping.get(insertBeforeStatement.eClass());
            if ((insertBeforeConstraint == null)) {
              return false;
            }
            if (((insertBeforeStatement.eClass() != YangPackage.Literals.UNKNOWN) && (!Objects.equal(constraint, insertBeforeConstraint)))) {
              final String insertBeforeOrdinal = this.orderedConstraint.get(insertBeforeConstraint);
              boolean _isGreater_1 = this.isGreater(ordinal, insertBeforeOrdinal);
              if (_isGreater_1) {
                return false;
              }
            }
          }
        }
      }
    }
    return true;
  }
  
  private void checkStatementInContext(final Statement statement, final Statement substatementContainer, final ValidationMessageAcceptor acceptor) {
    final EList<Statement> substatements = substatementContainer.getSubstatements();
    final EClass clazz = statement.eClass();
    if ((clazz == YangPackage.Literals.UNKNOWN)) {
      return;
    }
    final SubstatementGroup.SubstatementConstraint constraint = this.constraintMapping.get(clazz);
    final TextRegion range = this.getKeywordRange(statement);
    final boolean version11 = this.isVersion11(substatementContainer);
    if ((constraint == null)) {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("Unexpected substatement: \'");
      String _yangName = YangNameUtils.getYangName(clazz);
      _builder.append(_yangName);
      _builder.append("\'.");
      final String message = _builder.toString();
      acceptor.acceptError(message, statement, range.getOffset(), range.getLength(), IssueCodes.UNEXPECTED_SUBSTATEMENT);
      return;
    }
    final SubstatementGroup.Cardinality cardinality = constraint.cardinality;
    final int elementCount = IterableExtensions.size(Iterables.filter(substatements, clazz.getInstanceClass()));
    boolean _contains = cardinality.contains(elementCount);
    boolean _not = (!_contains);
    if (_not) {
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("Expected \'");
      String _yangName_1 = YangNameUtils.getYangName(clazz);
      _builder_1.append(_yangName_1);
      _builder_1.append("\' with ");
      _builder_1.append(cardinality);
      _builder_1.append(" cardinality. Got ");
      _builder_1.append(elementCount);
      _builder_1.append(" instead.");
      final String message_1 = _builder_1.toString();
      acceptor.acceptError(message_1, statement, range.getOffset(), range.getLength(), IssueCodes.SUBSTATEMENT_CARDINALITY);
      return;
    }
    if ((constraint.isVersion11() && (!version11))) {
      StringConcatenation _builder_2 = new StringConcatenation();
      _builder_2.append("Statement \'");
      String _yangName_2 = YangNameUtils.getYangName(clazz);
      _builder_2.append(_yangName_2);
      _builder_2.append("\' requires explicit YANG version ");
      _builder_2.append(YangExtensions.YANG_1_1);
      _builder_2.append(".");
      final String message_2 = _builder_2.toString();
      acceptor.acceptError(message_2, statement, range.getOffset(), range.getLength(), IssueCodes.SUBSTATEMENT_CARDINALITY);
      return;
    }
    final int index = substatements.indexOf(statement);
    if ((index < 0)) {
      StringConcatenation _builder_3 = new StringConcatenation();
      _builder_3.append("The context does not contain the given statement: ");
      _builder_3.append(substatements);
      _builder_3.append(", ");
      _builder_3.append(statement);
      _builder_3.append(".");
      throw new IllegalStateException(_builder_3.toString());
    }
    int i = (index - 1);
    String mostSevereErrorMessage = ((String) null);
    while ((i >= 0)) {
      {
        final Statement precedingStatement = substatements.get(i);
        final SubstatementGroup.SubstatementConstraint precedingConstraint = this.constraintMapping.get(precedingStatement.eClass());
        if (((precedingStatement.eClass() != YangPackage.Literals.UNKNOWN) && (!Objects.equal(constraint, precedingConstraint)))) {
          final String ordinal = this.orderedConstraint.get(constraint);
          final String precedingOrdinal = this.orderedConstraint.get(precedingConstraint);
          boolean _isGreater = this.isGreater(precedingOrdinal, ordinal);
          if (_isGreater) {
            mostSevereErrorMessage = YangNameUtils.getYangName(precedingStatement);
          }
        }
        i--;
      }
    }
    if ((mostSevereErrorMessage != null)) {
      StringConcatenation _builder_4 = new StringConcatenation();
      _builder_4.append("Substatement \'");
      String _yangName_3 = YangNameUtils.getYangName(clazz);
      _builder_4.append(_yangName_3);
      _builder_4.append("\' must be declared before \'");
      _builder_4.append(mostSevereErrorMessage);
      _builder_4.append("\'.");
      final String message_3 = _builder_4.toString();
      acceptor.acceptError(message_3, statement, range.getOffset(), range.getLength(), IssueCodes.SUBSTATEMENT_ORDERING);
    }
  }
  
  private boolean isGreater(final String left, final String right) {
    int _compareTo = this.getValue(left).compareTo(this.getValue(right));
    return (_compareTo > 0);
  }
  
  /**
   * Converts the string given in {@code \d(.\d)*} format into a big decimal.
   * For instance 0.0.1 will be 0,01 while 2.1.2.3 will be 2,123 value.
   */
  private BigDecimal getValue(final String it) {
    final Function1<String, Integer> _function = (String it_1) -> {
      return Integer.valueOf(Integer.parseInt(it_1));
    };
    final List<Integer> segments = ListExtensions.<String, Integer>map(Splitter.on(".").trimResults().splitToList(it), _function);
    StringConcatenation _builder = new StringConcatenation();
    Integer _head = IterableExtensions.<Integer>head(segments);
    _builder.append(_head);
    _builder.append(".");
    String _join = IterableExtensions.join(Iterables.<Integer>skip(segments, 1));
    _builder.append(_join);
    return new BigDecimal(_builder.toString());
  }
  
  private boolean isVersion11(final EObject it) {
    Resource _eResource = null;
    if (it!=null) {
      _eResource=it.eResource();
    }
    final Resource resource = _eResource;
    if ((resource instanceof XtextResource)) {
      final YangExtensions yangExtensions = ((XtextResource)resource).getResourceServiceProvider().<YangExtensions>get(YangExtensions.class);
      final String version = yangExtensions.getYangVersion(it);
      return Objects.equal(YangExtensions.YANG_1_1, version);
    }
    return false;
  }
}

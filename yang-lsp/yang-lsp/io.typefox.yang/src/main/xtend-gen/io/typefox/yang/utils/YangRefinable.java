package io.typefox.yang.utils;

import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.base.Supplier;
import com.google.common.base.Suppliers;
import com.google.common.collect.ImmutableList;
import io.typefox.yang.utils.ValidationMessageAcceptorExt;
import io.typefox.yang.validation.IssueCodes;
import io.typefox.yang.yang.BinaryOperation;
import io.typefox.yang.yang.Expression;
import io.typefox.yang.yang.Literal;
import io.typefox.yang.yang.Max;
import io.typefox.yang.yang.Min;
import io.typefox.yang.yang.Refinable;
import io.typefox.yang.yang.YangPackage;
import io.typefox.yang.yang.util.YangSwitch;
import java.math.BigDecimal;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.ListIterator;
import java.util.function.Consumer;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.xtend.lib.annotations.Data;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.validation.ValidationMessageAcceptor;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;
import org.eclipse.xtext.xbase.lib.Pair;
import org.eclipse.xtext.xbase.lib.Pure;
import org.eclipse.xtext.xbase.lib.util.ToStringBuilder;

/**
 * Immutable representation of a <a href="https://tools.ietf.org/html/rfc7950#section-9.2.4">YANG refinable</a>.
 * 
 * @author akos.kitta
 */
@SuppressWarnings("all")
public class YangRefinable {
  @Data
  private static class Cut implements Comparable<YangRefinable.Cut> {
    private final String endpoint;
    
    private final EObject node;
    
    @Override
    public int compareTo(final YangRefinable.Cut o) {
      String _endpoint = null;
      if (o!=null) {
        _endpoint=o.endpoint;
      }
      return YangRefinable.NUMBER_LITERAL_COMPARATOR.compare(this.endpoint, _endpoint);
    }
    
    private boolean isLessThanOrEqual(final YangRefinable.Cut o) {
      int _compareTo = this.compareTo(o);
      boolean _greaterThan = (_compareTo > 0);
      return (!_greaterThan);
    }
    
    private YangRefinable.Cut substitute(final YangRefinable conatiner) {
      YangRefinable.Cut _switchResult = null;
      final String endpoint = this.endpoint;
      if (endpoint != null) {
        switch (endpoint) {
          case YangRefinable.MIN:
            String _min = conatiner.getMin();
            _switchResult = new YangRefinable.Cut(_min, this.node);
            break;
          case YangRefinable.MAX:
            String _max = conatiner.getMax();
            _switchResult = new YangRefinable.Cut(_max, this.node);
            break;
          default:
            _switchResult = this;
            break;
        }
      } else {
        _switchResult = this;
      }
      return _switchResult;
    }
    
    public Cut(final String endpoint, final EObject node) {
      super();
      this.endpoint = endpoint;
      this.node = node;
    }
    
    @Override
    @Pure
    public int hashCode() {
      final int prime = 31;
      int result = 1;
      result = prime * result + ((this.endpoint== null) ? 0 : this.endpoint.hashCode());
      return prime * result + ((this.node== null) ? 0 : this.node.hashCode());
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
      YangRefinable.Cut other = (YangRefinable.Cut) obj;
      if (this.endpoint == null) {
        if (other.endpoint != null)
          return false;
      } else if (!this.endpoint.equals(other.endpoint))
        return false;
      if (this.node == null) {
        if (other.node != null)
          return false;
      } else if (!this.node.equals(other.node))
        return false;
      return true;
    }
    
    @Override
    @Pure
    public String toString() {
      ToStringBuilder b = new ToStringBuilder(this);
      b.add("endpoint", this.endpoint);
      b.add("node", this.node);
      return b.toString();
    }
    
    @Pure
    public String getEndpoint() {
      return this.endpoint;
    }
    
    @Pure
    public EObject getNode() {
      return this.node;
    }
  }
  
  @Data
  private static class Segment {
    private final YangRefinable.Cut lowerBound;
    
    private final YangRefinable.Cut upperBound;
    
    private YangRefinable.Segment substitute(final YangRefinable conatiner) {
      final YangRefinable.Cut sLoweBound = this.lowerBound.substitute(conatiner);
      final YangRefinable.Cut sUpperBound = this.upperBound.substitute(conatiner);
      if (((this.lowerBound != sLoweBound) || (this.upperBound != sUpperBound))) {
        return new YangRefinable.Segment(sLoweBound, sUpperBound);
      }
      return this;
    }
    
    private boolean isRange() {
      return (!Objects.equal(this.lowerBound.endpoint, this.upperBound.endpoint));
    }
    
    @Override
    public String toString() {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append(this.lowerBound.endpoint);
      {
        boolean _isRange = this.isRange();
        if (_isRange) {
          _builder.append("..");
          _builder.append(this.upperBound.endpoint);
        }
      }
      return _builder.toString();
    }
    
    public Segment(final YangRefinable.Cut lowerBound, final YangRefinable.Cut upperBound) {
      super();
      this.lowerBound = lowerBound;
      this.upperBound = upperBound;
    }
    
    @Override
    @Pure
    public int hashCode() {
      final int prime = 31;
      int result = 1;
      result = prime * result + ((this.lowerBound== null) ? 0 : this.lowerBound.hashCode());
      return prime * result + ((this.upperBound== null) ? 0 : this.upperBound.hashCode());
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
      YangRefinable.Segment other = (YangRefinable.Segment) obj;
      if (this.lowerBound == null) {
        if (other.lowerBound != null)
          return false;
      } else if (!this.lowerBound.equals(other.lowerBound))
        return false;
      if (this.upperBound == null) {
        if (other.upperBound != null)
          return false;
      } else if (!this.upperBound.equals(other.upperBound))
        return false;
      return true;
    }
    
    @Pure
    public YangRefinable.Cut getLowerBound() {
      return this.lowerBound;
    }
    
    @Pure
    public YangRefinable.Cut getUpperBound() {
      return this.upperBound;
    }
  }
  
  /**
   * YANG refinement visitor that transforms the AST nodes into a list of range strings.
   */
  private static class RefinableTransformer extends YangSwitch<List<Pair<String, EObject>>> implements Function1<Refinable, Iterable<YangRefinable.Cut>> {
    @Override
    public Iterable<YangRefinable.Cut> apply(final Refinable it) {
      final Function1<Pair<String, EObject>, YangRefinable.Cut> _function = (Pair<String, EObject> it_1) -> {
        String _key = it_1.getKey();
        EObject _value = it_1.getValue();
        return new YangRefinable.Cut(_key, _value);
      };
      return ListExtensions.<Pair<String, EObject>, YangRefinable.Cut>map(this.doSwitch(it), _function);
    }
    
    @Override
    public List<Pair<String, EObject>> caseRefinable(final Refinable it) {
      return this.doSwitch(it.getExpression());
    }
    
    @Override
    public List<Pair<String, EObject>> caseBinaryOperation(final BinaryOperation it) {
      final ImmutableList.Builder<Pair<String, EObject>> builder = ImmutableList.<Pair<String, EObject>>builder();
      ImmutableList.Builder<Pair<String, EObject>> _addAll = builder.addAll(this.doSwitch(it.getLeft()));
      String _trim = it.getOperator().trim();
      Pair<String, EObject> _mappedTo = Pair.<String, EObject>of(_trim, null);
      _addAll.add(_mappedTo).addAll(this.doSwitch(it.getRight()));
      return builder.build();
    }
    
    @Override
    public List<Pair<String, EObject>> caseMin(final Min it) {
      Pair<String, EObject> _mappedTo = Pair.<String, EObject>of(YangRefinable.MIN, it);
      return Collections.<Pair<String, EObject>>unmodifiableList(CollectionLiterals.<Pair<String, EObject>>newArrayList(_mappedTo));
    }
    
    @Override
    public List<Pair<String, EObject>> caseMax(final Max it) {
      Pair<String, EObject> _mappedTo = Pair.<String, EObject>of(YangRefinable.MAX, it);
      return Collections.<Pair<String, EObject>>unmodifiableList(CollectionLiterals.<Pair<String, EObject>>newArrayList(_mappedTo));
    }
    
    @Override
    public List<Pair<String, EObject>> caseLiteral(final Literal it) {
      String _trim = it.getValue().trim();
      Pair<String, EObject> _mappedTo = Pair.<String, EObject>of(_trim, it);
      return Collections.<Pair<String, EObject>>unmodifiableList(CollectionLiterals.<Pair<String, EObject>>newArrayList(_mappedTo));
    }
  }
  
  /**
   * NOOP refinable. The validation does nothing on this instance.
   */
  public static final YangRefinable NOOP = new YangRefinable(CollectionLiterals.<YangRefinable.Cut>emptyList(), null) {
    @Override
    public boolean validate(final ValidationMessageAcceptor it) {
      return true;
    }
    
    @Override
    public String toString() {
      return "NOOP";
    }
  };
  
  private static final String MIN = "min";
  
  private static final String MAX = "max";
  
  /**
   * Null-safe comparator that creates {@link BigDecimal}s from the string literal arguments and compares the
   * values of the big decimals.
   * <p>
   * The arguments could be {@code null}, but if present must be a valid value literal.
   * 
   * @see BigDecimal#BigDecimal(String)
   */
  private static final Comparator<String> NUMBER_LITERAL_COMPARATOR = ((Comparator<String>) (String left, String right) -> {
    final Comparator<BigDecimal> _function = (BigDecimal o1, BigDecimal o2) -> {
      return o1.compareTo(o2);
    };
    final Comparator<BigDecimal> nullSafe = Comparator.<BigDecimal>nullsLast(_function);
    return nullSafe.compare(YangRefinable.VALUE_CONVERTER.apply(left), YangRefinable.VALUE_CONVERTER.apply(right));
  });
  
  private static final Function1<? super String, ? extends BigDecimal> VALUE_CONVERTER = ((Function1<String, BigDecimal>) (String it) -> {
    if ((it == null)) {
      return null;
    }
    try {
      return new BigDecimal(it);
    } catch (final Throwable _t) {
      if (_t instanceof NumberFormatException) {
        final NumberFormatException e = (NumberFormatException)_t;
        e.printStackTrace();
        return null;
      } else {
        throw Exceptions.sneakyThrow(_t);
      }
    }
  });
  
  private final YangRefinable parentRange;
  
  private final List<YangRefinable.Segment> segments;
  
  private final Supplier<String> minSupplier;
  
  private final Supplier<String> maxSupplier;
  
  /**
   * Use {@link YangTypesExtensions#getYangRefinable(Refinable)} instead.
   */
  public static YangRefinable create(final Refinable refinable, final YangRefinable parentRange) {
    Preconditions.<YangRefinable>checkNotNull(parentRange, "parentRange");
    Iterable<YangRefinable.Cut> _apply = new YangRefinable.RefinableTransformer().apply(refinable);
    return new YangRefinable(_apply, parentRange);
  }
  
  /**
   * This should be used only for built-in type definition.
   */
  public static YangRefinable createBuiltin(final String lowerBound, final String upperBound) {
    YangRefinable.Cut _cut = new YangRefinable.Cut(lowerBound, null);
    YangRefinable.Cut _cut_1 = new YangRefinable.Cut("..", null);
    YangRefinable.Cut _cut_2 = new YangRefinable.Cut(upperBound, null);
    return new YangRefinable(Collections.<YangRefinable.Cut>unmodifiableList(CollectionLiterals.<YangRefinable.Cut>newArrayList(_cut, _cut_1, _cut_2)), null);
  }
  
  private YangRefinable(final Iterable<YangRefinable.Cut> segments, final YangRefinable parentRange) {
    final ImmutableList.Builder<YangRefinable.Segment> builder = ImmutableList.<YangRefinable.Segment>builder();
    final ListIterator<YangRefinable.Cut> itr = IterableExtensions.<YangRefinable.Cut>toList(segments).listIterator();
    while (itr.hasNext()) {
      {
        final YangRefinable.Cut lowerCandidate = itr.next();
        final boolean wait = (itr.hasNext() && Objects.equal(itr.next().endpoint, ".."));
        if (wait) {
          YangRefinable.Cut _next = itr.next();
          YangRefinable.Segment _segment = new YangRefinable.Segment(lowerCandidate, _next);
          builder.add(_segment);
          boolean _hasNext = itr.hasNext();
          if (_hasNext) {
            itr.next();
          }
        } else {
          YangRefinable.Segment _segment_1 = new YangRefinable.Segment(lowerCandidate, lowerCandidate);
          builder.add(_segment_1);
        }
      }
    }
    this.segments = builder.build();
    this.parentRange = parentRange;
    final Supplier<String> _function = () -> {
      final YangRefinable.Cut max = IterableExtensions.<YangRefinable.Segment>last(this.segments).upperBound;
      String _xifexpression = null;
      boolean _equals = Objects.equal(max.endpoint, YangRefinable.MAX);
      if (_equals) {
        String _xblockexpression = null;
        {
          StringConcatenation _builder = new StringConcatenation();
          _builder.append("Cannot substitute \'");
          _builder.append(YangRefinable.MAX);
          _builder.append("\' keyword when parent refinement is not specified.");
          Preconditions.checkState((this.parentRange != 
            null), _builder);
          _xblockexpression = this.parentRange.getMax();
        }
        _xifexpression = _xblockexpression;
      } else {
        _xifexpression = max.endpoint;
      }
      return _xifexpression;
    };
    this.maxSupplier = Suppliers.<String>memoize(_function);
    final Supplier<String> _function_1 = () -> {
      final YangRefinable.Cut min = IterableExtensions.<YangRefinable.Segment>head(this.segments).lowerBound;
      String _xifexpression = null;
      boolean _equals = Objects.equal(min.endpoint, YangRefinable.MIN);
      if (_equals) {
        String _xblockexpression = null;
        {
          StringConcatenation _builder = new StringConcatenation();
          _builder.append("Cannot substitute \'");
          _builder.append(YangRefinable.MIN);
          _builder.append("\' keyword when parent refinement is not specified.");
          Preconditions.checkState((this.parentRange != 
            null), _builder);
          _xblockexpression = this.parentRange.getMin();
        }
        _xifexpression = _xblockexpression;
      } else {
        _xifexpression = min.endpoint;
      }
      return _xifexpression;
    };
    this.minSupplier = Suppliers.<String>memoize(_function_1);
  }
  
  /**
   * Returns {@code true} if the refinement is valid, otherwise returns {@code false}.
   */
  public boolean validate(final ValidationMessageAcceptor it) {
    if ((this.parentRange == null)) {
      return true;
    }
    final ValidationMessageAcceptorExt acceptor = ValidationMessageAcceptorExt.wrappedAcceptor(it);
    return (this.checkDisjointOrder(acceptor) && this.checkContains(this.parentRange, acceptor));
  }
  
  @Override
  public String toString() {
    final Function1<YangRefinable.Segment, String> _function = (YangRefinable.Segment it) -> {
      return this.getLabel(it);
    };
    return IterableExtensions.join(ListExtensions.<YangRefinable.Segment, String>map(this.segments, _function), " | ");
  }
  
  /**
   * If multiple values or refinement are given, they all must be disjoint and must be in ascending order.
   * 
   * See: https://tools.ietf.org/html/rfc7950#section-9.2.4
   */
  private boolean checkDisjointOrder(final ValidationMessageAcceptorExt acceptor) {
    for (int i = 1; (i < this.segments.size()); i++) {
      {
        final YangRefinable.Segment previous = this.segments.get((i - 1)).substitute(this);
        final YangRefinable.Segment current = this.segments.get(i).substitute(this);
        String _xifexpression = null;
        boolean _isLessThanOrEqual = current.lowerBound.isLessThanOrEqual(previous.upperBound);
        if (_isLessThanOrEqual) {
          StringConcatenation _builder = new StringConcatenation();
          _builder.append("Each range restriction must be disjoint.");
          _xifexpression = _builder.toString();
        } else {
          String _xifexpression_1 = null;
          boolean _isLessThanOrEqual_1 = current.upperBound.isLessThanOrEqual(previous.lowerBound);
          if (_isLessThanOrEqual_1) {
            StringConcatenation _builder_1 = new StringConcatenation();
            _builder_1.append("Each range restriction must be in ascending order.");
            _xifexpression_1 = _builder_1.toString();
          } else {
            _xifexpression_1 = null;
          }
          _xifexpression = _xifexpression_1;
        }
        final String message = _xifexpression;
        if ((message != null)) {
          this.acceptError(current, acceptor, message);
        }
      }
    }
    boolean _hasError = acceptor.hasError();
    return (!_hasError);
  }
  
  /**
   * Checks whether the segment argument is contained in the current segment.
   * More formally, the lower bound of the current is less than or equals the lower
   * bound of the other, and the upper bound of the argument is less than or equals
   * the upper bound of the current one.
   * 
   * See: https://tools.ietf.org/html/rfc7950#section-9.2.4
   */
  private boolean checkContains(final YangRefinable other, final ValidationMessageAcceptorExt acceptor) {
    final Function1<YangRefinable.Segment, YangRefinable.Segment> _function = (YangRefinable.Segment it) -> {
      return it.substitute(this);
    };
    final Consumer<YangRefinable.Segment> _function_1 = (YangRefinable.Segment current) -> {
      final Function1<YangRefinable.Segment, YangRefinable.Segment> _function_2 = (YangRefinable.Segment it) -> {
        return it.substitute(other);
      };
      final Function1<YangRefinable.Segment, Boolean> _function_3 = (YangRefinable.Segment parent) -> {
        return Boolean.valueOf((parent.lowerBound.isLessThanOrEqual(current.lowerBound) && 
          current.upperBound.isLessThanOrEqual(parent.upperBound)));
      };
      boolean _exists = IterableExtensions.<YangRefinable.Segment>exists(ListExtensions.<YangRefinable.Segment, YangRefinable.Segment>map(other.segments, _function_2), _function_3);
      boolean _not = (!_exists);
      if (_not) {
        StringConcatenation _builder = new StringConcatenation();
        _builder.append("The ");
        {
          boolean _isRange = current.isRange();
          if (_isRange) {
            _builder.append("range");
          } else {
            _builder.append("explicit value");
          }
        }
        _builder.append(" \"");
        _builder.append(current);
        _builder.append("\" is not valid for the base type.");
        final String message = _builder.toString();
        this.acceptError(current, acceptor, message);
      }
    };
    ListExtensions.<YangRefinable.Segment, YangRefinable.Segment>map(this.segments, _function).forEach(_function_1);
    boolean _hasError = acceptor.hasError();
    return (!_hasError);
  }
  
  private void acceptError(final YangRefinable.Segment segment, @Extension final ValidationMessageAcceptor acceptor, final String message) {
    final YangRefinable.Cut lowerBound = segment.lowerBound;
    final EObject astNode = lowerBound.node;
    final String code = IssueCodes.TYPE_ERROR;
    final int index = ValidationMessageAcceptor.INSIGNIFICANT_INDEX;
    EObject _xifexpression = null;
    EObject _eContainer = astNode.eContainer();
    if ((_eContainer instanceof BinaryOperation)) {
      _xifexpression = astNode.eContainer();
    } else {
      _xifexpression = astNode;
    }
    final EObject object = _xifexpression;
    if ((object instanceof Literal)) {
      acceptor.acceptError(message, object, YangPackage.Literals.LITERAL__VALUE, index, code);
    } else {
      if (((object instanceof Min) || (object instanceof Max))) {
        EObject _eContainer_1 = object.eContainer();
        final BinaryOperation op = ((BinaryOperation) _eContainer_1);
        EReference _xifexpression_1 = null;
        Expression _right = op.getRight();
        boolean _tripleEquals = (_right == object);
        if (_tripleEquals) {
          _xifexpression_1 = YangPackage.Literals.BINARY_OPERATION__RIGHT;
        } else {
          _xifexpression_1 = YangPackage.Literals.BINARY_OPERATION__RIGHT;
        }
        final EReference feature = _xifexpression_1;
        acceptor.acceptError(message, op, feature, index, code);
      } else {
        if ((object instanceof BinaryOperation)) {
          EReference _xifexpression_2 = null;
          String _operator = ((BinaryOperation)object).getOperator();
          boolean _equals = Objects.equal(_operator, "..");
          if (_equals) {
            _xifexpression_2 = null;
          } else {
            EReference _xifexpression_3 = null;
            Expression _right_1 = ((BinaryOperation)object).getRight();
            boolean _tripleEquals_1 = (_right_1 == astNode);
            if (_tripleEquals_1) {
              _xifexpression_3 = YangPackage.Literals.BINARY_OPERATION__RIGHT;
            } else {
              EReference _xifexpression_4 = null;
              Expression _left = ((BinaryOperation)object).getLeft();
              boolean _tripleEquals_2 = (_left == astNode);
              if (_tripleEquals_2) {
                _xifexpression_4 = YangPackage.Literals.BINARY_OPERATION__LEFT;
              } else {
                _xifexpression_4 = null;
              }
              _xifexpression_3 = _xifexpression_4;
            }
            _xifexpression_2 = _xifexpression_3;
          }
          final EReference feature_1 = _xifexpression_2;
          acceptor.acceptError(message, object, feature_1, index, code);
        }
      }
    }
  }
  
  private String getMin() {
    return this.minSupplier.get();
  }
  
  private String getMax() {
    return this.maxSupplier.get();
  }
  
  private String getLabel(final YangRefinable.Segment it) {
    final Function1<YangRefinable.Cut, YangRefinable.Cut> _function = (YangRefinable.Cut it_1) -> {
      return it_1.substitute(this);
    };
    final Function1<YangRefinable.Cut, String> _function_1 = (YangRefinable.Cut it_1) -> {
      return it_1.endpoint;
    };
    final List<String> bounds = ListExtensions.<YangRefinable.Cut, String>map(ListExtensions.<YangRefinable.Cut, YangRefinable.Cut>map(Collections.<YangRefinable.Cut>unmodifiableList(CollectionLiterals.<YangRefinable.Cut>newArrayList(it.lowerBound, it.upperBound)), _function), _function_1);
    StringConcatenation _builder = new StringConcatenation();
    String _head = IterableExtensions.<String>head(bounds);
    _builder.append(_head);
    {
      String _head_1 = IterableExtensions.<String>head(bounds);
      String _last = IterableExtensions.<String>last(bounds);
      boolean _notEquals = (!Objects.equal(_head_1, _last));
      if (_notEquals) {
        _builder.append("..");
        String _last_1 = IterableExtensions.<String>last(bounds);
        _builder.append(_last_1);
      }
    }
    return _builder.toString();
  }
}

package io.typefox.yang.validation;

import com.google.common.base.Objects;
import com.google.common.collect.Iterables;
import com.google.common.collect.Multimap;
import com.google.common.collect.Range;
import com.google.inject.Inject;
import com.google.inject.Singleton;
import io.typefox.yang.utils.IterableExtensions2;
import io.typefox.yang.utils.YangExtensions;
import io.typefox.yang.utils.YangNameUtils;
import io.typefox.yang.utils.YangTypesExtensions;
import io.typefox.yang.validation.IssueCodes;
import io.typefox.yang.yang.Bit;
import io.typefox.yang.yang.Enumerable;
import io.typefox.yang.yang.Ordered;
import io.typefox.yang.yang.Position;
import io.typefox.yang.yang.Type;
import io.typefox.yang.yang.Value;
import io.typefox.yang.yang.YangPackage;
import java.util.ArrayList;
import java.util.Collection;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.xtend.lib.annotations.Data;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.util.Strings;
import org.eclipse.xtext.validation.ValidationMessageAcceptor;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.Pure;
import org.eclipse.xtext.xbase.lib.util.ToStringBuilder;

/**
 * Validator for YANG enumeration and bits types.
 * 
 * @author akos.kitta
 */
@Singleton
@SuppressWarnings("all")
public class YangEnumerableValidator {
  @Data
  private static class Context {
    private final Type astNode;
    
    private final String name;
    
    private final Class<? extends Enumerable> enumerableClass;
    
    private final Class<? extends Ordered> orderedClass;
    
    private final Range<Integer> substatementCardinality;
    
    private final Range<Long> ordinalRange;
    
    public Context(final Type astNode, final String name, final Class<? extends Enumerable> enumerableClass, final Class<? extends Ordered> orderedClass, final Range<Integer> substatementCardinality, final Range<Long> ordinalRange) {
      super();
      this.astNode = astNode;
      this.name = name;
      this.enumerableClass = enumerableClass;
      this.orderedClass = orderedClass;
      this.substatementCardinality = substatementCardinality;
      this.ordinalRange = ordinalRange;
    }
    
    @Override
    @Pure
    public int hashCode() {
      final int prime = 31;
      int result = 1;
      result = prime * result + ((this.astNode== null) ? 0 : this.astNode.hashCode());
      result = prime * result + ((this.name== null) ? 0 : this.name.hashCode());
      result = prime * result + ((this.enumerableClass== null) ? 0 : this.enumerableClass.hashCode());
      result = prime * result + ((this.orderedClass== null) ? 0 : this.orderedClass.hashCode());
      result = prime * result + ((this.substatementCardinality== null) ? 0 : this.substatementCardinality.hashCode());
      return prime * result + ((this.ordinalRange== null) ? 0 : this.ordinalRange.hashCode());
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
      YangEnumerableValidator.Context other = (YangEnumerableValidator.Context) obj;
      if (this.astNode == null) {
        if (other.astNode != null)
          return false;
      } else if (!this.astNode.equals(other.astNode))
        return false;
      if (this.name == null) {
        if (other.name != null)
          return false;
      } else if (!this.name.equals(other.name))
        return false;
      if (this.enumerableClass == null) {
        if (other.enumerableClass != null)
          return false;
      } else if (!this.enumerableClass.equals(other.enumerableClass))
        return false;
      if (this.orderedClass == null) {
        if (other.orderedClass != null)
          return false;
      } else if (!this.orderedClass.equals(other.orderedClass))
        return false;
      if (this.substatementCardinality == null) {
        if (other.substatementCardinality != null)
          return false;
      } else if (!this.substatementCardinality.equals(other.substatementCardinality))
        return false;
      if (this.ordinalRange == null) {
        if (other.ordinalRange != null)
          return false;
      } else if (!this.ordinalRange.equals(other.ordinalRange))
        return false;
      return true;
    }
    
    @Override
    @Pure
    public String toString() {
      ToStringBuilder b = new ToStringBuilder(this);
      b.add("astNode", this.astNode);
      b.add("name", this.name);
      b.add("enumerableClass", this.enumerableClass);
      b.add("orderedClass", this.orderedClass);
      b.add("substatementCardinality", this.substatementCardinality);
      b.add("ordinalRange", this.ordinalRange);
      return b.toString();
    }
    
    @Pure
    public Type getAstNode() {
      return this.astNode;
    }
    
    @Pure
    public String getName() {
      return this.name;
    }
    
    @Pure
    public Class<? extends Enumerable> getEnumerableClass() {
      return this.enumerableClass;
    }
    
    @Pure
    public Class<? extends Ordered> getOrderedClass() {
      return this.orderedClass;
    }
    
    @Pure
    public Range<Integer> getSubstatementCardinality() {
      return this.substatementCardinality;
    }
    
    @Pure
    public Range<Long> getOrdinalRange() {
      return this.ordinalRange;
    }
  }
  
  @Inject
  @Extension
  private YangExtensions _yangExtensions;
  
  @Inject
  @Extension
  private YangTypesExtensions _yangTypesExtensions;
  
  public void validateEnumerable(final Type type, final ValidationMessageAcceptor acceptor) {
    final YangEnumerableValidator.Context context = this.getContext(type);
    if ((context == null)) {
      return;
    }
    final Type it = context.astNode;
    final long minValid = context.ordinalRange.lowerEndpoint().longValue();
    final long maxValid = context.ordinalRange.upperEndpoint().longValue();
    final String enumerableName = YangNameUtils.getYangName(context.enumerableClass);
    final String orderedName = YangNameUtils.getYangName(context.enumerableClass);
    final Iterable<? extends Enumerable> enumerables = this._yangExtensions.<Enumerable>substatementsOfType(it, context.enumerableClass);
    if (((!context.substatementCardinality.contains(Integer.valueOf(IterableExtensions.size(enumerables)))) && this._yangTypesExtensions.isBuiltin(it))) {
      StringConcatenation _builder = new StringConcatenation();
      String _firstUpper = Strings.toFirstUpper(context.name);
      _builder.append(_firstUpper);
      _builder.append(" type must have at least one \"");
      _builder.append(enumerableName);
      _builder.append("\" statement.");
      final String message = _builder.toString();
      this.error(acceptor, message, it, YangPackage.Literals.TYPE__TYPE_REF, IssueCodes.TYPE_ERROR);
    } else {
      final Function1<Enumerable, String> _function = (Enumerable it_1) -> {
        return it_1.getName();
      };
      final BiConsumer<String, Collection<Enumerable>> _function_1 = (String name, Collection<Enumerable> statementsWithSameName) -> {
        int _size = statementsWithSameName.size();
        boolean _greaterThan = (_size > 1);
        if (_greaterThan) {
          final Consumer<Enumerable> _function_2 = (Enumerable it_1) -> {
            StringConcatenation _builder_1 = new StringConcatenation();
            _builder_1.append("The ");
            _builder_1.append(orderedName);
            _builder_1.append(" name has already been used for the ");
            _builder_1.append(context.name);
            _builder_1.append(".");
            final String message_1 = _builder_1.toString();
            this.error(acceptor, message_1, it_1, YangPackage.Literals.ENUMERABLE__NAME, IssueCodes.DUPLICATE_ENUMERABLE_NAME);
          };
          statementsWithSameName.forEach(_function_2);
        }
      };
      IterableExtensions2.<String, Enumerable>toMultimap(enumerables, _function).asMap().forEach(_function_1);
      final Function1<Enumerable, Ordered> _function_2 = (Enumerable it_1) -> {
        return this._yangExtensions.<Ordered>firstSubstatementsOfType(it_1, context.orderedClass);
      };
      final Iterable<Ordered> allOrdinals = IterableExtensions.map(enumerables, _function_2);
      final Function1<Ordered, String> _function_3 = (Ordered it_1) -> {
        return it_1.getOrdinal();
      };
      final BiConsumer<String, Collection<Ordered>> _function_4 = (String ordinal, Collection<Ordered> statementsWithSameOrdinal) -> {
        int _size = statementsWithSameOrdinal.size();
        boolean _greaterThan = (_size > 1);
        if (_greaterThan) {
          final Consumer<Ordered> _function_5 = (Ordered it_1) -> {
            StringConcatenation _builder_1 = new StringConcatenation();
            _builder_1.append("The integer value ");
            _builder_1.append(orderedName);
            _builder_1.append("s has already been used for the ");
            _builder_1.append(context.name);
            _builder_1.append(".");
            final String message_1 = _builder_1.toString();
            this.error(acceptor, message_1, it_1, YangPackage.Literals.ORDERED__ORDINAL, IssueCodes.DUPLICATE_ENUMERABLE_VALUE);
          };
          statementsWithSameOrdinal.forEach(_function_5);
        }
      };
      IterableExtensions2.<String, Ordered>toMultimap(IterableExtensions.<Ordered>filterNull(allOrdinals), _function_3).asMap().forEach(_function_4);
      final ArrayList<Long> maxOrdinal = CollectionLiterals.<Long>newArrayList(Long.valueOf(minValid));
      final Consumer<Enumerable> _function_5 = (Enumerable it_1) -> {
        final Ordered ordered = this._yangExtensions.<Ordered>firstSubstatementsOfType(it_1, context.orderedClass);
        String _ordinal = null;
        if (ordered!=null) {
          _ordinal=ordered.getOrdinal();
        }
        final String ordinal = _ordinal;
        if ((ordinal != null)) {
          try {
            final long value = Long.parseLong(ordinal);
            if (((value < minValid) || (value > maxValid))) {
              throw new NumberFormatException();
            }
            long _longValue = IterableExtensions.<Long>head(maxOrdinal).longValue();
            boolean _greaterThan = (value > _longValue);
            if (_greaterThan) {
              maxOrdinal.set(0, Long.valueOf(value));
            }
          } catch (final Throwable _t) {
            if (_t instanceof NumberFormatException) {
              StringConcatenation _builder_1 = new StringConcatenation();
              _builder_1.append("The ");
              _builder_1.append(enumerableName);
              _builder_1.append(" value is not an integer between ");
              _builder_1.append(minValid);
              _builder_1.append(" and ");
              _builder_1.append(maxValid);
              _builder_1.append(".");
              final String message_1 = _builder_1.toString();
              this.error(acceptor, message_1, ordered, YangPackage.Literals.ORDERED__ORDINAL, IssueCodes.ORDINAL_VALUE);
            } else {
              throw Exceptions.sneakyThrow(_t);
            }
          }
        } else {
          long _longValue_1 = IterableExtensions.<Long>head(maxOrdinal).longValue();
          boolean _greaterEqualsThan = (_longValue_1 >= maxValid);
          if (_greaterEqualsThan) {
            StringConcatenation _builder_2 = new StringConcatenation();
            _builder_2.append("Cannot automatically asign a value to ");
            _builder_2.append(orderedName);
            _builder_2.append(". An explicit ");
            _builder_2.append(orderedName);
            _builder_2.append(" has to be assigned instead.");
            final String message_2 = _builder_2.toString();
            this.error(acceptor, message_2, it_1, YangPackage.Literals.ENUMERABLE__NAME, IssueCodes.ORDINAL_VALUE);
          } else {
            long _longValue_2 = IterableExtensions.<Long>head(maxOrdinal).longValue();
            long _plus = (_longValue_2 + 1L);
            maxOrdinal.set(0, Long.valueOf(_plus));
          }
        }
      };
      enumerables.forEach(_function_5);
      boolean _isBuiltin = this._yangTypesExtensions.isBuiltin(it);
      boolean _not = (!_isBuiltin);
      if (_not) {
        final Type currentType = it;
        final Function1<Type, Boolean> _function_6 = (Type it_1) -> {
          return Boolean.valueOf((it_1 != currentType));
        };
        final Function1<Type, Iterable<? extends Enumerable>> _function_7 = (Type it_1) -> {
          return this._yangExtensions.<Enumerable>substatementsOfType(it_1, context.enumerableClass);
        };
        final Function1<Enumerable, String> _function_8 = (Enumerable it_1) -> {
          return it_1.getName();
        };
        final Multimap<String, Enumerable> allEnumerablesNames = IterableExtensions2.<String, Enumerable>toMultimap(Iterables.<Enumerable>concat(IterableExtensions.<Type, Iterable<? extends Enumerable>>map(IterableExtensions.<Type>filter(this._yangTypesExtensions.getTypeHierarchy(it), _function_6), _function_7)), _function_8);
        final Consumer<Enumerable> _function_9 = (Enumerable it_1) -> {
          StringConcatenation _builder_1 = new StringConcatenation();
          _builder_1.append("A new assigned name must not declared when restricting an existing ");
          _builder_1.append(context.name);
          _builder_1.append(" type.");
          final String message_1 = _builder_1.toString();
          final Collection<Enumerable> enumerablesWithSameNames = allEnumerablesNames.get(it_1.getName());
          boolean _isNullOrEmpty = IterableExtensions.isNullOrEmpty(enumerablesWithSameNames);
          if (_isNullOrEmpty) {
            this.error(acceptor, message_1, it_1, YangPackage.Literals.ENUMERABLE__NAME, IssueCodes.ENUMERABLE_RESTRICTION_NAME);
          } else {
            final Ordered ordered = this._yangExtensions.<Ordered>firstSubstatementsOfType(it_1, context.orderedClass);
            String _ordinal = null;
            if (ordered!=null) {
              _ordinal=ordered.getOrdinal();
            }
            final String ordinal = _ordinal;
            final Function1<Enumerable, Ordered> _function_10 = (Enumerable it_2) -> {
              return this._yangExtensions.<Ordered>firstSubstatementsOfType(it_2, context.orderedClass);
            };
            final Function1<Ordered, String> _function_11 = (Ordered it_2) -> {
              return it_2.getOrdinal();
            };
            final Iterable<String> parentOrdinals = IterableExtensions.<Ordered, String>map(IterableExtensions.<Ordered>filterNull(IterableExtensions.<Enumerable, Ordered>map(enumerablesWithSameNames, _function_10)), _function_11);
            if (((ordinal != null) && (!IterableExtensions.<String>exists(parentOrdinals, ((Function1<String, Boolean>) (String it_2) -> {
              return Boolean.valueOf(Objects.equal(ordinal, it_2));
            }))))) {
              this.error(acceptor, message_1, it_1, YangPackage.Literals.ENUMERABLE__NAME, IssueCodes.ENUMERABLE_RESTRICTION_VALUE);
            }
          }
        };
        enumerables.forEach(_function_9);
      }
    }
  }
  
  private YangEnumerableValidator.Context getContext(final Type it) {
    YangEnumerableValidator.Context _switchResult = null;
    boolean _matched = false;
    boolean _isSubtypeOfEnumeration = this._yangTypesExtensions.isSubtypeOfEnumeration(it);
    if (_isSubtypeOfEnumeration) {
      _matched=true;
      YangEnumerableValidator.Context _xblockexpression = null;
      {
        final Range<Integer> cardinalityRange = Range.<Integer>closed(Integer.valueOf(0), Integer.valueOf(Integer.MAX_VALUE));
        final Range<Long> ordinalRange = Range.<Long>closed(Long.valueOf((-2147483648L)), Long.valueOf(2147483647L));
        _xblockexpression = new YangEnumerableValidator.Context(it, "enumeration", io.typefox.yang.yang.Enum.class, Value.class, cardinalityRange, ordinalRange);
      }
      _switchResult = _xblockexpression;
    }
    if (!_matched) {
      boolean _isSubtypeOfBits = this._yangTypesExtensions.isSubtypeOfBits(it);
      if (_isSubtypeOfBits) {
        _matched=true;
        YangEnumerableValidator.Context _xblockexpression_1 = null;
        {
          final Range<Integer> cardinalityRange = Range.<Integer>closed(Integer.valueOf(1), Integer.valueOf(Integer.MAX_VALUE));
          final Range<Long> ordinalRange = Range.<Long>closed(Long.valueOf(0L), Long.valueOf(4294967295L));
          _xblockexpression_1 = new YangEnumerableValidator.Context(it, "bits", Bit.class, Position.class, cardinalityRange, ordinalRange);
        }
        _switchResult = _xblockexpression_1;
      }
    }
    if (!_matched) {
      _switchResult = null;
    }
    return _switchResult;
  }
  
  private void error(final ValidationMessageAcceptor it, final String message, final EObject object, final EStructuralFeature feature, final String issueCode) {
    it.acceptError(message, object, feature, (-1), issueCode);
  }
}

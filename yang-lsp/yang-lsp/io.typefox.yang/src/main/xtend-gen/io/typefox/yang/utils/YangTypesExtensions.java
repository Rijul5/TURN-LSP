package io.typefox.yang.utils;

import com.google.common.base.Objects;
import com.google.common.base.Supplier;
import com.google.common.base.Suppliers;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Iterables;
import com.google.inject.Inject;
import com.google.inject.Singleton;
import io.typefox.yang.services.YangGrammarAccess;
import io.typefox.yang.utils.YangExtensions;
import io.typefox.yang.utils.YangRefinable;
import io.typefox.yang.yang.FractionDigits;
import io.typefox.yang.yang.Length;
import io.typefox.yang.yang.Range;
import io.typefox.yang.yang.Refinable;
import io.typefox.yang.yang.Type;
import io.typefox.yang.yang.TypeReference;
import io.typefox.yang.yang.Typedef;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Map;
import java.util.Stack;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.Keyword;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;
import org.eclipse.xtext.xbase.lib.Pair;

/**
 * Extensions for YANG <a href="https://tools.ietf.org/html/rfc7950#section-9.2">built-in types</a>.
 * 
 * @author akos.kitta
 */
@Singleton
@SuppressWarnings("all")
public class YangTypesExtensions {
  /**
   * Contains a couple of ranges for the YANG built-in types.
   */
  public static abstract class BuiltinRanges {
    private static final String MIN_64_LITERAL = "-9223372036854775808";
    
    private static final String MAX_64_LITERAL = "9223372036854775807";
    
    private static final BigDecimal MIN_64_BASE = new BigDecimal(YangTypesExtensions.BuiltinRanges.MIN_64_LITERAL);
    
    private static final BigDecimal MAX_64_BASE = new BigDecimal(YangTypesExtensions.BuiltinRanges.MAX_64_LITERAL);
    
    private static final YangRefinable INT_8 = YangRefinable.createBuiltin("-128", "127");
    
    private static final YangRefinable INT_16 = YangRefinable.createBuiltin("-32768", "32767");
    
    private static final YangRefinable INT_32 = YangRefinable.createBuiltin("-2147483648", "2147483647");
    
    private static final YangRefinable INT_64 = YangRefinable.createBuiltin(YangTypesExtensions.BuiltinRanges.MIN_64_LITERAL, YangTypesExtensions.BuiltinRanges.MAX_64_LITERAL);
    
    private static final YangRefinable UINT_8 = YangRefinable.createBuiltin("0", "255");
    
    private static final YangRefinable UINT_16 = YangRefinable.createBuiltin("0", "65535");
    
    private static final YangRefinable UINT_32 = YangRefinable.createBuiltin("0", "4294967295");
    
    private static final YangRefinable UINT_64 = YangRefinable.createBuiltin("0", "18446744073709551615");
  }
  
  @Inject
  @Extension
  private YangExtensions _yangExtensions;
  
  @Inject
  private YangGrammarAccess grammarAccess;
  
  private final Supplier<Collection<String>> builtinNames = Suppliers.<Collection<String>>memoize(((Supplier<Collection<String>>) () -> {
    final Function1<Keyword, String> _function = (Keyword it) -> {
      return it.getValue();
    };
    return ImmutableSet.<String>copyOf(IterableExtensions.<Keyword, String>map(Iterables.<Keyword>filter(this.grammarAccess.getBUILTIN_TYPEAccess().getAlternatives().getElements(), Keyword.class), _function));
  }));
  
  private final Supplier<Map<String, YangRefinable>> integerBuiltins = Suppliers.<Map<String, YangRefinable>>memoize(((Supplier<Map<String, YangRefinable>>) () -> {
    final YangGrammarAccess.BUILTIN_TYPEElements it = this.grammarAccess.getBUILTIN_TYPEAccess();
    Keyword _int8Keyword_8 = it.getInt8Keyword_8();
    Pair<Keyword, YangRefinable> _mappedTo = Pair.<Keyword, YangRefinable>of(_int8Keyword_8, YangTypesExtensions.BuiltinRanges.INT_8);
    Keyword _int16Keyword_9 = it.getInt16Keyword_9();
    Pair<Keyword, YangRefinable> _mappedTo_1 = Pair.<Keyword, YangRefinable>of(_int16Keyword_9, YangTypesExtensions.BuiltinRanges.INT_16);
    Keyword _int32Keyword_10 = it.getInt32Keyword_10();
    Pair<Keyword, YangRefinable> _mappedTo_2 = Pair.<Keyword, YangRefinable>of(_int32Keyword_10, YangTypesExtensions.BuiltinRanges.INT_32);
    Keyword _int64Keyword_11 = it.getInt64Keyword_11();
    Pair<Keyword, YangRefinable> _mappedTo_3 = Pair.<Keyword, YangRefinable>of(_int64Keyword_11, YangTypesExtensions.BuiltinRanges.INT_64);
    Keyword _uint8Keyword_14 = it.getUint8Keyword_14();
    Pair<Keyword, YangRefinable> _mappedTo_4 = Pair.<Keyword, YangRefinable>of(_uint8Keyword_14, YangTypesExtensions.BuiltinRanges.UINT_8);
    Keyword _uint16Keyword_15 = it.getUint16Keyword_15();
    Pair<Keyword, YangRefinable> _mappedTo_5 = Pair.<Keyword, YangRefinable>of(_uint16Keyword_15, YangTypesExtensions.BuiltinRanges.UINT_16);
    Keyword _uint32Keyword_16 = it.getUint32Keyword_16();
    Pair<Keyword, YangRefinable> _mappedTo_6 = Pair.<Keyword, YangRefinable>of(_uint32Keyword_16, YangTypesExtensions.BuiltinRanges.UINT_32);
    Keyword _uint64Keyword_17 = it.getUint64Keyword_17();
    Pair<Keyword, YangRefinable> _mappedTo_7 = Pair.<Keyword, YangRefinable>of(_uint64Keyword_17, YangTypesExtensions.BuiltinRanges.UINT_64);
    final Function1<Pair<Keyword, YangRefinable>, Pair<String, YangRefinable>> _function = (Pair<Keyword, YangRefinable> it_1) -> {
      String _value = it_1.getKey().getValue();
      YangRefinable _value_1 = it_1.getValue();
      return Pair.<String, YangRefinable>of(_value, _value_1);
    };
    return ImmutableMap.<String, YangRefinable>copyOf(CollectionLiterals.<String, YangRefinable>newHashMap(
      ((Pair<? extends String, ? extends YangRefinable>[])Conversions.unwrapArray(ListExtensions.<Pair<Keyword, YangRefinable>, Pair<String, YangRefinable>>map(Collections.<Pair<Keyword, YangRefinable>>unmodifiableList(CollectionLiterals.<Pair<Keyword, YangRefinable>>newArrayList(_mappedTo, _mappedTo_1, _mappedTo_2, _mappedTo_3, _mappedTo_4, _mappedTo_5, _mappedTo_6, _mappedTo_7)), _function), Pair.class))));
  }));
  
  private final Supplier<String> decimalBuiltin = Suppliers.<String>memoize(((Supplier<String>) () -> {
    return this.grammarAccess.getBUILTIN_TYPEAccess().getDecimal64Keyword_3().getValue();
  }));
  
  private final Supplier<String> stringBuiltin = Suppliers.<String>memoize(((Supplier<String>) () -> {
    return this.grammarAccess.getBUILTIN_TYPEAccess().getStringKeyword_13().getValue();
  }));
  
  private final Supplier<String> binaryBuiltin = Suppliers.<String>memoize(((Supplier<String>) () -> {
    return this.grammarAccess.getBUILTIN_TYPEAccess().getBinaryKeyword_0().getValue();
  }));
  
  private final Supplier<String> enumerationBuiltin = Suppliers.<String>memoize(((Supplier<String>) () -> {
    return this.grammarAccess.getBUILTIN_TYPEAccess().getEnumerationKeyword_5().getValue();
  }));
  
  private final Supplier<String> unionBuiltin = Suppliers.<String>memoize(((Supplier<String>) () -> {
    return this.grammarAccess.getBUILTIN_TYPEAccess().getUnionKeyword_18().getValue();
  }));
  
  private final Supplier<String> bitsBuiltin = Suppliers.<String>memoize(((Supplier<String>) () -> {
    return this.grammarAccess.getBUILTIN_TYPEAccess().getBitsKeyword_1().getValue();
  }));
  
  private final Supplier<String> identityrefBuiltin = Suppliers.<String>memoize(((Supplier<String>) () -> {
    return this.grammarAccess.getBUILTIN_TYPEAccess().getIdentityrefKeyword_6().getValue();
  }));
  
  /**
   * Returns {@code true} if the argument equals with any of the built-in YANG type names, otherwise {@code false}.
   */
  public boolean isBuiltinName(final String it) {
    return this.builtinNames.get().contains(it);
  }
  
  /**
   * Returns {@code true} if the type of the type definition argument is a YANG built-in type.
   */
  public boolean isBuiltin(final Typedef it) {
    return this.isBuiltin(IterableExtensions.head(this._yangExtensions.<Type>substatementsOfType(it, Type.class)));
  }
  
  /**
   * Returns {@code true} if the type argument is a YANG built-in type.
   */
  public boolean isBuiltin(final Type it) {
    Collection<String> _get = this.builtinNames.get();
    TypeReference _typeRef = it.getTypeRef();
    String _builtin = null;
    if (_typeRef!=null) {
      _builtin=_typeRef.getBuiltin();
    }
    return _get.contains(_builtin);
  }
  
  /**
   * Returns {@code true} if the type argument is a direct subtype of the built-in integer.
   */
  public boolean isInteger(final Type it) {
    return this.integerBuiltins.get().keySet().contains(it.getTypeRef().getBuiltin());
  }
  
  /**
   * Returns {@code true} if the type argument is a direct subtype of the built-in 64-bit decimal.
   */
  public boolean isDecimal(final Type it) {
    String _get = this.decimalBuiltin.get();
    String _builtin = it.getTypeRef().getBuiltin();
    return Objects.equal(_get, _builtin);
  }
  
  /**
   * Returns {@code true} if the type argument is a direct subtype of the built-in string YANG type.
   */
  public boolean isString(final Type it) {
    String _get = this.stringBuiltin.get();
    String _builtin = it.getTypeRef().getBuiltin();
    return Objects.equal(_get, _builtin);
  }
  
  /**
   * {@code true} if the argument is a direct subtype of the binary built-in YANG type.
   */
  public boolean isBinary(final Type it) {
    String _get = this.binaryBuiltin.get();
    String _builtin = it.getTypeRef().getBuiltin();
    return Objects.equal(_get, _builtin);
  }
  
  /**
   * Returns {@code true} if the type argument is a subtype of the built-in YANG enumeration type.
   */
  public boolean isEnumeration(final Type it) {
    String _get = this.enumerationBuiltin.get();
    String _builtin = it.getTypeRef().getBuiltin();
    return Objects.equal(_get, _builtin);
  }
  
  /**
   * {@code true} if the type is a direct subtype of the built-in union type, otherwise {@code false}.
   */
  public boolean isUnion(final Type it) {
    String _get = this.unionBuiltin.get();
    String _builtin = it.getTypeRef().getBuiltin();
    return Objects.equal(_get, _builtin);
  }
  
  /**
   * Returns {@code true} if the argument is a directly derived from the bits YANG type, otherwise {@code false}.
   */
  public boolean isBits(final Type it) {
    String _get = this.bitsBuiltin.get();
    String _builtin = it.getTypeRef().getBuiltin();
    return Objects.equal(_get, _builtin);
  }
  
  /**
   * {@code true} if the type is an identity reference built-in type, otherwise {@code false}.
   */
  public boolean isIdentityref(final Type it) {
    String _get = this.identityrefBuiltin.get();
    String _builtin = it.getTypeRef().getBuiltin();
    return Objects.equal(_get, _builtin);
  }
  
  /**
   * Sugar for {@code isSubtypeOfInteger(Type) || isSubtypeOfDecimal(Type)}.
   */
  public boolean isSubtypeOfNumber(final Type it) {
    final Function1<Type, Boolean> _function = (Type it_1) -> {
      return Boolean.valueOf((this.isInteger(it_1) || this.isDecimal(it_1)));
    };
    return this.isSubtypeOf(it, _function);
  }
  
  /**
   * Returns {@code true} if the argument is either a direct or a transitive subtype of the built-in string YANG type.
   */
  public boolean isSubtypeOfString(final Type it) {
    final Function1<Type, Boolean> _function = (Type it_1) -> {
      return Boolean.valueOf(this.isString(it_1));
    };
    return this.isSubtypeOf(it, _function);
  }
  
  /**
   * {@code true} if the argument is either a direct or derived subtype of the built-in binary type.
   */
  public boolean isSubtypeOfBinary(final Type it) {
    final Function1<Type, Boolean> _function = (Type it_1) -> {
      return Boolean.valueOf(this.isBinary(it_1));
    };
    return this.isSubtypeOf(it, _function);
  }
  
  /**
   * Returns {@code true} if the type argument is a subtype of any built-in integer types or derived from it.
   */
  public boolean isSubtypeOfInteger(final Type it) {
    final Function1<Type, Boolean> _function = (Type it_1) -> {
      return Boolean.valueOf(this.isInteger(it_1));
    };
    return this.isSubtypeOf(it, _function);
  }
  
  /**
   * Returns {@code true} if the type argument is a subtype of the built-in 64-bit decimal type or derived from it.
   */
  public boolean isSubtypeOfDecimal(final Type it) {
    final Function1<Type, Boolean> _function = (Type it_1) -> {
      return Boolean.valueOf(this.isDecimal(it_1));
    };
    return this.isSubtypeOf(it, _function);
  }
  
  /**
   * {@code true} if the argument is either a direct or transitive subtype of the YANG enumeration type, otherwise {@code false};
   */
  public boolean isSubtypeOfEnumeration(final Type it) {
    final Function1<Type, Boolean> _function = (Type it_1) -> {
      return Boolean.valueOf(this.isEnumeration(it_1));
    };
    return this.isSubtypeOf(it, _function);
  }
  
  /**
   * {@code true} if the argument is either a direct or transitive subtype of the YANG enumeration type, otherwise {@code false};
   */
  public boolean isSubtypeOfBits(final Type it) {
    final Function1<Type, Boolean> _function = (Type it_1) -> {
      return Boolean.valueOf(this.isBits(it_1));
    };
    return this.isSubtypeOf(it, _function);
  }
  
  private boolean isSubtypeOf(final Type it, final Function1<? super Type, ? extends Boolean> subtypePredicate) {
    final HashSet<Type> recursionGuard = CollectionLiterals.<Type>newHashSet();
    Type type = it;
    while ((type != null)) {
      {
        Boolean _apply = subtypePredicate.apply(type);
        if ((_apply).booleanValue()) {
          return true;
        }
        boolean _add = recursionGuard.add(type);
        boolean _not = (!_add);
        if (_not) {
          return false;
        }
        type = this.getSuperType(type);
      }
    }
    return false;
  }
  
  /**
   * Returns with the {@code type of t}
   */
  public Type getType(final Typedef it) {
    return IterableExtensions.head(this._yangExtensions.<Type>substatementsOfType(it, Type.class));
  }
  
  /**
   * Returns with the direct super type of type argument. If the argument is a built-in type, returns with the argument.
   */
  public Type getSuperType(final Type it) {
    boolean _isBuiltin = this.isBuiltin(it);
    if (_isBuiltin) {
      return it;
    }
    TypeReference _typeRef = it.getTypeRef();
    Typedef _type = null;
    if (_typeRef!=null) {
      _type=_typeRef.getType();
    }
    Type _type_1 = null;
    if (_type!=null) {
      _type_1=this.getType(_type);
    }
    return _type_1;
  }
  
  /**
   * Returns with the refinement kind for the type argument based on its built-in super type.
   * <ul>
   * <li>{@code range} for the decimal and all integer types.</li>
   * <li>{@code length} for the string type.</li>
   * <li>{@code null} otherwise.</li>
   * <ul>
   */
  public Class<? extends Refinable> getRefinementKind(final Type it) {
    Class<? extends Refinable> _switchResult = null;
    boolean _matched = false;
    boolean _isSubtypeOfNumber = this.isSubtypeOfNumber(it);
    if (_isSubtypeOfNumber) {
      _matched=true;
      _switchResult = Range.class;
    }
    if (!_matched) {
      boolean _isSubtypeOfString = this.isSubtypeOfString(it);
      if (_isSubtypeOfString) {
        _matched=true;
        _switchResult = Length.class;
      }
    }
    if (!_matched) {
      boolean _isSubtypeOfBinary = this.isSubtypeOfBinary(it);
      if (_isSubtypeOfBinary) {
        _matched=true;
        _switchResult = Length.class;
      }
    }
    if (!_matched) {
      _switchResult = null;
    }
    return _switchResult;
  }
  
  /**
   * Returns with the container type of the refinement argument.
   */
  public Type getType(final Refinable it) {
    return EcoreUtil2.<Type>getContainerOfType(it, Type.class);
  }
  
  /**
   * Returns with the contained (sub-statement) refinement for the type.
   */
  public Refinable getRefinement(final Type it) {
    return this._yangExtensions.<Refinable>firstSubstatementsOfType(it, Refinable.class);
  }
  
  /**
   * Returns with the refinement which the argument refinement restricts.
   * If the refinement does not have any restriction, returns with the built-in type refinement.
   */
  public Type getSuperYangRefinement(final Refinable refinable) {
    return this.getSuperType(this.getType(refinable));
  }
  
  /**
   * {@code true} if the argument type is refinable. More formally, if any of the bellow conditions is {@code true}:
   * <p>
   * <ul>
   * <li>subtype of integer or decimal,</li>
   * <li>subtype of string or</li>
   * <li>subtype of binary.</li>
   * </ul>
   */
  public boolean isRefinable(final Type it) {
    return ((this.isSubtypeOfNumber(it) || this.isSubtypeOfString(it)) || this.isSubtypeOfBinary(it));
  }
  
  /**
   * Transforms the AST refinement into a data model refinement and returns with it.
   * Returns with the {@link YangRefinable#NOOP NOOP} refinable if the given refinement
   * argument does not contained either in an integer, a decimal or in a string type.
   */
  public YangRefinable getYangRefinable(final Refinable it) {
    final Type type = this.getType(it);
    boolean _isRefinable = this.isRefinable(type);
    boolean _not = (!_isRefinable);
    if (_not) {
      return YangRefinable.NOOP;
    }
    final Stack<Type> types = this.getTypeHierarchy(type);
    final Stack<YangRefinable> refinements = new Stack<YangRefinable>();
    while ((!types.isEmpty())) {
      {
        final Type currentType = types.pop();
        YangRefinable _switchResult = null;
        boolean _matched = false;
        boolean _isSubtypeOfDecimal = this.isSubtypeOfDecimal(currentType);
        if (_isSubtypeOfDecimal) {
          _matched=true;
          YangRefinable _xblockexpression = null;
          {
            final int fractionDigits = this.getFractionDigitsAsInt(currentType);
            final String lowerBound = YangTypesExtensions.BuiltinRanges.MIN_64_BASE.movePointLeft(fractionDigits).toString();
            final String upperBound = YangTypesExtensions.BuiltinRanges.MAX_64_BASE.movePointLeft(fractionDigits).toString();
            _xblockexpression = YangRefinable.createBuiltin(lowerBound, upperBound);
          }
          _switchResult = _xblockexpression;
        }
        if (!_matched) {
          boolean _isSubtypeOfInteger = this.isSubtypeOfInteger(currentType);
          if (_isSubtypeOfInteger) {
            _matched=true;
            Map<String, YangRefinable> _get = this.integerBuiltins.get();
            TypeReference _typeRef = null;
            if (currentType!=null) {
              _typeRef=currentType.getTypeRef();
            }
            String _builtin = null;
            if (_typeRef!=null) {
              _builtin=_typeRef.getBuiltin();
            }
            _switchResult = _get.get(_builtin);
          }
        }
        if (!_matched) {
          boolean _isSubtypeOfString = this.isSubtypeOfString(currentType);
          if (_isSubtypeOfString) {
            _matched=true;
            _switchResult = this.integerBuiltins.get().get(this.grammarAccess.getBUILTIN_TYPEAccess().getUint64Keyword_17().getValue());
          }
        }
        if (!_matched) {
          boolean _isSubtypeOfBinary = this.isSubtypeOfBinary(currentType);
          if (_isSubtypeOfBinary) {
            _matched=true;
            _switchResult = this.integerBuiltins.get().get(this.grammarAccess.getBUILTIN_TYPEAccess().getUint64Keyword_17().getValue());
          }
        }
        if (!_matched) {
          _switchResult = null;
        }
        final YangRefinable refinement = _switchResult;
        if ((refinement != null)) {
          refinements.push(refinement);
        }
        final YangRefinable parentRange = refinements.peek();
        final Refinable candidate = this.getRefinement(currentType);
        if ((candidate != null)) {
          refinements.add(YangRefinable.create(candidate, parentRange));
        }
      }
    }
    return refinements.pop();
  }
  
  /**
   * Calculate the type hierarchy from bottom to top and returns with a mutable stack.
   * The top-most element is a built-in type. Includes the argument if not {@code null}.
   */
  public Stack<Type> getTypeHierarchy(final Type it) {
    final Stack<Type> hierarchy = new Stack<Type>();
    Type superType = it;
    while ((superType != null)) {
      {
        hierarchy.push(superType);
        boolean _isBuiltin = this.isBuiltin(superType);
        if (_isBuiltin) {
          superType = null;
        } else {
          superType = this.getSuperType(superType);
        }
      }
    }
    return hierarchy;
  }
  
  /**
   * Returns with the fraction digit of the given type as an integer.
   * If the type is not a 64-bit decimal, but has a valid "fraction-digits" statement,
   * this method will parse the value and returns with the integer.
   * If the "fraction-digits" does not exist as a sub-statement on the type, or
   * it cannot be parsed, this method returns with {@code 0} (zero) instead.
   */
  public int getFractionDigitsAsInt(final Type it) {
    FractionDigits _firstSubstatementsOfType = this._yangExtensions.<FractionDigits>firstSubstatementsOfType(it, FractionDigits.class);
    String _range = null;
    if (_firstSubstatementsOfType!=null) {
      _range=_firstSubstatementsOfType.getRange();
    }
    final String value = _range;
    int _xtrycatchfinallyexpression = (int) 0;
    try {
      int _xifexpression = (int) 0;
      if ((value == null)) {
        _xifexpression = 0;
      } else {
        _xifexpression = Integer.valueOf(Integer.parseInt(value)).intValue();
      }
      _xtrycatchfinallyexpression = _xifexpression;
    } catch (final Throwable _t) {
      if (_t instanceof NumberFormatException) {
        _xtrycatchfinallyexpression = 0;
      } else {
        throw Exceptions.sneakyThrow(_t);
      }
    }
    return _xtrycatchfinallyexpression;
  }
}

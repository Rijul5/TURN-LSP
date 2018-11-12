package io.typefox.yang.utils;

import com.google.common.base.Objects;
import com.google.common.collect.Iterables;
import com.google.inject.Singleton;
import io.typefox.yang.yang.AbstractModule;
import io.typefox.yang.yang.BelongsTo;
import io.typefox.yang.yang.Import;
import io.typefox.yang.yang.OtherStatement;
import io.typefox.yang.yang.Prefix;
import io.typefox.yang.yang.Statement;
import io.typefox.yang.yang.Submodule;
import io.typefox.yang.yang.YangVersion;
import java.util.Arrays;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.xbase.lib.IterableExtensions;

/**
 * Convenient extension methods for the YANG language.
 * 
 * @author akos.kitta
 */
@Singleton
@SuppressWarnings("all")
public class YangExtensions {
  /**
   * The {@code 1.0} YANG version.
   */
  public static final String YANG_1 = "1";
  
  /**
   * The {@code 1.1} YANG version.
   */
  public static final String YANG_1_1 = "1.1";
  
  /**
   * Returns with the YANG version of the module where the AST node element is contained.
   * <p>
   * Returns with version {@code 1} if the container module does not declare the version or the version equals
   * with {@code 1}.
   * <p>
   * Returns with {@code 1.1} if the container module has declared YANG version, and that equals to {@code 1.1},
   * otherwise returns with {@code null}. Also returns with {@code null}, if the argument is not contained in a module.
   */
  public String getYangVersion(final EObject it) {
    final AbstractModule module = EcoreUtil2.<AbstractModule>getContainerOfType(it, AbstractModule.class);
    if ((module == null)) {
      return null;
    }
    YangVersion _firstSubstatementsOfType = this.<YangVersion>firstSubstatementsOfType(module, YangVersion.class);
    String _yangVersion = null;
    if (_firstSubstatementsOfType!=null) {
      _yangVersion=_firstSubstatementsOfType.getYangVersion();
    }
    final String version = _yangVersion;
    if (((null == version) || Objects.equal(YangExtensions.YANG_1, version))) {
      return YangExtensions.YANG_1;
    }
    String _xifexpression = null;
    boolean _equals = Objects.equal(YangExtensions.YANG_1_1, version);
    if (_equals) {
      _xifexpression = YangExtensions.YANG_1_1;
    } else {
      _xifexpression = null;
    }
    return _xifexpression;
  }
  
  /**
   * Returns with all sub-statements of a given type for the statement argument.
   */
  public <S extends Statement> Iterable<? extends S> substatementsOfType(final Statement it, final Class<? extends S> clazz) {
    return Iterables.filter(it.getSubstatements(), clazz);
  }
  
  /**
   * Returns with the first sub-statement of a given type for the statement argument or {@code null}.
   */
  public <S extends Statement> S firstSubstatementsOfType(final Statement it, final Class<? extends S> clazz) {
    return IterableExtensions.head(this.<S>substatementsOfType(it, clazz));
  }
  
  /**
   * Returns with the last sub-statement of a given type for the statement argument or {@code null}.
   */
  public <S extends Statement> S lastSubstatementsOfType(final Statement it, final Class<? extends S> clazz) {
    return IterableExtensions.last(this.<S>substatementsOfType(it, clazz));
  }
  
  /**
   * Returns the main module this element belongs to
   * Returns the containing module, or the belongs-to module of this element is contained in a submodule.
   */
  public io.typefox.yang.yang.Module getMainModule(final EObject obj) {
    final AbstractModule module = EcoreUtil2.<AbstractModule>getContainerOfType(obj, AbstractModule.class);
    boolean _matched = false;
    if (module instanceof Submodule) {
      _matched=true;
      BelongsTo _head = IterableExtensions.<BelongsTo>head(Iterables.<BelongsTo>filter(((Submodule)module).getSubstatements(), BelongsTo.class));
      io.typefox.yang.yang.Module _module = null;
      if (_head!=null) {
        _module=_head.getModule();
      }
      return _module;
    }
    if (!_matched) {
      if (module instanceof io.typefox.yang.yang.Module) {
        _matched=true;
        return ((io.typefox.yang.yang.Module)module);
      }
    }
    return null;
  }
  
  /**
   * Returns the prefix of an element
   */
  protected String _getPrefix(final io.typefox.yang.yang.Module it) {
    Prefix _head = IterableExtensions.<Prefix>head(Iterables.<Prefix>filter(it.getSubstatements(), Prefix.class));
    String _prefix = null;
    if (_head!=null) {
      _prefix=_head.getPrefix();
    }
    return _prefix;
  }
  
  protected String _getPrefix(final Submodule it) {
    BelongsTo _head = IterableExtensions.<BelongsTo>head(Iterables.<BelongsTo>filter(it.getSubstatements(), BelongsTo.class));
    String _prefix = null;
    if (_head!=null) {
      _prefix=this.getPrefix(_head);
    }
    return _prefix;
  }
  
  protected String _getPrefix(final BelongsTo it) {
    Prefix _head = IterableExtensions.<Prefix>head(Iterables.<Prefix>filter(it.getSubstatements(), Prefix.class));
    String _prefix = null;
    if (_head!=null) {
      _prefix=_head.getPrefix();
    }
    return _prefix;
  }
  
  protected String _getPrefix(final Import it) {
    Prefix _head = IterableExtensions.<Prefix>head(Iterables.<Prefix>filter(it.getSubstatements(), Prefix.class));
    String _prefix = null;
    if (_head!=null) {
      _prefix=_head.getPrefix();
    }
    return _prefix;
  }
  
  public String getRevisionFromFileName(final AbstractModule module) {
    String _xblockexpression = null;
    {
      final String rawFileName = module.eResource().getURI().trimFileExtension().lastSegment();
      final int index = rawFileName.indexOf("@");
      String _xifexpression = null;
      if ((index > (-1))) {
        _xifexpression = rawFileName.substring((index + 1));
      } else {
        _xifexpression = null;
      }
      _xblockexpression = _xifexpression;
    }
    return _xblockexpression;
  }
  
  public String getPrefix(final OtherStatement it) {
    if (it instanceof Import) {
      return _getPrefix((Import)it);
    } else if (it instanceof io.typefox.yang.yang.Module) {
      return _getPrefix((io.typefox.yang.yang.Module)it);
    } else if (it instanceof Submodule) {
      return _getPrefix((Submodule)it);
    } else if (it instanceof BelongsTo) {
      return _getPrefix((BelongsTo)it);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(it).toString());
    }
  }
}

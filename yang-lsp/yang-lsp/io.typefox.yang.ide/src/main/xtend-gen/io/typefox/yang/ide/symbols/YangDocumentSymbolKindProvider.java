package io.typefox.yang.ide.symbols;

import com.google.common.base.Objects;
import io.typefox.yang.yang.YangPackage;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.lsp4j.SymbolKind;
import org.eclipse.xtext.ide.server.symbol.DocumentSymbolMapper;

@SuppressWarnings("all")
public class YangDocumentSymbolKindProvider extends DocumentSymbolMapper.DocumentSymbolKindProvider {
  @Override
  protected SymbolKind getSymbolKind(final EClass clazz) {
    SymbolKind _switchResult = null;
    boolean _matched = false;
    if (Objects.equal(clazz, YangPackage.Literals.AUGMENT)) {
      _matched=true;
      _switchResult = SymbolKind.Method;
    }
    if (!_matched) {
      if (Objects.equal(clazz, YangPackage.Literals.CASE)) {
        _matched=true;
        _switchResult = SymbolKind.String;
      }
    }
    if (!_matched) {
      if (Objects.equal(clazz, YangPackage.Literals.CHOICE)) {
        _matched=true;
        _switchResult = SymbolKind.Number;
      }
    }
    if (!_matched) {
      if (Objects.equal(clazz, YangPackage.Literals.CONTAINER)) {
        _matched=true;
        _switchResult = SymbolKind.Namespace;
      }
    }
    if (!_matched) {
      if (Objects.equal(clazz, YangPackage.Literals.EXTENSION)) {
        _matched=true;
        _switchResult = SymbolKind.Module;
      }
    }
    if (!_matched) {
      if (Objects.equal(clazz, YangPackage.Literals.FEATURE)) {
        _matched=true;
        _switchResult = SymbolKind.Boolean;
      }
    }
    if (!_matched) {
      if (Objects.equal(clazz, YangPackage.Literals.GROUPING)) {
        _matched=true;
        _switchResult = SymbolKind.Class;
      }
    }
    if (!_matched) {
      if (Objects.equal(clazz, YangPackage.Literals.IDENTITY)) {
        _matched=true;
        _switchResult = SymbolKind.Constant;
      }
    }
    if (!_matched) {
      if (Objects.equal(clazz, YangPackage.Literals.INPUT)) {
        _matched=true;
        _switchResult = SymbolKind.Property;
      }
    }
    if (!_matched) {
      if (Objects.equal(clazz, YangPackage.Literals.LEAF)) {
        _matched=true;
        _switchResult = SymbolKind.Variable;
      }
    }
    if (!_matched) {
      if (Objects.equal(clazz, YangPackage.Literals.LEAF_LIST)) {
        _matched=true;
        _switchResult = SymbolKind.Array;
      }
    }
    if (!_matched) {
      if (Objects.equal(clazz, YangPackage.Literals.OUTPUT)) {
        _matched=true;
        _switchResult = SymbolKind.Constructor;
      }
    }
    if (!_matched) {
      if (Objects.equal(clazz, YangPackage.Literals.NOTIFICATION)) {
        _matched=true;
        _switchResult = SymbolKind.Function;
      }
    }
    if (!_matched) {
      if (Objects.equal(clazz, YangPackage.Literals.RPC)) {
        _matched=true;
        _switchResult = SymbolKind.Method;
      }
    }
    if (!_matched) {
      if (Objects.equal(clazz, YangPackage.Literals.TYPEDEF)) {
        _matched=true;
        _switchResult = SymbolKind.Enum;
      }
    }
    if (!_matched) {
      _switchResult = SymbolKind.Field;
    }
    return _switchResult;
  }
}

package io.typefox.yang.ide.symbols;

import io.typefox.yang.utils.YangNameUtils;
import io.typefox.yang.yang.Augment;
import io.typefox.yang.yang.SchemaNode;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.ide.server.symbol.DocumentSymbolMapper;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;

@SuppressWarnings("all")
public class YangDocumentSymbolNameProvider extends DocumentSymbolMapper.DocumentSymbolNameProvider {
  @Override
  public String getName(final EObject object) {
    String _xblockexpression = null;
    {
      if ((object instanceof SchemaNode)) {
        String _elvis = null;
        String _name = ((SchemaNode)object).getName();
        if (_name != null) {
          _elvis = _name;
        } else {
          String _yangName = this.getYangName(object);
          _elvis = _yangName;
        }
        return _elvis;
      } else {
        if ((object instanceof Augment)) {
          String _elvis_1 = null;
          String _trim = NodeModelUtils.findActualNodeFor(((Augment)object).getPath()).getText().trim();
          if (_trim != null) {
            _elvis_1 = _trim;
          } else {
            String _yangName_1 = this.getYangName(object);
            _elvis_1 = _yangName_1;
          }
          return _elvis_1;
        }
      }
      _xblockexpression = super.getName(object);
    }
    return _xblockexpression;
  }
  
  protected String getYangName(final Object clazz) {
    return YangNameUtils.getYangName(clazz);
  }
}

package io.typefox.yang.resource;

import com.google.inject.Inject;
import io.typefox.yang.utils.YangExtensions;
import io.typefox.yang.yang.AbstractImport;
import io.typefox.yang.yang.AbstractModule;
import io.typefox.yang.yang.CurrentRef;
import io.typefox.yang.yang.ParentRef;
import io.typefox.yang.yang.Revision;
import io.typefox.yang.yang.RevisionDate;
import io.typefox.yang.yang.impl.XpathNameTestImpl;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.CrossReference;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.scoping.IScope;
import org.eclipse.xtext.serializer.diagnostic.ISerializationDiagnostic;
import org.eclipse.xtext.serializer.tokens.CrossReferenceSerializer;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.IterableExtensions;

@SuppressWarnings("all")
public class YangCrossReferenceSerializer extends CrossReferenceSerializer {
  @Inject
  @Extension
  private YangExtensions _yangExtensions;
  
  @Override
  public String serializeCrossRef(final EObject semanticObject, final CrossReference crossref, final EObject target, final INode node, final ISerializationDiagnostic.Acceptor errors) {
    String _xblockexpression = null;
    {
      if ((semanticObject instanceof RevisionDate)) {
        final AbstractImport import_ = EcoreUtil2.<AbstractImport>getContainerOfType(semanticObject, AbstractImport.class);
        AbstractModule _module = null;
        if (import_!=null) {
          _module=import_.getModule();
        }
        boolean _tripleNotEquals = (_module != null);
        if (_tripleNotEquals) {
          String _elvis = null;
          Revision _head = IterableExtensions.head(this._yangExtensions.<Revision>substatementsOfType(import_.getModule(), Revision.class));
          String _revision = null;
          if (_head!=null) {
            _revision=_head.getRevision();
          }
          if (_revision != null) {
            _elvis = _revision;
          } else {
            String _revisionFromFileName = this._yangExtensions.getRevisionFromFileName(import_.getModule());
            _elvis = _revisionFromFileName;
          }
          return _elvis;
        }
      }
      _xblockexpression = super.serializeCrossRef(semanticObject, crossref, target, node, errors);
    }
    return _xblockexpression;
  }
  
  @Override
  protected String getCrossReferenceNameFromScope(final EObject semanticObject, final CrossReference crossref, final EObject target, final IScope scope, final ISerializationDiagnostic.Acceptor errors) {
    if ((semanticObject instanceof ParentRef)) {
      return "..";
    }
    if ((semanticObject instanceof CurrentRef)) {
      return ".";
    }
    final String nameFromSuper = super.getCrossReferenceNameFromScope(semanticObject, crossref, target, scope, errors);
    if ((semanticObject instanceof XpathNameTestImpl)) {
      String _prefix = ((XpathNameTestImpl)semanticObject).getPrefix();
      String _plus = (_prefix + ":");
      boolean _startsWith = nameFromSuper.startsWith(_plus);
      if (_startsWith) {
        int _length = ((XpathNameTestImpl)semanticObject).getPrefix().length();
        int _plus_1 = (_length + 1);
        return nameFromSuper.substring(_plus_1);
      }
    }
    return nameFromSuper;
  }
}

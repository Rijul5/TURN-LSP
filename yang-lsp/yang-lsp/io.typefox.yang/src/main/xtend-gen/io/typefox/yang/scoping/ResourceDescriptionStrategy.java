package io.typefox.yang.scoping;

import com.google.inject.Inject;
import io.typefox.yang.utils.YangExtensions;
import io.typefox.yang.yang.AbstractModule;
import io.typefox.yang.yang.Revision;
import io.typefox.yang.yang.Statement;
import io.typefox.yang.yang.YangFactory;
import java.util.Collections;
import java.util.Map;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.resource.EObjectDescription;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.resource.impl.DefaultResourceDescriptionStrategy;
import org.eclipse.xtext.util.IAcceptor;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.Pair;

@SuppressWarnings("all")
public class ResourceDescriptionStrategy extends DefaultResourceDescriptionStrategy {
  public static final String REVISION = "rev";
  
  @Inject
  @Extension
  private YangExtensions _yangExtensions;
  
  @Override
  public boolean createEObjectDescriptions(final EObject m, final IAcceptor<IEObjectDescription> acceptor) {
    if ((m instanceof AbstractModule)) {
      Map<String, String> data = CollectionLiterals.<String, String>emptyMap();
      String _elvis = null;
      Revision _head = IterableExtensions.head(this._yangExtensions.<Revision>substatementsOfType(((Statement)m), Revision.class));
      String _revision = null;
      if (_head!=null) {
        _revision=_head.getRevision();
      }
      if (_revision != null) {
        _elvis = _revision;
      } else {
        String _revisionFromFileName = this._yangExtensions.getRevisionFromFileName(((AbstractModule)m));
        _elvis = _revisionFromFileName;
      }
      final String leadingRevision = _elvis;
      if ((leadingRevision != null)) {
        Pair<String, String> _mappedTo = Pair.<String, String>of(ResourceDescriptionStrategy.REVISION, leadingRevision);
        data = Collections.<String, String>unmodifiableMap(CollectionLiterals.<String, String>newHashMap(_mappedTo));
      }
      final AbstractModule proxy = YangFactory.eINSTANCE.createAbstractModule();
      ((InternalEObject) proxy).eSetProxyURI(EcoreUtil.getURI(m));
      QualifiedName _create = QualifiedName.create(((AbstractModule)m).getName());
      EObjectDescription _eObjectDescription = new EObjectDescription(_create, proxy, data);
      acceptor.accept(_eObjectDescription);
      return false;
    }
    return true;
  }
}

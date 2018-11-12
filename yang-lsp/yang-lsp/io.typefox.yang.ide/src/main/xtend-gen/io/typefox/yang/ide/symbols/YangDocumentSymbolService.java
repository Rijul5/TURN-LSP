package io.typefox.yang.ide.symbols;

import com.google.inject.Inject;
import java.util.Collections;
import java.util.List;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.lsp4j.Location;
import org.eclipse.xtext.findReferences.IReferenceFinder;
import org.eclipse.xtext.ide.server.DocumentExtensions;
import org.eclipse.xtext.ide.server.symbol.DocumentSymbolService;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.resource.EObjectAtOffsetHelper;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.util.CancelIndicator;
import org.eclipse.xtext.util.TextRegion;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Extension;

@SuppressWarnings("all")
public class YangDocumentSymbolService extends DocumentSymbolService {
  @Inject
  @Extension
  private DocumentExtensions _documentExtensions;
  
  @Inject
  private EObjectAtOffsetHelper helper;
  
  @Override
  public List<? extends Location> getDefinitions(final XtextResource resource, final int offset, final IReferenceFinder.IResourceAccess resourceAccess, final CancelIndicator cancelIndicator) {
    TextRegion _textRegion = new TextRegion(offset, 0);
    final INode node = this.helper.getCrossReferenceNode(resource, _textRegion);
    if ((node != null)) {
      final EObject element = this.helper.getCrossReferencedElement(node);
      if ((element != null)) {
        Location _newFullLocation = this._documentExtensions.newFullLocation(element);
        return Collections.<Location>unmodifiableList(CollectionLiterals.<Location>newArrayList(_newFullLocation));
      }
    }
    return CollectionLiterals.<Location>emptyList();
  }
}

package io.typefox.yang.ide.symbols;

import com.google.common.collect.Iterators;
import com.google.common.collect.UnmodifiableIterator;
import io.typefox.yang.yang.AbstractModule;
import io.typefox.yang.yang.Statement;
import java.util.Iterator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.ide.server.symbol.HierarchicalDocumentSymbolService;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.IterableExtensions;

@SuppressWarnings("all")
public class YangHierarchicalDocumentSymbolService extends HierarchicalDocumentSymbolService {
  @Override
  protected Iterator<Object> getAllContents(final Resource resource) {
    final EObject module = IterableExtensions.<EObject>head(resource.getContents());
    if ((module instanceof AbstractModule)) {
      final UnmodifiableIterator<Statement> allStatements = Iterators.<Statement>filter(EcoreUtil.<Object>getAllProperContents(module, true), Statement.class);
      return Iterators.<Object>filter(allStatements, Object.class);
    }
    return CollectionLiterals.<Object>emptyList().iterator();
  }
}

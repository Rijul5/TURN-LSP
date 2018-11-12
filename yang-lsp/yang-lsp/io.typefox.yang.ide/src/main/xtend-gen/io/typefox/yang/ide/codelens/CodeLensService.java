package io.typefox.yang.ide.codelens;

import com.google.common.base.Objects;
import com.google.common.collect.Multimap;
import com.google.inject.Inject;
import io.typefox.yang.findReferences.YangReferenceFinder;
import io.typefox.yang.settings.PreferenceValuesProvider;
import io.typefox.yang.yang.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.lsp4j.CodeLens;
import org.eclipse.lsp4j.CodeLensParams;
import org.eclipse.lsp4j.Command;
import org.eclipse.lsp4j.Location;
import org.eclipse.lsp4j.Range;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.Keyword;
import org.eclipse.xtext.ide.server.Document;
import org.eclipse.xtext.ide.server.DocumentExtensions;
import org.eclipse.xtext.ide.server.codelens.ICodeLensService;
import org.eclipse.xtext.nodemodel.ILeafNode;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;
import org.eclipse.xtext.preferences.PreferenceKey;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.util.CancelIndicator;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Pair;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

@SuppressWarnings("all")
public class CodeLensService implements ICodeLensService {
  public static final PreferenceKey CODE_LENS_ENABLED = new PreferenceKey("code-lenses", "on");
  
  @Inject
  private YangReferenceFinder referenceFinder;
  
  @Inject
  private DocumentExtensions documentExtensions;
  
  @Inject
  private PreferenceValuesProvider preferenceProvider;
  
  @Override
  public List<? extends CodeLens> computeCodeLenses(final Document document, final XtextResource resource, final CodeLensParams params, final CancelIndicator indicator) {
    final String enabled = this.preferenceProvider.getPreferenceValues(resource).getPreference(CodeLensService.CODE_LENS_ENABLED);
    boolean _equals = enabled.equals("on");
    boolean _not = (!_equals);
    if (_not) {
      return CollectionLiterals.<CodeLens>emptyList();
    }
    final Multimap<URI, Pair<URI, EReference>> references = this.referenceFinder.collectReferences(resource, indicator);
    final ArrayList<CodeLens> result = CollectionLiterals.<CodeLens>newArrayList();
    Set<URI> _keySet = references.keySet();
    for (final URI uri : _keySet) {
      URI _trimFragment = uri.trimFragment();
      URI _uRI = resource.getURI();
      boolean _equals_1 = Objects.equal(_trimFragment, _uRI);
      if (_equals_1) {
        final EObject eObject = resource.getEObject(uri.fragment());
        if ((eObject instanceof Statement)) {
          final Function1<ILeafNode, Boolean> _function = (ILeafNode it) -> {
            EObject _grammarElement = it.getGrammarElement();
            return Boolean.valueOf((_grammarElement instanceof Keyword));
          };
          final ILeafNode kwNode = IterableExtensions.<ILeafNode>head(IterableExtensions.<ILeafNode>filter(NodeModelUtils.findActualNodeFor(eObject).getLeafNodes(), _function));
          if ((kwNode != null)) {
            final Range range = this.documentExtensions.newRange(resource, kwNode.getTextRegion());
            final Function1<Pair<URI, EReference>, Location> _function_1 = (Pair<URI, EReference> refInfo) -> {
              final EObject eobj = resource.getResourceSet().getEObject(refInfo.getKey(), false);
              return this.documentExtensions.newLocation(eobj, refInfo.getValue(), (-1));
            };
            final List<Location> locations = IterableExtensions.<Location>toList(IterableExtensions.<Pair<URI, EReference>, Location>map(references.get(uri), _function_1));
            CodeLens _codeLens = new CodeLens();
            final Procedure1<CodeLens> _function_2 = (CodeLens it) -> {
              it.setRange(range);
              Command _command = new Command();
              final Procedure1<Command> _function_3 = (Command it_1) -> {
                it_1.setCommand("yang.show.references");
                String _switchResult = null;
                int _size = references.get(uri).size();
                final int count = _size;
                switch (count) {
                  case 1:
                    _switchResult = "1 reference";
                    break;
                  default:
                    StringConcatenation _builder = new StringConcatenation();
                    _builder.append(count);
                    _builder.append(" references");
                    _switchResult = _builder.toString();
                    break;
                }
                it_1.setTitle(_switchResult);
                it_1.setArguments(CollectionLiterals.<Object>newArrayList(
                  uri.trimFragment().toString(), 
                  range.getStart(), locations));
              };
              Command _doubleArrow = ObjectExtensions.<Command>operator_doubleArrow(_command, _function_3);
              it.setCommand(_doubleArrow);
            };
            CodeLens _doubleArrow = ObjectExtensions.<CodeLens>operator_doubleArrow(_codeLens, _function_2);
            result.add(_doubleArrow);
          }
        }
      }
    }
    return result;
  }
}

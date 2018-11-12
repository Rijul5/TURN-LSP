package io.typefox.yang.diagram;

import com.google.inject.Inject;
import io.typefox.sprotty.api.HtmlRoot;
import io.typefox.sprotty.api.IDiagramServer;
import io.typefox.sprotty.api.IPopupModelFactory;
import io.typefox.sprotty.api.PreRenderedElement;
import io.typefox.sprotty.api.RequestPopupModelAction;
import io.typefox.sprotty.api.SModelElement;
import io.typefox.sprotty.api.SModelRoot;
import io.typefox.sprotty.server.xtext.ILanguageAwareDiagramServer;
import io.typefox.sprotty.server.xtext.tracing.ITraceProvider;
import io.typefox.sprotty.server.xtext.tracing.Traceable;
import io.typefox.yang.yang.Description;
import io.typefox.yang.yang.Namespace;
import io.typefox.yang.yang.Prefix;
import io.typefox.yang.yang.Statement;
import io.typefox.yang.yang.YangVersion;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.concurrent.CompletableFuture;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.ide.server.ILanguageServerAccess;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Pair;

@SuppressWarnings("all")
public class YangPopupModelFactory implements IPopupModelFactory {
  @Inject
  @Extension
  private ITraceProvider _iTraceProvider;
  
  @Override
  public SModelRoot createPopupModel(final SModelElement element, final RequestPopupModelAction request, final IDiagramServer server) {
    try {
      HtmlRoot _xifexpression = null;
      if ((element instanceof Traceable)) {
        HtmlRoot _xblockexpression = null;
        {
          final BiFunction<EObject, ILanguageServerAccess.Context, HtmlRoot> _function = (EObject statement, ILanguageServerAccess.Context context) -> {
            HtmlRoot _xifexpression_1 = null;
            if ((statement instanceof Statement)) {
              _xifexpression_1 = this.createPopup(((Statement)statement), element, request);
            } else {
              _xifexpression_1 = null;
            }
            return _xifexpression_1;
          };
          final CompletableFuture<HtmlRoot> future = this._iTraceProvider.<HtmlRoot>withSource(((Traceable)element), ((ILanguageAwareDiagramServer) server), _function);
          _xblockexpression = future.get();
        }
        _xifexpression = _xblockexpression;
      } else {
        _xifexpression = null;
      }
      return _xifexpression;
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  protected HtmlRoot createPopup(final Statement stmt, final SModelElement element, final RequestPopupModelAction request) {
    HtmlRoot _xblockexpression = null;
    {
      String _id = element.getId();
      final String popupId = (_id + "-popup");
      final ArrayList<Pair<String, String>> infos = new ArrayList<Pair<String, String>>();
      EList<Statement> _substatements = stmt.getSubstatements();
      for (final Statement statement : _substatements) {
        {
          final Pair<String, String> info = this.createHtml(statement);
          if ((info != null)) {
            infos.add(info);
          }
        }
      }
      HtmlRoot _xifexpression = null;
      boolean _isEmpty = infos.isEmpty();
      boolean _not = (!_isEmpty);
      if (_not) {
        final Consumer<HtmlRoot> _function = (HtmlRoot it) -> {
          it.setType("html");
          it.setId(popupId);
          final Consumer<PreRenderedElement> _function_1 = (PreRenderedElement it_1) -> {
            it_1.setType("pre-rendered");
            it_1.setId((popupId + "-body"));
            StringConcatenation _builder = new StringConcatenation();
            _builder.append("<div class=\"infoBlock\">");
            _builder.newLine();
            {
              for(final Pair<String, String> info : infos) {
                _builder.append("\t");
                _builder.append("<div class=\"sprotty-infoRow\">");
                _builder.newLine();
                _builder.append("\t");
                _builder.append("\t");
                _builder.append("<div class=\"sprotty-infoTitle\">");
                String _key = info.getKey();
                _builder.append(_key, "\t\t");
                _builder.append(":</div>");
                _builder.newLineIfNotEmpty();
                _builder.append("\t");
                _builder.append("\t");
                _builder.append("<div class=\"sprotty-infoText\">");
                String _value = info.getValue();
                _builder.append(_value, "\t\t");
                _builder.append("</div>");
                _builder.newLineIfNotEmpty();
                _builder.append("\t");
                _builder.append("</div>");
                _builder.newLine();
              }
            }
            _builder.append("</div>");
            _builder.newLine();
            it_1.setCode(_builder.toString());
          };
          PreRenderedElement _preRenderedElement = new PreRenderedElement(_function_1);
          it.setChildren(Collections.<SModelElement>unmodifiableList(CollectionLiterals.<SModelElement>newArrayList(_preRenderedElement)));
          it.setCanvasBounds(request.getBounds());
        };
        _xifexpression = new HtmlRoot(_function);
      }
      _xblockexpression = _xifexpression;
    }
    return _xblockexpression;
  }
  
  protected Pair<String, String> _createHtml(final Statement statement) {
    return null;
  }
  
  protected Pair<String, String> _createHtml(final Prefix prefixStmt) {
    String _prefix = prefixStmt.getPrefix();
    return Pair.<String, String>of("Prefix", _prefix);
  }
  
  protected Pair<String, String> _createHtml(final Namespace namespaceStmt) {
    String _uri = namespaceStmt.getUri();
    return Pair.<String, String>of("Namespace", _uri);
  }
  
  protected Pair<String, String> _createHtml(final YangVersion yangVersionStmt) {
    String _yangVersion = yangVersionStmt.getYangVersion();
    return Pair.<String, String>of("Yang version", _yangVersion);
  }
  
  protected Pair<String, String> _createHtml(final Description descriptionStmt) {
    String _description = descriptionStmt.getDescription();
    return Pair.<String, String>of("Description", _description);
  }
  
  protected Pair<String, String> createHtml(final Statement descriptionStmt) {
    if (descriptionStmt instanceof Description) {
      return _createHtml((Description)descriptionStmt);
    } else if (descriptionStmt instanceof Namespace) {
      return _createHtml((Namespace)descriptionStmt);
    } else if (descriptionStmt instanceof Prefix) {
      return _createHtml((Prefix)descriptionStmt);
    } else if (descriptionStmt instanceof YangVersion) {
      return _createHtml((YangVersion)descriptionStmt);
    } else if (descriptionStmt != null) {
      return _createHtml(descriptionStmt);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(descriptionStmt).toString());
    }
  }
}

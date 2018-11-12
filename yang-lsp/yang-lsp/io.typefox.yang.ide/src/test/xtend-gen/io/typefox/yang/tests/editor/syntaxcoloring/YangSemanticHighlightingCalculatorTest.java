package io.typefox.yang.tests.editor.syntaxcoloring;

import com.google.common.base.Objects;
import com.google.inject.Inject;
import io.typefox.yang.ide.editor.syntaxcoloring.YangSemanticHighlightingCalculator;
import io.typefox.yang.tests.AbstractYangLSPTest;
import java.io.File;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.nio.file.Path;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.function.Consumer;
import org.eclipse.lsp4j.ClientCapabilities;
import org.eclipse.lsp4j.InitializeParams;
import org.eclipse.lsp4j.SemanticHighlightingCapabilities;
import org.eclipse.lsp4j.SemanticHighlightingInformation;
import org.eclipse.lsp4j.TextDocumentClientCapabilities;
import org.eclipse.lsp4j.VersionedTextDocumentIdentifier;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.ide.server.UriExtensions;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Pair;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

@SuppressWarnings("all")
public class YangSemanticHighlightingCalculatorTest extends AbstractYangLSPTest {
  @Inject
  @Extension
  private UriExtensions _uriExtensions;
  
  private List<List<String>> scopes;
  
  @Before
  public void before() {
    final Procedure1<InitializeParams> _function = (InitializeParams it) -> {
      ClientCapabilities _clientCapabilities = new ClientCapabilities();
      final Procedure1<ClientCapabilities> _function_1 = (ClientCapabilities it_1) -> {
        TextDocumentClientCapabilities _textDocumentClientCapabilities = new TextDocumentClientCapabilities();
        final Procedure1<TextDocumentClientCapabilities> _function_2 = (TextDocumentClientCapabilities it_2) -> {
          SemanticHighlightingCapabilities _semanticHighlightingCapabilities = new SemanticHighlightingCapabilities();
          final Procedure1<SemanticHighlightingCapabilities> _function_3 = (SemanticHighlightingCapabilities it_3) -> {
            it_3.setSemanticHighlighting(Boolean.valueOf(true));
          };
          SemanticHighlightingCapabilities _doubleArrow = ObjectExtensions.<SemanticHighlightingCapabilities>operator_doubleArrow(_semanticHighlightingCapabilities, _function_3);
          it_2.setSemanticHighlightingCapabilities(_doubleArrow);
        };
        TextDocumentClientCapabilities _doubleArrow = ObjectExtensions.<TextDocumentClientCapabilities>operator_doubleArrow(_textDocumentClientCapabilities, _function_2);
        it_1.setTextDocument(_doubleArrow);
      };
      ClientCapabilities _doubleArrow = ObjectExtensions.<ClientCapabilities>operator_doubleArrow(_clientCapabilities, _function_1);
      it.setCapabilities(_doubleArrow);
    };
    this.scopes = this.initialize(_function).getCapabilities().getSemanticHighlighting().getScopes();
  }
  
  @Test
  public void checkStylesAndScopes() {
    final Function1<Field, Boolean> _function = (Field it) -> {
      return Boolean.valueOf(((Modifier.isStatic(it.getModifiers()) && Modifier.isPublic(it.getModifiers())) && (it.getType() == List.class)));
    };
    final Iterable<Field> scopes = IterableExtensions.<Field>filter(((Iterable<Field>)Conversions.doWrapArray(YangSemanticHighlightingCalculator.Scopes.class.getDeclaredFields())), _function);
    final Function1<Field, Boolean> _function_1 = (Field it) -> {
      return Boolean.valueOf(((Modifier.isStatic(it.getModifiers()) && Modifier.isPublic(it.getModifiers())) && (it.getType() == String.class)));
    };
    final Iterable<Field> styles = IterableExtensions.<Field>filter(((Iterable<Field>)Conversions.doWrapArray(YangSemanticHighlightingCalculator.Styles.class.getDeclaredFields())), _function_1);
    Assert.assertEquals(IterableExtensions.size(scopes), IterableExtensions.size(styles));
    Assert.assertEquals(YangSemanticHighlightingCalculator.STYLE_MAPPINGS.size(), IterableExtensions.size(styles));
    final Consumer<Field> _function_2 = (Field scope) -> {
      final String scopeName = scope.getName();
      final String expectedStyleName = scopeName.replace("_SCOPES", "_STYLE");
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("Cannot find style \'");
      _builder.append(expectedStyleName);
      _builder.append("\' for scope: ");
      _builder.append(scopeName);
      _builder.append(".");
      final Function1<Field, Boolean> _function_3 = (Field it) -> {
        String _name = it.getName();
        return Boolean.valueOf(Objects.equal(_name, expectedStyleName));
      };
      Assert.assertTrue(_builder.toString(), IterableExtensions.<Field>exists(styles, _function_3));
    };
    scopes.forEach(_function_2);
    final Consumer<Field> _function_3 = (Field style) -> {
      final String styleName = style.getName();
      final String expectedScopeName = styleName.replace("_STYLE", "_SCOPES");
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("Cannot find scope \'");
      _builder.append(expectedScopeName);
      _builder.append("\' for style: ");
      _builder.append(styleName);
      _builder.append(".");
      final Function1<Field, Boolean> _function_4 = (Field it) -> {
        String _name = it.getName();
        return Boolean.valueOf(Objects.equal(_name, expectedScopeName));
      };
      Assert.assertTrue(_builder.toString(), IterableExtensions.<Field>exists(scopes, _function_4));
    };
    styles.forEach(_function_3);
  }
  
  @Test
  public void checkDescription_singleLine() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("module x {");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("description \"desc\";");
    _builder.newLine();
    _builder.append("}");
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("0 : []");
    _builder_1.newLine();
    _builder_1.append("1 : [14:6:");
    _builder_1.append(YangSemanticHighlightingCalculator.Scopes.DESCRIPTION_SCOPES);
    _builder_1.append("]");
    _builder_1.newLineIfNotEmpty();
    _builder_1.append("2 : []");
    this.assertInfos(_builder, _builder_1.toString());
  }
  
  @Test
  public void checkDescription_multiLine() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("module x {");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("description ");
    _builder.newLine();
    _builder.append("   ");
    _builder.append("\"");
    _builder.newLine();
    _builder.append("     ");
    _builder.append("blabla");
    _builder.newLine();
    _builder.append("  ");
    _builder.newLine();
    _builder.append("      ");
    _builder.append("\";");
    _builder.newLine();
    _builder.append("}");
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("0 : []");
    _builder_1.newLine();
    _builder_1.append("1 : []");
    _builder_1.newLine();
    _builder_1.append("2 : [3:1:");
    _builder_1.append(YangSemanticHighlightingCalculator.Scopes.DESCRIPTION_SCOPES);
    _builder_1.append("]");
    _builder_1.newLineIfNotEmpty();
    _builder_1.append("3 : [0:11:");
    _builder_1.append(YangSemanticHighlightingCalculator.Scopes.DESCRIPTION_SCOPES);
    _builder_1.append("]");
    _builder_1.newLineIfNotEmpty();
    _builder_1.append("4 : [0:2:");
    _builder_1.append(YangSemanticHighlightingCalculator.Scopes.DESCRIPTION_SCOPES);
    _builder_1.append("]");
    _builder_1.newLineIfNotEmpty();
    _builder_1.append("5 : [0:7:");
    _builder_1.append(YangSemanticHighlightingCalculator.Scopes.DESCRIPTION_SCOPES);
    _builder_1.append("]");
    _builder_1.newLineIfNotEmpty();
    _builder_1.append("6 : []");
    this.assertInfos(_builder, _builder_1.toString());
  }
  
  protected String open(final CharSequence content) {
    return this.open(content, UUID.randomUUID().toString());
  }
  
  protected String open(final CharSequence content, final String fileName) {
    Path _path = this.root.toPath();
    StringConcatenation _builder = new StringConcatenation();
    _builder.append(fileName);
    _builder.append(".");
    _builder.append(this.fileExtension);
    final File file = _path.resolve(_builder.toString()).toFile();
    final String uri = this._uriExtensions.toUriString(file.toURI());
    this.open(uri, content.toString());
    return uri;
  }
  
  protected void assertInfos(final CharSequence content, final String expected) {
    final String uri = this.open(content, "MyModel");
    final Map<VersionedTextDocumentIdentifier, List<SemanticHighlightingInformation>> params = this.getSemanticHighlightingParams();
    Assert.assertEquals(1, params.size());
    final Function1<Map.Entry<VersionedTextDocumentIdentifier, List<SemanticHighlightingInformation>>, Boolean> _function = (Map.Entry<VersionedTextDocumentIdentifier, List<SemanticHighlightingInformation>> it) -> {
      String _uri = it.getKey().getUri();
      return Boolean.valueOf(Objects.equal(_uri, uri));
    };
    final Map.Entry<VersionedTextDocumentIdentifier, List<SemanticHighlightingInformation>> entry = IterableExtensions.<Map.Entry<VersionedTextDocumentIdentifier, List<SemanticHighlightingInformation>>>findFirst(params.entrySet(), _function);
    Assert.assertNotNull(entry);
    final Function1<SemanticHighlightingInformation, Pair<SemanticHighlightingInformation, List<List<String>>>> _function_1 = (SemanticHighlightingInformation it) -> {
      return Pair.<SemanticHighlightingInformation, List<List<String>>>of(it, this.scopes);
    };
    final Function1<Pair<SemanticHighlightingInformation, List<List<String>>>, String> _function_2 = (Pair<SemanticHighlightingInformation, List<List<String>>> it) -> {
      return this.toExpectation(it);
    };
    final String actual = IterableExtensions.join(ListExtensions.<Pair<SemanticHighlightingInformation, List<List<String>>>, String>map(ListExtensions.<SemanticHighlightingInformation, Pair<SemanticHighlightingInformation, List<List<String>>>>map(entry.getValue(), _function_1), _function_2), "\n");
    this.assertEquals(expected, actual);
  }
}

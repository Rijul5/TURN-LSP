package io.typefox.yang.ide.completion;

import com.google.common.base.Objects;
import com.google.inject.Inject;
import com.google.inject.Singleton;
import io.typefox.yang.ide.completion.YangTemplateProvider;
import org.eclipse.xtext.formatting.IIndentationInformation;
import org.eclipse.xtext.ide.editor.contentassist.ContentAssistEntry;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

/**
 * Singleton template proposal provider for YANG.
 * 
 * @author akos.kitta
 */
@Singleton
@SuppressWarnings("all")
public class YangTemplateProposalProvider {
  @Inject
  @Extension
  private YangTemplateProvider _yangTemplateProvider;
  
  @Inject
  @Extension
  private IIndentationInformation _iIndentationInformation;
  
  public Iterable<ContentAssistEntry> getTemplateEntry(final ContentAssistEntry entry) {
    Iterable<ContentAssistEntry> _xifexpression = null;
    String _kind = null;
    if (entry!=null) {
      _kind=entry.getKind();
    }
    boolean _equals = Objects.equal(_kind, ContentAssistEntry.KIND_KEYWORD);
    if (_equals) {
      final Function1<YangTemplateProvider.Template, ContentAssistEntry> _function = (YangTemplateProvider.Template it) -> {
        return this.toTemplate(it, entry);
      };
      _xifexpression = IterableExtensions.<YangTemplateProvider.Template, ContentAssistEntry>map(this._yangTemplateProvider.getTemplatesForKeyword(entry), _function);
    } else {
      _xifexpression = CollectionLiterals.<ContentAssistEntry>emptyList();
    }
    return _xifexpression;
  }
  
  private ContentAssistEntry toTemplate(final YangTemplateProvider.Template template, final ContentAssistEntry original) {
    ContentAssistEntry _contentAssistEntry = new ContentAssistEntry();
    final Procedure1<ContentAssistEntry> _function = (ContentAssistEntry it) -> {
      it.setPrefix(original.getPrefix());
      it.setLabel(template.getLabel());
      it.setProposal(template.getTemplate().replaceAll("  ", this._iIndentationInformation.getIndentString()));
      it.setDescription(template.getDescription());
      it.setDocumentation(template.getDocumentation());
      it.setKind(ContentAssistEntry.KIND_SNIPPET);
      it.setSource(original.getSource());
    };
    return ObjectExtensions.<ContentAssistEntry>operator_doubleArrow(_contentAssistEntry, _function);
  }
}

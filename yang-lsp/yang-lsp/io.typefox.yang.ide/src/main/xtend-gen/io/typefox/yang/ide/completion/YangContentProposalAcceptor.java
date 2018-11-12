package io.typefox.yang.ide.completion;

import com.google.inject.Inject;
import io.typefox.yang.ide.completion.YangTemplateProposalProvider;
import java.util.function.Consumer;
import org.eclipse.xtext.ide.editor.contentassist.ContentAssistEntry;
import org.eclipse.xtext.ide.editor.contentassist.IdeContentProposalAcceptor;
import org.eclipse.xtext.xbase.lib.IterableExtensions;

/**
 * Customized content proposal acceptor that automatically accepts all
 * available template proposals for a particular keyword entry and disregards the
 * keyword entry.
 * 
 * @author akos.kitta
 */
@SuppressWarnings("all")
public class YangContentProposalAcceptor extends IdeContentProposalAcceptor {
  @Inject
  private YangTemplateProposalProvider templateProposalProvider;
  
  @Override
  public void accept(final ContentAssistEntry entry, final int priority) {
    final Iterable<ContentAssistEntry> templates = this.templateProposalProvider.getTemplateEntry(entry);
    boolean _isNullOrEmpty = IterableExtensions.isNullOrEmpty(templates);
    if (_isNullOrEmpty) {
      super.accept(entry, priority);
    } else {
      final Consumer<ContentAssistEntry> _function = (ContentAssistEntry it) -> {
        super.accept(it, priority);
      };
      templates.forEach(_function);
    }
  }
}

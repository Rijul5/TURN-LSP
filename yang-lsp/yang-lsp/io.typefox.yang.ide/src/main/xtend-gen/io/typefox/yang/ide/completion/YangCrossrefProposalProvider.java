package io.typefox.yang.ide.completion;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import io.typefox.yang.documentation.DocumentationProvider;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.xtext.CrossReference;
import org.eclipse.xtext.ide.editor.contentassist.ContentAssistContext;
import org.eclipse.xtext.ide.editor.contentassist.ContentAssistEntry;
import org.eclipse.xtext.ide.editor.contentassist.IdeCrossrefProposalProvider;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

/**
 * Cross reference proposal provider implementation that attaches a documentation
 * to the content assist entry. The attached documentation is extracted for all the
 * cross-references YANG statements that have the {@code description} sub-statement.
 * 
 * @author akos.kitta
 */
@Singleton
@SuppressWarnings("all")
public class YangCrossrefProposalProvider extends IdeCrossrefProposalProvider {
  @Inject
  @Extension
  private DocumentationProvider _documentationProvider;
  
  @Override
  protected ContentAssistEntry createProposal(final IEObjectDescription candidate, final CrossReference crossRef, final ContentAssistContext context) {
    final Procedure1<ContentAssistEntry> _function = (ContentAssistEntry it) -> {
      it.setSource(candidate);
      EClass _eClass = candidate.getEClass();
      String _name = null;
      if (_eClass!=null) {
        _name=_eClass.getName();
      }
      it.setDescription(_name);
      it.setDocumentation(this._documentationProvider.getDocumentation(candidate.getEObjectOrProxy()));
    };
    return this.getProposalCreator().createProposal(this.getQualifiedNameConverter().toString(candidate.getName()), context, _function);
  }
}

package io.typefox.yang.formatting2;

import com.google.common.base.Objects;
import com.google.inject.Inject;
import io.typefox.yang.formatting2.YangNodeModelBasedRegionAccessBuilder;
import io.typefox.yang.resource.YangTokenUtil;
import io.typefox.yang.services.YangGrammarAccess;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.AbstractRule;
import org.eclipse.xtext.Keyword;
import org.eclipse.xtext.formatting2.regionaccess.ITextRegionAccess;
import org.eclipse.xtext.formatting2.regionaccess.TextRegionAccessBuilder;
import org.eclipse.xtext.formatting2.regionaccess.internal.NodeModelBasedRegionAccessBuilder;
import org.eclipse.xtext.formatting2.regionaccess.internal.TextRegionAccessBuildingSequencer;
import org.eclipse.xtext.nodemodel.ILeafNode;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.serializer.ISerializationContext;
import org.eclipse.xtext.serializer.acceptor.ISequenceAcceptor;

@SuppressWarnings("all")
public class YangTextRegionAccessBuilder extends TextRegionAccessBuilder {
  public static class YangTextRegionAccessBuildingSequencer extends TextRegionAccessBuildingSequencer {
    @Override
    public void acceptWhitespace(final AbstractRule rule, final String token, final ILeafNode node) {
      boolean _matches = YangTokenUtil.HIDDEN_QUOTES_PATTERN.matcher(token).matches();
      if (_matches) {
        this.acceptSemantic(rule, token);
        super.acceptWhitespace(rule, "", node);
      } else {
        super.acceptWhitespace(rule, token, node);
      }
    }
    
    @Override
    public void acceptUnassignedKeyword(final Keyword keyword, final String token, final ILeafNode node) {
      if ((Objects.equal(keyword.getValue(), "<<<<") || Objects.equal(keyword.getValue(), ">>>>"))) {
        return;
      }
      super.acceptUnassignedKeyword(keyword, token, node);
    }
  }
  
  @Inject
  private YangGrammarAccess grammarAccess;
  
  private TextRegionAccessBuildingSequencer fromSequencer;
  
  private NodeModelBasedRegionAccessBuilder fromNodeModel;
  
  @Override
  public TextRegionAccessBuilder forNodeModel(final XtextResource resource) {
    this.fromNodeModel = new YangNodeModelBasedRegionAccessBuilder(this.grammarAccess).withResource(resource);
    return this;
  }
  
  @Override
  public ISequenceAcceptor forSequence(final ISerializationContext ctx, final EObject root) {
    return this.fromSequencer = new YangTextRegionAccessBuilder.YangTextRegionAccessBuildingSequencer().withRoot(ctx, root);
  }
  
  @Override
  public ITextRegionAccess create() {
    if ((this.fromNodeModel != null)) {
      return this.fromNodeModel.create();
    }
    if ((this.fromSequencer != null)) {
      return this.fromSequencer.getRegionAccess();
    }
    throw new IllegalStateException();
  }
}

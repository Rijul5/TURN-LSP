package io.typefox.yang.formatting2;

import com.google.common.base.Objects;
import io.typefox.yang.formatting2.ExtendedNodeHiddenRegion;
import io.typefox.yang.formatting2.HIDDENSemanticRegion;
import io.typefox.yang.services.YangGrammarAccess;
import org.eclipse.xtend.lib.annotations.FinalFieldsConstructor;
import org.eclipse.xtext.formatting2.regionaccess.ITextRegionAccess;
import org.eclipse.xtext.formatting2.regionaccess.internal.NodeEObjectRegion;
import org.eclipse.xtext.formatting2.regionaccess.internal.NodeHiddenRegion;
import org.eclipse.xtext.formatting2.regionaccess.internal.NodeModelBasedRegionAccess;
import org.eclipse.xtext.formatting2.regionaccess.internal.NodeModelBasedRegionAccessBuilder;
import org.eclipse.xtext.nodemodel.ILeafNode;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.IterableExtensions;

@FinalFieldsConstructor
@SuppressWarnings("all")
public class YangNodeModelBasedRegionAccessBuilder extends NodeModelBasedRegionAccessBuilder {
  @Extension
  private final YangGrammarAccess grammarAccess;
  
  @Override
  protected void add(final NodeModelBasedRegionAccess access, final INode node) {
    if (((node instanceof ILeafNode) && Objects.equal(this.grammarAccess.getHIDDENRule(), node.getGrammarElement()))) {
      this.addHIDDEN(access, node);
      return;
    }
    super.add(access, node);
  }
  
  protected void addHIDDEN(final NodeModelBasedRegionAccess access, final INode node) {
    final NodeEObjectRegion eObjectTokens = IterableExtensions.<NodeEObjectRegion>head(this.getStack());
    final HIDDENSemanticRegion newSemantic = new HIDDENSemanticRegion(access, node);
    final ExtendedNodeHiddenRegion newHidden = this.createHiddenRegion(access);
    newSemantic.setTrailing(newHidden);
    newHidden.setPrevious(newSemantic);
    newSemantic.setLeading(this.getLastHidden());
    this.getLastHidden().setNext(newSemantic);
    eObjectTokens.addChild(newSemantic);
    newSemantic.setEObjectTokens(eObjectTokens);
    this.setLastHidden(newHidden);
  }
  
  @Override
  public ExtendedNodeHiddenRegion createHiddenRegion(final ITextRegionAccess access) {
    return new ExtendedNodeHiddenRegion(access);
  }
  
  @Override
  protected ExtendedNodeHiddenRegion getLastHidden() {
    NodeHiddenRegion _lastHidden = super.getLastHidden();
    return ((ExtendedNodeHiddenRegion) _lastHidden);
  }
  
  public YangNodeModelBasedRegionAccessBuilder(final YangGrammarAccess grammarAccess) {
    super();
    this.grammarAccess = grammarAccess;
  }
}

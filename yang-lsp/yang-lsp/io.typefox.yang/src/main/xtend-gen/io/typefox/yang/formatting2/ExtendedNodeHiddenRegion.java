package io.typefox.yang.formatting2;

import org.eclipse.xtext.formatting2.regionaccess.ISemanticRegion;
import org.eclipse.xtext.formatting2.regionaccess.ITextRegionAccess;
import org.eclipse.xtext.formatting2.regionaccess.internal.NodeHiddenRegion;

@SuppressWarnings("all")
class ExtendedNodeHiddenRegion extends NodeHiddenRegion {
  protected ExtendedNodeHiddenRegion(final ITextRegionAccess access) {
    super(access);
  }
  
  @Override
  public void setPrevious(final ISemanticRegion previous) {
    super.setPrevious(previous);
  }
  
  @Override
  public void setNext(final ISemanticRegion next) {
    super.setNext(next);
  }
}

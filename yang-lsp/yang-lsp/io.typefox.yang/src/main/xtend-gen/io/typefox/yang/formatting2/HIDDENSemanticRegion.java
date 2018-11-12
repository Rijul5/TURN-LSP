package io.typefox.yang.formatting2;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtext.Assignment;
import org.eclipse.xtext.GrammarUtil;
import org.eclipse.xtext.formatting2.regionaccess.IEObjectRegion;
import org.eclipse.xtext.formatting2.regionaccess.IHiddenRegion;
import org.eclipse.xtext.formatting2.regionaccess.ISemanticRegion;
import org.eclipse.xtext.formatting2.regionaccess.ISemanticRegionFinder;
import org.eclipse.xtext.formatting2.regionaccess.ISequentialRegion;
import org.eclipse.xtext.formatting2.regionaccess.internal.NodeEObjectRegion;
import org.eclipse.xtext.formatting2.regionaccess.internal.NodeModelBasedRegionAccess;
import org.eclipse.xtext.formatting2.regionaccess.internal.NodeRegion;
import org.eclipse.xtext.formatting2.regionaccess.internal.SemanticRegionMatcher;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.xbase.lib.Pure;

@SuppressWarnings("all")
class HIDDENSemanticRegion extends NodeRegion implements ISemanticRegion {
  @Accessors
  private NodeEObjectRegion eObjectTokens;
  
  @Accessors
  private IHiddenRegion leading;
  
  @Accessors
  private IHiddenRegion trailing;
  
  protected HIDDENSemanticRegion(final NodeModelBasedRegionAccess access, final INode node) {
    super(access, node);
  }
  
  @Override
  public EObject getGrammarElement() {
    return this.getNode().getGrammarElement();
  }
  
  @Override
  public IEObjectRegion getEObjectRegion() {
    return this.eObjectTokens;
  }
  
  @Override
  public IHiddenRegion getNextHiddenRegion() {
    return this.trailing;
  }
  
  @Override
  public ISemanticRegion getNextSemanticRegion() {
    ISemanticRegion _xifexpression = null;
    if ((this.trailing != null)) {
      _xifexpression = this.trailing.getNextSemanticRegion();
    } else {
      _xifexpression = null;
    }
    return _xifexpression;
  }
  
  @Override
  public ISequentialRegion getNextSequentialRegion() {
    return this.trailing;
  }
  
  @Override
  public IHiddenRegion getPreviousHiddenRegion() {
    return this.leading;
  }
  
  @Override
  public ISemanticRegion getPreviousSemanticRegion() {
    ISemanticRegion _xifexpression = null;
    if ((this.leading != null)) {
      _xifexpression = this.leading.getPreviousSemanticRegion();
    } else {
      _xifexpression = null;
    }
    return _xifexpression;
  }
  
  @Override
  public ISequentialRegion getPreviousSequentialRegion() {
    return this.leading;
  }
  
  @Override
  public ISemanticRegionFinder immediatelyFollowing() {
    ISemanticRegion _nextSemanticRegion = this.getNextSemanticRegion();
    return new SemanticRegionMatcher(_nextSemanticRegion);
  }
  
  @Override
  public ISemanticRegionFinder immediatelyPreceding() {
    ISemanticRegion _previousSemanticRegion = this.getPreviousSemanticRegion();
    return new SemanticRegionMatcher(_previousSemanticRegion);
  }
  
  @Override
  public EObject getSemanticElement() {
    EObject _xifexpression = null;
    if ((this.eObjectTokens != null)) {
      _xifexpression = this.eObjectTokens.getSemanticElement();
    } else {
      _xifexpression = null;
    }
    return _xifexpression;
  }
  
  @Override
  public EStructuralFeature getContainingFeature() {
    Assignment assignment = GrammarUtil.containingAssignment(this.getGrammarElement());
    if ((assignment != null)) {
      return this.getSemanticElement().eClass().getEStructuralFeature(assignment.getFeature());
    }
    return null;
  }
  
  @Override
  public IEObjectRegion getContainingRegion() {
    return this.eObjectTokens;
  }
  
  @Override
  public int getIndexInContainingFeature() {
    throw new UnsupportedOperationException("TODO: auto-generated method stub");
  }
  
  @Pure
  public NodeEObjectRegion getEObjectTokens() {
    return this.eObjectTokens;
  }
  
  public void setEObjectTokens(final NodeEObjectRegion eObjectTokens) {
    this.eObjectTokens = eObjectTokens;
  }
  
  @Pure
  public IHiddenRegion getLeading() {
    return this.leading;
  }
  
  public void setLeading(final IHiddenRegion leading) {
    this.leading = leading;
  }
  
  @Pure
  public IHiddenRegion getTrailing() {
    return this.trailing;
  }
  
  public void setTrailing(final IHiddenRegion trailing) {
    this.trailing = trailing;
  }
}

package io.typefox.yang.diagram;

import io.typefox.yang.diagram.YangNodeClassified;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtext.xbase.lib.Pure;

@Accessors
@SuppressWarnings("all")
public class YangNode extends YangNodeClassified {
  private Boolean expanded;
  
  @Pure
  public Boolean getExpanded() {
    return this.expanded;
  }
  
  public void setExpanded(final Boolean expanded) {
    this.expanded = expanded;
  }
}

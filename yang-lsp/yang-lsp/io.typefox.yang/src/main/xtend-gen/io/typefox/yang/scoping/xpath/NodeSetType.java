package io.typefox.yang.scoping.xpath;

import io.typefox.yang.scoping.xpath.XpathType;
import java.util.List;
import org.eclipse.xtend.lib.annotations.Data;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.xbase.lib.Pure;
import org.eclipse.xtext.xbase.lib.util.ToStringBuilder;

@Data
@SuppressWarnings("all")
public class NodeSetType implements XpathType {
  private final List<IEObjectDescription> nodes;
  
  public NodeSetType(final List<IEObjectDescription> nodes) {
    super();
    this.nodes = nodes;
  }
  
  @Override
  @Pure
  public int hashCode() {
    return 31 * 1 + ((this.nodes== null) ? 0 : this.nodes.hashCode());
  }
  
  @Override
  @Pure
  public boolean equals(final Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    NodeSetType other = (NodeSetType) obj;
    if (this.nodes == null) {
      if (other.nodes != null)
        return false;
    } else if (!this.nodes.equals(other.nodes))
      return false;
    return true;
  }
  
  @Override
  @Pure
  public String toString() {
    ToStringBuilder b = new ToStringBuilder(this);
    b.add("nodes", this.nodes);
    return b.toString();
  }
  
  @Pure
  public List<IEObjectDescription> getNodes() {
    return this.nodes;
  }
}

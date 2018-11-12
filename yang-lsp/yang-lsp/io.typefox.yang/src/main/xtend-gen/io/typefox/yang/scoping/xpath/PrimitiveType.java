package io.typefox.yang.scoping.xpath;

import io.typefox.yang.scoping.xpath.XpathType;
import org.eclipse.xtend.lib.annotations.Data;
import org.eclipse.xtext.xbase.lib.Pure;
import org.eclipse.xtext.xbase.lib.util.ToStringBuilder;

@Data
@SuppressWarnings("all")
public class PrimitiveType implements XpathType {
  private final String name;
  
  public PrimitiveType(final String name) {
    super();
    this.name = name;
  }
  
  @Override
  @Pure
  public int hashCode() {
    return 31 * 1 + ((this.name== null) ? 0 : this.name.hashCode());
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
    PrimitiveType other = (PrimitiveType) obj;
    if (this.name == null) {
      if (other.name != null)
        return false;
    } else if (!this.name.equals(other.name))
      return false;
    return true;
  }
  
  @Override
  @Pure
  public String toString() {
    ToStringBuilder b = new ToStringBuilder(this);
    b.add("name", this.name);
    return b.toString();
  }
  
  @Pure
  public String getName() {
    return this.name;
  }
}

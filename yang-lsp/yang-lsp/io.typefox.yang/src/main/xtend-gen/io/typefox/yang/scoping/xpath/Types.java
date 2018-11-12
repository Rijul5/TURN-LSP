package io.typefox.yang.scoping.xpath;

import io.typefox.yang.scoping.xpath.NodeSetType;
import io.typefox.yang.scoping.xpath.PrimitiveType;
import io.typefox.yang.scoping.xpath.XpathType;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;

@SuppressWarnings("all")
public class Types {
  public static final XpathType ANY = new XpathType() {
  };
  
  public static final PrimitiveType BOOLEAN = new PrimitiveType("boolean");
  
  public static final PrimitiveType STRING = new PrimitiveType("string");
  
  public static final PrimitiveType NUMBER = new PrimitiveType("number");
  
  public static NodeSetType nodeSet(final IEObjectDescription nodes) {
    if ((nodes == null)) {
      return Types.nodeSet(Collections.<IEObjectDescription>unmodifiableList(CollectionLiterals.<IEObjectDescription>newArrayList()));
    } else {
      return Types.nodeSet(Collections.<IEObjectDescription>unmodifiableList(CollectionLiterals.<IEObjectDescription>newArrayList(nodes)));
    }
  }
  
  public static NodeSetType nodeSet(final List<IEObjectDescription> nodes) {
    return new NodeSetType(nodes);
  }
  
  public static NodeSetType union(final XpathType type, final XpathType type2) {
    final ArrayList<IEObjectDescription> nodes = CollectionLiterals.<IEObjectDescription>newArrayList();
    if ((type instanceof NodeSetType)) {
      nodes.addAll(((NodeSetType)type).getNodes());
    }
    if ((type2 instanceof NodeSetType)) {
      nodes.addAll(((NodeSetType)type2).getNodes());
    }
    return Types.nodeSet(nodes);
  }
}

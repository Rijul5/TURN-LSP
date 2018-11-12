package io.typefox.yang.resource;

import java.util.regex.Pattern;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.parsetree.reconstr.impl.TokenUtil;

@SuppressWarnings("all")
public class YangTokenUtil extends TokenUtil {
  public static final Pattern HIDDEN_QUOTES_PATTERN = Pattern.compile("[\"\']\\s*\\+?\\s*");
  
  @Override
  public boolean isWhitespaceOrCommentNode(final INode node) {
    return (YangTokenUtil.HIDDEN_QUOTES_PATTERN.matcher(node.getText()).matches() || super.isWhitespaceOrCommentNode(node));
  }
}

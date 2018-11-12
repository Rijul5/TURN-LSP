package io.typefox.yang.documentation;

import com.google.common.collect.Iterables;
import com.google.inject.Singleton;
import io.typefox.yang.yang.Description;
import io.typefox.yang.yang.Statement;
import io.typefox.yang.yang.YangPackage;
import java.util.Arrays;
import org.apache.log4j.Logger;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.documentation.IEObjectDocumentationProvider;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;
import org.eclipse.xtext.util.internal.Log;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.IterableExtensions;

@Log
@Singleton
@SuppressWarnings("all")
public class DocumentationProvider implements IEObjectDocumentationProvider {
  protected String _getDocumentation(final EObject o) {
    return null;
  }
  
  protected String _getDocumentation(final Statement o) {
    final Description description = IterableExtensions.<Description>head(Iterables.<Description>filter(o.getSubstatements(), Description.class));
    if ((description == null)) {
      return null;
    }
    final INode node = IterableExtensions.<INode>head(NodeModelUtils.findNodesForFeature(description, YangPackage.Literals.DESCRIPTION__DESCRIPTION));
    if ((node == null)) {
      return null;
    }
    try {
      final int column = NodeModelUtils.getLineAndColumn(node, node.getOffset()).getColumn();
      final StringBuilder result = new StringBuilder();
      int lineNo = 0;
      String[] _split = description.getDescription().split("\\n");
      for (final String line : _split) {
        {
          if ((lineNo == 0)) {
            result.append(line);
          } else {
            int substrStart = 0;
            for (; (((substrStart < line.length()) && (substrStart < column)) && Character.isWhitespace(line.charAt(substrStart))); substrStart++) {
            }
            result.append("\n");
            result.append(line.substring(substrStart));
          }
          lineNo++;
        }
      }
      return result.toString();
    } catch (final Throwable _t) {
      if (_t instanceof Exception) {
        final Exception e = (Exception)_t;
        StringConcatenation _builder = new StringConcatenation();
        _builder.append("Couldn\'t obtain documentatio for node ");
        _builder.append(o);
        _builder.append(" (");
        String _simpleName = e.getClass().getSimpleName();
        _builder.append(_simpleName);
        _builder.append(" : ");
        String _message = e.getMessage();
        _builder.append(_message);
        _builder.append(")");
        DocumentationProvider.LOG.info(_builder);
        return null;
      } else {
        throw Exceptions.sneakyThrow(_t);
      }
    }
  }
  
  public String getDocumentation(final EObject o) {
    if (o instanceof Statement) {
      return _getDocumentation((Statement)o);
    } else if (o != null) {
      return _getDocumentation(o);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(o).toString());
    }
  }
  
  private static final Logger LOG = Logger.getLogger(DocumentationProvider.class);
}

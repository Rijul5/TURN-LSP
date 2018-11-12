package io.typefox.yang.scoping;

import com.google.inject.Inject;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.diagnostics.Severity;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.validation.EObjectDiagnosticImpl;
import org.eclipse.xtext.validation.IssueSeveritiesProvider;

@SuppressWarnings("all")
public class Validator {
  @Inject
  private IssueSeveritiesProvider severitiesProvider;
  
  public boolean addIssue(final EObject obj, final EStructuralFeature feature, final String errorMessage, final String issueCode) {
    boolean _xblockexpression = false;
    {
      Resource _eResource = obj.eResource();
      final XtextResource resource = ((XtextResource) _eResource);
      final Severity severity = this.severitiesProvider.getIssueSeverities(resource).getSeverity(issueCode);
      EList<Resource.Diagnostic> _switchResult = null;
      if (severity != null) {
        switch (severity) {
          case ERROR:
            _switchResult = resource.getErrors();
            break;
          case WARNING:
            _switchResult = resource.getWarnings();
            break;
          default:
            _switchResult = null;
            break;
        }
      } else {
        _switchResult = null;
      }
      final EList<Resource.Diagnostic> list = _switchResult;
      boolean _xifexpression = false;
      if ((list != null)) {
        boolean _xblockexpression_1 = false;
        {
          String[] _newArrayOfSize = new String[0];
          final EObjectDiagnosticImpl diagnostic = new EObjectDiagnosticImpl(severity, issueCode, errorMessage, obj, feature, (-1), _newArrayOfSize);
          boolean _xifexpression_1 = false;
          boolean _contains = list.contains(diagnostic);
          boolean _not = (!_contains);
          if (_not) {
            _xifexpression_1 = list.add(diagnostic);
          }
          _xblockexpression_1 = _xifexpression_1;
        }
        _xifexpression = _xblockexpression_1;
      }
      _xblockexpression = _xifexpression;
    }
    return _xblockexpression;
  }
}

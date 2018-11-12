package io.typefox.yang.validation;

import com.google.common.collect.Iterables;
import com.google.inject.Inject;
import io.typefox.yang.scoping.ScopeContextProvider;
import io.typefox.yang.utils.ExtensionProvider;
import io.typefox.yang.validation.IValidatorExtension;
import io.typefox.yang.yang.AbstractModule;
import java.util.List;
import org.apache.log4j.Logger;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.diagnostics.Severity;
import org.eclipse.xtext.preferences.PreferenceKey;
import org.eclipse.xtext.service.OperationCanceledError;
import org.eclipse.xtext.service.OperationCanceledManager;
import org.eclipse.xtext.util.CancelIndicator;
import org.eclipse.xtext.util.IAcceptor;
import org.eclipse.xtext.util.internal.Log;
import org.eclipse.xtext.validation.CheckMode;
import org.eclipse.xtext.validation.Issue;
import org.eclipse.xtext.validation.IssueSeverities;
import org.eclipse.xtext.validation.IssueSeveritiesProvider;
import org.eclipse.xtext.validation.ResourceValidatorImpl;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.IterableExtensions;

@Log
@SuppressWarnings("all")
public class ResourceValidator extends ResourceValidatorImpl {
  @Inject
  private ScopeContextProvider ctxProvider;
  
  @Inject
  private ExtensionProvider extensionProvider;
  
  @Inject
  private OperationCanceledManager operationCanceledManager;
  
  @Inject
  private IssueSeveritiesProvider issueSeveritiesProvider;
  
  @Override
  public List<Issue> validate(final Resource resource, final CheckMode mode, final CancelIndicator mon) throws OperationCanceledError {
    List<Issue> _xblockexpression = null;
    {
      Iterable<AbstractModule> _filter = Iterables.<AbstractModule>filter(resource.getContents(), AbstractModule.class);
      for (final AbstractModule m : _filter) {
        this.ctxProvider.getScopeContext(m).resolveAll();
      }
      _xblockexpression = super.validate(resource, mode, mon);
    }
    return _xblockexpression;
  }
  
  public static final PreferenceKey VALIDATORS = new PreferenceKey("extension.validators", "");
  
  @Override
  protected void validate(final Resource resource, final CheckMode mode, final CancelIndicator monitor, final IAcceptor<Issue> acceptor) {
    final List<IValidatorExtension> validators = this.extensionProvider.<IValidatorExtension>getExtensions(ResourceValidator.VALIDATORS, resource, IValidatorExtension.class);
    boolean _isNullOrEmpty = IterableExtensions.isNullOrEmpty(validators);
    boolean _not = (!_isNullOrEmpty);
    if (_not) {
      final IssueSeverities issueSeverities = this.issueSeveritiesProvider.getIssueSeverities(resource);
      final IAcceptor<Issue> _function = (Issue issue) -> {
        if ((issue instanceof Issue.IssueImpl)) {
          final Severity configured = issueSeverities.getSeverity(((Issue.IssueImpl)issue).getCode());
          if ((configured != null)) {
            ((Issue.IssueImpl)issue).setSeverity(configured);
          }
        }
        acceptor.accept(issue);
      };
      final IAcceptor<Issue> wrappedAcceptor = _function;
      for (final IValidatorExtension validator : validators) {
        try {
          EObject _head = IterableExtensions.<EObject>head(resource.getContents());
          validator.validate(((AbstractModule) _head), wrappedAcceptor, monitor);
        } catch (final Throwable _t) {
          if (_t instanceof Exception) {
            final Exception e = (Exception)_t;
            this.operationCanceledManager.propagateIfCancelException(e);
            ResourceValidator.LOG.error("Error running validator extension", e);
          } else {
            throw Exceptions.sneakyThrow(_t);
          }
        }
      }
    }
    super.validate(resource, mode, monitor, acceptor);
  }
  
  @Override
  protected IAcceptor<Issue> createAcceptor(final List<Issue> result) {
    final IAcceptor<Issue> delegate = super.createAcceptor(result);
    final IAcceptor<Issue> _function = (Issue it) -> {
      delegate.accept(it);
    };
    return _function;
  }
  
  private static final Logger LOG = Logger.getLogger(ResourceValidator.class);
}

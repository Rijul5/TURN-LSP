package io.typefox.yang.validation;

import io.typefox.yang.yang.AbstractModule;
import org.eclipse.xtext.util.CancelIndicator;
import org.eclipse.xtext.util.IAcceptor;
import org.eclipse.xtext.validation.Issue;

@SuppressWarnings("all")
public interface IValidatorExtension {
  public abstract void validate(final AbstractModule module, final IAcceptor<Issue> issueAcceptor, final CancelIndicator cancelIndicator);
}

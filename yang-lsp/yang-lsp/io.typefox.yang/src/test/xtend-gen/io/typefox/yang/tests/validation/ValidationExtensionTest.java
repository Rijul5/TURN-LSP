package io.typefox.yang.tests.validation;

import com.google.common.base.Objects;
import io.typefox.yang.tests.AbstractYangTest;
import java.io.File;
import java.util.List;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.diagnostics.Severity;
import org.eclipse.xtext.validation.Issue;
import org.eclipse.xtext.workspace.FileProjectConfig;
import org.eclipse.xtext.workspace.ProjectConfigAdapter;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.junit.Assert;
import org.junit.Test;

@SuppressWarnings("all")
public class ValidationExtensionTest extends AbstractYangTest {
  private static final String BAD_NAME = "bad_name";
  
  @Test
  public void testExtensionNotRegistered() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("module foo {");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    final Resource m = this.load(_builder);
    this.assertNoErrors(this.root(m), ValidationExtensionTest.BAD_NAME);
  }
  
  @Test
  public void testExtensionRegistered() {
    try {
      final File root = new File("./src/test/resources/project").getCanonicalFile();
      FileProjectConfig _fileProjectConfig = new FileProjectConfig(root);
      ProjectConfigAdapter.install(this.resourceSet, _fileProjectConfig);
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("module foo {");
      _builder.newLine();
      _builder.append("\t");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      final Resource m = this.load(_builder);
      final List<Issue> validate = this.validator.validate(this.root(m).eResource());
      final Function1<Issue, Boolean> _function = (Issue it) -> {
        String _code = it.getCode();
        return Boolean.valueOf(Objects.equal(_code, ValidationExtensionTest.BAD_NAME));
      };
      final Issue issue = IterableExtensions.<Issue>findFirst(validate, _function);
      Assert.assertEquals(Severity.WARNING, issue.getSeverity());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}

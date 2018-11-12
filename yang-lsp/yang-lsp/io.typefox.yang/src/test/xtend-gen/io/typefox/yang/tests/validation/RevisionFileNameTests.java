package io.typefox.yang.tests.validation;

import com.google.inject.Inject;
import io.typefox.yang.tests.YangInjectorProvider;
import io.typefox.yang.validation.IssueCodes;
import io.typefox.yang.yang.AbstractModule;
import io.typefox.yang.yang.YangPackage;
import org.eclipse.emf.common.util.URI;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.resource.XtextResourceSet;
import org.eclipse.xtext.testing.InjectWith;
import org.eclipse.xtext.testing.XtextRunner;
import org.eclipse.xtext.testing.util.ParseHelper;
import org.eclipse.xtext.testing.validation.ValidationTestHelper;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Extension;
import org.junit.Test;
import org.junit.runner.RunWith;

@InjectWith(YangInjectorProvider.class)
@RunWith(XtextRunner.class)
@SuppressWarnings("all")
public class RevisionFileNameTests {
  @Inject
  @Extension
  private ParseHelper<AbstractModule> _parseHelper;
  
  @Inject
  private XtextResourceSet resourceSet;
  
  @Inject
  @Extension
  private ValidationTestHelper validationTestHelper;
  
  @Test
  public void testIllegalFilename() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("module foo {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("prefix foo;");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("namespace foo;");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      this.validationTestHelper.assertWarning(this._parseHelper.parse(_builder, URI.createURI("test@invalidformat.yang"), this.resourceSet), YangPackage.Literals.ABSTRACT_MODULE, IssueCodes.INVALID_REVISION_FORMAT);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testWrongFilename() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("module foo {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("prefix foo;");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("namespace foo;");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("revision 2012-12-12 {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("description \'what a revision!\';");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      this.validationTestHelper.assertWarning(this._parseHelper.parse(_builder, URI.createURI("test@2000-01-01.yang"), this.resourceSet), YangPackage.Literals.REVISION, IssueCodes.REVISION_MISMATCH);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}

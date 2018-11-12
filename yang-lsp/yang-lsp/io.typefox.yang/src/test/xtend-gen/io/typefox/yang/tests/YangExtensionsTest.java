package io.typefox.yang.tests;

import com.google.inject.Inject;
import io.typefox.yang.tests.AbstractYangTest;
import io.typefox.yang.utils.YangExtensions;
import io.typefox.yang.yang.YangFactory;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.Extension;
import org.junit.Assert;
import org.junit.Test;

/**
 * Testing the YANG extensions.
 * 
 * @author akos.kitta
 */
@SuppressWarnings("all")
public class YangExtensionsTest extends AbstractYangTest {
  @Inject
  @Extension
  private YangExtensions _yangExtensions;
  
  @Test
  public void checkImplicitVersion_Expect_1() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("module example-system {");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    final Resource it = this.load(_builder);
    Assert.assertEquals(YangExtensions.YANG_1, this._yangExtensions.getYangVersion(this.root(it)));
  }
  
  @Test
  public void checkExplicitVersion_Expect_1() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("module example-system {");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("yang-version 1;");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    final Resource it = this.load(_builder);
    Assert.assertEquals(YangExtensions.YANG_1, this._yangExtensions.getYangVersion(this.root(it)));
  }
  
  @Test
  public void checkExplicitVersion_Expect_1_1() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("module example-system {");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("yang-version 1.1;");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    final Resource it = this.load(_builder);
    Assert.assertEquals(YangExtensions.YANG_1_1, this._yangExtensions.getYangVersion(this.root(it)));
  }
  
  @Test
  public void checkExplicitVersion_Invalid_Expect_Null() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("module example-system {");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("yang-version 1.2;");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    final Resource it = this.load(_builder);
    Assert.assertEquals(null, this._yangExtensions.getYangVersion(this.root(it)));
  }
  
  @Test
  public void checkExplicitVersion_Broken_Expect_Null() {
    Assert.assertEquals(null, YangFactory.eINSTANCE.createYangVersion().getYangVersion());
  }
}

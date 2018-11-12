package io.typefox.yang.tests;

import com.google.inject.Inject;
import io.typefox.yang.tests.AbstractYangTest;
import io.typefox.yang.utils.YangTypesExtensions;
import io.typefox.yang.yang.Type;
import io.typefox.yang.yang.Typedef;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.Extension;
import org.junit.Assert;
import org.junit.Test;

/**
 * Test for the YANG built-in type extensions.
 * 
 * @author akos.kitta
 */
@SuppressWarnings("all")
public class YangTypesExtensionsTest extends AbstractYangTest {
  @Inject
  @Extension
  private YangTypesExtensions _yangTypesExtensions;
  
  @Test
  public void checkBuiltin_True() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("module foo {");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("typedef my-base-int32-type {");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("type int32 {");
    _builder.newLine();
    _builder.append("      ");
    _builder.append("range \"1..4\";");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    Assert.assertTrue(this._yangTypesExtensions.isBuiltin(this._yangExtensions.<Typedef>firstSubstatementsOfType(this.root(this.load(_builder)), Typedef.class)));
  }
  
  @Test
  public void checkBuiltin_False() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("module foo {");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("typedef my-type1 {");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("type my-base-int32-type {");
    _builder.newLine();
    _builder.append("      ");
    _builder.append("range \"11..max\";");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    Assert.assertFalse(this._yangTypesExtensions.isBuiltin(this._yangExtensions.<Typedef>firstSubstatementsOfType(this.root(this.load(_builder)), Typedef.class)));
  }
  
  @Test
  public void checkSubtypeOfInteger_01() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("module foo {");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("typedef my-base-int32-type {");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("type int32 {");
    _builder.newLine();
    _builder.append("      ");
    _builder.append("range \"1..4\";");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    Assert.assertTrue(this._yangTypesExtensions.isSubtypeOfInteger(this._yangExtensions.<Type>firstSubstatementsOfType(this._yangExtensions.<Typedef>firstSubstatementsOfType(this.root(this.load(_builder)), Typedef.class), Type.class)));
  }
  
  @Test
  public void checkSubtypeOfInteger_02() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("module foo {");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("typedef my-base-int32-type {");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("type decimal64 {");
    _builder.newLine();
    _builder.append("      ");
    _builder.append("range \"1..4\";");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    Assert.assertFalse(this._yangTypesExtensions.isSubtypeOfInteger(this._yangExtensions.<Type>firstSubstatementsOfType(this._yangExtensions.<Typedef>firstSubstatementsOfType(this.root(this.load(_builder)), Typedef.class), Type.class)));
  }
  
  @Test
  public void checkSubtypeOfInteger_03() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("module foo {");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("typedef my-base-int32-type {");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("type int32 {");
    _builder.newLine();
    _builder.append("      ");
    _builder.append("range \"1..4 | 10..20\";");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("  ");
    _builder.append("typedef my-type1 {");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("type my-base-int32-type {");
    _builder.newLine();
    _builder.append("      ");
    _builder.append("range \"11..max\";");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    Assert.assertTrue(this._yangTypesExtensions.isSubtypeOfInteger(this._yangExtensions.<Type>firstSubstatementsOfType(this._yangExtensions.<Typedef>lastSubstatementsOfType(this.root(this.load(_builder)), Typedef.class), Type.class)));
  }
  
  @Test
  public void checkSubtypeOfInteger_04() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("module foo {");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("typedef my-base-int32-type {");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("type decimal64 {");
    _builder.newLine();
    _builder.append("      ");
    _builder.append("range \"1..4 | 10..20\";");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("  ");
    _builder.append("typedef my-type1 {");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("type my-base-int32-type {");
    _builder.newLine();
    _builder.append("      ");
    _builder.append("range \"11..max\";");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    Assert.assertFalse(this._yangTypesExtensions.isSubtypeOfInteger(this._yangExtensions.<Type>firstSubstatementsOfType(this._yangExtensions.<Typedef>lastSubstatementsOfType(this.root(this.load(_builder)), Typedef.class), Type.class)));
  }
  
  @Test
  public void checkYangRange_01() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("module foo {");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("typedef my-base-int32-type {");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("type int32 {");
    _builder.newLine();
    _builder.append("      ");
    _builder.append("range \"1..4\";");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    this.assertEquals(this._yangTypesExtensions.getYangRefinable(this._yangTypesExtensions.getRefinement(this._yangExtensions.<Type>firstSubstatementsOfType(this._yangExtensions.<Typedef>firstSubstatementsOfType(this.root(this.load(_builder)), Typedef.class), Type.class))).toString(), "1..4");
  }
  
  @Test
  public void checkYangRange_02() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("module foo {");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("typedef my-base-int32-type {");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("type int32 {");
    _builder.newLine();
    _builder.append("      ");
    _builder.append("range \"1 | 2 | 4..5 | 6\";");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    this.assertEquals(this._yangTypesExtensions.getYangRefinable(this._yangTypesExtensions.getRefinement(this._yangExtensions.<Type>firstSubstatementsOfType(this._yangExtensions.<Typedef>firstSubstatementsOfType(this.root(this.load(_builder)), Typedef.class), Type.class))).toString(), "1 | 2 | 4..5 | 6");
  }
  
  @Test
  public void checkYangRange_03() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("module c {");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("typedef my-base-int32-type {");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("type int32 {");
    _builder.newLine();
    _builder.append("      ");
    _builder.append("range \"1..4 | 10..200\";");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("typedef my-type1 {");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("type my-base-int32-type {");
    _builder.newLine();
    _builder.append("      ");
    _builder.append("range \"2..max\";");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("typedef my-type2 {");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("type my-type1 {");
    _builder.newLine();
    _builder.append("      ");
    _builder.append("range \"min..max\";");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    this.assertEquals(this._yangTypesExtensions.getYangRefinable(this._yangTypesExtensions.getRefinement(this._yangExtensions.<Type>firstSubstatementsOfType(this._yangExtensions.<Typedef>lastSubstatementsOfType(this.root(this.load(_builder)), Typedef.class), Type.class))).toString(), "2..200");
  }
  
  private void assertEquals(final CharSequence actual, final CharSequence expected) {
    Assert.assertEquals(expected, actual);
  }
}

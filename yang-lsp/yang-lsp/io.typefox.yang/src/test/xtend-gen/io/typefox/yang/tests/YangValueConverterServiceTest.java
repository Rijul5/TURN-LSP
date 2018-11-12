package io.typefox.yang.tests;

import io.typefox.yang.tests.AbstractYangTest;
import io.typefox.yang.yang.Pattern;
import io.typefox.yang.yang.Type;
import io.typefox.yang.yang.Typedef;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.junit.Assert;
import org.junit.Test;

/**
 * Test for checking the string escaping in the value converter service.
 * 
 * @author akos.kitta
 */
@SuppressWarnings("all")
public class YangValueConverterServiceTest extends AbstractYangTest {
  @Test
  public void checkConvertSingleQuotedString() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("module foo {");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("typedef ipv6-address {");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("type string {");
    _builder.newLine();
    _builder.append("      ");
    _builder.append("pattern \'((:|[0-9a-fA-F]{0,4}):)([0-9a-fA-F]{0,4}:){0,5}\'");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("+ \'((([0-9a-fA-F]{0,4}:)?(:|[0-9a-fA-F]{0,4}))|\'");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("+ \'(((25[0-5]|2[0-4][0-9]|[01]?[0-9]?[0-9])\\.){3}\'");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("+ \'(25[0-5]|2[0-4][0-9]|[01]?[0-9]?[0-9])))\'");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("+ \'(%[\\p{N}\\p{L}]+)?\';");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    final Resource it = this.load(_builder);
    final Pattern pattern = this._yangExtensions.<Pattern>firstSubstatementsOfType(this._yangExtensions.<Type>firstSubstatementsOfType(this._yangExtensions.<Typedef>firstSubstatementsOfType(this.root(it), Typedef.class), Type.class), Pattern.class);
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("((:|[0-9a-fA-F]{0,4}):)([0-9a-fA-F]{0,4}:){0,5}((([0-9a-fA-F]{0,4}:)?(:|[0-9a-fA-F]{0,4}))|(((25[0-5]|2[0-4][0-9]|[01]?[0-9]?[0-9])\\.){3}(25[0-5]|2[0-4][0-9]|[01]?[0-9]?[0-9])))(%[\\p{N}\\p{L}]+)?");
    Assert.assertEquals(_builder_1.toString(), 
      pattern.getRegexp());
  }
  
  @Test
  public void checkConvertDoubleQuotedString() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("module foo {");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("typedef ipv6-address {");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("type string {");
    _builder.newLine();
    _builder.append("      ");
    _builder.append("pattern \"((:|[0-9a-fA-F]{0,4}):)([0-9a-fA-F]{0,4}:){0,5}\"");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("+ \"((([0-9a-fA-F]{0,4}:)?(:|[0-9a-fA-F]{0,4}))|\"");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("+ \"(((25[0-5]|2[0-4][0-9]|[01]?[0-9]?[0-9])\\.){3}\"");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("+ \"(25[0-5]|2[0-4][0-9]|[01]?[0-9]?[0-9])))\"");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("+ \"(%[\\p{N}\\p{L}]+)?\";");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    final Resource it = this.load(_builder);
    final Pattern pattern = this._yangExtensions.<Pattern>firstSubstatementsOfType(this._yangExtensions.<Type>firstSubstatementsOfType(this._yangExtensions.<Typedef>firstSubstatementsOfType(this.root(it), Typedef.class), Type.class), Pattern.class);
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("((:|[0-9a-fA-F]{0,4}):)([0-9a-fA-F]{0,4}:){0,5}((([0-9a-fA-F]{0,4}:)?(:|[0-9a-fA-F]{0,4}))|(((25[0-5]|2[0-4][0-9]|[01]?[0-9]?[0-9])\\.){3}(25[0-5]|2[0-4][0-9]|[01]?[0-9]?[0-9])))(%[\\p{N}\\p{L}]+)?");
    Assert.assertEquals(_builder_1.toString(), 
      pattern.getRegexp());
  }
}

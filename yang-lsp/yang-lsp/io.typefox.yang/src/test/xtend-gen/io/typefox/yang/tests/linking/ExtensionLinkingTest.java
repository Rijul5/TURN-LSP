package io.typefox.yang.tests.linking;

import io.typefox.yang.tests.AbstractYangTest;
import io.typefox.yang.yang.Extension;
import io.typefox.yang.yang.Unknown;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.junit.Assert;
import org.junit.Test;

@SuppressWarnings("all")
public class ExtensionLinkingTest extends AbstractYangTest {
  @Test
  public void testLocalExtension() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("module xt7 {");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("prefix x;");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("namespace \"urn:test:xt7\";");
    _builder.newLine();
    _builder.newLine();
    _builder.append("  ");
    _builder.append("leaf foo {");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("type int16;");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("x:foo \"some string\";");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("  ");
    _builder.append("x:foo \"another string\";");
    _builder.newLine();
    _builder.newLine();
    _builder.append("  ");
    _builder.append("extension foo {");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("argument bar {");
    _builder.newLine();
    _builder.append("      ");
    _builder.append("yin-element false;");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    final Resource m = this.load(_builder);
    final Unknown unk = IterableExtensions.head(this._yangExtensions.<Unknown>substatementsOfType(this.root(m), Unknown.class));
    Assert.assertSame(unk.getExtension(), IterableExtensions.head(this._yangExtensions.<Extension>substatementsOfType(this.root(m), Extension.class)));
  }
}

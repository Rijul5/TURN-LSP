package io.typefox.yang.tests.linking;

import com.google.common.collect.Iterators;
import io.typefox.yang.tests.AbstractYangTest;
import io.typefox.yang.yang.XpathNameTest;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.IteratorExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.junit.Assert;
import org.junit.Test;

@SuppressWarnings("all")
public class BugMustLinkingTest extends AbstractYangTest {
  @Test
  public void testMustLinking() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("module bug_mustlinking {");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("prefix bug_mustlinking;");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("namespace bug_mustlinking;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("    ");
    _builder.append("container c1 {");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("choice co {");
    _builder.newLine();
    _builder.append("            ");
    _builder.append("case cz1 {");
    _builder.newLine();
    _builder.append("                ");
    _builder.append("container c2 {");
    _builder.newLine();
    _builder.append("                    ");
    _builder.append("uses testgrp {");
    _builder.newLine();
    _builder.append("                        ");
    _builder.append("refine a {");
    _builder.newLine();
    _builder.append("                            ");
    _builder.append("must g1;");
    _builder.newLine();
    _builder.append("                        ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("                    ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("                ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("            ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("    ");
    _builder.append("grouping testgrp {");
    _builder.newLine();
    _builder.append("      ");
    _builder.append("list a {");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("leaf g1 { type string; }");
    _builder.newLine();
    _builder.append("      ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("   ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    final Resource r = this.load(_builder);
    this.assertNoErrors(r);
    final Procedure1<XpathNameTest> _function = (XpathNameTest it) -> {
      Assert.assertFalse(it.getRef().eIsProxy());
    };
    IteratorExtensions.<XpathNameTest>forEach(Iterators.<XpathNameTest>filter(r.getAllContents(), XpathNameTest.class), _function);
  }
}

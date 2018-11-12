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
public class Bug132Test extends AbstractYangTest {
  @Test
  public void testDeviationLinking() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("module m1 { ");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("prefix m;");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("namespace m;");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("container c1 { ");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("leaf l1 { ");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("type string;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("} ");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("grouping g1 { ");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("leaf gl1 { ");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("type leafref { ");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("path \"/m:c1/m:l1\";");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
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

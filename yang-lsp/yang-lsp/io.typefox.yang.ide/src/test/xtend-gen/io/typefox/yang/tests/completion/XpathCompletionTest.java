package io.typefox.yang.tests.completion;

import io.typefox.yang.tests.AbstractYangLSPTest;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.testing.TestCompletionConfiguration;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.junit.Test;

@SuppressWarnings("all")
public class XpathCompletionTest extends AbstractYangLSPTest {
  public static class XpathTest {
    private String expression;
    
    private CharSequence expected;
  }
  
  private void testXpath(final Procedure1<? super XpathCompletionTest.XpathTest> cb) {
    final XpathCompletionTest.XpathTest d = new XpathCompletionTest.XpathTest();
    cb.apply(d);
    int cursorIdx = d.expression.indexOf("|");
    if ((cursorIdx >= 0)) {
      String _substring = d.expression.substring(0, cursorIdx);
      String _substring_1 = d.expression.substring((cursorIdx + 1));
      String _plus = (_substring + _substring_1);
      d.expression = _plus;
    } else {
      cursorIdx = d.expression.length();
    }
    final int cursor = cursorIdx;
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("module foo {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("prefix foo;");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("namespace urn:foo;");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("container outer {");
    _builder.newLine();
    _builder.append("when \"");
    _builder.append(d.expression);
    _builder.append("\";");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t");
    _builder.append("container middle {");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("container inner {");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("leaf inner-leaf {");
    _builder.newLine();
    _builder.append("\t\t\t\t\t");
    _builder.append("type string;");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("leaf middle-leaf {");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("type string;");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("leaf outer-leaf {");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("type string;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    final String fullModel = _builder.toString();
    final Procedure1<TestCompletionConfiguration> _function = (TestCompletionConfiguration it) -> {
      it.setModel(fullModel);
      it.setLine(4);
      it.setColumn((6 + cursor));
      it.setExpectedCompletionItems(d.expected.toString());
    };
    this.testCompletion(_function);
  }
  
  @Test
  public void testAbsolute() {
    final Procedure1<XpathCompletionTest.XpathTest> _function = (XpathCompletionTest.XpathTest it) -> {
      it.expression = "/";
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("outer -> outer [[4, 7] .. [4, 7]]");
      _builder.newLine();
      it.expected = _builder;
    };
    this.testXpath(_function);
  }
  
  @Test
  public void testRelative() {
    final Procedure1<XpathCompletionTest.XpathTest> _function = (XpathCompletionTest.XpathTest it) -> {
      it.expression = "";
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("middle -> middle [[4, 6] .. [4, 6]]");
      _builder.newLine();
      _builder.append("outer-leaf -> outer-leaf [[4, 6] .. [4, 6]]");
      _builder.newLine();
      it.expected = _builder;
    };
    this.testXpath(_function);
  }
  
  @Test
  public void testRelative_01() {
    final Procedure1<XpathCompletionTest.XpathTest> _function = (XpathCompletionTest.XpathTest it) -> {
      it.expression = "./";
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("middle -> middle [[4, 8] .. [4, 8]]");
      _builder.newLine();
      _builder.append("outer-leaf -> outer-leaf [[4, 8] .. [4, 8]]");
      _builder.newLine();
      it.expected = _builder;
    };
    this.testXpath(_function);
  }
  
  @Test
  public void testFilter() {
    final Procedure1<XpathCompletionTest.XpathTest> _function = (XpathCompletionTest.XpathTest it) -> {
      it.expression = "./middle[middle-leaf != current()/|]";
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("middle -> middle [[4, 40] .. [4, 40]]");
      _builder.newLine();
      _builder.append("outer-leaf -> outer-leaf [[4, 40] .. [4, 40]]");
      _builder.newLine();
      it.expected = _builder;
    };
    this.testXpath(_function);
  }
  
  @Test
  public void testFilter_01() {
    final Procedure1<XpathCompletionTest.XpathTest> _function = (XpathCompletionTest.XpathTest it) -> {
      it.expression = "./middle[|]";
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("inner -> inner [[4, 15] .. [4, 15]]");
      _builder.newLine();
      _builder.append("middle-leaf -> middle-leaf [[4, 15] .. [4, 15]]");
      _builder.newLine();
      it.expected = _builder;
    };
    this.testXpath(_function);
  }
  
  @Test
  public void testAxis_01() {
    final Procedure1<XpathCompletionTest.XpathTest> _function = (XpathCompletionTest.XpathTest it) -> {
      it.expression = "following-sibling::";
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("outer -> outer [[4, 25] .. [4, 25]]");
      _builder.newLine();
      it.expected = _builder;
    };
    this.testXpath(_function);
  }
  
  @Test
  public void testAxis_02() {
    final Procedure1<XpathCompletionTest.XpathTest> _function = (XpathCompletionTest.XpathTest it) -> {
      it.expression = "//inner-leaf/ancestor::";
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("inner -> inner [[4, 29] .. [4, 29]]");
      _builder.newLine();
      _builder.append("middle -> middle [[4, 29] .. [4, 29]]");
      _builder.newLine();
      _builder.append("outer -> outer [[4, 29] .. [4, 29]]");
      _builder.newLine();
      it.expected = _builder;
    };
    this.testXpath(_function);
  }
  
  @Test
  public void testAxis_03() {
    final Procedure1<XpathCompletionTest.XpathTest> _function = (XpathCompletionTest.XpathTest it) -> {
      it.expression = "//inner-leaf/ancestor-or-self::";
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("inner -> inner [[4, 37] .. [4, 37]]");
      _builder.newLine();
      _builder.append("inner-leaf -> inner-leaf [[4, 37] .. [4, 37]]");
      _builder.newLine();
      _builder.append("middle -> middle [[4, 37] .. [4, 37]]");
      _builder.newLine();
      _builder.append("outer -> outer [[4, 37] .. [4, 37]]");
      _builder.newLine();
      it.expected = _builder;
    };
    this.testXpath(_function);
  }
  
  @Test
  public void testAxis_04() {
    final Procedure1<XpathCompletionTest.XpathTest> _function = (XpathCompletionTest.XpathTest it) -> {
      it.expression = "descendant-or-self::";
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("inner -> inner [[4, 26] .. [4, 26]]");
      _builder.newLine();
      _builder.append("inner-leaf -> inner-leaf [[4, 26] .. [4, 26]]");
      _builder.newLine();
      _builder.append("middle -> middle [[4, 26] .. [4, 26]]");
      _builder.newLine();
      _builder.append("middle-leaf -> middle-leaf [[4, 26] .. [4, 26]]");
      _builder.newLine();
      _builder.append("outer -> outer [[4, 26] .. [4, 26]]");
      _builder.newLine();
      _builder.append("outer-leaf -> outer-leaf [[4, 26] .. [4, 26]]");
      _builder.newLine();
      it.expected = _builder;
    };
    this.testXpath(_function);
  }
  
  @Test
  public void testAxis_05() {
    final Procedure1<XpathCompletionTest.XpathTest> _function = (XpathCompletionTest.XpathTest it) -> {
      it.expression = "descendant::";
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("inner -> inner [[4, 18] .. [4, 18]]");
      _builder.newLine();
      _builder.append("inner-leaf -> inner-leaf [[4, 18] .. [4, 18]]");
      _builder.newLine();
      _builder.append("middle -> middle [[4, 18] .. [4, 18]]");
      _builder.newLine();
      _builder.append("middle-leaf -> middle-leaf [[4, 18] .. [4, 18]]");
      _builder.newLine();
      _builder.append("outer-leaf -> outer-leaf [[4, 18] .. [4, 18]]");
      _builder.newLine();
      it.expected = _builder;
    };
    this.testXpath(_function);
  }
  
  @Test
  public void testAxis_06() {
    final Procedure1<XpathCompletionTest.XpathTest> _function = (XpathCompletionTest.XpathTest it) -> {
      it.expression = "//";
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("inner -> inner [[4, 8] .. [4, 8]]");
      _builder.newLine();
      _builder.append("inner-leaf -> inner-leaf [[4, 8] .. [4, 8]]");
      _builder.newLine();
      _builder.append("middle -> middle [[4, 8] .. [4, 8]]");
      _builder.newLine();
      _builder.append("middle-leaf -> middle-leaf [[4, 8] .. [4, 8]]");
      _builder.newLine();
      _builder.append("outer -> outer [[4, 8] .. [4, 8]]");
      _builder.newLine();
      _builder.append("outer-leaf -> outer-leaf [[4, 8] .. [4, 8]]");
      _builder.newLine();
      it.expected = _builder;
    };
    this.testXpath(_function);
  }
  
  @Test
  public void testAxis_07() {
    final Procedure1<XpathCompletionTest.XpathTest> _function = (XpathCompletionTest.XpathTest it) -> {
      it.expression = "descendant::|inner";
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("inner -> inner [[4, 18] .. [4, 18]]");
      _builder.newLine();
      _builder.append("inner-leaf -> inner-leaf [[4, 18] .. [4, 18]]");
      _builder.newLine();
      _builder.append("middle -> middle [[4, 18] .. [4, 18]]");
      _builder.newLine();
      _builder.append("middle-leaf -> middle-leaf [[4, 18] .. [4, 18]]");
      _builder.newLine();
      _builder.append("outer-leaf -> outer-leaf [[4, 18] .. [4, 18]]");
      _builder.newLine();
      it.expected = _builder;
    };
    this.testXpath(_function);
  }
  
  @Test
  public void testAxis_08() {
    final Procedure1<XpathCompletionTest.XpathTest> _function = (XpathCompletionTest.XpathTest it) -> {
      it.expression = "/|foo";
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("outer -> outer [[4, 7] .. [4, 7]]");
      _builder.newLine();
      it.expected = _builder;
    };
    this.testXpath(_function);
  }
  
  @Test
  public void testFunctionProposalsNeedPrefix() {
    final Procedure1<XpathCompletionTest.XpathTest> _function = (XpathCompletionTest.XpathTest it) -> {
      it.expression = "./middle[c|]";
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("ceiling(number) -> ceiling(${number}) [[4, 15] .. [4, 16]]");
      _builder.newLine();
      _builder.append("concat(string, string, string) -> concat(${string}, ${string}, ${string}) [[4, 15] .. [4, 16]]");
      _builder.newLine();
      _builder.append("contains(string, string) -> contains(${string}, ${string}) [[4, 15] .. [4, 16]]");
      _builder.newLine();
      _builder.append("count(node_set) -> count(${node_set}) [[4, 15] .. [4, 16]]");
      _builder.newLine();
      _builder.append("current() -> current() [[4, 15] .. [4, 16]]");
      _builder.newLine();
      it.expected = _builder;
    };
    this.testXpath(_function);
  }
}

package io.typefox.yang.tests;

import com.google.inject.Inject;
import com.google.inject.Provider;
import io.typefox.yang.parser.antlr.internal.InternalYangParser;
import io.typefox.yang.parser.antlr.lexer.jflex.JFlexBasedInternalYangLexer;
import io.typefox.yang.tests.YangInjectorProvider;
import org.antlr.runtime.ANTLRStringStream;
import org.antlr.runtime.Token;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.parser.antlr.Lexer;
import org.eclipse.xtext.testing.InjectWith;
import org.eclipse.xtext.testing.XtextRunner;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

@InjectWith(YangInjectorProvider.class)
@RunWith(XtextRunner.class)
@SuppressWarnings("all")
public class LexerTest {
  @Inject
  private Provider<JFlexBasedInternalYangLexer> lexer;
  
  @Test
  public void testExpression() {
    final JFlexBasedInternalYangLexer l = this.lexer.get();
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("when ./myFunction(23.4,.5+(.45div(23)));");
    _builder.newLine();
    ANTLRStringStream _aNTLRStringStream = new ANTLRStringStream(_builder.toString());
    l.setCharStream(_aNTLRStringStream);
    this.assertNextToken(l, InternalYangParser.When, "when");
    this.assertNextToken(l, InternalYangParser.RULE_WS, " ");
    this.assertNextToken(l, InternalYangParser.FullStop, ".");
    this.assertNextToken(l, InternalYangParser.Solidus, "/");
    this.assertNextToken(l, InternalYangParser.RULE_ID, "myFunction");
    this.assertNextToken(l, InternalYangParser.LeftParenthesis, "(");
    this.assertNextToken(l, InternalYangParser.RULE_NUMBER, "23.4");
    this.assertNextToken(l, InternalYangParser.Comma, ",");
    this.assertNextToken(l, InternalYangParser.RULE_NUMBER, ".5");
    this.assertNextToken(l, InternalYangParser.PlusSign, "+");
    this.assertNextToken(l, InternalYangParser.LeftParenthesis, "(");
    this.assertNextToken(l, InternalYangParser.RULE_NUMBER, ".45");
    this.assertNextToken(l, InternalYangParser.Div, "div");
    this.assertNextToken(l, InternalYangParser.LeftParenthesis, "(");
    this.assertNextToken(l, InternalYangParser.RULE_NUMBER, "23");
    this.assertNextToken(l, InternalYangParser.RightParenthesis, ")");
    this.assertNextToken(l, InternalYangParser.RightParenthesis, ")");
    this.assertNextToken(l, InternalYangParser.RightParenthesis, ")");
    this.assertNextToken(l, InternalYangParser.Semicolon, ";");
  }
  
  @Test
  public void testKeyExpression() {
    final JFlexBasedInternalYangLexer l = this.lexer.get();
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("key \"k1 k2\";");
    _builder.newLine();
    ANTLRStringStream _aNTLRStringStream = new ANTLRStringStream(_builder.toString());
    l.setCharStream(_aNTLRStringStream);
    this.assertNextToken(l, InternalYangParser.Key, "key");
    this.assertNextToken(l, InternalYangParser.RULE_WS, " ");
    this.assertNextToken(l, InternalYangParser.RULE_HIDDEN, "\"");
    this.assertNextToken(l, InternalYangParser.RULE_ID, "k1");
    this.assertNextToken(l, InternalYangParser.RULE_WS, " ");
    this.assertNextToken(l, InternalYangParser.RULE_ID, "k2");
    this.assertNextToken(l, InternalYangParser.RULE_HIDDEN, "\"");
    this.assertNextToken(l, InternalYangParser.Semicolon, ";");
  }
  
  @Test
  public void testNonExpression() {
    final JFlexBasedInternalYangLexer l = this.lexer.get();
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("description ./myFunction(23.4,.5+(.45div(23)));");
    _builder.newLine();
    ANTLRStringStream _aNTLRStringStream = new ANTLRStringStream(_builder.toString());
    l.setCharStream(_aNTLRStringStream);
    this.assertNextToken(l, InternalYangParser.Description, "description");
    this.assertNextToken(l, InternalYangParser.RULE_WS, " ");
    this.assertNextToken(l, InternalYangParser.RULE_STRING, "./myFunction(23.4,.5+(.45div(23)))");
    this.assertNextToken(l, InternalYangParser.Semicolon, ";");
  }
  
  @Test
  public void testBlackBoxDQString() {
    final JFlexBasedInternalYangLexer l = this.lexer.get();
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("revision 2015-05-26 {");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("description");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("\"Formal Project Review Draft 1.\";");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("reference \"EVC Ethernet Services Definitions YANG Modules \" +");
    _builder.newLine();
    _builder.append("  \t\t");
    _builder.append("\"(MEF XX), TBD\";");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    ANTLRStringStream _aNTLRStringStream = new ANTLRStringStream(_builder.toString());
    l.setCharStream(_aNTLRStringStream);
  }
  
  @Test
  public void testExpressionSQString() {
    final JFlexBasedInternalYangLexer l = this.lexer.get();
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("when \'./foo[x = \"holla\"] \'");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("+ /* test */ ");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("\'and myFunction(23.4, .5 + (.45 div 23))\';");
    _builder.newLine();
    ANTLRStringStream _aNTLRStringStream = new ANTLRStringStream(_builder.toString());
    l.setCharStream(_aNTLRStringStream);
    this.assertNextToken(l, InternalYangParser.When, "when");
    this.assertNextToken(l, InternalYangParser.RULE_WS, " ");
    this.assertNextToken(l, InternalYangParser.RULE_HIDDEN, "\'");
    this.assertNextToken(l, InternalYangParser.FullStop, ".");
    this.assertNextToken(l, InternalYangParser.Solidus, "/");
    this.assertNextToken(l, InternalYangParser.RULE_ID, "foo");
    this.assertNextToken(l, InternalYangParser.LeftSquareBracket, "[");
    this.assertNextToken(l, InternalYangParser.RULE_ID, "x");
    this.assertNextToken(l, InternalYangParser.RULE_WS, " ");
    this.assertNextToken(l, InternalYangParser.EqualsSign, "=");
    this.assertNextToken(l, InternalYangParser.RULE_WS, " ");
    this.assertNextToken(l, InternalYangParser.RULE_STRING, "\"holla\"");
    this.assertNextToken(l, InternalYangParser.RightSquareBracket, "]");
    this.assertNextToken(l, InternalYangParser.RULE_WS, " ");
    String _lineSeparator = System.lineSeparator();
    String _plus = ("\'" + _lineSeparator);
    String _plus_1 = (_plus + "\t+ /* test */ ");
    String _lineSeparator_1 = System.lineSeparator();
    String _plus_2 = (_plus_1 + _lineSeparator_1);
    String _plus_3 = (_plus_2 + "\t");
    this.assertNextToken(l, InternalYangParser.RULE_HIDDEN, _plus_3);
    this.assertNextToken(l, InternalYangParser.RULE_HIDDEN, "\'");
    this.assertNextToken(l, InternalYangParser.And, "and");
    this.assertNextToken(l, InternalYangParser.RULE_WS, " ");
    this.assertNextToken(l, InternalYangParser.RULE_ID, "myFunction");
    this.assertNextToken(l, InternalYangParser.LeftParenthesis, "(");
    this.assertNextToken(l, InternalYangParser.RULE_NUMBER, "23.4");
    this.assertNextToken(l, InternalYangParser.Comma, ",");
    this.assertNextToken(l, InternalYangParser.RULE_WS, " ");
    this.assertNextToken(l, InternalYangParser.RULE_NUMBER, ".5");
    this.assertNextToken(l, InternalYangParser.RULE_WS, " ");
    this.assertNextToken(l, InternalYangParser.PlusSign, "+");
    this.assertNextToken(l, InternalYangParser.RULE_WS, " ");
    this.assertNextToken(l, InternalYangParser.LeftParenthesis, "(");
    this.assertNextToken(l, InternalYangParser.RULE_NUMBER, ".45");
    this.assertNextToken(l, InternalYangParser.RULE_WS, " ");
    this.assertNextToken(l, InternalYangParser.Div, "div");
    this.assertNextToken(l, InternalYangParser.RULE_WS, " ");
    this.assertNextToken(l, InternalYangParser.RULE_NUMBER, "23");
    this.assertNextToken(l, InternalYangParser.RightParenthesis, ")");
    this.assertNextToken(l, InternalYangParser.RightParenthesis, ")");
    this.assertNextToken(l, InternalYangParser.RULE_HIDDEN, "\'");
    this.assertNextToken(l, InternalYangParser.Semicolon, ";");
  }
  
  @Test
  public void testExpressionString() {
    final JFlexBasedInternalYangLexer l = this.lexer.get();
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("when \"./foo[x = \\\"holla\\\"] \"");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("+ /* test */ ");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("\"and myFunction(23.4, .5 + (.45 div 23))\";");
    _builder.newLine();
    ANTLRStringStream _aNTLRStringStream = new ANTLRStringStream(_builder.toString());
    l.setCharStream(_aNTLRStringStream);
    this.assertNextToken(l, InternalYangParser.When, "when");
    this.assertNextToken(l, InternalYangParser.RULE_WS, " ");
    this.assertNextToken(l, InternalYangParser.RULE_HIDDEN, "\"");
    this.assertNextToken(l, InternalYangParser.FullStop, ".");
    this.assertNextToken(l, InternalYangParser.Solidus, "/");
    this.assertNextToken(l, InternalYangParser.RULE_ID, "foo");
    this.assertNextToken(l, InternalYangParser.LeftSquareBracket, "[");
    this.assertNextToken(l, InternalYangParser.RULE_ID, "x");
    this.assertNextToken(l, InternalYangParser.RULE_WS, " ");
    this.assertNextToken(l, InternalYangParser.EqualsSign, "=");
    this.assertNextToken(l, InternalYangParser.RULE_WS, " ");
    this.assertNextToken(l, InternalYangParser.RULE_STRING, "\\\"holla\\\"");
    this.assertNextToken(l, InternalYangParser.RightSquareBracket, "]");
    this.assertNextToken(l, InternalYangParser.RULE_WS, " ");
    String _lineSeparator = System.lineSeparator();
    String _plus = ("\"" + _lineSeparator);
    String _plus_1 = (_plus + "\t+ /* test */ ");
    String _lineSeparator_1 = System.lineSeparator();
    String _plus_2 = (_plus_1 + _lineSeparator_1);
    String _plus_3 = (_plus_2 + "\t");
    this.assertNextToken(l, InternalYangParser.RULE_HIDDEN, _plus_3);
    this.assertNextToken(l, InternalYangParser.RULE_HIDDEN, "\"");
    this.assertNextToken(l, InternalYangParser.And, "and");
    this.assertNextToken(l, InternalYangParser.RULE_WS, " ");
    this.assertNextToken(l, InternalYangParser.RULE_ID, "myFunction");
    this.assertNextToken(l, InternalYangParser.LeftParenthesis, "(");
    this.assertNextToken(l, InternalYangParser.RULE_NUMBER, "23.4");
    this.assertNextToken(l, InternalYangParser.Comma, ",");
    this.assertNextToken(l, InternalYangParser.RULE_WS, " ");
    this.assertNextToken(l, InternalYangParser.RULE_NUMBER, ".5");
    this.assertNextToken(l, InternalYangParser.RULE_WS, " ");
    this.assertNextToken(l, InternalYangParser.PlusSign, "+");
    this.assertNextToken(l, InternalYangParser.RULE_WS, " ");
    this.assertNextToken(l, InternalYangParser.LeftParenthesis, "(");
    this.assertNextToken(l, InternalYangParser.RULE_NUMBER, ".45");
    this.assertNextToken(l, InternalYangParser.RULE_WS, " ");
    this.assertNextToken(l, InternalYangParser.Div, "div");
    this.assertNextToken(l, InternalYangParser.RULE_WS, " ");
    this.assertNextToken(l, InternalYangParser.RULE_NUMBER, "23");
    this.assertNextToken(l, InternalYangParser.RightParenthesis, ")");
    this.assertNextToken(l, InternalYangParser.RightParenthesis, ")");
    this.assertNextToken(l, InternalYangParser.RULE_HIDDEN, "\"");
    this.assertNextToken(l, InternalYangParser.Semicolon, ";");
  }
  
  @Test
  public void testCustomStatement() {
    final JFlexBasedInternalYangLexer l = this.lexer.get();
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("foo:bar \'holz\';");
    _builder.newLine();
    ANTLRStringStream _aNTLRStringStream = new ANTLRStringStream(_builder.toString());
    l.setCharStream(_aNTLRStringStream);
    this.assertNextToken(l, InternalYangParser.RULE_EXTENSION_NAME, "foo:bar");
    this.assertNextToken(l, InternalYangParser.RULE_WS, " ");
    this.assertNextToken(l, InternalYangParser.RULE_STRING, "\'holz\'");
    this.assertNextToken(l, InternalYangParser.Semicolon, ";");
  }
  
  @Test
  public void testLexer() {
    final JFlexBasedInternalYangLexer l = this.lexer.get();
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("module 212-$556C {");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("path \"module\"");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    ANTLRStringStream _aNTLRStringStream = new ANTLRStringStream(_builder.toString());
    l.setCharStream(_aNTLRStringStream);
    this.assertNextToken(l, InternalYangParser.Module, "module");
    this.assertNextToken(l, InternalYangParser.RULE_WS, " ");
    this.assertNextToken(l, InternalYangParser.RULE_STRING, "212-$556C");
    this.assertNextToken(l, InternalYangParser.RULE_WS, " ");
    this.assertNextToken(l, InternalYangParser.LeftCurlyBracket, "{");
    String _lineSeparator = System.lineSeparator();
    String _plus = (_lineSeparator + "  ");
    this.assertNextToken(l, InternalYangParser.RULE_WS, _plus);
    this.assertNextToken(l, InternalYangParser.Path, "path");
    this.assertNextToken(l, InternalYangParser.RULE_WS, " ");
    this.assertNextToken(l, InternalYangParser.RULE_HIDDEN, "\"");
    this.assertNextToken(l, InternalYangParser.RULE_ID, "module");
    this.assertNextToken(l, InternalYangParser.RULE_HIDDEN, "\"");
    this.assertNextToken(l, InternalYangParser.RULE_WS, System.lineSeparator());
    this.assertNextToken(l, InternalYangParser.RightCurlyBracket, "}");
  }
  
  @Test
  public void test_DoubleQuotedString() {
    final JFlexBasedInternalYangLexer l = this.lexer.get();
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("module \"foo\"");
    _builder.newLine();
    ANTLRStringStream _aNTLRStringStream = new ANTLRStringStream(_builder.toString());
    l.setCharStream(_aNTLRStringStream);
    this.assertNextToken(l, InternalYangParser.Module, "module");
    this.assertNextToken(l, InternalYangParser.RULE_WS, " ");
    this.assertNextToken(l, InternalYangParser.RULE_STRING, "\"foo\"");
  }
  
  @Test
  public void test_SingleQuotedString() {
    final JFlexBasedInternalYangLexer l = this.lexer.get();
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("module \'foo-bar42\'");
    _builder.newLine();
    ANTLRStringStream _aNTLRStringStream = new ANTLRStringStream(_builder.toString());
    l.setCharStream(_aNTLRStringStream);
    this.assertNextToken(l, InternalYangParser.Module, "module");
    this.assertNextToken(l, InternalYangParser.RULE_WS, " ");
    this.assertNextToken(l, InternalYangParser.RULE_STRING, "\'foo-bar42\'");
  }
  
  @Test
  public void test_MinMaxRangeExpression() {
    final JFlexBasedInternalYangLexer l = this.lexer.get();
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("range 1 | min..2|3..max|min..max  |  min .. max");
    _builder.newLine();
    ANTLRStringStream _aNTLRStringStream = new ANTLRStringStream(_builder.toString());
    l.setCharStream(_aNTLRStringStream);
    this.assertNextToken(l, InternalYangParser.Range, "range");
    this.assertNextToken(l, InternalYangParser.RULE_WS, " ");
    this.assertNextToken(l, InternalYangParser.RULE_NUMBER, "1");
    this.assertNextToken(l, InternalYangParser.RULE_WS, " ");
    this.assertNextToken(l, InternalYangParser.VerticalLine, "|");
    this.assertNextToken(l, InternalYangParser.RULE_WS, " ");
    this.assertNextToken(l, InternalYangParser.Min, "min");
    this.assertNextToken(l, InternalYangParser.FullStopFullStop, "..");
    this.assertNextToken(l, InternalYangParser.RULE_NUMBER, "2");
    this.assertNextToken(l, InternalYangParser.VerticalLine, "|");
    this.assertNextToken(l, InternalYangParser.RULE_NUMBER, "3");
    this.assertNextToken(l, InternalYangParser.FullStopFullStop, "..");
    this.assertNextToken(l, InternalYangParser.Max, "max");
    this.assertNextToken(l, InternalYangParser.VerticalLine, "|");
    this.assertNextToken(l, InternalYangParser.Min, "min");
    this.assertNextToken(l, InternalYangParser.FullStopFullStop, "..");
    this.assertNextToken(l, InternalYangParser.Max, "max");
    this.assertNextToken(l, InternalYangParser.RULE_WS, "  ");
    this.assertNextToken(l, InternalYangParser.VerticalLine, "|");
    this.assertNextToken(l, InternalYangParser.RULE_WS, "  ");
    this.assertNextToken(l, InternalYangParser.Min, "min");
    this.assertNextToken(l, InternalYangParser.RULE_WS, " ");
    this.assertNextToken(l, InternalYangParser.FullStopFullStop, "..");
    this.assertNextToken(l, InternalYangParser.RULE_WS, " ");
    this.assertNextToken(l, InternalYangParser.Max, "max");
  }
  
  @Test
  public void test_SignedRangeExpression() {
    final JFlexBasedInternalYangLexer l = this.lexer.get();
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("range -1 | -2..2|+3..4");
    _builder.newLine();
    ANTLRStringStream _aNTLRStringStream = new ANTLRStringStream(_builder.toString());
    l.setCharStream(_aNTLRStringStream);
    this.assertNextToken(l, InternalYangParser.Range, "range");
    this.assertNextToken(l, InternalYangParser.RULE_WS, " ");
    this.assertNextToken(l, InternalYangParser.RULE_NUMBER, "-1");
    this.assertNextToken(l, InternalYangParser.RULE_WS, " ");
    this.assertNextToken(l, InternalYangParser.VerticalLine, "|");
    this.assertNextToken(l, InternalYangParser.RULE_WS, " ");
    this.assertNextToken(l, InternalYangParser.RULE_NUMBER, "-2");
    this.assertNextToken(l, InternalYangParser.FullStopFullStop, "..");
    this.assertNextToken(l, InternalYangParser.RULE_NUMBER, "2");
    this.assertNextToken(l, InternalYangParser.VerticalLine, "|");
    this.assertNextToken(l, InternalYangParser.RULE_NUMBER, "+3");
    this.assertNextToken(l, InternalYangParser.FullStopFullStop, "..");
    this.assertNextToken(l, InternalYangParser.RULE_NUMBER, "4");
  }
  
  @Test
  public void test_singleQuotedString() {
    final JFlexBasedInternalYangLexer l = this.lexer.get();
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("pattern \'((:|[0-9a-fA-F]{0,4}):)([0-9a-fA-F]{0,4}:){0,5}\'");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("+ \'((([0-9a-fA-F]{0,4}:)?(:|[0-9a-fA-F]{0,4}))|\'");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("+ \'(((25[0-5]|2[0-4][0-9]|[01]?[0-9]?[0-9])\\.){3}\'");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("+ \'(25[0-5]|2[0-4][0-9]|[01]?[0-9]?[0-9])))\'");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("+ \'(%[\\p{N}\\p{L}]+)?\';");
    _builder.newLine();
    ANTLRStringStream _aNTLRStringStream = new ANTLRStringStream(_builder.toString());
    l.setCharStream(_aNTLRStringStream);
    this.assertNextToken(l, InternalYangParser.Pattern, "pattern");
    this.assertNextToken(l, InternalYangParser.RULE_WS, " ");
    this.assertNextToken(l, InternalYangParser.RULE_STRING, "\'((:|[0-9a-fA-F]{0,4}):)([0-9a-fA-F]{0,4}:){0,5}\'");
    String _lineSeparator = System.lineSeparator();
    String _plus = (_lineSeparator + "  ");
    this.assertNextToken(l, InternalYangParser.RULE_WS, _plus);
    this.assertNextToken(l, InternalYangParser.RULE_HIDDEN, "+");
    this.assertNextToken(l, InternalYangParser.RULE_WS, " ");
    this.assertNextToken(l, InternalYangParser.RULE_STRING, "\'((([0-9a-fA-F]{0,4}:)?(:|[0-9a-fA-F]{0,4}))|\'");
    String _lineSeparator_1 = System.lineSeparator();
    String _plus_1 = (_lineSeparator_1 + "  ");
    this.assertNextToken(l, InternalYangParser.RULE_WS, _plus_1);
    this.assertNextToken(l, InternalYangParser.RULE_HIDDEN, "+");
    this.assertNextToken(l, InternalYangParser.RULE_WS, " ");
    this.assertNextToken(l, InternalYangParser.RULE_STRING, "\'(((25[0-5]|2[0-4][0-9]|[01]?[0-9]?[0-9])\\.){3}\'");
    String _lineSeparator_2 = System.lineSeparator();
    String _plus_2 = (_lineSeparator_2 + "  ");
    this.assertNextToken(l, InternalYangParser.RULE_WS, _plus_2);
    this.assertNextToken(l, InternalYangParser.RULE_HIDDEN, "+");
    this.assertNextToken(l, InternalYangParser.RULE_WS, " ");
    this.assertNextToken(l, InternalYangParser.RULE_STRING, "\'(25[0-5]|2[0-4][0-9]|[01]?[0-9]?[0-9])))\'");
    String _lineSeparator_3 = System.lineSeparator();
    String _plus_3 = (_lineSeparator_3 + "  ");
    this.assertNextToken(l, InternalYangParser.RULE_WS, _plus_3);
    this.assertNextToken(l, InternalYangParser.RULE_HIDDEN, "+");
    this.assertNextToken(l, InternalYangParser.RULE_WS, " ");
    this.assertNextToken(l, InternalYangParser.RULE_STRING, "\'(%[\\p{N}\\p{L}]+)?\'");
  }
  
  @Test
  public void test_Comments() {
    final JFlexBasedInternalYangLexer l = this.lexer.get();
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("/*");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("augment \"/policy:policies/policy:policy-entry\"");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("+ \"/policy:classifier-entry\"");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("+ \"/policy:classifier-action-entry-cfg/\"");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("+ \"policy:action-cfg-params/action:marking/action:marking-cfg\" {");
    _builder.newLine();
    _builder.append("            ");
    _builder.append("description \"extend the marking dscp to add set from a tablemap\";");
    _builder.newLine();
    _builder.append("            ");
    _builder.append("uses SET-VAL-TABLEMAP;");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("*/");
    _builder.newLine();
    ANTLRStringStream _aNTLRStringStream = new ANTLRStringStream(_builder.toString());
    l.setCharStream(_aNTLRStringStream);
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("/*");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("augment \"/policy:policies/policy:policy-entry\"");
    _builder_1.newLine();
    _builder_1.append("        ");
    _builder_1.append("+ \"/policy:classifier-entry\"");
    _builder_1.newLine();
    _builder_1.append("        ");
    _builder_1.append("+ \"/policy:classifier-action-entry-cfg/\"");
    _builder_1.newLine();
    _builder_1.append("        ");
    _builder_1.append("+ \"policy:action-cfg-params/action:marking/action:marking-cfg\" {");
    _builder_1.newLine();
    _builder_1.append("            ");
    _builder_1.append("description \"extend the marking dscp to add set from a tablemap\";");
    _builder_1.newLine();
    _builder_1.append("            ");
    _builder_1.append("uses SET-VAL-TABLEMAP;");
    _builder_1.newLine();
    _builder_1.append("        ");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("*/");
    this.assertNextToken(l, InternalYangParser.RULE_ML_COMMENT, _builder_1.toString());
    this.assertNextToken(l, InternalYangParser.RULE_WS, System.lineSeparator());
    this.assertNextToken(l, InternalYangParser.EOF, null);
  }
  
  @Test
  public void testString() {
    final JFlexBasedInternalYangLexer l = this.lexer.get();
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("description \"User variable type; only \'global\' variables can \\\\");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("be saved in the yangcli uservars file.\";");
    _builder.newLine();
    ANTLRStringStream _aNTLRStringStream = new ANTLRStringStream(_builder.toString());
    l.setCharStream(_aNTLRStringStream);
    this.assertNextToken(l, InternalYangParser.Description, "description");
    this.assertNextToken(l, InternalYangParser.RULE_WS, " ");
    this.assertNextToken(l, InternalYangParser.RULE_STRING, null);
    this.assertNextToken(l, InternalYangParser.Semicolon, ";");
    this.assertNextToken(l, InternalYangParser.RULE_WS, null);
    this.assertNextToken(l, InternalYangParser.EOF, null);
  }
  
  private void assertNextToken(final Lexer it, final int id, final String text) {
    final Token t = it.nextToken();
    Assert.assertEquals(id, t.getType());
    if ((text != null)) {
      Assert.assertEquals(text, t.getText());
    }
  }
}

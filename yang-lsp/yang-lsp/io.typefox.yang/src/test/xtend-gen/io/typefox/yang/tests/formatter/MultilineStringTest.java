package io.typefox.yang.tests.formatter;

import io.typefox.yang.formatting2.YangFormatter;
import io.typefox.yang.tests.AbstractYangTest;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.preferences.MapBasedPreferenceValues;
import org.eclipse.xtext.testing.formatter.FormatterTestRequest;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.junit.Test;

@SuppressWarnings("all")
public class MultilineStringTest extends AbstractYangTest {
  public static String wrapUnformatted(final CharSequence s) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("module m1 {");
    _builder.newLine();
    _builder.append("     ");
    _builder.append("module m2 {");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("module m2 {");
    _builder.newLine();
    _builder.append("            ");
    _builder.append(s, "            ");
    _builder.newLineIfNotEmpty();
    _builder.append("          ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    return _builder.toString();
  }
  
  public static String wrapFormatted(final CharSequence s) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("module m1 {");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("module m2 {");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("module m2 {");
    _builder.newLine();
    _builder.append("            ");
    _builder.append(s, "            ");
    _builder.newLineIfNotEmpty();
    _builder.append("        ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    return _builder.toString();
  }
  
  @Test
  public void test_SL_concatenation() {
    final Procedure1<FormatterTestRequest> _function = (FormatterTestRequest it) -> {
      final Procedure1<MapBasedPreferenceValues> _function_1 = (MapBasedPreferenceValues it_1) -> {
        it_1.<Boolean>put(YangFormatter.FORCE_NEW_LINE, Boolean.valueOf(false));
      };
      it.preferences(_function_1);
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("description \"foo\" /* a */ /* b */ + \"bar\";");
      _builder.newLine();
      it.setExpectation(MultilineStringTest.wrapFormatted(_builder));
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("description \"foo\"/* a *//* b */    +      \"bar\";");
      _builder_1.newLine();
      it.setToBeFormatted(MultilineStringTest.wrapUnformatted(_builder_1));
    };
    this.assertFormattedWithoutSerialization(_function);
  }
  
  @Test
  public void test_indentation_1a() {
    final Procedure1<FormatterTestRequest> _function = (FormatterTestRequest it) -> {
      final Procedure1<MapBasedPreferenceValues> _function_1 = (MapBasedPreferenceValues it_1) -> {
        it_1.<Boolean>put(YangFormatter.FORCE_NEW_LINE, Boolean.valueOf(true));
      };
      it.preferences(_function_1);
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("description");
      _builder.newLine();
      _builder.append("  ");
      _builder.append("\"foo\"");
      _builder.newLine();
      _builder.append("+ \"bar\";");
      _builder.newLine();
      it.setExpectation(MultilineStringTest.wrapFormatted(_builder));
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("description \"foo\"");
      _builder_1.newLine();
      _builder_1.append("     ");
      _builder_1.append("+ \"bar\";");
      _builder_1.newLine();
      it.setToBeFormatted(MultilineStringTest.wrapUnformatted(_builder_1));
    };
    this.assertFormattedWithoutSerialization(_function);
  }
  
  @Test
  public void test_indentation_1b() {
    final Procedure1<FormatterTestRequest> _function = (FormatterTestRequest it) -> {
      final Procedure1<MapBasedPreferenceValues> _function_1 = (MapBasedPreferenceValues it_1) -> {
        it_1.<Boolean>put(YangFormatter.FORCE_NEW_LINE, Boolean.valueOf(false));
      };
      it.preferences(_function_1);
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("description \"foo\"");
      _builder.newLine();
      _builder.append("          ");
      _builder.append("+ \"bar\";");
      _builder.newLine();
      it.setExpectation(MultilineStringTest.wrapFormatted(_builder));
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("     ");
      _builder_1.append("description \"foo\"");
      _builder_1.newLine();
      _builder_1.append("+ \"bar\";");
      _builder_1.newLine();
      it.setToBeFormatted(MultilineStringTest.wrapUnformatted(_builder_1));
    };
    this.assertFormattedWithoutSerialization(_function);
  }
  
  @Test
  public void test_indentation_2() {
    final Procedure1<FormatterTestRequest> _function = (FormatterTestRequest it) -> {
      final Procedure1<MapBasedPreferenceValues> _function_1 = (MapBasedPreferenceValues it_1) -> {
        it_1.<Boolean>put(YangFormatter.FORCE_NEW_LINE, Boolean.valueOf(false));
      };
      it.preferences(_function_1);
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("description \"foo\"");
      _builder.newLine();
      _builder.append("          ");
      _builder.append("+ \"bar\";");
      _builder.newLine();
      it.setToBeFormatted(MultilineStringTest.wrapFormatted(_builder));
    };
    this.assertFormattedWithoutSerialization(_function);
  }
  
  @Test
  public void test_indentation_3() {
    final Procedure1<FormatterTestRequest> _function = (FormatterTestRequest it) -> {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("pattern");
      _builder.newLine();
      _builder.append("  ");
      _builder.append("\'$0$.*\'");
      _builder.newLine();
      _builder.append("  ");
      _builder.append("// comment");
      _builder.newLine();
      _builder.append("+ \'|$1$[a-zA-Z0-9./]{1,8}$[a-zA-Z0-9./]{22}\'");
      _builder.newLine();
      _builder.append("+ \'|$5$(rounds=\\d+$)?[a-zA-Z0-9./]{1,16}$[a-zA-Z0-9./]{43}\'");
      _builder.newLine();
      _builder.append("+ /* comment */ \'|$6$(rounds=\\d+$)?[a-zA-Z0-9./]{1,16}$[a-zA-Z0-9./]{86}\';");
      _builder.newLine();
      it.setExpectation(MultilineStringTest.wrapFormatted(_builder));
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("pattern \'$0$.*\'");
      _builder_1.newLine();
      _builder_1.append(" ");
      _builder_1.append("// comment");
      _builder_1.newLine();
      _builder_1.append("      ");
      _builder_1.append("+ \'|$1$[a-zA-Z0-9./]{1,8}$[a-zA-Z0-9./]{22}\'");
      _builder_1.newLine();
      _builder_1.append("   ");
      _builder_1.append("+ \'|$5$(rounds=\\d+$)?[a-zA-Z0-9./]{1,16}$[a-zA-Z0-9./]{43}\'");
      _builder_1.newLine();
      _builder_1.append(" ");
      _builder_1.append("+ /* comment */ \'|$6$(rounds=\\d+$)?[a-zA-Z0-9./]{1,16}$[a-zA-Z0-9./]{86}\';");
      _builder_1.newLine();
      it.setToBeFormatted(MultilineStringTest.wrapUnformatted(_builder_1));
    };
    this.assertFormattedWithoutSerialization(_function);
  }
  
  @Test
  public void test_indentation_4() {
    final Procedure1<FormatterTestRequest> _function = (FormatterTestRequest it) -> {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("pattern");
      _builder.newLine();
      _builder.append("  ");
      _builder.append("\'$0$.*\'");
      _builder.newLine();
      _builder.append("+ \'$0$.*\'");
      _builder.newLine();
      _builder.append("  ");
      _builder.append("// comment");
      _builder.newLine();
      _builder.append("+ \'|$1$[a-zA-Z0-9./]{1,8}$[a-zA-Z0-9./]{22}\'");
      _builder.newLine();
      _builder.append("+ \'|$5$(rounds=\\d+$)?[a-zA-Z0-9./]{1,16}$[a-zA-Z0-9./]{43}\'");
      _builder.newLine();
      _builder.append("+ /* comment */ \'|$6$(rounds=\\d+$)?[a-zA-Z0-9./]{1,16}$[a-zA-Z0-9./]{86}\';");
      _builder.newLine();
      it.setToBeFormatted(MultilineStringTest.wrapFormatted(_builder));
    };
    this.assertFormattedWithoutSerialization(_function);
  }
  
  @Test
  public void test_indentation_5() {
    final Procedure1<FormatterTestRequest> _function = (FormatterTestRequest it) -> {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("pattern");
      _builder.newLine();
      _builder.append("  ");
      _builder.append("\'$0$.*\'");
      _builder.newLine();
      _builder.append("  ");
      _builder.append("/* comment");
      _builder.newLine();
      _builder.append("   ");
      _builder.append("* foo");
      _builder.newLine();
      _builder.append("   ");
      _builder.append("*/");
      _builder.newLine();
      _builder.append("+ \'|$1$[a-zA-Z0-9./]{1,8}$[a-zA-Z0-9./]{22}\'");
      _builder.newLine();
      _builder.append("+ \'|$5$(rounds=\\d+$)?[a-zA-Z0-9./]{1,16}$[a-zA-Z0-9./]{43}\'");
      _builder.newLine();
      _builder.append("+ /* comment */ \'|$6$(rounds=\\d+$)?[a-zA-Z0-9./]{1,16}$[a-zA-Z0-9./]{86}\';");
      _builder.newLine();
      it.setExpectation(MultilineStringTest.wrapFormatted(_builder));
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("pattern \'$0$.*\'");
      _builder_1.newLine();
      _builder_1.append("                 ");
      _builder_1.append("/* comment");
      _builder_1.newLine();
      _builder_1.append("              ");
      _builder_1.append("* foo");
      _builder_1.newLine();
      _builder_1.append("  ");
      _builder_1.append("*/");
      _builder_1.newLine();
      _builder_1.append("      ");
      _builder_1.append("+ \'|$1$[a-zA-Z0-9./]{1,8}$[a-zA-Z0-9./]{22}\'");
      _builder_1.newLine();
      _builder_1.append("   ");
      _builder_1.append("+ \'|$5$(rounds=\\d+$)?[a-zA-Z0-9./]{1,16}$[a-zA-Z0-9./]{43}\'");
      _builder_1.newLine();
      _builder_1.append(" ");
      _builder_1.append("+ /* comment */ \'|$6$(rounds=\\d+$)?[a-zA-Z0-9./]{1,16}$[a-zA-Z0-9./]{86}\';");
      _builder_1.newLine();
      it.setToBeFormatted(MultilineStringTest.wrapUnformatted(_builder_1));
    };
    this.assertFormattedWithoutSerialization(_function);
  }
  
  @Test
  public void test_ML_indentation_1() {
    final Procedure1<FormatterTestRequest> _function = (FormatterTestRequest it) -> {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("description");
      _builder.newLine();
      _builder.append("  ");
      _builder.append("\"This revision adds the following new data types:");
      _builder.newLine();
      _builder.append("   ");
      _builder.append("Foo");
      _builder.newLine();
      _builder.append("  ");
      _builder.append("\";");
      _builder.newLine();
      it.setExpectation(MultilineStringTest.wrapFormatted(_builder));
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("     ");
      _builder_1.append("description \"This revision adds the following new data types:");
      _builder_1.newLine();
      _builder_1.append("Foo");
      _builder_1.newLine();
      _builder_1.append("             ");
      _builder_1.append("\";");
      _builder_1.newLine();
      it.setToBeFormatted(MultilineStringTest.wrapUnformatted(_builder_1));
    };
    this.assertFormattedWithoutSerialization(_function);
  }
  
  @Test
  public void test_ML_indentation_2() {
    final Procedure1<FormatterTestRequest> _function = (FormatterTestRequest it) -> {
      final Procedure1<MapBasedPreferenceValues> _function_1 = (MapBasedPreferenceValues it_1) -> {
        it_1.<Boolean>put(YangFormatter.FORCE_NEW_LINE, Boolean.valueOf(false));
      };
      it.preferences(_function_1);
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("description \"This revision adds the following new data types: \"");
      _builder.newLine();
      _builder.append("          ");
      _builder.append("+ \"foo");
      _builder.newLine();
      _builder.append("             ");
      _builder.append("bar\";");
      _builder.newLine();
      it.setExpectation(MultilineStringTest.wrapFormatted(_builder));
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("     ");
      _builder_1.append("description \"This revision adds the following new data types: \"");
      _builder_1.newLine();
      _builder_1.append("+ \"foo");
      _builder_1.newLine();
      _builder_1.append("bar\";");
      _builder_1.newLine();
      it.setToBeFormatted(MultilineStringTest.wrapUnformatted(_builder_1));
    };
    this.assertFormattedWithoutSerialization(_function);
  }
  
  @Test
  public void test_ML_indentation_3() {
    final Procedure1<FormatterTestRequest> _function = (FormatterTestRequest it) -> {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("description");
      _builder.newLine();
      _builder.append("  ");
      _builder.append("\"This revision adds the following new data types:");
      _builder.newLine();
      _builder.append("   ");
      _builder.append("- yang-identifier");
      _builder.newLine();
      _builder.append("   ");
      _builder.append("- hex-string");
      _builder.newLine();
      _builder.append("   ");
      _builder.append("- uuid");
      _builder.newLine();
      _builder.append("   ");
      _builder.append("- dotted-quad");
      _builder.newLine();
      _builder.append("  ");
      _builder.append("\";");
      _builder.newLine();
      it.setExpectation(MultilineStringTest.wrapFormatted(_builder));
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("description \"This revision adds the following new data types:");
      _builder_1.newLine();
      _builder_1.append("      ");
      _builder_1.append("- yang-identifier");
      _builder_1.newLine();
      _builder_1.append("      ");
      _builder_1.append("- hex-string");
      _builder_1.newLine();
      _builder_1.append("      ");
      _builder_1.append("- uuid");
      _builder_1.newLine();
      _builder_1.append("      ");
      _builder_1.append("- dotted-quad");
      _builder_1.newLine();
      _builder_1.append("        ");
      _builder_1.append("\";");
      _builder_1.newLine();
      it.setToBeFormatted(MultilineStringTest.wrapUnformatted(_builder_1));
    };
    this.assertFormattedWithoutSerialization(_function);
  }
  
  @Test
  public void test_ML_indentation_4() {
    final Procedure1<FormatterTestRequest> _function = (FormatterTestRequest it) -> {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("contact");
      _builder.newLine();
      _builder.append("  ");
      _builder.append("\"WG Web:   <http://tools.ietf.org/wg/netmod/>");
      _builder.newLine();
      _builder.append("   ");
      _builder.append("WG List:  <mailto:netmod@ietf.org>");
      _builder.newLine();
      _builder.append("   ");
      _builder.newLine();
      _builder.append("   ");
      _builder.append("WG Chair: David Kessens");
      _builder.newLine();
      _builder.append("             ");
      _builder.append("<mailto:david.kessens@nsn.com>");
      _builder.newLine();
      _builder.append("   ");
      _builder.newLine();
      _builder.append("   ");
      _builder.append("WG Chair: Juergen Schoenwaelder");
      _builder.newLine();
      _builder.append("             ");
      _builder.append("<mailto:j.schoenwaelder@jacobs-university.de>");
      _builder.newLine();
      _builder.append("   ");
      _builder.newLine();
      _builder.append("   ");
      _builder.append("Editor:   Juergen Schoenwaelder");
      _builder.newLine();
      _builder.append("             ");
      _builder.append("<mailto:j.schoenwaelder@jacobs-university.de>");
      _builder.newLine();
      _builder.append("  ");
      _builder.append("\";");
      _builder.newLine();
      it.setToBeFormatted(MultilineStringTest.wrapFormatted(_builder));
    };
    this.assertFormattedWithoutSerialization(_function);
  }
  
  @Test
  public void test_ML_indentation_5() {
    final Procedure1<FormatterTestRequest> _function = (FormatterTestRequest it) -> {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("contact");
      _builder.newLine();
      _builder.append("  ");
      _builder.append("\"WG Web:   <http://tools.ietf.org/wg/netmod/>");
      _builder.newLine();
      _builder.append("   ");
      _builder.append("WG List:  <mailto:netmod@ietf.org>");
      _builder.newLine();
      _builder.append("   ");
      _builder.newLine();
      _builder.append("   ");
      _builder.append("WG Chair: David Kessens");
      _builder.newLine();
      _builder.append("             ");
      _builder.append("<mailto:david.kessens@nsn.com>");
      _builder.newLine();
      _builder.append("   ");
      _builder.newLine();
      _builder.append("   ");
      _builder.append("WG Chair: Juergen Schoenwaelder");
      _builder.newLine();
      _builder.append("             ");
      _builder.append("<mailto:j.schoenwaelder@jacobs-university.de>");
      _builder.newLine();
      _builder.append("   ");
      _builder.newLine();
      _builder.append("   ");
      _builder.append("Editor:   Juergen Schoenwaelder");
      _builder.newLine();
      _builder.append("             ");
      _builder.append("<mailto:j.schoenwaelder@jacobs-university.de>");
      _builder.newLine();
      _builder.append("  ");
      _builder.append("\";");
      _builder.newLine();
      it.setExpectation(MultilineStringTest.wrapFormatted(_builder));
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("contact");
      _builder_1.newLine();
      _builder_1.append("      ");
      _builder_1.append("\"WG Web:   <http://tools.ietf.org/wg/netmod/>");
      _builder_1.newLine();
      _builder_1.append("       ");
      _builder_1.append("WG List:  <mailto:netmod@ietf.org>");
      _builder_1.newLine();
      _builder_1.append("    ");
      _builder_1.newLine();
      _builder_1.append("       ");
      _builder_1.append("WG Chair: David Kessens");
      _builder_1.newLine();
      _builder_1.append("                 ");
      _builder_1.append("<mailto:david.kessens@nsn.com>");
      _builder_1.newLine();
      _builder_1.append("    ");
      _builder_1.newLine();
      _builder_1.append("       ");
      _builder_1.append("WG Chair: Juergen Schoenwaelder");
      _builder_1.newLine();
      _builder_1.append("                 ");
      _builder_1.append("<mailto:j.schoenwaelder@jacobs-university.de>");
      _builder_1.newLine();
      _builder_1.append("    ");
      _builder_1.newLine();
      _builder_1.append("       ");
      _builder_1.append("Editor:   Juergen Schoenwaelder");
      _builder_1.newLine();
      _builder_1.append("                 ");
      _builder_1.append("<mailto:j.schoenwaelder@jacobs-university.de>");
      _builder_1.newLine();
      _builder_1.append("      ");
      _builder_1.append("\";");
      _builder_1.newLine();
      it.setToBeFormatted(MultilineStringTest.wrapUnformatted(_builder_1));
    };
    this.assertFormattedWithoutSerialization(_function);
  }
  
  @Test
  public void test_ML_indentation_6() {
    final Procedure1<FormatterTestRequest> _function = (FormatterTestRequest it) -> {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("description");
      _builder.newLine();
      _builder.append("  ");
      _builder.append("\"Foo");
      _builder.newLine();
      _builder.append("  ");
      _builder.append("\";");
      _builder.newLine();
      it.setExpectation(MultilineStringTest.wrapFormatted(_builder));
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("description \"Foo");
      _builder_1.newLine();
      _builder_1.append("    ");
      _builder_1.append("\";");
      _builder_1.newLine();
      it.setToBeFormatted(MultilineStringTest.wrapUnformatted(_builder_1));
    };
    this.assertFormattedWithoutSerialization(_function);
  }
  
  @Test
  public void test_ML_indentation_7() {
    final Procedure1<FormatterTestRequest> _function = (FormatterTestRequest it) -> {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("description");
      _builder.newLine();
      _builder.append("  ");
      _builder.append("\'foo");
      _builder.newLine();
      _builder.append("    ");
      _builder.append("bar");
      _builder.newLine();
      _builder.append("  ");
      _builder.append("\';");
      _builder.newLine();
      it.setExpectation(MultilineStringTest.wrapFormatted(_builder));
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("description");
      _builder_1.newLine();
      _builder_1.append("  ");
      _builder_1.append("\'foo");
      _builder_1.newLine();
      _builder_1.append("    ");
      _builder_1.append("bar");
      _builder_1.newLine();
      _builder_1.append("    ");
      _builder_1.append("\';");
      _builder_1.newLine();
      it.setToBeFormatted(MultilineStringTest.wrapUnformatted(_builder_1));
    };
    this.assertFormattedWithoutSerialization(_function);
  }
  
  @Test
  public void test_ML_indentation_8() {
    final Procedure1<FormatterTestRequest> _function = (FormatterTestRequest it) -> {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("contact");
      _builder.newLine();
      _builder.append("  ");
      _builder.append("\"WG Chair: David Kessens");
      _builder.newLine();
      _builder.append("             ");
      _builder.append("<mailto:david.kessens@nsn.com>\";");
      _builder.newLine();
      it.setToBeFormatted(MultilineStringTest.wrapFormatted(_builder));
    };
    this.assertFormattedWithoutSerialization(_function);
  }
  
  @Test
  public void test_ML_indentation_9() {
    final Procedure1<FormatterTestRequest> _function = (FormatterTestRequest it) -> {
      final Procedure1<MapBasedPreferenceValues> _function_1 = (MapBasedPreferenceValues it_1) -> {
        it_1.put(YangFormatter.FORCE_NEW_LINE, "false");
      };
      it.preferences(_function_1);
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("contact \"WG Chair: David Kessens");
      _builder.newLine();
      _builder.append("                   ");
      _builder.append("<mailto:david.kessens@nsn.com>\";");
      _builder.newLine();
      it.setToBeFormatted(MultilineStringTest.wrapFormatted(_builder));
    };
    this.assertFormattedWithoutSerialization(_function);
  }
  
  @Test
  public void test_option_forceNewLine_off() {
    final Procedure1<FormatterTestRequest> _function = (FormatterTestRequest it) -> {
      final Procedure1<MapBasedPreferenceValues> _function_1 = (MapBasedPreferenceValues it_1) -> {
        it_1.put(YangFormatter.FORCE_NEW_LINE, "false");
      };
      it.preferences(_function_1);
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("contact \"xyz\";");
      _builder.newLine();
      it.setExpectation(MultilineStringTest.wrapFormatted(_builder));
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("contact \"xyz\";");
      _builder_1.newLine();
      it.setToBeFormatted(MultilineStringTest.wrapUnformatted(_builder_1));
    };
    this.assertFormattedWithoutSerialization(_function);
  }
  
  @Test
  public void test_option_forceNewLine_on() {
    final Procedure1<FormatterTestRequest> _function = (FormatterTestRequest it) -> {
      final Procedure1<MapBasedPreferenceValues> _function_1 = (MapBasedPreferenceValues it_1) -> {
        it_1.put(YangFormatter.FORCE_NEW_LINE, "true");
      };
      it.preferences(_function_1);
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("contact");
      _builder.newLine();
      _builder.append("  ");
      _builder.append("\"xyz\";");
      _builder.newLine();
      it.setExpectation(MultilineStringTest.wrapFormatted(_builder));
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("contact \"xyz\";");
      _builder_1.newLine();
      it.setToBeFormatted(MultilineStringTest.wrapUnformatted(_builder_1));
    };
    this.assertFormattedWithoutSerialization(_function);
  }
}

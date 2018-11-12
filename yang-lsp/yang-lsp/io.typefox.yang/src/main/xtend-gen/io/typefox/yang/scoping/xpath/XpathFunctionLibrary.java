package io.typefox.yang.scoping.xpath;

import java.util.Collections;
import java.util.Map;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Functions.Function0;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.eclipse.xtext.xbase.lib.Pure;

@SuppressWarnings("all")
public class XpathFunctionLibrary {
  public enum Type {
    STRING,
    
    BOOLEAN,
    
    NUMBER,
    
    NODE_SET,
    
    OBJECT;
  }
  
  @Accessors
  public static class Function {
    private String name;
    
    private String documentation;
    
    private XpathFunctionLibrary.Type returnType;
    
    private XpathFunctionLibrary.Type[] paramTypes;
    
    private int optional = 0;
    
    private boolean isVarArg = false;
    
    @Pure
    public String getName() {
      return this.name;
    }
    
    public void setName(final String name) {
      this.name = name;
    }
    
    @Pure
    public String getDocumentation() {
      return this.documentation;
    }
    
    public void setDocumentation(final String documentation) {
      this.documentation = documentation;
    }
    
    @Pure
    public XpathFunctionLibrary.Type getReturnType() {
      return this.returnType;
    }
    
    public void setReturnType(final XpathFunctionLibrary.Type returnType) {
      this.returnType = returnType;
    }
    
    @Pure
    public XpathFunctionLibrary.Type[] getParamTypes() {
      return this.paramTypes;
    }
    
    public void setParamTypes(final XpathFunctionLibrary.Type[] paramTypes) {
      this.paramTypes = paramTypes;
    }
    
    @Pure
    public int getOptional() {
      return this.optional;
    }
    
    public void setOptional(final int optional) {
      this.optional = optional;
    }
    
    @Pure
    public boolean isVarArg() {
      return this.isVarArg;
    }
    
    public void setIsVarArg(final boolean isVarArg) {
      this.isVarArg = isVarArg;
    }
  }
  
  public static final Map<String, XpathFunctionLibrary.Function> FUNCTIONS = new Function0<Map<String, XpathFunctionLibrary.Function>>() {
    public Map<String, XpathFunctionLibrary.Function> apply() {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("The last function returns a number equal to the context size from the expression evaluation context.");
      _builder.newLine();
      XpathFunctionLibrary.Function _fun = XpathFunctionLibrary.fun(_builder, XpathFunctionLibrary.Type.NUMBER, "last");
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("The position function returns a number equal to the context position from the expression evaluation context.");
      _builder_1.newLine();
      XpathFunctionLibrary.Function _fun_1 = XpathFunctionLibrary.fun(_builder_1, XpathFunctionLibrary.Type.NUMBER, "position");
      StringConcatenation _builder_2 = new StringConcatenation();
      _builder_2.append("The count function returns the number of nodes in the argument node-set.");
      _builder_2.newLine();
      XpathFunctionLibrary.Function _fun_2 = XpathFunctionLibrary.fun(_builder_2, XpathFunctionLibrary.Type.NUMBER, "count", XpathFunctionLibrary.Type.NODE_SET);
      StringConcatenation _builder_3 = new StringConcatenation();
      _builder_3.append("The id function selects elements by their unique ID (see [5.2.1 Unique IDs]). When the argument to id is of type node-set, then the result is the union of the result of applying id to the string-value of each of the nodes in the argument node-set. When the argument to id is of any other type, the argument is converted to a string as if by a call to the string function; the string is split into a whitespace-separated list of tokens (whitespace is any sequence of characters matching the production S); the result is a node-set containing the elements in the same document as the context node that have a unique ID equal to any of the tokens in the list.");
      _builder_3.newLine();
      _builder_3.newLine();
      _builder_3.append(" ");
      _builder_3.append("- `id(\"foo\")` selects the element with unique ID foo");
      _builder_3.newLine();
      _builder_3.append(" ");
      _builder_3.append("- `id(\"foo\")/child::para[position()=5]` selects the fifth para child of the element with unique ID foo");
      _builder_3.newLine();
      XpathFunctionLibrary.Function _fun_3 = XpathFunctionLibrary.fun(_builder_3, XpathFunctionLibrary.Type.NODE_SET, "id", XpathFunctionLibrary.Type.OBJECT);
      StringConcatenation _builder_4 = new StringConcatenation();
      _builder_4.append("The local-name function returns the local part of the expanded-name of the node in the argument node-set that is first in document order. If the argument node-set is empty or the first node has no expanded-name, an empty string is returned. If the argument is omitted, it defaults to a node-set with the context node as its only member.");
      _builder_4.newLine();
      XpathFunctionLibrary.Function _fun_4 = XpathFunctionLibrary.fun(_builder_4, XpathFunctionLibrary.Type.STRING, "local-name", XpathFunctionLibrary.Type.NODE_SET);
      final Procedure1<XpathFunctionLibrary.Function> _function = (XpathFunctionLibrary.Function it) -> {
        it.optional = 1;
      };
      XpathFunctionLibrary.Function _doubleArrow = ObjectExtensions.<XpathFunctionLibrary.Function>operator_doubleArrow(_fun_4, _function);
      StringConcatenation _builder_5 = new StringConcatenation();
      _builder_5.append("The namespace-uri function returns the namespace URI of the expanded-name of the node in the argument node-set that is first in document order. If the argument node-set is empty, the first node has no expanded-name, or the namespace URI of the expanded-name is null, an empty string is returned. If the argument is omitted, it defaults to a node-set with the context node as its only member.");
      _builder_5.newLine();
      XpathFunctionLibrary.Function _fun_5 = XpathFunctionLibrary.fun(_builder_5, XpathFunctionLibrary.Type.STRING, "namespace-uri", XpathFunctionLibrary.Type.NODE_SET);
      final Procedure1<XpathFunctionLibrary.Function> _function_1 = (XpathFunctionLibrary.Function it) -> {
        it.optional = 1;
      };
      XpathFunctionLibrary.Function _doubleArrow_1 = ObjectExtensions.<XpathFunctionLibrary.Function>operator_doubleArrow(_fun_5, _function_1);
      StringConcatenation _builder_6 = new StringConcatenation();
      _builder_6.append("The name function returns a string containing a QName representing the expanded-name of the node in the argument node-set that is first in document order. The QName must represent the expanded-name with respect to the namespace declarations in effect on the node whose expanded-name is being represented. Typically, this will be the QName that occurred in the XML source. This need not be the case if there are namespace declarations in effect on the node that associate multiple prefixes with the same namespace. However, an implementation may include information about the original prefix in its representation of nodes; in this case, an implementation can ensure that the returned string is always the same as the QName used in the XML source. If the argument node-set is empty or the first node has no expanded-name, an empty string is returned. If the argument it omitted, it defaults to a node-set with the context node as its only member.");
      _builder_6.newLine();
      XpathFunctionLibrary.Function _fun_6 = XpathFunctionLibrary.fun(_builder_6, XpathFunctionLibrary.Type.STRING, "name", XpathFunctionLibrary.Type.NODE_SET);
      final Procedure1<XpathFunctionLibrary.Function> _function_2 = (XpathFunctionLibrary.Function it) -> {
        it.optional = 1;
      };
      XpathFunctionLibrary.Function _doubleArrow_2 = ObjectExtensions.<XpathFunctionLibrary.Function>operator_doubleArrow(_fun_6, _function_2);
      StringConcatenation _builder_7 = new StringConcatenation();
      _builder_7.append("The string function converts an object to a string as follows:");
      _builder_7.newLine();
      _builder_7.newLine();
      _builder_7.append(" ");
      _builder_7.append("- A node-set is converted to a string by returning the string-value of the node in the node-set that is first in document order. If the node-set is empty, an empty string is returned.");
      _builder_7.newLine();
      _builder_7.newLine();
      _builder_7.append(" ");
      _builder_7.append("- A number is converted to a string as follows");
      _builder_7.newLine();
      _builder_7.newLine();
      _builder_7.append(" ");
      _builder_7.append("- NaN is converted to the string `NaN`");
      _builder_7.newLine();
      _builder_7.newLine();
      _builder_7.append(" ");
      _builder_7.append("- positive zero is converted to the string 0");
      _builder_7.newLine();
      _builder_7.newLine();
      _builder_7.append(" ");
      _builder_7.append("- negative zero is converted to the string 0");
      _builder_7.newLine();
      _builder_7.newLine();
      _builder_7.append(" ");
      _builder_7.append("- positive infinity is converted to the string Infinity");
      _builder_7.newLine();
      _builder_7.newLine();
      _builder_7.append(" ");
      _builder_7.append("- negative infinity is converted to the string -Infinity");
      _builder_7.newLine();
      _builder_7.newLine();
      _builder_7.append(" ");
      _builder_7.append("- if the number is an integer, the number is represented in decimal form as a Number with no decimal point and no leading zeros, preceded by a minus sign (-) if the number is negative");
      _builder_7.newLine();
      _builder_7.newLine();
      _builder_7.append(" ");
      _builder_7.append("- otherwise, the number is represented in decimal form as a Number including a decimal point with at least one digit before the decimal point and at least one digit after the decimal point, preceded by a minus sign (-) if the number is negative; there must be no leading zeros before the decimal point apart possibly from the one required digit immediately before the decimal point; beyond the one required digit after the decimal point there must be as many, but only as many, more digits as are needed to uniquely distinguish the number from all other IEEE 754 numeric values.");
      _builder_7.newLine();
      _builder_7.newLine();
      _builder_7.append(" ");
      _builder_7.append("- The boolean false value is converted to the string false. The boolean true value is converted to the string true.");
      _builder_7.newLine();
      _builder_7.newLine();
      _builder_7.append(" ");
      _builder_7.append("- An object of a type other than the four basic types is converted to a string in a way that is dependent on that type.");
      _builder_7.newLine();
      _builder_7.newLine();
      _builder_7.append("If the argument is omitted, it defaults to a node-set with the context node as its only member.");
      _builder_7.newLine();
      XpathFunctionLibrary.Function _fun_7 = XpathFunctionLibrary.fun(_builder_7, XpathFunctionLibrary.Type.STRING, "string", XpathFunctionLibrary.Type.OBJECT);
      final Procedure1<XpathFunctionLibrary.Function> _function_3 = (XpathFunctionLibrary.Function it) -> {
        it.optional = 1;
      };
      XpathFunctionLibrary.Function _doubleArrow_3 = ObjectExtensions.<XpathFunctionLibrary.Function>operator_doubleArrow(_fun_7, _function_3);
      StringConcatenation _builder_8 = new StringConcatenation();
      _builder_8.append("The concat function returns the concatenation of its arguments.");
      _builder_8.newLine();
      XpathFunctionLibrary.Function _fun_8 = XpathFunctionLibrary.fun(_builder_8, XpathFunctionLibrary.Type.STRING, "concat", XpathFunctionLibrary.Type.STRING, XpathFunctionLibrary.Type.STRING, XpathFunctionLibrary.Type.STRING);
      final Procedure1<XpathFunctionLibrary.Function> _function_4 = (XpathFunctionLibrary.Function it) -> {
        it.isVarArg = true;
      };
      XpathFunctionLibrary.Function _doubleArrow_4 = ObjectExtensions.<XpathFunctionLibrary.Function>operator_doubleArrow(_fun_8, _function_4);
      StringConcatenation _builder_9 = new StringConcatenation();
      _builder_9.append("The starts-with function returns true if the first argument string starts with the second argument string, and otherwise returns false.");
      _builder_9.newLine();
      XpathFunctionLibrary.Function _fun_9 = XpathFunctionLibrary.fun(_builder_9, XpathFunctionLibrary.Type.BOOLEAN, "starts-with", XpathFunctionLibrary.Type.STRING, XpathFunctionLibrary.Type.STRING);
      StringConcatenation _builder_10 = new StringConcatenation();
      _builder_10.append("The contains function returns true if the first argument string contains the second argument string, and otherwise returns false.");
      _builder_10.newLine();
      XpathFunctionLibrary.Function _fun_10 = XpathFunctionLibrary.fun(_builder_10, XpathFunctionLibrary.Type.BOOLEAN, "contains", XpathFunctionLibrary.Type.STRING, XpathFunctionLibrary.Type.STRING);
      StringConcatenation _builder_11 = new StringConcatenation();
      _builder_11.append("The substring-before function returns the substring of the first argument string that precedes the first occurrence of the second argument string in the first argument string, or the empty string if the first argument string does not contain the second argument string. For example, `substring-before(\"1999/04/01\",\"/\")` returns `1999`.");
      _builder_11.newLine();
      XpathFunctionLibrary.Function _fun_11 = XpathFunctionLibrary.fun(_builder_11, XpathFunctionLibrary.Type.STRING, "substring-before", XpathFunctionLibrary.Type.STRING, XpathFunctionLibrary.Type.STRING);
      StringConcatenation _builder_12 = new StringConcatenation();
      _builder_12.append("The substring-after function returns the substring of the first argument string that follows the first occurrence of the second argument string in the first argument string, or the empty string if the first argument string does not contain the second argument string. For example, `substring-after(\"1999/04/01\",\"/\")` returns `04/01`, and `substring-after(\"1999/04/01\",\"19\")` returns `99/04/01`.");
      _builder_12.newLine();
      XpathFunctionLibrary.Function _fun_12 = XpathFunctionLibrary.fun(_builder_12, XpathFunctionLibrary.Type.STRING, "substring-after", XpathFunctionLibrary.Type.STRING, XpathFunctionLibrary.Type.STRING);
      StringConcatenation _builder_13 = new StringConcatenation();
      _builder_13.append("The substring function returns the substring of the first argument starting at the position specified in the second argument with length specified in the third argument. For example, substring(\"12345\",2,3) returns \"234\". If the third argument is not specified, it returns the substring starting at the position specified in the second argument and continuing to the end of the string. For example, substring(\"12345\",2) returns \"2345\".");
      _builder_13.newLine();
      _builder_13.newLine();
      _builder_13.append("More precisely, each character in the string (see [3.6 Strings]) is considered to have a numeric position: the position of the first character is 1, the position of the second character is 2 and so on.");
      _builder_13.newLine();
      _builder_13.newLine();
      _builder_13.append("NOTE: This differs from Java and ECMAScript, in which the String.substring method treats the position of the first character as 0.");
      _builder_13.newLine();
      _builder_13.append("The returned substring contains those characters for which the position of the character is greater than or equal to the rounded value of the second argument and, if the third argument is specified, less than the sum of the rounded value of the second argument and the rounded value of the third argument; the comparisons and addition used for the above follow the standard IEEE 754 rules; rounding is done as if by a call to the round function. The following examples illustrate various unusual cases:");
      _builder_13.newLine();
      _builder_13.newLine();
      _builder_13.append(" ");
      _builder_13.append("- `substring(\"12345\", 1.5, 2.6)` returns `\"234\"`");
      _builder_13.newLine();
      _builder_13.newLine();
      _builder_13.append(" ");
      _builder_13.append("- `substring(\"12345\", 0, 3)` returns `\"12\"`");
      _builder_13.newLine();
      _builder_13.newLine();
      _builder_13.append(" ");
      _builder_13.append("- `substring(\"12345\", 0 div 0, 3)` returns `\"\"`");
      _builder_13.newLine();
      _builder_13.newLine();
      _builder_13.append(" ");
      _builder_13.append("- `substring(\"12345\", 1, 0 div 0)` returns `\"\"`");
      _builder_13.newLine();
      _builder_13.newLine();
      _builder_13.append(" ");
      _builder_13.append("- `substring(\"12345\", -42, 1 div 0)` returns `\"12345\"`");
      _builder_13.newLine();
      _builder_13.newLine();
      _builder_13.append(" ");
      _builder_13.append("- `substring(\"12345\", -1 div 0, 1 div 0)` returns `\"\"`");
      _builder_13.newLine();
      XpathFunctionLibrary.Function _fun_13 = XpathFunctionLibrary.fun(_builder_13, XpathFunctionLibrary.Type.STRING, "substring", XpathFunctionLibrary.Type.STRING, XpathFunctionLibrary.Type.NUMBER, XpathFunctionLibrary.Type.NUMBER);
      final Procedure1<XpathFunctionLibrary.Function> _function_5 = (XpathFunctionLibrary.Function it) -> {
        it.optional = 1;
      };
      XpathFunctionLibrary.Function _doubleArrow_5 = ObjectExtensions.<XpathFunctionLibrary.Function>operator_doubleArrow(_fun_13, _function_5);
      StringConcatenation _builder_14 = new StringConcatenation();
      _builder_14.append("The string-length returns the number of characters in the string (see [3.6 Strings]). If the argument is omitted, it defaults to the context node converted to a string, in other words the string-value of the context node.");
      _builder_14.newLine();
      XpathFunctionLibrary.Function _fun_14 = XpathFunctionLibrary.fun(_builder_14, XpathFunctionLibrary.Type.NUMBER, "string-length", XpathFunctionLibrary.Type.STRING);
      final Procedure1<XpathFunctionLibrary.Function> _function_6 = (XpathFunctionLibrary.Function it) -> {
        it.optional = 1;
      };
      XpathFunctionLibrary.Function _doubleArrow_6 = ObjectExtensions.<XpathFunctionLibrary.Function>operator_doubleArrow(_fun_14, _function_6);
      StringConcatenation _builder_15 = new StringConcatenation();
      _builder_15.append("The normalize-space function returns the argument string with whitespace normalized by stripping leading and trailing whitespace and replacing sequences of whitespace characters by a single space. Whitespace characters are the same as those allowed by the S production in XML. If the argument is omitted, it defaults to the context node converted to a string, in other words the string-value of the context node.");
      _builder_15.newLine();
      XpathFunctionLibrary.Function _fun_15 = XpathFunctionLibrary.fun(_builder_15, XpathFunctionLibrary.Type.STRING, "normalize-space", XpathFunctionLibrary.Type.STRING);
      final Procedure1<XpathFunctionLibrary.Function> _function_7 = (XpathFunctionLibrary.Function it) -> {
        it.optional = 1;
      };
      XpathFunctionLibrary.Function _doubleArrow_7 = ObjectExtensions.<XpathFunctionLibrary.Function>operator_doubleArrow(_fun_15, _function_7);
      StringConcatenation _builder_16 = new StringConcatenation();
      _builder_16.append("The translate function returns the first argument string with occurrences of characters in the second argument string replaced by the character at the corresponding position in the third argument string. For example, translate(\"bar\",\"abc\",\"ABC\") returns the string BAr. If there is a character in the second argument string with no character at a corresponding position in the third argument string (because the second argument string is longer than the third argument string), then occurrences of that character in the first argument string are removed. For example, translate(\"--aaa--\",\"abc-\",\"ABC\") returns \"AAA\". If a character occurs more than once in the second argument string, then the first occurrence determines the replacement character. If the third argument string is longer than the second argument string, then excess characters are ignored.");
      _builder_16.newLine();
      XpathFunctionLibrary.Function _fun_16 = XpathFunctionLibrary.fun(_builder_16, XpathFunctionLibrary.Type.STRING, "translate", XpathFunctionLibrary.Type.STRING, XpathFunctionLibrary.Type.STRING, XpathFunctionLibrary.Type.STRING);
      StringConcatenation _builder_17 = new StringConcatenation();
      _builder_17.append("The boolean function converts its argument to a boolean as follows:");
      _builder_17.newLine();
      _builder_17.newLine();
      _builder_17.append(" ");
      _builder_17.append("- a number is true if and only if it is neither positive or negative zero nor NaN");
      _builder_17.newLine();
      _builder_17.newLine();
      _builder_17.append(" ");
      _builder_17.append("- a node-set is true if and only if it is non-empty");
      _builder_17.newLine();
      _builder_17.newLine();
      _builder_17.append(" ");
      _builder_17.append("- a string is true if and only if its length is non-zero");
      _builder_17.newLine();
      _builder_17.newLine();
      _builder_17.append(" ");
      _builder_17.append("- an object of a type other than the four basic types is converted to a boolean in a way that is dependent on that type");
      _builder_17.newLine();
      XpathFunctionLibrary.Function _fun_17 = XpathFunctionLibrary.fun(_builder_17, XpathFunctionLibrary.Type.BOOLEAN, "boolean", XpathFunctionLibrary.Type.OBJECT);
      StringConcatenation _builder_18 = new StringConcatenation();
      _builder_18.append("The not function returns true if its argument is false, and false otherwise.");
      _builder_18.newLine();
      XpathFunctionLibrary.Function _fun_18 = XpathFunctionLibrary.fun(_builder_18, XpathFunctionLibrary.Type.BOOLEAN, "not", XpathFunctionLibrary.Type.BOOLEAN);
      StringConcatenation _builder_19 = new StringConcatenation();
      _builder_19.append("The true function returns true.");
      _builder_19.newLine();
      XpathFunctionLibrary.Function _fun_19 = XpathFunctionLibrary.fun(_builder_19, XpathFunctionLibrary.Type.BOOLEAN, "true");
      StringConcatenation _builder_20 = new StringConcatenation();
      _builder_20.append("The false function returns false.");
      _builder_20.newLine();
      XpathFunctionLibrary.Function _fun_20 = XpathFunctionLibrary.fun(_builder_20, XpathFunctionLibrary.Type.BOOLEAN, "false");
      StringConcatenation _builder_21 = new StringConcatenation();
      _builder_21.append("The lang function returns true or false depending on whether the language of the context node as specified by xml:lang attributes is the same as or is a sublanguage of the language specified by the argument string. The language of the context node is determined by the value of the xml:lang attribute on the context node, or, if the context node has no xml:lang attribute, by the value of the xml:lang attribute on the nearest ancestor of the context node that has an xml:lang attribute. If there is no such attribute, then lang returns false. If there is such an attribute, then lang returns true if the attribute value is equal to the argument ignoring case, or if there is some suffix starting with - such that the attribute value is equal to the argument ignoring that suffix of the attribute value and ignoring case. For example, lang(\"en\") would return true if the context node is any of these five elements:");
      _builder_21.newLine();
      _builder_21.append("```");
      _builder_21.newLine();
      _builder_21.append("<para xml:lang=\"en\"/>");
      _builder_21.newLine();
      _builder_21.append("<div xml:lang=\"en\"><para/></div>");
      _builder_21.newLine();
      _builder_21.append("<para xml:lang=\"EN\"/>");
      _builder_21.newLine();
      _builder_21.append("<para xml:lang=\"en-us\"/>");
      _builder_21.newLine();
      _builder_21.append("``");
      _builder_21.newLine();
      XpathFunctionLibrary.Function _fun_21 = XpathFunctionLibrary.fun(_builder_21, XpathFunctionLibrary.Type.BOOLEAN, "lang", XpathFunctionLibrary.Type.STRING);
      StringConcatenation _builder_22 = new StringConcatenation();
      _builder_22.append("The number function converts its argument to a number as follows:");
      _builder_22.newLine();
      _builder_22.newLine();
      _builder_22.append(" ");
      _builder_22.append("- a string that consists of optional whitespace followed by an optional minus sign followed by a Number followed by whitespace is converted to the IEEE 754 number that is nearest (according to the IEEE 754 round-to-nearest rule) to the mathematical value represented by the string; any other string is converted to NaN");
      _builder_22.newLine();
      _builder_22.newLine();
      _builder_22.append(" ");
      _builder_22.append("- boolean true is converted to 1; boolean false is converted to 0");
      _builder_22.newLine();
      _builder_22.newLine();
      _builder_22.append(" ");
      _builder_22.append("- a node-set is first converted to a string as if by a call to the string function and then converted in the same way as a string argument");
      _builder_22.newLine();
      _builder_22.newLine();
      _builder_22.append(" ");
      _builder_22.append("- an object of a type other than the four basic types is converted to a number in a way that is dependent on that type");
      _builder_22.newLine();
      _builder_22.newLine();
      _builder_22.append("If the argument is omitted, it defaults to a node-set with the context node as its only member.");
      _builder_22.newLine();
      _builder_22.newLine();
      _builder_22.append(" ");
      _builder_22.append("- NOTE: The number function should not be used for conversion of numeric data occurring in an element in an XML document unless the element is of a type that represents numeric data in a language-neutral format (which would typically be transformed into a language-specific format for presentation to a user). In addition, the number function cannot be used unless the language-neutral format used by the element is consistent with the XPath syntax for a Number.");
      _builder_22.newLine();
      XpathFunctionLibrary.Function _fun_22 = XpathFunctionLibrary.fun(_builder_22, XpathFunctionLibrary.Type.NUMBER, "number", XpathFunctionLibrary.Type.OBJECT);
      StringConcatenation _builder_23 = new StringConcatenation();
      _builder_23.append("The sum function returns the sum, for each node in the argument node-set, of the result of converting the string-values of the node to a number.");
      _builder_23.newLine();
      XpathFunctionLibrary.Function _fun_23 = XpathFunctionLibrary.fun(_builder_23, XpathFunctionLibrary.Type.NUMBER, "sum", XpathFunctionLibrary.Type.NODE_SET);
      StringConcatenation _builder_24 = new StringConcatenation();
      _builder_24.append("The floor function returns the largest (closest to positive infinity) number that is not greater than the argument and that is an integer.");
      _builder_24.newLine();
      XpathFunctionLibrary.Function _fun_24 = XpathFunctionLibrary.fun(_builder_24, XpathFunctionLibrary.Type.NUMBER, "floor", XpathFunctionLibrary.Type.NUMBER);
      StringConcatenation _builder_25 = new StringConcatenation();
      _builder_25.append("The ceiling function returns the smallest (closest to negative infinity) number that is not less than the argument and that is an integer.");
      _builder_25.newLine();
      XpathFunctionLibrary.Function _fun_25 = XpathFunctionLibrary.fun(_builder_25, XpathFunctionLibrary.Type.NUMBER, "ceiling", XpathFunctionLibrary.Type.NUMBER);
      StringConcatenation _builder_26 = new StringConcatenation();
      _builder_26.append("The round function returns the number that is closest to the argument and that is an integer. If there are two such numbers, then the one that is closest to positive infinity is returned. If the argument is NaN, then NaN is returned. If the argument is positive infinity, then positive infinity is returned. If the argument is negative infinity, then negative infinity is returned. If the argument is positive zero, then positive zero is returned. If the argument is negative zero, then negative zero is returned. If the argument is less than zero, but greater than or equal to -0.5, then negative zero is returned.");
      _builder_26.newLine();
      _builder_26.newLine();
      _builder_26.append(" ");
      _builder_26.append("- NOTE: For these last two cases, the result of calling the round function is not the same as the result of adding 0.5 and then calling the floor function.");
      _builder_26.newLine();
      XpathFunctionLibrary.Function _fun_26 = XpathFunctionLibrary.fun(_builder_26, XpathFunctionLibrary.Type.NUMBER, "round", XpathFunctionLibrary.Type.NUMBER);
      StringConcatenation _builder_27 = new StringConcatenation();
      _builder_27.append("The current() function takes no input parameters and returns a node set with the initial context node as its only member.");
      _builder_27.newLine();
      XpathFunctionLibrary.Function _fun_27 = XpathFunctionLibrary.fun(_builder_27, XpathFunctionLibrary.Type.NODE_SET, "current");
      StringConcatenation _builder_28 = new StringConcatenation();
      _builder_28.append("The re-match() function returns `true` if the first argument string matches the regular expression (second argument); otherwise, it returns `false`.");
      _builder_28.newLine();
      XpathFunctionLibrary.Function _fun_28 = XpathFunctionLibrary.fun(_builder_28, XpathFunctionLibrary.Type.BOOLEAN, "re-match", XpathFunctionLibrary.Type.STRING, XpathFunctionLibrary.Type.STRING);
      StringConcatenation _builder_29 = new StringConcatenation();
      _builder_29.append("The deref() function follows the reference defined by the first node in document order in the argument \"nodes\" and returns the nodes it refers to.");
      _builder_29.newLine();
      _builder_29.newLine();
      _builder_29.append("If the first argument node is of type \"instance-identifier\", the function returns a node set that contains the single node that the instance identifier refers to, if it exists.  If no such node exists, an empty node set is returned.");
      _builder_29.newLine();
      _builder_29.newLine();
      _builder_29.append("If the first argument node is of type \"leafref\", the function returns a node set that contains the nodes that the leafref refers to. Specifically, this set contains the nodes selected by the leafref\'s \"path\" statement (Section 9.9.2) that have the same value as the first argument node.");
      _builder_29.newLine();
      _builder_29.newLine();
      _builder_29.append("If the first argument node is of any other type, an empty node set is returned.");
      _builder_29.newLine();
      XpathFunctionLibrary.Function _fun_29 = XpathFunctionLibrary.fun(_builder_29, XpathFunctionLibrary.Type.NODE_SET, "deref", XpathFunctionLibrary.Type.NODE_SET);
      StringConcatenation _builder_30 = new StringConcatenation();
      _builder_30.append("The derived-from() function returns \"true\" if any node in the");
      _builder_30.newLine();
      _builder_30.append("   ");
      _builder_30.append("argument \"nodes\" is a node of type \"identityref\" and its value is an");
      _builder_30.newLine();
      _builder_30.append("   ");
      _builder_30.append("identity that is derived from (see Section 7.18.2) the identity");
      _builder_30.newLine();
      _builder_30.append("   ");
      _builder_30.append("\"identity\"; otherwise, it returns \"false\".");
      _builder_30.newLine();
      _builder_30.newLine();
      _builder_30.append("   ");
      _builder_30.append("The parameter \"identity\" is a string matching the rule");
      _builder_30.newLine();
      _builder_30.append("   ");
      _builder_30.append("\"identifier-ref\" in Section 14.  If a prefix is present on the");
      _builder_30.newLine();
      _builder_30.append("   ");
      _builder_30.append("identity, it refers to an identity defined in the module that was");
      _builder_30.newLine();
      _builder_30.append("   ");
      _builder_30.append("imported with that prefix, or the local module if the prefix matches");
      _builder_30.newLine();
      _builder_30.append("   ");
      _builder_30.append("the local module\'s prefix.  If no prefix is present, the identity");
      _builder_30.newLine();
      _builder_30.append("   ");
      _builder_30.append("refers to an identity defined in the current module or an included");
      _builder_30.newLine();
      _builder_30.append("   ");
      _builder_30.append("submodule.");
      _builder_30.newLine();
      XpathFunctionLibrary.Function _fun_30 = XpathFunctionLibrary.fun(_builder_30, XpathFunctionLibrary.Type.BOOLEAN, "derived-from", XpathFunctionLibrary.Type.NODE_SET, XpathFunctionLibrary.Type.STRING);
      StringConcatenation _builder_31 = new StringConcatenation();
      _builder_31.append("The derived-from-or-self() function returns \"true\" if any node in the");
      _builder_31.newLine();
      _builder_31.append("   ");
      _builder_31.append("argument \"nodes\" is a node of type \"identityref\" and its value is an");
      _builder_31.newLine();
      _builder_31.append("   ");
      _builder_31.append("identity that is equal to or derived from (see Section 7.18.2) the");
      _builder_31.newLine();
      _builder_31.append("   ");
      _builder_31.append("identity \"identity\"; otherwise, it returns \"false\".");
      _builder_31.newLine();
      _builder_31.newLine();
      _builder_31.append("   ");
      _builder_31.append("The parameter \"identity\" is a string matching the rule");
      _builder_31.newLine();
      _builder_31.append("   ");
      _builder_31.append("\"identifier-ref\" in Section 14.  If a prefix is present on the");
      _builder_31.newLine();
      _builder_31.append("   ");
      _builder_31.append("identity, it refers to an identity defined in the module that was");
      _builder_31.newLine();
      _builder_31.append("   ");
      _builder_31.append("imported with that prefix, or the local module if the prefix matches");
      _builder_31.newLine();
      _builder_31.append("   ");
      _builder_31.append("the local module\'s prefix.  If no prefix is present, the identity");
      _builder_31.newLine();
      _builder_31.append("   ");
      _builder_31.append("refers to an identity defined in the current module or an included");
      _builder_31.newLine();
      _builder_31.append("   ");
      _builder_31.append("submodule.");
      _builder_31.newLine();
      XpathFunctionLibrary.Function _fun_31 = XpathFunctionLibrary.fun(_builder_31, XpathFunctionLibrary.Type.BOOLEAN, "derived-from-or-self", XpathFunctionLibrary.Type.NODE_SET, XpathFunctionLibrary.Type.STRING);
      StringConcatenation _builder_32 = new StringConcatenation();
      _builder_32.append("The enum-value() function checks to see if the first node in document");
      _builder_32.newLine();
      _builder_32.append("   ");
      _builder_32.append("order in the argument \"nodes\" is a node of type \"enumeration\" and");
      _builder_32.newLine();
      _builder_32.append("   ");
      _builder_32.append("returns the enum\'s integer value.  If the \"nodes\" node set is empty");
      _builder_32.newLine();
      _builder_32.append("   ");
      _builder_32.append("or if the first node in \"nodes\" is not of type \"enumeration\", it");
      _builder_32.newLine();
      _builder_32.append("   ");
      _builder_32.append("returns NaN (not a number).");
      _builder_32.newLine();
      XpathFunctionLibrary.Function _fun_32 = XpathFunctionLibrary.fun(_builder_32, XpathFunctionLibrary.Type.NUMBER, "enum-value", XpathFunctionLibrary.Type.NODE_SET);
      StringConcatenation _builder_33 = new StringConcatenation();
      _builder_33.append("The bit-is-set() function returns \"true\" if the first node in");
      _builder_33.newLine();
      _builder_33.append("   ");
      _builder_33.append("document order in the argument \"nodes\" is a node of type \"bits\" and");
      _builder_33.newLine();
      _builder_33.append("   ");
      _builder_33.append("its value has the bit \"bit-name\" set; otherwise, it returns \"false\".");
      _builder_33.newLine();
      _builder_33.append("   ");
      _builder_33.newLine();
      _builder_33.newLine();
      XpathFunctionLibrary.Function _fun_33 = XpathFunctionLibrary.fun(_builder_33, XpathFunctionLibrary.Type.BOOLEAN, "bit-is-set", XpathFunctionLibrary.Type.NODE_SET, XpathFunctionLibrary.Type.STRING);
      final Function1<XpathFunctionLibrary.Function, String> _function_8 = (XpathFunctionLibrary.Function it) -> {
        return it.name;
      };
      Map<String, XpathFunctionLibrary.Function> _map = IterableExtensions.<String, XpathFunctionLibrary.Function>toMap(Collections.<XpathFunctionLibrary.Function>unmodifiableList(CollectionLiterals.<XpathFunctionLibrary.Function>newArrayList(_fun, _fun_1, _fun_2, _fun_3, _doubleArrow, _doubleArrow_1, _doubleArrow_2, _doubleArrow_3, _doubleArrow_4, _fun_9, _fun_10, _fun_11, _fun_12, _doubleArrow_5, _doubleArrow_6, _doubleArrow_7, _fun_16, _fun_17, _fun_18, _fun_19, _fun_20, _fun_21, _fun_22, _fun_23, _fun_24, _fun_25, _fun_26, _fun_27, _fun_28, _fun_29, _fun_30, _fun_31, _fun_32, _fun_33)), _function_8);
      return _map;
    }
  }.apply();
  
  private static XpathFunctionLibrary.Function fun(final CharSequence documentation, final XpathFunctionLibrary.Type returnType, final String name, final XpathFunctionLibrary.Type... parameters) {
    XpathFunctionLibrary.Function _function = new XpathFunctionLibrary.Function();
    final Procedure1<XpathFunctionLibrary.Function> _function_1 = (XpathFunctionLibrary.Function it) -> {
      it.documentation = documentation.toString();
      it.name = name;
      it.returnType = returnType;
      it.paramTypes = parameters;
    };
    return ObjectExtensions.<XpathFunctionLibrary.Function>operator_doubleArrow(_function, _function_1);
  }
}

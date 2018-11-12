package io.typefox.yang.parser.antlr.lexer.jflex;

import io.typefox.yang.parser.antlr.internal.InternalYangParser;
import io.typefox.yang.parser.antlr.lexer.jflex.YangFlexer;
import java.io.FileReader;
import java.util.regex.Pattern;
import org.antlr.runtime.Token;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.InputOutput;

@SuppressWarnings("all")
public class YangFix {
  private static final Pattern CONCAT_PATTERN = Pattern.compile("(\"\\s*\\+\\s*\"|\'\\s*\\+\\s*\')");
  
  public static void main(final String[] args) {
    try {
      String _get = args[0];
      final FileReader reader = new FileReader(_get);
      final YangFlexer yangFlexer = new YangFlexer(reader);
      boolean stop = false;
      String lastHidden = "";
      do {
        {
          final Token token = yangFlexer.nextToken();
          int _type = token.getType();
          boolean _tripleEquals = (_type == Token.EOF);
          if (_tripleEquals) {
            stop = true;
          }
          int _type_1 = token.getType();
          boolean _equals = (_type_1 == InternalYangParser.RULE_HIDDEN);
          if (_equals) {
            String _lastHidden = lastHidden;
            String _text = token.getText();
            lastHidden = (_lastHidden + _text);
          } else {
            if (((!lastHidden.isEmpty()) && (!YangFix.CONCAT_PATTERN.matcher(lastHidden).matches()))) {
              InputOutput.<String>print(lastHidden);
            }
            lastHidden = "";
            String _text_1 = token.getText();
            boolean _tripleNotEquals = (_text_1 != null);
            if (_tripleNotEquals) {
              InputOutput.<String>print(token.getText());
            }
          }
        }
      } while((!stop));
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}

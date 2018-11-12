package io.typefox.yang.formatting2;

import com.google.common.base.Objects;
import com.google.common.base.Strings;
import io.typefox.yang.services.YangGrammarAccess;
import java.util.LinkedList;
import java.util.List;
import java.util.function.Consumer;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtend.lib.annotations.FinalFieldsConstructor;
import org.eclipse.xtext.TerminalRule;
import org.eclipse.xtext.formatting2.ITextReplacer;
import org.eclipse.xtext.formatting2.ITextReplacerContext;
import org.eclipse.xtext.formatting2.regionaccess.ITextSegment;
import org.eclipse.xtext.formatting2.regionaccess.internal.NodeSemanticRegion;
import org.eclipse.xtext.nodemodel.ILeafNode;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.ExclusiveRange;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;

@FinalFieldsConstructor
@SuppressWarnings("all")
public class MultilineStringReplacer implements ITextReplacer {
  @FinalFieldsConstructor
  public static class LinesModel {
    private final LinkedList<MultilineStringReplacer.Line> lines = CollectionLiterals.<MultilineStringReplacer.Line>newLinkedList(new MultilineStringReplacer.Line());
    
    @Extension
    private final YangGrammarAccess _yangGrammarAccess;
    
    private final String firstLineIndentation;
    
    private final String trailingLinesIndentation;
    
    public MultilineStringReplacer.Line getLast() {
      return this.lines.getLast();
    }
    
    public boolean addSpace() {
      boolean _xifexpression = false;
      if (((!this.getLast().isEmpty()) && (!this.getLast().getLast().trim().isEmpty()))) {
        _xifexpression = this.getLast().append(" ", MultilineStringReplacer.Line.PartType.Hidden);
      }
      return _xifexpression;
    }
    
    public Boolean addStringValue(final String text, final int originalStartColumn) {
      boolean _xblockexpression = false;
      {
        final String[] parts = text.split(System.lineSeparator());
        boolean _xifexpression = false;
        int _length = parts.length;
        boolean _tripleEquals = (_length == 1);
        if (_tripleEquals) {
          _xifexpression = this.getLast().append(text, MultilineStringReplacer.Line.PartType.Value);
        } else {
          this.getLast().append(IterableExtensions.<String>head(((Iterable<String>)Conversions.doWrapArray(parts))), MultilineStringReplacer.Line.PartType.Value);
          final int indentToRemoved = MultilineStringReplacer.LinesModel.indentToRemoved(parts, originalStartColumn);
          final Function1<String, String> _function = (String it) -> {
            return MultilineStringReplacer.LinesModel.leftTrim(it, indentToRemoved);
          };
          final List<String> rest = IterableExtensions.<String>toList(IterableExtensions.<String, String>map(IterableExtensions.<String>tail(((Iterable<String>)Conversions.doWrapArray(parts))), _function));
          boolean _isQuote = MultilineStringReplacer.isQuote(IterableExtensions.<String>last(rest));
          if (_isQuote) {
            int _length_1 = ((Object[])Conversions.unwrapArray(rest, Object.class)).length;
            int _minus = (_length_1 - 1);
            rest.set(_minus, IterableExtensions.<String>last(rest).trim());
          }
          for (final String part : rest) {
            {
              this.newLine();
              this.getLast().append(part, MultilineStringReplacer.Line.PartType.ValueContinuation);
            }
          }
        }
        _xblockexpression = _xifexpression;
      }
      return Boolean.valueOf(_xblockexpression);
    }
    
    public static String leftTrim(final String string, final int trimLength) {
      Integer _elvis = null;
      int _min = Math.min(string.length(), trimLength);
      final Function1<Integer, Boolean> _function = (Integer index) -> {
        boolean _isWhitespace = Character.isWhitespace(string.charAt((index).intValue()));
        return Boolean.valueOf((!_isWhitespace));
      };
      Integer _findFirst = IterableExtensions.<Integer>findFirst(new ExclusiveRange(0, _min, true), _function);
      if (_findFirst != null) {
        _elvis = _findFirst;
      } else {
        _elvis = Integer.valueOf(trimLength);
      }
      final Integer beginIndex = _elvis;
      return string.substring(Math.min(string.length(), (beginIndex).intValue()));
    }
    
    public static String leftTrim(final String s) {
      Integer _elvis = null;
      int _length = s.length();
      final Function1<Integer, Boolean> _function = (Integer index) -> {
        boolean _isWhitespace = Character.isWhitespace(s.charAt((index).intValue()));
        return Boolean.valueOf((!_isWhitespace));
      };
      Integer _findFirst = IterableExtensions.<Integer>findFirst(new ExclusiveRange(0, _length, true), _function);
      if (_findFirst != null) {
        _elvis = _findFirst;
      } else {
        int _length_1 = s.length();
        _elvis = Integer.valueOf(_length_1);
      }
      final Integer beginIndex = _elvis;
      return s.substring((beginIndex).intValue());
    }
    
    public static int indentToRemoved(final String[] strings, final int originalStartColumn) {
      final Function1<String, Integer> _function = (String it) -> {
        Integer _elvis = null;
        int _length = it.length();
        final Function1<Integer, Boolean> _function_1 = (Integer index) -> {
          boolean _isWhitespace = Character.isWhitespace(it.charAt((index).intValue()));
          return Boolean.valueOf((!_isWhitespace));
        };
        Integer _findFirst = IterableExtensions.<Integer>findFirst(new ExclusiveRange(0, _length, true), _function_1);
        if (_findFirst != null) {
          _elvis = _findFirst;
        } else {
          _elvis = Integer.valueOf(Integer.MAX_VALUE);
        }
        return _elvis;
      };
      final Function1<? super String, ? extends Integer> countLeadingWS = _function;
      int _length = strings.length;
      int count = (_length - 1);
      boolean _isQuote = MultilineStringReplacer.isQuote(IterableExtensions.<String>last(((Iterable<String>)Conversions.doWrapArray(strings))));
      if (_isQuote) {
        int _count = count;
        count = (_count - 1);
      }
      if ((count < 1)) {
        return 0;
      }
      final Function1<String, Integer> _function_1 = (String it) -> {
        return countLeadingWS.apply(it);
      };
      final Integer minCountLeadingWS = IterableExtensions.<Integer>min(IterableExtensions.<String, Integer>map(IterableExtensions.<String>take(IterableExtensions.<String>tail(((Iterable<String>)Conversions.doWrapArray(strings))), count), _function_1));
      return Math.min((minCountLeadingWS).intValue(), originalStartColumn);
    }
    
    public boolean addSingleLineComment(final String text) {
      return this.getLast().append(text, MultilineStringReplacer.Line.PartType.SingleLineComment);
    }
    
    public boolean newLine() {
      boolean _xifexpression = false;
      boolean _isEmpty = this.getLast().isEmpty();
      boolean _not = (!_isEmpty);
      if (_not) {
        MultilineStringReplacer.Line _line = new MultilineStringReplacer.Line();
        _xifexpression = this.lines.add(_line);
      }
      return _xifexpression;
    }
    
    public MultilineStringReplacer.LinesModel addMultiLineComment(final String text) {
      String[] parts = text.split(System.lineSeparator());
      boolean first = true;
      for (final String part : parts) {
        if (first) {
          first = false;
          this.getLast().append(part, MultilineStringReplacer.Line.PartType.MultiLineComment);
        } else {
          this.newLine();
          MultilineStringReplacer.Line _last = this.getLast();
          String _leftTrim = MultilineStringReplacer.LinesModel.leftTrim(part);
          String _plus = (" " + _leftTrim);
          _last.append(_plus, MultilineStringReplacer.Line.PartType.MultiLineComment);
        }
      }
      return this;
    }
    
    public boolean addPlus() {
      boolean _xifexpression = false;
      boolean _isEmpty = this.getLast().isEmpty();
      boolean _not = (!_isEmpty);
      if (_not) {
        _xifexpression = this.getLast().append("+", MultilineStringReplacer.Line.PartType.Hidden);
      }
      return _xifexpression;
    }
    
    public void build(final List<ILeafNode> leafNodes) {
      for (final ILeafNode it : leafNodes) {
        boolean _isHidden = it.isHidden();
        if (_isHidden) {
          final EObject grammarElement = it.getGrammarElement();
          TerminalRule _mL_COMMENTRule = this._yangGrammarAccess.getML_COMMENTRule();
          boolean _equals = Objects.equal(_mL_COMMENTRule, grammarElement);
          if (_equals) {
            this.addSpace();
            this.addMultiLineComment(it.getText());
          }
          TerminalRule _sL_COMMENTRule = this._yangGrammarAccess.getSL_COMMENTRule();
          boolean _equals_1 = Objects.equal(_sL_COMMENTRule, grammarElement);
          if (_equals_1) {
            final String text = it.getText().replace(System.lineSeparator(), "");
            this.addSpace();
            this.addSingleLineComment(text);
            this.newLine();
          }
          TerminalRule _wSRule = this._yangGrammarAccess.getWSRule();
          boolean _equals_2 = Objects.equal(_wSRule, grammarElement);
          if (_equals_2) {
            boolean _contains = it.getText().contains(System.lineSeparator());
            if (_contains) {
              this.newLine();
            } else {
              this.addSpace();
            }
          }
          TerminalRule _hIDDENRule = this._yangGrammarAccess.getHIDDENRule();
          boolean _equals_3 = Objects.equal(_hIDDENRule, grammarElement);
          if (_equals_3) {
            boolean _contains_1 = it.getText().contains("+");
            if (_contains_1) {
              this.addPlus();
            }
          }
        } else {
          final int originalStartColumn = NodeModelUtils.getLineAndColumn(it, it.getOffset()).getColumn();
          this.addStringValue(it.getText(), originalStartColumn);
        }
      }
      IterableExtensions.<MultilineStringReplacer.Line>head(this.lines).prepend(this.firstLineIndentation, MultilineStringReplacer.Line.PartType.Hidden);
      final Consumer<MultilineStringReplacer.Line> _function = (MultilineStringReplacer.Line it_1) -> {
        final String lineTypePrefix = it_1.getPrefix();
        it_1.prepend((this.trailingLinesIndentation + lineTypePrefix), MultilineStringReplacer.Line.PartType.Hidden);
      };
      IterableExtensions.<MultilineStringReplacer.Line>tail(this.lines).forEach(_function);
    }
    
    @Override
    public String toString() {
      final String string = IterableExtensions.join(this.lines, System.lineSeparator());
      return string;
    }
    
    public LinesModel(final YangGrammarAccess _yangGrammarAccess, final String firstLineIndentation, final String trailingLinesIndentation) {
      super();
      this._yangGrammarAccess = _yangGrammarAccess;
      this.firstLineIndentation = firstLineIndentation;
      this.trailingLinesIndentation = trailingLinesIndentation;
    }
  }
  
  public static class Line {
    public enum PartType {
      Hidden,
      
      Value,
      
      ValueContinuation,
      
      SingleLineComment,
      
      MultiLineComment;
    }
    
    private final LinkedList<String> parts = CollectionLiterals.<String>newLinkedList();
    
    private final LinkedList<MultilineStringReplacer.Line.PartType> types = CollectionLiterals.<MultilineStringReplacer.Line.PartType>newLinkedList();
    
    public boolean isEmpty() {
      return this.parts.isEmpty();
    }
    
    public String getLast() {
      boolean _isEmpty = this.parts.isEmpty();
      boolean _not = (!_isEmpty);
      if (_not) {
        return this.parts.getLast();
      }
      return null;
    }
    
    public void prepend(final String string, final MultilineStringReplacer.Line.PartType type) {
      this.parts.add(0, string);
      this.types.add(0, type);
    }
    
    public boolean append(final String string, final MultilineStringReplacer.Line.PartType type) {
      boolean _xblockexpression = false;
      {
        this.parts.add(string);
        _xblockexpression = this.types.add(type);
      }
      return _xblockexpression;
    }
    
    public String getPrefix() {
      final boolean startsWithValueContinuation = ((!this.types.isEmpty()) && Objects.equal(this.types.getFirst(), MultilineStringReplacer.Line.PartType.ValueContinuation));
      if (startsWithValueContinuation) {
        String _xifexpression = null;
        boolean _isQuote = MultilineStringReplacer.isQuote(this.parts.getFirst());
        if (_isQuote) {
          _xifexpression = "  ";
        } else {
          _xifexpression = "   ";
        }
        return _xifexpression;
      }
      final boolean containsValue = this.types.contains(MultilineStringReplacer.Line.PartType.Value);
      if (containsValue) {
        return "+ ";
      }
      return "  ";
    }
    
    @Override
    public String toString() {
      return IterableExtensions.join(this.parts);
    }
  }
  
  private final YangGrammarAccess grammerAccess;
  
  private final NodeSemanticRegion region;
  
  private final int trailingLinesIndent;
  
  @Override
  public ITextSegment getRegion() {
    return this.region;
  }
  
  public boolean alignWithKeyword() {
    return (this.trailingLinesIndent != 0);
  }
  
  public String getFirstLineIndentation() {
    String _xifexpression = null;
    boolean _alignWithKeyword = this.alignWithKeyword();
    if (_alignWithKeyword) {
      _xifexpression = "";
    } else {
      _xifexpression = "  ";
    }
    return _xifexpression;
  }
  
  public String getTrailingLinesIndentation() {
    String _xifexpression = null;
    boolean _alignWithKeyword = this.alignWithKeyword();
    if (_alignWithKeyword) {
      _xifexpression = Strings.repeat(" ", (this.trailingLinesIndent - 1));
    } else {
      _xifexpression = "";
    }
    return _xifexpression;
  }
  
  @Override
  public ITextReplacerContext createReplacements(final ITextReplacerContext context) {
    final String currentIndentation = context.getIndentationString();
    final String firstLineIndentation = this.getFirstLineIndentation();
    String _trailingLinesIndentation = this.getTrailingLinesIndentation();
    final String trailingLinesIndentation = (currentIndentation + _trailingLinesIndentation);
    final List<ILeafNode> leafNodes = IterableExtensions.<ILeafNode>toList(this.region.getNode().getLeafNodes());
    final MultilineStringReplacer.LinesModel model = new MultilineStringReplacer.LinesModel(this.grammerAccess, firstLineIndentation, trailingLinesIndentation);
    model.build(leafNodes);
    final String newText = model.toString();
    context.addReplacement(this.region.replaceWith(newText));
    return context;
  }
  
  public static boolean isQuote(final String s) {
    final String trimmed = s.trim();
    return (Objects.equal(trimmed, "\"") || Objects.equal(trimmed, "\'"));
  }
  
  public MultilineStringReplacer(final YangGrammarAccess grammerAccess, final NodeSemanticRegion region, final int trailingLinesIndent) {
    super();
    this.grammerAccess = grammerAccess;
    this.region = region;
    this.trailingLinesIndent = trailingLinesIndent;
  }
}

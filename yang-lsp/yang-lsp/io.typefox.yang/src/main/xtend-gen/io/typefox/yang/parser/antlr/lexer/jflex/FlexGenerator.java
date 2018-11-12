package io.typefox.yang.parser.antlr.lexer.jflex;

import java.io.File;
import java.nio.file.Files;
import java.util.Collections;
import java.util.List;
import org.eclipse.xtend.lib.annotations.Data;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Functions.Function0;
import org.eclipse.xtext.xbase.lib.Pure;
import org.eclipse.xtext.xbase.lib.util.ToStringBuilder;

@SuppressWarnings("all")
public class FlexGenerator {
  @Data
  public static class ExpressionMode {
    private final String name;
    
    private final String commonElements;
    
    private final boolean canContainString;
    
    public ExpressionMode(final String name, final String commonElements, final boolean canContainString) {
      super();
      this.name = name;
      this.commonElements = commonElements;
      this.canContainString = canContainString;
    }
    
    @Override
    @Pure
    public int hashCode() {
      final int prime = 31;
      int result = 1;
      result = prime * result + ((this.name== null) ? 0 : this.name.hashCode());
      result = prime * result + ((this.commonElements== null) ? 0 : this.commonElements.hashCode());
      return prime * result + (this.canContainString ? 1231 : 1237);
    }
    
    @Override
    @Pure
    public boolean equals(final Object obj) {
      if (this == obj)
        return true;
      if (obj == null)
        return false;
      if (getClass() != obj.getClass())
        return false;
      FlexGenerator.ExpressionMode other = (FlexGenerator.ExpressionMode) obj;
      if (this.name == null) {
        if (other.name != null)
          return false;
      } else if (!this.name.equals(other.name))
        return false;
      if (this.commonElements == null) {
        if (other.commonElements != null)
          return false;
      } else if (!this.commonElements.equals(other.commonElements))
        return false;
      if (other.canContainString != this.canContainString)
        return false;
      return true;
    }
    
    @Override
    @Pure
    public String toString() {
      ToStringBuilder b = new ToStringBuilder(this);
      b.add("name", this.name);
      b.add("commonElements", this.commonElements);
      b.add("canContainString", this.canContainString);
      return b.toString();
    }
    
    @Pure
    public String getName() {
      return this.name;
    }
    
    @Pure
    public String getCommonElements() {
      return this.commonElements;
    }
    
    @Pure
    public boolean isCanContainString() {
      return this.canContainString;
    }
  }
  
  public static void main(final String[] args) {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("./src/main/java/");
      String _replace = FlexGenerator.class.getPackage().getName().replace(".", "/");
      _builder.append(_replace);
      _builder.append("/YangFlexer.flex");
      Files.write(
        new File(_builder.toString()).toPath(), 
        new FlexGenerator().generate().toString().getBytes());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  private final String predefinedRules = new Function0<String>() {
    public String apply() {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("WS=[\\ \\n\\r\\t]+");
      _builder.newLine();
      _builder.newLine();
      _builder.append("ML_COMMENT=\"/*\" ~\"*/\"");
      _builder.newLine();
      _builder.append("SL_COMMENT=\"/\"\"/\"[^\\r\\n]*(\\r?\\n)?");
      _builder.newLine();
      _builder.newLine();
      _builder.append("ID= [a-zA-Z_] [a-zA-Z0-9_\\.\\-]*");
      _builder.newLine();
      _builder.newLine();
      _builder.append("EXTENSION_NAME={ID} \":\" {ID}");
      _builder.newLine();
      _builder.newLine();
      _builder.append("STRING=[^\\ \\n\\r\\t\\{\\}\\;\\\'\\\"]+");
      _builder.newLine();
      _builder.append("SINGLE_QUOTED_STRING= \"\'\" [^\']* \"\'\"?");
      _builder.newLine();
      _builder.append("DOUBLE_QUOTED_STRING= \\\" ([^\\\\\\\"]|\\\\.)* \\\"?");
      _builder.newLine();
      _builder.append("ESCAPED_DQ_STRING= \\\\\\\" [^\\\\\\\"]* \\\\\\\"?");
      _builder.newLine();
      _builder.newLine();
      _builder.append("NUMBER= (\"+\"|\"-\")? {U_NUMBER}");
      _builder.newLine();
      _builder.append("U_NUMBER= [0-9]+ (\".\" [0-9]+)? | \".\" [0-9]+");
      _builder.newLine();
      _builder.newLine();
      _builder.append("OPERATOR= \"and\" | \"or\" | \"mod\" | \"div\" | \"*\" | \"|\" | \"+\" | \"-\" | \"=\" | \"!=\" | \"<\" | \"<=\" | \">\" | \">=\"");
      _builder.newLine();
      _builder.newLine();
      _builder.append("STRING_CONCAT= ({WS} | {ML_COMMENT} | {SL_COMMENT})* \"+\" ({WS} | {ML_COMMENT} | {SL_COMMENT})*");
      _builder.newLine();
      return _builder.toString();
    }
  }.apply();
  
  private final FlexGenerator.ExpressionMode GenericExpressionMode = new Function0<FlexGenerator.ExpressionMode>() {
    public FlexGenerator.ExpressionMode apply() {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("{OPERATOR}  { return RULE_OPERATOR; }");
      _builder.newLine();
      _builder.append("\"binary\"                {return Binary;}");
      _builder.newLine();
      _builder.append("\"bits\"                  {return Bits;}");
      _builder.newLine();
      _builder.append("\"boolean\"               {return Boolean;}");
      _builder.newLine();
      _builder.append("\"decimal64\"             {return Decimal64;}");
      _builder.newLine();
      _builder.append("\"empty\"                 {return Empty;}");
      _builder.newLine();
      _builder.append("\"enumeration\"           {return Enumeration;}");
      _builder.newLine();
      _builder.append("\"identityref\"           {return Identityref;}");
      _builder.newLine();
      _builder.append("\"instance-identifier\"   {return InstanceIdentifier;}");
      _builder.newLine();
      _builder.append("\"int8\"                  {return Int8;}");
      _builder.newLine();
      _builder.append("\"int16\"                 {return Int16;}");
      _builder.newLine();
      _builder.append("\"int32\"                 {return Int32;}");
      _builder.newLine();
      _builder.append("\"int64\"                 {return Int64;}");
      _builder.newLine();
      _builder.append("\"leafref\"               {return Leafref;}");
      _builder.newLine();
      _builder.append("\"string\"                {return String;}");
      _builder.newLine();
      _builder.append("\"uint8\"                 {return Uint8;}");
      _builder.newLine();
      _builder.append("\"uint16\"                {return Uint16;}");
      _builder.newLine();
      _builder.append("\"uint32\"                {return Uint32;}");
      _builder.newLine();
      _builder.append("\"uint64\"                {return Uint64;}");
      _builder.newLine();
      _builder.append("\"union\"                 {return Union;}");
      _builder.newLine();
      _builder.append("\"min\"                   {return Min;}");
      _builder.newLine();
      _builder.append("\"max\"                   {return Max;}");
      _builder.newLine();
      _builder.append("{ID}        { return RULE_ID; }");
      _builder.newLine();
      _builder.append("{NUMBER}    { return RULE_NUMBER; }");
      _builder.newLine();
      _builder.append("\":\"         { return Colon; }");
      _builder.newLine();
      _builder.append("\"(\"         { return LeftParenthesis; }");
      _builder.newLine();
      _builder.append("\")\"         { return RightParenthesis; }");
      _builder.newLine();
      _builder.append("\"[\"         { return LeftSquareBracket; }");
      _builder.newLine();
      _builder.append("\"]\"         { return RightSquareBracket; }");
      _builder.newLine();
      _builder.append("\".\"         { return FullStop; }");
      _builder.newLine();
      _builder.append("\"..\"        { return FullStopFullStop; }");
      _builder.newLine();
      _builder.append("\"/\"         { return Solidus; }");
      _builder.newLine();
      _builder.append("\",\"         { return Comma; }");
      _builder.newLine();
      FlexGenerator.ExpressionMode _expressionMode = new FlexGenerator.ExpressionMode("EXPRESSION", _builder.toString(), true);
      return _expressionMode;
    }
  }.apply();
  
  private final FlexGenerator.ExpressionMode XpathExpressionMode = new Function0<FlexGenerator.ExpressionMode>() {
    public FlexGenerator.ExpressionMode apply() {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("\"comment\"\t\t\t\t\t\t\t{return Comment;}");
      _builder.newLine();
      _builder.append("\"text\"\t\t\t\t\t\t\t\t{return Text;}");
      _builder.newLine();
      _builder.append("\"processing-instruction\"\t\t\t\t{return ProcessingInstruction;}");
      _builder.newLine();
      _builder.append("\"node\"\t\t\t\t\t\t\t\t{return Node;}");
      _builder.newLine();
      _builder.newLine();
      _builder.append("\"ancestor\"\t\t\t\t\t\t\t{return Ancestor;}");
      _builder.newLine();
      _builder.append("\"ancestor-or-self\"\t\t\t\t\t{return AncestorOrSelf;}");
      _builder.newLine();
      _builder.append("\"attribute\"\t\t\t\t\t\t\t{return Attribute;}");
      _builder.newLine();
      _builder.append("\"child\"\t\t\t\t\t\t\t\t{return Child;}");
      _builder.newLine();
      _builder.append("\"descendant\"\t\t\t\t\t\t\t{return Descendant;}");
      _builder.newLine();
      _builder.append("\"descendant-or-self\"\t\t\t\t\t{return DescendantOrSelf;}");
      _builder.newLine();
      _builder.append("\"following\"\t\t\t\t\t\t\t{return Following;}");
      _builder.newLine();
      _builder.append("\"following-sibling\"\t\t\t\t\t{return FollowingSibling;}");
      _builder.newLine();
      _builder.append("\"namespace\"\t\t\t\t\t\t\t{return Namespace;}");
      _builder.newLine();
      _builder.append("\"parent\"\t\t\t\t\t\t\t\t{return Parent;}");
      _builder.newLine();
      _builder.append("\"preceding\"\t\t\t\t\t\t\t{return Preceding;}");
      _builder.newLine();
      _builder.append("\"preceding-sibling\"\t\t\t\t\t{return PrecedingSibling;}");
      _builder.newLine();
      _builder.append("\"self\"\t\t\t\t\t\t\t\t{return Self;}");
      _builder.newLine();
      _builder.newLine();
      _builder.append("\"or\" \t\t\t\t\t\t\t\t{return Or;}");
      _builder.newLine();
      _builder.append("\"and\"\t\t\t\t\t\t\t\t{return And;}");
      _builder.newLine();
      _builder.append("\"div\"\t\t\t\t\t\t\t\t{return Div;}");
      _builder.newLine();
      _builder.append("\"mod\"\t\t\t\t\t\t\t\t{return Mod;}");
      _builder.newLine();
      _builder.newLine();
      _builder.append("{ID}\t\t\t\t\t\t\t\t\t{ return RULE_ID; }");
      _builder.newLine();
      _builder.append("{U_NUMBER}\t\t\t\t\t\t\t\t{ return RULE_NUMBER; }");
      _builder.newLine();
      _builder.newLine();
      _builder.append("\"=\"         { return EqualsSign; }");
      _builder.newLine();
      _builder.append("\"!=\"\t        { return ExclamationMarkEqualsSign; }");
      _builder.newLine();
      _builder.append("\"<\"         { return LessThanSign; }");
      _builder.newLine();
      _builder.append("\">\"         { return GreaterThanSign; }");
      _builder.newLine();
      _builder.append("\"<=\"\t        { return LessThanSignEqualsSign; }");
      _builder.newLine();
      _builder.append("\">=\"        { return GreaterThanSignEqualsSign; }");
      _builder.newLine();
      _builder.append("\"+\"         { return PlusSign; }");
      _builder.newLine();
      _builder.append("\"-\"         { return HyphenMinus; }");
      _builder.newLine();
      _builder.append("\"*\"         { return Asterisk; }");
      _builder.newLine();
      _builder.append("\"$\"         { return DollarSign; }");
      _builder.newLine();
      _builder.append("\"|\"         { return VerticalLine; }");
      _builder.newLine();
      _builder.append("\"@\"         { return CommercialAt; }");
      _builder.newLine();
      _builder.newLine();
      _builder.append("\":\"         { return Colon; }");
      _builder.newLine();
      _builder.append("\"(\"         { return LeftParenthesis; }");
      _builder.newLine();
      _builder.append("\")\"         { return RightParenthesis; }");
      _builder.newLine();
      _builder.append("\"[\"         { return LeftSquareBracket; }");
      _builder.newLine();
      _builder.append("\"]\"         { return RightSquareBracket; }");
      _builder.newLine();
      _builder.append("\".\"         { return FullStop; }");
      _builder.newLine();
      _builder.append("\"..\"        { return FullStopFullStop; }");
      _builder.newLine();
      _builder.append("\"/\"         { return Solidus; }");
      _builder.newLine();
      _builder.append("\",\"         { return Comma; }");
      _builder.newLine();
      FlexGenerator.ExpressionMode _expressionMode = new FlexGenerator.ExpressionMode("XPATH_EXPRESSION", _builder.toString(), true);
      return _expressionMode;
    }
  }.apply();
  
  private final FlexGenerator.ExpressionMode RefinementMode = new Function0<FlexGenerator.ExpressionMode>() {
    public FlexGenerator.ExpressionMode apply() {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("{NUMBER}    { return RULE_NUMBER; }");
      _builder.newLine();
      _builder.append("\"|\"  \t    { return VerticalLine; }");
      _builder.newLine();
      _builder.append("\"min\"       { return Min;}");
      _builder.newLine();
      _builder.append("\"max\"       { return Max;}");
      _builder.newLine();
      _builder.append("\"..\"        { return FullStopFullStop; }");
      _builder.newLine();
      FlexGenerator.ExpressionMode _expressionMode = new FlexGenerator.ExpressionMode("REFINEMENT_EXPRESSION", _builder.toString(), false);
      return _expressionMode;
    }
  }.apply();
  
  private final FlexGenerator.ExpressionMode IfFeatureMode = new Function0<FlexGenerator.ExpressionMode>() {
    public FlexGenerator.ExpressionMode apply() {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("\":\"        { return Colon; }");
      _builder.newLine();
      _builder.append("\"or\"  \t   { return Or; }");
      _builder.newLine();
      _builder.append("\"and\"      { return And; }");
      _builder.newLine();
      _builder.append("\"not\"      { return Not; }");
      _builder.newLine();
      _builder.append("{ID}    \t   { return RULE_ID; }");
      _builder.newLine();
      _builder.append("\"(\"        { return LeftParenthesis; }");
      _builder.newLine();
      _builder.append("\")\"        { return RightParenthesis; }");
      _builder.newLine();
      FlexGenerator.ExpressionMode _expressionMode = new FlexGenerator.ExpressionMode("IF_FEATURE_EXPRESSION", _builder.toString(), false);
      return _expressionMode;
    }
  }.apply();
  
  private final List<FlexGenerator.ExpressionMode> allModes = Collections.<FlexGenerator.ExpressionMode>unmodifiableList(CollectionLiterals.<FlexGenerator.ExpressionMode>newArrayList(this.GenericExpressionMode, this.XpathExpressionMode, this.RefinementMode, this.IfFeatureMode));
  
  private final String statements = new Function0<String>() {
    public String apply() {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("\"action\"                  {yybegin(BLACK_BOX_STRING); return Action; }");
      _builder.newLine();
      _builder.append("\"anydata\"                 {yybegin(BLACK_BOX_STRING); return Anydata; }");
      _builder.newLine();
      _builder.append("\"anyxml\"                  {yybegin(BLACK_BOX_STRING); return Anyxml; }");
      _builder.newLine();
      _builder.append("\"argument\"                {yybegin(BLACK_BOX_STRING); return Argument; }");
      _builder.newLine();
      _builder.append("\"augment\"                 {yybegin(");
      _builder.append(FlexGenerator.this.GenericExpressionMode.name);
      _builder.append("); return Augment; }");
      _builder.newLineIfNotEmpty();
      _builder.append("\"base\"                    {yybegin(");
      _builder.append(FlexGenerator.this.GenericExpressionMode.name);
      _builder.append("); return Base; }");
      _builder.newLineIfNotEmpty();
      _builder.append("\"belongs-to\"              {yybegin(BLACK_BOX_STRING); return BelongsTo; }");
      _builder.newLine();
      _builder.append("\"bit\"                     {yybegin(BLACK_BOX_STRING); return Bit; }");
      _builder.newLine();
      _builder.append("\"case\"                    {yybegin(BLACK_BOX_STRING); return Case; }");
      _builder.newLine();
      _builder.append("\"choice\"                  {yybegin(BLACK_BOX_STRING); return Choice; }");
      _builder.newLine();
      _builder.append("\"config\"                  {yybegin(BLACK_BOX_STRING); return Config; }");
      _builder.newLine();
      _builder.append("\"contact\"                 {yybegin(BLACK_BOX_STRING); return Contact; }");
      _builder.newLine();
      _builder.append("\"container\"               {yybegin(BLACK_BOX_STRING); return Container; }");
      _builder.newLine();
      _builder.append(" ");
      _builder.append("\"default\"                {yybegin(BLACK_BOX_STRING); return Default; }");
      _builder.newLine();
      _builder.append(" ");
      _builder.append("\"description\"            {yybegin(BLACK_BOX_STRING); return Description; }");
      _builder.newLine();
      _builder.append(" ");
      _builder.append("\"enum\"                   {yybegin(BLACK_BOX_STRING); return Enum; }");
      _builder.newLine();
      _builder.append(" ");
      _builder.append("\"error-app-tag\"          {yybegin(BLACK_BOX_STRING); return ErrorAppTag; }");
      _builder.newLine();
      _builder.append(" ");
      _builder.append("\"error-message\"          {yybegin(BLACK_BOX_STRING); return ErrorMessage; }");
      _builder.newLine();
      _builder.append(" ");
      _builder.append("\"extension\"              {yybegin(BLACK_BOX_STRING); return Extension; }");
      _builder.newLine();
      _builder.append(" ");
      _builder.append("\"deviation\"              {yybegin(");
      _builder.append(FlexGenerator.this.GenericExpressionMode.name, " ");
      _builder.append("); return Deviation; }");
      _builder.newLineIfNotEmpty();
      _builder.append(" ");
      _builder.append("\"deviate\"                {yybegin(BLACK_BOX_STRING); return Deviate; }");
      _builder.newLine();
      _builder.append(" ");
      _builder.append("\"feature\"                {yybegin(BLACK_BOX_STRING); return Feature; }");
      _builder.newLine();
      _builder.append(" ");
      _builder.append("\"fraction-digits\"        {yybegin(BLACK_BOX_STRING); return FractionDigits; }");
      _builder.newLine();
      _builder.append(" ");
      _builder.append("\"grouping\"               {yybegin(BLACK_BOX_STRING); return Grouping; }");
      _builder.newLine();
      _builder.append(" ");
      _builder.append("\"identity\"               {yybegin(BLACK_BOX_STRING); return Identity; }");
      _builder.newLine();
      _builder.append(" ");
      _builder.append("\"if-feature\"             {yybegin(");
      _builder.append(FlexGenerator.this.IfFeatureMode.name, " ");
      _builder.append("); return IfFeature; }");
      _builder.newLineIfNotEmpty();
      _builder.append(" ");
      _builder.append("\"import\"                 {yybegin(BLACK_BOX_STRING); return Import; }");
      _builder.newLine();
      _builder.append(" ");
      _builder.append("\"include\"                {yybegin(BLACK_BOX_STRING); return Include; }");
      _builder.newLine();
      _builder.append(" ");
      _builder.append("\"input\"                  {yybegin(BLACK_BOX_STRING); return Input; }");
      _builder.newLine();
      _builder.append(" ");
      _builder.append("\"key\"                    {yybegin(");
      _builder.append(FlexGenerator.this.GenericExpressionMode.name, " ");
      _builder.append("); return Key; }");
      _builder.newLineIfNotEmpty();
      _builder.append(" ");
      _builder.append("\"leaf\"                   {yybegin(BLACK_BOX_STRING); return Leaf; }");
      _builder.newLine();
      _builder.append(" ");
      _builder.append("\"leaf-list\"              {yybegin(BLACK_BOX_STRING); return LeafList; }");
      _builder.newLine();
      _builder.append(" ");
      _builder.append("\"length\"                 {yybegin(");
      _builder.append(FlexGenerator.this.RefinementMode.name, " ");
      _builder.append("); return Length; }");
      _builder.newLineIfNotEmpty();
      _builder.append(" ");
      _builder.append("\"list\"                   {yybegin(BLACK_BOX_STRING); return List; }");
      _builder.newLine();
      _builder.append(" ");
      _builder.append("\"mandatory\"              {yybegin(BLACK_BOX_STRING); return Mandatory; }");
      _builder.newLine();
      _builder.append(" ");
      _builder.append("\"max-elements\"           {yybegin(BLACK_BOX_STRING); return MaxElements; }");
      _builder.newLine();
      _builder.append(" ");
      _builder.append("\"min-elements\"           {yybegin(BLACK_BOX_STRING); return MinElements; }");
      _builder.newLine();
      _builder.append(" ");
      _builder.append("\"modifier\"               {yybegin(BLACK_BOX_STRING); return Modifier; }");
      _builder.newLine();
      _builder.append(" ");
      _builder.append("\"module\"                 {yybegin(BLACK_BOX_STRING); return Module; }");
      _builder.newLine();
      _builder.append(" ");
      _builder.append("\"must\"                   {yybegin(");
      _builder.append(FlexGenerator.this.XpathExpressionMode.name, " ");
      _builder.append("); return Must; }");
      _builder.newLineIfNotEmpty();
      _builder.append(" ");
      _builder.append("\"namespace\"              {yybegin(BLACK_BOX_STRING); return Namespace; }");
      _builder.newLine();
      _builder.append(" ");
      _builder.append("\"notification\"           {yybegin(BLACK_BOX_STRING); return Notification; }");
      _builder.newLine();
      _builder.append(" ");
      _builder.append("\"ordered-by\"             {yybegin(BLACK_BOX_STRING); return OrderedBy; }");
      _builder.newLine();
      _builder.append(" ");
      _builder.append("\"organization\"           {yybegin(BLACK_BOX_STRING); return Organization; }");
      _builder.newLine();
      _builder.append(" ");
      _builder.append("\"output\"                 {yybegin(BLACK_BOX_STRING); return Output; }");
      _builder.newLine();
      _builder.append(" ");
      _builder.append("\"path\"                   {yybegin(");
      _builder.append(FlexGenerator.this.XpathExpressionMode.name, " ");
      _builder.append("); return Path; }");
      _builder.newLineIfNotEmpty();
      _builder.append(" ");
      _builder.append("\"pattern\"                {yybegin(BLACK_BOX_STRING); return Pattern; }");
      _builder.newLine();
      _builder.append(" ");
      _builder.append("\"position\"               {yybegin(BLACK_BOX_STRING); return Position; }");
      _builder.newLine();
      _builder.append(" ");
      _builder.append("\"prefix\"                 {yybegin(BLACK_BOX_STRING); return Prefix; }");
      _builder.newLine();
      _builder.append(" ");
      _builder.append("\"presence\"               {yybegin(BLACK_BOX_STRING); return Presence; }");
      _builder.newLine();
      _builder.append(" ");
      _builder.append("\"range\"                  {yybegin(");
      _builder.append(FlexGenerator.this.RefinementMode.name, " ");
      _builder.append("); return Range; }");
      _builder.newLineIfNotEmpty();
      _builder.append(" ");
      _builder.append("\"reference\"              {yybegin(BLACK_BOX_STRING); return Reference; }");
      _builder.newLine();
      _builder.append(" ");
      _builder.append("\"refine\"                 {yybegin(");
      _builder.append(FlexGenerator.this.GenericExpressionMode.name, " ");
      _builder.append("); return Refine; }");
      _builder.newLineIfNotEmpty();
      _builder.append(" ");
      _builder.append("\"require-instance\"       {yybegin(BLACK_BOX_STRING); return RequireInstance; }");
      _builder.newLine();
      _builder.append(" ");
      _builder.append("\"revision\"               {yybegin(BLACK_BOX_STRING); return Revision; }");
      _builder.newLine();
      _builder.append(" ");
      _builder.append("\"revision-date\"          {yybegin(BLACK_BOX_STRING); return RevisionDate; }");
      _builder.newLine();
      _builder.append(" ");
      _builder.append("\"rpc\"                    {yybegin(BLACK_BOX_STRING); return Rpc; }");
      _builder.newLine();
      _builder.append(" ");
      _builder.append("\"status\"                 {yybegin(BLACK_BOX_STRING); return Status; }");
      _builder.newLine();
      _builder.append(" ");
      _builder.append("\"submodule\"              {yybegin(BLACK_BOX_STRING); return Submodule; }");
      _builder.newLine();
      _builder.append(" ");
      _builder.append("\"type\"                   {yybegin(");
      _builder.append(FlexGenerator.this.GenericExpressionMode.name, " ");
      _builder.append("); return Type; }");
      _builder.newLineIfNotEmpty();
      _builder.append(" ");
      _builder.append("\"typedef\"                {yybegin(BLACK_BOX_STRING); return Typedef; }");
      _builder.newLine();
      _builder.append(" ");
      _builder.append("\"unique\"                 {yybegin(");
      _builder.append(FlexGenerator.this.GenericExpressionMode.name, " ");
      _builder.append("); return Unique; }");
      _builder.newLineIfNotEmpty();
      _builder.append(" ");
      _builder.append("\"units\"                  {yybegin(BLACK_BOX_STRING); return Units; }");
      _builder.newLine();
      _builder.append(" ");
      _builder.append("\"uses\"                   {yybegin(");
      _builder.append(FlexGenerator.this.GenericExpressionMode.name, " ");
      _builder.append("); return Uses; }");
      _builder.newLineIfNotEmpty();
      _builder.append(" ");
      _builder.append("\"value\"                  {yybegin(BLACK_BOX_STRING); return Value; }");
      _builder.newLine();
      _builder.append(" ");
      _builder.append("\"when\"                   {yybegin(");
      _builder.append(FlexGenerator.this.XpathExpressionMode.name, " ");
      _builder.append("); return When; }");
      _builder.newLineIfNotEmpty();
      _builder.append(" ");
      _builder.append("\"yang-version\"           {yybegin(BLACK_BOX_STRING); return YangVersion; }");
      _builder.newLine();
      _builder.append(" ");
      _builder.append("\"yin-element\"            {yybegin(BLACK_BOX_STRING); return YinElement; }");
      _builder.newLine();
      return _builder.toString();
    }
  }.apply();
  
  public CharSequence generateExpressionMode(final FlexGenerator.ExpressionMode mode) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("<");
    _builder.append(mode.name);
    _builder.append("> {");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("{ML_COMMENT} { return RULE_ML_COMMENT; }");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("{SL_COMMENT} { return RULE_SL_COMMENT; }");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("\\\"          {yybegin(IN_");
    _builder.append(mode.name, "\t");
    _builder.append("_STRING); return RULE_HIDDEN;}");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("\"\'\"         {yybegin(IN_SQ_");
    _builder.append(mode.name, "\t");
    _builder.append("_STRING); return RULE_HIDDEN;}");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append(mode.commonElements, "\t");
    _builder.newLineIfNotEmpty();
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("<IN_");
    _builder.append(mode.name);
    _builder.append("_STRING> {");
    _builder.newLineIfNotEmpty();
    {
      if (mode.canContainString) {
        _builder.append("\t");
        _builder.append("{SINGLE_QUOTED_STRING} { return RULE_STRING; }");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("{ESCAPED_DQ_STRING}    { return RULE_STRING; }");
        _builder.newLine();
      }
    }
    _builder.append("\t");
    _builder.append(mode.commonElements, "\t");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("\\\" {STRING_CONCAT} { yybegin(");
    _builder.append(mode.name, "\t");
    _builder.append("); return RULE_HIDDEN; }");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("\\\"                 { yybegin(YYINITIAL); return RULE_HIDDEN; }");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("<IN_SQ_");
    _builder.append(mode.name);
    _builder.append("_STRING> {");
    _builder.newLineIfNotEmpty();
    {
      if (mode.canContainString) {
        _builder.append("\t");
        _builder.append("{DOUBLE_QUOTED_STRING}    { return RULE_STRING; }");
        _builder.newLine();
      }
    }
    _builder.append("\t");
    _builder.append(mode.commonElements, "\t");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("\"\'\" {STRING_CONCAT} { yybegin(");
    _builder.append(mode.name, "\t");
    _builder.append("); return RULE_HIDDEN; }");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("\"\'\"                 { yybegin(YYINITIAL); return RULE_HIDDEN; }");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    return _builder;
  }
  
  public CharSequence generate() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("/*");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("* generated by Xtext 2.13.0-SNAPSHOT");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("*/");
    _builder.newLine();
    _builder.append("package io.typefox.yang.parser.antlr.lexer.jflex;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("import java.io.Reader;");
    _builder.newLine();
    _builder.append("import java.io.IOException;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("import org.antlr.runtime.Token;");
    _builder.newLine();
    _builder.append("import org.antlr.runtime.CommonToken;");
    _builder.newLine();
    _builder.append("import org.antlr.runtime.TokenSource;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("import static io.typefox.yang.parser.antlr.internal.InternalYangParser.*;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("@SuppressWarnings({\"all\"})");
    _builder.newLine();
    _builder.append("%%");
    _builder.newLine();
    _builder.newLine();
    _builder.append("%{");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("public final static TokenSource createTokenSource(Reader reader) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("return new YangFlexer(reader);");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("private int offset = 0;");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("public void reset(Reader reader) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("yyreset(reader);");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("offset = 0;");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("@Override");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("public Token nextToken() {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("try {");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("int type = advance();");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("if (type == Token.EOF) {");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("return Token.EOF_TOKEN;");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("int length = yylength();");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("final String tokenText = yytext();");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("CommonToken result = new CommonTokenWithText(tokenText, type, Token.DEFAULT_CHANNEL, offset);");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("offset += length;");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("return result;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("} catch (IOException e) {");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("throw new RuntimeException(e);");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("@Override");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("public String getSourceName() {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("return \"FlexTokenSource\";");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("public static class CommonTokenWithText extends CommonToken {");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("private static final long serialVersionUID = 1L;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("public CommonTokenWithText(String tokenText, int type, int defaultChannel, int offset) {");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("super(null, type, defaultChannel, offset, offset + tokenText.length() - 1);");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("this.text = tokenText;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("%}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("%unicode");
    _builder.newLine();
    _builder.append("%implements org.antlr.runtime.TokenSource");
    _builder.newLine();
    _builder.append("%class YangFlexer");
    _builder.newLine();
    _builder.append("%function advance");
    _builder.newLine();
    _builder.append("%public");
    _builder.newLine();
    _builder.append("%int");
    _builder.newLine();
    _builder.append("%eofval{");
    _builder.newLine();
    _builder.append("return Token.EOF;");
    _builder.newLine();
    _builder.append("%eofval}");
    _builder.newLine();
    _builder.newLine();
    _builder.append(this.predefinedRules);
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    {
      for(final FlexGenerator.ExpressionMode m : this.allModes) {
        _builder.append("%s ");
        _builder.append(m.name);
        _builder.append(", IN_");
        _builder.append(m.name);
        _builder.append("_STRING, IN_SQ_");
        _builder.append(m.name);
        _builder.append("_STRING");
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.append("%s BLACK_BOX_STRING, BLACK_BOX_STRING_CONCAT");
    _builder.newLine();
    _builder.newLine();
    _builder.append("%%");
    _builder.newLine();
    _builder.newLine();
    _builder.append("<BLACK_BOX_STRING> {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("{STRING} { return RULE_STRING; }\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("{SINGLE_QUOTED_STRING} { yybegin(BLACK_BOX_STRING_CONCAT); return RULE_STRING; }");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("{DOUBLE_QUOTED_STRING} { yybegin(BLACK_BOX_STRING_CONCAT); return RULE_STRING; }");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("{ML_COMMENT} { return RULE_ML_COMMENT; }");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("{SL_COMMENT} { return RULE_SL_COMMENT; }");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("<BLACK_BOX_STRING_CONCAT> {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("\"+\" { return RULE_HIDDEN;}");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("{SINGLE_QUOTED_STRING} { return RULE_STRING; }");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("{DOUBLE_QUOTED_STRING} { return RULE_STRING; }");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("{ML_COMMENT} { return RULE_ML_COMMENT; }");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("{SL_COMMENT} { return RULE_SL_COMMENT; }");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    {
      for(final FlexGenerator.ExpressionMode mode : this.allModes) {
        CharSequence _generateExpressionMode = this.generateExpressionMode(mode);
        _builder.append(_generateExpressionMode);
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.newLine();
    _builder.append("<YYINITIAL> {");
    _builder.newLine();
    _builder.append(this.statements);
    _builder.newLineIfNotEmpty();
    _builder.append(" ");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("{EXTENSION_NAME}          { yybegin(BLACK_BOX_STRING);  return RULE_EXTENSION_NAME; }");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("{ID}                      {                             return RULE_ID; }");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("{ML_COMMENT} { return RULE_ML_COMMENT; }");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("{SL_COMMENT} { return RULE_SL_COMMENT; }");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.append("\\; { yybegin(YYINITIAL); return Semicolon; }");
    _builder.newLine();
    _builder.append("\\{ { yybegin(YYINITIAL); return LeftCurlyBracket; }");
    _builder.newLine();
    _builder.append("\\} { yybegin(YYINITIAL); return RightCurlyBracket; }");
    _builder.newLine();
    _builder.append("{WS} { return RULE_WS; }");
    _builder.newLine();
    _builder.append(". { return RULE_ANY_OTHER; }");
    _builder.newLine();
    _builder.newLine();
    return _builder;
  }
}

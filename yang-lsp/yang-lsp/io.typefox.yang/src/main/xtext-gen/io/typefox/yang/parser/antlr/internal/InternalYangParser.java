package io.typefox.yang.parser.antlr.internal;

import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.AbstractInternalAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.parser.antlr.AntlrDatatypeRuleToken;
import io.typefox.yang.services.YangGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
@SuppressWarnings("all")
public class InternalYangParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "ProcessingInstruction", "InstanceIdentifier", "DescendantOrSelf", "FollowingSibling", "PrecedingSibling", "AncestorOrSelf", "RequireInstance", "FractionDigits", "ErrorAppTag", "ErrorMessage", "NotSupported", "RevisionDate", "MaxElements", "MinElements", "Notification", "Organization", "YangVersion", "Description", "Enumeration", "Identityref", "YinElement", "BelongsTo", "Deprecated", "Descendant", "IfFeature", "OrderedBy", "Attribute", "Container", "Decimal64", "Deviation", "Extension", "Following", "LeafList", "Mandatory", "Namespace", "Preceding", "Reference", "Submodule", "Unbounded", "Ancestor", "Argument", "Grouping", "Identity", "Modifier", "Obsolete", "Position", "Presence", "Revision", "Anydata", "Augment", "Boolean", "Comment", "Contact", "Current", "Default", "Deviate", "Feature", "Include", "Leafref", "Pattern", "Replace", "Typedef", "Action", "Anyxml", "Binary", "Choice", "Config", "Delete", "Import", "Length", "Module", "Output", "Parent", "Prefix", "Refine", "Status", "String", "KW_System", "Uint16", "Uint32", "Uint64", "Unique", "Child", "Empty", "False", "Input", "Int16", "Int32", "Int64", "Range", "Uint8", "Union", "Units", "Value", "LessThanSignLessThanSignLessThanSignLessThanSign", "GreaterThanSignGreaterThanSignGreaterThanSignGreaterThanSign", "Base", "Bits", "Case", "Enum", "Int8", "Leaf", "List", "Must", "Node", "Path", "Self", "Text", "True", "Type", "User", "Uses", "When", "Add", "And", "Bit", "Div", "Key", "Max", "Min", "Mod", "Not", "Rpc", "ExclamationMarkEqualsSign", "FullStopFullStop", "LessThanSignEqualsSign", "GreaterThanSignEqualsSign", "Or", "DollarSign", "LeftParenthesis", "RightParenthesis", "Asterisk", "PlusSign", "Comma", "HyphenMinus", "FullStop", "Solidus", "Colon", "Semicolon", "LessThanSign", "EqualsSign", "GreaterThanSign", "CommercialAt", "LeftSquareBracket", "RightSquareBracket", "LeftCurlyBracket", "VerticalLine", "RightCurlyBracket", "RULE_ID", "RULE_EXTENSION_NAME", "RULE_STRING", "RULE_NUMBER", "RULE_OPERATOR", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_HIDDEN", "RULE_ANY_OTHER"
    };
    public static final int Delete=71;
    public static final int Enum=103;
    public static final int FractionDigits=11;
    public static final int Import=72;
    public static final int Or=131;
    public static final int KW_System=81;
    public static final int Node=108;
    public static final int Submodule=41;
    public static final int String=80;
    public static final int False=88;
    public static final int Int16=90;
    public static final int Feature=60;
    public static final int Must=107;
    public static final int LessThanSign=143;
    public static final int LeftParenthesis=133;
    public static final int Uint16=82;
    public static final int InstanceIdentifier=5;
    public static final int Identity=46;
    public static final int Boolean=54;
    public static final int Child=86;
    public static final int Status=79;
    public static final int Refine=78;
    public static final int Uint8=94;
    public static final int GreaterThanSign=145;
    public static final int RULE_ID=152;
    public static final int Position=49;
    public static final int Grouping=45;
    public static final int Namespace=38;
    public static final int GreaterThanSignEqualsSign=130;
    public static final int YangVersion=20;
    public static final int Min=123;
    public static final int Typedef=65;
    public static final int VerticalLine=150;
    public static final int Identityref=23;
    public static final int PlusSign=136;
    public static final int RULE_ML_COMMENT=157;
    public static final int Bits=101;
    public static final int LeftSquareBracket=147;
    public static final int Module=74;
    public static final int Ancestor=43;
    public static final int Current=57;
    public static final int GreaterThanSignGreaterThanSignGreaterThanSignGreaterThanSign=99;
    public static final int ProcessingInstruction=4;
    public static final int Key=121;
    public static final int Organization=19;
    public static final int Description=21;
    public static final int Attribute=30;
    public static final int Max=122;
    public static final int Prefix=77;
    public static final int Self=110;
    public static final int AncestorOrSelf=9;
    public static final int Notification=18;
    public static final int Union=95;
    public static final int Case=102;
    public static final int Comma=137;
    public static final int HyphenMinus=138;
    public static final int Deprecated=26;
    public static final int Descendant=27;
    public static final int Int32=91;
    public static final int MaxElements=16;
    public static final int Output=75;
    public static final int Leaf=105;
    public static final int RULE_HIDDEN=160;
    public static final int LessThanSignEqualsSign=129;
    public static final int Solidus=140;
    public static final int RightCurlyBracket=151;
    public static final int Uint32=83;
    public static final int RULE_OPERATOR=156;
    public static final int Path=109;
    public static final int Pattern=63;
    public static final int FullStop=139;
    public static final int Enumeration=22;
    public static final int Reference=40;
    public static final int Following=35;
    public static final int Text=111;
    public static final int Int8=104;
    public static final int Default=58;
    public static final int Unbounded=42;
    public static final int Leafref=62;
    public static final int CommercialAt=146;
    public static final int Div=120;
    public static final int Semicolon=142;
    public static final int RevisionDate=15;
    public static final int Type=113;
    public static final int When=116;
    public static final int Anydata=52;
    public static final int RULE_EXTENSION_NAME=153;
    public static final int Length=73;
    public static final int ExclamationMarkEqualsSign=127;
    public static final int ErrorMessage=13;
    public static final int Add=117;
    public static final int Choice=69;
    public static final int ErrorAppTag=12;
    public static final int Include=61;
    public static final int True=112;
    public static final int Augment=53;
    public static final int Preceding=39;
    public static final int Container=31;
    public static final int Obsolete=48;
    public static final int Input=89;
    public static final int FullStopFullStop=128;
    public static final int List=106;
    public static final int RightSquareBracket=148;
    public static final int OrderedBy=29;
    public static final int YinElement=24;
    public static final int RightParenthesis=134;
    public static final int LessThanSignLessThanSignLessThanSignLessThanSign=98;
    public static final int DescendantOrSelf=6;
    public static final int FollowingSibling=7;
    public static final int Range=93;
    public static final int Units=96;
    public static final int Not=125;
    public static final int Revision=51;
    public static final int And=118;
    public static final int Value=97;
    public static final int Unique=85;
    public static final int RequireInstance=10;
    public static final int Binary=68;
    public static final int Deviation=33;
    public static final int Mandatory=37;
    public static final int Uint64=84;
    public static final int Action=66;
    public static final int User=114;
    public static final int Argument=44;
    public static final int Uses=115;
    public static final int Rpc=126;
    public static final int Parent=76;
    public static final int Config=70;
    public static final int Decimal64=32;
    public static final int LeafList=36;
    public static final int RULE_STRING=154;
    public static final int BelongsTo=25;
    public static final int Deviate=59;
    public static final int RULE_SL_COMMENT=158;
    public static final int EqualsSign=144;
    public static final int Empty=87;
    public static final int Presence=50;
    public static final int Colon=141;
    public static final int EOF=-1;
    public static final int Modifier=47;
    public static final int Asterisk=135;
    public static final int Comment=55;
    public static final int Replace=64;
    public static final int Mod=124;
    public static final int MinElements=17;
    public static final int RULE_WS=159;
    public static final int LeftCurlyBracket=149;
    public static final int RULE_ANY_OTHER=161;
    public static final int Bit=119;
    public static final int RULE_NUMBER=155;
    public static final int NotSupported=14;
    public static final int Base=100;
    public static final int IfFeature=28;
    public static final int Contact=56;
    public static final int Extension=34;
    public static final int PrecedingSibling=8;
    public static final int Int64=92;
    public static final int DollarSign=132;
    public static final int Anyxml=67;

    // delegates
    // delegators


        public InternalYangParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalYangParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalYangParser.tokenNames; }
    public String getGrammarFileName() { return "InternalYangParser.g"; }



     	private YangGrammarAccess grammarAccess;

        public InternalYangParser(TokenStream input, YangGrammarAccess grammarAccess) {
            this(input);
            this.grammarAccess = grammarAccess;
            registerRules(grammarAccess.getGrammar());
        }

        @Override
        protected String getFirstRuleName() {
        	return "AbstractModule";
       	}

       	@Override
       	protected YangGrammarAccess getGrammarAccess() {
       		return grammarAccess;
       	}




    // $ANTLR start "entryRuleAbstractModule"
    // InternalYangParser.g:57:1: entryRuleAbstractModule returns [EObject current=null] : iv_ruleAbstractModule= ruleAbstractModule EOF ;
    public final EObject entryRuleAbstractModule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAbstractModule = null;


        try {
            // InternalYangParser.g:57:55: (iv_ruleAbstractModule= ruleAbstractModule EOF )
            // InternalYangParser.g:58:2: iv_ruleAbstractModule= ruleAbstractModule EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getAbstractModuleRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleAbstractModule=ruleAbstractModule();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleAbstractModule; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleAbstractModule"


    // $ANTLR start "ruleAbstractModule"
    // InternalYangParser.g:64:1: ruleAbstractModule returns [EObject current=null] : (this_Module_0= ruleModule | this_Submodule_1= ruleSubmodule ) ;
    public final EObject ruleAbstractModule() throws RecognitionException {
        EObject current = null;

        EObject this_Module_0 = null;

        EObject this_Submodule_1 = null;



        	enterRule();

        try {
            // InternalYangParser.g:70:2: ( (this_Module_0= ruleModule | this_Submodule_1= ruleSubmodule ) )
            // InternalYangParser.g:71:2: (this_Module_0= ruleModule | this_Submodule_1= ruleSubmodule )
            {
            // InternalYangParser.g:71:2: (this_Module_0= ruleModule | this_Submodule_1= ruleSubmodule )
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( (LA1_0==Module) ) {
                alt1=1;
            }
            else if ( (LA1_0==Submodule) ) {
                alt1=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 1, 0, input);

                throw nvae;
            }
            switch (alt1) {
                case 1 :
                    // InternalYangParser.g:72:3: this_Module_0= ruleModule
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getAbstractModuleAccess().getModuleParserRuleCall_0());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_Module_0=ruleModule();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_Module_0;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 2 :
                    // InternalYangParser.g:81:3: this_Submodule_1= ruleSubmodule
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getAbstractModuleAccess().getSubmoduleParserRuleCall_1());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_Submodule_1=ruleSubmodule();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_Submodule_1;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleAbstractModule"


    // $ANTLR start "ruleStatementEnd"
    // InternalYangParser.g:94:1: ruleStatementEnd[EObject in_current] returns [EObject current=in_current] : ( (otherlv_0= LeftCurlyBracket ( (lv_substatements_1_0= ruleStatement ) )* otherlv_2= RightCurlyBracket ) | otherlv_3= Semicolon ) ;
    public final EObject ruleStatementEnd(EObject in_current) throws RecognitionException {
        EObject current = in_current;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        EObject lv_substatements_1_0 = null;



        	enterRule();

        try {
            // InternalYangParser.g:100:2: ( ( (otherlv_0= LeftCurlyBracket ( (lv_substatements_1_0= ruleStatement ) )* otherlv_2= RightCurlyBracket ) | otherlv_3= Semicolon ) )
            // InternalYangParser.g:101:2: ( (otherlv_0= LeftCurlyBracket ( (lv_substatements_1_0= ruleStatement ) )* otherlv_2= RightCurlyBracket ) | otherlv_3= Semicolon )
            {
            // InternalYangParser.g:101:2: ( (otherlv_0= LeftCurlyBracket ( (lv_substatements_1_0= ruleStatement ) )* otherlv_2= RightCurlyBracket ) | otherlv_3= Semicolon )
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==LeftCurlyBracket) ) {
                alt3=1;
            }
            else if ( (LA3_0==Semicolon) ) {
                alt3=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 3, 0, input);

                throw nvae;
            }
            switch (alt3) {
                case 1 :
                    // InternalYangParser.g:102:3: (otherlv_0= LeftCurlyBracket ( (lv_substatements_1_0= ruleStatement ) )* otherlv_2= RightCurlyBracket )
                    {
                    // InternalYangParser.g:102:3: (otherlv_0= LeftCurlyBracket ( (lv_substatements_1_0= ruleStatement ) )* otherlv_2= RightCurlyBracket )
                    // InternalYangParser.g:103:4: otherlv_0= LeftCurlyBracket ( (lv_substatements_1_0= ruleStatement ) )* otherlv_2= RightCurlyBracket
                    {
                    otherlv_0=(Token)match(input,LeftCurlyBracket,FOLLOW_3); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_0, grammarAccess.getStatementEndAccess().getLeftCurlyBracketKeyword_0_0());
                      			
                    }
                    // InternalYangParser.g:107:4: ( (lv_substatements_1_0= ruleStatement ) )*
                    loop2:
                    do {
                        int alt2=2;
                        int LA2_0 = input.LA(1);

                        if ( ((LA2_0>=RequireInstance && LA2_0<=ErrorMessage)||(LA2_0>=RevisionDate && LA2_0<=Description)||(LA2_0>=YinElement && LA2_0<=BelongsTo)||(LA2_0>=IfFeature && LA2_0<=OrderedBy)||LA2_0==Container||(LA2_0>=Deviation && LA2_0<=Extension)||(LA2_0>=LeafList && LA2_0<=Namespace)||(LA2_0>=Reference && LA2_0<=Submodule)||(LA2_0>=Argument && LA2_0<=Modifier)||(LA2_0>=Position && LA2_0<=Augment)||LA2_0==Contact||(LA2_0>=Default && LA2_0<=Include)||LA2_0==Pattern||(LA2_0>=Typedef && LA2_0<=Anyxml)||(LA2_0>=Choice && LA2_0<=Config)||(LA2_0>=Import && LA2_0<=Output)||(LA2_0>=Prefix && LA2_0<=Status)||LA2_0==Unique||LA2_0==Input||LA2_0==Range||(LA2_0>=Units && LA2_0<=Value)||LA2_0==Base||(LA2_0>=Case && LA2_0<=Enum)||(LA2_0>=Leaf && LA2_0<=Must)||LA2_0==Path||LA2_0==Type||(LA2_0>=Uses && LA2_0<=When)||LA2_0==Bit||LA2_0==Key||LA2_0==Rpc||LA2_0==RULE_EXTENSION_NAME) ) {
                            alt2=1;
                        }


                        switch (alt2) {
                    	case 1 :
                    	    // InternalYangParser.g:108:5: (lv_substatements_1_0= ruleStatement )
                    	    {
                    	    // InternalYangParser.g:108:5: (lv_substatements_1_0= ruleStatement )
                    	    // InternalYangParser.g:109:6: lv_substatements_1_0= ruleStatement
                    	    {
                    	    if ( state.backtracking==0 ) {

                    	      						newCompositeNode(grammarAccess.getStatementEndAccess().getSubstatementsStatementParserRuleCall_0_1_0());
                    	      					
                    	    }
                    	    pushFollow(FOLLOW_3);
                    	    lv_substatements_1_0=ruleStatement();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      						if (current==null) {
                    	      							current = createModelElementForParent(grammarAccess.getStatementEndRule());
                    	      						}
                    	      						add(
                    	      							current,
                    	      							"substatements",
                    	      							lv_substatements_1_0,
                    	      							"io.typefox.yang.Yang.Statement");
                    	      						afterParserOrEnumRuleCall();
                    	      					
                    	    }

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop2;
                        }
                    } while (true);

                    otherlv_2=(Token)match(input,RightCurlyBracket,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_2, grammarAccess.getStatementEndAccess().getRightCurlyBracketKeyword_0_2());
                      			
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalYangParser.g:132:3: otherlv_3= Semicolon
                    {
                    otherlv_3=(Token)match(input,Semicolon,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			newLeafNode(otherlv_3, grammarAccess.getStatementEndAccess().getSemicolonKeyword_1());
                      		
                    }

                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleStatementEnd"


    // $ANTLR start "entryRuleStatement"
    // InternalYangParser.g:140:1: entryRuleStatement returns [EObject current=null] : iv_ruleStatement= ruleStatement EOF ;
    public final EObject entryRuleStatement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStatement = null;


        try {
            // InternalYangParser.g:140:50: (iv_ruleStatement= ruleStatement EOF )
            // InternalYangParser.g:141:2: iv_ruleStatement= ruleStatement EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getStatementRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleStatement=ruleStatement();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleStatement; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleStatement"


    // $ANTLR start "ruleStatement"
    // InternalYangParser.g:147:1: ruleStatement returns [EObject current=null] : (this_SchemaNode_0= ruleSchemaNode | this_OtherStatement_1= ruleOtherStatement ) ;
    public final EObject ruleStatement() throws RecognitionException {
        EObject current = null;

        EObject this_SchemaNode_0 = null;

        EObject this_OtherStatement_1 = null;



        	enterRule();

        try {
            // InternalYangParser.g:153:2: ( (this_SchemaNode_0= ruleSchemaNode | this_OtherStatement_1= ruleOtherStatement ) )
            // InternalYangParser.g:154:2: (this_SchemaNode_0= ruleSchemaNode | this_OtherStatement_1= ruleOtherStatement )
            {
            // InternalYangParser.g:154:2: (this_SchemaNode_0= ruleSchemaNode | this_OtherStatement_1= ruleOtherStatement )
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==Notification||LA4_0==Container||LA4_0==Extension||LA4_0==LeafList||(LA4_0>=Grouping && LA4_0<=Identity)||LA4_0==Anydata||LA4_0==Feature||(LA4_0>=Typedef && LA4_0<=Anyxml)||LA4_0==Choice||LA4_0==Output||LA4_0==Input||LA4_0==Case||(LA4_0>=Leaf && LA4_0<=List)||LA4_0==Rpc) ) {
                alt4=1;
            }
            else if ( ((LA4_0>=RequireInstance && LA4_0<=ErrorMessage)||(LA4_0>=RevisionDate && LA4_0<=MinElements)||(LA4_0>=Organization && LA4_0<=Description)||(LA4_0>=YinElement && LA4_0<=BelongsTo)||(LA4_0>=IfFeature && LA4_0<=OrderedBy)||LA4_0==Deviation||(LA4_0>=Mandatory && LA4_0<=Namespace)||(LA4_0>=Reference && LA4_0<=Submodule)||LA4_0==Argument||LA4_0==Modifier||(LA4_0>=Position && LA4_0<=Revision)||LA4_0==Augment||LA4_0==Contact||(LA4_0>=Default && LA4_0<=Deviate)||LA4_0==Include||LA4_0==Pattern||LA4_0==Config||(LA4_0>=Import && LA4_0<=Module)||(LA4_0>=Prefix && LA4_0<=Status)||LA4_0==Unique||LA4_0==Range||(LA4_0>=Units && LA4_0<=Value)||LA4_0==Base||LA4_0==Enum||LA4_0==Must||LA4_0==Path||LA4_0==Type||(LA4_0>=Uses && LA4_0<=When)||LA4_0==Bit||LA4_0==Key||LA4_0==RULE_EXTENSION_NAME) ) {
                alt4=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 4, 0, input);

                throw nvae;
            }
            switch (alt4) {
                case 1 :
                    // InternalYangParser.g:155:3: this_SchemaNode_0= ruleSchemaNode
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getStatementAccess().getSchemaNodeParserRuleCall_0());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_SchemaNode_0=ruleSchemaNode();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_SchemaNode_0;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 2 :
                    // InternalYangParser.g:164:3: this_OtherStatement_1= ruleOtherStatement
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getStatementAccess().getOtherStatementParserRuleCall_1());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_OtherStatement_1=ruleOtherStatement();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_OtherStatement_1;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleStatement"


    // $ANTLR start "entryRuleAbstractImport"
    // InternalYangParser.g:176:1: entryRuleAbstractImport returns [EObject current=null] : iv_ruleAbstractImport= ruleAbstractImport EOF ;
    public final EObject entryRuleAbstractImport() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAbstractImport = null;


        try {
            // InternalYangParser.g:176:55: (iv_ruleAbstractImport= ruleAbstractImport EOF )
            // InternalYangParser.g:177:2: iv_ruleAbstractImport= ruleAbstractImport EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getAbstractImportRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleAbstractImport=ruleAbstractImport();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleAbstractImport; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleAbstractImport"


    // $ANTLR start "ruleAbstractImport"
    // InternalYangParser.g:183:1: ruleAbstractImport returns [EObject current=null] : (this_Import_0= ruleImport | this_Include_1= ruleInclude ) ;
    public final EObject ruleAbstractImport() throws RecognitionException {
        EObject current = null;

        EObject this_Import_0 = null;

        EObject this_Include_1 = null;



        	enterRule();

        try {
            // InternalYangParser.g:189:2: ( (this_Import_0= ruleImport | this_Include_1= ruleInclude ) )
            // InternalYangParser.g:190:2: (this_Import_0= ruleImport | this_Include_1= ruleInclude )
            {
            // InternalYangParser.g:190:2: (this_Import_0= ruleImport | this_Include_1= ruleInclude )
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==Import) ) {
                alt5=1;
            }
            else if ( (LA5_0==Include) ) {
                alt5=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 5, 0, input);

                throw nvae;
            }
            switch (alt5) {
                case 1 :
                    // InternalYangParser.g:191:3: this_Import_0= ruleImport
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getAbstractImportAccess().getImportParserRuleCall_0());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_Import_0=ruleImport();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_Import_0;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 2 :
                    // InternalYangParser.g:200:3: this_Include_1= ruleInclude
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getAbstractImportAccess().getIncludeParserRuleCall_1());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_Include_1=ruleInclude();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_Include_1;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleAbstractImport"


    // $ANTLR start "entryRuleSchemaNode"
    // InternalYangParser.g:212:1: entryRuleSchemaNode returns [EObject current=null] : iv_ruleSchemaNode= ruleSchemaNode EOF ;
    public final EObject entryRuleSchemaNode() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSchemaNode = null;


        try {
            // InternalYangParser.g:212:51: (iv_ruleSchemaNode= ruleSchemaNode EOF )
            // InternalYangParser.g:213:2: iv_ruleSchemaNode= ruleSchemaNode EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getSchemaNodeRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleSchemaNode=ruleSchemaNode();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleSchemaNode; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleSchemaNode"


    // $ANTLR start "ruleSchemaNode"
    // InternalYangParser.g:219:1: ruleSchemaNode returns [EObject current=null] : (this_DataSchemaNode_0= ruleDataSchemaNode | this_Extension_1= ruleExtension | this_Feature_2= ruleFeature | this_Grouping_3= ruleGrouping | this_Identity_4= ruleIdentity | this_Notification_5= ruleNotification | this_Rpc_6= ruleRpc | this_Action_7= ruleAction | this_Input_8= ruleInput | this_Output_9= ruleOutput | this_Typedef_10= ruleTypedef ) ;
    public final EObject ruleSchemaNode() throws RecognitionException {
        EObject current = null;

        EObject this_DataSchemaNode_0 = null;

        EObject this_Extension_1 = null;

        EObject this_Feature_2 = null;

        EObject this_Grouping_3 = null;

        EObject this_Identity_4 = null;

        EObject this_Notification_5 = null;

        EObject this_Rpc_6 = null;

        EObject this_Action_7 = null;

        EObject this_Input_8 = null;

        EObject this_Output_9 = null;

        EObject this_Typedef_10 = null;



        	enterRule();

        try {
            // InternalYangParser.g:225:2: ( (this_DataSchemaNode_0= ruleDataSchemaNode | this_Extension_1= ruleExtension | this_Feature_2= ruleFeature | this_Grouping_3= ruleGrouping | this_Identity_4= ruleIdentity | this_Notification_5= ruleNotification | this_Rpc_6= ruleRpc | this_Action_7= ruleAction | this_Input_8= ruleInput | this_Output_9= ruleOutput | this_Typedef_10= ruleTypedef ) )
            // InternalYangParser.g:226:2: (this_DataSchemaNode_0= ruleDataSchemaNode | this_Extension_1= ruleExtension | this_Feature_2= ruleFeature | this_Grouping_3= ruleGrouping | this_Identity_4= ruleIdentity | this_Notification_5= ruleNotification | this_Rpc_6= ruleRpc | this_Action_7= ruleAction | this_Input_8= ruleInput | this_Output_9= ruleOutput | this_Typedef_10= ruleTypedef )
            {
            // InternalYangParser.g:226:2: (this_DataSchemaNode_0= ruleDataSchemaNode | this_Extension_1= ruleExtension | this_Feature_2= ruleFeature | this_Grouping_3= ruleGrouping | this_Identity_4= ruleIdentity | this_Notification_5= ruleNotification | this_Rpc_6= ruleRpc | this_Action_7= ruleAction | this_Input_8= ruleInput | this_Output_9= ruleOutput | this_Typedef_10= ruleTypedef )
            int alt6=11;
            switch ( input.LA(1) ) {
            case Container:
            case LeafList:
            case Anydata:
            case Anyxml:
            case Choice:
            case Case:
            case Leaf:
            case List:
                {
                alt6=1;
                }
                break;
            case Extension:
                {
                alt6=2;
                }
                break;
            case Feature:
                {
                alt6=3;
                }
                break;
            case Grouping:
                {
                alt6=4;
                }
                break;
            case Identity:
                {
                alt6=5;
                }
                break;
            case Notification:
                {
                alt6=6;
                }
                break;
            case Rpc:
                {
                alt6=7;
                }
                break;
            case Action:
                {
                alt6=8;
                }
                break;
            case Input:
                {
                alt6=9;
                }
                break;
            case Output:
                {
                alt6=10;
                }
                break;
            case Typedef:
                {
                alt6=11;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 6, 0, input);

                throw nvae;
            }

            switch (alt6) {
                case 1 :
                    // InternalYangParser.g:227:3: this_DataSchemaNode_0= ruleDataSchemaNode
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getSchemaNodeAccess().getDataSchemaNodeParserRuleCall_0());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_DataSchemaNode_0=ruleDataSchemaNode();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_DataSchemaNode_0;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 2 :
                    // InternalYangParser.g:236:3: this_Extension_1= ruleExtension
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getSchemaNodeAccess().getExtensionParserRuleCall_1());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_Extension_1=ruleExtension();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_Extension_1;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 3 :
                    // InternalYangParser.g:245:3: this_Feature_2= ruleFeature
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getSchemaNodeAccess().getFeatureParserRuleCall_2());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_Feature_2=ruleFeature();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_Feature_2;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 4 :
                    // InternalYangParser.g:254:3: this_Grouping_3= ruleGrouping
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getSchemaNodeAccess().getGroupingParserRuleCall_3());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_Grouping_3=ruleGrouping();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_Grouping_3;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 5 :
                    // InternalYangParser.g:263:3: this_Identity_4= ruleIdentity
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getSchemaNodeAccess().getIdentityParserRuleCall_4());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_Identity_4=ruleIdentity();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_Identity_4;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 6 :
                    // InternalYangParser.g:272:3: this_Notification_5= ruleNotification
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getSchemaNodeAccess().getNotificationParserRuleCall_5());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_Notification_5=ruleNotification();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_Notification_5;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 7 :
                    // InternalYangParser.g:281:3: this_Rpc_6= ruleRpc
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getSchemaNodeAccess().getRpcParserRuleCall_6());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_Rpc_6=ruleRpc();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_Rpc_6;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 8 :
                    // InternalYangParser.g:290:3: this_Action_7= ruleAction
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getSchemaNodeAccess().getActionParserRuleCall_7());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_Action_7=ruleAction();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_Action_7;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 9 :
                    // InternalYangParser.g:299:3: this_Input_8= ruleInput
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getSchemaNodeAccess().getInputParserRuleCall_8());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_Input_8=ruleInput();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_Input_8;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 10 :
                    // InternalYangParser.g:308:3: this_Output_9= ruleOutput
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getSchemaNodeAccess().getOutputParserRuleCall_9());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_Output_9=ruleOutput();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_Output_9;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 11 :
                    // InternalYangParser.g:317:3: this_Typedef_10= ruleTypedef
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getSchemaNodeAccess().getTypedefParserRuleCall_10());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_Typedef_10=ruleTypedef();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_Typedef_10;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleSchemaNode"


    // $ANTLR start "entryRuleDataSchemaNode"
    // InternalYangParser.g:329:1: entryRuleDataSchemaNode returns [EObject current=null] : iv_ruleDataSchemaNode= ruleDataSchemaNode EOF ;
    public final EObject entryRuleDataSchemaNode() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDataSchemaNode = null;


        try {
            // InternalYangParser.g:329:55: (iv_ruleDataSchemaNode= ruleDataSchemaNode EOF )
            // InternalYangParser.g:330:2: iv_ruleDataSchemaNode= ruleDataSchemaNode EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getDataSchemaNodeRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleDataSchemaNode=ruleDataSchemaNode();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleDataSchemaNode; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleDataSchemaNode"


    // $ANTLR start "ruleDataSchemaNode"
    // InternalYangParser.g:336:1: ruleDataSchemaNode returns [EObject current=null] : (this_Anydata_0= ruleAnydata | this_Anyxml_1= ruleAnyxml | this_Container_2= ruleContainer | this_Choice_3= ruleChoice | this_Case_4= ruleCase | this_List_5= ruleList | this_Leaf_6= ruleLeaf | this_LeafList_7= ruleLeafList ) ;
    public final EObject ruleDataSchemaNode() throws RecognitionException {
        EObject current = null;

        EObject this_Anydata_0 = null;

        EObject this_Anyxml_1 = null;

        EObject this_Container_2 = null;

        EObject this_Choice_3 = null;

        EObject this_Case_4 = null;

        EObject this_List_5 = null;

        EObject this_Leaf_6 = null;

        EObject this_LeafList_7 = null;



        	enterRule();

        try {
            // InternalYangParser.g:342:2: ( (this_Anydata_0= ruleAnydata | this_Anyxml_1= ruleAnyxml | this_Container_2= ruleContainer | this_Choice_3= ruleChoice | this_Case_4= ruleCase | this_List_5= ruleList | this_Leaf_6= ruleLeaf | this_LeafList_7= ruleLeafList ) )
            // InternalYangParser.g:343:2: (this_Anydata_0= ruleAnydata | this_Anyxml_1= ruleAnyxml | this_Container_2= ruleContainer | this_Choice_3= ruleChoice | this_Case_4= ruleCase | this_List_5= ruleList | this_Leaf_6= ruleLeaf | this_LeafList_7= ruleLeafList )
            {
            // InternalYangParser.g:343:2: (this_Anydata_0= ruleAnydata | this_Anyxml_1= ruleAnyxml | this_Container_2= ruleContainer | this_Choice_3= ruleChoice | this_Case_4= ruleCase | this_List_5= ruleList | this_Leaf_6= ruleLeaf | this_LeafList_7= ruleLeafList )
            int alt7=8;
            switch ( input.LA(1) ) {
            case Anydata:
                {
                alt7=1;
                }
                break;
            case Anyxml:
                {
                alt7=2;
                }
                break;
            case Container:
                {
                alt7=3;
                }
                break;
            case Choice:
                {
                alt7=4;
                }
                break;
            case Case:
                {
                alt7=5;
                }
                break;
            case List:
                {
                alt7=6;
                }
                break;
            case Leaf:
                {
                alt7=7;
                }
                break;
            case LeafList:
                {
                alt7=8;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 7, 0, input);

                throw nvae;
            }

            switch (alt7) {
                case 1 :
                    // InternalYangParser.g:344:3: this_Anydata_0= ruleAnydata
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getDataSchemaNodeAccess().getAnydataParserRuleCall_0());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_Anydata_0=ruleAnydata();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_Anydata_0;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 2 :
                    // InternalYangParser.g:353:3: this_Anyxml_1= ruleAnyxml
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getDataSchemaNodeAccess().getAnyxmlParserRuleCall_1());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_Anyxml_1=ruleAnyxml();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_Anyxml_1;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 3 :
                    // InternalYangParser.g:362:3: this_Container_2= ruleContainer
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getDataSchemaNodeAccess().getContainerParserRuleCall_2());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_Container_2=ruleContainer();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_Container_2;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 4 :
                    // InternalYangParser.g:371:3: this_Choice_3= ruleChoice
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getDataSchemaNodeAccess().getChoiceParserRuleCall_3());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_Choice_3=ruleChoice();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_Choice_3;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 5 :
                    // InternalYangParser.g:380:3: this_Case_4= ruleCase
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getDataSchemaNodeAccess().getCaseParserRuleCall_4());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_Case_4=ruleCase();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_Case_4;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 6 :
                    // InternalYangParser.g:389:3: this_List_5= ruleList
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getDataSchemaNodeAccess().getListParserRuleCall_5());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_List_5=ruleList();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_List_5;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 7 :
                    // InternalYangParser.g:398:3: this_Leaf_6= ruleLeaf
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getDataSchemaNodeAccess().getLeafParserRuleCall_6());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_Leaf_6=ruleLeaf();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_Leaf_6;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 8 :
                    // InternalYangParser.g:407:3: this_LeafList_7= ruleLeafList
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getDataSchemaNodeAccess().getLeafListParserRuleCall_7());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_LeafList_7=ruleLeafList();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_LeafList_7;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleDataSchemaNode"


    // $ANTLR start "entryRuleOtherStatement"
    // InternalYangParser.g:419:1: entryRuleOtherStatement returns [EObject current=null] : iv_ruleOtherStatement= ruleOtherStatement EOF ;
    public final EObject entryRuleOtherStatement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleOtherStatement = null;


        try {
            // InternalYangParser.g:419:55: (iv_ruleOtherStatement= ruleOtherStatement EOF )
            // InternalYangParser.g:420:2: iv_ruleOtherStatement= ruleOtherStatement EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getOtherStatementRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleOtherStatement=ruleOtherStatement();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleOtherStatement; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleOtherStatement"


    // $ANTLR start "ruleOtherStatement"
    // InternalYangParser.g:426:1: ruleOtherStatement returns [EObject current=null] : (this_AbstractModule_0= ruleAbstractModule | this_AbstractImport_1= ruleAbstractImport | this_Argument_2= ruleArgument | this_Augment_3= ruleAugment | this_Base_4= ruleBase | this_BelongsTo_5= ruleBelongsTo | this_Config_6= ruleConfig | this_Contact_7= ruleContact | this_Default_8= ruleDefault | this_Description_9= ruleDescription | this_Enumerable_10= ruleEnumerable | this_ErrorAppTag_11= ruleErrorAppTag | this_ErrorMessage_12= ruleErrorMessage | this_Deviation_13= ruleDeviation | this_Deviate_14= ruleDeviate | this_FractionDigits_15= ruleFractionDigits | this_IfFeature_16= ruleIfFeature | this_Key_17= ruleKey | this_Mandatory_18= ruleMandatory | this_MaxElements_19= ruleMaxElements | this_MinElements_20= ruleMinElements | this_Modifier_21= ruleModifier | this_Must_22= ruleMust | this_Namespace_23= ruleNamespace | this_Ordered_24= ruleOrdered | this_OrderedBy_25= ruleOrderedBy | this_Organization_26= ruleOrganization | this_Path_27= rulePath | this_Pattern_28= rulePattern | this_Prefix_29= rulePrefix | this_Presence_30= rulePresence | this_Reference_31= ruleReference | this_Refine_32= ruleRefine | this_Refinable_33= ruleRefinable | this_RequireInstance_34= ruleRequireInstance | this_Revision_35= ruleRevision | this_RevisionDate_36= ruleRevisionDate | this_Status_37= ruleStatus | this_Type_38= ruleType | this_Unique_39= ruleUnique | this_Units_40= ruleUnits | this_Unknown_41= ruleUnknown | this_Uses_42= ruleUses | this_When_43= ruleWhen | this_YangVersion_44= ruleYangVersion | this_YinElement_45= ruleYinElement ) ;
    public final EObject ruleOtherStatement() throws RecognitionException {
        EObject current = null;

        EObject this_AbstractModule_0 = null;

        EObject this_AbstractImport_1 = null;

        EObject this_Argument_2 = null;

        EObject this_Augment_3 = null;

        EObject this_Base_4 = null;

        EObject this_BelongsTo_5 = null;

        EObject this_Config_6 = null;

        EObject this_Contact_7 = null;

        EObject this_Default_8 = null;

        EObject this_Description_9 = null;

        EObject this_Enumerable_10 = null;

        EObject this_ErrorAppTag_11 = null;

        EObject this_ErrorMessage_12 = null;

        EObject this_Deviation_13 = null;

        EObject this_Deviate_14 = null;

        EObject this_FractionDigits_15 = null;

        EObject this_IfFeature_16 = null;

        EObject this_Key_17 = null;

        EObject this_Mandatory_18 = null;

        EObject this_MaxElements_19 = null;

        EObject this_MinElements_20 = null;

        EObject this_Modifier_21 = null;

        EObject this_Must_22 = null;

        EObject this_Namespace_23 = null;

        EObject this_Ordered_24 = null;

        EObject this_OrderedBy_25 = null;

        EObject this_Organization_26 = null;

        EObject this_Path_27 = null;

        EObject this_Pattern_28 = null;

        EObject this_Prefix_29 = null;

        EObject this_Presence_30 = null;

        EObject this_Reference_31 = null;

        EObject this_Refine_32 = null;

        EObject this_Refinable_33 = null;

        EObject this_RequireInstance_34 = null;

        EObject this_Revision_35 = null;

        EObject this_RevisionDate_36 = null;

        EObject this_Status_37 = null;

        EObject this_Type_38 = null;

        EObject this_Unique_39 = null;

        EObject this_Units_40 = null;

        EObject this_Unknown_41 = null;

        EObject this_Uses_42 = null;

        EObject this_When_43 = null;

        EObject this_YangVersion_44 = null;

        EObject this_YinElement_45 = null;



        	enterRule();

        try {
            // InternalYangParser.g:432:2: ( (this_AbstractModule_0= ruleAbstractModule | this_AbstractImport_1= ruleAbstractImport | this_Argument_2= ruleArgument | this_Augment_3= ruleAugment | this_Base_4= ruleBase | this_BelongsTo_5= ruleBelongsTo | this_Config_6= ruleConfig | this_Contact_7= ruleContact | this_Default_8= ruleDefault | this_Description_9= ruleDescription | this_Enumerable_10= ruleEnumerable | this_ErrorAppTag_11= ruleErrorAppTag | this_ErrorMessage_12= ruleErrorMessage | this_Deviation_13= ruleDeviation | this_Deviate_14= ruleDeviate | this_FractionDigits_15= ruleFractionDigits | this_IfFeature_16= ruleIfFeature | this_Key_17= ruleKey | this_Mandatory_18= ruleMandatory | this_MaxElements_19= ruleMaxElements | this_MinElements_20= ruleMinElements | this_Modifier_21= ruleModifier | this_Must_22= ruleMust | this_Namespace_23= ruleNamespace | this_Ordered_24= ruleOrdered | this_OrderedBy_25= ruleOrderedBy | this_Organization_26= ruleOrganization | this_Path_27= rulePath | this_Pattern_28= rulePattern | this_Prefix_29= rulePrefix | this_Presence_30= rulePresence | this_Reference_31= ruleReference | this_Refine_32= ruleRefine | this_Refinable_33= ruleRefinable | this_RequireInstance_34= ruleRequireInstance | this_Revision_35= ruleRevision | this_RevisionDate_36= ruleRevisionDate | this_Status_37= ruleStatus | this_Type_38= ruleType | this_Unique_39= ruleUnique | this_Units_40= ruleUnits | this_Unknown_41= ruleUnknown | this_Uses_42= ruleUses | this_When_43= ruleWhen | this_YangVersion_44= ruleYangVersion | this_YinElement_45= ruleYinElement ) )
            // InternalYangParser.g:433:2: (this_AbstractModule_0= ruleAbstractModule | this_AbstractImport_1= ruleAbstractImport | this_Argument_2= ruleArgument | this_Augment_3= ruleAugment | this_Base_4= ruleBase | this_BelongsTo_5= ruleBelongsTo | this_Config_6= ruleConfig | this_Contact_7= ruleContact | this_Default_8= ruleDefault | this_Description_9= ruleDescription | this_Enumerable_10= ruleEnumerable | this_ErrorAppTag_11= ruleErrorAppTag | this_ErrorMessage_12= ruleErrorMessage | this_Deviation_13= ruleDeviation | this_Deviate_14= ruleDeviate | this_FractionDigits_15= ruleFractionDigits | this_IfFeature_16= ruleIfFeature | this_Key_17= ruleKey | this_Mandatory_18= ruleMandatory | this_MaxElements_19= ruleMaxElements | this_MinElements_20= ruleMinElements | this_Modifier_21= ruleModifier | this_Must_22= ruleMust | this_Namespace_23= ruleNamespace | this_Ordered_24= ruleOrdered | this_OrderedBy_25= ruleOrderedBy | this_Organization_26= ruleOrganization | this_Path_27= rulePath | this_Pattern_28= rulePattern | this_Prefix_29= rulePrefix | this_Presence_30= rulePresence | this_Reference_31= ruleReference | this_Refine_32= ruleRefine | this_Refinable_33= ruleRefinable | this_RequireInstance_34= ruleRequireInstance | this_Revision_35= ruleRevision | this_RevisionDate_36= ruleRevisionDate | this_Status_37= ruleStatus | this_Type_38= ruleType | this_Unique_39= ruleUnique | this_Units_40= ruleUnits | this_Unknown_41= ruleUnknown | this_Uses_42= ruleUses | this_When_43= ruleWhen | this_YangVersion_44= ruleYangVersion | this_YinElement_45= ruleYinElement )
            {
            // InternalYangParser.g:433:2: (this_AbstractModule_0= ruleAbstractModule | this_AbstractImport_1= ruleAbstractImport | this_Argument_2= ruleArgument | this_Augment_3= ruleAugment | this_Base_4= ruleBase | this_BelongsTo_5= ruleBelongsTo | this_Config_6= ruleConfig | this_Contact_7= ruleContact | this_Default_8= ruleDefault | this_Description_9= ruleDescription | this_Enumerable_10= ruleEnumerable | this_ErrorAppTag_11= ruleErrorAppTag | this_ErrorMessage_12= ruleErrorMessage | this_Deviation_13= ruleDeviation | this_Deviate_14= ruleDeviate | this_FractionDigits_15= ruleFractionDigits | this_IfFeature_16= ruleIfFeature | this_Key_17= ruleKey | this_Mandatory_18= ruleMandatory | this_MaxElements_19= ruleMaxElements | this_MinElements_20= ruleMinElements | this_Modifier_21= ruleModifier | this_Must_22= ruleMust | this_Namespace_23= ruleNamespace | this_Ordered_24= ruleOrdered | this_OrderedBy_25= ruleOrderedBy | this_Organization_26= ruleOrganization | this_Path_27= rulePath | this_Pattern_28= rulePattern | this_Prefix_29= rulePrefix | this_Presence_30= rulePresence | this_Reference_31= ruleReference | this_Refine_32= ruleRefine | this_Refinable_33= ruleRefinable | this_RequireInstance_34= ruleRequireInstance | this_Revision_35= ruleRevision | this_RevisionDate_36= ruleRevisionDate | this_Status_37= ruleStatus | this_Type_38= ruleType | this_Unique_39= ruleUnique | this_Units_40= ruleUnits | this_Unknown_41= ruleUnknown | this_Uses_42= ruleUses | this_When_43= ruleWhen | this_YangVersion_44= ruleYangVersion | this_YinElement_45= ruleYinElement )
            int alt8=46;
            switch ( input.LA(1) ) {
            case Submodule:
            case Module:
                {
                alt8=1;
                }
                break;
            case Include:
            case Import:
                {
                alt8=2;
                }
                break;
            case Argument:
                {
                alt8=3;
                }
                break;
            case Augment:
                {
                alt8=4;
                }
                break;
            case Base:
                {
                alt8=5;
                }
                break;
            case BelongsTo:
                {
                alt8=6;
                }
                break;
            case Config:
                {
                alt8=7;
                }
                break;
            case Contact:
                {
                alt8=8;
                }
                break;
            case Default:
                {
                alt8=9;
                }
                break;
            case Description:
                {
                alt8=10;
                }
                break;
            case Enum:
            case Bit:
                {
                alt8=11;
                }
                break;
            case ErrorAppTag:
                {
                alt8=12;
                }
                break;
            case ErrorMessage:
                {
                alt8=13;
                }
                break;
            case Deviation:
                {
                alt8=14;
                }
                break;
            case Deviate:
                {
                alt8=15;
                }
                break;
            case FractionDigits:
                {
                alt8=16;
                }
                break;
            case IfFeature:
                {
                alt8=17;
                }
                break;
            case Key:
                {
                alt8=18;
                }
                break;
            case Mandatory:
                {
                alt8=19;
                }
                break;
            case MaxElements:
                {
                alt8=20;
                }
                break;
            case MinElements:
                {
                alt8=21;
                }
                break;
            case Modifier:
                {
                alt8=22;
                }
                break;
            case Must:
                {
                alt8=23;
                }
                break;
            case Namespace:
                {
                alt8=24;
                }
                break;
            case Position:
            case Value:
                {
                alt8=25;
                }
                break;
            case OrderedBy:
                {
                alt8=26;
                }
                break;
            case Organization:
                {
                alt8=27;
                }
                break;
            case Path:
                {
                alt8=28;
                }
                break;
            case Pattern:
                {
                alt8=29;
                }
                break;
            case Prefix:
                {
                alt8=30;
                }
                break;
            case Presence:
                {
                alt8=31;
                }
                break;
            case Reference:
                {
                alt8=32;
                }
                break;
            case Refine:
                {
                alt8=33;
                }
                break;
            case Length:
            case Range:
                {
                alt8=34;
                }
                break;
            case RequireInstance:
                {
                alt8=35;
                }
                break;
            case Revision:
                {
                alt8=36;
                }
                break;
            case RevisionDate:
                {
                alt8=37;
                }
                break;
            case Status:
                {
                alt8=38;
                }
                break;
            case Type:
                {
                alt8=39;
                }
                break;
            case Unique:
                {
                alt8=40;
                }
                break;
            case Units:
                {
                alt8=41;
                }
                break;
            case RULE_EXTENSION_NAME:
                {
                alt8=42;
                }
                break;
            case Uses:
                {
                alt8=43;
                }
                break;
            case When:
                {
                alt8=44;
                }
                break;
            case YangVersion:
                {
                alt8=45;
                }
                break;
            case YinElement:
                {
                alt8=46;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 8, 0, input);

                throw nvae;
            }

            switch (alt8) {
                case 1 :
                    // InternalYangParser.g:434:3: this_AbstractModule_0= ruleAbstractModule
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getOtherStatementAccess().getAbstractModuleParserRuleCall_0());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_AbstractModule_0=ruleAbstractModule();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_AbstractModule_0;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 2 :
                    // InternalYangParser.g:443:3: this_AbstractImport_1= ruleAbstractImport
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getOtherStatementAccess().getAbstractImportParserRuleCall_1());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_AbstractImport_1=ruleAbstractImport();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_AbstractImport_1;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 3 :
                    // InternalYangParser.g:452:3: this_Argument_2= ruleArgument
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getOtherStatementAccess().getArgumentParserRuleCall_2());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_Argument_2=ruleArgument();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_Argument_2;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 4 :
                    // InternalYangParser.g:461:3: this_Augment_3= ruleAugment
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getOtherStatementAccess().getAugmentParserRuleCall_3());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_Augment_3=ruleAugment();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_Augment_3;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 5 :
                    // InternalYangParser.g:470:3: this_Base_4= ruleBase
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getOtherStatementAccess().getBaseParserRuleCall_4());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_Base_4=ruleBase();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_Base_4;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 6 :
                    // InternalYangParser.g:479:3: this_BelongsTo_5= ruleBelongsTo
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getOtherStatementAccess().getBelongsToParserRuleCall_5());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_BelongsTo_5=ruleBelongsTo();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_BelongsTo_5;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 7 :
                    // InternalYangParser.g:488:3: this_Config_6= ruleConfig
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getOtherStatementAccess().getConfigParserRuleCall_6());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_Config_6=ruleConfig();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_Config_6;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 8 :
                    // InternalYangParser.g:497:3: this_Contact_7= ruleContact
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getOtherStatementAccess().getContactParserRuleCall_7());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_Contact_7=ruleContact();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_Contact_7;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 9 :
                    // InternalYangParser.g:506:3: this_Default_8= ruleDefault
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getOtherStatementAccess().getDefaultParserRuleCall_8());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_Default_8=ruleDefault();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_Default_8;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 10 :
                    // InternalYangParser.g:515:3: this_Description_9= ruleDescription
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getOtherStatementAccess().getDescriptionParserRuleCall_9());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_Description_9=ruleDescription();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_Description_9;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 11 :
                    // InternalYangParser.g:524:3: this_Enumerable_10= ruleEnumerable
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getOtherStatementAccess().getEnumerableParserRuleCall_10());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_Enumerable_10=ruleEnumerable();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_Enumerable_10;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 12 :
                    // InternalYangParser.g:533:3: this_ErrorAppTag_11= ruleErrorAppTag
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getOtherStatementAccess().getErrorAppTagParserRuleCall_11());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_ErrorAppTag_11=ruleErrorAppTag();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_ErrorAppTag_11;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 13 :
                    // InternalYangParser.g:542:3: this_ErrorMessage_12= ruleErrorMessage
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getOtherStatementAccess().getErrorMessageParserRuleCall_12());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_ErrorMessage_12=ruleErrorMessage();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_ErrorMessage_12;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 14 :
                    // InternalYangParser.g:551:3: this_Deviation_13= ruleDeviation
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getOtherStatementAccess().getDeviationParserRuleCall_13());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_Deviation_13=ruleDeviation();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_Deviation_13;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 15 :
                    // InternalYangParser.g:560:3: this_Deviate_14= ruleDeviate
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getOtherStatementAccess().getDeviateParserRuleCall_14());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_Deviate_14=ruleDeviate();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_Deviate_14;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 16 :
                    // InternalYangParser.g:569:3: this_FractionDigits_15= ruleFractionDigits
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getOtherStatementAccess().getFractionDigitsParserRuleCall_15());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_FractionDigits_15=ruleFractionDigits();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_FractionDigits_15;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 17 :
                    // InternalYangParser.g:578:3: this_IfFeature_16= ruleIfFeature
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getOtherStatementAccess().getIfFeatureParserRuleCall_16());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_IfFeature_16=ruleIfFeature();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_IfFeature_16;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 18 :
                    // InternalYangParser.g:587:3: this_Key_17= ruleKey
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getOtherStatementAccess().getKeyParserRuleCall_17());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_Key_17=ruleKey();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_Key_17;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 19 :
                    // InternalYangParser.g:596:3: this_Mandatory_18= ruleMandatory
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getOtherStatementAccess().getMandatoryParserRuleCall_18());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_Mandatory_18=ruleMandatory();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_Mandatory_18;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 20 :
                    // InternalYangParser.g:605:3: this_MaxElements_19= ruleMaxElements
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getOtherStatementAccess().getMaxElementsParserRuleCall_19());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_MaxElements_19=ruleMaxElements();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_MaxElements_19;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 21 :
                    // InternalYangParser.g:614:3: this_MinElements_20= ruleMinElements
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getOtherStatementAccess().getMinElementsParserRuleCall_20());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_MinElements_20=ruleMinElements();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_MinElements_20;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 22 :
                    // InternalYangParser.g:623:3: this_Modifier_21= ruleModifier
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getOtherStatementAccess().getModifierParserRuleCall_21());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_Modifier_21=ruleModifier();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_Modifier_21;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 23 :
                    // InternalYangParser.g:632:3: this_Must_22= ruleMust
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getOtherStatementAccess().getMustParserRuleCall_22());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_Must_22=ruleMust();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_Must_22;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 24 :
                    // InternalYangParser.g:641:3: this_Namespace_23= ruleNamespace
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getOtherStatementAccess().getNamespaceParserRuleCall_23());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_Namespace_23=ruleNamespace();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_Namespace_23;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 25 :
                    // InternalYangParser.g:650:3: this_Ordered_24= ruleOrdered
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getOtherStatementAccess().getOrderedParserRuleCall_24());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_Ordered_24=ruleOrdered();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_Ordered_24;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 26 :
                    // InternalYangParser.g:659:3: this_OrderedBy_25= ruleOrderedBy
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getOtherStatementAccess().getOrderedByParserRuleCall_25());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_OrderedBy_25=ruleOrderedBy();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_OrderedBy_25;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 27 :
                    // InternalYangParser.g:668:3: this_Organization_26= ruleOrganization
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getOtherStatementAccess().getOrganizationParserRuleCall_26());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_Organization_26=ruleOrganization();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_Organization_26;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 28 :
                    // InternalYangParser.g:677:3: this_Path_27= rulePath
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getOtherStatementAccess().getPathParserRuleCall_27());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_Path_27=rulePath();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_Path_27;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 29 :
                    // InternalYangParser.g:686:3: this_Pattern_28= rulePattern
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getOtherStatementAccess().getPatternParserRuleCall_28());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_Pattern_28=rulePattern();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_Pattern_28;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 30 :
                    // InternalYangParser.g:695:3: this_Prefix_29= rulePrefix
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getOtherStatementAccess().getPrefixParserRuleCall_29());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_Prefix_29=rulePrefix();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_Prefix_29;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 31 :
                    // InternalYangParser.g:704:3: this_Presence_30= rulePresence
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getOtherStatementAccess().getPresenceParserRuleCall_30());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_Presence_30=rulePresence();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_Presence_30;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 32 :
                    // InternalYangParser.g:713:3: this_Reference_31= ruleReference
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getOtherStatementAccess().getReferenceParserRuleCall_31());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_Reference_31=ruleReference();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_Reference_31;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 33 :
                    // InternalYangParser.g:722:3: this_Refine_32= ruleRefine
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getOtherStatementAccess().getRefineParserRuleCall_32());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_Refine_32=ruleRefine();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_Refine_32;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 34 :
                    // InternalYangParser.g:731:3: this_Refinable_33= ruleRefinable
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getOtherStatementAccess().getRefinableParserRuleCall_33());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_Refinable_33=ruleRefinable();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_Refinable_33;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 35 :
                    // InternalYangParser.g:740:3: this_RequireInstance_34= ruleRequireInstance
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getOtherStatementAccess().getRequireInstanceParserRuleCall_34());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_RequireInstance_34=ruleRequireInstance();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_RequireInstance_34;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 36 :
                    // InternalYangParser.g:749:3: this_Revision_35= ruleRevision
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getOtherStatementAccess().getRevisionParserRuleCall_35());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_Revision_35=ruleRevision();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_Revision_35;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 37 :
                    // InternalYangParser.g:758:3: this_RevisionDate_36= ruleRevisionDate
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getOtherStatementAccess().getRevisionDateParserRuleCall_36());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_RevisionDate_36=ruleRevisionDate();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_RevisionDate_36;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 38 :
                    // InternalYangParser.g:767:3: this_Status_37= ruleStatus
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getOtherStatementAccess().getStatusParserRuleCall_37());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_Status_37=ruleStatus();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_Status_37;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 39 :
                    // InternalYangParser.g:776:3: this_Type_38= ruleType
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getOtherStatementAccess().getTypeParserRuleCall_38());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_Type_38=ruleType();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_Type_38;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 40 :
                    // InternalYangParser.g:785:3: this_Unique_39= ruleUnique
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getOtherStatementAccess().getUniqueParserRuleCall_39());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_Unique_39=ruleUnique();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_Unique_39;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 41 :
                    // InternalYangParser.g:794:3: this_Units_40= ruleUnits
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getOtherStatementAccess().getUnitsParserRuleCall_40());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_Units_40=ruleUnits();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_Units_40;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 42 :
                    // InternalYangParser.g:803:3: this_Unknown_41= ruleUnknown
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getOtherStatementAccess().getUnknownParserRuleCall_41());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_Unknown_41=ruleUnknown();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_Unknown_41;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 43 :
                    // InternalYangParser.g:812:3: this_Uses_42= ruleUses
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getOtherStatementAccess().getUsesParserRuleCall_42());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_Uses_42=ruleUses();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_Uses_42;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 44 :
                    // InternalYangParser.g:821:3: this_When_43= ruleWhen
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getOtherStatementAccess().getWhenParserRuleCall_43());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_When_43=ruleWhen();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_When_43;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 45 :
                    // InternalYangParser.g:830:3: this_YangVersion_44= ruleYangVersion
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getOtherStatementAccess().getYangVersionParserRuleCall_44());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_YangVersion_44=ruleYangVersion();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_YangVersion_44;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 46 :
                    // InternalYangParser.g:839:3: this_YinElement_45= ruleYinElement
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getOtherStatementAccess().getYinElementParserRuleCall_45());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_YinElement_45=ruleYinElement();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_YinElement_45;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleOtherStatement"


    // $ANTLR start "entryRuleEnumerable"
    // InternalYangParser.g:851:1: entryRuleEnumerable returns [EObject current=null] : iv_ruleEnumerable= ruleEnumerable EOF ;
    public final EObject entryRuleEnumerable() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEnumerable = null;


        try {
            // InternalYangParser.g:851:51: (iv_ruleEnumerable= ruleEnumerable EOF )
            // InternalYangParser.g:852:2: iv_ruleEnumerable= ruleEnumerable EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getEnumerableRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleEnumerable=ruleEnumerable();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleEnumerable; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleEnumerable"


    // $ANTLR start "ruleEnumerable"
    // InternalYangParser.g:858:1: ruleEnumerable returns [EObject current=null] : (this_Enum_0= ruleEnum | this_Bit_1= ruleBit ) ;
    public final EObject ruleEnumerable() throws RecognitionException {
        EObject current = null;

        EObject this_Enum_0 = null;

        EObject this_Bit_1 = null;



        	enterRule();

        try {
            // InternalYangParser.g:864:2: ( (this_Enum_0= ruleEnum | this_Bit_1= ruleBit ) )
            // InternalYangParser.g:865:2: (this_Enum_0= ruleEnum | this_Bit_1= ruleBit )
            {
            // InternalYangParser.g:865:2: (this_Enum_0= ruleEnum | this_Bit_1= ruleBit )
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==Enum) ) {
                alt9=1;
            }
            else if ( (LA9_0==Bit) ) {
                alt9=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 9, 0, input);

                throw nvae;
            }
            switch (alt9) {
                case 1 :
                    // InternalYangParser.g:866:3: this_Enum_0= ruleEnum
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getEnumerableAccess().getEnumParserRuleCall_0());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_Enum_0=ruleEnum();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_Enum_0;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 2 :
                    // InternalYangParser.g:875:3: this_Bit_1= ruleBit
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getEnumerableAccess().getBitParserRuleCall_1());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_Bit_1=ruleBit();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_Bit_1;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleEnumerable"


    // $ANTLR start "entryRuleOrdered"
    // InternalYangParser.g:887:1: entryRuleOrdered returns [EObject current=null] : iv_ruleOrdered= ruleOrdered EOF ;
    public final EObject entryRuleOrdered() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleOrdered = null;


        try {
            // InternalYangParser.g:887:48: (iv_ruleOrdered= ruleOrdered EOF )
            // InternalYangParser.g:888:2: iv_ruleOrdered= ruleOrdered EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getOrderedRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleOrdered=ruleOrdered();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleOrdered; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleOrdered"


    // $ANTLR start "ruleOrdered"
    // InternalYangParser.g:894:1: ruleOrdered returns [EObject current=null] : (this_Position_0= rulePosition | this_Value_1= ruleValue ) ;
    public final EObject ruleOrdered() throws RecognitionException {
        EObject current = null;

        EObject this_Position_0 = null;

        EObject this_Value_1 = null;



        	enterRule();

        try {
            // InternalYangParser.g:900:2: ( (this_Position_0= rulePosition | this_Value_1= ruleValue ) )
            // InternalYangParser.g:901:2: (this_Position_0= rulePosition | this_Value_1= ruleValue )
            {
            // InternalYangParser.g:901:2: (this_Position_0= rulePosition | this_Value_1= ruleValue )
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==Position) ) {
                alt10=1;
            }
            else if ( (LA10_0==Value) ) {
                alt10=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 10, 0, input);

                throw nvae;
            }
            switch (alt10) {
                case 1 :
                    // InternalYangParser.g:902:3: this_Position_0= rulePosition
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getOrderedAccess().getPositionParserRuleCall_0());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_Position_0=rulePosition();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_Position_0;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 2 :
                    // InternalYangParser.g:911:3: this_Value_1= ruleValue
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getOrderedAccess().getValueParserRuleCall_1());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_Value_1=ruleValue();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_Value_1;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleOrdered"


    // $ANTLR start "entryRuleRefinable"
    // InternalYangParser.g:923:1: entryRuleRefinable returns [EObject current=null] : iv_ruleRefinable= ruleRefinable EOF ;
    public final EObject entryRuleRefinable() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRefinable = null;


        try {
            // InternalYangParser.g:923:50: (iv_ruleRefinable= ruleRefinable EOF )
            // InternalYangParser.g:924:2: iv_ruleRefinable= ruleRefinable EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getRefinableRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleRefinable=ruleRefinable();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleRefinable; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleRefinable"


    // $ANTLR start "ruleRefinable"
    // InternalYangParser.g:930:1: ruleRefinable returns [EObject current=null] : (this_Range_0= ruleRange | this_Length_1= ruleLength ) ;
    public final EObject ruleRefinable() throws RecognitionException {
        EObject current = null;

        EObject this_Range_0 = null;

        EObject this_Length_1 = null;



        	enterRule();

        try {
            // InternalYangParser.g:936:2: ( (this_Range_0= ruleRange | this_Length_1= ruleLength ) )
            // InternalYangParser.g:937:2: (this_Range_0= ruleRange | this_Length_1= ruleLength )
            {
            // InternalYangParser.g:937:2: (this_Range_0= ruleRange | this_Length_1= ruleLength )
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==Range) ) {
                alt11=1;
            }
            else if ( (LA11_0==Length) ) {
                alt11=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 11, 0, input);

                throw nvae;
            }
            switch (alt11) {
                case 1 :
                    // InternalYangParser.g:938:3: this_Range_0= ruleRange
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getRefinableAccess().getRangeParserRuleCall_0());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_Range_0=ruleRange();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_Range_0;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 2 :
                    // InternalYangParser.g:947:3: this_Length_1= ruleLength
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getRefinableAccess().getLengthParserRuleCall_1());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_Length_1=ruleLength();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_Length_1;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleRefinable"


    // $ANTLR start "entryRuleModule"
    // InternalYangParser.g:959:1: entryRuleModule returns [EObject current=null] : iv_ruleModule= ruleModule EOF ;
    public final EObject entryRuleModule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleModule = null;


        try {
            // InternalYangParser.g:959:47: (iv_ruleModule= ruleModule EOF )
            // InternalYangParser.g:960:2: iv_ruleModule= ruleModule EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getModuleRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleModule=ruleModule();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleModule; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleModule"


    // $ANTLR start "ruleModule"
    // InternalYangParser.g:966:1: ruleModule returns [EObject current=null] : (otherlv_0= Module ( (lv_name_1_0= ruleStringValue ) ) this_StatementEnd_2= ruleStatementEnd[$current] ) ;
    public final EObject ruleModule() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        AntlrDatatypeRuleToken lv_name_1_0 = null;

        EObject this_StatementEnd_2 = null;



        	enterRule();

        try {
            // InternalYangParser.g:972:2: ( (otherlv_0= Module ( (lv_name_1_0= ruleStringValue ) ) this_StatementEnd_2= ruleStatementEnd[$current] ) )
            // InternalYangParser.g:973:2: (otherlv_0= Module ( (lv_name_1_0= ruleStringValue ) ) this_StatementEnd_2= ruleStatementEnd[$current] )
            {
            // InternalYangParser.g:973:2: (otherlv_0= Module ( (lv_name_1_0= ruleStringValue ) ) this_StatementEnd_2= ruleStatementEnd[$current] )
            // InternalYangParser.g:974:3: otherlv_0= Module ( (lv_name_1_0= ruleStringValue ) ) this_StatementEnd_2= ruleStatementEnd[$current]
            {
            otherlv_0=(Token)match(input,Module,FOLLOW_4); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getModuleAccess().getModuleKeyword_0());
              		
            }
            // InternalYangParser.g:978:3: ( (lv_name_1_0= ruleStringValue ) )
            // InternalYangParser.g:979:4: (lv_name_1_0= ruleStringValue )
            {
            // InternalYangParser.g:979:4: (lv_name_1_0= ruleStringValue )
            // InternalYangParser.g:980:5: lv_name_1_0= ruleStringValue
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getModuleAccess().getNameStringValueParserRuleCall_1_0());
              				
            }
            pushFollow(FOLLOW_5);
            lv_name_1_0=ruleStringValue();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getModuleRule());
              					}
              					set(
              						current,
              						"name",
              						lv_name_1_0,
              						"io.typefox.yang.Yang.StringValue");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            if ( state.backtracking==0 ) {

              			if (current==null) {
              				current = createModelElement(grammarAccess.getModuleRule());
              			}
              			newCompositeNode(grammarAccess.getModuleAccess().getStatementEndParserRuleCall_2());
              		
            }
            pushFollow(FOLLOW_2);
            this_StatementEnd_2=ruleStatementEnd(current);

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current = this_StatementEnd_2;
              			afterParserOrEnumRuleCall();
              		
            }

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleModule"


    // $ANTLR start "entryRuleYangVersion"
    // InternalYangParser.g:1012:1: entryRuleYangVersion returns [EObject current=null] : iv_ruleYangVersion= ruleYangVersion EOF ;
    public final EObject entryRuleYangVersion() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleYangVersion = null;


        try {
            // InternalYangParser.g:1012:52: (iv_ruleYangVersion= ruleYangVersion EOF )
            // InternalYangParser.g:1013:2: iv_ruleYangVersion= ruleYangVersion EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getYangVersionRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleYangVersion=ruleYangVersion();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleYangVersion; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleYangVersion"


    // $ANTLR start "ruleYangVersion"
    // InternalYangParser.g:1019:1: ruleYangVersion returns [EObject current=null] : (otherlv_0= YangVersion ( (lv_yangVersion_1_0= ruleStringValue ) ) this_StatementEnd_2= ruleStatementEnd[$current] ) ;
    public final EObject ruleYangVersion() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        AntlrDatatypeRuleToken lv_yangVersion_1_0 = null;

        EObject this_StatementEnd_2 = null;



        	enterRule();

        try {
            // InternalYangParser.g:1025:2: ( (otherlv_0= YangVersion ( (lv_yangVersion_1_0= ruleStringValue ) ) this_StatementEnd_2= ruleStatementEnd[$current] ) )
            // InternalYangParser.g:1026:2: (otherlv_0= YangVersion ( (lv_yangVersion_1_0= ruleStringValue ) ) this_StatementEnd_2= ruleStatementEnd[$current] )
            {
            // InternalYangParser.g:1026:2: (otherlv_0= YangVersion ( (lv_yangVersion_1_0= ruleStringValue ) ) this_StatementEnd_2= ruleStatementEnd[$current] )
            // InternalYangParser.g:1027:3: otherlv_0= YangVersion ( (lv_yangVersion_1_0= ruleStringValue ) ) this_StatementEnd_2= ruleStatementEnd[$current]
            {
            otherlv_0=(Token)match(input,YangVersion,FOLLOW_4); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getYangVersionAccess().getYangVersionKeyword_0());
              		
            }
            // InternalYangParser.g:1031:3: ( (lv_yangVersion_1_0= ruleStringValue ) )
            // InternalYangParser.g:1032:4: (lv_yangVersion_1_0= ruleStringValue )
            {
            // InternalYangParser.g:1032:4: (lv_yangVersion_1_0= ruleStringValue )
            // InternalYangParser.g:1033:5: lv_yangVersion_1_0= ruleStringValue
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getYangVersionAccess().getYangVersionStringValueParserRuleCall_1_0());
              				
            }
            pushFollow(FOLLOW_5);
            lv_yangVersion_1_0=ruleStringValue();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getYangVersionRule());
              					}
              					set(
              						current,
              						"yangVersion",
              						lv_yangVersion_1_0,
              						"io.typefox.yang.Yang.StringValue");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            if ( state.backtracking==0 ) {

              			if (current==null) {
              				current = createModelElement(grammarAccess.getYangVersionRule());
              			}
              			newCompositeNode(grammarAccess.getYangVersionAccess().getStatementEndParserRuleCall_2());
              		
            }
            pushFollow(FOLLOW_2);
            this_StatementEnd_2=ruleStatementEnd(current);

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current = this_StatementEnd_2;
              			afterParserOrEnumRuleCall();
              		
            }

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleYangVersion"


    // $ANTLR start "entryRuleNamespace"
    // InternalYangParser.g:1065:1: entryRuleNamespace returns [EObject current=null] : iv_ruleNamespace= ruleNamespace EOF ;
    public final EObject entryRuleNamespace() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNamespace = null;


        try {
            // InternalYangParser.g:1065:50: (iv_ruleNamespace= ruleNamespace EOF )
            // InternalYangParser.g:1066:2: iv_ruleNamespace= ruleNamespace EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getNamespaceRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleNamespace=ruleNamespace();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleNamespace; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleNamespace"


    // $ANTLR start "ruleNamespace"
    // InternalYangParser.g:1072:1: ruleNamespace returns [EObject current=null] : (otherlv_0= Namespace ( (lv_uri_1_0= ruleStringValue ) ) this_StatementEnd_2= ruleStatementEnd[$current] ) ;
    public final EObject ruleNamespace() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        AntlrDatatypeRuleToken lv_uri_1_0 = null;

        EObject this_StatementEnd_2 = null;



        	enterRule();

        try {
            // InternalYangParser.g:1078:2: ( (otherlv_0= Namespace ( (lv_uri_1_0= ruleStringValue ) ) this_StatementEnd_2= ruleStatementEnd[$current] ) )
            // InternalYangParser.g:1079:2: (otherlv_0= Namespace ( (lv_uri_1_0= ruleStringValue ) ) this_StatementEnd_2= ruleStatementEnd[$current] )
            {
            // InternalYangParser.g:1079:2: (otherlv_0= Namespace ( (lv_uri_1_0= ruleStringValue ) ) this_StatementEnd_2= ruleStatementEnd[$current] )
            // InternalYangParser.g:1080:3: otherlv_0= Namespace ( (lv_uri_1_0= ruleStringValue ) ) this_StatementEnd_2= ruleStatementEnd[$current]
            {
            otherlv_0=(Token)match(input,Namespace,FOLLOW_4); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getNamespaceAccess().getNamespaceKeyword_0());
              		
            }
            // InternalYangParser.g:1084:3: ( (lv_uri_1_0= ruleStringValue ) )
            // InternalYangParser.g:1085:4: (lv_uri_1_0= ruleStringValue )
            {
            // InternalYangParser.g:1085:4: (lv_uri_1_0= ruleStringValue )
            // InternalYangParser.g:1086:5: lv_uri_1_0= ruleStringValue
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getNamespaceAccess().getUriStringValueParserRuleCall_1_0());
              				
            }
            pushFollow(FOLLOW_5);
            lv_uri_1_0=ruleStringValue();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getNamespaceRule());
              					}
              					set(
              						current,
              						"uri",
              						lv_uri_1_0,
              						"io.typefox.yang.Yang.StringValue");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            if ( state.backtracking==0 ) {

              			if (current==null) {
              				current = createModelElement(grammarAccess.getNamespaceRule());
              			}
              			newCompositeNode(grammarAccess.getNamespaceAccess().getStatementEndParserRuleCall_2());
              		
            }
            pushFollow(FOLLOW_2);
            this_StatementEnd_2=ruleStatementEnd(current);

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current = this_StatementEnd_2;
              			afterParserOrEnumRuleCall();
              		
            }

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleNamespace"


    // $ANTLR start "entryRulePrefix"
    // InternalYangParser.g:1118:1: entryRulePrefix returns [EObject current=null] : iv_rulePrefix= rulePrefix EOF ;
    public final EObject entryRulePrefix() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePrefix = null;


        try {
            // InternalYangParser.g:1118:47: (iv_rulePrefix= rulePrefix EOF )
            // InternalYangParser.g:1119:2: iv_rulePrefix= rulePrefix EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getPrefixRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_rulePrefix=rulePrefix();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_rulePrefix; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulePrefix"


    // $ANTLR start "rulePrefix"
    // InternalYangParser.g:1125:1: rulePrefix returns [EObject current=null] : (otherlv_0= Prefix ( (lv_prefix_1_0= ruleStringValue ) ) this_StatementEnd_2= ruleStatementEnd[$current] ) ;
    public final EObject rulePrefix() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        AntlrDatatypeRuleToken lv_prefix_1_0 = null;

        EObject this_StatementEnd_2 = null;



        	enterRule();

        try {
            // InternalYangParser.g:1131:2: ( (otherlv_0= Prefix ( (lv_prefix_1_0= ruleStringValue ) ) this_StatementEnd_2= ruleStatementEnd[$current] ) )
            // InternalYangParser.g:1132:2: (otherlv_0= Prefix ( (lv_prefix_1_0= ruleStringValue ) ) this_StatementEnd_2= ruleStatementEnd[$current] )
            {
            // InternalYangParser.g:1132:2: (otherlv_0= Prefix ( (lv_prefix_1_0= ruleStringValue ) ) this_StatementEnd_2= ruleStatementEnd[$current] )
            // InternalYangParser.g:1133:3: otherlv_0= Prefix ( (lv_prefix_1_0= ruleStringValue ) ) this_StatementEnd_2= ruleStatementEnd[$current]
            {
            otherlv_0=(Token)match(input,Prefix,FOLLOW_4); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getPrefixAccess().getPrefixKeyword_0());
              		
            }
            // InternalYangParser.g:1137:3: ( (lv_prefix_1_0= ruleStringValue ) )
            // InternalYangParser.g:1138:4: (lv_prefix_1_0= ruleStringValue )
            {
            // InternalYangParser.g:1138:4: (lv_prefix_1_0= ruleStringValue )
            // InternalYangParser.g:1139:5: lv_prefix_1_0= ruleStringValue
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getPrefixAccess().getPrefixStringValueParserRuleCall_1_0());
              				
            }
            pushFollow(FOLLOW_5);
            lv_prefix_1_0=ruleStringValue();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getPrefixRule());
              					}
              					set(
              						current,
              						"prefix",
              						lv_prefix_1_0,
              						"io.typefox.yang.Yang.StringValue");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            if ( state.backtracking==0 ) {

              			if (current==null) {
              				current = createModelElement(grammarAccess.getPrefixRule());
              			}
              			newCompositeNode(grammarAccess.getPrefixAccess().getStatementEndParserRuleCall_2());
              		
            }
            pushFollow(FOLLOW_2);
            this_StatementEnd_2=ruleStatementEnd(current);

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current = this_StatementEnd_2;
              			afterParserOrEnumRuleCall();
              		
            }

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "rulePrefix"


    // $ANTLR start "entryRuleImport"
    // InternalYangParser.g:1171:1: entryRuleImport returns [EObject current=null] : iv_ruleImport= ruleImport EOF ;
    public final EObject entryRuleImport() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleImport = null;


        try {
            // InternalYangParser.g:1171:47: (iv_ruleImport= ruleImport EOF )
            // InternalYangParser.g:1172:2: iv_ruleImport= ruleImport EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getImportRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleImport=ruleImport();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleImport; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleImport"


    // $ANTLR start "ruleImport"
    // InternalYangParser.g:1178:1: ruleImport returns [EObject current=null] : (otherlv_0= Import ( ( ruleStringValue ) ) this_StatementEnd_2= ruleStatementEnd[$current] ) ;
    public final EObject ruleImport() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        EObject this_StatementEnd_2 = null;



        	enterRule();

        try {
            // InternalYangParser.g:1184:2: ( (otherlv_0= Import ( ( ruleStringValue ) ) this_StatementEnd_2= ruleStatementEnd[$current] ) )
            // InternalYangParser.g:1185:2: (otherlv_0= Import ( ( ruleStringValue ) ) this_StatementEnd_2= ruleStatementEnd[$current] )
            {
            // InternalYangParser.g:1185:2: (otherlv_0= Import ( ( ruleStringValue ) ) this_StatementEnd_2= ruleStatementEnd[$current] )
            // InternalYangParser.g:1186:3: otherlv_0= Import ( ( ruleStringValue ) ) this_StatementEnd_2= ruleStatementEnd[$current]
            {
            otherlv_0=(Token)match(input,Import,FOLLOW_4); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getImportAccess().getImportKeyword_0());
              		
            }
            // InternalYangParser.g:1190:3: ( ( ruleStringValue ) )
            // InternalYangParser.g:1191:4: ( ruleStringValue )
            {
            // InternalYangParser.g:1191:4: ( ruleStringValue )
            // InternalYangParser.g:1192:5: ruleStringValue
            {
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElement(grammarAccess.getImportRule());
              					}
              				
            }
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getImportAccess().getModuleAbstractModuleCrossReference_1_0());
              				
            }
            pushFollow(FOLLOW_5);
            ruleStringValue();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            if ( state.backtracking==0 ) {

              			if (current==null) {
              				current = createModelElement(grammarAccess.getImportRule());
              			}
              			newCompositeNode(grammarAccess.getImportAccess().getStatementEndParserRuleCall_2());
              		
            }
            pushFollow(FOLLOW_2);
            this_StatementEnd_2=ruleStatementEnd(current);

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current = this_StatementEnd_2;
              			afterParserOrEnumRuleCall();
              		
            }

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleImport"


    // $ANTLR start "entryRuleRevisionDate"
    // InternalYangParser.g:1221:1: entryRuleRevisionDate returns [EObject current=null] : iv_ruleRevisionDate= ruleRevisionDate EOF ;
    public final EObject entryRuleRevisionDate() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRevisionDate = null;


        try {
            // InternalYangParser.g:1221:53: (iv_ruleRevisionDate= ruleRevisionDate EOF )
            // InternalYangParser.g:1222:2: iv_ruleRevisionDate= ruleRevisionDate EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getRevisionDateRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleRevisionDate=ruleRevisionDate();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleRevisionDate; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleRevisionDate"


    // $ANTLR start "ruleRevisionDate"
    // InternalYangParser.g:1228:1: ruleRevisionDate returns [EObject current=null] : (otherlv_0= RevisionDate ( ( ruleStringValue ) ) this_StatementEnd_2= ruleStatementEnd[$current] ) ;
    public final EObject ruleRevisionDate() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        EObject this_StatementEnd_2 = null;



        	enterRule();

        try {
            // InternalYangParser.g:1234:2: ( (otherlv_0= RevisionDate ( ( ruleStringValue ) ) this_StatementEnd_2= ruleStatementEnd[$current] ) )
            // InternalYangParser.g:1235:2: (otherlv_0= RevisionDate ( ( ruleStringValue ) ) this_StatementEnd_2= ruleStatementEnd[$current] )
            {
            // InternalYangParser.g:1235:2: (otherlv_0= RevisionDate ( ( ruleStringValue ) ) this_StatementEnd_2= ruleStatementEnd[$current] )
            // InternalYangParser.g:1236:3: otherlv_0= RevisionDate ( ( ruleStringValue ) ) this_StatementEnd_2= ruleStatementEnd[$current]
            {
            otherlv_0=(Token)match(input,RevisionDate,FOLLOW_4); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getRevisionDateAccess().getRevisionDateKeyword_0());
              		
            }
            // InternalYangParser.g:1240:3: ( ( ruleStringValue ) )
            // InternalYangParser.g:1241:4: ( ruleStringValue )
            {
            // InternalYangParser.g:1241:4: ( ruleStringValue )
            // InternalYangParser.g:1242:5: ruleStringValue
            {
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElement(grammarAccess.getRevisionDateRule());
              					}
              				
            }
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getRevisionDateAccess().getDateRevisionCrossReference_1_0());
              				
            }
            pushFollow(FOLLOW_5);
            ruleStringValue();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            if ( state.backtracking==0 ) {

              			if (current==null) {
              				current = createModelElement(grammarAccess.getRevisionDateRule());
              			}
              			newCompositeNode(grammarAccess.getRevisionDateAccess().getStatementEndParserRuleCall_2());
              		
            }
            pushFollow(FOLLOW_2);
            this_StatementEnd_2=ruleStatementEnd(current);

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current = this_StatementEnd_2;
              			afterParserOrEnumRuleCall();
              		
            }

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleRevisionDate"


    // $ANTLR start "entryRuleInclude"
    // InternalYangParser.g:1271:1: entryRuleInclude returns [EObject current=null] : iv_ruleInclude= ruleInclude EOF ;
    public final EObject entryRuleInclude() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleInclude = null;


        try {
            // InternalYangParser.g:1271:48: (iv_ruleInclude= ruleInclude EOF )
            // InternalYangParser.g:1272:2: iv_ruleInclude= ruleInclude EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getIncludeRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleInclude=ruleInclude();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleInclude; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleInclude"


    // $ANTLR start "ruleInclude"
    // InternalYangParser.g:1278:1: ruleInclude returns [EObject current=null] : (otherlv_0= Include ( ( ruleStringValue ) ) this_StatementEnd_2= ruleStatementEnd[$current] ) ;
    public final EObject ruleInclude() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        EObject this_StatementEnd_2 = null;



        	enterRule();

        try {
            // InternalYangParser.g:1284:2: ( (otherlv_0= Include ( ( ruleStringValue ) ) this_StatementEnd_2= ruleStatementEnd[$current] ) )
            // InternalYangParser.g:1285:2: (otherlv_0= Include ( ( ruleStringValue ) ) this_StatementEnd_2= ruleStatementEnd[$current] )
            {
            // InternalYangParser.g:1285:2: (otherlv_0= Include ( ( ruleStringValue ) ) this_StatementEnd_2= ruleStatementEnd[$current] )
            // InternalYangParser.g:1286:3: otherlv_0= Include ( ( ruleStringValue ) ) this_StatementEnd_2= ruleStatementEnd[$current]
            {
            otherlv_0=(Token)match(input,Include,FOLLOW_4); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getIncludeAccess().getIncludeKeyword_0());
              		
            }
            // InternalYangParser.g:1290:3: ( ( ruleStringValue ) )
            // InternalYangParser.g:1291:4: ( ruleStringValue )
            {
            // InternalYangParser.g:1291:4: ( ruleStringValue )
            // InternalYangParser.g:1292:5: ruleStringValue
            {
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElement(grammarAccess.getIncludeRule());
              					}
              				
            }
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getIncludeAccess().getModuleAbstractModuleCrossReference_1_0());
              				
            }
            pushFollow(FOLLOW_5);
            ruleStringValue();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            if ( state.backtracking==0 ) {

              			if (current==null) {
              				current = createModelElement(grammarAccess.getIncludeRule());
              			}
              			newCompositeNode(grammarAccess.getIncludeAccess().getStatementEndParserRuleCall_2());
              		
            }
            pushFollow(FOLLOW_2);
            this_StatementEnd_2=ruleStatementEnd(current);

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current = this_StatementEnd_2;
              			afterParserOrEnumRuleCall();
              		
            }

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleInclude"


    // $ANTLR start "entryRuleOrganization"
    // InternalYangParser.g:1321:1: entryRuleOrganization returns [EObject current=null] : iv_ruleOrganization= ruleOrganization EOF ;
    public final EObject entryRuleOrganization() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleOrganization = null;


        try {
            // InternalYangParser.g:1321:53: (iv_ruleOrganization= ruleOrganization EOF )
            // InternalYangParser.g:1322:2: iv_ruleOrganization= ruleOrganization EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getOrganizationRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleOrganization=ruleOrganization();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleOrganization; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleOrganization"


    // $ANTLR start "ruleOrganization"
    // InternalYangParser.g:1328:1: ruleOrganization returns [EObject current=null] : (otherlv_0= Organization ( (lv_organization_1_0= ruleStringValue ) ) this_StatementEnd_2= ruleStatementEnd[$current] ) ;
    public final EObject ruleOrganization() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        AntlrDatatypeRuleToken lv_organization_1_0 = null;

        EObject this_StatementEnd_2 = null;



        	enterRule();

        try {
            // InternalYangParser.g:1334:2: ( (otherlv_0= Organization ( (lv_organization_1_0= ruleStringValue ) ) this_StatementEnd_2= ruleStatementEnd[$current] ) )
            // InternalYangParser.g:1335:2: (otherlv_0= Organization ( (lv_organization_1_0= ruleStringValue ) ) this_StatementEnd_2= ruleStatementEnd[$current] )
            {
            // InternalYangParser.g:1335:2: (otherlv_0= Organization ( (lv_organization_1_0= ruleStringValue ) ) this_StatementEnd_2= ruleStatementEnd[$current] )
            // InternalYangParser.g:1336:3: otherlv_0= Organization ( (lv_organization_1_0= ruleStringValue ) ) this_StatementEnd_2= ruleStatementEnd[$current]
            {
            otherlv_0=(Token)match(input,Organization,FOLLOW_4); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getOrganizationAccess().getOrganizationKeyword_0());
              		
            }
            // InternalYangParser.g:1340:3: ( (lv_organization_1_0= ruleStringValue ) )
            // InternalYangParser.g:1341:4: (lv_organization_1_0= ruleStringValue )
            {
            // InternalYangParser.g:1341:4: (lv_organization_1_0= ruleStringValue )
            // InternalYangParser.g:1342:5: lv_organization_1_0= ruleStringValue
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getOrganizationAccess().getOrganizationStringValueParserRuleCall_1_0());
              				
            }
            pushFollow(FOLLOW_5);
            lv_organization_1_0=ruleStringValue();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getOrganizationRule());
              					}
              					set(
              						current,
              						"organization",
              						lv_organization_1_0,
              						"io.typefox.yang.Yang.StringValue");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            if ( state.backtracking==0 ) {

              			if (current==null) {
              				current = createModelElement(grammarAccess.getOrganizationRule());
              			}
              			newCompositeNode(grammarAccess.getOrganizationAccess().getStatementEndParserRuleCall_2());
              		
            }
            pushFollow(FOLLOW_2);
            this_StatementEnd_2=ruleStatementEnd(current);

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current = this_StatementEnd_2;
              			afterParserOrEnumRuleCall();
              		
            }

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleOrganization"


    // $ANTLR start "entryRuleContact"
    // InternalYangParser.g:1374:1: entryRuleContact returns [EObject current=null] : iv_ruleContact= ruleContact EOF ;
    public final EObject entryRuleContact() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleContact = null;


        try {
            // InternalYangParser.g:1374:48: (iv_ruleContact= ruleContact EOF )
            // InternalYangParser.g:1375:2: iv_ruleContact= ruleContact EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getContactRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleContact=ruleContact();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleContact; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleContact"


    // $ANTLR start "ruleContact"
    // InternalYangParser.g:1381:1: ruleContact returns [EObject current=null] : (otherlv_0= Contact ( (lv_contact_1_0= ruleStringValue ) ) this_StatementEnd_2= ruleStatementEnd[$current] ) ;
    public final EObject ruleContact() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        AntlrDatatypeRuleToken lv_contact_1_0 = null;

        EObject this_StatementEnd_2 = null;



        	enterRule();

        try {
            // InternalYangParser.g:1387:2: ( (otherlv_0= Contact ( (lv_contact_1_0= ruleStringValue ) ) this_StatementEnd_2= ruleStatementEnd[$current] ) )
            // InternalYangParser.g:1388:2: (otherlv_0= Contact ( (lv_contact_1_0= ruleStringValue ) ) this_StatementEnd_2= ruleStatementEnd[$current] )
            {
            // InternalYangParser.g:1388:2: (otherlv_0= Contact ( (lv_contact_1_0= ruleStringValue ) ) this_StatementEnd_2= ruleStatementEnd[$current] )
            // InternalYangParser.g:1389:3: otherlv_0= Contact ( (lv_contact_1_0= ruleStringValue ) ) this_StatementEnd_2= ruleStatementEnd[$current]
            {
            otherlv_0=(Token)match(input,Contact,FOLLOW_4); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getContactAccess().getContactKeyword_0());
              		
            }
            // InternalYangParser.g:1393:3: ( (lv_contact_1_0= ruleStringValue ) )
            // InternalYangParser.g:1394:4: (lv_contact_1_0= ruleStringValue )
            {
            // InternalYangParser.g:1394:4: (lv_contact_1_0= ruleStringValue )
            // InternalYangParser.g:1395:5: lv_contact_1_0= ruleStringValue
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getContactAccess().getContactStringValueParserRuleCall_1_0());
              				
            }
            pushFollow(FOLLOW_5);
            lv_contact_1_0=ruleStringValue();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getContactRule());
              					}
              					set(
              						current,
              						"contact",
              						lv_contact_1_0,
              						"io.typefox.yang.Yang.StringValue");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            if ( state.backtracking==0 ) {

              			if (current==null) {
              				current = createModelElement(grammarAccess.getContactRule());
              			}
              			newCompositeNode(grammarAccess.getContactAccess().getStatementEndParserRuleCall_2());
              		
            }
            pushFollow(FOLLOW_2);
            this_StatementEnd_2=ruleStatementEnd(current);

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current = this_StatementEnd_2;
              			afterParserOrEnumRuleCall();
              		
            }

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleContact"


    // $ANTLR start "entryRuleRevision"
    // InternalYangParser.g:1427:1: entryRuleRevision returns [EObject current=null] : iv_ruleRevision= ruleRevision EOF ;
    public final EObject entryRuleRevision() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRevision = null;


        try {
            // InternalYangParser.g:1427:49: (iv_ruleRevision= ruleRevision EOF )
            // InternalYangParser.g:1428:2: iv_ruleRevision= ruleRevision EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getRevisionRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleRevision=ruleRevision();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleRevision; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleRevision"


    // $ANTLR start "ruleRevision"
    // InternalYangParser.g:1434:1: ruleRevision returns [EObject current=null] : (otherlv_0= Revision ( (lv_revision_1_0= ruleStringValue ) ) this_StatementEnd_2= ruleStatementEnd[$current] ) ;
    public final EObject ruleRevision() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        AntlrDatatypeRuleToken lv_revision_1_0 = null;

        EObject this_StatementEnd_2 = null;



        	enterRule();

        try {
            // InternalYangParser.g:1440:2: ( (otherlv_0= Revision ( (lv_revision_1_0= ruleStringValue ) ) this_StatementEnd_2= ruleStatementEnd[$current] ) )
            // InternalYangParser.g:1441:2: (otherlv_0= Revision ( (lv_revision_1_0= ruleStringValue ) ) this_StatementEnd_2= ruleStatementEnd[$current] )
            {
            // InternalYangParser.g:1441:2: (otherlv_0= Revision ( (lv_revision_1_0= ruleStringValue ) ) this_StatementEnd_2= ruleStatementEnd[$current] )
            // InternalYangParser.g:1442:3: otherlv_0= Revision ( (lv_revision_1_0= ruleStringValue ) ) this_StatementEnd_2= ruleStatementEnd[$current]
            {
            otherlv_0=(Token)match(input,Revision,FOLLOW_4); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getRevisionAccess().getRevisionKeyword_0());
              		
            }
            // InternalYangParser.g:1446:3: ( (lv_revision_1_0= ruleStringValue ) )
            // InternalYangParser.g:1447:4: (lv_revision_1_0= ruleStringValue )
            {
            // InternalYangParser.g:1447:4: (lv_revision_1_0= ruleStringValue )
            // InternalYangParser.g:1448:5: lv_revision_1_0= ruleStringValue
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getRevisionAccess().getRevisionStringValueParserRuleCall_1_0());
              				
            }
            pushFollow(FOLLOW_5);
            lv_revision_1_0=ruleStringValue();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getRevisionRule());
              					}
              					set(
              						current,
              						"revision",
              						lv_revision_1_0,
              						"io.typefox.yang.Yang.StringValue");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            if ( state.backtracking==0 ) {

              			if (current==null) {
              				current = createModelElement(grammarAccess.getRevisionRule());
              			}
              			newCompositeNode(grammarAccess.getRevisionAccess().getStatementEndParserRuleCall_2());
              		
            }
            pushFollow(FOLLOW_2);
            this_StatementEnd_2=ruleStatementEnd(current);

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current = this_StatementEnd_2;
              			afterParserOrEnumRuleCall();
              		
            }

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleRevision"


    // $ANTLR start "entryRuleSubmodule"
    // InternalYangParser.g:1480:1: entryRuleSubmodule returns [EObject current=null] : iv_ruleSubmodule= ruleSubmodule EOF ;
    public final EObject entryRuleSubmodule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSubmodule = null;


        try {
            // InternalYangParser.g:1480:50: (iv_ruleSubmodule= ruleSubmodule EOF )
            // InternalYangParser.g:1481:2: iv_ruleSubmodule= ruleSubmodule EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getSubmoduleRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleSubmodule=ruleSubmodule();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleSubmodule; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleSubmodule"


    // $ANTLR start "ruleSubmodule"
    // InternalYangParser.g:1487:1: ruleSubmodule returns [EObject current=null] : (otherlv_0= Submodule ( (lv_name_1_0= ruleStringValue ) ) this_StatementEnd_2= ruleStatementEnd[$current] ) ;
    public final EObject ruleSubmodule() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        AntlrDatatypeRuleToken lv_name_1_0 = null;

        EObject this_StatementEnd_2 = null;



        	enterRule();

        try {
            // InternalYangParser.g:1493:2: ( (otherlv_0= Submodule ( (lv_name_1_0= ruleStringValue ) ) this_StatementEnd_2= ruleStatementEnd[$current] ) )
            // InternalYangParser.g:1494:2: (otherlv_0= Submodule ( (lv_name_1_0= ruleStringValue ) ) this_StatementEnd_2= ruleStatementEnd[$current] )
            {
            // InternalYangParser.g:1494:2: (otherlv_0= Submodule ( (lv_name_1_0= ruleStringValue ) ) this_StatementEnd_2= ruleStatementEnd[$current] )
            // InternalYangParser.g:1495:3: otherlv_0= Submodule ( (lv_name_1_0= ruleStringValue ) ) this_StatementEnd_2= ruleStatementEnd[$current]
            {
            otherlv_0=(Token)match(input,Submodule,FOLLOW_4); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getSubmoduleAccess().getSubmoduleKeyword_0());
              		
            }
            // InternalYangParser.g:1499:3: ( (lv_name_1_0= ruleStringValue ) )
            // InternalYangParser.g:1500:4: (lv_name_1_0= ruleStringValue )
            {
            // InternalYangParser.g:1500:4: (lv_name_1_0= ruleStringValue )
            // InternalYangParser.g:1501:5: lv_name_1_0= ruleStringValue
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getSubmoduleAccess().getNameStringValueParserRuleCall_1_0());
              				
            }
            pushFollow(FOLLOW_5);
            lv_name_1_0=ruleStringValue();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getSubmoduleRule());
              					}
              					set(
              						current,
              						"name",
              						lv_name_1_0,
              						"io.typefox.yang.Yang.StringValue");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            if ( state.backtracking==0 ) {

              			if (current==null) {
              				current = createModelElement(grammarAccess.getSubmoduleRule());
              			}
              			newCompositeNode(grammarAccess.getSubmoduleAccess().getStatementEndParserRuleCall_2());
              		
            }
            pushFollow(FOLLOW_2);
            this_StatementEnd_2=ruleStatementEnd(current);

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current = this_StatementEnd_2;
              			afterParserOrEnumRuleCall();
              		
            }

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleSubmodule"


    // $ANTLR start "entryRuleBelongsTo"
    // InternalYangParser.g:1533:1: entryRuleBelongsTo returns [EObject current=null] : iv_ruleBelongsTo= ruleBelongsTo EOF ;
    public final EObject entryRuleBelongsTo() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBelongsTo = null;


        try {
            // InternalYangParser.g:1533:50: (iv_ruleBelongsTo= ruleBelongsTo EOF )
            // InternalYangParser.g:1534:2: iv_ruleBelongsTo= ruleBelongsTo EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getBelongsToRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleBelongsTo=ruleBelongsTo();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleBelongsTo; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleBelongsTo"


    // $ANTLR start "ruleBelongsTo"
    // InternalYangParser.g:1540:1: ruleBelongsTo returns [EObject current=null] : (otherlv_0= BelongsTo ( ( ruleStringValue ) ) this_StatementEnd_2= ruleStatementEnd[$current] ) ;
    public final EObject ruleBelongsTo() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        EObject this_StatementEnd_2 = null;



        	enterRule();

        try {
            // InternalYangParser.g:1546:2: ( (otherlv_0= BelongsTo ( ( ruleStringValue ) ) this_StatementEnd_2= ruleStatementEnd[$current] ) )
            // InternalYangParser.g:1547:2: (otherlv_0= BelongsTo ( ( ruleStringValue ) ) this_StatementEnd_2= ruleStatementEnd[$current] )
            {
            // InternalYangParser.g:1547:2: (otherlv_0= BelongsTo ( ( ruleStringValue ) ) this_StatementEnd_2= ruleStatementEnd[$current] )
            // InternalYangParser.g:1548:3: otherlv_0= BelongsTo ( ( ruleStringValue ) ) this_StatementEnd_2= ruleStatementEnd[$current]
            {
            otherlv_0=(Token)match(input,BelongsTo,FOLLOW_4); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getBelongsToAccess().getBelongsToKeyword_0());
              		
            }
            // InternalYangParser.g:1552:3: ( ( ruleStringValue ) )
            // InternalYangParser.g:1553:4: ( ruleStringValue )
            {
            // InternalYangParser.g:1553:4: ( ruleStringValue )
            // InternalYangParser.g:1554:5: ruleStringValue
            {
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElement(grammarAccess.getBelongsToRule());
              					}
              				
            }
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getBelongsToAccess().getModuleModuleCrossReference_1_0());
              				
            }
            pushFollow(FOLLOW_5);
            ruleStringValue();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            if ( state.backtracking==0 ) {

              			if (current==null) {
              				current = createModelElement(grammarAccess.getBelongsToRule());
              			}
              			newCompositeNode(grammarAccess.getBelongsToAccess().getStatementEndParserRuleCall_2());
              		
            }
            pushFollow(FOLLOW_2);
            this_StatementEnd_2=ruleStatementEnd(current);

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current = this_StatementEnd_2;
              			afterParserOrEnumRuleCall();
              		
            }

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleBelongsTo"


    // $ANTLR start "entryRuleTypedef"
    // InternalYangParser.g:1583:1: entryRuleTypedef returns [EObject current=null] : iv_ruleTypedef= ruleTypedef EOF ;
    public final EObject entryRuleTypedef() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTypedef = null;


        try {
            // InternalYangParser.g:1583:48: (iv_ruleTypedef= ruleTypedef EOF )
            // InternalYangParser.g:1584:2: iv_ruleTypedef= ruleTypedef EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getTypedefRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleTypedef=ruleTypedef();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleTypedef; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleTypedef"


    // $ANTLR start "ruleTypedef"
    // InternalYangParser.g:1590:1: ruleTypedef returns [EObject current=null] : (otherlv_0= Typedef ( (lv_name_1_0= ruleStringValue ) ) this_StatementEnd_2= ruleStatementEnd[$current] ) ;
    public final EObject ruleTypedef() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        AntlrDatatypeRuleToken lv_name_1_0 = null;

        EObject this_StatementEnd_2 = null;



        	enterRule();

        try {
            // InternalYangParser.g:1596:2: ( (otherlv_0= Typedef ( (lv_name_1_0= ruleStringValue ) ) this_StatementEnd_2= ruleStatementEnd[$current] ) )
            // InternalYangParser.g:1597:2: (otherlv_0= Typedef ( (lv_name_1_0= ruleStringValue ) ) this_StatementEnd_2= ruleStatementEnd[$current] )
            {
            // InternalYangParser.g:1597:2: (otherlv_0= Typedef ( (lv_name_1_0= ruleStringValue ) ) this_StatementEnd_2= ruleStatementEnd[$current] )
            // InternalYangParser.g:1598:3: otherlv_0= Typedef ( (lv_name_1_0= ruleStringValue ) ) this_StatementEnd_2= ruleStatementEnd[$current]
            {
            otherlv_0=(Token)match(input,Typedef,FOLLOW_4); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getTypedefAccess().getTypedefKeyword_0());
              		
            }
            // InternalYangParser.g:1602:3: ( (lv_name_1_0= ruleStringValue ) )
            // InternalYangParser.g:1603:4: (lv_name_1_0= ruleStringValue )
            {
            // InternalYangParser.g:1603:4: (lv_name_1_0= ruleStringValue )
            // InternalYangParser.g:1604:5: lv_name_1_0= ruleStringValue
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getTypedefAccess().getNameStringValueParserRuleCall_1_0());
              				
            }
            pushFollow(FOLLOW_5);
            lv_name_1_0=ruleStringValue();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getTypedefRule());
              					}
              					set(
              						current,
              						"name",
              						lv_name_1_0,
              						"io.typefox.yang.Yang.StringValue");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            if ( state.backtracking==0 ) {

              			if (current==null) {
              				current = createModelElement(grammarAccess.getTypedefRule());
              			}
              			newCompositeNode(grammarAccess.getTypedefAccess().getStatementEndParserRuleCall_2());
              		
            }
            pushFollow(FOLLOW_2);
            this_StatementEnd_2=ruleStatementEnd(current);

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current = this_StatementEnd_2;
              			afterParserOrEnumRuleCall();
              		
            }

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleTypedef"


    // $ANTLR start "entryRuleUnits"
    // InternalYangParser.g:1636:1: entryRuleUnits returns [EObject current=null] : iv_ruleUnits= ruleUnits EOF ;
    public final EObject entryRuleUnits() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleUnits = null;


        try {
            // InternalYangParser.g:1636:46: (iv_ruleUnits= ruleUnits EOF )
            // InternalYangParser.g:1637:2: iv_ruleUnits= ruleUnits EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getUnitsRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleUnits=ruleUnits();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleUnits; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleUnits"


    // $ANTLR start "ruleUnits"
    // InternalYangParser.g:1643:1: ruleUnits returns [EObject current=null] : (otherlv_0= Units ( (lv_definition_1_0= ruleStringValue ) ) this_StatementEnd_2= ruleStatementEnd[$current] ) ;
    public final EObject ruleUnits() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        AntlrDatatypeRuleToken lv_definition_1_0 = null;

        EObject this_StatementEnd_2 = null;



        	enterRule();

        try {
            // InternalYangParser.g:1649:2: ( (otherlv_0= Units ( (lv_definition_1_0= ruleStringValue ) ) this_StatementEnd_2= ruleStatementEnd[$current] ) )
            // InternalYangParser.g:1650:2: (otherlv_0= Units ( (lv_definition_1_0= ruleStringValue ) ) this_StatementEnd_2= ruleStatementEnd[$current] )
            {
            // InternalYangParser.g:1650:2: (otherlv_0= Units ( (lv_definition_1_0= ruleStringValue ) ) this_StatementEnd_2= ruleStatementEnd[$current] )
            // InternalYangParser.g:1651:3: otherlv_0= Units ( (lv_definition_1_0= ruleStringValue ) ) this_StatementEnd_2= ruleStatementEnd[$current]
            {
            otherlv_0=(Token)match(input,Units,FOLLOW_4); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getUnitsAccess().getUnitsKeyword_0());
              		
            }
            // InternalYangParser.g:1655:3: ( (lv_definition_1_0= ruleStringValue ) )
            // InternalYangParser.g:1656:4: (lv_definition_1_0= ruleStringValue )
            {
            // InternalYangParser.g:1656:4: (lv_definition_1_0= ruleStringValue )
            // InternalYangParser.g:1657:5: lv_definition_1_0= ruleStringValue
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getUnitsAccess().getDefinitionStringValueParserRuleCall_1_0());
              				
            }
            pushFollow(FOLLOW_5);
            lv_definition_1_0=ruleStringValue();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getUnitsRule());
              					}
              					set(
              						current,
              						"definition",
              						lv_definition_1_0,
              						"io.typefox.yang.Yang.StringValue");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            if ( state.backtracking==0 ) {

              			if (current==null) {
              				current = createModelElement(grammarAccess.getUnitsRule());
              			}
              			newCompositeNode(grammarAccess.getUnitsAccess().getStatementEndParserRuleCall_2());
              		
            }
            pushFollow(FOLLOW_2);
            this_StatementEnd_2=ruleStatementEnd(current);

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current = this_StatementEnd_2;
              			afterParserOrEnumRuleCall();
              		
            }

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleUnits"


    // $ANTLR start "entryRuleDefault"
    // InternalYangParser.g:1689:1: entryRuleDefault returns [EObject current=null] : iv_ruleDefault= ruleDefault EOF ;
    public final EObject entryRuleDefault() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDefault = null;


        try {
            // InternalYangParser.g:1689:48: (iv_ruleDefault= ruleDefault EOF )
            // InternalYangParser.g:1690:2: iv_ruleDefault= ruleDefault EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getDefaultRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleDefault=ruleDefault();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleDefault; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleDefault"


    // $ANTLR start "ruleDefault"
    // InternalYangParser.g:1696:1: ruleDefault returns [EObject current=null] : (otherlv_0= Default ( (lv_defaultStringValue_1_0= ruleStringValue ) ) this_StatementEnd_2= ruleStatementEnd[$current] ) ;
    public final EObject ruleDefault() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        AntlrDatatypeRuleToken lv_defaultStringValue_1_0 = null;

        EObject this_StatementEnd_2 = null;



        	enterRule();

        try {
            // InternalYangParser.g:1702:2: ( (otherlv_0= Default ( (lv_defaultStringValue_1_0= ruleStringValue ) ) this_StatementEnd_2= ruleStatementEnd[$current] ) )
            // InternalYangParser.g:1703:2: (otherlv_0= Default ( (lv_defaultStringValue_1_0= ruleStringValue ) ) this_StatementEnd_2= ruleStatementEnd[$current] )
            {
            // InternalYangParser.g:1703:2: (otherlv_0= Default ( (lv_defaultStringValue_1_0= ruleStringValue ) ) this_StatementEnd_2= ruleStatementEnd[$current] )
            // InternalYangParser.g:1704:3: otherlv_0= Default ( (lv_defaultStringValue_1_0= ruleStringValue ) ) this_StatementEnd_2= ruleStatementEnd[$current]
            {
            otherlv_0=(Token)match(input,Default,FOLLOW_4); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getDefaultAccess().getDefaultKeyword_0());
              		
            }
            // InternalYangParser.g:1708:3: ( (lv_defaultStringValue_1_0= ruleStringValue ) )
            // InternalYangParser.g:1709:4: (lv_defaultStringValue_1_0= ruleStringValue )
            {
            // InternalYangParser.g:1709:4: (lv_defaultStringValue_1_0= ruleStringValue )
            // InternalYangParser.g:1710:5: lv_defaultStringValue_1_0= ruleStringValue
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getDefaultAccess().getDefaultStringValueStringValueParserRuleCall_1_0());
              				
            }
            pushFollow(FOLLOW_5);
            lv_defaultStringValue_1_0=ruleStringValue();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getDefaultRule());
              					}
              					set(
              						current,
              						"defaultStringValue",
              						lv_defaultStringValue_1_0,
              						"io.typefox.yang.Yang.StringValue");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            if ( state.backtracking==0 ) {

              			if (current==null) {
              				current = createModelElement(grammarAccess.getDefaultRule());
              			}
              			newCompositeNode(grammarAccess.getDefaultAccess().getStatementEndParserRuleCall_2());
              		
            }
            pushFollow(FOLLOW_2);
            this_StatementEnd_2=ruleStatementEnd(current);

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current = this_StatementEnd_2;
              			afterParserOrEnumRuleCall();
              		
            }

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleDefault"


    // $ANTLR start "entryRuleType"
    // InternalYangParser.g:1742:1: entryRuleType returns [EObject current=null] : iv_ruleType= ruleType EOF ;
    public final EObject entryRuleType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleType = null;


        try {
            // InternalYangParser.g:1742:45: (iv_ruleType= ruleType EOF )
            // InternalYangParser.g:1743:2: iv_ruleType= ruleType EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getTypeRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleType=ruleType();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleType; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleType"


    // $ANTLR start "ruleType"
    // InternalYangParser.g:1749:1: ruleType returns [EObject current=null] : (otherlv_0= Type ( (lv_typeRef_1_0= ruleTypeReference ) ) this_StatementEnd_2= ruleStatementEnd[$current] ) ;
    public final EObject ruleType() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        EObject lv_typeRef_1_0 = null;

        EObject this_StatementEnd_2 = null;



        	enterRule();

        try {
            // InternalYangParser.g:1755:2: ( (otherlv_0= Type ( (lv_typeRef_1_0= ruleTypeReference ) ) this_StatementEnd_2= ruleStatementEnd[$current] ) )
            // InternalYangParser.g:1756:2: (otherlv_0= Type ( (lv_typeRef_1_0= ruleTypeReference ) ) this_StatementEnd_2= ruleStatementEnd[$current] )
            {
            // InternalYangParser.g:1756:2: (otherlv_0= Type ( (lv_typeRef_1_0= ruleTypeReference ) ) this_StatementEnd_2= ruleStatementEnd[$current] )
            // InternalYangParser.g:1757:3: otherlv_0= Type ( (lv_typeRef_1_0= ruleTypeReference ) ) this_StatementEnd_2= ruleStatementEnd[$current]
            {
            otherlv_0=(Token)match(input,Type,FOLLOW_6); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getTypeAccess().getTypeKeyword_0());
              		
            }
            // InternalYangParser.g:1761:3: ( (lv_typeRef_1_0= ruleTypeReference ) )
            // InternalYangParser.g:1762:4: (lv_typeRef_1_0= ruleTypeReference )
            {
            // InternalYangParser.g:1762:4: (lv_typeRef_1_0= ruleTypeReference )
            // InternalYangParser.g:1763:5: lv_typeRef_1_0= ruleTypeReference
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getTypeAccess().getTypeRefTypeReferenceParserRuleCall_1_0());
              				
            }
            pushFollow(FOLLOW_5);
            lv_typeRef_1_0=ruleTypeReference();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getTypeRule());
              					}
              					set(
              						current,
              						"typeRef",
              						lv_typeRef_1_0,
              						"io.typefox.yang.Yang.TypeReference");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            if ( state.backtracking==0 ) {

              			if (current==null) {
              				current = createModelElement(grammarAccess.getTypeRule());
              			}
              			newCompositeNode(grammarAccess.getTypeAccess().getStatementEndParserRuleCall_2());
              		
            }
            pushFollow(FOLLOW_2);
            this_StatementEnd_2=ruleStatementEnd(current);

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current = this_StatementEnd_2;
              			afterParserOrEnumRuleCall();
              		
            }

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleType"


    // $ANTLR start "entryRuleTypeReference"
    // InternalYangParser.g:1795:1: entryRuleTypeReference returns [EObject current=null] : iv_ruleTypeReference= ruleTypeReference EOF ;
    public final EObject entryRuleTypeReference() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTypeReference = null;


        try {
            // InternalYangParser.g:1795:54: (iv_ruleTypeReference= ruleTypeReference EOF )
            // InternalYangParser.g:1796:2: iv_ruleTypeReference= ruleTypeReference EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getTypeReferenceRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleTypeReference=ruleTypeReference();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleTypeReference; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleTypeReference"


    // $ANTLR start "ruleTypeReference"
    // InternalYangParser.g:1802:1: ruleTypeReference returns [EObject current=null] : ( ( (lv_builtin_0_0= ruleBUILTIN_TYPE ) ) | ( ( ruleQualifiedTypeName ) ) ) ;
    public final EObject ruleTypeReference() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_builtin_0_0 = null;



        	enterRule();

        try {
            // InternalYangParser.g:1808:2: ( ( ( (lv_builtin_0_0= ruleBUILTIN_TYPE ) ) | ( ( ruleQualifiedTypeName ) ) ) )
            // InternalYangParser.g:1809:2: ( ( (lv_builtin_0_0= ruleBUILTIN_TYPE ) ) | ( ( ruleQualifiedTypeName ) ) )
            {
            // InternalYangParser.g:1809:2: ( ( (lv_builtin_0_0= ruleBUILTIN_TYPE ) ) | ( ( ruleQualifiedTypeName ) ) )
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0==InstanceIdentifier||(LA12_0>=Enumeration && LA12_0<=Identityref)||LA12_0==Decimal64||LA12_0==Boolean||LA12_0==Leafref||LA12_0==Binary||LA12_0==String||(LA12_0>=Uint16 && LA12_0<=Uint64)||LA12_0==Empty||(LA12_0>=Int16 && LA12_0<=Int64)||(LA12_0>=Uint8 && LA12_0<=Union)||LA12_0==Bits||LA12_0==Int8) ) {
                alt12=1;
            }
            else if ( ((LA12_0>=RequireInstance && LA12_0<=Description)||(LA12_0>=YinElement && LA12_0<=Deprecated)||(LA12_0>=IfFeature && LA12_0<=OrderedBy)||LA12_0==Container||(LA12_0>=Deviation && LA12_0<=Extension)||(LA12_0>=LeafList && LA12_0<=Namespace)||(LA12_0>=Reference && LA12_0<=Unbounded)||(LA12_0>=Argument && LA12_0<=Augment)||(LA12_0>=Contact && LA12_0<=Include)||(LA12_0>=Pattern && LA12_0<=Anyxml)||(LA12_0>=Choice && LA12_0<=Output)||(LA12_0>=Prefix && LA12_0<=Status)||LA12_0==KW_System||LA12_0==Unique||(LA12_0>=False && LA12_0<=Input)||LA12_0==Range||(LA12_0>=Units && LA12_0<=Value)||LA12_0==Base||(LA12_0>=Case && LA12_0<=Enum)||(LA12_0>=Leaf && LA12_0<=Must)||LA12_0==Path||(LA12_0>=True && LA12_0<=Add)||LA12_0==Bit||(LA12_0>=Key && LA12_0<=Min)||LA12_0==Rpc||LA12_0==RULE_ID) ) {
                alt12=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 12, 0, input);

                throw nvae;
            }
            switch (alt12) {
                case 1 :
                    // InternalYangParser.g:1810:3: ( (lv_builtin_0_0= ruleBUILTIN_TYPE ) )
                    {
                    // InternalYangParser.g:1810:3: ( (lv_builtin_0_0= ruleBUILTIN_TYPE ) )
                    // InternalYangParser.g:1811:4: (lv_builtin_0_0= ruleBUILTIN_TYPE )
                    {
                    // InternalYangParser.g:1811:4: (lv_builtin_0_0= ruleBUILTIN_TYPE )
                    // InternalYangParser.g:1812:5: lv_builtin_0_0= ruleBUILTIN_TYPE
                    {
                    if ( state.backtracking==0 ) {

                      					newCompositeNode(grammarAccess.getTypeReferenceAccess().getBuiltinBUILTIN_TYPEParserRuleCall_0_0());
                      				
                    }
                    pushFollow(FOLLOW_2);
                    lv_builtin_0_0=ruleBUILTIN_TYPE();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					if (current==null) {
                      						current = createModelElementForParent(grammarAccess.getTypeReferenceRule());
                      					}
                      					set(
                      						current,
                      						"builtin",
                      						lv_builtin_0_0,
                      						"io.typefox.yang.Yang.BUILTIN_TYPE");
                      					afterParserOrEnumRuleCall();
                      				
                    }

                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalYangParser.g:1830:3: ( ( ruleQualifiedTypeName ) )
                    {
                    // InternalYangParser.g:1830:3: ( ( ruleQualifiedTypeName ) )
                    // InternalYangParser.g:1831:4: ( ruleQualifiedTypeName )
                    {
                    // InternalYangParser.g:1831:4: ( ruleQualifiedTypeName )
                    // InternalYangParser.g:1832:5: ruleQualifiedTypeName
                    {
                    if ( state.backtracking==0 ) {

                      					if (current==null) {
                      						current = createModelElement(grammarAccess.getTypeReferenceRule());
                      					}
                      				
                    }
                    if ( state.backtracking==0 ) {

                      					newCompositeNode(grammarAccess.getTypeReferenceAccess().getTypeTypedefCrossReference_1_0());
                      				
                    }
                    pushFollow(FOLLOW_2);
                    ruleQualifiedTypeName();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					afterParserOrEnumRuleCall();
                      				
                    }

                    }


                    }


                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleTypeReference"


    // $ANTLR start "entryRuleContainer"
    // InternalYangParser.g:1850:1: entryRuleContainer returns [EObject current=null] : iv_ruleContainer= ruleContainer EOF ;
    public final EObject entryRuleContainer() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleContainer = null;


        try {
            // InternalYangParser.g:1850:50: (iv_ruleContainer= ruleContainer EOF )
            // InternalYangParser.g:1851:2: iv_ruleContainer= ruleContainer EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getContainerRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleContainer=ruleContainer();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleContainer; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleContainer"


    // $ANTLR start "ruleContainer"
    // InternalYangParser.g:1857:1: ruleContainer returns [EObject current=null] : (otherlv_0= Container ( (lv_name_1_0= ruleStringValue ) ) this_StatementEnd_2= ruleStatementEnd[$current] ) ;
    public final EObject ruleContainer() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        AntlrDatatypeRuleToken lv_name_1_0 = null;

        EObject this_StatementEnd_2 = null;



        	enterRule();

        try {
            // InternalYangParser.g:1863:2: ( (otherlv_0= Container ( (lv_name_1_0= ruleStringValue ) ) this_StatementEnd_2= ruleStatementEnd[$current] ) )
            // InternalYangParser.g:1864:2: (otherlv_0= Container ( (lv_name_1_0= ruleStringValue ) ) this_StatementEnd_2= ruleStatementEnd[$current] )
            {
            // InternalYangParser.g:1864:2: (otherlv_0= Container ( (lv_name_1_0= ruleStringValue ) ) this_StatementEnd_2= ruleStatementEnd[$current] )
            // InternalYangParser.g:1865:3: otherlv_0= Container ( (lv_name_1_0= ruleStringValue ) ) this_StatementEnd_2= ruleStatementEnd[$current]
            {
            otherlv_0=(Token)match(input,Container,FOLLOW_4); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getContainerAccess().getContainerKeyword_0());
              		
            }
            // InternalYangParser.g:1869:3: ( (lv_name_1_0= ruleStringValue ) )
            // InternalYangParser.g:1870:4: (lv_name_1_0= ruleStringValue )
            {
            // InternalYangParser.g:1870:4: (lv_name_1_0= ruleStringValue )
            // InternalYangParser.g:1871:5: lv_name_1_0= ruleStringValue
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getContainerAccess().getNameStringValueParserRuleCall_1_0());
              				
            }
            pushFollow(FOLLOW_5);
            lv_name_1_0=ruleStringValue();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getContainerRule());
              					}
              					set(
              						current,
              						"name",
              						lv_name_1_0,
              						"io.typefox.yang.Yang.StringValue");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            if ( state.backtracking==0 ) {

              			if (current==null) {
              				current = createModelElement(grammarAccess.getContainerRule());
              			}
              			newCompositeNode(grammarAccess.getContainerAccess().getStatementEndParserRuleCall_2());
              		
            }
            pushFollow(FOLLOW_2);
            this_StatementEnd_2=ruleStatementEnd(current);

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current = this_StatementEnd_2;
              			afterParserOrEnumRuleCall();
              		
            }

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleContainer"


    // $ANTLR start "entryRuleMust"
    // InternalYangParser.g:1903:1: entryRuleMust returns [EObject current=null] : iv_ruleMust= ruleMust EOF ;
    public final EObject entryRuleMust() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMust = null;


        try {
            // InternalYangParser.g:1903:45: (iv_ruleMust= ruleMust EOF )
            // InternalYangParser.g:1904:2: iv_ruleMust= ruleMust EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getMustRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleMust=ruleMust();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleMust; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleMust"


    // $ANTLR start "ruleMust"
    // InternalYangParser.g:1910:1: ruleMust returns [EObject current=null] : (otherlv_0= Must ( (lv_constraint_1_0= ruleXpathExpression ) ) this_StatementEnd_2= ruleStatementEnd[$current] ) ;
    public final EObject ruleMust() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        EObject lv_constraint_1_0 = null;

        EObject this_StatementEnd_2 = null;



        	enterRule();

        try {
            // InternalYangParser.g:1916:2: ( (otherlv_0= Must ( (lv_constraint_1_0= ruleXpathExpression ) ) this_StatementEnd_2= ruleStatementEnd[$current] ) )
            // InternalYangParser.g:1917:2: (otherlv_0= Must ( (lv_constraint_1_0= ruleXpathExpression ) ) this_StatementEnd_2= ruleStatementEnd[$current] )
            {
            // InternalYangParser.g:1917:2: (otherlv_0= Must ( (lv_constraint_1_0= ruleXpathExpression ) ) this_StatementEnd_2= ruleStatementEnd[$current] )
            // InternalYangParser.g:1918:3: otherlv_0= Must ( (lv_constraint_1_0= ruleXpathExpression ) ) this_StatementEnd_2= ruleStatementEnd[$current]
            {
            otherlv_0=(Token)match(input,Must,FOLLOW_7); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getMustAccess().getMustKeyword_0());
              		
            }
            // InternalYangParser.g:1922:3: ( (lv_constraint_1_0= ruleXpathExpression ) )
            // InternalYangParser.g:1923:4: (lv_constraint_1_0= ruleXpathExpression )
            {
            // InternalYangParser.g:1923:4: (lv_constraint_1_0= ruleXpathExpression )
            // InternalYangParser.g:1924:5: lv_constraint_1_0= ruleXpathExpression
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getMustAccess().getConstraintXpathExpressionParserRuleCall_1_0());
              				
            }
            pushFollow(FOLLOW_5);
            lv_constraint_1_0=ruleXpathExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getMustRule());
              					}
              					set(
              						current,
              						"constraint",
              						lv_constraint_1_0,
              						"io.typefox.yang.Yang.XpathExpression");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            if ( state.backtracking==0 ) {

              			if (current==null) {
              				current = createModelElement(grammarAccess.getMustRule());
              			}
              			newCompositeNode(grammarAccess.getMustAccess().getStatementEndParserRuleCall_2());
              		
            }
            pushFollow(FOLLOW_2);
            this_StatementEnd_2=ruleStatementEnd(current);

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current = this_StatementEnd_2;
              			afterParserOrEnumRuleCall();
              		
            }

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleMust"


    // $ANTLR start "entryRuleErrorMessage"
    // InternalYangParser.g:1956:1: entryRuleErrorMessage returns [EObject current=null] : iv_ruleErrorMessage= ruleErrorMessage EOF ;
    public final EObject entryRuleErrorMessage() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleErrorMessage = null;


        try {
            // InternalYangParser.g:1956:53: (iv_ruleErrorMessage= ruleErrorMessage EOF )
            // InternalYangParser.g:1957:2: iv_ruleErrorMessage= ruleErrorMessage EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getErrorMessageRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleErrorMessage=ruleErrorMessage();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleErrorMessage; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleErrorMessage"


    // $ANTLR start "ruleErrorMessage"
    // InternalYangParser.g:1963:1: ruleErrorMessage returns [EObject current=null] : (otherlv_0= ErrorMessage ( (lv_message_1_0= ruleStringValue ) ) this_StatementEnd_2= ruleStatementEnd[$current] ) ;
    public final EObject ruleErrorMessage() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        AntlrDatatypeRuleToken lv_message_1_0 = null;

        EObject this_StatementEnd_2 = null;



        	enterRule();

        try {
            // InternalYangParser.g:1969:2: ( (otherlv_0= ErrorMessage ( (lv_message_1_0= ruleStringValue ) ) this_StatementEnd_2= ruleStatementEnd[$current] ) )
            // InternalYangParser.g:1970:2: (otherlv_0= ErrorMessage ( (lv_message_1_0= ruleStringValue ) ) this_StatementEnd_2= ruleStatementEnd[$current] )
            {
            // InternalYangParser.g:1970:2: (otherlv_0= ErrorMessage ( (lv_message_1_0= ruleStringValue ) ) this_StatementEnd_2= ruleStatementEnd[$current] )
            // InternalYangParser.g:1971:3: otherlv_0= ErrorMessage ( (lv_message_1_0= ruleStringValue ) ) this_StatementEnd_2= ruleStatementEnd[$current]
            {
            otherlv_0=(Token)match(input,ErrorMessage,FOLLOW_4); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getErrorMessageAccess().getErrorMessageKeyword_0());
              		
            }
            // InternalYangParser.g:1975:3: ( (lv_message_1_0= ruleStringValue ) )
            // InternalYangParser.g:1976:4: (lv_message_1_0= ruleStringValue )
            {
            // InternalYangParser.g:1976:4: (lv_message_1_0= ruleStringValue )
            // InternalYangParser.g:1977:5: lv_message_1_0= ruleStringValue
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getErrorMessageAccess().getMessageStringValueParserRuleCall_1_0());
              				
            }
            pushFollow(FOLLOW_5);
            lv_message_1_0=ruleStringValue();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getErrorMessageRule());
              					}
              					set(
              						current,
              						"message",
              						lv_message_1_0,
              						"io.typefox.yang.Yang.StringValue");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            if ( state.backtracking==0 ) {

              			if (current==null) {
              				current = createModelElement(grammarAccess.getErrorMessageRule());
              			}
              			newCompositeNode(grammarAccess.getErrorMessageAccess().getStatementEndParserRuleCall_2());
              		
            }
            pushFollow(FOLLOW_2);
            this_StatementEnd_2=ruleStatementEnd(current);

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current = this_StatementEnd_2;
              			afterParserOrEnumRuleCall();
              		
            }

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleErrorMessage"


    // $ANTLR start "entryRuleErrorAppTag"
    // InternalYangParser.g:2009:1: entryRuleErrorAppTag returns [EObject current=null] : iv_ruleErrorAppTag= ruleErrorAppTag EOF ;
    public final EObject entryRuleErrorAppTag() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleErrorAppTag = null;


        try {
            // InternalYangParser.g:2009:52: (iv_ruleErrorAppTag= ruleErrorAppTag EOF )
            // InternalYangParser.g:2010:2: iv_ruleErrorAppTag= ruleErrorAppTag EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getErrorAppTagRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleErrorAppTag=ruleErrorAppTag();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleErrorAppTag; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleErrorAppTag"


    // $ANTLR start "ruleErrorAppTag"
    // InternalYangParser.g:2016:1: ruleErrorAppTag returns [EObject current=null] : (otherlv_0= ErrorAppTag ( (lv_tag_1_0= ruleStringValue ) ) this_StatementEnd_2= ruleStatementEnd[$current] ) ;
    public final EObject ruleErrorAppTag() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        AntlrDatatypeRuleToken lv_tag_1_0 = null;

        EObject this_StatementEnd_2 = null;



        	enterRule();

        try {
            // InternalYangParser.g:2022:2: ( (otherlv_0= ErrorAppTag ( (lv_tag_1_0= ruleStringValue ) ) this_StatementEnd_2= ruleStatementEnd[$current] ) )
            // InternalYangParser.g:2023:2: (otherlv_0= ErrorAppTag ( (lv_tag_1_0= ruleStringValue ) ) this_StatementEnd_2= ruleStatementEnd[$current] )
            {
            // InternalYangParser.g:2023:2: (otherlv_0= ErrorAppTag ( (lv_tag_1_0= ruleStringValue ) ) this_StatementEnd_2= ruleStatementEnd[$current] )
            // InternalYangParser.g:2024:3: otherlv_0= ErrorAppTag ( (lv_tag_1_0= ruleStringValue ) ) this_StatementEnd_2= ruleStatementEnd[$current]
            {
            otherlv_0=(Token)match(input,ErrorAppTag,FOLLOW_4); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getErrorAppTagAccess().getErrorAppTagKeyword_0());
              		
            }
            // InternalYangParser.g:2028:3: ( (lv_tag_1_0= ruleStringValue ) )
            // InternalYangParser.g:2029:4: (lv_tag_1_0= ruleStringValue )
            {
            // InternalYangParser.g:2029:4: (lv_tag_1_0= ruleStringValue )
            // InternalYangParser.g:2030:5: lv_tag_1_0= ruleStringValue
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getErrorAppTagAccess().getTagStringValueParserRuleCall_1_0());
              				
            }
            pushFollow(FOLLOW_5);
            lv_tag_1_0=ruleStringValue();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getErrorAppTagRule());
              					}
              					set(
              						current,
              						"tag",
              						lv_tag_1_0,
              						"io.typefox.yang.Yang.StringValue");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            if ( state.backtracking==0 ) {

              			if (current==null) {
              				current = createModelElement(grammarAccess.getErrorAppTagRule());
              			}
              			newCompositeNode(grammarAccess.getErrorAppTagAccess().getStatementEndParserRuleCall_2());
              		
            }
            pushFollow(FOLLOW_2);
            this_StatementEnd_2=ruleStatementEnd(current);

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current = this_StatementEnd_2;
              			afterParserOrEnumRuleCall();
              		
            }

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleErrorAppTag"


    // $ANTLR start "entryRulePresence"
    // InternalYangParser.g:2062:1: entryRulePresence returns [EObject current=null] : iv_rulePresence= rulePresence EOF ;
    public final EObject entryRulePresence() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePresence = null;


        try {
            // InternalYangParser.g:2062:49: (iv_rulePresence= rulePresence EOF )
            // InternalYangParser.g:2063:2: iv_rulePresence= rulePresence EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getPresenceRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_rulePresence=rulePresence();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_rulePresence; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulePresence"


    // $ANTLR start "rulePresence"
    // InternalYangParser.g:2069:1: rulePresence returns [EObject current=null] : (otherlv_0= Presence ( (lv_description_1_0= ruleStringValue ) ) this_StatementEnd_2= ruleStatementEnd[$current] ) ;
    public final EObject rulePresence() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        AntlrDatatypeRuleToken lv_description_1_0 = null;

        EObject this_StatementEnd_2 = null;



        	enterRule();

        try {
            // InternalYangParser.g:2075:2: ( (otherlv_0= Presence ( (lv_description_1_0= ruleStringValue ) ) this_StatementEnd_2= ruleStatementEnd[$current] ) )
            // InternalYangParser.g:2076:2: (otherlv_0= Presence ( (lv_description_1_0= ruleStringValue ) ) this_StatementEnd_2= ruleStatementEnd[$current] )
            {
            // InternalYangParser.g:2076:2: (otherlv_0= Presence ( (lv_description_1_0= ruleStringValue ) ) this_StatementEnd_2= ruleStatementEnd[$current] )
            // InternalYangParser.g:2077:3: otherlv_0= Presence ( (lv_description_1_0= ruleStringValue ) ) this_StatementEnd_2= ruleStatementEnd[$current]
            {
            otherlv_0=(Token)match(input,Presence,FOLLOW_4); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getPresenceAccess().getPresenceKeyword_0());
              		
            }
            // InternalYangParser.g:2081:3: ( (lv_description_1_0= ruleStringValue ) )
            // InternalYangParser.g:2082:4: (lv_description_1_0= ruleStringValue )
            {
            // InternalYangParser.g:2082:4: (lv_description_1_0= ruleStringValue )
            // InternalYangParser.g:2083:5: lv_description_1_0= ruleStringValue
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getPresenceAccess().getDescriptionStringValueParserRuleCall_1_0());
              				
            }
            pushFollow(FOLLOW_5);
            lv_description_1_0=ruleStringValue();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getPresenceRule());
              					}
              					set(
              						current,
              						"description",
              						lv_description_1_0,
              						"io.typefox.yang.Yang.StringValue");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            if ( state.backtracking==0 ) {

              			if (current==null) {
              				current = createModelElement(grammarAccess.getPresenceRule());
              			}
              			newCompositeNode(grammarAccess.getPresenceAccess().getStatementEndParserRuleCall_2());
              		
            }
            pushFollow(FOLLOW_2);
            this_StatementEnd_2=ruleStatementEnd(current);

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current = this_StatementEnd_2;
              			afterParserOrEnumRuleCall();
              		
            }

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "rulePresence"


    // $ANTLR start "entryRuleLeaf"
    // InternalYangParser.g:2115:1: entryRuleLeaf returns [EObject current=null] : iv_ruleLeaf= ruleLeaf EOF ;
    public final EObject entryRuleLeaf() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLeaf = null;


        try {
            // InternalYangParser.g:2115:45: (iv_ruleLeaf= ruleLeaf EOF )
            // InternalYangParser.g:2116:2: iv_ruleLeaf= ruleLeaf EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getLeafRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleLeaf=ruleLeaf();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleLeaf; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleLeaf"


    // $ANTLR start "ruleLeaf"
    // InternalYangParser.g:2122:1: ruleLeaf returns [EObject current=null] : (otherlv_0= Leaf ( (lv_name_1_0= ruleStringValue ) ) this_StatementEnd_2= ruleStatementEnd[$current] ) ;
    public final EObject ruleLeaf() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        AntlrDatatypeRuleToken lv_name_1_0 = null;

        EObject this_StatementEnd_2 = null;



        	enterRule();

        try {
            // InternalYangParser.g:2128:2: ( (otherlv_0= Leaf ( (lv_name_1_0= ruleStringValue ) ) this_StatementEnd_2= ruleStatementEnd[$current] ) )
            // InternalYangParser.g:2129:2: (otherlv_0= Leaf ( (lv_name_1_0= ruleStringValue ) ) this_StatementEnd_2= ruleStatementEnd[$current] )
            {
            // InternalYangParser.g:2129:2: (otherlv_0= Leaf ( (lv_name_1_0= ruleStringValue ) ) this_StatementEnd_2= ruleStatementEnd[$current] )
            // InternalYangParser.g:2130:3: otherlv_0= Leaf ( (lv_name_1_0= ruleStringValue ) ) this_StatementEnd_2= ruleStatementEnd[$current]
            {
            otherlv_0=(Token)match(input,Leaf,FOLLOW_4); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getLeafAccess().getLeafKeyword_0());
              		
            }
            // InternalYangParser.g:2134:3: ( (lv_name_1_0= ruleStringValue ) )
            // InternalYangParser.g:2135:4: (lv_name_1_0= ruleStringValue )
            {
            // InternalYangParser.g:2135:4: (lv_name_1_0= ruleStringValue )
            // InternalYangParser.g:2136:5: lv_name_1_0= ruleStringValue
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getLeafAccess().getNameStringValueParserRuleCall_1_0());
              				
            }
            pushFollow(FOLLOW_5);
            lv_name_1_0=ruleStringValue();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getLeafRule());
              					}
              					set(
              						current,
              						"name",
              						lv_name_1_0,
              						"io.typefox.yang.Yang.StringValue");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            if ( state.backtracking==0 ) {

              			if (current==null) {
              				current = createModelElement(grammarAccess.getLeafRule());
              			}
              			newCompositeNode(grammarAccess.getLeafAccess().getStatementEndParserRuleCall_2());
              		
            }
            pushFollow(FOLLOW_2);
            this_StatementEnd_2=ruleStatementEnd(current);

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current = this_StatementEnd_2;
              			afterParserOrEnumRuleCall();
              		
            }

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleLeaf"


    // $ANTLR start "entryRuleMandatory"
    // InternalYangParser.g:2168:1: entryRuleMandatory returns [EObject current=null] : iv_ruleMandatory= ruleMandatory EOF ;
    public final EObject entryRuleMandatory() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMandatory = null;


        try {
            // InternalYangParser.g:2168:50: (iv_ruleMandatory= ruleMandatory EOF )
            // InternalYangParser.g:2169:2: iv_ruleMandatory= ruleMandatory EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getMandatoryRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleMandatory=ruleMandatory();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleMandatory; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleMandatory"


    // $ANTLR start "ruleMandatory"
    // InternalYangParser.g:2175:1: ruleMandatory returns [EObject current=null] : (otherlv_0= Mandatory ( (lv_isMandatory_1_0= ruleStringValue ) ) this_StatementEnd_2= ruleStatementEnd[$current] ) ;
    public final EObject ruleMandatory() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        AntlrDatatypeRuleToken lv_isMandatory_1_0 = null;

        EObject this_StatementEnd_2 = null;



        	enterRule();

        try {
            // InternalYangParser.g:2181:2: ( (otherlv_0= Mandatory ( (lv_isMandatory_1_0= ruleStringValue ) ) this_StatementEnd_2= ruleStatementEnd[$current] ) )
            // InternalYangParser.g:2182:2: (otherlv_0= Mandatory ( (lv_isMandatory_1_0= ruleStringValue ) ) this_StatementEnd_2= ruleStatementEnd[$current] )
            {
            // InternalYangParser.g:2182:2: (otherlv_0= Mandatory ( (lv_isMandatory_1_0= ruleStringValue ) ) this_StatementEnd_2= ruleStatementEnd[$current] )
            // InternalYangParser.g:2183:3: otherlv_0= Mandatory ( (lv_isMandatory_1_0= ruleStringValue ) ) this_StatementEnd_2= ruleStatementEnd[$current]
            {
            otherlv_0=(Token)match(input,Mandatory,FOLLOW_4); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getMandatoryAccess().getMandatoryKeyword_0());
              		
            }
            // InternalYangParser.g:2187:3: ( (lv_isMandatory_1_0= ruleStringValue ) )
            // InternalYangParser.g:2188:4: (lv_isMandatory_1_0= ruleStringValue )
            {
            // InternalYangParser.g:2188:4: (lv_isMandatory_1_0= ruleStringValue )
            // InternalYangParser.g:2189:5: lv_isMandatory_1_0= ruleStringValue
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getMandatoryAccess().getIsMandatoryStringValueParserRuleCall_1_0());
              				
            }
            pushFollow(FOLLOW_5);
            lv_isMandatory_1_0=ruleStringValue();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getMandatoryRule());
              					}
              					set(
              						current,
              						"isMandatory",
              						lv_isMandatory_1_0,
              						"io.typefox.yang.Yang.StringValue");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            if ( state.backtracking==0 ) {

              			if (current==null) {
              				current = createModelElement(grammarAccess.getMandatoryRule());
              			}
              			newCompositeNode(grammarAccess.getMandatoryAccess().getStatementEndParserRuleCall_2());
              		
            }
            pushFollow(FOLLOW_2);
            this_StatementEnd_2=ruleStatementEnd(current);

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current = this_StatementEnd_2;
              			afterParserOrEnumRuleCall();
              		
            }

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleMandatory"


    // $ANTLR start "entryRuleLeafList"
    // InternalYangParser.g:2221:1: entryRuleLeafList returns [EObject current=null] : iv_ruleLeafList= ruleLeafList EOF ;
    public final EObject entryRuleLeafList() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLeafList = null;


        try {
            // InternalYangParser.g:2221:49: (iv_ruleLeafList= ruleLeafList EOF )
            // InternalYangParser.g:2222:2: iv_ruleLeafList= ruleLeafList EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getLeafListRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleLeafList=ruleLeafList();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleLeafList; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleLeafList"


    // $ANTLR start "ruleLeafList"
    // InternalYangParser.g:2228:1: ruleLeafList returns [EObject current=null] : (otherlv_0= LeafList ( (lv_name_1_0= ruleStringValue ) ) this_StatementEnd_2= ruleStatementEnd[$current] ) ;
    public final EObject ruleLeafList() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        AntlrDatatypeRuleToken lv_name_1_0 = null;

        EObject this_StatementEnd_2 = null;



        	enterRule();

        try {
            // InternalYangParser.g:2234:2: ( (otherlv_0= LeafList ( (lv_name_1_0= ruleStringValue ) ) this_StatementEnd_2= ruleStatementEnd[$current] ) )
            // InternalYangParser.g:2235:2: (otherlv_0= LeafList ( (lv_name_1_0= ruleStringValue ) ) this_StatementEnd_2= ruleStatementEnd[$current] )
            {
            // InternalYangParser.g:2235:2: (otherlv_0= LeafList ( (lv_name_1_0= ruleStringValue ) ) this_StatementEnd_2= ruleStatementEnd[$current] )
            // InternalYangParser.g:2236:3: otherlv_0= LeafList ( (lv_name_1_0= ruleStringValue ) ) this_StatementEnd_2= ruleStatementEnd[$current]
            {
            otherlv_0=(Token)match(input,LeafList,FOLLOW_4); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getLeafListAccess().getLeafListKeyword_0());
              		
            }
            // InternalYangParser.g:2240:3: ( (lv_name_1_0= ruleStringValue ) )
            // InternalYangParser.g:2241:4: (lv_name_1_0= ruleStringValue )
            {
            // InternalYangParser.g:2241:4: (lv_name_1_0= ruleStringValue )
            // InternalYangParser.g:2242:5: lv_name_1_0= ruleStringValue
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getLeafListAccess().getNameStringValueParserRuleCall_1_0());
              				
            }
            pushFollow(FOLLOW_5);
            lv_name_1_0=ruleStringValue();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getLeafListRule());
              					}
              					set(
              						current,
              						"name",
              						lv_name_1_0,
              						"io.typefox.yang.Yang.StringValue");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            if ( state.backtracking==0 ) {

              			if (current==null) {
              				current = createModelElement(grammarAccess.getLeafListRule());
              			}
              			newCompositeNode(grammarAccess.getLeafListAccess().getStatementEndParserRuleCall_2());
              		
            }
            pushFollow(FOLLOW_2);
            this_StatementEnd_2=ruleStatementEnd(current);

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current = this_StatementEnd_2;
              			afterParserOrEnumRuleCall();
              		
            }

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleLeafList"


    // $ANTLR start "entryRuleMinElements"
    // InternalYangParser.g:2274:1: entryRuleMinElements returns [EObject current=null] : iv_ruleMinElements= ruleMinElements EOF ;
    public final EObject entryRuleMinElements() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMinElements = null;


        try {
            // InternalYangParser.g:2274:52: (iv_ruleMinElements= ruleMinElements EOF )
            // InternalYangParser.g:2275:2: iv_ruleMinElements= ruleMinElements EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getMinElementsRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleMinElements=ruleMinElements();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleMinElements; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleMinElements"


    // $ANTLR start "ruleMinElements"
    // InternalYangParser.g:2281:1: ruleMinElements returns [EObject current=null] : (otherlv_0= MinElements ( (lv_minElements_1_0= ruleStringValue ) ) this_StatementEnd_2= ruleStatementEnd[$current] ) ;
    public final EObject ruleMinElements() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        AntlrDatatypeRuleToken lv_minElements_1_0 = null;

        EObject this_StatementEnd_2 = null;



        	enterRule();

        try {
            // InternalYangParser.g:2287:2: ( (otherlv_0= MinElements ( (lv_minElements_1_0= ruleStringValue ) ) this_StatementEnd_2= ruleStatementEnd[$current] ) )
            // InternalYangParser.g:2288:2: (otherlv_0= MinElements ( (lv_minElements_1_0= ruleStringValue ) ) this_StatementEnd_2= ruleStatementEnd[$current] )
            {
            // InternalYangParser.g:2288:2: (otherlv_0= MinElements ( (lv_minElements_1_0= ruleStringValue ) ) this_StatementEnd_2= ruleStatementEnd[$current] )
            // InternalYangParser.g:2289:3: otherlv_0= MinElements ( (lv_minElements_1_0= ruleStringValue ) ) this_StatementEnd_2= ruleStatementEnd[$current]
            {
            otherlv_0=(Token)match(input,MinElements,FOLLOW_4); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getMinElementsAccess().getMinElementsKeyword_0());
              		
            }
            // InternalYangParser.g:2293:3: ( (lv_minElements_1_0= ruleStringValue ) )
            // InternalYangParser.g:2294:4: (lv_minElements_1_0= ruleStringValue )
            {
            // InternalYangParser.g:2294:4: (lv_minElements_1_0= ruleStringValue )
            // InternalYangParser.g:2295:5: lv_minElements_1_0= ruleStringValue
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getMinElementsAccess().getMinElementsStringValueParserRuleCall_1_0());
              				
            }
            pushFollow(FOLLOW_5);
            lv_minElements_1_0=ruleStringValue();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getMinElementsRule());
              					}
              					set(
              						current,
              						"minElements",
              						lv_minElements_1_0,
              						"io.typefox.yang.Yang.StringValue");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            if ( state.backtracking==0 ) {

              			if (current==null) {
              				current = createModelElement(grammarAccess.getMinElementsRule());
              			}
              			newCompositeNode(grammarAccess.getMinElementsAccess().getStatementEndParserRuleCall_2());
              		
            }
            pushFollow(FOLLOW_2);
            this_StatementEnd_2=ruleStatementEnd(current);

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current = this_StatementEnd_2;
              			afterParserOrEnumRuleCall();
              		
            }

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleMinElements"


    // $ANTLR start "entryRuleMaxElements"
    // InternalYangParser.g:2327:1: entryRuleMaxElements returns [EObject current=null] : iv_ruleMaxElements= ruleMaxElements EOF ;
    public final EObject entryRuleMaxElements() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMaxElements = null;


        try {
            // InternalYangParser.g:2327:52: (iv_ruleMaxElements= ruleMaxElements EOF )
            // InternalYangParser.g:2328:2: iv_ruleMaxElements= ruleMaxElements EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getMaxElementsRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleMaxElements=ruleMaxElements();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleMaxElements; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleMaxElements"


    // $ANTLR start "ruleMaxElements"
    // InternalYangParser.g:2334:1: ruleMaxElements returns [EObject current=null] : (otherlv_0= MaxElements ( (lv_maxElements_1_0= ruleStringValue ) ) this_StatementEnd_2= ruleStatementEnd[$current] ) ;
    public final EObject ruleMaxElements() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        AntlrDatatypeRuleToken lv_maxElements_1_0 = null;

        EObject this_StatementEnd_2 = null;



        	enterRule();

        try {
            // InternalYangParser.g:2340:2: ( (otherlv_0= MaxElements ( (lv_maxElements_1_0= ruleStringValue ) ) this_StatementEnd_2= ruleStatementEnd[$current] ) )
            // InternalYangParser.g:2341:2: (otherlv_0= MaxElements ( (lv_maxElements_1_0= ruleStringValue ) ) this_StatementEnd_2= ruleStatementEnd[$current] )
            {
            // InternalYangParser.g:2341:2: (otherlv_0= MaxElements ( (lv_maxElements_1_0= ruleStringValue ) ) this_StatementEnd_2= ruleStatementEnd[$current] )
            // InternalYangParser.g:2342:3: otherlv_0= MaxElements ( (lv_maxElements_1_0= ruleStringValue ) ) this_StatementEnd_2= ruleStatementEnd[$current]
            {
            otherlv_0=(Token)match(input,MaxElements,FOLLOW_4); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getMaxElementsAccess().getMaxElementsKeyword_0());
              		
            }
            // InternalYangParser.g:2346:3: ( (lv_maxElements_1_0= ruleStringValue ) )
            // InternalYangParser.g:2347:4: (lv_maxElements_1_0= ruleStringValue )
            {
            // InternalYangParser.g:2347:4: (lv_maxElements_1_0= ruleStringValue )
            // InternalYangParser.g:2348:5: lv_maxElements_1_0= ruleStringValue
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getMaxElementsAccess().getMaxElementsStringValueParserRuleCall_1_0());
              				
            }
            pushFollow(FOLLOW_5);
            lv_maxElements_1_0=ruleStringValue();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getMaxElementsRule());
              					}
              					set(
              						current,
              						"maxElements",
              						lv_maxElements_1_0,
              						"io.typefox.yang.Yang.StringValue");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            if ( state.backtracking==0 ) {

              			if (current==null) {
              				current = createModelElement(grammarAccess.getMaxElementsRule());
              			}
              			newCompositeNode(grammarAccess.getMaxElementsAccess().getStatementEndParserRuleCall_2());
              		
            }
            pushFollow(FOLLOW_2);
            this_StatementEnd_2=ruleStatementEnd(current);

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current = this_StatementEnd_2;
              			afterParserOrEnumRuleCall();
              		
            }

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleMaxElements"


    // $ANTLR start "entryRuleOrderedBy"
    // InternalYangParser.g:2380:1: entryRuleOrderedBy returns [EObject current=null] : iv_ruleOrderedBy= ruleOrderedBy EOF ;
    public final EObject entryRuleOrderedBy() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleOrderedBy = null;


        try {
            // InternalYangParser.g:2380:50: (iv_ruleOrderedBy= ruleOrderedBy EOF )
            // InternalYangParser.g:2381:2: iv_ruleOrderedBy= ruleOrderedBy EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getOrderedByRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleOrderedBy=ruleOrderedBy();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleOrderedBy; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleOrderedBy"


    // $ANTLR start "ruleOrderedBy"
    // InternalYangParser.g:2387:1: ruleOrderedBy returns [EObject current=null] : (otherlv_0= OrderedBy ( (lv_orderedBy_1_0= ruleStringValue ) ) this_StatementEnd_2= ruleStatementEnd[$current] ) ;
    public final EObject ruleOrderedBy() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        AntlrDatatypeRuleToken lv_orderedBy_1_0 = null;

        EObject this_StatementEnd_2 = null;



        	enterRule();

        try {
            // InternalYangParser.g:2393:2: ( (otherlv_0= OrderedBy ( (lv_orderedBy_1_0= ruleStringValue ) ) this_StatementEnd_2= ruleStatementEnd[$current] ) )
            // InternalYangParser.g:2394:2: (otherlv_0= OrderedBy ( (lv_orderedBy_1_0= ruleStringValue ) ) this_StatementEnd_2= ruleStatementEnd[$current] )
            {
            // InternalYangParser.g:2394:2: (otherlv_0= OrderedBy ( (lv_orderedBy_1_0= ruleStringValue ) ) this_StatementEnd_2= ruleStatementEnd[$current] )
            // InternalYangParser.g:2395:3: otherlv_0= OrderedBy ( (lv_orderedBy_1_0= ruleStringValue ) ) this_StatementEnd_2= ruleStatementEnd[$current]
            {
            otherlv_0=(Token)match(input,OrderedBy,FOLLOW_4); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getOrderedByAccess().getOrderedByKeyword_0());
              		
            }
            // InternalYangParser.g:2399:3: ( (lv_orderedBy_1_0= ruleStringValue ) )
            // InternalYangParser.g:2400:4: (lv_orderedBy_1_0= ruleStringValue )
            {
            // InternalYangParser.g:2400:4: (lv_orderedBy_1_0= ruleStringValue )
            // InternalYangParser.g:2401:5: lv_orderedBy_1_0= ruleStringValue
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getOrderedByAccess().getOrderedByStringValueParserRuleCall_1_0());
              				
            }
            pushFollow(FOLLOW_5);
            lv_orderedBy_1_0=ruleStringValue();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getOrderedByRule());
              					}
              					set(
              						current,
              						"orderedBy",
              						lv_orderedBy_1_0,
              						"io.typefox.yang.Yang.StringValue");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            if ( state.backtracking==0 ) {

              			if (current==null) {
              				current = createModelElement(grammarAccess.getOrderedByRule());
              			}
              			newCompositeNode(grammarAccess.getOrderedByAccess().getStatementEndParserRuleCall_2());
              		
            }
            pushFollow(FOLLOW_2);
            this_StatementEnd_2=ruleStatementEnd(current);

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current = this_StatementEnd_2;
              			afterParserOrEnumRuleCall();
              		
            }

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleOrderedBy"


    // $ANTLR start "entryRuleList"
    // InternalYangParser.g:2433:1: entryRuleList returns [EObject current=null] : iv_ruleList= ruleList EOF ;
    public final EObject entryRuleList() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleList = null;


        try {
            // InternalYangParser.g:2433:45: (iv_ruleList= ruleList EOF )
            // InternalYangParser.g:2434:2: iv_ruleList= ruleList EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getListRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleList=ruleList();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleList; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleList"


    // $ANTLR start "ruleList"
    // InternalYangParser.g:2440:1: ruleList returns [EObject current=null] : (otherlv_0= List ( (lv_name_1_0= ruleStringValue ) ) this_StatementEnd_2= ruleStatementEnd[$current] ) ;
    public final EObject ruleList() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        AntlrDatatypeRuleToken lv_name_1_0 = null;

        EObject this_StatementEnd_2 = null;



        	enterRule();

        try {
            // InternalYangParser.g:2446:2: ( (otherlv_0= List ( (lv_name_1_0= ruleStringValue ) ) this_StatementEnd_2= ruleStatementEnd[$current] ) )
            // InternalYangParser.g:2447:2: (otherlv_0= List ( (lv_name_1_0= ruleStringValue ) ) this_StatementEnd_2= ruleStatementEnd[$current] )
            {
            // InternalYangParser.g:2447:2: (otherlv_0= List ( (lv_name_1_0= ruleStringValue ) ) this_StatementEnd_2= ruleStatementEnd[$current] )
            // InternalYangParser.g:2448:3: otherlv_0= List ( (lv_name_1_0= ruleStringValue ) ) this_StatementEnd_2= ruleStatementEnd[$current]
            {
            otherlv_0=(Token)match(input,List,FOLLOW_4); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getListAccess().getListKeyword_0());
              		
            }
            // InternalYangParser.g:2452:3: ( (lv_name_1_0= ruleStringValue ) )
            // InternalYangParser.g:2453:4: (lv_name_1_0= ruleStringValue )
            {
            // InternalYangParser.g:2453:4: (lv_name_1_0= ruleStringValue )
            // InternalYangParser.g:2454:5: lv_name_1_0= ruleStringValue
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getListAccess().getNameStringValueParserRuleCall_1_0());
              				
            }
            pushFollow(FOLLOW_5);
            lv_name_1_0=ruleStringValue();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getListRule());
              					}
              					set(
              						current,
              						"name",
              						lv_name_1_0,
              						"io.typefox.yang.Yang.StringValue");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            if ( state.backtracking==0 ) {

              			if (current==null) {
              				current = createModelElement(grammarAccess.getListRule());
              			}
              			newCompositeNode(grammarAccess.getListAccess().getStatementEndParserRuleCall_2());
              		
            }
            pushFollow(FOLLOW_2);
            this_StatementEnd_2=ruleStatementEnd(current);

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current = this_StatementEnd_2;
              			afterParserOrEnumRuleCall();
              		
            }

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleList"


    // $ANTLR start "entryRuleKey"
    // InternalYangParser.g:2486:1: entryRuleKey returns [EObject current=null] : iv_ruleKey= ruleKey EOF ;
    public final EObject entryRuleKey() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleKey = null;


        try {
            // InternalYangParser.g:2486:44: (iv_ruleKey= ruleKey EOF )
            // InternalYangParser.g:2487:2: iv_ruleKey= ruleKey EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getKeyRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleKey=ruleKey();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleKey; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleKey"


    // $ANTLR start "ruleKey"
    // InternalYangParser.g:2493:1: ruleKey returns [EObject current=null] : ( () otherlv_1= Key ( (lv_references_2_0= ruleKeyReference ) )+ this_StatementEnd_3= ruleStatementEnd[$current] ) ;
    public final EObject ruleKey() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_references_2_0 = null;

        EObject this_StatementEnd_3 = null;



        	enterRule();

        try {
            // InternalYangParser.g:2499:2: ( ( () otherlv_1= Key ( (lv_references_2_0= ruleKeyReference ) )+ this_StatementEnd_3= ruleStatementEnd[$current] ) )
            // InternalYangParser.g:2500:2: ( () otherlv_1= Key ( (lv_references_2_0= ruleKeyReference ) )+ this_StatementEnd_3= ruleStatementEnd[$current] )
            {
            // InternalYangParser.g:2500:2: ( () otherlv_1= Key ( (lv_references_2_0= ruleKeyReference ) )+ this_StatementEnd_3= ruleStatementEnd[$current] )
            // InternalYangParser.g:2501:3: () otherlv_1= Key ( (lv_references_2_0= ruleKeyReference ) )+ this_StatementEnd_3= ruleStatementEnd[$current]
            {
            // InternalYangParser.g:2501:3: ()
            // InternalYangParser.g:2502:4: 
            {
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getKeyAccess().getKeyAction_0(),
              					current);
              			
            }

            }

            otherlv_1=(Token)match(input,Key,FOLLOW_6); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getKeyAccess().getKeyKeyword_1());
              		
            }
            // InternalYangParser.g:2512:3: ( (lv_references_2_0= ruleKeyReference ) )+
            int cnt13=0;
            loop13:
            do {
                int alt13=2;
                int LA13_0 = input.LA(1);

                if ( (LA13_0==InstanceIdentifier||(LA13_0>=RequireInstance && LA13_0<=Deprecated)||(LA13_0>=IfFeature && LA13_0<=OrderedBy)||(LA13_0>=Container && LA13_0<=Extension)||(LA13_0>=LeafList && LA13_0<=Namespace)||(LA13_0>=Reference && LA13_0<=Unbounded)||(LA13_0>=Argument && LA13_0<=Boolean)||(LA13_0>=Contact && LA13_0<=Output)||(LA13_0>=Prefix && LA13_0<=Unique)||(LA13_0>=Empty && LA13_0<=Value)||(LA13_0>=Base && LA13_0<=Must)||LA13_0==Path||(LA13_0>=True && LA13_0<=Add)||LA13_0==Bit||(LA13_0>=Key && LA13_0<=Min)||LA13_0==Rpc||LA13_0==RULE_ID) ) {
                    alt13=1;
                }


                switch (alt13) {
            	case 1 :
            	    // InternalYangParser.g:2513:4: (lv_references_2_0= ruleKeyReference )
            	    {
            	    // InternalYangParser.g:2513:4: (lv_references_2_0= ruleKeyReference )
            	    // InternalYangParser.g:2514:5: lv_references_2_0= ruleKeyReference
            	    {
            	    if ( state.backtracking==0 ) {

            	      					newCompositeNode(grammarAccess.getKeyAccess().getReferencesKeyReferenceParserRuleCall_2_0());
            	      				
            	    }
            	    pushFollow(FOLLOW_8);
            	    lv_references_2_0=ruleKeyReference();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      					if (current==null) {
            	      						current = createModelElementForParent(grammarAccess.getKeyRule());
            	      					}
            	      					add(
            	      						current,
            	      						"references",
            	      						lv_references_2_0,
            	      						"io.typefox.yang.Yang.KeyReference");
            	      					afterParserOrEnumRuleCall();
            	      				
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt13 >= 1 ) break loop13;
            	    if (state.backtracking>0) {state.failed=true; return current;}
                        EarlyExitException eee =
                            new EarlyExitException(13, input);
                        throw eee;
                }
                cnt13++;
            } while (true);

            if ( state.backtracking==0 ) {

              			if (current==null) {
              				current = createModelElement(grammarAccess.getKeyRule());
              			}
              			newCompositeNode(grammarAccess.getKeyAccess().getStatementEndParserRuleCall_3());
              		
            }
            pushFollow(FOLLOW_2);
            this_StatementEnd_3=ruleStatementEnd(current);

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current = this_StatementEnd_3;
              			afterParserOrEnumRuleCall();
              		
            }

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleKey"


    // $ANTLR start "entryRuleKeyReference"
    // InternalYangParser.g:2546:1: entryRuleKeyReference returns [EObject current=null] : iv_ruleKeyReference= ruleKeyReference EOF ;
    public final EObject entryRuleKeyReference() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleKeyReference = null;


        try {
            // InternalYangParser.g:2546:53: (iv_ruleKeyReference= ruleKeyReference EOF )
            // InternalYangParser.g:2547:2: iv_ruleKeyReference= ruleKeyReference EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getKeyReferenceRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleKeyReference=ruleKeyReference();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleKeyReference; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleKeyReference"


    // $ANTLR start "ruleKeyReference"
    // InternalYangParser.g:2553:1: ruleKeyReference returns [EObject current=null] : ( ( ruleQNAME ) ) ;
    public final EObject ruleKeyReference() throws RecognitionException {
        EObject current = null;


        	enterRule();

        try {
            // InternalYangParser.g:2559:2: ( ( ( ruleQNAME ) ) )
            // InternalYangParser.g:2560:2: ( ( ruleQNAME ) )
            {
            // InternalYangParser.g:2560:2: ( ( ruleQNAME ) )
            // InternalYangParser.g:2561:3: ( ruleQNAME )
            {
            // InternalYangParser.g:2561:3: ( ruleQNAME )
            // InternalYangParser.g:2562:4: ruleQNAME
            {
            if ( state.backtracking==0 ) {

              				if (current==null) {
              					current = createModelElement(grammarAccess.getKeyReferenceRule());
              				}
              			
            }
            if ( state.backtracking==0 ) {

              				newCompositeNode(grammarAccess.getKeyReferenceAccess().getNodeLeafCrossReference_0());
              			
            }
            pushFollow(FOLLOW_2);
            ruleQNAME();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              				afterParserOrEnumRuleCall();
              			
            }

            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleKeyReference"


    // $ANTLR start "ruleDescendantSchemaNodeIdentifierReferences"
    // InternalYangParser.g:2580:1: ruleDescendantSchemaNodeIdentifierReferences[EObject in_current] returns [EObject current=in_current] : ( (lv_references_0_0= ruleDescendantSchemaNodeIdentifier ) )+ ;
    public final EObject ruleDescendantSchemaNodeIdentifierReferences(EObject in_current) throws RecognitionException {
        EObject current = in_current;

        EObject lv_references_0_0 = null;



        	enterRule();

        try {
            // InternalYangParser.g:2586:2: ( ( (lv_references_0_0= ruleDescendantSchemaNodeIdentifier ) )+ )
            // InternalYangParser.g:2587:2: ( (lv_references_0_0= ruleDescendantSchemaNodeIdentifier ) )+
            {
            // InternalYangParser.g:2587:2: ( (lv_references_0_0= ruleDescendantSchemaNodeIdentifier ) )+
            int cnt14=0;
            loop14:
            do {
                int alt14=2;
                int LA14_0 = input.LA(1);

                if ( (LA14_0==InstanceIdentifier||(LA14_0>=RequireInstance && LA14_0<=Deprecated)||(LA14_0>=IfFeature && LA14_0<=OrderedBy)||(LA14_0>=Container && LA14_0<=Extension)||(LA14_0>=LeafList && LA14_0<=Namespace)||(LA14_0>=Reference && LA14_0<=Unbounded)||(LA14_0>=Argument && LA14_0<=Boolean)||(LA14_0>=Contact && LA14_0<=Output)||(LA14_0>=Prefix && LA14_0<=Unique)||(LA14_0>=Empty && LA14_0<=Value)||(LA14_0>=Base && LA14_0<=Must)||LA14_0==Path||(LA14_0>=True && LA14_0<=Add)||LA14_0==Bit||(LA14_0>=Key && LA14_0<=Min)||LA14_0==Rpc||LA14_0==RULE_ID) ) {
                    alt14=1;
                }


                switch (alt14) {
            	case 1 :
            	    // InternalYangParser.g:2588:3: (lv_references_0_0= ruleDescendantSchemaNodeIdentifier )
            	    {
            	    // InternalYangParser.g:2588:3: (lv_references_0_0= ruleDescendantSchemaNodeIdentifier )
            	    // InternalYangParser.g:2589:4: lv_references_0_0= ruleDescendantSchemaNodeIdentifier
            	    {
            	    if ( state.backtracking==0 ) {

            	      				newCompositeNode(grammarAccess.getDescendantSchemaNodeIdentifierReferencesAccess().getReferencesDescendantSchemaNodeIdentifierParserRuleCall_0());
            	      			
            	    }
            	    pushFollow(FOLLOW_9);
            	    lv_references_0_0=ruleDescendantSchemaNodeIdentifier();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      				if (current==null) {
            	      					current = createModelElementForParent(grammarAccess.getDescendantSchemaNodeIdentifierReferencesRule());
            	      				}
            	      				add(
            	      					current,
            	      					"references",
            	      					lv_references_0_0,
            	      					"io.typefox.yang.Yang.DescendantSchemaNodeIdentifier");
            	      				afterParserOrEnumRuleCall();
            	      			
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt14 >= 1 ) break loop14;
            	    if (state.backtracking>0) {state.failed=true; return current;}
                        EarlyExitException eee =
                            new EarlyExitException(14, input);
                        throw eee;
                }
                cnt14++;
            } while (true);


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleDescendantSchemaNodeIdentifierReferences"


    // $ANTLR start "entryRuleUnique"
    // InternalYangParser.g:2609:1: entryRuleUnique returns [EObject current=null] : iv_ruleUnique= ruleUnique EOF ;
    public final EObject entryRuleUnique() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleUnique = null;


        try {
            // InternalYangParser.g:2609:47: (iv_ruleUnique= ruleUnique EOF )
            // InternalYangParser.g:2610:2: iv_ruleUnique= ruleUnique EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getUniqueRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleUnique=ruleUnique();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleUnique; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleUnique"


    // $ANTLR start "ruleUnique"
    // InternalYangParser.g:2616:1: ruleUnique returns [EObject current=null] : ( () otherlv_1= Unique this_DescendantSchemaNodeIdentifierReferences_2= ruleDescendantSchemaNodeIdentifierReferences[$current] this_StatementEnd_3= ruleStatementEnd[$current] ) ;
    public final EObject ruleUnique() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject this_DescendantSchemaNodeIdentifierReferences_2 = null;

        EObject this_StatementEnd_3 = null;



        	enterRule();

        try {
            // InternalYangParser.g:2622:2: ( ( () otherlv_1= Unique this_DescendantSchemaNodeIdentifierReferences_2= ruleDescendantSchemaNodeIdentifierReferences[$current] this_StatementEnd_3= ruleStatementEnd[$current] ) )
            // InternalYangParser.g:2623:2: ( () otherlv_1= Unique this_DescendantSchemaNodeIdentifierReferences_2= ruleDescendantSchemaNodeIdentifierReferences[$current] this_StatementEnd_3= ruleStatementEnd[$current] )
            {
            // InternalYangParser.g:2623:2: ( () otherlv_1= Unique this_DescendantSchemaNodeIdentifierReferences_2= ruleDescendantSchemaNodeIdentifierReferences[$current] this_StatementEnd_3= ruleStatementEnd[$current] )
            // InternalYangParser.g:2624:3: () otherlv_1= Unique this_DescendantSchemaNodeIdentifierReferences_2= ruleDescendantSchemaNodeIdentifierReferences[$current] this_StatementEnd_3= ruleStatementEnd[$current]
            {
            // InternalYangParser.g:2624:3: ()
            // InternalYangParser.g:2625:4: 
            {
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getUniqueAccess().getUniqueAction_0(),
              					current);
              			
            }

            }

            otherlv_1=(Token)match(input,Unique,FOLLOW_6); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getUniqueAccess().getUniqueKeyword_1());
              		
            }
            if ( state.backtracking==0 ) {

              			if (current==null) {
              				current = createModelElement(grammarAccess.getUniqueRule());
              			}
              			newCompositeNode(grammarAccess.getUniqueAccess().getDescendantSchemaNodeIdentifierReferencesParserRuleCall_2());
              		
            }
            pushFollow(FOLLOW_5);
            this_DescendantSchemaNodeIdentifierReferences_2=ruleDescendantSchemaNodeIdentifierReferences(current);

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current = this_DescendantSchemaNodeIdentifierReferences_2;
              			afterParserOrEnumRuleCall();
              		
            }
            if ( state.backtracking==0 ) {

              			if (current==null) {
              				current = createModelElement(grammarAccess.getUniqueRule());
              			}
              			newCompositeNode(grammarAccess.getUniqueAccess().getStatementEndParserRuleCall_3());
              		
            }
            pushFollow(FOLLOW_2);
            this_StatementEnd_3=ruleStatementEnd(current);

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current = this_StatementEnd_3;
              			afterParserOrEnumRuleCall();
              		
            }

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleUnique"


    // $ANTLR start "entryRuleChoice"
    // InternalYangParser.g:2661:1: entryRuleChoice returns [EObject current=null] : iv_ruleChoice= ruleChoice EOF ;
    public final EObject entryRuleChoice() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleChoice = null;


        try {
            // InternalYangParser.g:2661:47: (iv_ruleChoice= ruleChoice EOF )
            // InternalYangParser.g:2662:2: iv_ruleChoice= ruleChoice EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getChoiceRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleChoice=ruleChoice();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleChoice; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleChoice"


    // $ANTLR start "ruleChoice"
    // InternalYangParser.g:2668:1: ruleChoice returns [EObject current=null] : (otherlv_0= Choice ( (lv_name_1_0= ruleStringValue ) ) this_StatementEnd_2= ruleStatementEnd[$current] ) ;
    public final EObject ruleChoice() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        AntlrDatatypeRuleToken lv_name_1_0 = null;

        EObject this_StatementEnd_2 = null;



        	enterRule();

        try {
            // InternalYangParser.g:2674:2: ( (otherlv_0= Choice ( (lv_name_1_0= ruleStringValue ) ) this_StatementEnd_2= ruleStatementEnd[$current] ) )
            // InternalYangParser.g:2675:2: (otherlv_0= Choice ( (lv_name_1_0= ruleStringValue ) ) this_StatementEnd_2= ruleStatementEnd[$current] )
            {
            // InternalYangParser.g:2675:2: (otherlv_0= Choice ( (lv_name_1_0= ruleStringValue ) ) this_StatementEnd_2= ruleStatementEnd[$current] )
            // InternalYangParser.g:2676:3: otherlv_0= Choice ( (lv_name_1_0= ruleStringValue ) ) this_StatementEnd_2= ruleStatementEnd[$current]
            {
            otherlv_0=(Token)match(input,Choice,FOLLOW_4); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getChoiceAccess().getChoiceKeyword_0());
              		
            }
            // InternalYangParser.g:2680:3: ( (lv_name_1_0= ruleStringValue ) )
            // InternalYangParser.g:2681:4: (lv_name_1_0= ruleStringValue )
            {
            // InternalYangParser.g:2681:4: (lv_name_1_0= ruleStringValue )
            // InternalYangParser.g:2682:5: lv_name_1_0= ruleStringValue
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getChoiceAccess().getNameStringValueParserRuleCall_1_0());
              				
            }
            pushFollow(FOLLOW_5);
            lv_name_1_0=ruleStringValue();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getChoiceRule());
              					}
              					set(
              						current,
              						"name",
              						lv_name_1_0,
              						"io.typefox.yang.Yang.StringValue");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            if ( state.backtracking==0 ) {

              			if (current==null) {
              				current = createModelElement(grammarAccess.getChoiceRule());
              			}
              			newCompositeNode(grammarAccess.getChoiceAccess().getStatementEndParserRuleCall_2());
              		
            }
            pushFollow(FOLLOW_2);
            this_StatementEnd_2=ruleStatementEnd(current);

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current = this_StatementEnd_2;
              			afterParserOrEnumRuleCall();
              		
            }

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleChoice"


    // $ANTLR start "entryRuleCase"
    // InternalYangParser.g:2714:1: entryRuleCase returns [EObject current=null] : iv_ruleCase= ruleCase EOF ;
    public final EObject entryRuleCase() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCase = null;


        try {
            // InternalYangParser.g:2714:45: (iv_ruleCase= ruleCase EOF )
            // InternalYangParser.g:2715:2: iv_ruleCase= ruleCase EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getCaseRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleCase=ruleCase();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleCase; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleCase"


    // $ANTLR start "ruleCase"
    // InternalYangParser.g:2721:1: ruleCase returns [EObject current=null] : (otherlv_0= Case ( (lv_name_1_0= ruleStringValue ) ) this_StatementEnd_2= ruleStatementEnd[$current] ) ;
    public final EObject ruleCase() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        AntlrDatatypeRuleToken lv_name_1_0 = null;

        EObject this_StatementEnd_2 = null;



        	enterRule();

        try {
            // InternalYangParser.g:2727:2: ( (otherlv_0= Case ( (lv_name_1_0= ruleStringValue ) ) this_StatementEnd_2= ruleStatementEnd[$current] ) )
            // InternalYangParser.g:2728:2: (otherlv_0= Case ( (lv_name_1_0= ruleStringValue ) ) this_StatementEnd_2= ruleStatementEnd[$current] )
            {
            // InternalYangParser.g:2728:2: (otherlv_0= Case ( (lv_name_1_0= ruleStringValue ) ) this_StatementEnd_2= ruleStatementEnd[$current] )
            // InternalYangParser.g:2729:3: otherlv_0= Case ( (lv_name_1_0= ruleStringValue ) ) this_StatementEnd_2= ruleStatementEnd[$current]
            {
            otherlv_0=(Token)match(input,Case,FOLLOW_4); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getCaseAccess().getCaseKeyword_0());
              		
            }
            // InternalYangParser.g:2733:3: ( (lv_name_1_0= ruleStringValue ) )
            // InternalYangParser.g:2734:4: (lv_name_1_0= ruleStringValue )
            {
            // InternalYangParser.g:2734:4: (lv_name_1_0= ruleStringValue )
            // InternalYangParser.g:2735:5: lv_name_1_0= ruleStringValue
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getCaseAccess().getNameStringValueParserRuleCall_1_0());
              				
            }
            pushFollow(FOLLOW_5);
            lv_name_1_0=ruleStringValue();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getCaseRule());
              					}
              					set(
              						current,
              						"name",
              						lv_name_1_0,
              						"io.typefox.yang.Yang.StringValue");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            if ( state.backtracking==0 ) {

              			if (current==null) {
              				current = createModelElement(grammarAccess.getCaseRule());
              			}
              			newCompositeNode(grammarAccess.getCaseAccess().getStatementEndParserRuleCall_2());
              		
            }
            pushFollow(FOLLOW_2);
            this_StatementEnd_2=ruleStatementEnd(current);

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current = this_StatementEnd_2;
              			afterParserOrEnumRuleCall();
              		
            }

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleCase"


    // $ANTLR start "entryRuleAnydata"
    // InternalYangParser.g:2767:1: entryRuleAnydata returns [EObject current=null] : iv_ruleAnydata= ruleAnydata EOF ;
    public final EObject entryRuleAnydata() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAnydata = null;


        try {
            // InternalYangParser.g:2767:48: (iv_ruleAnydata= ruleAnydata EOF )
            // InternalYangParser.g:2768:2: iv_ruleAnydata= ruleAnydata EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getAnydataRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleAnydata=ruleAnydata();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleAnydata; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleAnydata"


    // $ANTLR start "ruleAnydata"
    // InternalYangParser.g:2774:1: ruleAnydata returns [EObject current=null] : (otherlv_0= Anydata ( (lv_name_1_0= ruleStringValue ) ) this_StatementEnd_2= ruleStatementEnd[$current] ) ;
    public final EObject ruleAnydata() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        AntlrDatatypeRuleToken lv_name_1_0 = null;

        EObject this_StatementEnd_2 = null;



        	enterRule();

        try {
            // InternalYangParser.g:2780:2: ( (otherlv_0= Anydata ( (lv_name_1_0= ruleStringValue ) ) this_StatementEnd_2= ruleStatementEnd[$current] ) )
            // InternalYangParser.g:2781:2: (otherlv_0= Anydata ( (lv_name_1_0= ruleStringValue ) ) this_StatementEnd_2= ruleStatementEnd[$current] )
            {
            // InternalYangParser.g:2781:2: (otherlv_0= Anydata ( (lv_name_1_0= ruleStringValue ) ) this_StatementEnd_2= ruleStatementEnd[$current] )
            // InternalYangParser.g:2782:3: otherlv_0= Anydata ( (lv_name_1_0= ruleStringValue ) ) this_StatementEnd_2= ruleStatementEnd[$current]
            {
            otherlv_0=(Token)match(input,Anydata,FOLLOW_4); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getAnydataAccess().getAnydataKeyword_0());
              		
            }
            // InternalYangParser.g:2786:3: ( (lv_name_1_0= ruleStringValue ) )
            // InternalYangParser.g:2787:4: (lv_name_1_0= ruleStringValue )
            {
            // InternalYangParser.g:2787:4: (lv_name_1_0= ruleStringValue )
            // InternalYangParser.g:2788:5: lv_name_1_0= ruleStringValue
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getAnydataAccess().getNameStringValueParserRuleCall_1_0());
              				
            }
            pushFollow(FOLLOW_5);
            lv_name_1_0=ruleStringValue();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getAnydataRule());
              					}
              					set(
              						current,
              						"name",
              						lv_name_1_0,
              						"io.typefox.yang.Yang.StringValue");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            if ( state.backtracking==0 ) {

              			if (current==null) {
              				current = createModelElement(grammarAccess.getAnydataRule());
              			}
              			newCompositeNode(grammarAccess.getAnydataAccess().getStatementEndParserRuleCall_2());
              		
            }
            pushFollow(FOLLOW_2);
            this_StatementEnd_2=ruleStatementEnd(current);

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current = this_StatementEnd_2;
              			afterParserOrEnumRuleCall();
              		
            }

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleAnydata"


    // $ANTLR start "entryRuleAnyxml"
    // InternalYangParser.g:2820:1: entryRuleAnyxml returns [EObject current=null] : iv_ruleAnyxml= ruleAnyxml EOF ;
    public final EObject entryRuleAnyxml() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAnyxml = null;


        try {
            // InternalYangParser.g:2820:47: (iv_ruleAnyxml= ruleAnyxml EOF )
            // InternalYangParser.g:2821:2: iv_ruleAnyxml= ruleAnyxml EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getAnyxmlRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleAnyxml=ruleAnyxml();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleAnyxml; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleAnyxml"


    // $ANTLR start "ruleAnyxml"
    // InternalYangParser.g:2827:1: ruleAnyxml returns [EObject current=null] : (otherlv_0= Anyxml ( (lv_name_1_0= ruleStringValue ) ) this_StatementEnd_2= ruleStatementEnd[$current] ) ;
    public final EObject ruleAnyxml() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        AntlrDatatypeRuleToken lv_name_1_0 = null;

        EObject this_StatementEnd_2 = null;



        	enterRule();

        try {
            // InternalYangParser.g:2833:2: ( (otherlv_0= Anyxml ( (lv_name_1_0= ruleStringValue ) ) this_StatementEnd_2= ruleStatementEnd[$current] ) )
            // InternalYangParser.g:2834:2: (otherlv_0= Anyxml ( (lv_name_1_0= ruleStringValue ) ) this_StatementEnd_2= ruleStatementEnd[$current] )
            {
            // InternalYangParser.g:2834:2: (otherlv_0= Anyxml ( (lv_name_1_0= ruleStringValue ) ) this_StatementEnd_2= ruleStatementEnd[$current] )
            // InternalYangParser.g:2835:3: otherlv_0= Anyxml ( (lv_name_1_0= ruleStringValue ) ) this_StatementEnd_2= ruleStatementEnd[$current]
            {
            otherlv_0=(Token)match(input,Anyxml,FOLLOW_4); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getAnyxmlAccess().getAnyxmlKeyword_0());
              		
            }
            // InternalYangParser.g:2839:3: ( (lv_name_1_0= ruleStringValue ) )
            // InternalYangParser.g:2840:4: (lv_name_1_0= ruleStringValue )
            {
            // InternalYangParser.g:2840:4: (lv_name_1_0= ruleStringValue )
            // InternalYangParser.g:2841:5: lv_name_1_0= ruleStringValue
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getAnyxmlAccess().getNameStringValueParserRuleCall_1_0());
              				
            }
            pushFollow(FOLLOW_5);
            lv_name_1_0=ruleStringValue();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getAnyxmlRule());
              					}
              					set(
              						current,
              						"name",
              						lv_name_1_0,
              						"io.typefox.yang.Yang.StringValue");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            if ( state.backtracking==0 ) {

              			if (current==null) {
              				current = createModelElement(grammarAccess.getAnyxmlRule());
              			}
              			newCompositeNode(grammarAccess.getAnyxmlAccess().getStatementEndParserRuleCall_2());
              		
            }
            pushFollow(FOLLOW_2);
            this_StatementEnd_2=ruleStatementEnd(current);

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current = this_StatementEnd_2;
              			afterParserOrEnumRuleCall();
              		
            }

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleAnyxml"


    // $ANTLR start "entryRuleGrouping"
    // InternalYangParser.g:2873:1: entryRuleGrouping returns [EObject current=null] : iv_ruleGrouping= ruleGrouping EOF ;
    public final EObject entryRuleGrouping() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleGrouping = null;


        try {
            // InternalYangParser.g:2873:49: (iv_ruleGrouping= ruleGrouping EOF )
            // InternalYangParser.g:2874:2: iv_ruleGrouping= ruleGrouping EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getGroupingRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleGrouping=ruleGrouping();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleGrouping; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleGrouping"


    // $ANTLR start "ruleGrouping"
    // InternalYangParser.g:2880:1: ruleGrouping returns [EObject current=null] : (otherlv_0= Grouping ( (lv_name_1_0= ruleStringValue ) ) this_StatementEnd_2= ruleStatementEnd[$current] ) ;
    public final EObject ruleGrouping() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        AntlrDatatypeRuleToken lv_name_1_0 = null;

        EObject this_StatementEnd_2 = null;



        	enterRule();

        try {
            // InternalYangParser.g:2886:2: ( (otherlv_0= Grouping ( (lv_name_1_0= ruleStringValue ) ) this_StatementEnd_2= ruleStatementEnd[$current] ) )
            // InternalYangParser.g:2887:2: (otherlv_0= Grouping ( (lv_name_1_0= ruleStringValue ) ) this_StatementEnd_2= ruleStatementEnd[$current] )
            {
            // InternalYangParser.g:2887:2: (otherlv_0= Grouping ( (lv_name_1_0= ruleStringValue ) ) this_StatementEnd_2= ruleStatementEnd[$current] )
            // InternalYangParser.g:2888:3: otherlv_0= Grouping ( (lv_name_1_0= ruleStringValue ) ) this_StatementEnd_2= ruleStatementEnd[$current]
            {
            otherlv_0=(Token)match(input,Grouping,FOLLOW_4); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getGroupingAccess().getGroupingKeyword_0());
              		
            }
            // InternalYangParser.g:2892:3: ( (lv_name_1_0= ruleStringValue ) )
            // InternalYangParser.g:2893:4: (lv_name_1_0= ruleStringValue )
            {
            // InternalYangParser.g:2893:4: (lv_name_1_0= ruleStringValue )
            // InternalYangParser.g:2894:5: lv_name_1_0= ruleStringValue
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getGroupingAccess().getNameStringValueParserRuleCall_1_0());
              				
            }
            pushFollow(FOLLOW_5);
            lv_name_1_0=ruleStringValue();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getGroupingRule());
              					}
              					set(
              						current,
              						"name",
              						lv_name_1_0,
              						"io.typefox.yang.Yang.StringValue");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            if ( state.backtracking==0 ) {

              			if (current==null) {
              				current = createModelElement(grammarAccess.getGroupingRule());
              			}
              			newCompositeNode(grammarAccess.getGroupingAccess().getStatementEndParserRuleCall_2());
              		
            }
            pushFollow(FOLLOW_2);
            this_StatementEnd_2=ruleStatementEnd(current);

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current = this_StatementEnd_2;
              			afterParserOrEnumRuleCall();
              		
            }

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleGrouping"


    // $ANTLR start "entryRuleUses"
    // InternalYangParser.g:2926:1: entryRuleUses returns [EObject current=null] : iv_ruleUses= ruleUses EOF ;
    public final EObject entryRuleUses() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleUses = null;


        try {
            // InternalYangParser.g:2926:45: (iv_ruleUses= ruleUses EOF )
            // InternalYangParser.g:2927:2: iv_ruleUses= ruleUses EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getUsesRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleUses=ruleUses();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleUses; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleUses"


    // $ANTLR start "ruleUses"
    // InternalYangParser.g:2933:1: ruleUses returns [EObject current=null] : (otherlv_0= Uses ( (lv_grouping_1_0= ruleGroupingRef ) ) this_StatementEnd_2= ruleStatementEnd[$current] ) ;
    public final EObject ruleUses() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        EObject lv_grouping_1_0 = null;

        EObject this_StatementEnd_2 = null;



        	enterRule();

        try {
            // InternalYangParser.g:2939:2: ( (otherlv_0= Uses ( (lv_grouping_1_0= ruleGroupingRef ) ) this_StatementEnd_2= ruleStatementEnd[$current] ) )
            // InternalYangParser.g:2940:2: (otherlv_0= Uses ( (lv_grouping_1_0= ruleGroupingRef ) ) this_StatementEnd_2= ruleStatementEnd[$current] )
            {
            // InternalYangParser.g:2940:2: (otherlv_0= Uses ( (lv_grouping_1_0= ruleGroupingRef ) ) this_StatementEnd_2= ruleStatementEnd[$current] )
            // InternalYangParser.g:2941:3: otherlv_0= Uses ( (lv_grouping_1_0= ruleGroupingRef ) ) this_StatementEnd_2= ruleStatementEnd[$current]
            {
            otherlv_0=(Token)match(input,Uses,FOLLOW_6); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getUsesAccess().getUsesKeyword_0());
              		
            }
            // InternalYangParser.g:2945:3: ( (lv_grouping_1_0= ruleGroupingRef ) )
            // InternalYangParser.g:2946:4: (lv_grouping_1_0= ruleGroupingRef )
            {
            // InternalYangParser.g:2946:4: (lv_grouping_1_0= ruleGroupingRef )
            // InternalYangParser.g:2947:5: lv_grouping_1_0= ruleGroupingRef
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getUsesAccess().getGroupingGroupingRefParserRuleCall_1_0());
              				
            }
            pushFollow(FOLLOW_5);
            lv_grouping_1_0=ruleGroupingRef();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getUsesRule());
              					}
              					set(
              						current,
              						"grouping",
              						lv_grouping_1_0,
              						"io.typefox.yang.Yang.GroupingRef");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            if ( state.backtracking==0 ) {

              			if (current==null) {
              				current = createModelElement(grammarAccess.getUsesRule());
              			}
              			newCompositeNode(grammarAccess.getUsesAccess().getStatementEndParserRuleCall_2());
              		
            }
            pushFollow(FOLLOW_2);
            this_StatementEnd_2=ruleStatementEnd(current);

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current = this_StatementEnd_2;
              			afterParserOrEnumRuleCall();
              		
            }

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleUses"


    // $ANTLR start "entryRuleRefine"
    // InternalYangParser.g:2979:1: entryRuleRefine returns [EObject current=null] : iv_ruleRefine= ruleRefine EOF ;
    public final EObject entryRuleRefine() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRefine = null;


        try {
            // InternalYangParser.g:2979:47: (iv_ruleRefine= ruleRefine EOF )
            // InternalYangParser.g:2980:2: iv_ruleRefine= ruleRefine EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getRefineRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleRefine=ruleRefine();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleRefine; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleRefine"


    // $ANTLR start "ruleRefine"
    // InternalYangParser.g:2986:1: ruleRefine returns [EObject current=null] : (otherlv_0= Refine ( (lv_node_1_0= ruleSchemaNodeIdentifier ) ) this_StatementEnd_2= ruleStatementEnd[$current] ) ;
    public final EObject ruleRefine() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        EObject lv_node_1_0 = null;

        EObject this_StatementEnd_2 = null;



        	enterRule();

        try {
            // InternalYangParser.g:2992:2: ( (otherlv_0= Refine ( (lv_node_1_0= ruleSchemaNodeIdentifier ) ) this_StatementEnd_2= ruleStatementEnd[$current] ) )
            // InternalYangParser.g:2993:2: (otherlv_0= Refine ( (lv_node_1_0= ruleSchemaNodeIdentifier ) ) this_StatementEnd_2= ruleStatementEnd[$current] )
            {
            // InternalYangParser.g:2993:2: (otherlv_0= Refine ( (lv_node_1_0= ruleSchemaNodeIdentifier ) ) this_StatementEnd_2= ruleStatementEnd[$current] )
            // InternalYangParser.g:2994:3: otherlv_0= Refine ( (lv_node_1_0= ruleSchemaNodeIdentifier ) ) this_StatementEnd_2= ruleStatementEnd[$current]
            {
            otherlv_0=(Token)match(input,Refine,FOLLOW_10); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getRefineAccess().getRefineKeyword_0());
              		
            }
            // InternalYangParser.g:2998:3: ( (lv_node_1_0= ruleSchemaNodeIdentifier ) )
            // InternalYangParser.g:2999:4: (lv_node_1_0= ruleSchemaNodeIdentifier )
            {
            // InternalYangParser.g:2999:4: (lv_node_1_0= ruleSchemaNodeIdentifier )
            // InternalYangParser.g:3000:5: lv_node_1_0= ruleSchemaNodeIdentifier
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getRefineAccess().getNodeSchemaNodeIdentifierParserRuleCall_1_0());
              				
            }
            pushFollow(FOLLOW_5);
            lv_node_1_0=ruleSchemaNodeIdentifier();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getRefineRule());
              					}
              					set(
              						current,
              						"node",
              						lv_node_1_0,
              						"io.typefox.yang.Yang.SchemaNodeIdentifier");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            if ( state.backtracking==0 ) {

              			if (current==null) {
              				current = createModelElement(grammarAccess.getRefineRule());
              			}
              			newCompositeNode(grammarAccess.getRefineAccess().getStatementEndParserRuleCall_2());
              		
            }
            pushFollow(FOLLOW_2);
            this_StatementEnd_2=ruleStatementEnd(current);

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current = this_StatementEnd_2;
              			afterParserOrEnumRuleCall();
              		
            }

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleRefine"


    // $ANTLR start "entryRuleRpc"
    // InternalYangParser.g:3032:1: entryRuleRpc returns [EObject current=null] : iv_ruleRpc= ruleRpc EOF ;
    public final EObject entryRuleRpc() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRpc = null;


        try {
            // InternalYangParser.g:3032:44: (iv_ruleRpc= ruleRpc EOF )
            // InternalYangParser.g:3033:2: iv_ruleRpc= ruleRpc EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getRpcRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleRpc=ruleRpc();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleRpc; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleRpc"


    // $ANTLR start "ruleRpc"
    // InternalYangParser.g:3039:1: ruleRpc returns [EObject current=null] : (otherlv_0= Rpc ( (lv_name_1_0= ruleStringValue ) ) this_StatementEnd_2= ruleStatementEnd[$current] ) ;
    public final EObject ruleRpc() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        AntlrDatatypeRuleToken lv_name_1_0 = null;

        EObject this_StatementEnd_2 = null;



        	enterRule();

        try {
            // InternalYangParser.g:3045:2: ( (otherlv_0= Rpc ( (lv_name_1_0= ruleStringValue ) ) this_StatementEnd_2= ruleStatementEnd[$current] ) )
            // InternalYangParser.g:3046:2: (otherlv_0= Rpc ( (lv_name_1_0= ruleStringValue ) ) this_StatementEnd_2= ruleStatementEnd[$current] )
            {
            // InternalYangParser.g:3046:2: (otherlv_0= Rpc ( (lv_name_1_0= ruleStringValue ) ) this_StatementEnd_2= ruleStatementEnd[$current] )
            // InternalYangParser.g:3047:3: otherlv_0= Rpc ( (lv_name_1_0= ruleStringValue ) ) this_StatementEnd_2= ruleStatementEnd[$current]
            {
            otherlv_0=(Token)match(input,Rpc,FOLLOW_4); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getRpcAccess().getRpcKeyword_0());
              		
            }
            // InternalYangParser.g:3051:3: ( (lv_name_1_0= ruleStringValue ) )
            // InternalYangParser.g:3052:4: (lv_name_1_0= ruleStringValue )
            {
            // InternalYangParser.g:3052:4: (lv_name_1_0= ruleStringValue )
            // InternalYangParser.g:3053:5: lv_name_1_0= ruleStringValue
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getRpcAccess().getNameStringValueParserRuleCall_1_0());
              				
            }
            pushFollow(FOLLOW_5);
            lv_name_1_0=ruleStringValue();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getRpcRule());
              					}
              					set(
              						current,
              						"name",
              						lv_name_1_0,
              						"io.typefox.yang.Yang.StringValue");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            if ( state.backtracking==0 ) {

              			if (current==null) {
              				current = createModelElement(grammarAccess.getRpcRule());
              			}
              			newCompositeNode(grammarAccess.getRpcAccess().getStatementEndParserRuleCall_2());
              		
            }
            pushFollow(FOLLOW_2);
            this_StatementEnd_2=ruleStatementEnd(current);

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current = this_StatementEnd_2;
              			afterParserOrEnumRuleCall();
              		
            }

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleRpc"


    // $ANTLR start "entryRuleInput"
    // InternalYangParser.g:3085:1: entryRuleInput returns [EObject current=null] : iv_ruleInput= ruleInput EOF ;
    public final EObject entryRuleInput() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleInput = null;


        try {
            // InternalYangParser.g:3085:46: (iv_ruleInput= ruleInput EOF )
            // InternalYangParser.g:3086:2: iv_ruleInput= ruleInput EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getInputRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleInput=ruleInput();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleInput; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleInput"


    // $ANTLR start "ruleInput"
    // InternalYangParser.g:3092:1: ruleInput returns [EObject current=null] : ( () otherlv_1= Input ( (lv_name_2_0= ruleStringValue ) )? this_StatementEnd_3= ruleStatementEnd[$current] ) ;
    public final EObject ruleInput() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        AntlrDatatypeRuleToken lv_name_2_0 = null;

        EObject this_StatementEnd_3 = null;



        	enterRule();

        try {
            // InternalYangParser.g:3098:2: ( ( () otherlv_1= Input ( (lv_name_2_0= ruleStringValue ) )? this_StatementEnd_3= ruleStatementEnd[$current] ) )
            // InternalYangParser.g:3099:2: ( () otherlv_1= Input ( (lv_name_2_0= ruleStringValue ) )? this_StatementEnd_3= ruleStatementEnd[$current] )
            {
            // InternalYangParser.g:3099:2: ( () otherlv_1= Input ( (lv_name_2_0= ruleStringValue ) )? this_StatementEnd_3= ruleStatementEnd[$current] )
            // InternalYangParser.g:3100:3: () otherlv_1= Input ( (lv_name_2_0= ruleStringValue ) )? this_StatementEnd_3= ruleStatementEnd[$current]
            {
            // InternalYangParser.g:3100:3: ()
            // InternalYangParser.g:3101:4: 
            {
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getInputAccess().getInputAction_0(),
              					current);
              			
            }

            }

            otherlv_1=(Token)match(input,Input,FOLLOW_11); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getInputAccess().getInputKeyword_1());
              		
            }
            // InternalYangParser.g:3111:3: ( (lv_name_2_0= ruleStringValue ) )?
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( (LA15_0==RULE_STRING) ) {
                alt15=1;
            }
            switch (alt15) {
                case 1 :
                    // InternalYangParser.g:3112:4: (lv_name_2_0= ruleStringValue )
                    {
                    // InternalYangParser.g:3112:4: (lv_name_2_0= ruleStringValue )
                    // InternalYangParser.g:3113:5: lv_name_2_0= ruleStringValue
                    {
                    if ( state.backtracking==0 ) {

                      					newCompositeNode(grammarAccess.getInputAccess().getNameStringValueParserRuleCall_2_0());
                      				
                    }
                    pushFollow(FOLLOW_5);
                    lv_name_2_0=ruleStringValue();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					if (current==null) {
                      						current = createModelElementForParent(grammarAccess.getInputRule());
                      					}
                      					set(
                      						current,
                      						"name",
                      						lv_name_2_0,
                      						"io.typefox.yang.Yang.StringValue");
                      					afterParserOrEnumRuleCall();
                      				
                    }

                    }


                    }
                    break;

            }

            if ( state.backtracking==0 ) {

              			if (current==null) {
              				current = createModelElement(grammarAccess.getInputRule());
              			}
              			newCompositeNode(grammarAccess.getInputAccess().getStatementEndParserRuleCall_3());
              		
            }
            pushFollow(FOLLOW_2);
            this_StatementEnd_3=ruleStatementEnd(current);

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current = this_StatementEnd_3;
              			afterParserOrEnumRuleCall();
              		
            }

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleInput"


    // $ANTLR start "entryRuleOutput"
    // InternalYangParser.g:3145:1: entryRuleOutput returns [EObject current=null] : iv_ruleOutput= ruleOutput EOF ;
    public final EObject entryRuleOutput() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleOutput = null;


        try {
            // InternalYangParser.g:3145:47: (iv_ruleOutput= ruleOutput EOF )
            // InternalYangParser.g:3146:2: iv_ruleOutput= ruleOutput EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getOutputRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleOutput=ruleOutput();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleOutput; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleOutput"


    // $ANTLR start "ruleOutput"
    // InternalYangParser.g:3152:1: ruleOutput returns [EObject current=null] : ( () otherlv_1= Output ( (lv_name_2_0= ruleStringValue ) )? this_StatementEnd_3= ruleStatementEnd[$current] ) ;
    public final EObject ruleOutput() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        AntlrDatatypeRuleToken lv_name_2_0 = null;

        EObject this_StatementEnd_3 = null;



        	enterRule();

        try {
            // InternalYangParser.g:3158:2: ( ( () otherlv_1= Output ( (lv_name_2_0= ruleStringValue ) )? this_StatementEnd_3= ruleStatementEnd[$current] ) )
            // InternalYangParser.g:3159:2: ( () otherlv_1= Output ( (lv_name_2_0= ruleStringValue ) )? this_StatementEnd_3= ruleStatementEnd[$current] )
            {
            // InternalYangParser.g:3159:2: ( () otherlv_1= Output ( (lv_name_2_0= ruleStringValue ) )? this_StatementEnd_3= ruleStatementEnd[$current] )
            // InternalYangParser.g:3160:3: () otherlv_1= Output ( (lv_name_2_0= ruleStringValue ) )? this_StatementEnd_3= ruleStatementEnd[$current]
            {
            // InternalYangParser.g:3160:3: ()
            // InternalYangParser.g:3161:4: 
            {
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getOutputAccess().getOutputAction_0(),
              					current);
              			
            }

            }

            otherlv_1=(Token)match(input,Output,FOLLOW_11); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getOutputAccess().getOutputKeyword_1());
              		
            }
            // InternalYangParser.g:3171:3: ( (lv_name_2_0= ruleStringValue ) )?
            int alt16=2;
            int LA16_0 = input.LA(1);

            if ( (LA16_0==RULE_STRING) ) {
                alt16=1;
            }
            switch (alt16) {
                case 1 :
                    // InternalYangParser.g:3172:4: (lv_name_2_0= ruleStringValue )
                    {
                    // InternalYangParser.g:3172:4: (lv_name_2_0= ruleStringValue )
                    // InternalYangParser.g:3173:5: lv_name_2_0= ruleStringValue
                    {
                    if ( state.backtracking==0 ) {

                      					newCompositeNode(grammarAccess.getOutputAccess().getNameStringValueParserRuleCall_2_0());
                      				
                    }
                    pushFollow(FOLLOW_5);
                    lv_name_2_0=ruleStringValue();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					if (current==null) {
                      						current = createModelElementForParent(grammarAccess.getOutputRule());
                      					}
                      					set(
                      						current,
                      						"name",
                      						lv_name_2_0,
                      						"io.typefox.yang.Yang.StringValue");
                      					afterParserOrEnumRuleCall();
                      				
                    }

                    }


                    }
                    break;

            }

            if ( state.backtracking==0 ) {

              			if (current==null) {
              				current = createModelElement(grammarAccess.getOutputRule());
              			}
              			newCompositeNode(grammarAccess.getOutputAccess().getStatementEndParserRuleCall_3());
              		
            }
            pushFollow(FOLLOW_2);
            this_StatementEnd_3=ruleStatementEnd(current);

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current = this_StatementEnd_3;
              			afterParserOrEnumRuleCall();
              		
            }

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleOutput"


    // $ANTLR start "entryRuleAction"
    // InternalYangParser.g:3205:1: entryRuleAction returns [EObject current=null] : iv_ruleAction= ruleAction EOF ;
    public final EObject entryRuleAction() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAction = null;


        try {
            // InternalYangParser.g:3205:47: (iv_ruleAction= ruleAction EOF )
            // InternalYangParser.g:3206:2: iv_ruleAction= ruleAction EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getActionRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleAction=ruleAction();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleAction; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleAction"


    // $ANTLR start "ruleAction"
    // InternalYangParser.g:3212:1: ruleAction returns [EObject current=null] : (otherlv_0= Action ( (lv_name_1_0= ruleStringValue ) ) this_StatementEnd_2= ruleStatementEnd[$current] ) ;
    public final EObject ruleAction() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        AntlrDatatypeRuleToken lv_name_1_0 = null;

        EObject this_StatementEnd_2 = null;



        	enterRule();

        try {
            // InternalYangParser.g:3218:2: ( (otherlv_0= Action ( (lv_name_1_0= ruleStringValue ) ) this_StatementEnd_2= ruleStatementEnd[$current] ) )
            // InternalYangParser.g:3219:2: (otherlv_0= Action ( (lv_name_1_0= ruleStringValue ) ) this_StatementEnd_2= ruleStatementEnd[$current] )
            {
            // InternalYangParser.g:3219:2: (otherlv_0= Action ( (lv_name_1_0= ruleStringValue ) ) this_StatementEnd_2= ruleStatementEnd[$current] )
            // InternalYangParser.g:3220:3: otherlv_0= Action ( (lv_name_1_0= ruleStringValue ) ) this_StatementEnd_2= ruleStatementEnd[$current]
            {
            otherlv_0=(Token)match(input,Action,FOLLOW_4); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getActionAccess().getActionKeyword_0());
              		
            }
            // InternalYangParser.g:3224:3: ( (lv_name_1_0= ruleStringValue ) )
            // InternalYangParser.g:3225:4: (lv_name_1_0= ruleStringValue )
            {
            // InternalYangParser.g:3225:4: (lv_name_1_0= ruleStringValue )
            // InternalYangParser.g:3226:5: lv_name_1_0= ruleStringValue
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getActionAccess().getNameStringValueParserRuleCall_1_0());
              				
            }
            pushFollow(FOLLOW_5);
            lv_name_1_0=ruleStringValue();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getActionRule());
              					}
              					set(
              						current,
              						"name",
              						lv_name_1_0,
              						"io.typefox.yang.Yang.StringValue");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            if ( state.backtracking==0 ) {

              			if (current==null) {
              				current = createModelElement(grammarAccess.getActionRule());
              			}
              			newCompositeNode(grammarAccess.getActionAccess().getStatementEndParserRuleCall_2());
              		
            }
            pushFollow(FOLLOW_2);
            this_StatementEnd_2=ruleStatementEnd(current);

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current = this_StatementEnd_2;
              			afterParserOrEnumRuleCall();
              		
            }

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleAction"


    // $ANTLR start "entryRuleNotification"
    // InternalYangParser.g:3258:1: entryRuleNotification returns [EObject current=null] : iv_ruleNotification= ruleNotification EOF ;
    public final EObject entryRuleNotification() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNotification = null;


        try {
            // InternalYangParser.g:3258:53: (iv_ruleNotification= ruleNotification EOF )
            // InternalYangParser.g:3259:2: iv_ruleNotification= ruleNotification EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getNotificationRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleNotification=ruleNotification();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleNotification; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleNotification"


    // $ANTLR start "ruleNotification"
    // InternalYangParser.g:3265:1: ruleNotification returns [EObject current=null] : (otherlv_0= Notification ( (lv_name_1_0= ruleStringValue ) ) this_StatementEnd_2= ruleStatementEnd[$current] ) ;
    public final EObject ruleNotification() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        AntlrDatatypeRuleToken lv_name_1_0 = null;

        EObject this_StatementEnd_2 = null;



        	enterRule();

        try {
            // InternalYangParser.g:3271:2: ( (otherlv_0= Notification ( (lv_name_1_0= ruleStringValue ) ) this_StatementEnd_2= ruleStatementEnd[$current] ) )
            // InternalYangParser.g:3272:2: (otherlv_0= Notification ( (lv_name_1_0= ruleStringValue ) ) this_StatementEnd_2= ruleStatementEnd[$current] )
            {
            // InternalYangParser.g:3272:2: (otherlv_0= Notification ( (lv_name_1_0= ruleStringValue ) ) this_StatementEnd_2= ruleStatementEnd[$current] )
            // InternalYangParser.g:3273:3: otherlv_0= Notification ( (lv_name_1_0= ruleStringValue ) ) this_StatementEnd_2= ruleStatementEnd[$current]
            {
            otherlv_0=(Token)match(input,Notification,FOLLOW_4); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getNotificationAccess().getNotificationKeyword_0());
              		
            }
            // InternalYangParser.g:3277:3: ( (lv_name_1_0= ruleStringValue ) )
            // InternalYangParser.g:3278:4: (lv_name_1_0= ruleStringValue )
            {
            // InternalYangParser.g:3278:4: (lv_name_1_0= ruleStringValue )
            // InternalYangParser.g:3279:5: lv_name_1_0= ruleStringValue
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getNotificationAccess().getNameStringValueParserRuleCall_1_0());
              				
            }
            pushFollow(FOLLOW_5);
            lv_name_1_0=ruleStringValue();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getNotificationRule());
              					}
              					set(
              						current,
              						"name",
              						lv_name_1_0,
              						"io.typefox.yang.Yang.StringValue");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            if ( state.backtracking==0 ) {

              			if (current==null) {
              				current = createModelElement(grammarAccess.getNotificationRule());
              			}
              			newCompositeNode(grammarAccess.getNotificationAccess().getStatementEndParserRuleCall_2());
              		
            }
            pushFollow(FOLLOW_2);
            this_StatementEnd_2=ruleStatementEnd(current);

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current = this_StatementEnd_2;
              			afterParserOrEnumRuleCall();
              		
            }

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleNotification"


    // $ANTLR start "entryRuleAugment"
    // InternalYangParser.g:3311:1: entryRuleAugment returns [EObject current=null] : iv_ruleAugment= ruleAugment EOF ;
    public final EObject entryRuleAugment() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAugment = null;


        try {
            // InternalYangParser.g:3311:48: (iv_ruleAugment= ruleAugment EOF )
            // InternalYangParser.g:3312:2: iv_ruleAugment= ruleAugment EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getAugmentRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleAugment=ruleAugment();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleAugment; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleAugment"


    // $ANTLR start "ruleAugment"
    // InternalYangParser.g:3318:1: ruleAugment returns [EObject current=null] : (otherlv_0= Augment ( (lv_path_1_0= ruleSchemaNodeIdentifier ) ) this_StatementEnd_2= ruleStatementEnd[$current] ) ;
    public final EObject ruleAugment() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        EObject lv_path_1_0 = null;

        EObject this_StatementEnd_2 = null;



        	enterRule();

        try {
            // InternalYangParser.g:3324:2: ( (otherlv_0= Augment ( (lv_path_1_0= ruleSchemaNodeIdentifier ) ) this_StatementEnd_2= ruleStatementEnd[$current] ) )
            // InternalYangParser.g:3325:2: (otherlv_0= Augment ( (lv_path_1_0= ruleSchemaNodeIdentifier ) ) this_StatementEnd_2= ruleStatementEnd[$current] )
            {
            // InternalYangParser.g:3325:2: (otherlv_0= Augment ( (lv_path_1_0= ruleSchemaNodeIdentifier ) ) this_StatementEnd_2= ruleStatementEnd[$current] )
            // InternalYangParser.g:3326:3: otherlv_0= Augment ( (lv_path_1_0= ruleSchemaNodeIdentifier ) ) this_StatementEnd_2= ruleStatementEnd[$current]
            {
            otherlv_0=(Token)match(input,Augment,FOLLOW_10); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getAugmentAccess().getAugmentKeyword_0());
              		
            }
            // InternalYangParser.g:3330:3: ( (lv_path_1_0= ruleSchemaNodeIdentifier ) )
            // InternalYangParser.g:3331:4: (lv_path_1_0= ruleSchemaNodeIdentifier )
            {
            // InternalYangParser.g:3331:4: (lv_path_1_0= ruleSchemaNodeIdentifier )
            // InternalYangParser.g:3332:5: lv_path_1_0= ruleSchemaNodeIdentifier
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getAugmentAccess().getPathSchemaNodeIdentifierParserRuleCall_1_0());
              				
            }
            pushFollow(FOLLOW_5);
            lv_path_1_0=ruleSchemaNodeIdentifier();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getAugmentRule());
              					}
              					set(
              						current,
              						"path",
              						lv_path_1_0,
              						"io.typefox.yang.Yang.SchemaNodeIdentifier");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            if ( state.backtracking==0 ) {

              			if (current==null) {
              				current = createModelElement(grammarAccess.getAugmentRule());
              			}
              			newCompositeNode(grammarAccess.getAugmentAccess().getStatementEndParserRuleCall_2());
              		
            }
            pushFollow(FOLLOW_2);
            this_StatementEnd_2=ruleStatementEnd(current);

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current = this_StatementEnd_2;
              			afterParserOrEnumRuleCall();
              		
            }

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleAugment"


    // $ANTLR start "entryRuleIdentity"
    // InternalYangParser.g:3364:1: entryRuleIdentity returns [EObject current=null] : iv_ruleIdentity= ruleIdentity EOF ;
    public final EObject entryRuleIdentity() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleIdentity = null;


        try {
            // InternalYangParser.g:3364:49: (iv_ruleIdentity= ruleIdentity EOF )
            // InternalYangParser.g:3365:2: iv_ruleIdentity= ruleIdentity EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getIdentityRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleIdentity=ruleIdentity();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleIdentity; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleIdentity"


    // $ANTLR start "ruleIdentity"
    // InternalYangParser.g:3371:1: ruleIdentity returns [EObject current=null] : (otherlv_0= Identity ( (lv_name_1_0= ruleStringValue ) ) this_StatementEnd_2= ruleStatementEnd[$current] ) ;
    public final EObject ruleIdentity() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        AntlrDatatypeRuleToken lv_name_1_0 = null;

        EObject this_StatementEnd_2 = null;



        	enterRule();

        try {
            // InternalYangParser.g:3377:2: ( (otherlv_0= Identity ( (lv_name_1_0= ruleStringValue ) ) this_StatementEnd_2= ruleStatementEnd[$current] ) )
            // InternalYangParser.g:3378:2: (otherlv_0= Identity ( (lv_name_1_0= ruleStringValue ) ) this_StatementEnd_2= ruleStatementEnd[$current] )
            {
            // InternalYangParser.g:3378:2: (otherlv_0= Identity ( (lv_name_1_0= ruleStringValue ) ) this_StatementEnd_2= ruleStatementEnd[$current] )
            // InternalYangParser.g:3379:3: otherlv_0= Identity ( (lv_name_1_0= ruleStringValue ) ) this_StatementEnd_2= ruleStatementEnd[$current]
            {
            otherlv_0=(Token)match(input,Identity,FOLLOW_4); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getIdentityAccess().getIdentityKeyword_0());
              		
            }
            // InternalYangParser.g:3383:3: ( (lv_name_1_0= ruleStringValue ) )
            // InternalYangParser.g:3384:4: (lv_name_1_0= ruleStringValue )
            {
            // InternalYangParser.g:3384:4: (lv_name_1_0= ruleStringValue )
            // InternalYangParser.g:3385:5: lv_name_1_0= ruleStringValue
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getIdentityAccess().getNameStringValueParserRuleCall_1_0());
              				
            }
            pushFollow(FOLLOW_5);
            lv_name_1_0=ruleStringValue();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getIdentityRule());
              					}
              					set(
              						current,
              						"name",
              						lv_name_1_0,
              						"io.typefox.yang.Yang.StringValue");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            if ( state.backtracking==0 ) {

              			if (current==null) {
              				current = createModelElement(grammarAccess.getIdentityRule());
              			}
              			newCompositeNode(grammarAccess.getIdentityAccess().getStatementEndParserRuleCall_2());
              		
            }
            pushFollow(FOLLOW_2);
            this_StatementEnd_2=ruleStatementEnd(current);

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current = this_StatementEnd_2;
              			afterParserOrEnumRuleCall();
              		
            }

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleIdentity"


    // $ANTLR start "entryRuleBase"
    // InternalYangParser.g:3417:1: entryRuleBase returns [EObject current=null] : iv_ruleBase= ruleBase EOF ;
    public final EObject entryRuleBase() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBase = null;


        try {
            // InternalYangParser.g:3417:45: (iv_ruleBase= ruleBase EOF )
            // InternalYangParser.g:3418:2: iv_ruleBase= ruleBase EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getBaseRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleBase=ruleBase();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleBase; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleBase"


    // $ANTLR start "ruleBase"
    // InternalYangParser.g:3424:1: ruleBase returns [EObject current=null] : (otherlv_0= Base ( ( ruleQNAME ) ) this_StatementEnd_2= ruleStatementEnd[$current] ) ;
    public final EObject ruleBase() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        EObject this_StatementEnd_2 = null;



        	enterRule();

        try {
            // InternalYangParser.g:3430:2: ( (otherlv_0= Base ( ( ruleQNAME ) ) this_StatementEnd_2= ruleStatementEnd[$current] ) )
            // InternalYangParser.g:3431:2: (otherlv_0= Base ( ( ruleQNAME ) ) this_StatementEnd_2= ruleStatementEnd[$current] )
            {
            // InternalYangParser.g:3431:2: (otherlv_0= Base ( ( ruleQNAME ) ) this_StatementEnd_2= ruleStatementEnd[$current] )
            // InternalYangParser.g:3432:3: otherlv_0= Base ( ( ruleQNAME ) ) this_StatementEnd_2= ruleStatementEnd[$current]
            {
            otherlv_0=(Token)match(input,Base,FOLLOW_6); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getBaseAccess().getBaseKeyword_0());
              		
            }
            // InternalYangParser.g:3436:3: ( ( ruleQNAME ) )
            // InternalYangParser.g:3437:4: ( ruleQNAME )
            {
            // InternalYangParser.g:3437:4: ( ruleQNAME )
            // InternalYangParser.g:3438:5: ruleQNAME
            {
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElement(grammarAccess.getBaseRule());
              					}
              				
            }
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getBaseAccess().getReferenceIdentityCrossReference_1_0());
              				
            }
            pushFollow(FOLLOW_5);
            ruleQNAME();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            if ( state.backtracking==0 ) {

              			if (current==null) {
              				current = createModelElement(grammarAccess.getBaseRule());
              			}
              			newCompositeNode(grammarAccess.getBaseAccess().getStatementEndParserRuleCall_2());
              		
            }
            pushFollow(FOLLOW_2);
            this_StatementEnd_2=ruleStatementEnd(current);

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current = this_StatementEnd_2;
              			afterParserOrEnumRuleCall();
              		
            }

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleBase"


    // $ANTLR start "entryRuleExtension"
    // InternalYangParser.g:3467:1: entryRuleExtension returns [EObject current=null] : iv_ruleExtension= ruleExtension EOF ;
    public final EObject entryRuleExtension() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExtension = null;


        try {
            // InternalYangParser.g:3467:50: (iv_ruleExtension= ruleExtension EOF )
            // InternalYangParser.g:3468:2: iv_ruleExtension= ruleExtension EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getExtensionRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleExtension=ruleExtension();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleExtension; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleExtension"


    // $ANTLR start "ruleExtension"
    // InternalYangParser.g:3474:1: ruleExtension returns [EObject current=null] : (otherlv_0= Extension ( (lv_name_1_0= ruleStringValue ) ) this_StatementEnd_2= ruleStatementEnd[$current] ) ;
    public final EObject ruleExtension() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        AntlrDatatypeRuleToken lv_name_1_0 = null;

        EObject this_StatementEnd_2 = null;



        	enterRule();

        try {
            // InternalYangParser.g:3480:2: ( (otherlv_0= Extension ( (lv_name_1_0= ruleStringValue ) ) this_StatementEnd_2= ruleStatementEnd[$current] ) )
            // InternalYangParser.g:3481:2: (otherlv_0= Extension ( (lv_name_1_0= ruleStringValue ) ) this_StatementEnd_2= ruleStatementEnd[$current] )
            {
            // InternalYangParser.g:3481:2: (otherlv_0= Extension ( (lv_name_1_0= ruleStringValue ) ) this_StatementEnd_2= ruleStatementEnd[$current] )
            // InternalYangParser.g:3482:3: otherlv_0= Extension ( (lv_name_1_0= ruleStringValue ) ) this_StatementEnd_2= ruleStatementEnd[$current]
            {
            otherlv_0=(Token)match(input,Extension,FOLLOW_4); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getExtensionAccess().getExtensionKeyword_0());
              		
            }
            // InternalYangParser.g:3486:3: ( (lv_name_1_0= ruleStringValue ) )
            // InternalYangParser.g:3487:4: (lv_name_1_0= ruleStringValue )
            {
            // InternalYangParser.g:3487:4: (lv_name_1_0= ruleStringValue )
            // InternalYangParser.g:3488:5: lv_name_1_0= ruleStringValue
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getExtensionAccess().getNameStringValueParserRuleCall_1_0());
              				
            }
            pushFollow(FOLLOW_5);
            lv_name_1_0=ruleStringValue();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getExtensionRule());
              					}
              					set(
              						current,
              						"name",
              						lv_name_1_0,
              						"io.typefox.yang.Yang.StringValue");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            if ( state.backtracking==0 ) {

              			if (current==null) {
              				current = createModelElement(grammarAccess.getExtensionRule());
              			}
              			newCompositeNode(grammarAccess.getExtensionAccess().getStatementEndParserRuleCall_2());
              		
            }
            pushFollow(FOLLOW_2);
            this_StatementEnd_2=ruleStatementEnd(current);

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current = this_StatementEnd_2;
              			afterParserOrEnumRuleCall();
              		
            }

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleExtension"


    // $ANTLR start "entryRuleArgument"
    // InternalYangParser.g:3520:1: entryRuleArgument returns [EObject current=null] : iv_ruleArgument= ruleArgument EOF ;
    public final EObject entryRuleArgument() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleArgument = null;


        try {
            // InternalYangParser.g:3520:49: (iv_ruleArgument= ruleArgument EOF )
            // InternalYangParser.g:3521:2: iv_ruleArgument= ruleArgument EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getArgumentRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleArgument=ruleArgument();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleArgument; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleArgument"


    // $ANTLR start "ruleArgument"
    // InternalYangParser.g:3527:1: ruleArgument returns [EObject current=null] : (otherlv_0= Argument ( (lv_name_1_0= ruleStringValue ) ) this_StatementEnd_2= ruleStatementEnd[$current] ) ;
    public final EObject ruleArgument() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        AntlrDatatypeRuleToken lv_name_1_0 = null;

        EObject this_StatementEnd_2 = null;



        	enterRule();

        try {
            // InternalYangParser.g:3533:2: ( (otherlv_0= Argument ( (lv_name_1_0= ruleStringValue ) ) this_StatementEnd_2= ruleStatementEnd[$current] ) )
            // InternalYangParser.g:3534:2: (otherlv_0= Argument ( (lv_name_1_0= ruleStringValue ) ) this_StatementEnd_2= ruleStatementEnd[$current] )
            {
            // InternalYangParser.g:3534:2: (otherlv_0= Argument ( (lv_name_1_0= ruleStringValue ) ) this_StatementEnd_2= ruleStatementEnd[$current] )
            // InternalYangParser.g:3535:3: otherlv_0= Argument ( (lv_name_1_0= ruleStringValue ) ) this_StatementEnd_2= ruleStatementEnd[$current]
            {
            otherlv_0=(Token)match(input,Argument,FOLLOW_4); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getArgumentAccess().getArgumentKeyword_0());
              		
            }
            // InternalYangParser.g:3539:3: ( (lv_name_1_0= ruleStringValue ) )
            // InternalYangParser.g:3540:4: (lv_name_1_0= ruleStringValue )
            {
            // InternalYangParser.g:3540:4: (lv_name_1_0= ruleStringValue )
            // InternalYangParser.g:3541:5: lv_name_1_0= ruleStringValue
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getArgumentAccess().getNameStringValueParserRuleCall_1_0());
              				
            }
            pushFollow(FOLLOW_5);
            lv_name_1_0=ruleStringValue();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getArgumentRule());
              					}
              					set(
              						current,
              						"name",
              						lv_name_1_0,
              						"io.typefox.yang.Yang.StringValue");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            if ( state.backtracking==0 ) {

              			if (current==null) {
              				current = createModelElement(grammarAccess.getArgumentRule());
              			}
              			newCompositeNode(grammarAccess.getArgumentAccess().getStatementEndParserRuleCall_2());
              		
            }
            pushFollow(FOLLOW_2);
            this_StatementEnd_2=ruleStatementEnd(current);

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current = this_StatementEnd_2;
              			afterParserOrEnumRuleCall();
              		
            }

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleArgument"


    // $ANTLR start "entryRuleYinElement"
    // InternalYangParser.g:3573:1: entryRuleYinElement returns [EObject current=null] : iv_ruleYinElement= ruleYinElement EOF ;
    public final EObject entryRuleYinElement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleYinElement = null;


        try {
            // InternalYangParser.g:3573:51: (iv_ruleYinElement= ruleYinElement EOF )
            // InternalYangParser.g:3574:2: iv_ruleYinElement= ruleYinElement EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getYinElementRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleYinElement=ruleYinElement();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleYinElement; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleYinElement"


    // $ANTLR start "ruleYinElement"
    // InternalYangParser.g:3580:1: ruleYinElement returns [EObject current=null] : (otherlv_0= YinElement ( (lv_isYinElement_1_0= ruleStringValue ) ) this_StatementEnd_2= ruleStatementEnd[$current] ) ;
    public final EObject ruleYinElement() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        AntlrDatatypeRuleToken lv_isYinElement_1_0 = null;

        EObject this_StatementEnd_2 = null;



        	enterRule();

        try {
            // InternalYangParser.g:3586:2: ( (otherlv_0= YinElement ( (lv_isYinElement_1_0= ruleStringValue ) ) this_StatementEnd_2= ruleStatementEnd[$current] ) )
            // InternalYangParser.g:3587:2: (otherlv_0= YinElement ( (lv_isYinElement_1_0= ruleStringValue ) ) this_StatementEnd_2= ruleStatementEnd[$current] )
            {
            // InternalYangParser.g:3587:2: (otherlv_0= YinElement ( (lv_isYinElement_1_0= ruleStringValue ) ) this_StatementEnd_2= ruleStatementEnd[$current] )
            // InternalYangParser.g:3588:3: otherlv_0= YinElement ( (lv_isYinElement_1_0= ruleStringValue ) ) this_StatementEnd_2= ruleStatementEnd[$current]
            {
            otherlv_0=(Token)match(input,YinElement,FOLLOW_4); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getYinElementAccess().getYinElementKeyword_0());
              		
            }
            // InternalYangParser.g:3592:3: ( (lv_isYinElement_1_0= ruleStringValue ) )
            // InternalYangParser.g:3593:4: (lv_isYinElement_1_0= ruleStringValue )
            {
            // InternalYangParser.g:3593:4: (lv_isYinElement_1_0= ruleStringValue )
            // InternalYangParser.g:3594:5: lv_isYinElement_1_0= ruleStringValue
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getYinElementAccess().getIsYinElementStringValueParserRuleCall_1_0());
              				
            }
            pushFollow(FOLLOW_5);
            lv_isYinElement_1_0=ruleStringValue();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getYinElementRule());
              					}
              					set(
              						current,
              						"isYinElement",
              						lv_isYinElement_1_0,
              						"io.typefox.yang.Yang.StringValue");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            if ( state.backtracking==0 ) {

              			if (current==null) {
              				current = createModelElement(grammarAccess.getYinElementRule());
              			}
              			newCompositeNode(grammarAccess.getYinElementAccess().getStatementEndParserRuleCall_2());
              		
            }
            pushFollow(FOLLOW_2);
            this_StatementEnd_2=ruleStatementEnd(current);

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current = this_StatementEnd_2;
              			afterParserOrEnumRuleCall();
              		
            }

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleYinElement"


    // $ANTLR start "entryRuleFeature"
    // InternalYangParser.g:3626:1: entryRuleFeature returns [EObject current=null] : iv_ruleFeature= ruleFeature EOF ;
    public final EObject entryRuleFeature() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFeature = null;


        try {
            // InternalYangParser.g:3626:48: (iv_ruleFeature= ruleFeature EOF )
            // InternalYangParser.g:3627:2: iv_ruleFeature= ruleFeature EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getFeatureRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleFeature=ruleFeature();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleFeature; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleFeature"


    // $ANTLR start "ruleFeature"
    // InternalYangParser.g:3633:1: ruleFeature returns [EObject current=null] : (otherlv_0= Feature ( (lv_name_1_0= ruleStringValue ) ) this_StatementEnd_2= ruleStatementEnd[$current] ) ;
    public final EObject ruleFeature() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        AntlrDatatypeRuleToken lv_name_1_0 = null;

        EObject this_StatementEnd_2 = null;



        	enterRule();

        try {
            // InternalYangParser.g:3639:2: ( (otherlv_0= Feature ( (lv_name_1_0= ruleStringValue ) ) this_StatementEnd_2= ruleStatementEnd[$current] ) )
            // InternalYangParser.g:3640:2: (otherlv_0= Feature ( (lv_name_1_0= ruleStringValue ) ) this_StatementEnd_2= ruleStatementEnd[$current] )
            {
            // InternalYangParser.g:3640:2: (otherlv_0= Feature ( (lv_name_1_0= ruleStringValue ) ) this_StatementEnd_2= ruleStatementEnd[$current] )
            // InternalYangParser.g:3641:3: otherlv_0= Feature ( (lv_name_1_0= ruleStringValue ) ) this_StatementEnd_2= ruleStatementEnd[$current]
            {
            otherlv_0=(Token)match(input,Feature,FOLLOW_4); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getFeatureAccess().getFeatureKeyword_0());
              		
            }
            // InternalYangParser.g:3645:3: ( (lv_name_1_0= ruleStringValue ) )
            // InternalYangParser.g:3646:4: (lv_name_1_0= ruleStringValue )
            {
            // InternalYangParser.g:3646:4: (lv_name_1_0= ruleStringValue )
            // InternalYangParser.g:3647:5: lv_name_1_0= ruleStringValue
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getFeatureAccess().getNameStringValueParserRuleCall_1_0());
              				
            }
            pushFollow(FOLLOW_5);
            lv_name_1_0=ruleStringValue();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getFeatureRule());
              					}
              					set(
              						current,
              						"name",
              						lv_name_1_0,
              						"io.typefox.yang.Yang.StringValue");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            if ( state.backtracking==0 ) {

              			if (current==null) {
              				current = createModelElement(grammarAccess.getFeatureRule());
              			}
              			newCompositeNode(grammarAccess.getFeatureAccess().getStatementEndParserRuleCall_2());
              		
            }
            pushFollow(FOLLOW_2);
            this_StatementEnd_2=ruleStatementEnd(current);

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current = this_StatementEnd_2;
              			afterParserOrEnumRuleCall();
              		
            }

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleFeature"


    // $ANTLR start "entryRuleIfFeature"
    // InternalYangParser.g:3679:1: entryRuleIfFeature returns [EObject current=null] : iv_ruleIfFeature= ruleIfFeature EOF ;
    public final EObject entryRuleIfFeature() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleIfFeature = null;


        try {
            // InternalYangParser.g:3679:50: (iv_ruleIfFeature= ruleIfFeature EOF )
            // InternalYangParser.g:3680:2: iv_ruleIfFeature= ruleIfFeature EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getIfFeatureRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleIfFeature=ruleIfFeature();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleIfFeature; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleIfFeature"


    // $ANTLR start "ruleIfFeature"
    // InternalYangParser.g:3686:1: ruleIfFeature returns [EObject current=null] : (otherlv_0= IfFeature ( (lv_condition_1_0= ruleIfFeatureOrExpression ) ) this_StatementEnd_2= ruleStatementEnd[$current] ) ;
    public final EObject ruleIfFeature() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        EObject lv_condition_1_0 = null;

        EObject this_StatementEnd_2 = null;



        	enterRule();

        try {
            // InternalYangParser.g:3692:2: ( (otherlv_0= IfFeature ( (lv_condition_1_0= ruleIfFeatureOrExpression ) ) this_StatementEnd_2= ruleStatementEnd[$current] ) )
            // InternalYangParser.g:3693:2: (otherlv_0= IfFeature ( (lv_condition_1_0= ruleIfFeatureOrExpression ) ) this_StatementEnd_2= ruleStatementEnd[$current] )
            {
            // InternalYangParser.g:3693:2: (otherlv_0= IfFeature ( (lv_condition_1_0= ruleIfFeatureOrExpression ) ) this_StatementEnd_2= ruleStatementEnd[$current] )
            // InternalYangParser.g:3694:3: otherlv_0= IfFeature ( (lv_condition_1_0= ruleIfFeatureOrExpression ) ) this_StatementEnd_2= ruleStatementEnd[$current]
            {
            otherlv_0=(Token)match(input,IfFeature,FOLLOW_12); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getIfFeatureAccess().getIfFeatureKeyword_0());
              		
            }
            // InternalYangParser.g:3698:3: ( (lv_condition_1_0= ruleIfFeatureOrExpression ) )
            // InternalYangParser.g:3699:4: (lv_condition_1_0= ruleIfFeatureOrExpression )
            {
            // InternalYangParser.g:3699:4: (lv_condition_1_0= ruleIfFeatureOrExpression )
            // InternalYangParser.g:3700:5: lv_condition_1_0= ruleIfFeatureOrExpression
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getIfFeatureAccess().getConditionIfFeatureOrExpressionParserRuleCall_1_0());
              				
            }
            pushFollow(FOLLOW_5);
            lv_condition_1_0=ruleIfFeatureOrExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getIfFeatureRule());
              					}
              					set(
              						current,
              						"condition",
              						lv_condition_1_0,
              						"io.typefox.yang.Yang.IfFeatureOrExpression");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            if ( state.backtracking==0 ) {

              			if (current==null) {
              				current = createModelElement(grammarAccess.getIfFeatureRule());
              			}
              			newCompositeNode(grammarAccess.getIfFeatureAccess().getStatementEndParserRuleCall_2());
              		
            }
            pushFollow(FOLLOW_2);
            this_StatementEnd_2=ruleStatementEnd(current);

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current = this_StatementEnd_2;
              			afterParserOrEnumRuleCall();
              		
            }

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleIfFeature"


    // $ANTLR start "entryRuleIfFeatureOrExpression"
    // InternalYangParser.g:3732:1: entryRuleIfFeatureOrExpression returns [EObject current=null] : iv_ruleIfFeatureOrExpression= ruleIfFeatureOrExpression EOF ;
    public final EObject entryRuleIfFeatureOrExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleIfFeatureOrExpression = null;


        try {
            // InternalYangParser.g:3732:62: (iv_ruleIfFeatureOrExpression= ruleIfFeatureOrExpression EOF )
            // InternalYangParser.g:3733:2: iv_ruleIfFeatureOrExpression= ruleIfFeatureOrExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getIfFeatureOrExpressionRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleIfFeatureOrExpression=ruleIfFeatureOrExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleIfFeatureOrExpression; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleIfFeatureOrExpression"


    // $ANTLR start "ruleIfFeatureOrExpression"
    // InternalYangParser.g:3739:1: ruleIfFeatureOrExpression returns [EObject current=null] : (this_IfFeatureAndExpression_0= ruleIfFeatureAndExpression ( () ( (lv_operator_2_0= Or ) ) ( (lv_right_3_0= ruleIfFeatureAndExpression ) ) )* ) ;
    public final EObject ruleIfFeatureOrExpression() throws RecognitionException {
        EObject current = null;

        Token lv_operator_2_0=null;
        EObject this_IfFeatureAndExpression_0 = null;

        EObject lv_right_3_0 = null;



        	enterRule();

        try {
            // InternalYangParser.g:3745:2: ( (this_IfFeatureAndExpression_0= ruleIfFeatureAndExpression ( () ( (lv_operator_2_0= Or ) ) ( (lv_right_3_0= ruleIfFeatureAndExpression ) ) )* ) )
            // InternalYangParser.g:3746:2: (this_IfFeatureAndExpression_0= ruleIfFeatureAndExpression ( () ( (lv_operator_2_0= Or ) ) ( (lv_right_3_0= ruleIfFeatureAndExpression ) ) )* )
            {
            // InternalYangParser.g:3746:2: (this_IfFeatureAndExpression_0= ruleIfFeatureAndExpression ( () ( (lv_operator_2_0= Or ) ) ( (lv_right_3_0= ruleIfFeatureAndExpression ) ) )* )
            // InternalYangParser.g:3747:3: this_IfFeatureAndExpression_0= ruleIfFeatureAndExpression ( () ( (lv_operator_2_0= Or ) ) ( (lv_right_3_0= ruleIfFeatureAndExpression ) ) )*
            {
            if ( state.backtracking==0 ) {

              			newCompositeNode(grammarAccess.getIfFeatureOrExpressionAccess().getIfFeatureAndExpressionParserRuleCall_0());
              		
            }
            pushFollow(FOLLOW_13);
            this_IfFeatureAndExpression_0=ruleIfFeatureAndExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current = this_IfFeatureAndExpression_0;
              			afterParserOrEnumRuleCall();
              		
            }
            // InternalYangParser.g:3755:3: ( () ( (lv_operator_2_0= Or ) ) ( (lv_right_3_0= ruleIfFeatureAndExpression ) ) )*
            loop17:
            do {
                int alt17=2;
                int LA17_0 = input.LA(1);

                if ( (LA17_0==Or) ) {
                    alt17=1;
                }


                switch (alt17) {
            	case 1 :
            	    // InternalYangParser.g:3756:4: () ( (lv_operator_2_0= Or ) ) ( (lv_right_3_0= ruleIfFeatureAndExpression ) )
            	    {
            	    // InternalYangParser.g:3756:4: ()
            	    // InternalYangParser.g:3757:5: 
            	    {
            	    if ( state.backtracking==0 ) {

            	      					current = forceCreateModelElementAndSet(
            	      						grammarAccess.getIfFeatureOrExpressionAccess().getBinaryOperatorLeftAction_1_0(),
            	      						current);
            	      				
            	    }

            	    }

            	    // InternalYangParser.g:3763:4: ( (lv_operator_2_0= Or ) )
            	    // InternalYangParser.g:3764:5: (lv_operator_2_0= Or )
            	    {
            	    // InternalYangParser.g:3764:5: (lv_operator_2_0= Or )
            	    // InternalYangParser.g:3765:6: lv_operator_2_0= Or
            	    {
            	    lv_operator_2_0=(Token)match(input,Or,FOLLOW_12); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      						newLeafNode(lv_operator_2_0, grammarAccess.getIfFeatureOrExpressionAccess().getOperatorOrKeyword_1_1_0());
            	      					
            	    }
            	    if ( state.backtracking==0 ) {

            	      						if (current==null) {
            	      							current = createModelElement(grammarAccess.getIfFeatureOrExpressionRule());
            	      						}
            	      						setWithLastConsumed(current, "operator", lv_operator_2_0, "or");
            	      					
            	    }

            	    }


            	    }

            	    // InternalYangParser.g:3777:4: ( (lv_right_3_0= ruleIfFeatureAndExpression ) )
            	    // InternalYangParser.g:3778:5: (lv_right_3_0= ruleIfFeatureAndExpression )
            	    {
            	    // InternalYangParser.g:3778:5: (lv_right_3_0= ruleIfFeatureAndExpression )
            	    // InternalYangParser.g:3779:6: lv_right_3_0= ruleIfFeatureAndExpression
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getIfFeatureOrExpressionAccess().getRightIfFeatureAndExpressionParserRuleCall_1_2_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_13);
            	    lv_right_3_0=ruleIfFeatureAndExpression();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      						if (current==null) {
            	      							current = createModelElementForParent(grammarAccess.getIfFeatureOrExpressionRule());
            	      						}
            	      						set(
            	      							current,
            	      							"right",
            	      							lv_right_3_0,
            	      							"io.typefox.yang.Yang.IfFeatureAndExpression");
            	      						afterParserOrEnumRuleCall();
            	      					
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop17;
                }
            } while (true);


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleIfFeatureOrExpression"


    // $ANTLR start "entryRuleIfFeatureAndExpression"
    // InternalYangParser.g:3801:1: entryRuleIfFeatureAndExpression returns [EObject current=null] : iv_ruleIfFeatureAndExpression= ruleIfFeatureAndExpression EOF ;
    public final EObject entryRuleIfFeatureAndExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleIfFeatureAndExpression = null;


        try {
            // InternalYangParser.g:3801:63: (iv_ruleIfFeatureAndExpression= ruleIfFeatureAndExpression EOF )
            // InternalYangParser.g:3802:2: iv_ruleIfFeatureAndExpression= ruleIfFeatureAndExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getIfFeatureAndExpressionRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleIfFeatureAndExpression=ruleIfFeatureAndExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleIfFeatureAndExpression; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleIfFeatureAndExpression"


    // $ANTLR start "ruleIfFeatureAndExpression"
    // InternalYangParser.g:3808:1: ruleIfFeatureAndExpression returns [EObject current=null] : (this_IfFeatureExpression_0= ruleIfFeatureExpression ( () ( (lv_operator_2_0= And ) ) ( (lv_right_3_0= ruleIfFeatureExpression ) ) )* ) ;
    public final EObject ruleIfFeatureAndExpression() throws RecognitionException {
        EObject current = null;

        Token lv_operator_2_0=null;
        EObject this_IfFeatureExpression_0 = null;

        EObject lv_right_3_0 = null;



        	enterRule();

        try {
            // InternalYangParser.g:3814:2: ( (this_IfFeatureExpression_0= ruleIfFeatureExpression ( () ( (lv_operator_2_0= And ) ) ( (lv_right_3_0= ruleIfFeatureExpression ) ) )* ) )
            // InternalYangParser.g:3815:2: (this_IfFeatureExpression_0= ruleIfFeatureExpression ( () ( (lv_operator_2_0= And ) ) ( (lv_right_3_0= ruleIfFeatureExpression ) ) )* )
            {
            // InternalYangParser.g:3815:2: (this_IfFeatureExpression_0= ruleIfFeatureExpression ( () ( (lv_operator_2_0= And ) ) ( (lv_right_3_0= ruleIfFeatureExpression ) ) )* )
            // InternalYangParser.g:3816:3: this_IfFeatureExpression_0= ruleIfFeatureExpression ( () ( (lv_operator_2_0= And ) ) ( (lv_right_3_0= ruleIfFeatureExpression ) ) )*
            {
            if ( state.backtracking==0 ) {

              			newCompositeNode(grammarAccess.getIfFeatureAndExpressionAccess().getIfFeatureExpressionParserRuleCall_0());
              		
            }
            pushFollow(FOLLOW_14);
            this_IfFeatureExpression_0=ruleIfFeatureExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current = this_IfFeatureExpression_0;
              			afterParserOrEnumRuleCall();
              		
            }
            // InternalYangParser.g:3824:3: ( () ( (lv_operator_2_0= And ) ) ( (lv_right_3_0= ruleIfFeatureExpression ) ) )*
            loop18:
            do {
                int alt18=2;
                int LA18_0 = input.LA(1);

                if ( (LA18_0==And) ) {
                    alt18=1;
                }


                switch (alt18) {
            	case 1 :
            	    // InternalYangParser.g:3825:4: () ( (lv_operator_2_0= And ) ) ( (lv_right_3_0= ruleIfFeatureExpression ) )
            	    {
            	    // InternalYangParser.g:3825:4: ()
            	    // InternalYangParser.g:3826:5: 
            	    {
            	    if ( state.backtracking==0 ) {

            	      					current = forceCreateModelElementAndSet(
            	      						grammarAccess.getIfFeatureAndExpressionAccess().getBinaryOperatorLeftAction_1_0(),
            	      						current);
            	      				
            	    }

            	    }

            	    // InternalYangParser.g:3832:4: ( (lv_operator_2_0= And ) )
            	    // InternalYangParser.g:3833:5: (lv_operator_2_0= And )
            	    {
            	    // InternalYangParser.g:3833:5: (lv_operator_2_0= And )
            	    // InternalYangParser.g:3834:6: lv_operator_2_0= And
            	    {
            	    lv_operator_2_0=(Token)match(input,And,FOLLOW_12); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      						newLeafNode(lv_operator_2_0, grammarAccess.getIfFeatureAndExpressionAccess().getOperatorAndKeyword_1_1_0());
            	      					
            	    }
            	    if ( state.backtracking==0 ) {

            	      						if (current==null) {
            	      							current = createModelElement(grammarAccess.getIfFeatureAndExpressionRule());
            	      						}
            	      						setWithLastConsumed(current, "operator", lv_operator_2_0, "and");
            	      					
            	    }

            	    }


            	    }

            	    // InternalYangParser.g:3846:4: ( (lv_right_3_0= ruleIfFeatureExpression ) )
            	    // InternalYangParser.g:3847:5: (lv_right_3_0= ruleIfFeatureExpression )
            	    {
            	    // InternalYangParser.g:3847:5: (lv_right_3_0= ruleIfFeatureExpression )
            	    // InternalYangParser.g:3848:6: lv_right_3_0= ruleIfFeatureExpression
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getIfFeatureAndExpressionAccess().getRightIfFeatureExpressionParserRuleCall_1_2_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_14);
            	    lv_right_3_0=ruleIfFeatureExpression();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      						if (current==null) {
            	      							current = createModelElementForParent(grammarAccess.getIfFeatureAndExpressionRule());
            	      						}
            	      						set(
            	      							current,
            	      							"right",
            	      							lv_right_3_0,
            	      							"io.typefox.yang.Yang.IfFeatureExpression");
            	      						afterParserOrEnumRuleCall();
            	      					
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop18;
                }
            } while (true);


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleIfFeatureAndExpression"


    // $ANTLR start "entryRuleIfFeatureExpression"
    // InternalYangParser.g:3870:1: entryRuleIfFeatureExpression returns [EObject current=null] : iv_ruleIfFeatureExpression= ruleIfFeatureExpression EOF ;
    public final EObject entryRuleIfFeatureExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleIfFeatureExpression = null;


        try {
            // InternalYangParser.g:3870:60: (iv_ruleIfFeatureExpression= ruleIfFeatureExpression EOF )
            // InternalYangParser.g:3871:2: iv_ruleIfFeatureExpression= ruleIfFeatureExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getIfFeatureExpressionRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleIfFeatureExpression=ruleIfFeatureExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleIfFeatureExpression; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleIfFeatureExpression"


    // $ANTLR start "ruleIfFeatureExpression"
    // InternalYangParser.g:3877:1: ruleIfFeatureExpression returns [EObject current=null] : ( ( () ( ( ruleQNAME ) ) ) | ( () ( (lv_operator_3_0= Not ) ) ( (lv_target_4_0= ruleIfFeatureExpression ) ) ) | (otherlv_5= LeftParenthesis this_IfFeatureOrExpression_6= ruleIfFeatureOrExpression otherlv_7= RightParenthesis ) ) ;
    public final EObject ruleIfFeatureExpression() throws RecognitionException {
        EObject current = null;

        Token lv_operator_3_0=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        EObject lv_target_4_0 = null;

        EObject this_IfFeatureOrExpression_6 = null;



        	enterRule();

        try {
            // InternalYangParser.g:3883:2: ( ( ( () ( ( ruleQNAME ) ) ) | ( () ( (lv_operator_3_0= Not ) ) ( (lv_target_4_0= ruleIfFeatureExpression ) ) ) | (otherlv_5= LeftParenthesis this_IfFeatureOrExpression_6= ruleIfFeatureOrExpression otherlv_7= RightParenthesis ) ) )
            // InternalYangParser.g:3884:2: ( ( () ( ( ruleQNAME ) ) ) | ( () ( (lv_operator_3_0= Not ) ) ( (lv_target_4_0= ruleIfFeatureExpression ) ) ) | (otherlv_5= LeftParenthesis this_IfFeatureOrExpression_6= ruleIfFeatureOrExpression otherlv_7= RightParenthesis ) )
            {
            // InternalYangParser.g:3884:2: ( ( () ( ( ruleQNAME ) ) ) | ( () ( (lv_operator_3_0= Not ) ) ( (lv_target_4_0= ruleIfFeatureExpression ) ) ) | (otherlv_5= LeftParenthesis this_IfFeatureOrExpression_6= ruleIfFeatureOrExpression otherlv_7= RightParenthesis ) )
            int alt19=3;
            switch ( input.LA(1) ) {
            case InstanceIdentifier:
            case RequireInstance:
            case FractionDigits:
            case ErrorAppTag:
            case ErrorMessage:
            case NotSupported:
            case RevisionDate:
            case MaxElements:
            case MinElements:
            case Notification:
            case Organization:
            case YangVersion:
            case Description:
            case Enumeration:
            case Identityref:
            case YinElement:
            case BelongsTo:
            case Deprecated:
            case IfFeature:
            case OrderedBy:
            case Container:
            case Decimal64:
            case Deviation:
            case Extension:
            case LeafList:
            case Mandatory:
            case Namespace:
            case Reference:
            case Submodule:
            case Unbounded:
            case Argument:
            case Grouping:
            case Identity:
            case Modifier:
            case Obsolete:
            case Position:
            case Presence:
            case Revision:
            case Anydata:
            case Augment:
            case Boolean:
            case Contact:
            case Current:
            case Default:
            case Deviate:
            case Feature:
            case Include:
            case Leafref:
            case Pattern:
            case Replace:
            case Typedef:
            case Action:
            case Anyxml:
            case Binary:
            case Choice:
            case Config:
            case Delete:
            case Import:
            case Length:
            case Module:
            case Output:
            case Prefix:
            case Refine:
            case Status:
            case String:
            case KW_System:
            case Uint16:
            case Uint32:
            case Uint64:
            case Unique:
            case Empty:
            case False:
            case Input:
            case Int16:
            case Int32:
            case Int64:
            case Range:
            case Uint8:
            case Union:
            case Units:
            case Value:
            case Base:
            case Bits:
            case Case:
            case Enum:
            case Int8:
            case Leaf:
            case List:
            case Must:
            case Path:
            case True:
            case Type:
            case User:
            case Uses:
            case When:
            case Add:
            case Bit:
            case Key:
            case Max:
            case Min:
            case Rpc:
            case RULE_ID:
                {
                alt19=1;
                }
                break;
            case Not:
                {
                alt19=2;
                }
                break;
            case LeftParenthesis:
                {
                alt19=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 19, 0, input);

                throw nvae;
            }

            switch (alt19) {
                case 1 :
                    // InternalYangParser.g:3885:3: ( () ( ( ruleQNAME ) ) )
                    {
                    // InternalYangParser.g:3885:3: ( () ( ( ruleQNAME ) ) )
                    // InternalYangParser.g:3886:4: () ( ( ruleQNAME ) )
                    {
                    // InternalYangParser.g:3886:4: ()
                    // InternalYangParser.g:3887:5: 
                    {
                    if ( state.backtracking==0 ) {

                      					current = forceCreateModelElement(
                      						grammarAccess.getIfFeatureExpressionAccess().getFeatureReferenceAction_0_0(),
                      						current);
                      				
                    }

                    }

                    // InternalYangParser.g:3893:4: ( ( ruleQNAME ) )
                    // InternalYangParser.g:3894:5: ( ruleQNAME )
                    {
                    // InternalYangParser.g:3894:5: ( ruleQNAME )
                    // InternalYangParser.g:3895:6: ruleQNAME
                    {
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElement(grammarAccess.getIfFeatureExpressionRule());
                      						}
                      					
                    }
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getIfFeatureExpressionAccess().getFeatureFeatureCrossReference_0_1_0());
                      					
                    }
                    pushFollow(FOLLOW_2);
                    ruleQNAME();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalYangParser.g:3911:3: ( () ( (lv_operator_3_0= Not ) ) ( (lv_target_4_0= ruleIfFeatureExpression ) ) )
                    {
                    // InternalYangParser.g:3911:3: ( () ( (lv_operator_3_0= Not ) ) ( (lv_target_4_0= ruleIfFeatureExpression ) ) )
                    // InternalYangParser.g:3912:4: () ( (lv_operator_3_0= Not ) ) ( (lv_target_4_0= ruleIfFeatureExpression ) )
                    {
                    // InternalYangParser.g:3912:4: ()
                    // InternalYangParser.g:3913:5: 
                    {
                    if ( state.backtracking==0 ) {

                      					current = forceCreateModelElement(
                      						grammarAccess.getIfFeatureExpressionAccess().getUnaryOperationAction_1_0(),
                      						current);
                      				
                    }

                    }

                    // InternalYangParser.g:3919:4: ( (lv_operator_3_0= Not ) )
                    // InternalYangParser.g:3920:5: (lv_operator_3_0= Not )
                    {
                    // InternalYangParser.g:3920:5: (lv_operator_3_0= Not )
                    // InternalYangParser.g:3921:6: lv_operator_3_0= Not
                    {
                    lv_operator_3_0=(Token)match(input,Not,FOLLOW_12); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						newLeafNode(lv_operator_3_0, grammarAccess.getIfFeatureExpressionAccess().getOperatorNotKeyword_1_1_0());
                      					
                    }
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElement(grammarAccess.getIfFeatureExpressionRule());
                      						}
                      						setWithLastConsumed(current, "operator", lv_operator_3_0, "not");
                      					
                    }

                    }


                    }

                    // InternalYangParser.g:3933:4: ( (lv_target_4_0= ruleIfFeatureExpression ) )
                    // InternalYangParser.g:3934:5: (lv_target_4_0= ruleIfFeatureExpression )
                    {
                    // InternalYangParser.g:3934:5: (lv_target_4_0= ruleIfFeatureExpression )
                    // InternalYangParser.g:3935:6: lv_target_4_0= ruleIfFeatureExpression
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getIfFeatureExpressionAccess().getTargetIfFeatureExpressionParserRuleCall_1_2_0());
                      					
                    }
                    pushFollow(FOLLOW_2);
                    lv_target_4_0=ruleIfFeatureExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getIfFeatureExpressionRule());
                      						}
                      						set(
                      							current,
                      							"target",
                      							lv_target_4_0,
                      							"io.typefox.yang.Yang.IfFeatureExpression");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }


                    }


                    }
                    break;
                case 3 :
                    // InternalYangParser.g:3954:3: (otherlv_5= LeftParenthesis this_IfFeatureOrExpression_6= ruleIfFeatureOrExpression otherlv_7= RightParenthesis )
                    {
                    // InternalYangParser.g:3954:3: (otherlv_5= LeftParenthesis this_IfFeatureOrExpression_6= ruleIfFeatureOrExpression otherlv_7= RightParenthesis )
                    // InternalYangParser.g:3955:4: otherlv_5= LeftParenthesis this_IfFeatureOrExpression_6= ruleIfFeatureOrExpression otherlv_7= RightParenthesis
                    {
                    otherlv_5=(Token)match(input,LeftParenthesis,FOLLOW_12); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_5, grammarAccess.getIfFeatureExpressionAccess().getLeftParenthesisKeyword_2_0());
                      			
                    }
                    if ( state.backtracking==0 ) {

                      				newCompositeNode(grammarAccess.getIfFeatureExpressionAccess().getIfFeatureOrExpressionParserRuleCall_2_1());
                      			
                    }
                    pushFollow(FOLLOW_15);
                    this_IfFeatureOrExpression_6=ruleIfFeatureOrExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = this_IfFeatureOrExpression_6;
                      				afterParserOrEnumRuleCall();
                      			
                    }
                    otherlv_7=(Token)match(input,RightParenthesis,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_7, grammarAccess.getIfFeatureExpressionAccess().getRightParenthesisKeyword_2_2());
                      			
                    }

                    }


                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleIfFeatureExpression"


    // $ANTLR start "entryRuleDeviation"
    // InternalYangParser.g:3976:1: entryRuleDeviation returns [EObject current=null] : iv_ruleDeviation= ruleDeviation EOF ;
    public final EObject entryRuleDeviation() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDeviation = null;


        try {
            // InternalYangParser.g:3976:50: (iv_ruleDeviation= ruleDeviation EOF )
            // InternalYangParser.g:3977:2: iv_ruleDeviation= ruleDeviation EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getDeviationRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleDeviation=ruleDeviation();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleDeviation; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleDeviation"


    // $ANTLR start "ruleDeviation"
    // InternalYangParser.g:3983:1: ruleDeviation returns [EObject current=null] : (otherlv_0= Deviation ( (lv_reference_1_0= ruleSchemaNodeIdentifier ) ) this_StatementEnd_2= ruleStatementEnd[$current] ) ;
    public final EObject ruleDeviation() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        EObject lv_reference_1_0 = null;

        EObject this_StatementEnd_2 = null;



        	enterRule();

        try {
            // InternalYangParser.g:3989:2: ( (otherlv_0= Deviation ( (lv_reference_1_0= ruleSchemaNodeIdentifier ) ) this_StatementEnd_2= ruleStatementEnd[$current] ) )
            // InternalYangParser.g:3990:2: (otherlv_0= Deviation ( (lv_reference_1_0= ruleSchemaNodeIdentifier ) ) this_StatementEnd_2= ruleStatementEnd[$current] )
            {
            // InternalYangParser.g:3990:2: (otherlv_0= Deviation ( (lv_reference_1_0= ruleSchemaNodeIdentifier ) ) this_StatementEnd_2= ruleStatementEnd[$current] )
            // InternalYangParser.g:3991:3: otherlv_0= Deviation ( (lv_reference_1_0= ruleSchemaNodeIdentifier ) ) this_StatementEnd_2= ruleStatementEnd[$current]
            {
            otherlv_0=(Token)match(input,Deviation,FOLLOW_10); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getDeviationAccess().getDeviationKeyword_0());
              		
            }
            // InternalYangParser.g:3995:3: ( (lv_reference_1_0= ruleSchemaNodeIdentifier ) )
            // InternalYangParser.g:3996:4: (lv_reference_1_0= ruleSchemaNodeIdentifier )
            {
            // InternalYangParser.g:3996:4: (lv_reference_1_0= ruleSchemaNodeIdentifier )
            // InternalYangParser.g:3997:5: lv_reference_1_0= ruleSchemaNodeIdentifier
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getDeviationAccess().getReferenceSchemaNodeIdentifierParserRuleCall_1_0());
              				
            }
            pushFollow(FOLLOW_5);
            lv_reference_1_0=ruleSchemaNodeIdentifier();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getDeviationRule());
              					}
              					set(
              						current,
              						"reference",
              						lv_reference_1_0,
              						"io.typefox.yang.Yang.SchemaNodeIdentifier");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            if ( state.backtracking==0 ) {

              			if (current==null) {
              				current = createModelElement(grammarAccess.getDeviationRule());
              			}
              			newCompositeNode(grammarAccess.getDeviationAccess().getStatementEndParserRuleCall_2());
              		
            }
            pushFollow(FOLLOW_2);
            this_StatementEnd_2=ruleStatementEnd(current);

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current = this_StatementEnd_2;
              			afterParserOrEnumRuleCall();
              		
            }

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleDeviation"


    // $ANTLR start "entryRuleDeviate"
    // InternalYangParser.g:4029:1: entryRuleDeviate returns [EObject current=null] : iv_ruleDeviate= ruleDeviate EOF ;
    public final EObject entryRuleDeviate() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDeviate = null;


        try {
            // InternalYangParser.g:4029:48: (iv_ruleDeviate= ruleDeviate EOF )
            // InternalYangParser.g:4030:2: iv_ruleDeviate= ruleDeviate EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getDeviateRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleDeviate=ruleDeviate();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleDeviate; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleDeviate"


    // $ANTLR start "ruleDeviate"
    // InternalYangParser.g:4036:1: ruleDeviate returns [EObject current=null] : (otherlv_0= Deviate ( (lv_argument_1_0= ruleStringValue ) ) this_StatementEnd_2= ruleStatementEnd[$current] ) ;
    public final EObject ruleDeviate() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        AntlrDatatypeRuleToken lv_argument_1_0 = null;

        EObject this_StatementEnd_2 = null;



        	enterRule();

        try {
            // InternalYangParser.g:4042:2: ( (otherlv_0= Deviate ( (lv_argument_1_0= ruleStringValue ) ) this_StatementEnd_2= ruleStatementEnd[$current] ) )
            // InternalYangParser.g:4043:2: (otherlv_0= Deviate ( (lv_argument_1_0= ruleStringValue ) ) this_StatementEnd_2= ruleStatementEnd[$current] )
            {
            // InternalYangParser.g:4043:2: (otherlv_0= Deviate ( (lv_argument_1_0= ruleStringValue ) ) this_StatementEnd_2= ruleStatementEnd[$current] )
            // InternalYangParser.g:4044:3: otherlv_0= Deviate ( (lv_argument_1_0= ruleStringValue ) ) this_StatementEnd_2= ruleStatementEnd[$current]
            {
            otherlv_0=(Token)match(input,Deviate,FOLLOW_4); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getDeviateAccess().getDeviateKeyword_0());
              		
            }
            // InternalYangParser.g:4048:3: ( (lv_argument_1_0= ruleStringValue ) )
            // InternalYangParser.g:4049:4: (lv_argument_1_0= ruleStringValue )
            {
            // InternalYangParser.g:4049:4: (lv_argument_1_0= ruleStringValue )
            // InternalYangParser.g:4050:5: lv_argument_1_0= ruleStringValue
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getDeviateAccess().getArgumentStringValueParserRuleCall_1_0());
              				
            }
            pushFollow(FOLLOW_5);
            lv_argument_1_0=ruleStringValue();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getDeviateRule());
              					}
              					set(
              						current,
              						"argument",
              						lv_argument_1_0,
              						"io.typefox.yang.Yang.StringValue");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            if ( state.backtracking==0 ) {

              			if (current==null) {
              				current = createModelElement(grammarAccess.getDeviateRule());
              			}
              			newCompositeNode(grammarAccess.getDeviateAccess().getStatementEndParserRuleCall_2());
              		
            }
            pushFollow(FOLLOW_2);
            this_StatementEnd_2=ruleStatementEnd(current);

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current = this_StatementEnd_2;
              			afterParserOrEnumRuleCall();
              		
            }

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleDeviate"


    // $ANTLR start "entryRuleConfig"
    // InternalYangParser.g:4082:1: entryRuleConfig returns [EObject current=null] : iv_ruleConfig= ruleConfig EOF ;
    public final EObject entryRuleConfig() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleConfig = null;


        try {
            // InternalYangParser.g:4082:47: (iv_ruleConfig= ruleConfig EOF )
            // InternalYangParser.g:4083:2: iv_ruleConfig= ruleConfig EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getConfigRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleConfig=ruleConfig();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleConfig; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleConfig"


    // $ANTLR start "ruleConfig"
    // InternalYangParser.g:4089:1: ruleConfig returns [EObject current=null] : (otherlv_0= Config ( (lv_isConfig_1_0= ruleStringValue ) ) this_StatementEnd_2= ruleStatementEnd[$current] ) ;
    public final EObject ruleConfig() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        AntlrDatatypeRuleToken lv_isConfig_1_0 = null;

        EObject this_StatementEnd_2 = null;



        	enterRule();

        try {
            // InternalYangParser.g:4095:2: ( (otherlv_0= Config ( (lv_isConfig_1_0= ruleStringValue ) ) this_StatementEnd_2= ruleStatementEnd[$current] ) )
            // InternalYangParser.g:4096:2: (otherlv_0= Config ( (lv_isConfig_1_0= ruleStringValue ) ) this_StatementEnd_2= ruleStatementEnd[$current] )
            {
            // InternalYangParser.g:4096:2: (otherlv_0= Config ( (lv_isConfig_1_0= ruleStringValue ) ) this_StatementEnd_2= ruleStatementEnd[$current] )
            // InternalYangParser.g:4097:3: otherlv_0= Config ( (lv_isConfig_1_0= ruleStringValue ) ) this_StatementEnd_2= ruleStatementEnd[$current]
            {
            otherlv_0=(Token)match(input,Config,FOLLOW_4); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getConfigAccess().getConfigKeyword_0());
              		
            }
            // InternalYangParser.g:4101:3: ( (lv_isConfig_1_0= ruleStringValue ) )
            // InternalYangParser.g:4102:4: (lv_isConfig_1_0= ruleStringValue )
            {
            // InternalYangParser.g:4102:4: (lv_isConfig_1_0= ruleStringValue )
            // InternalYangParser.g:4103:5: lv_isConfig_1_0= ruleStringValue
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getConfigAccess().getIsConfigStringValueParserRuleCall_1_0());
              				
            }
            pushFollow(FOLLOW_5);
            lv_isConfig_1_0=ruleStringValue();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getConfigRule());
              					}
              					set(
              						current,
              						"isConfig",
              						lv_isConfig_1_0,
              						"io.typefox.yang.Yang.StringValue");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            if ( state.backtracking==0 ) {

              			if (current==null) {
              				current = createModelElement(grammarAccess.getConfigRule());
              			}
              			newCompositeNode(grammarAccess.getConfigAccess().getStatementEndParserRuleCall_2());
              		
            }
            pushFollow(FOLLOW_2);
            this_StatementEnd_2=ruleStatementEnd(current);

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current = this_StatementEnd_2;
              			afterParserOrEnumRuleCall();
              		
            }

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleConfig"


    // $ANTLR start "entryRuleStatus"
    // InternalYangParser.g:4135:1: entryRuleStatus returns [EObject current=null] : iv_ruleStatus= ruleStatus EOF ;
    public final EObject entryRuleStatus() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStatus = null;


        try {
            // InternalYangParser.g:4135:47: (iv_ruleStatus= ruleStatus EOF )
            // InternalYangParser.g:4136:2: iv_ruleStatus= ruleStatus EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getStatusRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleStatus=ruleStatus();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleStatus; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleStatus"


    // $ANTLR start "ruleStatus"
    // InternalYangParser.g:4142:1: ruleStatus returns [EObject current=null] : (otherlv_0= Status ( (lv_argument_1_0= ruleStringValue ) ) this_StatementEnd_2= ruleStatementEnd[$current] ) ;
    public final EObject ruleStatus() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        AntlrDatatypeRuleToken lv_argument_1_0 = null;

        EObject this_StatementEnd_2 = null;



        	enterRule();

        try {
            // InternalYangParser.g:4148:2: ( (otherlv_0= Status ( (lv_argument_1_0= ruleStringValue ) ) this_StatementEnd_2= ruleStatementEnd[$current] ) )
            // InternalYangParser.g:4149:2: (otherlv_0= Status ( (lv_argument_1_0= ruleStringValue ) ) this_StatementEnd_2= ruleStatementEnd[$current] )
            {
            // InternalYangParser.g:4149:2: (otherlv_0= Status ( (lv_argument_1_0= ruleStringValue ) ) this_StatementEnd_2= ruleStatementEnd[$current] )
            // InternalYangParser.g:4150:3: otherlv_0= Status ( (lv_argument_1_0= ruleStringValue ) ) this_StatementEnd_2= ruleStatementEnd[$current]
            {
            otherlv_0=(Token)match(input,Status,FOLLOW_4); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getStatusAccess().getStatusKeyword_0());
              		
            }
            // InternalYangParser.g:4154:3: ( (lv_argument_1_0= ruleStringValue ) )
            // InternalYangParser.g:4155:4: (lv_argument_1_0= ruleStringValue )
            {
            // InternalYangParser.g:4155:4: (lv_argument_1_0= ruleStringValue )
            // InternalYangParser.g:4156:5: lv_argument_1_0= ruleStringValue
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getStatusAccess().getArgumentStringValueParserRuleCall_1_0());
              				
            }
            pushFollow(FOLLOW_5);
            lv_argument_1_0=ruleStringValue();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getStatusRule());
              					}
              					set(
              						current,
              						"argument",
              						lv_argument_1_0,
              						"io.typefox.yang.Yang.StringValue");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            if ( state.backtracking==0 ) {

              			if (current==null) {
              				current = createModelElement(grammarAccess.getStatusRule());
              			}
              			newCompositeNode(grammarAccess.getStatusAccess().getStatementEndParserRuleCall_2());
              		
            }
            pushFollow(FOLLOW_2);
            this_StatementEnd_2=ruleStatementEnd(current);

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current = this_StatementEnd_2;
              			afterParserOrEnumRuleCall();
              		
            }

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleStatus"


    // $ANTLR start "entryRuleDescription"
    // InternalYangParser.g:4188:1: entryRuleDescription returns [EObject current=null] : iv_ruleDescription= ruleDescription EOF ;
    public final EObject entryRuleDescription() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDescription = null;


        try {
            // InternalYangParser.g:4188:52: (iv_ruleDescription= ruleDescription EOF )
            // InternalYangParser.g:4189:2: iv_ruleDescription= ruleDescription EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getDescriptionRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleDescription=ruleDescription();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleDescription; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleDescription"


    // $ANTLR start "ruleDescription"
    // InternalYangParser.g:4195:1: ruleDescription returns [EObject current=null] : (otherlv_0= Description ( (lv_description_1_0= ruleStringValue ) ) this_StatementEnd_2= ruleStatementEnd[$current] ) ;
    public final EObject ruleDescription() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        AntlrDatatypeRuleToken lv_description_1_0 = null;

        EObject this_StatementEnd_2 = null;



        	enterRule();

        try {
            // InternalYangParser.g:4201:2: ( (otherlv_0= Description ( (lv_description_1_0= ruleStringValue ) ) this_StatementEnd_2= ruleStatementEnd[$current] ) )
            // InternalYangParser.g:4202:2: (otherlv_0= Description ( (lv_description_1_0= ruleStringValue ) ) this_StatementEnd_2= ruleStatementEnd[$current] )
            {
            // InternalYangParser.g:4202:2: (otherlv_0= Description ( (lv_description_1_0= ruleStringValue ) ) this_StatementEnd_2= ruleStatementEnd[$current] )
            // InternalYangParser.g:4203:3: otherlv_0= Description ( (lv_description_1_0= ruleStringValue ) ) this_StatementEnd_2= ruleStatementEnd[$current]
            {
            otherlv_0=(Token)match(input,Description,FOLLOW_4); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getDescriptionAccess().getDescriptionKeyword_0());
              		
            }
            // InternalYangParser.g:4207:3: ( (lv_description_1_0= ruleStringValue ) )
            // InternalYangParser.g:4208:4: (lv_description_1_0= ruleStringValue )
            {
            // InternalYangParser.g:4208:4: (lv_description_1_0= ruleStringValue )
            // InternalYangParser.g:4209:5: lv_description_1_0= ruleStringValue
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getDescriptionAccess().getDescriptionStringValueParserRuleCall_1_0());
              				
            }
            pushFollow(FOLLOW_5);
            lv_description_1_0=ruleStringValue();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getDescriptionRule());
              					}
              					set(
              						current,
              						"description",
              						lv_description_1_0,
              						"io.typefox.yang.Yang.StringValue");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            if ( state.backtracking==0 ) {

              			if (current==null) {
              				current = createModelElement(grammarAccess.getDescriptionRule());
              			}
              			newCompositeNode(grammarAccess.getDescriptionAccess().getStatementEndParserRuleCall_2());
              		
            }
            pushFollow(FOLLOW_2);
            this_StatementEnd_2=ruleStatementEnd(current);

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current = this_StatementEnd_2;
              			afterParserOrEnumRuleCall();
              		
            }

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleDescription"


    // $ANTLR start "entryRuleReference"
    // InternalYangParser.g:4241:1: entryRuleReference returns [EObject current=null] : iv_ruleReference= ruleReference EOF ;
    public final EObject entryRuleReference() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleReference = null;


        try {
            // InternalYangParser.g:4241:50: (iv_ruleReference= ruleReference EOF )
            // InternalYangParser.g:4242:2: iv_ruleReference= ruleReference EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getReferenceRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleReference=ruleReference();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleReference; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleReference"


    // $ANTLR start "ruleReference"
    // InternalYangParser.g:4248:1: ruleReference returns [EObject current=null] : (otherlv_0= Reference ( (lv_reference_1_0= ruleStringValue ) ) this_StatementEnd_2= ruleStatementEnd[$current] ) ;
    public final EObject ruleReference() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        AntlrDatatypeRuleToken lv_reference_1_0 = null;

        EObject this_StatementEnd_2 = null;



        	enterRule();

        try {
            // InternalYangParser.g:4254:2: ( (otherlv_0= Reference ( (lv_reference_1_0= ruleStringValue ) ) this_StatementEnd_2= ruleStatementEnd[$current] ) )
            // InternalYangParser.g:4255:2: (otherlv_0= Reference ( (lv_reference_1_0= ruleStringValue ) ) this_StatementEnd_2= ruleStatementEnd[$current] )
            {
            // InternalYangParser.g:4255:2: (otherlv_0= Reference ( (lv_reference_1_0= ruleStringValue ) ) this_StatementEnd_2= ruleStatementEnd[$current] )
            // InternalYangParser.g:4256:3: otherlv_0= Reference ( (lv_reference_1_0= ruleStringValue ) ) this_StatementEnd_2= ruleStatementEnd[$current]
            {
            otherlv_0=(Token)match(input,Reference,FOLLOW_4); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getReferenceAccess().getReferenceKeyword_0());
              		
            }
            // InternalYangParser.g:4260:3: ( (lv_reference_1_0= ruleStringValue ) )
            // InternalYangParser.g:4261:4: (lv_reference_1_0= ruleStringValue )
            {
            // InternalYangParser.g:4261:4: (lv_reference_1_0= ruleStringValue )
            // InternalYangParser.g:4262:5: lv_reference_1_0= ruleStringValue
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getReferenceAccess().getReferenceStringValueParserRuleCall_1_0());
              				
            }
            pushFollow(FOLLOW_5);
            lv_reference_1_0=ruleStringValue();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getReferenceRule());
              					}
              					set(
              						current,
              						"reference",
              						lv_reference_1_0,
              						"io.typefox.yang.Yang.StringValue");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            if ( state.backtracking==0 ) {

              			if (current==null) {
              				current = createModelElement(grammarAccess.getReferenceRule());
              			}
              			newCompositeNode(grammarAccess.getReferenceAccess().getStatementEndParserRuleCall_2());
              		
            }
            pushFollow(FOLLOW_2);
            this_StatementEnd_2=ruleStatementEnd(current);

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current = this_StatementEnd_2;
              			afterParserOrEnumRuleCall();
              		
            }

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleReference"


    // $ANTLR start "entryRuleWhen"
    // InternalYangParser.g:4294:1: entryRuleWhen returns [EObject current=null] : iv_ruleWhen= ruleWhen EOF ;
    public final EObject entryRuleWhen() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleWhen = null;


        try {
            // InternalYangParser.g:4294:45: (iv_ruleWhen= ruleWhen EOF )
            // InternalYangParser.g:4295:2: iv_ruleWhen= ruleWhen EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getWhenRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleWhen=ruleWhen();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleWhen; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleWhen"


    // $ANTLR start "ruleWhen"
    // InternalYangParser.g:4301:1: ruleWhen returns [EObject current=null] : (otherlv_0= When ( (lv_condition_1_0= ruleXpathExpression ) ) this_StatementEnd_2= ruleStatementEnd[$current] ) ;
    public final EObject ruleWhen() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        EObject lv_condition_1_0 = null;

        EObject this_StatementEnd_2 = null;



        	enterRule();

        try {
            // InternalYangParser.g:4307:2: ( (otherlv_0= When ( (lv_condition_1_0= ruleXpathExpression ) ) this_StatementEnd_2= ruleStatementEnd[$current] ) )
            // InternalYangParser.g:4308:2: (otherlv_0= When ( (lv_condition_1_0= ruleXpathExpression ) ) this_StatementEnd_2= ruleStatementEnd[$current] )
            {
            // InternalYangParser.g:4308:2: (otherlv_0= When ( (lv_condition_1_0= ruleXpathExpression ) ) this_StatementEnd_2= ruleStatementEnd[$current] )
            // InternalYangParser.g:4309:3: otherlv_0= When ( (lv_condition_1_0= ruleXpathExpression ) ) this_StatementEnd_2= ruleStatementEnd[$current]
            {
            otherlv_0=(Token)match(input,When,FOLLOW_7); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getWhenAccess().getWhenKeyword_0());
              		
            }
            // InternalYangParser.g:4313:3: ( (lv_condition_1_0= ruleXpathExpression ) )
            // InternalYangParser.g:4314:4: (lv_condition_1_0= ruleXpathExpression )
            {
            // InternalYangParser.g:4314:4: (lv_condition_1_0= ruleXpathExpression )
            // InternalYangParser.g:4315:5: lv_condition_1_0= ruleXpathExpression
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getWhenAccess().getConditionXpathExpressionParserRuleCall_1_0());
              				
            }
            pushFollow(FOLLOW_5);
            lv_condition_1_0=ruleXpathExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getWhenRule());
              					}
              					set(
              						current,
              						"condition",
              						lv_condition_1_0,
              						"io.typefox.yang.Yang.XpathExpression");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            if ( state.backtracking==0 ) {

              			if (current==null) {
              				current = createModelElement(grammarAccess.getWhenRule());
              			}
              			newCompositeNode(grammarAccess.getWhenAccess().getStatementEndParserRuleCall_2());
              		
            }
            pushFollow(FOLLOW_2);
            this_StatementEnd_2=ruleStatementEnd(current);

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current = this_StatementEnd_2;
              			afterParserOrEnumRuleCall();
              		
            }

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleWhen"


    // $ANTLR start "entryRuleRange"
    // InternalYangParser.g:4347:1: entryRuleRange returns [EObject current=null] : iv_ruleRange= ruleRange EOF ;
    public final EObject entryRuleRange() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRange = null;


        try {
            // InternalYangParser.g:4347:46: (iv_ruleRange= ruleRange EOF )
            // InternalYangParser.g:4348:2: iv_ruleRange= ruleRange EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getRangeRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleRange=ruleRange();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleRange; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleRange"


    // $ANTLR start "ruleRange"
    // InternalYangParser.g:4354:1: ruleRange returns [EObject current=null] : (otherlv_0= Range ( (lv_expression_1_0= ruleRefinementExpression ) ) this_StatementEnd_2= ruleStatementEnd[$current] ) ;
    public final EObject ruleRange() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        EObject lv_expression_1_0 = null;

        EObject this_StatementEnd_2 = null;



        	enterRule();

        try {
            // InternalYangParser.g:4360:2: ( (otherlv_0= Range ( (lv_expression_1_0= ruleRefinementExpression ) ) this_StatementEnd_2= ruleStatementEnd[$current] ) )
            // InternalYangParser.g:4361:2: (otherlv_0= Range ( (lv_expression_1_0= ruleRefinementExpression ) ) this_StatementEnd_2= ruleStatementEnd[$current] )
            {
            // InternalYangParser.g:4361:2: (otherlv_0= Range ( (lv_expression_1_0= ruleRefinementExpression ) ) this_StatementEnd_2= ruleStatementEnd[$current] )
            // InternalYangParser.g:4362:3: otherlv_0= Range ( (lv_expression_1_0= ruleRefinementExpression ) ) this_StatementEnd_2= ruleStatementEnd[$current]
            {
            otherlv_0=(Token)match(input,Range,FOLLOW_16); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getRangeAccess().getRangeKeyword_0());
              		
            }
            // InternalYangParser.g:4366:3: ( (lv_expression_1_0= ruleRefinementExpression ) )
            // InternalYangParser.g:4367:4: (lv_expression_1_0= ruleRefinementExpression )
            {
            // InternalYangParser.g:4367:4: (lv_expression_1_0= ruleRefinementExpression )
            // InternalYangParser.g:4368:5: lv_expression_1_0= ruleRefinementExpression
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getRangeAccess().getExpressionRefinementExpressionParserRuleCall_1_0());
              				
            }
            pushFollow(FOLLOW_5);
            lv_expression_1_0=ruleRefinementExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getRangeRule());
              					}
              					set(
              						current,
              						"expression",
              						lv_expression_1_0,
              						"io.typefox.yang.Yang.RefinementExpression");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            if ( state.backtracking==0 ) {

              			if (current==null) {
              				current = createModelElement(grammarAccess.getRangeRule());
              			}
              			newCompositeNode(grammarAccess.getRangeAccess().getStatementEndParserRuleCall_2());
              		
            }
            pushFollow(FOLLOW_2);
            this_StatementEnd_2=ruleStatementEnd(current);

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current = this_StatementEnd_2;
              			afterParserOrEnumRuleCall();
              		
            }

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleRange"


    // $ANTLR start "entryRuleRefinementExpression"
    // InternalYangParser.g:4400:1: entryRuleRefinementExpression returns [EObject current=null] : iv_ruleRefinementExpression= ruleRefinementExpression EOF ;
    public final EObject entryRuleRefinementExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRefinementExpression = null;


        try {
            // InternalYangParser.g:4400:61: (iv_ruleRefinementExpression= ruleRefinementExpression EOF )
            // InternalYangParser.g:4401:2: iv_ruleRefinementExpression= ruleRefinementExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getRefinementExpressionRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleRefinementExpression=ruleRefinementExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleRefinementExpression; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleRefinementExpression"


    // $ANTLR start "ruleRefinementExpression"
    // InternalYangParser.g:4407:1: ruleRefinementExpression returns [EObject current=null] : (this_RangeRefinementExpression_0= ruleRangeRefinementExpression ( () ( (lv_operator_2_0= VerticalLine ) ) ( (lv_right_3_0= ruleRangeRefinementExpression ) ) )* ) ;
    public final EObject ruleRefinementExpression() throws RecognitionException {
        EObject current = null;

        Token lv_operator_2_0=null;
        EObject this_RangeRefinementExpression_0 = null;

        EObject lv_right_3_0 = null;



        	enterRule();

        try {
            // InternalYangParser.g:4413:2: ( (this_RangeRefinementExpression_0= ruleRangeRefinementExpression ( () ( (lv_operator_2_0= VerticalLine ) ) ( (lv_right_3_0= ruleRangeRefinementExpression ) ) )* ) )
            // InternalYangParser.g:4414:2: (this_RangeRefinementExpression_0= ruleRangeRefinementExpression ( () ( (lv_operator_2_0= VerticalLine ) ) ( (lv_right_3_0= ruleRangeRefinementExpression ) ) )* )
            {
            // InternalYangParser.g:4414:2: (this_RangeRefinementExpression_0= ruleRangeRefinementExpression ( () ( (lv_operator_2_0= VerticalLine ) ) ( (lv_right_3_0= ruleRangeRefinementExpression ) ) )* )
            // InternalYangParser.g:4415:3: this_RangeRefinementExpression_0= ruleRangeRefinementExpression ( () ( (lv_operator_2_0= VerticalLine ) ) ( (lv_right_3_0= ruleRangeRefinementExpression ) ) )*
            {
            if ( state.backtracking==0 ) {

              			newCompositeNode(grammarAccess.getRefinementExpressionAccess().getRangeRefinementExpressionParserRuleCall_0());
              		
            }
            pushFollow(FOLLOW_17);
            this_RangeRefinementExpression_0=ruleRangeRefinementExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current = this_RangeRefinementExpression_0;
              			afterParserOrEnumRuleCall();
              		
            }
            // InternalYangParser.g:4423:3: ( () ( (lv_operator_2_0= VerticalLine ) ) ( (lv_right_3_0= ruleRangeRefinementExpression ) ) )*
            loop20:
            do {
                int alt20=2;
                int LA20_0 = input.LA(1);

                if ( (LA20_0==VerticalLine) ) {
                    alt20=1;
                }


                switch (alt20) {
            	case 1 :
            	    // InternalYangParser.g:4424:4: () ( (lv_operator_2_0= VerticalLine ) ) ( (lv_right_3_0= ruleRangeRefinementExpression ) )
            	    {
            	    // InternalYangParser.g:4424:4: ()
            	    // InternalYangParser.g:4425:5: 
            	    {
            	    if ( state.backtracking==0 ) {

            	      					current = forceCreateModelElementAndSet(
            	      						grammarAccess.getRefinementExpressionAccess().getBinaryOperationLeftAction_1_0(),
            	      						current);
            	      				
            	    }

            	    }

            	    // InternalYangParser.g:4431:4: ( (lv_operator_2_0= VerticalLine ) )
            	    // InternalYangParser.g:4432:5: (lv_operator_2_0= VerticalLine )
            	    {
            	    // InternalYangParser.g:4432:5: (lv_operator_2_0= VerticalLine )
            	    // InternalYangParser.g:4433:6: lv_operator_2_0= VerticalLine
            	    {
            	    lv_operator_2_0=(Token)match(input,VerticalLine,FOLLOW_16); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      						newLeafNode(lv_operator_2_0, grammarAccess.getRefinementExpressionAccess().getOperatorVerticalLineKeyword_1_1_0());
            	      					
            	    }
            	    if ( state.backtracking==0 ) {

            	      						if (current==null) {
            	      							current = createModelElement(grammarAccess.getRefinementExpressionRule());
            	      						}
            	      						setWithLastConsumed(current, "operator", lv_operator_2_0, "|");
            	      					
            	    }

            	    }


            	    }

            	    // InternalYangParser.g:4445:4: ( (lv_right_3_0= ruleRangeRefinementExpression ) )
            	    // InternalYangParser.g:4446:5: (lv_right_3_0= ruleRangeRefinementExpression )
            	    {
            	    // InternalYangParser.g:4446:5: (lv_right_3_0= ruleRangeRefinementExpression )
            	    // InternalYangParser.g:4447:6: lv_right_3_0= ruleRangeRefinementExpression
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getRefinementExpressionAccess().getRightRangeRefinementExpressionParserRuleCall_1_2_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_17);
            	    lv_right_3_0=ruleRangeRefinementExpression();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      						if (current==null) {
            	      							current = createModelElementForParent(grammarAccess.getRefinementExpressionRule());
            	      						}
            	      						set(
            	      							current,
            	      							"right",
            	      							lv_right_3_0,
            	      							"io.typefox.yang.Yang.RangeRefinementExpression");
            	      						afterParserOrEnumRuleCall();
            	      					
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop20;
                }
            } while (true);


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleRefinementExpression"


    // $ANTLR start "entryRuleRangeRefinementExpression"
    // InternalYangParser.g:4469:1: entryRuleRangeRefinementExpression returns [EObject current=null] : iv_ruleRangeRefinementExpression= ruleRangeRefinementExpression EOF ;
    public final EObject entryRuleRangeRefinementExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRangeRefinementExpression = null;


        try {
            // InternalYangParser.g:4469:66: (iv_ruleRangeRefinementExpression= ruleRangeRefinementExpression EOF )
            // InternalYangParser.g:4470:2: iv_ruleRangeRefinementExpression= ruleRangeRefinementExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getRangeRefinementExpressionRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleRangeRefinementExpression=ruleRangeRefinementExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleRangeRefinementExpression; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleRangeRefinementExpression"


    // $ANTLR start "ruleRangeRefinementExpression"
    // InternalYangParser.g:4476:1: ruleRangeRefinementExpression returns [EObject current=null] : (this_ExplicitRefinementExpression_0= ruleExplicitRefinementExpression ( () ( (lv_operator_2_0= FullStopFullStop ) ) ( (lv_right_3_0= ruleExplicitRefinementExpression ) ) )? ) ;
    public final EObject ruleRangeRefinementExpression() throws RecognitionException {
        EObject current = null;

        Token lv_operator_2_0=null;
        EObject this_ExplicitRefinementExpression_0 = null;

        EObject lv_right_3_0 = null;



        	enterRule();

        try {
            // InternalYangParser.g:4482:2: ( (this_ExplicitRefinementExpression_0= ruleExplicitRefinementExpression ( () ( (lv_operator_2_0= FullStopFullStop ) ) ( (lv_right_3_0= ruleExplicitRefinementExpression ) ) )? ) )
            // InternalYangParser.g:4483:2: (this_ExplicitRefinementExpression_0= ruleExplicitRefinementExpression ( () ( (lv_operator_2_0= FullStopFullStop ) ) ( (lv_right_3_0= ruleExplicitRefinementExpression ) ) )? )
            {
            // InternalYangParser.g:4483:2: (this_ExplicitRefinementExpression_0= ruleExplicitRefinementExpression ( () ( (lv_operator_2_0= FullStopFullStop ) ) ( (lv_right_3_0= ruleExplicitRefinementExpression ) ) )? )
            // InternalYangParser.g:4484:3: this_ExplicitRefinementExpression_0= ruleExplicitRefinementExpression ( () ( (lv_operator_2_0= FullStopFullStop ) ) ( (lv_right_3_0= ruleExplicitRefinementExpression ) ) )?
            {
            if ( state.backtracking==0 ) {

              			newCompositeNode(grammarAccess.getRangeRefinementExpressionAccess().getExplicitRefinementExpressionParserRuleCall_0());
              		
            }
            pushFollow(FOLLOW_18);
            this_ExplicitRefinementExpression_0=ruleExplicitRefinementExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current = this_ExplicitRefinementExpression_0;
              			afterParserOrEnumRuleCall();
              		
            }
            // InternalYangParser.g:4492:3: ( () ( (lv_operator_2_0= FullStopFullStop ) ) ( (lv_right_3_0= ruleExplicitRefinementExpression ) ) )?
            int alt21=2;
            int LA21_0 = input.LA(1);

            if ( (LA21_0==FullStopFullStop) ) {
                alt21=1;
            }
            switch (alt21) {
                case 1 :
                    // InternalYangParser.g:4493:4: () ( (lv_operator_2_0= FullStopFullStop ) ) ( (lv_right_3_0= ruleExplicitRefinementExpression ) )
                    {
                    // InternalYangParser.g:4493:4: ()
                    // InternalYangParser.g:4494:5: 
                    {
                    if ( state.backtracking==0 ) {

                      					current = forceCreateModelElementAndSet(
                      						grammarAccess.getRangeRefinementExpressionAccess().getBinaryOperationLeftAction_1_0(),
                      						current);
                      				
                    }

                    }

                    // InternalYangParser.g:4500:4: ( (lv_operator_2_0= FullStopFullStop ) )
                    // InternalYangParser.g:4501:5: (lv_operator_2_0= FullStopFullStop )
                    {
                    // InternalYangParser.g:4501:5: (lv_operator_2_0= FullStopFullStop )
                    // InternalYangParser.g:4502:6: lv_operator_2_0= FullStopFullStop
                    {
                    lv_operator_2_0=(Token)match(input,FullStopFullStop,FOLLOW_16); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						newLeafNode(lv_operator_2_0, grammarAccess.getRangeRefinementExpressionAccess().getOperatorFullStopFullStopKeyword_1_1_0());
                      					
                    }
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElement(grammarAccess.getRangeRefinementExpressionRule());
                      						}
                      						setWithLastConsumed(current, "operator", lv_operator_2_0, "..");
                      					
                    }

                    }


                    }

                    // InternalYangParser.g:4514:4: ( (lv_right_3_0= ruleExplicitRefinementExpression ) )
                    // InternalYangParser.g:4515:5: (lv_right_3_0= ruleExplicitRefinementExpression )
                    {
                    // InternalYangParser.g:4515:5: (lv_right_3_0= ruleExplicitRefinementExpression )
                    // InternalYangParser.g:4516:6: lv_right_3_0= ruleExplicitRefinementExpression
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getRangeRefinementExpressionAccess().getRightExplicitRefinementExpressionParserRuleCall_1_2_0());
                      					
                    }
                    pushFollow(FOLLOW_2);
                    lv_right_3_0=ruleExplicitRefinementExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getRangeRefinementExpressionRule());
                      						}
                      						set(
                      							current,
                      							"right",
                      							lv_right_3_0,
                      							"io.typefox.yang.Yang.ExplicitRefinementExpression");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }


                    }
                    break;

            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleRangeRefinementExpression"


    // $ANTLR start "entryRuleExplicitRefinementExpression"
    // InternalYangParser.g:4538:1: entryRuleExplicitRefinementExpression returns [EObject current=null] : iv_ruleExplicitRefinementExpression= ruleExplicitRefinementExpression EOF ;
    public final EObject entryRuleExplicitRefinementExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExplicitRefinementExpression = null;


        try {
            // InternalYangParser.g:4538:69: (iv_ruleExplicitRefinementExpression= ruleExplicitRefinementExpression EOF )
            // InternalYangParser.g:4539:2: iv_ruleExplicitRefinementExpression= ruleExplicitRefinementExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getExplicitRefinementExpressionRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleExplicitRefinementExpression=ruleExplicitRefinementExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleExplicitRefinementExpression; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleExplicitRefinementExpression"


    // $ANTLR start "ruleExplicitRefinementExpression"
    // InternalYangParser.g:4545:1: ruleExplicitRefinementExpression returns [EObject current=null] : ( ( () ( (lv_value_1_0= RULE_NUMBER ) ) ) | ( () otherlv_3= Min ) | ( () otherlv_5= Max ) ) ;
    public final EObject ruleExplicitRefinementExpression() throws RecognitionException {
        EObject current = null;

        Token lv_value_1_0=null;
        Token otherlv_3=null;
        Token otherlv_5=null;


        	enterRule();

        try {
            // InternalYangParser.g:4551:2: ( ( ( () ( (lv_value_1_0= RULE_NUMBER ) ) ) | ( () otherlv_3= Min ) | ( () otherlv_5= Max ) ) )
            // InternalYangParser.g:4552:2: ( ( () ( (lv_value_1_0= RULE_NUMBER ) ) ) | ( () otherlv_3= Min ) | ( () otherlv_5= Max ) )
            {
            // InternalYangParser.g:4552:2: ( ( () ( (lv_value_1_0= RULE_NUMBER ) ) ) | ( () otherlv_3= Min ) | ( () otherlv_5= Max ) )
            int alt22=3;
            switch ( input.LA(1) ) {
            case RULE_NUMBER:
                {
                alt22=1;
                }
                break;
            case Min:
                {
                alt22=2;
                }
                break;
            case Max:
                {
                alt22=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 22, 0, input);

                throw nvae;
            }

            switch (alt22) {
                case 1 :
                    // InternalYangParser.g:4553:3: ( () ( (lv_value_1_0= RULE_NUMBER ) ) )
                    {
                    // InternalYangParser.g:4553:3: ( () ( (lv_value_1_0= RULE_NUMBER ) ) )
                    // InternalYangParser.g:4554:4: () ( (lv_value_1_0= RULE_NUMBER ) )
                    {
                    // InternalYangParser.g:4554:4: ()
                    // InternalYangParser.g:4555:5: 
                    {
                    if ( state.backtracking==0 ) {

                      					current = forceCreateModelElement(
                      						grammarAccess.getExplicitRefinementExpressionAccess().getLiteralAction_0_0(),
                      						current);
                      				
                    }

                    }

                    // InternalYangParser.g:4561:4: ( (lv_value_1_0= RULE_NUMBER ) )
                    // InternalYangParser.g:4562:5: (lv_value_1_0= RULE_NUMBER )
                    {
                    // InternalYangParser.g:4562:5: (lv_value_1_0= RULE_NUMBER )
                    // InternalYangParser.g:4563:6: lv_value_1_0= RULE_NUMBER
                    {
                    lv_value_1_0=(Token)match(input,RULE_NUMBER,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						newLeafNode(lv_value_1_0, grammarAccess.getExplicitRefinementExpressionAccess().getValueNUMBERTerminalRuleCall_0_1_0());
                      					
                    }
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElement(grammarAccess.getExplicitRefinementExpressionRule());
                      						}
                      						setWithLastConsumed(
                      							current,
                      							"value",
                      							lv_value_1_0,
                      							"io.typefox.yang.Yang.NUMBER");
                      					
                    }

                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalYangParser.g:4581:3: ( () otherlv_3= Min )
                    {
                    // InternalYangParser.g:4581:3: ( () otherlv_3= Min )
                    // InternalYangParser.g:4582:4: () otherlv_3= Min
                    {
                    // InternalYangParser.g:4582:4: ()
                    // InternalYangParser.g:4583:5: 
                    {
                    if ( state.backtracking==0 ) {

                      					current = forceCreateModelElement(
                      						grammarAccess.getExplicitRefinementExpressionAccess().getMinAction_1_0(),
                      						current);
                      				
                    }

                    }

                    otherlv_3=(Token)match(input,Min,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_3, grammarAccess.getExplicitRefinementExpressionAccess().getMinKeyword_1_1());
                      			
                    }

                    }


                    }
                    break;
                case 3 :
                    // InternalYangParser.g:4595:3: ( () otherlv_5= Max )
                    {
                    // InternalYangParser.g:4595:3: ( () otherlv_5= Max )
                    // InternalYangParser.g:4596:4: () otherlv_5= Max
                    {
                    // InternalYangParser.g:4596:4: ()
                    // InternalYangParser.g:4597:5: 
                    {
                    if ( state.backtracking==0 ) {

                      					current = forceCreateModelElement(
                      						grammarAccess.getExplicitRefinementExpressionAccess().getMaxAction_2_0(),
                      						current);
                      				
                    }

                    }

                    otherlv_5=(Token)match(input,Max,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_5, grammarAccess.getExplicitRefinementExpressionAccess().getMaxKeyword_2_1());
                      			
                    }

                    }


                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleExplicitRefinementExpression"


    // $ANTLR start "entryRuleFractionDigits"
    // InternalYangParser.g:4612:1: entryRuleFractionDigits returns [EObject current=null] : iv_ruleFractionDigits= ruleFractionDigits EOF ;
    public final EObject entryRuleFractionDigits() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFractionDigits = null;


        try {
            // InternalYangParser.g:4612:55: (iv_ruleFractionDigits= ruleFractionDigits EOF )
            // InternalYangParser.g:4613:2: iv_ruleFractionDigits= ruleFractionDigits EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getFractionDigitsRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleFractionDigits=ruleFractionDigits();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleFractionDigits; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleFractionDigits"


    // $ANTLR start "ruleFractionDigits"
    // InternalYangParser.g:4619:1: ruleFractionDigits returns [EObject current=null] : (otherlv_0= FractionDigits ( (lv_range_1_0= ruleStringValue ) ) this_StatementEnd_2= ruleStatementEnd[$current] ) ;
    public final EObject ruleFractionDigits() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        AntlrDatatypeRuleToken lv_range_1_0 = null;

        EObject this_StatementEnd_2 = null;



        	enterRule();

        try {
            // InternalYangParser.g:4625:2: ( (otherlv_0= FractionDigits ( (lv_range_1_0= ruleStringValue ) ) this_StatementEnd_2= ruleStatementEnd[$current] ) )
            // InternalYangParser.g:4626:2: (otherlv_0= FractionDigits ( (lv_range_1_0= ruleStringValue ) ) this_StatementEnd_2= ruleStatementEnd[$current] )
            {
            // InternalYangParser.g:4626:2: (otherlv_0= FractionDigits ( (lv_range_1_0= ruleStringValue ) ) this_StatementEnd_2= ruleStatementEnd[$current] )
            // InternalYangParser.g:4627:3: otherlv_0= FractionDigits ( (lv_range_1_0= ruleStringValue ) ) this_StatementEnd_2= ruleStatementEnd[$current]
            {
            otherlv_0=(Token)match(input,FractionDigits,FOLLOW_4); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getFractionDigitsAccess().getFractionDigitsKeyword_0());
              		
            }
            // InternalYangParser.g:4631:3: ( (lv_range_1_0= ruleStringValue ) )
            // InternalYangParser.g:4632:4: (lv_range_1_0= ruleStringValue )
            {
            // InternalYangParser.g:4632:4: (lv_range_1_0= ruleStringValue )
            // InternalYangParser.g:4633:5: lv_range_1_0= ruleStringValue
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getFractionDigitsAccess().getRangeStringValueParserRuleCall_1_0());
              				
            }
            pushFollow(FOLLOW_5);
            lv_range_1_0=ruleStringValue();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getFractionDigitsRule());
              					}
              					set(
              						current,
              						"range",
              						lv_range_1_0,
              						"io.typefox.yang.Yang.StringValue");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            if ( state.backtracking==0 ) {

              			if (current==null) {
              				current = createModelElement(grammarAccess.getFractionDigitsRule());
              			}
              			newCompositeNode(grammarAccess.getFractionDigitsAccess().getStatementEndParserRuleCall_2());
              		
            }
            pushFollow(FOLLOW_2);
            this_StatementEnd_2=ruleStatementEnd(current);

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current = this_StatementEnd_2;
              			afterParserOrEnumRuleCall();
              		
            }

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleFractionDigits"


    // $ANTLR start "entryRuleLength"
    // InternalYangParser.g:4665:1: entryRuleLength returns [EObject current=null] : iv_ruleLength= ruleLength EOF ;
    public final EObject entryRuleLength() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLength = null;


        try {
            // InternalYangParser.g:4665:47: (iv_ruleLength= ruleLength EOF )
            // InternalYangParser.g:4666:2: iv_ruleLength= ruleLength EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getLengthRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleLength=ruleLength();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleLength; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleLength"


    // $ANTLR start "ruleLength"
    // InternalYangParser.g:4672:1: ruleLength returns [EObject current=null] : (otherlv_0= Length ( (lv_expression_1_0= ruleRefinementExpression ) ) this_StatementEnd_2= ruleStatementEnd[$current] ) ;
    public final EObject ruleLength() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        EObject lv_expression_1_0 = null;

        EObject this_StatementEnd_2 = null;



        	enterRule();

        try {
            // InternalYangParser.g:4678:2: ( (otherlv_0= Length ( (lv_expression_1_0= ruleRefinementExpression ) ) this_StatementEnd_2= ruleStatementEnd[$current] ) )
            // InternalYangParser.g:4679:2: (otherlv_0= Length ( (lv_expression_1_0= ruleRefinementExpression ) ) this_StatementEnd_2= ruleStatementEnd[$current] )
            {
            // InternalYangParser.g:4679:2: (otherlv_0= Length ( (lv_expression_1_0= ruleRefinementExpression ) ) this_StatementEnd_2= ruleStatementEnd[$current] )
            // InternalYangParser.g:4680:3: otherlv_0= Length ( (lv_expression_1_0= ruleRefinementExpression ) ) this_StatementEnd_2= ruleStatementEnd[$current]
            {
            otherlv_0=(Token)match(input,Length,FOLLOW_16); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getLengthAccess().getLengthKeyword_0());
              		
            }
            // InternalYangParser.g:4684:3: ( (lv_expression_1_0= ruleRefinementExpression ) )
            // InternalYangParser.g:4685:4: (lv_expression_1_0= ruleRefinementExpression )
            {
            // InternalYangParser.g:4685:4: (lv_expression_1_0= ruleRefinementExpression )
            // InternalYangParser.g:4686:5: lv_expression_1_0= ruleRefinementExpression
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getLengthAccess().getExpressionRefinementExpressionParserRuleCall_1_0());
              				
            }
            pushFollow(FOLLOW_5);
            lv_expression_1_0=ruleRefinementExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getLengthRule());
              					}
              					set(
              						current,
              						"expression",
              						lv_expression_1_0,
              						"io.typefox.yang.Yang.RefinementExpression");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            if ( state.backtracking==0 ) {

              			if (current==null) {
              				current = createModelElement(grammarAccess.getLengthRule());
              			}
              			newCompositeNode(grammarAccess.getLengthAccess().getStatementEndParserRuleCall_2());
              		
            }
            pushFollow(FOLLOW_2);
            this_StatementEnd_2=ruleStatementEnd(current);

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current = this_StatementEnd_2;
              			afterParserOrEnumRuleCall();
              		
            }

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleLength"


    // $ANTLR start "entryRulePattern"
    // InternalYangParser.g:4718:1: entryRulePattern returns [EObject current=null] : iv_rulePattern= rulePattern EOF ;
    public final EObject entryRulePattern() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePattern = null;


        try {
            // InternalYangParser.g:4718:48: (iv_rulePattern= rulePattern EOF )
            // InternalYangParser.g:4719:2: iv_rulePattern= rulePattern EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getPatternRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_rulePattern=rulePattern();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_rulePattern; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulePattern"


    // $ANTLR start "rulePattern"
    // InternalYangParser.g:4725:1: rulePattern returns [EObject current=null] : (otherlv_0= Pattern ( (lv_regexp_1_0= ruleStringValue ) ) this_StatementEnd_2= ruleStatementEnd[$current] ) ;
    public final EObject rulePattern() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        AntlrDatatypeRuleToken lv_regexp_1_0 = null;

        EObject this_StatementEnd_2 = null;



        	enterRule();

        try {
            // InternalYangParser.g:4731:2: ( (otherlv_0= Pattern ( (lv_regexp_1_0= ruleStringValue ) ) this_StatementEnd_2= ruleStatementEnd[$current] ) )
            // InternalYangParser.g:4732:2: (otherlv_0= Pattern ( (lv_regexp_1_0= ruleStringValue ) ) this_StatementEnd_2= ruleStatementEnd[$current] )
            {
            // InternalYangParser.g:4732:2: (otherlv_0= Pattern ( (lv_regexp_1_0= ruleStringValue ) ) this_StatementEnd_2= ruleStatementEnd[$current] )
            // InternalYangParser.g:4733:3: otherlv_0= Pattern ( (lv_regexp_1_0= ruleStringValue ) ) this_StatementEnd_2= ruleStatementEnd[$current]
            {
            otherlv_0=(Token)match(input,Pattern,FOLLOW_4); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getPatternAccess().getPatternKeyword_0());
              		
            }
            // InternalYangParser.g:4737:3: ( (lv_regexp_1_0= ruleStringValue ) )
            // InternalYangParser.g:4738:4: (lv_regexp_1_0= ruleStringValue )
            {
            // InternalYangParser.g:4738:4: (lv_regexp_1_0= ruleStringValue )
            // InternalYangParser.g:4739:5: lv_regexp_1_0= ruleStringValue
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getPatternAccess().getRegexpStringValueParserRuleCall_1_0());
              				
            }
            pushFollow(FOLLOW_5);
            lv_regexp_1_0=ruleStringValue();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getPatternRule());
              					}
              					set(
              						current,
              						"regexp",
              						lv_regexp_1_0,
              						"io.typefox.yang.Yang.StringValue");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            if ( state.backtracking==0 ) {

              			if (current==null) {
              				current = createModelElement(grammarAccess.getPatternRule());
              			}
              			newCompositeNode(grammarAccess.getPatternAccess().getStatementEndParserRuleCall_2());
              		
            }
            pushFollow(FOLLOW_2);
            this_StatementEnd_2=ruleStatementEnd(current);

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current = this_StatementEnd_2;
              			afterParserOrEnumRuleCall();
              		
            }

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "rulePattern"


    // $ANTLR start "entryRuleModifier"
    // InternalYangParser.g:4771:1: entryRuleModifier returns [EObject current=null] : iv_ruleModifier= ruleModifier EOF ;
    public final EObject entryRuleModifier() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleModifier = null;


        try {
            // InternalYangParser.g:4771:49: (iv_ruleModifier= ruleModifier EOF )
            // InternalYangParser.g:4772:2: iv_ruleModifier= ruleModifier EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getModifierRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleModifier=ruleModifier();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleModifier; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleModifier"


    // $ANTLR start "ruleModifier"
    // InternalYangParser.g:4778:1: ruleModifier returns [EObject current=null] : (otherlv_0= Modifier ( (lv_modifier_1_0= ruleStringValue ) ) this_StatementEnd_2= ruleStatementEnd[$current] ) ;
    public final EObject ruleModifier() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        AntlrDatatypeRuleToken lv_modifier_1_0 = null;

        EObject this_StatementEnd_2 = null;



        	enterRule();

        try {
            // InternalYangParser.g:4784:2: ( (otherlv_0= Modifier ( (lv_modifier_1_0= ruleStringValue ) ) this_StatementEnd_2= ruleStatementEnd[$current] ) )
            // InternalYangParser.g:4785:2: (otherlv_0= Modifier ( (lv_modifier_1_0= ruleStringValue ) ) this_StatementEnd_2= ruleStatementEnd[$current] )
            {
            // InternalYangParser.g:4785:2: (otherlv_0= Modifier ( (lv_modifier_1_0= ruleStringValue ) ) this_StatementEnd_2= ruleStatementEnd[$current] )
            // InternalYangParser.g:4786:3: otherlv_0= Modifier ( (lv_modifier_1_0= ruleStringValue ) ) this_StatementEnd_2= ruleStatementEnd[$current]
            {
            otherlv_0=(Token)match(input,Modifier,FOLLOW_4); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getModifierAccess().getModifierKeyword_0());
              		
            }
            // InternalYangParser.g:4790:3: ( (lv_modifier_1_0= ruleStringValue ) )
            // InternalYangParser.g:4791:4: (lv_modifier_1_0= ruleStringValue )
            {
            // InternalYangParser.g:4791:4: (lv_modifier_1_0= ruleStringValue )
            // InternalYangParser.g:4792:5: lv_modifier_1_0= ruleStringValue
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getModifierAccess().getModifierStringValueParserRuleCall_1_0());
              				
            }
            pushFollow(FOLLOW_5);
            lv_modifier_1_0=ruleStringValue();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getModifierRule());
              					}
              					set(
              						current,
              						"modifier",
              						lv_modifier_1_0,
              						"io.typefox.yang.Yang.StringValue");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            if ( state.backtracking==0 ) {

              			if (current==null) {
              				current = createModelElement(grammarAccess.getModifierRule());
              			}
              			newCompositeNode(grammarAccess.getModifierAccess().getStatementEndParserRuleCall_2());
              		
            }
            pushFollow(FOLLOW_2);
            this_StatementEnd_2=ruleStatementEnd(current);

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current = this_StatementEnd_2;
              			afterParserOrEnumRuleCall();
              		
            }

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleModifier"


    // $ANTLR start "entryRuleEnum"
    // InternalYangParser.g:4824:1: entryRuleEnum returns [EObject current=null] : iv_ruleEnum= ruleEnum EOF ;
    public final EObject entryRuleEnum() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEnum = null;


        try {
            // InternalYangParser.g:4824:45: (iv_ruleEnum= ruleEnum EOF )
            // InternalYangParser.g:4825:2: iv_ruleEnum= ruleEnum EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getEnumRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleEnum=ruleEnum();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleEnum; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleEnum"


    // $ANTLR start "ruleEnum"
    // InternalYangParser.g:4831:1: ruleEnum returns [EObject current=null] : (otherlv_0= Enum ( (lv_name_1_0= ruleStringValue ) ) this_StatementEnd_2= ruleStatementEnd[$current] ) ;
    public final EObject ruleEnum() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        AntlrDatatypeRuleToken lv_name_1_0 = null;

        EObject this_StatementEnd_2 = null;



        	enterRule();

        try {
            // InternalYangParser.g:4837:2: ( (otherlv_0= Enum ( (lv_name_1_0= ruleStringValue ) ) this_StatementEnd_2= ruleStatementEnd[$current] ) )
            // InternalYangParser.g:4838:2: (otherlv_0= Enum ( (lv_name_1_0= ruleStringValue ) ) this_StatementEnd_2= ruleStatementEnd[$current] )
            {
            // InternalYangParser.g:4838:2: (otherlv_0= Enum ( (lv_name_1_0= ruleStringValue ) ) this_StatementEnd_2= ruleStatementEnd[$current] )
            // InternalYangParser.g:4839:3: otherlv_0= Enum ( (lv_name_1_0= ruleStringValue ) ) this_StatementEnd_2= ruleStatementEnd[$current]
            {
            otherlv_0=(Token)match(input,Enum,FOLLOW_4); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getEnumAccess().getEnumKeyword_0());
              		
            }
            // InternalYangParser.g:4843:3: ( (lv_name_1_0= ruleStringValue ) )
            // InternalYangParser.g:4844:4: (lv_name_1_0= ruleStringValue )
            {
            // InternalYangParser.g:4844:4: (lv_name_1_0= ruleStringValue )
            // InternalYangParser.g:4845:5: lv_name_1_0= ruleStringValue
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getEnumAccess().getNameStringValueParserRuleCall_1_0());
              				
            }
            pushFollow(FOLLOW_5);
            lv_name_1_0=ruleStringValue();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getEnumRule());
              					}
              					set(
              						current,
              						"name",
              						lv_name_1_0,
              						"io.typefox.yang.Yang.StringValue");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            if ( state.backtracking==0 ) {

              			if (current==null) {
              				current = createModelElement(grammarAccess.getEnumRule());
              			}
              			newCompositeNode(grammarAccess.getEnumAccess().getStatementEndParserRuleCall_2());
              		
            }
            pushFollow(FOLLOW_2);
            this_StatementEnd_2=ruleStatementEnd(current);

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current = this_StatementEnd_2;
              			afterParserOrEnumRuleCall();
              		
            }

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleEnum"


    // $ANTLR start "entryRuleValue"
    // InternalYangParser.g:4877:1: entryRuleValue returns [EObject current=null] : iv_ruleValue= ruleValue EOF ;
    public final EObject entryRuleValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleValue = null;


        try {
            // InternalYangParser.g:4877:46: (iv_ruleValue= ruleValue EOF )
            // InternalYangParser.g:4878:2: iv_ruleValue= ruleValue EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getValueRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleValue=ruleValue();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleValue; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleValue"


    // $ANTLR start "ruleValue"
    // InternalYangParser.g:4884:1: ruleValue returns [EObject current=null] : (otherlv_0= Value ( (lv_ordinal_1_0= ruleStringValue ) ) this_StatementEnd_2= ruleStatementEnd[$current] ) ;
    public final EObject ruleValue() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        AntlrDatatypeRuleToken lv_ordinal_1_0 = null;

        EObject this_StatementEnd_2 = null;



        	enterRule();

        try {
            // InternalYangParser.g:4890:2: ( (otherlv_0= Value ( (lv_ordinal_1_0= ruleStringValue ) ) this_StatementEnd_2= ruleStatementEnd[$current] ) )
            // InternalYangParser.g:4891:2: (otherlv_0= Value ( (lv_ordinal_1_0= ruleStringValue ) ) this_StatementEnd_2= ruleStatementEnd[$current] )
            {
            // InternalYangParser.g:4891:2: (otherlv_0= Value ( (lv_ordinal_1_0= ruleStringValue ) ) this_StatementEnd_2= ruleStatementEnd[$current] )
            // InternalYangParser.g:4892:3: otherlv_0= Value ( (lv_ordinal_1_0= ruleStringValue ) ) this_StatementEnd_2= ruleStatementEnd[$current]
            {
            otherlv_0=(Token)match(input,Value,FOLLOW_4); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getValueAccess().getValueKeyword_0());
              		
            }
            // InternalYangParser.g:4896:3: ( (lv_ordinal_1_0= ruleStringValue ) )
            // InternalYangParser.g:4897:4: (lv_ordinal_1_0= ruleStringValue )
            {
            // InternalYangParser.g:4897:4: (lv_ordinal_1_0= ruleStringValue )
            // InternalYangParser.g:4898:5: lv_ordinal_1_0= ruleStringValue
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getValueAccess().getOrdinalStringValueParserRuleCall_1_0());
              				
            }
            pushFollow(FOLLOW_5);
            lv_ordinal_1_0=ruleStringValue();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getValueRule());
              					}
              					set(
              						current,
              						"ordinal",
              						lv_ordinal_1_0,
              						"io.typefox.yang.Yang.StringValue");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            if ( state.backtracking==0 ) {

              			if (current==null) {
              				current = createModelElement(grammarAccess.getValueRule());
              			}
              			newCompositeNode(grammarAccess.getValueAccess().getStatementEndParserRuleCall_2());
              		
            }
            pushFollow(FOLLOW_2);
            this_StatementEnd_2=ruleStatementEnd(current);

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current = this_StatementEnd_2;
              			afterParserOrEnumRuleCall();
              		
            }

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleValue"


    // $ANTLR start "entryRuleBit"
    // InternalYangParser.g:4930:1: entryRuleBit returns [EObject current=null] : iv_ruleBit= ruleBit EOF ;
    public final EObject entryRuleBit() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBit = null;


        try {
            // InternalYangParser.g:4930:44: (iv_ruleBit= ruleBit EOF )
            // InternalYangParser.g:4931:2: iv_ruleBit= ruleBit EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getBitRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleBit=ruleBit();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleBit; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleBit"


    // $ANTLR start "ruleBit"
    // InternalYangParser.g:4937:1: ruleBit returns [EObject current=null] : (otherlv_0= Bit ( (lv_name_1_0= ruleStringValue ) ) this_StatementEnd_2= ruleStatementEnd[$current] ) ;
    public final EObject ruleBit() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        AntlrDatatypeRuleToken lv_name_1_0 = null;

        EObject this_StatementEnd_2 = null;



        	enterRule();

        try {
            // InternalYangParser.g:4943:2: ( (otherlv_0= Bit ( (lv_name_1_0= ruleStringValue ) ) this_StatementEnd_2= ruleStatementEnd[$current] ) )
            // InternalYangParser.g:4944:2: (otherlv_0= Bit ( (lv_name_1_0= ruleStringValue ) ) this_StatementEnd_2= ruleStatementEnd[$current] )
            {
            // InternalYangParser.g:4944:2: (otherlv_0= Bit ( (lv_name_1_0= ruleStringValue ) ) this_StatementEnd_2= ruleStatementEnd[$current] )
            // InternalYangParser.g:4945:3: otherlv_0= Bit ( (lv_name_1_0= ruleStringValue ) ) this_StatementEnd_2= ruleStatementEnd[$current]
            {
            otherlv_0=(Token)match(input,Bit,FOLLOW_4); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getBitAccess().getBitKeyword_0());
              		
            }
            // InternalYangParser.g:4949:3: ( (lv_name_1_0= ruleStringValue ) )
            // InternalYangParser.g:4950:4: (lv_name_1_0= ruleStringValue )
            {
            // InternalYangParser.g:4950:4: (lv_name_1_0= ruleStringValue )
            // InternalYangParser.g:4951:5: lv_name_1_0= ruleStringValue
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getBitAccess().getNameStringValueParserRuleCall_1_0());
              				
            }
            pushFollow(FOLLOW_5);
            lv_name_1_0=ruleStringValue();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getBitRule());
              					}
              					set(
              						current,
              						"name",
              						lv_name_1_0,
              						"io.typefox.yang.Yang.StringValue");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            if ( state.backtracking==0 ) {

              			if (current==null) {
              				current = createModelElement(grammarAccess.getBitRule());
              			}
              			newCompositeNode(grammarAccess.getBitAccess().getStatementEndParserRuleCall_2());
              		
            }
            pushFollow(FOLLOW_2);
            this_StatementEnd_2=ruleStatementEnd(current);

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current = this_StatementEnd_2;
              			afterParserOrEnumRuleCall();
              		
            }

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleBit"


    // $ANTLR start "entryRulePosition"
    // InternalYangParser.g:4983:1: entryRulePosition returns [EObject current=null] : iv_rulePosition= rulePosition EOF ;
    public final EObject entryRulePosition() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePosition = null;


        try {
            // InternalYangParser.g:4983:49: (iv_rulePosition= rulePosition EOF )
            // InternalYangParser.g:4984:2: iv_rulePosition= rulePosition EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getPositionRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_rulePosition=rulePosition();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_rulePosition; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulePosition"


    // $ANTLR start "rulePosition"
    // InternalYangParser.g:4990:1: rulePosition returns [EObject current=null] : (otherlv_0= Position ( (lv_ordinal_1_0= ruleStringValue ) ) this_StatementEnd_2= ruleStatementEnd[$current] ) ;
    public final EObject rulePosition() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        AntlrDatatypeRuleToken lv_ordinal_1_0 = null;

        EObject this_StatementEnd_2 = null;



        	enterRule();

        try {
            // InternalYangParser.g:4996:2: ( (otherlv_0= Position ( (lv_ordinal_1_0= ruleStringValue ) ) this_StatementEnd_2= ruleStatementEnd[$current] ) )
            // InternalYangParser.g:4997:2: (otherlv_0= Position ( (lv_ordinal_1_0= ruleStringValue ) ) this_StatementEnd_2= ruleStatementEnd[$current] )
            {
            // InternalYangParser.g:4997:2: (otherlv_0= Position ( (lv_ordinal_1_0= ruleStringValue ) ) this_StatementEnd_2= ruleStatementEnd[$current] )
            // InternalYangParser.g:4998:3: otherlv_0= Position ( (lv_ordinal_1_0= ruleStringValue ) ) this_StatementEnd_2= ruleStatementEnd[$current]
            {
            otherlv_0=(Token)match(input,Position,FOLLOW_4); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getPositionAccess().getPositionKeyword_0());
              		
            }
            // InternalYangParser.g:5002:3: ( (lv_ordinal_1_0= ruleStringValue ) )
            // InternalYangParser.g:5003:4: (lv_ordinal_1_0= ruleStringValue )
            {
            // InternalYangParser.g:5003:4: (lv_ordinal_1_0= ruleStringValue )
            // InternalYangParser.g:5004:5: lv_ordinal_1_0= ruleStringValue
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getPositionAccess().getOrdinalStringValueParserRuleCall_1_0());
              				
            }
            pushFollow(FOLLOW_5);
            lv_ordinal_1_0=ruleStringValue();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getPositionRule());
              					}
              					set(
              						current,
              						"ordinal",
              						lv_ordinal_1_0,
              						"io.typefox.yang.Yang.StringValue");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            if ( state.backtracking==0 ) {

              			if (current==null) {
              				current = createModelElement(grammarAccess.getPositionRule());
              			}
              			newCompositeNode(grammarAccess.getPositionAccess().getStatementEndParserRuleCall_2());
              		
            }
            pushFollow(FOLLOW_2);
            this_StatementEnd_2=ruleStatementEnd(current);

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current = this_StatementEnd_2;
              			afterParserOrEnumRuleCall();
              		
            }

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "rulePosition"


    // $ANTLR start "entryRulePath"
    // InternalYangParser.g:5036:1: entryRulePath returns [EObject current=null] : iv_rulePath= rulePath EOF ;
    public final EObject entryRulePath() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePath = null;


        try {
            // InternalYangParser.g:5036:45: (iv_rulePath= rulePath EOF )
            // InternalYangParser.g:5037:2: iv_rulePath= rulePath EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getPathRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_rulePath=rulePath();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_rulePath; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulePath"


    // $ANTLR start "rulePath"
    // InternalYangParser.g:5043:1: rulePath returns [EObject current=null] : (otherlv_0= Path ( (lv_reference_1_0= ruleXpathExpression ) ) this_StatementEnd_2= ruleStatementEnd[$current] ) ;
    public final EObject rulePath() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        EObject lv_reference_1_0 = null;

        EObject this_StatementEnd_2 = null;



        	enterRule();

        try {
            // InternalYangParser.g:5049:2: ( (otherlv_0= Path ( (lv_reference_1_0= ruleXpathExpression ) ) this_StatementEnd_2= ruleStatementEnd[$current] ) )
            // InternalYangParser.g:5050:2: (otherlv_0= Path ( (lv_reference_1_0= ruleXpathExpression ) ) this_StatementEnd_2= ruleStatementEnd[$current] )
            {
            // InternalYangParser.g:5050:2: (otherlv_0= Path ( (lv_reference_1_0= ruleXpathExpression ) ) this_StatementEnd_2= ruleStatementEnd[$current] )
            // InternalYangParser.g:5051:3: otherlv_0= Path ( (lv_reference_1_0= ruleXpathExpression ) ) this_StatementEnd_2= ruleStatementEnd[$current]
            {
            otherlv_0=(Token)match(input,Path,FOLLOW_7); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getPathAccess().getPathKeyword_0());
              		
            }
            // InternalYangParser.g:5055:3: ( (lv_reference_1_0= ruleXpathExpression ) )
            // InternalYangParser.g:5056:4: (lv_reference_1_0= ruleXpathExpression )
            {
            // InternalYangParser.g:5056:4: (lv_reference_1_0= ruleXpathExpression )
            // InternalYangParser.g:5057:5: lv_reference_1_0= ruleXpathExpression
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getPathAccess().getReferenceXpathExpressionParserRuleCall_1_0());
              				
            }
            pushFollow(FOLLOW_5);
            lv_reference_1_0=ruleXpathExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getPathRule());
              					}
              					set(
              						current,
              						"reference",
              						lv_reference_1_0,
              						"io.typefox.yang.Yang.XpathExpression");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            if ( state.backtracking==0 ) {

              			if (current==null) {
              				current = createModelElement(grammarAccess.getPathRule());
              			}
              			newCompositeNode(grammarAccess.getPathAccess().getStatementEndParserRuleCall_2());
              		
            }
            pushFollow(FOLLOW_2);
            this_StatementEnd_2=ruleStatementEnd(current);

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current = this_StatementEnd_2;
              			afterParserOrEnumRuleCall();
              		
            }

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "rulePath"


    // $ANTLR start "entryRuleRequireInstance"
    // InternalYangParser.g:5089:1: entryRuleRequireInstance returns [EObject current=null] : iv_ruleRequireInstance= ruleRequireInstance EOF ;
    public final EObject entryRuleRequireInstance() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRequireInstance = null;


        try {
            // InternalYangParser.g:5089:56: (iv_ruleRequireInstance= ruleRequireInstance EOF )
            // InternalYangParser.g:5090:2: iv_ruleRequireInstance= ruleRequireInstance EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getRequireInstanceRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleRequireInstance=ruleRequireInstance();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleRequireInstance; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleRequireInstance"


    // $ANTLR start "ruleRequireInstance"
    // InternalYangParser.g:5096:1: ruleRequireInstance returns [EObject current=null] : (otherlv_0= RequireInstance ( (lv_isRequireInstance_1_0= ruleStringValue ) ) this_StatementEnd_2= ruleStatementEnd[$current] ) ;
    public final EObject ruleRequireInstance() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        AntlrDatatypeRuleToken lv_isRequireInstance_1_0 = null;

        EObject this_StatementEnd_2 = null;



        	enterRule();

        try {
            // InternalYangParser.g:5102:2: ( (otherlv_0= RequireInstance ( (lv_isRequireInstance_1_0= ruleStringValue ) ) this_StatementEnd_2= ruleStatementEnd[$current] ) )
            // InternalYangParser.g:5103:2: (otherlv_0= RequireInstance ( (lv_isRequireInstance_1_0= ruleStringValue ) ) this_StatementEnd_2= ruleStatementEnd[$current] )
            {
            // InternalYangParser.g:5103:2: (otherlv_0= RequireInstance ( (lv_isRequireInstance_1_0= ruleStringValue ) ) this_StatementEnd_2= ruleStatementEnd[$current] )
            // InternalYangParser.g:5104:3: otherlv_0= RequireInstance ( (lv_isRequireInstance_1_0= ruleStringValue ) ) this_StatementEnd_2= ruleStatementEnd[$current]
            {
            otherlv_0=(Token)match(input,RequireInstance,FOLLOW_4); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getRequireInstanceAccess().getRequireInstanceKeyword_0());
              		
            }
            // InternalYangParser.g:5108:3: ( (lv_isRequireInstance_1_0= ruleStringValue ) )
            // InternalYangParser.g:5109:4: (lv_isRequireInstance_1_0= ruleStringValue )
            {
            // InternalYangParser.g:5109:4: (lv_isRequireInstance_1_0= ruleStringValue )
            // InternalYangParser.g:5110:5: lv_isRequireInstance_1_0= ruleStringValue
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getRequireInstanceAccess().getIsRequireInstanceStringValueParserRuleCall_1_0());
              				
            }
            pushFollow(FOLLOW_5);
            lv_isRequireInstance_1_0=ruleStringValue();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getRequireInstanceRule());
              					}
              					set(
              						current,
              						"isRequireInstance",
              						lv_isRequireInstance_1_0,
              						"io.typefox.yang.Yang.StringValue");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            if ( state.backtracking==0 ) {

              			if (current==null) {
              				current = createModelElement(grammarAccess.getRequireInstanceRule());
              			}
              			newCompositeNode(grammarAccess.getRequireInstanceAccess().getStatementEndParserRuleCall_2());
              		
            }
            pushFollow(FOLLOW_2);
            this_StatementEnd_2=ruleStatementEnd(current);

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current = this_StatementEnd_2;
              			afterParserOrEnumRuleCall();
              		
            }

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleRequireInstance"


    // $ANTLR start "entryRuleUnknown"
    // InternalYangParser.g:5142:1: entryRuleUnknown returns [EObject current=null] : iv_ruleUnknown= ruleUnknown EOF ;
    public final EObject entryRuleUnknown() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleUnknown = null;


        try {
            // InternalYangParser.g:5142:48: (iv_ruleUnknown= ruleUnknown EOF )
            // InternalYangParser.g:5143:2: iv_ruleUnknown= ruleUnknown EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getUnknownRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleUnknown=ruleUnknown();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleUnknown; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleUnknown"


    // $ANTLR start "ruleUnknown"
    // InternalYangParser.g:5149:1: ruleUnknown returns [EObject current=null] : ( ( (otherlv_0= RULE_EXTENSION_NAME ) ) ( (lv_name_1_0= ruleStringValue ) )? this_StatementEnd_2= ruleStatementEnd[$current] ) ;
    public final EObject ruleUnknown() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        AntlrDatatypeRuleToken lv_name_1_0 = null;

        EObject this_StatementEnd_2 = null;



        	enterRule();

        try {
            // InternalYangParser.g:5155:2: ( ( ( (otherlv_0= RULE_EXTENSION_NAME ) ) ( (lv_name_1_0= ruleStringValue ) )? this_StatementEnd_2= ruleStatementEnd[$current] ) )
            // InternalYangParser.g:5156:2: ( ( (otherlv_0= RULE_EXTENSION_NAME ) ) ( (lv_name_1_0= ruleStringValue ) )? this_StatementEnd_2= ruleStatementEnd[$current] )
            {
            // InternalYangParser.g:5156:2: ( ( (otherlv_0= RULE_EXTENSION_NAME ) ) ( (lv_name_1_0= ruleStringValue ) )? this_StatementEnd_2= ruleStatementEnd[$current] )
            // InternalYangParser.g:5157:3: ( (otherlv_0= RULE_EXTENSION_NAME ) ) ( (lv_name_1_0= ruleStringValue ) )? this_StatementEnd_2= ruleStatementEnd[$current]
            {
            // InternalYangParser.g:5157:3: ( (otherlv_0= RULE_EXTENSION_NAME ) )
            // InternalYangParser.g:5158:4: (otherlv_0= RULE_EXTENSION_NAME )
            {
            // InternalYangParser.g:5158:4: (otherlv_0= RULE_EXTENSION_NAME )
            // InternalYangParser.g:5159:5: otherlv_0= RULE_EXTENSION_NAME
            {
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElement(grammarAccess.getUnknownRule());
              					}
              				
            }
            otherlv_0=(Token)match(input,RULE_EXTENSION_NAME,FOLLOW_11); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					newLeafNode(otherlv_0, grammarAccess.getUnknownAccess().getExtensionExtensionCrossReference_0_0());
              				
            }

            }


            }

            // InternalYangParser.g:5170:3: ( (lv_name_1_0= ruleStringValue ) )?
            int alt23=2;
            int LA23_0 = input.LA(1);

            if ( (LA23_0==RULE_STRING) ) {
                alt23=1;
            }
            switch (alt23) {
                case 1 :
                    // InternalYangParser.g:5171:4: (lv_name_1_0= ruleStringValue )
                    {
                    // InternalYangParser.g:5171:4: (lv_name_1_0= ruleStringValue )
                    // InternalYangParser.g:5172:5: lv_name_1_0= ruleStringValue
                    {
                    if ( state.backtracking==0 ) {

                      					newCompositeNode(grammarAccess.getUnknownAccess().getNameStringValueParserRuleCall_1_0());
                      				
                    }
                    pushFollow(FOLLOW_5);
                    lv_name_1_0=ruleStringValue();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					if (current==null) {
                      						current = createModelElementForParent(grammarAccess.getUnknownRule());
                      					}
                      					set(
                      						current,
                      						"name",
                      						lv_name_1_0,
                      						"io.typefox.yang.Yang.StringValue");
                      					afterParserOrEnumRuleCall();
                      				
                    }

                    }


                    }
                    break;

            }

            if ( state.backtracking==0 ) {

              			if (current==null) {
              				current = createModelElement(grammarAccess.getUnknownRule());
              			}
              			newCompositeNode(grammarAccess.getUnknownAccess().getStatementEndParserRuleCall_2());
              		
            }
            pushFollow(FOLLOW_2);
            this_StatementEnd_2=ruleStatementEnd(current);

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current = this_StatementEnd_2;
              			afterParserOrEnumRuleCall();
              		
            }

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleUnknown"


    // $ANTLR start "entryRuleDescendantSchemaNodeIdentifier"
    // InternalYangParser.g:5204:1: entryRuleDescendantSchemaNodeIdentifier returns [EObject current=null] : iv_ruleDescendantSchemaNodeIdentifier= ruleDescendantSchemaNodeIdentifier EOF ;
    public final EObject entryRuleDescendantSchemaNodeIdentifier() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDescendantSchemaNodeIdentifier = null;


        try {
            // InternalYangParser.g:5204:71: (iv_ruleDescendantSchemaNodeIdentifier= ruleDescendantSchemaNodeIdentifier EOF )
            // InternalYangParser.g:5205:2: iv_ruleDescendantSchemaNodeIdentifier= ruleDescendantSchemaNodeIdentifier EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getDescendantSchemaNodeIdentifierRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleDescendantSchemaNodeIdentifier=ruleDescendantSchemaNodeIdentifier();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleDescendantSchemaNodeIdentifier; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleDescendantSchemaNodeIdentifier"


    // $ANTLR start "ruleDescendantSchemaNodeIdentifier"
    // InternalYangParser.g:5211:1: ruleDescendantSchemaNodeIdentifier returns [EObject current=null] : (this_DescendantRootSchemaNodeIdentifier_0= ruleDescendantRootSchemaNodeIdentifier ( () otherlv_2= Solidus ( ( ruleQNAME ) ) )* ) ;
    public final EObject ruleDescendantSchemaNodeIdentifier() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        EObject this_DescendantRootSchemaNodeIdentifier_0 = null;



        	enterRule();

        try {
            // InternalYangParser.g:5217:2: ( (this_DescendantRootSchemaNodeIdentifier_0= ruleDescendantRootSchemaNodeIdentifier ( () otherlv_2= Solidus ( ( ruleQNAME ) ) )* ) )
            // InternalYangParser.g:5218:2: (this_DescendantRootSchemaNodeIdentifier_0= ruleDescendantRootSchemaNodeIdentifier ( () otherlv_2= Solidus ( ( ruleQNAME ) ) )* )
            {
            // InternalYangParser.g:5218:2: (this_DescendantRootSchemaNodeIdentifier_0= ruleDescendantRootSchemaNodeIdentifier ( () otherlv_2= Solidus ( ( ruleQNAME ) ) )* )
            // InternalYangParser.g:5219:3: this_DescendantRootSchemaNodeIdentifier_0= ruleDescendantRootSchemaNodeIdentifier ( () otherlv_2= Solidus ( ( ruleQNAME ) ) )*
            {
            if ( state.backtracking==0 ) {

              			newCompositeNode(grammarAccess.getDescendantSchemaNodeIdentifierAccess().getDescendantRootSchemaNodeIdentifierParserRuleCall_0());
              		
            }
            pushFollow(FOLLOW_19);
            this_DescendantRootSchemaNodeIdentifier_0=ruleDescendantRootSchemaNodeIdentifier();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current = this_DescendantRootSchemaNodeIdentifier_0;
              			afterParserOrEnumRuleCall();
              		
            }
            // InternalYangParser.g:5227:3: ( () otherlv_2= Solidus ( ( ruleQNAME ) ) )*
            loop24:
            do {
                int alt24=2;
                int LA24_0 = input.LA(1);

                if ( (LA24_0==Solidus) ) {
                    alt24=1;
                }


                switch (alt24) {
            	case 1 :
            	    // InternalYangParser.g:5228:4: () otherlv_2= Solidus ( ( ruleQNAME ) )
            	    {
            	    // InternalYangParser.g:5228:4: ()
            	    // InternalYangParser.g:5229:5: 
            	    {
            	    if ( state.backtracking==0 ) {

            	      					current = forceCreateModelElementAndSet(
            	      						grammarAccess.getDescendantSchemaNodeIdentifierAccess().getSchemaNodeIdentifierTargetAction_1_0(),
            	      						current);
            	      				
            	    }

            	    }

            	    otherlv_2=(Token)match(input,Solidus,FOLLOW_6); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      				newLeafNode(otherlv_2, grammarAccess.getDescendantSchemaNodeIdentifierAccess().getSolidusKeyword_1_1());
            	      			
            	    }
            	    // InternalYangParser.g:5239:4: ( ( ruleQNAME ) )
            	    // InternalYangParser.g:5240:5: ( ruleQNAME )
            	    {
            	    // InternalYangParser.g:5240:5: ( ruleQNAME )
            	    // InternalYangParser.g:5241:6: ruleQNAME
            	    {
            	    if ( state.backtracking==0 ) {

            	      						if (current==null) {
            	      							current = createModelElement(grammarAccess.getDescendantSchemaNodeIdentifierRule());
            	      						}
            	      					
            	    }
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getDescendantSchemaNodeIdentifierAccess().getSchemaNodeSchemaNodeCrossReference_1_2_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_19);
            	    ruleQNAME();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      						afterParserOrEnumRuleCall();
            	      					
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop24;
                }
            } while (true);


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleDescendantSchemaNodeIdentifier"


    // $ANTLR start "entryRuleDescendantRootSchemaNodeIdentifier"
    // InternalYangParser.g:5260:1: entryRuleDescendantRootSchemaNodeIdentifier returns [EObject current=null] : iv_ruleDescendantRootSchemaNodeIdentifier= ruleDescendantRootSchemaNodeIdentifier EOF ;
    public final EObject entryRuleDescendantRootSchemaNodeIdentifier() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDescendantRootSchemaNodeIdentifier = null;


        try {
            // InternalYangParser.g:5260:75: (iv_ruleDescendantRootSchemaNodeIdentifier= ruleDescendantRootSchemaNodeIdentifier EOF )
            // InternalYangParser.g:5261:2: iv_ruleDescendantRootSchemaNodeIdentifier= ruleDescendantRootSchemaNodeIdentifier EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getDescendantRootSchemaNodeIdentifierRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleDescendantRootSchemaNodeIdentifier=ruleDescendantRootSchemaNodeIdentifier();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleDescendantRootSchemaNodeIdentifier; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleDescendantRootSchemaNodeIdentifier"


    // $ANTLR start "ruleDescendantRootSchemaNodeIdentifier"
    // InternalYangParser.g:5267:1: ruleDescendantRootSchemaNodeIdentifier returns [EObject current=null] : ( ( ruleQNAME ) ) ;
    public final EObject ruleDescendantRootSchemaNodeIdentifier() throws RecognitionException {
        EObject current = null;


        	enterRule();

        try {
            // InternalYangParser.g:5273:2: ( ( ( ruleQNAME ) ) )
            // InternalYangParser.g:5274:2: ( ( ruleQNAME ) )
            {
            // InternalYangParser.g:5274:2: ( ( ruleQNAME ) )
            // InternalYangParser.g:5275:3: ( ruleQNAME )
            {
            // InternalYangParser.g:5275:3: ( ruleQNAME )
            // InternalYangParser.g:5276:4: ruleQNAME
            {
            if ( state.backtracking==0 ) {

              				if (current==null) {
              					current = createModelElement(grammarAccess.getDescendantRootSchemaNodeIdentifierRule());
              				}
              			
            }
            if ( state.backtracking==0 ) {

              				newCompositeNode(grammarAccess.getDescendantRootSchemaNodeIdentifierAccess().getSchemaNodeSchemaNodeCrossReference_0());
              			
            }
            pushFollow(FOLLOW_2);
            ruleQNAME();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              				afterParserOrEnumRuleCall();
              			
            }

            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleDescendantRootSchemaNodeIdentifier"


    // $ANTLR start "entryRuleSchemaNodeIdentifier"
    // InternalYangParser.g:5293:1: entryRuleSchemaNodeIdentifier returns [EObject current=null] : iv_ruleSchemaNodeIdentifier= ruleSchemaNodeIdentifier EOF ;
    public final EObject entryRuleSchemaNodeIdentifier() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSchemaNodeIdentifier = null;


        try {
            // InternalYangParser.g:5293:61: (iv_ruleSchemaNodeIdentifier= ruleSchemaNodeIdentifier EOF )
            // InternalYangParser.g:5294:2: iv_ruleSchemaNodeIdentifier= ruleSchemaNodeIdentifier EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getSchemaNodeIdentifierRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleSchemaNodeIdentifier=ruleSchemaNodeIdentifier();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleSchemaNodeIdentifier; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleSchemaNodeIdentifier"


    // $ANTLR start "ruleSchemaNodeIdentifier"
    // InternalYangParser.g:5300:1: ruleSchemaNodeIdentifier returns [EObject current=null] : (this_RootSchemaNodeIdentifier_0= ruleRootSchemaNodeIdentifier ( () otherlv_2= Solidus ( ( ruleQNAME ) ) )* ) ;
    public final EObject ruleSchemaNodeIdentifier() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        EObject this_RootSchemaNodeIdentifier_0 = null;



        	enterRule();

        try {
            // InternalYangParser.g:5306:2: ( (this_RootSchemaNodeIdentifier_0= ruleRootSchemaNodeIdentifier ( () otherlv_2= Solidus ( ( ruleQNAME ) ) )* ) )
            // InternalYangParser.g:5307:2: (this_RootSchemaNodeIdentifier_0= ruleRootSchemaNodeIdentifier ( () otherlv_2= Solidus ( ( ruleQNAME ) ) )* )
            {
            // InternalYangParser.g:5307:2: (this_RootSchemaNodeIdentifier_0= ruleRootSchemaNodeIdentifier ( () otherlv_2= Solidus ( ( ruleQNAME ) ) )* )
            // InternalYangParser.g:5308:3: this_RootSchemaNodeIdentifier_0= ruleRootSchemaNodeIdentifier ( () otherlv_2= Solidus ( ( ruleQNAME ) ) )*
            {
            if ( state.backtracking==0 ) {

              			newCompositeNode(grammarAccess.getSchemaNodeIdentifierAccess().getRootSchemaNodeIdentifierParserRuleCall_0());
              		
            }
            pushFollow(FOLLOW_19);
            this_RootSchemaNodeIdentifier_0=ruleRootSchemaNodeIdentifier();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current = this_RootSchemaNodeIdentifier_0;
              			afterParserOrEnumRuleCall();
              		
            }
            // InternalYangParser.g:5316:3: ( () otherlv_2= Solidus ( ( ruleQNAME ) ) )*
            loop25:
            do {
                int alt25=2;
                int LA25_0 = input.LA(1);

                if ( (LA25_0==Solidus) ) {
                    alt25=1;
                }


                switch (alt25) {
            	case 1 :
            	    // InternalYangParser.g:5317:4: () otherlv_2= Solidus ( ( ruleQNAME ) )
            	    {
            	    // InternalYangParser.g:5317:4: ()
            	    // InternalYangParser.g:5318:5: 
            	    {
            	    if ( state.backtracking==0 ) {

            	      					current = forceCreateModelElementAndSet(
            	      						grammarAccess.getSchemaNodeIdentifierAccess().getSchemaNodeIdentifierTargetAction_1_0(),
            	      						current);
            	      				
            	    }

            	    }

            	    otherlv_2=(Token)match(input,Solidus,FOLLOW_6); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      				newLeafNode(otherlv_2, grammarAccess.getSchemaNodeIdentifierAccess().getSolidusKeyword_1_1());
            	      			
            	    }
            	    // InternalYangParser.g:5328:4: ( ( ruleQNAME ) )
            	    // InternalYangParser.g:5329:5: ( ruleQNAME )
            	    {
            	    // InternalYangParser.g:5329:5: ( ruleQNAME )
            	    // InternalYangParser.g:5330:6: ruleQNAME
            	    {
            	    if ( state.backtracking==0 ) {

            	      						if (current==null) {
            	      							current = createModelElement(grammarAccess.getSchemaNodeIdentifierRule());
            	      						}
            	      					
            	    }
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getSchemaNodeIdentifierAccess().getSchemaNodeSchemaNodeCrossReference_1_2_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_19);
            	    ruleQNAME();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      						afterParserOrEnumRuleCall();
            	      					
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop25;
                }
            } while (true);


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleSchemaNodeIdentifier"


    // $ANTLR start "entryRuleRootSchemaNodeIdentifier"
    // InternalYangParser.g:5349:1: entryRuleRootSchemaNodeIdentifier returns [EObject current=null] : iv_ruleRootSchemaNodeIdentifier= ruleRootSchemaNodeIdentifier EOF ;
    public final EObject entryRuleRootSchemaNodeIdentifier() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRootSchemaNodeIdentifier = null;


        try {
            // InternalYangParser.g:5349:65: (iv_ruleRootSchemaNodeIdentifier= ruleRootSchemaNodeIdentifier EOF )
            // InternalYangParser.g:5350:2: iv_ruleRootSchemaNodeIdentifier= ruleRootSchemaNodeIdentifier EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getRootSchemaNodeIdentifierRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleRootSchemaNodeIdentifier=ruleRootSchemaNodeIdentifier();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleRootSchemaNodeIdentifier; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleRootSchemaNodeIdentifier"


    // $ANTLR start "ruleRootSchemaNodeIdentifier"
    // InternalYangParser.g:5356:1: ruleRootSchemaNodeIdentifier returns [EObject current=null] : ( ( (lv_isAbsolute_0_0= Solidus ) )? ( ( ruleQNAME ) ) ) ;
    public final EObject ruleRootSchemaNodeIdentifier() throws RecognitionException {
        EObject current = null;

        Token lv_isAbsolute_0_0=null;


        	enterRule();

        try {
            // InternalYangParser.g:5362:2: ( ( ( (lv_isAbsolute_0_0= Solidus ) )? ( ( ruleQNAME ) ) ) )
            // InternalYangParser.g:5363:2: ( ( (lv_isAbsolute_0_0= Solidus ) )? ( ( ruleQNAME ) ) )
            {
            // InternalYangParser.g:5363:2: ( ( (lv_isAbsolute_0_0= Solidus ) )? ( ( ruleQNAME ) ) )
            // InternalYangParser.g:5364:3: ( (lv_isAbsolute_0_0= Solidus ) )? ( ( ruleQNAME ) )
            {
            // InternalYangParser.g:5364:3: ( (lv_isAbsolute_0_0= Solidus ) )?
            int alt26=2;
            int LA26_0 = input.LA(1);

            if ( (LA26_0==Solidus) ) {
                alt26=1;
            }
            switch (alt26) {
                case 1 :
                    // InternalYangParser.g:5365:4: (lv_isAbsolute_0_0= Solidus )
                    {
                    // InternalYangParser.g:5365:4: (lv_isAbsolute_0_0= Solidus )
                    // InternalYangParser.g:5366:5: lv_isAbsolute_0_0= Solidus
                    {
                    lv_isAbsolute_0_0=(Token)match(input,Solidus,FOLLOW_6); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					newLeafNode(lv_isAbsolute_0_0, grammarAccess.getRootSchemaNodeIdentifierAccess().getIsAbsoluteSolidusKeyword_0_0());
                      				
                    }
                    if ( state.backtracking==0 ) {

                      					if (current==null) {
                      						current = createModelElement(grammarAccess.getRootSchemaNodeIdentifierRule());
                      					}
                      					setWithLastConsumed(current, "isAbsolute", true, "/");
                      				
                    }

                    }


                    }
                    break;

            }

            // InternalYangParser.g:5378:3: ( ( ruleQNAME ) )
            // InternalYangParser.g:5379:4: ( ruleQNAME )
            {
            // InternalYangParser.g:5379:4: ( ruleQNAME )
            // InternalYangParser.g:5380:5: ruleQNAME
            {
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElement(grammarAccess.getRootSchemaNodeIdentifierRule());
              					}
              				
            }
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getRootSchemaNodeIdentifierAccess().getSchemaNodeSchemaNodeCrossReference_1_0());
              				
            }
            pushFollow(FOLLOW_2);
            ruleQNAME();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					afterParserOrEnumRuleCall();
              				
            }

            }


            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleRootSchemaNodeIdentifier"


    // $ANTLR start "entryRuleGroupingRef"
    // InternalYangParser.g:5398:1: entryRuleGroupingRef returns [EObject current=null] : iv_ruleGroupingRef= ruleGroupingRef EOF ;
    public final EObject entryRuleGroupingRef() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleGroupingRef = null;


        try {
            // InternalYangParser.g:5398:52: (iv_ruleGroupingRef= ruleGroupingRef EOF )
            // InternalYangParser.g:5399:2: iv_ruleGroupingRef= ruleGroupingRef EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getGroupingRefRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleGroupingRef=ruleGroupingRef();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleGroupingRef; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleGroupingRef"


    // $ANTLR start "ruleGroupingRef"
    // InternalYangParser.g:5405:1: ruleGroupingRef returns [EObject current=null] : ( ( ruleQNAME ) ) ;
    public final EObject ruleGroupingRef() throws RecognitionException {
        EObject current = null;


        	enterRule();

        try {
            // InternalYangParser.g:5411:2: ( ( ( ruleQNAME ) ) )
            // InternalYangParser.g:5412:2: ( ( ruleQNAME ) )
            {
            // InternalYangParser.g:5412:2: ( ( ruleQNAME ) )
            // InternalYangParser.g:5413:3: ( ruleQNAME )
            {
            // InternalYangParser.g:5413:3: ( ruleQNAME )
            // InternalYangParser.g:5414:4: ruleQNAME
            {
            if ( state.backtracking==0 ) {

              				if (current==null) {
              					current = createModelElement(grammarAccess.getGroupingRefRule());
              				}
              			
            }
            if ( state.backtracking==0 ) {

              				newCompositeNode(grammarAccess.getGroupingRefAccess().getNodeGroupingCrossReference_0());
              			
            }
            pushFollow(FOLLOW_2);
            ruleQNAME();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              				afterParserOrEnumRuleCall();
              			
            }

            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleGroupingRef"


    // $ANTLR start "entryRuleXpathExpression"
    // InternalYangParser.g:5431:1: entryRuleXpathExpression returns [EObject current=null] : iv_ruleXpathExpression= ruleXpathExpression EOF ;
    public final EObject entryRuleXpathExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXpathExpression = null;


        try {
            // InternalYangParser.g:5431:56: (iv_ruleXpathExpression= ruleXpathExpression EOF )
            // InternalYangParser.g:5432:2: iv_ruleXpathExpression= ruleXpathExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXpathExpressionRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleXpathExpression=ruleXpathExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXpathExpression; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleXpathExpression"


    // $ANTLR start "ruleXpathExpression"
    // InternalYangParser.g:5438:1: ruleXpathExpression returns [EObject current=null] : ( ( () otherlv_1= LessThanSignLessThanSignLessThanSignLessThanSign ( (lv_text_2_0= RULE_STRING ) ) otherlv_3= GreaterThanSignGreaterThanSignGreaterThanSignGreaterThanSign ) | this_ParsedXpathExpression_4= ruleParsedXpathExpression ) ;
    public final EObject ruleXpathExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token lv_text_2_0=null;
        Token otherlv_3=null;
        EObject this_ParsedXpathExpression_4 = null;



        	enterRule();

        try {
            // InternalYangParser.g:5444:2: ( ( ( () otherlv_1= LessThanSignLessThanSignLessThanSignLessThanSign ( (lv_text_2_0= RULE_STRING ) ) otherlv_3= GreaterThanSignGreaterThanSignGreaterThanSignGreaterThanSign ) | this_ParsedXpathExpression_4= ruleParsedXpathExpression ) )
            // InternalYangParser.g:5445:2: ( ( () otherlv_1= LessThanSignLessThanSignLessThanSignLessThanSign ( (lv_text_2_0= RULE_STRING ) ) otherlv_3= GreaterThanSignGreaterThanSignGreaterThanSignGreaterThanSign ) | this_ParsedXpathExpression_4= ruleParsedXpathExpression )
            {
            // InternalYangParser.g:5445:2: ( ( () otherlv_1= LessThanSignLessThanSignLessThanSignLessThanSign ( (lv_text_2_0= RULE_STRING ) ) otherlv_3= GreaterThanSignGreaterThanSignGreaterThanSignGreaterThanSign ) | this_ParsedXpathExpression_4= ruleParsedXpathExpression )
            int alt27=2;
            int LA27_0 = input.LA(1);

            if ( (LA27_0==LessThanSignLessThanSignLessThanSignLessThanSign) ) {
                alt27=1;
            }
            else if ( ((LA27_0>=ProcessingInstruction && LA27_0<=Value)||(LA27_0>=Base && LA27_0<=Mod)||LA27_0==Rpc||LA27_0==FullStopFullStop||(LA27_0>=Or && LA27_0<=LeftParenthesis)||LA27_0==Asterisk||(LA27_0>=HyphenMinus && LA27_0<=Solidus)||LA27_0==CommercialAt||LA27_0==RULE_ID||(LA27_0>=RULE_STRING && LA27_0<=RULE_NUMBER)) ) {
                alt27=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 27, 0, input);

                throw nvae;
            }
            switch (alt27) {
                case 1 :
                    // InternalYangParser.g:5446:3: ( () otherlv_1= LessThanSignLessThanSignLessThanSignLessThanSign ( (lv_text_2_0= RULE_STRING ) ) otherlv_3= GreaterThanSignGreaterThanSignGreaterThanSignGreaterThanSign )
                    {
                    // InternalYangParser.g:5446:3: ( () otherlv_1= LessThanSignLessThanSignLessThanSignLessThanSign ( (lv_text_2_0= RULE_STRING ) ) otherlv_3= GreaterThanSignGreaterThanSignGreaterThanSignGreaterThanSign )
                    // InternalYangParser.g:5447:4: () otherlv_1= LessThanSignLessThanSignLessThanSignLessThanSign ( (lv_text_2_0= RULE_STRING ) ) otherlv_3= GreaterThanSignGreaterThanSignGreaterThanSignGreaterThanSign
                    {
                    // InternalYangParser.g:5447:4: ()
                    // InternalYangParser.g:5448:5: 
                    {
                    if ( state.backtracking==0 ) {

                      					current = forceCreateModelElement(
                      						grammarAccess.getXpathExpressionAccess().getUnparsedXpathAction_0_0(),
                      						current);
                      				
                    }

                    }

                    otherlv_1=(Token)match(input,LessThanSignLessThanSignLessThanSignLessThanSign,FOLLOW_4); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_1, grammarAccess.getXpathExpressionAccess().getLessThanSignLessThanSignLessThanSignLessThanSignKeyword_0_1());
                      			
                    }
                    // InternalYangParser.g:5458:4: ( (lv_text_2_0= RULE_STRING ) )
                    // InternalYangParser.g:5459:5: (lv_text_2_0= RULE_STRING )
                    {
                    // InternalYangParser.g:5459:5: (lv_text_2_0= RULE_STRING )
                    // InternalYangParser.g:5460:6: lv_text_2_0= RULE_STRING
                    {
                    lv_text_2_0=(Token)match(input,RULE_STRING,FOLLOW_20); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						newLeafNode(lv_text_2_0, grammarAccess.getXpathExpressionAccess().getTextSTRINGTerminalRuleCall_0_2_0());
                      					
                    }
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElement(grammarAccess.getXpathExpressionRule());
                      						}
                      						setWithLastConsumed(
                      							current,
                      							"text",
                      							lv_text_2_0,
                      							"io.typefox.yang.Yang.STRING");
                      					
                    }

                    }


                    }

                    otherlv_3=(Token)match(input,GreaterThanSignGreaterThanSignGreaterThanSignGreaterThanSign,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_3, grammarAccess.getXpathExpressionAccess().getGreaterThanSignGreaterThanSignGreaterThanSignGreaterThanSignKeyword_0_3());
                      			
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalYangParser.g:5482:3: this_ParsedXpathExpression_4= ruleParsedXpathExpression
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getXpathExpressionAccess().getParsedXpathExpressionParserRuleCall_1());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_ParsedXpathExpression_4=ruleParsedXpathExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_ParsedXpathExpression_4;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleXpathExpression"


    // $ANTLR start "entryRuleParsedXpathExpression"
    // InternalYangParser.g:5494:1: entryRuleParsedXpathExpression returns [EObject current=null] : iv_ruleParsedXpathExpression= ruleParsedXpathExpression EOF ;
    public final EObject entryRuleParsedXpathExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParsedXpathExpression = null;


        try {
            // InternalYangParser.g:5494:62: (iv_ruleParsedXpathExpression= ruleParsedXpathExpression EOF )
            // InternalYangParser.g:5495:2: iv_ruleParsedXpathExpression= ruleParsedXpathExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getParsedXpathExpressionRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleParsedXpathExpression=ruleParsedXpathExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleParsedXpathExpression; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleParsedXpathExpression"


    // $ANTLR start "ruleParsedXpathExpression"
    // InternalYangParser.g:5501:1: ruleParsedXpathExpression returns [EObject current=null] : this_XpathOrExpr_0= ruleXpathOrExpr ;
    public final EObject ruleParsedXpathExpression() throws RecognitionException {
        EObject current = null;

        EObject this_XpathOrExpr_0 = null;



        	enterRule();

        try {
            // InternalYangParser.g:5507:2: (this_XpathOrExpr_0= ruleXpathOrExpr )
            // InternalYangParser.g:5508:2: this_XpathOrExpr_0= ruleXpathOrExpr
            {
            if ( state.backtracking==0 ) {

              		newCompositeNode(grammarAccess.getParsedXpathExpressionAccess().getXpathOrExprParserRuleCall());
              	
            }
            pushFollow(FOLLOW_2);
            this_XpathOrExpr_0=ruleXpathOrExpr();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              		current = this_XpathOrExpr_0;
              		afterParserOrEnumRuleCall();
              	
            }

            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleParsedXpathExpression"


    // $ANTLR start "entryRuleXpathOrExpr"
    // InternalYangParser.g:5519:1: entryRuleXpathOrExpr returns [EObject current=null] : iv_ruleXpathOrExpr= ruleXpathOrExpr EOF ;
    public final EObject entryRuleXpathOrExpr() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXpathOrExpr = null;


        try {
            // InternalYangParser.g:5519:52: (iv_ruleXpathOrExpr= ruleXpathOrExpr EOF )
            // InternalYangParser.g:5520:2: iv_ruleXpathOrExpr= ruleXpathOrExpr EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXpathOrExprRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleXpathOrExpr=ruleXpathOrExpr();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXpathOrExpr; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleXpathOrExpr"


    // $ANTLR start "ruleXpathOrExpr"
    // InternalYangParser.g:5526:1: ruleXpathOrExpr returns [EObject current=null] : (this_XpathAndExpr_0= ruleXpathAndExpr ( () ( (lv_operator_2_0= Or ) ) ( (lv_right_3_0= ruleXpathAndExpr ) ) )* ) ;
    public final EObject ruleXpathOrExpr() throws RecognitionException {
        EObject current = null;

        Token lv_operator_2_0=null;
        EObject this_XpathAndExpr_0 = null;

        EObject lv_right_3_0 = null;



        	enterRule();

        try {
            // InternalYangParser.g:5532:2: ( (this_XpathAndExpr_0= ruleXpathAndExpr ( () ( (lv_operator_2_0= Or ) ) ( (lv_right_3_0= ruleXpathAndExpr ) ) )* ) )
            // InternalYangParser.g:5533:2: (this_XpathAndExpr_0= ruleXpathAndExpr ( () ( (lv_operator_2_0= Or ) ) ( (lv_right_3_0= ruleXpathAndExpr ) ) )* )
            {
            // InternalYangParser.g:5533:2: (this_XpathAndExpr_0= ruleXpathAndExpr ( () ( (lv_operator_2_0= Or ) ) ( (lv_right_3_0= ruleXpathAndExpr ) ) )* )
            // InternalYangParser.g:5534:3: this_XpathAndExpr_0= ruleXpathAndExpr ( () ( (lv_operator_2_0= Or ) ) ( (lv_right_3_0= ruleXpathAndExpr ) ) )*
            {
            if ( state.backtracking==0 ) {

              			newCompositeNode(grammarAccess.getXpathOrExprAccess().getXpathAndExprParserRuleCall_0());
              		
            }
            pushFollow(FOLLOW_13);
            this_XpathAndExpr_0=ruleXpathAndExpr();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current = this_XpathAndExpr_0;
              			afterParserOrEnumRuleCall();
              		
            }
            // InternalYangParser.g:5542:3: ( () ( (lv_operator_2_0= Or ) ) ( (lv_right_3_0= ruleXpathAndExpr ) ) )*
            loop28:
            do {
                int alt28=2;
                int LA28_0 = input.LA(1);

                if ( (LA28_0==Or) ) {
                    alt28=1;
                }


                switch (alt28) {
            	case 1 :
            	    // InternalYangParser.g:5543:4: () ( (lv_operator_2_0= Or ) ) ( (lv_right_3_0= ruleXpathAndExpr ) )
            	    {
            	    // InternalYangParser.g:5543:4: ()
            	    // InternalYangParser.g:5544:5: 
            	    {
            	    if ( state.backtracking==0 ) {

            	      					current = forceCreateModelElementAndSet(
            	      						grammarAccess.getXpathOrExprAccess().getXpathOrOperationLeftAction_1_0(),
            	      						current);
            	      				
            	    }

            	    }

            	    // InternalYangParser.g:5550:4: ( (lv_operator_2_0= Or ) )
            	    // InternalYangParser.g:5551:5: (lv_operator_2_0= Or )
            	    {
            	    // InternalYangParser.g:5551:5: (lv_operator_2_0= Or )
            	    // InternalYangParser.g:5552:6: lv_operator_2_0= Or
            	    {
            	    lv_operator_2_0=(Token)match(input,Or,FOLLOW_7); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      						newLeafNode(lv_operator_2_0, grammarAccess.getXpathOrExprAccess().getOperatorOrKeyword_1_1_0());
            	      					
            	    }
            	    if ( state.backtracking==0 ) {

            	      						if (current==null) {
            	      							current = createModelElement(grammarAccess.getXpathOrExprRule());
            	      						}
            	      						setWithLastConsumed(current, "operator", lv_operator_2_0, "or");
            	      					
            	    }

            	    }


            	    }

            	    // InternalYangParser.g:5564:4: ( (lv_right_3_0= ruleXpathAndExpr ) )
            	    // InternalYangParser.g:5565:5: (lv_right_3_0= ruleXpathAndExpr )
            	    {
            	    // InternalYangParser.g:5565:5: (lv_right_3_0= ruleXpathAndExpr )
            	    // InternalYangParser.g:5566:6: lv_right_3_0= ruleXpathAndExpr
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getXpathOrExprAccess().getRightXpathAndExprParserRuleCall_1_2_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_13);
            	    lv_right_3_0=ruleXpathAndExpr();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      						if (current==null) {
            	      							current = createModelElementForParent(grammarAccess.getXpathOrExprRule());
            	      						}
            	      						set(
            	      							current,
            	      							"right",
            	      							lv_right_3_0,
            	      							"io.typefox.yang.Yang.XpathAndExpr");
            	      						afterParserOrEnumRuleCall();
            	      					
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop28;
                }
            } while (true);


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleXpathOrExpr"


    // $ANTLR start "entryRuleXpathAndExpr"
    // InternalYangParser.g:5588:1: entryRuleXpathAndExpr returns [EObject current=null] : iv_ruleXpathAndExpr= ruleXpathAndExpr EOF ;
    public final EObject entryRuleXpathAndExpr() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXpathAndExpr = null;


        try {
            // InternalYangParser.g:5588:53: (iv_ruleXpathAndExpr= ruleXpathAndExpr EOF )
            // InternalYangParser.g:5589:2: iv_ruleXpathAndExpr= ruleXpathAndExpr EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXpathAndExprRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleXpathAndExpr=ruleXpathAndExpr();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXpathAndExpr; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleXpathAndExpr"


    // $ANTLR start "ruleXpathAndExpr"
    // InternalYangParser.g:5595:1: ruleXpathAndExpr returns [EObject current=null] : (this_XpathEqualityExpr_0= ruleXpathEqualityExpr ( () ( (lv_operator_2_0= And ) ) ( (lv_right_3_0= ruleXpathEqualityExpr ) ) )* ) ;
    public final EObject ruleXpathAndExpr() throws RecognitionException {
        EObject current = null;

        Token lv_operator_2_0=null;
        EObject this_XpathEqualityExpr_0 = null;

        EObject lv_right_3_0 = null;



        	enterRule();

        try {
            // InternalYangParser.g:5601:2: ( (this_XpathEqualityExpr_0= ruleXpathEqualityExpr ( () ( (lv_operator_2_0= And ) ) ( (lv_right_3_0= ruleXpathEqualityExpr ) ) )* ) )
            // InternalYangParser.g:5602:2: (this_XpathEqualityExpr_0= ruleXpathEqualityExpr ( () ( (lv_operator_2_0= And ) ) ( (lv_right_3_0= ruleXpathEqualityExpr ) ) )* )
            {
            // InternalYangParser.g:5602:2: (this_XpathEqualityExpr_0= ruleXpathEqualityExpr ( () ( (lv_operator_2_0= And ) ) ( (lv_right_3_0= ruleXpathEqualityExpr ) ) )* )
            // InternalYangParser.g:5603:3: this_XpathEqualityExpr_0= ruleXpathEqualityExpr ( () ( (lv_operator_2_0= And ) ) ( (lv_right_3_0= ruleXpathEqualityExpr ) ) )*
            {
            if ( state.backtracking==0 ) {

              			newCompositeNode(grammarAccess.getXpathAndExprAccess().getXpathEqualityExprParserRuleCall_0());
              		
            }
            pushFollow(FOLLOW_14);
            this_XpathEqualityExpr_0=ruleXpathEqualityExpr();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current = this_XpathEqualityExpr_0;
              			afterParserOrEnumRuleCall();
              		
            }
            // InternalYangParser.g:5611:3: ( () ( (lv_operator_2_0= And ) ) ( (lv_right_3_0= ruleXpathEqualityExpr ) ) )*
            loop29:
            do {
                int alt29=2;
                int LA29_0 = input.LA(1);

                if ( (LA29_0==And) ) {
                    alt29=1;
                }


                switch (alt29) {
            	case 1 :
            	    // InternalYangParser.g:5612:4: () ( (lv_operator_2_0= And ) ) ( (lv_right_3_0= ruleXpathEqualityExpr ) )
            	    {
            	    // InternalYangParser.g:5612:4: ()
            	    // InternalYangParser.g:5613:5: 
            	    {
            	    if ( state.backtracking==0 ) {

            	      					current = forceCreateModelElementAndSet(
            	      						grammarAccess.getXpathAndExprAccess().getXpathAndOperationLeftAction_1_0(),
            	      						current);
            	      				
            	    }

            	    }

            	    // InternalYangParser.g:5619:4: ( (lv_operator_2_0= And ) )
            	    // InternalYangParser.g:5620:5: (lv_operator_2_0= And )
            	    {
            	    // InternalYangParser.g:5620:5: (lv_operator_2_0= And )
            	    // InternalYangParser.g:5621:6: lv_operator_2_0= And
            	    {
            	    lv_operator_2_0=(Token)match(input,And,FOLLOW_7); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      						newLeafNode(lv_operator_2_0, grammarAccess.getXpathAndExprAccess().getOperatorAndKeyword_1_1_0());
            	      					
            	    }
            	    if ( state.backtracking==0 ) {

            	      						if (current==null) {
            	      							current = createModelElement(grammarAccess.getXpathAndExprRule());
            	      						}
            	      						setWithLastConsumed(current, "operator", lv_operator_2_0, "and");
            	      					
            	    }

            	    }


            	    }

            	    // InternalYangParser.g:5633:4: ( (lv_right_3_0= ruleXpathEqualityExpr ) )
            	    // InternalYangParser.g:5634:5: (lv_right_3_0= ruleXpathEqualityExpr )
            	    {
            	    // InternalYangParser.g:5634:5: (lv_right_3_0= ruleXpathEqualityExpr )
            	    // InternalYangParser.g:5635:6: lv_right_3_0= ruleXpathEqualityExpr
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getXpathAndExprAccess().getRightXpathEqualityExprParserRuleCall_1_2_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_14);
            	    lv_right_3_0=ruleXpathEqualityExpr();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      						if (current==null) {
            	      							current = createModelElementForParent(grammarAccess.getXpathAndExprRule());
            	      						}
            	      						set(
            	      							current,
            	      							"right",
            	      							lv_right_3_0,
            	      							"io.typefox.yang.Yang.XpathEqualityExpr");
            	      						afterParserOrEnumRuleCall();
            	      					
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop29;
                }
            } while (true);


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleXpathAndExpr"


    // $ANTLR start "entryRuleXpathEqualityExpr"
    // InternalYangParser.g:5657:1: entryRuleXpathEqualityExpr returns [EObject current=null] : iv_ruleXpathEqualityExpr= ruleXpathEqualityExpr EOF ;
    public final EObject entryRuleXpathEqualityExpr() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXpathEqualityExpr = null;


        try {
            // InternalYangParser.g:5657:58: (iv_ruleXpathEqualityExpr= ruleXpathEqualityExpr EOF )
            // InternalYangParser.g:5658:2: iv_ruleXpathEqualityExpr= ruleXpathEqualityExpr EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXpathEqualityExprRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleXpathEqualityExpr=ruleXpathEqualityExpr();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXpathEqualityExpr; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleXpathEqualityExpr"


    // $ANTLR start "ruleXpathEqualityExpr"
    // InternalYangParser.g:5664:1: ruleXpathEqualityExpr returns [EObject current=null] : (this_XpathRelationalExpr_0= ruleXpathRelationalExpr ( () ( ( (lv_operator_2_1= EqualsSign | lv_operator_2_2= ExclamationMarkEqualsSign ) ) ) ( (lv_right_3_0= ruleXpathRelationalExpr ) ) )* ) ;
    public final EObject ruleXpathEqualityExpr() throws RecognitionException {
        EObject current = null;

        Token lv_operator_2_1=null;
        Token lv_operator_2_2=null;
        EObject this_XpathRelationalExpr_0 = null;

        EObject lv_right_3_0 = null;



        	enterRule();

        try {
            // InternalYangParser.g:5670:2: ( (this_XpathRelationalExpr_0= ruleXpathRelationalExpr ( () ( ( (lv_operator_2_1= EqualsSign | lv_operator_2_2= ExclamationMarkEqualsSign ) ) ) ( (lv_right_3_0= ruleXpathRelationalExpr ) ) )* ) )
            // InternalYangParser.g:5671:2: (this_XpathRelationalExpr_0= ruleXpathRelationalExpr ( () ( ( (lv_operator_2_1= EqualsSign | lv_operator_2_2= ExclamationMarkEqualsSign ) ) ) ( (lv_right_3_0= ruleXpathRelationalExpr ) ) )* )
            {
            // InternalYangParser.g:5671:2: (this_XpathRelationalExpr_0= ruleXpathRelationalExpr ( () ( ( (lv_operator_2_1= EqualsSign | lv_operator_2_2= ExclamationMarkEqualsSign ) ) ) ( (lv_right_3_0= ruleXpathRelationalExpr ) ) )* )
            // InternalYangParser.g:5672:3: this_XpathRelationalExpr_0= ruleXpathRelationalExpr ( () ( ( (lv_operator_2_1= EqualsSign | lv_operator_2_2= ExclamationMarkEqualsSign ) ) ) ( (lv_right_3_0= ruleXpathRelationalExpr ) ) )*
            {
            if ( state.backtracking==0 ) {

              			newCompositeNode(grammarAccess.getXpathEqualityExprAccess().getXpathRelationalExprParserRuleCall_0());
              		
            }
            pushFollow(FOLLOW_21);
            this_XpathRelationalExpr_0=ruleXpathRelationalExpr();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current = this_XpathRelationalExpr_0;
              			afterParserOrEnumRuleCall();
              		
            }
            // InternalYangParser.g:5680:3: ( () ( ( (lv_operator_2_1= EqualsSign | lv_operator_2_2= ExclamationMarkEqualsSign ) ) ) ( (lv_right_3_0= ruleXpathRelationalExpr ) ) )*
            loop31:
            do {
                int alt31=2;
                int LA31_0 = input.LA(1);

                if ( (LA31_0==ExclamationMarkEqualsSign||LA31_0==EqualsSign) ) {
                    alt31=1;
                }


                switch (alt31) {
            	case 1 :
            	    // InternalYangParser.g:5681:4: () ( ( (lv_operator_2_1= EqualsSign | lv_operator_2_2= ExclamationMarkEqualsSign ) ) ) ( (lv_right_3_0= ruleXpathRelationalExpr ) )
            	    {
            	    // InternalYangParser.g:5681:4: ()
            	    // InternalYangParser.g:5682:5: 
            	    {
            	    if ( state.backtracking==0 ) {

            	      					current = forceCreateModelElementAndSet(
            	      						grammarAccess.getXpathEqualityExprAccess().getXpathEqualityOperationLeftAction_1_0(),
            	      						current);
            	      				
            	    }

            	    }

            	    // InternalYangParser.g:5688:4: ( ( (lv_operator_2_1= EqualsSign | lv_operator_2_2= ExclamationMarkEqualsSign ) ) )
            	    // InternalYangParser.g:5689:5: ( (lv_operator_2_1= EqualsSign | lv_operator_2_2= ExclamationMarkEqualsSign ) )
            	    {
            	    // InternalYangParser.g:5689:5: ( (lv_operator_2_1= EqualsSign | lv_operator_2_2= ExclamationMarkEqualsSign ) )
            	    // InternalYangParser.g:5690:6: (lv_operator_2_1= EqualsSign | lv_operator_2_2= ExclamationMarkEqualsSign )
            	    {
            	    // InternalYangParser.g:5690:6: (lv_operator_2_1= EqualsSign | lv_operator_2_2= ExclamationMarkEqualsSign )
            	    int alt30=2;
            	    int LA30_0 = input.LA(1);

            	    if ( (LA30_0==EqualsSign) ) {
            	        alt30=1;
            	    }
            	    else if ( (LA30_0==ExclamationMarkEqualsSign) ) {
            	        alt30=2;
            	    }
            	    else {
            	        if (state.backtracking>0) {state.failed=true; return current;}
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 30, 0, input);

            	        throw nvae;
            	    }
            	    switch (alt30) {
            	        case 1 :
            	            // InternalYangParser.g:5691:7: lv_operator_2_1= EqualsSign
            	            {
            	            lv_operator_2_1=(Token)match(input,EqualsSign,FOLLOW_7); if (state.failed) return current;
            	            if ( state.backtracking==0 ) {

            	              							newLeafNode(lv_operator_2_1, grammarAccess.getXpathEqualityExprAccess().getOperatorEqualsSignKeyword_1_1_0_0());
            	              						
            	            }
            	            if ( state.backtracking==0 ) {

            	              							if (current==null) {
            	              								current = createModelElement(grammarAccess.getXpathEqualityExprRule());
            	              							}
            	              							setWithLastConsumed(current, "operator", lv_operator_2_1, null);
            	              						
            	            }

            	            }
            	            break;
            	        case 2 :
            	            // InternalYangParser.g:5702:7: lv_operator_2_2= ExclamationMarkEqualsSign
            	            {
            	            lv_operator_2_2=(Token)match(input,ExclamationMarkEqualsSign,FOLLOW_7); if (state.failed) return current;
            	            if ( state.backtracking==0 ) {

            	              							newLeafNode(lv_operator_2_2, grammarAccess.getXpathEqualityExprAccess().getOperatorExclamationMarkEqualsSignKeyword_1_1_0_1());
            	              						
            	            }
            	            if ( state.backtracking==0 ) {

            	              							if (current==null) {
            	              								current = createModelElement(grammarAccess.getXpathEqualityExprRule());
            	              							}
            	              							setWithLastConsumed(current, "operator", lv_operator_2_2, null);
            	              						
            	            }

            	            }
            	            break;

            	    }


            	    }


            	    }

            	    // InternalYangParser.g:5715:4: ( (lv_right_3_0= ruleXpathRelationalExpr ) )
            	    // InternalYangParser.g:5716:5: (lv_right_3_0= ruleXpathRelationalExpr )
            	    {
            	    // InternalYangParser.g:5716:5: (lv_right_3_0= ruleXpathRelationalExpr )
            	    // InternalYangParser.g:5717:6: lv_right_3_0= ruleXpathRelationalExpr
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getXpathEqualityExprAccess().getRightXpathRelationalExprParserRuleCall_1_2_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_21);
            	    lv_right_3_0=ruleXpathRelationalExpr();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      						if (current==null) {
            	      							current = createModelElementForParent(grammarAccess.getXpathEqualityExprRule());
            	      						}
            	      						set(
            	      							current,
            	      							"right",
            	      							lv_right_3_0,
            	      							"io.typefox.yang.Yang.XpathRelationalExpr");
            	      						afterParserOrEnumRuleCall();
            	      					
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop31;
                }
            } while (true);


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleXpathEqualityExpr"


    // $ANTLR start "entryRuleXpathRelationalExpr"
    // InternalYangParser.g:5739:1: entryRuleXpathRelationalExpr returns [EObject current=null] : iv_ruleXpathRelationalExpr= ruleXpathRelationalExpr EOF ;
    public final EObject entryRuleXpathRelationalExpr() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXpathRelationalExpr = null;


        try {
            // InternalYangParser.g:5739:60: (iv_ruleXpathRelationalExpr= ruleXpathRelationalExpr EOF )
            // InternalYangParser.g:5740:2: iv_ruleXpathRelationalExpr= ruleXpathRelationalExpr EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXpathRelationalExprRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleXpathRelationalExpr=ruleXpathRelationalExpr();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXpathRelationalExpr; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleXpathRelationalExpr"


    // $ANTLR start "ruleXpathRelationalExpr"
    // InternalYangParser.g:5746:1: ruleXpathRelationalExpr returns [EObject current=null] : (this_XpathAdditiveExpr_0= ruleXpathAdditiveExpr ( () ( ( (lv_operator_2_1= LessThanSign | lv_operator_2_2= GreaterThanSign | lv_operator_2_3= LessThanSignEqualsSign | lv_operator_2_4= GreaterThanSignEqualsSign ) ) ) ( (lv_right_3_0= ruleXpathAdditiveExpr ) ) )* ) ;
    public final EObject ruleXpathRelationalExpr() throws RecognitionException {
        EObject current = null;

        Token lv_operator_2_1=null;
        Token lv_operator_2_2=null;
        Token lv_operator_2_3=null;
        Token lv_operator_2_4=null;
        EObject this_XpathAdditiveExpr_0 = null;

        EObject lv_right_3_0 = null;



        	enterRule();

        try {
            // InternalYangParser.g:5752:2: ( (this_XpathAdditiveExpr_0= ruleXpathAdditiveExpr ( () ( ( (lv_operator_2_1= LessThanSign | lv_operator_2_2= GreaterThanSign | lv_operator_2_3= LessThanSignEqualsSign | lv_operator_2_4= GreaterThanSignEqualsSign ) ) ) ( (lv_right_3_0= ruleXpathAdditiveExpr ) ) )* ) )
            // InternalYangParser.g:5753:2: (this_XpathAdditiveExpr_0= ruleXpathAdditiveExpr ( () ( ( (lv_operator_2_1= LessThanSign | lv_operator_2_2= GreaterThanSign | lv_operator_2_3= LessThanSignEqualsSign | lv_operator_2_4= GreaterThanSignEqualsSign ) ) ) ( (lv_right_3_0= ruleXpathAdditiveExpr ) ) )* )
            {
            // InternalYangParser.g:5753:2: (this_XpathAdditiveExpr_0= ruleXpathAdditiveExpr ( () ( ( (lv_operator_2_1= LessThanSign | lv_operator_2_2= GreaterThanSign | lv_operator_2_3= LessThanSignEqualsSign | lv_operator_2_4= GreaterThanSignEqualsSign ) ) ) ( (lv_right_3_0= ruleXpathAdditiveExpr ) ) )* )
            // InternalYangParser.g:5754:3: this_XpathAdditiveExpr_0= ruleXpathAdditiveExpr ( () ( ( (lv_operator_2_1= LessThanSign | lv_operator_2_2= GreaterThanSign | lv_operator_2_3= LessThanSignEqualsSign | lv_operator_2_4= GreaterThanSignEqualsSign ) ) ) ( (lv_right_3_0= ruleXpathAdditiveExpr ) ) )*
            {
            if ( state.backtracking==0 ) {

              			newCompositeNode(grammarAccess.getXpathRelationalExprAccess().getXpathAdditiveExprParserRuleCall_0());
              		
            }
            pushFollow(FOLLOW_22);
            this_XpathAdditiveExpr_0=ruleXpathAdditiveExpr();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current = this_XpathAdditiveExpr_0;
              			afterParserOrEnumRuleCall();
              		
            }
            // InternalYangParser.g:5762:3: ( () ( ( (lv_operator_2_1= LessThanSign | lv_operator_2_2= GreaterThanSign | lv_operator_2_3= LessThanSignEqualsSign | lv_operator_2_4= GreaterThanSignEqualsSign ) ) ) ( (lv_right_3_0= ruleXpathAdditiveExpr ) ) )*
            loop33:
            do {
                int alt33=2;
                int LA33_0 = input.LA(1);

                if ( ((LA33_0>=LessThanSignEqualsSign && LA33_0<=GreaterThanSignEqualsSign)||LA33_0==LessThanSign||LA33_0==GreaterThanSign) ) {
                    alt33=1;
                }


                switch (alt33) {
            	case 1 :
            	    // InternalYangParser.g:5763:4: () ( ( (lv_operator_2_1= LessThanSign | lv_operator_2_2= GreaterThanSign | lv_operator_2_3= LessThanSignEqualsSign | lv_operator_2_4= GreaterThanSignEqualsSign ) ) ) ( (lv_right_3_0= ruleXpathAdditiveExpr ) )
            	    {
            	    // InternalYangParser.g:5763:4: ()
            	    // InternalYangParser.g:5764:5: 
            	    {
            	    if ( state.backtracking==0 ) {

            	      					current = forceCreateModelElementAndSet(
            	      						grammarAccess.getXpathRelationalExprAccess().getXpathRelationalOperationLeftAction_1_0(),
            	      						current);
            	      				
            	    }

            	    }

            	    // InternalYangParser.g:5770:4: ( ( (lv_operator_2_1= LessThanSign | lv_operator_2_2= GreaterThanSign | lv_operator_2_3= LessThanSignEqualsSign | lv_operator_2_4= GreaterThanSignEqualsSign ) ) )
            	    // InternalYangParser.g:5771:5: ( (lv_operator_2_1= LessThanSign | lv_operator_2_2= GreaterThanSign | lv_operator_2_3= LessThanSignEqualsSign | lv_operator_2_4= GreaterThanSignEqualsSign ) )
            	    {
            	    // InternalYangParser.g:5771:5: ( (lv_operator_2_1= LessThanSign | lv_operator_2_2= GreaterThanSign | lv_operator_2_3= LessThanSignEqualsSign | lv_operator_2_4= GreaterThanSignEqualsSign ) )
            	    // InternalYangParser.g:5772:6: (lv_operator_2_1= LessThanSign | lv_operator_2_2= GreaterThanSign | lv_operator_2_3= LessThanSignEqualsSign | lv_operator_2_4= GreaterThanSignEqualsSign )
            	    {
            	    // InternalYangParser.g:5772:6: (lv_operator_2_1= LessThanSign | lv_operator_2_2= GreaterThanSign | lv_operator_2_3= LessThanSignEqualsSign | lv_operator_2_4= GreaterThanSignEqualsSign )
            	    int alt32=4;
            	    switch ( input.LA(1) ) {
            	    case LessThanSign:
            	        {
            	        alt32=1;
            	        }
            	        break;
            	    case GreaterThanSign:
            	        {
            	        alt32=2;
            	        }
            	        break;
            	    case LessThanSignEqualsSign:
            	        {
            	        alt32=3;
            	        }
            	        break;
            	    case GreaterThanSignEqualsSign:
            	        {
            	        alt32=4;
            	        }
            	        break;
            	    default:
            	        if (state.backtracking>0) {state.failed=true; return current;}
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 32, 0, input);

            	        throw nvae;
            	    }

            	    switch (alt32) {
            	        case 1 :
            	            // InternalYangParser.g:5773:7: lv_operator_2_1= LessThanSign
            	            {
            	            lv_operator_2_1=(Token)match(input,LessThanSign,FOLLOW_7); if (state.failed) return current;
            	            if ( state.backtracking==0 ) {

            	              							newLeafNode(lv_operator_2_1, grammarAccess.getXpathRelationalExprAccess().getOperatorLessThanSignKeyword_1_1_0_0());
            	              						
            	            }
            	            if ( state.backtracking==0 ) {

            	              							if (current==null) {
            	              								current = createModelElement(grammarAccess.getXpathRelationalExprRule());
            	              							}
            	              							setWithLastConsumed(current, "operator", lv_operator_2_1, null);
            	              						
            	            }

            	            }
            	            break;
            	        case 2 :
            	            // InternalYangParser.g:5784:7: lv_operator_2_2= GreaterThanSign
            	            {
            	            lv_operator_2_2=(Token)match(input,GreaterThanSign,FOLLOW_7); if (state.failed) return current;
            	            if ( state.backtracking==0 ) {

            	              							newLeafNode(lv_operator_2_2, grammarAccess.getXpathRelationalExprAccess().getOperatorGreaterThanSignKeyword_1_1_0_1());
            	              						
            	            }
            	            if ( state.backtracking==0 ) {

            	              							if (current==null) {
            	              								current = createModelElement(grammarAccess.getXpathRelationalExprRule());
            	              							}
            	              							setWithLastConsumed(current, "operator", lv_operator_2_2, null);
            	              						
            	            }

            	            }
            	            break;
            	        case 3 :
            	            // InternalYangParser.g:5795:7: lv_operator_2_3= LessThanSignEqualsSign
            	            {
            	            lv_operator_2_3=(Token)match(input,LessThanSignEqualsSign,FOLLOW_7); if (state.failed) return current;
            	            if ( state.backtracking==0 ) {

            	              							newLeafNode(lv_operator_2_3, grammarAccess.getXpathRelationalExprAccess().getOperatorLessThanSignEqualsSignKeyword_1_1_0_2());
            	              						
            	            }
            	            if ( state.backtracking==0 ) {

            	              							if (current==null) {
            	              								current = createModelElement(grammarAccess.getXpathRelationalExprRule());
            	              							}
            	              							setWithLastConsumed(current, "operator", lv_operator_2_3, null);
            	              						
            	            }

            	            }
            	            break;
            	        case 4 :
            	            // InternalYangParser.g:5806:7: lv_operator_2_4= GreaterThanSignEqualsSign
            	            {
            	            lv_operator_2_4=(Token)match(input,GreaterThanSignEqualsSign,FOLLOW_7); if (state.failed) return current;
            	            if ( state.backtracking==0 ) {

            	              							newLeafNode(lv_operator_2_4, grammarAccess.getXpathRelationalExprAccess().getOperatorGreaterThanSignEqualsSignKeyword_1_1_0_3());
            	              						
            	            }
            	            if ( state.backtracking==0 ) {

            	              							if (current==null) {
            	              								current = createModelElement(grammarAccess.getXpathRelationalExprRule());
            	              							}
            	              							setWithLastConsumed(current, "operator", lv_operator_2_4, null);
            	              						
            	            }

            	            }
            	            break;

            	    }


            	    }


            	    }

            	    // InternalYangParser.g:5819:4: ( (lv_right_3_0= ruleXpathAdditiveExpr ) )
            	    // InternalYangParser.g:5820:5: (lv_right_3_0= ruleXpathAdditiveExpr )
            	    {
            	    // InternalYangParser.g:5820:5: (lv_right_3_0= ruleXpathAdditiveExpr )
            	    // InternalYangParser.g:5821:6: lv_right_3_0= ruleXpathAdditiveExpr
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getXpathRelationalExprAccess().getRightXpathAdditiveExprParserRuleCall_1_2_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_22);
            	    lv_right_3_0=ruleXpathAdditiveExpr();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      						if (current==null) {
            	      							current = createModelElementForParent(grammarAccess.getXpathRelationalExprRule());
            	      						}
            	      						set(
            	      							current,
            	      							"right",
            	      							lv_right_3_0,
            	      							"io.typefox.yang.Yang.XpathAdditiveExpr");
            	      						afterParserOrEnumRuleCall();
            	      					
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop33;
                }
            } while (true);


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleXpathRelationalExpr"


    // $ANTLR start "entryRuleXpathAdditiveExpr"
    // InternalYangParser.g:5843:1: entryRuleXpathAdditiveExpr returns [EObject current=null] : iv_ruleXpathAdditiveExpr= ruleXpathAdditiveExpr EOF ;
    public final EObject entryRuleXpathAdditiveExpr() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXpathAdditiveExpr = null;


        try {
            // InternalYangParser.g:5843:58: (iv_ruleXpathAdditiveExpr= ruleXpathAdditiveExpr EOF )
            // InternalYangParser.g:5844:2: iv_ruleXpathAdditiveExpr= ruleXpathAdditiveExpr EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXpathAdditiveExprRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleXpathAdditiveExpr=ruleXpathAdditiveExpr();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXpathAdditiveExpr; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleXpathAdditiveExpr"


    // $ANTLR start "ruleXpathAdditiveExpr"
    // InternalYangParser.g:5850:1: ruleXpathAdditiveExpr returns [EObject current=null] : (this_XpathMultiplicativeExpr_0= ruleXpathMultiplicativeExpr ( () ( ( (lv_operator_2_1= PlusSign | lv_operator_2_2= HyphenMinus ) ) ) ( (lv_right_3_0= ruleXpathMultiplicativeExpr ) ) )* ) ;
    public final EObject ruleXpathAdditiveExpr() throws RecognitionException {
        EObject current = null;

        Token lv_operator_2_1=null;
        Token lv_operator_2_2=null;
        EObject this_XpathMultiplicativeExpr_0 = null;

        EObject lv_right_3_0 = null;



        	enterRule();

        try {
            // InternalYangParser.g:5856:2: ( (this_XpathMultiplicativeExpr_0= ruleXpathMultiplicativeExpr ( () ( ( (lv_operator_2_1= PlusSign | lv_operator_2_2= HyphenMinus ) ) ) ( (lv_right_3_0= ruleXpathMultiplicativeExpr ) ) )* ) )
            // InternalYangParser.g:5857:2: (this_XpathMultiplicativeExpr_0= ruleXpathMultiplicativeExpr ( () ( ( (lv_operator_2_1= PlusSign | lv_operator_2_2= HyphenMinus ) ) ) ( (lv_right_3_0= ruleXpathMultiplicativeExpr ) ) )* )
            {
            // InternalYangParser.g:5857:2: (this_XpathMultiplicativeExpr_0= ruleXpathMultiplicativeExpr ( () ( ( (lv_operator_2_1= PlusSign | lv_operator_2_2= HyphenMinus ) ) ) ( (lv_right_3_0= ruleXpathMultiplicativeExpr ) ) )* )
            // InternalYangParser.g:5858:3: this_XpathMultiplicativeExpr_0= ruleXpathMultiplicativeExpr ( () ( ( (lv_operator_2_1= PlusSign | lv_operator_2_2= HyphenMinus ) ) ) ( (lv_right_3_0= ruleXpathMultiplicativeExpr ) ) )*
            {
            if ( state.backtracking==0 ) {

              			newCompositeNode(grammarAccess.getXpathAdditiveExprAccess().getXpathMultiplicativeExprParserRuleCall_0());
              		
            }
            pushFollow(FOLLOW_23);
            this_XpathMultiplicativeExpr_0=ruleXpathMultiplicativeExpr();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current = this_XpathMultiplicativeExpr_0;
              			afterParserOrEnumRuleCall();
              		
            }
            // InternalYangParser.g:5866:3: ( () ( ( (lv_operator_2_1= PlusSign | lv_operator_2_2= HyphenMinus ) ) ) ( (lv_right_3_0= ruleXpathMultiplicativeExpr ) ) )*
            loop35:
            do {
                int alt35=2;
                int LA35_0 = input.LA(1);

                if ( (LA35_0==PlusSign||LA35_0==HyphenMinus) ) {
                    alt35=1;
                }


                switch (alt35) {
            	case 1 :
            	    // InternalYangParser.g:5867:4: () ( ( (lv_operator_2_1= PlusSign | lv_operator_2_2= HyphenMinus ) ) ) ( (lv_right_3_0= ruleXpathMultiplicativeExpr ) )
            	    {
            	    // InternalYangParser.g:5867:4: ()
            	    // InternalYangParser.g:5868:5: 
            	    {
            	    if ( state.backtracking==0 ) {

            	      					current = forceCreateModelElementAndSet(
            	      						grammarAccess.getXpathAdditiveExprAccess().getXpathAdditiveOperationLeftAction_1_0(),
            	      						current);
            	      				
            	    }

            	    }

            	    // InternalYangParser.g:5874:4: ( ( (lv_operator_2_1= PlusSign | lv_operator_2_2= HyphenMinus ) ) )
            	    // InternalYangParser.g:5875:5: ( (lv_operator_2_1= PlusSign | lv_operator_2_2= HyphenMinus ) )
            	    {
            	    // InternalYangParser.g:5875:5: ( (lv_operator_2_1= PlusSign | lv_operator_2_2= HyphenMinus ) )
            	    // InternalYangParser.g:5876:6: (lv_operator_2_1= PlusSign | lv_operator_2_2= HyphenMinus )
            	    {
            	    // InternalYangParser.g:5876:6: (lv_operator_2_1= PlusSign | lv_operator_2_2= HyphenMinus )
            	    int alt34=2;
            	    int LA34_0 = input.LA(1);

            	    if ( (LA34_0==PlusSign) ) {
            	        alt34=1;
            	    }
            	    else if ( (LA34_0==HyphenMinus) ) {
            	        alt34=2;
            	    }
            	    else {
            	        if (state.backtracking>0) {state.failed=true; return current;}
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 34, 0, input);

            	        throw nvae;
            	    }
            	    switch (alt34) {
            	        case 1 :
            	            // InternalYangParser.g:5877:7: lv_operator_2_1= PlusSign
            	            {
            	            lv_operator_2_1=(Token)match(input,PlusSign,FOLLOW_7); if (state.failed) return current;
            	            if ( state.backtracking==0 ) {

            	              							newLeafNode(lv_operator_2_1, grammarAccess.getXpathAdditiveExprAccess().getOperatorPlusSignKeyword_1_1_0_0());
            	              						
            	            }
            	            if ( state.backtracking==0 ) {

            	              							if (current==null) {
            	              								current = createModelElement(grammarAccess.getXpathAdditiveExprRule());
            	              							}
            	              							setWithLastConsumed(current, "operator", lv_operator_2_1, null);
            	              						
            	            }

            	            }
            	            break;
            	        case 2 :
            	            // InternalYangParser.g:5888:7: lv_operator_2_2= HyphenMinus
            	            {
            	            lv_operator_2_2=(Token)match(input,HyphenMinus,FOLLOW_7); if (state.failed) return current;
            	            if ( state.backtracking==0 ) {

            	              							newLeafNode(lv_operator_2_2, grammarAccess.getXpathAdditiveExprAccess().getOperatorHyphenMinusKeyword_1_1_0_1());
            	              						
            	            }
            	            if ( state.backtracking==0 ) {

            	              							if (current==null) {
            	              								current = createModelElement(grammarAccess.getXpathAdditiveExprRule());
            	              							}
            	              							setWithLastConsumed(current, "operator", lv_operator_2_2, null);
            	              						
            	            }

            	            }
            	            break;

            	    }


            	    }


            	    }

            	    // InternalYangParser.g:5901:4: ( (lv_right_3_0= ruleXpathMultiplicativeExpr ) )
            	    // InternalYangParser.g:5902:5: (lv_right_3_0= ruleXpathMultiplicativeExpr )
            	    {
            	    // InternalYangParser.g:5902:5: (lv_right_3_0= ruleXpathMultiplicativeExpr )
            	    // InternalYangParser.g:5903:6: lv_right_3_0= ruleXpathMultiplicativeExpr
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getXpathAdditiveExprAccess().getRightXpathMultiplicativeExprParserRuleCall_1_2_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_23);
            	    lv_right_3_0=ruleXpathMultiplicativeExpr();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      						if (current==null) {
            	      							current = createModelElementForParent(grammarAccess.getXpathAdditiveExprRule());
            	      						}
            	      						set(
            	      							current,
            	      							"right",
            	      							lv_right_3_0,
            	      							"io.typefox.yang.Yang.XpathMultiplicativeExpr");
            	      						afterParserOrEnumRuleCall();
            	      					
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop35;
                }
            } while (true);


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleXpathAdditiveExpr"


    // $ANTLR start "entryRuleXpathMultiplicativeExpr"
    // InternalYangParser.g:5925:1: entryRuleXpathMultiplicativeExpr returns [EObject current=null] : iv_ruleXpathMultiplicativeExpr= ruleXpathMultiplicativeExpr EOF ;
    public final EObject entryRuleXpathMultiplicativeExpr() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXpathMultiplicativeExpr = null;


        try {
            // InternalYangParser.g:5925:64: (iv_ruleXpathMultiplicativeExpr= ruleXpathMultiplicativeExpr EOF )
            // InternalYangParser.g:5926:2: iv_ruleXpathMultiplicativeExpr= ruleXpathMultiplicativeExpr EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXpathMultiplicativeExprRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleXpathMultiplicativeExpr=ruleXpathMultiplicativeExpr();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXpathMultiplicativeExpr; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleXpathMultiplicativeExpr"


    // $ANTLR start "ruleXpathMultiplicativeExpr"
    // InternalYangParser.g:5932:1: ruleXpathMultiplicativeExpr returns [EObject current=null] : (this_XpathUnaryExpr_0= ruleXpathUnaryExpr ( () ( ( (lv_operator_2_1= Asterisk | lv_operator_2_2= Div | lv_operator_2_3= Mod ) ) ) ( (lv_right_3_0= ruleXpathMultiplicativeExpr ) ) )? ) ;
    public final EObject ruleXpathMultiplicativeExpr() throws RecognitionException {
        EObject current = null;

        Token lv_operator_2_1=null;
        Token lv_operator_2_2=null;
        Token lv_operator_2_3=null;
        EObject this_XpathUnaryExpr_0 = null;

        EObject lv_right_3_0 = null;



        	enterRule();

        try {
            // InternalYangParser.g:5938:2: ( (this_XpathUnaryExpr_0= ruleXpathUnaryExpr ( () ( ( (lv_operator_2_1= Asterisk | lv_operator_2_2= Div | lv_operator_2_3= Mod ) ) ) ( (lv_right_3_0= ruleXpathMultiplicativeExpr ) ) )? ) )
            // InternalYangParser.g:5939:2: (this_XpathUnaryExpr_0= ruleXpathUnaryExpr ( () ( ( (lv_operator_2_1= Asterisk | lv_operator_2_2= Div | lv_operator_2_3= Mod ) ) ) ( (lv_right_3_0= ruleXpathMultiplicativeExpr ) ) )? )
            {
            // InternalYangParser.g:5939:2: (this_XpathUnaryExpr_0= ruleXpathUnaryExpr ( () ( ( (lv_operator_2_1= Asterisk | lv_operator_2_2= Div | lv_operator_2_3= Mod ) ) ) ( (lv_right_3_0= ruleXpathMultiplicativeExpr ) ) )? )
            // InternalYangParser.g:5940:3: this_XpathUnaryExpr_0= ruleXpathUnaryExpr ( () ( ( (lv_operator_2_1= Asterisk | lv_operator_2_2= Div | lv_operator_2_3= Mod ) ) ) ( (lv_right_3_0= ruleXpathMultiplicativeExpr ) ) )?
            {
            if ( state.backtracking==0 ) {

              			newCompositeNode(grammarAccess.getXpathMultiplicativeExprAccess().getXpathUnaryExprParserRuleCall_0());
              		
            }
            pushFollow(FOLLOW_24);
            this_XpathUnaryExpr_0=ruleXpathUnaryExpr();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current = this_XpathUnaryExpr_0;
              			afterParserOrEnumRuleCall();
              		
            }
            // InternalYangParser.g:5948:3: ( () ( ( (lv_operator_2_1= Asterisk | lv_operator_2_2= Div | lv_operator_2_3= Mod ) ) ) ( (lv_right_3_0= ruleXpathMultiplicativeExpr ) ) )?
            int alt37=2;
            int LA37_0 = input.LA(1);

            if ( (LA37_0==Div||LA37_0==Mod||LA37_0==Asterisk) ) {
                alt37=1;
            }
            switch (alt37) {
                case 1 :
                    // InternalYangParser.g:5949:4: () ( ( (lv_operator_2_1= Asterisk | lv_operator_2_2= Div | lv_operator_2_3= Mod ) ) ) ( (lv_right_3_0= ruleXpathMultiplicativeExpr ) )
                    {
                    // InternalYangParser.g:5949:4: ()
                    // InternalYangParser.g:5950:5: 
                    {
                    if ( state.backtracking==0 ) {

                      					current = forceCreateModelElementAndSet(
                      						grammarAccess.getXpathMultiplicativeExprAccess().getXpathMultiplicativeOperationLeftAction_1_0(),
                      						current);
                      				
                    }

                    }

                    // InternalYangParser.g:5956:4: ( ( (lv_operator_2_1= Asterisk | lv_operator_2_2= Div | lv_operator_2_3= Mod ) ) )
                    // InternalYangParser.g:5957:5: ( (lv_operator_2_1= Asterisk | lv_operator_2_2= Div | lv_operator_2_3= Mod ) )
                    {
                    // InternalYangParser.g:5957:5: ( (lv_operator_2_1= Asterisk | lv_operator_2_2= Div | lv_operator_2_3= Mod ) )
                    // InternalYangParser.g:5958:6: (lv_operator_2_1= Asterisk | lv_operator_2_2= Div | lv_operator_2_3= Mod )
                    {
                    // InternalYangParser.g:5958:6: (lv_operator_2_1= Asterisk | lv_operator_2_2= Div | lv_operator_2_3= Mod )
                    int alt36=3;
                    switch ( input.LA(1) ) {
                    case Asterisk:
                        {
                        alt36=1;
                        }
                        break;
                    case Div:
                        {
                        alt36=2;
                        }
                        break;
                    case Mod:
                        {
                        alt36=3;
                        }
                        break;
                    default:
                        if (state.backtracking>0) {state.failed=true; return current;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 36, 0, input);

                        throw nvae;
                    }

                    switch (alt36) {
                        case 1 :
                            // InternalYangParser.g:5959:7: lv_operator_2_1= Asterisk
                            {
                            lv_operator_2_1=(Token)match(input,Asterisk,FOLLOW_7); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              							newLeafNode(lv_operator_2_1, grammarAccess.getXpathMultiplicativeExprAccess().getOperatorAsteriskKeyword_1_1_0_0());
                              						
                            }
                            if ( state.backtracking==0 ) {

                              							if (current==null) {
                              								current = createModelElement(grammarAccess.getXpathMultiplicativeExprRule());
                              							}
                              							setWithLastConsumed(current, "operator", lv_operator_2_1, null);
                              						
                            }

                            }
                            break;
                        case 2 :
                            // InternalYangParser.g:5970:7: lv_operator_2_2= Div
                            {
                            lv_operator_2_2=(Token)match(input,Div,FOLLOW_7); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              							newLeafNode(lv_operator_2_2, grammarAccess.getXpathMultiplicativeExprAccess().getOperatorDivKeyword_1_1_0_1());
                              						
                            }
                            if ( state.backtracking==0 ) {

                              							if (current==null) {
                              								current = createModelElement(grammarAccess.getXpathMultiplicativeExprRule());
                              							}
                              							setWithLastConsumed(current, "operator", lv_operator_2_2, null);
                              						
                            }

                            }
                            break;
                        case 3 :
                            // InternalYangParser.g:5981:7: lv_operator_2_3= Mod
                            {
                            lv_operator_2_3=(Token)match(input,Mod,FOLLOW_7); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              							newLeafNode(lv_operator_2_3, grammarAccess.getXpathMultiplicativeExprAccess().getOperatorModKeyword_1_1_0_2());
                              						
                            }
                            if ( state.backtracking==0 ) {

                              							if (current==null) {
                              								current = createModelElement(grammarAccess.getXpathMultiplicativeExprRule());
                              							}
                              							setWithLastConsumed(current, "operator", lv_operator_2_3, null);
                              						
                            }

                            }
                            break;

                    }


                    }


                    }

                    // InternalYangParser.g:5994:4: ( (lv_right_3_0= ruleXpathMultiplicativeExpr ) )
                    // InternalYangParser.g:5995:5: (lv_right_3_0= ruleXpathMultiplicativeExpr )
                    {
                    // InternalYangParser.g:5995:5: (lv_right_3_0= ruleXpathMultiplicativeExpr )
                    // InternalYangParser.g:5996:6: lv_right_3_0= ruleXpathMultiplicativeExpr
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getXpathMultiplicativeExprAccess().getRightXpathMultiplicativeExprParserRuleCall_1_2_0());
                      					
                    }
                    pushFollow(FOLLOW_2);
                    lv_right_3_0=ruleXpathMultiplicativeExpr();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getXpathMultiplicativeExprRule());
                      						}
                      						set(
                      							current,
                      							"right",
                      							lv_right_3_0,
                      							"io.typefox.yang.Yang.XpathMultiplicativeExpr");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }


                    }
                    break;

            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleXpathMultiplicativeExpr"


    // $ANTLR start "entryRuleXpathUnaryExpr"
    // InternalYangParser.g:6018:1: entryRuleXpathUnaryExpr returns [EObject current=null] : iv_ruleXpathUnaryExpr= ruleXpathUnaryExpr EOF ;
    public final EObject entryRuleXpathUnaryExpr() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXpathUnaryExpr = null;


        try {
            // InternalYangParser.g:6018:55: (iv_ruleXpathUnaryExpr= ruleXpathUnaryExpr EOF )
            // InternalYangParser.g:6019:2: iv_ruleXpathUnaryExpr= ruleXpathUnaryExpr EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXpathUnaryExprRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleXpathUnaryExpr=ruleXpathUnaryExpr();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXpathUnaryExpr; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleXpathUnaryExpr"


    // $ANTLR start "ruleXpathUnaryExpr"
    // InternalYangParser.g:6025:1: ruleXpathUnaryExpr returns [EObject current=null] : ( ( () ( (lv_operator_1_0= HyphenMinus ) ) ( (lv_target_2_0= ruleXpathUnionExpr ) ) ) | this_XpathUnionExpr_3= ruleXpathUnionExpr ) ;
    public final EObject ruleXpathUnaryExpr() throws RecognitionException {
        EObject current = null;

        Token lv_operator_1_0=null;
        EObject lv_target_2_0 = null;

        EObject this_XpathUnionExpr_3 = null;



        	enterRule();

        try {
            // InternalYangParser.g:6031:2: ( ( ( () ( (lv_operator_1_0= HyphenMinus ) ) ( (lv_target_2_0= ruleXpathUnionExpr ) ) ) | this_XpathUnionExpr_3= ruleXpathUnionExpr ) )
            // InternalYangParser.g:6032:2: ( ( () ( (lv_operator_1_0= HyphenMinus ) ) ( (lv_target_2_0= ruleXpathUnionExpr ) ) ) | this_XpathUnionExpr_3= ruleXpathUnionExpr )
            {
            // InternalYangParser.g:6032:2: ( ( () ( (lv_operator_1_0= HyphenMinus ) ) ( (lv_target_2_0= ruleXpathUnionExpr ) ) ) | this_XpathUnionExpr_3= ruleXpathUnionExpr )
            int alt38=2;
            int LA38_0 = input.LA(1);

            if ( (LA38_0==HyphenMinus) ) {
                alt38=1;
            }
            else if ( ((LA38_0>=ProcessingInstruction && LA38_0<=Value)||(LA38_0>=Base && LA38_0<=Mod)||LA38_0==Rpc||LA38_0==FullStopFullStop||(LA38_0>=Or && LA38_0<=LeftParenthesis)||LA38_0==Asterisk||(LA38_0>=FullStop && LA38_0<=Solidus)||LA38_0==CommercialAt||LA38_0==RULE_ID||(LA38_0>=RULE_STRING && LA38_0<=RULE_NUMBER)) ) {
                alt38=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 38, 0, input);

                throw nvae;
            }
            switch (alt38) {
                case 1 :
                    // InternalYangParser.g:6033:3: ( () ( (lv_operator_1_0= HyphenMinus ) ) ( (lv_target_2_0= ruleXpathUnionExpr ) ) )
                    {
                    // InternalYangParser.g:6033:3: ( () ( (lv_operator_1_0= HyphenMinus ) ) ( (lv_target_2_0= ruleXpathUnionExpr ) ) )
                    // InternalYangParser.g:6034:4: () ( (lv_operator_1_0= HyphenMinus ) ) ( (lv_target_2_0= ruleXpathUnionExpr ) )
                    {
                    // InternalYangParser.g:6034:4: ()
                    // InternalYangParser.g:6035:5: 
                    {
                    if ( state.backtracking==0 ) {

                      					current = forceCreateModelElement(
                      						grammarAccess.getXpathUnaryExprAccess().getXpathUnaryOperationAction_0_0(),
                      						current);
                      				
                    }

                    }

                    // InternalYangParser.g:6041:4: ( (lv_operator_1_0= HyphenMinus ) )
                    // InternalYangParser.g:6042:5: (lv_operator_1_0= HyphenMinus )
                    {
                    // InternalYangParser.g:6042:5: (lv_operator_1_0= HyphenMinus )
                    // InternalYangParser.g:6043:6: lv_operator_1_0= HyphenMinus
                    {
                    lv_operator_1_0=(Token)match(input,HyphenMinus,FOLLOW_7); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						newLeafNode(lv_operator_1_0, grammarAccess.getXpathUnaryExprAccess().getOperatorHyphenMinusKeyword_0_1_0());
                      					
                    }
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElement(grammarAccess.getXpathUnaryExprRule());
                      						}
                      						setWithLastConsumed(current, "operator", lv_operator_1_0, "-");
                      					
                    }

                    }


                    }

                    // InternalYangParser.g:6055:4: ( (lv_target_2_0= ruleXpathUnionExpr ) )
                    // InternalYangParser.g:6056:5: (lv_target_2_0= ruleXpathUnionExpr )
                    {
                    // InternalYangParser.g:6056:5: (lv_target_2_0= ruleXpathUnionExpr )
                    // InternalYangParser.g:6057:6: lv_target_2_0= ruleXpathUnionExpr
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getXpathUnaryExprAccess().getTargetXpathUnionExprParserRuleCall_0_2_0());
                      					
                    }
                    pushFollow(FOLLOW_2);
                    lv_target_2_0=ruleXpathUnionExpr();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getXpathUnaryExprRule());
                      						}
                      						set(
                      							current,
                      							"target",
                      							lv_target_2_0,
                      							"io.typefox.yang.Yang.XpathUnionExpr");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalYangParser.g:6076:3: this_XpathUnionExpr_3= ruleXpathUnionExpr
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getXpathUnaryExprAccess().getXpathUnionExprParserRuleCall_1());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_XpathUnionExpr_3=ruleXpathUnionExpr();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_XpathUnionExpr_3;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleXpathUnaryExpr"


    // $ANTLR start "entryRuleXpathUnionExpr"
    // InternalYangParser.g:6088:1: entryRuleXpathUnionExpr returns [EObject current=null] : iv_ruleXpathUnionExpr= ruleXpathUnionExpr EOF ;
    public final EObject entryRuleXpathUnionExpr() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXpathUnionExpr = null;


        try {
            // InternalYangParser.g:6088:55: (iv_ruleXpathUnionExpr= ruleXpathUnionExpr EOF )
            // InternalYangParser.g:6089:2: iv_ruleXpathUnionExpr= ruleXpathUnionExpr EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXpathUnionExprRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleXpathUnionExpr=ruleXpathUnionExpr();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXpathUnionExpr; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleXpathUnionExpr"


    // $ANTLR start "ruleXpathUnionExpr"
    // InternalYangParser.g:6095:1: ruleXpathUnionExpr returns [EObject current=null] : (this_XpathPathExpr_0= ruleXpathPathExpr ( () ( (lv_operator_2_0= VerticalLine ) ) ( (lv_right_3_0= ruleXpathUnionExpr ) ) )? ) ;
    public final EObject ruleXpathUnionExpr() throws RecognitionException {
        EObject current = null;

        Token lv_operator_2_0=null;
        EObject this_XpathPathExpr_0 = null;

        EObject lv_right_3_0 = null;



        	enterRule();

        try {
            // InternalYangParser.g:6101:2: ( (this_XpathPathExpr_0= ruleXpathPathExpr ( () ( (lv_operator_2_0= VerticalLine ) ) ( (lv_right_3_0= ruleXpathUnionExpr ) ) )? ) )
            // InternalYangParser.g:6102:2: (this_XpathPathExpr_0= ruleXpathPathExpr ( () ( (lv_operator_2_0= VerticalLine ) ) ( (lv_right_3_0= ruleXpathUnionExpr ) ) )? )
            {
            // InternalYangParser.g:6102:2: (this_XpathPathExpr_0= ruleXpathPathExpr ( () ( (lv_operator_2_0= VerticalLine ) ) ( (lv_right_3_0= ruleXpathUnionExpr ) ) )? )
            // InternalYangParser.g:6103:3: this_XpathPathExpr_0= ruleXpathPathExpr ( () ( (lv_operator_2_0= VerticalLine ) ) ( (lv_right_3_0= ruleXpathUnionExpr ) ) )?
            {
            if ( state.backtracking==0 ) {

              			newCompositeNode(grammarAccess.getXpathUnionExprAccess().getXpathPathExprParserRuleCall_0());
              		
            }
            pushFollow(FOLLOW_17);
            this_XpathPathExpr_0=ruleXpathPathExpr();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current = this_XpathPathExpr_0;
              			afterParserOrEnumRuleCall();
              		
            }
            // InternalYangParser.g:6111:3: ( () ( (lv_operator_2_0= VerticalLine ) ) ( (lv_right_3_0= ruleXpathUnionExpr ) ) )?
            int alt39=2;
            int LA39_0 = input.LA(1);

            if ( (LA39_0==VerticalLine) ) {
                alt39=1;
            }
            switch (alt39) {
                case 1 :
                    // InternalYangParser.g:6112:4: () ( (lv_operator_2_0= VerticalLine ) ) ( (lv_right_3_0= ruleXpathUnionExpr ) )
                    {
                    // InternalYangParser.g:6112:4: ()
                    // InternalYangParser.g:6113:5: 
                    {
                    if ( state.backtracking==0 ) {

                      					current = forceCreateModelElementAndSet(
                      						grammarAccess.getXpathUnionExprAccess().getXpathUnionOperationLeftAction_1_0(),
                      						current);
                      				
                    }

                    }

                    // InternalYangParser.g:6119:4: ( (lv_operator_2_0= VerticalLine ) )
                    // InternalYangParser.g:6120:5: (lv_operator_2_0= VerticalLine )
                    {
                    // InternalYangParser.g:6120:5: (lv_operator_2_0= VerticalLine )
                    // InternalYangParser.g:6121:6: lv_operator_2_0= VerticalLine
                    {
                    lv_operator_2_0=(Token)match(input,VerticalLine,FOLLOW_7); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						newLeafNode(lv_operator_2_0, grammarAccess.getXpathUnionExprAccess().getOperatorVerticalLineKeyword_1_1_0());
                      					
                    }
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElement(grammarAccess.getXpathUnionExprRule());
                      						}
                      						setWithLastConsumed(current, "operator", lv_operator_2_0, "|");
                      					
                    }

                    }


                    }

                    // InternalYangParser.g:6133:4: ( (lv_right_3_0= ruleXpathUnionExpr ) )
                    // InternalYangParser.g:6134:5: (lv_right_3_0= ruleXpathUnionExpr )
                    {
                    // InternalYangParser.g:6134:5: (lv_right_3_0= ruleXpathUnionExpr )
                    // InternalYangParser.g:6135:6: lv_right_3_0= ruleXpathUnionExpr
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getXpathUnionExprAccess().getRightXpathUnionExprParserRuleCall_1_2_0());
                      					
                    }
                    pushFollow(FOLLOW_2);
                    lv_right_3_0=ruleXpathUnionExpr();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getXpathUnionExprRule());
                      						}
                      						set(
                      							current,
                      							"right",
                      							lv_right_3_0,
                      							"io.typefox.yang.Yang.XpathUnionExpr");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }


                    }
                    break;

            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleXpathUnionExpr"


    // $ANTLR start "entryRuleXpathPathExpr"
    // InternalYangParser.g:6157:1: entryRuleXpathPathExpr returns [EObject current=null] : iv_ruleXpathPathExpr= ruleXpathPathExpr EOF ;
    public final EObject entryRuleXpathPathExpr() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXpathPathExpr = null;


        try {
            // InternalYangParser.g:6157:54: (iv_ruleXpathPathExpr= ruleXpathPathExpr EOF )
            // InternalYangParser.g:6158:2: iv_ruleXpathPathExpr= ruleXpathPathExpr EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXpathPathExprRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleXpathPathExpr=ruleXpathPathExpr();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXpathPathExpr; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleXpathPathExpr"


    // $ANTLR start "ruleXpathPathExpr"
    // InternalYangParser.g:6164:1: ruleXpathPathExpr returns [EObject current=null] : (this_XpathFilterExpr_0= ruleXpathFilterExpr ( () otherlv_2= Solidus ( ( Solidus )=> ( (lv_isDescendants_3_0= Solidus ) ) )? ( (lv_step_4_0= ruleXpathStep ) ) ( () otherlv_6= LeftSquareBracket ( (lv_predicate_7_0= ruleXpathExpression ) ) otherlv_8= RightSquareBracket )* )* ) ;
    public final EObject ruleXpathPathExpr() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        Token lv_isDescendants_3_0=null;
        Token otherlv_6=null;
        Token otherlv_8=null;
        EObject this_XpathFilterExpr_0 = null;

        EObject lv_step_4_0 = null;

        EObject lv_predicate_7_0 = null;



        	enterRule();

        try {
            // InternalYangParser.g:6170:2: ( (this_XpathFilterExpr_0= ruleXpathFilterExpr ( () otherlv_2= Solidus ( ( Solidus )=> ( (lv_isDescendants_3_0= Solidus ) ) )? ( (lv_step_4_0= ruleXpathStep ) ) ( () otherlv_6= LeftSquareBracket ( (lv_predicate_7_0= ruleXpathExpression ) ) otherlv_8= RightSquareBracket )* )* ) )
            // InternalYangParser.g:6171:2: (this_XpathFilterExpr_0= ruleXpathFilterExpr ( () otherlv_2= Solidus ( ( Solidus )=> ( (lv_isDescendants_3_0= Solidus ) ) )? ( (lv_step_4_0= ruleXpathStep ) ) ( () otherlv_6= LeftSquareBracket ( (lv_predicate_7_0= ruleXpathExpression ) ) otherlv_8= RightSquareBracket )* )* )
            {
            // InternalYangParser.g:6171:2: (this_XpathFilterExpr_0= ruleXpathFilterExpr ( () otherlv_2= Solidus ( ( Solidus )=> ( (lv_isDescendants_3_0= Solidus ) ) )? ( (lv_step_4_0= ruleXpathStep ) ) ( () otherlv_6= LeftSquareBracket ( (lv_predicate_7_0= ruleXpathExpression ) ) otherlv_8= RightSquareBracket )* )* )
            // InternalYangParser.g:6172:3: this_XpathFilterExpr_0= ruleXpathFilterExpr ( () otherlv_2= Solidus ( ( Solidus )=> ( (lv_isDescendants_3_0= Solidus ) ) )? ( (lv_step_4_0= ruleXpathStep ) ) ( () otherlv_6= LeftSquareBracket ( (lv_predicate_7_0= ruleXpathExpression ) ) otherlv_8= RightSquareBracket )* )*
            {
            if ( state.backtracking==0 ) {

              			newCompositeNode(grammarAccess.getXpathPathExprAccess().getXpathFilterExprParserRuleCall_0());
              		
            }
            pushFollow(FOLLOW_19);
            this_XpathFilterExpr_0=ruleXpathFilterExpr();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current = this_XpathFilterExpr_0;
              			afterParserOrEnumRuleCall();
              		
            }
            // InternalYangParser.g:6180:3: ( () otherlv_2= Solidus ( ( Solidus )=> ( (lv_isDescendants_3_0= Solidus ) ) )? ( (lv_step_4_0= ruleXpathStep ) ) ( () otherlv_6= LeftSquareBracket ( (lv_predicate_7_0= ruleXpathExpression ) ) otherlv_8= RightSquareBracket )* )*
            loop42:
            do {
                int alt42=2;
                int LA42_0 = input.LA(1);

                if ( (LA42_0==Solidus) ) {
                    alt42=1;
                }


                switch (alt42) {
            	case 1 :
            	    // InternalYangParser.g:6181:4: () otherlv_2= Solidus ( ( Solidus )=> ( (lv_isDescendants_3_0= Solidus ) ) )? ( (lv_step_4_0= ruleXpathStep ) ) ( () otherlv_6= LeftSquareBracket ( (lv_predicate_7_0= ruleXpathExpression ) ) otherlv_8= RightSquareBracket )*
            	    {
            	    // InternalYangParser.g:6181:4: ()
            	    // InternalYangParser.g:6182:5: 
            	    {
            	    if ( state.backtracking==0 ) {

            	      					current = forceCreateModelElementAndSet(
            	      						grammarAccess.getXpathPathExprAccess().getXpathLocationTargetAction_1_0(),
            	      						current);
            	      				
            	    }

            	    }

            	    otherlv_2=(Token)match(input,Solidus,FOLLOW_25); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      				newLeafNode(otherlv_2, grammarAccess.getXpathPathExprAccess().getSolidusKeyword_1_1());
            	      			
            	    }
            	    // InternalYangParser.g:6192:4: ( ( Solidus )=> ( (lv_isDescendants_3_0= Solidus ) ) )?
            	    int alt40=2;
            	    int LA40_0 = input.LA(1);

            	    if ( (LA40_0==Solidus) && (synpred1_InternalYangParser())) {
            	        alt40=1;
            	    }
            	    switch (alt40) {
            	        case 1 :
            	            // InternalYangParser.g:6193:5: ( Solidus )=> ( (lv_isDescendants_3_0= Solidus ) )
            	            {
            	            // InternalYangParser.g:6194:5: ( (lv_isDescendants_3_0= Solidus ) )
            	            // InternalYangParser.g:6195:6: (lv_isDescendants_3_0= Solidus )
            	            {
            	            // InternalYangParser.g:6195:6: (lv_isDescendants_3_0= Solidus )
            	            // InternalYangParser.g:6196:7: lv_isDescendants_3_0= Solidus
            	            {
            	            lv_isDescendants_3_0=(Token)match(input,Solidus,FOLLOW_26); if (state.failed) return current;
            	            if ( state.backtracking==0 ) {

            	              							newLeafNode(lv_isDescendants_3_0, grammarAccess.getXpathPathExprAccess().getIsDescendantsSolidusKeyword_1_2_0_0());
            	              						
            	            }
            	            if ( state.backtracking==0 ) {

            	              							if (current==null) {
            	              								current = createModelElement(grammarAccess.getXpathPathExprRule());
            	              							}
            	              							setWithLastConsumed(current, "isDescendants", true, "/");
            	              						
            	            }

            	            }


            	            }


            	            }
            	            break;

            	    }

            	    // InternalYangParser.g:6209:4: ( (lv_step_4_0= ruleXpathStep ) )
            	    // InternalYangParser.g:6210:5: (lv_step_4_0= ruleXpathStep )
            	    {
            	    // InternalYangParser.g:6210:5: (lv_step_4_0= ruleXpathStep )
            	    // InternalYangParser.g:6211:6: lv_step_4_0= ruleXpathStep
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getXpathPathExprAccess().getStepXpathStepParserRuleCall_1_3_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_27);
            	    lv_step_4_0=ruleXpathStep();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      						if (current==null) {
            	      							current = createModelElementForParent(grammarAccess.getXpathPathExprRule());
            	      						}
            	      						set(
            	      							current,
            	      							"step",
            	      							lv_step_4_0,
            	      							"io.typefox.yang.Yang.XpathStep");
            	      						afterParserOrEnumRuleCall();
            	      					
            	    }

            	    }


            	    }

            	    // InternalYangParser.g:6228:4: ( () otherlv_6= LeftSquareBracket ( (lv_predicate_7_0= ruleXpathExpression ) ) otherlv_8= RightSquareBracket )*
            	    loop41:
            	    do {
            	        int alt41=2;
            	        int LA41_0 = input.LA(1);

            	        if ( (LA41_0==LeftSquareBracket) ) {
            	            alt41=1;
            	        }


            	        switch (alt41) {
            	    	case 1 :
            	    	    // InternalYangParser.g:6229:5: () otherlv_6= LeftSquareBracket ( (lv_predicate_7_0= ruleXpathExpression ) ) otherlv_8= RightSquareBracket
            	    	    {
            	    	    // InternalYangParser.g:6229:5: ()
            	    	    // InternalYangParser.g:6230:6: 
            	    	    {
            	    	    if ( state.backtracking==0 ) {

            	    	      						current = forceCreateModelElementAndSet(
            	    	      							grammarAccess.getXpathPathExprAccess().getXpathFilterTargetAction_1_4_0(),
            	    	      							current);
            	    	      					
            	    	    }

            	    	    }

            	    	    otherlv_6=(Token)match(input,LeftSquareBracket,FOLLOW_7); if (state.failed) return current;
            	    	    if ( state.backtracking==0 ) {

            	    	      					newLeafNode(otherlv_6, grammarAccess.getXpathPathExprAccess().getLeftSquareBracketKeyword_1_4_1());
            	    	      				
            	    	    }
            	    	    // InternalYangParser.g:6240:5: ( (lv_predicate_7_0= ruleXpathExpression ) )
            	    	    // InternalYangParser.g:6241:6: (lv_predicate_7_0= ruleXpathExpression )
            	    	    {
            	    	    // InternalYangParser.g:6241:6: (lv_predicate_7_0= ruleXpathExpression )
            	    	    // InternalYangParser.g:6242:7: lv_predicate_7_0= ruleXpathExpression
            	    	    {
            	    	    if ( state.backtracking==0 ) {

            	    	      							newCompositeNode(grammarAccess.getXpathPathExprAccess().getPredicateXpathExpressionParserRuleCall_1_4_2_0());
            	    	      						
            	    	    }
            	    	    pushFollow(FOLLOW_28);
            	    	    lv_predicate_7_0=ruleXpathExpression();

            	    	    state._fsp--;
            	    	    if (state.failed) return current;
            	    	    if ( state.backtracking==0 ) {

            	    	      							if (current==null) {
            	    	      								current = createModelElementForParent(grammarAccess.getXpathPathExprRule());
            	    	      							}
            	    	      							set(
            	    	      								current,
            	    	      								"predicate",
            	    	      								lv_predicate_7_0,
            	    	      								"io.typefox.yang.Yang.XpathExpression");
            	    	      							afterParserOrEnumRuleCall();
            	    	      						
            	    	    }

            	    	    }


            	    	    }

            	    	    otherlv_8=(Token)match(input,RightSquareBracket,FOLLOW_27); if (state.failed) return current;
            	    	    if ( state.backtracking==0 ) {

            	    	      					newLeafNode(otherlv_8, grammarAccess.getXpathPathExprAccess().getRightSquareBracketKeyword_1_4_3());
            	    	      				
            	    	    }

            	    	    }
            	    	    break;

            	    	default :
            	    	    break loop41;
            	        }
            	    } while (true);


            	    }
            	    break;

            	default :
            	    break loop42;
                }
            } while (true);


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleXpathPathExpr"


    // $ANTLR start "entryRuleXpathFilterExpr"
    // InternalYangParser.g:6269:1: entryRuleXpathFilterExpr returns [EObject current=null] : iv_ruleXpathFilterExpr= ruleXpathFilterExpr EOF ;
    public final EObject entryRuleXpathFilterExpr() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXpathFilterExpr = null;


        try {
            // InternalYangParser.g:6269:56: (iv_ruleXpathFilterExpr= ruleXpathFilterExpr EOF )
            // InternalYangParser.g:6270:2: iv_ruleXpathFilterExpr= ruleXpathFilterExpr EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXpathFilterExprRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleXpathFilterExpr=ruleXpathFilterExpr();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXpathFilterExpr; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleXpathFilterExpr"


    // $ANTLR start "ruleXpathFilterExpr"
    // InternalYangParser.g:6276:1: ruleXpathFilterExpr returns [EObject current=null] : (this_XpathPrimaryExpr_0= ruleXpathPrimaryExpr ( () otherlv_2= LeftSquareBracket ( (lv_predicate_3_0= ruleXpathExpression ) ) otherlv_4= RightSquareBracket )* ) ;
    public final EObject ruleXpathFilterExpr() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject this_XpathPrimaryExpr_0 = null;

        EObject lv_predicate_3_0 = null;



        	enterRule();

        try {
            // InternalYangParser.g:6282:2: ( (this_XpathPrimaryExpr_0= ruleXpathPrimaryExpr ( () otherlv_2= LeftSquareBracket ( (lv_predicate_3_0= ruleXpathExpression ) ) otherlv_4= RightSquareBracket )* ) )
            // InternalYangParser.g:6283:2: (this_XpathPrimaryExpr_0= ruleXpathPrimaryExpr ( () otherlv_2= LeftSquareBracket ( (lv_predicate_3_0= ruleXpathExpression ) ) otherlv_4= RightSquareBracket )* )
            {
            // InternalYangParser.g:6283:2: (this_XpathPrimaryExpr_0= ruleXpathPrimaryExpr ( () otherlv_2= LeftSquareBracket ( (lv_predicate_3_0= ruleXpathExpression ) ) otherlv_4= RightSquareBracket )* )
            // InternalYangParser.g:6284:3: this_XpathPrimaryExpr_0= ruleXpathPrimaryExpr ( () otherlv_2= LeftSquareBracket ( (lv_predicate_3_0= ruleXpathExpression ) ) otherlv_4= RightSquareBracket )*
            {
            if ( state.backtracking==0 ) {

              			newCompositeNode(grammarAccess.getXpathFilterExprAccess().getXpathPrimaryExprParserRuleCall_0());
              		
            }
            pushFollow(FOLLOW_29);
            this_XpathPrimaryExpr_0=ruleXpathPrimaryExpr();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current = this_XpathPrimaryExpr_0;
              			afterParserOrEnumRuleCall();
              		
            }
            // InternalYangParser.g:6292:3: ( () otherlv_2= LeftSquareBracket ( (lv_predicate_3_0= ruleXpathExpression ) ) otherlv_4= RightSquareBracket )*
            loop43:
            do {
                int alt43=2;
                int LA43_0 = input.LA(1);

                if ( (LA43_0==LeftSquareBracket) ) {
                    alt43=1;
                }


                switch (alt43) {
            	case 1 :
            	    // InternalYangParser.g:6293:4: () otherlv_2= LeftSquareBracket ( (lv_predicate_3_0= ruleXpathExpression ) ) otherlv_4= RightSquareBracket
            	    {
            	    // InternalYangParser.g:6293:4: ()
            	    // InternalYangParser.g:6294:5: 
            	    {
            	    if ( state.backtracking==0 ) {

            	      					current = forceCreateModelElementAndSet(
            	      						grammarAccess.getXpathFilterExprAccess().getXpathFilterTargetAction_1_0(),
            	      						current);
            	      				
            	    }

            	    }

            	    otherlv_2=(Token)match(input,LeftSquareBracket,FOLLOW_7); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      				newLeafNode(otherlv_2, grammarAccess.getXpathFilterExprAccess().getLeftSquareBracketKeyword_1_1());
            	      			
            	    }
            	    // InternalYangParser.g:6304:4: ( (lv_predicate_3_0= ruleXpathExpression ) )
            	    // InternalYangParser.g:6305:5: (lv_predicate_3_0= ruleXpathExpression )
            	    {
            	    // InternalYangParser.g:6305:5: (lv_predicate_3_0= ruleXpathExpression )
            	    // InternalYangParser.g:6306:6: lv_predicate_3_0= ruleXpathExpression
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getXpathFilterExprAccess().getPredicateXpathExpressionParserRuleCall_1_2_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_28);
            	    lv_predicate_3_0=ruleXpathExpression();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      						if (current==null) {
            	      							current = createModelElementForParent(grammarAccess.getXpathFilterExprRule());
            	      						}
            	      						set(
            	      							current,
            	      							"predicate",
            	      							lv_predicate_3_0,
            	      							"io.typefox.yang.Yang.XpathExpression");
            	      						afterParserOrEnumRuleCall();
            	      					
            	    }

            	    }


            	    }

            	    otherlv_4=(Token)match(input,RightSquareBracket,FOLLOW_29); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      				newLeafNode(otherlv_4, grammarAccess.getXpathFilterExprAccess().getRightSquareBracketKeyword_1_3());
            	      			
            	    }

            	    }
            	    break;

            	default :
            	    break loop43;
                }
            } while (true);


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleXpathFilterExpr"


    // $ANTLR start "entryRuleXpathPrimaryExpr"
    // InternalYangParser.g:6332:1: entryRuleXpathPrimaryExpr returns [EObject current=null] : iv_ruleXpathPrimaryExpr= ruleXpathPrimaryExpr EOF ;
    public final EObject entryRuleXpathPrimaryExpr() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXpathPrimaryExpr = null;


        try {
            // InternalYangParser.g:6332:57: (iv_ruleXpathPrimaryExpr= ruleXpathPrimaryExpr EOF )
            // InternalYangParser.g:6333:2: iv_ruleXpathPrimaryExpr= ruleXpathPrimaryExpr EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXpathPrimaryExprRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleXpathPrimaryExpr=ruleXpathPrimaryExpr();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXpathPrimaryExpr; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleXpathPrimaryExpr"


    // $ANTLR start "ruleXpathPrimaryExpr"
    // InternalYangParser.g:6339:1: ruleXpathPrimaryExpr returns [EObject current=null] : ( ( () otherlv_1= DollarSign ( (lv_name_2_0= ruleQNAME ) ) ) | (otherlv_3= LeftParenthesis this_XpathExpression_4= ruleXpathExpression otherlv_5= RightParenthesis ) | ( () ( (lv_value_7_0= RULE_STRING ) ) ) | ( () ( (lv_value_9_0= RULE_NUMBER ) ) ) | ( () ( (lv_name_11_0= ruleQNAME ) ) otherlv_12= LeftParenthesis ( ( (lv_args_13_0= ruleXpathExpression ) ) (otherlv_14= Comma ( (lv_args_15_0= ruleXpathExpression ) ) )* )? otherlv_16= RightParenthesis ) | ( () ( (lv_step_18_0= ruleXpathStep ) ) ) | ( () otherlv_20= Solidus ( ( Solidus )=> ( (lv_isDescendants_21_0= Solidus ) ) )? ( ( FullStop | FullStopFullStop | CommercialAt | Ancestor | AncestorOrSelf | Attribute | Child | Descendant | DescendantOrSelf | Following | FollowingSibling | Namespace | Parent | Preceding | PrecedingSibling | Self | Div | And | Or | Mod | Comment | Text | Node | Asterisk | ProcessingInstruction | RULE_ID )=> (lv_step_22_0= ruleXpathStep ) )? ) ) ;
    public final EObject ruleXpathPrimaryExpr() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Token lv_value_7_0=null;
        Token lv_value_9_0=null;
        Token otherlv_12=null;
        Token otherlv_14=null;
        Token otherlv_16=null;
        Token otherlv_20=null;
        Token lv_isDescendants_21_0=null;
        AntlrDatatypeRuleToken lv_name_2_0 = null;

        EObject this_XpathExpression_4 = null;

        AntlrDatatypeRuleToken lv_name_11_0 = null;

        EObject lv_args_13_0 = null;

        EObject lv_args_15_0 = null;

        EObject lv_step_18_0 = null;

        EObject lv_step_22_0 = null;



        	enterRule();

        try {
            // InternalYangParser.g:6345:2: ( ( ( () otherlv_1= DollarSign ( (lv_name_2_0= ruleQNAME ) ) ) | (otherlv_3= LeftParenthesis this_XpathExpression_4= ruleXpathExpression otherlv_5= RightParenthesis ) | ( () ( (lv_value_7_0= RULE_STRING ) ) ) | ( () ( (lv_value_9_0= RULE_NUMBER ) ) ) | ( () ( (lv_name_11_0= ruleQNAME ) ) otherlv_12= LeftParenthesis ( ( (lv_args_13_0= ruleXpathExpression ) ) (otherlv_14= Comma ( (lv_args_15_0= ruleXpathExpression ) ) )* )? otherlv_16= RightParenthesis ) | ( () ( (lv_step_18_0= ruleXpathStep ) ) ) | ( () otherlv_20= Solidus ( ( Solidus )=> ( (lv_isDescendants_21_0= Solidus ) ) )? ( ( FullStop | FullStopFullStop | CommercialAt | Ancestor | AncestorOrSelf | Attribute | Child | Descendant | DescendantOrSelf | Following | FollowingSibling | Namespace | Parent | Preceding | PrecedingSibling | Self | Div | And | Or | Mod | Comment | Text | Node | Asterisk | ProcessingInstruction | RULE_ID )=> (lv_step_22_0= ruleXpathStep ) )? ) ) )
            // InternalYangParser.g:6346:2: ( ( () otherlv_1= DollarSign ( (lv_name_2_0= ruleQNAME ) ) ) | (otherlv_3= LeftParenthesis this_XpathExpression_4= ruleXpathExpression otherlv_5= RightParenthesis ) | ( () ( (lv_value_7_0= RULE_STRING ) ) ) | ( () ( (lv_value_9_0= RULE_NUMBER ) ) ) | ( () ( (lv_name_11_0= ruleQNAME ) ) otherlv_12= LeftParenthesis ( ( (lv_args_13_0= ruleXpathExpression ) ) (otherlv_14= Comma ( (lv_args_15_0= ruleXpathExpression ) ) )* )? otherlv_16= RightParenthesis ) | ( () ( (lv_step_18_0= ruleXpathStep ) ) ) | ( () otherlv_20= Solidus ( ( Solidus )=> ( (lv_isDescendants_21_0= Solidus ) ) )? ( ( FullStop | FullStopFullStop | CommercialAt | Ancestor | AncestorOrSelf | Attribute | Child | Descendant | DescendantOrSelf | Following | FollowingSibling | Namespace | Parent | Preceding | PrecedingSibling | Self | Div | And | Or | Mod | Comment | Text | Node | Asterisk | ProcessingInstruction | RULE_ID )=> (lv_step_22_0= ruleXpathStep ) )? ) )
            {
            // InternalYangParser.g:6346:2: ( ( () otherlv_1= DollarSign ( (lv_name_2_0= ruleQNAME ) ) ) | (otherlv_3= LeftParenthesis this_XpathExpression_4= ruleXpathExpression otherlv_5= RightParenthesis ) | ( () ( (lv_value_7_0= RULE_STRING ) ) ) | ( () ( (lv_value_9_0= RULE_NUMBER ) ) ) | ( () ( (lv_name_11_0= ruleQNAME ) ) otherlv_12= LeftParenthesis ( ( (lv_args_13_0= ruleXpathExpression ) ) (otherlv_14= Comma ( (lv_args_15_0= ruleXpathExpression ) ) )* )? otherlv_16= RightParenthesis ) | ( () ( (lv_step_18_0= ruleXpathStep ) ) ) | ( () otherlv_20= Solidus ( ( Solidus )=> ( (lv_isDescendants_21_0= Solidus ) ) )? ( ( FullStop | FullStopFullStop | CommercialAt | Ancestor | AncestorOrSelf | Attribute | Child | Descendant | DescendantOrSelf | Following | FollowingSibling | Namespace | Parent | Preceding | PrecedingSibling | Self | Div | And | Or | Mod | Comment | Text | Node | Asterisk | ProcessingInstruction | RULE_ID )=> (lv_step_22_0= ruleXpathStep ) )? ) )
            int alt48=7;
            alt48 = dfa48.predict(input);
            switch (alt48) {
                case 1 :
                    // InternalYangParser.g:6347:3: ( () otherlv_1= DollarSign ( (lv_name_2_0= ruleQNAME ) ) )
                    {
                    // InternalYangParser.g:6347:3: ( () otherlv_1= DollarSign ( (lv_name_2_0= ruleQNAME ) ) )
                    // InternalYangParser.g:6348:4: () otherlv_1= DollarSign ( (lv_name_2_0= ruleQNAME ) )
                    {
                    // InternalYangParser.g:6348:4: ()
                    // InternalYangParser.g:6349:5: 
                    {
                    if ( state.backtracking==0 ) {

                      					current = forceCreateModelElement(
                      						grammarAccess.getXpathPrimaryExprAccess().getXpathVariableReferenceAction_0_0(),
                      						current);
                      				
                    }

                    }

                    otherlv_1=(Token)match(input,DollarSign,FOLLOW_6); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_1, grammarAccess.getXpathPrimaryExprAccess().getDollarSignKeyword_0_1());
                      			
                    }
                    // InternalYangParser.g:6359:4: ( (lv_name_2_0= ruleQNAME ) )
                    // InternalYangParser.g:6360:5: (lv_name_2_0= ruleQNAME )
                    {
                    // InternalYangParser.g:6360:5: (lv_name_2_0= ruleQNAME )
                    // InternalYangParser.g:6361:6: lv_name_2_0= ruleQNAME
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getXpathPrimaryExprAccess().getNameQNAMEParserRuleCall_0_2_0());
                      					
                    }
                    pushFollow(FOLLOW_2);
                    lv_name_2_0=ruleQNAME();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getXpathPrimaryExprRule());
                      						}
                      						set(
                      							current,
                      							"name",
                      							lv_name_2_0,
                      							"io.typefox.yang.Yang.QNAME");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalYangParser.g:6380:3: (otherlv_3= LeftParenthesis this_XpathExpression_4= ruleXpathExpression otherlv_5= RightParenthesis )
                    {
                    // InternalYangParser.g:6380:3: (otherlv_3= LeftParenthesis this_XpathExpression_4= ruleXpathExpression otherlv_5= RightParenthesis )
                    // InternalYangParser.g:6381:4: otherlv_3= LeftParenthesis this_XpathExpression_4= ruleXpathExpression otherlv_5= RightParenthesis
                    {
                    otherlv_3=(Token)match(input,LeftParenthesis,FOLLOW_7); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_3, grammarAccess.getXpathPrimaryExprAccess().getLeftParenthesisKeyword_1_0());
                      			
                    }
                    if ( state.backtracking==0 ) {

                      				newCompositeNode(grammarAccess.getXpathPrimaryExprAccess().getXpathExpressionParserRuleCall_1_1());
                      			
                    }
                    pushFollow(FOLLOW_15);
                    this_XpathExpression_4=ruleXpathExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = this_XpathExpression_4;
                      				afterParserOrEnumRuleCall();
                      			
                    }
                    otherlv_5=(Token)match(input,RightParenthesis,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_5, grammarAccess.getXpathPrimaryExprAccess().getRightParenthesisKeyword_1_2());
                      			
                    }

                    }


                    }
                    break;
                case 3 :
                    // InternalYangParser.g:6399:3: ( () ( (lv_value_7_0= RULE_STRING ) ) )
                    {
                    // InternalYangParser.g:6399:3: ( () ( (lv_value_7_0= RULE_STRING ) ) )
                    // InternalYangParser.g:6400:4: () ( (lv_value_7_0= RULE_STRING ) )
                    {
                    // InternalYangParser.g:6400:4: ()
                    // InternalYangParser.g:6401:5: 
                    {
                    if ( state.backtracking==0 ) {

                      					current = forceCreateModelElement(
                      						grammarAccess.getXpathPrimaryExprAccess().getXpathStringLiteralAction_2_0(),
                      						current);
                      				
                    }

                    }

                    // InternalYangParser.g:6407:4: ( (lv_value_7_0= RULE_STRING ) )
                    // InternalYangParser.g:6408:5: (lv_value_7_0= RULE_STRING )
                    {
                    // InternalYangParser.g:6408:5: (lv_value_7_0= RULE_STRING )
                    // InternalYangParser.g:6409:6: lv_value_7_0= RULE_STRING
                    {
                    lv_value_7_0=(Token)match(input,RULE_STRING,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						newLeafNode(lv_value_7_0, grammarAccess.getXpathPrimaryExprAccess().getValueSTRINGTerminalRuleCall_2_1_0());
                      					
                    }
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElement(grammarAccess.getXpathPrimaryExprRule());
                      						}
                      						setWithLastConsumed(
                      							current,
                      							"value",
                      							lv_value_7_0,
                      							"io.typefox.yang.Yang.STRING");
                      					
                    }

                    }


                    }


                    }


                    }
                    break;
                case 4 :
                    // InternalYangParser.g:6427:3: ( () ( (lv_value_9_0= RULE_NUMBER ) ) )
                    {
                    // InternalYangParser.g:6427:3: ( () ( (lv_value_9_0= RULE_NUMBER ) ) )
                    // InternalYangParser.g:6428:4: () ( (lv_value_9_0= RULE_NUMBER ) )
                    {
                    // InternalYangParser.g:6428:4: ()
                    // InternalYangParser.g:6429:5: 
                    {
                    if ( state.backtracking==0 ) {

                      					current = forceCreateModelElement(
                      						grammarAccess.getXpathPrimaryExprAccess().getXpathNumberLiteralAction_3_0(),
                      						current);
                      				
                    }

                    }

                    // InternalYangParser.g:6435:4: ( (lv_value_9_0= RULE_NUMBER ) )
                    // InternalYangParser.g:6436:5: (lv_value_9_0= RULE_NUMBER )
                    {
                    // InternalYangParser.g:6436:5: (lv_value_9_0= RULE_NUMBER )
                    // InternalYangParser.g:6437:6: lv_value_9_0= RULE_NUMBER
                    {
                    lv_value_9_0=(Token)match(input,RULE_NUMBER,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						newLeafNode(lv_value_9_0, grammarAccess.getXpathPrimaryExprAccess().getValueNUMBERTerminalRuleCall_3_1_0());
                      					
                    }
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElement(grammarAccess.getXpathPrimaryExprRule());
                      						}
                      						setWithLastConsumed(
                      							current,
                      							"value",
                      							lv_value_9_0,
                      							"io.typefox.yang.Yang.NUMBER");
                      					
                    }

                    }


                    }


                    }


                    }
                    break;
                case 5 :
                    // InternalYangParser.g:6455:3: ( () ( (lv_name_11_0= ruleQNAME ) ) otherlv_12= LeftParenthesis ( ( (lv_args_13_0= ruleXpathExpression ) ) (otherlv_14= Comma ( (lv_args_15_0= ruleXpathExpression ) ) )* )? otherlv_16= RightParenthesis )
                    {
                    // InternalYangParser.g:6455:3: ( () ( (lv_name_11_0= ruleQNAME ) ) otherlv_12= LeftParenthesis ( ( (lv_args_13_0= ruleXpathExpression ) ) (otherlv_14= Comma ( (lv_args_15_0= ruleXpathExpression ) ) )* )? otherlv_16= RightParenthesis )
                    // InternalYangParser.g:6456:4: () ( (lv_name_11_0= ruleQNAME ) ) otherlv_12= LeftParenthesis ( ( (lv_args_13_0= ruleXpathExpression ) ) (otherlv_14= Comma ( (lv_args_15_0= ruleXpathExpression ) ) )* )? otherlv_16= RightParenthesis
                    {
                    // InternalYangParser.g:6456:4: ()
                    // InternalYangParser.g:6457:5: 
                    {
                    if ( state.backtracking==0 ) {

                      					current = forceCreateModelElement(
                      						grammarAccess.getXpathPrimaryExprAccess().getXpathFunctionCallAction_4_0(),
                      						current);
                      				
                    }

                    }

                    // InternalYangParser.g:6463:4: ( (lv_name_11_0= ruleQNAME ) )
                    // InternalYangParser.g:6464:5: (lv_name_11_0= ruleQNAME )
                    {
                    // InternalYangParser.g:6464:5: (lv_name_11_0= ruleQNAME )
                    // InternalYangParser.g:6465:6: lv_name_11_0= ruleQNAME
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getXpathPrimaryExprAccess().getNameQNAMEParserRuleCall_4_1_0());
                      					
                    }
                    pushFollow(FOLLOW_30);
                    lv_name_11_0=ruleQNAME();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getXpathPrimaryExprRule());
                      						}
                      						set(
                      							current,
                      							"name",
                      							lv_name_11_0,
                      							"io.typefox.yang.Yang.QNAME");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }

                    otherlv_12=(Token)match(input,LeftParenthesis,FOLLOW_31); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_12, grammarAccess.getXpathPrimaryExprAccess().getLeftParenthesisKeyword_4_2());
                      			
                    }
                    // InternalYangParser.g:6486:4: ( ( (lv_args_13_0= ruleXpathExpression ) ) (otherlv_14= Comma ( (lv_args_15_0= ruleXpathExpression ) ) )* )?
                    int alt45=2;
                    int LA45_0 = input.LA(1);

                    if ( ((LA45_0>=ProcessingInstruction && LA45_0<=LessThanSignLessThanSignLessThanSignLessThanSign)||(LA45_0>=Base && LA45_0<=Mod)||LA45_0==Rpc||LA45_0==FullStopFullStop||(LA45_0>=Or && LA45_0<=LeftParenthesis)||LA45_0==Asterisk||(LA45_0>=HyphenMinus && LA45_0<=Solidus)||LA45_0==CommercialAt||LA45_0==RULE_ID||(LA45_0>=RULE_STRING && LA45_0<=RULE_NUMBER)) ) {
                        alt45=1;
                    }
                    switch (alt45) {
                        case 1 :
                            // InternalYangParser.g:6487:5: ( (lv_args_13_0= ruleXpathExpression ) ) (otherlv_14= Comma ( (lv_args_15_0= ruleXpathExpression ) ) )*
                            {
                            // InternalYangParser.g:6487:5: ( (lv_args_13_0= ruleXpathExpression ) )
                            // InternalYangParser.g:6488:6: (lv_args_13_0= ruleXpathExpression )
                            {
                            // InternalYangParser.g:6488:6: (lv_args_13_0= ruleXpathExpression )
                            // InternalYangParser.g:6489:7: lv_args_13_0= ruleXpathExpression
                            {
                            if ( state.backtracking==0 ) {

                              							newCompositeNode(grammarAccess.getXpathPrimaryExprAccess().getArgsXpathExpressionParserRuleCall_4_3_0_0());
                              						
                            }
                            pushFollow(FOLLOW_32);
                            lv_args_13_0=ruleXpathExpression();

                            state._fsp--;
                            if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              							if (current==null) {
                              								current = createModelElementForParent(grammarAccess.getXpathPrimaryExprRule());
                              							}
                              							add(
                              								current,
                              								"args",
                              								lv_args_13_0,
                              								"io.typefox.yang.Yang.XpathExpression");
                              							afterParserOrEnumRuleCall();
                              						
                            }

                            }


                            }

                            // InternalYangParser.g:6506:5: (otherlv_14= Comma ( (lv_args_15_0= ruleXpathExpression ) ) )*
                            loop44:
                            do {
                                int alt44=2;
                                int LA44_0 = input.LA(1);

                                if ( (LA44_0==Comma) ) {
                                    alt44=1;
                                }


                                switch (alt44) {
                            	case 1 :
                            	    // InternalYangParser.g:6507:6: otherlv_14= Comma ( (lv_args_15_0= ruleXpathExpression ) )
                            	    {
                            	    otherlv_14=(Token)match(input,Comma,FOLLOW_7); if (state.failed) return current;
                            	    if ( state.backtracking==0 ) {

                            	      						newLeafNode(otherlv_14, grammarAccess.getXpathPrimaryExprAccess().getCommaKeyword_4_3_1_0());
                            	      					
                            	    }
                            	    // InternalYangParser.g:6511:6: ( (lv_args_15_0= ruleXpathExpression ) )
                            	    // InternalYangParser.g:6512:7: (lv_args_15_0= ruleXpathExpression )
                            	    {
                            	    // InternalYangParser.g:6512:7: (lv_args_15_0= ruleXpathExpression )
                            	    // InternalYangParser.g:6513:8: lv_args_15_0= ruleXpathExpression
                            	    {
                            	    if ( state.backtracking==0 ) {

                            	      								newCompositeNode(grammarAccess.getXpathPrimaryExprAccess().getArgsXpathExpressionParserRuleCall_4_3_1_1_0());
                            	      							
                            	    }
                            	    pushFollow(FOLLOW_32);
                            	    lv_args_15_0=ruleXpathExpression();

                            	    state._fsp--;
                            	    if (state.failed) return current;
                            	    if ( state.backtracking==0 ) {

                            	      								if (current==null) {
                            	      									current = createModelElementForParent(grammarAccess.getXpathPrimaryExprRule());
                            	      								}
                            	      								add(
                            	      									current,
                            	      									"args",
                            	      									lv_args_15_0,
                            	      									"io.typefox.yang.Yang.XpathExpression");
                            	      								afterParserOrEnumRuleCall();
                            	      							
                            	    }

                            	    }


                            	    }


                            	    }
                            	    break;

                            	default :
                            	    break loop44;
                                }
                            } while (true);


                            }
                            break;

                    }

                    otherlv_16=(Token)match(input,RightParenthesis,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_16, grammarAccess.getXpathPrimaryExprAccess().getRightParenthesisKeyword_4_4());
                      			
                    }

                    }


                    }
                    break;
                case 6 :
                    // InternalYangParser.g:6538:3: ( () ( (lv_step_18_0= ruleXpathStep ) ) )
                    {
                    // InternalYangParser.g:6538:3: ( () ( (lv_step_18_0= ruleXpathStep ) ) )
                    // InternalYangParser.g:6539:4: () ( (lv_step_18_0= ruleXpathStep ) )
                    {
                    // InternalYangParser.g:6539:4: ()
                    // InternalYangParser.g:6540:5: 
                    {
                    if ( state.backtracking==0 ) {

                      					current = forceCreateModelElement(
                      						grammarAccess.getXpathPrimaryExprAccess().getRelativePathAction_5_0(),
                      						current);
                      				
                    }

                    }

                    // InternalYangParser.g:6546:4: ( (lv_step_18_0= ruleXpathStep ) )
                    // InternalYangParser.g:6547:5: (lv_step_18_0= ruleXpathStep )
                    {
                    // InternalYangParser.g:6547:5: (lv_step_18_0= ruleXpathStep )
                    // InternalYangParser.g:6548:6: lv_step_18_0= ruleXpathStep
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getXpathPrimaryExprAccess().getStepXpathStepParserRuleCall_5_1_0());
                      					
                    }
                    pushFollow(FOLLOW_2);
                    lv_step_18_0=ruleXpathStep();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getXpathPrimaryExprRule());
                      						}
                      						set(
                      							current,
                      							"step",
                      							lv_step_18_0,
                      							"io.typefox.yang.Yang.XpathStep");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }


                    }


                    }
                    break;
                case 7 :
                    // InternalYangParser.g:6567:3: ( () otherlv_20= Solidus ( ( Solidus )=> ( (lv_isDescendants_21_0= Solidus ) ) )? ( ( FullStop | FullStopFullStop | CommercialAt | Ancestor | AncestorOrSelf | Attribute | Child | Descendant | DescendantOrSelf | Following | FollowingSibling | Namespace | Parent | Preceding | PrecedingSibling | Self | Div | And | Or | Mod | Comment | Text | Node | Asterisk | ProcessingInstruction | RULE_ID )=> (lv_step_22_0= ruleXpathStep ) )? )
                    {
                    // InternalYangParser.g:6567:3: ( () otherlv_20= Solidus ( ( Solidus )=> ( (lv_isDescendants_21_0= Solidus ) ) )? ( ( FullStop | FullStopFullStop | CommercialAt | Ancestor | AncestorOrSelf | Attribute | Child | Descendant | DescendantOrSelf | Following | FollowingSibling | Namespace | Parent | Preceding | PrecedingSibling | Self | Div | And | Or | Mod | Comment | Text | Node | Asterisk | ProcessingInstruction | RULE_ID )=> (lv_step_22_0= ruleXpathStep ) )? )
                    // InternalYangParser.g:6568:4: () otherlv_20= Solidus ( ( Solidus )=> ( (lv_isDescendants_21_0= Solidus ) ) )? ( ( FullStop | FullStopFullStop | CommercialAt | Ancestor | AncestorOrSelf | Attribute | Child | Descendant | DescendantOrSelf | Following | FollowingSibling | Namespace | Parent | Preceding | PrecedingSibling | Self | Div | And | Or | Mod | Comment | Text | Node | Asterisk | ProcessingInstruction | RULE_ID )=> (lv_step_22_0= ruleXpathStep ) )?
                    {
                    // InternalYangParser.g:6568:4: ()
                    // InternalYangParser.g:6569:5: 
                    {
                    if ( state.backtracking==0 ) {

                      					current = forceCreateModelElement(
                      						grammarAccess.getXpathPrimaryExprAccess().getAbsolutePathAction_6_0(),
                      						current);
                      				
                    }

                    }

                    otherlv_20=(Token)match(input,Solidus,FOLLOW_33); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_20, grammarAccess.getXpathPrimaryExprAccess().getSolidusKeyword_6_1());
                      			
                    }
                    // InternalYangParser.g:6579:4: ( ( Solidus )=> ( (lv_isDescendants_21_0= Solidus ) ) )?
                    int alt46=2;
                    alt46 = dfa46.predict(input);
                    switch (alt46) {
                        case 1 :
                            // InternalYangParser.g:6580:5: ( Solidus )=> ( (lv_isDescendants_21_0= Solidus ) )
                            {
                            // InternalYangParser.g:6581:5: ( (lv_isDescendants_21_0= Solidus ) )
                            // InternalYangParser.g:6582:6: (lv_isDescendants_21_0= Solidus )
                            {
                            // InternalYangParser.g:6582:6: (lv_isDescendants_21_0= Solidus )
                            // InternalYangParser.g:6583:7: lv_isDescendants_21_0= Solidus
                            {
                            lv_isDescendants_21_0=(Token)match(input,Solidus,FOLLOW_34); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              							newLeafNode(lv_isDescendants_21_0, grammarAccess.getXpathPrimaryExprAccess().getIsDescendantsSolidusKeyword_6_2_0_0());
                              						
                            }
                            if ( state.backtracking==0 ) {

                              							if (current==null) {
                              								current = createModelElement(grammarAccess.getXpathPrimaryExprRule());
                              							}
                              							setWithLastConsumed(current, "isDescendants", true, "/");
                              						
                            }

                            }


                            }


                            }
                            break;

                    }

                    // InternalYangParser.g:6596:4: ( ( FullStop | FullStopFullStop | CommercialAt | Ancestor | AncestorOrSelf | Attribute | Child | Descendant | DescendantOrSelf | Following | FollowingSibling | Namespace | Parent | Preceding | PrecedingSibling | Self | Div | And | Or | Mod | Comment | Text | Node | Asterisk | ProcessingInstruction | RULE_ID )=> (lv_step_22_0= ruleXpathStep ) )?
                    int alt47=2;
                    alt47 = dfa47.predict(input);
                    switch (alt47) {
                        case 1 :
                            // InternalYangParser.g:6597:5: ( FullStop | FullStopFullStop | CommercialAt | Ancestor | AncestorOrSelf | Attribute | Child | Descendant | DescendantOrSelf | Following | FollowingSibling | Namespace | Parent | Preceding | PrecedingSibling | Self | Div | And | Or | Mod | Comment | Text | Node | Asterisk | ProcessingInstruction | RULE_ID )=> (lv_step_22_0= ruleXpathStep )
                            {
                            // InternalYangParser.g:6598:5: (lv_step_22_0= ruleXpathStep )
                            // InternalYangParser.g:6599:6: lv_step_22_0= ruleXpathStep
                            {
                            if ( state.backtracking==0 ) {

                              						newCompositeNode(grammarAccess.getXpathPrimaryExprAccess().getStepXpathStepParserRuleCall_6_3_0());
                              					
                            }
                            pushFollow(FOLLOW_2);
                            lv_step_22_0=ruleXpathStep();

                            state._fsp--;
                            if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              						if (current==null) {
                              							current = createModelElementForParent(grammarAccess.getXpathPrimaryExprRule());
                              						}
                              						set(
                              							current,
                              							"step",
                              							lv_step_22_0,
                              							"io.typefox.yang.Yang.XpathStep");
                              						afterParserOrEnumRuleCall();
                              					
                            }

                            }


                            }
                            break;

                    }


                    }


                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleXpathPrimaryExpr"


    // $ANTLR start "entryRuleXpathStep"
    // InternalYangParser.g:6621:1: entryRuleXpathStep returns [EObject current=null] : iv_ruleXpathStep= ruleXpathStep EOF ;
    public final EObject entryRuleXpathStep() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXpathStep = null;


        try {
            // InternalYangParser.g:6621:50: (iv_ruleXpathStep= ruleXpathStep EOF )
            // InternalYangParser.g:6622:2: iv_ruleXpathStep= ruleXpathStep EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXpathStepRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleXpathStep=ruleXpathStep();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXpathStep; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleXpathStep"


    // $ANTLR start "ruleXpathStep"
    // InternalYangParser.g:6628:1: ruleXpathStep returns [EObject current=null] : ( ( () ( ( ruleDot ) ) ) | ( () ( ( ruleDotDot ) ) ) | ( () otherlv_5= CommercialAt ( (lv_attributeName_6_0= ruleXpathIDOrKw ) ) ) | ( ( ( (lv_axis_7_0= ruleXpathAxisName ) ) otherlv_8= Colon otherlv_9= Colon )? ( (lv_node_10_0= ruleXpathNodeTest ) ) ) ) ;
    public final EObject ruleXpathStep() throws RecognitionException {
        EObject current = null;

        Token otherlv_5=null;
        Token otherlv_8=null;
        Token otherlv_9=null;
        AntlrDatatypeRuleToken lv_attributeName_6_0 = null;

        AntlrDatatypeRuleToken lv_axis_7_0 = null;

        EObject lv_node_10_0 = null;



        	enterRule();

        try {
            // InternalYangParser.g:6634:2: ( ( ( () ( ( ruleDot ) ) ) | ( () ( ( ruleDotDot ) ) ) | ( () otherlv_5= CommercialAt ( (lv_attributeName_6_0= ruleXpathIDOrKw ) ) ) | ( ( ( (lv_axis_7_0= ruleXpathAxisName ) ) otherlv_8= Colon otherlv_9= Colon )? ( (lv_node_10_0= ruleXpathNodeTest ) ) ) ) )
            // InternalYangParser.g:6635:2: ( ( () ( ( ruleDot ) ) ) | ( () ( ( ruleDotDot ) ) ) | ( () otherlv_5= CommercialAt ( (lv_attributeName_6_0= ruleXpathIDOrKw ) ) ) | ( ( ( (lv_axis_7_0= ruleXpathAxisName ) ) otherlv_8= Colon otherlv_9= Colon )? ( (lv_node_10_0= ruleXpathNodeTest ) ) ) )
            {
            // InternalYangParser.g:6635:2: ( ( () ( ( ruleDot ) ) ) | ( () ( ( ruleDotDot ) ) ) | ( () otherlv_5= CommercialAt ( (lv_attributeName_6_0= ruleXpathIDOrKw ) ) ) | ( ( ( (lv_axis_7_0= ruleXpathAxisName ) ) otherlv_8= Colon otherlv_9= Colon )? ( (lv_node_10_0= ruleXpathNodeTest ) ) ) )
            int alt50=4;
            switch ( input.LA(1) ) {
            case FullStop:
                {
                alt50=1;
                }
                break;
            case FullStopFullStop:
                {
                alt50=2;
                }
                break;
            case CommercialAt:
                {
                alt50=3;
                }
                break;
            case ProcessingInstruction:
            case DescendantOrSelf:
            case FollowingSibling:
            case PrecedingSibling:
            case AncestorOrSelf:
            case Descendant:
            case Attribute:
            case Following:
            case Namespace:
            case Preceding:
            case Ancestor:
            case Comment:
            case Parent:
            case Child:
            case Node:
            case Self:
            case Text:
            case And:
            case Div:
            case Mod:
            case Or:
            case Asterisk:
            case RULE_ID:
                {
                alt50=4;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 50, 0, input);

                throw nvae;
            }

            switch (alt50) {
                case 1 :
                    // InternalYangParser.g:6636:3: ( () ( ( ruleDot ) ) )
                    {
                    // InternalYangParser.g:6636:3: ( () ( ( ruleDot ) ) )
                    // InternalYangParser.g:6637:4: () ( ( ruleDot ) )
                    {
                    // InternalYangParser.g:6637:4: ()
                    // InternalYangParser.g:6638:5: 
                    {
                    if ( state.backtracking==0 ) {

                      					current = forceCreateModelElement(
                      						grammarAccess.getXpathStepAccess().getCurrentRefAction_0_0(),
                      						current);
                      				
                    }

                    }

                    // InternalYangParser.g:6644:4: ( ( ruleDot ) )
                    // InternalYangParser.g:6645:5: ( ruleDot )
                    {
                    // InternalYangParser.g:6645:5: ( ruleDot )
                    // InternalYangParser.g:6646:6: ruleDot
                    {
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElement(grammarAccess.getXpathStepRule());
                      						}
                      					
                    }
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getXpathStepAccess().getRefSchemaNodeCrossReference_0_1_0());
                      					
                    }
                    pushFollow(FOLLOW_2);
                    ruleDot();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalYangParser.g:6662:3: ( () ( ( ruleDotDot ) ) )
                    {
                    // InternalYangParser.g:6662:3: ( () ( ( ruleDotDot ) ) )
                    // InternalYangParser.g:6663:4: () ( ( ruleDotDot ) )
                    {
                    // InternalYangParser.g:6663:4: ()
                    // InternalYangParser.g:6664:5: 
                    {
                    if ( state.backtracking==0 ) {

                      					current = forceCreateModelElement(
                      						grammarAccess.getXpathStepAccess().getParentRefAction_1_0(),
                      						current);
                      				
                    }

                    }

                    // InternalYangParser.g:6670:4: ( ( ruleDotDot ) )
                    // InternalYangParser.g:6671:5: ( ruleDotDot )
                    {
                    // InternalYangParser.g:6671:5: ( ruleDotDot )
                    // InternalYangParser.g:6672:6: ruleDotDot
                    {
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElement(grammarAccess.getXpathStepRule());
                      						}
                      					
                    }
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getXpathStepAccess().getRefSchemaNodeCrossReference_1_1_0());
                      					
                    }
                    pushFollow(FOLLOW_2);
                    ruleDotDot();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }


                    }


                    }
                    break;
                case 3 :
                    // InternalYangParser.g:6688:3: ( () otherlv_5= CommercialAt ( (lv_attributeName_6_0= ruleXpathIDOrKw ) ) )
                    {
                    // InternalYangParser.g:6688:3: ( () otherlv_5= CommercialAt ( (lv_attributeName_6_0= ruleXpathIDOrKw ) ) )
                    // InternalYangParser.g:6689:4: () otherlv_5= CommercialAt ( (lv_attributeName_6_0= ruleXpathIDOrKw ) )
                    {
                    // InternalYangParser.g:6689:4: ()
                    // InternalYangParser.g:6690:5: 
                    {
                    if ( state.backtracking==0 ) {

                      					current = forceCreateModelElement(
                      						grammarAccess.getXpathStepAccess().getAbbrevAttributeStepAction_2_0(),
                      						current);
                      				
                    }

                    }

                    otherlv_5=(Token)match(input,CommercialAt,FOLLOW_35); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_5, grammarAccess.getXpathStepAccess().getCommercialAtKeyword_2_1());
                      			
                    }
                    // InternalYangParser.g:6700:4: ( (lv_attributeName_6_0= ruleXpathIDOrKw ) )
                    // InternalYangParser.g:6701:5: (lv_attributeName_6_0= ruleXpathIDOrKw )
                    {
                    // InternalYangParser.g:6701:5: (lv_attributeName_6_0= ruleXpathIDOrKw )
                    // InternalYangParser.g:6702:6: lv_attributeName_6_0= ruleXpathIDOrKw
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getXpathStepAccess().getAttributeNameXpathIDOrKwParserRuleCall_2_2_0());
                      					
                    }
                    pushFollow(FOLLOW_2);
                    lv_attributeName_6_0=ruleXpathIDOrKw();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getXpathStepRule());
                      						}
                      						set(
                      							current,
                      							"attributeName",
                      							lv_attributeName_6_0,
                      							"io.typefox.yang.Yang.XpathIDOrKw");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }


                    }


                    }
                    break;
                case 4 :
                    // InternalYangParser.g:6721:3: ( ( ( (lv_axis_7_0= ruleXpathAxisName ) ) otherlv_8= Colon otherlv_9= Colon )? ( (lv_node_10_0= ruleXpathNodeTest ) ) )
                    {
                    // InternalYangParser.g:6721:3: ( ( ( (lv_axis_7_0= ruleXpathAxisName ) ) otherlv_8= Colon otherlv_9= Colon )? ( (lv_node_10_0= ruleXpathNodeTest ) ) )
                    // InternalYangParser.g:6722:4: ( ( (lv_axis_7_0= ruleXpathAxisName ) ) otherlv_8= Colon otherlv_9= Colon )? ( (lv_node_10_0= ruleXpathNodeTest ) )
                    {
                    // InternalYangParser.g:6722:4: ( ( (lv_axis_7_0= ruleXpathAxisName ) ) otherlv_8= Colon otherlv_9= Colon )?
                    int alt49=2;
                    alt49 = dfa49.predict(input);
                    switch (alt49) {
                        case 1 :
                            // InternalYangParser.g:6723:5: ( (lv_axis_7_0= ruleXpathAxisName ) ) otherlv_8= Colon otherlv_9= Colon
                            {
                            // InternalYangParser.g:6723:5: ( (lv_axis_7_0= ruleXpathAxisName ) )
                            // InternalYangParser.g:6724:6: (lv_axis_7_0= ruleXpathAxisName )
                            {
                            // InternalYangParser.g:6724:6: (lv_axis_7_0= ruleXpathAxisName )
                            // InternalYangParser.g:6725:7: lv_axis_7_0= ruleXpathAxisName
                            {
                            if ( state.backtracking==0 ) {

                              							newCompositeNode(grammarAccess.getXpathStepAccess().getAxisXpathAxisNameParserRuleCall_3_0_0_0());
                              						
                            }
                            pushFollow(FOLLOW_36);
                            lv_axis_7_0=ruleXpathAxisName();

                            state._fsp--;
                            if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              							if (current==null) {
                              								current = createModelElementForParent(grammarAccess.getXpathStepRule());
                              							}
                              							set(
                              								current,
                              								"axis",
                              								lv_axis_7_0,
                              								"io.typefox.yang.Yang.XpathAxisName");
                              							afterParserOrEnumRuleCall();
                              						
                            }

                            }


                            }

                            otherlv_8=(Token)match(input,Colon,FOLLOW_36); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              					newLeafNode(otherlv_8, grammarAccess.getXpathStepAccess().getColonKeyword_3_0_1());
                              				
                            }
                            otherlv_9=(Token)match(input,Colon,FOLLOW_26); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              					newLeafNode(otherlv_9, grammarAccess.getXpathStepAccess().getColonKeyword_3_0_2());
                              				
                            }

                            }
                            break;

                    }

                    // InternalYangParser.g:6751:4: ( (lv_node_10_0= ruleXpathNodeTest ) )
                    // InternalYangParser.g:6752:5: (lv_node_10_0= ruleXpathNodeTest )
                    {
                    // InternalYangParser.g:6752:5: (lv_node_10_0= ruleXpathNodeTest )
                    // InternalYangParser.g:6753:6: lv_node_10_0= ruleXpathNodeTest
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getXpathStepAccess().getNodeXpathNodeTestParserRuleCall_3_1_0());
                      					
                    }
                    pushFollow(FOLLOW_2);
                    lv_node_10_0=ruleXpathNodeTest();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getXpathStepRule());
                      						}
                      						set(
                      							current,
                      							"node",
                      							lv_node_10_0,
                      							"io.typefox.yang.Yang.XpathNodeTest");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }


                    }


                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleXpathStep"


    // $ANTLR start "entryRuleDot"
    // InternalYangParser.g:6775:1: entryRuleDot returns [String current=null] : iv_ruleDot= ruleDot EOF ;
    public final String entryRuleDot() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleDot = null;


        try {
            // InternalYangParser.g:6775:43: (iv_ruleDot= ruleDot EOF )
            // InternalYangParser.g:6776:2: iv_ruleDot= ruleDot EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getDotRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleDot=ruleDot();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleDot.getText(); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleDot"


    // $ANTLR start "ruleDot"
    // InternalYangParser.g:6782:1: ruleDot returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : kw= FullStop ;
    public final AntlrDatatypeRuleToken ruleDot() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;


        	enterRule();

        try {
            // InternalYangParser.g:6788:2: (kw= FullStop )
            // InternalYangParser.g:6789:2: kw= FullStop
            {
            kw=(Token)match(input,FullStop,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              		current.merge(kw);
              		newLeafNode(kw, grammarAccess.getDotAccess().getFullStopKeyword());
              	
            }

            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleDot"


    // $ANTLR start "entryRuleDotDot"
    // InternalYangParser.g:6797:1: entryRuleDotDot returns [String current=null] : iv_ruleDotDot= ruleDotDot EOF ;
    public final String entryRuleDotDot() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleDotDot = null;


        try {
            // InternalYangParser.g:6797:46: (iv_ruleDotDot= ruleDotDot EOF )
            // InternalYangParser.g:6798:2: iv_ruleDotDot= ruleDotDot EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getDotDotRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleDotDot=ruleDotDot();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleDotDot.getText(); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleDotDot"


    // $ANTLR start "ruleDotDot"
    // InternalYangParser.g:6804:1: ruleDotDot returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : kw= FullStopFullStop ;
    public final AntlrDatatypeRuleToken ruleDotDot() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;


        	enterRule();

        try {
            // InternalYangParser.g:6810:2: (kw= FullStopFullStop )
            // InternalYangParser.g:6811:2: kw= FullStopFullStop
            {
            kw=(Token)match(input,FullStopFullStop,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              		current.merge(kw);
              		newLeafNode(kw, grammarAccess.getDotDotAccess().getFullStopFullStopKeyword());
              	
            }

            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleDotDot"


    // $ANTLR start "entryRuleXpathNodeTest"
    // InternalYangParser.g:6819:1: entryRuleXpathNodeTest returns [EObject current=null] : iv_ruleXpathNodeTest= ruleXpathNodeTest EOF ;
    public final EObject entryRuleXpathNodeTest() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXpathNodeTest = null;


        try {
            // InternalYangParser.g:6819:54: (iv_ruleXpathNodeTest= ruleXpathNodeTest EOF )
            // InternalYangParser.g:6820:2: iv_ruleXpathNodeTest= ruleXpathNodeTest EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXpathNodeTestRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleXpathNodeTest=ruleXpathNodeTest();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXpathNodeTest; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleXpathNodeTest"


    // $ANTLR start "ruleXpathNodeTest"
    // InternalYangParser.g:6826:1: ruleXpathNodeTest returns [EObject current=null] : (this_XpathNameTest_0= ruleXpathNameTest | ( () ( (lv_name_2_0= ruleXpathNodeType ) ) otherlv_3= LeftParenthesis otherlv_4= RightParenthesis ) | ( () otherlv_6= ProcessingInstruction otherlv_7= LeftParenthesis ( (lv_instruction_8_0= RULE_STRING ) ) otherlv_9= RightParenthesis ) ) ;
    public final EObject ruleXpathNodeTest() throws RecognitionException {
        EObject current = null;

        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        Token otherlv_7=null;
        Token lv_instruction_8_0=null;
        Token otherlv_9=null;
        EObject this_XpathNameTest_0 = null;

        AntlrDatatypeRuleToken lv_name_2_0 = null;



        	enterRule();

        try {
            // InternalYangParser.g:6832:2: ( (this_XpathNameTest_0= ruleXpathNameTest | ( () ( (lv_name_2_0= ruleXpathNodeType ) ) otherlv_3= LeftParenthesis otherlv_4= RightParenthesis ) | ( () otherlv_6= ProcessingInstruction otherlv_7= LeftParenthesis ( (lv_instruction_8_0= RULE_STRING ) ) otherlv_9= RightParenthesis ) ) )
            // InternalYangParser.g:6833:2: (this_XpathNameTest_0= ruleXpathNameTest | ( () ( (lv_name_2_0= ruleXpathNodeType ) ) otherlv_3= LeftParenthesis otherlv_4= RightParenthesis ) | ( () otherlv_6= ProcessingInstruction otherlv_7= LeftParenthesis ( (lv_instruction_8_0= RULE_STRING ) ) otherlv_9= RightParenthesis ) )
            {
            // InternalYangParser.g:6833:2: (this_XpathNameTest_0= ruleXpathNameTest | ( () ( (lv_name_2_0= ruleXpathNodeType ) ) otherlv_3= LeftParenthesis otherlv_4= RightParenthesis ) | ( () otherlv_6= ProcessingInstruction otherlv_7= LeftParenthesis ( (lv_instruction_8_0= RULE_STRING ) ) otherlv_9= RightParenthesis ) )
            int alt51=3;
            switch ( input.LA(1) ) {
            case DescendantOrSelf:
            case FollowingSibling:
            case PrecedingSibling:
            case AncestorOrSelf:
            case Descendant:
            case Attribute:
            case Following:
            case Namespace:
            case Preceding:
            case Ancestor:
            case Parent:
            case Child:
            case Self:
            case And:
            case Div:
            case Mod:
            case Or:
            case Asterisk:
            case RULE_ID:
                {
                alt51=1;
                }
                break;
            case Comment:
                {
                int LA51_2 = input.LA(2);

                if ( (LA51_2==EOF||LA51_2==And||LA51_2==Div||LA51_2==Mod||LA51_2==ExclamationMarkEqualsSign||(LA51_2>=LessThanSignEqualsSign && LA51_2<=Or)||(LA51_2>=RightParenthesis && LA51_2<=HyphenMinus)||LA51_2==Solidus||(LA51_2>=Semicolon && LA51_2<=GreaterThanSign)||(LA51_2>=LeftSquareBracket && LA51_2<=VerticalLine)) ) {
                    alt51=1;
                }
                else if ( (LA51_2==LeftParenthesis) ) {
                    alt51=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 51, 2, input);

                    throw nvae;
                }
                }
                break;
            case Text:
                {
                int LA51_3 = input.LA(2);

                if ( (LA51_3==EOF||LA51_3==And||LA51_3==Div||LA51_3==Mod||LA51_3==ExclamationMarkEqualsSign||(LA51_3>=LessThanSignEqualsSign && LA51_3<=Or)||(LA51_3>=RightParenthesis && LA51_3<=HyphenMinus)||LA51_3==Solidus||(LA51_3>=Semicolon && LA51_3<=GreaterThanSign)||(LA51_3>=LeftSquareBracket && LA51_3<=VerticalLine)) ) {
                    alt51=1;
                }
                else if ( (LA51_3==LeftParenthesis) ) {
                    alt51=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 51, 3, input);

                    throw nvae;
                }
                }
                break;
            case Node:
                {
                int LA51_4 = input.LA(2);

                if ( (LA51_4==LeftParenthesis) ) {
                    alt51=2;
                }
                else if ( (LA51_4==EOF||LA51_4==And||LA51_4==Div||LA51_4==Mod||LA51_4==ExclamationMarkEqualsSign||(LA51_4>=LessThanSignEqualsSign && LA51_4<=Or)||(LA51_4>=RightParenthesis && LA51_4<=HyphenMinus)||LA51_4==Solidus||(LA51_4>=Semicolon && LA51_4<=GreaterThanSign)||(LA51_4>=LeftSquareBracket && LA51_4<=VerticalLine)) ) {
                    alt51=1;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 51, 4, input);

                    throw nvae;
                }
                }
                break;
            case ProcessingInstruction:
                {
                alt51=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 51, 0, input);

                throw nvae;
            }

            switch (alt51) {
                case 1 :
                    // InternalYangParser.g:6834:3: this_XpathNameTest_0= ruleXpathNameTest
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getXpathNodeTestAccess().getXpathNameTestParserRuleCall_0());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_XpathNameTest_0=ruleXpathNameTest();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_XpathNameTest_0;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 2 :
                    // InternalYangParser.g:6843:3: ( () ( (lv_name_2_0= ruleXpathNodeType ) ) otherlv_3= LeftParenthesis otherlv_4= RightParenthesis )
                    {
                    // InternalYangParser.g:6843:3: ( () ( (lv_name_2_0= ruleXpathNodeType ) ) otherlv_3= LeftParenthesis otherlv_4= RightParenthesis )
                    // InternalYangParser.g:6844:4: () ( (lv_name_2_0= ruleXpathNodeType ) ) otherlv_3= LeftParenthesis otherlv_4= RightParenthesis
                    {
                    // InternalYangParser.g:6844:4: ()
                    // InternalYangParser.g:6845:5: 
                    {
                    if ( state.backtracking==0 ) {

                      					current = forceCreateModelElement(
                      						grammarAccess.getXpathNodeTestAccess().getXpathNodeTypeAction_1_0(),
                      						current);
                      				
                    }

                    }

                    // InternalYangParser.g:6851:4: ( (lv_name_2_0= ruleXpathNodeType ) )
                    // InternalYangParser.g:6852:5: (lv_name_2_0= ruleXpathNodeType )
                    {
                    // InternalYangParser.g:6852:5: (lv_name_2_0= ruleXpathNodeType )
                    // InternalYangParser.g:6853:6: lv_name_2_0= ruleXpathNodeType
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getXpathNodeTestAccess().getNameXpathNodeTypeParserRuleCall_1_1_0());
                      					
                    }
                    pushFollow(FOLLOW_30);
                    lv_name_2_0=ruleXpathNodeType();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getXpathNodeTestRule());
                      						}
                      						set(
                      							current,
                      							"name",
                      							lv_name_2_0,
                      							"io.typefox.yang.Yang.XpathNodeType");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }

                    otherlv_3=(Token)match(input,LeftParenthesis,FOLLOW_15); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_3, grammarAccess.getXpathNodeTestAccess().getLeftParenthesisKeyword_1_2());
                      			
                    }
                    otherlv_4=(Token)match(input,RightParenthesis,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_4, grammarAccess.getXpathNodeTestAccess().getRightParenthesisKeyword_1_3());
                      			
                    }

                    }


                    }
                    break;
                case 3 :
                    // InternalYangParser.g:6880:3: ( () otherlv_6= ProcessingInstruction otherlv_7= LeftParenthesis ( (lv_instruction_8_0= RULE_STRING ) ) otherlv_9= RightParenthesis )
                    {
                    // InternalYangParser.g:6880:3: ( () otherlv_6= ProcessingInstruction otherlv_7= LeftParenthesis ( (lv_instruction_8_0= RULE_STRING ) ) otherlv_9= RightParenthesis )
                    // InternalYangParser.g:6881:4: () otherlv_6= ProcessingInstruction otherlv_7= LeftParenthesis ( (lv_instruction_8_0= RULE_STRING ) ) otherlv_9= RightParenthesis
                    {
                    // InternalYangParser.g:6881:4: ()
                    // InternalYangParser.g:6882:5: 
                    {
                    if ( state.backtracking==0 ) {

                      					current = forceCreateModelElement(
                      						grammarAccess.getXpathNodeTestAccess().getProcessingInstructionAction_2_0(),
                      						current);
                      				
                    }

                    }

                    otherlv_6=(Token)match(input,ProcessingInstruction,FOLLOW_30); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_6, grammarAccess.getXpathNodeTestAccess().getProcessingInstructionKeyword_2_1());
                      			
                    }
                    otherlv_7=(Token)match(input,LeftParenthesis,FOLLOW_4); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_7, grammarAccess.getXpathNodeTestAccess().getLeftParenthesisKeyword_2_2());
                      			
                    }
                    // InternalYangParser.g:6896:4: ( (lv_instruction_8_0= RULE_STRING ) )
                    // InternalYangParser.g:6897:5: (lv_instruction_8_0= RULE_STRING )
                    {
                    // InternalYangParser.g:6897:5: (lv_instruction_8_0= RULE_STRING )
                    // InternalYangParser.g:6898:6: lv_instruction_8_0= RULE_STRING
                    {
                    lv_instruction_8_0=(Token)match(input,RULE_STRING,FOLLOW_15); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						newLeafNode(lv_instruction_8_0, grammarAccess.getXpathNodeTestAccess().getInstructionSTRINGTerminalRuleCall_2_3_0());
                      					
                    }
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElement(grammarAccess.getXpathNodeTestRule());
                      						}
                      						setWithLastConsumed(
                      							current,
                      							"instruction",
                      							lv_instruction_8_0,
                      							"io.typefox.yang.Yang.STRING");
                      					
                    }

                    }


                    }

                    otherlv_9=(Token)match(input,RightParenthesis,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_9, grammarAccess.getXpathNodeTestAccess().getRightParenthesisKeyword_2_4());
                      			
                    }

                    }


                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleXpathNodeTest"


    // $ANTLR start "entryRuleXpathNameTest"
    // InternalYangParser.g:6923:1: entryRuleXpathNameTest returns [EObject current=null] : iv_ruleXpathNameTest= ruleXpathNameTest EOF ;
    public final EObject entryRuleXpathNameTest() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXpathNameTest = null;


        try {
            // InternalYangParser.g:6923:54: (iv_ruleXpathNameTest= ruleXpathNameTest EOF )
            // InternalYangParser.g:6924:2: iv_ruleXpathNameTest= ruleXpathNameTest EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXpathNameTestRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleXpathNameTest=ruleXpathNameTest();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXpathNameTest; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleXpathNameTest"


    // $ANTLR start "ruleXpathNameTest"
    // InternalYangParser.g:6930:1: ruleXpathNameTest returns [EObject current=null] : ( ( ( (lv_prefix_0_0= RULE_ID ) ) otherlv_1= Colon )? ( ( ruleXpathIDOrKw ) ) ) ;
    public final EObject ruleXpathNameTest() throws RecognitionException {
        EObject current = null;

        Token lv_prefix_0_0=null;
        Token otherlv_1=null;


        	enterRule();

        try {
            // InternalYangParser.g:6936:2: ( ( ( ( (lv_prefix_0_0= RULE_ID ) ) otherlv_1= Colon )? ( ( ruleXpathIDOrKw ) ) ) )
            // InternalYangParser.g:6937:2: ( ( ( (lv_prefix_0_0= RULE_ID ) ) otherlv_1= Colon )? ( ( ruleXpathIDOrKw ) ) )
            {
            // InternalYangParser.g:6937:2: ( ( ( (lv_prefix_0_0= RULE_ID ) ) otherlv_1= Colon )? ( ( ruleXpathIDOrKw ) ) )
            // InternalYangParser.g:6938:3: ( ( (lv_prefix_0_0= RULE_ID ) ) otherlv_1= Colon )? ( ( ruleXpathIDOrKw ) )
            {
            // InternalYangParser.g:6938:3: ( ( (lv_prefix_0_0= RULE_ID ) ) otherlv_1= Colon )?
            int alt52=2;
            int LA52_0 = input.LA(1);

            if ( (LA52_0==RULE_ID) ) {
                int LA52_1 = input.LA(2);

                if ( (LA52_1==Colon) ) {
                    alt52=1;
                }
            }
            switch (alt52) {
                case 1 :
                    // InternalYangParser.g:6939:4: ( (lv_prefix_0_0= RULE_ID ) ) otherlv_1= Colon
                    {
                    // InternalYangParser.g:6939:4: ( (lv_prefix_0_0= RULE_ID ) )
                    // InternalYangParser.g:6940:5: (lv_prefix_0_0= RULE_ID )
                    {
                    // InternalYangParser.g:6940:5: (lv_prefix_0_0= RULE_ID )
                    // InternalYangParser.g:6941:6: lv_prefix_0_0= RULE_ID
                    {
                    lv_prefix_0_0=(Token)match(input,RULE_ID,FOLLOW_36); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						newLeafNode(lv_prefix_0_0, grammarAccess.getXpathNameTestAccess().getPrefixIDTerminalRuleCall_0_0_0());
                      					
                    }
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElement(grammarAccess.getXpathNameTestRule());
                      						}
                      						setWithLastConsumed(
                      							current,
                      							"prefix",
                      							lv_prefix_0_0,
                      							"io.typefox.yang.Yang.ID");
                      					
                    }

                    }


                    }

                    otherlv_1=(Token)match(input,Colon,FOLLOW_35); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_1, grammarAccess.getXpathNameTestAccess().getColonKeyword_0_1());
                      			
                    }

                    }
                    break;

            }

            // InternalYangParser.g:6962:3: ( ( ruleXpathIDOrKw ) )
            // InternalYangParser.g:6963:4: ( ruleXpathIDOrKw )
            {
            // InternalYangParser.g:6963:4: ( ruleXpathIDOrKw )
            // InternalYangParser.g:6964:5: ruleXpathIDOrKw
            {
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElement(grammarAccess.getXpathNameTestRule());
              					}
              				
            }
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getXpathNameTestAccess().getRefSchemaNodeCrossReference_1_0());
              				
            }
            pushFollow(FOLLOW_2);
            ruleXpathIDOrKw();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					afterParserOrEnumRuleCall();
              				
            }

            }


            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleXpathNameTest"


    // $ANTLR start "entryRuleXpathNodeType"
    // InternalYangParser.g:6982:1: entryRuleXpathNodeType returns [String current=null] : iv_ruleXpathNodeType= ruleXpathNodeType EOF ;
    public final String entryRuleXpathNodeType() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleXpathNodeType = null;


        try {
            // InternalYangParser.g:6982:53: (iv_ruleXpathNodeType= ruleXpathNodeType EOF )
            // InternalYangParser.g:6983:2: iv_ruleXpathNodeType= ruleXpathNodeType EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXpathNodeTypeRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleXpathNodeType=ruleXpathNodeType();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXpathNodeType.getText(); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleXpathNodeType"


    // $ANTLR start "ruleXpathNodeType"
    // InternalYangParser.g:6989:1: ruleXpathNodeType returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= Comment | kw= Text | kw= Node ) ;
    public final AntlrDatatypeRuleToken ruleXpathNodeType() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;


        	enterRule();

        try {
            // InternalYangParser.g:6995:2: ( (kw= Comment | kw= Text | kw= Node ) )
            // InternalYangParser.g:6996:2: (kw= Comment | kw= Text | kw= Node )
            {
            // InternalYangParser.g:6996:2: (kw= Comment | kw= Text | kw= Node )
            int alt53=3;
            switch ( input.LA(1) ) {
            case Comment:
                {
                alt53=1;
                }
                break;
            case Text:
                {
                alt53=2;
                }
                break;
            case Node:
                {
                alt53=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 53, 0, input);

                throw nvae;
            }

            switch (alt53) {
                case 1 :
                    // InternalYangParser.g:6997:3: kw= Comment
                    {
                    kw=(Token)match(input,Comment,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getXpathNodeTypeAccess().getCommentKeyword_0());
                      		
                    }

                    }
                    break;
                case 2 :
                    // InternalYangParser.g:7003:3: kw= Text
                    {
                    kw=(Token)match(input,Text,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getXpathNodeTypeAccess().getTextKeyword_1());
                      		
                    }

                    }
                    break;
                case 3 :
                    // InternalYangParser.g:7009:3: kw= Node
                    {
                    kw=(Token)match(input,Node,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getXpathNodeTypeAccess().getNodeKeyword_2());
                      		
                    }

                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleXpathNodeType"


    // $ANTLR start "entryRuleXpathAxisName"
    // InternalYangParser.g:7018:1: entryRuleXpathAxisName returns [String current=null] : iv_ruleXpathAxisName= ruleXpathAxisName EOF ;
    public final String entryRuleXpathAxisName() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleXpathAxisName = null;


        try {
            // InternalYangParser.g:7018:53: (iv_ruleXpathAxisName= ruleXpathAxisName EOF )
            // InternalYangParser.g:7019:2: iv_ruleXpathAxisName= ruleXpathAxisName EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXpathAxisNameRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleXpathAxisName=ruleXpathAxisName();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXpathAxisName.getText(); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleXpathAxisName"


    // $ANTLR start "ruleXpathAxisName"
    // InternalYangParser.g:7025:1: ruleXpathAxisName returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= Ancestor | kw= AncestorOrSelf | kw= Attribute | kw= Child | kw= Descendant | kw= DescendantOrSelf | kw= Following | kw= FollowingSibling | kw= Namespace | kw= Parent | kw= Preceding | kw= PrecedingSibling | kw= Self ) ;
    public final AntlrDatatypeRuleToken ruleXpathAxisName() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;


        	enterRule();

        try {
            // InternalYangParser.g:7031:2: ( (kw= Ancestor | kw= AncestorOrSelf | kw= Attribute | kw= Child | kw= Descendant | kw= DescendantOrSelf | kw= Following | kw= FollowingSibling | kw= Namespace | kw= Parent | kw= Preceding | kw= PrecedingSibling | kw= Self ) )
            // InternalYangParser.g:7032:2: (kw= Ancestor | kw= AncestorOrSelf | kw= Attribute | kw= Child | kw= Descendant | kw= DescendantOrSelf | kw= Following | kw= FollowingSibling | kw= Namespace | kw= Parent | kw= Preceding | kw= PrecedingSibling | kw= Self )
            {
            // InternalYangParser.g:7032:2: (kw= Ancestor | kw= AncestorOrSelf | kw= Attribute | kw= Child | kw= Descendant | kw= DescendantOrSelf | kw= Following | kw= FollowingSibling | kw= Namespace | kw= Parent | kw= Preceding | kw= PrecedingSibling | kw= Self )
            int alt54=13;
            switch ( input.LA(1) ) {
            case Ancestor:
                {
                alt54=1;
                }
                break;
            case AncestorOrSelf:
                {
                alt54=2;
                }
                break;
            case Attribute:
                {
                alt54=3;
                }
                break;
            case Child:
                {
                alt54=4;
                }
                break;
            case Descendant:
                {
                alt54=5;
                }
                break;
            case DescendantOrSelf:
                {
                alt54=6;
                }
                break;
            case Following:
                {
                alt54=7;
                }
                break;
            case FollowingSibling:
                {
                alt54=8;
                }
                break;
            case Namespace:
                {
                alt54=9;
                }
                break;
            case Parent:
                {
                alt54=10;
                }
                break;
            case Preceding:
                {
                alt54=11;
                }
                break;
            case PrecedingSibling:
                {
                alt54=12;
                }
                break;
            case Self:
                {
                alt54=13;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 54, 0, input);

                throw nvae;
            }

            switch (alt54) {
                case 1 :
                    // InternalYangParser.g:7033:3: kw= Ancestor
                    {
                    kw=(Token)match(input,Ancestor,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getXpathAxisNameAccess().getAncestorKeyword_0());
                      		
                    }

                    }
                    break;
                case 2 :
                    // InternalYangParser.g:7039:3: kw= AncestorOrSelf
                    {
                    kw=(Token)match(input,AncestorOrSelf,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getXpathAxisNameAccess().getAncestorOrSelfKeyword_1());
                      		
                    }

                    }
                    break;
                case 3 :
                    // InternalYangParser.g:7045:3: kw= Attribute
                    {
                    kw=(Token)match(input,Attribute,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getXpathAxisNameAccess().getAttributeKeyword_2());
                      		
                    }

                    }
                    break;
                case 4 :
                    // InternalYangParser.g:7051:3: kw= Child
                    {
                    kw=(Token)match(input,Child,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getXpathAxisNameAccess().getChildKeyword_3());
                      		
                    }

                    }
                    break;
                case 5 :
                    // InternalYangParser.g:7057:3: kw= Descendant
                    {
                    kw=(Token)match(input,Descendant,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getXpathAxisNameAccess().getDescendantKeyword_4());
                      		
                    }

                    }
                    break;
                case 6 :
                    // InternalYangParser.g:7063:3: kw= DescendantOrSelf
                    {
                    kw=(Token)match(input,DescendantOrSelf,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getXpathAxisNameAccess().getDescendantOrSelfKeyword_5());
                      		
                    }

                    }
                    break;
                case 7 :
                    // InternalYangParser.g:7069:3: kw= Following
                    {
                    kw=(Token)match(input,Following,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getXpathAxisNameAccess().getFollowingKeyword_6());
                      		
                    }

                    }
                    break;
                case 8 :
                    // InternalYangParser.g:7075:3: kw= FollowingSibling
                    {
                    kw=(Token)match(input,FollowingSibling,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getXpathAxisNameAccess().getFollowingSiblingKeyword_7());
                      		
                    }

                    }
                    break;
                case 9 :
                    // InternalYangParser.g:7081:3: kw= Namespace
                    {
                    kw=(Token)match(input,Namespace,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getXpathAxisNameAccess().getNamespaceKeyword_8());
                      		
                    }

                    }
                    break;
                case 10 :
                    // InternalYangParser.g:7087:3: kw= Parent
                    {
                    kw=(Token)match(input,Parent,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getXpathAxisNameAccess().getParentKeyword_9());
                      		
                    }

                    }
                    break;
                case 11 :
                    // InternalYangParser.g:7093:3: kw= Preceding
                    {
                    kw=(Token)match(input,Preceding,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getXpathAxisNameAccess().getPrecedingKeyword_10());
                      		
                    }

                    }
                    break;
                case 12 :
                    // InternalYangParser.g:7099:3: kw= PrecedingSibling
                    {
                    kw=(Token)match(input,PrecedingSibling,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getXpathAxisNameAccess().getPrecedingSiblingKeyword_11());
                      		
                    }

                    }
                    break;
                case 13 :
                    // InternalYangParser.g:7105:3: kw= Self
                    {
                    kw=(Token)match(input,Self,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getXpathAxisNameAccess().getSelfKeyword_12());
                      		
                    }

                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleXpathAxisName"


    // $ANTLR start "entryRuleXpathIDOrKw"
    // InternalYangParser.g:7114:1: entryRuleXpathIDOrKw returns [String current=null] : iv_ruleXpathIDOrKw= ruleXpathIDOrKw EOF ;
    public final String entryRuleXpathIDOrKw() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleXpathIDOrKw = null;


        try {
            // InternalYangParser.g:7114:51: (iv_ruleXpathIDOrKw= ruleXpathIDOrKw EOF )
            // InternalYangParser.g:7115:2: iv_ruleXpathIDOrKw= ruleXpathIDOrKw EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXpathIDOrKwRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleXpathIDOrKw=ruleXpathIDOrKw();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXpathIDOrKw.getText(); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleXpathIDOrKw"


    // $ANTLR start "ruleXpathIDOrKw"
    // InternalYangParser.g:7121:1: ruleXpathIDOrKw returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_ID_0= RULE_ID | kw= Div | kw= And | kw= Or | kw= Mod | this_XpathAxisName_5= ruleXpathAxisName | this_XpathNodeType_6= ruleXpathNodeType | kw= Asterisk ) ;
    public final AntlrDatatypeRuleToken ruleXpathIDOrKw() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;
        Token kw=null;
        AntlrDatatypeRuleToken this_XpathAxisName_5 = null;

        AntlrDatatypeRuleToken this_XpathNodeType_6 = null;



        	enterRule();

        try {
            // InternalYangParser.g:7127:2: ( (this_ID_0= RULE_ID | kw= Div | kw= And | kw= Or | kw= Mod | this_XpathAxisName_5= ruleXpathAxisName | this_XpathNodeType_6= ruleXpathNodeType | kw= Asterisk ) )
            // InternalYangParser.g:7128:2: (this_ID_0= RULE_ID | kw= Div | kw= And | kw= Or | kw= Mod | this_XpathAxisName_5= ruleXpathAxisName | this_XpathNodeType_6= ruleXpathNodeType | kw= Asterisk )
            {
            // InternalYangParser.g:7128:2: (this_ID_0= RULE_ID | kw= Div | kw= And | kw= Or | kw= Mod | this_XpathAxisName_5= ruleXpathAxisName | this_XpathNodeType_6= ruleXpathNodeType | kw= Asterisk )
            int alt55=8;
            switch ( input.LA(1) ) {
            case RULE_ID:
                {
                alt55=1;
                }
                break;
            case Div:
                {
                alt55=2;
                }
                break;
            case And:
                {
                alt55=3;
                }
                break;
            case Or:
                {
                alt55=4;
                }
                break;
            case Mod:
                {
                alt55=5;
                }
                break;
            case DescendantOrSelf:
            case FollowingSibling:
            case PrecedingSibling:
            case AncestorOrSelf:
            case Descendant:
            case Attribute:
            case Following:
            case Namespace:
            case Preceding:
            case Ancestor:
            case Parent:
            case Child:
            case Self:
                {
                alt55=6;
                }
                break;
            case Comment:
            case Node:
            case Text:
                {
                alt55=7;
                }
                break;
            case Asterisk:
                {
                alt55=8;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 55, 0, input);

                throw nvae;
            }

            switch (alt55) {
                case 1 :
                    // InternalYangParser.g:7129:3: this_ID_0= RULE_ID
                    {
                    this_ID_0=(Token)match(input,RULE_ID,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(this_ID_0);
                      		
                    }
                    if ( state.backtracking==0 ) {

                      			newLeafNode(this_ID_0, grammarAccess.getXpathIDOrKwAccess().getIDTerminalRuleCall_0());
                      		
                    }

                    }
                    break;
                case 2 :
                    // InternalYangParser.g:7137:3: kw= Div
                    {
                    kw=(Token)match(input,Div,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getXpathIDOrKwAccess().getDivKeyword_1());
                      		
                    }

                    }
                    break;
                case 3 :
                    // InternalYangParser.g:7143:3: kw= And
                    {
                    kw=(Token)match(input,And,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getXpathIDOrKwAccess().getAndKeyword_2());
                      		
                    }

                    }
                    break;
                case 4 :
                    // InternalYangParser.g:7149:3: kw= Or
                    {
                    kw=(Token)match(input,Or,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getXpathIDOrKwAccess().getOrKeyword_3());
                      		
                    }

                    }
                    break;
                case 5 :
                    // InternalYangParser.g:7155:3: kw= Mod
                    {
                    kw=(Token)match(input,Mod,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getXpathIDOrKwAccess().getModKeyword_4());
                      		
                    }

                    }
                    break;
                case 6 :
                    // InternalYangParser.g:7161:3: this_XpathAxisName_5= ruleXpathAxisName
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getXpathIDOrKwAccess().getXpathAxisNameParserRuleCall_5());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_XpathAxisName_5=ruleXpathAxisName();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(this_XpathAxisName_5);
                      		
                    }
                    if ( state.backtracking==0 ) {

                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 7 :
                    // InternalYangParser.g:7172:3: this_XpathNodeType_6= ruleXpathNodeType
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getXpathIDOrKwAccess().getXpathNodeTypeParserRuleCall_6());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_XpathNodeType_6=ruleXpathNodeType();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(this_XpathNodeType_6);
                      		
                    }
                    if ( state.backtracking==0 ) {

                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 8 :
                    // InternalYangParser.g:7183:3: kw= Asterisk
                    {
                    kw=(Token)match(input,Asterisk,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getXpathIDOrKwAccess().getAsteriskKeyword_7());
                      		
                    }

                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleXpathIDOrKw"


    // $ANTLR start "entryRuleQNAME"
    // InternalYangParser.g:7192:1: entryRuleQNAME returns [String current=null] : iv_ruleQNAME= ruleQNAME EOF ;
    public final String entryRuleQNAME() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleQNAME = null;


        try {
            // InternalYangParser.g:7192:45: (iv_ruleQNAME= ruleQNAME EOF )
            // InternalYangParser.g:7193:2: iv_ruleQNAME= ruleQNAME EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getQNAMERule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleQNAME=ruleQNAME();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleQNAME.getText(); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleQNAME"


    // $ANTLR start "ruleQNAME"
    // InternalYangParser.g:7199:1: ruleQNAME returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : ( (this_IdOrKw_0= ruleIdOrKw kw= Colon )? this_IdOrKw_2= ruleIdOrKw ) ;
    public final AntlrDatatypeRuleToken ruleQNAME() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        AntlrDatatypeRuleToken this_IdOrKw_0 = null;

        AntlrDatatypeRuleToken this_IdOrKw_2 = null;



        	enterRule();

        try {
            // InternalYangParser.g:7205:2: ( ( (this_IdOrKw_0= ruleIdOrKw kw= Colon )? this_IdOrKw_2= ruleIdOrKw ) )
            // InternalYangParser.g:7206:2: ( (this_IdOrKw_0= ruleIdOrKw kw= Colon )? this_IdOrKw_2= ruleIdOrKw )
            {
            // InternalYangParser.g:7206:2: ( (this_IdOrKw_0= ruleIdOrKw kw= Colon )? this_IdOrKw_2= ruleIdOrKw )
            // InternalYangParser.g:7207:3: (this_IdOrKw_0= ruleIdOrKw kw= Colon )? this_IdOrKw_2= ruleIdOrKw
            {
            // InternalYangParser.g:7207:3: (this_IdOrKw_0= ruleIdOrKw kw= Colon )?
            int alt56=2;
            alt56 = dfa56.predict(input);
            switch (alt56) {
                case 1 :
                    // InternalYangParser.g:7208:4: this_IdOrKw_0= ruleIdOrKw kw= Colon
                    {
                    if ( state.backtracking==0 ) {

                      				newCompositeNode(grammarAccess.getQNAMEAccess().getIdOrKwParserRuleCall_0_0());
                      			
                    }
                    pushFollow(FOLLOW_36);
                    this_IdOrKw_0=ruleIdOrKw();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current.merge(this_IdOrKw_0);
                      			
                    }
                    if ( state.backtracking==0 ) {

                      				afterParserOrEnumRuleCall();
                      			
                    }
                    kw=(Token)match(input,Colon,FOLLOW_6); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current.merge(kw);
                      				newLeafNode(kw, grammarAccess.getQNAMEAccess().getColonKeyword_0_1());
                      			
                    }

                    }
                    break;

            }

            if ( state.backtracking==0 ) {

              			newCompositeNode(grammarAccess.getQNAMEAccess().getIdOrKwParserRuleCall_1());
              		
            }
            pushFollow(FOLLOW_2);
            this_IdOrKw_2=ruleIdOrKw();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current.merge(this_IdOrKw_2);
              		
            }
            if ( state.backtracking==0 ) {

              			afterParserOrEnumRuleCall();
              		
            }

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleQNAME"


    // $ANTLR start "entryRuleStringValue"
    // InternalYangParser.g:7238:1: entryRuleStringValue returns [String current=null] : iv_ruleStringValue= ruleStringValue EOF ;
    public final String entryRuleStringValue() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleStringValue = null;


        try {
            // InternalYangParser.g:7238:51: (iv_ruleStringValue= ruleStringValue EOF )
            // InternalYangParser.g:7239:2: iv_ruleStringValue= ruleStringValue EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getStringValueRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleStringValue=ruleStringValue();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleStringValue.getText(); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleStringValue"


    // $ANTLR start "ruleStringValue"
    // InternalYangParser.g:7245:1: ruleStringValue returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_STRING_0= RULE_STRING )+ ;
    public final AntlrDatatypeRuleToken ruleStringValue() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_STRING_0=null;


        	enterRule();

        try {
            // InternalYangParser.g:7251:2: ( (this_STRING_0= RULE_STRING )+ )
            // InternalYangParser.g:7252:2: (this_STRING_0= RULE_STRING )+
            {
            // InternalYangParser.g:7252:2: (this_STRING_0= RULE_STRING )+
            int cnt57=0;
            loop57:
            do {
                int alt57=2;
                int LA57_0 = input.LA(1);

                if ( (LA57_0==RULE_STRING) ) {
                    alt57=1;
                }


                switch (alt57) {
            	case 1 :
            	    // InternalYangParser.g:7253:3: this_STRING_0= RULE_STRING
            	    {
            	    this_STRING_0=(Token)match(input,RULE_STRING,FOLLOW_37); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      			current.merge(this_STRING_0);
            	      		
            	    }
            	    if ( state.backtracking==0 ) {

            	      			newLeafNode(this_STRING_0, grammarAccess.getStringValueAccess().getSTRINGTerminalRuleCall());
            	      		
            	    }

            	    }
            	    break;

            	default :
            	    if ( cnt57 >= 1 ) break loop57;
            	    if (state.backtracking>0) {state.failed=true; return current;}
                        EarlyExitException eee =
                            new EarlyExitException(57, input);
                        throw eee;
                }
                cnt57++;
            } while (true);


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleStringValue"


    // $ANTLR start "entryRuleIdOrKw"
    // InternalYangParser.g:7264:1: entryRuleIdOrKw returns [String current=null] : iv_ruleIdOrKw= ruleIdOrKw EOF ;
    public final String entryRuleIdOrKw() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleIdOrKw = null;


        try {
            // InternalYangParser.g:7264:46: (iv_ruleIdOrKw= ruleIdOrKw EOF )
            // InternalYangParser.g:7265:2: iv_ruleIdOrKw= ruleIdOrKw EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getIdOrKwRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleIdOrKw=ruleIdOrKw();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleIdOrKw.getText(); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleIdOrKw"


    // $ANTLR start "ruleIdOrKw"
    // InternalYangParser.g:7271:1: ruleIdOrKw returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_ID_0= RULE_ID | this_BUILTIN_TYPE_1= ruleBUILTIN_TYPE | this_KEYWORD_2= ruleKEYWORD ) ;
    public final AntlrDatatypeRuleToken ruleIdOrKw() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;
        AntlrDatatypeRuleToken this_BUILTIN_TYPE_1 = null;

        AntlrDatatypeRuleToken this_KEYWORD_2 = null;



        	enterRule();

        try {
            // InternalYangParser.g:7277:2: ( (this_ID_0= RULE_ID | this_BUILTIN_TYPE_1= ruleBUILTIN_TYPE | this_KEYWORD_2= ruleKEYWORD ) )
            // InternalYangParser.g:7278:2: (this_ID_0= RULE_ID | this_BUILTIN_TYPE_1= ruleBUILTIN_TYPE | this_KEYWORD_2= ruleKEYWORD )
            {
            // InternalYangParser.g:7278:2: (this_ID_0= RULE_ID | this_BUILTIN_TYPE_1= ruleBUILTIN_TYPE | this_KEYWORD_2= ruleKEYWORD )
            int alt58=3;
            switch ( input.LA(1) ) {
            case RULE_ID:
                {
                alt58=1;
                }
                break;
            case InstanceIdentifier:
            case Enumeration:
            case Identityref:
            case Decimal64:
            case Boolean:
            case Leafref:
            case Binary:
            case String:
            case Uint16:
            case Uint32:
            case Uint64:
            case Empty:
            case Int16:
            case Int32:
            case Int64:
            case Uint8:
            case Union:
            case Bits:
            case Int8:
                {
                alt58=2;
                }
                break;
            case RequireInstance:
            case FractionDigits:
            case ErrorAppTag:
            case ErrorMessage:
            case NotSupported:
            case RevisionDate:
            case MaxElements:
            case MinElements:
            case Notification:
            case Organization:
            case YangVersion:
            case Description:
            case YinElement:
            case BelongsTo:
            case Deprecated:
            case IfFeature:
            case OrderedBy:
            case Container:
            case Deviation:
            case Extension:
            case LeafList:
            case Mandatory:
            case Namespace:
            case Reference:
            case Submodule:
            case Unbounded:
            case Argument:
            case Grouping:
            case Identity:
            case Modifier:
            case Obsolete:
            case Position:
            case Presence:
            case Revision:
            case Anydata:
            case Augment:
            case Contact:
            case Current:
            case Default:
            case Deviate:
            case Feature:
            case Include:
            case Pattern:
            case Replace:
            case Typedef:
            case Action:
            case Anyxml:
            case Choice:
            case Config:
            case Delete:
            case Import:
            case Length:
            case Module:
            case Output:
            case Prefix:
            case Refine:
            case Status:
            case KW_System:
            case Unique:
            case False:
            case Input:
            case Range:
            case Units:
            case Value:
            case Base:
            case Case:
            case Enum:
            case Leaf:
            case List:
            case Must:
            case Path:
            case True:
            case Type:
            case User:
            case Uses:
            case When:
            case Add:
            case Bit:
            case Key:
            case Max:
            case Min:
            case Rpc:
                {
                alt58=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 58, 0, input);

                throw nvae;
            }

            switch (alt58) {
                case 1 :
                    // InternalYangParser.g:7279:3: this_ID_0= RULE_ID
                    {
                    this_ID_0=(Token)match(input,RULE_ID,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(this_ID_0);
                      		
                    }
                    if ( state.backtracking==0 ) {

                      			newLeafNode(this_ID_0, grammarAccess.getIdOrKwAccess().getIDTerminalRuleCall_0());
                      		
                    }

                    }
                    break;
                case 2 :
                    // InternalYangParser.g:7287:3: this_BUILTIN_TYPE_1= ruleBUILTIN_TYPE
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getIdOrKwAccess().getBUILTIN_TYPEParserRuleCall_1());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_BUILTIN_TYPE_1=ruleBUILTIN_TYPE();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(this_BUILTIN_TYPE_1);
                      		
                    }
                    if ( state.backtracking==0 ) {

                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 3 :
                    // InternalYangParser.g:7298:3: this_KEYWORD_2= ruleKEYWORD
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getIdOrKwAccess().getKEYWORDParserRuleCall_2());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_KEYWORD_2=ruleKEYWORD();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(this_KEYWORD_2);
                      		
                    }
                    if ( state.backtracking==0 ) {

                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleIdOrKw"


    // $ANTLR start "entryRuleQualifiedTypeName"
    // InternalYangParser.g:7312:1: entryRuleQualifiedTypeName returns [String current=null] : iv_ruleQualifiedTypeName= ruleQualifiedTypeName EOF ;
    public final String entryRuleQualifiedTypeName() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleQualifiedTypeName = null;


        try {
            // InternalYangParser.g:7312:57: (iv_ruleQualifiedTypeName= ruleQualifiedTypeName EOF )
            // InternalYangParser.g:7313:2: iv_ruleQualifiedTypeName= ruleQualifiedTypeName EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getQualifiedTypeNameRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleQualifiedTypeName=ruleQualifiedTypeName();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleQualifiedTypeName.getText(); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleQualifiedTypeName"


    // $ANTLR start "ruleQualifiedTypeName"
    // InternalYangParser.g:7319:1: ruleQualifiedTypeName returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : ( ( (this_ID_0= RULE_ID | this_KEYWORD_1= ruleKEYWORD ) kw= Colon )? (this_ID_3= RULE_ID | this_KEYWORD_4= ruleKEYWORD ) ) ;
    public final AntlrDatatypeRuleToken ruleQualifiedTypeName() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;
        Token kw=null;
        Token this_ID_3=null;
        AntlrDatatypeRuleToken this_KEYWORD_1 = null;

        AntlrDatatypeRuleToken this_KEYWORD_4 = null;



        	enterRule();

        try {
            // InternalYangParser.g:7325:2: ( ( ( (this_ID_0= RULE_ID | this_KEYWORD_1= ruleKEYWORD ) kw= Colon )? (this_ID_3= RULE_ID | this_KEYWORD_4= ruleKEYWORD ) ) )
            // InternalYangParser.g:7326:2: ( ( (this_ID_0= RULE_ID | this_KEYWORD_1= ruleKEYWORD ) kw= Colon )? (this_ID_3= RULE_ID | this_KEYWORD_4= ruleKEYWORD ) )
            {
            // InternalYangParser.g:7326:2: ( ( (this_ID_0= RULE_ID | this_KEYWORD_1= ruleKEYWORD ) kw= Colon )? (this_ID_3= RULE_ID | this_KEYWORD_4= ruleKEYWORD ) )
            // InternalYangParser.g:7327:3: ( (this_ID_0= RULE_ID | this_KEYWORD_1= ruleKEYWORD ) kw= Colon )? (this_ID_3= RULE_ID | this_KEYWORD_4= ruleKEYWORD )
            {
            // InternalYangParser.g:7327:3: ( (this_ID_0= RULE_ID | this_KEYWORD_1= ruleKEYWORD ) kw= Colon )?
            int alt60=2;
            alt60 = dfa60.predict(input);
            switch (alt60) {
                case 1 :
                    // InternalYangParser.g:7328:4: (this_ID_0= RULE_ID | this_KEYWORD_1= ruleKEYWORD ) kw= Colon
                    {
                    // InternalYangParser.g:7328:4: (this_ID_0= RULE_ID | this_KEYWORD_1= ruleKEYWORD )
                    int alt59=2;
                    int LA59_0 = input.LA(1);

                    if ( (LA59_0==RULE_ID) ) {
                        alt59=1;
                    }
                    else if ( ((LA59_0>=RequireInstance && LA59_0<=Description)||(LA59_0>=YinElement && LA59_0<=Deprecated)||(LA59_0>=IfFeature && LA59_0<=OrderedBy)||LA59_0==Container||(LA59_0>=Deviation && LA59_0<=Extension)||(LA59_0>=LeafList && LA59_0<=Namespace)||(LA59_0>=Reference && LA59_0<=Unbounded)||(LA59_0>=Argument && LA59_0<=Augment)||(LA59_0>=Contact && LA59_0<=Include)||(LA59_0>=Pattern && LA59_0<=Anyxml)||(LA59_0>=Choice && LA59_0<=Output)||(LA59_0>=Prefix && LA59_0<=Status)||LA59_0==KW_System||LA59_0==Unique||(LA59_0>=False && LA59_0<=Input)||LA59_0==Range||(LA59_0>=Units && LA59_0<=Value)||LA59_0==Base||(LA59_0>=Case && LA59_0<=Enum)||(LA59_0>=Leaf && LA59_0<=Must)||LA59_0==Path||(LA59_0>=True && LA59_0<=Add)||LA59_0==Bit||(LA59_0>=Key && LA59_0<=Min)||LA59_0==Rpc) ) {
                        alt59=2;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return current;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 59, 0, input);

                        throw nvae;
                    }
                    switch (alt59) {
                        case 1 :
                            // InternalYangParser.g:7329:5: this_ID_0= RULE_ID
                            {
                            this_ID_0=(Token)match(input,RULE_ID,FOLLOW_36); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              					current.merge(this_ID_0);
                              				
                            }
                            if ( state.backtracking==0 ) {

                              					newLeafNode(this_ID_0, grammarAccess.getQualifiedTypeNameAccess().getIDTerminalRuleCall_0_0_0());
                              				
                            }

                            }
                            break;
                        case 2 :
                            // InternalYangParser.g:7337:5: this_KEYWORD_1= ruleKEYWORD
                            {
                            if ( state.backtracking==0 ) {

                              					newCompositeNode(grammarAccess.getQualifiedTypeNameAccess().getKEYWORDParserRuleCall_0_0_1());
                              				
                            }
                            pushFollow(FOLLOW_36);
                            this_KEYWORD_1=ruleKEYWORD();

                            state._fsp--;
                            if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              					current.merge(this_KEYWORD_1);
                              				
                            }
                            if ( state.backtracking==0 ) {

                              					afterParserOrEnumRuleCall();
                              				
                            }

                            }
                            break;

                    }

                    kw=(Token)match(input,Colon,FOLLOW_38); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current.merge(kw);
                      				newLeafNode(kw, grammarAccess.getQualifiedTypeNameAccess().getColonKeyword_0_1());
                      			
                    }

                    }
                    break;

            }

            // InternalYangParser.g:7354:3: (this_ID_3= RULE_ID | this_KEYWORD_4= ruleKEYWORD )
            int alt61=2;
            int LA61_0 = input.LA(1);

            if ( (LA61_0==RULE_ID) ) {
                alt61=1;
            }
            else if ( ((LA61_0>=RequireInstance && LA61_0<=Description)||(LA61_0>=YinElement && LA61_0<=Deprecated)||(LA61_0>=IfFeature && LA61_0<=OrderedBy)||LA61_0==Container||(LA61_0>=Deviation && LA61_0<=Extension)||(LA61_0>=LeafList && LA61_0<=Namespace)||(LA61_0>=Reference && LA61_0<=Unbounded)||(LA61_0>=Argument && LA61_0<=Augment)||(LA61_0>=Contact && LA61_0<=Include)||(LA61_0>=Pattern && LA61_0<=Anyxml)||(LA61_0>=Choice && LA61_0<=Output)||(LA61_0>=Prefix && LA61_0<=Status)||LA61_0==KW_System||LA61_0==Unique||(LA61_0>=False && LA61_0<=Input)||LA61_0==Range||(LA61_0>=Units && LA61_0<=Value)||LA61_0==Base||(LA61_0>=Case && LA61_0<=Enum)||(LA61_0>=Leaf && LA61_0<=Must)||LA61_0==Path||(LA61_0>=True && LA61_0<=Add)||LA61_0==Bit||(LA61_0>=Key && LA61_0<=Min)||LA61_0==Rpc) ) {
                alt61=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 61, 0, input);

                throw nvae;
            }
            switch (alt61) {
                case 1 :
                    // InternalYangParser.g:7355:4: this_ID_3= RULE_ID
                    {
                    this_ID_3=(Token)match(input,RULE_ID,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current.merge(this_ID_3);
                      			
                    }
                    if ( state.backtracking==0 ) {

                      				newLeafNode(this_ID_3, grammarAccess.getQualifiedTypeNameAccess().getIDTerminalRuleCall_1_0());
                      			
                    }

                    }
                    break;
                case 2 :
                    // InternalYangParser.g:7363:4: this_KEYWORD_4= ruleKEYWORD
                    {
                    if ( state.backtracking==0 ) {

                      				newCompositeNode(grammarAccess.getQualifiedTypeNameAccess().getKEYWORDParserRuleCall_1_1());
                      			
                    }
                    pushFollow(FOLLOW_2);
                    this_KEYWORD_4=ruleKEYWORD();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current.merge(this_KEYWORD_4);
                      			
                    }
                    if ( state.backtracking==0 ) {

                      				afterParserOrEnumRuleCall();
                      			
                    }

                    }
                    break;

            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleQualifiedTypeName"


    // $ANTLR start "entryRuleBUILTIN_TYPE"
    // InternalYangParser.g:7378:1: entryRuleBUILTIN_TYPE returns [String current=null] : iv_ruleBUILTIN_TYPE= ruleBUILTIN_TYPE EOF ;
    public final String entryRuleBUILTIN_TYPE() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleBUILTIN_TYPE = null;


        try {
            // InternalYangParser.g:7378:52: (iv_ruleBUILTIN_TYPE= ruleBUILTIN_TYPE EOF )
            // InternalYangParser.g:7379:2: iv_ruleBUILTIN_TYPE= ruleBUILTIN_TYPE EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getBUILTIN_TYPERule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleBUILTIN_TYPE=ruleBUILTIN_TYPE();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleBUILTIN_TYPE.getText(); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleBUILTIN_TYPE"


    // $ANTLR start "ruleBUILTIN_TYPE"
    // InternalYangParser.g:7385:1: ruleBUILTIN_TYPE returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= Binary | kw= Bits | kw= Boolean | kw= Decimal64 | kw= Empty | kw= Enumeration | kw= Identityref | kw= InstanceIdentifier | kw= Int8 | kw= Int16 | kw= Int32 | kw= Int64 | kw= Leafref | kw= String | kw= Uint8 | kw= Uint16 | kw= Uint32 | kw= Uint64 | kw= Union ) ;
    public final AntlrDatatypeRuleToken ruleBUILTIN_TYPE() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;


        	enterRule();

        try {
            // InternalYangParser.g:7391:2: ( (kw= Binary | kw= Bits | kw= Boolean | kw= Decimal64 | kw= Empty | kw= Enumeration | kw= Identityref | kw= InstanceIdentifier | kw= Int8 | kw= Int16 | kw= Int32 | kw= Int64 | kw= Leafref | kw= String | kw= Uint8 | kw= Uint16 | kw= Uint32 | kw= Uint64 | kw= Union ) )
            // InternalYangParser.g:7392:2: (kw= Binary | kw= Bits | kw= Boolean | kw= Decimal64 | kw= Empty | kw= Enumeration | kw= Identityref | kw= InstanceIdentifier | kw= Int8 | kw= Int16 | kw= Int32 | kw= Int64 | kw= Leafref | kw= String | kw= Uint8 | kw= Uint16 | kw= Uint32 | kw= Uint64 | kw= Union )
            {
            // InternalYangParser.g:7392:2: (kw= Binary | kw= Bits | kw= Boolean | kw= Decimal64 | kw= Empty | kw= Enumeration | kw= Identityref | kw= InstanceIdentifier | kw= Int8 | kw= Int16 | kw= Int32 | kw= Int64 | kw= Leafref | kw= String | kw= Uint8 | kw= Uint16 | kw= Uint32 | kw= Uint64 | kw= Union )
            int alt62=19;
            switch ( input.LA(1) ) {
            case Binary:
                {
                alt62=1;
                }
                break;
            case Bits:
                {
                alt62=2;
                }
                break;
            case Boolean:
                {
                alt62=3;
                }
                break;
            case Decimal64:
                {
                alt62=4;
                }
                break;
            case Empty:
                {
                alt62=5;
                }
                break;
            case Enumeration:
                {
                alt62=6;
                }
                break;
            case Identityref:
                {
                alt62=7;
                }
                break;
            case InstanceIdentifier:
                {
                alt62=8;
                }
                break;
            case Int8:
                {
                alt62=9;
                }
                break;
            case Int16:
                {
                alt62=10;
                }
                break;
            case Int32:
                {
                alt62=11;
                }
                break;
            case Int64:
                {
                alt62=12;
                }
                break;
            case Leafref:
                {
                alt62=13;
                }
                break;
            case String:
                {
                alt62=14;
                }
                break;
            case Uint8:
                {
                alt62=15;
                }
                break;
            case Uint16:
                {
                alt62=16;
                }
                break;
            case Uint32:
                {
                alt62=17;
                }
                break;
            case Uint64:
                {
                alt62=18;
                }
                break;
            case Union:
                {
                alt62=19;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 62, 0, input);

                throw nvae;
            }

            switch (alt62) {
                case 1 :
                    // InternalYangParser.g:7393:3: kw= Binary
                    {
                    kw=(Token)match(input,Binary,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getBUILTIN_TYPEAccess().getBinaryKeyword_0());
                      		
                    }

                    }
                    break;
                case 2 :
                    // InternalYangParser.g:7399:3: kw= Bits
                    {
                    kw=(Token)match(input,Bits,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getBUILTIN_TYPEAccess().getBitsKeyword_1());
                      		
                    }

                    }
                    break;
                case 3 :
                    // InternalYangParser.g:7405:3: kw= Boolean
                    {
                    kw=(Token)match(input,Boolean,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getBUILTIN_TYPEAccess().getBooleanKeyword_2());
                      		
                    }

                    }
                    break;
                case 4 :
                    // InternalYangParser.g:7411:3: kw= Decimal64
                    {
                    kw=(Token)match(input,Decimal64,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getBUILTIN_TYPEAccess().getDecimal64Keyword_3());
                      		
                    }

                    }
                    break;
                case 5 :
                    // InternalYangParser.g:7417:3: kw= Empty
                    {
                    kw=(Token)match(input,Empty,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getBUILTIN_TYPEAccess().getEmptyKeyword_4());
                      		
                    }

                    }
                    break;
                case 6 :
                    // InternalYangParser.g:7423:3: kw= Enumeration
                    {
                    kw=(Token)match(input,Enumeration,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getBUILTIN_TYPEAccess().getEnumerationKeyword_5());
                      		
                    }

                    }
                    break;
                case 7 :
                    // InternalYangParser.g:7429:3: kw= Identityref
                    {
                    kw=(Token)match(input,Identityref,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getBUILTIN_TYPEAccess().getIdentityrefKeyword_6());
                      		
                    }

                    }
                    break;
                case 8 :
                    // InternalYangParser.g:7435:3: kw= InstanceIdentifier
                    {
                    kw=(Token)match(input,InstanceIdentifier,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getBUILTIN_TYPEAccess().getInstanceIdentifierKeyword_7());
                      		
                    }

                    }
                    break;
                case 9 :
                    // InternalYangParser.g:7441:3: kw= Int8
                    {
                    kw=(Token)match(input,Int8,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getBUILTIN_TYPEAccess().getInt8Keyword_8());
                      		
                    }

                    }
                    break;
                case 10 :
                    // InternalYangParser.g:7447:3: kw= Int16
                    {
                    kw=(Token)match(input,Int16,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getBUILTIN_TYPEAccess().getInt16Keyword_9());
                      		
                    }

                    }
                    break;
                case 11 :
                    // InternalYangParser.g:7453:3: kw= Int32
                    {
                    kw=(Token)match(input,Int32,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getBUILTIN_TYPEAccess().getInt32Keyword_10());
                      		
                    }

                    }
                    break;
                case 12 :
                    // InternalYangParser.g:7459:3: kw= Int64
                    {
                    kw=(Token)match(input,Int64,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getBUILTIN_TYPEAccess().getInt64Keyword_11());
                      		
                    }

                    }
                    break;
                case 13 :
                    // InternalYangParser.g:7465:3: kw= Leafref
                    {
                    kw=(Token)match(input,Leafref,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getBUILTIN_TYPEAccess().getLeafrefKeyword_12());
                      		
                    }

                    }
                    break;
                case 14 :
                    // InternalYangParser.g:7471:3: kw= String
                    {
                    kw=(Token)match(input,String,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getBUILTIN_TYPEAccess().getStringKeyword_13());
                      		
                    }

                    }
                    break;
                case 15 :
                    // InternalYangParser.g:7477:3: kw= Uint8
                    {
                    kw=(Token)match(input,Uint8,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getBUILTIN_TYPEAccess().getUint8Keyword_14());
                      		
                    }

                    }
                    break;
                case 16 :
                    // InternalYangParser.g:7483:3: kw= Uint16
                    {
                    kw=(Token)match(input,Uint16,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getBUILTIN_TYPEAccess().getUint16Keyword_15());
                      		
                    }

                    }
                    break;
                case 17 :
                    // InternalYangParser.g:7489:3: kw= Uint32
                    {
                    kw=(Token)match(input,Uint32,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getBUILTIN_TYPEAccess().getUint32Keyword_16());
                      		
                    }

                    }
                    break;
                case 18 :
                    // InternalYangParser.g:7495:3: kw= Uint64
                    {
                    kw=(Token)match(input,Uint64,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getBUILTIN_TYPEAccess().getUint64Keyword_17());
                      		
                    }

                    }
                    break;
                case 19 :
                    // InternalYangParser.g:7501:3: kw= Union
                    {
                    kw=(Token)match(input,Union,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getBUILTIN_TYPEAccess().getUnionKeyword_18());
                      		
                    }

                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleBUILTIN_TYPE"


    // $ANTLR start "entryRuleKEYWORD"
    // InternalYangParser.g:7510:1: entryRuleKEYWORD returns [String current=null] : iv_ruleKEYWORD= ruleKEYWORD EOF ;
    public final String entryRuleKEYWORD() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleKEYWORD = null;


        try {
            // InternalYangParser.g:7510:47: (iv_ruleKEYWORD= ruleKEYWORD EOF )
            // InternalYangParser.g:7511:2: iv_ruleKEYWORD= ruleKEYWORD EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getKEYWORDRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleKEYWORD=ruleKEYWORD();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleKEYWORD.getText(); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleKEYWORD"


    // $ANTLR start "ruleKEYWORD"
    // InternalYangParser.g:7517:1: ruleKEYWORD returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_STATEMENT_KEYWORD_0= ruleSTATEMENT_KEYWORD | kw= Add | kw= Current | kw= Delete | kw= Deprecated | kw= False | kw= Max | kw= Min | kw= NotSupported | kw= Obsolete | kw= Replace | kw= KW_System | kw= True | kw= Unbounded | kw= User ) ;
    public final AntlrDatatypeRuleToken ruleKEYWORD() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        AntlrDatatypeRuleToken this_STATEMENT_KEYWORD_0 = null;



        	enterRule();

        try {
            // InternalYangParser.g:7523:2: ( (this_STATEMENT_KEYWORD_0= ruleSTATEMENT_KEYWORD | kw= Add | kw= Current | kw= Delete | kw= Deprecated | kw= False | kw= Max | kw= Min | kw= NotSupported | kw= Obsolete | kw= Replace | kw= KW_System | kw= True | kw= Unbounded | kw= User ) )
            // InternalYangParser.g:7524:2: (this_STATEMENT_KEYWORD_0= ruleSTATEMENT_KEYWORD | kw= Add | kw= Current | kw= Delete | kw= Deprecated | kw= False | kw= Max | kw= Min | kw= NotSupported | kw= Obsolete | kw= Replace | kw= KW_System | kw= True | kw= Unbounded | kw= User )
            {
            // InternalYangParser.g:7524:2: (this_STATEMENT_KEYWORD_0= ruleSTATEMENT_KEYWORD | kw= Add | kw= Current | kw= Delete | kw= Deprecated | kw= False | kw= Max | kw= Min | kw= NotSupported | kw= Obsolete | kw= Replace | kw= KW_System | kw= True | kw= Unbounded | kw= User )
            int alt63=15;
            switch ( input.LA(1) ) {
            case RequireInstance:
            case FractionDigits:
            case ErrorAppTag:
            case ErrorMessage:
            case RevisionDate:
            case MaxElements:
            case MinElements:
            case Notification:
            case Organization:
            case YangVersion:
            case Description:
            case YinElement:
            case BelongsTo:
            case IfFeature:
            case OrderedBy:
            case Container:
            case Deviation:
            case Extension:
            case LeafList:
            case Mandatory:
            case Namespace:
            case Reference:
            case Submodule:
            case Argument:
            case Grouping:
            case Identity:
            case Modifier:
            case Position:
            case Presence:
            case Revision:
            case Anydata:
            case Augment:
            case Contact:
            case Default:
            case Deviate:
            case Feature:
            case Include:
            case Pattern:
            case Typedef:
            case Action:
            case Anyxml:
            case Choice:
            case Config:
            case Import:
            case Length:
            case Module:
            case Output:
            case Prefix:
            case Refine:
            case Status:
            case Unique:
            case Input:
            case Range:
            case Units:
            case Value:
            case Base:
            case Case:
            case Enum:
            case Leaf:
            case List:
            case Must:
            case Path:
            case Type:
            case Uses:
            case When:
            case Bit:
            case Key:
            case Rpc:
                {
                alt63=1;
                }
                break;
            case Add:
                {
                alt63=2;
                }
                break;
            case Current:
                {
                alt63=3;
                }
                break;
            case Delete:
                {
                alt63=4;
                }
                break;
            case Deprecated:
                {
                alt63=5;
                }
                break;
            case False:
                {
                alt63=6;
                }
                break;
            case Max:
                {
                alt63=7;
                }
                break;
            case Min:
                {
                alt63=8;
                }
                break;
            case NotSupported:
                {
                alt63=9;
                }
                break;
            case Obsolete:
                {
                alt63=10;
                }
                break;
            case Replace:
                {
                alt63=11;
                }
                break;
            case KW_System:
                {
                alt63=12;
                }
                break;
            case True:
                {
                alt63=13;
                }
                break;
            case Unbounded:
                {
                alt63=14;
                }
                break;
            case User:
                {
                alt63=15;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 63, 0, input);

                throw nvae;
            }

            switch (alt63) {
                case 1 :
                    // InternalYangParser.g:7525:3: this_STATEMENT_KEYWORD_0= ruleSTATEMENT_KEYWORD
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getKEYWORDAccess().getSTATEMENT_KEYWORDParserRuleCall_0());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_STATEMENT_KEYWORD_0=ruleSTATEMENT_KEYWORD();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(this_STATEMENT_KEYWORD_0);
                      		
                    }
                    if ( state.backtracking==0 ) {

                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 2 :
                    // InternalYangParser.g:7536:3: kw= Add
                    {
                    kw=(Token)match(input,Add,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getKEYWORDAccess().getAddKeyword_1());
                      		
                    }

                    }
                    break;
                case 3 :
                    // InternalYangParser.g:7542:3: kw= Current
                    {
                    kw=(Token)match(input,Current,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getKEYWORDAccess().getCurrentKeyword_2());
                      		
                    }

                    }
                    break;
                case 4 :
                    // InternalYangParser.g:7548:3: kw= Delete
                    {
                    kw=(Token)match(input,Delete,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getKEYWORDAccess().getDeleteKeyword_3());
                      		
                    }

                    }
                    break;
                case 5 :
                    // InternalYangParser.g:7554:3: kw= Deprecated
                    {
                    kw=(Token)match(input,Deprecated,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getKEYWORDAccess().getDeprecatedKeyword_4());
                      		
                    }

                    }
                    break;
                case 6 :
                    // InternalYangParser.g:7560:3: kw= False
                    {
                    kw=(Token)match(input,False,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getKEYWORDAccess().getFalseKeyword_5());
                      		
                    }

                    }
                    break;
                case 7 :
                    // InternalYangParser.g:7566:3: kw= Max
                    {
                    kw=(Token)match(input,Max,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getKEYWORDAccess().getMaxKeyword_6());
                      		
                    }

                    }
                    break;
                case 8 :
                    // InternalYangParser.g:7572:3: kw= Min
                    {
                    kw=(Token)match(input,Min,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getKEYWORDAccess().getMinKeyword_7());
                      		
                    }

                    }
                    break;
                case 9 :
                    // InternalYangParser.g:7578:3: kw= NotSupported
                    {
                    kw=(Token)match(input,NotSupported,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getKEYWORDAccess().getNotSupportedKeyword_8());
                      		
                    }

                    }
                    break;
                case 10 :
                    // InternalYangParser.g:7584:3: kw= Obsolete
                    {
                    kw=(Token)match(input,Obsolete,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getKEYWORDAccess().getObsoleteKeyword_9());
                      		
                    }

                    }
                    break;
                case 11 :
                    // InternalYangParser.g:7590:3: kw= Replace
                    {
                    kw=(Token)match(input,Replace,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getKEYWORDAccess().getReplaceKeyword_10());
                      		
                    }

                    }
                    break;
                case 12 :
                    // InternalYangParser.g:7596:3: kw= KW_System
                    {
                    kw=(Token)match(input,KW_System,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getKEYWORDAccess().getSystemKeyword_11());
                      		
                    }

                    }
                    break;
                case 13 :
                    // InternalYangParser.g:7602:3: kw= True
                    {
                    kw=(Token)match(input,True,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getKEYWORDAccess().getTrueKeyword_12());
                      		
                    }

                    }
                    break;
                case 14 :
                    // InternalYangParser.g:7608:3: kw= Unbounded
                    {
                    kw=(Token)match(input,Unbounded,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getKEYWORDAccess().getUnboundedKeyword_13());
                      		
                    }

                    }
                    break;
                case 15 :
                    // InternalYangParser.g:7614:3: kw= User
                    {
                    kw=(Token)match(input,User,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getKEYWORDAccess().getUserKeyword_14());
                      		
                    }

                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleKEYWORD"


    // $ANTLR start "entryRuleSTATEMENT_KEYWORD"
    // InternalYangParser.g:7623:1: entryRuleSTATEMENT_KEYWORD returns [String current=null] : iv_ruleSTATEMENT_KEYWORD= ruleSTATEMENT_KEYWORD EOF ;
    public final String entryRuleSTATEMENT_KEYWORD() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleSTATEMENT_KEYWORD = null;


        try {
            // InternalYangParser.g:7623:57: (iv_ruleSTATEMENT_KEYWORD= ruleSTATEMENT_KEYWORD EOF )
            // InternalYangParser.g:7624:2: iv_ruleSTATEMENT_KEYWORD= ruleSTATEMENT_KEYWORD EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getSTATEMENT_KEYWORDRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleSTATEMENT_KEYWORD=ruleSTATEMENT_KEYWORD();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleSTATEMENT_KEYWORD.getText(); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleSTATEMENT_KEYWORD"


    // $ANTLR start "ruleSTATEMENT_KEYWORD"
    // InternalYangParser.g:7630:1: ruleSTATEMENT_KEYWORD returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= Action | kw= Anydata | kw= Anyxml | kw= Argument | kw= Augment | kw= Base | kw= BelongsTo | kw= Bit | kw= Case | kw= Choice | kw= Config | kw= Contact | kw= Container | kw= Default | kw= Description | kw= Enum | kw= ErrorAppTag | kw= ErrorMessage | kw= Extension | kw= Deviation | kw= Deviate | kw= Feature | kw= FractionDigits | kw= Grouping | kw= Identity | kw= IfFeature | kw= Import | kw= Include | kw= Input | kw= Key | kw= Leaf | kw= LeafList | kw= Length | kw= List | kw= Mandatory | kw= MaxElements | kw= MinElements | kw= Modifier | kw= Module | kw= Must | kw= Namespace | kw= Notification | kw= OrderedBy | kw= Organization | kw= Output | kw= Path | kw= Pattern | kw= Position | kw= Prefix | kw= Presence | kw= Range | kw= Reference | kw= Refine | kw= RequireInstance | kw= Revision | kw= RevisionDate | kw= Rpc | kw= Status | kw= Submodule | kw= Type | kw= Typedef | kw= Unique | kw= Units | kw= Uses | kw= Value | kw= When | kw= YangVersion | kw= YinElement ) ;
    public final AntlrDatatypeRuleToken ruleSTATEMENT_KEYWORD() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;


        	enterRule();

        try {
            // InternalYangParser.g:7636:2: ( (kw= Action | kw= Anydata | kw= Anyxml | kw= Argument | kw= Augment | kw= Base | kw= BelongsTo | kw= Bit | kw= Case | kw= Choice | kw= Config | kw= Contact | kw= Container | kw= Default | kw= Description | kw= Enum | kw= ErrorAppTag | kw= ErrorMessage | kw= Extension | kw= Deviation | kw= Deviate | kw= Feature | kw= FractionDigits | kw= Grouping | kw= Identity | kw= IfFeature | kw= Import | kw= Include | kw= Input | kw= Key | kw= Leaf | kw= LeafList | kw= Length | kw= List | kw= Mandatory | kw= MaxElements | kw= MinElements | kw= Modifier | kw= Module | kw= Must | kw= Namespace | kw= Notification | kw= OrderedBy | kw= Organization | kw= Output | kw= Path | kw= Pattern | kw= Position | kw= Prefix | kw= Presence | kw= Range | kw= Reference | kw= Refine | kw= RequireInstance | kw= Revision | kw= RevisionDate | kw= Rpc | kw= Status | kw= Submodule | kw= Type | kw= Typedef | kw= Unique | kw= Units | kw= Uses | kw= Value | kw= When | kw= YangVersion | kw= YinElement ) )
            // InternalYangParser.g:7637:2: (kw= Action | kw= Anydata | kw= Anyxml | kw= Argument | kw= Augment | kw= Base | kw= BelongsTo | kw= Bit | kw= Case | kw= Choice | kw= Config | kw= Contact | kw= Container | kw= Default | kw= Description | kw= Enum | kw= ErrorAppTag | kw= ErrorMessage | kw= Extension | kw= Deviation | kw= Deviate | kw= Feature | kw= FractionDigits | kw= Grouping | kw= Identity | kw= IfFeature | kw= Import | kw= Include | kw= Input | kw= Key | kw= Leaf | kw= LeafList | kw= Length | kw= List | kw= Mandatory | kw= MaxElements | kw= MinElements | kw= Modifier | kw= Module | kw= Must | kw= Namespace | kw= Notification | kw= OrderedBy | kw= Organization | kw= Output | kw= Path | kw= Pattern | kw= Position | kw= Prefix | kw= Presence | kw= Range | kw= Reference | kw= Refine | kw= RequireInstance | kw= Revision | kw= RevisionDate | kw= Rpc | kw= Status | kw= Submodule | kw= Type | kw= Typedef | kw= Unique | kw= Units | kw= Uses | kw= Value | kw= When | kw= YangVersion | kw= YinElement )
            {
            // InternalYangParser.g:7637:2: (kw= Action | kw= Anydata | kw= Anyxml | kw= Argument | kw= Augment | kw= Base | kw= BelongsTo | kw= Bit | kw= Case | kw= Choice | kw= Config | kw= Contact | kw= Container | kw= Default | kw= Description | kw= Enum | kw= ErrorAppTag | kw= ErrorMessage | kw= Extension | kw= Deviation | kw= Deviate | kw= Feature | kw= FractionDigits | kw= Grouping | kw= Identity | kw= IfFeature | kw= Import | kw= Include | kw= Input | kw= Key | kw= Leaf | kw= LeafList | kw= Length | kw= List | kw= Mandatory | kw= MaxElements | kw= MinElements | kw= Modifier | kw= Module | kw= Must | kw= Namespace | kw= Notification | kw= OrderedBy | kw= Organization | kw= Output | kw= Path | kw= Pattern | kw= Position | kw= Prefix | kw= Presence | kw= Range | kw= Reference | kw= Refine | kw= RequireInstance | kw= Revision | kw= RevisionDate | kw= Rpc | kw= Status | kw= Submodule | kw= Type | kw= Typedef | kw= Unique | kw= Units | kw= Uses | kw= Value | kw= When | kw= YangVersion | kw= YinElement )
            int alt64=68;
            switch ( input.LA(1) ) {
            case Action:
                {
                alt64=1;
                }
                break;
            case Anydata:
                {
                alt64=2;
                }
                break;
            case Anyxml:
                {
                alt64=3;
                }
                break;
            case Argument:
                {
                alt64=4;
                }
                break;
            case Augment:
                {
                alt64=5;
                }
                break;
            case Base:
                {
                alt64=6;
                }
                break;
            case BelongsTo:
                {
                alt64=7;
                }
                break;
            case Bit:
                {
                alt64=8;
                }
                break;
            case Case:
                {
                alt64=9;
                }
                break;
            case Choice:
                {
                alt64=10;
                }
                break;
            case Config:
                {
                alt64=11;
                }
                break;
            case Contact:
                {
                alt64=12;
                }
                break;
            case Container:
                {
                alt64=13;
                }
                break;
            case Default:
                {
                alt64=14;
                }
                break;
            case Description:
                {
                alt64=15;
                }
                break;
            case Enum:
                {
                alt64=16;
                }
                break;
            case ErrorAppTag:
                {
                alt64=17;
                }
                break;
            case ErrorMessage:
                {
                alt64=18;
                }
                break;
            case Extension:
                {
                alt64=19;
                }
                break;
            case Deviation:
                {
                alt64=20;
                }
                break;
            case Deviate:
                {
                alt64=21;
                }
                break;
            case Feature:
                {
                alt64=22;
                }
                break;
            case FractionDigits:
                {
                alt64=23;
                }
                break;
            case Grouping:
                {
                alt64=24;
                }
                break;
            case Identity:
                {
                alt64=25;
                }
                break;
            case IfFeature:
                {
                alt64=26;
                }
                break;
            case Import:
                {
                alt64=27;
                }
                break;
            case Include:
                {
                alt64=28;
                }
                break;
            case Input:
                {
                alt64=29;
                }
                break;
            case Key:
                {
                alt64=30;
                }
                break;
            case Leaf:
                {
                alt64=31;
                }
                break;
            case LeafList:
                {
                alt64=32;
                }
                break;
            case Length:
                {
                alt64=33;
                }
                break;
            case List:
                {
                alt64=34;
                }
                break;
            case Mandatory:
                {
                alt64=35;
                }
                break;
            case MaxElements:
                {
                alt64=36;
                }
                break;
            case MinElements:
                {
                alt64=37;
                }
                break;
            case Modifier:
                {
                alt64=38;
                }
                break;
            case Module:
                {
                alt64=39;
                }
                break;
            case Must:
                {
                alt64=40;
                }
                break;
            case Namespace:
                {
                alt64=41;
                }
                break;
            case Notification:
                {
                alt64=42;
                }
                break;
            case OrderedBy:
                {
                alt64=43;
                }
                break;
            case Organization:
                {
                alt64=44;
                }
                break;
            case Output:
                {
                alt64=45;
                }
                break;
            case Path:
                {
                alt64=46;
                }
                break;
            case Pattern:
                {
                alt64=47;
                }
                break;
            case Position:
                {
                alt64=48;
                }
                break;
            case Prefix:
                {
                alt64=49;
                }
                break;
            case Presence:
                {
                alt64=50;
                }
                break;
            case Range:
                {
                alt64=51;
                }
                break;
            case Reference:
                {
                alt64=52;
                }
                break;
            case Refine:
                {
                alt64=53;
                }
                break;
            case RequireInstance:
                {
                alt64=54;
                }
                break;
            case Revision:
                {
                alt64=55;
                }
                break;
            case RevisionDate:
                {
                alt64=56;
                }
                break;
            case Rpc:
                {
                alt64=57;
                }
                break;
            case Status:
                {
                alt64=58;
                }
                break;
            case Submodule:
                {
                alt64=59;
                }
                break;
            case Type:
                {
                alt64=60;
                }
                break;
            case Typedef:
                {
                alt64=61;
                }
                break;
            case Unique:
                {
                alt64=62;
                }
                break;
            case Units:
                {
                alt64=63;
                }
                break;
            case Uses:
                {
                alt64=64;
                }
                break;
            case Value:
                {
                alt64=65;
                }
                break;
            case When:
                {
                alt64=66;
                }
                break;
            case YangVersion:
                {
                alt64=67;
                }
                break;
            case YinElement:
                {
                alt64=68;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 64, 0, input);

                throw nvae;
            }

            switch (alt64) {
                case 1 :
                    // InternalYangParser.g:7638:3: kw= Action
                    {
                    kw=(Token)match(input,Action,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getSTATEMENT_KEYWORDAccess().getActionKeyword_0());
                      		
                    }

                    }
                    break;
                case 2 :
                    // InternalYangParser.g:7644:3: kw= Anydata
                    {
                    kw=(Token)match(input,Anydata,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getSTATEMENT_KEYWORDAccess().getAnydataKeyword_1());
                      		
                    }

                    }
                    break;
                case 3 :
                    // InternalYangParser.g:7650:3: kw= Anyxml
                    {
                    kw=(Token)match(input,Anyxml,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getSTATEMENT_KEYWORDAccess().getAnyxmlKeyword_2());
                      		
                    }

                    }
                    break;
                case 4 :
                    // InternalYangParser.g:7656:3: kw= Argument
                    {
                    kw=(Token)match(input,Argument,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getSTATEMENT_KEYWORDAccess().getArgumentKeyword_3());
                      		
                    }

                    }
                    break;
                case 5 :
                    // InternalYangParser.g:7662:3: kw= Augment
                    {
                    kw=(Token)match(input,Augment,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getSTATEMENT_KEYWORDAccess().getAugmentKeyword_4());
                      		
                    }

                    }
                    break;
                case 6 :
                    // InternalYangParser.g:7668:3: kw= Base
                    {
                    kw=(Token)match(input,Base,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getSTATEMENT_KEYWORDAccess().getBaseKeyword_5());
                      		
                    }

                    }
                    break;
                case 7 :
                    // InternalYangParser.g:7674:3: kw= BelongsTo
                    {
                    kw=(Token)match(input,BelongsTo,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getSTATEMENT_KEYWORDAccess().getBelongsToKeyword_6());
                      		
                    }

                    }
                    break;
                case 8 :
                    // InternalYangParser.g:7680:3: kw= Bit
                    {
                    kw=(Token)match(input,Bit,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getSTATEMENT_KEYWORDAccess().getBitKeyword_7());
                      		
                    }

                    }
                    break;
                case 9 :
                    // InternalYangParser.g:7686:3: kw= Case
                    {
                    kw=(Token)match(input,Case,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getSTATEMENT_KEYWORDAccess().getCaseKeyword_8());
                      		
                    }

                    }
                    break;
                case 10 :
                    // InternalYangParser.g:7692:3: kw= Choice
                    {
                    kw=(Token)match(input,Choice,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getSTATEMENT_KEYWORDAccess().getChoiceKeyword_9());
                      		
                    }

                    }
                    break;
                case 11 :
                    // InternalYangParser.g:7698:3: kw= Config
                    {
                    kw=(Token)match(input,Config,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getSTATEMENT_KEYWORDAccess().getConfigKeyword_10());
                      		
                    }

                    }
                    break;
                case 12 :
                    // InternalYangParser.g:7704:3: kw= Contact
                    {
                    kw=(Token)match(input,Contact,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getSTATEMENT_KEYWORDAccess().getContactKeyword_11());
                      		
                    }

                    }
                    break;
                case 13 :
                    // InternalYangParser.g:7710:3: kw= Container
                    {
                    kw=(Token)match(input,Container,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getSTATEMENT_KEYWORDAccess().getContainerKeyword_12());
                      		
                    }

                    }
                    break;
                case 14 :
                    // InternalYangParser.g:7716:3: kw= Default
                    {
                    kw=(Token)match(input,Default,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getSTATEMENT_KEYWORDAccess().getDefaultKeyword_13());
                      		
                    }

                    }
                    break;
                case 15 :
                    // InternalYangParser.g:7722:3: kw= Description
                    {
                    kw=(Token)match(input,Description,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getSTATEMENT_KEYWORDAccess().getDescriptionKeyword_14());
                      		
                    }

                    }
                    break;
                case 16 :
                    // InternalYangParser.g:7728:3: kw= Enum
                    {
                    kw=(Token)match(input,Enum,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getSTATEMENT_KEYWORDAccess().getEnumKeyword_15());
                      		
                    }

                    }
                    break;
                case 17 :
                    // InternalYangParser.g:7734:3: kw= ErrorAppTag
                    {
                    kw=(Token)match(input,ErrorAppTag,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getSTATEMENT_KEYWORDAccess().getErrorAppTagKeyword_16());
                      		
                    }

                    }
                    break;
                case 18 :
                    // InternalYangParser.g:7740:3: kw= ErrorMessage
                    {
                    kw=(Token)match(input,ErrorMessage,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getSTATEMENT_KEYWORDAccess().getErrorMessageKeyword_17());
                      		
                    }

                    }
                    break;
                case 19 :
                    // InternalYangParser.g:7746:3: kw= Extension
                    {
                    kw=(Token)match(input,Extension,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getSTATEMENT_KEYWORDAccess().getExtensionKeyword_18());
                      		
                    }

                    }
                    break;
                case 20 :
                    // InternalYangParser.g:7752:3: kw= Deviation
                    {
                    kw=(Token)match(input,Deviation,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getSTATEMENT_KEYWORDAccess().getDeviationKeyword_19());
                      		
                    }

                    }
                    break;
                case 21 :
                    // InternalYangParser.g:7758:3: kw= Deviate
                    {
                    kw=(Token)match(input,Deviate,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getSTATEMENT_KEYWORDAccess().getDeviateKeyword_20());
                      		
                    }

                    }
                    break;
                case 22 :
                    // InternalYangParser.g:7764:3: kw= Feature
                    {
                    kw=(Token)match(input,Feature,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getSTATEMENT_KEYWORDAccess().getFeatureKeyword_21());
                      		
                    }

                    }
                    break;
                case 23 :
                    // InternalYangParser.g:7770:3: kw= FractionDigits
                    {
                    kw=(Token)match(input,FractionDigits,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getSTATEMENT_KEYWORDAccess().getFractionDigitsKeyword_22());
                      		
                    }

                    }
                    break;
                case 24 :
                    // InternalYangParser.g:7776:3: kw= Grouping
                    {
                    kw=(Token)match(input,Grouping,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getSTATEMENT_KEYWORDAccess().getGroupingKeyword_23());
                      		
                    }

                    }
                    break;
                case 25 :
                    // InternalYangParser.g:7782:3: kw= Identity
                    {
                    kw=(Token)match(input,Identity,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getSTATEMENT_KEYWORDAccess().getIdentityKeyword_24());
                      		
                    }

                    }
                    break;
                case 26 :
                    // InternalYangParser.g:7788:3: kw= IfFeature
                    {
                    kw=(Token)match(input,IfFeature,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getSTATEMENT_KEYWORDAccess().getIfFeatureKeyword_25());
                      		
                    }

                    }
                    break;
                case 27 :
                    // InternalYangParser.g:7794:3: kw= Import
                    {
                    kw=(Token)match(input,Import,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getSTATEMENT_KEYWORDAccess().getImportKeyword_26());
                      		
                    }

                    }
                    break;
                case 28 :
                    // InternalYangParser.g:7800:3: kw= Include
                    {
                    kw=(Token)match(input,Include,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getSTATEMENT_KEYWORDAccess().getIncludeKeyword_27());
                      		
                    }

                    }
                    break;
                case 29 :
                    // InternalYangParser.g:7806:3: kw= Input
                    {
                    kw=(Token)match(input,Input,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getSTATEMENT_KEYWORDAccess().getInputKeyword_28());
                      		
                    }

                    }
                    break;
                case 30 :
                    // InternalYangParser.g:7812:3: kw= Key
                    {
                    kw=(Token)match(input,Key,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getSTATEMENT_KEYWORDAccess().getKeyKeyword_29());
                      		
                    }

                    }
                    break;
                case 31 :
                    // InternalYangParser.g:7818:3: kw= Leaf
                    {
                    kw=(Token)match(input,Leaf,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getSTATEMENT_KEYWORDAccess().getLeafKeyword_30());
                      		
                    }

                    }
                    break;
                case 32 :
                    // InternalYangParser.g:7824:3: kw= LeafList
                    {
                    kw=(Token)match(input,LeafList,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getSTATEMENT_KEYWORDAccess().getLeafListKeyword_31());
                      		
                    }

                    }
                    break;
                case 33 :
                    // InternalYangParser.g:7830:3: kw= Length
                    {
                    kw=(Token)match(input,Length,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getSTATEMENT_KEYWORDAccess().getLengthKeyword_32());
                      		
                    }

                    }
                    break;
                case 34 :
                    // InternalYangParser.g:7836:3: kw= List
                    {
                    kw=(Token)match(input,List,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getSTATEMENT_KEYWORDAccess().getListKeyword_33());
                      		
                    }

                    }
                    break;
                case 35 :
                    // InternalYangParser.g:7842:3: kw= Mandatory
                    {
                    kw=(Token)match(input,Mandatory,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getSTATEMENT_KEYWORDAccess().getMandatoryKeyword_34());
                      		
                    }

                    }
                    break;
                case 36 :
                    // InternalYangParser.g:7848:3: kw= MaxElements
                    {
                    kw=(Token)match(input,MaxElements,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getSTATEMENT_KEYWORDAccess().getMaxElementsKeyword_35());
                      		
                    }

                    }
                    break;
                case 37 :
                    // InternalYangParser.g:7854:3: kw= MinElements
                    {
                    kw=(Token)match(input,MinElements,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getSTATEMENT_KEYWORDAccess().getMinElementsKeyword_36());
                      		
                    }

                    }
                    break;
                case 38 :
                    // InternalYangParser.g:7860:3: kw= Modifier
                    {
                    kw=(Token)match(input,Modifier,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getSTATEMENT_KEYWORDAccess().getModifierKeyword_37());
                      		
                    }

                    }
                    break;
                case 39 :
                    // InternalYangParser.g:7866:3: kw= Module
                    {
                    kw=(Token)match(input,Module,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getSTATEMENT_KEYWORDAccess().getModuleKeyword_38());
                      		
                    }

                    }
                    break;
                case 40 :
                    // InternalYangParser.g:7872:3: kw= Must
                    {
                    kw=(Token)match(input,Must,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getSTATEMENT_KEYWORDAccess().getMustKeyword_39());
                      		
                    }

                    }
                    break;
                case 41 :
                    // InternalYangParser.g:7878:3: kw= Namespace
                    {
                    kw=(Token)match(input,Namespace,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getSTATEMENT_KEYWORDAccess().getNamespaceKeyword_40());
                      		
                    }

                    }
                    break;
                case 42 :
                    // InternalYangParser.g:7884:3: kw= Notification
                    {
                    kw=(Token)match(input,Notification,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getSTATEMENT_KEYWORDAccess().getNotificationKeyword_41());
                      		
                    }

                    }
                    break;
                case 43 :
                    // InternalYangParser.g:7890:3: kw= OrderedBy
                    {
                    kw=(Token)match(input,OrderedBy,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getSTATEMENT_KEYWORDAccess().getOrderedByKeyword_42());
                      		
                    }

                    }
                    break;
                case 44 :
                    // InternalYangParser.g:7896:3: kw= Organization
                    {
                    kw=(Token)match(input,Organization,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getSTATEMENT_KEYWORDAccess().getOrganizationKeyword_43());
                      		
                    }

                    }
                    break;
                case 45 :
                    // InternalYangParser.g:7902:3: kw= Output
                    {
                    kw=(Token)match(input,Output,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getSTATEMENT_KEYWORDAccess().getOutputKeyword_44());
                      		
                    }

                    }
                    break;
                case 46 :
                    // InternalYangParser.g:7908:3: kw= Path
                    {
                    kw=(Token)match(input,Path,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getSTATEMENT_KEYWORDAccess().getPathKeyword_45());
                      		
                    }

                    }
                    break;
                case 47 :
                    // InternalYangParser.g:7914:3: kw= Pattern
                    {
                    kw=(Token)match(input,Pattern,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getSTATEMENT_KEYWORDAccess().getPatternKeyword_46());
                      		
                    }

                    }
                    break;
                case 48 :
                    // InternalYangParser.g:7920:3: kw= Position
                    {
                    kw=(Token)match(input,Position,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getSTATEMENT_KEYWORDAccess().getPositionKeyword_47());
                      		
                    }

                    }
                    break;
                case 49 :
                    // InternalYangParser.g:7926:3: kw= Prefix
                    {
                    kw=(Token)match(input,Prefix,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getSTATEMENT_KEYWORDAccess().getPrefixKeyword_48());
                      		
                    }

                    }
                    break;
                case 50 :
                    // InternalYangParser.g:7932:3: kw= Presence
                    {
                    kw=(Token)match(input,Presence,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getSTATEMENT_KEYWORDAccess().getPresenceKeyword_49());
                      		
                    }

                    }
                    break;
                case 51 :
                    // InternalYangParser.g:7938:3: kw= Range
                    {
                    kw=(Token)match(input,Range,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getSTATEMENT_KEYWORDAccess().getRangeKeyword_50());
                      		
                    }

                    }
                    break;
                case 52 :
                    // InternalYangParser.g:7944:3: kw= Reference
                    {
                    kw=(Token)match(input,Reference,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getSTATEMENT_KEYWORDAccess().getReferenceKeyword_51());
                      		
                    }

                    }
                    break;
                case 53 :
                    // InternalYangParser.g:7950:3: kw= Refine
                    {
                    kw=(Token)match(input,Refine,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getSTATEMENT_KEYWORDAccess().getRefineKeyword_52());
                      		
                    }

                    }
                    break;
                case 54 :
                    // InternalYangParser.g:7956:3: kw= RequireInstance
                    {
                    kw=(Token)match(input,RequireInstance,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getSTATEMENT_KEYWORDAccess().getRequireInstanceKeyword_53());
                      		
                    }

                    }
                    break;
                case 55 :
                    // InternalYangParser.g:7962:3: kw= Revision
                    {
                    kw=(Token)match(input,Revision,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getSTATEMENT_KEYWORDAccess().getRevisionKeyword_54());
                      		
                    }

                    }
                    break;
                case 56 :
                    // InternalYangParser.g:7968:3: kw= RevisionDate
                    {
                    kw=(Token)match(input,RevisionDate,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getSTATEMENT_KEYWORDAccess().getRevisionDateKeyword_55());
                      		
                    }

                    }
                    break;
                case 57 :
                    // InternalYangParser.g:7974:3: kw= Rpc
                    {
                    kw=(Token)match(input,Rpc,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getSTATEMENT_KEYWORDAccess().getRpcKeyword_56());
                      		
                    }

                    }
                    break;
                case 58 :
                    // InternalYangParser.g:7980:3: kw= Status
                    {
                    kw=(Token)match(input,Status,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getSTATEMENT_KEYWORDAccess().getStatusKeyword_57());
                      		
                    }

                    }
                    break;
                case 59 :
                    // InternalYangParser.g:7986:3: kw= Submodule
                    {
                    kw=(Token)match(input,Submodule,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getSTATEMENT_KEYWORDAccess().getSubmoduleKeyword_58());
                      		
                    }

                    }
                    break;
                case 60 :
                    // InternalYangParser.g:7992:3: kw= Type
                    {
                    kw=(Token)match(input,Type,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getSTATEMENT_KEYWORDAccess().getTypeKeyword_59());
                      		
                    }

                    }
                    break;
                case 61 :
                    // InternalYangParser.g:7998:3: kw= Typedef
                    {
                    kw=(Token)match(input,Typedef,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getSTATEMENT_KEYWORDAccess().getTypedefKeyword_60());
                      		
                    }

                    }
                    break;
                case 62 :
                    // InternalYangParser.g:8004:3: kw= Unique
                    {
                    kw=(Token)match(input,Unique,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getSTATEMENT_KEYWORDAccess().getUniqueKeyword_61());
                      		
                    }

                    }
                    break;
                case 63 :
                    // InternalYangParser.g:8010:3: kw= Units
                    {
                    kw=(Token)match(input,Units,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getSTATEMENT_KEYWORDAccess().getUnitsKeyword_62());
                      		
                    }

                    }
                    break;
                case 64 :
                    // InternalYangParser.g:8016:3: kw= Uses
                    {
                    kw=(Token)match(input,Uses,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getSTATEMENT_KEYWORDAccess().getUsesKeyword_63());
                      		
                    }

                    }
                    break;
                case 65 :
                    // InternalYangParser.g:8022:3: kw= Value
                    {
                    kw=(Token)match(input,Value,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getSTATEMENT_KEYWORDAccess().getValueKeyword_64());
                      		
                    }

                    }
                    break;
                case 66 :
                    // InternalYangParser.g:8028:3: kw= When
                    {
                    kw=(Token)match(input,When,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getSTATEMENT_KEYWORDAccess().getWhenKeyword_65());
                      		
                    }

                    }
                    break;
                case 67 :
                    // InternalYangParser.g:8034:3: kw= YangVersion
                    {
                    kw=(Token)match(input,YangVersion,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getSTATEMENT_KEYWORDAccess().getYangVersionKeyword_66());
                      		
                    }

                    }
                    break;
                case 68 :
                    // InternalYangParser.g:8040:3: kw= YinElement
                    {
                    kw=(Token)match(input,YinElement,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getSTATEMENT_KEYWORDAccess().getYinElementKeyword_67());
                      		
                    }

                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleSTATEMENT_KEYWORD"

    // $ANTLR start synpred1_InternalYangParser
    public final void synpred1_InternalYangParser_fragment() throws RecognitionException {   
        // InternalYangParser.g:6193:5: ( Solidus )
        // InternalYangParser.g:6193:6: Solidus
        {
        match(input,Solidus,FOLLOW_2); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred1_InternalYangParser

    // $ANTLR start synpred2_InternalYangParser
    public final void synpred2_InternalYangParser_fragment() throws RecognitionException {   
        // InternalYangParser.g:6580:5: ( Solidus )
        // InternalYangParser.g:6580:6: Solidus
        {
        match(input,Solidus,FOLLOW_2); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred2_InternalYangParser

    // $ANTLR start synpred3_InternalYangParser
    public final void synpred3_InternalYangParser_fragment() throws RecognitionException {   
        // InternalYangParser.g:6597:5: ( FullStop | FullStopFullStop | CommercialAt | Ancestor | AncestorOrSelf | Attribute | Child | Descendant | DescendantOrSelf | Following | FollowingSibling | Namespace | Parent | Preceding | PrecedingSibling | Self | Div | And | Or | Mod | Comment | Text | Node | Asterisk | ProcessingInstruction | RULE_ID )
        // InternalYangParser.g:
        {
        if ( input.LA(1)==ProcessingInstruction||(input.LA(1)>=DescendantOrSelf && input.LA(1)<=AncestorOrSelf)||input.LA(1)==Descendant||input.LA(1)==Attribute||input.LA(1)==Following||(input.LA(1)>=Namespace && input.LA(1)<=Preceding)||input.LA(1)==Ancestor||input.LA(1)==Comment||input.LA(1)==Parent||input.LA(1)==Child||input.LA(1)==Node||(input.LA(1)>=Self && input.LA(1)<=Text)||input.LA(1)==And||input.LA(1)==Div||input.LA(1)==Mod||input.LA(1)==FullStopFullStop||input.LA(1)==Or||input.LA(1)==Asterisk||input.LA(1)==FullStop||input.LA(1)==CommercialAt||input.LA(1)==RULE_ID ) {
            input.consume();
            state.errorRecovery=false;state.failed=false;
        }
        else {
            if (state.backtracking>0) {state.failed=true; return ;}
            MismatchedSetException mse = new MismatchedSetException(null,input);
            throw mse;
        }


        }
    }
    // $ANTLR end synpred3_InternalYangParser

    // Delegated rules

    public final boolean synpred1_InternalYangParser() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred1_InternalYangParser_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred2_InternalYangParser() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred2_InternalYangParser_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred3_InternalYangParser() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred3_InternalYangParser_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }


    protected DFA48 dfa48 = new DFA48(this);
    protected DFA46 dfa46 = new DFA46(this);
    protected DFA47 dfa47 = new DFA47(this);
    protected DFA49 dfa49 = new DFA49(this);
    protected DFA56 dfa56 = new DFA56(this);
    protected DFA60 dfa60 = new DFA60(this);
    static final String dfa_1s = "\16\uffff";
    static final String dfa_2s = "\5\uffff\1\10\1\uffff\1\10\4\uffff\2\10";
    static final String dfa_3s = "\1\4\4\uffff\1\166\1\uffff\1\166\2\uffff\2\5\2\166";
    static final String dfa_4s = "\1\u009b\4\uffff\1\u0096\1\uffff\1\u0096\2\uffff\2\u0098\2\u0096";
    static final String dfa_5s = "\1\uffff\1\1\1\2\1\3\1\4\1\uffff\1\5\1\uffff\1\6\1\7\4\uffff";
    static final String dfa_6s = "\16\uffff}>";
    static final String[] dfa_7s = {
            "\1\10\1\6\4\10\21\6\1\10\2\6\1\10\4\6\1\10\2\6\1\7\1\10\3\6\1\10\13\6\1\10\24\6\1\10\11\6\1\10\13\6\2\uffff\10\6\1\10\1\6\2\10\6\6\1\10\1\6\1\10\3\6\1\10\1\uffff\1\6\1\uffff\1\10\2\uffff\1\10\1\1\1\2\1\uffff\1\10\3\uffff\1\10\1\11\5\uffff\1\10\5\uffff\1\5\1\uffff\1\3\1\4",
            "",
            "",
            "",
            "",
            "\1\10\1\uffff\1\10\3\uffff\1\10\2\uffff\1\10\1\uffff\3\10\1\uffff\1\6\5\10\1\uffff\1\10\1\12\4\10\1\uffff\4\10",
            "",
            "\1\10\1\uffff\1\10\3\uffff\1\10\2\uffff\1\10\1\uffff\3\10\1\uffff\1\6\5\10\1\uffff\1\10\1\13\4\10\1\uffff\4\10",
            "",
            "",
            "\1\6\4\10\21\6\1\10\2\6\1\10\4\6\1\10\2\6\1\15\1\10\3\6\1\10\13\6\1\10\24\6\1\10\11\6\1\10\13\6\2\uffff\10\6\1\10\1\6\2\10\6\6\1\10\1\6\1\10\3\6\1\10\1\uffff\1\6\4\uffff\1\10\3\uffff\1\10\20\uffff\1\14",
            "\1\6\4\uffff\21\6\1\uffff\2\6\1\uffff\4\6\1\uffff\3\6\1\uffff\3\6\1\uffff\13\6\1\uffff\24\6\1\uffff\11\6\1\uffff\13\6\2\uffff\10\6\1\uffff\1\6\2\uffff\6\6\1\uffff\1\6\1\uffff\3\6\2\uffff\1\6\16\uffff\1\10\12\uffff\1\6",
            "\1\10\1\uffff\1\10\3\uffff\1\10\2\uffff\1\10\1\uffff\3\10\1\uffff\1\6\5\10\1\uffff\1\10\1\uffff\4\10\1\uffff\4\10",
            "\1\10\1\uffff\1\10\3\uffff\1\10\2\uffff\1\10\1\uffff\3\10\1\uffff\1\6\5\10\1\uffff\1\10\1\uffff\4\10\1\uffff\4\10"
    };

    static final short[] dfa_1 = DFA.unpackEncodedString(dfa_1s);
    static final short[] dfa_2 = DFA.unpackEncodedString(dfa_2s);
    static final char[] dfa_3 = DFA.unpackEncodedStringToUnsignedChars(dfa_3s);
    static final char[] dfa_4 = DFA.unpackEncodedStringToUnsignedChars(dfa_4s);
    static final short[] dfa_5 = DFA.unpackEncodedString(dfa_5s);
    static final short[] dfa_6 = DFA.unpackEncodedString(dfa_6s);
    static final short[][] dfa_7 = unpackEncodedStringArray(dfa_7s);

    class DFA48 extends DFA {

        public DFA48(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 48;
            this.eot = dfa_1;
            this.eof = dfa_2;
            this.min = dfa_3;
            this.max = dfa_4;
            this.accept = dfa_5;
            this.special = dfa_6;
            this.transition = dfa_7;
        }
        public String getDescription() {
            return "6346:2: ( ( () otherlv_1= DollarSign ( (lv_name_2_0= ruleQNAME ) ) ) | (otherlv_3= LeftParenthesis this_XpathExpression_4= ruleXpathExpression otherlv_5= RightParenthesis ) | ( () ( (lv_value_7_0= RULE_STRING ) ) ) | ( () ( (lv_value_9_0= RULE_NUMBER ) ) ) | ( () ( (lv_name_11_0= ruleQNAME ) ) otherlv_12= LeftParenthesis ( ( (lv_args_13_0= ruleXpathExpression ) ) (otherlv_14= Comma ( (lv_args_15_0= ruleXpathExpression ) ) )* )? otherlv_16= RightParenthesis ) | ( () ( (lv_step_18_0= ruleXpathStep ) ) ) | ( () otherlv_20= Solidus ( ( Solidus )=> ( (lv_isDescendants_21_0= Solidus ) ) )? ( ( FullStop | FullStopFullStop | CommercialAt | Ancestor | AncestorOrSelf | Attribute | Child | Descendant | DescendantOrSelf | Following | FollowingSibling | Namespace | Parent | Preceding | PrecedingSibling | Self | Div | And | Or | Mod | Comment | Text | Node | Asterisk | ProcessingInstruction | RULE_ID )=> (lv_step_22_0= ruleXpathStep ) )? ) )";
        }
    }
    static final String dfa_8s = "\107\uffff";
    static final String dfa_9s = "\1\2\1\52\105\uffff";
    static final String dfa_10s = "\2\4\1\uffff\2\0\1\6\26\0\1\u0085\1\uffff\1\0\17\uffff\26\0\1\u009a\1\u0086\1\0";
    static final String dfa_11s = "\2\u0098\1\uffff\2\0\1\u0098\26\0\1\u0085\1\uffff\1\0\17\uffff\26\0\1\u009a\1\u0086\1\0";
    static final String dfa_12s = "\2\uffff\1\2\32\uffff\1\1\1\uffff\17\1\31\uffff";
    static final String dfa_13s = "\1\uffff\1\13\1\uffff\1\30\1\35\1\uffff\1\21\1\37\1\53\1\4\1\22\1\40\1\54\1\5\1\23\1\41\1\55\1\6\1\24\1\2\1\46\1\31\1\20\1\14\1\15\1\32\1\47\1\36\2\uffff\1\10\17\uffff\1\25\1\52\1\44\1\3\1\0\1\26\1\16\1\42\1\33\1\57\1\51\1\11\1\1\1\27\1\17\1\43\1\34\1\60\1\56\1\45\1\7\1\50\2\uffff\1\12}>";
    static final String[] dfa_14s = {
            "\1\2\1\uffff\4\2\21\uffff\1\2\2\uffff\1\2\4\uffff\1\2\2\uffff\2\2\3\uffff\1\2\13\uffff\1\2\24\uffff\1\2\11\uffff\1\2\25\uffff\1\2\1\uffff\2\2\6\uffff\1\2\1\uffff\1\2\3\uffff\1\2\2\uffff\5\2\2\uffff\6\2\1\1\1\uffff\11\2\1\uffff\1\2",
            "\1\34\1\uffff\1\13\1\15\1\21\1\7\21\uffff\1\12\2\uffff\1\10\4\uffff\1\14\2\uffff\1\16\1\20\3\uffff\1\6\13\uffff\1\30\24\uffff\1\17\11\uffff\1\11\25\uffff\1\32\1\uffff\1\22\1\31\6\uffff\1\25\1\uffff\1\24\3\uffff\1\27\2\uffff\1\47\1\4\1\44\1\45\1\26\2\uffff\1\54\1\33\1\40\1\55\1\41\1\3\1\36\1\uffff\1\51\1\42\1\46\1\43\1\5\1\35\1\53\1\50\1\37\1\uffff\1\23",
            "",
            "\1\uffff",
            "\1\uffff",
            "\1\70\1\72\1\76\1\64\21\uffff\1\67\2\uffff\1\65\4\uffff\1\71\2\uffff\1\73\1\75\3\uffff\1\63\13\uffff\1\100\24\uffff\1\74\11\uffff\1\66\25\uffff\1\102\1\uffff\1\77\1\101\6\uffff\1\60\1\uffff\1\57\3\uffff\1\62\6\uffff\1\61\3\uffff\1\103\20\uffff\1\56",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\104",
            "",
            "\1\uffff",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\105",
            "\1\106",
            "\1\uffff"
    };

    static final short[] dfa_8 = DFA.unpackEncodedString(dfa_8s);
    static final short[] dfa_9 = DFA.unpackEncodedString(dfa_9s);
    static final char[] dfa_10 = DFA.unpackEncodedStringToUnsignedChars(dfa_10s);
    static final char[] dfa_11 = DFA.unpackEncodedStringToUnsignedChars(dfa_11s);
    static final short[] dfa_12 = DFA.unpackEncodedString(dfa_12s);
    static final short[] dfa_13 = DFA.unpackEncodedString(dfa_13s);
    static final short[][] dfa_14 = unpackEncodedStringArray(dfa_14s);

    class DFA46 extends DFA {

        public DFA46(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 46;
            this.eot = dfa_8;
            this.eof = dfa_9;
            this.min = dfa_10;
            this.max = dfa_11;
            this.accept = dfa_12;
            this.special = dfa_13;
            this.transition = dfa_14;
        }
        public String getDescription() {
            return "6579:4: ( ( Solidus )=> ( (lv_isDescendants_21_0= Solidus ) ) )?";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA46_50 = input.LA(1);

                         
                        int index46_50 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred2_InternalYangParser()) ) {s = 45;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index46_50);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA46_58 = input.LA(1);

                         
                        int index46_58 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred2_InternalYangParser()) ) {s = 45;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index46_58);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA46_19 = input.LA(1);

                         
                        int index46_19 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred2_InternalYangParser()) ) {s = 45;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index46_19);
                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA46_49 = input.LA(1);

                         
                        int index46_49 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred2_InternalYangParser()) ) {s = 45;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index46_49);
                        if ( s>=0 ) return s;
                        break;
                    case 4 : 
                        int LA46_9 = input.LA(1);

                         
                        int index46_9 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred2_InternalYangParser()) ) {s = 45;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index46_9);
                        if ( s>=0 ) return s;
                        break;
                    case 5 : 
                        int LA46_13 = input.LA(1);

                         
                        int index46_13 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred2_InternalYangParser()) ) {s = 45;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index46_13);
                        if ( s>=0 ) return s;
                        break;
                    case 6 : 
                        int LA46_17 = input.LA(1);

                         
                        int index46_17 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred2_InternalYangParser()) ) {s = 45;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index46_17);
                        if ( s>=0 ) return s;
                        break;
                    case 7 : 
                        int LA46_66 = input.LA(1);

                         
                        int index46_66 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred2_InternalYangParser()) ) {s = 45;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index46_66);
                        if ( s>=0 ) return s;
                        break;
                    case 8 : 
                        int LA46_30 = input.LA(1);

                         
                        int index46_30 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred2_InternalYangParser()) ) {s = 45;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index46_30);
                        if ( s>=0 ) return s;
                        break;
                    case 9 : 
                        int LA46_57 = input.LA(1);

                         
                        int index46_57 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred2_InternalYangParser()) ) {s = 45;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index46_57);
                        if ( s>=0 ) return s;
                        break;
                    case 10 : 
                        int LA46_70 = input.LA(1);

                         
                        int index46_70 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred2_InternalYangParser()) ) {s = 45;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index46_70);
                        if ( s>=0 ) return s;
                        break;
                    case 11 : 
                        int LA46_1 = input.LA(1);

                         
                        int index46_1 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA46_1==FullStop) ) {s = 3;}

                        else if ( (LA46_1==FullStopFullStop) ) {s = 4;}

                        else if ( (LA46_1==CommercialAt) ) {s = 5;}

                        else if ( (LA46_1==Ancestor) ) {s = 6;}

                        else if ( (LA46_1==AncestorOrSelf) ) {s = 7;}

                        else if ( (LA46_1==Attribute) ) {s = 8;}

                        else if ( (LA46_1==Child) ) {s = 9;}

                        else if ( (LA46_1==Descendant) ) {s = 10;}

                        else if ( (LA46_1==DescendantOrSelf) ) {s = 11;}

                        else if ( (LA46_1==Following) ) {s = 12;}

                        else if ( (LA46_1==FollowingSibling) ) {s = 13;}

                        else if ( (LA46_1==Namespace) ) {s = 14;}

                        else if ( (LA46_1==Parent) ) {s = 15;}

                        else if ( (LA46_1==Preceding) ) {s = 16;}

                        else if ( (LA46_1==PrecedingSibling) ) {s = 17;}

                        else if ( (LA46_1==Self) ) {s = 18;}

                        else if ( (LA46_1==RULE_ID) ) {s = 19;}

                        else if ( (LA46_1==Div) ) {s = 20;}

                        else if ( (LA46_1==And) ) {s = 21;}

                        else if ( (LA46_1==Or) ) {s = 22;}

                        else if ( (LA46_1==Mod) ) {s = 23;}

                        else if ( (LA46_1==Comment) ) {s = 24;}

                        else if ( (LA46_1==Text) ) {s = 25;}

                        else if ( (LA46_1==Node) ) {s = 26;}

                        else if ( (LA46_1==Asterisk) ) {s = 27;}

                        else if ( (LA46_1==ProcessingInstruction) ) {s = 28;}

                        else if ( (LA46_1==LeftSquareBracket) && (synpred2_InternalYangParser())) {s = 29;}

                        else if ( (LA46_1==Solidus) ) {s = 30;}

                        else if ( (LA46_1==VerticalLine) && (synpred2_InternalYangParser())) {s = 31;}

                        else if ( (LA46_1==PlusSign) && (synpred2_InternalYangParser())) {s = 32;}

                        else if ( (LA46_1==HyphenMinus) && (synpred2_InternalYangParser())) {s = 33;}

                        else if ( (LA46_1==LessThanSign) && (synpred2_InternalYangParser())) {s = 34;}

                        else if ( (LA46_1==GreaterThanSign) && (synpred2_InternalYangParser())) {s = 35;}

                        else if ( (LA46_1==LessThanSignEqualsSign) && (synpred2_InternalYangParser())) {s = 36;}

                        else if ( (LA46_1==GreaterThanSignEqualsSign) && (synpred2_InternalYangParser())) {s = 37;}

                        else if ( (LA46_1==EqualsSign) && (synpred2_InternalYangParser())) {s = 38;}

                        else if ( (LA46_1==ExclamationMarkEqualsSign) && (synpred2_InternalYangParser())) {s = 39;}

                        else if ( (LA46_1==LeftCurlyBracket) && (synpred2_InternalYangParser())) {s = 40;}

                        else if ( (LA46_1==Semicolon) && (synpred2_InternalYangParser())) {s = 41;}

                        else if ( (LA46_1==EOF) && (synpred2_InternalYangParser())) {s = 42;}

                        else if ( (LA46_1==RightSquareBracket) && (synpred2_InternalYangParser())) {s = 43;}

                        else if ( (LA46_1==RightParenthesis) && (synpred2_InternalYangParser())) {s = 44;}

                        else if ( (LA46_1==Comma) && (synpred2_InternalYangParser())) {s = 45;}

                         
                        input.seek(index46_1);
                        if ( s>=0 ) return s;
                        break;
                    case 12 : 
                        int LA46_23 = input.LA(1);

                         
                        int index46_23 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred2_InternalYangParser()) ) {s = 45;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index46_23);
                        if ( s>=0 ) return s;
                        break;
                    case 13 : 
                        int LA46_24 = input.LA(1);

                         
                        int index46_24 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred2_InternalYangParser()) ) {s = 45;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index46_24);
                        if ( s>=0 ) return s;
                        break;
                    case 14 : 
                        int LA46_52 = input.LA(1);

                         
                        int index46_52 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred2_InternalYangParser()) ) {s = 45;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index46_52);
                        if ( s>=0 ) return s;
                        break;
                    case 15 : 
                        int LA46_60 = input.LA(1);

                         
                        int index46_60 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred2_InternalYangParser()) ) {s = 45;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index46_60);
                        if ( s>=0 ) return s;
                        break;
                    case 16 : 
                        int LA46_22 = input.LA(1);

                         
                        int index46_22 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred2_InternalYangParser()) ) {s = 45;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index46_22);
                        if ( s>=0 ) return s;
                        break;
                    case 17 : 
                        int LA46_6 = input.LA(1);

                         
                        int index46_6 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred2_InternalYangParser()) ) {s = 45;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index46_6);
                        if ( s>=0 ) return s;
                        break;
                    case 18 : 
                        int LA46_10 = input.LA(1);

                         
                        int index46_10 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred2_InternalYangParser()) ) {s = 45;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index46_10);
                        if ( s>=0 ) return s;
                        break;
                    case 19 : 
                        int LA46_14 = input.LA(1);

                         
                        int index46_14 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred2_InternalYangParser()) ) {s = 45;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index46_14);
                        if ( s>=0 ) return s;
                        break;
                    case 20 : 
                        int LA46_18 = input.LA(1);

                         
                        int index46_18 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred2_InternalYangParser()) ) {s = 45;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index46_18);
                        if ( s>=0 ) return s;
                        break;
                    case 21 : 
                        int LA46_46 = input.LA(1);

                         
                        int index46_46 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred2_InternalYangParser()) ) {s = 45;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index46_46);
                        if ( s>=0 ) return s;
                        break;
                    case 22 : 
                        int LA46_51 = input.LA(1);

                         
                        int index46_51 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred2_InternalYangParser()) ) {s = 45;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index46_51);
                        if ( s>=0 ) return s;
                        break;
                    case 23 : 
                        int LA46_59 = input.LA(1);

                         
                        int index46_59 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred2_InternalYangParser()) ) {s = 45;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index46_59);
                        if ( s>=0 ) return s;
                        break;
                    case 24 : 
                        int LA46_3 = input.LA(1);

                         
                        int index46_3 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred2_InternalYangParser()) ) {s = 45;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index46_3);
                        if ( s>=0 ) return s;
                        break;
                    case 25 : 
                        int LA46_21 = input.LA(1);

                         
                        int index46_21 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred2_InternalYangParser()) ) {s = 45;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index46_21);
                        if ( s>=0 ) return s;
                        break;
                    case 26 : 
                        int LA46_25 = input.LA(1);

                         
                        int index46_25 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred2_InternalYangParser()) ) {s = 45;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index46_25);
                        if ( s>=0 ) return s;
                        break;
                    case 27 : 
                        int LA46_54 = input.LA(1);

                         
                        int index46_54 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred2_InternalYangParser()) ) {s = 45;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index46_54);
                        if ( s>=0 ) return s;
                        break;
                    case 28 : 
                        int LA46_62 = input.LA(1);

                         
                        int index46_62 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred2_InternalYangParser()) ) {s = 45;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index46_62);
                        if ( s>=0 ) return s;
                        break;
                    case 29 : 
                        int LA46_4 = input.LA(1);

                         
                        int index46_4 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred2_InternalYangParser()) ) {s = 45;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index46_4);
                        if ( s>=0 ) return s;
                        break;
                    case 30 : 
                        int LA46_27 = input.LA(1);

                         
                        int index46_27 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred2_InternalYangParser()) ) {s = 45;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index46_27);
                        if ( s>=0 ) return s;
                        break;
                    case 31 : 
                        int LA46_7 = input.LA(1);

                         
                        int index46_7 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred2_InternalYangParser()) ) {s = 45;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index46_7);
                        if ( s>=0 ) return s;
                        break;
                    case 32 : 
                        int LA46_11 = input.LA(1);

                         
                        int index46_11 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred2_InternalYangParser()) ) {s = 45;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index46_11);
                        if ( s>=0 ) return s;
                        break;
                    case 33 : 
                        int LA46_15 = input.LA(1);

                         
                        int index46_15 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred2_InternalYangParser()) ) {s = 45;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index46_15);
                        if ( s>=0 ) return s;
                        break;
                    case 34 : 
                        int LA46_53 = input.LA(1);

                         
                        int index46_53 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred2_InternalYangParser()) ) {s = 45;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index46_53);
                        if ( s>=0 ) return s;
                        break;
                    case 35 : 
                        int LA46_61 = input.LA(1);

                         
                        int index46_61 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred2_InternalYangParser()) ) {s = 45;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index46_61);
                        if ( s>=0 ) return s;
                        break;
                    case 36 : 
                        int LA46_48 = input.LA(1);

                         
                        int index46_48 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred2_InternalYangParser()) ) {s = 45;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index46_48);
                        if ( s>=0 ) return s;
                        break;
                    case 37 : 
                        int LA46_65 = input.LA(1);

                         
                        int index46_65 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred2_InternalYangParser()) ) {s = 45;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index46_65);
                        if ( s>=0 ) return s;
                        break;
                    case 38 : 
                        int LA46_20 = input.LA(1);

                         
                        int index46_20 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred2_InternalYangParser()) ) {s = 45;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index46_20);
                        if ( s>=0 ) return s;
                        break;
                    case 39 : 
                        int LA46_26 = input.LA(1);

                         
                        int index46_26 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred2_InternalYangParser()) ) {s = 45;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index46_26);
                        if ( s>=0 ) return s;
                        break;
                    case 40 : 
                        int LA46_67 = input.LA(1);

                         
                        int index46_67 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred2_InternalYangParser()) ) {s = 45;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index46_67);
                        if ( s>=0 ) return s;
                        break;
                    case 41 : 
                        int LA46_56 = input.LA(1);

                         
                        int index46_56 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred2_InternalYangParser()) ) {s = 45;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index46_56);
                        if ( s>=0 ) return s;
                        break;
                    case 42 : 
                        int LA46_47 = input.LA(1);

                         
                        int index46_47 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred2_InternalYangParser()) ) {s = 45;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index46_47);
                        if ( s>=0 ) return s;
                        break;
                    case 43 : 
                        int LA46_8 = input.LA(1);

                         
                        int index46_8 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred2_InternalYangParser()) ) {s = 45;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index46_8);
                        if ( s>=0 ) return s;
                        break;
                    case 44 : 
                        int LA46_12 = input.LA(1);

                         
                        int index46_12 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred2_InternalYangParser()) ) {s = 45;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index46_12);
                        if ( s>=0 ) return s;
                        break;
                    case 45 : 
                        int LA46_16 = input.LA(1);

                         
                        int index46_16 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred2_InternalYangParser()) ) {s = 45;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index46_16);
                        if ( s>=0 ) return s;
                        break;
                    case 46 : 
                        int LA46_64 = input.LA(1);

                         
                        int index46_64 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred2_InternalYangParser()) ) {s = 45;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index46_64);
                        if ( s>=0 ) return s;
                        break;
                    case 47 : 
                        int LA46_55 = input.LA(1);

                         
                        int index46_55 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred2_InternalYangParser()) ) {s = 45;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index46_55);
                        if ( s>=0 ) return s;
                        break;
                    case 48 : 
                        int LA46_63 = input.LA(1);

                         
                        int index46_63 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred2_InternalYangParser()) ) {s = 45;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index46_63);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 46, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String dfa_15s = "\54\uffff";
    static final String dfa_16s = "\1\33\53\uffff";
    static final String dfa_17s = "\1\4\21\uffff\4\0\3\uffff\1\0\22\uffff";
    static final String dfa_18s = "\1\u0098\21\uffff\4\0\3\uffff\1\0\22\uffff";
    static final String dfa_19s = "\1\uffff\21\1\4\uffff\3\1\1\uffff\1\1\1\2\20\uffff";
    static final String dfa_20s = "\1\0\21\uffff\1\1\1\2\1\3\1\4\3\uffff\1\5\22\uffff}>";
    static final String[] dfa_21s = {
            "\1\32\1\uffff\1\11\1\13\1\17\1\5\21\uffff\1\10\2\uffff\1\6\4\uffff\1\12\2\uffff\1\14\1\16\3\uffff\1\4\13\uffff\1\26\24\uffff\1\15\11\uffff\1\7\25\uffff\1\30\1\uffff\1\20\1\27\6\uffff\1\23\1\uffff\1\22\3\uffff\1\25\2\uffff\1\33\1\2\2\33\1\24\2\uffff\1\33\1\31\3\33\1\1\1\33\1\uffff\4\33\1\3\4\33\1\uffff\1\21",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "",
            "",
            "",
            "\1\uffff",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            ""
    };

    static final short[] dfa_15 = DFA.unpackEncodedString(dfa_15s);
    static final short[] dfa_16 = DFA.unpackEncodedString(dfa_16s);
    static final char[] dfa_17 = DFA.unpackEncodedStringToUnsignedChars(dfa_17s);
    static final char[] dfa_18 = DFA.unpackEncodedStringToUnsignedChars(dfa_18s);
    static final short[] dfa_19 = DFA.unpackEncodedString(dfa_19s);
    static final short[] dfa_20 = DFA.unpackEncodedString(dfa_20s);
    static final short[][] dfa_21 = unpackEncodedStringArray(dfa_21s);

    class DFA47 extends DFA {

        public DFA47(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 47;
            this.eot = dfa_15;
            this.eof = dfa_16;
            this.min = dfa_17;
            this.max = dfa_18;
            this.accept = dfa_19;
            this.special = dfa_20;
            this.transition = dfa_21;
        }
        public String getDescription() {
            return "6596:4: ( ( FullStop | FullStopFullStop | CommercialAt | Ancestor | AncestorOrSelf | Attribute | Child | Descendant | DescendantOrSelf | Following | FollowingSibling | Namespace | Parent | Preceding | PrecedingSibling | Self | Div | And | Or | Mod | Comment | Text | Node | Asterisk | ProcessingInstruction | RULE_ID )=> (lv_step_22_0= ruleXpathStep ) )?";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA47_0 = input.LA(1);

                         
                        int index47_0 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA47_0==FullStop) && (synpred3_InternalYangParser())) {s = 1;}

                        else if ( (LA47_0==FullStopFullStop) && (synpred3_InternalYangParser())) {s = 2;}

                        else if ( (LA47_0==CommercialAt) && (synpred3_InternalYangParser())) {s = 3;}

                        else if ( (LA47_0==Ancestor) && (synpred3_InternalYangParser())) {s = 4;}

                        else if ( (LA47_0==AncestorOrSelf) && (synpred3_InternalYangParser())) {s = 5;}

                        else if ( (LA47_0==Attribute) && (synpred3_InternalYangParser())) {s = 6;}

                        else if ( (LA47_0==Child) && (synpred3_InternalYangParser())) {s = 7;}

                        else if ( (LA47_0==Descendant) && (synpred3_InternalYangParser())) {s = 8;}

                        else if ( (LA47_0==DescendantOrSelf) && (synpred3_InternalYangParser())) {s = 9;}

                        else if ( (LA47_0==Following) && (synpred3_InternalYangParser())) {s = 10;}

                        else if ( (LA47_0==FollowingSibling) && (synpred3_InternalYangParser())) {s = 11;}

                        else if ( (LA47_0==Namespace) && (synpred3_InternalYangParser())) {s = 12;}

                        else if ( (LA47_0==Parent) && (synpred3_InternalYangParser())) {s = 13;}

                        else if ( (LA47_0==Preceding) && (synpred3_InternalYangParser())) {s = 14;}

                        else if ( (LA47_0==PrecedingSibling) && (synpred3_InternalYangParser())) {s = 15;}

                        else if ( (LA47_0==Self) && (synpred3_InternalYangParser())) {s = 16;}

                        else if ( (LA47_0==RULE_ID) && (synpred3_InternalYangParser())) {s = 17;}

                        else if ( (LA47_0==Div) ) {s = 18;}

                        else if ( (LA47_0==And) ) {s = 19;}

                        else if ( (LA47_0==Or) ) {s = 20;}

                        else if ( (LA47_0==Mod) ) {s = 21;}

                        else if ( (LA47_0==Comment) && (synpred3_InternalYangParser())) {s = 22;}

                        else if ( (LA47_0==Text) && (synpred3_InternalYangParser())) {s = 23;}

                        else if ( (LA47_0==Node) && (synpred3_InternalYangParser())) {s = 24;}

                        else if ( (LA47_0==Asterisk) ) {s = 25;}

                        else if ( (LA47_0==ProcessingInstruction) && (synpred3_InternalYangParser())) {s = 26;}

                        else if ( (LA47_0==EOF||LA47_0==ExclamationMarkEqualsSign||(LA47_0>=LessThanSignEqualsSign && LA47_0<=GreaterThanSignEqualsSign)||LA47_0==RightParenthesis||(LA47_0>=PlusSign && LA47_0<=HyphenMinus)||LA47_0==Solidus||(LA47_0>=Semicolon && LA47_0<=GreaterThanSign)||(LA47_0>=LeftSquareBracket && LA47_0<=VerticalLine)) ) {s = 27;}

                         
                        input.seek(index47_0);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA47_18 = input.LA(1);

                         
                        int index47_18 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred3_InternalYangParser()) ) {s = 26;}

                        else if ( (true) ) {s = 27;}

                         
                        input.seek(index47_18);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA47_19 = input.LA(1);

                         
                        int index47_19 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred3_InternalYangParser()) ) {s = 26;}

                        else if ( (true) ) {s = 27;}

                         
                        input.seek(index47_19);
                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA47_20 = input.LA(1);

                         
                        int index47_20 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred3_InternalYangParser()) ) {s = 26;}

                        else if ( (true) ) {s = 27;}

                         
                        input.seek(index47_20);
                        if ( s>=0 ) return s;
                        break;
                    case 4 : 
                        int LA47_21 = input.LA(1);

                         
                        int index47_21 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred3_InternalYangParser()) ) {s = 26;}

                        else if ( (true) ) {s = 27;}

                         
                        input.seek(index47_21);
                        if ( s>=0 ) return s;
                        break;
                    case 5 : 
                        int LA47_25 = input.LA(1);

                         
                        int index47_25 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred3_InternalYangParser()) ) {s = 26;}

                        else if ( (true) ) {s = 27;}

                         
                        input.seek(index47_25);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 47, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String dfa_22s = "\20\uffff";
    static final String dfa_23s = "\1\uffff\15\16\2\uffff";
    static final String dfa_24s = "\1\4\15\166\2\uffff";
    static final String dfa_25s = "\1\u0098\15\u0096\2\uffff";
    static final String dfa_26s = "\16\uffff\1\2\1\1";
    static final String dfa_27s = "\20\uffff}>";
    static final String[] dfa_28s = {
            "\1\16\1\uffff\1\6\1\10\1\14\1\2\21\uffff\1\5\2\uffff\1\3\4\uffff\1\7\2\uffff\1\11\1\13\3\uffff\1\1\13\uffff\1\16\24\uffff\1\12\11\uffff\1\4\25\uffff\1\16\1\uffff\1\15\1\16\6\uffff\1\16\1\uffff\1\16\3\uffff\1\16\6\uffff\1\16\3\uffff\1\16\20\uffff\1\16",
            "\1\16\1\uffff\1\16\3\uffff\1\16\2\uffff\1\16\1\uffff\3\16\2\uffff\5\16\1\uffff\1\16\1\17\4\16\1\uffff\4\16",
            "\1\16\1\uffff\1\16\3\uffff\1\16\2\uffff\1\16\1\uffff\3\16\2\uffff\5\16\1\uffff\1\16\1\17\4\16\1\uffff\4\16",
            "\1\16\1\uffff\1\16\3\uffff\1\16\2\uffff\1\16\1\uffff\3\16\2\uffff\5\16\1\uffff\1\16\1\17\4\16\1\uffff\4\16",
            "\1\16\1\uffff\1\16\3\uffff\1\16\2\uffff\1\16\1\uffff\3\16\2\uffff\5\16\1\uffff\1\16\1\17\4\16\1\uffff\4\16",
            "\1\16\1\uffff\1\16\3\uffff\1\16\2\uffff\1\16\1\uffff\3\16\2\uffff\5\16\1\uffff\1\16\1\17\4\16\1\uffff\4\16",
            "\1\16\1\uffff\1\16\3\uffff\1\16\2\uffff\1\16\1\uffff\3\16\2\uffff\5\16\1\uffff\1\16\1\17\4\16\1\uffff\4\16",
            "\1\16\1\uffff\1\16\3\uffff\1\16\2\uffff\1\16\1\uffff\3\16\2\uffff\5\16\1\uffff\1\16\1\17\4\16\1\uffff\4\16",
            "\1\16\1\uffff\1\16\3\uffff\1\16\2\uffff\1\16\1\uffff\3\16\2\uffff\5\16\1\uffff\1\16\1\17\4\16\1\uffff\4\16",
            "\1\16\1\uffff\1\16\3\uffff\1\16\2\uffff\1\16\1\uffff\3\16\2\uffff\5\16\1\uffff\1\16\1\17\4\16\1\uffff\4\16",
            "\1\16\1\uffff\1\16\3\uffff\1\16\2\uffff\1\16\1\uffff\3\16\2\uffff\5\16\1\uffff\1\16\1\17\4\16\1\uffff\4\16",
            "\1\16\1\uffff\1\16\3\uffff\1\16\2\uffff\1\16\1\uffff\3\16\2\uffff\5\16\1\uffff\1\16\1\17\4\16\1\uffff\4\16",
            "\1\16\1\uffff\1\16\3\uffff\1\16\2\uffff\1\16\1\uffff\3\16\2\uffff\5\16\1\uffff\1\16\1\17\4\16\1\uffff\4\16",
            "\1\16\1\uffff\1\16\3\uffff\1\16\2\uffff\1\16\1\uffff\3\16\2\uffff\5\16\1\uffff\1\16\1\17\4\16\1\uffff\4\16",
            "",
            ""
    };

    static final short[] dfa_22 = DFA.unpackEncodedString(dfa_22s);
    static final short[] dfa_23 = DFA.unpackEncodedString(dfa_23s);
    static final char[] dfa_24 = DFA.unpackEncodedStringToUnsignedChars(dfa_24s);
    static final char[] dfa_25 = DFA.unpackEncodedStringToUnsignedChars(dfa_25s);
    static final short[] dfa_26 = DFA.unpackEncodedString(dfa_26s);
    static final short[] dfa_27 = DFA.unpackEncodedString(dfa_27s);
    static final short[][] dfa_28 = unpackEncodedStringArray(dfa_28s);

    class DFA49 extends DFA {

        public DFA49(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 49;
            this.eot = dfa_22;
            this.eof = dfa_23;
            this.min = dfa_24;
            this.max = dfa_25;
            this.accept = dfa_26;
            this.special = dfa_27;
            this.transition = dfa_28;
        }
        public String getDescription() {
            return "6722:4: ( ( (lv_axis_7_0= ruleXpathAxisName ) ) otherlv_8= Colon otherlv_9= Colon )?";
        }
    }
    static final String dfa_29s = "\151\uffff";
    static final String dfa_30s = "\1\uffff\146\150\2\uffff";
    static final String dfa_31s = "\147\5\2\uffff";
    static final String dfa_32s = "\147\u0098\2\uffff";
    static final String dfa_33s = "\147\uffff\1\1\1\2";
    static final String dfa_34s = "\151\uffff}>";
    static final String[] dfa_35s = {
            "\1\11\4\uffff\1\112\1\53\1\45\1\46\1\140\1\114\1\70\1\71\1\76\1\100\1\127\1\43\1\7\1\10\1\130\1\33\1\134\1\uffff\1\56\1\77\1\uffff\1\41\1\5\1\50\1\47\1\uffff\1\64\1\67\1\75\1\uffff\1\110\1\117\1\145\1\uffff\1\30\1\54\1\55\1\72\1\141\1\104\1\106\1\113\1\26\1\31\1\4\1\uffff\1\40\1\132\1\42\1\51\1\52\1\60\1\16\1\103\1\142\1\121\1\25\1\27\1\2\1\36\1\37\1\133\1\57\1\65\1\73\1\101\1\uffff\1\105\1\111\1\116\1\17\1\143\1\21\1\22\1\23\1\122\1\uffff\1\6\1\135\1\61\1\13\1\14\1\15\1\107\1\20\1\24\1\123\1\125\2\uffff\1\32\1\3\1\35\1\44\1\12\1\63\1\66\1\74\1\uffff\1\102\2\uffff\1\144\1\120\1\146\1\124\1\126\1\131\1\uffff\1\34\1\uffff\1\62\1\136\1\137\2\uffff\1\115\31\uffff\1\1",
            "\1\150\4\uffff\21\150\1\uffff\2\150\1\uffff\4\150\1\uffff\3\150\1\uffff\3\150\1\uffff\13\150\1\uffff\24\150\1\uffff\11\150\1\uffff\13\150\2\uffff\10\150\1\uffff\1\150\2\uffff\15\150\1\uffff\2\150\1\uffff\3\150\1\uffff\6\150\1\uffff\1\150\1\147\4\150\1\uffff\4\150\1\uffff\1\150",
            "\1\150\4\uffff\21\150\1\uffff\2\150\1\uffff\4\150\1\uffff\3\150\1\uffff\3\150\1\uffff\13\150\1\uffff\24\150\1\uffff\11\150\1\uffff\13\150\2\uffff\10\150\1\uffff\1\150\2\uffff\15\150\1\uffff\2\150\1\uffff\3\150\1\uffff\6\150\1\uffff\1\150\1\147\4\150\1\uffff\4\150\1\uffff\1\150",
            "\1\150\4\uffff\21\150\1\uffff\2\150\1\uffff\4\150\1\uffff\3\150\1\uffff\3\150\1\uffff\13\150\1\uffff\24\150\1\uffff\11\150\1\uffff\13\150\2\uffff\10\150\1\uffff\1\150\2\uffff\15\150\1\uffff\2\150\1\uffff\3\150\1\uffff\6\150\1\uffff\1\150\1\147\4\150\1\uffff\4\150\1\uffff\1\150",
            "\1\150\4\uffff\21\150\1\uffff\2\150\1\uffff\4\150\1\uffff\3\150\1\uffff\3\150\1\uffff\13\150\1\uffff\24\150\1\uffff\11\150\1\uffff\13\150\2\uffff\10\150\1\uffff\1\150\2\uffff\15\150\1\uffff\2\150\1\uffff\3\150\1\uffff\6\150\1\uffff\1\150\1\147\4\150\1\uffff\4\150\1\uffff\1\150",
            "\1\150\4\uffff\21\150\1\uffff\2\150\1\uffff\4\150\1\uffff\3\150\1\uffff\3\150\1\uffff\13\150\1\uffff\24\150\1\uffff\11\150\1\uffff\13\150\2\uffff\10\150\1\uffff\1\150\2\uffff\15\150\1\uffff\2\150\1\uffff\3\150\1\uffff\6\150\1\uffff\1\150\1\147\4\150\1\uffff\4\150\1\uffff\1\150",
            "\1\150\4\uffff\21\150\1\uffff\2\150\1\uffff\4\150\1\uffff\3\150\1\uffff\3\150\1\uffff\13\150\1\uffff\24\150\1\uffff\11\150\1\uffff\13\150\2\uffff\10\150\1\uffff\1\150\2\uffff\15\150\1\uffff\2\150\1\uffff\3\150\1\uffff\6\150\1\uffff\1\150\1\147\4\150\1\uffff\4\150\1\uffff\1\150",
            "\1\150\4\uffff\21\150\1\uffff\2\150\1\uffff\4\150\1\uffff\3\150\1\uffff\3\150\1\uffff\13\150\1\uffff\24\150\1\uffff\11\150\1\uffff\13\150\2\uffff\10\150\1\uffff\1\150\2\uffff\15\150\1\uffff\2\150\1\uffff\3\150\1\uffff\6\150\1\uffff\1\150\1\147\4\150\1\uffff\4\150\1\uffff\1\150",
            "\1\150\4\uffff\21\150\1\uffff\2\150\1\uffff\4\150\1\uffff\3\150\1\uffff\3\150\1\uffff\13\150\1\uffff\24\150\1\uffff\11\150\1\uffff\13\150\2\uffff\10\150\1\uffff\1\150\2\uffff\15\150\1\uffff\2\150\1\uffff\3\150\1\uffff\6\150\1\uffff\1\150\1\147\4\150\1\uffff\4\150\1\uffff\1\150",
            "\1\150\4\uffff\21\150\1\uffff\2\150\1\uffff\4\150\1\uffff\3\150\1\uffff\3\150\1\uffff\13\150\1\uffff\24\150\1\uffff\11\150\1\uffff\13\150\2\uffff\10\150\1\uffff\1\150\2\uffff\15\150\1\uffff\2\150\1\uffff\3\150\1\uffff\6\150\1\uffff\1\150\1\147\4\150\1\uffff\4\150\1\uffff\1\150",
            "\1\150\4\uffff\21\150\1\uffff\2\150\1\uffff\4\150\1\uffff\3\150\1\uffff\3\150\1\uffff\13\150\1\uffff\24\150\1\uffff\11\150\1\uffff\13\150\2\uffff\10\150\1\uffff\1\150\2\uffff\15\150\1\uffff\2\150\1\uffff\3\150\1\uffff\6\150\1\uffff\1\150\1\147\4\150\1\uffff\4\150\1\uffff\1\150",
            "\1\150\4\uffff\21\150\1\uffff\2\150\1\uffff\4\150\1\uffff\3\150\1\uffff\3\150\1\uffff\13\150\1\uffff\24\150\1\uffff\11\150\1\uffff\13\150\2\uffff\10\150\1\uffff\1\150\2\uffff\15\150\1\uffff\2\150\1\uffff\3\150\1\uffff\6\150\1\uffff\1\150\1\147\4\150\1\uffff\4\150\1\uffff\1\150",
            "\1\150\4\uffff\21\150\1\uffff\2\150\1\uffff\4\150\1\uffff\3\150\1\uffff\3\150\1\uffff\13\150\1\uffff\24\150\1\uffff\11\150\1\uffff\13\150\2\uffff\10\150\1\uffff\1\150\2\uffff\15\150\1\uffff\2\150\1\uffff\3\150\1\uffff\6\150\1\uffff\1\150\1\147\4\150\1\uffff\4\150\1\uffff\1\150",
            "\1\150\4\uffff\21\150\1\uffff\2\150\1\uffff\4\150\1\uffff\3\150\1\uffff\3\150\1\uffff\13\150\1\uffff\24\150\1\uffff\11\150\1\uffff\13\150\2\uffff\10\150\1\uffff\1\150\2\uffff\15\150\1\uffff\2\150\1\uffff\3\150\1\uffff\6\150\1\uffff\1\150\1\147\4\150\1\uffff\4\150\1\uffff\1\150",
            "\1\150\4\uffff\21\150\1\uffff\2\150\1\uffff\4\150\1\uffff\3\150\1\uffff\3\150\1\uffff\13\150\1\uffff\24\150\1\uffff\11\150\1\uffff\13\150\2\uffff\10\150\1\uffff\1\150\2\uffff\15\150\1\uffff\2\150\1\uffff\3\150\1\uffff\6\150\1\uffff\1\150\1\147\4\150\1\uffff\4\150\1\uffff\1\150",
            "\1\150\4\uffff\21\150\1\uffff\2\150\1\uffff\4\150\1\uffff\3\150\1\uffff\3\150\1\uffff\13\150\1\uffff\24\150\1\uffff\11\150\1\uffff\13\150\2\uffff\10\150\1\uffff\1\150\2\uffff\15\150\1\uffff\2\150\1\uffff\3\150\1\uffff\6\150\1\uffff\1\150\1\147\4\150\1\uffff\4\150\1\uffff\1\150",
            "\1\150\4\uffff\21\150\1\uffff\2\150\1\uffff\4\150\1\uffff\3\150\1\uffff\3\150\1\uffff\13\150\1\uffff\24\150\1\uffff\11\150\1\uffff\13\150\2\uffff\10\150\1\uffff\1\150\2\uffff\15\150\1\uffff\2\150\1\uffff\3\150\1\uffff\6\150\1\uffff\1\150\1\147\4\150\1\uffff\4\150\1\uffff\1\150",
            "\1\150\4\uffff\21\150\1\uffff\2\150\1\uffff\4\150\1\uffff\3\150\1\uffff\3\150\1\uffff\13\150\1\uffff\24\150\1\uffff\11\150\1\uffff\13\150\2\uffff\10\150\1\uffff\1\150\2\uffff\15\150\1\uffff\2\150\1\uffff\3\150\1\uffff\6\150\1\uffff\1\150\1\147\4\150\1\uffff\4\150\1\uffff\1\150",
            "\1\150\4\uffff\21\150\1\uffff\2\150\1\uffff\4\150\1\uffff\3\150\1\uffff\3\150\1\uffff\13\150\1\uffff\24\150\1\uffff\11\150\1\uffff\13\150\2\uffff\10\150\1\uffff\1\150\2\uffff\15\150\1\uffff\2\150\1\uffff\3\150\1\uffff\6\150\1\uffff\1\150\1\147\4\150\1\uffff\4\150\1\uffff\1\150",
            "\1\150\4\uffff\21\150\1\uffff\2\150\1\uffff\4\150\1\uffff\3\150\1\uffff\3\150\1\uffff\13\150\1\uffff\24\150\1\uffff\11\150\1\uffff\13\150\2\uffff\10\150\1\uffff\1\150\2\uffff\15\150\1\uffff\2\150\1\uffff\3\150\1\uffff\6\150\1\uffff\1\150\1\147\4\150\1\uffff\4\150\1\uffff\1\150",
            "\1\150\4\uffff\21\150\1\uffff\2\150\1\uffff\4\150\1\uffff\3\150\1\uffff\3\150\1\uffff\13\150\1\uffff\24\150\1\uffff\11\150\1\uffff\13\150\2\uffff\10\150\1\uffff\1\150\2\uffff\15\150\1\uffff\2\150\1\uffff\3\150\1\uffff\6\150\1\uffff\1\150\1\147\4\150\1\uffff\4\150\1\uffff\1\150",
            "\1\150\4\uffff\21\150\1\uffff\2\150\1\uffff\4\150\1\uffff\3\150\1\uffff\3\150\1\uffff\13\150\1\uffff\24\150\1\uffff\11\150\1\uffff\13\150\2\uffff\10\150\1\uffff\1\150\2\uffff\15\150\1\uffff\2\150\1\uffff\3\150\1\uffff\6\150\1\uffff\1\150\1\147\4\150\1\uffff\4\150\1\uffff\1\150",
            "\1\150\4\uffff\21\150\1\uffff\2\150\1\uffff\4\150\1\uffff\3\150\1\uffff\3\150\1\uffff\13\150\1\uffff\24\150\1\uffff\11\150\1\uffff\13\150\2\uffff\10\150\1\uffff\1\150\2\uffff\15\150\1\uffff\2\150\1\uffff\3\150\1\uffff\6\150\1\uffff\1\150\1\147\4\150\1\uffff\4\150\1\uffff\1\150",
            "\1\150\4\uffff\21\150\1\uffff\2\150\1\uffff\4\150\1\uffff\3\150\1\uffff\3\150\1\uffff\13\150\1\uffff\24\150\1\uffff\11\150\1\uffff\13\150\2\uffff\10\150\1\uffff\1\150\2\uffff\15\150\1\uffff\2\150\1\uffff\3\150\1\uffff\6\150\1\uffff\1\150\1\147\4\150\1\uffff\4\150\1\uffff\1\150",
            "\1\150\4\uffff\21\150\1\uffff\2\150\1\uffff\4\150\1\uffff\3\150\1\uffff\3\150\1\uffff\13\150\1\uffff\24\150\1\uffff\11\150\1\uffff\13\150\2\uffff\10\150\1\uffff\1\150\2\uffff\15\150\1\uffff\2\150\1\uffff\3\150\1\uffff\6\150\1\uffff\1\150\1\147\4\150\1\uffff\4\150\1\uffff\1\150",
            "\1\150\4\uffff\21\150\1\uffff\2\150\1\uffff\4\150\1\uffff\3\150\1\uffff\3\150\1\uffff\13\150\1\uffff\24\150\1\uffff\11\150\1\uffff\13\150\2\uffff\10\150\1\uffff\1\150\2\uffff\15\150\1\uffff\2\150\1\uffff\3\150\1\uffff\6\150\1\uffff\1\150\1\147\4\150\1\uffff\4\150\1\uffff\1\150",
            "\1\150\4\uffff\21\150\1\uffff\2\150\1\uffff\4\150\1\uffff\3\150\1\uffff\3\150\1\uffff\13\150\1\uffff\24\150\1\uffff\11\150\1\uffff\13\150\2\uffff\10\150\1\uffff\1\150\2\uffff\15\150\1\uffff\2\150\1\uffff\3\150\1\uffff\6\150\1\uffff\1\150\1\147\4\150\1\uffff\4\150\1\uffff\1\150",
            "\1\150\4\uffff\21\150\1\uffff\2\150\1\uffff\4\150\1\uffff\3\150\1\uffff\3\150\1\uffff\13\150\1\uffff\24\150\1\uffff\11\150\1\uffff\13\150\2\uffff\10\150\1\uffff\1\150\2\uffff\15\150\1\uffff\2\150\1\uffff\3\150\1\uffff\6\150\1\uffff\1\150\1\147\4\150\1\uffff\4\150\1\uffff\1\150",
            "\1\150\4\uffff\21\150\1\uffff\2\150\1\uffff\4\150\1\uffff\3\150\1\uffff\3\150\1\uffff\13\150\1\uffff\24\150\1\uffff\11\150\1\uffff\13\150\2\uffff\10\150\1\uffff\1\150\2\uffff\15\150\1\uffff\2\150\1\uffff\3\150\1\uffff\6\150\1\uffff\1\150\1\147\4\150\1\uffff\4\150\1\uffff\1\150",
            "\1\150\4\uffff\21\150\1\uffff\2\150\1\uffff\4\150\1\uffff\3\150\1\uffff\3\150\1\uffff\13\150\1\uffff\24\150\1\uffff\11\150\1\uffff\13\150\2\uffff\10\150\1\uffff\1\150\2\uffff\15\150\1\uffff\2\150\1\uffff\3\150\1\uffff\6\150\1\uffff\1\150\1\147\4\150\1\uffff\4\150\1\uffff\1\150",
            "\1\150\4\uffff\21\150\1\uffff\2\150\1\uffff\4\150\1\uffff\3\150\1\uffff\3\150\1\uffff\13\150\1\uffff\24\150\1\uffff\11\150\1\uffff\13\150\2\uffff\10\150\1\uffff\1\150\2\uffff\15\150\1\uffff\2\150\1\uffff\3\150\1\uffff\6\150\1\uffff\1\150\1\147\4\150\1\uffff\4\150\1\uffff\1\150",
            "\1\150\4\uffff\21\150\1\uffff\2\150\1\uffff\4\150\1\uffff\3\150\1\uffff\3\150\1\uffff\13\150\1\uffff\24\150\1\uffff\11\150\1\uffff\13\150\2\uffff\10\150\1\uffff\1\150\2\uffff\15\150\1\uffff\2\150\1\uffff\3\150\1\uffff\6\150\1\uffff\1\150\1\147\4\150\1\uffff\4\150\1\uffff\1\150",
            "\1\150\4\uffff\21\150\1\uffff\2\150\1\uffff\4\150\1\uffff\3\150\1\uffff\3\150\1\uffff\13\150\1\uffff\24\150\1\uffff\11\150\1\uffff\13\150\2\uffff\10\150\1\uffff\1\150\2\uffff\15\150\1\uffff\2\150\1\uffff\3\150\1\uffff\6\150\1\uffff\1\150\1\147\4\150\1\uffff\4\150\1\uffff\1\150",
            "\1\150\4\uffff\21\150\1\uffff\2\150\1\uffff\4\150\1\uffff\3\150\1\uffff\3\150\1\uffff\13\150\1\uffff\24\150\1\uffff\11\150\1\uffff\13\150\2\uffff\10\150\1\uffff\1\150\2\uffff\15\150\1\uffff\2\150\1\uffff\3\150\1\uffff\6\150\1\uffff\1\150\1\147\4\150\1\uffff\4\150\1\uffff\1\150",
            "\1\150\4\uffff\21\150\1\uffff\2\150\1\uffff\4\150\1\uffff\3\150\1\uffff\3\150\1\uffff\13\150\1\uffff\24\150\1\uffff\11\150\1\uffff\13\150\2\uffff\10\150\1\uffff\1\150\2\uffff\15\150\1\uffff\2\150\1\uffff\3\150\1\uffff\6\150\1\uffff\1\150\1\147\4\150\1\uffff\4\150\1\uffff\1\150",
            "\1\150\4\uffff\21\150\1\uffff\2\150\1\uffff\4\150\1\uffff\3\150\1\uffff\3\150\1\uffff\13\150\1\uffff\24\150\1\uffff\11\150\1\uffff\13\150\2\uffff\10\150\1\uffff\1\150\2\uffff\15\150\1\uffff\2\150\1\uffff\3\150\1\uffff\6\150\1\uffff\1\150\1\147\4\150\1\uffff\4\150\1\uffff\1\150",
            "\1\150\4\uffff\21\150\1\uffff\2\150\1\uffff\4\150\1\uffff\3\150\1\uffff\3\150\1\uffff\13\150\1\uffff\24\150\1\uffff\11\150\1\uffff\13\150\2\uffff\10\150\1\uffff\1\150\2\uffff\15\150\1\uffff\2\150\1\uffff\3\150\1\uffff\6\150\1\uffff\1\150\1\147\4\150\1\uffff\4\150\1\uffff\1\150",
            "\1\150\4\uffff\21\150\1\uffff\2\150\1\uffff\4\150\1\uffff\3\150\1\uffff\3\150\1\uffff\13\150\1\uffff\24\150\1\uffff\11\150\1\uffff\13\150\2\uffff\10\150\1\uffff\1\150\2\uffff\15\150\1\uffff\2\150\1\uffff\3\150\1\uffff\6\150\1\uffff\1\150\1\147\4\150\1\uffff\4\150\1\uffff\1\150",
            "\1\150\4\uffff\21\150\1\uffff\2\150\1\uffff\4\150\1\uffff\3\150\1\uffff\3\150\1\uffff\13\150\1\uffff\24\150\1\uffff\11\150\1\uffff\13\150\2\uffff\10\150\1\uffff\1\150\2\uffff\15\150\1\uffff\2\150\1\uffff\3\150\1\uffff\6\150\1\uffff\1\150\1\147\4\150\1\uffff\4\150\1\uffff\1\150",
            "\1\150\4\uffff\21\150\1\uffff\2\150\1\uffff\4\150\1\uffff\3\150\1\uffff\3\150\1\uffff\13\150\1\uffff\24\150\1\uffff\11\150\1\uffff\13\150\2\uffff\10\150\1\uffff\1\150\2\uffff\15\150\1\uffff\2\150\1\uffff\3\150\1\uffff\6\150\1\uffff\1\150\1\147\4\150\1\uffff\4\150\1\uffff\1\150",
            "\1\150\4\uffff\21\150\1\uffff\2\150\1\uffff\4\150\1\uffff\3\150\1\uffff\3\150\1\uffff\13\150\1\uffff\24\150\1\uffff\11\150\1\uffff\13\150\2\uffff\10\150\1\uffff\1\150\2\uffff\15\150\1\uffff\2\150\1\uffff\3\150\1\uffff\6\150\1\uffff\1\150\1\147\4\150\1\uffff\4\150\1\uffff\1\150",
            "\1\150\4\uffff\21\150\1\uffff\2\150\1\uffff\4\150\1\uffff\3\150\1\uffff\3\150\1\uffff\13\150\1\uffff\24\150\1\uffff\11\150\1\uffff\13\150\2\uffff\10\150\1\uffff\1\150\2\uffff\15\150\1\uffff\2\150\1\uffff\3\150\1\uffff\6\150\1\uffff\1\150\1\147\4\150\1\uffff\4\150\1\uffff\1\150",
            "\1\150\4\uffff\21\150\1\uffff\2\150\1\uffff\4\150\1\uffff\3\150\1\uffff\3\150\1\uffff\13\150\1\uffff\24\150\1\uffff\11\150\1\uffff\13\150\2\uffff\10\150\1\uffff\1\150\2\uffff\15\150\1\uffff\2\150\1\uffff\3\150\1\uffff\6\150\1\uffff\1\150\1\147\4\150\1\uffff\4\150\1\uffff\1\150",
            "\1\150\4\uffff\21\150\1\uffff\2\150\1\uffff\4\150\1\uffff\3\150\1\uffff\3\150\1\uffff\13\150\1\uffff\24\150\1\uffff\11\150\1\uffff\13\150\2\uffff\10\150\1\uffff\1\150\2\uffff\15\150\1\uffff\2\150\1\uffff\3\150\1\uffff\6\150\1\uffff\1\150\1\147\4\150\1\uffff\4\150\1\uffff\1\150",
            "\1\150\4\uffff\21\150\1\uffff\2\150\1\uffff\4\150\1\uffff\3\150\1\uffff\3\150\1\uffff\13\150\1\uffff\24\150\1\uffff\11\150\1\uffff\13\150\2\uffff\10\150\1\uffff\1\150\2\uffff\15\150\1\uffff\2\150\1\uffff\3\150\1\uffff\6\150\1\uffff\1\150\1\147\4\150\1\uffff\4\150\1\uffff\1\150",
            "\1\150\4\uffff\21\150\1\uffff\2\150\1\uffff\4\150\1\uffff\3\150\1\uffff\3\150\1\uffff\13\150\1\uffff\24\150\1\uffff\11\150\1\uffff\13\150\2\uffff\10\150\1\uffff\1\150\2\uffff\15\150\1\uffff\2\150\1\uffff\3\150\1\uffff\6\150\1\uffff\1\150\1\147\4\150\1\uffff\4\150\1\uffff\1\150",
            "\1\150\4\uffff\21\150\1\uffff\2\150\1\uffff\4\150\1\uffff\3\150\1\uffff\3\150\1\uffff\13\150\1\uffff\24\150\1\uffff\11\150\1\uffff\13\150\2\uffff\10\150\1\uffff\1\150\2\uffff\15\150\1\uffff\2\150\1\uffff\3\150\1\uffff\6\150\1\uffff\1\150\1\147\4\150\1\uffff\4\150\1\uffff\1\150",
            "\1\150\4\uffff\21\150\1\uffff\2\150\1\uffff\4\150\1\uffff\3\150\1\uffff\3\150\1\uffff\13\150\1\uffff\24\150\1\uffff\11\150\1\uffff\13\150\2\uffff\10\150\1\uffff\1\150\2\uffff\15\150\1\uffff\2\150\1\uffff\3\150\1\uffff\6\150\1\uffff\1\150\1\147\4\150\1\uffff\4\150\1\uffff\1\150",
            "\1\150\4\uffff\21\150\1\uffff\2\150\1\uffff\4\150\1\uffff\3\150\1\uffff\3\150\1\uffff\13\150\1\uffff\24\150\1\uffff\11\150\1\uffff\13\150\2\uffff\10\150\1\uffff\1\150\2\uffff\15\150\1\uffff\2\150\1\uffff\3\150\1\uffff\6\150\1\uffff\1\150\1\147\4\150\1\uffff\4\150\1\uffff\1\150",
            "\1\150\4\uffff\21\150\1\uffff\2\150\1\uffff\4\150\1\uffff\3\150\1\uffff\3\150\1\uffff\13\150\1\uffff\24\150\1\uffff\11\150\1\uffff\13\150\2\uffff\10\150\1\uffff\1\150\2\uffff\15\150\1\uffff\2\150\1\uffff\3\150\1\uffff\6\150\1\uffff\1\150\1\147\4\150\1\uffff\4\150\1\uffff\1\150",
            "\1\150\4\uffff\21\150\1\uffff\2\150\1\uffff\4\150\1\uffff\3\150\1\uffff\3\150\1\uffff\13\150\1\uffff\24\150\1\uffff\11\150\1\uffff\13\150\2\uffff\10\150\1\uffff\1\150\2\uffff\15\150\1\uffff\2\150\1\uffff\3\150\1\uffff\6\150\1\uffff\1\150\1\147\4\150\1\uffff\4\150\1\uffff\1\150",
            "\1\150\4\uffff\21\150\1\uffff\2\150\1\uffff\4\150\1\uffff\3\150\1\uffff\3\150\1\uffff\13\150\1\uffff\24\150\1\uffff\11\150\1\uffff\13\150\2\uffff\10\150\1\uffff\1\150\2\uffff\15\150\1\uffff\2\150\1\uffff\3\150\1\uffff\6\150\1\uffff\1\150\1\147\4\150\1\uffff\4\150\1\uffff\1\150",
            "\1\150\4\uffff\21\150\1\uffff\2\150\1\uffff\4\150\1\uffff\3\150\1\uffff\3\150\1\uffff\13\150\1\uffff\24\150\1\uffff\11\150\1\uffff\13\150\2\uffff\10\150\1\uffff\1\150\2\uffff\15\150\1\uffff\2\150\1\uffff\3\150\1\uffff\6\150\1\uffff\1\150\1\147\4\150\1\uffff\4\150\1\uffff\1\150",
            "\1\150\4\uffff\21\150\1\uffff\2\150\1\uffff\4\150\1\uffff\3\150\1\uffff\3\150\1\uffff\13\150\1\uffff\24\150\1\uffff\11\150\1\uffff\13\150\2\uffff\10\150\1\uffff\1\150\2\uffff\15\150\1\uffff\2\150\1\uffff\3\150\1\uffff\6\150\1\uffff\1\150\1\147\4\150\1\uffff\4\150\1\uffff\1\150",
            "\1\150\4\uffff\21\150\1\uffff\2\150\1\uffff\4\150\1\uffff\3\150\1\uffff\3\150\1\uffff\13\150\1\uffff\24\150\1\uffff\11\150\1\uffff\13\150\2\uffff\10\150\1\uffff\1\150\2\uffff\15\150\1\uffff\2\150\1\uffff\3\150\1\uffff\6\150\1\uffff\1\150\1\147\4\150\1\uffff\4\150\1\uffff\1\150",
            "\1\150\4\uffff\21\150\1\uffff\2\150\1\uffff\4\150\1\uffff\3\150\1\uffff\3\150\1\uffff\13\150\1\uffff\24\150\1\uffff\11\150\1\uffff\13\150\2\uffff\10\150\1\uffff\1\150\2\uffff\15\150\1\uffff\2\150\1\uffff\3\150\1\uffff\6\150\1\uffff\1\150\1\147\4\150\1\uffff\4\150\1\uffff\1\150",
            "\1\150\4\uffff\21\150\1\uffff\2\150\1\uffff\4\150\1\uffff\3\150\1\uffff\3\150\1\uffff\13\150\1\uffff\24\150\1\uffff\11\150\1\uffff\13\150\2\uffff\10\150\1\uffff\1\150\2\uffff\15\150\1\uffff\2\150\1\uffff\3\150\1\uffff\6\150\1\uffff\1\150\1\147\4\150\1\uffff\4\150\1\uffff\1\150",
            "\1\150\4\uffff\21\150\1\uffff\2\150\1\uffff\4\150\1\uffff\3\150\1\uffff\3\150\1\uffff\13\150\1\uffff\24\150\1\uffff\11\150\1\uffff\13\150\2\uffff\10\150\1\uffff\1\150\2\uffff\15\150\1\uffff\2\150\1\uffff\3\150\1\uffff\6\150\1\uffff\1\150\1\147\4\150\1\uffff\4\150\1\uffff\1\150",
            "\1\150\4\uffff\21\150\1\uffff\2\150\1\uffff\4\150\1\uffff\3\150\1\uffff\3\150\1\uffff\13\150\1\uffff\24\150\1\uffff\11\150\1\uffff\13\150\2\uffff\10\150\1\uffff\1\150\2\uffff\15\150\1\uffff\2\150\1\uffff\3\150\1\uffff\6\150\1\uffff\1\150\1\147\4\150\1\uffff\4\150\1\uffff\1\150",
            "\1\150\4\uffff\21\150\1\uffff\2\150\1\uffff\4\150\1\uffff\3\150\1\uffff\3\150\1\uffff\13\150\1\uffff\24\150\1\uffff\11\150\1\uffff\13\150\2\uffff\10\150\1\uffff\1\150\2\uffff\15\150\1\uffff\2\150\1\uffff\3\150\1\uffff\6\150\1\uffff\1\150\1\147\4\150\1\uffff\4\150\1\uffff\1\150",
            "\1\150\4\uffff\21\150\1\uffff\2\150\1\uffff\4\150\1\uffff\3\150\1\uffff\3\150\1\uffff\13\150\1\uffff\24\150\1\uffff\11\150\1\uffff\13\150\2\uffff\10\150\1\uffff\1\150\2\uffff\15\150\1\uffff\2\150\1\uffff\3\150\1\uffff\6\150\1\uffff\1\150\1\147\4\150\1\uffff\4\150\1\uffff\1\150",
            "\1\150\4\uffff\21\150\1\uffff\2\150\1\uffff\4\150\1\uffff\3\150\1\uffff\3\150\1\uffff\13\150\1\uffff\24\150\1\uffff\11\150\1\uffff\13\150\2\uffff\10\150\1\uffff\1\150\2\uffff\15\150\1\uffff\2\150\1\uffff\3\150\1\uffff\6\150\1\uffff\1\150\1\147\4\150\1\uffff\4\150\1\uffff\1\150",
            "\1\150\4\uffff\21\150\1\uffff\2\150\1\uffff\4\150\1\uffff\3\150\1\uffff\3\150\1\uffff\13\150\1\uffff\24\150\1\uffff\11\150\1\uffff\13\150\2\uffff\10\150\1\uffff\1\150\2\uffff\15\150\1\uffff\2\150\1\uffff\3\150\1\uffff\6\150\1\uffff\1\150\1\147\4\150\1\uffff\4\150\1\uffff\1\150",
            "\1\150\4\uffff\21\150\1\uffff\2\150\1\uffff\4\150\1\uffff\3\150\1\uffff\3\150\1\uffff\13\150\1\uffff\24\150\1\uffff\11\150\1\uffff\13\150\2\uffff\10\150\1\uffff\1\150\2\uffff\15\150\1\uffff\2\150\1\uffff\3\150\1\uffff\6\150\1\uffff\1\150\1\147\4\150\1\uffff\4\150\1\uffff\1\150",
            "\1\150\4\uffff\21\150\1\uffff\2\150\1\uffff\4\150\1\uffff\3\150\1\uffff\3\150\1\uffff\13\150\1\uffff\24\150\1\uffff\11\150\1\uffff\13\150\2\uffff\10\150\1\uffff\1\150\2\uffff\15\150\1\uffff\2\150\1\uffff\3\150\1\uffff\6\150\1\uffff\1\150\1\147\4\150\1\uffff\4\150\1\uffff\1\150",
            "\1\150\4\uffff\21\150\1\uffff\2\150\1\uffff\4\150\1\uffff\3\150\1\uffff\3\150\1\uffff\13\150\1\uffff\24\150\1\uffff\11\150\1\uffff\13\150\2\uffff\10\150\1\uffff\1\150\2\uffff\15\150\1\uffff\2\150\1\uffff\3\150\1\uffff\6\150\1\uffff\1\150\1\147\4\150\1\uffff\4\150\1\uffff\1\150",
            "\1\150\4\uffff\21\150\1\uffff\2\150\1\uffff\4\150\1\uffff\3\150\1\uffff\3\150\1\uffff\13\150\1\uffff\24\150\1\uffff\11\150\1\uffff\13\150\2\uffff\10\150\1\uffff\1\150\2\uffff\15\150\1\uffff\2\150\1\uffff\3\150\1\uffff\6\150\1\uffff\1\150\1\147\4\150\1\uffff\4\150\1\uffff\1\150",
            "\1\150\4\uffff\21\150\1\uffff\2\150\1\uffff\4\150\1\uffff\3\150\1\uffff\3\150\1\uffff\13\150\1\uffff\24\150\1\uffff\11\150\1\uffff\13\150\2\uffff\10\150\1\uffff\1\150\2\uffff\15\150\1\uffff\2\150\1\uffff\3\150\1\uffff\6\150\1\uffff\1\150\1\147\4\150\1\uffff\4\150\1\uffff\1\150",
            "\1\150\4\uffff\21\150\1\uffff\2\150\1\uffff\4\150\1\uffff\3\150\1\uffff\3\150\1\uffff\13\150\1\uffff\24\150\1\uffff\11\150\1\uffff\13\150\2\uffff\10\150\1\uffff\1\150\2\uffff\15\150\1\uffff\2\150\1\uffff\3\150\1\uffff\6\150\1\uffff\1\150\1\147\4\150\1\uffff\4\150\1\uffff\1\150",
            "\1\150\4\uffff\21\150\1\uffff\2\150\1\uffff\4\150\1\uffff\3\150\1\uffff\3\150\1\uffff\13\150\1\uffff\24\150\1\uffff\11\150\1\uffff\13\150\2\uffff\10\150\1\uffff\1\150\2\uffff\15\150\1\uffff\2\150\1\uffff\3\150\1\uffff\6\150\1\uffff\1\150\1\147\4\150\1\uffff\4\150\1\uffff\1\150",
            "\1\150\4\uffff\21\150\1\uffff\2\150\1\uffff\4\150\1\uffff\3\150\1\uffff\3\150\1\uffff\13\150\1\uffff\24\150\1\uffff\11\150\1\uffff\13\150\2\uffff\10\150\1\uffff\1\150\2\uffff\15\150\1\uffff\2\150\1\uffff\3\150\1\uffff\6\150\1\uffff\1\150\1\147\4\150\1\uffff\4\150\1\uffff\1\150",
            "\1\150\4\uffff\21\150\1\uffff\2\150\1\uffff\4\150\1\uffff\3\150\1\uffff\3\150\1\uffff\13\150\1\uffff\24\150\1\uffff\11\150\1\uffff\13\150\2\uffff\10\150\1\uffff\1\150\2\uffff\15\150\1\uffff\2\150\1\uffff\3\150\1\uffff\6\150\1\uffff\1\150\1\147\4\150\1\uffff\4\150\1\uffff\1\150",
            "\1\150\4\uffff\21\150\1\uffff\2\150\1\uffff\4\150\1\uffff\3\150\1\uffff\3\150\1\uffff\13\150\1\uffff\24\150\1\uffff\11\150\1\uffff\13\150\2\uffff\10\150\1\uffff\1\150\2\uffff\15\150\1\uffff\2\150\1\uffff\3\150\1\uffff\6\150\1\uffff\1\150\1\147\4\150\1\uffff\4\150\1\uffff\1\150",
            "\1\150\4\uffff\21\150\1\uffff\2\150\1\uffff\4\150\1\uffff\3\150\1\uffff\3\150\1\uffff\13\150\1\uffff\24\150\1\uffff\11\150\1\uffff\13\150\2\uffff\10\150\1\uffff\1\150\2\uffff\15\150\1\uffff\2\150\1\uffff\3\150\1\uffff\6\150\1\uffff\1\150\1\147\4\150\1\uffff\4\150\1\uffff\1\150",
            "\1\150\4\uffff\21\150\1\uffff\2\150\1\uffff\4\150\1\uffff\3\150\1\uffff\3\150\1\uffff\13\150\1\uffff\24\150\1\uffff\11\150\1\uffff\13\150\2\uffff\10\150\1\uffff\1\150\2\uffff\15\150\1\uffff\2\150\1\uffff\3\150\1\uffff\6\150\1\uffff\1\150\1\147\4\150\1\uffff\4\150\1\uffff\1\150",
            "\1\150\4\uffff\21\150\1\uffff\2\150\1\uffff\4\150\1\uffff\3\150\1\uffff\3\150\1\uffff\13\150\1\uffff\24\150\1\uffff\11\150\1\uffff\13\150\2\uffff\10\150\1\uffff\1\150\2\uffff\15\150\1\uffff\2\150\1\uffff\3\150\1\uffff\6\150\1\uffff\1\150\1\147\4\150\1\uffff\4\150\1\uffff\1\150",
            "\1\150\4\uffff\21\150\1\uffff\2\150\1\uffff\4\150\1\uffff\3\150\1\uffff\3\150\1\uffff\13\150\1\uffff\24\150\1\uffff\11\150\1\uffff\13\150\2\uffff\10\150\1\uffff\1\150\2\uffff\15\150\1\uffff\2\150\1\uffff\3\150\1\uffff\6\150\1\uffff\1\150\1\147\4\150\1\uffff\4\150\1\uffff\1\150",
            "\1\150\4\uffff\21\150\1\uffff\2\150\1\uffff\4\150\1\uffff\3\150\1\uffff\3\150\1\uffff\13\150\1\uffff\24\150\1\uffff\11\150\1\uffff\13\150\2\uffff\10\150\1\uffff\1\150\2\uffff\15\150\1\uffff\2\150\1\uffff\3\150\1\uffff\6\150\1\uffff\1\150\1\147\4\150\1\uffff\4\150\1\uffff\1\150",
            "\1\150\4\uffff\21\150\1\uffff\2\150\1\uffff\4\150\1\uffff\3\150\1\uffff\3\150\1\uffff\13\150\1\uffff\24\150\1\uffff\11\150\1\uffff\13\150\2\uffff\10\150\1\uffff\1\150\2\uffff\15\150\1\uffff\2\150\1\uffff\3\150\1\uffff\6\150\1\uffff\1\150\1\147\4\150\1\uffff\4\150\1\uffff\1\150",
            "\1\150\4\uffff\21\150\1\uffff\2\150\1\uffff\4\150\1\uffff\3\150\1\uffff\3\150\1\uffff\13\150\1\uffff\24\150\1\uffff\11\150\1\uffff\13\150\2\uffff\10\150\1\uffff\1\150\2\uffff\15\150\1\uffff\2\150\1\uffff\3\150\1\uffff\6\150\1\uffff\1\150\1\147\4\150\1\uffff\4\150\1\uffff\1\150",
            "\1\150\4\uffff\21\150\1\uffff\2\150\1\uffff\4\150\1\uffff\3\150\1\uffff\3\150\1\uffff\13\150\1\uffff\24\150\1\uffff\11\150\1\uffff\13\150\2\uffff\10\150\1\uffff\1\150\2\uffff\15\150\1\uffff\2\150\1\uffff\3\150\1\uffff\6\150\1\uffff\1\150\1\147\4\150\1\uffff\4\150\1\uffff\1\150",
            "\1\150\4\uffff\21\150\1\uffff\2\150\1\uffff\4\150\1\uffff\3\150\1\uffff\3\150\1\uffff\13\150\1\uffff\24\150\1\uffff\11\150\1\uffff\13\150\2\uffff\10\150\1\uffff\1\150\2\uffff\15\150\1\uffff\2\150\1\uffff\3\150\1\uffff\6\150\1\uffff\1\150\1\147\4\150\1\uffff\4\150\1\uffff\1\150",
            "\1\150\4\uffff\21\150\1\uffff\2\150\1\uffff\4\150\1\uffff\3\150\1\uffff\3\150\1\uffff\13\150\1\uffff\24\150\1\uffff\11\150\1\uffff\13\150\2\uffff\10\150\1\uffff\1\150\2\uffff\15\150\1\uffff\2\150\1\uffff\3\150\1\uffff\6\150\1\uffff\1\150\1\147\4\150\1\uffff\4\150\1\uffff\1\150",
            "\1\150\4\uffff\21\150\1\uffff\2\150\1\uffff\4\150\1\uffff\3\150\1\uffff\3\150\1\uffff\13\150\1\uffff\24\150\1\uffff\11\150\1\uffff\13\150\2\uffff\10\150\1\uffff\1\150\2\uffff\15\150\1\uffff\2\150\1\uffff\3\150\1\uffff\6\150\1\uffff\1\150\1\147\4\150\1\uffff\4\150\1\uffff\1\150",
            "\1\150\4\uffff\21\150\1\uffff\2\150\1\uffff\4\150\1\uffff\3\150\1\uffff\3\150\1\uffff\13\150\1\uffff\24\150\1\uffff\11\150\1\uffff\13\150\2\uffff\10\150\1\uffff\1\150\2\uffff\15\150\1\uffff\2\150\1\uffff\3\150\1\uffff\6\150\1\uffff\1\150\1\147\4\150\1\uffff\4\150\1\uffff\1\150",
            "\1\150\4\uffff\21\150\1\uffff\2\150\1\uffff\4\150\1\uffff\3\150\1\uffff\3\150\1\uffff\13\150\1\uffff\24\150\1\uffff\11\150\1\uffff\13\150\2\uffff\10\150\1\uffff\1\150\2\uffff\15\150\1\uffff\2\150\1\uffff\3\150\1\uffff\6\150\1\uffff\1\150\1\147\4\150\1\uffff\4\150\1\uffff\1\150",
            "\1\150\4\uffff\21\150\1\uffff\2\150\1\uffff\4\150\1\uffff\3\150\1\uffff\3\150\1\uffff\13\150\1\uffff\24\150\1\uffff\11\150\1\uffff\13\150\2\uffff\10\150\1\uffff\1\150\2\uffff\15\150\1\uffff\2\150\1\uffff\3\150\1\uffff\6\150\1\uffff\1\150\1\147\4\150\1\uffff\4\150\1\uffff\1\150",
            "\1\150\4\uffff\21\150\1\uffff\2\150\1\uffff\4\150\1\uffff\3\150\1\uffff\3\150\1\uffff\13\150\1\uffff\24\150\1\uffff\11\150\1\uffff\13\150\2\uffff\10\150\1\uffff\1\150\2\uffff\15\150\1\uffff\2\150\1\uffff\3\150\1\uffff\6\150\1\uffff\1\150\1\147\4\150\1\uffff\4\150\1\uffff\1\150",
            "\1\150\4\uffff\21\150\1\uffff\2\150\1\uffff\4\150\1\uffff\3\150\1\uffff\3\150\1\uffff\13\150\1\uffff\24\150\1\uffff\11\150\1\uffff\13\150\2\uffff\10\150\1\uffff\1\150\2\uffff\15\150\1\uffff\2\150\1\uffff\3\150\1\uffff\6\150\1\uffff\1\150\1\147\4\150\1\uffff\4\150\1\uffff\1\150",
            "\1\150\4\uffff\21\150\1\uffff\2\150\1\uffff\4\150\1\uffff\3\150\1\uffff\3\150\1\uffff\13\150\1\uffff\24\150\1\uffff\11\150\1\uffff\13\150\2\uffff\10\150\1\uffff\1\150\2\uffff\15\150\1\uffff\2\150\1\uffff\3\150\1\uffff\6\150\1\uffff\1\150\1\147\4\150\1\uffff\4\150\1\uffff\1\150",
            "\1\150\4\uffff\21\150\1\uffff\2\150\1\uffff\4\150\1\uffff\3\150\1\uffff\3\150\1\uffff\13\150\1\uffff\24\150\1\uffff\11\150\1\uffff\13\150\2\uffff\10\150\1\uffff\1\150\2\uffff\15\150\1\uffff\2\150\1\uffff\3\150\1\uffff\6\150\1\uffff\1\150\1\147\4\150\1\uffff\4\150\1\uffff\1\150",
            "\1\150\4\uffff\21\150\1\uffff\2\150\1\uffff\4\150\1\uffff\3\150\1\uffff\3\150\1\uffff\13\150\1\uffff\24\150\1\uffff\11\150\1\uffff\13\150\2\uffff\10\150\1\uffff\1\150\2\uffff\15\150\1\uffff\2\150\1\uffff\3\150\1\uffff\6\150\1\uffff\1\150\1\147\4\150\1\uffff\4\150\1\uffff\1\150",
            "\1\150\4\uffff\21\150\1\uffff\2\150\1\uffff\4\150\1\uffff\3\150\1\uffff\3\150\1\uffff\13\150\1\uffff\24\150\1\uffff\11\150\1\uffff\13\150\2\uffff\10\150\1\uffff\1\150\2\uffff\15\150\1\uffff\2\150\1\uffff\3\150\1\uffff\6\150\1\uffff\1\150\1\147\4\150\1\uffff\4\150\1\uffff\1\150",
            "\1\150\4\uffff\21\150\1\uffff\2\150\1\uffff\4\150\1\uffff\3\150\1\uffff\3\150\1\uffff\13\150\1\uffff\24\150\1\uffff\11\150\1\uffff\13\150\2\uffff\10\150\1\uffff\1\150\2\uffff\15\150\1\uffff\2\150\1\uffff\3\150\1\uffff\6\150\1\uffff\1\150\1\147\4\150\1\uffff\4\150\1\uffff\1\150",
            "\1\150\4\uffff\21\150\1\uffff\2\150\1\uffff\4\150\1\uffff\3\150\1\uffff\3\150\1\uffff\13\150\1\uffff\24\150\1\uffff\11\150\1\uffff\13\150\2\uffff\10\150\1\uffff\1\150\2\uffff\15\150\1\uffff\2\150\1\uffff\3\150\1\uffff\6\150\1\uffff\1\150\1\147\4\150\1\uffff\4\150\1\uffff\1\150",
            "\1\150\4\uffff\21\150\1\uffff\2\150\1\uffff\4\150\1\uffff\3\150\1\uffff\3\150\1\uffff\13\150\1\uffff\24\150\1\uffff\11\150\1\uffff\13\150\2\uffff\10\150\1\uffff\1\150\2\uffff\15\150\1\uffff\2\150\1\uffff\3\150\1\uffff\6\150\1\uffff\1\150\1\147\4\150\1\uffff\4\150\1\uffff\1\150",
            "\1\150\4\uffff\21\150\1\uffff\2\150\1\uffff\4\150\1\uffff\3\150\1\uffff\3\150\1\uffff\13\150\1\uffff\24\150\1\uffff\11\150\1\uffff\13\150\2\uffff\10\150\1\uffff\1\150\2\uffff\15\150\1\uffff\2\150\1\uffff\3\150\1\uffff\6\150\1\uffff\1\150\1\147\4\150\1\uffff\4\150\1\uffff\1\150",
            "\1\150\4\uffff\21\150\1\uffff\2\150\1\uffff\4\150\1\uffff\3\150\1\uffff\3\150\1\uffff\13\150\1\uffff\24\150\1\uffff\11\150\1\uffff\13\150\2\uffff\10\150\1\uffff\1\150\2\uffff\15\150\1\uffff\2\150\1\uffff\3\150\1\uffff\6\150\1\uffff\1\150\1\147\4\150\1\uffff\4\150\1\uffff\1\150",
            "\1\150\4\uffff\21\150\1\uffff\2\150\1\uffff\4\150\1\uffff\3\150\1\uffff\3\150\1\uffff\13\150\1\uffff\24\150\1\uffff\11\150\1\uffff\13\150\2\uffff\10\150\1\uffff\1\150\2\uffff\15\150\1\uffff\2\150\1\uffff\3\150\1\uffff\6\150\1\uffff\1\150\1\147\4\150\1\uffff\4\150\1\uffff\1\150",
            "\1\150\4\uffff\21\150\1\uffff\2\150\1\uffff\4\150\1\uffff\3\150\1\uffff\3\150\1\uffff\13\150\1\uffff\24\150\1\uffff\11\150\1\uffff\13\150\2\uffff\10\150\1\uffff\1\150\2\uffff\15\150\1\uffff\2\150\1\uffff\3\150\1\uffff\6\150\1\uffff\1\150\1\147\4\150\1\uffff\4\150\1\uffff\1\150",
            "\1\150\4\uffff\21\150\1\uffff\2\150\1\uffff\4\150\1\uffff\3\150\1\uffff\3\150\1\uffff\13\150\1\uffff\24\150\1\uffff\11\150\1\uffff\13\150\2\uffff\10\150\1\uffff\1\150\2\uffff\15\150\1\uffff\2\150\1\uffff\3\150\1\uffff\6\150\1\uffff\1\150\1\147\4\150\1\uffff\4\150\1\uffff\1\150",
            "\1\150\4\uffff\21\150\1\uffff\2\150\1\uffff\4\150\1\uffff\3\150\1\uffff\3\150\1\uffff\13\150\1\uffff\24\150\1\uffff\11\150\1\uffff\13\150\2\uffff\10\150\1\uffff\1\150\2\uffff\15\150\1\uffff\2\150\1\uffff\3\150\1\uffff\6\150\1\uffff\1\150\1\147\4\150\1\uffff\4\150\1\uffff\1\150",
            "\1\150\4\uffff\21\150\1\uffff\2\150\1\uffff\4\150\1\uffff\3\150\1\uffff\3\150\1\uffff\13\150\1\uffff\24\150\1\uffff\11\150\1\uffff\13\150\2\uffff\10\150\1\uffff\1\150\2\uffff\15\150\1\uffff\2\150\1\uffff\3\150\1\uffff\6\150\1\uffff\1\150\1\147\4\150\1\uffff\4\150\1\uffff\1\150",
            "",
            ""
    };

    static final short[] dfa_29 = DFA.unpackEncodedString(dfa_29s);
    static final short[] dfa_30 = DFA.unpackEncodedString(dfa_30s);
    static final char[] dfa_31 = DFA.unpackEncodedStringToUnsignedChars(dfa_31s);
    static final char[] dfa_32 = DFA.unpackEncodedStringToUnsignedChars(dfa_32s);
    static final short[] dfa_33 = DFA.unpackEncodedString(dfa_33s);
    static final short[] dfa_34 = DFA.unpackEncodedString(dfa_34s);
    static final short[][] dfa_35 = unpackEncodedStringArray(dfa_35s);

    class DFA56 extends DFA {

        public DFA56(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 56;
            this.eot = dfa_29;
            this.eof = dfa_30;
            this.min = dfa_31;
            this.max = dfa_32;
            this.accept = dfa_33;
            this.special = dfa_34;
            this.transition = dfa_35;
        }
        public String getDescription() {
            return "7207:3: (this_IdOrKw_0= ruleIdOrKw kw= Colon )?";
        }
    }
    static final String dfa_36s = "\126\uffff";
    static final String dfa_37s = "\1\uffff\123\125\2\uffff";
    static final String dfa_38s = "\1\12\123\u008d\2\uffff";
    static final String dfa_39s = "\1\u0098\123\u0095\2\uffff";
    static final String dfa_40s = "\124\uffff\1\1\1\2";
    static final String dfa_41s = "\126\uffff}>";
    static final String[] dfa_42s = {
            "\1\67\1\30\1\22\1\23\1\115\1\71\1\45\1\46\1\53\1\55\1\104\1\20\2\uffff\1\105\1\10\1\111\1\uffff\1\33\1\54\1\uffff\1\16\1\uffff\1\25\1\24\1\uffff\1\41\1\44\1\52\1\uffff\1\65\1\74\1\122\1\uffff\1\5\1\31\1\32\1\47\1\116\1\61\1\63\1\70\1\3\1\6\2\uffff\1\15\1\107\1\17\1\26\1\27\1\35\1\uffff\1\60\1\117\1\76\1\2\1\4\1\uffff\1\13\1\14\1\110\1\34\1\42\1\50\1\56\1\uffff\1\62\1\66\1\73\1\uffff\1\120\3\uffff\1\77\2\uffff\1\112\1\36\3\uffff\1\64\2\uffff\1\100\1\102\2\uffff\1\7\1\uffff\1\12\1\21\1\uffff\1\40\1\43\1\51\1\uffff\1\57\2\uffff\1\121\1\75\1\123\1\101\1\103\1\106\1\uffff\1\11\1\uffff\1\37\1\113\1\114\2\uffff\1\72\31\uffff\1\1",
            "\1\124\1\125\6\uffff\1\125",
            "\1\124\1\125\6\uffff\1\125",
            "\1\124\1\125\6\uffff\1\125",
            "\1\124\1\125\6\uffff\1\125",
            "\1\124\1\125\6\uffff\1\125",
            "\1\124\1\125\6\uffff\1\125",
            "\1\124\1\125\6\uffff\1\125",
            "\1\124\1\125\6\uffff\1\125",
            "\1\124\1\125\6\uffff\1\125",
            "\1\124\1\125\6\uffff\1\125",
            "\1\124\1\125\6\uffff\1\125",
            "\1\124\1\125\6\uffff\1\125",
            "\1\124\1\125\6\uffff\1\125",
            "\1\124\1\125\6\uffff\1\125",
            "\1\124\1\125\6\uffff\1\125",
            "\1\124\1\125\6\uffff\1\125",
            "\1\124\1\125\6\uffff\1\125",
            "\1\124\1\125\6\uffff\1\125",
            "\1\124\1\125\6\uffff\1\125",
            "\1\124\1\125\6\uffff\1\125",
            "\1\124\1\125\6\uffff\1\125",
            "\1\124\1\125\6\uffff\1\125",
            "\1\124\1\125\6\uffff\1\125",
            "\1\124\1\125\6\uffff\1\125",
            "\1\124\1\125\6\uffff\1\125",
            "\1\124\1\125\6\uffff\1\125",
            "\1\124\1\125\6\uffff\1\125",
            "\1\124\1\125\6\uffff\1\125",
            "\1\124\1\125\6\uffff\1\125",
            "\1\124\1\125\6\uffff\1\125",
            "\1\124\1\125\6\uffff\1\125",
            "\1\124\1\125\6\uffff\1\125",
            "\1\124\1\125\6\uffff\1\125",
            "\1\124\1\125\6\uffff\1\125",
            "\1\124\1\125\6\uffff\1\125",
            "\1\124\1\125\6\uffff\1\125",
            "\1\124\1\125\6\uffff\1\125",
            "\1\124\1\125\6\uffff\1\125",
            "\1\124\1\125\6\uffff\1\125",
            "\1\124\1\125\6\uffff\1\125",
            "\1\124\1\125\6\uffff\1\125",
            "\1\124\1\125\6\uffff\1\125",
            "\1\124\1\125\6\uffff\1\125",
            "\1\124\1\125\6\uffff\1\125",
            "\1\124\1\125\6\uffff\1\125",
            "\1\124\1\125\6\uffff\1\125",
            "\1\124\1\125\6\uffff\1\125",
            "\1\124\1\125\6\uffff\1\125",
            "\1\124\1\125\6\uffff\1\125",
            "\1\124\1\125\6\uffff\1\125",
            "\1\124\1\125\6\uffff\1\125",
            "\1\124\1\125\6\uffff\1\125",
            "\1\124\1\125\6\uffff\1\125",
            "\1\124\1\125\6\uffff\1\125",
            "\1\124\1\125\6\uffff\1\125",
            "\1\124\1\125\6\uffff\1\125",
            "\1\124\1\125\6\uffff\1\125",
            "\1\124\1\125\6\uffff\1\125",
            "\1\124\1\125\6\uffff\1\125",
            "\1\124\1\125\6\uffff\1\125",
            "\1\124\1\125\6\uffff\1\125",
            "\1\124\1\125\6\uffff\1\125",
            "\1\124\1\125\6\uffff\1\125",
            "\1\124\1\125\6\uffff\1\125",
            "\1\124\1\125\6\uffff\1\125",
            "\1\124\1\125\6\uffff\1\125",
            "\1\124\1\125\6\uffff\1\125",
            "\1\124\1\125\6\uffff\1\125",
            "\1\124\1\125\6\uffff\1\125",
            "\1\124\1\125\6\uffff\1\125",
            "\1\124\1\125\6\uffff\1\125",
            "\1\124\1\125\6\uffff\1\125",
            "\1\124\1\125\6\uffff\1\125",
            "\1\124\1\125\6\uffff\1\125",
            "\1\124\1\125\6\uffff\1\125",
            "\1\124\1\125\6\uffff\1\125",
            "\1\124\1\125\6\uffff\1\125",
            "\1\124\1\125\6\uffff\1\125",
            "\1\124\1\125\6\uffff\1\125",
            "\1\124\1\125\6\uffff\1\125",
            "\1\124\1\125\6\uffff\1\125",
            "\1\124\1\125\6\uffff\1\125",
            "\1\124\1\125\6\uffff\1\125",
            "",
            ""
    };

    static final short[] dfa_36 = DFA.unpackEncodedString(dfa_36s);
    static final short[] dfa_37 = DFA.unpackEncodedString(dfa_37s);
    static final char[] dfa_38 = DFA.unpackEncodedStringToUnsignedChars(dfa_38s);
    static final char[] dfa_39 = DFA.unpackEncodedStringToUnsignedChars(dfa_39s);
    static final short[] dfa_40 = DFA.unpackEncodedString(dfa_40s);
    static final short[] dfa_41 = DFA.unpackEncodedString(dfa_41s);
    static final short[][] dfa_42 = unpackEncodedStringArray(dfa_42s);

    class DFA60 extends DFA {

        public DFA60(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 60;
            this.eot = dfa_36;
            this.eof = dfa_37;
            this.min = dfa_38;
            this.max = dfa_39;
            this.accept = dfa_40;
            this.special = dfa_41;
            this.transition = dfa_42;
        }
        public String getDescription() {
            return "7327:3: ( (this_ID_0= RULE_ID | this_KEYWORD_1= ruleKEYWORD ) kw= Colon )?";
        }
    }
 

    public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_3 = new BitSet(new long[]{0xBD3EF376B33FBC00L,0x429A2ED32220EF6EL,0x0000000002800000L});
    public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000004000000L});
    public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000204000L});
    public static final BitSet FOLLOW_6 = new BitSet(new long[]{0xFF7FF777B7FFFC20L,0x4EBF2FF3FFBFEFFFL,0x0000000001000000L});
    public static final BitSet FOLLOW_7 = new BitSet(new long[]{0xFFFFFFFFFFFFFFF0L,0x5FFFFFF7FFFFFFFFL,0x000000000D041CB9L});
    public static final BitSet FOLLOW_8 = new BitSet(new long[]{0xFF7FF777B7FFFC20L,0x4EBF2FF3FFBFEFFFL,0x0000000001204000L});
    public static final BitSet FOLLOW_9 = new BitSet(new long[]{0xFF7FF777B7FFFC22L,0x4EBF2FF3FFBFEFFFL,0x0000000001000000L});
    public static final BitSet FOLLOW_10 = new BitSet(new long[]{0xFF7FF777B7FFFC20L,0x4EBF2FF3FFBFEFFFL,0x0000000001001000L});
    public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000004204000L});
    public static final BitSet FOLLOW_12 = new BitSet(new long[]{0xFF7FF777B7FFFC20L,0x6EBF2FF3FFBFEFFFL,0x0000000001000020L});
    public static final BitSet FOLLOW_13 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0000000000000008L});
    public static final BitSet FOLLOW_14 = new BitSet(new long[]{0x0000000000000002L,0x0040000000000000L});
    public static final BitSet FOLLOW_15 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000040L});
    public static final BitSet FOLLOW_16 = new BitSet(new long[]{0x0000000000000000L,0x0C00000000000000L,0x0000000008000000L});
    public static final BitSet FOLLOW_17 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0000000000400000L});
    public static final BitSet FOLLOW_18 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0000000000000001L});
    public static final BitSet FOLLOW_19 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0000000000001000L});
    public static final BitSet FOLLOW_20 = new BitSet(new long[]{0x0000000000000000L,0x0000000800000000L});
    public static final BitSet FOLLOW_21 = new BitSet(new long[]{0x0000000000000002L,0x8000000000000000L,0x0000000000010000L});
    public static final BitSet FOLLOW_22 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0000000000028006L});
    public static final BitSet FOLLOW_23 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0000000000000500L});
    public static final BitSet FOLLOW_24 = new BitSet(new long[]{0x0000000000000002L,0x1100000000000000L,0x0000000000000080L});
    public static final BitSet FOLLOW_25 = new BitSet(new long[]{0x008008C8480003D0L,0x1140D00000401000L,0x0000000001041889L});
    public static final BitSet FOLLOW_26 = new BitSet(new long[]{0x008008C8480003D0L,0x1140D00000401000L,0x0000000001040889L});
    public static final BitSet FOLLOW_27 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0000000000081000L});
    public static final BitSet FOLLOW_28 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000100000L});
    public static final BitSet FOLLOW_29 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0000000000080000L});
    public static final BitSet FOLLOW_30 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000020L});
    public static final BitSet FOLLOW_31 = new BitSet(new long[]{0xFFFFFFFFFFFFFFF0L,0x5FFFFFF7FFFFFFFFL,0x000000000D041CF9L});
    public static final BitSet FOLLOW_32 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000240L});
    public static final BitSet FOLLOW_33 = new BitSet(new long[]{0x008008C8480003D2L,0x1140D00000401000L,0x0000000001041889L});
    public static final BitSet FOLLOW_34 = new BitSet(new long[]{0x008008C8480003D2L,0x1140D00000401000L,0x0000000001040889L});
    public static final BitSet FOLLOW_35 = new BitSet(new long[]{0x008008C8480003C0L,0x1140D00000401000L,0x0000000001000088L});
    public static final BitSet FOLLOW_36 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000002000L});
    public static final BitSet FOLLOW_37 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0000000004000000L});
    public static final BitSet FOLLOW_38 = new BitSet(new long[]{0xBF3FF776B73FFC00L,0x4EBF2ED32322EFEFL,0x0000000001000000L});

}
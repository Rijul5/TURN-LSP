package io.typefox.yang.parser.antlr.lexer;

// Hack: Use our own Lexer superclass by means of import. 
// Currently there is no other way to specify the superclass for the lexer.
import org.eclipse.xtext.parser.antlr.Lexer;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalYangLexer extends Lexer {
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

    public InternalYangLexer() {;} 
    public InternalYangLexer(CharStream input) {
        this(input, new RecognizerSharedState());
    }
    public InternalYangLexer(CharStream input, RecognizerSharedState state) {
        super(input,state);

    }
    public String getGrammarFileName() { return "InternalYangLexer.g"; }

    // $ANTLR start "ProcessingInstruction"
    public final void mProcessingInstruction() throws RecognitionException {
        try {
            int _type = ProcessingInstruction;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalYangLexer.g:14:23: ( 'processing-instruction' )
            // InternalYangLexer.g:14:25: 'processing-instruction'
            {
            match("processing-instruction"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "ProcessingInstruction"

    // $ANTLR start "InstanceIdentifier"
    public final void mInstanceIdentifier() throws RecognitionException {
        try {
            int _type = InstanceIdentifier;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalYangLexer.g:16:20: ( 'instance-identifier' )
            // InternalYangLexer.g:16:22: 'instance-identifier'
            {
            match("instance-identifier"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "InstanceIdentifier"

    // $ANTLR start "DescendantOrSelf"
    public final void mDescendantOrSelf() throws RecognitionException {
        try {
            int _type = DescendantOrSelf;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalYangLexer.g:18:18: ( 'descendant-or-self' )
            // InternalYangLexer.g:18:20: 'descendant-or-self'
            {
            match("descendant-or-self"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "DescendantOrSelf"

    // $ANTLR start "FollowingSibling"
    public final void mFollowingSibling() throws RecognitionException {
        try {
            int _type = FollowingSibling;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalYangLexer.g:20:18: ( 'following-sibling' )
            // InternalYangLexer.g:20:20: 'following-sibling'
            {
            match("following-sibling"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "FollowingSibling"

    // $ANTLR start "PrecedingSibling"
    public final void mPrecedingSibling() throws RecognitionException {
        try {
            int _type = PrecedingSibling;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalYangLexer.g:22:18: ( 'preceding-sibling' )
            // InternalYangLexer.g:22:20: 'preceding-sibling'
            {
            match("preceding-sibling"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "PrecedingSibling"

    // $ANTLR start "AncestorOrSelf"
    public final void mAncestorOrSelf() throws RecognitionException {
        try {
            int _type = AncestorOrSelf;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalYangLexer.g:24:16: ( 'ancestor-or-self' )
            // InternalYangLexer.g:24:18: 'ancestor-or-self'
            {
            match("ancestor-or-self"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "AncestorOrSelf"

    // $ANTLR start "RequireInstance"
    public final void mRequireInstance() throws RecognitionException {
        try {
            int _type = RequireInstance;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalYangLexer.g:26:17: ( 'require-instance' )
            // InternalYangLexer.g:26:19: 'require-instance'
            {
            match("require-instance"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RequireInstance"

    // $ANTLR start "FractionDigits"
    public final void mFractionDigits() throws RecognitionException {
        try {
            int _type = FractionDigits;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalYangLexer.g:28:16: ( 'fraction-digits' )
            // InternalYangLexer.g:28:18: 'fraction-digits'
            {
            match("fraction-digits"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "FractionDigits"

    // $ANTLR start "ErrorAppTag"
    public final void mErrorAppTag() throws RecognitionException {
        try {
            int _type = ErrorAppTag;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalYangLexer.g:30:13: ( 'error-app-tag' )
            // InternalYangLexer.g:30:15: 'error-app-tag'
            {
            match("error-app-tag"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "ErrorAppTag"

    // $ANTLR start "ErrorMessage"
    public final void mErrorMessage() throws RecognitionException {
        try {
            int _type = ErrorMessage;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalYangLexer.g:32:14: ( 'error-message' )
            // InternalYangLexer.g:32:16: 'error-message'
            {
            match("error-message"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "ErrorMessage"

    // $ANTLR start "NotSupported"
    public final void mNotSupported() throws RecognitionException {
        try {
            int _type = NotSupported;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalYangLexer.g:34:14: ( 'not-supported' )
            // InternalYangLexer.g:34:16: 'not-supported'
            {
            match("not-supported"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "NotSupported"

    // $ANTLR start "RevisionDate"
    public final void mRevisionDate() throws RecognitionException {
        try {
            int _type = RevisionDate;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalYangLexer.g:36:14: ( 'revision-date' )
            // InternalYangLexer.g:36:16: 'revision-date'
            {
            match("revision-date"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RevisionDate"

    // $ANTLR start "MaxElements"
    public final void mMaxElements() throws RecognitionException {
        try {
            int _type = MaxElements;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalYangLexer.g:38:13: ( 'max-elements' )
            // InternalYangLexer.g:38:15: 'max-elements'
            {
            match("max-elements"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "MaxElements"

    // $ANTLR start "MinElements"
    public final void mMinElements() throws RecognitionException {
        try {
            int _type = MinElements;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalYangLexer.g:40:13: ( 'min-elements' )
            // InternalYangLexer.g:40:15: 'min-elements'
            {
            match("min-elements"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "MinElements"

    // $ANTLR start "Notification"
    public final void mNotification() throws RecognitionException {
        try {
            int _type = Notification;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalYangLexer.g:42:14: ( 'notification' )
            // InternalYangLexer.g:42:16: 'notification'
            {
            match("notification"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Notification"

    // $ANTLR start "Organization"
    public final void mOrganization() throws RecognitionException {
        try {
            int _type = Organization;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalYangLexer.g:44:14: ( 'organization' )
            // InternalYangLexer.g:44:16: 'organization'
            {
            match("organization"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Organization"

    // $ANTLR start "YangVersion"
    public final void mYangVersion() throws RecognitionException {
        try {
            int _type = YangVersion;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalYangLexer.g:46:13: ( 'yang-version' )
            // InternalYangLexer.g:46:15: 'yang-version'
            {
            match("yang-version"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "YangVersion"

    // $ANTLR start "Description"
    public final void mDescription() throws RecognitionException {
        try {
            int _type = Description;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalYangLexer.g:48:13: ( 'description' )
            // InternalYangLexer.g:48:15: 'description'
            {
            match("description"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Description"

    // $ANTLR start "Enumeration"
    public final void mEnumeration() throws RecognitionException {
        try {
            int _type = Enumeration;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalYangLexer.g:50:13: ( 'enumeration' )
            // InternalYangLexer.g:50:15: 'enumeration'
            {
            match("enumeration"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Enumeration"

    // $ANTLR start "Identityref"
    public final void mIdentityref() throws RecognitionException {
        try {
            int _type = Identityref;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalYangLexer.g:52:13: ( 'identityref' )
            // InternalYangLexer.g:52:15: 'identityref'
            {
            match("identityref"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Identityref"

    // $ANTLR start "YinElement"
    public final void mYinElement() throws RecognitionException {
        try {
            int _type = YinElement;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalYangLexer.g:54:12: ( 'yin-element' )
            // InternalYangLexer.g:54:14: 'yin-element'
            {
            match("yin-element"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "YinElement"

    // $ANTLR start "BelongsTo"
    public final void mBelongsTo() throws RecognitionException {
        try {
            int _type = BelongsTo;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalYangLexer.g:56:11: ( 'belongs-to' )
            // InternalYangLexer.g:56:13: 'belongs-to'
            {
            match("belongs-to"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "BelongsTo"

    // $ANTLR start "Deprecated"
    public final void mDeprecated() throws RecognitionException {
        try {
            int _type = Deprecated;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalYangLexer.g:58:12: ( 'deprecated' )
            // InternalYangLexer.g:58:14: 'deprecated'
            {
            match("deprecated"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Deprecated"

    // $ANTLR start "Descendant"
    public final void mDescendant() throws RecognitionException {
        try {
            int _type = Descendant;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalYangLexer.g:60:12: ( 'descendant' )
            // InternalYangLexer.g:60:14: 'descendant'
            {
            match("descendant"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Descendant"

    // $ANTLR start "IfFeature"
    public final void mIfFeature() throws RecognitionException {
        try {
            int _type = IfFeature;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalYangLexer.g:62:11: ( 'if-feature' )
            // InternalYangLexer.g:62:13: 'if-feature'
            {
            match("if-feature"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "IfFeature"

    // $ANTLR start "OrderedBy"
    public final void mOrderedBy() throws RecognitionException {
        try {
            int _type = OrderedBy;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalYangLexer.g:64:11: ( 'ordered-by' )
            // InternalYangLexer.g:64:13: 'ordered-by'
            {
            match("ordered-by"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "OrderedBy"

    // $ANTLR start "Attribute"
    public final void mAttribute() throws RecognitionException {
        try {
            int _type = Attribute;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalYangLexer.g:66:11: ( 'attribute' )
            // InternalYangLexer.g:66:13: 'attribute'
            {
            match("attribute"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Attribute"

    // $ANTLR start "Container"
    public final void mContainer() throws RecognitionException {
        try {
            int _type = Container;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalYangLexer.g:68:11: ( 'container' )
            // InternalYangLexer.g:68:13: 'container'
            {
            match("container"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Container"

    // $ANTLR start "Decimal64"
    public final void mDecimal64() throws RecognitionException {
        try {
            int _type = Decimal64;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalYangLexer.g:70:11: ( 'decimal64' )
            // InternalYangLexer.g:70:13: 'decimal64'
            {
            match("decimal64"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Decimal64"

    // $ANTLR start "Deviation"
    public final void mDeviation() throws RecognitionException {
        try {
            int _type = Deviation;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalYangLexer.g:72:11: ( 'deviation' )
            // InternalYangLexer.g:72:13: 'deviation'
            {
            match("deviation"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Deviation"

    // $ANTLR start "Extension"
    public final void mExtension() throws RecognitionException {
        try {
            int _type = Extension;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalYangLexer.g:74:11: ( 'extension' )
            // InternalYangLexer.g:74:13: 'extension'
            {
            match("extension"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Extension"

    // $ANTLR start "Following"
    public final void mFollowing() throws RecognitionException {
        try {
            int _type = Following;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalYangLexer.g:76:11: ( 'following' )
            // InternalYangLexer.g:76:13: 'following'
            {
            match("following"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Following"

    // $ANTLR start "LeafList"
    public final void mLeafList() throws RecognitionException {
        try {
            int _type = LeafList;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalYangLexer.g:78:10: ( 'leaf-list' )
            // InternalYangLexer.g:78:12: 'leaf-list'
            {
            match("leaf-list"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "LeafList"

    // $ANTLR start "Mandatory"
    public final void mMandatory() throws RecognitionException {
        try {
            int _type = Mandatory;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalYangLexer.g:80:11: ( 'mandatory' )
            // InternalYangLexer.g:80:13: 'mandatory'
            {
            match("mandatory"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Mandatory"

    // $ANTLR start "Namespace"
    public final void mNamespace() throws RecognitionException {
        try {
            int _type = Namespace;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalYangLexer.g:82:11: ( 'namespace' )
            // InternalYangLexer.g:82:13: 'namespace'
            {
            match("namespace"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Namespace"

    // $ANTLR start "Preceding"
    public final void mPreceding() throws RecognitionException {
        try {
            int _type = Preceding;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalYangLexer.g:84:11: ( 'preceding' )
            // InternalYangLexer.g:84:13: 'preceding'
            {
            match("preceding"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Preceding"

    // $ANTLR start "Reference"
    public final void mReference() throws RecognitionException {
        try {
            int _type = Reference;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalYangLexer.g:86:11: ( 'reference' )
            // InternalYangLexer.g:86:13: 'reference'
            {
            match("reference"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Reference"

    // $ANTLR start "Submodule"
    public final void mSubmodule() throws RecognitionException {
        try {
            int _type = Submodule;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalYangLexer.g:88:11: ( 'submodule' )
            // InternalYangLexer.g:88:13: 'submodule'
            {
            match("submodule"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Submodule"

    // $ANTLR start "Unbounded"
    public final void mUnbounded() throws RecognitionException {
        try {
            int _type = Unbounded;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalYangLexer.g:90:11: ( 'unbounded' )
            // InternalYangLexer.g:90:13: 'unbounded'
            {
            match("unbounded"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Unbounded"

    // $ANTLR start "Ancestor"
    public final void mAncestor() throws RecognitionException {
        try {
            int _type = Ancestor;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalYangLexer.g:92:10: ( 'ancestor' )
            // InternalYangLexer.g:92:12: 'ancestor'
            {
            match("ancestor"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Ancestor"

    // $ANTLR start "Argument"
    public final void mArgument() throws RecognitionException {
        try {
            int _type = Argument;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalYangLexer.g:94:10: ( 'argument' )
            // InternalYangLexer.g:94:12: 'argument'
            {
            match("argument"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Argument"

    // $ANTLR start "Grouping"
    public final void mGrouping() throws RecognitionException {
        try {
            int _type = Grouping;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalYangLexer.g:96:10: ( 'grouping' )
            // InternalYangLexer.g:96:12: 'grouping'
            {
            match("grouping"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Grouping"

    // $ANTLR start "Identity"
    public final void mIdentity() throws RecognitionException {
        try {
            int _type = Identity;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalYangLexer.g:98:10: ( 'identity' )
            // InternalYangLexer.g:98:12: 'identity'
            {
            match("identity"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Identity"

    // $ANTLR start "Modifier"
    public final void mModifier() throws RecognitionException {
        try {
            int _type = Modifier;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalYangLexer.g:100:10: ( 'modifier' )
            // InternalYangLexer.g:100:12: 'modifier'
            {
            match("modifier"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Modifier"

    // $ANTLR start "Obsolete"
    public final void mObsolete() throws RecognitionException {
        try {
            int _type = Obsolete;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalYangLexer.g:102:10: ( 'obsolete' )
            // InternalYangLexer.g:102:12: 'obsolete'
            {
            match("obsolete"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Obsolete"

    // $ANTLR start "Position"
    public final void mPosition() throws RecognitionException {
        try {
            int _type = Position;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalYangLexer.g:104:10: ( 'position' )
            // InternalYangLexer.g:104:12: 'position'
            {
            match("position"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Position"

    // $ANTLR start "Presence"
    public final void mPresence() throws RecognitionException {
        try {
            int _type = Presence;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalYangLexer.g:106:10: ( 'presence' )
            // InternalYangLexer.g:106:12: 'presence'
            {
            match("presence"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Presence"

    // $ANTLR start "Revision"
    public final void mRevision() throws RecognitionException {
        try {
            int _type = Revision;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalYangLexer.g:108:10: ( 'revision' )
            // InternalYangLexer.g:108:12: 'revision'
            {
            match("revision"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Revision"

    // $ANTLR start "Anydata"
    public final void mAnydata() throws RecognitionException {
        try {
            int _type = Anydata;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalYangLexer.g:110:9: ( 'anydata' )
            // InternalYangLexer.g:110:11: 'anydata'
            {
            match("anydata"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Anydata"

    // $ANTLR start "Augment"
    public final void mAugment() throws RecognitionException {
        try {
            int _type = Augment;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalYangLexer.g:112:9: ( 'augment' )
            // InternalYangLexer.g:112:11: 'augment'
            {
            match("augment"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Augment"

    // $ANTLR start "Boolean"
    public final void mBoolean() throws RecognitionException {
        try {
            int _type = Boolean;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalYangLexer.g:114:9: ( 'boolean' )
            // InternalYangLexer.g:114:11: 'boolean'
            {
            match("boolean"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Boolean"

    // $ANTLR start "Comment"
    public final void mComment() throws RecognitionException {
        try {
            int _type = Comment;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalYangLexer.g:116:9: ( 'comment' )
            // InternalYangLexer.g:116:11: 'comment'
            {
            match("comment"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Comment"

    // $ANTLR start "Contact"
    public final void mContact() throws RecognitionException {
        try {
            int _type = Contact;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalYangLexer.g:118:9: ( 'contact' )
            // InternalYangLexer.g:118:11: 'contact'
            {
            match("contact"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Contact"

    // $ANTLR start "Current"
    public final void mCurrent() throws RecognitionException {
        try {
            int _type = Current;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalYangLexer.g:120:9: ( 'current' )
            // InternalYangLexer.g:120:11: 'current'
            {
            match("current"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Current"

    // $ANTLR start "Default"
    public final void mDefault() throws RecognitionException {
        try {
            int _type = Default;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalYangLexer.g:122:9: ( 'default' )
            // InternalYangLexer.g:122:11: 'default'
            {
            match("default"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Default"

    // $ANTLR start "Deviate"
    public final void mDeviate() throws RecognitionException {
        try {
            int _type = Deviate;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalYangLexer.g:124:9: ( 'deviate' )
            // InternalYangLexer.g:124:11: 'deviate'
            {
            match("deviate"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Deviate"

    // $ANTLR start "Feature"
    public final void mFeature() throws RecognitionException {
        try {
            int _type = Feature;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalYangLexer.g:126:9: ( 'feature' )
            // InternalYangLexer.g:126:11: 'feature'
            {
            match("feature"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Feature"

    // $ANTLR start "Include"
    public final void mInclude() throws RecognitionException {
        try {
            int _type = Include;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalYangLexer.g:128:9: ( 'include' )
            // InternalYangLexer.g:128:11: 'include'
            {
            match("include"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Include"

    // $ANTLR start "Leafref"
    public final void mLeafref() throws RecognitionException {
        try {
            int _type = Leafref;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalYangLexer.g:130:9: ( 'leafref' )
            // InternalYangLexer.g:130:11: 'leafref'
            {
            match("leafref"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Leafref"

    // $ANTLR start "Pattern"
    public final void mPattern() throws RecognitionException {
        try {
            int _type = Pattern;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalYangLexer.g:132:9: ( 'pattern' )
            // InternalYangLexer.g:132:11: 'pattern'
            {
            match("pattern"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Pattern"

    // $ANTLR start "Replace"
    public final void mReplace() throws RecognitionException {
        try {
            int _type = Replace;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalYangLexer.g:134:9: ( 'replace' )
            // InternalYangLexer.g:134:11: 'replace'
            {
            match("replace"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Replace"

    // $ANTLR start "Typedef"
    public final void mTypedef() throws RecognitionException {
        try {
            int _type = Typedef;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalYangLexer.g:136:9: ( 'typedef' )
            // InternalYangLexer.g:136:11: 'typedef'
            {
            match("typedef"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Typedef"

    // $ANTLR start "Action"
    public final void mAction() throws RecognitionException {
        try {
            int _type = Action;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalYangLexer.g:138:8: ( 'action' )
            // InternalYangLexer.g:138:10: 'action'
            {
            match("action"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Action"

    // $ANTLR start "Anyxml"
    public final void mAnyxml() throws RecognitionException {
        try {
            int _type = Anyxml;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalYangLexer.g:140:8: ( 'anyxml' )
            // InternalYangLexer.g:140:10: 'anyxml'
            {
            match("anyxml"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Anyxml"

    // $ANTLR start "Binary"
    public final void mBinary() throws RecognitionException {
        try {
            int _type = Binary;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalYangLexer.g:142:8: ( 'binary' )
            // InternalYangLexer.g:142:10: 'binary'
            {
            match("binary"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Binary"

    // $ANTLR start "Choice"
    public final void mChoice() throws RecognitionException {
        try {
            int _type = Choice;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalYangLexer.g:144:8: ( 'choice' )
            // InternalYangLexer.g:144:10: 'choice'
            {
            match("choice"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Choice"

    // $ANTLR start "Config"
    public final void mConfig() throws RecognitionException {
        try {
            int _type = Config;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalYangLexer.g:146:8: ( 'config' )
            // InternalYangLexer.g:146:10: 'config'
            {
            match("config"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Config"

    // $ANTLR start "Delete"
    public final void mDelete() throws RecognitionException {
        try {
            int _type = Delete;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalYangLexer.g:148:8: ( 'delete' )
            // InternalYangLexer.g:148:10: 'delete'
            {
            match("delete"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Delete"

    // $ANTLR start "Import"
    public final void mImport() throws RecognitionException {
        try {
            int _type = Import;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalYangLexer.g:150:8: ( 'import' )
            // InternalYangLexer.g:150:10: 'import'
            {
            match("import"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Import"

    // $ANTLR start "Length"
    public final void mLength() throws RecognitionException {
        try {
            int _type = Length;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalYangLexer.g:152:8: ( 'length' )
            // InternalYangLexer.g:152:10: 'length'
            {
            match("length"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Length"

    // $ANTLR start "Module"
    public final void mModule() throws RecognitionException {
        try {
            int _type = Module;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalYangLexer.g:154:8: ( 'module' )
            // InternalYangLexer.g:154:10: 'module'
            {
            match("module"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Module"

    // $ANTLR start "Output"
    public final void mOutput() throws RecognitionException {
        try {
            int _type = Output;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalYangLexer.g:156:8: ( 'output' )
            // InternalYangLexer.g:156:10: 'output'
            {
            match("output"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Output"

    // $ANTLR start "Parent"
    public final void mParent() throws RecognitionException {
        try {
            int _type = Parent;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalYangLexer.g:158:8: ( 'parent' )
            // InternalYangLexer.g:158:10: 'parent'
            {
            match("parent"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Parent"

    // $ANTLR start "Prefix"
    public final void mPrefix() throws RecognitionException {
        try {
            int _type = Prefix;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalYangLexer.g:160:8: ( 'prefix' )
            // InternalYangLexer.g:160:10: 'prefix'
            {
            match("prefix"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Prefix"

    // $ANTLR start "Refine"
    public final void mRefine() throws RecognitionException {
        try {
            int _type = Refine;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalYangLexer.g:162:8: ( 'refine' )
            // InternalYangLexer.g:162:10: 'refine'
            {
            match("refine"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Refine"

    // $ANTLR start "Status"
    public final void mStatus() throws RecognitionException {
        try {
            int _type = Status;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalYangLexer.g:164:8: ( 'status' )
            // InternalYangLexer.g:164:10: 'status'
            {
            match("status"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Status"

    // $ANTLR start "String"
    public final void mString() throws RecognitionException {
        try {
            int _type = String;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalYangLexer.g:166:8: ( 'string' )
            // InternalYangLexer.g:166:10: 'string'
            {
            match("string"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "String"

    // $ANTLR start "KW_System"
    public final void mKW_System() throws RecognitionException {
        try {
            int _type = KW_System;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalYangLexer.g:168:11: ( 'system' )
            // InternalYangLexer.g:168:13: 'system'
            {
            match("system"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "KW_System"

    // $ANTLR start "Uint16"
    public final void mUint16() throws RecognitionException {
        try {
            int _type = Uint16;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalYangLexer.g:170:8: ( 'uint16' )
            // InternalYangLexer.g:170:10: 'uint16'
            {
            match("uint16"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Uint16"

    // $ANTLR start "Uint32"
    public final void mUint32() throws RecognitionException {
        try {
            int _type = Uint32;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalYangLexer.g:172:8: ( 'uint32' )
            // InternalYangLexer.g:172:10: 'uint32'
            {
            match("uint32"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Uint32"

    // $ANTLR start "Uint64"
    public final void mUint64() throws RecognitionException {
        try {
            int _type = Uint64;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalYangLexer.g:174:8: ( 'uint64' )
            // InternalYangLexer.g:174:10: 'uint64'
            {
            match("uint64"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Uint64"

    // $ANTLR start "Unique"
    public final void mUnique() throws RecognitionException {
        try {
            int _type = Unique;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalYangLexer.g:176:8: ( 'unique' )
            // InternalYangLexer.g:176:10: 'unique'
            {
            match("unique"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Unique"

    // $ANTLR start "Child"
    public final void mChild() throws RecognitionException {
        try {
            int _type = Child;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalYangLexer.g:178:7: ( 'child' )
            // InternalYangLexer.g:178:9: 'child'
            {
            match("child"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Child"

    // $ANTLR start "Empty"
    public final void mEmpty() throws RecognitionException {
        try {
            int _type = Empty;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalYangLexer.g:180:7: ( 'empty' )
            // InternalYangLexer.g:180:9: 'empty'
            {
            match("empty"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Empty"

    // $ANTLR start "False"
    public final void mFalse() throws RecognitionException {
        try {
            int _type = False;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalYangLexer.g:182:7: ( 'false' )
            // InternalYangLexer.g:182:9: 'false'
            {
            match("false"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "False"

    // $ANTLR start "Input"
    public final void mInput() throws RecognitionException {
        try {
            int _type = Input;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalYangLexer.g:184:7: ( 'input' )
            // InternalYangLexer.g:184:9: 'input'
            {
            match("input"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Input"

    // $ANTLR start "Int16"
    public final void mInt16() throws RecognitionException {
        try {
            int _type = Int16;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalYangLexer.g:186:7: ( 'int16' )
            // InternalYangLexer.g:186:9: 'int16'
            {
            match("int16"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Int16"

    // $ANTLR start "Int32"
    public final void mInt32() throws RecognitionException {
        try {
            int _type = Int32;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalYangLexer.g:188:7: ( 'int32' )
            // InternalYangLexer.g:188:9: 'int32'
            {
            match("int32"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Int32"

    // $ANTLR start "Int64"
    public final void mInt64() throws RecognitionException {
        try {
            int _type = Int64;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalYangLexer.g:190:7: ( 'int64' )
            // InternalYangLexer.g:190:9: 'int64'
            {
            match("int64"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Int64"

    // $ANTLR start "Range"
    public final void mRange() throws RecognitionException {
        try {
            int _type = Range;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalYangLexer.g:192:7: ( 'range' )
            // InternalYangLexer.g:192:9: 'range'
            {
            match("range"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Range"

    // $ANTLR start "Uint8"
    public final void mUint8() throws RecognitionException {
        try {
            int _type = Uint8;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalYangLexer.g:194:7: ( 'uint8' )
            // InternalYangLexer.g:194:9: 'uint8'
            {
            match("uint8"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Uint8"

    // $ANTLR start "Union"
    public final void mUnion() throws RecognitionException {
        try {
            int _type = Union;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalYangLexer.g:196:7: ( 'union' )
            // InternalYangLexer.g:196:9: 'union'
            {
            match("union"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Union"

    // $ANTLR start "Units"
    public final void mUnits() throws RecognitionException {
        try {
            int _type = Units;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalYangLexer.g:198:7: ( 'units' )
            // InternalYangLexer.g:198:9: 'units'
            {
            match("units"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Units"

    // $ANTLR start "Value"
    public final void mValue() throws RecognitionException {
        try {
            int _type = Value;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalYangLexer.g:200:7: ( 'value' )
            // InternalYangLexer.g:200:9: 'value'
            {
            match("value"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Value"

    // $ANTLR start "LessThanSignLessThanSignLessThanSignLessThanSign"
    public final void mLessThanSignLessThanSignLessThanSignLessThanSign() throws RecognitionException {
        try {
            int _type = LessThanSignLessThanSignLessThanSignLessThanSign;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalYangLexer.g:202:50: ( '<<<<' )
            // InternalYangLexer.g:202:52: '<<<<'
            {
            match("<<<<"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "LessThanSignLessThanSignLessThanSignLessThanSign"

    // $ANTLR start "GreaterThanSignGreaterThanSignGreaterThanSignGreaterThanSign"
    public final void mGreaterThanSignGreaterThanSignGreaterThanSignGreaterThanSign() throws RecognitionException {
        try {
            int _type = GreaterThanSignGreaterThanSignGreaterThanSignGreaterThanSign;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalYangLexer.g:204:62: ( '>>>>' )
            // InternalYangLexer.g:204:64: '>>>>'
            {
            match(">>>>"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "GreaterThanSignGreaterThanSignGreaterThanSignGreaterThanSign"

    // $ANTLR start "Base"
    public final void mBase() throws RecognitionException {
        try {
            int _type = Base;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalYangLexer.g:206:6: ( 'base' )
            // InternalYangLexer.g:206:8: 'base'
            {
            match("base"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Base"

    // $ANTLR start "Bits"
    public final void mBits() throws RecognitionException {
        try {
            int _type = Bits;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalYangLexer.g:208:6: ( 'bits' )
            // InternalYangLexer.g:208:8: 'bits'
            {
            match("bits"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Bits"

    // $ANTLR start "Case"
    public final void mCase() throws RecognitionException {
        try {
            int _type = Case;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalYangLexer.g:210:6: ( 'case' )
            // InternalYangLexer.g:210:8: 'case'
            {
            match("case"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Case"

    // $ANTLR start "Enum"
    public final void mEnum() throws RecognitionException {
        try {
            int _type = Enum;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalYangLexer.g:212:6: ( 'enum' )
            // InternalYangLexer.g:212:8: 'enum'
            {
            match("enum"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Enum"

    // $ANTLR start "Int8"
    public final void mInt8() throws RecognitionException {
        try {
            int _type = Int8;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalYangLexer.g:214:6: ( 'int8' )
            // InternalYangLexer.g:214:8: 'int8'
            {
            match("int8"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Int8"

    // $ANTLR start "Leaf"
    public final void mLeaf() throws RecognitionException {
        try {
            int _type = Leaf;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalYangLexer.g:216:6: ( 'leaf' )
            // InternalYangLexer.g:216:8: 'leaf'
            {
            match("leaf"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Leaf"

    // $ANTLR start "List"
    public final void mList() throws RecognitionException {
        try {
            int _type = List;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalYangLexer.g:218:6: ( 'list' )
            // InternalYangLexer.g:218:8: 'list'
            {
            match("list"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "List"

    // $ANTLR start "Must"
    public final void mMust() throws RecognitionException {
        try {
            int _type = Must;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalYangLexer.g:220:6: ( 'must' )
            // InternalYangLexer.g:220:8: 'must'
            {
            match("must"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Must"

    // $ANTLR start "Node"
    public final void mNode() throws RecognitionException {
        try {
            int _type = Node;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalYangLexer.g:222:6: ( 'node' )
            // InternalYangLexer.g:222:8: 'node'
            {
            match("node"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Node"

    // $ANTLR start "Path"
    public final void mPath() throws RecognitionException {
        try {
            int _type = Path;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalYangLexer.g:224:6: ( 'path' )
            // InternalYangLexer.g:224:8: 'path'
            {
            match("path"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Path"

    // $ANTLR start "Self"
    public final void mSelf() throws RecognitionException {
        try {
            int _type = Self;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalYangLexer.g:226:6: ( 'self' )
            // InternalYangLexer.g:226:8: 'self'
            {
            match("self"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Self"

    // $ANTLR start "Text"
    public final void mText() throws RecognitionException {
        try {
            int _type = Text;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalYangLexer.g:228:6: ( 'text' )
            // InternalYangLexer.g:228:8: 'text'
            {
            match("text"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Text"

    // $ANTLR start "True"
    public final void mTrue() throws RecognitionException {
        try {
            int _type = True;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalYangLexer.g:230:6: ( 'true' )
            // InternalYangLexer.g:230:8: 'true'
            {
            match("true"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "True"

    // $ANTLR start "Type"
    public final void mType() throws RecognitionException {
        try {
            int _type = Type;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalYangLexer.g:232:6: ( 'type' )
            // InternalYangLexer.g:232:8: 'type'
            {
            match("type"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Type"

    // $ANTLR start "User"
    public final void mUser() throws RecognitionException {
        try {
            int _type = User;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalYangLexer.g:234:6: ( 'user' )
            // InternalYangLexer.g:234:8: 'user'
            {
            match("user"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "User"

    // $ANTLR start "Uses"
    public final void mUses() throws RecognitionException {
        try {
            int _type = Uses;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalYangLexer.g:236:6: ( 'uses' )
            // InternalYangLexer.g:236:8: 'uses'
            {
            match("uses"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Uses"

    // $ANTLR start "When"
    public final void mWhen() throws RecognitionException {
        try {
            int _type = When;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalYangLexer.g:238:6: ( 'when' )
            // InternalYangLexer.g:238:8: 'when'
            {
            match("when"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "When"

    // $ANTLR start "Add"
    public final void mAdd() throws RecognitionException {
        try {
            int _type = Add;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalYangLexer.g:240:5: ( 'add' )
            // InternalYangLexer.g:240:7: 'add'
            {
            match("add"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Add"

    // $ANTLR start "And"
    public final void mAnd() throws RecognitionException {
        try {
            int _type = And;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalYangLexer.g:242:5: ( 'and' )
            // InternalYangLexer.g:242:7: 'and'
            {
            match("and"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "And"

    // $ANTLR start "Bit"
    public final void mBit() throws RecognitionException {
        try {
            int _type = Bit;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalYangLexer.g:244:5: ( 'bit' )
            // InternalYangLexer.g:244:7: 'bit'
            {
            match("bit"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Bit"

    // $ANTLR start "Div"
    public final void mDiv() throws RecognitionException {
        try {
            int _type = Div;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalYangLexer.g:246:5: ( 'div' )
            // InternalYangLexer.g:246:7: 'div'
            {
            match("div"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Div"

    // $ANTLR start "Key"
    public final void mKey() throws RecognitionException {
        try {
            int _type = Key;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalYangLexer.g:248:5: ( 'key' )
            // InternalYangLexer.g:248:7: 'key'
            {
            match("key"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Key"

    // $ANTLR start "Max"
    public final void mMax() throws RecognitionException {
        try {
            int _type = Max;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalYangLexer.g:250:5: ( 'max' )
            // InternalYangLexer.g:250:7: 'max'
            {
            match("max"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Max"

    // $ANTLR start "Min"
    public final void mMin() throws RecognitionException {
        try {
            int _type = Min;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalYangLexer.g:252:5: ( 'min' )
            // InternalYangLexer.g:252:7: 'min'
            {
            match("min"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Min"

    // $ANTLR start "Mod"
    public final void mMod() throws RecognitionException {
        try {
            int _type = Mod;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalYangLexer.g:254:5: ( 'mod' )
            // InternalYangLexer.g:254:7: 'mod'
            {
            match("mod"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Mod"

    // $ANTLR start "Not"
    public final void mNot() throws RecognitionException {
        try {
            int _type = Not;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalYangLexer.g:256:5: ( 'not' )
            // InternalYangLexer.g:256:7: 'not'
            {
            match("not"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Not"

    // $ANTLR start "Rpc"
    public final void mRpc() throws RecognitionException {
        try {
            int _type = Rpc;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalYangLexer.g:258:5: ( 'rpc' )
            // InternalYangLexer.g:258:7: 'rpc'
            {
            match("rpc"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Rpc"

    // $ANTLR start "ExclamationMarkEqualsSign"
    public final void mExclamationMarkEqualsSign() throws RecognitionException {
        try {
            int _type = ExclamationMarkEqualsSign;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalYangLexer.g:260:27: ( '!=' )
            // InternalYangLexer.g:260:29: '!='
            {
            match("!="); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "ExclamationMarkEqualsSign"

    // $ANTLR start "FullStopFullStop"
    public final void mFullStopFullStop() throws RecognitionException {
        try {
            int _type = FullStopFullStop;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalYangLexer.g:262:18: ( '..' )
            // InternalYangLexer.g:262:20: '..'
            {
            match(".."); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "FullStopFullStop"

    // $ANTLR start "LessThanSignEqualsSign"
    public final void mLessThanSignEqualsSign() throws RecognitionException {
        try {
            int _type = LessThanSignEqualsSign;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalYangLexer.g:264:24: ( '<=' )
            // InternalYangLexer.g:264:26: '<='
            {
            match("<="); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "LessThanSignEqualsSign"

    // $ANTLR start "GreaterThanSignEqualsSign"
    public final void mGreaterThanSignEqualsSign() throws RecognitionException {
        try {
            int _type = GreaterThanSignEqualsSign;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalYangLexer.g:266:27: ( '>=' )
            // InternalYangLexer.g:266:29: '>='
            {
            match(">="); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "GreaterThanSignEqualsSign"

    // $ANTLR start "Or"
    public final void mOr() throws RecognitionException {
        try {
            int _type = Or;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalYangLexer.g:268:4: ( 'or' )
            // InternalYangLexer.g:268:6: 'or'
            {
            match("or"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Or"

    // $ANTLR start "DollarSign"
    public final void mDollarSign() throws RecognitionException {
        try {
            int _type = DollarSign;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalYangLexer.g:270:12: ( '$' )
            // InternalYangLexer.g:270:14: '$'
            {
            match('$'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "DollarSign"

    // $ANTLR start "LeftParenthesis"
    public final void mLeftParenthesis() throws RecognitionException {
        try {
            int _type = LeftParenthesis;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalYangLexer.g:272:17: ( '(' )
            // InternalYangLexer.g:272:19: '('
            {
            match('('); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "LeftParenthesis"

    // $ANTLR start "RightParenthesis"
    public final void mRightParenthesis() throws RecognitionException {
        try {
            int _type = RightParenthesis;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalYangLexer.g:274:18: ( ')' )
            // InternalYangLexer.g:274:20: ')'
            {
            match(')'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RightParenthesis"

    // $ANTLR start "Asterisk"
    public final void mAsterisk() throws RecognitionException {
        try {
            int _type = Asterisk;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalYangLexer.g:276:10: ( '*' )
            // InternalYangLexer.g:276:12: '*'
            {
            match('*'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Asterisk"

    // $ANTLR start "PlusSign"
    public final void mPlusSign() throws RecognitionException {
        try {
            int _type = PlusSign;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalYangLexer.g:278:10: ( '+' )
            // InternalYangLexer.g:278:12: '+'
            {
            match('+'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "PlusSign"

    // $ANTLR start "Comma"
    public final void mComma() throws RecognitionException {
        try {
            int _type = Comma;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalYangLexer.g:280:7: ( ',' )
            // InternalYangLexer.g:280:9: ','
            {
            match(','); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Comma"

    // $ANTLR start "HyphenMinus"
    public final void mHyphenMinus() throws RecognitionException {
        try {
            int _type = HyphenMinus;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalYangLexer.g:282:13: ( '-' )
            // InternalYangLexer.g:282:15: '-'
            {
            match('-'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "HyphenMinus"

    // $ANTLR start "FullStop"
    public final void mFullStop() throws RecognitionException {
        try {
            int _type = FullStop;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalYangLexer.g:284:10: ( '.' )
            // InternalYangLexer.g:284:12: '.'
            {
            match('.'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "FullStop"

    // $ANTLR start "Solidus"
    public final void mSolidus() throws RecognitionException {
        try {
            int _type = Solidus;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalYangLexer.g:286:9: ( '/' )
            // InternalYangLexer.g:286:11: '/'
            {
            match('/'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Solidus"

    // $ANTLR start "Colon"
    public final void mColon() throws RecognitionException {
        try {
            int _type = Colon;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalYangLexer.g:288:7: ( ':' )
            // InternalYangLexer.g:288:9: ':'
            {
            match(':'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Colon"

    // $ANTLR start "Semicolon"
    public final void mSemicolon() throws RecognitionException {
        try {
            int _type = Semicolon;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalYangLexer.g:290:11: ( ';' )
            // InternalYangLexer.g:290:13: ';'
            {
            match(';'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Semicolon"

    // $ANTLR start "LessThanSign"
    public final void mLessThanSign() throws RecognitionException {
        try {
            int _type = LessThanSign;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalYangLexer.g:292:14: ( '<' )
            // InternalYangLexer.g:292:16: '<'
            {
            match('<'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "LessThanSign"

    // $ANTLR start "EqualsSign"
    public final void mEqualsSign() throws RecognitionException {
        try {
            int _type = EqualsSign;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalYangLexer.g:294:12: ( '=' )
            // InternalYangLexer.g:294:14: '='
            {
            match('='); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "EqualsSign"

    // $ANTLR start "GreaterThanSign"
    public final void mGreaterThanSign() throws RecognitionException {
        try {
            int _type = GreaterThanSign;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalYangLexer.g:296:17: ( '>' )
            // InternalYangLexer.g:296:19: '>'
            {
            match('>'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "GreaterThanSign"

    // $ANTLR start "CommercialAt"
    public final void mCommercialAt() throws RecognitionException {
        try {
            int _type = CommercialAt;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalYangLexer.g:298:14: ( '@' )
            // InternalYangLexer.g:298:16: '@'
            {
            match('@'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "CommercialAt"

    // $ANTLR start "LeftSquareBracket"
    public final void mLeftSquareBracket() throws RecognitionException {
        try {
            int _type = LeftSquareBracket;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalYangLexer.g:300:19: ( '[' )
            // InternalYangLexer.g:300:21: '['
            {
            match('['); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "LeftSquareBracket"

    // $ANTLR start "RightSquareBracket"
    public final void mRightSquareBracket() throws RecognitionException {
        try {
            int _type = RightSquareBracket;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalYangLexer.g:302:20: ( ']' )
            // InternalYangLexer.g:302:22: ']'
            {
            match(']'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RightSquareBracket"

    // $ANTLR start "LeftCurlyBracket"
    public final void mLeftCurlyBracket() throws RecognitionException {
        try {
            int _type = LeftCurlyBracket;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalYangLexer.g:304:18: ( '{' )
            // InternalYangLexer.g:304:20: '{'
            {
            match('{'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "LeftCurlyBracket"

    // $ANTLR start "VerticalLine"
    public final void mVerticalLine() throws RecognitionException {
        try {
            int _type = VerticalLine;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalYangLexer.g:306:14: ( '|' )
            // InternalYangLexer.g:306:16: '|'
            {
            match('|'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "VerticalLine"

    // $ANTLR start "RightCurlyBracket"
    public final void mRightCurlyBracket() throws RecognitionException {
        try {
            int _type = RightCurlyBracket;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalYangLexer.g:308:19: ( '}' )
            // InternalYangLexer.g:308:21: '}'
            {
            match('}'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RightCurlyBracket"

    // $ANTLR start "RULE_ID"
    public final void mRULE_ID() throws RecognitionException {
        try {
            int _type = RULE_ID;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalYangLexer.g:310:9: ( 'an id' )
            // InternalYangLexer.g:310:11: 'an id'
            {
            match("an id"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_ID"

    // $ANTLR start "RULE_EXTENSION_NAME"
    public final void mRULE_EXTENSION_NAME() throws RecognitionException {
        try {
            int _type = RULE_EXTENSION_NAME;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalYangLexer.g:312:21: ( 'ID:ID // only valid on statement ctx' )
            // InternalYangLexer.g:312:23: 'ID:ID // only valid on statement ctx'
            {
            match("ID:ID // only valid on statement ctx"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_EXTENSION_NAME"

    // $ANTLR start "RULE_STRING"
    public final void mRULE_STRING() throws RecognitionException {
        try {
            int _type = RULE_STRING;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalYangLexer.g:314:13: ( 'an unquoted string' )
            // InternalYangLexer.g:314:15: 'an unquoted string'
            {
            match("an unquoted string"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_STRING"

    // $ANTLR start "RULE_NUMBER"
    public final void mRULE_NUMBER() throws RecognitionException {
        try {
            int _type = RULE_NUMBER;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalYangLexer.g:316:13: ( 'positive integer value' )
            // InternalYangLexer.g:316:15: 'positive integer value'
            {
            match("positive integer value"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_NUMBER"

    // $ANTLR start "RULE_OPERATOR"
    public final void mRULE_OPERATOR() throws RecognitionException {
        try {
            int _type = RULE_OPERATOR;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalYangLexer.g:318:15: ( ( 'and' | 'or' | 'mod' | 'div' | '*' | '/' | '//' | '|' | '+' | '-' | '=' | '!=' | '<' | '<=' | '>' | '>=' ) )
            // InternalYangLexer.g:318:17: ( 'and' | 'or' | 'mod' | 'div' | '*' | '/' | '//' | '|' | '+' | '-' | '=' | '!=' | '<' | '<=' | '>' | '>=' )
            {
            // InternalYangLexer.g:318:17: ( 'and' | 'or' | 'mod' | 'div' | '*' | '/' | '//' | '|' | '+' | '-' | '=' | '!=' | '<' | '<=' | '>' | '>=' )
            int alt1=16;
            alt1 = dfa1.predict(input);
            switch (alt1) {
                case 1 :
                    // InternalYangLexer.g:318:18: 'and'
                    {
                    match("and"); 


                    }
                    break;
                case 2 :
                    // InternalYangLexer.g:318:24: 'or'
                    {
                    match("or"); 


                    }
                    break;
                case 3 :
                    // InternalYangLexer.g:318:29: 'mod'
                    {
                    match("mod"); 


                    }
                    break;
                case 4 :
                    // InternalYangLexer.g:318:35: 'div'
                    {
                    match("div"); 


                    }
                    break;
                case 5 :
                    // InternalYangLexer.g:318:41: '*'
                    {
                    match('*'); 

                    }
                    break;
                case 6 :
                    // InternalYangLexer.g:318:45: '/'
                    {
                    match('/'); 

                    }
                    break;
                case 7 :
                    // InternalYangLexer.g:318:49: '//'
                    {
                    match("//"); 


                    }
                    break;
                case 8 :
                    // InternalYangLexer.g:318:54: '|'
                    {
                    match('|'); 

                    }
                    break;
                case 9 :
                    // InternalYangLexer.g:318:58: '+'
                    {
                    match('+'); 

                    }
                    break;
                case 10 :
                    // InternalYangLexer.g:318:62: '-'
                    {
                    match('-'); 

                    }
                    break;
                case 11 :
                    // InternalYangLexer.g:318:66: '='
                    {
                    match('='); 

                    }
                    break;
                case 12 :
                    // InternalYangLexer.g:318:70: '!='
                    {
                    match("!="); 


                    }
                    break;
                case 13 :
                    // InternalYangLexer.g:318:75: '<'
                    {
                    match('<'); 

                    }
                    break;
                case 14 :
                    // InternalYangLexer.g:318:79: '<='
                    {
                    match("<="); 


                    }
                    break;
                case 15 :
                    // InternalYangLexer.g:318:84: '>'
                    {
                    match('>'); 

                    }
                    break;
                case 16 :
                    // InternalYangLexer.g:318:88: '>='
                    {
                    match(">="); 


                    }
                    break;

            }


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_OPERATOR"

    // $ANTLR start "RULE_ML_COMMENT"
    public final void mRULE_ML_COMMENT() throws RecognitionException {
        try {
            int _type = RULE_ML_COMMENT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalYangLexer.g:320:17: ( '/*' ( options {greedy=false; } : . )* '*/' )
            // InternalYangLexer.g:320:19: '/*' ( options {greedy=false; } : . )* '*/'
            {
            match("/*"); 

            // InternalYangLexer.g:320:24: ( options {greedy=false; } : . )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0=='*') ) {
                    int LA2_1 = input.LA(2);

                    if ( (LA2_1=='/') ) {
                        alt2=2;
                    }
                    else if ( ((LA2_1>='\u0000' && LA2_1<='.')||(LA2_1>='0' && LA2_1<='\uFFFF')) ) {
                        alt2=1;
                    }


                }
                else if ( ((LA2_0>='\u0000' && LA2_0<=')')||(LA2_0>='+' && LA2_0<='\uFFFF')) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // InternalYangLexer.g:320:52: .
            	    {
            	    matchAny(); 

            	    }
            	    break;

            	default :
            	    break loop2;
                }
            } while (true);

            match("*/"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_ML_COMMENT"

    // $ANTLR start "RULE_SL_COMMENT"
    public final void mRULE_SL_COMMENT() throws RecognitionException {
        try {
            int _type = RULE_SL_COMMENT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalYangLexer.g:322:17: ( '//' (~ ( ( '\\n' | '\\r' ) ) )* ( ( '\\r' )? '\\n' )? )
            // InternalYangLexer.g:322:19: '//' (~ ( ( '\\n' | '\\r' ) ) )* ( ( '\\r' )? '\\n' )?
            {
            match("//"); 

            // InternalYangLexer.g:322:24: (~ ( ( '\\n' | '\\r' ) ) )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( ((LA3_0>='\u0000' && LA3_0<='\t')||(LA3_0>='\u000B' && LA3_0<='\f')||(LA3_0>='\u000E' && LA3_0<='\uFFFF')) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // InternalYangLexer.g:322:24: ~ ( ( '\\n' | '\\r' ) )
            	    {
            	    if ( (input.LA(1)>='\u0000' && input.LA(1)<='\t')||(input.LA(1)>='\u000B' && input.LA(1)<='\f')||(input.LA(1)>='\u000E' && input.LA(1)<='\uFFFF') ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


            	    }
            	    break;

            	default :
            	    break loop3;
                }
            } while (true);

            // InternalYangLexer.g:322:40: ( ( '\\r' )? '\\n' )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0=='\n'||LA5_0=='\r') ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // InternalYangLexer.g:322:41: ( '\\r' )? '\\n'
                    {
                    // InternalYangLexer.g:322:41: ( '\\r' )?
                    int alt4=2;
                    int LA4_0 = input.LA(1);

                    if ( (LA4_0=='\r') ) {
                        alt4=1;
                    }
                    switch (alt4) {
                        case 1 :
                            // InternalYangLexer.g:322:41: '\\r'
                            {
                            match('\r'); 

                            }
                            break;

                    }

                    match('\n'); 

                    }
                    break;

            }


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_SL_COMMENT"

    // $ANTLR start "RULE_WS"
    public final void mRULE_WS() throws RecognitionException {
        try {
            int _type = RULE_WS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalYangLexer.g:324:9: ( ( ' ' | '\\t' | '\\r' | '\\n' )+ )
            // InternalYangLexer.g:324:11: ( ' ' | '\\t' | '\\r' | '\\n' )+
            {
            // InternalYangLexer.g:324:11: ( ' ' | '\\t' | '\\r' | '\\n' )+
            int cnt6=0;
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( ((LA6_0>='\t' && LA6_0<='\n')||LA6_0=='\r'||LA6_0==' ') ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // InternalYangLexer.g:
            	    {
            	    if ( (input.LA(1)>='\t' && input.LA(1)<='\n')||input.LA(1)=='\r'||input.LA(1)==' ' ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


            	    }
            	    break;

            	default :
            	    if ( cnt6 >= 1 ) break loop6;
                        EarlyExitException eee =
                            new EarlyExitException(6, input);
                        throw eee;
                }
                cnt6++;
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_WS"

    // $ANTLR start "RULE_HIDDEN"
    public final void mRULE_HIDDEN() throws RecognitionException {
        try {
            int _type = RULE_HIDDEN;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalYangLexer.g:326:13: ( 'other hidden tokens' )
            // InternalYangLexer.g:326:15: 'other hidden tokens'
            {
            match("other hidden tokens"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_HIDDEN"

    // $ANTLR start "RULE_ANY_OTHER"
    public final void mRULE_ANY_OTHER() throws RecognitionException {
        try {
            int _type = RULE_ANY_OTHER;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalYangLexer.g:328:16: ( . )
            // InternalYangLexer.g:328:18: .
            {
            matchAny(); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_ANY_OTHER"

    public void mTokens() throws RecognitionException {
        // InternalYangLexer.g:1:8: ( ProcessingInstruction | InstanceIdentifier | DescendantOrSelf | FollowingSibling | PrecedingSibling | AncestorOrSelf | RequireInstance | FractionDigits | ErrorAppTag | ErrorMessage | NotSupported | RevisionDate | MaxElements | MinElements | Notification | Organization | YangVersion | Description | Enumeration | Identityref | YinElement | BelongsTo | Deprecated | Descendant | IfFeature | OrderedBy | Attribute | Container | Decimal64 | Deviation | Extension | Following | LeafList | Mandatory | Namespace | Preceding | Reference | Submodule | Unbounded | Ancestor | Argument | Grouping | Identity | Modifier | Obsolete | Position | Presence | Revision | Anydata | Augment | Boolean | Comment | Contact | Current | Default | Deviate | Feature | Include | Leafref | Pattern | Replace | Typedef | Action | Anyxml | Binary | Choice | Config | Delete | Import | Length | Module | Output | Parent | Prefix | Refine | Status | String | KW_System | Uint16 | Uint32 | Uint64 | Unique | Child | Empty | False | Input | Int16 | Int32 | Int64 | Range | Uint8 | Union | Units | Value | LessThanSignLessThanSignLessThanSignLessThanSign | GreaterThanSignGreaterThanSignGreaterThanSignGreaterThanSign | Base | Bits | Case | Enum | Int8 | Leaf | List | Must | Node | Path | Self | Text | True | Type | User | Uses | When | Add | And | Bit | Div | Key | Max | Min | Mod | Not | Rpc | ExclamationMarkEqualsSign | FullStopFullStop | LessThanSignEqualsSign | GreaterThanSignEqualsSign | Or | DollarSign | LeftParenthesis | RightParenthesis | Asterisk | PlusSign | Comma | HyphenMinus | FullStop | Solidus | Colon | Semicolon | LessThanSign | EqualsSign | GreaterThanSign | CommercialAt | LeftSquareBracket | RightSquareBracket | LeftCurlyBracket | VerticalLine | RightCurlyBracket | RULE_ID | RULE_EXTENSION_NAME | RULE_STRING | RULE_NUMBER | RULE_OPERATOR | RULE_ML_COMMENT | RULE_SL_COMMENT | RULE_WS | RULE_HIDDEN | RULE_ANY_OTHER )
        int alt7=158;
        alt7 = dfa7.predict(input);
        switch (alt7) {
            case 1 :
                // InternalYangLexer.g:1:10: ProcessingInstruction
                {
                mProcessingInstruction(); 

                }
                break;
            case 2 :
                // InternalYangLexer.g:1:32: InstanceIdentifier
                {
                mInstanceIdentifier(); 

                }
                break;
            case 3 :
                // InternalYangLexer.g:1:51: DescendantOrSelf
                {
                mDescendantOrSelf(); 

                }
                break;
            case 4 :
                // InternalYangLexer.g:1:68: FollowingSibling
                {
                mFollowingSibling(); 

                }
                break;
            case 5 :
                // InternalYangLexer.g:1:85: PrecedingSibling
                {
                mPrecedingSibling(); 

                }
                break;
            case 6 :
                // InternalYangLexer.g:1:102: AncestorOrSelf
                {
                mAncestorOrSelf(); 

                }
                break;
            case 7 :
                // InternalYangLexer.g:1:117: RequireInstance
                {
                mRequireInstance(); 

                }
                break;
            case 8 :
                // InternalYangLexer.g:1:133: FractionDigits
                {
                mFractionDigits(); 

                }
                break;
            case 9 :
                // InternalYangLexer.g:1:148: ErrorAppTag
                {
                mErrorAppTag(); 

                }
                break;
            case 10 :
                // InternalYangLexer.g:1:160: ErrorMessage
                {
                mErrorMessage(); 

                }
                break;
            case 11 :
                // InternalYangLexer.g:1:173: NotSupported
                {
                mNotSupported(); 

                }
                break;
            case 12 :
                // InternalYangLexer.g:1:186: RevisionDate
                {
                mRevisionDate(); 

                }
                break;
            case 13 :
                // InternalYangLexer.g:1:199: MaxElements
                {
                mMaxElements(); 

                }
                break;
            case 14 :
                // InternalYangLexer.g:1:211: MinElements
                {
                mMinElements(); 

                }
                break;
            case 15 :
                // InternalYangLexer.g:1:223: Notification
                {
                mNotification(); 

                }
                break;
            case 16 :
                // InternalYangLexer.g:1:236: Organization
                {
                mOrganization(); 

                }
                break;
            case 17 :
                // InternalYangLexer.g:1:249: YangVersion
                {
                mYangVersion(); 

                }
                break;
            case 18 :
                // InternalYangLexer.g:1:261: Description
                {
                mDescription(); 

                }
                break;
            case 19 :
                // InternalYangLexer.g:1:273: Enumeration
                {
                mEnumeration(); 

                }
                break;
            case 20 :
                // InternalYangLexer.g:1:285: Identityref
                {
                mIdentityref(); 

                }
                break;
            case 21 :
                // InternalYangLexer.g:1:297: YinElement
                {
                mYinElement(); 

                }
                break;
            case 22 :
                // InternalYangLexer.g:1:308: BelongsTo
                {
                mBelongsTo(); 

                }
                break;
            case 23 :
                // InternalYangLexer.g:1:318: Deprecated
                {
                mDeprecated(); 

                }
                break;
            case 24 :
                // InternalYangLexer.g:1:329: Descendant
                {
                mDescendant(); 

                }
                break;
            case 25 :
                // InternalYangLexer.g:1:340: IfFeature
                {
                mIfFeature(); 

                }
                break;
            case 26 :
                // InternalYangLexer.g:1:350: OrderedBy
                {
                mOrderedBy(); 

                }
                break;
            case 27 :
                // InternalYangLexer.g:1:360: Attribute
                {
                mAttribute(); 

                }
                break;
            case 28 :
                // InternalYangLexer.g:1:370: Container
                {
                mContainer(); 

                }
                break;
            case 29 :
                // InternalYangLexer.g:1:380: Decimal64
                {
                mDecimal64(); 

                }
                break;
            case 30 :
                // InternalYangLexer.g:1:390: Deviation
                {
                mDeviation(); 

                }
                break;
            case 31 :
                // InternalYangLexer.g:1:400: Extension
                {
                mExtension(); 

                }
                break;
            case 32 :
                // InternalYangLexer.g:1:410: Following
                {
                mFollowing(); 

                }
                break;
            case 33 :
                // InternalYangLexer.g:1:420: LeafList
                {
                mLeafList(); 

                }
                break;
            case 34 :
                // InternalYangLexer.g:1:429: Mandatory
                {
                mMandatory(); 

                }
                break;
            case 35 :
                // InternalYangLexer.g:1:439: Namespace
                {
                mNamespace(); 

                }
                break;
            case 36 :
                // InternalYangLexer.g:1:449: Preceding
                {
                mPreceding(); 

                }
                break;
            case 37 :
                // InternalYangLexer.g:1:459: Reference
                {
                mReference(); 

                }
                break;
            case 38 :
                // InternalYangLexer.g:1:469: Submodule
                {
                mSubmodule(); 

                }
                break;
            case 39 :
                // InternalYangLexer.g:1:479: Unbounded
                {
                mUnbounded(); 

                }
                break;
            case 40 :
                // InternalYangLexer.g:1:489: Ancestor
                {
                mAncestor(); 

                }
                break;
            case 41 :
                // InternalYangLexer.g:1:498: Argument
                {
                mArgument(); 

                }
                break;
            case 42 :
                // InternalYangLexer.g:1:507: Grouping
                {
                mGrouping(); 

                }
                break;
            case 43 :
                // InternalYangLexer.g:1:516: Identity
                {
                mIdentity(); 

                }
                break;
            case 44 :
                // InternalYangLexer.g:1:525: Modifier
                {
                mModifier(); 

                }
                break;
            case 45 :
                // InternalYangLexer.g:1:534: Obsolete
                {
                mObsolete(); 

                }
                break;
            case 46 :
                // InternalYangLexer.g:1:543: Position
                {
                mPosition(); 

                }
                break;
            case 47 :
                // InternalYangLexer.g:1:552: Presence
                {
                mPresence(); 

                }
                break;
            case 48 :
                // InternalYangLexer.g:1:561: Revision
                {
                mRevision(); 

                }
                break;
            case 49 :
                // InternalYangLexer.g:1:570: Anydata
                {
                mAnydata(); 

                }
                break;
            case 50 :
                // InternalYangLexer.g:1:578: Augment
                {
                mAugment(); 

                }
                break;
            case 51 :
                // InternalYangLexer.g:1:586: Boolean
                {
                mBoolean(); 

                }
                break;
            case 52 :
                // InternalYangLexer.g:1:594: Comment
                {
                mComment(); 

                }
                break;
            case 53 :
                // InternalYangLexer.g:1:602: Contact
                {
                mContact(); 

                }
                break;
            case 54 :
                // InternalYangLexer.g:1:610: Current
                {
                mCurrent(); 

                }
                break;
            case 55 :
                // InternalYangLexer.g:1:618: Default
                {
                mDefault(); 

                }
                break;
            case 56 :
                // InternalYangLexer.g:1:626: Deviate
                {
                mDeviate(); 

                }
                break;
            case 57 :
                // InternalYangLexer.g:1:634: Feature
                {
                mFeature(); 

                }
                break;
            case 58 :
                // InternalYangLexer.g:1:642: Include
                {
                mInclude(); 

                }
                break;
            case 59 :
                // InternalYangLexer.g:1:650: Leafref
                {
                mLeafref(); 

                }
                break;
            case 60 :
                // InternalYangLexer.g:1:658: Pattern
                {
                mPattern(); 

                }
                break;
            case 61 :
                // InternalYangLexer.g:1:666: Replace
                {
                mReplace(); 

                }
                break;
            case 62 :
                // InternalYangLexer.g:1:674: Typedef
                {
                mTypedef(); 

                }
                break;
            case 63 :
                // InternalYangLexer.g:1:682: Action
                {
                mAction(); 

                }
                break;
            case 64 :
                // InternalYangLexer.g:1:689: Anyxml
                {
                mAnyxml(); 

                }
                break;
            case 65 :
                // InternalYangLexer.g:1:696: Binary
                {
                mBinary(); 

                }
                break;
            case 66 :
                // InternalYangLexer.g:1:703: Choice
                {
                mChoice(); 

                }
                break;
            case 67 :
                // InternalYangLexer.g:1:710: Config
                {
                mConfig(); 

                }
                break;
            case 68 :
                // InternalYangLexer.g:1:717: Delete
                {
                mDelete(); 

                }
                break;
            case 69 :
                // InternalYangLexer.g:1:724: Import
                {
                mImport(); 

                }
                break;
            case 70 :
                // InternalYangLexer.g:1:731: Length
                {
                mLength(); 

                }
                break;
            case 71 :
                // InternalYangLexer.g:1:738: Module
                {
                mModule(); 

                }
                break;
            case 72 :
                // InternalYangLexer.g:1:745: Output
                {
                mOutput(); 

                }
                break;
            case 73 :
                // InternalYangLexer.g:1:752: Parent
                {
                mParent(); 

                }
                break;
            case 74 :
                // InternalYangLexer.g:1:759: Prefix
                {
                mPrefix(); 

                }
                break;
            case 75 :
                // InternalYangLexer.g:1:766: Refine
                {
                mRefine(); 

                }
                break;
            case 76 :
                // InternalYangLexer.g:1:773: Status
                {
                mStatus(); 

                }
                break;
            case 77 :
                // InternalYangLexer.g:1:780: String
                {
                mString(); 

                }
                break;
            case 78 :
                // InternalYangLexer.g:1:787: KW_System
                {
                mKW_System(); 

                }
                break;
            case 79 :
                // InternalYangLexer.g:1:797: Uint16
                {
                mUint16(); 

                }
                break;
            case 80 :
                // InternalYangLexer.g:1:804: Uint32
                {
                mUint32(); 

                }
                break;
            case 81 :
                // InternalYangLexer.g:1:811: Uint64
                {
                mUint64(); 

                }
                break;
            case 82 :
                // InternalYangLexer.g:1:818: Unique
                {
                mUnique(); 

                }
                break;
            case 83 :
                // InternalYangLexer.g:1:825: Child
                {
                mChild(); 

                }
                break;
            case 84 :
                // InternalYangLexer.g:1:831: Empty
                {
                mEmpty(); 

                }
                break;
            case 85 :
                // InternalYangLexer.g:1:837: False
                {
                mFalse(); 

                }
                break;
            case 86 :
                // InternalYangLexer.g:1:843: Input
                {
                mInput(); 

                }
                break;
            case 87 :
                // InternalYangLexer.g:1:849: Int16
                {
                mInt16(); 

                }
                break;
            case 88 :
                // InternalYangLexer.g:1:855: Int32
                {
                mInt32(); 

                }
                break;
            case 89 :
                // InternalYangLexer.g:1:861: Int64
                {
                mInt64(); 

                }
                break;
            case 90 :
                // InternalYangLexer.g:1:867: Range
                {
                mRange(); 

                }
                break;
            case 91 :
                // InternalYangLexer.g:1:873: Uint8
                {
                mUint8(); 

                }
                break;
            case 92 :
                // InternalYangLexer.g:1:879: Union
                {
                mUnion(); 

                }
                break;
            case 93 :
                // InternalYangLexer.g:1:885: Units
                {
                mUnits(); 

                }
                break;
            case 94 :
                // InternalYangLexer.g:1:891: Value
                {
                mValue(); 

                }
                break;
            case 95 :
                // InternalYangLexer.g:1:897: LessThanSignLessThanSignLessThanSignLessThanSign
                {
                mLessThanSignLessThanSignLessThanSignLessThanSign(); 

                }
                break;
            case 96 :
                // InternalYangLexer.g:1:946: GreaterThanSignGreaterThanSignGreaterThanSignGreaterThanSign
                {
                mGreaterThanSignGreaterThanSignGreaterThanSignGreaterThanSign(); 

                }
                break;
            case 97 :
                // InternalYangLexer.g:1:1007: Base
                {
                mBase(); 

                }
                break;
            case 98 :
                // InternalYangLexer.g:1:1012: Bits
                {
                mBits(); 

                }
                break;
            case 99 :
                // InternalYangLexer.g:1:1017: Case
                {
                mCase(); 

                }
                break;
            case 100 :
                // InternalYangLexer.g:1:1022: Enum
                {
                mEnum(); 

                }
                break;
            case 101 :
                // InternalYangLexer.g:1:1027: Int8
                {
                mInt8(); 

                }
                break;
            case 102 :
                // InternalYangLexer.g:1:1032: Leaf
                {
                mLeaf(); 

                }
                break;
            case 103 :
                // InternalYangLexer.g:1:1037: List
                {
                mList(); 

                }
                break;
            case 104 :
                // InternalYangLexer.g:1:1042: Must
                {
                mMust(); 

                }
                break;
            case 105 :
                // InternalYangLexer.g:1:1047: Node
                {
                mNode(); 

                }
                break;
            case 106 :
                // InternalYangLexer.g:1:1052: Path
                {
                mPath(); 

                }
                break;
            case 107 :
                // InternalYangLexer.g:1:1057: Self
                {
                mSelf(); 

                }
                break;
            case 108 :
                // InternalYangLexer.g:1:1062: Text
                {
                mText(); 

                }
                break;
            case 109 :
                // InternalYangLexer.g:1:1067: True
                {
                mTrue(); 

                }
                break;
            case 110 :
                // InternalYangLexer.g:1:1072: Type
                {
                mType(); 

                }
                break;
            case 111 :
                // InternalYangLexer.g:1:1077: User
                {
                mUser(); 

                }
                break;
            case 112 :
                // InternalYangLexer.g:1:1082: Uses
                {
                mUses(); 

                }
                break;
            case 113 :
                // InternalYangLexer.g:1:1087: When
                {
                mWhen(); 

                }
                break;
            case 114 :
                // InternalYangLexer.g:1:1092: Add
                {
                mAdd(); 

                }
                break;
            case 115 :
                // InternalYangLexer.g:1:1096: And
                {
                mAnd(); 

                }
                break;
            case 116 :
                // InternalYangLexer.g:1:1100: Bit
                {
                mBit(); 

                }
                break;
            case 117 :
                // InternalYangLexer.g:1:1104: Div
                {
                mDiv(); 

                }
                break;
            case 118 :
                // InternalYangLexer.g:1:1108: Key
                {
                mKey(); 

                }
                break;
            case 119 :
                // InternalYangLexer.g:1:1112: Max
                {
                mMax(); 

                }
                break;
            case 120 :
                // InternalYangLexer.g:1:1116: Min
                {
                mMin(); 

                }
                break;
            case 121 :
                // InternalYangLexer.g:1:1120: Mod
                {
                mMod(); 

                }
                break;
            case 122 :
                // InternalYangLexer.g:1:1124: Not
                {
                mNot(); 

                }
                break;
            case 123 :
                // InternalYangLexer.g:1:1128: Rpc
                {
                mRpc(); 

                }
                break;
            case 124 :
                // InternalYangLexer.g:1:1132: ExclamationMarkEqualsSign
                {
                mExclamationMarkEqualsSign(); 

                }
                break;
            case 125 :
                // InternalYangLexer.g:1:1158: FullStopFullStop
                {
                mFullStopFullStop(); 

                }
                break;
            case 126 :
                // InternalYangLexer.g:1:1175: LessThanSignEqualsSign
                {
                mLessThanSignEqualsSign(); 

                }
                break;
            case 127 :
                // InternalYangLexer.g:1:1198: GreaterThanSignEqualsSign
                {
                mGreaterThanSignEqualsSign(); 

                }
                break;
            case 128 :
                // InternalYangLexer.g:1:1224: Or
                {
                mOr(); 

                }
                break;
            case 129 :
                // InternalYangLexer.g:1:1227: DollarSign
                {
                mDollarSign(); 

                }
                break;
            case 130 :
                // InternalYangLexer.g:1:1238: LeftParenthesis
                {
                mLeftParenthesis(); 

                }
                break;
            case 131 :
                // InternalYangLexer.g:1:1254: RightParenthesis
                {
                mRightParenthesis(); 

                }
                break;
            case 132 :
                // InternalYangLexer.g:1:1271: Asterisk
                {
                mAsterisk(); 

                }
                break;
            case 133 :
                // InternalYangLexer.g:1:1280: PlusSign
                {
                mPlusSign(); 

                }
                break;
            case 134 :
                // InternalYangLexer.g:1:1289: Comma
                {
                mComma(); 

                }
                break;
            case 135 :
                // InternalYangLexer.g:1:1295: HyphenMinus
                {
                mHyphenMinus(); 

                }
                break;
            case 136 :
                // InternalYangLexer.g:1:1307: FullStop
                {
                mFullStop(); 

                }
                break;
            case 137 :
                // InternalYangLexer.g:1:1316: Solidus
                {
                mSolidus(); 

                }
                break;
            case 138 :
                // InternalYangLexer.g:1:1324: Colon
                {
                mColon(); 

                }
                break;
            case 139 :
                // InternalYangLexer.g:1:1330: Semicolon
                {
                mSemicolon(); 

                }
                break;
            case 140 :
                // InternalYangLexer.g:1:1340: LessThanSign
                {
                mLessThanSign(); 

                }
                break;
            case 141 :
                // InternalYangLexer.g:1:1353: EqualsSign
                {
                mEqualsSign(); 

                }
                break;
            case 142 :
                // InternalYangLexer.g:1:1364: GreaterThanSign
                {
                mGreaterThanSign(); 

                }
                break;
            case 143 :
                // InternalYangLexer.g:1:1380: CommercialAt
                {
                mCommercialAt(); 

                }
                break;
            case 144 :
                // InternalYangLexer.g:1:1393: LeftSquareBracket
                {
                mLeftSquareBracket(); 

                }
                break;
            case 145 :
                // InternalYangLexer.g:1:1411: RightSquareBracket
                {
                mRightSquareBracket(); 

                }
                break;
            case 146 :
                // InternalYangLexer.g:1:1430: LeftCurlyBracket
                {
                mLeftCurlyBracket(); 

                }
                break;
            case 147 :
                // InternalYangLexer.g:1:1447: VerticalLine
                {
                mVerticalLine(); 

                }
                break;
            case 148 :
                // InternalYangLexer.g:1:1460: RightCurlyBracket
                {
                mRightCurlyBracket(); 

                }
                break;
            case 149 :
                // InternalYangLexer.g:1:1478: RULE_ID
                {
                mRULE_ID(); 

                }
                break;
            case 150 :
                // InternalYangLexer.g:1:1486: RULE_EXTENSION_NAME
                {
                mRULE_EXTENSION_NAME(); 

                }
                break;
            case 151 :
                // InternalYangLexer.g:1:1506: RULE_STRING
                {
                mRULE_STRING(); 

                }
                break;
            case 152 :
                // InternalYangLexer.g:1:1518: RULE_NUMBER
                {
                mRULE_NUMBER(); 

                }
                break;
            case 153 :
                // InternalYangLexer.g:1:1530: RULE_OPERATOR
                {
                mRULE_OPERATOR(); 

                }
                break;
            case 154 :
                // InternalYangLexer.g:1:1544: RULE_ML_COMMENT
                {
                mRULE_ML_COMMENT(); 

                }
                break;
            case 155 :
                // InternalYangLexer.g:1:1560: RULE_SL_COMMENT
                {
                mRULE_SL_COMMENT(); 

                }
                break;
            case 156 :
                // InternalYangLexer.g:1:1576: RULE_WS
                {
                mRULE_WS(); 

                }
                break;
            case 157 :
                // InternalYangLexer.g:1:1584: RULE_HIDDEN
                {
                mRULE_HIDDEN(); 

                }
                break;
            case 158 :
                // InternalYangLexer.g:1:1596: RULE_ANY_OTHER
                {
                mRULE_ANY_OTHER(); 

                }
                break;

        }

    }


    protected DFA1 dfa1 = new DFA1(this);
    protected DFA7 dfa7 = new DFA7(this);
    static final String DFA1_eotS =
        "\6\uffff\1\17\5\uffff\1\21\1\23\6\uffff";
    static final String DFA1_eofS =
        "\24\uffff";
    static final String DFA1_minS =
        "\1\41\5\uffff\1\57\5\uffff\2\75\6\uffff";
    static final String DFA1_maxS =
        "\1\174\5\uffff\1\57\5\uffff\2\75\6\uffff";
    static final String DFA1_acceptS =
        "\1\uffff\1\1\1\2\1\3\1\4\1\5\1\uffff\1\10\1\11\1\12\1\13\1\14\2\uffff\1\7\1\6\1\16\1\15\1\20\1\17";
    static final String DFA1_specialS =
        "\24\uffff}>";
    static final String[] DFA1_transitionS = {
            "\1\13\10\uffff\1\5\1\10\1\uffff\1\11\1\uffff\1\6\14\uffff\1\14\1\12\1\15\42\uffff\1\1\2\uffff\1\4\10\uffff\1\3\1\uffff\1\2\14\uffff\1\7",
            "",
            "",
            "",
            "",
            "",
            "\1\16",
            "",
            "",
            "",
            "",
            "",
            "\1\20",
            "\1\22",
            "",
            "",
            "",
            "",
            "",
            ""
    };

    static final short[] DFA1_eot = DFA.unpackEncodedString(DFA1_eotS);
    static final short[] DFA1_eof = DFA.unpackEncodedString(DFA1_eofS);
    static final char[] DFA1_min = DFA.unpackEncodedStringToUnsignedChars(DFA1_minS);
    static final char[] DFA1_max = DFA.unpackEncodedStringToUnsignedChars(DFA1_maxS);
    static final short[] DFA1_accept = DFA.unpackEncodedString(DFA1_acceptS);
    static final short[] DFA1_special = DFA.unpackEncodedString(DFA1_specialS);
    static final short[][] DFA1_transition;

    static {
        int numStates = DFA1_transitionS.length;
        DFA1_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA1_transition[i] = DFA.unpackEncodedString(DFA1_transitionS[i]);
        }
    }

    class DFA1 extends DFA {

        public DFA1(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 1;
            this.eot = DFA1_eot;
            this.eof = DFA1_eof;
            this.min = DFA1_min;
            this.max = DFA1_max;
            this.accept = DFA1_accept;
            this.special = DFA1_special;
            this.transition = DFA1_transition;
        }
        public String getDescription() {
            return "318:17: ( 'and' | 'or' | 'mod' | 'div' | '*' | '/' | '//' | '|' | '+' | '-' | '=' | '!=' | '<' | '<=' | '>' | '>=' )";
        }
    }
    static final String DFA7_eotS =
        "\1\uffff\23\55\1\154\1\157\3\55\1\164\7\uffff\1\176\11\uffff\1\55\42\uffff\1\u00ae\55\uffff\1\u00c2\51\uffff\1\u00df\1\uffff\1\u00e1\1\uffff\1\u00e3\1\u00e6\4\uffff\1\u00e8\53\uffff\1\u00fe\16\uffff\1\u0102\6\uffff\1\u0108\56\uffff\1\u0128\2\uffff\1\u012c\1\u012e\1\u0130\3\uffff\1\u0133\6\uffff\1\u0135\4\uffff";
    static final String DFA7_eofS =
        "\u0136\uffff";
    static final String DFA7_minS =
        "\1\0\1\141\1\144\1\145\1\141\1\143\1\141\1\155\2\141\1\142\3\141\2\145\1\151\1\162\1\145\1\141\1\74\1\75\1\150\1\145\1\75\1\56\7\uffff\1\52\11\uffff\1\104\2\uffff\1\145\1\163\1\162\1\143\1\145\2\uffff\1\143\1\166\1\154\3\uffff\1\40\5\uffff\1\146\2\uffff\1\162\1\165\2\uffff\1\144\1\uffff\2\156\1\144\1\uffff\1\144\7\uffff\1\156\1\uffff\1\155\1\uffff\1\151\1\uffff\1\141\2\uffff\1\141\2\uffff\1\142\1\156\1\145\1\uffff\1\160\25\uffff\1\0\16\uffff\1\143\1\151\1\150\4\uffff\1\61\1\156\1\143\2\uffff\1\151\3\uffff\1\154\1\145\1\144\1\uffff\1\151\1\uffff\1\151\1\145\1\uffff\1\157\1\155\1\55\1\uffff\1\55\1\uffff\1\55\1\151\4\uffff\1\163\1\146\3\uffff\1\146\4\uffff\1\157\1\164\1\162\1\145\5\uffff\1\145\2\uffff\1\164\6\uffff\1\164\1\145\1\141\1\uffff\1\157\1\163\5\uffff\1\163\2\uffff\1\162\1\145\14\uffff\1\141\1\uffff\1\55\3\uffff\1\61\2\uffff\2\144\2\151\1\156\1\uffff\1\164\1\167\1\164\1\151\1\55\2\uffff\1\143\11\uffff\1\151\1\157\1\164\1\144\1\145\1\151\2\157\1\141\2\uffff\1\156\2\uffff\1\171\1\141\2\uffff\1\156\1\162\1\156\2\uffff\1\147\1\162\1\156\1\147\3\55\2\uffff\1\164\1\55\6\uffff\1\55\4\uffff";
    static final String DFA7_maxS =
        "\1\uffff\1\162\1\156\1\151\1\162\1\165\1\160\1\170\1\157\2\165\1\151\1\157\1\165\1\151\1\171\1\163\1\162\1\171\1\141\1\75\1\76\1\150\1\145\1\75\1\56\7\uffff\1\57\11\uffff\1\104\2\uffff\1\157\1\163\2\164\1\145\2\uffff\2\166\1\154\3\uffff\1\171\5\uffff\1\166\2\uffff\1\162\1\165\2\uffff\1\164\1\uffff\1\170\1\156\1\144\1\uffff\1\147\7\uffff\1\164\1\uffff\1\156\1\uffff\1\157\1\uffff\1\156\2\uffff\1\162\2\uffff\1\151\1\156\1\145\1\uffff\1\160\25\uffff\1\uffff\16\uffff\1\163\1\151\1\164\4\uffff\1\70\1\156\1\143\2\uffff\1\151\3\uffff\1\154\1\145\1\170\1\uffff\1\165\1\uffff\2\151\1\uffff\1\157\1\155\1\151\1\uffff\1\55\1\uffff\1\55\1\165\4\uffff\1\163\1\164\3\uffff\1\146\4\uffff\2\164\1\163\1\145\5\uffff\1\145\2\uffff\1\164\6\uffff\1\164\1\162\1\141\1\uffff\1\157\1\163\5\uffff\1\163\2\uffff\1\162\1\145\14\uffff\1\141\1\uffff\1\162\3\uffff\1\70\2\uffff\2\144\2\151\1\156\1\uffff\1\164\1\167\1\164\1\151\1\55\2\uffff\1\151\11\uffff\1\151\1\166\1\164\1\144\2\151\2\157\1\155\2\uffff\1\156\2\uffff\1\171\1\141\2\uffff\1\156\1\162\1\156\2\uffff\1\147\1\162\1\156\1\147\3\55\2\uffff\1\164\1\55\6\uffff\1\55\4\uffff";
    static final String DFA7_acceptS =
        "\32\uffff\1\u0081\1\u0082\1\u0083\1\u0084\1\u0085\1\u0086\1\u0087\1\uffff\1\u008a\1\u008b\1\u008d\1\u008f\1\u0090\1\u0091\1\u0092\1\u0093\1\u0094\1\uffff\1\u009c\1\u009e\5\uffff\1\31\1\105\3\uffff\1\10\1\71\1\125\1\uffff\1\33\1\51\1\62\1\77\1\162\1\uffff\1\132\1\173\2\uffff\1\37\1\124\1\uffff\1\43\3\uffff\1\150\1\uffff\1\55\1\110\1\u009d\1\21\1\25\1\26\1\63\1\uffff\1\141\1\uffff\1\66\1\uffff\1\143\1\uffff\1\147\1\46\1\uffff\1\116\1\153\3\uffff\1\52\1\uffff\1\154\1\155\1\136\1\137\1\176\1\u008c\1\140\1\177\1\u008e\1\161\1\166\1\174\1\175\1\u0088\1\u0081\1\u0082\1\u0083\1\u0084\1\u0085\1\u0086\1\u0087\1\uffff\1\u009a\1\u0089\1\u008a\1\u008b\1\u008d\1\u008f\1\u0090\1\u0091\1\u0092\1\u0093\1\u0094\1\u0096\1\u009c\1\1\3\uffff\1\111\1\2\1\72\1\126\3\uffff\1\27\1\35\1\uffff\1\67\1\104\1\165\3\uffff\1\163\1\uffff\1\7\2\uffff\1\75\3\uffff\1\151\1\uffff\1\42\2\uffff\1\20\1\32\1\u0080\1\101\2\uffff\1\64\1\102\1\123\1\uffff\1\106\1\114\1\115\1\47\4\uffff\1\176\1\177\1\174\1\u009b\1\u0099\1\uffff\1\57\1\112\1\uffff\1\74\1\152\1\127\1\130\1\131\1\145\3\uffff\1\165\2\uffff\1\61\1\100\1\163\1\u0095\1\u0097\1\uffff\1\45\1\113\2\uffff\1\13\1\17\1\172\1\15\1\167\1\16\1\170\1\54\1\107\1\171\1\142\1\164\1\uffff\1\103\1\uffff\1\122\1\134\1\135\1\uffff\1\157\1\160\5\uffff\1\22\5\uffff\1\23\1\144\1\uffff\1\41\1\73\1\146\1\117\1\120\1\121\1\133\1\76\1\156\11\uffff\1\34\1\65\1\uffff\1\56\1\u0098\2\uffff\1\36\1\70\3\uffff\1\11\1\12\7\uffff\1\24\1\53\2\uffff\1\6\1\50\1\14\1\60\1\5\1\44\1\uffff\1\4\1\40\1\3\1\30";
    static final String DFA7_specialS =
        "\1\1\173\uffff\1\0\u00b9\uffff}>";
    static final String[] DFA7_transitionS = {
            "\11\55\2\54\2\55\1\54\22\55\1\54\1\30\2\55\1\32\3\55\1\33\1\34\1\35\1\36\1\37\1\40\1\31\1\41\12\55\1\42\1\43\1\24\1\44\1\25\1\55\1\45\10\55\1\53\21\55\1\46\1\55\1\47\3\55\1\5\1\14\1\15\1\3\1\7\1\4\1\21\1\55\1\2\1\55\1\27\1\16\1\11\1\10\1\12\1\1\1\55\1\6\1\17\1\22\1\20\1\23\1\26\1\55\1\13\1\55\1\50\1\51\1\52\uff82\55",
            "\1\60\15\uffff\1\57\2\uffff\1\56",
            "\1\62\1\uffff\1\63\6\uffff\1\64\1\61",
            "\1\65\3\uffff\1\66",
            "\1\72\3\uffff\1\71\11\uffff\1\67\2\uffff\1\70",
            "\1\77\1\100\11\uffff\1\73\3\uffff\1\75\1\uffff\1\74\1\76",
            "\1\102\3\uffff\1\101\12\uffff\1\103",
            "\1\107\1\105\3\uffff\1\104\5\uffff\1\106",
            "\1\111\15\uffff\1\110",
            "\1\112\7\uffff\1\113\5\uffff\1\114\5\uffff\1\115",
            "\1\117\17\uffff\1\116\1\uffff\1\121\1\120",
            "\1\122\7\uffff\1\123",
            "\1\127\3\uffff\1\124\3\uffff\1\126\5\uffff\1\125",
            "\1\133\6\uffff\1\132\6\uffff\1\130\5\uffff\1\131",
            "\1\134\3\uffff\1\135",
            "\1\141\16\uffff\1\137\1\136\3\uffff\1\140",
            "\1\143\4\uffff\1\142\4\uffff\1\144",
            "\1\145",
            "\1\147\14\uffff\1\150\6\uffff\1\146",
            "\1\151",
            "\1\152\1\153",
            "\1\156\1\155",
            "\1\160",
            "\1\161",
            "\1\162",
            "\1\163",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\175\4\uffff\1\174",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\u0088",
            "",
            "",
            "\1\u008b\11\uffff\1\u008a",
            "\1\u008c",
            "\1\u008e\1\uffff\1\u008d",
            "\1\u0090\14\uffff\1\u0091\2\uffff\1\u008f\1\u0092",
            "\1\u0093",
            "",
            "",
            "\1\u0096\2\uffff\1\u0098\5\uffff\1\u0099\3\uffff\1\u0095\2\uffff\1\u0094\2\uffff\1\u0097",
            "\1\u009a",
            "\1\u009b",
            "",
            "",
            "",
            "\1\u009f\102\uffff\1\u009c\1\u009e\24\uffff\1\u009d",
            "",
            "",
            "",
            "",
            "",
            "\1\u00a2\11\uffff\1\u00a3\1\u00a0\4\uffff\1\u00a1",
            "",
            "",
            "\1\u00a4",
            "\1\u00a5",
            "",
            "",
            "\1\u00a7\17\uffff\1\u00a6",
            "",
            "\1\u00a9\11\uffff\1\u00a8",
            "\1\u00aa",
            "\1\u00ab",
            "",
            "\1\u00ad\2\uffff\1\u00ac",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\u00af\5\uffff\1\u00b0",
            "",
            "\1\u00b2\1\u00b1",
            "",
            "\1\u00b4\5\uffff\1\u00b3",
            "",
            "\1\u00b5\14\uffff\1\u00b6",
            "",
            "",
            "\1\u00b7\20\uffff\1\u00b8",
            "",
            "",
            "\1\u00b9\6\uffff\1\u00ba",
            "\1\u00bb",
            "\1\u00bc",
            "",
            "\1\u00bd",
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
            "",
            "",
            "",
            "",
            "\0\u00c1",
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
            "\1\u00c3\2\uffff\1\u00c5\14\uffff\1\u00c4",
            "\1\u00c6",
            "\1\u00c8\13\uffff\1\u00c7",
            "",
            "",
            "",
            "",
            "\1\u00c9\1\uffff\1\u00ca\2\uffff\1\u00cb\1\uffff\1\u00cc",
            "\1\u00cd",
            "\1\u00ce",
            "",
            "",
            "\1\u00cf",
            "",
            "",
            "",
            "\1\u00d1",
            "\1\u00d2",
            "\1\u00d3\23\uffff\1\u00d4",
            "",
            "\1\u00d6\13\uffff\1\u00d7",
            "",
            "\1\u00d8",
            "\1\u00d9\3\uffff\1\u00da",
            "",
            "\1\u00db",
            "\1\u00dc",
            "\1\u00dd\73\uffff\1\u00de",
            "",
            "\1\u00e0",
            "",
            "\1\u00e2",
            "\1\u00e4\13\uffff\1\u00e5",
            "",
            "",
            "",
            "",
            "\1\u00e7",
            "\1\u00ea\15\uffff\1\u00e9",
            "",
            "",
            "",
            "\1\u00eb",
            "",
            "",
            "",
            "",
            "\1\u00ed\1\uffff\1\u00ec\2\uffff\1\u00ee",
            "\1\u00ef",
            "\1\u00f0\1\u00f1",
            "\1\u00f2",
            "",
            "",
            "",
            "",
            "",
            "\1\u00f3",
            "",
            "",
            "\1\u00f4",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\u00f5",
            "\1\u00f6\14\uffff\1\u00f7",
            "\1\u00f8",
            "",
            "\1\u00f9",
            "\1\u00fa",
            "",
            "",
            "",
            "",
            "",
            "\1\u00fb",
            "",
            "",
            "\1\u00fc",
            "\1\u00fd",
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
            "\1\u00ff",
            "",
            "\1\u0100\104\uffff\1\u0101",
            "",
            "",
            "",
            "\1\u0103\1\uffff\1\u0104\2\uffff\1\u0105\1\uffff\1\u0106",
            "",
            "",
            "\1\u0107",
            "\1\u0109",
            "\1\u010a",
            "\1\u010b",
            "\1\u010c",
            "",
            "\1\u010d",
            "\1\u010e",
            "\1\u010f",
            "\1\u0110",
            "\1\u0111",
            "",
            "",
            "\1\u0113\5\uffff\1\u0112",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\u0114",
            "\1\u0115\6\uffff\1\u0116",
            "\1\u0117",
            "\1\u0118",
            "\1\u011a\3\uffff\1\u0119",
            "\1\u011b",
            "\1\u011c",
            "\1\u011d",
            "\1\u011e\13\uffff\1\u011f",
            "",
            "",
            "\1\u0120",
            "",
            "",
            "\1\u0121",
            "\1\u0122",
            "",
            "",
            "\1\u0123",
            "\1\u0124",
            "\1\u0125",
            "",
            "",
            "\1\u0126",
            "\1\u0127",
            "\1\u0129",
            "\1\u012a",
            "\1\u012b",
            "\1\u012d",
            "\1\u012f",
            "",
            "",
            "\1\u0131",
            "\1\u0132",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\u0134",
            "",
            "",
            "",
            ""
    };

    static final short[] DFA7_eot = DFA.unpackEncodedString(DFA7_eotS);
    static final short[] DFA7_eof = DFA.unpackEncodedString(DFA7_eofS);
    static final char[] DFA7_min = DFA.unpackEncodedStringToUnsignedChars(DFA7_minS);
    static final char[] DFA7_max = DFA.unpackEncodedStringToUnsignedChars(DFA7_maxS);
    static final short[] DFA7_accept = DFA.unpackEncodedString(DFA7_acceptS);
    static final short[] DFA7_special = DFA.unpackEncodedString(DFA7_specialS);
    static final short[][] DFA7_transition;

    static {
        int numStates = DFA7_transitionS.length;
        DFA7_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA7_transition[i] = DFA.unpackEncodedString(DFA7_transitionS[i]);
        }
    }

    class DFA7 extends DFA {

        public DFA7(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 7;
            this.eot = DFA7_eot;
            this.eof = DFA7_eof;
            this.min = DFA7_min;
            this.max = DFA7_max;
            this.accept = DFA7_accept;
            this.special = DFA7_special;
            this.transition = DFA7_transition;
        }
        public String getDescription() {
            return "1:1: Tokens : ( ProcessingInstruction | InstanceIdentifier | DescendantOrSelf | FollowingSibling | PrecedingSibling | AncestorOrSelf | RequireInstance | FractionDigits | ErrorAppTag | ErrorMessage | NotSupported | RevisionDate | MaxElements | MinElements | Notification | Organization | YangVersion | Description | Enumeration | Identityref | YinElement | BelongsTo | Deprecated | Descendant | IfFeature | OrderedBy | Attribute | Container | Decimal64 | Deviation | Extension | Following | LeafList | Mandatory | Namespace | Preceding | Reference | Submodule | Unbounded | Ancestor | Argument | Grouping | Identity | Modifier | Obsolete | Position | Presence | Revision | Anydata | Augment | Boolean | Comment | Contact | Current | Default | Deviate | Feature | Include | Leafref | Pattern | Replace | Typedef | Action | Anyxml | Binary | Choice | Config | Delete | Import | Length | Module | Output | Parent | Prefix | Refine | Status | String | KW_System | Uint16 | Uint32 | Uint64 | Unique | Child | Empty | False | Input | Int16 | Int32 | Int64 | Range | Uint8 | Union | Units | Value | LessThanSignLessThanSignLessThanSignLessThanSign | GreaterThanSignGreaterThanSignGreaterThanSignGreaterThanSign | Base | Bits | Case | Enum | Int8 | Leaf | List | Must | Node | Path | Self | Text | True | Type | User | Uses | When | Add | And | Bit | Div | Key | Max | Min | Mod | Not | Rpc | ExclamationMarkEqualsSign | FullStopFullStop | LessThanSignEqualsSign | GreaterThanSignEqualsSign | Or | DollarSign | LeftParenthesis | RightParenthesis | Asterisk | PlusSign | Comma | HyphenMinus | FullStop | Solidus | Colon | Semicolon | LessThanSign | EqualsSign | GreaterThanSign | CommercialAt | LeftSquareBracket | RightSquareBracket | LeftCurlyBracket | VerticalLine | RightCurlyBracket | RULE_ID | RULE_EXTENSION_NAME | RULE_STRING | RULE_NUMBER | RULE_OPERATOR | RULE_ML_COMMENT | RULE_SL_COMMENT | RULE_WS | RULE_HIDDEN | RULE_ANY_OTHER );";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            IntStream input = _input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA7_124 = input.LA(1);

                        s = -1;
                        if ( ((LA7_124>='\u0000' && LA7_124<='\uFFFF')) ) {s = 193;}

                        else s = 194;

                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA7_0 = input.LA(1);

                        s = -1;
                        if ( (LA7_0=='p') ) {s = 1;}

                        else if ( (LA7_0=='i') ) {s = 2;}

                        else if ( (LA7_0=='d') ) {s = 3;}

                        else if ( (LA7_0=='f') ) {s = 4;}

                        else if ( (LA7_0=='a') ) {s = 5;}

                        else if ( (LA7_0=='r') ) {s = 6;}

                        else if ( (LA7_0=='e') ) {s = 7;}

                        else if ( (LA7_0=='n') ) {s = 8;}

                        else if ( (LA7_0=='m') ) {s = 9;}

                        else if ( (LA7_0=='o') ) {s = 10;}

                        else if ( (LA7_0=='y') ) {s = 11;}

                        else if ( (LA7_0=='b') ) {s = 12;}

                        else if ( (LA7_0=='c') ) {s = 13;}

                        else if ( (LA7_0=='l') ) {s = 14;}

                        else if ( (LA7_0=='s') ) {s = 15;}

                        else if ( (LA7_0=='u') ) {s = 16;}

                        else if ( (LA7_0=='g') ) {s = 17;}

                        else if ( (LA7_0=='t') ) {s = 18;}

                        else if ( (LA7_0=='v') ) {s = 19;}

                        else if ( (LA7_0=='<') ) {s = 20;}

                        else if ( (LA7_0=='>') ) {s = 21;}

                        else if ( (LA7_0=='w') ) {s = 22;}

                        else if ( (LA7_0=='k') ) {s = 23;}

                        else if ( (LA7_0=='!') ) {s = 24;}

                        else if ( (LA7_0=='.') ) {s = 25;}

                        else if ( (LA7_0=='$') ) {s = 26;}

                        else if ( (LA7_0=='(') ) {s = 27;}

                        else if ( (LA7_0==')') ) {s = 28;}

                        else if ( (LA7_0=='*') ) {s = 29;}

                        else if ( (LA7_0=='+') ) {s = 30;}

                        else if ( (LA7_0==',') ) {s = 31;}

                        else if ( (LA7_0=='-') ) {s = 32;}

                        else if ( (LA7_0=='/') ) {s = 33;}

                        else if ( (LA7_0==':') ) {s = 34;}

                        else if ( (LA7_0==';') ) {s = 35;}

                        else if ( (LA7_0=='=') ) {s = 36;}

                        else if ( (LA7_0=='@') ) {s = 37;}

                        else if ( (LA7_0=='[') ) {s = 38;}

                        else if ( (LA7_0==']') ) {s = 39;}

                        else if ( (LA7_0=='{') ) {s = 40;}

                        else if ( (LA7_0=='|') ) {s = 41;}

                        else if ( (LA7_0=='}') ) {s = 42;}

                        else if ( (LA7_0=='I') ) {s = 43;}

                        else if ( ((LA7_0>='\t' && LA7_0<='\n')||LA7_0=='\r'||LA7_0==' ') ) {s = 44;}

                        else if ( ((LA7_0>='\u0000' && LA7_0<='\b')||(LA7_0>='\u000B' && LA7_0<='\f')||(LA7_0>='\u000E' && LA7_0<='\u001F')||(LA7_0>='\"' && LA7_0<='#')||(LA7_0>='%' && LA7_0<='\'')||(LA7_0>='0' && LA7_0<='9')||LA7_0=='?'||(LA7_0>='A' && LA7_0<='H')||(LA7_0>='J' && LA7_0<='Z')||LA7_0=='\\'||(LA7_0>='^' && LA7_0<='`')||LA7_0=='h'||LA7_0=='j'||LA7_0=='q'||LA7_0=='x'||LA7_0=='z'||(LA7_0>='~' && LA7_0<='\uFFFF')) ) {s = 45;}

                        if ( s>=0 ) return s;
                        break;
            }
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 7, _s, input);
            error(nvae);
            throw nvae;
        }
    }
 

}
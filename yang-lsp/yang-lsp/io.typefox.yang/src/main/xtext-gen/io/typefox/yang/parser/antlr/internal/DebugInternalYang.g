/*
 * generated by Xtext 2.16.0-SNAPSHOT
 */
grammar DebugInternalYang;

// Rule AbstractModule
ruleAbstractModule:
	(
		ruleModule
		    |
		ruleSubmodule
	)
;

// Rule StatementEnd
ruleStatementEnd:
	(
		'{'
		ruleStatement
		*
		'}'
		    |
		';'
	)
;

// Rule Statement
ruleStatement:
	(
		ruleSchemaNode
		    |
		ruleOtherStatement
	)
;

// Rule AbstractImport
ruleAbstractImport:
	(
		ruleImport
		    |
		ruleInclude
	)
;

// Rule SchemaNode
ruleSchemaNode:
	(
		ruleDataSchemaNode
		    |
		ruleExtension
		    |
		ruleFeature
		    |
		ruleGrouping
		    |
		ruleIdentity
		    |
		ruleNotification
		    |
		ruleRpc
		    |
		ruleAction
		    |
		ruleInput
		    |
		ruleOutput
		    |
		ruleTypedef
	)
;

// Rule DataSchemaNode
ruleDataSchemaNode:
	(
		ruleAnydata
		    |
		ruleAnyxml
		    |
		ruleContainer
		    |
		ruleChoice
		    |
		ruleCase
		    |
		ruleList
		    |
		ruleLeaf
		    |
		ruleLeafList
	)
;

// Rule OtherStatement
ruleOtherStatement:
	(
		ruleAbstractModule
		    |
		ruleAbstractImport
		    |
		ruleArgument
		    |
		ruleAugment
		    |
		ruleBase
		    |
		ruleBelongsTo
		    |
		ruleConfig
		    |
		ruleContact
		    |
		ruleDefault
		    |
		ruleDescription
		    |
		ruleEnumerable
		    |
		ruleErrorAppTag
		    |
		ruleErrorMessage
		    |
		ruleDeviation
		    |
		ruleDeviate
		    |
		ruleFractionDigits
		    |
		ruleIfFeature
		    |
		ruleKey
		    |
		ruleMandatory
		    |
		ruleMaxElements
		    |
		ruleMinElements
		    |
		ruleModifier
		    |
		ruleMust
		    |
		ruleNamespace
		    |
		ruleOrdered
		    |
		ruleOrderedBy
		    |
		ruleOrganization
		    |
		rulePath
		    |
		rulePattern
		    |
		rulePrefix
		    |
		rulePresence
		    |
		ruleReference
		    |
		ruleRefine
		    |
		ruleRefinable
		    |
		ruleRequireInstance
		    |
		ruleRevision
		    |
		ruleRevisionDate
		    |
		ruleStatus
		    |
		ruleType
		    |
		ruleUnique
		    |
		ruleUnits
		    |
		ruleUnknown
		    |
		ruleUses
		    |
		ruleWhen
		    |
		ruleYangVersion
		    |
		ruleYinElement
	)
;

// Rule Enumerable
ruleEnumerable:
	(
		ruleEnum
		    |
		ruleBit
	)
;

// Rule Ordered
ruleOrdered:
	(
		rulePosition
		    |
		ruleValue
	)
;

// Rule Refinable
ruleRefinable:
	(
		ruleRange
		    |
		ruleLength
	)
;

// Rule Module
ruleModule:
	'module'
	ruleStringValue
	ruleStatementEnd
;

// Rule YangVersion
ruleYangVersion:
	'yang-version'
	ruleStringValue
	ruleStatementEnd
;

// Rule Namespace
ruleNamespace:
	'namespace'
	ruleStringValue
	ruleStatementEnd
;

// Rule Prefix
rulePrefix:
	'prefix'
	ruleStringValue
	ruleStatementEnd
;

// Rule Import
ruleImport:
	'import'
	ruleStringValue
	ruleStatementEnd
;

// Rule RevisionDate
ruleRevisionDate:
	'revision-date'
	ruleStringValue
	ruleStatementEnd
;

// Rule Include
ruleInclude:
	'include'
	ruleStringValue
	ruleStatementEnd
;

// Rule Organization
ruleOrganization:
	'organization'
	ruleStringValue
	ruleStatementEnd
;

// Rule Contact
ruleContact:
	'contact'
	ruleStringValue
	ruleStatementEnd
;

// Rule Revision
ruleRevision:
	'revision'
	ruleStringValue
	ruleStatementEnd
;

// Rule Submodule
ruleSubmodule:
	'submodule'
	ruleStringValue
	ruleStatementEnd
;

// Rule BelongsTo
ruleBelongsTo:
	'belongs-to'
	ruleStringValue
	ruleStatementEnd
;

// Rule Typedef
ruleTypedef:
	'typedef'
	ruleStringValue
	ruleStatementEnd
;

// Rule Units
ruleUnits:
	'units'
	ruleStringValue
	ruleStatementEnd
;

// Rule Default
ruleDefault:
	'default'
	ruleStringValue
	ruleStatementEnd
;

// Rule Type
ruleType:
	'type'
	ruleTypeReference
	ruleStatementEnd
;

// Rule TypeReference
ruleTypeReference:
	(
		ruleBUILTIN_TYPE
		    |
		ruleQualifiedTypeName
	)
;

// Rule Container
ruleContainer:
	'container'
	ruleStringValue
	ruleStatementEnd
;

// Rule Must
ruleMust:
	'must'
	ruleXpathExpression
	ruleStatementEnd
;

// Rule ErrorMessage
ruleErrorMessage:
	'error-message'
	ruleStringValue
	ruleStatementEnd
;

// Rule ErrorAppTag
ruleErrorAppTag:
	'error-app-tag'
	ruleStringValue
	ruleStatementEnd
;

// Rule Presence
rulePresence:
	'presence'
	ruleStringValue
	ruleStatementEnd
;

// Rule Leaf
ruleLeaf:
	'leaf'
	ruleStringValue
	ruleStatementEnd
;

// Rule Mandatory
ruleMandatory:
	'mandatory'
	ruleStringValue
	ruleStatementEnd
;

// Rule LeafList
ruleLeafList:
	'leaf-list'
	ruleStringValue
	ruleStatementEnd
;

// Rule MinElements
ruleMinElements:
	'min-elements'
	ruleStringValue
	ruleStatementEnd
;

// Rule MaxElements
ruleMaxElements:
	'max-elements'
	ruleStringValue
	ruleStatementEnd
;

// Rule OrderedBy
ruleOrderedBy:
	'ordered-by'
	ruleStringValue
	ruleStatementEnd
;

// Rule List
ruleList:
	'list'
	ruleStringValue
	ruleStatementEnd
;

// Rule Key
ruleKey:
	'key'
	ruleKeyReference
	+
	ruleStatementEnd
;

// Rule KeyReference
ruleKeyReference:
	ruleQNAME
;

// Rule DescendantSchemaNodeIdentifierReferences
ruleDescendantSchemaNodeIdentifierReferences:
	ruleDescendantSchemaNodeIdentifier
	+
;

// Rule Unique
ruleUnique:
	'unique'
	ruleDescendantSchemaNodeIdentifierReferences
	ruleStatementEnd
;

// Rule Choice
ruleChoice:
	'choice'
	ruleStringValue
	ruleStatementEnd
;

// Rule Case
ruleCase:
	'case'
	ruleStringValue
	ruleStatementEnd
;

// Rule Anydata
ruleAnydata:
	'anydata'
	ruleStringValue
	ruleStatementEnd
;

// Rule Anyxml
ruleAnyxml:
	'anyxml'
	ruleStringValue
	ruleStatementEnd
;

// Rule Grouping
ruleGrouping:
	'grouping'
	ruleStringValue
	ruleStatementEnd
;

// Rule Uses
ruleUses:
	'uses'
	ruleGroupingRef
	ruleStatementEnd
;

// Rule Refine
ruleRefine:
	'refine'
	ruleSchemaNodeIdentifier
	ruleStatementEnd
;

// Rule Rpc
ruleRpc:
	'rpc'
	ruleStringValue
	ruleStatementEnd
;

// Rule Input
ruleInput:
	'input'
	ruleStringValue
	?
	ruleStatementEnd
;

// Rule Output
ruleOutput:
	'output'
	ruleStringValue
	?
	ruleStatementEnd
;

// Rule Action
ruleAction:
	'action'
	ruleStringValue
	ruleStatementEnd
;

// Rule Notification
ruleNotification:
	'notification'
	ruleStringValue
	ruleStatementEnd
;

// Rule Augment
ruleAugment:
	'augment'
	ruleSchemaNodeIdentifier
	ruleStatementEnd
;

// Rule Identity
ruleIdentity:
	'identity'
	ruleStringValue
	ruleStatementEnd
;

// Rule Base
ruleBase:
	'base'
	ruleQNAME
	ruleStatementEnd
;

// Rule Extension
ruleExtension:
	'extension'
	ruleStringValue
	ruleStatementEnd
;

// Rule Argument
ruleArgument:
	'argument'
	ruleStringValue
	ruleStatementEnd
;

// Rule YinElement
ruleYinElement:
	'yin-element'
	ruleStringValue
	ruleStatementEnd
;

// Rule Feature
ruleFeature:
	'feature'
	ruleStringValue
	ruleStatementEnd
;

// Rule IfFeature
ruleIfFeature:
	'if-feature'
	ruleIfFeatureOrExpression
	ruleStatementEnd
;

// Rule IfFeatureOrExpression
ruleIfFeatureOrExpression:
	ruleIfFeatureAndExpression
	(
		'or'
		ruleIfFeatureAndExpression
	)*
;

// Rule IfFeatureAndExpression
ruleIfFeatureAndExpression:
	ruleIfFeatureExpression
	(
		'and'
		ruleIfFeatureExpression
	)*
;

// Rule IfFeatureExpression
ruleIfFeatureExpression:
	(
		ruleQNAME
		    |
		'not'
		ruleIfFeatureExpression
		    |
		'('
		ruleIfFeatureOrExpression
		')'
	)
;

// Rule Deviation
ruleDeviation:
	'deviation'
	ruleSchemaNodeIdentifier
	ruleStatementEnd
;

// Rule Deviate
ruleDeviate:
	'deviate'
	ruleStringValue
	ruleStatementEnd
;

// Rule Config
ruleConfig:
	'config'
	ruleStringValue
	ruleStatementEnd
;

// Rule Status
ruleStatus:
	'status'
	ruleStringValue
	ruleStatementEnd
;

// Rule Description
ruleDescription:
	'description'
	ruleStringValue
	ruleStatementEnd
;

// Rule Reference
ruleReference:
	'reference'
	ruleStringValue
	ruleStatementEnd
;

// Rule When
ruleWhen:
	'when'
	ruleXpathExpression
	ruleStatementEnd
;

// Rule Range
ruleRange:
	'range'
	ruleRefinementExpression
	ruleStatementEnd
;

// Rule RefinementExpression
ruleRefinementExpression:
	ruleRangeRefinementExpression
	(
		'|'
		ruleRangeRefinementExpression
	)*
;

// Rule RangeRefinementExpression
ruleRangeRefinementExpression:
	ruleExplicitRefinementExpression
	(
		'..'
		ruleExplicitRefinementExpression
	)?
;

// Rule ExplicitRefinementExpression
ruleExplicitRefinementExpression:
	(
		RULE_NUMBER
		    |
		'min'
		    |
		'max'
	)
;

// Rule FractionDigits
ruleFractionDigits:
	'fraction-digits'
	ruleStringValue
	ruleStatementEnd
;

// Rule Length
ruleLength:
	'length'
	ruleRefinementExpression
	ruleStatementEnd
;

// Rule Pattern
rulePattern:
	'pattern'
	ruleStringValue
	ruleStatementEnd
;

// Rule Modifier
ruleModifier:
	'modifier'
	ruleStringValue
	ruleStatementEnd
;

// Rule Enum
ruleEnum:
	'enum'
	ruleStringValue
	ruleStatementEnd
;

// Rule Value
ruleValue:
	'value'
	ruleStringValue
	ruleStatementEnd
;

// Rule Bit
ruleBit:
	'bit'
	ruleStringValue
	ruleStatementEnd
;

// Rule Position
rulePosition:
	'position'
	ruleStringValue
	ruleStatementEnd
;

// Rule Path
rulePath:
	'path'
	ruleXpathExpression
	ruleStatementEnd
;

// Rule RequireInstance
ruleRequireInstance:
	'require-instance'
	ruleStringValue
	ruleStatementEnd
;

// Rule Unknown
ruleUnknown:
	RULE_EXTENSION_NAME
	ruleStringValue
	?
	ruleStatementEnd
;

// Rule DescendantSchemaNodeIdentifier
ruleDescendantSchemaNodeIdentifier:
	ruleDescendantRootSchemaNodeIdentifier
	(
		'/'
		ruleQNAME
	)*
;

// Rule DescendantRootSchemaNodeIdentifier
ruleDescendantRootSchemaNodeIdentifier:
	ruleQNAME
;

// Rule SchemaNodeIdentifier
ruleSchemaNodeIdentifier:
	ruleRootSchemaNodeIdentifier
	(
		'/'
		ruleQNAME
	)*
;

// Rule RootSchemaNodeIdentifier
ruleRootSchemaNodeIdentifier:
	'/'
	?
	ruleQNAME
;

// Rule GroupingRef
ruleGroupingRef:
	ruleQNAME
;

// Rule XpathExpression
ruleXpathExpression:
	(
		'<<<<'
		RULE_STRING
		'>>>>'
		    |
		ruleParsedXpathExpression
	)
;

// Rule ParsedXpathExpression
ruleParsedXpathExpression:
	ruleXpathOrExpr
;

// Rule XpathOrExpr
ruleXpathOrExpr:
	ruleXpathAndExpr
	(
		'or'
		ruleXpathAndExpr
	)*
;

// Rule XpathAndExpr
ruleXpathAndExpr:
	ruleXpathEqualityExpr
	(
		'and'
		ruleXpathEqualityExpr
	)*
;

// Rule XpathEqualityExpr
ruleXpathEqualityExpr:
	ruleXpathRelationalExpr
	(
		(
			'='
			    |
			'!='
		)
		ruleXpathRelationalExpr
	)*
;

// Rule XpathRelationalExpr
ruleXpathRelationalExpr:
	ruleXpathAdditiveExpr
	(
		(
			'<'
			    |
			'>'
			    |
			'<='
			    |
			'>='
		)
		ruleXpathAdditiveExpr
	)*
;

// Rule XpathAdditiveExpr
ruleXpathAdditiveExpr:
	ruleXpathMultiplicativeExpr
	(
		(
			'+'
			    |
			'-'
		)
		ruleXpathMultiplicativeExpr
	)*
;

// Rule XpathMultiplicativeExpr
ruleXpathMultiplicativeExpr:
	ruleXpathUnaryExpr
	(
		(
			'*'
			    |
			'div'
			    |
			'mod'
		)
		ruleXpathMultiplicativeExpr
	)?
;

// Rule XpathUnaryExpr
ruleXpathUnaryExpr:
	(
		'-'
		ruleXpathUnionExpr
		    |
		ruleXpathUnionExpr
	)
;

// Rule XpathUnionExpr
ruleXpathUnionExpr:
	ruleXpathPathExpr
	(
		'|'
		ruleXpathUnionExpr
	)?
;

// Rule XpathPathExpr
ruleXpathPathExpr:
	ruleXpathFilterExpr
	(
		'/'
		(
			('/')=>
			'/'
		)?
		ruleXpathStep
		(
			'['
			ruleXpathExpression
			']'
		)*
	)*
;

// Rule XpathFilterExpr
ruleXpathFilterExpr:
	ruleXpathPrimaryExpr
	(
		'['
		ruleXpathExpression
		']'
	)*
;

// Rule XpathPrimaryExpr
ruleXpathPrimaryExpr:
	(
		'$'
		ruleQNAME
		    |
		'('
		ruleXpathExpression
		')'
		    |
		RULE_STRING
		    |
		RULE_NUMBER
		    |
		ruleQNAME
		'('
		(
			ruleXpathExpression
			(
				','
				ruleXpathExpression
			)*
		)?
		')'
		    |
		ruleXpathStep
		    |
		'/'
		(
			('/')=>
			'/'
		)?
		(
			('.' | '..' | '@' | 'ancestor' | 'ancestor-or-self' | 'attribute' | 'child' | 'descendant' | 'descendant-or-self' | 'following' | 'following-sibling' | 'namespace' | 'parent' | 'preceding' | 'preceding-sibling' | 'self' | 'div' | 'and' | 'or' | 'mod' | 'comment' | 'text' | 'node' | '*' | 'processing-instruction' | RULE_ID)=>
			ruleXpathStep
		)?
	)
;

// Rule XpathStep
ruleXpathStep:
	(
		ruleDot
		    |
		ruleDotDot
		    |
		'@'
		ruleXpathIDOrKw
		    |
		(
			ruleXpathAxisName
			':'
			':'
		)?
		ruleXpathNodeTest
	)
;

// Rule Dot
ruleDot:
	'.'
;

// Rule DotDot
ruleDotDot:
	'..'
;

// Rule XpathNodeTest
ruleXpathNodeTest:
	(
		ruleXpathNameTest
		    |
		ruleXpathNodeType
		'('
		')'
		    |
		'processing-instruction'
		'('
		RULE_STRING
		')'
	)
;

// Rule XpathNameTest
ruleXpathNameTest:
	(
		RULE_ID
		':'
	)?
	ruleXpathIDOrKw
;

// Rule XpathNodeType
ruleXpathNodeType:
	(
		'comment'
		    |
		'text'
		    |
		'node'
	)
;

// Rule XpathAxisName
ruleXpathAxisName:
	(
		'ancestor'
		    |
		'ancestor-or-self'
		    |
		'attribute'
		    |
		'child'
		    |
		'descendant'
		    |
		'descendant-or-self'
		    |
		'following'
		    |
		'following-sibling'
		    |
		'namespace'
		    |
		'parent'
		    |
		'preceding'
		    |
		'preceding-sibling'
		    |
		'self'
	)
;

// Rule XpathIDOrKw
ruleXpathIDOrKw:
	(
		RULE_ID
		    |
		'div'
		    |
		'and'
		    |
		'or'
		    |
		'mod'
		    |
		ruleXpathAxisName
		    |
		ruleXpathNodeType
		    |
		'*'
	)
;

// Rule QNAME
ruleQNAME:
	(
		ruleIdOrKw
		':'
	)?
	ruleIdOrKw
;

// Rule StringValue
ruleStringValue:
	RULE_STRING+
;

// Rule IdOrKw
ruleIdOrKw:
	(
		RULE_ID
		    |
		ruleBUILTIN_TYPE
		    |
		ruleKEYWORD
	)
;

// Rule QualifiedTypeName
ruleQualifiedTypeName:
	(
		(
			RULE_ID
			    |
			ruleKEYWORD
		)
		':'
	)?
	(
		RULE_ID
		    |
		ruleKEYWORD
	)
;

// Rule BUILTIN_TYPE
ruleBUILTIN_TYPE:
	(
		'binary'
		    |
		'bits'
		    |
		'boolean'
		    |
		'decimal64'
		    |
		'empty'
		    |
		'enumeration'
		    |
		'identityref'
		    |
		'instance-identifier'
		    |
		'int8'
		    |
		'int16'
		    |
		'int32'
		    |
		'int64'
		    |
		'leafref'
		    |
		'string'
		    |
		'uint8'
		    |
		'uint16'
		    |
		'uint32'
		    |
		'uint64'
		    |
		'union'
	)
;

// Rule KEYWORD
ruleKEYWORD:
	(
		ruleSTATEMENT_KEYWORD
		    |
		'add'
		    |
		'current'
		    |
		'delete'
		    |
		'deprecated'
		    |
		'false'
		    |
		'max'
		    |
		'min'
		    |
		'not-supported'
		    |
		'obsolete'
		    |
		'replace'
		    |
		'system'
		    |
		'true'
		    |
		'unbounded'
		    |
		'user'
	)
;

// Rule STATEMENT_KEYWORD
ruleSTATEMENT_KEYWORD:
	(
		'action'
		    |
		'anydata'
		    |
		'anyxml'
		    |
		'argument'
		    |
		'augment'
		    |
		'base'
		    |
		'belongs-to'
		    |
		'bit'
		    |
		'case'
		    |
		'choice'
		    |
		'config'
		    |
		'contact'
		    |
		'container'
		    |
		'default'
		    |
		'description'
		    |
		'enum'
		    |
		'error-app-tag'
		    |
		'error-message'
		    |
		'extension'
		    |
		'deviation'
		    |
		'deviate'
		    |
		'feature'
		    |
		'fraction-digits'
		    |
		'grouping'
		    |
		'identity'
		    |
		'if-feature'
		    |
		'import'
		    |
		'include'
		    |
		'input'
		    |
		'key'
		    |
		'leaf'
		    |
		'leaf-list'
		    |
		'length'
		    |
		'list'
		    |
		'mandatory'
		    |
		'max-elements'
		    |
		'min-elements'
		    |
		'modifier'
		    |
		'module'
		    |
		'must'
		    |
		'namespace'
		    |
		'notification'
		    |
		'ordered-by'
		    |
		'organization'
		    |
		'output'
		    |
		'path'
		    |
		'pattern'
		    |
		'position'
		    |
		'prefix'
		    |
		'presence'
		    |
		'range'
		    |
		'reference'
		    |
		'refine'
		    |
		'require-instance'
		    |
		'revision'
		    |
		'revision-date'
		    |
		'rpc'
		    |
		'status'
		    |
		'submodule'
		    |
		'type'
		    |
		'typedef'
		    |
		'unique'
		    |
		'units'
		    |
		'uses'
		    |
		'value'
		    |
		'when'
		    |
		'yang-version'
		    |
		'yin-element'
	)
;

RULE_ID : 'an id';

RULE_EXTENSION_NAME : 'ID:ID // only valid on statement ctx';

RULE_STRING : 'an unquoted string';

RULE_NUMBER : 'positive integer value';

RULE_OPERATOR : ('and'|'or'|'mod'|'div'|'*'|'/'|'//'|'|'|'+'|'-'|'='|'!='|'<'|'<='|'>'|'>=');

RULE_ML_COMMENT : '/*' ( options {greedy=false;} : . )*'*/' {skip();};

RULE_SL_COMMENT : '//' ~(('\n'|'\r'))* ('\r'? '\n')? {skip();};

RULE_WS : (' '|'\t'|'\r'|'\n')+ {skip();};

RULE_HIDDEN : 'other hidden tokens' {skip();};

RULE_ANY_OTHER : .;
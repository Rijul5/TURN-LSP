package io.typefox.yang.validation;

import com.google.common.collect.ImmutableMap;
import com.google.inject.Singleton;
import io.typefox.yang.utils.YangExtensions;
import io.typefox.yang.validation.SubstatementGroup;
import io.typefox.yang.yang.YangPackage;
import java.util.Map;
import org.eclipse.emf.ecore.EClass;

/**
 * Provides YANG sub-statement rules for a given statement given as an EClass.
 * 
 * @author akos.kitta
 */
@Singleton
@SuppressWarnings("all")
public class SubstatementRuleProvider {
  public static SubstatementGroup newRule() {
    return new SubstatementGroup(false);
  }
  
  public static SubstatementGroup newOrderedRule() {
    return new SubstatementGroup(true);
  }
  
  private static final SubstatementGroup MODULE_HEADER_RULE = SubstatementRuleProvider.newRule().optional(YangPackage.Literals.YANG_VERSION).must(YangPackage.Literals.NAMESPACE).must(YangPackage.Literals.PREFIX);
  
  private static final SubstatementGroup SUBMODULE_HEADER_RULE = SubstatementRuleProvider.newRule().optional(YangPackage.Literals.YANG_VERSION).must(YangPackage.Literals.BELONGS_TO);
  
  private static final SubstatementGroup LINKAGE_RULE = SubstatementRuleProvider.newRule().any(YangPackage.Literals.IMPORT).any(YangPackage.Literals.INCLUDE);
  
  private static final SubstatementGroup META_RULE = SubstatementRuleProvider.newRule().optional(YangPackage.Literals.ORGANIZATION).optional(YangPackage.Literals.CONTACT).optional(YangPackage.Literals.DESCRIPTION).optional(YangPackage.Literals.REFERENCE);
  
  private static final SubstatementGroup DATA_RULE = SubstatementRuleProvider.newRule().any(YangPackage.Literals.CONTAINER).any(YangPackage.Literals.LEAF).any(YangPackage.Literals.LEAF_LIST).any(YangPackage.Literals.LIST).any(YangPackage.Literals.CHOICE).any(YangExtensions.YANG_1_1, YangPackage.Literals.ANYDATA).any(YangPackage.Literals.ANYXML).any(YangPackage.Literals.USES);
  
  private static final SubstatementGroup BODY_RULE = SubstatementRuleProvider.newRule().any(YangPackage.Literals.EXTENSION).any(YangPackage.Literals.FEATURE).any(YangPackage.Literals.IDENTITY).any(YangPackage.Literals.TYPEDEF).any(YangPackage.Literals.GROUPING).any(YangPackage.Literals.RPC).any(YangPackage.Literals.NOTIFICATION).any(YangPackage.Literals.DEVIATION).any(YangPackage.Literals.AUGMENT).with(SubstatementRuleProvider.DATA_RULE);
  
  private static final SubstatementGroup REVISION_RULE = SubstatementRuleProvider.newRule().optional(YangPackage.Literals.DESCRIPTION).optional(YangPackage.Literals.REFERENCE);
  
  private static final SubstatementGroup MODULE_RULE = SubstatementRuleProvider.newOrderedRule().with(SubstatementRuleProvider.MODULE_HEADER_RULE).with(SubstatementRuleProvider.LINKAGE_RULE).with(SubstatementRuleProvider.META_RULE).any(YangPackage.Literals.REVISION).with(SubstatementRuleProvider.BODY_RULE);
  
  private static final SubstatementGroup SUBMODULE_RULE = SubstatementRuleProvider.newOrderedRule().with(SubstatementRuleProvider.SUBMODULE_HEADER_RULE).with(SubstatementRuleProvider.LINKAGE_RULE).with(SubstatementRuleProvider.META_RULE).any(YangPackage.Literals.REVISION).with(SubstatementRuleProvider.BODY_RULE);
  
  private static final SubstatementGroup IMPORT_RULE = SubstatementRuleProvider.newRule().must(YangPackage.Literals.PREFIX).optional(YangPackage.Literals.REVISION_DATE).optional(YangExtensions.YANG_1_1, YangPackage.Literals.DESCRIPTION).optional(YangExtensions.YANG_1_1, YangPackage.Literals.REFERENCE);
  
  private static final SubstatementGroup INCLUDE_RULE = SubstatementRuleProvider.newRule().optional(YangPackage.Literals.REVISION_DATE).optional(YangExtensions.YANG_1_1, YangPackage.Literals.DESCRIPTION).optional(YangExtensions.YANG_1_1, YangPackage.Literals.REFERENCE);
  
  private static final SubstatementGroup BELONGS_TO_RULE = SubstatementRuleProvider.newRule().must(YangPackage.Literals.PREFIX);
  
  private static final SubstatementGroup EXTENSION_RULE = SubstatementRuleProvider.newRule().optional(YangPackage.Literals.ARGUMENT).optional(YangPackage.Literals.STATUS).optional(YangPackage.Literals.DESCRIPTION).optional(YangPackage.Literals.REFERENCE);
  
  private static final SubstatementGroup ARGUMENT_RULE = SubstatementRuleProvider.newRule().optional(YangPackage.Literals.YIN_ELEMENT);
  
  private static final SubstatementGroup FEATURE_RULE = SubstatementRuleProvider.newRule().any(YangPackage.Literals.IF_FEATURE).optional(YangPackage.Literals.STATUS).optional(YangPackage.Literals.DESCRIPTION).optional(YangPackage.Literals.REFERENCE);
  
  private static final SubstatementGroup IDENTITY_RULE = SubstatementRuleProvider.newRule().any(YangPackage.Literals.BASE).any(YangExtensions.YANG_1_1, YangPackage.Literals.IF_FEATURE).optional(YangPackage.Literals.STATUS).optional(YangPackage.Literals.DESCRIPTION).optional(YangPackage.Literals.REFERENCE);
  
  private static final SubstatementGroup TYPEDEF_RULE = SubstatementRuleProvider.newRule().must(YangPackage.Literals.TYPE).optional(YangPackage.Literals.UNITS).optional(YangPackage.Literals.DEFAULT).optional(YangPackage.Literals.STATUS).optional(YangPackage.Literals.DESCRIPTION).optional(YangPackage.Literals.REFERENCE);
  
  private static final SubstatementGroup TYPE_RULE = SubstatementRuleProvider.newRule().optional(YangPackage.Literals.FRACTION_DIGITS).optional(YangPackage.Literals.RANGE).optional(YangPackage.Literals.LENGTH).any(YangPackage.Literals.PATTERN).any(YangPackage.Literals.ENUM).any(YangPackage.Literals.BIT).optional(YangPackage.Literals.PATH).optional(YangPackage.Literals.REQUIRE_INSTANCE).any(YangPackage.Literals.BASE).any(YangPackage.Literals.TYPE);
  
  /**
   * For both "range" and "length".
   */
  private static final SubstatementGroup REFINABLE_RULE = SubstatementRuleProvider.newRule().optional(YangPackage.Literals.ERROR_MESSAGE).optional(YangPackage.Literals.ERROR_APP_TAG).optional(YangPackage.Literals.DESCRIPTION).optional(YangPackage.Literals.REFERENCE);
  
  private static final SubstatementGroup PATTERN_RULE = SubstatementRuleProvider.newRule().optional(YangExtensions.YANG_1_1, YangPackage.Literals.MODIFIER).optional(YangPackage.Literals.ERROR_MESSAGE).optional(YangPackage.Literals.ERROR_APP_TAG).optional(YangPackage.Literals.DESCRIPTION).optional(YangPackage.Literals.REFERENCE);
  
  private static final SubstatementGroup ENUM_RULE = SubstatementRuleProvider.newRule().optional(YangPackage.Literals.VALUE).any(YangExtensions.YANG_1_1, YangPackage.Literals.IF_FEATURE).optional(YangPackage.Literals.STATUS).optional(YangPackage.Literals.DESCRIPTION).optional(YangPackage.Literals.REFERENCE);
  
  private static final SubstatementGroup BIT_RULE = SubstatementRuleProvider.newRule().optional(YangPackage.Literals.POSITION).any(YangExtensions.YANG_1_1, YangPackage.Literals.IF_FEATURE).optional(YangPackage.Literals.STATUS).optional(YangPackage.Literals.DESCRIPTION).optional(YangPackage.Literals.REFERENCE);
  
  private static final SubstatementGroup MUST_RULE = SubstatementRuleProvider.newRule().optional(YangPackage.Literals.ERROR_MESSAGE).optional(YangPackage.Literals.ERROR_APP_TAG).optional(YangPackage.Literals.DESCRIPTION).optional(YangPackage.Literals.REFERENCE);
  
  private static final SubstatementGroup GROUPING_RULE = SubstatementRuleProvider.newRule().optional(YangPackage.Literals.STATUS).optional(YangPackage.Literals.DESCRIPTION).optional(YangPackage.Literals.REFERENCE).any(YangPackage.Literals.TYPEDEF).any(YangPackage.Literals.GROUPING).with(SubstatementRuleProvider.DATA_RULE).any(YangExtensions.YANG_1_1, YangPackage.Literals.ACTION).any(YangExtensions.YANG_1_1, YangPackage.Literals.NOTIFICATION);
  
  private static final SubstatementGroup CONTAINER_RULE = SubstatementRuleProvider.newRule().optional(YangPackage.Literals.WHEN).any(YangPackage.Literals.IF_FEATURE).any(YangPackage.Literals.MUST).optional(YangPackage.Literals.PRESENCE).optional(YangPackage.Literals.CONFIG).optional(YangPackage.Literals.STATUS).optional(YangPackage.Literals.DESCRIPTION).optional(YangPackage.Literals.REFERENCE).any(YangPackage.Literals.TYPEDEF).any(YangPackage.Literals.GROUPING).with(SubstatementRuleProvider.DATA_RULE).any(YangExtensions.YANG_1_1, YangPackage.Literals.ACTION).any(YangExtensions.YANG_1_1, YangPackage.Literals.NOTIFICATION);
  
  private static final SubstatementGroup LEAF_RULE = SubstatementRuleProvider.newRule().optional(YangPackage.Literals.WHEN).any(YangPackage.Literals.IF_FEATURE).must(YangPackage.Literals.TYPE).optional(YangPackage.Literals.UNITS).any(YangPackage.Literals.MUST).optional(YangPackage.Literals.DEFAULT).optional(YangPackage.Literals.CONFIG).optional(YangPackage.Literals.MANDATORY).optional(YangPackage.Literals.STATUS).optional(YangPackage.Literals.DESCRIPTION).optional(YangPackage.Literals.REFERENCE);
  
  private static final SubstatementGroup LEAF_LIST_RULE = SubstatementRuleProvider.newRule().optional(YangPackage.Literals.WHEN).any(YangPackage.Literals.IF_FEATURE).must(YangPackage.Literals.TYPE).optional(YangPackage.Literals.UNITS).any(YangPackage.Literals.MUST).any(YangExtensions.YANG_1_1, YangPackage.Literals.DEFAULT).optional(YangPackage.Literals.CONFIG).optional(YangPackage.Literals.MIN_ELEMENTS).optional(YangPackage.Literals.MAX_ELEMENTS).optional(YangPackage.Literals.ORDERED_BY).optional(YangPackage.Literals.STATUS).optional(YangPackage.Literals.DESCRIPTION).optional(YangPackage.Literals.REFERENCE);
  
  private static final SubstatementGroup LIST_RULE = SubstatementRuleProvider.newRule().optional(YangPackage.Literals.WHEN).any(YangPackage.Literals.IF_FEATURE).any(YangPackage.Literals.MUST).optional(YangPackage.Literals.KEY).any(YangPackage.Literals.UNIQUE).optional(YangPackage.Literals.CONFIG).optional(YangPackage.Literals.MIN_ELEMENTS).optional(YangPackage.Literals.MAX_ELEMENTS).optional(YangPackage.Literals.ORDERED_BY).optional(YangPackage.Literals.STATUS).optional(YangPackage.Literals.DESCRIPTION).optional(YangPackage.Literals.REFERENCE).any(YangPackage.Literals.TYPEDEF).any(YangPackage.Literals.GROUPING).with(SubstatementRuleProvider.DATA_RULE).any(YangExtensions.YANG_1_1, YangPackage.Literals.ACTION).any(YangExtensions.YANG_1_1, YangPackage.Literals.NOTIFICATION);
  
  private static final SubstatementGroup CHOICE_RULE = SubstatementRuleProvider.newRule().optional(YangPackage.Literals.WHEN).any(YangPackage.Literals.IF_FEATURE).optional(YangPackage.Literals.DEFAULT).any(YangPackage.Literals.MUST).optional(YangPackage.Literals.CONFIG).optional(YangPackage.Literals.MANDATORY).optional(YangPackage.Literals.STATUS).optional(YangPackage.Literals.DESCRIPTION).optional(YangPackage.Literals.REFERENCE).any(YangPackage.Literals.CASE).any(YangExtensions.YANG_1_1, YangPackage.Literals.CHOICE).any(YangPackage.Literals.CONTAINER).any(YangPackage.Literals.LEAF).any(YangPackage.Literals.LEAF_LIST).any(YangPackage.Literals.LIST).any(YangExtensions.YANG_1_1, YangPackage.Literals.ANYDATA).any(YangPackage.Literals.ANYXML);
  
  private static final SubstatementGroup CASE_RULE = SubstatementRuleProvider.newRule().optional(YangPackage.Literals.WHEN).any(YangPackage.Literals.IF_FEATURE).optional(YangPackage.Literals.STATUS).optional(YangPackage.Literals.DESCRIPTION).optional(YangPackage.Literals.REFERENCE).with(SubstatementRuleProvider.DATA_RULE);
  
  private static final SubstatementGroup ANYDATA_RULE = SubstatementRuleProvider.newRule().optional(YangPackage.Literals.WHEN).any(YangPackage.Literals.IF_FEATURE).any(YangPackage.Literals.MUST).optional(YangPackage.Literals.CONFIG).optional(YangPackage.Literals.MANDATORY).optional(YangPackage.Literals.STATUS).optional(YangPackage.Literals.DESCRIPTION).optional(YangPackage.Literals.REFERENCE);
  
  private static final SubstatementGroup ANYXML_RULE = SubstatementRuleProvider.newRule().optional(YangPackage.Literals.WHEN).any(YangPackage.Literals.IF_FEATURE).any(YangPackage.Literals.MUST).optional(YangPackage.Literals.CONFIG).optional(YangPackage.Literals.MANDATORY).optional(YangPackage.Literals.STATUS).optional(YangPackage.Literals.DESCRIPTION).optional(YangPackage.Literals.REFERENCE);
  
  private static final SubstatementGroup USES_RULE = SubstatementRuleProvider.newRule().optional(YangPackage.Literals.WHEN).any(YangPackage.Literals.IF_FEATURE).optional(YangPackage.Literals.STATUS).optional(YangPackage.Literals.DESCRIPTION).optional(YangPackage.Literals.REFERENCE).any(YangPackage.Literals.REFINE).any(YangPackage.Literals.AUGMENT);
  
  private static final SubstatementGroup REFINE_RULE = SubstatementRuleProvider.newRule().any(YangPackage.Literals.MUST).any(YangExtensions.YANG_1_1, YangPackage.Literals.IF_FEATURE).optional(YangPackage.Literals.PRESENCE).optional(YangPackage.Literals.DEFAULT).optional(YangPackage.Literals.CONFIG).optional(YangPackage.Literals.MANDATORY).optional(YangPackage.Literals.MIN_ELEMENTS).optional(YangPackage.Literals.MAX_ELEMENTS).optional(YangPackage.Literals.DESCRIPTION).optional(YangPackage.Literals.REFERENCE);
  
  private static final SubstatementGroup AUGMENT_RULE = SubstatementRuleProvider.newRule().optional(YangPackage.Literals.WHEN).any(YangPackage.Literals.IF_FEATURE).optional(YangPackage.Literals.STATUS).optional(YangPackage.Literals.DESCRIPTION).optional(YangPackage.Literals.REFERENCE).any(YangPackage.Literals.CASE).with(SubstatementRuleProvider.DATA_RULE).any(YangExtensions.YANG_1_1, YangPackage.Literals.ACTION).any(YangExtensions.YANG_1_1, YangPackage.Literals.NOTIFICATION);
  
  private static final SubstatementGroup WHEN_RULE = SubstatementRuleProvider.newRule().optional(YangPackage.Literals.DESCRIPTION).optional(YangPackage.Literals.REFERENCE);
  
  private static final SubstatementGroup RPC_RULE = SubstatementRuleProvider.newRule().any(YangPackage.Literals.IF_FEATURE).optional(YangPackage.Literals.STATUS).optional(YangPackage.Literals.DESCRIPTION).optional(YangPackage.Literals.REFERENCE).any(YangPackage.Literals.TYPEDEF).any(YangPackage.Literals.GROUPING).optional(YangPackage.Literals.INPUT).optional(YangPackage.Literals.OUTPUT);
  
  private static final SubstatementGroup ACTION_RULE = SubstatementRuleProvider.newRule().any(YangPackage.Literals.IF_FEATURE).optional(YangPackage.Literals.STATUS).optional(YangPackage.Literals.DESCRIPTION).optional(YangPackage.Literals.REFERENCE).any(YangPackage.Literals.TYPEDEF).any(YangPackage.Literals.GROUPING).optional(YangPackage.Literals.INPUT).optional(YangPackage.Literals.OUTPUT);
  
  private static final SubstatementGroup INPUT_RULE = SubstatementRuleProvider.newRule().any(YangExtensions.YANG_1_1, YangPackage.Literals.MUST).any(YangPackage.Literals.TYPEDEF).any(YangPackage.Literals.GROUPING).with(SubstatementRuleProvider.DATA_RULE);
  
  private static final SubstatementGroup OUTPUT_RULE = SubstatementRuleProvider.newRule().any(YangExtensions.YANG_1_1, YangPackage.Literals.MUST).any(YangPackage.Literals.TYPEDEF).any(YangPackage.Literals.GROUPING).with(SubstatementRuleProvider.DATA_RULE);
  
  private static final SubstatementGroup NOTIFICATION_RULE = SubstatementRuleProvider.newRule().any(YangPackage.Literals.IF_FEATURE).any(YangExtensions.YANG_1_1, YangPackage.Literals.MUST).optional(YangPackage.Literals.STATUS).optional(YangPackage.Literals.DESCRIPTION).optional(YangPackage.Literals.REFERENCE).any(YangPackage.Literals.TYPEDEF).any(YangPackage.Literals.GROUPING).with(SubstatementRuleProvider.DATA_RULE);
  
  private static final SubstatementGroup DEVIATION_RULE = SubstatementRuleProvider.newRule().optional(YangPackage.Literals.DESCRIPTION).optional(YangPackage.Literals.REFERENCE).atLeastOne(YangPackage.Literals.DEVIATE);
  
  private static final SubstatementGroup DEVIATE_RULE = SubstatementRuleProvider.newRule().optional(YangPackage.Literals.TYPE).optional(YangPackage.Literals.UNITS).any(YangPackage.Literals.MUST).any(YangPackage.Literals.UNIQUE).any(YangPackage.Literals.DEFAULT).optional(YangPackage.Literals.CONFIG).optional(YangPackage.Literals.MANDATORY).optional(YangPackage.Literals.MIN_ELEMENTS).optional(YangPackage.Literals.MAX_ELEMENTS);
  
  private final Map<EClass, SubstatementGroup> rules;
  
  public SubstatementRuleProvider() {
    this.rules = ImmutableMap.<EClass, SubstatementGroup>builder().put(YangPackage.Literals.REVISION, SubstatementRuleProvider.REVISION_RULE).put(YangPackage.Literals.MODULE, SubstatementRuleProvider.MODULE_RULE).put(YangPackage.Literals.SUBMODULE, SubstatementRuleProvider.SUBMODULE_RULE).put(YangPackage.Literals.IMPORT, SubstatementRuleProvider.IMPORT_RULE).put(YangPackage.Literals.INCLUDE, SubstatementRuleProvider.INCLUDE_RULE).put(YangPackage.Literals.BELONGS_TO, SubstatementRuleProvider.BELONGS_TO_RULE).put(YangPackage.Literals.EXTENSION, SubstatementRuleProvider.EXTENSION_RULE).put(YangPackage.Literals.ARGUMENT, SubstatementRuleProvider.ARGUMENT_RULE).put(YangPackage.Literals.FEATURE, SubstatementRuleProvider.FEATURE_RULE).put(YangPackage.Literals.IDENTITY, SubstatementRuleProvider.IDENTITY_RULE).put(YangPackage.Literals.TYPEDEF, SubstatementRuleProvider.TYPEDEF_RULE).put(YangPackage.Literals.TYPE, SubstatementRuleProvider.TYPE_RULE).put(YangPackage.Literals.RANGE, SubstatementRuleProvider.REFINABLE_RULE).put(YangPackage.Literals.LENGTH, SubstatementRuleProvider.REFINABLE_RULE).put(YangPackage.Literals.PATTERN, SubstatementRuleProvider.PATTERN_RULE).put(YangPackage.Literals.ENUM, SubstatementRuleProvider.ENUM_RULE).put(YangPackage.Literals.BIT, SubstatementRuleProvider.BIT_RULE).put(YangPackage.Literals.MUST, SubstatementRuleProvider.MUST_RULE).put(YangPackage.Literals.GROUPING, SubstatementRuleProvider.GROUPING_RULE).put(YangPackage.Literals.CONTAINER, SubstatementRuleProvider.CONTAINER_RULE).put(YangPackage.Literals.LEAF, SubstatementRuleProvider.LEAF_RULE).put(YangPackage.Literals.LEAF_LIST, SubstatementRuleProvider.LEAF_LIST_RULE).put(YangPackage.Literals.LIST, SubstatementRuleProvider.LIST_RULE).put(YangPackage.Literals.CHOICE, SubstatementRuleProvider.CHOICE_RULE).put(YangPackage.Literals.CASE, SubstatementRuleProvider.CASE_RULE).put(YangPackage.Literals.ANYDATA, SubstatementRuleProvider.ANYDATA_RULE).put(YangPackage.Literals.ANYXML, SubstatementRuleProvider.ANYXML_RULE).put(YangPackage.Literals.USES, SubstatementRuleProvider.USES_RULE).put(YangPackage.Literals.REFINE, SubstatementRuleProvider.REFINE_RULE).put(YangPackage.Literals.AUGMENT, SubstatementRuleProvider.AUGMENT_RULE).put(YangPackage.Literals.WHEN, SubstatementRuleProvider.WHEN_RULE).put(YangPackage.Literals.RPC, SubstatementRuleProvider.RPC_RULE).put(YangPackage.Literals.ACTION, SubstatementRuleProvider.ACTION_RULE).put(YangPackage.Literals.INPUT, SubstatementRuleProvider.INPUT_RULE).put(YangPackage.Literals.OUTPUT, SubstatementRuleProvider.OUTPUT_RULE).put(YangPackage.Literals.NOTIFICATION, SubstatementRuleProvider.NOTIFICATION_RULE).put(YangPackage.Literals.DEVIATION, SubstatementRuleProvider.DEVIATION_RULE).put(YangPackage.Literals.DEVIATE, SubstatementRuleProvider.DEVIATE_RULE).build();
  }
  
  public SubstatementGroup get(final EClass clazz) {
    return this.rules.get(clazz);
  }
}

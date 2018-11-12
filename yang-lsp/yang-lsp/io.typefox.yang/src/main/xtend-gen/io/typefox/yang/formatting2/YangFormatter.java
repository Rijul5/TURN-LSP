package io.typefox.yang.formatting2;

import com.google.common.base.Objects;
import com.google.inject.Inject;
import io.typefox.yang.formatting2.MultilineStringReplacer;
import io.typefox.yang.services.YangGrammarAccess;
import io.typefox.yang.yang.Action;
import io.typefox.yang.yang.Anydata;
import io.typefox.yang.yang.Anyxml;
import io.typefox.yang.yang.Argument;
import io.typefox.yang.yang.Augment;
import io.typefox.yang.yang.Base;
import io.typefox.yang.yang.BelongsTo;
import io.typefox.yang.yang.Bit;
import io.typefox.yang.yang.Case;
import io.typefox.yang.yang.Choice;
import io.typefox.yang.yang.Config;
import io.typefox.yang.yang.Contact;
import io.typefox.yang.yang.Container;
import io.typefox.yang.yang.Default;
import io.typefox.yang.yang.Description;
import io.typefox.yang.yang.Deviate;
import io.typefox.yang.yang.Deviation;
import io.typefox.yang.yang.ErrorAppTag;
import io.typefox.yang.yang.ErrorMessage;
import io.typefox.yang.yang.Expression;
import io.typefox.yang.yang.Feature;
import io.typefox.yang.yang.FractionDigits;
import io.typefox.yang.yang.Grouping;
import io.typefox.yang.yang.GroupingRef;
import io.typefox.yang.yang.Identity;
import io.typefox.yang.yang.IfFeature;
import io.typefox.yang.yang.Import;
import io.typefox.yang.yang.Include;
import io.typefox.yang.yang.Input;
import io.typefox.yang.yang.Key;
import io.typefox.yang.yang.KeyReference;
import io.typefox.yang.yang.Leaf;
import io.typefox.yang.yang.LeafList;
import io.typefox.yang.yang.Length;
import io.typefox.yang.yang.List;
import io.typefox.yang.yang.Mandatory;
import io.typefox.yang.yang.MaxElements;
import io.typefox.yang.yang.MinElements;
import io.typefox.yang.yang.Modifier;
import io.typefox.yang.yang.Must;
import io.typefox.yang.yang.Namespace;
import io.typefox.yang.yang.Notification;
import io.typefox.yang.yang.OrderedBy;
import io.typefox.yang.yang.Organization;
import io.typefox.yang.yang.Output;
import io.typefox.yang.yang.Path;
import io.typefox.yang.yang.Pattern;
import io.typefox.yang.yang.Position;
import io.typefox.yang.yang.Prefix;
import io.typefox.yang.yang.Presence;
import io.typefox.yang.yang.Range;
import io.typefox.yang.yang.Reference;
import io.typefox.yang.yang.Refine;
import io.typefox.yang.yang.RequireInstance;
import io.typefox.yang.yang.Revision;
import io.typefox.yang.yang.RevisionDate;
import io.typefox.yang.yang.Rpc;
import io.typefox.yang.yang.SchemaNodeIdentifier;
import io.typefox.yang.yang.Statement;
import io.typefox.yang.yang.Status;
import io.typefox.yang.yang.Submodule;
import io.typefox.yang.yang.Type;
import io.typefox.yang.yang.TypeReference;
import io.typefox.yang.yang.Typedef;
import io.typefox.yang.yang.Unique;
import io.typefox.yang.yang.Units;
import io.typefox.yang.yang.Unknown;
import io.typefox.yang.yang.Uses;
import io.typefox.yang.yang.Value;
import io.typefox.yang.yang.When;
import io.typefox.yang.yang.XpathExpression;
import io.typefox.yang.yang.XpathLocation;
import io.typefox.yang.yang.XpathNameTest;
import io.typefox.yang.yang.YangVersion;
import io.typefox.yang.yang.YinElement;
import java.util.Arrays;
import java.util.function.Consumer;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.Assignment;
import org.eclipse.xtext.Keyword;
import org.eclipse.xtext.TerminalRule;
import org.eclipse.xtext.formatting.IIndentationInformation;
import org.eclipse.xtext.formatting2.AbstractFormatter2;
import org.eclipse.xtext.formatting2.FormatterPreferenceKeys;
import org.eclipse.xtext.formatting2.FormatterRequest;
import org.eclipse.xtext.formatting2.IFormattableDocument;
import org.eclipse.xtext.formatting2.IHiddenRegionFormatter;
import org.eclipse.xtext.formatting2.regionaccess.ISemanticRegion;
import org.eclipse.xtext.formatting2.regionaccess.internal.NodeSemanticRegion;
import org.eclipse.xtext.nodemodel.ICompositeNode;
import org.eclipse.xtext.nodemodel.ILeafNode;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;
import org.eclipse.xtext.preferences.BooleanKey;
import org.eclipse.xtext.preferences.ITypedPreferenceValues;
import org.eclipse.xtext.preferences.MapBasedPreferenceValues;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

@SuppressWarnings("all")
public class YangFormatter extends AbstractFormatter2 {
  @Inject
  @Extension
  private YangGrammarAccess _yangGrammarAccess;
  
  @Inject
  private IIndentationInformation indentationInformation;
  
  public static final BooleanKey FORCE_NEW_LINE = new BooleanKey("FORCE_NEW_LINE", Boolean.valueOf(true));
  
  @Override
  protected void initialize(final FormatterRequest request) {
    final ITypedPreferenceValues preferences = request.getPreferences();
    if ((preferences instanceof MapBasedPreferenceValues)) {
      ((MapBasedPreferenceValues)preferences).<String>put(FormatterPreferenceKeys.indentation, this.indentationInformation.getIndentString());
    }
    super.initialize(request);
  }
  
  protected void _format(final io.typefox.yang.yang.Module m, @Extension final IFormattableDocument it) {
    final Procedure1<IHiddenRegionFormatter> _function = (IHiddenRegionFormatter it_1) -> {
      it_1.oneSpace();
    };
    it.surround(this.textRegionExtensions.regionFor(m).assignment(this._yangGrammarAccess.getModuleAccess().getNameAssignment_1()), _function);
    this.formatStatement(it, m);
  }
  
  protected void _format(final YangVersion v, @Extension final IFormattableDocument it) {
    final Procedure1<IHiddenRegionFormatter> _function = (IHiddenRegionFormatter it_1) -> {
      it_1.oneSpace();
    };
    it.surround(this.textRegionExtensions.regionFor(v).assignment(this._yangGrammarAccess.getYangVersionAccess().getYangVersionAssignment_1()), _function);
    this.formatStatement(it, v);
  }
  
  protected void _format(final Namespace ns, @Extension final IFormattableDocument it) {
    final Procedure1<IHiddenRegionFormatter> _function = (IHiddenRegionFormatter it_1) -> {
      it_1.oneSpace();
    };
    it.surround(this.textRegionExtensions.regionFor(ns).assignment(this._yangGrammarAccess.getNamespaceAccess().getUriAssignment_1()), _function);
    this.formatStatement(it, ns);
  }
  
  protected void _format(final Prefix p, @Extension final IFormattableDocument it) {
    final Procedure1<IHiddenRegionFormatter> _function = (IHiddenRegionFormatter it_1) -> {
      it_1.oneSpace();
    };
    it.surround(this.textRegionExtensions.regionFor(p).assignment(this._yangGrammarAccess.getPrefixAccess().getPrefixAssignment_1()), _function);
    this.formatStatement(it, p);
  }
  
  protected void _format(final Organization o, @Extension final IFormattableDocument it) {
    this.formatMultilineString(it, o, this._yangGrammarAccess.getOrganizationAccess().getOrganizationAssignment_1());
    this.formatStatement(it, o);
  }
  
  protected void _format(final Description d, @Extension final IFormattableDocument it) {
    this.formatMultilineString(it, d, this._yangGrammarAccess.getDescriptionAccess().getDescriptionAssignment_1());
    this.formatStatement(it, d);
  }
  
  protected void _format(final Contact c, @Extension final IFormattableDocument it) {
    this.formatMultilineString(it, c, this._yangGrammarAccess.getContactAccess().getContactAssignment_1());
    this.formatStatement(it, c);
  }
  
  protected void _format(final Reference r, @Extension final IFormattableDocument it) {
    this.formatMultilineString(it, r, this._yangGrammarAccess.getReferenceAccess().getReferenceAssignment_1());
    this.formatStatement(it, r);
  }
  
  protected void _format(final Pattern p, @Extension final IFormattableDocument it) {
    this.formatMultilineString(it, p, this._yangGrammarAccess.getPatternAccess().getRegexpAssignment_1());
    this.formatStatement(it, p);
  }
  
  protected void _format(final ErrorMessage e, @Extension final IFormattableDocument it) {
    this.formatMultilineString(it, e, this._yangGrammarAccess.getErrorMessageAccess().getMessageAssignment_1());
    this.formatStatement(it, e);
  }
  
  protected void _format(final ErrorAppTag e, @Extension final IFormattableDocument it) {
    this.formatMultilineString(it, e, this._yangGrammarAccess.getErrorAppTagAccess().getTagAssignment_1());
    this.formatStatement(it, e);
  }
  
  protected void _format(final Presence p, @Extension final IFormattableDocument it) {
    this.formatMultilineString(it, p, this._yangGrammarAccess.getPresenceAccess().getDescriptionAssignment_1());
    this.formatStatement(it, p);
  }
  
  protected void _format(final Revision r, @Extension final IFormattableDocument it) {
    final Procedure1<IHiddenRegionFormatter> _function = (IHiddenRegionFormatter it_1) -> {
      it_1.oneSpace();
    };
    it.surround(this.textRegionExtensions.regionFor(r).assignment(this._yangGrammarAccess.getRevisionAccess().getRevisionAssignment_1()), _function);
    this.formatStatement(it, r);
  }
  
  protected void _format(final Typedef t, @Extension final IFormattableDocument it) {
    final Procedure1<IHiddenRegionFormatter> _function = (IHiddenRegionFormatter it_1) -> {
      it_1.oneSpace();
    };
    it.surround(this.textRegionExtensions.regionFor(t).assignment(this._yangGrammarAccess.getTypedefAccess().getNameAssignment_1()), _function);
    this.formatStatement(it, t);
  }
  
  protected void _format(final Type t, @Extension final IFormattableDocument it) {
    final TypeReference typeRef = t.getTypeRef();
    if ((typeRef != null)) {
      final Procedure1<IHiddenRegionFormatter> _function = (IHiddenRegionFormatter it_1) -> {
        it_1.oneSpace();
      };
      it.surround(this.textRegionExtensions.regionFor(typeRef).assignment(this._yangGrammarAccess.getTypeReferenceAccess().getTypeAssignment_1()), _function);
      final Procedure1<IHiddenRegionFormatter> _function_1 = (IHiddenRegionFormatter it_1) -> {
        it_1.oneSpace();
      };
      it.surround(this.textRegionExtensions.regionFor(typeRef).crossRef(this._yangGrammarAccess.getTypeReferenceAccess().getTypeTypedefCrossReference_1_0()), _function_1);
    }
    this.formatStatement(it, t);
  }
  
  protected void _format(final io.typefox.yang.yang.Enum e, @Extension final IFormattableDocument it) {
    final Procedure1<IHiddenRegionFormatter> _function = (IHiddenRegionFormatter it_1) -> {
      it_1.oneSpace();
    };
    it.surround(this.textRegionExtensions.regionFor(e).assignment(this._yangGrammarAccess.getEnumAccess().getNameAssignment_1()), _function);
    this.formatStatement(it, e);
  }
  
  protected void _format(final Value v, @Extension final IFormattableDocument it) {
    final Procedure1<IHiddenRegionFormatter> _function = (IHiddenRegionFormatter it_1) -> {
      it_1.oneSpace();
    };
    it.surround(this.textRegionExtensions.regionFor(v).assignment(this._yangGrammarAccess.getValueAccess().getOrdinalAssignment_1()), _function);
    this.formatStatement(it, v);
  }
  
  protected void _format(final Length l, @Extension final IFormattableDocument it) {
    this.formatRefinement(it, l.getExpression());
    this.formatStatement(it, l);
  }
  
  protected void _format(final Range r, @Extension final IFormattableDocument it) {
    this.formatRefinement(it, r.getExpression());
    this.formatStatement(it, r);
  }
  
  protected void _format(final Grouping g, @Extension final IFormattableDocument it) {
    final Procedure1<IHiddenRegionFormatter> _function = (IHiddenRegionFormatter it_1) -> {
      it_1.oneSpace();
    };
    it.surround(this.textRegionExtensions.regionFor(g).assignment(this._yangGrammarAccess.getGroupingAccess().getNameAssignment_1()), _function);
    this.formatStatement(it, g);
  }
  
  protected void _format(final Leaf l, @Extension final IFormattableDocument it) {
    final Procedure1<IHiddenRegionFormatter> _function = (IHiddenRegionFormatter it_1) -> {
      it_1.oneSpace();
    };
    it.surround(this.textRegionExtensions.regionFor(l).assignment(this._yangGrammarAccess.getLeafAccess().getNameAssignment_1()), _function);
    this.formatStatement(it, l);
  }
  
  protected void _format(final LeafList l, @Extension final IFormattableDocument it) {
    final Procedure1<IHiddenRegionFormatter> _function = (IHiddenRegionFormatter it_1) -> {
      it_1.oneSpace();
    };
    it.surround(this.textRegionExtensions.regionFor(l).assignment(this._yangGrammarAccess.getLeafListAccess().getNameAssignment_1()), _function);
    this.formatStatement(it, l);
  }
  
  protected void _format(final Augment a, @Extension final IFormattableDocument it) {
    this.formatIdentifier(it, a.getPath());
    this.formatStatement(it, a);
  }
  
  protected void _format(final When w, @Extension final IFormattableDocument it) {
    this.formatXpath(it, w.getCondition());
    this.formatStatement(it, w);
  }
  
  protected void _format(final Path p, @Extension final IFormattableDocument it) {
    this.formatXpath(it, p.getReference());
    this.formatStatement(it, p);
  }
  
  protected void _format(final Uses u, @Extension final IFormattableDocument it) {
    GroupingRef _grouping = u.getGrouping();
    boolean _tripleNotEquals = (_grouping != null);
    if (_tripleNotEquals) {
      final Procedure1<IHiddenRegionFormatter> _function = (IHiddenRegionFormatter it_1) -> {
        it_1.oneSpace();
      };
      it.surround(this.textRegionExtensions.regionFor(u.getGrouping()).crossRef(this._yangGrammarAccess.getGroupingRefAccess().getNodeGroupingCrossReference_0()), _function);
    }
    this.formatStatement(it, u);
  }
  
  protected void _format(final Container c, @Extension final IFormattableDocument it) {
    final Procedure1<IHiddenRegionFormatter> _function = (IHiddenRegionFormatter it_1) -> {
      it_1.oneSpace();
    };
    it.surround(this.textRegionExtensions.regionFor(c).assignment(this._yangGrammarAccess.getContainerAccess().getNameAssignment_1()), _function);
    this.formatStatement(it, c);
  }
  
  protected void _format(final Must m, @Extension final IFormattableDocument it) {
    this.formatXpath(it, m.getConstraint());
    this.formatStatement(it, m);
  }
  
  protected void _format(final Mandatory m, @Extension final IFormattableDocument it) {
    final Procedure1<IHiddenRegionFormatter> _function = (IHiddenRegionFormatter it_1) -> {
      it_1.oneSpace();
    };
    it.surround(this.textRegionExtensions.regionFor(m).assignment(this._yangGrammarAccess.getMandatoryAccess().getIsMandatoryAssignment_1()), _function);
    this.formatStatement(it, m);
  }
  
  protected void _format(final MinElements m, @Extension final IFormattableDocument it) {
    final Procedure1<IHiddenRegionFormatter> _function = (IHiddenRegionFormatter it_1) -> {
      it_1.oneSpace();
    };
    it.surround(this.textRegionExtensions.regionFor(m).assignment(this._yangGrammarAccess.getMinElementsAccess().getMinElementsAssignment_1()), _function);
    this.formatStatement(it, m);
  }
  
  protected void _format(final MaxElements m, @Extension final IFormattableDocument it) {
    final Procedure1<IHiddenRegionFormatter> _function = (IHiddenRegionFormatter it_1) -> {
      it_1.oneSpace();
    };
    it.surround(this.textRegionExtensions.regionFor(m).assignment(this._yangGrammarAccess.getMaxElementsAccess().getMaxElementsAssignment_1()), _function);
    this.formatStatement(it, m);
  }
  
  protected void _format(final OrderedBy o, @Extension final IFormattableDocument it) {
    final Procedure1<IHiddenRegionFormatter> _function = (IHiddenRegionFormatter it_1) -> {
      it_1.oneSpace();
    };
    it.surround(this.textRegionExtensions.regionFor(o).assignment(this._yangGrammarAccess.getOrderedByAccess().getOrderedByAssignment_1()), _function);
    this.formatStatement(it, o);
  }
  
  protected void _format(final List l, @Extension final IFormattableDocument it) {
    final Procedure1<IHiddenRegionFormatter> _function = (IHiddenRegionFormatter it_1) -> {
      it_1.oneSpace();
    };
    it.surround(this.textRegionExtensions.regionFor(l).assignment(this._yangGrammarAccess.getListAccess().getNameAssignment_1()), _function);
    this.formatStatement(it, l);
  }
  
  protected void _format(final Choice c, @Extension final IFormattableDocument it) {
    final Procedure1<IHiddenRegionFormatter> _function = (IHiddenRegionFormatter it_1) -> {
      it_1.oneSpace();
    };
    it.surround(this.textRegionExtensions.regionFor(c).assignment(this._yangGrammarAccess.getChoiceAccess().getNameAssignment_1()), _function);
    this.formatStatement(it, c);
  }
  
  protected void _format(final Case c, @Extension final IFormattableDocument it) {
    final Procedure1<IHiddenRegionFormatter> _function = (IHiddenRegionFormatter it_1) -> {
      it_1.oneSpace();
    };
    it.surround(this.textRegionExtensions.regionFor(c).assignment(this._yangGrammarAccess.getCaseAccess().getNameAssignment_1()), _function);
    this.formatStatement(it, c);
  }
  
  protected void _format(final Anydata a, @Extension final IFormattableDocument it) {
    final Procedure1<IHiddenRegionFormatter> _function = (IHiddenRegionFormatter it_1) -> {
      it_1.oneSpace();
    };
    it.surround(this.textRegionExtensions.regionFor(a).assignment(this._yangGrammarAccess.getAnydataAccess().getNameAssignment_1()), _function);
    this.formatStatement(it, a);
  }
  
  protected void _format(final Anyxml a, @Extension final IFormattableDocument it) {
    final Procedure1<IHiddenRegionFormatter> _function = (IHiddenRegionFormatter it_1) -> {
      it_1.oneSpace();
    };
    it.surround(this.textRegionExtensions.regionFor(a).assignment(this._yangGrammarAccess.getAnyxmlAccess().getNameAssignment_1()), _function);
    this.formatStatement(it, a);
  }
  
  protected void _format(final Refine r, @Extension final IFormattableDocument it) {
    this.formatIdentifier(it, r.getNode());
    this.formatStatement(it, r);
  }
  
  protected void _format(final Rpc r, @Extension final IFormattableDocument it) {
    final Procedure1<IHiddenRegionFormatter> _function = (IHiddenRegionFormatter it_1) -> {
      it_1.oneSpace();
    };
    it.surround(this.textRegionExtensions.regionFor(r).assignment(this._yangGrammarAccess.getRpcAccess().getNameAssignment_1()), _function);
    this.formatStatement(it, r);
  }
  
  protected void _format(final Input i, @Extension final IFormattableDocument it) {
    final Procedure1<IHiddenRegionFormatter> _function = (IHiddenRegionFormatter it_1) -> {
      it_1.oneSpace();
    };
    it.surround(this.textRegionExtensions.regionFor(i).assignment(this._yangGrammarAccess.getInputAccess().getNameAssignment_2()), _function);
    this.formatStatement(it, i);
  }
  
  protected void _format(final Output o, @Extension final IFormattableDocument it) {
    final Procedure1<IHiddenRegionFormatter> _function = (IHiddenRegionFormatter it_1) -> {
      it_1.oneSpace();
    };
    it.surround(this.textRegionExtensions.regionFor(o).assignment(this._yangGrammarAccess.getOutputAccess().getNameAssignment_2()), _function);
    this.formatStatement(it, o);
  }
  
  protected void _format(final Action a, @Extension final IFormattableDocument it) {
    final Procedure1<IHiddenRegionFormatter> _function = (IHiddenRegionFormatter it_1) -> {
      it_1.oneSpace();
    };
    it.surround(this.textRegionExtensions.regionFor(a).assignment(this._yangGrammarAccess.getActionAccess().getNameAssignment_1()), _function);
    this.formatStatement(it, a);
  }
  
  protected void _format(final Notification n, @Extension final IFormattableDocument it) {
    final Procedure1<IHiddenRegionFormatter> _function = (IHiddenRegionFormatter it_1) -> {
      it_1.oneSpace();
    };
    it.surround(this.textRegionExtensions.regionFor(n).assignment(this._yangGrammarAccess.getNotificationAccess().getNameAssignment_1()), _function);
    this.formatStatement(it, n);
  }
  
  protected void _format(final Identity i, @Extension final IFormattableDocument it) {
    final Procedure1<IHiddenRegionFormatter> _function = (IHiddenRegionFormatter it_1) -> {
      it_1.oneSpace();
    };
    it.surround(this.textRegionExtensions.regionFor(i).assignment(this._yangGrammarAccess.getIdentityAccess().getNameAssignment_1()), _function);
    this.formatStatement(it, i);
  }
  
  protected void _format(final Base b, @Extension final IFormattableDocument it) {
    final Procedure1<IHiddenRegionFormatter> _function = (IHiddenRegionFormatter it_1) -> {
      it_1.oneSpace();
    };
    it.surround(this.textRegionExtensions.regionFor(b).assignment(this._yangGrammarAccess.getBaseAccess().getReferenceAssignment_1()), _function);
    this.formatStatement(it, b);
  }
  
  protected void _format(final io.typefox.yang.yang.Extension e, @Extension final IFormattableDocument it) {
    final Procedure1<IHiddenRegionFormatter> _function = (IHiddenRegionFormatter it_1) -> {
      it_1.oneSpace();
    };
    it.surround(this.textRegionExtensions.regionFor(e).assignment(this._yangGrammarAccess.getExtensionAccess().getNameAssignment_1()), _function);
    this.formatStatement(it, e);
  }
  
  protected void _format(final Argument a, @Extension final IFormattableDocument it) {
    final Procedure1<IHiddenRegionFormatter> _function = (IHiddenRegionFormatter it_1) -> {
      it_1.oneSpace();
    };
    it.surround(this.textRegionExtensions.regionFor(a).assignment(this._yangGrammarAccess.getArgumentAccess().getNameAssignment_1()), _function);
    this.formatStatement(it, a);
  }
  
  protected void _format(final YinElement y, @Extension final IFormattableDocument it) {
    final Procedure1<IHiddenRegionFormatter> _function = (IHiddenRegionFormatter it_1) -> {
      it_1.oneSpace();
    };
    it.surround(this.textRegionExtensions.regionFor(y).assignment(this._yangGrammarAccess.getYinElementAccess().getIsYinElementAssignment_1()), _function);
    this.formatStatement(it, y);
  }
  
  protected void _format(final Feature f, @Extension final IFormattableDocument it) {
    final Procedure1<IHiddenRegionFormatter> _function = (IHiddenRegionFormatter it_1) -> {
      it_1.oneSpace();
    };
    it.surround(this.textRegionExtensions.regionFor(f).assignment(this._yangGrammarAccess.getFeatureAccess().getNameAssignment_1()), _function);
    this.formatStatement(it, f);
  }
  
  protected void _format(final Deviate d, @Extension final IFormattableDocument it) {
    final Procedure1<IHiddenRegionFormatter> _function = (IHiddenRegionFormatter it_1) -> {
      it_1.oneSpace();
    };
    it.surround(this.textRegionExtensions.regionFor(d).assignment(this._yangGrammarAccess.getDeviateAccess().getArgumentAssignment_1()), _function);
    this.formatStatement(it, d);
  }
  
  protected void _format(final Deviation d, @Extension final IFormattableDocument it) {
    this.formatIdentifier(it, d.getReference());
    this.formatStatement(it, d);
  }
  
  protected void _format(final Config c, @Extension final IFormattableDocument it) {
    final Procedure1<IHiddenRegionFormatter> _function = (IHiddenRegionFormatter it_1) -> {
      it_1.oneSpace();
    };
    it.surround(this.textRegionExtensions.regionFor(c).assignment(this._yangGrammarAccess.getConfigAccess().getIsConfigAssignment_1()), _function);
    this.formatStatement(it, c);
  }
  
  protected void _format(final Status s, @Extension final IFormattableDocument it) {
    final Procedure1<IHiddenRegionFormatter> _function = (IHiddenRegionFormatter it_1) -> {
      it_1.oneSpace();
    };
    it.surround(this.textRegionExtensions.regionFor(s).assignment(this._yangGrammarAccess.getStatusAccess().getArgumentAssignment_1()), _function);
    this.formatStatement(it, s);
  }
  
  protected void _format(final FractionDigits s, @Extension final IFormattableDocument it) {
    final Procedure1<IHiddenRegionFormatter> _function = (IHiddenRegionFormatter it_1) -> {
      it_1.oneSpace();
    };
    it.surround(this.textRegionExtensions.regionFor(s).assignment(this._yangGrammarAccess.getFractionDigitsAccess().getRangeAssignment_1()), _function);
    this.formatStatement(it, s);
  }
  
  protected void _format(final Modifier s, @Extension final IFormattableDocument it) {
    final Procedure1<IHiddenRegionFormatter> _function = (IHiddenRegionFormatter it_1) -> {
      it_1.oneSpace();
    };
    it.surround(this.textRegionExtensions.regionFor(s).assignment(this._yangGrammarAccess.getModifierAccess().getModifierAssignment_1()), _function);
    this.formatStatement(it, s);
  }
  
  protected void _format(final Bit s, @Extension final IFormattableDocument it) {
    final Procedure1<IHiddenRegionFormatter> _function = (IHiddenRegionFormatter it_1) -> {
      it_1.oneSpace();
    };
    it.surround(this.textRegionExtensions.regionFor(s).assignment(this._yangGrammarAccess.getBitAccess().getNameAssignment_1()), _function);
    this.formatStatement(it, s);
  }
  
  protected void _format(final Position s, @Extension final IFormattableDocument it) {
    final Procedure1<IHiddenRegionFormatter> _function = (IHiddenRegionFormatter it_1) -> {
      it_1.oneSpace();
    };
    it.surround(this.textRegionExtensions.regionFor(s).assignment(this._yangGrammarAccess.getPositionAccess().getOrdinalAssignment_1()), _function);
    this.formatStatement(it, s);
  }
  
  protected void _format(final RequireInstance s, @Extension final IFormattableDocument it) {
    final Procedure1<IHiddenRegionFormatter> _function = (IHiddenRegionFormatter it_1) -> {
      it_1.oneSpace();
    };
    it.surround(this.textRegionExtensions.regionFor(s).assignment(this._yangGrammarAccess.getRequireInstanceAccess().getIsRequireInstanceAssignment_1()), _function);
    this.formatStatement(it, s);
  }
  
  protected void _format(final Import s, @Extension final IFormattableDocument it) {
    final Procedure1<IHiddenRegionFormatter> _function = (IHiddenRegionFormatter it_1) -> {
      it_1.oneSpace();
    };
    it.surround(this.textRegionExtensions.regionFor(s).assignment(this._yangGrammarAccess.getImportAccess().getModuleAssignment_1()), _function);
    this.formatStatement(it, s);
  }
  
  protected void _format(final RevisionDate s, @Extension final IFormattableDocument it) {
    final Procedure1<IHiddenRegionFormatter> _function = (IHiddenRegionFormatter it_1) -> {
      it_1.oneSpace();
    };
    it.surround(this.textRegionExtensions.regionFor(s).assignment(this._yangGrammarAccess.getRevisionDateAccess().getDateAssignment_1()), _function);
    this.formatStatement(it, s);
  }
  
  protected void _format(final Include s, @Extension final IFormattableDocument it) {
    final Procedure1<IHiddenRegionFormatter> _function = (IHiddenRegionFormatter it_1) -> {
      it_1.oneSpace();
    };
    it.surround(this.textRegionExtensions.regionFor(s).assignment(this._yangGrammarAccess.getIncludeAccess().getModuleAssignment_1()), _function);
    this.formatStatement(it, s);
  }
  
  protected void _format(final Submodule s, @Extension final IFormattableDocument it) {
    final Procedure1<IHiddenRegionFormatter> _function = (IHiddenRegionFormatter it_1) -> {
      it_1.oneSpace();
    };
    it.surround(this.textRegionExtensions.regionFor(s).assignment(this._yangGrammarAccess.getSubmoduleAccess().getNameAssignment_1()), _function);
    this.formatStatement(it, s);
  }
  
  protected void _format(final BelongsTo s, @Extension final IFormattableDocument it) {
    final Procedure1<IHiddenRegionFormatter> _function = (IHiddenRegionFormatter it_1) -> {
      it_1.oneSpace();
    };
    it.surround(this.textRegionExtensions.regionFor(s).assignment(this._yangGrammarAccess.getBelongsToAccess().getModuleAssignment_1()), _function);
    this.formatStatement(it, s);
  }
  
  protected void _format(final Units s, @Extension final IFormattableDocument it) {
    final Procedure1<IHiddenRegionFormatter> _function = (IHiddenRegionFormatter it_1) -> {
      it_1.oneSpace();
    };
    it.surround(this.textRegionExtensions.regionFor(s).assignment(this._yangGrammarAccess.getUnitsAccess().getDefinitionAssignment_1()), _function);
    this.formatStatement(it, s);
  }
  
  protected void _format(final Default s, @Extension final IFormattableDocument it) {
    final Procedure1<IHiddenRegionFormatter> _function = (IHiddenRegionFormatter it_1) -> {
      it_1.oneSpace();
    };
    it.surround(this.textRegionExtensions.regionFor(s).assignment(this._yangGrammarAccess.getDefaultAccess().getDefaultStringValueAssignment_1()), _function);
    this.formatStatement(it, s);
  }
  
  protected void _format(final Unique u, @Extension final IFormattableDocument it) {
    EList<SchemaNodeIdentifier> _references = u.getReferences();
    for (final SchemaNodeIdentifier reference : _references) {
      this.formatIdentifier(it, reference);
    }
    this.formatStatement(it, u);
  }
  
  protected void _format(final Key k, @Extension final IFormattableDocument it) {
    final Consumer<ISemanticRegion> _function = (ISemanticRegion it_1) -> {
      final Procedure1<IHiddenRegionFormatter> _function_1 = (IHiddenRegionFormatter it_2) -> {
        it_2.noSpace();
      };
      it.append(it_1, _function_1);
    };
    this.textRegionExtensions.semanticRegions(IterableExtensions.<KeyReference>last(k.getReferences())).forEach(_function);
    this.formatStatement(it, k);
  }
  
  protected void _format(final IfFeature i, @Extension final IFormattableDocument it) {
    this.formatStatement(it, i);
  }
  
  protected void _format(final Unknown u, @Extension final IFormattableDocument it) {
    ISemanticRegion _xifexpression = null;
    String _name = u.getName();
    boolean _tripleNotEquals = (_name != null);
    if (_tripleNotEquals) {
      _xifexpression = this.textRegionExtensions.regionFor(u).assignment(this._yangGrammarAccess.getUnknownAccess().getNameAssignment_1());
    } else {
      _xifexpression = this.textRegionExtensions.regionFor(u).assignment(this._yangGrammarAccess.getUnknownAccess().getExtensionAssignment_0());
    }
    final ISemanticRegion lastRegion = _xifexpression;
    if ((lastRegion != null)) {
      final ISemanticRegion nextSemanticRegion = lastRegion.getNextSemanticRegion();
      TerminalRule _hIDDENRule = this._yangGrammarAccess.getHIDDENRule();
      EObject _grammarElement = nextSemanticRegion.getGrammarElement();
      boolean _equals = Objects.equal(_hIDDENRule, _grammarElement);
      if (_equals) {
        final Procedure1<IHiddenRegionFormatter> _function = (IHiddenRegionFormatter it_1) -> {
          it_1.noSpace();
        };
        final Procedure1<IHiddenRegionFormatter> _function_1 = (IHiddenRegionFormatter it_1) -> {
          it_1.oneSpace();
        };
        it.append(it.prepend(nextSemanticRegion, _function), _function_1);
      } else {
        final Procedure1<IHiddenRegionFormatter> _function_2 = (IHiddenRegionFormatter it_1) -> {
          it_1.oneSpace();
        };
        it.append(lastRegion, _function_2);
      }
    }
    this.formatStatement(it, u);
  }
  
  protected void formatMultilineString(@Extension final IFormattableDocument document, final Statement s, final Assignment a) {
    final ISemanticRegion region = this.textRegionExtensions.regionFor(s).assignment(a);
    if ((region instanceof NodeSemanticRegion)) {
      int trailingLinesIndent = 0;
      Boolean _preference = this.getPreferences().<Boolean>getPreference(YangFormatter.FORCE_NEW_LINE);
      if ((_preference).booleanValue()) {
        final Procedure1<IHiddenRegionFormatter> _function = (IHiddenRegionFormatter it) -> {
          it.newLine();
        };
        document.prepend(region, _function);
      } else {
        final Procedure1<IHiddenRegionFormatter> _function_1 = (IHiddenRegionFormatter it) -> {
          it.oneSpace();
        };
        document.prepend(region, _function_1);
        final String keyword = this.findFirstKeyword(s);
        trailingLinesIndent = keyword.length();
      }
      MultilineStringReplacer _multilineStringReplacer = new MultilineStringReplacer(this._yangGrammarAccess, ((NodeSemanticRegion)region), trailingLinesIndent);
      document.addReplacer(_multilineStringReplacer);
    }
  }
  
  protected String findFirstKeyword(final Statement statement) {
    final ICompositeNode node = NodeModelUtils.findActualNodeFor(statement);
    String _elvis = null;
    final Function1<ILeafNode, Boolean> _function = (ILeafNode it) -> {
      EObject _grammarElement = it.getGrammarElement();
      return Boolean.valueOf((_grammarElement instanceof Keyword));
    };
    ILeafNode _findFirst = IterableExtensions.<ILeafNode>findFirst(node.getLeafNodes(), _function);
    String _text = null;
    if (_findFirst!=null) {
      _text=_findFirst.getText();
    }
    if (_text != null) {
      _elvis = _text;
    } else {
      _elvis = "";
    }
    return _elvis;
  }
  
  protected void formatStatement(@Extension final IFormattableDocument document, final Statement it) {
    final Procedure1<IHiddenRegionFormatter> _function = (IHiddenRegionFormatter it_1) -> {
      it_1.noSpace();
      it_1.highPriority();
    };
    document.prepend(this.textRegionExtensions.regionFor(it).keyword(this._yangGrammarAccess.getStatementEndAccess().getSemicolonKeyword_1()), _function);
    final ISemanticRegion leftCurly = this.textRegionExtensions.regionFor(it).keyword(this._yangGrammarAccess.getStatementEndAccess().getLeftCurlyBracketKeyword_0_0());
    final ISemanticRegion rightCurly = this.textRegionExtensions.regionFor(it).keyword(this._yangGrammarAccess.getStatementEndAccess().getRightCurlyBracketKeyword_0_2());
    final Procedure1<IHiddenRegionFormatter> _function_1 = (IHiddenRegionFormatter it_1) -> {
      it_1.newLine();
    };
    final Procedure1<IHiddenRegionFormatter> _function_2 = (IHiddenRegionFormatter it_1) -> {
      it_1.indent();
    };
    document.<ISemanticRegion, ISemanticRegion>interior(leftCurly, 
      document.prepend(rightCurly, _function_1), _function_2);
    final Consumer<Statement> _function_3 = (Statement it_1) -> {
      final Procedure1<IHiddenRegionFormatter> _function_4 = (IHiddenRegionFormatter it_2) -> {
        it_2.setNewLines(1, 1, 2);
      };
      document.<Statement>prepend(it_1, _function_4);
      document.<Statement>format(it_1);
    };
    it.getSubstatements().forEach(_function_3);
  }
  
  protected void formatIdentifier(@Extension final IFormattableDocument document, final SchemaNodeIdentifier id) {
    if ((id == null)) {
      return;
    }
    final java.util.List<ISemanticRegion> nodeRegions = IterableExtensions.<ISemanticRegion>toList(this.textRegionExtensions.allSemanticRegions(id));
    final Procedure1<IHiddenRegionFormatter> _function = (IHiddenRegionFormatter it) -> {
      it.oneSpace();
    };
    document.prepend(IterableExtensions.<ISemanticRegion>head(nodeRegions), _function);
    final Consumer<ISemanticRegion> _function_1 = (ISemanticRegion it) -> {
      final Procedure1<IHiddenRegionFormatter> _function_2 = (IHiddenRegionFormatter it_1) -> {
        it_1.noSpace();
      };
      document.prepend(it, _function_2);
    };
    IterableExtensions.<ISemanticRegion>tail(nodeRegions).forEach(_function_1);
    final ISemanticRegion nextSemanticRegion = IterableExtensions.<ISemanticRegion>last(nodeRegions).getNextSemanticRegion();
    TerminalRule _hIDDENRule = this._yangGrammarAccess.getHIDDENRule();
    EObject _grammarElement = nextSemanticRegion.getGrammarElement();
    boolean _equals = Objects.equal(_hIDDENRule, _grammarElement);
    if (_equals) {
      final Procedure1<IHiddenRegionFormatter> _function_2 = (IHiddenRegionFormatter it) -> {
        it.noSpace();
      };
      final Procedure1<IHiddenRegionFormatter> _function_3 = (IHiddenRegionFormatter it) -> {
        it.oneSpace();
      };
      document.append(document.prepend(nextSemanticRegion, _function_2), _function_3);
    } else {
      final Procedure1<IHiddenRegionFormatter> _function_4 = (IHiddenRegionFormatter it) -> {
        it.oneSpace();
      };
      document.append(IterableExtensions.<ISemanticRegion>last(nodeRegions), _function_4);
    }
  }
  
  protected ISemanticRegion formatXpath(@Extension final IFormattableDocument document, final XpathExpression expression) {
    ISemanticRegion _xblockexpression = null;
    {
      final java.util.List<ISemanticRegion> nodeRegions = IterableExtensions.<ISemanticRegion>toList(this.textRegionExtensions.allSemanticRegions(expression));
      final Procedure1<IHiddenRegionFormatter> _function = (IHiddenRegionFormatter it) -> {
        it.oneSpace();
      };
      document.prepend(IterableExtensions.<ISemanticRegion>head(nodeRegions), _function);
      final Function1<ISemanticRegion, Boolean> _function_1 = (ISemanticRegion it) -> {
        return Boolean.valueOf((Objects.equal(it.getGrammarElement(), this._yangGrammarAccess.getHIDDENRule()) && ((it.getSemanticElement() instanceof XpathLocation) || (it.getSemanticElement() instanceof XpathNameTest))));
      };
      final Consumer<ISemanticRegion> _function_2 = (ISemanticRegion it) -> {
        final Procedure1<IHiddenRegionFormatter> _function_3 = (IHiddenRegionFormatter it_1) -> {
          it_1.noSpace();
        };
        document.prepend(it, _function_3);
      };
      IterableExtensions.<ISemanticRegion>filter(IterableExtensions.<ISemanticRegion>tail(nodeRegions), _function_1).forEach(_function_2);
      final ISemanticRegion nextSemanticRegion = IterableExtensions.<ISemanticRegion>last(nodeRegions).getNextSemanticRegion();
      ISemanticRegion _xifexpression = null;
      TerminalRule _hIDDENRule = this._yangGrammarAccess.getHIDDENRule();
      EObject _grammarElement = nextSemanticRegion.getGrammarElement();
      boolean _equals = Objects.equal(_hIDDENRule, _grammarElement);
      if (_equals) {
        final Procedure1<IHiddenRegionFormatter> _function_3 = (IHiddenRegionFormatter it) -> {
          it.noSpace();
        };
        final Procedure1<IHiddenRegionFormatter> _function_4 = (IHiddenRegionFormatter it) -> {
          it.oneSpace();
        };
        _xifexpression = document.append(document.prepend(nextSemanticRegion, _function_3), _function_4);
      } else {
        final Procedure1<IHiddenRegionFormatter> _function_5 = (IHiddenRegionFormatter it) -> {
          it.oneSpace();
        };
        _xifexpression = document.append(IterableExtensions.<ISemanticRegion>last(nodeRegions), _function_5);
      }
      _xblockexpression = _xifexpression;
    }
    return _xblockexpression;
  }
  
  protected ISemanticRegion formatRefinement(@Extension final IFormattableDocument document, final Expression expression) {
    ISemanticRegion _xblockexpression = null;
    {
      final java.util.List<ISemanticRegion> nodeRegions = IterableExtensions.<ISemanticRegion>toList(this.textRegionExtensions.allSemanticRegions(expression));
      final Procedure1<IHiddenRegionFormatter> _function = (IHiddenRegionFormatter it) -> {
        it.oneSpace();
      };
      document.prepend(IterableExtensions.<ISemanticRegion>head(nodeRegions), _function);
      final ISemanticRegion nextSemanticRegion = IterableExtensions.<ISemanticRegion>last(nodeRegions).getNextSemanticRegion();
      ISemanticRegion _xifexpression = null;
      TerminalRule _hIDDENRule = this._yangGrammarAccess.getHIDDENRule();
      EObject _grammarElement = nextSemanticRegion.getGrammarElement();
      boolean _equals = Objects.equal(_hIDDENRule, _grammarElement);
      if (_equals) {
        final Procedure1<IHiddenRegionFormatter> _function_1 = (IHiddenRegionFormatter it) -> {
          it.noSpace();
        };
        final Procedure1<IHiddenRegionFormatter> _function_2 = (IHiddenRegionFormatter it) -> {
          it.oneSpace();
        };
        _xifexpression = document.append(document.prepend(nextSemanticRegion, _function_1), _function_2);
      } else {
        final Procedure1<IHiddenRegionFormatter> _function_3 = (IHiddenRegionFormatter it) -> {
          it.oneSpace();
        };
        _xifexpression = document.append(IterableExtensions.<ISemanticRegion>last(nodeRegions), _function_3);
      }
      _xblockexpression = _xifexpression;
    }
    return _xblockexpression;
  }
  
  public void format(final Object a, final IFormattableDocument it) {
    if (a instanceof Anydata) {
      _format((Anydata)a, it);
      return;
    } else if (a instanceof Anyxml) {
      _format((Anyxml)a, it);
      return;
    } else if (a instanceof Bit) {
      _format((Bit)a, it);
      return;
    } else if (a instanceof Case) {
      _format((Case)a, it);
      return;
    } else if (a instanceof Choice) {
      _format((Choice)a, it);
      return;
    } else if (a instanceof Container) {
      _format((Container)a, it);
      return;
    } else if (a instanceof io.typefox.yang.yang.Enum) {
      _format((io.typefox.yang.yang.Enum)a, it);
      return;
    } else if (a instanceof Import) {
      _format((Import)a, it);
      return;
    } else if (a instanceof Include) {
      _format((Include)a, it);
      return;
    } else if (a instanceof Leaf) {
      _format((Leaf)a, it);
      return;
    } else if (a instanceof LeafList) {
      _format((LeafList)a, it);
      return;
    } else if (a instanceof Length) {
      _format((Length)a, it);
      return;
    } else if (a instanceof List) {
      _format((List)a, it);
      return;
    } else if (a instanceof io.typefox.yang.yang.Module) {
      _format((io.typefox.yang.yang.Module)a, it);
      return;
    } else if (a instanceof Position) {
      _format((Position)a, it);
      return;
    } else if (a instanceof Range) {
      _format((Range)a, it);
      return;
    } else if (a instanceof Submodule) {
      _format((Submodule)a, it);
      return;
    } else if (a instanceof Value) {
      _format((Value)a, it);
      return;
    } else if (a instanceof Action) {
      _format((Action)a, it);
      return;
    } else if (a instanceof Argument) {
      _format((Argument)a, it);
      return;
    } else if (a instanceof Augment) {
      _format((Augment)a, it);
      return;
    } else if (a instanceof Base) {
      _format((Base)a, it);
      return;
    } else if (a instanceof BelongsTo) {
      _format((BelongsTo)a, it);
      return;
    } else if (a instanceof Config) {
      _format((Config)a, it);
      return;
    } else if (a instanceof Contact) {
      _format((Contact)a, it);
      return;
    } else if (a instanceof Default) {
      _format((Default)a, it);
      return;
    } else if (a instanceof Description) {
      _format((Description)a, it);
      return;
    } else if (a instanceof Deviate) {
      _format((Deviate)a, it);
      return;
    } else if (a instanceof Deviation) {
      _format((Deviation)a, it);
      return;
    } else if (a instanceof ErrorAppTag) {
      _format((ErrorAppTag)a, it);
      return;
    } else if (a instanceof ErrorMessage) {
      _format((ErrorMessage)a, it);
      return;
    } else if (a instanceof io.typefox.yang.yang.Extension) {
      _format((io.typefox.yang.yang.Extension)a, it);
      return;
    } else if (a instanceof Feature) {
      _format((Feature)a, it);
      return;
    } else if (a instanceof FractionDigits) {
      _format((FractionDigits)a, it);
      return;
    } else if (a instanceof Grouping) {
      _format((Grouping)a, it);
      return;
    } else if (a instanceof Identity) {
      _format((Identity)a, it);
      return;
    } else if (a instanceof IfFeature) {
      _format((IfFeature)a, it);
      return;
    } else if (a instanceof Input) {
      _format((Input)a, it);
      return;
    } else if (a instanceof Key) {
      _format((Key)a, it);
      return;
    } else if (a instanceof Mandatory) {
      _format((Mandatory)a, it);
      return;
    } else if (a instanceof MaxElements) {
      _format((MaxElements)a, it);
      return;
    } else if (a instanceof MinElements) {
      _format((MinElements)a, it);
      return;
    } else if (a instanceof Modifier) {
      _format((Modifier)a, it);
      return;
    } else if (a instanceof Must) {
      _format((Must)a, it);
      return;
    } else if (a instanceof Namespace) {
      _format((Namespace)a, it);
      return;
    } else if (a instanceof Notification) {
      _format((Notification)a, it);
      return;
    } else if (a instanceof OrderedBy) {
      _format((OrderedBy)a, it);
      return;
    } else if (a instanceof Organization) {
      _format((Organization)a, it);
      return;
    } else if (a instanceof Output) {
      _format((Output)a, it);
      return;
    } else if (a instanceof Path) {
      _format((Path)a, it);
      return;
    } else if (a instanceof Pattern) {
      _format((Pattern)a, it);
      return;
    } else if (a instanceof Prefix) {
      _format((Prefix)a, it);
      return;
    } else if (a instanceof Presence) {
      _format((Presence)a, it);
      return;
    } else if (a instanceof Reference) {
      _format((Reference)a, it);
      return;
    } else if (a instanceof Refine) {
      _format((Refine)a, it);
      return;
    } else if (a instanceof RequireInstance) {
      _format((RequireInstance)a, it);
      return;
    } else if (a instanceof Revision) {
      _format((Revision)a, it);
      return;
    } else if (a instanceof RevisionDate) {
      _format((RevisionDate)a, it);
      return;
    } else if (a instanceof Rpc) {
      _format((Rpc)a, it);
      return;
    } else if (a instanceof Status) {
      _format((Status)a, it);
      return;
    } else if (a instanceof Type) {
      _format((Type)a, it);
      return;
    } else if (a instanceof Typedef) {
      _format((Typedef)a, it);
      return;
    } else if (a instanceof Unique) {
      _format((Unique)a, it);
      return;
    } else if (a instanceof Units) {
      _format((Units)a, it);
      return;
    } else if (a instanceof Unknown) {
      _format((Unknown)a, it);
      return;
    } else if (a instanceof Uses) {
      _format((Uses)a, it);
      return;
    } else if (a instanceof When) {
      _format((When)a, it);
      return;
    } else if (a instanceof YangVersion) {
      _format((YangVersion)a, it);
      return;
    } else if (a instanceof YinElement) {
      _format((YinElement)a, it);
      return;
    } else if (a instanceof XtextResource) {
      _format((XtextResource)a, it);
      return;
    } else if (a instanceof EObject) {
      _format((EObject)a, it);
      return;
    } else if (a == null) {
      _format((Void)null, it);
      return;
    } else if (a != null) {
      _format(a, it);
      return;
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(a, it).toString());
    }
  }
}

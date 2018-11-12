package io.typefox.yang.ide.completion;

import com.google.common.base.Preconditions;
import com.google.common.base.Splitter;
import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimap;
import com.google.common.collect.Multimaps;
import com.google.inject.Singleton;
import io.typefox.yang.ide.completion.ContentAssistEntryUtils;
import io.typefox.yang.utils.YangDateUtils;
import io.typefox.yang.utils.YangNameUtils;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import org.eclipse.xtend.lib.annotations.AccessorType;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtend.lib.annotations.EqualsHashCode;
import org.eclipse.xtend.lib.annotations.ToString;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.ide.editor.contentassist.ContentAssistEntry;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.eclipse.xtext.xbase.lib.Pure;
import org.eclipse.xtext.xbase.lib.util.ToStringBuilder;

/**
 * Template provider for YANG.
 * 
 * <p>
 * The template text complies the LSP's <a href="https://github.com/Microsoft/language-server-protocol/blob/master/protocol.md#completion-request">snippet template syntax</a>.
 * The grammar for the template syntax is available <a href="https://github.com/Microsoft/vscode/blob/master/src/vs/editor/contrib/snippet/browser/snippet.md#grammar">here</a>.
 * 
 * @author akos.kitta
 */
@Singleton
@SuppressWarnings("all")
public class YangTemplateProvider {
  /**
   * Bare minimum representation of a template.
   * <p>
   * The templates uses two spaces {@code /\s\s/} as indentations at the definition-site.
   */
  @EqualsHashCode
  @Accessors(AccessorType.PACKAGE_GETTER)
  @ToString(skipNulls = true)
  static class Template {
    private String template;
    
    private String label;
    
    private String documentation;
    
    private String description;
    
    Template() {
    }
    
    Template(final String label) {
      this.label = Preconditions.<String>checkNotNull(label, "label");
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("Creates a new \"");
      _builder.append(label);
      _builder.append("\" statement.");
      this.description = _builder.toString();
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
      YangTemplateProvider.Template other = (YangTemplateProvider.Template) obj;
      if (this.template == null) {
        if (other.template != null)
          return false;
      } else if (!this.template.equals(other.template))
        return false;
      if (this.label == null) {
        if (other.label != null)
          return false;
      } else if (!this.label.equals(other.label))
        return false;
      if (this.documentation == null) {
        if (other.documentation != null)
          return false;
      } else if (!this.documentation.equals(other.documentation))
        return false;
      if (this.description == null) {
        if (other.description != null)
          return false;
      } else if (!this.description.equals(other.description))
        return false;
      return true;
    }
    
    @Override
    @Pure
    public int hashCode() {
      final int prime = 31;
      int result = 1;
      result = prime * result + ((this.template== null) ? 0 : this.template.hashCode());
      result = prime * result + ((this.label== null) ? 0 : this.label.hashCode());
      result = prime * result + ((this.documentation== null) ? 0 : this.documentation.hashCode());
      return prime * result + ((this.description== null) ? 0 : this.description.hashCode());
    }
    
    @Pure
    String getTemplate() {
      return this.template;
    }
    
    @Pure
    String getLabel() {
      return this.label;
    }
    
    @Pure
    String getDocumentation() {
      return this.documentation;
    }
    
    @Pure
    String getDescription() {
      return this.description;
    }
    
    @Override
    @Pure
    public String toString() {
      ToStringBuilder b = new ToStringBuilder(this);
      b.skipNulls();
      b.add("template", this.template);
      b.add("label", this.label);
      b.add("documentation", this.documentation);
      b.add("description", this.description);
      return b.toString();
    }
  }
  
  /**
   * All the available YANG templates.
   */
  static class YangTemplates {
    private static Multimap<String, Function1<? super ContentAssistEntry, ? extends YangTemplateProvider.Template>> register(final Multimap<String, Function1<? super ContentAssistEntry, ? extends YangTemplateProvider.Template>> map, final String key, final Function1<? super ContentAssistEntry, ? extends YangTemplateProvider.Template> it) {
      map.put(key, it);
      return map;
    }
    
    private static final Multimap<String, Function1<? super ContentAssistEntry, ? extends YangTemplateProvider.Template>> ALL_TEMPLATES = Multimaps.<String, Function1<? super ContentAssistEntry, ? extends YangTemplateProvider.Template>>unmodifiableMultimap(YangTemplateProvider.YangTemplates.register(YangTemplateProvider.YangTemplates.register(YangTemplateProvider.YangTemplates.register(YangTemplateProvider.YangTemplates.register(YangTemplateProvider.YangTemplates.register(YangTemplateProvider.YangTemplates.register(YangTemplateProvider.YangTemplates.register(YangTemplateProvider.YangTemplates.register(YangTemplateProvider.YangTemplates.register(YangTemplateProvider.YangTemplates.register(YangTemplateProvider.YangTemplates.register(YangTemplateProvider.YangTemplates.register(YangTemplateProvider.YangTemplates.register(YangTemplateProvider.YangTemplates.register(YangTemplateProvider.YangTemplates.register(YangTemplateProvider.YangTemplates.register(YangTemplateProvider.YangTemplates.register(YangTemplateProvider.YangTemplates.register(YangTemplateProvider.YangTemplates.register(YangTemplateProvider.YangTemplates.register(YangTemplateProvider.YangTemplates.register(YangTemplateProvider.YangTemplates.register(YangTemplateProvider.YangTemplates.register(YangTemplateProvider.YangTemplates.register(YangTemplateProvider.YangTemplates.register(YangTemplateProvider.YangTemplates.register(YangTemplateProvider.YangTemplates.register(YangTemplateProvider.YangTemplates.register(YangTemplateProvider.YangTemplates.register(YangTemplateProvider.YangTemplates.register(YangTemplateProvider.YangTemplates.register(YangTemplateProvider.YangTemplates.register(YangTemplateProvider.YangTemplates.register(YangTemplateProvider.YangTemplates.register(YangTemplateProvider.YangTemplates.register(YangTemplateProvider.YangTemplates.register(YangTemplateProvider.YangTemplates.register(YangTemplateProvider.YangTemplates.register(YangTemplateProvider.YangTemplates.register(YangTemplateProvider.YangTemplates.register(YangTemplateProvider.YangTemplates.register(YangTemplateProvider.YangTemplates.register(YangTemplateProvider.YangTemplates.register(YangTemplateProvider.YangTemplates.register(YangTemplateProvider.YangTemplates.register(YangTemplateProvider.YangTemplates.register(YangTemplateProvider.YangTemplates.register(YangTemplateProvider.YangTemplates.register(YangTemplateProvider.YangTemplates.register(YangTemplateProvider.YangTemplates.register(YangTemplateProvider.YangTemplates.register(YangTemplateProvider.YangTemplates.register(YangTemplateProvider.YangTemplates.register(YangTemplateProvider.YangTemplates.register(YangTemplateProvider.YangTemplates.register(YangTemplateProvider.YangTemplates.register(HashMultimap.<String, Function1<? super ContentAssistEntry, ? extends YangTemplateProvider.Template>>create(), "module", ((Function1<ContentAssistEntry, YangTemplateProvider.Template>) (ContentAssistEntry it) -> {
      YangTemplateProvider.Template _xblockexpression = null;
      {
        String _elvis = null;
        String _escapeModuleName = YangNameUtils.escapeModuleName(ContentAssistEntryUtils.getResourceName(it));
        if (_escapeModuleName != null) {
          _elvis = _escapeModuleName;
        } else {
          _elvis = "module-name";
        }
        final String moduleName = _elvis;
        YangTemplateProvider.Template _template = new YangTemplateProvider.Template("module");
        final Procedure1<YangTemplateProvider.Template> _function = (YangTemplateProvider.Template it_1) -> {
          StringConcatenation _builder = new StringConcatenation();
          _builder.append("module ${1:");
          _builder.append(moduleName);
          _builder.append("} {");
          _builder.newLineIfNotEmpty();
          _builder.append("  ");
          _builder.append("yang-version 1.1;");
          _builder.newLine();
          _builder.append("  ");
          _builder.append("namespace urn:ietf:params:xml:ns:yang:${1:");
          _builder.append(moduleName, "  ");
          _builder.append("};");
          _builder.newLineIfNotEmpty();
          _builder.append("  ");
          _builder.append("prefix ${1:");
          _builder.append(moduleName, "  ");
          _builder.append("};");
          _builder.newLineIfNotEmpty();
          _builder.newLine();
          _builder.append("  ");
          _builder.append("$0");
          _builder.newLine();
          _builder.append("}");
          _builder.newLine();
          it_1.template = _builder.toString();
          StringConcatenation _builder_1 = new StringConcatenation();
          _builder_1.append("The \"module\" statement defines the module\'s name and groups all statements that belong to the module together. The \"module\" statement\'s argument is the name of the module, followed by a block of substatements that holds detailed module information.");
          _builder_1.newLine();
          _builder_1.newLine();
          _builder_1.append("RFC 7950, Section 7.1: https://tools.ietf.org/html/rfc7950#section-7.1");
          _builder_1.newLine();
          it_1.documentation = _builder_1.toString();
        };
        _xblockexpression = ObjectExtensions.<YangTemplateProvider.Template>operator_doubleArrow(_template, _function);
      }
      return _xblockexpression;
    })), "yang-version", ((Function1<ContentAssistEntry, YangTemplateProvider.Template>) (ContentAssistEntry it) -> {
      YangTemplateProvider.Template _template = new YangTemplateProvider.Template("yang-version");
      final Procedure1<YangTemplateProvider.Template> _function = (YangTemplateProvider.Template it_1) -> {
        StringConcatenation _builder = new StringConcatenation();
        _builder.append("yang-version ${1:1.1};$0");
        _builder.newLine();
        it_1.template = _builder.toString();
        StringConcatenation _builder_1 = new StringConcatenation();
        _builder_1.append("The \"yang-version\" statement specifies which version of the YANG language was used in developing the module.");
        _builder_1.newLine();
        _builder_1.newLine();
        _builder_1.append("RFC 7950, Section 7.1.2: https://tools.ietf.org/html/rfc7950#section-7.1.2");
        _builder_1.newLine();
        it_1.documentation = _builder_1.toString();
      };
      return ObjectExtensions.<YangTemplateProvider.Template>operator_doubleArrow(_template, _function);
    })), "namespace", ((Function1<ContentAssistEntry, YangTemplateProvider.Template>) (ContentAssistEntry it) -> {
      YangTemplateProvider.Template _xblockexpression = null;
      {
        String _elvis = null;
        String _escapeModuleName = YangNameUtils.escapeModuleName(ContentAssistEntryUtils.getResourceName(it));
        if (_escapeModuleName != null) {
          _elvis = _escapeModuleName;
        } else {
          _elvis = "urn:namespace";
        }
        final String moduleName = _elvis;
        StringConcatenation _builder = new StringConcatenation();
        _builder.append("urn:ietf:params:xml:ns:yang:");
        _builder.append(moduleName);
        final String uri = _builder.toString();
        YangTemplateProvider.Template _template = new YangTemplateProvider.Template("namespace");
        final Procedure1<YangTemplateProvider.Template> _function = (YangTemplateProvider.Template it_1) -> {
          StringConcatenation _builder_1 = new StringConcatenation();
          _builder_1.append("namespace ${1:");
          _builder_1.append(uri);
          _builder_1.append("};$0");
          _builder_1.newLineIfNotEmpty();
          it_1.template = _builder_1.toString();
          StringConcatenation _builder_2 = new StringConcatenation();
          _builder_2.append("The \"namespace\" statement defines the XML namespace that all identifiers defined by the module are qualified by in the XML encoding, with the exception of identifiers for data nodes, action nodes, and notification nodes defined inside a grouping.");
          _builder_2.newLine();
          _builder_2.newLine();
          _builder_2.append("RFC 7950, Section 7.1.3: https://tools.ietf.org/html/rfc7950#section-7.1.3");
          _builder_2.newLine();
          it_1.documentation = _builder_2.toString();
        };
        _xblockexpression = ObjectExtensions.<YangTemplateProvider.Template>operator_doubleArrow(_template, _function);
      }
      return _xblockexpression;
    })), "prefix", ((Function1<ContentAssistEntry, YangTemplateProvider.Template>) (ContentAssistEntry it) -> {
      YangTemplateProvider.Template _xblockexpression = null;
      {
        String _elvis = null;
        String _escapeModuleName = YangNameUtils.escapeModuleName(ContentAssistEntryUtils.getResourceName(it));
        if (_escapeModuleName != null) {
          _elvis = _escapeModuleName;
        } else {
          _elvis = "prefix";
        }
        final String moduleName = _elvis;
        YangTemplateProvider.Template _template = new YangTemplateProvider.Template("prefix");
        final Procedure1<YangTemplateProvider.Template> _function = (YangTemplateProvider.Template it_1) -> {
          StringConcatenation _builder = new StringConcatenation();
          _builder.append("prefix ${1:");
          _builder.append(moduleName);
          _builder.append("};$0");
          _builder.newLineIfNotEmpty();
          it_1.template = _builder.toString();
          StringConcatenation _builder_1 = new StringConcatenation();
          _builder_1.append("The \"prefix\" statement is used to define the prefix associated with the module and its namespace. The \"prefix\" statement\'s argument is the prefix string that is used as a prefix to access a module.");
          _builder_1.newLine();
          _builder_1.newLine();
          _builder_1.append("RFC 7950, Section 7.1.4: https://tools.ietf.org/html/rfc7950#section-7.1.4");
          _builder_1.newLine();
          it_1.documentation = _builder_1.toString();
        };
        _xblockexpression = ObjectExtensions.<YangTemplateProvider.Template>operator_doubleArrow(_template, _function);
      }
      return _xblockexpression;
    })), "import", ((Function1<ContentAssistEntry, YangTemplateProvider.Template>) (ContentAssistEntry it) -> {
      YangTemplateProvider.Template _xblockexpression = null;
      {
        SimpleDateFormat _revisionDateFormat = YangDateUtils.getRevisionDateFormat();
        Date _date = new Date();
        final Iterator<String> segments = Splitter.on("-").trimResults().splitToList(_revisionDateFormat.format(_date)).iterator();
        YangTemplateProvider.Template _template = new YangTemplateProvider.Template("import");
        final Procedure1<YangTemplateProvider.Template> _function = (YangTemplateProvider.Template it_1) -> {
          StringConcatenation _builder = new StringConcatenation();
          _builder.append("import ${1:} {");
          _builder.newLine();
          _builder.append("  ");
          _builder.append("prefix ${1:};");
          _builder.newLine();
          _builder.append("  ");
          _builder.append("revision-date ${2:");
          String _next = segments.next();
          _builder.append(_next, "  ");
          _builder.append("}-${3:");
          String _next_1 = segments.next();
          _builder.append(_next_1, "  ");
          _builder.append("}-${4:");
          String _next_2 = segments.next();
          _builder.append(_next_2, "  ");
          _builder.append("};");
          _builder.newLineIfNotEmpty();
          _builder.append("}$0");
          _builder.newLine();
          it_1.template = _builder.toString();
          StringConcatenation _builder_1 = new StringConcatenation();
          _builder_1.append("The \"import\" statement makes definitions from one module available inside another module or submodule.");
          _builder_1.newLine();
          _builder_1.newLine();
          _builder_1.append("RFC 7950, Section 7.1.5: https://tools.ietf.org/html/rfc7950#section-7.1.5");
          _builder_1.newLine();
          it_1.documentation = _builder_1.toString();
        };
        _xblockexpression = ObjectExtensions.<YangTemplateProvider.Template>operator_doubleArrow(_template, _function);
      }
      return _xblockexpression;
    })), "include", ((Function1<ContentAssistEntry, YangTemplateProvider.Template>) (ContentAssistEntry it) -> {
      YangTemplateProvider.Template _xblockexpression = null;
      {
        SimpleDateFormat _revisionDateFormat = YangDateUtils.getRevisionDateFormat();
        Date _date = new Date();
        final Iterator<String> segments = Splitter.on("-").trimResults().splitToList(_revisionDateFormat.format(_date)).iterator();
        YangTemplateProvider.Template _template = new YangTemplateProvider.Template("include");
        final Procedure1<YangTemplateProvider.Template> _function = (YangTemplateProvider.Template it_1) -> {
          StringConcatenation _builder = new StringConcatenation();
          _builder.append("include ${1:} {");
          _builder.newLine();
          _builder.append("  ");
          _builder.append("revision-date ${2:");
          String _next = segments.next();
          _builder.append(_next, "  ");
          _builder.append("}-${3:");
          String _next_1 = segments.next();
          _builder.append(_next_1, "  ");
          _builder.append("}-${4:");
          String _next_2 = segments.next();
          _builder.append(_next_2, "  ");
          _builder.append("};");
          _builder.newLineIfNotEmpty();
          _builder.append("}$0");
          _builder.newLine();
          it_1.template = _builder.toString();
          StringConcatenation _builder_1 = new StringConcatenation();
          _builder_1.append("The \"include\" statement is used to make content from a submodule available to that submodule\'s parent module.");
          _builder_1.newLine();
          _builder_1.newLine();
          _builder_1.append("RFC 7950, Section 7.1.6: https://tools.ietf.org/html/rfc7950#section-7.1.6");
          _builder_1.newLine();
          it_1.documentation = _builder_1.toString();
        };
        _xblockexpression = ObjectExtensions.<YangTemplateProvider.Template>operator_doubleArrow(_template, _function);
      }
      return _xblockexpression;
    })), "organization", ((Function1<ContentAssistEntry, YangTemplateProvider.Template>) (ContentAssistEntry it) -> {
      YangTemplateProvider.Template _template = new YangTemplateProvider.Template("organization");
      final Procedure1<YangTemplateProvider.Template> _function = (YangTemplateProvider.Template it_1) -> {
        StringConcatenation _builder = new StringConcatenation();
        _builder.append("organization \"${1:}\";$0");
        _builder.newLine();
        it_1.template = _builder.toString();
        StringConcatenation _builder_1 = new StringConcatenation();
        _builder_1.append("The \"organization\" statement defines the party responsible for this module.");
        _builder_1.newLine();
        _builder_1.newLine();
        _builder_1.append("RFC 7950, Section 7.1.7: https://tools.ietf.org/html/rfc7950#section-7.1.7");
        _builder_1.newLine();
        it_1.documentation = _builder_1.toString();
      };
      return ObjectExtensions.<YangTemplateProvider.Template>operator_doubleArrow(_template, _function);
    })), "contact", ((Function1<ContentAssistEntry, YangTemplateProvider.Template>) (ContentAssistEntry it) -> {
      YangTemplateProvider.Template _template = new YangTemplateProvider.Template("contact");
      final Procedure1<YangTemplateProvider.Template> _function = (YangTemplateProvider.Template it_1) -> {
        StringConcatenation _builder = new StringConcatenation();
        _builder.append("contact \"${1:}\";$0");
        _builder.newLine();
        it_1.template = _builder.toString();
        StringConcatenation _builder_1 = new StringConcatenation();
        _builder_1.append("The \"contact\" statement provides contact information for the module.");
        _builder_1.newLine();
        _builder_1.newLine();
        _builder_1.append("RFC 7950, Section 7.1.8: https://tools.ietf.org/html/rfc7950#section-7.1.8");
        _builder_1.newLine();
        it_1.documentation = _builder_1.toString();
      };
      return ObjectExtensions.<YangTemplateProvider.Template>operator_doubleArrow(_template, _function);
    })), "revision", ((Function1<ContentAssistEntry, YangTemplateProvider.Template>) (ContentAssistEntry it) -> {
      YangTemplateProvider.Template _xblockexpression = null;
      {
        SimpleDateFormat _revisionDateFormat = YangDateUtils.getRevisionDateFormat();
        Date _date = new Date();
        final Iterator<String> segments = Splitter.on("-").trimResults().splitToList(_revisionDateFormat.format(_date)).iterator();
        YangTemplateProvider.Template _template = new YangTemplateProvider.Template("revision");
        final Procedure1<YangTemplateProvider.Template> _function = (YangTemplateProvider.Template it_1) -> {
          StringConcatenation _builder = new StringConcatenation();
          _builder.append("revision ${1:");
          String _next = segments.next();
          _builder.append(_next);
          _builder.append("}-${2:");
          String _next_1 = segments.next();
          _builder.append(_next_1);
          _builder.append("}-${3:");
          String _next_2 = segments.next();
          _builder.append(_next_2);
          _builder.append("} {");
          _builder.newLineIfNotEmpty();
          _builder.append("  ");
          _builder.append("description \"${4}\";$0");
          _builder.newLine();
          _builder.append("}");
          _builder.newLine();
          it_1.template = _builder.toString();
          StringConcatenation _builder_1 = new StringConcatenation();
          _builder_1.append("The \"revision\" statement specifies the editorial revision history of the module, including the initial revision. A series of \"revision\" statements detail the changes in the module\'s definition.");
          _builder_1.newLine();
          _builder_1.newLine();
          _builder_1.append("RFC 7950, Section 7.1.9: https://tools.ietf.org/html/rfc7950#section-7.1.9");
          _builder_1.newLine();
          it_1.documentation = _builder_1.toString();
        };
        _xblockexpression = ObjectExtensions.<YangTemplateProvider.Template>operator_doubleArrow(_template, _function);
      }
      return _xblockexpression;
    })), "submodule", ((Function1<ContentAssistEntry, YangTemplateProvider.Template>) (ContentAssistEntry it) -> {
      YangTemplateProvider.Template _xblockexpression = null;
      {
        String _elvis = null;
        String _escapeModuleName = YangNameUtils.escapeModuleName(ContentAssistEntryUtils.getResourceName(it));
        if (_escapeModuleName != null) {
          _elvis = _escapeModuleName;
        } else {
          _elvis = "module-name";
        }
        final String moduleName = _elvis;
        StringConcatenation _builder = new StringConcatenation();
        _builder.append("urn:ietf:params:xml:ns:yang:");
        _builder.append(moduleName);
        final String uri = _builder.toString();
        YangTemplateProvider.Template _template = new YangTemplateProvider.Template("submodule");
        final Procedure1<YangTemplateProvider.Template> _function = (YangTemplateProvider.Template it_1) -> {
          StringConcatenation _builder_1 = new StringConcatenation();
          _builder_1.append("submodule ${1:");
          _builder_1.append(moduleName);
          _builder_1.append("} {");
          _builder_1.newLineIfNotEmpty();
          _builder_1.append("  ");
          _builder_1.append("yang-version 1.1;");
          _builder_1.newLine();
          _builder_1.append("  ");
          _builder_1.append("belongs-to ${2:} {");
          _builder_1.newLine();
          _builder_1.append("    ");
          _builder_1.append("prefix ${1:");
          _builder_1.append(uri, "    ");
          _builder_1.append("};");
          _builder_1.newLineIfNotEmpty();
          _builder_1.append("  ");
          _builder_1.append("}");
          _builder_1.newLine();
          _builder_1.newLine();
          _builder_1.append("  ");
          _builder_1.append("$0");
          _builder_1.newLine();
          _builder_1.append("}");
          _builder_1.newLine();
          it_1.template = _builder_1.toString();
          StringConcatenation _builder_2 = new StringConcatenation();
          _builder_2.append("The \"submodule\" statement defines the submodule\'s name, and it groups all statements that belong to the submodule together.");
          _builder_2.newLine();
          _builder_2.newLine();
          _builder_2.append("RFC 7950, Section 7.2: https://tools.ietf.org/html/rfc7950#section-7.2");
          _builder_2.newLine();
          it_1.documentation = _builder_2.toString();
        };
        _xblockexpression = ObjectExtensions.<YangTemplateProvider.Template>operator_doubleArrow(_template, _function);
      }
      return _xblockexpression;
    })), "belongs-to", ((Function1<ContentAssistEntry, YangTemplateProvider.Template>) (ContentAssistEntry it) -> {
      YangTemplateProvider.Template _template = new YangTemplateProvider.Template("belongs-to");
      final Procedure1<YangTemplateProvider.Template> _function = (YangTemplateProvider.Template it_1) -> {
        StringConcatenation _builder = new StringConcatenation();
        _builder.append("belongs-to ${1:} {");
        _builder.newLine();
        _builder.append("  ");
        _builder.append("prefix ${1:};");
        _builder.newLine();
        _builder.append("}$0");
        _builder.newLine();
        it_1.template = _builder.toString();
        StringConcatenation _builder_1 = new StringConcatenation();
        _builder_1.append("The \"belongs-to\" statement specifies the module to which the submodule belongs.");
        _builder_1.newLine();
        _builder_1.newLine();
        _builder_1.append("RFC 7950, Section 7.2.2: https://tools.ietf.org/html/rfc7950#section-7.2.2");
        _builder_1.newLine();
        it_1.documentation = _builder_1.toString();
      };
      return ObjectExtensions.<YangTemplateProvider.Template>operator_doubleArrow(_template, _function);
    })), "typedef", ((Function1<ContentAssistEntry, YangTemplateProvider.Template>) (ContentAssistEntry it) -> {
      YangTemplateProvider.Template _template = new YangTemplateProvider.Template("typedef");
      final Procedure1<YangTemplateProvider.Template> _function = (YangTemplateProvider.Template it_1) -> {
        StringConcatenation _builder = new StringConcatenation();
        _builder.append("typedef ${1:type-name} {");
        _builder.newLine();
        _builder.append("  ");
        _builder.append("type ${2:};$0");
        _builder.newLine();
        _builder.append("}");
        _builder.newLine();
        it_1.template = _builder.toString();
        StringConcatenation _builder_1 = new StringConcatenation();
        _builder_1.append("The \"typedef\" statement defines a new type that may be used locally in the module or submodule, and by other modules that import from it.");
        _builder_1.newLine();
        _builder_1.newLine();
        _builder_1.append("RFC 7950, Section 7.3: https://tools.ietf.org/html/rfc7950#section-7.3");
        _builder_1.newLine();
        it_1.documentation = _builder_1.toString();
      };
      return ObjectExtensions.<YangTemplateProvider.Template>operator_doubleArrow(_template, _function);
    })), "units", ((Function1<ContentAssistEntry, YangTemplateProvider.Template>) (ContentAssistEntry it) -> {
      YangTemplateProvider.Template _template = new YangTemplateProvider.Template("units");
      final Procedure1<YangTemplateProvider.Template> _function = (YangTemplateProvider.Template it_1) -> {
        StringConcatenation _builder = new StringConcatenation();
        _builder.append("units ${1:unit};$0");
        _builder.newLine();
        it_1.template = _builder.toString();
        StringConcatenation _builder_1 = new StringConcatenation();
        _builder_1.append("The \"units\" statement contains a textual definition of the units associated with the type.");
        _builder_1.newLine();
        _builder_1.newLine();
        _builder_1.append("RFC 7950, Section 7.3.3: https://tools.ietf.org/html/rfc7950#section-7.3.3");
        _builder_1.newLine();
        it_1.documentation = _builder_1.toString();
      };
      return ObjectExtensions.<YangTemplateProvider.Template>operator_doubleArrow(_template, _function);
    })), "default", ((Function1<ContentAssistEntry, YangTemplateProvider.Template>) (ContentAssistEntry it) -> {
      YangTemplateProvider.Template _template = new YangTemplateProvider.Template("default");
      final Procedure1<YangTemplateProvider.Template> _function = (YangTemplateProvider.Template it_1) -> {
        StringConcatenation _builder = new StringConcatenation();
        _builder.append("default ${1:};$0");
        _builder.newLine();
        it_1.template = _builder.toString();
        StringConcatenation _builder_1 = new StringConcatenation();
        _builder_1.append("The \"default\" statement contains a default value for the new type.");
        _builder_1.newLine();
        _builder_1.newLine();
        _builder_1.append("RFC 7950, Section 7.3.4: https://tools.ietf.org/html/rfc7950#section-7.3.4");
        _builder_1.newLine();
        it_1.documentation = _builder_1.toString();
      };
      return ObjectExtensions.<YangTemplateProvider.Template>operator_doubleArrow(_template, _function);
    })), "type", ((Function1<ContentAssistEntry, YangTemplateProvider.Template>) (ContentAssistEntry it) -> {
      YangTemplateProvider.Template _template = new YangTemplateProvider.Template("type");
      final Procedure1<YangTemplateProvider.Template> _function = (YangTemplateProvider.Template it_1) -> {
        StringConcatenation _builder = new StringConcatenation();
        _builder.append("type ${1:type-name};$0");
        _builder.newLine();
        it_1.template = _builder.toString();
        StringConcatenation _builder_1 = new StringConcatenation();
        _builder_1.append("The \"type\" statement takes as an argument a string that is the name of a YANG built-in type or a derived type, followed by an optional block of substatements that is used to put further restrictions on the type.");
        _builder_1.newLine();
        _builder_1.newLine();
        _builder_1.append("RFC 7950, Section 7.4: https://tools.ietf.org/html/rfc7950#section-7.4");
        _builder_1.newLine();
        it_1.documentation = _builder_1.toString();
      };
      return ObjectExtensions.<YangTemplateProvider.Template>operator_doubleArrow(_template, _function);
    })), "container", ((Function1<ContentAssistEntry, YangTemplateProvider.Template>) (ContentAssistEntry it) -> {
      YangTemplateProvider.Template _template = new YangTemplateProvider.Template("container");
      final Procedure1<YangTemplateProvider.Template> _function = (YangTemplateProvider.Template it_1) -> {
        StringConcatenation _builder = new StringConcatenation();
        _builder.append("container ${1:container-name} {");
        _builder.newLine();
        _builder.append("  ");
        _builder.append("$0");
        _builder.newLine();
        _builder.append("}");
        _builder.newLine();
        it_1.template = _builder.toString();
        StringConcatenation _builder_1 = new StringConcatenation();
        _builder_1.append("The \"container\" statement is used to define an interior data node in the schema tree. It takes one argument, which is an identifier, followed by a block of substatements that holds detailed container information.");
        _builder_1.newLine();
        _builder_1.newLine();
        _builder_1.append("RFC 7950, Section 7.5: https://tools.ietf.org/html/rfc7950#section-7.5");
        _builder_1.newLine();
        it_1.documentation = _builder_1.toString();
      };
      return ObjectExtensions.<YangTemplateProvider.Template>operator_doubleArrow(_template, _function);
    })), "must", ((Function1<ContentAssistEntry, YangTemplateProvider.Template>) (ContentAssistEntry it) -> {
      YangTemplateProvider.Template _template = new YangTemplateProvider.Template("must");
      final Procedure1<YangTemplateProvider.Template> _function = (YangTemplateProvider.Template it_1) -> {
        StringConcatenation _builder = new StringConcatenation();
        _builder.append("must \"${1:expression}\";$0");
        _builder.newLine();
        it_1.template = _builder.toString();
        StringConcatenation _builder_1 = new StringConcatenation();
        _builder_1.append("The \"must\" statement, which is optional, takes as an argument a string that contains an XPath expression. It is used to formally declare a constraint on valid data.");
        _builder_1.newLine();
        _builder_1.newLine();
        _builder_1.append("RFC 7950, Section 7.5.3: https://tools.ietf.org/html/rfc7950#section-7.5.3");
        _builder_1.newLine();
        it_1.documentation = _builder_1.toString();
      };
      return ObjectExtensions.<YangTemplateProvider.Template>operator_doubleArrow(_template, _function);
    })), "error-message", ((Function1<ContentAssistEntry, YangTemplateProvider.Template>) (ContentAssistEntry it) -> {
      YangTemplateProvider.Template _template = new YangTemplateProvider.Template("error-message");
      final Procedure1<YangTemplateProvider.Template> _function = (YangTemplateProvider.Template it_1) -> {
        StringConcatenation _builder = new StringConcatenation();
        _builder.append("error-message \"${1:error-message}\";$0");
        _builder.newLine();
        it_1.template = _builder.toString();
        StringConcatenation _builder_1 = new StringConcatenation();
        _builder_1.append("The \"error-message\" statement, which is optional, takes a string as an argument. If the constraint evaluates to \"false\", the string is passed as <error-message> in the <rpc-error> in NETCONF.");
        _builder_1.newLine();
        _builder_1.newLine();
        _builder_1.append("RFC 7950, Section 7.5.4.1: https://tools.ietf.org/html/rfc7950#section-7.5.4.1");
        _builder_1.newLine();
        it_1.documentation = _builder_1.toString();
      };
      return ObjectExtensions.<YangTemplateProvider.Template>operator_doubleArrow(_template, _function);
    })), "error-app-tag", ((Function1<ContentAssistEntry, YangTemplateProvider.Template>) (ContentAssistEntry it) -> {
      YangTemplateProvider.Template _template = new YangTemplateProvider.Template("error-app-tag");
      final Procedure1<YangTemplateProvider.Template> _function = (YangTemplateProvider.Template it_1) -> {
        StringConcatenation _builder = new StringConcatenation();
        _builder.append("error-app-tag ${1:error-app-tag};$0");
        _builder.newLine();
        it_1.template = _builder.toString();
        StringConcatenation _builder_1 = new StringConcatenation();
        _builder_1.append("The \"error-app-tag\" statement, which is optional, takes a string as an argument. If the constraint evaluates to \"false\", the string is passed as <error-app-tag> in the <rpc-error> in NETCONF.");
        _builder_1.newLine();
        _builder_1.newLine();
        _builder_1.append("RFC 7950, Section 7.5.4.2: https://tools.ietf.org/html/rfc7950#section-7.5.4.2");
        _builder_1.newLine();
        it_1.documentation = _builder_1.toString();
      };
      return ObjectExtensions.<YangTemplateProvider.Template>operator_doubleArrow(_template, _function);
    })), "presence", ((Function1<ContentAssistEntry, YangTemplateProvider.Template>) (ContentAssistEntry it) -> {
      YangTemplateProvider.Template _template = new YangTemplateProvider.Template("presence");
      final Procedure1<YangTemplateProvider.Template> _function = (YangTemplateProvider.Template it_1) -> {
        StringConcatenation _builder = new StringConcatenation();
        _builder.append("presence ${1:meaning};$0");
        _builder.newLine();
        it_1.template = _builder.toString();
        StringConcatenation _builder_1 = new StringConcatenation();
        _builder_1.append("The \"presence\" statement assigns a meaning to the presence of a container in the data tree. It takes as an argument a string that contains a textual description of what the node\'s presence means.");
        _builder_1.newLine();
        _builder_1.newLine();
        _builder_1.append("RFC 7950, Section 7.5.5: https://tools.ietf.org/html/rfc7950#section-7.5.5");
        _builder_1.newLine();
        it_1.documentation = _builder_1.toString();
      };
      return ObjectExtensions.<YangTemplateProvider.Template>operator_doubleArrow(_template, _function);
    })), "leaf", ((Function1<ContentAssistEntry, YangTemplateProvider.Template>) (ContentAssistEntry it) -> {
      YangTemplateProvider.Template _template = new YangTemplateProvider.Template("leaf");
      final Procedure1<YangTemplateProvider.Template> _function = (YangTemplateProvider.Template it_1) -> {
        StringConcatenation _builder = new StringConcatenation();
        _builder.append("leaf ${1:leaf-name} {");
        _builder.newLine();
        _builder.append("  ");
        _builder.append("type ${2:type-name} {");
        _builder.newLine();
        _builder.append("    ");
        _builder.append("$0");
        _builder.newLine();
        _builder.append("  ");
        _builder.append("}");
        _builder.newLine();
        _builder.append("}");
        _builder.newLine();
        it_1.template = _builder.toString();
        StringConcatenation _builder_1 = new StringConcatenation();
        _builder_1.append("The \"leaf\" statement is used to define a leaf node in the schema tree. It takes one argument, which is an identifier, followed by a block of substatements that holds detailed leaf information.");
        _builder_1.newLine();
        _builder_1.newLine();
        _builder_1.append("RFC 7950, Section 7.6: https://tools.ietf.org/html/rfc7950#section-7.6");
        _builder_1.newLine();
        it_1.documentation = _builder_1.toString();
      };
      return ObjectExtensions.<YangTemplateProvider.Template>operator_doubleArrow(_template, _function);
    })), "mandatory", ((Function1<ContentAssistEntry, YangTemplateProvider.Template>) (ContentAssistEntry it) -> {
      YangTemplateProvider.Template _template = new YangTemplateProvider.Template("mandatory");
      final Procedure1<YangTemplateProvider.Template> _function = (YangTemplateProvider.Template it_1) -> {
        StringConcatenation _builder = new StringConcatenation();
        _builder.append("mandatory ${1:true};$0");
        _builder.newLine();
        it_1.template = _builder.toString();
        StringConcatenation _builder_1 = new StringConcatenation();
        _builder_1.append("The \"mandatory\" statement, which is optional, takes as an argument the string \"true\" or \"false\" and puts a constraint on valid data. If not specified, the default is \"false\".");
        _builder_1.newLine();
        _builder_1.newLine();
        _builder_1.append("RFC 7950, Section 7.6.5: https://tools.ietf.org/html/rfc7950#section-7.6.5");
        _builder_1.newLine();
        it_1.documentation = _builder_1.toString();
      };
      return ObjectExtensions.<YangTemplateProvider.Template>operator_doubleArrow(_template, _function);
    })), "leaf-list", ((Function1<ContentAssistEntry, YangTemplateProvider.Template>) (ContentAssistEntry it) -> {
      YangTemplateProvider.Template _template = new YangTemplateProvider.Template("leaf-list");
      final Procedure1<YangTemplateProvider.Template> _function = (YangTemplateProvider.Template it_1) -> {
        StringConcatenation _builder = new StringConcatenation();
        _builder.append("leaf-list ${1:leaf-list-name} {");
        _builder.newLine();
        _builder.append("  ");
        _builder.append("type ${2:type-name} {");
        _builder.newLine();
        _builder.append("    ");
        _builder.append("$0");
        _builder.newLine();
        _builder.append("  ");
        _builder.append("}");
        _builder.newLine();
        _builder.append("}");
        _builder.newLine();
        it_1.template = _builder.toString();
        StringConcatenation _builder_1 = new StringConcatenation();
        _builder_1.append("Where the \"leaf\" statement is used to define a simple scalar variable of a particular type, the \"leaf-list\" statement is used to define an array of a particular type.");
        _builder_1.newLine();
        _builder_1.newLine();
        _builder_1.append("RFC 7950, Section 7.7: https://tools.ietf.org/html/rfc7950#section-7.7");
        _builder_1.newLine();
        it_1.documentation = _builder_1.toString();
      };
      return ObjectExtensions.<YangTemplateProvider.Template>operator_doubleArrow(_template, _function);
    })), "min-elements", ((Function1<ContentAssistEntry, YangTemplateProvider.Template>) (ContentAssistEntry it) -> {
      YangTemplateProvider.Template _template = new YangTemplateProvider.Template("min-elements");
      final Procedure1<YangTemplateProvider.Template> _function = (YangTemplateProvider.Template it_1) -> {
        StringConcatenation _builder = new StringConcatenation();
        _builder.append("min-elements ${1:0};$0");
        _builder.newLine();
        it_1.template = _builder.toString();
        StringConcatenation _builder_1 = new StringConcatenation();
        _builder_1.append("The \"min-elements\" statement, which is optional, takes as an argument a non-negative integer that puts a constraint on valid list entries.");
        _builder_1.newLine();
        _builder_1.newLine();
        _builder_1.append("RFC 7950, Section 7.7.5: https://tools.ietf.org/html/rfc7950#section-7.7.5");
        _builder_1.newLine();
        it_1.documentation = _builder_1.toString();
      };
      return ObjectExtensions.<YangTemplateProvider.Template>operator_doubleArrow(_template, _function);
    })), "max-elements", ((Function1<ContentAssistEntry, YangTemplateProvider.Template>) (ContentAssistEntry it) -> {
      YangTemplateProvider.Template _template = new YangTemplateProvider.Template("max-elements");
      final Procedure1<YangTemplateProvider.Template> _function = (YangTemplateProvider.Template it_1) -> {
        StringConcatenation _builder = new StringConcatenation();
        _builder.append("max-elements ${1:unbounded};$0");
        _builder.newLine();
        it_1.template = _builder.toString();
        StringConcatenation _builder_1 = new StringConcatenation();
        _builder_1.append("The \"max-elements\" statement, which is optional, takes as an argument a positive integer or the string \"unbounded\", which puts a constraint on valid list entries.");
        _builder_1.newLine();
        _builder_1.newLine();
        _builder_1.append("RFC 7950, Section 7.7.6: https://tools.ietf.org/html/rfc7950#section-7.7.6");
        _builder_1.newLine();
        it_1.documentation = _builder_1.toString();
      };
      return ObjectExtensions.<YangTemplateProvider.Template>operator_doubleArrow(_template, _function);
    })), "ordered-by", ((Function1<ContentAssistEntry, YangTemplateProvider.Template>) (ContentAssistEntry it) -> {
      YangTemplateProvider.Template _template = new YangTemplateProvider.Template("ordered-by");
      final Procedure1<YangTemplateProvider.Template> _function = (YangTemplateProvider.Template it_1) -> {
        StringConcatenation _builder = new StringConcatenation();
        _builder.append("ordered-by ${1:system};$0");
        _builder.newLine();
        it_1.template = _builder.toString();
        StringConcatenation _builder_1 = new StringConcatenation();
        _builder_1.append("The \"ordered-by\" statement defines whether the order of entries within a list are determined by the user or the system. The argument is one of the strings \"system\" or \"user\". If not present, ordering defaults to \"system\".");
        _builder_1.newLine();
        _builder_1.newLine();
        _builder_1.append("RFC 7950, Section 7.7.7: https://tools.ietf.org/html/rfc7950#section-7.7.7");
        _builder_1.newLine();
        it_1.documentation = _builder_1.toString();
      };
      return ObjectExtensions.<YangTemplateProvider.Template>operator_doubleArrow(_template, _function);
    })), "list", ((Function1<ContentAssistEntry, YangTemplateProvider.Template>) (ContentAssistEntry it) -> {
      YangTemplateProvider.Template _template = new YangTemplateProvider.Template("list");
      final Procedure1<YangTemplateProvider.Template> _function = (YangTemplateProvider.Template it_1) -> {
        StringConcatenation _builder = new StringConcatenation();
        _builder.append("list ${1:list-name} {");
        _builder.newLine();
        _builder.append("  ");
        _builder.append("$0");
        _builder.newLine();
        _builder.append("}");
        _builder.newLine();
        it_1.template = _builder.toString();
        StringConcatenation _builder_1 = new StringConcatenation();
        _builder_1.append("The \"list\" statement is used to define an interior data node in the schema tree. A list node may exist in multiple instances in the data tree.");
        _builder_1.newLine();
        _builder_1.newLine();
        _builder_1.append("RFC 7950, Section 7.8: https://tools.ietf.org/html/rfc7950#section-7.8");
        _builder_1.newLine();
        it_1.documentation = _builder_1.toString();
      };
      return ObjectExtensions.<YangTemplateProvider.Template>operator_doubleArrow(_template, _function);
    })), "key", ((Function1<ContentAssistEntry, YangTemplateProvider.Template>) (ContentAssistEntry it) -> {
      YangTemplateProvider.Template _template = new YangTemplateProvider.Template("key");
      final Procedure1<YangTemplateProvider.Template> _function = (YangTemplateProvider.Template it_1) -> {
        StringConcatenation _builder = new StringConcatenation();
        _builder.append("key ${1:};$0");
        _builder.newLine();
        it_1.template = _builder.toString();
        StringConcatenation _builder_1 = new StringConcatenation();
        _builder_1.append("The \"key\" statement, which must be present if the list represents configuration and may be present otherwise, takes as an argument a string that specifies a space-separated list of one or more leaf identifiers of this list.");
        _builder_1.newLine();
        _builder_1.newLine();
        _builder_1.append("RFC 7950, Section 7.8.2: https://tools.ietf.org/html/rfc7950#section-7.8.2");
        _builder_1.newLine();
        it_1.documentation = _builder_1.toString();
      };
      return ObjectExtensions.<YangTemplateProvider.Template>operator_doubleArrow(_template, _function);
    })), "unique", ((Function1<ContentAssistEntry, YangTemplateProvider.Template>) (ContentAssistEntry it) -> {
      YangTemplateProvider.Template _template = new YangTemplateProvider.Template("unique");
      final Procedure1<YangTemplateProvider.Template> _function = (YangTemplateProvider.Template it_1) -> {
        StringConcatenation _builder = new StringConcatenation();
        _builder.append("unique ${1:}$2;$0");
        _builder.newLine();
        it_1.template = _builder.toString();
        StringConcatenation _builder_1 = new StringConcatenation();
        _builder_1.append("The \"unique\" statement is used to put constraints on valid list entries. It takes as an argument a string that contains a space- separated list of schema node identifiers, which must be given in the descendant form.");
        _builder_1.newLine();
        _builder_1.newLine();
        _builder_1.append("RFC 7950, Section 7.8.3: https://tools.ietf.org/html/rfc7950#section-7.8.3");
        _builder_1.newLine();
        it_1.documentation = _builder_1.toString();
      };
      return ObjectExtensions.<YangTemplateProvider.Template>operator_doubleArrow(_template, _function);
    })), "choice", ((Function1<ContentAssistEntry, YangTemplateProvider.Template>) (ContentAssistEntry it) -> {
      YangTemplateProvider.Template _template = new YangTemplateProvider.Template("choice");
      final Procedure1<YangTemplateProvider.Template> _function = (YangTemplateProvider.Template it_1) -> {
        StringConcatenation _builder = new StringConcatenation();
        _builder.append("choice ${1:choice-name} {");
        _builder.newLine();
        _builder.append("  ");
        _builder.append("$0");
        _builder.newLine();
        _builder.append("}");
        _builder.newLine();
        it_1.template = _builder.toString();
        StringConcatenation _builder_1 = new StringConcatenation();
        _builder_1.append("The \"choice\" statement defines a set of alternatives, only one of which may be present in any one data tree. The argument is an identifier, followed by a block of substatements that holds detailed choice information.");
        _builder_1.newLine();
        _builder_1.newLine();
        _builder_1.append("RFC 7950, Section 7.8.3: https://tools.ietf.org/html/rfc7950#section-7.8.3");
        _builder_1.newLine();
        it_1.documentation = _builder_1.toString();
      };
      return ObjectExtensions.<YangTemplateProvider.Template>operator_doubleArrow(_template, _function);
    })), "case", ((Function1<ContentAssistEntry, YangTemplateProvider.Template>) (ContentAssistEntry it) -> {
      YangTemplateProvider.Template _template = new YangTemplateProvider.Template("case");
      final Procedure1<YangTemplateProvider.Template> _function = (YangTemplateProvider.Template it_1) -> {
        StringConcatenation _builder = new StringConcatenation();
        _builder.append("case ${1:case-name} {");
        _builder.newLine();
        _builder.append("  ");
        _builder.append("$0");
        _builder.newLine();
        _builder.append("}");
        _builder.newLine();
        it_1.template = _builder.toString();
        StringConcatenation _builder_1 = new StringConcatenation();
        _builder_1.append("The \"case\" statement is used to define branches of the choice. It takes as an argument an identifier, followed by a block of substatements that holds detailed case information.");
        _builder_1.newLine();
        _builder_1.newLine();
        _builder_1.append("RFC 7950, Section 7.9.1: https://tools.ietf.org/html/rfc7950#section-7.9.2");
        _builder_1.newLine();
        it_1.documentation = _builder_1.toString();
      };
      return ObjectExtensions.<YangTemplateProvider.Template>operator_doubleArrow(_template, _function);
    })), "anydata", ((Function1<ContentAssistEntry, YangTemplateProvider.Template>) (ContentAssistEntry it) -> {
      YangTemplateProvider.Template _template = new YangTemplateProvider.Template("anydata");
      final Procedure1<YangTemplateProvider.Template> _function = (YangTemplateProvider.Template it_1) -> {
        StringConcatenation _builder = new StringConcatenation();
        _builder.append("anydata ${1:data};$0");
        _builder.newLine();
        it_1.template = _builder.toString();
        StringConcatenation _builder_1 = new StringConcatenation();
        _builder_1.append("The \"anydata\" statement defines an interior node in the schema tree. It takes one argument, which is an identifier, followed by a block of substatements that holds detailed anydata information.");
        _builder_1.newLine();
        _builder_1.newLine();
        _builder_1.append("RFC 7950, Section 7.10: https://tools.ietf.org/html/rfc7950#section-7.10");
        _builder_1.newLine();
        it_1.documentation = _builder_1.toString();
      };
      return ObjectExtensions.<YangTemplateProvider.Template>operator_doubleArrow(_template, _function);
    })), "anyxml", ((Function1<ContentAssistEntry, YangTemplateProvider.Template>) (ContentAssistEntry it) -> {
      YangTemplateProvider.Template _template = new YangTemplateProvider.Template("anyxml");
      final Procedure1<YangTemplateProvider.Template> _function = (YangTemplateProvider.Template it_1) -> {
        StringConcatenation _builder = new StringConcatenation();
        _builder.append("anyxml ${1:xml};$0");
        _builder.newLine();
        it_1.template = _builder.toString();
        StringConcatenation _builder_1 = new StringConcatenation();
        _builder_1.append("The \"anyxml\" statement defines an interior node in the schema tree. It takes one argument, which is an identifier, followed by a block of substatements that holds detailed anyxml information.");
        _builder_1.newLine();
        _builder_1.newLine();
        _builder_1.append("RFC 7950, Section 7.11: https://tools.ietf.org/html/rfc7950#section-7.11");
        _builder_1.newLine();
        it_1.documentation = _builder_1.toString();
      };
      return ObjectExtensions.<YangTemplateProvider.Template>operator_doubleArrow(_template, _function);
    })), "grouping", ((Function1<ContentAssistEntry, YangTemplateProvider.Template>) (ContentAssistEntry it) -> {
      YangTemplateProvider.Template _template = new YangTemplateProvider.Template("grouping");
      final Procedure1<YangTemplateProvider.Template> _function = (YangTemplateProvider.Template it_1) -> {
        StringConcatenation _builder = new StringConcatenation();
        _builder.append("grouping ${1:grouping-name} {");
        _builder.newLine();
        _builder.append("  ");
        _builder.append("$0");
        _builder.newLine();
        _builder.append("}");
        _builder.newLine();
        it_1.template = _builder.toString();
        StringConcatenation _builder_1 = new StringConcatenation();
        _builder_1.append("The \"grouping\" statement is used to define a reusable block of nodes, which may be used locally in the module or submodule, and by other modules that import from it.");
        _builder_1.newLine();
        _builder_1.newLine();
        _builder_1.append("RFC 7950, Section 7.12: https://tools.ietf.org/html/rfc7950#section-7.12");
        _builder_1.newLine();
        it_1.documentation = _builder_1.toString();
      };
      return ObjectExtensions.<YangTemplateProvider.Template>operator_doubleArrow(_template, _function);
    })), "uses", ((Function1<ContentAssistEntry, YangTemplateProvider.Template>) (ContentAssistEntry it) -> {
      YangTemplateProvider.Template _template = new YangTemplateProvider.Template("uses");
      final Procedure1<YangTemplateProvider.Template> _function = (YangTemplateProvider.Template it_1) -> {
        StringConcatenation _builder = new StringConcatenation();
        _builder.append("uses ${1:group-name} {");
        _builder.newLine();
        _builder.append("  ");
        _builder.append("$0");
        _builder.newLine();
        _builder.append("}");
        _builder.newLine();
        it_1.template = _builder.toString();
        StringConcatenation _builder_1 = new StringConcatenation();
        _builder_1.append("The \"uses\" statement is used to reference a \"grouping\" definition. It takes one argument, which is the name of the grouping.");
        _builder_1.newLine();
        _builder_1.newLine();
        _builder_1.append("RFC 7950, Section 7.13: https://tools.ietf.org/html/rfc7950#section-7.13");
        _builder_1.newLine();
        it_1.documentation = _builder_1.toString();
      };
      return ObjectExtensions.<YangTemplateProvider.Template>operator_doubleArrow(_template, _function);
    })), "refine", ((Function1<ContentAssistEntry, YangTemplateProvider.Template>) (ContentAssistEntry it) -> {
      YangTemplateProvider.Template _template = new YangTemplateProvider.Template("refine");
      final Procedure1<YangTemplateProvider.Template> _function = (YangTemplateProvider.Template it_1) -> {
        StringConcatenation _builder = new StringConcatenation();
        _builder.append("refine ${1:} {");
        _builder.newLine();
        _builder.append("  ");
        _builder.append("$0");
        _builder.newLine();
        _builder.append("}");
        _builder.newLine();
        it_1.template = _builder.toString();
        StringConcatenation _builder_1 = new StringConcatenation();
        _builder_1.append("Some of the properties of each node in the grouping can be refined with the \"refine\" statement. The argument is a string that identifies a node in the grouping. This node is called the refine\'s target node.");
        _builder_1.newLine();
        _builder_1.newLine();
        _builder_1.append("RFC 7950, Section 7.13.2: https://tools.ietf.org/html/rfc7950#section-7.13.2");
        _builder_1.newLine();
        it_1.documentation = _builder_1.toString();
      };
      return ObjectExtensions.<YangTemplateProvider.Template>operator_doubleArrow(_template, _function);
    })), "rpc", ((Function1<ContentAssistEntry, YangTemplateProvider.Template>) (ContentAssistEntry it) -> {
      YangTemplateProvider.Template _template = new YangTemplateProvider.Template("rpc");
      final Procedure1<YangTemplateProvider.Template> _function = (YangTemplateProvider.Template it_1) -> {
        StringConcatenation _builder = new StringConcatenation();
        _builder.append("rpc ${1:rpc-name} {");
        _builder.newLine();
        _builder.append("  ");
        _builder.append("$0");
        _builder.newLine();
        _builder.append("}");
        _builder.newLine();
        it_1.template = _builder.toString();
        StringConcatenation _builder_1 = new StringConcatenation();
        _builder_1.append("The \"rpc\" statement is used to define an RPC operation. It takes one argument, which is an identifier, followed by a block of substatements that holds detailed rpc information. This argument is the name of the RPC.");
        _builder_1.newLine();
        _builder_1.newLine();
        _builder_1.append("RFC 7950, Section 7.14: https://tools.ietf.org/html/rfc7950#section-7.14");
        _builder_1.newLine();
        it_1.documentation = _builder_1.toString();
      };
      return ObjectExtensions.<YangTemplateProvider.Template>operator_doubleArrow(_template, _function);
    })), "input", ((Function1<ContentAssistEntry, YangTemplateProvider.Template>) (ContentAssistEntry it) -> {
      YangTemplateProvider.Template _template = new YangTemplateProvider.Template("input");
      final Procedure1<YangTemplateProvider.Template> _function = (YangTemplateProvider.Template it_1) -> {
        StringConcatenation _builder = new StringConcatenation();
        _builder.append("input {");
        _builder.newLine();
        _builder.append("  ");
        _builder.append("$0");
        _builder.newLine();
        _builder.append("}");
        _builder.newLine();
        it_1.template = _builder.toString();
        StringConcatenation _builder_1 = new StringConcatenation();
        _builder_1.append("The \"input\" statement, which is optional, is used to define input parameters to the operation. It does not take an argument. The substatements to \"input\" define nodes under the operation\'s input node.");
        _builder_1.newLine();
        _builder_1.newLine();
        _builder_1.append("RFC 7950, Section 7.14.2: https://tools.ietf.org/html/rfc7950#section-7.14.2");
        _builder_1.newLine();
        it_1.documentation = _builder_1.toString();
      };
      return ObjectExtensions.<YangTemplateProvider.Template>operator_doubleArrow(_template, _function);
    })), "output", ((Function1<ContentAssistEntry, YangTemplateProvider.Template>) (ContentAssistEntry it) -> {
      YangTemplateProvider.Template _template = new YangTemplateProvider.Template("output");
      final Procedure1<YangTemplateProvider.Template> _function = (YangTemplateProvider.Template it_1) -> {
        StringConcatenation _builder = new StringConcatenation();
        _builder.append("output {");
        _builder.newLine();
        _builder.append("  ");
        _builder.append("$0");
        _builder.newLine();
        _builder.append("}");
        _builder.newLine();
        it_1.template = _builder.toString();
        StringConcatenation _builder_1 = new StringConcatenation();
        _builder_1.append("The \"output\" statement, which is optional, is used to define output parameters to the RPC operation. It does not take an argument. The substatements to \"output\" define nodes under the operation\'s output node.");
        _builder_1.newLine();
        _builder_1.newLine();
        _builder_1.append("RFC 7950, Section 7.14.3: https://tools.ietf.org/html/rfc7950#section-7.14.3");
        _builder_1.newLine();
        it_1.documentation = _builder_1.toString();
      };
      return ObjectExtensions.<YangTemplateProvider.Template>operator_doubleArrow(_template, _function);
    })), "action", ((Function1<ContentAssistEntry, YangTemplateProvider.Template>) (ContentAssistEntry it) -> {
      YangTemplateProvider.Template _template = new YangTemplateProvider.Template("action");
      final Procedure1<YangTemplateProvider.Template> _function = (YangTemplateProvider.Template it_1) -> {
        StringConcatenation _builder = new StringConcatenation();
        _builder.append("action ${1:action-name} {");
        _builder.newLine();
        _builder.append("  ");
        _builder.append("$0");
        _builder.newLine();
        _builder.append("}");
        _builder.newLine();
        it_1.template = _builder.toString();
        StringConcatenation _builder_1 = new StringConcatenation();
        _builder_1.append("The \"action\" statement is used to define an operation connected to a specific container or list data node. It takes one argument, which is an identifier, followed by a block of substatements that holds detailed action information. The argument is the name of the action.");
        _builder_1.newLine();
        _builder_1.newLine();
        _builder_1.append("RFC 7950, Section 7.15: https://tools.ietf.org/html/rfc7950#section-7.15");
        _builder_1.newLine();
        it_1.documentation = _builder_1.toString();
      };
      return ObjectExtensions.<YangTemplateProvider.Template>operator_doubleArrow(_template, _function);
    })), "notification", ((Function1<ContentAssistEntry, YangTemplateProvider.Template>) (ContentAssistEntry it) -> {
      YangTemplateProvider.Template _template = new YangTemplateProvider.Template("notification");
      final Procedure1<YangTemplateProvider.Template> _function = (YangTemplateProvider.Template it_1) -> {
        StringConcatenation _builder = new StringConcatenation();
        _builder.append("notification ${1:action-name} {");
        _builder.newLine();
        _builder.append("  ");
        _builder.append("$0");
        _builder.newLine();
        _builder.append("}");
        _builder.newLine();
        it_1.template = _builder.toString();
        StringConcatenation _builder_1 = new StringConcatenation();
        _builder_1.append("The \"notification\" statement is used to define a notification. It takes one argument, which is an identifier, followed by a block of substatements that holds detailed notification information. The \"notification\" statement defines a notification node in the schema tree.");
        _builder_1.newLine();
        _builder_1.newLine();
        _builder_1.append("RFC 7950, Section 7.16: https://tools.ietf.org/html/rfc7950#section-7.16");
        _builder_1.newLine();
        it_1.documentation = _builder_1.toString();
      };
      return ObjectExtensions.<YangTemplateProvider.Template>operator_doubleArrow(_template, _function);
    })), "augment", ((Function1<ContentAssistEntry, YangTemplateProvider.Template>) (ContentAssistEntry it) -> {
      YangTemplateProvider.Template _template = new YangTemplateProvider.Template("augment");
      final Procedure1<YangTemplateProvider.Template> _function = (YangTemplateProvider.Template it_1) -> {
        StringConcatenation _builder = new StringConcatenation();
        _builder.append("augment ${1:} {");
        _builder.newLine();
        _builder.append("  ");
        _builder.append("$0");
        _builder.newLine();
        _builder.append("}");
        _builder.newLine();
        it_1.template = _builder.toString();
        StringConcatenation _builder_1 = new StringConcatenation();
        _builder_1.append("The \"augment\" statement allows a module or submodule to add to a schema tree defined in an external module, or in the current module and its submodules, and to add to the nodes from a grouping in a \"uses\" statement. The argument is a string that identifies a node in the schema tree.");
        _builder_1.newLine();
        _builder_1.newLine();
        _builder_1.append("RFC 7950, Section 7.17: https://tools.ietf.org/html/rfc7950#section-7.17");
        _builder_1.newLine();
        it_1.documentation = _builder_1.toString();
      };
      return ObjectExtensions.<YangTemplateProvider.Template>operator_doubleArrow(_template, _function);
    })), "identity", ((Function1<ContentAssistEntry, YangTemplateProvider.Template>) (ContentAssistEntry it) -> {
      YangTemplateProvider.Template _template = new YangTemplateProvider.Template("identity");
      final Procedure1<YangTemplateProvider.Template> _function = (YangTemplateProvider.Template it_1) -> {
        StringConcatenation _builder = new StringConcatenation();
        _builder.append("identity ${1:identity-name} {");
        _builder.newLine();
        _builder.append("  ");
        _builder.append("$0");
        _builder.newLine();
        _builder.append("}");
        _builder.newLine();
        it_1.template = _builder.toString();
        StringConcatenation _builder_1 = new StringConcatenation();
        _builder_1.append("The \"identity\" statement is used to define a new globally unique, abstract, and untyped identity. The identity\'s only purpose is to denote its name, semantics, and existence. An identity can be either defined from scratch or derived from one or more base identities.");
        _builder_1.newLine();
        _builder_1.newLine();
        _builder_1.append("RFC 7950, Section 7.18: https://tools.ietf.org/html/rfc7950#section-7.18");
        _builder_1.newLine();
        it_1.documentation = _builder_1.toString();
      };
      return ObjectExtensions.<YangTemplateProvider.Template>operator_doubleArrow(_template, _function);
    })), "base", ((Function1<ContentAssistEntry, YangTemplateProvider.Template>) (ContentAssistEntry it) -> {
      YangTemplateProvider.Template _template = new YangTemplateProvider.Template("base");
      final Procedure1<YangTemplateProvider.Template> _function = (YangTemplateProvider.Template it_1) -> {
        StringConcatenation _builder = new StringConcatenation();
        _builder.append("base ${1:};$0");
        _builder.newLine();
        it_1.template = _builder.toString();
        StringConcatenation _builder_1 = new StringConcatenation();
        _builder_1.append("The \"base\" statement, which is optional, takes as an argument a string that is the name of an existing identity, from which the new identity is derived.");
        _builder_1.newLine();
        _builder_1.newLine();
        _builder_1.append("RFC 7950, Section 7.18.2: https://tools.ietf.org/html/rfc7950#section-7.18.2");
        _builder_1.newLine();
        it_1.documentation = _builder_1.toString();
      };
      return ObjectExtensions.<YangTemplateProvider.Template>operator_doubleArrow(_template, _function);
    })), "extension", ((Function1<ContentAssistEntry, YangTemplateProvider.Template>) (ContentAssistEntry it) -> {
      YangTemplateProvider.Template _template = new YangTemplateProvider.Template("extension");
      final Procedure1<YangTemplateProvider.Template> _function = (YangTemplateProvider.Template it_1) -> {
        StringConcatenation _builder = new StringConcatenation();
        _builder.append("extension ${1:extension-name} {");
        _builder.newLine();
        _builder.append("  ");
        _builder.append("$0");
        _builder.newLine();
        _builder.append("}");
        _builder.newLine();
        it_1.template = _builder.toString();
        StringConcatenation _builder_1 = new StringConcatenation();
        _builder_1.append("The \"extension\" statement allows the definition of new statements within the YANG language. This new statement definition can be imported and used by other modules.");
        _builder_1.newLine();
        _builder_1.newLine();
        _builder_1.append("RFC 7950, Section 7.19: https://tools.ietf.org/html/rfc7950#section-7.19");
        _builder_1.newLine();
        it_1.documentation = _builder_1.toString();
      };
      return ObjectExtensions.<YangTemplateProvider.Template>operator_doubleArrow(_template, _function);
    })), "argument", ((Function1<ContentAssistEntry, YangTemplateProvider.Template>) (ContentAssistEntry it) -> {
      YangTemplateProvider.Template _template = new YangTemplateProvider.Template("argument");
      final Procedure1<YangTemplateProvider.Template> _function = (YangTemplateProvider.Template it_1) -> {
        StringConcatenation _builder = new StringConcatenation();
        _builder.append("argument ${1:argument-name} {");
        _builder.newLine();
        _builder.append("  ");
        _builder.append("$0");
        _builder.newLine();
        _builder.append("}");
        _builder.newLine();
        it_1.template = _builder.toString();
        StringConcatenation _builder_1 = new StringConcatenation();
        _builder_1.append("The \"argument\" statement, which is optional, takes as an argument a string that is the name of the argument to the keyword. The argument\'s name is used in the YIN mapping, where it is used as an XML attribute or element name, depending on the argument\'s \"yin-element\" statement.");
        _builder_1.newLine();
        _builder_1.newLine();
        _builder_1.append("RFC 7950, Section 7.19.2: https://tools.ietf.org/html/rfc7950#section-7.19.2");
        _builder_1.newLine();
        it_1.documentation = _builder_1.toString();
      };
      return ObjectExtensions.<YangTemplateProvider.Template>operator_doubleArrow(_template, _function);
    })), "yin-element", ((Function1<ContentAssistEntry, YangTemplateProvider.Template>) (ContentAssistEntry it) -> {
      YangTemplateProvider.Template _template = new YangTemplateProvider.Template("yin-element");
      final Procedure1<YangTemplateProvider.Template> _function = (YangTemplateProvider.Template it_1) -> {
        StringConcatenation _builder = new StringConcatenation();
        _builder.append("yin-element ${1:yin-element-name} {");
        _builder.newLine();
        _builder.append("  ");
        _builder.append("$0");
        _builder.newLine();
        _builder.append("}");
        _builder.newLine();
        it_1.template = _builder.toString();
        StringConcatenation _builder_1 = new StringConcatenation();
        _builder_1.append("The \"yin-element\" statement, which is optional, takes as an argument the string \"true\" or \"false\".  This statement indicates whether the argument is mapped to an XML element in YIN or to an XML attribute.");
        _builder_1.newLine();
        _builder_1.newLine();
        _builder_1.append("RFC 7950, Section 7.19.2.2: https://tools.ietf.org/html/rfc7950#section-7.19.2.2");
        _builder_1.newLine();
        it_1.documentation = _builder_1.toString();
      };
      return ObjectExtensions.<YangTemplateProvider.Template>operator_doubleArrow(_template, _function);
    })), "feature", ((Function1<ContentAssistEntry, YangTemplateProvider.Template>) (ContentAssistEntry it) -> {
      YangTemplateProvider.Template _template = new YangTemplateProvider.Template("feature");
      final Procedure1<YangTemplateProvider.Template> _function = (YangTemplateProvider.Template it_1) -> {
        StringConcatenation _builder = new StringConcatenation();
        _builder.append("feature ${1:feature-name} {");
        _builder.newLine();
        _builder.append("  ");
        _builder.append("$0");
        _builder.newLine();
        _builder.append("}");
        _builder.newLine();
        it_1.template = _builder.toString();
        StringConcatenation _builder_1 = new StringConcatenation();
        _builder_1.append("The \"feature\" statement is used to define a mechanism by which portions of the schema are marked as conditional.  A feature name is defined that can later be referenced using the \"if-feature\" statement.");
        _builder_1.newLine();
        _builder_1.newLine();
        _builder_1.append("RFC 7950, Section 7.20.1: https://tools.ietf.org/html/rfc7950#section-7.20.1");
        _builder_1.newLine();
        it_1.documentation = _builder_1.toString();
      };
      return ObjectExtensions.<YangTemplateProvider.Template>operator_doubleArrow(_template, _function);
    })), "if-feature", ((Function1<ContentAssistEntry, YangTemplateProvider.Template>) (ContentAssistEntry it) -> {
      YangTemplateProvider.Template _template = new YangTemplateProvider.Template("if-feature");
      final Procedure1<YangTemplateProvider.Template> _function = (YangTemplateProvider.Template it_1) -> {
        StringConcatenation _builder = new StringConcatenation();
        _builder.append("if-feature ${1:}$2;$0");
        _builder.newLine();
        it_1.template = _builder.toString();
        StringConcatenation _builder_1 = new StringConcatenation();
        _builder_1.append("The \"if-feature\" statement makes its parent statement conditional. The argument is a boolean expression over feature names.  In this expression, a feature name evaluates to \"true\" if and only if the feature is supported by the server.");
        _builder_1.newLine();
        _builder_1.newLine();
        _builder_1.append("RFC 7950, Section 7.20.2: https://tools.ietf.org/html/rfc7950#section-7.20.2");
        _builder_1.newLine();
        it_1.documentation = _builder_1.toString();
      };
      return ObjectExtensions.<YangTemplateProvider.Template>operator_doubleArrow(_template, _function);
    })), "deviation", ((Function1<ContentAssistEntry, YangTemplateProvider.Template>) (ContentAssistEntry it) -> {
      YangTemplateProvider.Template _template = new YangTemplateProvider.Template("deviation");
      final Procedure1<YangTemplateProvider.Template> _function = (YangTemplateProvider.Template it_1) -> {
        StringConcatenation _builder = new StringConcatenation();
        _builder.append("deviation ${1:node-identifier} {");
        _builder.newLine();
        _builder.append("  ");
        _builder.append("deviate ${2:deviate-action} {");
        _builder.newLine();
        _builder.append("    ");
        _builder.append("$3");
        _builder.newLine();
        _builder.append("  ");
        _builder.append("}");
        _builder.newLine();
        _builder.append("  ");
        _builder.append("$0");
        _builder.newLine();
        _builder.append("}");
        _builder.newLine();
        it_1.template = _builder.toString();
        StringConcatenation _builder_1 = new StringConcatenation();
        _builder_1.append("The \"deviation\" statement defines a hierarchy of a module that the server does not implement faithfully.  The argument is a string that identifies the node in the schema tree where a deviation from the module occurs.  This node is called the deviation\'s target node.");
        _builder_1.newLine();
        _builder_1.newLine();
        _builder_1.append("RFC 7950, Section 7.20.3: https://tools.ietf.org/html/rfc7950#section-7.20.3");
        _builder_1.newLine();
        it_1.documentation = _builder_1.toString();
      };
      return ObjectExtensions.<YangTemplateProvider.Template>operator_doubleArrow(_template, _function);
    })), "deviate", ((Function1<ContentAssistEntry, YangTemplateProvider.Template>) (ContentAssistEntry it) -> {
      YangTemplateProvider.Template _template = new YangTemplateProvider.Template("deviate");
      final Procedure1<YangTemplateProvider.Template> _function = (YangTemplateProvider.Template it_1) -> {
        StringConcatenation _builder = new StringConcatenation();
        _builder.append("deviate ${1:deviate-action} {");
        _builder.newLine();
        _builder.append("  ");
        _builder.append("$2");
        _builder.newLine();
        _builder.append("}$0");
        _builder.newLine();
        it_1.template = _builder.toString();
        StringConcatenation _builder_1 = new StringConcatenation();
        _builder_1.append("The \"deviate\" statement defines how the server\'s implementation of the target node deviates from its original definition.  The argument is one of the strings \"not-supported\", \"add\", \"replace\", or \"delete\".");
        _builder_1.newLine();
        _builder_1.newLine();
        _builder_1.append("RFC 7950, Section 7.20.3.2: https://tools.ietf.org/html/rfc7950#section-7.20.3.2");
        _builder_1.newLine();
        it_1.documentation = _builder_1.toString();
      };
      return ObjectExtensions.<YangTemplateProvider.Template>operator_doubleArrow(_template, _function);
    })), "config", ((Function1<ContentAssistEntry, YangTemplateProvider.Template>) (ContentAssistEntry it) -> {
      YangTemplateProvider.Template _template = new YangTemplateProvider.Template("config");
      final Procedure1<YangTemplateProvider.Template> _function = (YangTemplateProvider.Template it_1) -> {
        StringConcatenation _builder = new StringConcatenation();
        _builder.append("config ${1:false};$0");
        _builder.newLine();
        it_1.template = _builder.toString();
        StringConcatenation _builder_1 = new StringConcatenation();
        _builder_1.append("The \"config\" statement takes as an argument the string \"true\" or \"false\".  If \"config\" is \"true\", the definition represents configuration.  Data nodes representing configuration are part of configuration datastores.");
        _builder_1.newLine();
        _builder_1.newLine();
        _builder_1.append("RFC 7950, Section 7.21.1: https://tools.ietf.org/html/rfc7950#section-7.21.1");
        _builder_1.newLine();
        it_1.documentation = _builder_1.toString();
      };
      return ObjectExtensions.<YangTemplateProvider.Template>operator_doubleArrow(_template, _function);
    })), "status", ((Function1<ContentAssistEntry, YangTemplateProvider.Template>) (ContentAssistEntry it) -> {
      YangTemplateProvider.Template _template = new YangTemplateProvider.Template("status");
      final Procedure1<YangTemplateProvider.Template> _function = (YangTemplateProvider.Template it_1) -> {
        StringConcatenation _builder = new StringConcatenation();
        _builder.append("status ${1:current};$0");
        _builder.newLine();
        it_1.template = _builder.toString();
        StringConcatenation _builder_1 = new StringConcatenation();
        _builder_1.append("The \"status\" statement takes as an argument one of the strings \"current\", \"deprecated\", or \"obsolete\". If no status is specified, the default is \"current\".");
        _builder_1.newLine();
        _builder_1.newLine();
        _builder_1.append("RFC 7950, Section 7.21.2: https://tools.ietf.org/html/rfc7950#section-7.21.2");
        _builder_1.newLine();
        it_1.documentation = _builder_1.toString();
      };
      return ObjectExtensions.<YangTemplateProvider.Template>operator_doubleArrow(_template, _function);
    })), "description", ((Function1<ContentAssistEntry, YangTemplateProvider.Template>) (ContentAssistEntry it) -> {
      YangTemplateProvider.Template _template = new YangTemplateProvider.Template("description");
      final Procedure1<YangTemplateProvider.Template> _function = (YangTemplateProvider.Template it_1) -> {
        StringConcatenation _builder = new StringConcatenation();
        _builder.append("description \"${1:}\";$0");
        _builder.newLine();
        it_1.template = _builder.toString();
        StringConcatenation _builder_1 = new StringConcatenation();
        _builder_1.append("The \"description\" statement takes as an argument a string that contains a human-readable textual description of this definition. The text is provided in a language (or languages) chosen by the module developer.");
        _builder_1.newLine();
        _builder_1.newLine();
        _builder_1.append("RFC 7950, Section 7.21.3: https://tools.ietf.org/html/rfc7950#section-7.21.3");
        _builder_1.newLine();
        it_1.documentation = _builder_1.toString();
      };
      return ObjectExtensions.<YangTemplateProvider.Template>operator_doubleArrow(_template, _function);
    })), "reference", ((Function1<ContentAssistEntry, YangTemplateProvider.Template>) (ContentAssistEntry it) -> {
      YangTemplateProvider.Template _template = new YangTemplateProvider.Template("reference");
      final Procedure1<YangTemplateProvider.Template> _function = (YangTemplateProvider.Template it_1) -> {
        StringConcatenation _builder = new StringConcatenation();
        _builder.append("reference \"${1:}\";$0");
        _builder.newLine();
        it_1.template = _builder.toString();
        StringConcatenation _builder_1 = new StringConcatenation();
        _builder_1.append("The \"reference\" statement takes as an argument a string that is a human-readable cross-reference to an external document -- either another module that defines related management information or a document that provides additional information relevant to this definition.");
        _builder_1.newLine();
        _builder_1.newLine();
        _builder_1.append("RFC 7950, Section 7.21.4: https://tools.ietf.org/html/rfc7950#section-7.21.4");
        _builder_1.newLine();
        it_1.documentation = _builder_1.toString();
      };
      return ObjectExtensions.<YangTemplateProvider.Template>operator_doubleArrow(_template, _function);
    })), "when", ((Function1<ContentAssistEntry, YangTemplateProvider.Template>) (ContentAssistEntry it) -> {
      YangTemplateProvider.Template _template = new YangTemplateProvider.Template("when");
      final Procedure1<YangTemplateProvider.Template> _function = (YangTemplateProvider.Template it_1) -> {
        StringConcatenation _builder = new StringConcatenation();
        _builder.append("when \"${1:expression}\";$0");
        _builder.newLine();
        it_1.template = _builder.toString();
        StringConcatenation _builder_1 = new StringConcatenation();
        _builder_1.append(" ");
        _builder_1.append("The \"when\" statement makes its parent data definition statement conditional.  The node defined by the parent data definition statement is only valid when the condition specified by the \"when\" statement is satisfied.  The statement\'s argument is an XPath expression, which is used to formally specify this condition.");
        _builder_1.newLine();
        _builder_1.newLine();
        _builder_1.append("RFC 7950, Section 7.21.5: https://tools.ietf.org/html/rfc7950#section-7.21.5");
        _builder_1.newLine();
        it_1.documentation = _builder_1.toString();
      };
      return ObjectExtensions.<YangTemplateProvider.Template>operator_doubleArrow(_template, _function);
    })));
  }
  
  private final Multimap<String, Function1<? super ContentAssistEntry, ? extends YangTemplateProvider.Template>> templates;
  
  public YangTemplateProvider() {
    this.templates = YangTemplateProvider.YangTemplates.ALL_TEMPLATES;
  }
  
  /**
   * Returns with all templates for a particular keyword. If no templates are registered for the keyword argument,
   * returns with an empty iterable.
   */
  public Iterable<YangTemplateProvider.Template> getTemplatesForKeyword(final ContentAssistEntry entry) {
    String _elvis = null;
    String _proposal = entry.getProposal();
    if (_proposal != null) {
      _elvis = _proposal;
    } else {
      String _label = entry.getLabel();
      _elvis = _label;
    }
    final Function1<Function1<? super ContentAssistEntry, ? extends YangTemplateProvider.Template>, YangTemplateProvider.Template> _function = (Function1<? super ContentAssistEntry, ? extends YangTemplateProvider.Template> it) -> {
      return it.apply(entry);
    };
    return IterableExtensions.<Function1<? super ContentAssistEntry, ? extends YangTemplateProvider.Template>, YangTemplateProvider.Template>map(this.templates.get(_elvis), _function);
  }
}

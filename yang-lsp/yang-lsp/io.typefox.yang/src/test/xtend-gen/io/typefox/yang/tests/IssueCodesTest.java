package io.typefox.yang.tests;

import com.google.common.collect.Maps;
import com.google.inject.Inject;
import io.typefox.yang.tests.AbstractYangTest;
import io.typefox.yang.validation.IssueCodes;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.HashMap;
import java.util.function.Consumer;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.preferences.PreferenceKey;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ErrorCollector;

/**
 * Test to verify that all issues codes are available from the {@link IssueCodes#getConfigurableIssueCodes()
 * configurable issue codes}, in other words; no dangling issue codes exist.
 * 
 * @author akos.kitta
 */
@SuppressWarnings("all")
public class IssueCodesTest extends AbstractYangTest {
  @Rule
  public final ErrorCollector collector = new ErrorCollector();
  
  @Inject
  @Extension
  private IssueCodes _issueCodes;
  
  @Test
  public void checkCodes() {
    final HashMap<String, PreferenceKey> copy = Maps.<String, PreferenceKey>newHashMap(this._issueCodes.getConfigurableIssueCodes());
    final Function1<Field, Boolean> _function = (Field it) -> {
      return Boolean.valueOf(((Modifier.isStatic(it.getModifiers()) && Modifier.isPublic(it.getModifiers())) && (it.getType() == String.class)));
    };
    final Function1<Field, String> _function_1 = (Field it) -> {
      try {
        Object _get = it.get(null);
        return ((String) _get);
      } catch (Throwable _e) {
        throw Exceptions.sneakyThrow(_e);
      }
    };
    final Consumer<String> _function_2 = (String it) -> {
      final PreferenceKey value = copy.remove(it);
      if ((value == null)) {
        StringConcatenation _builder = new StringConcatenation();
        _builder.append("Issue code \'");
        _builder.append(it);
        _builder.append("\' was not registerted among the configurable codes although it is declared as a code.");
        final String message = _builder.toString();
        IllegalStateException _illegalStateException = new IllegalStateException(message);
        this.collector.addError(_illegalStateException);
      }
    };
    IterableExtensions.<Field, String>map(IterableExtensions.<Field>filter(((Iterable<Field>)Conversions.doWrapArray(IssueCodes.class.getDeclaredFields())), _function), _function_1).forEach(_function_2);
    final Consumer<String> _function_3 = (String it) -> {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("Issue code \'");
      _builder.append(it);
      _builder.append("\' was registerted among the configurable codes although it is not declared as a code.");
      final String message = _builder.toString();
      IllegalStateException _illegalStateException = new IllegalStateException(message);
      this.collector.addError(_illegalStateException);
    };
    copy.keySet().forEach(_function_3);
  }
}

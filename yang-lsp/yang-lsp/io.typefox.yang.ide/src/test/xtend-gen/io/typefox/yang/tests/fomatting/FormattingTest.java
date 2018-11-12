package io.typefox.yang.tests.fomatting;

import com.google.common.base.Charsets;
import com.google.common.io.Files;
import io.typefox.yang.tests.AbstractYangLSPTest;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.function.Consumer;
import org.eclipse.xtend.lib.annotations.FinalFieldsConstructor;
import org.eclipse.xtext.testing.FormattingConfiguration;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.junit.ComparisonFailure;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@FinalFieldsConstructor
@RunWith(Parameterized.class)
@SuppressWarnings("all")
public class FormattingTest extends AbstractYangLSPTest {
  @Parameterized.Parameters(name = "{0}")
  public static Collection<Object[]> getFiles() {
    final ArrayList<Object[]> params = CollectionLiterals.<Object[]>newArrayList();
    File _file = new File("./src/test/resources");
    final Procedure1<File> _function = (File it) -> {
      final Object[] arr = new Object[1];
      arr[0] = it;
      params.add(arr);
    };
    FormattingTest.scan(_file, _function);
    return params;
  }
  
  public static void scan(final File it, @Extension final Procedure1<? super File> acceptor) {
    boolean _isDirectory = it.isDirectory();
    if (_isDirectory) {
      final File[] contents = it.listFiles();
      final Function1<File, Boolean> _function = (File it_1) -> {
        return Boolean.valueOf(it_1.isFile());
      };
      final Consumer<File> _function_1 = (File it_1) -> {
        acceptor.apply(it_1);
      };
      IterableExtensions.<File>filter(((Iterable<File>)Conversions.doWrapArray(contents)), _function).forEach(_function_1);
      final Function1<File, Boolean> _function_2 = (File it_1) -> {
        return Boolean.valueOf(it_1.isDirectory());
      };
      final Consumer<File> _function_3 = (File it_1) -> {
        FormattingTest.scan(it_1, acceptor);
      };
      IterableExtensions.<File>filter(((Iterable<File>)Conversions.doWrapArray(contents)), _function_2).forEach(_function_3);
    }
  }
  
  private final File file;
  
  @Test
  public void testFormatting_ignoring_comparision_failures() {
    try {
      final String content = Files.toString(this.file, Charsets.UTF_8);
      try {
        final Procedure1<FormattingConfiguration> _function = (FormattingConfiguration it) -> {
          it.setModel(content);
          it.setExpectedText(content);
        };
        this.testFormatting(_function);
      } catch (final Throwable _t) {
        if (_t instanceof ComparisonFailure) {
        } else {
          throw Exceptions.sneakyThrow(_t);
        }
      }
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  public FormattingTest(final File file) {
    super();
    this.file = file;
  }
}

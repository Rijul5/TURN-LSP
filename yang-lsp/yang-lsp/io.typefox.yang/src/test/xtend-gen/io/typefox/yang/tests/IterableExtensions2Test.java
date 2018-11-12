package io.typefox.yang.tests;

import io.typefox.yang.utils.IterableExtensions2;
import java.util.Collections;
import java.util.List;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.junit.Assert;
import org.junit.Test;

/**
 * Test for the iterables extensions.
 * 
 * @author akos.kitta
 */
@SuppressWarnings("all")
public class IterableExtensions2Test {
  @Test(expected = NullPointerException.class)
  public void check_toPrettyString_01() {
    IterableExtensions2.toPrettyString(((List<?>) null), "does not matter");
  }
  
  @Test
  public void check_toPrettyString_02() {
    Assert.assertEquals("", IterableExtensions2.toPrettyString(CollectionLiterals.<Object>emptyList(), "does not matter"));
  }
  
  @Test
  public void check_toPrettyString_03() {
    Assert.assertEquals("a", IterableExtensions2.toPrettyString(Collections.<Object>unmodifiableList(CollectionLiterals.<Object>newArrayList("a")), "does not matter"));
  }
  
  @Test
  public void check_toPrettyString_04() {
    Assert.assertEquals("a, b", IterableExtensions2.toPrettyString(Collections.<Object>unmodifiableList(CollectionLiterals.<Object>newArrayList("a", "b")), null));
  }
  
  @Test
  public void check_toPrettyString_05() {
    Assert.assertEquals("a, b, c", IterableExtensions2.toPrettyString(Collections.<Object>unmodifiableList(CollectionLiterals.<Object>newArrayList("a", "b", "c")), null));
  }
  
  @Test
  public void check_toPrettyString_06() {
    Assert.assertEquals("a, b or c", IterableExtensions2.toPrettyString(Collections.<Object>unmodifiableList(CollectionLiterals.<Object>newArrayList("a", "b", "c")), "or"));
  }
}

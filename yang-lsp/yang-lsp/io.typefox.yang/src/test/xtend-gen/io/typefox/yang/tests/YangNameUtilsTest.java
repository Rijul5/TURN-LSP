package io.typefox.yang.tests;

import io.typefox.yang.utils.YangNameUtils;
import org.junit.Assert;
import org.junit.Test;

/**
 * Test for the YANG name utilities class.
 * 
 * @author akos.kitta
 */
@SuppressWarnings("all")
public class YangNameUtilsTest {
  @Test
  public void check_escapeModuleName_01() {
    Assert.assertEquals("foo-bar", YangNameUtils.escapeModuleName("foo bar"));
  }
  
  @Test
  public void check_escapeModuleName_02() {
    Assert.assertEquals("foo-bar", YangNameUtils.escapeModuleName("  foo bar"));
  }
  
  @Test
  public void check_escapeModuleName_03() {
    Assert.assertEquals("foo-bar", YangNameUtils.escapeModuleName("foo bar  "));
  }
  
  @Test
  public void check_escapeModuleName_04() {
    Assert.assertEquals("foo-bar", YangNameUtils.escapeModuleName("foo bar"));
  }
  
  @Test
  public void check_escapeModuleName_05() {
    Assert.assertEquals("foo-bar", YangNameUtils.escapeModuleName("foo   bar"));
  }
  
  @Test
  public void check_escapeModuleName_07() {
    Assert.assertEquals("foo-bar", YangNameUtils.escapeModuleName("foo\n\nbar"));
  }
  
  @Test
  public void check_escapeModuleName_08() {
    Assert.assertEquals("foo-bar", YangNameUtils.escapeModuleName("foo bar\t\n"));
  }
  
  @Test
  public void check_escapeModuleName_06() {
    Assert.assertEquals("foo-bar-baz", YangNameUtils.escapeModuleName("foo  bar  baz"));
  }
}

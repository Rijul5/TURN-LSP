package io.typefox.yang.tests;

import org.eclipse.xtext.testing.AbstractLanguageServerTest;

@SuppressWarnings("all")
public abstract class AbstractYangLSPTest extends AbstractLanguageServerTest {
  public AbstractYangLSPTest() {
    super("yang");
  }
}

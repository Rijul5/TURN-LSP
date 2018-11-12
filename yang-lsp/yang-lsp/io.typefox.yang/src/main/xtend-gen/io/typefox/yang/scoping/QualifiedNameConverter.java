package io.typefox.yang.scoping;

import org.eclipse.xtext.naming.IQualifiedNameConverter;

@SuppressWarnings("all")
public class QualifiedNameConverter extends IQualifiedNameConverter.DefaultImpl {
  @Override
  public String getDelimiter() {
    return ":";
  }
}

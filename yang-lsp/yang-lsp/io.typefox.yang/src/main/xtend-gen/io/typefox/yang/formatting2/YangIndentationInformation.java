package io.typefox.yang.formatting2;

import org.eclipse.xtext.formatting.IIndentationInformation;

/**
 * Indentation information for YANG. Instead of the default tab ({@code \t}) it uses
 * four spaces ({@code [ ][ ][ ][ ]}).
 * 
 * @author akos.kitta
 */
@SuppressWarnings("all")
public class YangIndentationInformation implements IIndentationInformation {
  @Override
  public String getIndentString() {
    return "    ";
  }
}

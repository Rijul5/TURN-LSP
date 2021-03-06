/**
 * generated by Xtext 2.16.0-SNAPSHOT
 */
package io.typefox.yang.yang;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Pattern</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link io.typefox.yang.yang.Pattern#getRegexp <em>Regexp</em>}</li>
 * </ul>
 *
 * @see io.typefox.yang.yang.YangPackage#getPattern()
 * @model
 * @generated
 */
public interface Pattern extends OtherStatement
{
  /**
   * Returns the value of the '<em><b>Regexp</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Regexp</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Regexp</em>' attribute.
   * @see #setRegexp(String)
   * @see io.typefox.yang.yang.YangPackage#getPattern_Regexp()
   * @model
   * @generated
   */
  String getRegexp();

  /**
   * Sets the value of the '{@link io.typefox.yang.yang.Pattern#getRegexp <em>Regexp</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Regexp</em>' attribute.
   * @see #getRegexp()
   * @generated
   */
  void setRegexp(String value);

} // Pattern

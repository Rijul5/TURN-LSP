/**
 * generated by Xtext 2.16.0-SNAPSHOT
 */
package io.typefox.yang.yang;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Reference</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link io.typefox.yang.yang.Reference#getReference <em>Reference</em>}</li>
 * </ul>
 *
 * @see io.typefox.yang.yang.YangPackage#getReference()
 * @model
 * @generated
 */
public interface Reference extends OtherStatement
{
  /**
   * Returns the value of the '<em><b>Reference</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Reference</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Reference</em>' attribute.
   * @see #setReference(String)
   * @see io.typefox.yang.yang.YangPackage#getReference_Reference()
   * @model
   * @generated
   */
  String getReference();

  /**
   * Sets the value of the '{@link io.typefox.yang.yang.Reference#getReference <em>Reference</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Reference</em>' attribute.
   * @see #getReference()
   * @generated
   */
  void setReference(String value);

} // Reference
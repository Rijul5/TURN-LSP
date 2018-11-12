/**
 * generated by Xtext 2.16.0-SNAPSHOT
 */
package io.typefox.yang.yang;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Augment</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link io.typefox.yang.yang.Augment#getPath <em>Path</em>}</li>
 * </ul>
 *
 * @see io.typefox.yang.yang.YangPackage#getAugment()
 * @model
 * @generated
 */
public interface Augment extends OtherStatement
{
  /**
   * Returns the value of the '<em><b>Path</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Path</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Path</em>' containment reference.
   * @see #setPath(SchemaNodeIdentifier)
   * @see io.typefox.yang.yang.YangPackage#getAugment_Path()
   * @model containment="true"
   * @generated
   */
  SchemaNodeIdentifier getPath();

  /**
   * Sets the value of the '{@link io.typefox.yang.yang.Augment#getPath <em>Path</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Path</em>' containment reference.
   * @see #getPath()
   * @generated
   */
  void setPath(SchemaNodeIdentifier value);

} // Augment
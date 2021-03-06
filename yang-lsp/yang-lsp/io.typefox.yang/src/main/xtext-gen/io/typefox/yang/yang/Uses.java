/**
 * generated by Xtext 2.16.0-SNAPSHOT
 */
package io.typefox.yang.yang;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Uses</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link io.typefox.yang.yang.Uses#getGrouping <em>Grouping</em>}</li>
 * </ul>
 *
 * @see io.typefox.yang.yang.YangPackage#getUses()
 * @model
 * @generated
 */
public interface Uses extends OtherStatement
{
  /**
   * Returns the value of the '<em><b>Grouping</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Grouping</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Grouping</em>' containment reference.
   * @see #setGrouping(GroupingRef)
   * @see io.typefox.yang.yang.YangPackage#getUses_Grouping()
   * @model containment="true"
   * @generated
   */
  GroupingRef getGrouping();

  /**
   * Sets the value of the '{@link io.typefox.yang.yang.Uses#getGrouping <em>Grouping</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Grouping</em>' containment reference.
   * @see #getGrouping()
   * @generated
   */
  void setGrouping(GroupingRef value);

} // Uses

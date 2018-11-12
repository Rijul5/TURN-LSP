/**
 * generated by Xtext 2.16.0-SNAPSHOT
 */
package io.typefox.yang.yang;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Xpath Step</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link io.typefox.yang.yang.XpathStep#getAxis <em>Axis</em>}</li>
 *   <li>{@link io.typefox.yang.yang.XpathStep#getNode <em>Node</em>}</li>
 * </ul>
 *
 * @see io.typefox.yang.yang.YangPackage#getXpathStep()
 * @model
 * @generated
 */
public interface XpathStep extends EObject
{
  /**
   * Returns the value of the '<em><b>Axis</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Axis</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Axis</em>' attribute.
   * @see #setAxis(String)
   * @see io.typefox.yang.yang.YangPackage#getXpathStep_Axis()
   * @model
   * @generated
   */
  String getAxis();

  /**
   * Sets the value of the '{@link io.typefox.yang.yang.XpathStep#getAxis <em>Axis</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Axis</em>' attribute.
   * @see #getAxis()
   * @generated
   */
  void setAxis(String value);

  /**
   * Returns the value of the '<em><b>Node</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Node</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Node</em>' containment reference.
   * @see #setNode(XpathNodeTest)
   * @see io.typefox.yang.yang.YangPackage#getXpathStep_Node()
   * @model containment="true"
   * @generated
   */
  XpathNodeTest getNode();

  /**
   * Sets the value of the '{@link io.typefox.yang.yang.XpathStep#getNode <em>Node</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Node</em>' containment reference.
   * @see #getNode()
   * @generated
   */
  void setNode(XpathNodeTest value);

} // XpathStep
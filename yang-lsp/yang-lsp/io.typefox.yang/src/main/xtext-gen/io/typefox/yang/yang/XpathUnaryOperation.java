/**
 * generated by Xtext 2.16.0-SNAPSHOT
 */
package io.typefox.yang.yang;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Xpath Unary Operation</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link io.typefox.yang.yang.XpathUnaryOperation#getOperator <em>Operator</em>}</li>
 *   <li>{@link io.typefox.yang.yang.XpathUnaryOperation#getTarget <em>Target</em>}</li>
 * </ul>
 *
 * @see io.typefox.yang.yang.YangPackage#getXpathUnaryOperation()
 * @model
 * @generated
 */
public interface XpathUnaryOperation extends XpathExpression
{
  /**
   * Returns the value of the '<em><b>Operator</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Operator</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Operator</em>' attribute.
   * @see #setOperator(String)
   * @see io.typefox.yang.yang.YangPackage#getXpathUnaryOperation_Operator()
   * @model
   * @generated
   */
  String getOperator();

  /**
   * Sets the value of the '{@link io.typefox.yang.yang.XpathUnaryOperation#getOperator <em>Operator</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Operator</em>' attribute.
   * @see #getOperator()
   * @generated
   */
  void setOperator(String value);

  /**
   * Returns the value of the '<em><b>Target</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Target</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Target</em>' containment reference.
   * @see #setTarget(XpathExpression)
   * @see io.typefox.yang.yang.YangPackage#getXpathUnaryOperation_Target()
   * @model containment="true"
   * @generated
   */
  XpathExpression getTarget();

  /**
   * Sets the value of the '{@link io.typefox.yang.yang.XpathUnaryOperation#getTarget <em>Target</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Target</em>' containment reference.
   * @see #getTarget()
   * @generated
   */
  void setTarget(XpathExpression value);

} // XpathUnaryOperation
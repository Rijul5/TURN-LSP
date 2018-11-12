/**
 * generated by Xtext 2.16.0-SNAPSHOT
 */
package io.typefox.yang.yang.impl;

import io.typefox.yang.yang.Status;
import io.typefox.yang.yang.YangPackage;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Status</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link io.typefox.yang.yang.impl.StatusImpl#getArgument <em>Argument</em>}</li>
 * </ul>
 *
 * @generated
 */
public class StatusImpl extends OtherStatementImpl implements Status
{
  /**
   * The default value of the '{@link #getArgument() <em>Argument</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getArgument()
   * @generated
   * @ordered
   */
  protected static final String ARGUMENT_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getArgument() <em>Argument</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getArgument()
   * @generated
   * @ordered
   */
  protected String argument = ARGUMENT_EDEFAULT;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected StatusImpl()
  {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected EClass eStaticClass()
  {
    return YangPackage.Literals.STATUS;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getArgument()
  {
    return argument;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setArgument(String newArgument)
  {
    String oldArgument = argument;
    argument = newArgument;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, YangPackage.STATUS__ARGUMENT, oldArgument, argument));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Object eGet(int featureID, boolean resolve, boolean coreType)
  {
    switch (featureID)
    {
      case YangPackage.STATUS__ARGUMENT:
        return getArgument();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void eSet(int featureID, Object newValue)
  {
    switch (featureID)
    {
      case YangPackage.STATUS__ARGUMENT:
        setArgument((String)newValue);
        return;
    }
    super.eSet(featureID, newValue);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void eUnset(int featureID)
  {
    switch (featureID)
    {
      case YangPackage.STATUS__ARGUMENT:
        setArgument(ARGUMENT_EDEFAULT);
        return;
    }
    super.eUnset(featureID);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public boolean eIsSet(int featureID)
  {
    switch (featureID)
    {
      case YangPackage.STATUS__ARGUMENT:
        return ARGUMENT_EDEFAULT == null ? argument != null : !ARGUMENT_EDEFAULT.equals(argument);
    }
    return super.eIsSet(featureID);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String toString()
  {
    if (eIsProxy()) return super.toString();

    StringBuffer result = new StringBuffer(super.toString());
    result.append(" (argument: ");
    result.append(argument);
    result.append(')');
    return result.toString();
  }

} //StatusImpl
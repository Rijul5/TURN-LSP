/**
 * generated by Xtext 2.16.0-SNAPSHOT
 */
package io.typefox.yang.yang.impl;

import io.typefox.yang.yang.Ordered;
import io.typefox.yang.yang.YangPackage;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ordered</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link io.typefox.yang.yang.impl.OrderedImpl#getOrdinal <em>Ordinal</em>}</li>
 * </ul>
 *
 * @generated
 */
public class OrderedImpl extends OtherStatementImpl implements Ordered
{
  /**
   * The default value of the '{@link #getOrdinal() <em>Ordinal</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getOrdinal()
   * @generated
   * @ordered
   */
  protected static final String ORDINAL_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getOrdinal() <em>Ordinal</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getOrdinal()
   * @generated
   * @ordered
   */
  protected String ordinal = ORDINAL_EDEFAULT;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected OrderedImpl()
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
    return YangPackage.Literals.ORDERED;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getOrdinal()
  {
    return ordinal;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setOrdinal(String newOrdinal)
  {
    String oldOrdinal = ordinal;
    ordinal = newOrdinal;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, YangPackage.ORDERED__ORDINAL, oldOrdinal, ordinal));
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
      case YangPackage.ORDERED__ORDINAL:
        return getOrdinal();
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
      case YangPackage.ORDERED__ORDINAL:
        setOrdinal((String)newValue);
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
      case YangPackage.ORDERED__ORDINAL:
        setOrdinal(ORDINAL_EDEFAULT);
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
      case YangPackage.ORDERED__ORDINAL:
        return ORDINAL_EDEFAULT == null ? ordinal != null : !ORDINAL_EDEFAULT.equals(ordinal);
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
    result.append(" (ordinal: ");
    result.append(ordinal);
    result.append(')');
    return result.toString();
  }

} //OrderedImpl

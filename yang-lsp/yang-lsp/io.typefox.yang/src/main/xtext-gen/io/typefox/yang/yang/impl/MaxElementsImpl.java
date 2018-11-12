/**
 * generated by Xtext 2.16.0-SNAPSHOT
 */
package io.typefox.yang.yang.impl;

import io.typefox.yang.yang.MaxElements;
import io.typefox.yang.yang.YangPackage;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Max Elements</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link io.typefox.yang.yang.impl.MaxElementsImpl#getMaxElements <em>Max Elements</em>}</li>
 * </ul>
 *
 * @generated
 */
public class MaxElementsImpl extends OtherStatementImpl implements MaxElements
{
  /**
   * The default value of the '{@link #getMaxElements() <em>Max Elements</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getMaxElements()
   * @generated
   * @ordered
   */
  protected static final String MAX_ELEMENTS_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getMaxElements() <em>Max Elements</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getMaxElements()
   * @generated
   * @ordered
   */
  protected String maxElements = MAX_ELEMENTS_EDEFAULT;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected MaxElementsImpl()
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
    return YangPackage.Literals.MAX_ELEMENTS;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getMaxElements()
  {
    return maxElements;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setMaxElements(String newMaxElements)
  {
    String oldMaxElements = maxElements;
    maxElements = newMaxElements;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, YangPackage.MAX_ELEMENTS__MAX_ELEMENTS, oldMaxElements, maxElements));
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
      case YangPackage.MAX_ELEMENTS__MAX_ELEMENTS:
        return getMaxElements();
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
      case YangPackage.MAX_ELEMENTS__MAX_ELEMENTS:
        setMaxElements((String)newValue);
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
      case YangPackage.MAX_ELEMENTS__MAX_ELEMENTS:
        setMaxElements(MAX_ELEMENTS_EDEFAULT);
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
      case YangPackage.MAX_ELEMENTS__MAX_ELEMENTS:
        return MAX_ELEMENTS_EDEFAULT == null ? maxElements != null : !MAX_ELEMENTS_EDEFAULT.equals(maxElements);
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
    result.append(" (maxElements: ");
    result.append(maxElements);
    result.append(')');
    return result.toString();
  }

} //MaxElementsImpl
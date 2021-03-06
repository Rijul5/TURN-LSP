/**
 * generated by Xtext 2.16.0-SNAPSHOT
 */
package io.typefox.yang.yang.impl;

import io.typefox.yang.yang.AbsolutePath;
import io.typefox.yang.yang.XpathStep;
import io.typefox.yang.yang.YangPackage;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Absolute Path</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link io.typefox.yang.yang.impl.AbsolutePathImpl#isIsDescendants <em>Is Descendants</em>}</li>
 *   <li>{@link io.typefox.yang.yang.impl.AbsolutePathImpl#getStep <em>Step</em>}</li>
 * </ul>
 *
 * @generated
 */
public class AbsolutePathImpl extends XpathExpressionImpl implements AbsolutePath
{
  /**
   * The default value of the '{@link #isIsDescendants() <em>Is Descendants</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isIsDescendants()
   * @generated
   * @ordered
   */
  protected static final boolean IS_DESCENDANTS_EDEFAULT = false;

  /**
   * The cached value of the '{@link #isIsDescendants() <em>Is Descendants</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isIsDescendants()
   * @generated
   * @ordered
   */
  protected boolean isDescendants = IS_DESCENDANTS_EDEFAULT;

  /**
   * The cached value of the '{@link #getStep() <em>Step</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getStep()
   * @generated
   * @ordered
   */
  protected XpathStep step;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected AbsolutePathImpl()
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
    return YangPackage.Literals.ABSOLUTE_PATH;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isIsDescendants()
  {
    return isDescendants;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setIsDescendants(boolean newIsDescendants)
  {
    boolean oldIsDescendants = isDescendants;
    isDescendants = newIsDescendants;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, YangPackage.ABSOLUTE_PATH__IS_DESCENDANTS, oldIsDescendants, isDescendants));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public XpathStep getStep()
  {
    return step;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetStep(XpathStep newStep, NotificationChain msgs)
  {
    XpathStep oldStep = step;
    step = newStep;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, YangPackage.ABSOLUTE_PATH__STEP, oldStep, newStep);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setStep(XpathStep newStep)
  {
    if (newStep != step)
    {
      NotificationChain msgs = null;
      if (step != null)
        msgs = ((InternalEObject)step).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - YangPackage.ABSOLUTE_PATH__STEP, null, msgs);
      if (newStep != null)
        msgs = ((InternalEObject)newStep).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - YangPackage.ABSOLUTE_PATH__STEP, null, msgs);
      msgs = basicSetStep(newStep, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, YangPackage.ABSOLUTE_PATH__STEP, newStep, newStep));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs)
  {
    switch (featureID)
    {
      case YangPackage.ABSOLUTE_PATH__STEP:
        return basicSetStep(null, msgs);
    }
    return super.eInverseRemove(otherEnd, featureID, msgs);
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
      case YangPackage.ABSOLUTE_PATH__IS_DESCENDANTS:
        return isIsDescendants();
      case YangPackage.ABSOLUTE_PATH__STEP:
        return getStep();
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
      case YangPackage.ABSOLUTE_PATH__IS_DESCENDANTS:
        setIsDescendants((Boolean)newValue);
        return;
      case YangPackage.ABSOLUTE_PATH__STEP:
        setStep((XpathStep)newValue);
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
      case YangPackage.ABSOLUTE_PATH__IS_DESCENDANTS:
        setIsDescendants(IS_DESCENDANTS_EDEFAULT);
        return;
      case YangPackage.ABSOLUTE_PATH__STEP:
        setStep((XpathStep)null);
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
      case YangPackage.ABSOLUTE_PATH__IS_DESCENDANTS:
        return isDescendants != IS_DESCENDANTS_EDEFAULT;
      case YangPackage.ABSOLUTE_PATH__STEP:
        return step != null;
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
    result.append(" (isDescendants: ");
    result.append(isDescendants);
    result.append(')');
    return result.toString();
  }

} //AbsolutePathImpl

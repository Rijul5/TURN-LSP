/**
 * generated by Xtext 2.16.0-SNAPSHOT
 */
package io.typefox.yang.yang.impl;

import io.typefox.yang.yang.Revision;
import io.typefox.yang.yang.YangPackage;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Revision</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link io.typefox.yang.yang.impl.RevisionImpl#getRevision <em>Revision</em>}</li>
 * </ul>
 *
 * @generated
 */
public class RevisionImpl extends OtherStatementImpl implements Revision
{
  /**
   * The default value of the '{@link #getRevision() <em>Revision</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getRevision()
   * @generated
   * @ordered
   */
  protected static final String REVISION_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getRevision() <em>Revision</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getRevision()
   * @generated
   * @ordered
   */
  protected String revision = REVISION_EDEFAULT;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected RevisionImpl()
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
    return YangPackage.Literals.REVISION;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getRevision()
  {
    return revision;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setRevision(String newRevision)
  {
    String oldRevision = revision;
    revision = newRevision;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, YangPackage.REVISION__REVISION, oldRevision, revision));
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
      case YangPackage.REVISION__REVISION:
        return getRevision();
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
      case YangPackage.REVISION__REVISION:
        setRevision((String)newValue);
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
      case YangPackage.REVISION__REVISION:
        setRevision(REVISION_EDEFAULT);
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
      case YangPackage.REVISION__REVISION:
        return REVISION_EDEFAULT == null ? revision != null : !REVISION_EDEFAULT.equals(revision);
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
    result.append(" (revision: ");
    result.append(revision);
    result.append(')');
    return result.toString();
  }

} //RevisionImpl

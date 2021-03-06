/**
 * generated by Xtext 2.16.0-SNAPSHOT
 */
package io.typefox.yang.yang.impl;

import io.typefox.yang.yang.DescendantSchemaNodeIdentifierReferences;
import io.typefox.yang.yang.SchemaNodeIdentifier;
import io.typefox.yang.yang.YangPackage;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Descendant Schema Node Identifier References</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link io.typefox.yang.yang.impl.DescendantSchemaNodeIdentifierReferencesImpl#getReferences <em>References</em>}</li>
 * </ul>
 *
 * @generated
 */
public class DescendantSchemaNodeIdentifierReferencesImpl extends MinimalEObjectImpl.Container implements DescendantSchemaNodeIdentifierReferences
{
  /**
   * The cached value of the '{@link #getReferences() <em>References</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getReferences()
   * @generated
   * @ordered
   */
  protected EList<SchemaNodeIdentifier> references;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected DescendantSchemaNodeIdentifierReferencesImpl()
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
    return YangPackage.Literals.DESCENDANT_SCHEMA_NODE_IDENTIFIER_REFERENCES;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<SchemaNodeIdentifier> getReferences()
  {
    if (references == null)
    {
      references = new EObjectContainmentEList<SchemaNodeIdentifier>(SchemaNodeIdentifier.class, this, YangPackage.DESCENDANT_SCHEMA_NODE_IDENTIFIER_REFERENCES__REFERENCES);
    }
    return references;
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
      case YangPackage.DESCENDANT_SCHEMA_NODE_IDENTIFIER_REFERENCES__REFERENCES:
        return ((InternalEList<?>)getReferences()).basicRemove(otherEnd, msgs);
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
      case YangPackage.DESCENDANT_SCHEMA_NODE_IDENTIFIER_REFERENCES__REFERENCES:
        return getReferences();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @SuppressWarnings("unchecked")
  @Override
  public void eSet(int featureID, Object newValue)
  {
    switch (featureID)
    {
      case YangPackage.DESCENDANT_SCHEMA_NODE_IDENTIFIER_REFERENCES__REFERENCES:
        getReferences().clear();
        getReferences().addAll((Collection<? extends SchemaNodeIdentifier>)newValue);
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
      case YangPackage.DESCENDANT_SCHEMA_NODE_IDENTIFIER_REFERENCES__REFERENCES:
        getReferences().clear();
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
      case YangPackage.DESCENDANT_SCHEMA_NODE_IDENTIFIER_REFERENCES__REFERENCES:
        return references != null && !references.isEmpty();
    }
    return super.eIsSet(featureID);
  }

} //DescendantSchemaNodeIdentifierReferencesImpl

/*
 * generated by Xtext 2.16.0-SNAPSHOT
 */
package io.typefox.yang.validation;

import java.util.ArrayList;
import java.util.List;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.xtext.validation.AbstractDeclarativeValidator;

public abstract class AbstractYangValidator extends AbstractDeclarativeValidator {
	
	@Override
	protected List<EPackage> getEPackages() {
		List<EPackage> result = new ArrayList<EPackage>();
		result.add(io.typefox.yang.yang.YangPackage.eINSTANCE);
		return result;
	}
}

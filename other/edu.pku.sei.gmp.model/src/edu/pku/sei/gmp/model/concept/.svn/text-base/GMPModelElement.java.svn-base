package edu.pku.sei.gmp.model.concept;

import edu.pku.sei.gmp.model.common.GMPModelFactory;

/**
 * Root element of all the domain model elements.
 * 
 * @author yangyz
 * 
 */
public class GMPModelElement extends GMPElement {
	public GMPModelElement newInstance(String typeString) {
		GMPModelFactory factory = this.getModel().getModelFactory();
		return factory.createModelElement(typeString);
	}
}

package edu.pku.sei.gmp.model.shape;

import edu.pku.sei.gmp.model.common.GMPModelFactory;
import edu.pku.sei.gmp.model.concept.GMPElement;

public class GMPShapeElement extends GMPElement {
	public GMPShapeElement newInstance(String typeString) {
		GMPModelFactory factory = this.getModel().getModelFactory();
		return factory.createShapeElement(typeString);
	}
}

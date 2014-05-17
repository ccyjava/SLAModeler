package edu.pku.sei.gmp.model.tuple;

import edu.pku.sei.gmp.model.common.GMPConst;
import edu.pku.sei.gmp.model.concept.GMPElement;
import edu.pku.sei.gmp.model.concept.GMPModelElement;
import edu.pku.sei.gmp.model.shape.GMPShapeElement;
import edu.pku.sei.gmp.properties.annotation.GMPAnnotation;

public class GMPTupleElement extends GMPElement {
	@GMPAnnotation(
			name = GMPConst.TUPLE_MODELELEMENT,
			getter = "getModelElement",
			setter = "setModelElement",
			reference = true
			)
	private GMPModelElement modelElement;

	@GMPAnnotation(
			name = GMPConst.TUPLE_SHAPEELEMENT,
			getter = "getShapeElement",
			setter = "setShapeElement",
			reference = true
			)
	private GMPShapeElement shapeElement;

	public GMPTupleElement() {
		
	}

	public GMPModelElement getModelElement() {
		return this.modelElement;
	}

	public GMPShapeElement getShapeElement() {
		return this.shapeElement;
	}

	public void setModelElement(GMPModelElement modelElement) {
		this.modelElement = modelElement;
	}

	public void setShapeElement(GMPShapeElement shapeElement) {
		this.shapeElement = shapeElement;
	}
}

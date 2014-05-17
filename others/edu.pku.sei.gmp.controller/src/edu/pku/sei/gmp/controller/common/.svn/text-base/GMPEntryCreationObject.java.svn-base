package edu.pku.sei.gmp.controller.common;

import edu.pku.sei.gmp.model.concept.GMPModelElement;
import edu.pku.sei.gmp.model.shape.GMPShapeElement;
import edu.pku.sei.gmp.model.tuple.GMPTupleElement;

public class GMPEntryCreationObject {

	private GMPTupleElement tupleElement;
	private boolean shapeOnly = false;

	public GMPEntryCreationObject(GMPTupleElement tuple) {
		this.tupleElement = tuple;
		this.shapeOnly = false;
	}
	
	public GMPEntryCreationObject(GMPTupleElement tuple, boolean shapeOnly) {
		this.tupleElement = tuple;
		this.shapeOnly = shapeOnly;
	}
	
	public void setShapeOnly(boolean shapeOnly) {
		this.shapeOnly = shapeOnly;
	}

	public void setTupleElement(GMPTupleElement tupleElement) {
		this.tupleElement = tupleElement;
	}

	public boolean isShapeOnly() {
		return shapeOnly;
	}

	public GMPTupleElement getTupleElement() {
		return tupleElement;
	}

	public GMPModelElement getModelElement() {
		return tupleElement.getModelElement();
	}

	public GMPShapeElement getShapeElement() {
		return tupleElement.getShapeElement();
	}

}

package edu.pku.sei.gmp.editor.palette;

import org.eclipse.gef.requests.CreationFactory;

import edu.pku.sei.gmp.controller.common.GMPEntryCreationObject;
import edu.pku.sei.gmp.model.common.GMPModel;
import edu.pku.sei.gmp.model.common.GMPModelFactory;
import edu.pku.sei.gmp.model.concept.GMPModelElement;
import edu.pku.sei.gmp.model.shape.GMPShapeElement;
import edu.pku.sei.gmp.model.tuple.GMPTupleElement;

public class GMPCreationFactory implements CreationFactory {

	private String elementType;
	
	private GMPModel model;
	
	public GMPCreationFactory(String elementType, GMPModel model) {
		this.elementType = elementType;
		this.model = model;
	}
	
	@Override
	public Object getNewObject() {
		assert (model != null);
		GMPModelFactory modelFactory = model.getModelFactory();
		GMPModelElement modelElement = modelFactory
				.createModelElement(elementType);
		GMPShapeElement shapeElement = modelFactory
				.createShapeElement(elementType);
		GMPTupleElement tupleElement = modelFactory.createTupleElement(
				modelElement, shapeElement);
		return new GMPEntryCreationObject(tupleElement);
	}

	@Override
	public Object getObjectType() {
		return elementType;
	}

}

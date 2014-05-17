package edu.pku.sei.gmp.editor.dnd;

import org.eclipse.gef.requests.CreationFactory;

import edu.pku.sei.gmp.controller.common.GMPEntryCreationObject;
import edu.pku.sei.gmp.model.common.GMPModelFactory;
import edu.pku.sei.gmp.model.concept.GMPModelElement;
import edu.pku.sei.gmp.model.shape.GMPShapeElement;
import edu.pku.sei.gmp.model.tuple.GMPTupleElement;

public class GMPDropElementCreationFactory implements CreationFactory {

	private GMPModelElement modelElement;
	
	public GMPDropElementCreationFactory() {
	}
	
	public GMPModelElement getModelElement() {
		return modelElement;
	}

	public void setModelElement(GMPModelElement modelElement) {
		this.modelElement = modelElement;
	}

	@Override
	public Object getNewObject() {
		assert (modelElement.getModel() != null);
		GMPModelFactory modelFactory = modelElement.getModel()
				.getModelFactory();
		String elementType = modelFactory.id2type(modelElement.getId());
		GMPShapeElement shapeElement = modelFactory
				.createShapeElement(elementType);
		GMPTupleElement tupleElement = modelFactory.createTupleElement(
				modelElement, shapeElement);
		return new GMPEntryCreationObject(tupleElement, true);
	}

	@Override
	public Object getObjectType() {
		return modelElement.getModel().getModelFactory().id2type(modelElement.getId());
	}

}

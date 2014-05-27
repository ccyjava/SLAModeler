package edu.pku.sei.gmp.model.common;

import java.util.List;

import edu.pku.sei.gmp.model.concept.GMPModelElement;
import edu.pku.sei.gmp.model.shape.GMPDiagram;
import edu.pku.sei.gmp.model.shape.GMPShapeElement;
import edu.pku.sei.gmp.model.tuple.GMPTupleElement;
import edu.pku.sei.gmp.model.tuple.TupleManager;
import edu.pku.sei.gmp.model.util.GMPTypedList;
import edu.pku.sei.gmp.properties.annotation.GMPAnnotation;

public class GMPModel extends GMPModelElement {
	@GMPAnnotation(
			id = "GMPModel.name",
			name = GMPConst.MODEL_NAME,
			getter = "getName",
			setter = "setName"
			)
	private String name;
	
	private GMPModelFactory modelFactory;
	
	@GMPAnnotation(
			id = "GMPModel.rootElements",
			name = GMPConst.MODEL_ROOTELEMENTS,
			getter = "getRootElements"
			)
	private GMPTypedList<GMPModelElement> rootElements = new GMPTypedList<GMPModelElement>(
			GMPConst.MODEL_ROOTELEMENTS, GMPTypedList.BAG, this,
			GMPModelElement.class, true);

	@GMPAnnotation(
			id = "GMPModel.diagrams",
			name = GMPConst.MODEL_DIAGRAMS,
			getter = "getDiagrams"
			)
	private GMPTypedList<GMPDiagram> diagrams = new GMPTypedList<GMPDiagram>(
			GMPConst.MODEL_DIAGRAMS, GMPTypedList.BAG, this, GMPDiagram.class,
			true);

	// tuple manager
	private TupleManager tupleMgr = new TupleManager();

	
	public GMPModel() {
		this.setModel(this);
	}
	
	public String getName() {
		return this.name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public GMPTypedList<GMPModelElement> getRootElements() {
		return rootElements;
	}
	
	public GMPTypedList<GMPDiagram> getDiagrams() {
		return diagrams;
	}
	
	
	public void addDiagram(GMPDiagram diagram, GMPModelElement modelElem) {
		tupleMgr.add(this.getModelFactory().createTupleElement(modelElem, diagram));
		diagrams.add(diagram);
	}

	public void removeDiagram(GMPDiagram diagram) {
		diagrams.remove(diagram);
		tupleMgr.remove(diagram);
	}
	
	public List<GMPTupleElement> getAllTuples() {
		return tupleMgr.getAllTuples();
	}
	
	public void addTuple(GMPTupleElement tuple) {
		tupleMgr.add(tuple);
	}
	
	public void removeTuple(GMPTupleElement tuple) {
		removeTuple(tuple.getShapeElement());
	}
	
	public void removeTuple(GMPShapeElement shapeElement) {
		tupleMgr.remove(shapeElement);
	}
	
	public void removeTuple(GMPModelElement modelElement) {
		tupleMgr.remove(modelElement);
	}
	
	public GMPModelElement shape2model(GMPShapeElement shapeElem) {
		return tupleMgr.getModelFromShape(shapeElem);
	}
	
	public List<GMPShapeElement> model2shape(GMPModelElement modelElem) {
		return tupleMgr.getShapesFromModel(modelElem);
	}

	public GMPTupleElement shape2tuple(GMPShapeElement shape) {
		return tupleMgr.getTupleFromShape(shape);
	}
	
	public GMPModelFactory getModelFactory() {
		return modelFactory;
	}

	public void setModelFactory(GMPModelFactory modelFactory) {
		this.modelFactory = modelFactory;
	}
	
}

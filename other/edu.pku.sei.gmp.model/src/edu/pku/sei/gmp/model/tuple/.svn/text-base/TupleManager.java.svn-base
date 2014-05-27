package edu.pku.sei.gmp.model.tuple;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

import edu.pku.sei.gmp.model.concept.GMPElement;
import edu.pku.sei.gmp.model.concept.GMPModelElement;
import edu.pku.sei.gmp.model.shape.GMPShapeElement;

public class TupleManager extends GMPElement {
	private List<GMPTupleElement> tuples = new ArrayList<GMPTupleElement>();

	private Hashtable<GMPModelElement, List<GMPShapeElement>> model2shape = 
		new Hashtable<GMPModelElement, List<GMPShapeElement>>();

	private Hashtable<GMPShapeElement, GMPModelElement> shape2model = 
		new Hashtable<GMPShapeElement, GMPModelElement>();

	public List<GMPTupleElement> getAllTuples() {
		return tuples;
	}
	
	public void add(GMPTupleElement tuple) {
		GMPModelElement modelElem = tuple.getModelElement();
		GMPShapeElement shapeElem = tuple.getShapeElement();
		tuples.add(tuple);
		List<GMPShapeElement> shapes = model2shape.get(modelElem);
		if (shapes == null) {
			shapes = new ArrayList<GMPShapeElement>();
			shapes.add(shapeElem);
			model2shape.put(modelElem, shapes);
		} else {
			shapes.add(shapeElem);
		}
		shape2model.put(shapeElem, modelElem);
	}

	public void remove(GMPTupleElement tuple) {
		tuples.remove(tuple);
		shape2model.remove(tuple.getShapeElement());
		List<GMPShapeElement> shapes = model2shape.get(tuple.getModelElement());
		shapes.remove(tuple.getShapeElement());
		if (shapes.size() == 0) {
			model2shape.remove(tuple.getModelElement());
		}
	}

	public List<GMPShapeElement> getShapesFromModel(GMPModelElement modelElem) {
		List<GMPShapeElement> shapes = model2shape.get(modelElem);
		if (shapes == null) {
			shapes = new ArrayList<GMPShapeElement>();
		}
		return shapes;
	}

	public GMPModelElement getModelFromShape(GMPShapeElement shapeElem) {
		return shape2model.get(shapeElem);
	}
	
	public GMPTupleElement getTupleFromShape(GMPShapeElement shapeElem) {
		for (GMPTupleElement tuple : tuples) {
			if (tuple.getShapeElement() == shapeElem) {
				return tuple;
			}
		}
		return null;
	}

	public void remove(GMPModelElement modelElem) {
		List<GMPTupleElement> tuplesToRemove = new ArrayList<GMPTupleElement>();
		for (GMPTupleElement tuple : tuples) {
			if (tuple.getModelElement() == modelElem) {
				tuplesToRemove.add(tuple);
			}
		}
		for (GMPTupleElement tuple : tuplesToRemove) {
			remove(tuple);
		}
	}

	public void remove(GMPShapeElement shapeElem) {
		for (GMPTupleElement tuple : tuples) {
			if (tuple.getShapeElement() == shapeElem) {
				remove(tuple);
				break;
			}
		}
	}
}

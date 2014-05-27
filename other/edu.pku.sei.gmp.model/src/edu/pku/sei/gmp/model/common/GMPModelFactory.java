package edu.pku.sei.gmp.model.common;

import java.util.HashMap;

import edu.pku.sei.gmp.model.concept.GMPElement;
import edu.pku.sei.gmp.model.concept.GMPModelElement;
import edu.pku.sei.gmp.model.shape.GMPShapeElement;
import edu.pku.sei.gmp.model.tuple.GMPTupleElement;

/**
 * 创建model element、shape element，以及tuple element
 * 
 * @author yangyz
 * 
 */
public abstract class GMPModelFactory {
	private static int count = 0;

	private HashMap<Integer, GMPElement> elementMap = new HashMap<Integer, GMPElement>();

	private HashMap<Integer, String> typeMap = new HashMap<Integer, String>();

	private GMPModel model = null;

	public GMPModel getModel() {
		return this.model;
	}

	public void setModel(GMPModel model) {
		this.model = model;
	}

	public int getElementCount() {
		return count;
	}

	public void setElementCount(int elementCount) {
		count = elementCount;
	}

	/**
	 * generate an id.
	 * 
	 * @return
	 */
	public int generateId() {
		count++;
		return count;
	}

	/**
	 * Create a model element of the given type, and register it into the
	 * factory. This method equals to {@code createModelElement(type, true)},
	 * and it is designed to be used in EditPolicy to make the code clearer.
	 * 
	 * @param type
	 *            the type string of the element
	 * @return
	 */
	public GMPModelElement createModelElement(String type) {
		return createModelElement(type, true);
	}

	/**
	 * Create a shape element of the given type, and register it into the
	 * factory. This method equals to {@code createShapeElement(type, true)},
	 * and it is designed to be used in EditPolicy to make the code clearer.
	 * 
	 * @param type
	 *            the type string of the element
	 * @return
	 */
	public GMPShapeElement createShapeElement(String type) {
		return createShapeElement(type, true);
	}

	/**
	 * Create a tuple element initialized with a model element and a shape
	 * element, and register it into the factory. This method equals to {@code
	 * createTupleElement(modelElement, shapeElement, true)}, and it is designed
	 * to be used in EditPolicy to make the code clearer.
	 * 
	 * @param modelElement
	 * @param shapeElement
	 * @return
	 */
	public GMPTupleElement createTupleElement(GMPModelElement modelElement,
			GMPShapeElement shapeElement) {
		return createTupleElement(modelElement, shapeElement, true);
	}

	/**
	 * Create an empty tuple element, and register it into the factory. This
	 * method equals to {@code createTupleElement(null, null, true)}.
	 * 
	 * @return
	 */
	public GMPTupleElement createTupleElement() {
		return createTupleElement(null, null, true);
	}

	/**
	 * Create an empty tuple element. It will register the newly created element
	 * or not depending on the parameter {@code needRegister}.
	 * 
	 * @param needRegister
	 *            whether the element need be registered.
	 * @return
	 */
	public GMPTupleElement createTupleElement(boolean needRegister) {
		return createTupleElement(null, null, needRegister);
	}

	/**
	 * Create a model element. It will register the newly created element into
	 * the factory or not depending on the {@code needRegister} parameter
	 * 
	 * @param type
	 *            the type string of the element
	 * @param needRegister
	 *            whether the element need be registered.
	 * @return
	 */
	public abstract GMPModelElement createModelElement(String type,
			boolean needRegister);

	/**
	 * Create a shape element. It will register the newly created element into
	 * the factory or not depending on the {@code needRegister} parameter
	 * 
	 * @param type
	 *            the type string of the element
	 * @param needRegister
	 *            whether the element need be registered.
	 * @return
	 */
	public abstract GMPShapeElement createShapeElement(String type,
			boolean needRegister);

	/**
	 * Create a tuple element, which will be initialized with a {@code
	 * modelElement} and a {@code shapeElement}. It will register the newly
	 * created element into the factory or not depending on the {@code
	 * needRegister} parameter
	 */
	public GMPTupleElement createTupleElement(GMPModelElement modelElement,
			GMPShapeElement shapeElement, boolean needRegister) {
		GMPTupleElement tuple = new GMPTupleElement();
		tuple.setModelElement(modelElement);
		tuple.setShapeElement(shapeElement);
		tuple.setModel(this.getModel());
		if (needRegister) {
			tuple.setId(generateId());
			register(tuple, GMPConst.__TUPLEELEMENT__);
		}
		return tuple;
	}

	/**
	 * Register the element into the factory. This facility is mainly designed
	 * to get element and its type information in the serialization part by an
	 * id.
	 * 
	 * @param element
	 * @param type
	 */
	public final void register(GMPElement element, String type) {
		int id = element.getId();
		if (id > count) {
			this.setElementCount(id);
		}
		elementMap.put(id, element);
		typeMap.put(id, type);
	}

	/**
	 * Unregister the element, remove it from elementMap and typeMap.
	 * 
	 * @param element
	 */
	public final void unregister(GMPElement element) {
		elementMap.remove(element.getId());
		typeMap.remove(element.getId());
	}

	/**
	 * Get the {@link GMPElement} by its id. If the element does not exist, the
	 * method will return null.
	 * 
	 * @param id
	 * @return
	 */
	public GMPElement id2element(int id) {
		return elementMap.get(id);
	}

	/**
	 * Get the type string of the element whose id equals to the parameter.
	 * 
	 * @param id
	 * @return
	 */
	public String id2type(int id) {
		String type = typeMap.get(id);
		if (type != null) {
			return type;
		} else {
			return "";
		}
	}
}

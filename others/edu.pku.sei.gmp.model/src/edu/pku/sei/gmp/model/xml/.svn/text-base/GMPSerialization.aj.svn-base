package edu.pku.sei.gmp.model.xml;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import edu.pku.sei.gmp.model.common.GMPConst;
import edu.pku.sei.gmp.model.common.GMPModel;
import edu.pku.sei.gmp.model.common.GMPModelFactory;
import edu.pku.sei.gmp.model.concept.GMPElement;
import edu.pku.sei.gmp.model.concept.GMPModelElement;
import edu.pku.sei.gmp.model.shape.GMPShapeElement;
import edu.pku.sei.gmp.model.tuple.GMPTupleElement;
import edu.pku.sei.gmp.model.util.GMPTypedList;
import edu.pku.sei.gmp.properties.annotation.GMPAnnotation;

public aspect GMPSerialization {
	
	private GMPXMLUtils GMPModel.modelXmlUtils = null;

	private GMPXMLUtils GMPModel.shapeXmlUtils = null;

	private GMPXMLUtils GMPModel.tupleXmlUtils = null;

	private void GMPModel.initXMLUtils() {
		if (modelXmlUtils == null) {
			modelXmlUtils = new GMPXMLUtils();
			modelXmlUtils.setFactory(new GMPXMLModelFactory(this));
		}
		if (shapeXmlUtils == null) {
			shapeXmlUtils = new GMPXMLUtils();
			shapeXmlUtils.setFactory(new GMPXMLShapeFactory(this));
		}
		if (tupleXmlUtils == null) {
			tupleXmlUtils = new GMPXMLUtils();
			tupleXmlUtils.setFactory(new GMPXMLTupleFactory(this));
		}
	}

	public GMPXMLUtils GMPModel.getXMLUtils(GMPElement element) {
		initXMLUtils();
		if (element instanceof GMPModelElement) {
			return modelXmlUtils;
		} else if (element instanceof GMPShapeElement) {
			return shapeXmlUtils;
		} else if (element instanceof GMPTupleElement) {
			return tupleXmlUtils;
		}
		return null;
	}

	public void GMPElement.serialize(Element root) {
		GMPModel model = this.getModel();
		GMPModelFactory factory = model.getModelFactory();
		GMPXMLUtils xmlUtils = model.getXMLUtils(this);

		xmlUtils.serializeAttribute(root, "xmi:type", factory.id2type(this
				.getId()));

		Class<?> elementClass = this.getClass();
		List<Field> allFields = new ArrayList<Field>();
		while (elementClass != Object.class) {
			Field[] fields = elementClass.getDeclaredFields();
			for (Field field : fields) {
				allFields.add(field);
			}
			elementClass = elementClass.getSuperclass();
		}

		elementClass = this.getClass();

		for (Field f : allFields) {
			GMPAnnotation fieldDesc = f.getAnnotation(GMPAnnotation.class);
			if (fieldDesc == null || fieldDesc.serialize() == false) {
				continue;
			}

			Class<?> fieldClass = f.getType();
			try {
				boolean flag = f.isAccessible();
				f.setAccessible(true);
				Object value = f.get(this);
				f.setAccessible(flag);
				
				
				if (fieldClass.getName().equals("int")
						|| fieldClass.equals(Integer.class)) {
					int fieldValue = (Integer) value;
					xmlUtils.serializeAttribute(root, fieldDesc.name(),
							fieldValue);
				} else if (fieldClass.getName().equals("double")
						|| fieldClass.equals(Double.class)) {
					double fieldValue = (Double) value;
					xmlUtils.serializeAttribute(root, fieldDesc.name(),
							fieldValue);
				} else if (fieldClass.getName().equals("boolean")
						|| fieldClass.equals(Boolean.class)) {
					boolean fieldValue = (Boolean) value;
					xmlUtils.serializeAttribute(root, fieldDesc.name(),
							fieldValue);
				} else if (fieldClass.getName().equals("float")
						|| fieldClass.equals(Float.class)) {
					float fieldValue = (Float) value;
					xmlUtils.serializeAttribute(root, fieldDesc.name(),
							fieldValue);
				} else if (fieldClass.getName().equals("char")
						|| fieldClass.equals(Character.class)) {
					char fieldValue = (Character) value;
					xmlUtils.serializeAttribute(root, fieldDesc.name(),
							fieldValue);
				} else if (fieldClass.equals(String.class)) {
					String fieldValue = (String) value;
					xmlUtils.serializeAttribute(root, fieldDesc.name(),
							fieldValue);
				} else if (fieldClass.equals(GMPTypedList.class)) {
					List<?> fieldValue = (List<?>) value;
					if (fieldDesc.reference()) {
						xmlUtils.serializeReferences(root, fieldDesc.name(),
								fieldValue);
					} else {
						xmlUtils.serializeElements(root, fieldDesc.name(),
								fieldValue);
					}
				} else if (GMPElement.class.isAssignableFrom(fieldClass)) {
					GMPElement fieldValue = (GMPElement) value;
					if (fieldDesc.reference()) {
						xmlUtils.serializeReference(root, fieldDesc.name(),
								fieldValue);
					} else {
						xmlUtils.serializeElement(root, fieldDesc.name(),
								fieldValue);
					}
				} else if (fieldClass.isEnum() && value != null) {
					xmlUtils.serializeAttribute(root, fieldDesc.name(), value
							.toString());
				}
			} catch (IllegalArgumentException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			}
		}
	}

	public void GMPElement.deSerialize(Element root) {
		GMPModel model = this.getModel();
		GMPModelFactory factory = model.getModelFactory();
		GMPXMLUtils xmlUtils = model.getXMLUtils(this);

		String typeString = xmlUtils.deSerializeString(root, "xmi:type");

		Class<?> elementClass = this.getClass();
		List<Field> allFields = new ArrayList<Field>();
		while (elementClass != Object.class) {
			Field[] fields = elementClass.getDeclaredFields();
			for (Field field : fields) {
				allFields.add(field);
			}
			elementClass = elementClass.getSuperclass();
		}

		elementClass = this.getClass();

		for (Field f : allFields) {
			GMPAnnotation fieldDesc = f.getAnnotation(GMPAnnotation.class);
			if (fieldDesc == null || fieldDesc.serialize() == false) {
				continue;
			}

			Class<?> fieldClass = f.getType();

			try {
				Object value = null;
				List<?> list = null;
				if (fieldClass.getName().equals("int")
						|| fieldClass.equals(Integer.class)) {
					value = xmlUtils.deSerializeInt(root, fieldDesc.name());
				} else if (fieldClass.getName().equals("double")
						|| fieldClass.equals(Double.class)) {
					value = xmlUtils.deSerializeDouble(root, fieldDesc.name());
				} else if (fieldClass.getName().equals("boolean")
						|| fieldClass.equals(Boolean.class)) {
					value = xmlUtils.deSerializeBoolean(root, fieldDesc.name());
				} else if (fieldClass.getName().equals("float")
						|| fieldClass.equals(Float.class)) {
					value = xmlUtils.deSerializeFloat(root, fieldDesc.name());
				} else if (fieldClass.getName().equals("char")
						|| fieldClass.equals(Character.class)) {
					value = xmlUtils.deSerializeChar(root, fieldDesc.name());
				} else if (fieldClass.equals(String.class)) {
					value = xmlUtils.deSerializeString(root, fieldDesc.name());
				} else if (GMPElement.class.isAssignableFrom(fieldClass)) {
					if (fieldDesc.reference()) {
						value = xmlUtils.deSerializeReference(root, fieldDesc
								.name(), this);
					} else {
						value = xmlUtils.deSerializeElement(root, fieldDesc
								.name());
					}
				} else if (fieldClass.equals(GMPTypedList.class)) {
					if (fieldDesc.reference()) {
						list = xmlUtils.deSerializeReferences(root, fieldDesc
								.name(), this);
					} else {
						list = xmlUtils.deSerializeElements(root, fieldDesc
								.name());
					}
				} else if (fieldClass.isEnum()) {
					String literal = xmlUtils.deSerializeString(root, fieldDesc
							.name());
					for (Object o : fieldClass.getEnumConstants()) {
						if (o.toString().equals(literal)) {
							value = o;
							break;
						}
					}
				}
				
				if (value != null) {
					boolean flag = f.isAccessible();
					f.setAccessible(true);
					f.set(this, value);
					f.setAccessible(flag);
				} else if (list != null) {
					boolean flag = f.isAccessible();
					f.setAccessible(true);
					Object originalList = f.get(this);
					f.setAccessible(flag);
					((GMPTypedList<?>) originalList).addAll(list);
				}
			} catch (IllegalArgumentException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			}
		}
		factory.register(this, typeString);
	}

	public void GMPElement.dynamicSet(String featureId, Object value) {
		Class<?> elementClass = this.getClass();
		
		List<Field> allFields = new ArrayList<Field>();
		while (elementClass != Object.class) {
			Field[] fields = elementClass.getDeclaredFields();
			for (Field field : fields) {
				allFields.add(field);
			}
			elementClass = elementClass.getSuperclass();
		}
		elementClass = this.getClass();

		for (Field f : allFields) {
			GMPAnnotation fieldDesc = f.getAnnotation(GMPAnnotation.class);
			if (fieldDesc == null || fieldDesc.serialize() == false) {
				continue;
			}
			
			if (fieldDesc.name().equals(featureId)) {
				Class<?> fieldClass = f.getType();
				try {
					if (fieldClass.equals(GMPTypedList.class)) {
						Method getter = elementClass.getMethod(fieldDesc
								.getter(), new Class[0]);
						@SuppressWarnings("unchecked")
						GMPTypedList<Object> list = ((GMPTypedList<Object>) getter
								.invoke(this));
						list.add(value);
					} else if (GMPElement.class.isAssignableFrom(fieldClass)) {
						Method setter = elementClass.getMethod(fieldDesc
								.setter(), fieldClass);
						setter.invoke(this, value);
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}

	

	public void GMPModel.serializeModel(Document document, Element root) {
		GMPModelFactory factory = this.getModelFactory();
		initXMLUtils();
		modelXmlUtils.setDocument(document);
		modelXmlUtils.serializeAttribute(root, "xmi:type", factory.id2type(this
				.getId()));
		
		modelXmlUtils.serializeAttribute(root, GMPConst.ELEMENT_ID, this
				.getId());

		modelXmlUtils.serializeAttribute(root, GMPConst.MODEL_NAME, this
				.getName());
		modelXmlUtils.serializeElements(root, GMPConst.MODEL_ROOTELEMENTS, this
				.getRootElements());
	}

	public void GMPModel.serializeShape(Document document, Element root) {
		GMPModelFactory factory = this.getModelFactory();
		initXMLUtils();
		shapeXmlUtils.setDocument(document);
		
		shapeXmlUtils.serializeAttribute(root, "xmi:type", factory.id2type(this
				.getId()));
		shapeXmlUtils.serializeAttribute(root, GMPConst.ELEMENT_ID, this
				.getId());
		shapeXmlUtils.serializeAttribute(root, GMPConst.MODEL_NAME, this
				.getName());
		shapeXmlUtils.serializeElements(root, GMPConst.MODEL_DIAGRAMS, this
				.getDiagrams());
	}

	public void GMPModel.serializeTuple(Document document, Element root) {
		GMPModelFactory factory = this.getModelFactory();
		initXMLUtils();
		tupleXmlUtils.setDocument(document);
		tupleXmlUtils.serializeAttribute(root, "xmi:type", factory.id2type(this
				.getId()));
		tupleXmlUtils.serializeAttribute(root, GMPConst.ELEMENT_ID, this
				.getId());
		tupleXmlUtils.serializeAttribute(root, GMPConst.MODEL_NAME, this
				.getName());
		tupleXmlUtils.serializeElements(root, GMPConst.MODEL_ALLTUPLES, this
				.getAllTuples());
	}

	public void GMPModel.deSerializeModel(Document document, Element root) {
		GMPModelFactory factory = this.getModelFactory();
		initXMLUtils();
		modelXmlUtils.setDocument(document);

		String typeString = modelXmlUtils.deSerializeString(root, "xmi:type");
		setId(modelXmlUtils.deSerializeInt(root, GMPConst.ELEMENT_ID));
		
		factory.register(this, typeString);
		
		setName(modelXmlUtils.deSerializeString(root, GMPConst.MODEL_NAME));
		getRootElements().addAll(
				modelXmlUtils.deSerializeElements(root,
						GMPConst.MODEL_ROOTELEMENTS));
	}
	
	public void GMPModel.deSerializeShape(Document document, Element root) {
		GMPModelFactory factory = this.getModelFactory();
		initXMLUtils();
		shapeXmlUtils.setDocument(document);

		String typeString = shapeXmlUtils.deSerializeString(root, "xmi:type");
		setId(shapeXmlUtils.deSerializeInt(root, GMPConst.ELEMENT_ID));
		
		factory.register(this, typeString);
		
		setName(shapeXmlUtils.deSerializeString(root, GMPConst.MODEL_NAME));
		getDiagrams().addAll(
				shapeXmlUtils
						.deSerializeElements(root, GMPConst.MODEL_DIAGRAMS));
	}

	public void GMPModel.deSerializeTuple(Document document, Element root) {
		GMPModelFactory factory = this.getModelFactory();
		initXMLUtils();
		tupleXmlUtils.setDocument(document);

		String typeString = tupleXmlUtils.deSerializeString(root, "xmi:type");
		setId(tupleXmlUtils.deSerializeInt(root, GMPConst.ELEMENT_ID));
		
		factory.register(this, typeString);
		
		setName(tupleXmlUtils.deSerializeString(root, GMPConst.MODEL_NAME));
		List<?> tuples = tupleXmlUtils.deSerializeElements(root,
				GMPConst.MODEL_ALLTUPLES);
		for (Object t : tuples) {
			GMPTupleElement tuple = (GMPTupleElement) t;
			if (tuple.getModelElement() != null
					&& tuple.getShapeElement() != null)
				addTuple(tuple);
		}
	}
	
	public void GMPModel.serialize(Element root) {
		
	}
	
	public void GMPModel.deSerialize(Element root) {

	}
}

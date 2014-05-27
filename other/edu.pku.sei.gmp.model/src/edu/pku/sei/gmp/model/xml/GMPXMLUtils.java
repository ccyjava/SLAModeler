package edu.pku.sei.gmp.model.xml;

import java.util.ArrayList;
import java.util.List;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import edu.pku.sei.gmp.model.concept.GMPElement;

public class GMPXMLUtils {

	private Document document;

	private GMPXMLFactory factory;

	private static final String idSeparator = ":";

	public void setDocument(Document document) {
		this.document = document;
	}

	public GMPXMLFactory getFactory() {
		return this.factory;
	}

	public void setFactory(GMPXMLFactory factory) {
		this.factory = factory;
	}

	// integer
	public void serializeAttribute(Element root, String name, int value) {
		root.setAttribute(name, new Integer(value).toString());
	}

	public int deSerializeInt(Element root, String name) {
		String value = root.getAttribute(name);
		return Integer.parseInt(value);
	}

	// float
	public void serializeAttribute(Element root, String name, float value) {
		root.setAttribute(name, new Float(value).toString());
	}

	public float deSerializeFloat(Element root, String name) {
		String value = root.getAttribute(name);
		return Float.parseFloat(value);
	}

	// double
	public void serializeAttribute(Element root, String name, double value) {
		root.setAttribute(name, new Double(value).toString());
	}

	public double deSerializeDouble(Element root, String name) {
		String value = root.getAttribute(name);
		return Double.parseDouble(value);
	}

	// char
	public void serializeAttribute(Element root, String name, char value) {
		root.setAttribute(name, new Character(value).toString());
	}

	public char deSerializeChar(Element root, String name) {
		String value = root.getAttribute(name);
		return value.charAt(0);
	}

	// boolean
	public void serializeAttribute(Element root, String name, boolean value) {
		root.setAttribute(name, new Boolean(value).toString());
	}

	public boolean deSerializeBoolean(Element root, String name) {
		String value = root.getAttribute(name);
		return Boolean.valueOf(value).booleanValue();
	}

	// String
	public void serializeAttribute(Element root, String name, String value) {
		root.setAttribute(name, value);
	}

	public String deSerializeString(Element root, String name) {
		return root.getAttribute(name);
	}

	// Element
	public void serializeElement(Element root, String name, GMPElement element) {
		if (root == null)
			return;
		if (document == null)
			return;
		if (element == null)
			return;
		Element node = document.createElement(name);
		element.serialize(node);
		root.appendChild(node);
	}

	public GMPElement deSerializeElement(Element root, String name) {
		NodeList childNodes = root.getChildNodes();
		for (int i = 0; i < childNodes.getLength(); i++) {
			Node node = childNodes.item(i);
			if (node instanceof Element) {
				if (name.equals(node.getNodeName())) {
					GMPElement element = createGMPElementByNode((Element) node);
					element.deSerialize((Element) node);
					factory.checkDynamicSet(element.getId(), element);
					return element;
				}
			}
		}
		return null;
	}

	public void serializeElements(Element root, String name, List<?> elements) {
		if (document == null)
			return;
		if (elements == null)
			return;
		for (int i = 0; i < elements.size(); i++) {
			Object obj = elements.get(i);
			if (obj instanceof GMPElement) {
				Element node = document.createElement(name);
				((GMPElement) obj).serialize(node);
				root.appendChild(node);
			}
		}
	}

	public List<?> deSerializeElements(Element root, String name) {
		if (root == null)
			return new ArrayList<Object>();
		if (name == null || name.equals(""))
			return new ArrayList<Object>();
		List<GMPElement> list = new ArrayList<GMPElement>();
		NodeList childNodes = root.getChildNodes();
		for (int i = 0; i < childNodes.getLength(); i++) {
			if (childNodes.item(i) instanceof Element) {
				Element node = (Element) childNodes.item(i);
				if (name.equals(node.getNodeName())) {
					GMPElement element = createGMPElementByNode(node);
					if (element != null) {
						element.deSerialize(node);
						factory.checkDynamicSet(element.getId(), element);
						list.add(element);
					}
				}
			}
		}
		return list;
	}

	// Reference
	public void serializeReference(Element root, String name, GMPElement element) {
		if (root == null)
			return;
		if (document == null)
			return;
		if (element == null)
			return;
		root.setAttribute(name, "" + element.getId());
	}

	public GMPElement deSerializeReference(Element root, String name,
			GMPElement parent) {
		if (root == null)
			return null;
		String idStr = root.getAttribute(name);
		if (idStr.isEmpty())
			return null;
		int id = Integer.parseInt(idStr);
		GMPElement element = factory.id2element(id);
		if (element == null) {
			factory.registerDynamicSet(id, parent, name);
		}
		return element;
	}

	public void serializeReferences(Element root, String name, List<?> elements) {
		if (document == null)
			return;
		if (elements == null)
			return;
		String value = "";
		for (Object o : elements) {
			if (o instanceof GMPElement) {
				GMPElement element = (GMPElement) o;
				if (value.isEmpty()) {
					value = "" + element.getId();
				} else {
					value += idSeparator + element.getId();
				}
			}
		}
		root.setAttribute(name, value);
	}

	public List<?> deSerializeReferences(Element root, String name,
			GMPElement parent) {
		if (root == null)
			return new ArrayList<Object>();
		if (name == null || name.equals(""))
			return new ArrayList<Object>();
		List<GMPElement> list = new ArrayList<GMPElement>();
		String value = root.getAttribute(name);
		String[] ids = value.split(idSeparator);
		for (String idStr : ids) {
			if (idStr.isEmpty()) continue;
			int id = Integer.parseInt(idStr);
			GMPElement element = factory.id2element(id);
			if (element == null) {
				factory.registerDynamicSet(id, parent, name);
			} else {
				list.add(element);
			}
		}
		return list;
	}

	protected GMPElement createGMPElementByNode(Element node) {
		String typeStr = node.getAttribute("xmi:type");
		return factory.create(typeStr);
	}
}

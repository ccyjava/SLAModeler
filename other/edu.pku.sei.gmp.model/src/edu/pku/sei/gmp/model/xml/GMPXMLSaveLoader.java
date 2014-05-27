package edu.pku.sei.gmp.model.xml;

import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintWriter;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import edu.pku.sei.gmp.model.common.GMPModel;

public class GMPXMLSaveLoader {
	
	public static String getModelFileName(String modelName) {
		return modelName + ".model";
	}
	
	public static String getShapeFileName(String modelName) {
		return modelName + ".shape";
	}
	
	public static String getTupleFileName(String modelName) {
		return modelName + ".tuple";
	}
	
	
	public void save(GMPModel model, String path, String rootTag)
			throws Exception {
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();
		
		
		String modelFilename = getModelFileName(path);
		Document document = builder.newDocument();
		Element root = document.createElement(rootTag);
		initRoot(root);
		document.appendChild(root);
		model.serializeModel(document, root);
		writeToFile(document, modelFilename);
		
		String shapeFilename = getShapeFileName(path);
		document = builder.newDocument();
		root = document.createElement(rootTag);
		initRoot(root);
		document.appendChild(root);
		model.serializeShape(document, root);
		writeToFile(document, shapeFilename);
		
		String tupleFilename = getTupleFileName(path);
		document = builder.newDocument();
		root = document.createElement(rootTag);
		initRoot(root);
		document.appendChild(root);
		model.serializeTuple(document, root);
		writeToFile(document, tupleFilename);
		
	}

	private void initRoot(Element root) {
		root.setAttribute("xmlns:xsi",
				"http://www.w3.org/2001/XMLSchema-instance");
		root.setAttribute("xmlns:xmi", "http://www.omg.org/XMI");
		root.setAttribute("version", "2.0");
	}
	
	private void writeToFile(Document document, String filename)
			throws Exception {
		TransformerFactory tfactory = TransformerFactory.newInstance();
		Transformer transformer = tfactory.newTransformer();
		DOMSource source = new DOMSource(document);
		// 设置编码方式
		transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
		// 设置是否有换行
		transformer.setOutputProperty(OutputKeys.INDENT, "yes");
		PrintWriter pw = new PrintWriter(new FileOutputStream(filename));
		StreamResult result = new StreamResult(pw);
		transformer.transform(source, result);
	}

	public void load(GMPModel model, String path, String rootTag)
			throws Exception {
		String modelFilename = getModelFileName(path);
		String shapeFilename = getShapeFileName(path);
		String tupleFilename = getTupleFileName(path);

		Document document = loadFromFile(modelFilename);
		Element root = (Element)(document.getElementsByTagName(rootTag)).item(0);
		model.deSerializeModel(document, root);
		
		document = loadFromFile(shapeFilename);
		root = (Element)(document.getElementsByTagName(rootTag)).item(0);
		model.deSerializeShape(document, root);
		
		document = loadFromFile(tupleFilename);
		root = (Element)(document.getElementsByTagName(rootTag)).item(0);
		model.deSerializeTuple(document, root);
	}
	
	public Document loadFromFile(String filename) throws Exception {
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();
		return builder.parse(new File(filename));
	}
}

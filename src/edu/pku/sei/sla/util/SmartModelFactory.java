package edu.pku.sei.sla.util;

import edu.pku.sei.gmp.model.common.GMPModel;
import edu.pku.sei.gmp.model.common.GMPModelFactory;
import edu.pku.sei.gmp.model.concept.GMPModelElement;
import edu.pku.sei.gmp.model.shape.GMPDiagram;
import edu.pku.sei.gmp.model.shape.GMPNode;
import edu.pku.sei.gmp.model.shape.GMPShapeElement;

public class SmartModelFactory extends GMPModelFactory {

	private String packageName = "";

	public String getPackageName() {
		return packageName;
	}

	public SmartModelFactory(String packageName) {
		super();
		this.packageName = packageName;
	}

	public SmartModelFactory() {
		super();
	}

	public void setPackageName(String packageName) {
		this.packageName = packageName;
	}

	@Override
	public GMPModelElement createModelElement(String type, boolean needRegister) {
		GMPModelElement element = null;
		try {
			Class.forName(packageName + "." + type);
		} catch (Exception e) {
			System.err.println("smart model factory disable! class not found :"
					+ packageName + "." + type);
			return null;
		}

		try {
			element = (GMPModelElement) Class.forName(packageName + "." + type)
					.newInstance();
			System.out.println("smart factory create : " + packageName + "."
					+ type);

		} catch (Exception e) {
			System.err.println("error in creat Model :" + type);
			e.printStackTrace();
		}

		if (element != null) {

			if (type.endsWith("Model")) {
				this.setModel((GMPModel) element);
			}

			element.setModel(this.getModel());
		}else{
			return null;
		}

		if (needRegister) {
			element.setId(this.generateId());
			register(element, type);
		}
		return element;
	}

	@Override
	public GMPShapeElement createShapeElement(String type, boolean needRegister) {
		GMPShapeElement element = null;
		if (type.endsWith("Diagram")) {

			element = new GMPDiagram();
			GMPDiagram gmpDiagram = (GMPDiagram) element;
			gmpDiagram.setType(type);
			gmpDiagram.setName(type);
		} else {
			try {
				Class.forName(packageName + "." + type);
			} catch (Exception e) {
				System.err.println("error in create shape for :" + packageName
						+ "." + type);
				return null;
			}
			element = new GMPNode();
		}
		if (element == null)
			return null;
		element.setModel(this.getModel());
		if (needRegister) {
			element.setId(this.generateId());
			register(element, type);
		}
		return element;

	}
}

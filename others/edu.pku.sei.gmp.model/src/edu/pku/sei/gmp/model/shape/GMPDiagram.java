package edu.pku.sei.gmp.model.shape;

import edu.pku.sei.gmp.model.common.GMPConst;
import edu.pku.sei.gmp.properties.annotation.GMPAnnotation;

public class GMPDiagram extends GMPShapeContainer {
	
	@GMPAnnotation(
			id = "GMPDiagram.name",
			name = GMPConst.DIAGRAM_NAME,
			getter = "getName",
			setter = "setName",
			visible = true
			)
	private String name;
	
	@GMPAnnotation(
			id = "GMPDiagram.type",
			name = GMPConst.DIAGRAM_TYPE,
			getter = "getType",
			setter = "setType"
			)
	private String type;
	
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getName() {
		return this.name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
}

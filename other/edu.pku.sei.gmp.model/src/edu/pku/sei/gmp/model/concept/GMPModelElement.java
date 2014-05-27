package edu.pku.sei.gmp.model.concept;

import edu.pku.sei.gmp.model.common.GMPConst;
import edu.pku.sei.gmp.model.common.GMPModelFactory;
import edu.pku.sei.gmp.properties.annotation.GMPAnnotation;

/**
 * Root element of all the domain model elements.
 * 
 * @author yangyz
 * 
 */
public class GMPModelElement extends GMPElement {
	@GMPAnnotation(
			id = "GMPElement.name",
			name = GMPConst.ELEMENT_NAME,
			getter = "getName",
			setter = "setName",
			visible = true,
			serialize = true
			)
	private String name="";
	
	
	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public GMPModelElement newInstance(String typeString) {
		GMPModelFactory factory = this.getModel().getModelFactory();
		return factory.createModelElement(typeString);
	}
}

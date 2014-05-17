package edu.pku.sei.gmp.model.xml;

import edu.pku.sei.gmp.model.common.GMPModel;
import edu.pku.sei.gmp.model.concept.GMPElement;

public class GMPXMLTupleFactory extends GMPXMLFactory {

	GMPModel model = null;
	
	public GMPXMLTupleFactory(GMPModel model) {
		super();
		this.model = model;
	}
	
	@Override
	public GMPElement create(String type) {
		return model.getModelFactory().createTupleElement(false);
	}

	@Override
	public GMPElement id2element(int id) {
		return model.getModelFactory().id2element(id);
	}
}

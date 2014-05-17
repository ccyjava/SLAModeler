package edu.pku.sei.gmp.model.common;

import edu.pku.sei.gmp.model.concept.GMPElement;

public class AbstractFactory {
	private static int id;
	
	private GMPModel model = null;
	
	
	
	public GMPElement create(String elementType) {
		return null;
	}
	
	protected int getId() {
		return id++;
	}
	
	protected void setModel(GMPModel model) {
		this.model = model;
	}
	
	protected GMPModel getModel() {
		return model;
	}
	
	protected void init(GMPElement element) {
		element.setId(this.getId());
		element.setModel(this.getModel());
	}
}

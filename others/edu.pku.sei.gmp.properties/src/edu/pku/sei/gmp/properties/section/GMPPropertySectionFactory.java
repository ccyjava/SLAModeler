package edu.pku.sei.gmp.properties.section;

import edu.pku.sei.gmp.properties.core.GMPPropertyCategory;

public  class GMPPropertySectionFactory {

	public  GMPPropertySection createSection(String id){
		if(id.equals(GMPPropertyCategory.MODEL))
			return new GMPModelPropertySectionImpl();
		if(id.equals(GMPPropertyCategory.SHAPE))
			return new GMPAppearencePropertySectionImpl();
		return null;
	}
	
}

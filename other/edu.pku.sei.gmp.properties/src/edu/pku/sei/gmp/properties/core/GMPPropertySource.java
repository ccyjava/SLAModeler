package edu.pku.sei.gmp.properties.core;

import org.eclipse.ui.views.properties.IPropertyDescriptor;
import org.eclipse.ui.views.properties.IPropertySource;

import edu.pku.sei.gmp.properties.registry.GMPElementPropertyRegistry;
import edu.pku.sei.gmp.properties.util.GMPPropertyUtils;

public class GMPPropertySource implements IPropertySource {
	private Object hostSource;
	private GMPElementProperty elementProperty;

	@Override
	public String toString() {
		return hostSource.toString();
	}

	public GMPPropertySource(Object host) {
		hostSource = host;
		elementProperty = GMPElementPropertyRegistry.getInstance()
				.getElementProperty(host);
	}

	public IPropertyDescriptor[] getPropertyDescriptors() {
		if (GMPPropertyUtils.isPrimitive(hostSource.getClass())) {
			return null;
		} else {
			return elementProperty.getPropertyDescriptors();
		}
	}

	public Object getPropertyValue(Object id) {
		return elementProperty.getPropertyValue(hostSource, id);
	}

	public void setPropertyValue(Object id, Object value) {
		elementProperty.setPropertyValue(hostSource, id, value);
	}

	public Object getEditableValue() {
		return hostSource;
	}

	public void setFiltered(boolean isFiltered, String[] value){
		elementProperty.setFiltered(isFiltered, value);
	}
	
	public boolean isPropertySet(Object arg0) {
		return true;
	}

	public void resetPropertyValue(Object arg0) {
	}
}
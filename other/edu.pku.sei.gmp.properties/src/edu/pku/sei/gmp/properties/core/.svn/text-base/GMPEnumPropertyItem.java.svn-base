package edu.pku.sei.gmp.properties.core;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

import org.eclipse.ui.views.properties.IPropertyDescriptor;

import edu.pku.sei.gmp.properties.annotation.GMPAnnotation;
import edu.pku.sei.gmp.properties.annotation.GMPEnumAnnotation;
import edu.pku.sei.gmp.properties.descriptor.GMPEnumPropertyDescriptor;

public class GMPEnumPropertyItem extends GMPDefaultPropertyItem {

	private Object[] choices;
	private String enumMethodString;
	private Method enumMethod = null;
	GMPEnumPropertyDescriptor descriptor;

	public GMPEnumPropertyItem(Class<?> classType, Field field,
			GMPAnnotation fieldDesc, GMPEnumAnnotation enumDesc) {
		super(classType, field, fieldDesc);
		choices = enumDesc.enumLiterals();
		enumMethodString = enumDesc.enumMethod();
		descriptor = new GMPEnumPropertyDescriptor(this.getId(),
				this.getName(), this.getCategory());
	}

	public IPropertyDescriptor getDescriptor() {
		return descriptor;
	}

	public Object getValue(Object source) {
		if (!enumMethodString.isEmpty()) {
			if (enumMethod == null) {
				try {
					enumMethod = this.getClassType().getMethod(
							enumMethodString, new Class[0]);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			if (enumMethod != null) {
				try {
					choices = (Object[]) enumMethod.invoke(source);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		} else if (this.getField().getType().isEnum()) {
			choices = this.getField().getType().getEnumConstants();
		}
		if (choices == null) {
			return 0;
		}
		
		String[] literals = new String[choices.length + 1];
		literals[0] = "null";
		for (int i = 0; i < choices.length; i++) {
			literals[i + 1] = choices[i].toString();
		}
		descriptor.setLiterals(literals);
		
		Object current = super.getRawValue(source);
		if (current == null) {
			return 0;
		}
		for (int i = 0; i < choices.length; i++) {
			if (current.equals(choices[i])) {
				return i + 1;
			}
		}
		return 0;
	}
	
	public void setValue(Object source, Object value) {
		Integer index = (Integer) value;
		if (index == 0 || index > choices.length) {
			setRawValue(source, null);
		} else {
			setRawValue(source, choices[index - 1]);
		}
	}
}

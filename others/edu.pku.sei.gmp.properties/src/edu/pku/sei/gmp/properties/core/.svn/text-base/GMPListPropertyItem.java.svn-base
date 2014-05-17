package edu.pku.sei.gmp.properties.core;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.List;

import org.eclipse.gef.commands.CommandStack;
import org.eclipse.gef.requests.CreationFactory;
import org.eclipse.ui.views.properties.IPropertyDescriptor;

import edu.pku.sei.gmp.properties.annotation.GMPAnnotation;
import edu.pku.sei.gmp.properties.annotation.GMPListAnnotation;
import edu.pku.sei.gmp.properties.descriptor.GMPListPropertyDescriptor;

public class GMPListPropertyItem extends GMPDefaultPropertyItem {

	private Class<?> allowedType;
	private String newInstanceMethod;
	private String getCommandStackMethod;
	private String typeString;
	private GMPListPropertyDescriptor descriptor;

	public GMPListPropertyItem(Class<?> classType, Field field,
			GMPAnnotation fieldDesc, GMPListAnnotation listDesc) {
		super(classType, field, fieldDesc);
		newInstanceMethod = listDesc.newInstanceMethod();
		allowedType = listDesc.allowedType();
		typeString = listDesc.typeString();
		getCommandStackMethod = listDesc.getCommandStackMethod();
		descriptor = new GMPListPropertyDescriptor(this.getId(), this
					.getName(), this.getCategory(), allowedType);
	}

	public IPropertyDescriptor getDescriptor() {
		return descriptor;
	}
	
	public Object getValue(final Object source) {
		Object value = super.getRawValue(source);
		List<?> list = (List<?>) value;
		descriptor.setValues(list);
		descriptor.setCreationFactory(new CreationFactory() {
			@Override
			public Object getNewObject() {
				try {
					Method method = getClassType().getMethod(newInstanceMethod,
							String.class);
					return method.invoke(source, typeString);
				} catch (Exception e) {
					e.printStackTrace();
				}
				return new Object();
			}
			@Override
			public Object getObjectType() {
				return null;
			}
		});
		
		CommandStack cmdStack = null;
		try {
			Method method = getClassType().getMethod(getCommandStackMethod,
					new Class[0]);
			cmdStack = (CommandStack)method.invoke(source);
		} catch (Exception e) {
			e.printStackTrace();
			cmdStack = null;
		}
		
		if (cmdStack != null) {
			descriptor.setCommandStack(cmdStack);
		}
		
		StringBuffer sb = new StringBuffer();
		sb.append("[");
		int i = 0;
		for (Object o : list) {
			if (i++ != 0) {
				sb.append(", ");
			}
			sb.append(o.toString());
		}
		sb.append("]");
		
		return sb.toString();
	}
	
	public void setValue(Object source, Object value) {
		
	}
}

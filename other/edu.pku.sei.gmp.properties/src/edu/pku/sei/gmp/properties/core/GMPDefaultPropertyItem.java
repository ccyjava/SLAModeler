package edu.pku.sei.gmp.properties.core;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

import org.eclipse.ui.views.properties.ComboBoxPropertyDescriptor;
import org.eclipse.ui.views.properties.IPropertyDescriptor;
import org.eclipse.ui.views.properties.PropertyDescriptor;
import org.eclipse.ui.views.properties.TextPropertyDescriptor;

import edu.pku.sei.gmp.properties.annotation.GMPAnnotation;
import edu.pku.sei.gmp.properties.util.GMPPropertyUtils;

public class GMPDefaultPropertyItem extends GMPPropertyItem {
	/**
	 * The "get" accessor of the field. Also known as "getter".
	 */
	private String getter;
	
	/**
	 * The "set" accessor of the field. Also known as "setter".
	 */
	private String setter;

	/**
	 * The accessibility of the property. If this value is <code>true</code>,
	 * the corresponding item in the property sheet will not be editable.
	 */
	private boolean readonly;

	/**
	 * The property name declared in the model(java file). This name is got from
	 * the <code>Field</code> object reflectively.
	 */
	private String propertyName;

	/**
	 * The declared type of the property.
	 */
	private Class<?> propertyType;

	/**
	 * The declared type of the host object.
	 */
	private Class<?> classType;

	/**
	 * The <code>Field</code> object
	 */
	private Field field;

	/**
	 * A custom property that is not linked with a <code>Field</code>. In one
	 * <code>GMPPropertyItem</code>, <code>id</code>, <code>name</code> and
	 * <code>category</code> are necessary.
	 * 
	 * @param id
	 * @param name
	 * @param category
	 */
	public GMPDefaultPropertyItem(Object id, String name, String category) {
		super(id, name, category);
	}

	/**
	 * A custom property that associated with a <code>Field</code>.
	 * 
	 * @param classType
	 * @param field
	 * @param fieldDesc
	 */
	public GMPDefaultPropertyItem(Class<?> classType, Field field,
			GMPAnnotation fieldDesc) {
		super(fieldDesc.id(), fieldDesc.name(), fieldDesc.category());
		init(classType, field, fieldDesc);
	}

	private void init(Class<?> classType, Field field, GMPAnnotation fieldDesc) {
		this.classType = classType;
		this.field = field;
		if (fieldDesc.displayName().isEmpty()) {
			this.setName(fieldDesc.name());
		} else {
			this.setName(fieldDesc.displayName());
		}
		this.getter = fieldDesc.getter();
		this.setter = fieldDesc.setter();
		this.readonly = fieldDesc.readonly();
		this.propertyName = field.getName();
		this.propertyType = field.getType();
	}

	/**
	 * get the raw value of the field.
	 * <p>
	 * If the field is annotated with a "getter", it will invoke that method to
	 * get the raw value. While a "getter" is not provided, we will get the raw
	 * value from that field directly.
	 * 
	 * @param source
	 * @return
	 */
	protected Object getRawValue(Object source) {
		Object value = null;
		if (getter.isEmpty()) {
			boolean flag = field.isAccessible();
			field.setAccessible(true);
			try {
				value = (String) field.get(source);
			} catch (IllegalArgumentException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			}
			field.setAccessible(flag);
		} else {
			Method fieldGetter = null;
			try {
				fieldGetter = classType.getMethod(getter, new Class[0]);
				value = fieldGetter.invoke(source);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return value;
	}
	
	/**
	 * Get the value of one property. First it gets the raw value of the
	 * property, and wrap it according to its type.
	 * 
	 * @see getRawValue(Object source)
	 * @param source
	 * @return
	 */
	@Override
	public Object getValue(Object source) {
		Object value = getRawValue(source);
		
		if (value == null) {
			return "null";
		} else {
			/*
			if (value instanceof IAdaptable) {
				IPropertySource nestedProperty = (IPropertySource) ((IAdaptable) value)
						.getAdapter(IPropertySource.class);
				if (nestedProperty != null) {
					return nestedProperty;
				}
			}
			*/

			if (propertyType.equals(boolean.class)
					|| propertyType.equals(Boolean.class)) {
				boolean boolValue = (Boolean) value;
				if (boolValue) {
					return 1;
				} else {
					return 0;
				}
			} else if (GMPPropertyUtils.isPrimitive(propertyType)) {
				return value.toString();
			}

			return value;
		}
	}

	/**
	 * Set the raw value to the field.
	 * <p>
	 * If the field is annotated with a "setter", it will invoke this accessor
	 * to set the value. Or it will set the value to that field directly. We
	 * prefer the setter to the second way to modify the property value, because
	 * we can not notify the listeners of the field to refresh when its value is
	 * modified with reflection during runtime, even though the message
	 * notification facility is implemented by AspectJ
	 * 
	 * @param source
	 * @param value
	 */
	protected void setRawValue(Object source, Object value) {
		if (setter.isEmpty()) {
			boolean flag = field.isAccessible();
			field.setAccessible(true);
			try {
				field.set(source, value);
			} catch (IllegalArgumentException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			}
			field.setAccessible(flag);
		} else {
			try {
				Method fieldSetter = classType.getMethod(setter, propertyType);
				fieldSetter.invoke(source, value);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * Set the property value. First remove the wrap added by
	 * <code>getValue</code> method, then call the <code>setRawValue</code> with
	 * parameter of the raw value.
	 * 
	 * @param source
	 * @param value
	 */
	@Override
	public void setValue(Object source, Object value) {
		if (propertyType.equals(boolean.class)
				|| propertyType.equals(Boolean.class)) {
			int index = (Integer) value;
			if (index == 0) {
				value = false;
			} else {
				value = true;
			}
		} else if (GMPPropertyUtils.isPrimitive(propertyType)) {
			String str = (String) value;
			if (propertyType.equals(int.class)
					|| propertyType.equals(Integer.class)) {
				value = GMPPropertyUtils.parseInt(str, 0);
			} else if (propertyType.equals(float.class)
					|| propertyType.equals(Float.class)) {
				value = GMPPropertyUtils.parseFloat(str, 0.0f);
			} else if (propertyType.equals(double.class)
					|| propertyType.equals(Double.class)) {
				value = GMPPropertyUtils.parseDouble(str, 0.0);
			} else if (propertyType.equals(char.class)
					|| propertyType.equals(Character.class)) {
				value = GMPPropertyUtils.parseChar(str, ' ');
			}
		}

		setRawValue(source, value);
	}


	/**
	 * Get the <code>IPropertyDescriptor</code> of the field. 
	 * 
	 * @return
	 */
	public IPropertyDescriptor getDescriptor() {
		IPropertyDescriptor descriptor = null;
		if (!readonly) {
			if (propertyType.equals(boolean.class)
					|| propertyType.equals(Boolean.class)) {
				descriptor = new ComboBoxPropertyDescriptor(getId(), getName(),
						new String[] { "false", "true" });
				((ComboBoxPropertyDescriptor) descriptor)
						.setCategory(getCategory());
			} else if (GMPPropertyUtils.isPrimitiveOrString(propertyType)) {
				descriptor = new TextPropertyDescriptor(getId(), getName());
				((TextPropertyDescriptor) descriptor)
						.setCategory(getCategory());
			}
		}

		if (descriptor == null) {
			descriptor = new PropertyDescriptor(getId(), getName());
			((PropertyDescriptor) descriptor).setCategory(getCategory());
		}
		return descriptor;
	}

	public boolean isReadonly() {
		return readonly;
	}

	public void setReadonly(boolean readonly) {
		this.readonly = readonly;
	}

	public String getPropertyName() {
		return propertyName;
	}

	public void setPropertyName(String propertyName) {
		this.propertyName = propertyName;
	}

	public Class<?> getPropertyType() {
		return propertyType;
	}

	public void setPropertyType(Class<?> propertyType) {
		this.propertyType = propertyType;
	}

	public Class<?> getClassType() {
		return classType;
	}

	public void setClassType(Class<?> classType) {
		this.classType = classType;
	}

	public String getGetter() {
		return getter;
	}

	public void setGetter(String getter) {
		this.getter = getter;
	}

	public String getSetter() {
		return setter;
	}

	public void setSetter(String setter) {
		this.setter = setter;
	}

	public Field getField() {
		return field;
	}

	public void setField(Field field) {
		this.field = field;
	}
}

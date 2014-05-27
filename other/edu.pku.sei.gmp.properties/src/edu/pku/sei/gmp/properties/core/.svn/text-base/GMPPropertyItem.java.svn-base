package edu.pku.sei.gmp.properties.core;

import org.eclipse.ui.views.properties.IPropertyDescriptor;

public abstract class GMPPropertyItem {
	/**
	 * Property id, by which the property is distinguished from each other.
	 */
	private Object id;

	/**
	 * The name of the property, which is displayed in the property sheet.
	 */
	private String name;

	/**
	 * The category of the property. Something like <code>general</code>, <code>
	 * model</code>
	 * etc.
	 */
	private String category;

	public GMPPropertyItem(Object id, String name, String category) {
		this.id = id;
		this.name = name;
		this.category = category;
	}
	
	
	/**
	 * Property id, by which the property is distinguished from each other.
	 */
	public Object getId() {
		return id;
	}

	/**
	 * Property id, by which the property is distinguished from each other.
	 */
	public void setId(Object id) {
		this.id = id;
	}

	/**
	 * Get the name of the property, which is displayed in the property sheet.
	 */
	public String getName() {
		return name;
	}

	/**
	 * Set the name of the property, which is displayed in the property sheet.
	 * 
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Get the category of the property. Something like <code>general</code>,
	 * <code>
	 * model</code> etc.
	 */
	public String getCategory() {
		return category;
	}

	/**
	 * Set the category of the property. Something like <code>general</code>,
	 * <code>
	 * model</code> etc.
	 */
	public void setCategory(String category) {
		this.category = category;
	}
	
	/**
	 * Get the property value of the host object <code>source</code>.
	 * <p>
	 * e.g. In the model, one chooses an integer number to represent a boolean
	 * value, <code>0</code> for <code>false</code>, and <code>1</code> for
	 * <code>true</code>, while in the property sheet, "true" or "false" are
	 * preferable. And the only work you need to do is to implement this method
	 * like this: <code><pre>
	 * public Object getValue(Object source) {
	 *     int i = ((SomeModel) source).getXXX();
	 *     if (i == 0) {
	 *         return "false";
	 *     } else {
	 *         return "true";
	 *     }
	 * }
	 * </pre></code>
	 * 
	 * @param source
	 *            the source object
	 * @return the property value
	 */
	public abstract Object getValue(Object source);
	
	
	/**
	 * Set the property value of the host object <code>source</code>.
	 * <p>
	 * e.g. In the model, one chooses a integer number to represent a boolean
	 * value, <code>0</code> for <code>false</code>, and <code>1</code> for
	 * <code>true</code>, while in the property sheet, "true" or "false" are
	 * displayed rather than "0" or "1", that is, the parameter value will be a
	 * String of "true" or "false" not "0" or "1". All we need to do is:
	 * <code><pre>
	 * public void setValue(Object source, Object value) {
	 *     String str = (String) value;
	 *     if (str.equals("false")) {
	 *         ((SomeModel) source).setXXX(0);
	 *     } else {
	 *         ((SomeModel) source).setXXX(1);
	 *     }
	 * }
	 * </pre></code>
	 * 
	 * @param source
	 * @param value
	 * @see getPropertyValue
	 */
	public abstract void setValue(Object source, Object value);
	
	/**
	 * Get a customized <code>PropertyDescriptor</code> for the specific field.
	 * You can NOT return <code>null</code> here. If you want to custom the
	 * display text by implementing the <code>getPropertyValue</code>, you have
	 * to implement this method at the same time.
	 * 
	 * @return
	 */
	public abstract IPropertyDescriptor getDescriptor();
}

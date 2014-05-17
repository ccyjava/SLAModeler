package edu.pku.sei.gmp.properties.core;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.ui.views.properties.IPropertyDescriptor;

import edu.pku.sei.gmp.properties.annotation.GMPAnnotation;
import edu.pku.sei.gmp.properties.annotation.GMPEnumAnnotation;
import edu.pku.sei.gmp.properties.annotation.GMPListAnnotation;
import edu.pku.sei.gmp.properties.annotation.GMPMultiChoiceAnnotation;
import edu.pku.sei.gmp.properties.registry.GMPPropertyItemRegistry;
import edu.pku.sei.gmp.properties.util.GMPPropertyUtils;

public class GMPElementProperty {
	private Class<?> type;
	private List<GMPPropertyItem> items = new ArrayList<GMPPropertyItem>();
	private IPropertyDescriptor[] descriptors;

	private boolean isFiltered = false;
	private String[] filterValue;

	public void setFiltered(boolean isFiltered, String[] value) {
		this.isFiltered = isFiltered;
		this.filterValue = value;
	}

	public GMPElementProperty(Class<?> type) {
		this.type = type;
		this.initItems();
		this.initDescriptors();
	}

	public Class<?> getType() {
		return this.type;
	}

	public IPropertyDescriptor[] getPropertyDescriptors() {
		if (!isFiltered || descriptors.length == 0)
			return this.descriptors;
		else
			return filterDescriptors();
	}

	public Object getPropertyValue(Object source, Object id) {
		GMPPropertyItem item = this.getItemById(id);
		assert (item != null);
		return item.getValue(source);
	}

	public void setPropertyValue(Object source, Object id, Object value) {
		GMPPropertyItem item = this.getItemById(id);
		assert (item != null);
		item.setValue(source, value);
	}

	private GMPPropertyItem getItemById(Object id) {
		for (GMPPropertyItem item : items) {
			if (item.getId().equals(id)) {
				return item;
			}
		}
		return null;
	}

	private void initItems() {
		List<Field> allFields = GMPPropertyUtils.getAllField(type);
		for (Field field : allFields) {
			GMPDefaultPropertyItem item = createPropertyItem(field);
			if (item != null) {
				items.add(item);
			}
		}
		for (GMPPropertyItem item : GMPPropertyItemRegistry.getInstance()
				.getPropertyItem(type)) {
			items.add(item);
		}
	}

	private void initDescriptors() {
		descriptors = new IPropertyDescriptor[items.size()];
		for (int i = 0; i < items.size(); i++) {
			GMPPropertyItem item = items.get(i);
			descriptors[i] = item.getDescriptor();
		}
	}

	private GMPDefaultPropertyItem createPropertyItem(Field field) {
		GMPAnnotation fieldDesc = field.getAnnotation(GMPAnnotation.class);
		if (fieldDesc == null || !fieldDesc.visible()) {
			return null;
		}

		GMPListAnnotation listDesc = field
				.getAnnotation(GMPListAnnotation.class);
		if (listDesc != null) {
			return new GMPListPropertyItem(type, field, fieldDesc, listDesc);
		}

		GMPEnumAnnotation enumDesc = field
				.getAnnotation(GMPEnumAnnotation.class);
		if (enumDesc != null) {
			return new GMPEnumPropertyItem(type, field, fieldDesc, enumDesc);
		}

		GMPMultiChoiceAnnotation multiChoiceDesc = field
				.getAnnotation(GMPMultiChoiceAnnotation.class);
		if (multiChoiceDesc != null) {

		}

		return new GMPDefaultPropertyItem(type, field, fieldDesc);
	}

	private IPropertyDescriptor[] filterDescriptors() {
		List<IPropertyDescriptor> filteredDescriptors = new ArrayList<IPropertyDescriptor>();

		for (int i = 0; i < this.descriptors.length; i++) {
			String name = descriptors[i].getCategory();
			for (int j = 0; j < this.filterValue.length; j++) {
				if (name.equals(filterValue[j]))
					filteredDescriptors.add(descriptors[i]);
			}
		}
		IPropertyDescriptor[] result = (IPropertyDescriptor[]) filteredDescriptors
				.toArray(new IPropertyDescriptor[filteredDescriptors.size()]);
		return result;
	}
}

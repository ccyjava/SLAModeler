package edu.pku.sei.gmp.properties.descriptor;

import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.jface.viewers.ComboBoxCellEditor;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.views.properties.PropertyDescriptor;

public class GMPEnumPropertyDescriptor extends PropertyDescriptor {

	private String[] literals;
	
	public GMPEnumPropertyDescriptor(Object id, String displayName,
			String category) {
		super(id, displayName);
		setCategory(category);
	}

	public CellEditor createPropertyEditor(Composite parent) {
		ComboBoxCellEditor editor = new ComboBoxCellEditor(parent, literals, SWT.READ_ONLY);
		return editor;
	}
	
	public ILabelProvider getLabelProvider() {
		return new ILabelProvider() {

			@Override
			public Image getImage(Object element) {
				return null;
			}

			@Override
			public String getText(Object element) {
				Integer index = (Integer) element;
				return literals[index];
			}

			@Override
			public void addListener(ILabelProviderListener listener) {
			}

			@Override
			public void dispose() {
			}

			@Override
			public boolean isLabelProperty(Object element, String property) {
				return false;
			}

			@Override
			public void removeListener(ILabelProviderListener listener) {

			}
			
		};
	}

	public void setLiterals(String[] literals) {
		this.literals = literals;
	}
}

package edu.pku.sei.gmp.properties.descriptor;

import java.util.List;

import org.eclipse.gef.commands.CommandStack;
import org.eclipse.gef.requests.CreationFactory;
import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.views.properties.PropertyDescriptor;

import edu.pku.sei.gmp.properties.view.GMPListPropertyDialog;

public class GMPListPropertyDescriptor extends PropertyDescriptor {
	private Class<?> type;
	private CreationFactory factory;
	private List<?> list;
	private CommandStack commandStack;

	public GMPListPropertyDescriptor(Object id, String name, String category,
			Class<?> allowedType) {
		super(id, name);
		setCategory(category);
		this.type = allowedType;
	}

	public void setCreationFactory(CreationFactory factory) {
		this.factory = factory;
	}

	public void setValues(List<?> values) {
		this.list = values;
	}

	public void setCommandStack(CommandStack commandStack) {
		this.commandStack = commandStack;
	}

	
	@Override
	public CellEditor createPropertyEditor(Composite parent) {
		GMPListPropertyDialog dlg = new GMPListPropertyDialog(
				parent.getShell(), list, type);
		dlg.setCreationFactory(factory);
		if (commandStack != null)
			dlg.setCommandStack(commandStack);
		dlg.open();
		
		/*
		 * The code below is to notify the viewer to refresh. First remove one
		 * object of the list, and then add it back. the add and remove
		 * operations refresh the viewer correctly.
		 */
		if (!list.isEmpty()) {
			@SuppressWarnings("unchecked")
			List<Object> newList = (List<Object>) list;
			newList.add(list.remove(list.size() - 1));
		}
		
		return null;
	}
}

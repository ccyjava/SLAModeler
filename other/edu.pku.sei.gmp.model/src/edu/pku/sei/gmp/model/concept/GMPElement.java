package edu.pku.sei.gmp.model.concept;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.gef.commands.CommandStack;
import org.eclipse.ui.views.properties.IPropertySource;

import edu.pku.sei.gmp.common.cmdstack.GMPCommandStack;
import edu.pku.sei.gmp.model.common.GMPConst;
import edu.pku.sei.gmp.model.common.GMPModel;
import edu.pku.sei.gmp.model.util.GMPTypedList;
import edu.pku.sei.gmp.properties.annotation.GMPAnnotation;
import edu.pku.sei.gmp.properties.core.GMPPropertySource;



/**
 * Base class of all the elements of GMP.
 * 
 * @author yangyz
 * 
 */
public class GMPElement implements IAdaptable {
	
	@GMPAnnotation(
			id = "GMPElement.id",
			name = GMPConst.ELEMENT_ID,
			getter = "getId",
			setter = "setId"
			)
	protected int id;
	
	
	@GMPAnnotation(
			id = "GMPElement.model",
			name = GMPConst.ELEMENT_MODEL,
			getter = "getModel",
			setter = "setModel",
			reference = true
			)
	protected GMPModel model;
	
	
	
	
	


	@GMPAnnotation(
			id = "GMPElement.container",
			name = GMPConst.ELEMENT_CONTAINER,
			getter = "getContainer",
			setter = "setContainer",
			reference = true
			)
	protected GMPElement container;
	
	
	
	@GMPAnnotation(
			id = "GMPElement.children", 
			name = GMPConst.ELEMENT_CHILDREN,  
			getter = "getChildren",
			serialize = true
			)
	private GMPTypedList<GMPElement> children = new GMPTypedList<GMPElement>(
			GMPConst.ELEMENT_CHILDREN, GMPTypedList.BAG, this,
			GMPElement.class, true);
	
	public GMPTypedList<GMPElement> getChildren() {
		return children;
	}





	public GMPElement() {
		
	}
	
	
	public GMPElement getContainer() {
		return container;
	}

	
	public void setContainer(GMPElement container) {
		this.container = container;
	}

	public GMPModel getModel() {
		return model;
	}

	public void setModel(GMPModel model) {
		this.model = model;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	
	public CommandStack getCommandStack() {
		if (model != null)
			return GMPCommandStack.getCommandStack(model);
		else
			return null;
	}
	
	
	@SuppressWarnings("unchecked")
	@Override
	public Object getAdapter(Class adapter) {
		if (adapter == IPropertySource.class) {
			return new GMPPropertySource(this);
		}
		return null;
	}
}

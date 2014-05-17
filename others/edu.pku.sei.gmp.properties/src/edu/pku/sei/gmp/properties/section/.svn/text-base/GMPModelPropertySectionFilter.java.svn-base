package edu.pku.sei.gmp.properties.section;
import org.eclipse.gef.EditPart;
import org.eclipse.jface.viewers.IFilter;
import org.eclipse.jface.viewers.IStructuredSelection;


public class GMPModelPropertySectionFilter implements IFilter {

	@Override
	public boolean select(Object toTest){
		if (toTest instanceof IStructuredSelection
				|| toTest instanceof EditPart)
			return true;
		return false;
	}

}

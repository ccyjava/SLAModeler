package edu.pku.sei.gmp.notation.layout;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.draw2d.AbstractLayout;
import org.eclipse.draw2d.IFigure;

public abstract class AbstractNotationLayout extends AbstractLayout {
	
	protected Map<IFigure, Object> constraints = new HashMap<IFigure, Object>();
	public Object getConstraint(IFigure figure) {
		return constraints.get(figure);
	}
	public void setConstraint(IFigure figure, Object newConstraint) {
		super.setConstraint(figure, newConstraint);
		if (newConstraint != null)
			constraints.put(figure, newConstraint);
	}
	public void remove(IFigure figure) {
		super.remove(figure);
		constraints.remove(figure);
	}

}

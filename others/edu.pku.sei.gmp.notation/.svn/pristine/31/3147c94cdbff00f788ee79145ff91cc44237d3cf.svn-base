package edu.pku.sei.gmp.notation.figure;

import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.LayoutManager;
import org.eclipse.draw2d.Shape;

import edu.pku.sei.gmp.notation.layout.MultiLayout;

public abstract class AbstractNotationFigure extends Shape {

	public void setLayoutManager(LayoutManager manager) {
		LayoutManager lay = this.getLayoutManager();
		
		if(lay!=null) {
			if(lay instanceof MultiLayout) {
				((MultiLayout)lay).addLayout(manager);
				revalidate();
			} else {
				MultiLayout mlay = new  MultiLayout();
				mlay.addLayout(lay);
				mlay.addLayout(manager);
				super.setLayoutManager(mlay);
			}
		} else 
			super.setLayoutManager(manager);
	}

	public void setConstraint(IFigure child, Object constraint) {
		super.setConstraint(child, constraint);
	}

}

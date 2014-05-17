package edu.pku.sei.gmp.notation.layout;

import java.util.Iterator;
import java.util.List;

import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Rectangle;

import edu.pku.sei.gmp.notation.layout.constraint.VectorGraphLayoutConstraint;

public class VectorGraphLayout extends AbstractNotationLayout {

	public VectorGraphLayout() {

	}

	@Override
	protected Dimension calculatePreferredSize(IFigure container, int wHint,
			int hHint) {
		return container.getBounds().getSize();
	}

	public void layout(IFigure container) {
		Rectangle bound = container.getBounds();
		double vRate, hRate;
		int x, y, w, h;

		vRate = ((double) bound.height) / 100.0;
		hRate = ((double) bound.width) / 100.0;
		List<?> slaves = container.getChildren();
		Iterator<?> it = slaves.iterator();

		while (it.hasNext()) {
			IFigure c = (IFigure) it.next();
			VectorGraphLayoutConstraint cc = (VectorGraphLayoutConstraint) getConstraint(c);
			if (cc == null) {
			} else {
				x = bound.x + (int) (cc.x * hRate);
				y = bound.y + (int) (cc.y * vRate);
				w = (int) (cc.w * hRate);
				h = (int) (cc.h * vRate);
				c.setBounds(new Rectangle(x, y, w, h));
			}
		}
	}

	public void setConstraint(IFigure parent, IFigure figure) {
		parent.setConstraint(figure, new VectorGraphLayoutConstraint(parent
				.getBounds(), figure.getBounds()));
	}
}

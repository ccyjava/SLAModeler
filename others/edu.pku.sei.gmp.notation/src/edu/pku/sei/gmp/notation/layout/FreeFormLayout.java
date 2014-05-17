package edu.pku.sei.gmp.notation.layout;

import java.util.Iterator;
import java.util.List;

import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Rectangle;

import edu.pku.sei.gmp.notation.layout.constraint.FreeFormLayoutConstraint;

public class FreeFormLayout extends AbstractNotationLayout {

	protected Dimension calculatePreferredSize(IFigure container, int wHint,
			int hHint) {
		return container.getBounds().getSize();
	}

	protected Rectangle SINGLETON = new Rectangle();

	public void layout(IFigure container) {
		Rectangle r = container.getBounds();
		int x = r.x;
		int y = r.y;

		int w = r.width;
		int h = r.height;

		List<?> slaves = container.getChildren();

		Iterator<?> it = slaves.iterator();

		while (it.hasNext()) {
			IFigure c = (IFigure) it.next();
			FreeFormLayoutConstraint cc = (FreeFormLayoutConstraint) getConstraint(c);
			SINGLETON.setBounds(c.getBounds());

			if (cc.left >= 0 && cc.right >= 0) {
				// reset the x and width
				SINGLETON.x = (x + cc.left);
				SINGLETON.width = (w - cc.left - cc.right);
			} else {
				if (cc.left >= 0) {
					// just reset the x
					SINGLETON.x = (x + cc.left);
				}
				if (cc.right >= 0) {
					// just reset the x
					SINGLETON.x = (x + w - cc.right - SINGLETON.width);
				}
			}

			if (cc.top >= 0 && cc.bottom >= 0) {
				// reset the y and height
				SINGLETON.y = (y + cc.top);
				SINGLETON.height = (h - cc.top - cc.bottom);
			} else {
				if (cc.top >= 0) {
					// just reset the y
					SINGLETON.y = (y + cc.top);
				}
				if (cc.bottom >= 0) {
					// just reset the y
					SINGLETON.y = (y + h - cc.bottom - SINGLETON.height);
				}
			}
			c.setBounds(SINGLETON);
		}
	}

	public void setConstraint(IFigure parent, IFigure figure, int l, int t,
			int r, int b) {
		parent.setConstraint(figure, new FreeFormLayoutConstraint(l, t, r, b));
	}
}

package edu.pku.sei.gmp.notation.layout;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.draw2d.AbstractLayout;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.LayoutManager;
import org.eclipse.draw2d.geometry.Dimension;

import edu.pku.sei.gmp.notation.layout.constraint.LayoutConstraint;

public class MultiLayout extends AbstractLayout {

	protected List<LayoutManager> layoutList = new ArrayList<LayoutManager>();

	public Object getConstraint(IFigure figure) {
		Iterator<LayoutManager> i = layoutList.iterator();
		while (i.hasNext()) {
			LayoutManager l = (LayoutManager) i.next();
			Object o = l.getConstraint(figure);
			if (o != null)
				return o;
		}
		return null;
	}

	public void setConstraint(IFigure figure, Object newConstraint) {
		LayoutConstraint c = (LayoutConstraint) newConstraint;
		if (c == null)
			return;
		Class<?> type = c.getLayoutManagerType();
		Iterator<LayoutManager> i = layoutList.iterator();
		while (i.hasNext()) {
			LayoutManager l = (LayoutManager) i.next();
			if (l.getClass() == type) {
				l.setConstraint(figure, newConstraint);
			}
		}
		invalidate(figure);
	}

	public void addLayout(LayoutManager layout) {
		layoutList.add(layout);
	}

	protected Dimension calculatePreferredSize(IFigure container, int wHint,
			int hHint) {
		if (preferredSize == null) {
			preferredSize = new Dimension();
		}
		preferredSize.setSize(container.getSize());
		return preferredSize;
	}

	public void layout(IFigure container) {
		Iterator<LayoutManager> i = layoutList.iterator();

		while (i.hasNext()) {
			LayoutManager l = (LayoutManager) i.next();
			l.layout(container);
		}
	}

	public void invalidate() {
		super.invalidate();
		Iterator<LayoutManager> i = layoutList.iterator();
		while (i.hasNext()) {
			LayoutManager l = (LayoutManager) i.next();
			l.invalidate();
		}
	}

}

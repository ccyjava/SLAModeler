/**
 * @(#)SimpleContainerFigure.java, 2012-4-13. Copyright 2012 OOTeam, SEI, PKU.
 *                                 All rights reserved. OOTeam
 *                                 PROPRIETARY/CONFIDENTIAL. Use is subject to
 *                                 license terms.
 */
package edu.pku.sei.gmp.controller.figure;

import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.FreeformLayer;
import org.eclipse.draw2d.FreeformLayout;
import org.eclipse.draw2d.FreeformViewport;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.Label;
import org.eclipse.draw2d.LayoutManager;
import org.eclipse.draw2d.LineBorder;
import org.eclipse.draw2d.ScrollPane;
import org.eclipse.draw2d.ToolbarLayout;

import edu.pku.sei.gmp.controller.figure.GMPCommonFigure;
import edu.pku.sei.gmp.resource.image.GMPImageProvider;

//import edu.pku.sei.webfront.images.WebFrontImageProvider;

/**
 * @author QiuRui
 */
public class SimpleContainerFigure extends GMPCommonFigure {

	private IFigure collapsedLabel;

	private ScrollPane scrollpane;

	protected final IFigure pane;

	public SimpleContainerFigure() {
		super();
		setOpaque(true);
		LineBorder border = new LineBorder();
		border.setColor(ColorConstants.gray);
		setBorder(border);

		ToolbarLayout layout = new ToolbarLayout();
		layout.setStretchMinorAxis(true);
		layout.setSpacing(0);
		setLayoutManager(layout);

		collapsedLabel = createCollapsedLabel();
		collapsedLabel.setSize(100, 15);
		add(collapsedLabel);

		pane = new FreeformLayer();
		pane.setLayoutManager(new FreeformLayout());

		scrollpane = new ScrollPane();
		scrollpane.setViewport(new FreeformViewport());
		scrollpane.setContents(pane);
		scrollpane.setPreferredSize(100, 1000);
		this.add(scrollpane);

		setPreferredSize(100, 100);
	}

	private Label createCollapsedLabel() {
		Label label = new Label();
		label.setText(" ");
		// label.setIcon(WebFrontImageProvider.getImage("collapsed.gif"));
		label.setIcon(GMPImageProvider
				.getImage(GMPImageProvider.CONTAIER_IMAGE));
		return label;
	}

	public IFigure getContentPane() {
		return pane;
	}

	public IFigure getCollapsedLabel() {
		return collapsedLabel;
	}

	public ScrollPane getScrollpane() {
		return scrollpane;
	}

	@Override
	protected boolean useLocalCoordinates() {
		return true;
	}

	public void setPaneLayout(LayoutManager layout) {
		pane.setLayoutManager(layout);
	}
}

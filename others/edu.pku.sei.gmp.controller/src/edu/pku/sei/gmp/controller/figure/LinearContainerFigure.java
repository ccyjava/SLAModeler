/**
 * @(#)LinearContainerFigure.java, 2012-4-15. Copyright 2012 OOTeam, SEI, PKU.
 *                                 All rights reserved. OOTeam
 *                                 PROPRIETARY/CONFIDENTIAL. Use is subject to
 *                                 license terms.
 */
package edu.pku.sei.gmp.controller.figure;

import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.FreeformLayer;
import org.eclipse.draw2d.FreeformViewport;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.LayoutManager;
import org.eclipse.draw2d.LineBorder;
import org.eclipse.draw2d.ScrollPane;
import org.eclipse.draw2d.ToolbarLayout;

import edu.pku.sei.gmp.controller.figure.GMPCommonFigure;

/**
 * @author QiuRui
 */
public class LinearContainerFigure extends GMPCommonFigure {

    protected IFigure layer;

    /**
     * 默认的是纵向的ToolbarLayout，可以�?�?     * 
     * @see edu.pku.sei.webfront.ctrl.figure.LinearContainerFigure#setLayerLayout(LayoutManager)
     *      来改变默认的layout�?     *      
     */
    public LinearContainerFigure() {

        setOpaque(false);
        LineBorder border = new LineBorder();
        border.setColor(ColorConstants.gray);
        setBorder(border);
        
        ToolbarLayout layout = new ToolbarLayout();
        layout.setStretchMinorAxis(true);
        layout.setSpacing(2);
        setLayoutManager(layout);

        layer = new FreeformLayer();
        ToolbarLayout layout1 = new ToolbarLayout();
        layout1.setVertical(true);
        layout1.setSpacing(2);
        layout1.setStretchMinorAxis(true);
        layout1.setMinorAlignment(ToolbarLayout.ALIGN_TOPLEFT);
        layer.setLayoutManager(layout1);
        ScrollPane scrollPane = new ScrollPane();
        scrollPane.setViewport(new FreeformViewport());
        scrollPane.setContents(layer);
        scrollPane.setPreferredSize(100, 10000);
        add(scrollPane);
        //add(layer);

        setPreferredSize(100, 100);

    }

    public IFigure getContentPane() {
        return layer;
    }

    public void setLayerLayout(LayoutManager layout) {
        layer.setLayoutManager(layout);
    }
}

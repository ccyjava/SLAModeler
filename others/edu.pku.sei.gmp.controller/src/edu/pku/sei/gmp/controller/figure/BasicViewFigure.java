/**
 * @(#)BasicViewFigure.java, 2012-4-14. 
 * 
 * Copyright 2012 OOTeam, SEI, PKU. All rights reserved.
 * OOTeam PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package edu.pku.sei.gmp.controller.figure;

import org.eclipse.draw2d.Label;
import org.eclipse.draw2d.LineBorder;
import org.eclipse.draw2d.PositionConstants;
import org.eclipse.draw2d.ToolbarLayout;

import edu.pku.sei.gmp.controller.figure.GMPCommonFigure;

/**
 *
 * @author QiuRui
 *
 */
public class BasicViewFigure extends GMPCommonFigure {

    private Label header;

    public BasicViewFigure(Label header) {
        this.header = header;
        this.header.setLabelAlignment(PositionConstants.MIDDLE);
        this.header.setOpaque(true);
        ToolbarLayout layout = new ToolbarLayout();
        setLayoutManager(layout);
        setBorder(new LineBorder(1));
        add(header);
        setPreferredSize(65, 30);
    }

    public Label getHeader() {
        return header;
    }
}

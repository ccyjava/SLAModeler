/**
 * @(#)ContainerFigure.java, 2012-3-12. Copyright 2012 OOTeam, SEI, PKU. All
 *                           rights reserved. OOTeam PROPRIETARY/CONFIDENTIAL.
 *                           Use is subject to license terms.
 */
package edu.pku.sei.gmp.controller.figure;

import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.FreeformLayer;
import org.eclipse.draw2d.FreeformLayout;
import org.eclipse.draw2d.FreeformViewport;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.Label;
import org.eclipse.draw2d.LineBorder;
import org.eclipse.draw2d.PositionConstants;
import org.eclipse.draw2d.ScrollPane;
import org.eclipse.draw2d.StackLayout;
import org.eclipse.draw2d.ToolbarLayout;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.FontData;
import org.eclipse.swt.widgets.Display;

import edu.pku.sei.gmp.controller.figure.GMPCommonFigure;
import edu.pku.sei.gmp.resource.image.GMPImageProvider;

/**
 * Figure likes UML Package figure
 * 
 * @author QiuRui
 */
public class ContainerFigure extends GMPCommonFigure {

    static final Color CONTAINER_COLOR = ColorConstants.black;

    public ContainerHeaderFigure headerFigure;

    public ContainerContentFigure contentFigure;

    public ContainerFigure() {
        final ToolbarLayout layout = new ToolbarLayout();
        layout.setSpacing(0);
        setLayoutManager(layout);
        setForegroundColor(CONTAINER_COLOR);
        setOpaque(false);
        headerFigure = new ContainerHeaderFigure();
        add(headerFigure);
        contentFigure = new ContainerContentFigure();
        add(contentFigure);
    }

    public void changeLineColor(Color color) {
        if (color != null) {
            this.setForegroundColor(color);
            headerFigure.changeBorderColor(color);
        }
    }

    @Override
    protected void paintShadow(Graphics g) {
        g.pushState();
        Rectangle rect = getBounds().getCopy().translate(3, 3);
        g.setClip(rect);
        g.setBackgroundColor(ColorConstants.buttonDarker);
        g.popState();
    }

    public IFigure getContentPane() {
        return contentFigure.getContentPane();
    }

    public ContainerHeaderFigure getHeaderFigure() {
        return headerFigure;
    }

    public void setHeaderFigure(ContainerHeaderFigure headerFigure) {
        this.headerFigure = headerFigure;
    }

    public void setBounds(Rectangle rect) {
        this.headerFigure.setBounds(rect);
        this.contentFigure.setBounds(rect);
        super.setBounds(rect);
    }

    public Label getNameLabel() {
        return this.headerFigure.nameLabel;
    }

    public void setNameLabel(Label nameLabel) {
        this.headerFigure.nameLabel = nameLabel;
    }

    public class ContainerHeaderFigure extends GMPCommonFigure {

        private Label nameLabel;

        public ContainerHeaderFigure() {
            super();
            final ToolbarLayout layout = new ToolbarLayout();
            layout.setSpacing(0);
            setLayoutManager(layout);
            setOpaque(true); // non-transparent figure
            FontData[] fontdata = {
                new FontData("Arial", 9, SWT.BOLD)
            };
            this.nameLabel = new Label("");
            this.nameLabel.setFont(new Font(Display.getCurrent(), fontdata));
            this.nameLabel.setIcon(GMPImageProvider
                    .getImage(GMPImageProvider.FIELD_PACKAGE_IMAGE));
            this.nameLabel.setOpaque(false);
            this.nameLabel.setLabelAlignment(PositionConstants.LEFT);
            this.add(this.nameLabel);
            // should look in the preferences
            setBorder(new LineBorder(ContainerFigure.CONTAINER_COLOR));
            setForegroundColor(ColorConstants.black);
        }

        public void setBounds(Rectangle rectangle) {
            int headerWidth = this.nameLabel.getPreferredSize().width + 8;
            int headerHeight = this.nameLabel.getPreferredSize().height;
            Rectangle.SINGLETON.setLocation(0, 0);
            Rectangle.SINGLETON.setSize(headerWidth, headerHeight);
            super.setBounds(Rectangle.SINGLETON);
        }

        public void changeBorderColor(Color color) {
            ((LineBorder) getBorder()).setColor(color);
        }
    }

    public class ContainerContentFigure extends GMPCommonFigure {
        /** pane where the content of the element is draw */
        protected final IFigure pane;

        public ContainerContentFigure() {
            super();
            setLayoutManager(new StackLayout());
            pane = new FreeformLayer();
            pane.setLayoutManager(new FreeformLayout());
            // Add scrollpane
            ScrollPane scrollpane = new ScrollPane();
            scrollpane.setViewport(new FreeformViewport());
            scrollpane.setContents(pane);
            this.add(scrollpane);
            setBorder(new LineBorder(1));
            setOpaque(false);
        }

        public IFigure getContentPane() {
            return pane;
        }

        @Override
        public void setBounds(Rectangle rect) {
            int fatherHeight = getParent().getBounds().height;
            int fatherWidth = getParent().getBounds().width;
            int headerY = headerFigure.getSize().height;
            super.setBounds(new Rectangle(0, headerY - 1, fatherWidth,
                    fatherHeight - headerY));
        }

        @Override
        protected boolean useLocalCoordinates() {
            return true;
        }
    }

    protected boolean useLocalCoordinates() {
        return true;
    }
}

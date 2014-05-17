package edu.pku.sei.apel.ctrl.figure;

import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.ImageFigure;
import org.eclipse.draw2d.Label;
import org.eclipse.draw2d.ToolbarLayout;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.swt.graphics.Image;

import edu.pku.sei.apel.images.ApelImageProvider;
import edu.pku.sei.gmp.controller.figure.GMPCommonFigure;


public class CoImageFigure extends GMPCommonFigure {
	
	protected ImageFigure imageFigure;
	protected Label nameLabel;

	public CoImageFigure(String name, String imageName) {
		ToolbarLayout layout = new ToolbarLayout();
		this.setLayoutManager(layout);
		layout.setSpacing(2);
		layout.setVertical(true);
		this.setOpaque(true);
		
		Image image = ApelImageProvider.getImage(imageName);
		imageFigure = new ImageFigure(image);
		this.add(imageFigure);

		nameLabel = new Label(name);
		nameLabel.setForegroundColor(ColorConstants.black);
		nameLabel.setBackgroundColor(ColorConstants.white);
		this.add(nameLabel);
	}
	
	@Override
	public void setBounds(Rectangle rect) {
		Rectangle bounds = rect.getCopy();
		
		int	width, height;
		int nWidth = nameLabel.getPreferredSize().width;
		int iWidth = imageFigure.getPreferredSize().width;
		if(nWidth>iWidth){
			width = nWidth + 8;
		} else {
			width = iWidth + 8;
		}
		
		height = nameLabel.getPreferredSize().height + imageFigure.getPreferredSize().height + 4;
		
		Rectangle.SINGLETON.setLocation(0, 0);
		bounds.setSize(width, height);
		super.setBounds(bounds);
	}

	public Label getNameLabel() {
		return nameLabel;
	}

	public void setName(String newName) {	
		this.nameLabel.setText(newName);
	}
}

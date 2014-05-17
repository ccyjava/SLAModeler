package edu.pku.sei.gmp.notation.figure;

import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.ImageData;

public class ImageFigure extends AbstractNotationFigure {
	private String lastImage = null;
	private Image image = null;
	private Rectangle SINGLETON = new Rectangle();

	public ImageFigure(String uri) {
		this.setImageURI(uri);
	}

	public Image getImage() {
		return image;
	}

	public void setImage(Image image) {
		this.image = image;
	}

	public void setImageURI(String uri) {
		Image img;

		try {
			if (lastImage != uri) {
				img = getImage();
				if (img != null)
					img.dispose();
				lastImage = uri;
			}

			if (uri == null) {
				setImage(null);
			} else {
				img = new Image(null, uri);
				setImage(img);
			}
		} catch (Exception e) {
			System.out.println("DEBUG:" + e.toString());
			lastImage = null;
			image = null;
		}
	}

	protected void fillShape(Graphics graphics) {
		if (getImage() == null)
			return;

		Image img = getImage();
		ImageData dat = img.getImageData();
		Rectangle rect = this.getClientArea();

		graphics.drawImage(img, 0, 0, dat.width, dat.height, rect.x, rect.y,
				rect.width, rect.height);
	}

	protected void outlineShape(Graphics graphics) {
		if (image != null)
			return;
		SINGLETON.setBounds(this.getBounds());
		SINGLETON.width -= lineWidth;
		SINGLETON.height -= lineWidth;

		graphics.drawFocus(SINGLETON);
	}

}

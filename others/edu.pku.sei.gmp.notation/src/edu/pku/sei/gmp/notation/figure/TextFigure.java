package edu.pku.sei.gmp.notation.figure;

import org.eclipse.draw2d.Label;

public class TextFigure extends Label {
	
	public void setAlignment(int align) {
		setTextPlacement(Label.NORTH);
		switch(align){
		case 0:
			setTextAlignment(Label.LEFT);break;
		case 1:
			setTextAlignment(Label.CENTER);break;
		case 2:
			setTextAlignment(Label.RIGHT);break;
		}
	}
}

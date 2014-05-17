package edu.pku.sei.apel.ctrl.editpolicy;

import org.eclipse.draw2d.FlowLayout;
import org.eclipse.draw2d.IFigure;

public class ApelFlowLayout extends FlowLayout {
	
	int Vgap;//两元素间的垂直间隙
	int Hgap;//两元素间的水平间隙
	
	protected void layoutRow(IFigure parent) {
		int majorAdjustment = 0;
		int minorAdjustment = 0;
		int correctMajorAlignment = majorAlignment;
		int correctMinorAlignment = minorAlignment;

		majorAdjustment = data.area.width - data.rowWidth + getMinorSpacing();
		
		switch (correctMajorAlignment) {
			case ALIGN_LEFTTOP: 
				majorAdjustment = 0;
				break;
			case ALIGN_CENTER:
				majorAdjustment /= 2;
				break;
			case ALIGN_RIGHTBOTTOM:
				break;
		}

		for (int j = 0; j < data.rowCount; j++) {
			if (fill) {
				data.bounds[j].height = data.rowHeight;	
			} else {
				minorAdjustment = data.rowHeight - data.bounds[j].height;
				switch (correctMinorAlignment) {
					case ALIGN_LEFTTOP: 
						minorAdjustment = 25;
						break;
					case ALIGN_CENTER:
						minorAdjustment /= 2;
					break;
					case ALIGN_RIGHTBOTTOM:
						break;
				}
				data.bounds[j].y += minorAdjustment;
			}
			data.bounds[j].x += majorAdjustment;
			
			setBoundsOfChild(parent, data.row[j], transposer.t(data.bounds[j]));
		}
		data.rowY += getMajorSpacing() + data.rowHeight;
		initRow();
	}
	
	public ApelFlowLayout(){
		super();
	}
	
	public ApelFlowLayout(int Vgap,int Hgap){
		this.Vgap=Vgap;
		this.Hgap=Hgap;
	}
	
	public int getHgap(){
		return this.Hgap;
	}
	
	public int getVgap(){
		return this.Vgap;
	}
	
	public void setHgap(int Hgap){
		this.Hgap=Hgap;
	}
	
	public void setVgap(int Vgap){
		this.Vgap=Vgap;
	}

}

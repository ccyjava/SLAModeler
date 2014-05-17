package edu.pku.sei.gmp.notation.layout;

import java.util.Iterator;
import java.util.List;

import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Rectangle;

import edu.pku.sei.gmp.notation.layout.constraint.FlowLayoutConstraint;

public class FlowLayout extends AbstractNotationLayout {
	public boolean isVertical;
	public int align;
	final static public int ALIGN_LEFT = 0;
	final static public int ALIGN_TOP = 0;
	final static public int ALIGN_CENTER = 1;
	final static public int ALIGN_RIGHT = 2;
	final static public int ALIGN_BOTTOM = 2;
	public FlowLayout() {
		super();
		isVertical = true;
		align = ALIGN_LEFT;
	}
	public FlowLayout(boolean ver) {
		super();
		isVertical = ver;
		align = ALIGN_LEFT;
	}
	protected Dimension calculatePreferredSize(IFigure container, int wHint, int hHint) {
		return container.getBounds().getSize();
	}
	static protected Rectangle SINGLETON = new  Rectangle();

	public void layout(IFigure container) {
		Rectangle r = container.getBounds();
		int x = r.x;
		int y = r.y;
		
		int w = r.width;
		int h = r.height;
		
		List<?> slaves = container.getChildren();
		Iterator<?> it = null;
		
		if (isVertical) {
			int base = 0;
			int used = 0;
			it = slaves.iterator();
			while(it.hasNext()) {
				IFigure c = (IFigure) it.next();
				FlowLayoutConstraint d = (FlowLayoutConstraint) getConstraint(c);
				if(d.height<0) base+=d.height;
				else used+=d.height-1;
			}
			
			int spared = h-used;
			int spareuse = 0;
			
			it = slaves.iterator();
			
			while (it.hasNext()) {
				IFigure c = (IFigure) it.next();
				FlowLayoutConstraint d = (FlowLayoutConstraint) this.getConstraint(c);
				SINGLETON.setBounds(c.getBounds());
				
				if (d.width <0)
					SINGLETON.width = w;
				else
					SINGLETON.width = d.width;

				if (d.height < 0) {
					int curr = (int)(spared*((double)d.height/(double)base));
					if(it.hasNext()) {
						spareuse += curr-1;
						SINGLETON.height = curr;
					} else SINGLETON.height = (spared-spareuse);
				}
				else
					SINGLETON.height = d.height;
				int a ;
				if(d.align!=-1) a = d.align;
				else a = align;
				
				switch(a)
				{
				case ALIGN_LEFT:SINGLETON.x = x;break;
				case ALIGN_CENTER:SINGLETON.x = (x+w/2-SINGLETON.width/2);break;
				case ALIGN_RIGHT:SINGLETON.x =(x+w-SINGLETON.width);break;
				}
				
				SINGLETON.y = y;
				y+=SINGLETON.height-1;
				
				c.setBounds(SINGLETON);
			}
		}
		else {
			int base = 0;
			int used = 0;
			it = slaves.iterator();
			while(it.hasNext()) {
				IFigure c = (IFigure) it.next();
				FlowLayoutConstraint d = (FlowLayoutConstraint) this.getConstraint(c);
				if(d.width<0) base+=d.width;
				else used+=d.width-1;// FIXME used+=d.height-lineWidth
			}
			
			int spared = w-used;
			int spareuse = 0;
			
			it = slaves.iterator();
			
			while (it.hasNext()) {
				IFigure c = (IFigure) it.next();
				FlowLayoutConstraint d = (FlowLayoutConstraint) this.getConstraint(c);
				SINGLETON.setBounds(c.getBounds());
				
				if (d.height <0)
					SINGLETON.height = h;
				else
					SINGLETON.height = d.height;

				if (d.width < 0) {
					int curr = (int)(spared*((double)d.width/(double)base));
					if(it.hasNext()) {
						spareuse += curr-1;
						SINGLETON.width = curr;
					} else SINGLETON.width = (spared-spareuse);
				}
				else
					SINGLETON.width = d.width;
				
				SINGLETON.x = x;

				switch(align){
					case ALIGN_TOP:SINGLETON.y = y;break;
					case ALIGN_CENTER:SINGLETON.y = (y+h/2-SINGLETON.height/2);break;
					case ALIGN_BOTTOM:SINGLETON.y = (y+h-SINGLETON.height);break;
				}
				
				x+=SINGLETON.width-1;
				c.setBounds(SINGLETON);
			}
		}
	}
	
	public void setConstraint(IFigure parent,IFigure figure,int w,int h) {
		parent.setConstraint(figure, new FlowLayoutConstraint(w,h));
	}
	public void setConstraint(IFigure parent,IFigure figure,int w,int h,int a) {
		parent.setConstraint(figure, new FlowLayoutConstraint(w,h));
	}
	
	public int getAlign() {
		return align;
	}
	public void setAlign(int align) {
		this.align = align;
	}
	public boolean isVertical() {
		return isVertical;
	}
	public void setVertical(boolean isVertical) {
		this.isVertical = isVertical;
	}
}

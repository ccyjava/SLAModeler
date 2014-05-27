package edu.pku.sei.gmp.resource.color;

import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.widgets.Display;

import edu.pku.sei.gmp.resource.GMPResourceManager;

public class GMPColorManager extends GMPResourceManager<Integer,Color>{
	public GMPColorManager(){
		super();
	}
	public void init(){
		addColor(0,0,0);
		addColor(255,255,255);
		addColor(255,0,0);
		addColor(0,255,0);
		addColor(0,0,255);
	}
	private void addColor(int r,int g,int b){
		Color c = null;
		int key = GMPColor.toInteger(r, g, b);
		c = new Color(Display.getCurrent(),r,g,b);
		set(key,c);
	}
	public Color getSWTColor(GMPColor c){
		return getSWTColor(c.red,c.green,c.blue);
	}
	public Color getSWTColor(int r,int g,int b){
		
		int key = GMPColor.toInteger(r, g, b);
		org.eclipse.swt.graphics.Color c = null;
		if(key==-1)
			return null;
		else
			c = get(key);
		if(c==null){
			c = new Color(Display.getCurrent(),r,g,b);
			set(key,c);
		}
		return c;
	}
}


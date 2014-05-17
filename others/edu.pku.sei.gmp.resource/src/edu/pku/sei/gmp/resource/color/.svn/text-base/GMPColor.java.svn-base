package edu.pku.sei.gmp.resource.color;

import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.RGB;
import org.eclipse.swt.widgets.Display;



public class GMPColor {
	final public static GMPColor BLACK = new GMPColor(0,0,0);
	final public static GMPColor WHITE = new GMPColor(255,255,255);
	final public static GMPColor TRANSPARENT = new GMPColor(-1,-1,-1);
	public int red;
	public int green;
	public int blue;
	
	public GMPColor(int r,int g,int b){
		red = r;
		green = g;
		blue = b;
	}
	public GMPColor(){
		red = 0;
		green = 0;
		blue = 0;
	}
	public GMPColor(RGB rgb){
		fromRGB(rgb);
	}
	
	public RGB toRGB(){
		RGB rgb = new RGB(red,green,blue);
		return rgb;
	}
	public void fromRGB(RGB rgb){
		red = rgb.red;
		green = rgb.green;
		blue = rgb.blue;
	}
	public org.eclipse.swt.graphics.Color toSWTColor(){
		int r = red & 0xff;
		int g = green & 0xff;
		int b = blue & 0xff;
		
		return new Color(Display.getCurrent(),r,g,b);
	}
	public void fromSWTColor(Color GMPColor){
		red = GMPColor.getRed();
		green = GMPColor.getGreen();
		blue = GMPColor.getBlue();
	}
	
	public int toInteger(){
		return toInteger(red,green,blue);
	}
	static public int toInteger(int red,int green,int blue){
		int val = 0;
		if(red==-1||green==-1||blue==-1)
			val = -1;
		else
			val = ((red & 0xff)<<16)|((green & 0xff)<<8)|((blue & 0xff));
		
		return val;
	}
}

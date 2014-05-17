package edu.pku.sei.gmp.resource;

import java.util.HashMap;
import java.util.Iterator;

import org.eclipse.swt.graphics.Color;

import edu.pku.sei.gmp.resource.color.GMPColor;
import edu.pku.sei.gmp.resource.color.GMPColorManager;

public class GMPResourceGroupManager {
		public static GMPResourceGroupManager SINGLETON = new GMPResourceGroupManager();
		@SuppressWarnings("unchecked")
		private HashMap<Object,GMPResourceManager> managers;
		@SuppressWarnings("unchecked")
		public GMPResourceGroupManager(){
			managers = new HashMap<Object,GMPResourceManager>();
			addManager(COLOR_RESOURCE,new GMPColorManager());
		}
		
		@SuppressWarnings("unchecked")
		private void addManager(Object id,GMPResourceManager m){
			managers.put(id,m);
		}
		@SuppressWarnings("unchecked")
		public void dispose(){
			Iterator<GMPResourceManager> it = managers.values().iterator();
			while(it.hasNext()){
				it.next().dispose();
			}
		}
		@SuppressWarnings("unchecked")
		public GMPResourceManager getManager(Object id){
			return managers.get(id);
		}	
		
		final static public String COLOR_RESOURCE = "COLOR_RESOURCE";
		static public Color getSWTColor(int r,int g,int b){
			GMPColorManager m = (GMPColorManager)SINGLETON.getManager(COLOR_RESOURCE);
			if(m==null) return null;
			else return m.getSWTColor(r, g, b);
		}
		static public Color getSWTColor(GMPColor c){
			GMPColorManager m = (GMPColorManager)SINGLETON.getManager(COLOR_RESOURCE);
			if(m==null) return null;
			else return m.getSWTColor(c);
		}
}

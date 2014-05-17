package edu.pku.sei.gmp.explorer.actions;

import java.util.HashMap;

import org.eclipse.gef.ui.actions.UpdateAction;


public class GMPExplorerUpdateActionManager {
	
	private GMPExplorerUpdateActionManager(){
		
	}
	
	private static GMPExplorerUpdateActionManager instance = null;

	public static GMPExplorerUpdateActionManager getInstance() {
		if (instance == null) {
			instance = new GMPExplorerUpdateActionManager();
		}
		return instance;
	}
	
	private HashMap<String,UpdateAction> actions = new HashMap<String,UpdateAction>();
	
	public void addAction(String id, UpdateAction action){
		actions.put(id, action);
	}
	
	public UpdateAction getAction(String id){
		UpdateAction action = actions.get(id);
		if (action == null) {
			for (String key : actions.keySet()) {
				if (key.equals(id)) {
					action = actions.get(key);
					break;
				}
			}
		}
		return action;
	}
	
	public void updateActions(){
		for(UpdateAction a : actions.values()){
			a.update();
		}
	}
}

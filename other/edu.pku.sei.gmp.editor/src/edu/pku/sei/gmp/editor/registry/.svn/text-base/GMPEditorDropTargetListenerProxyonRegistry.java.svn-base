package edu.pku.sei.gmp.editor.registry;

import java.util.HashMap;

import edu.pku.sei.gmp.editor.dnd.IGMPEditorDropTargetListenerProxyon;

public class GMPEditorDropTargetListenerProxyonRegistry {
	
	private GMPEditorDropTargetListenerProxyonRegistry() {
	}

	private static GMPEditorDropTargetListenerProxyonRegistry instance = null;

	public static GMPEditorDropTargetListenerProxyonRegistry getInstance() {
		if (instance == null) {
			instance = new GMPEditorDropTargetListenerProxyonRegistry();
		}
		return instance;
	}

	private HashMap<String,IGMPEditorDropTargetListenerProxyon> map 
			= new HashMap<String,IGMPEditorDropTargetListenerProxyon>();
	
	/**
	 * 向ListenerProxyon注册表中注册一个{@link IGMPEditorDropTargetListenerProxyon}。
	 * 
	 * @param projectNature,listenerProxyon
	 */
	public void registerProxyon(String projectNature,IGMPEditorDropTargetListenerProxyon listenerProxyon) {
		map.put(projectNature,listenerProxyon);
	}
	
	public IGMPEditorDropTargetListenerProxyon getProxyon(String projectNature) {
		IGMPEditorDropTargetListenerProxyon listenerProxyon = map.get(projectNature);
		if (listenerProxyon == null) {
			for (String key : map.keySet()) {
				if (key.equals(projectNature)) {
					listenerProxyon = map.get(key);
					break;
				}
			}
		}
		return listenerProxyon;
	}

}

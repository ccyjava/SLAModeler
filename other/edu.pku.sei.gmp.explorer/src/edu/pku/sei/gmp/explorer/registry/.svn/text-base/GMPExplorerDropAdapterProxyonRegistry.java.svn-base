package edu.pku.sei.gmp.explorer.registry;

import java.util.HashMap;

import edu.pku.sei.gmp.explorer.dnd.IGMPViewerDropAdapterProxyon;

public class GMPExplorerDropAdapterProxyonRegistry {
	
	private GMPExplorerDropAdapterProxyonRegistry() {
	}

	private static GMPExplorerDropAdapterProxyonRegistry instance = null;

	public static GMPExplorerDropAdapterProxyonRegistry getInstance() {
		if (instance == null) {
			instance = new GMPExplorerDropAdapterProxyonRegistry();
		}
		return instance;
	}

	private HashMap<String,IGMPViewerDropAdapterProxyon> map 
			= new HashMap<String,IGMPViewerDropAdapterProxyon>();
	
	/**
	 * 向DropAdapter注册表中注册一个{@link IGMPViewerDropAdapterProxyon}。
	 * 
	 * @param projectNature,dropAdapter
	 */
	public void registerProxyon(String projectNature,IGMPViewerDropAdapterProxyon dropAdapter) {
		map.put(projectNature,dropAdapter);
	}
	
	public IGMPViewerDropAdapterProxyon getProxyon(String projectNature) {
		IGMPViewerDropAdapterProxyon dropAdapter = map.get(projectNature);
		if (dropAdapter == null) {
			for (String key : map.keySet()) {
				if (key.equals(projectNature)) {
					dropAdapter = map.get(key);
					break;
				}
			}
		}
		return dropAdapter;
	}
}

package edu.pku.sei.gmp.resource;

import java.util.HashMap;
import java.util.Iterator;

import org.eclipse.swt.graphics.Resource;

public class GMPResourceManager<K, R> {
	protected HashMap<K, R> resourceMap;

	public GMPResourceManager() {
		postInit();
		init();
	}

	private void postInit() {
		resourceMap = new HashMap<K, R>();
	}

	public void init() {
	}

	public void dispose() {
		Iterator<R> e = resourceMap.values().iterator();
		while (e.hasNext()) {
			Resource res = (Resource) e.next();
			res.dispose();
		}
		resourceMap.clear();
	}

	public R get(K id) {
		return resourceMap.get(id);
	}

	public void set(K k, R r) {
		R old = resourceMap.get(k);
		if (old != null) {
			((Resource) old).dispose();
		}
		resourceMap.put(k, r);
	}

	public boolean isContain(K k) {
		return resourceMap.containsKey(k);
	}
}

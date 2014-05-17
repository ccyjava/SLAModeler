package edu.pku.sei.gmp.explorer.registry;

import java.util.HashMap;

import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.ITreeContentProvider;

public class GMPExplorerProviderRegistry {
	private GMPExplorerProviderRegistry() {
		
	}
	
	private static GMPExplorerProviderRegistry instance = null;
	
	public static GMPExplorerProviderRegistry getInstance() {
		if (instance == null) {
			instance = new GMPExplorerProviderRegistry();
		}
		return instance;
	}
	
	private HashMap<String, ITreeContentProvider> contentProviderMap = 
			new HashMap<String, ITreeContentProvider>();
	private HashMap<String, ILabelProvider> labelProviderMap = 
			new HashMap<String, ILabelProvider>();
	
	
	public void registerProvider(String projectNature,
			ITreeContentProvider contentProvider, ILabelProvider labelProvider) {
		contentProviderMap.put(projectNature, contentProvider);
		labelProviderMap.put(projectNature, labelProvider);
	}
	
	public ITreeContentProvider getContentProvider(String projectNature) {
		ITreeContentProvider provider = contentProviderMap.get(projectNature);
		if (provider == null) {
			for (String key : contentProviderMap.keySet()) {
				if (key.equals(projectNature)) {
					provider = contentProviderMap.get(key);
					break;
				}
			}
		}
		return provider;
	}
	
	public ILabelProvider getLabelProvider(String projectNature) {
		ILabelProvider provider = labelProviderMap.get(projectNature);
		if (provider == null) {
			for (String key : labelProviderMap.keySet()) {
				if (key.equals(projectNature)) {
					provider = labelProviderMap.get(key);
					break;
				}
			}
		}
		return provider;
	}
}

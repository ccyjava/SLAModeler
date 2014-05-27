package edu.pku.sei.gmp.editor.registry;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

import edu.pku.sei.gmp.editor.action.IEditorActionProvider;

public class GMPEditorActionProviderRegistry {
	private GMPEditorActionProviderRegistry() {
	}
	
	private static GMPEditorActionProviderRegistry instance = null;
	
	public static GMPEditorActionProviderRegistry getInstance() {
		if (instance == null) {
			instance = new GMPEditorActionProviderRegistry();
		}
		return instance;
	}
	
	private HashSet<IEditorActionProvider> set = new HashSet<IEditorActionProvider>();

	/**
	* 向Action注册表中注册一个{@link IEditorActionProvider}。
	* 
	* @param actionProvider
	*/
	public void registerActionProvider(IEditorActionProvider actionProvider) {
		set.add(actionProvider);
	}
	
	public ArrayList<IEditorActionProvider> getActionProviders(String projectNature) {
		ArrayList<IEditorActionProvider> providers = new ArrayList<IEditorActionProvider>();
		Iterator<IEditorActionProvider> i = set.iterator();
		while(i.hasNext()){
			IEditorActionProvider provider = (IEditorActionProvider) i.next();
			if(provider.getProjectNature().equals(projectNature))
				providers.add(provider);
		}
		return providers;
	}
}

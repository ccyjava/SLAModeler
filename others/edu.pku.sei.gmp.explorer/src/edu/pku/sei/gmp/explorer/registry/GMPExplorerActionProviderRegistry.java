package edu.pku.sei.gmp.explorer.registry;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

import edu.pku.sei.gmp.explorer.actions.IExplorerActionProvider;

public class GMPExplorerActionProviderRegistry {

	private GMPExplorerActionProviderRegistry() {
	}

	private static GMPExplorerActionProviderRegistry instance = null;

	public static GMPExplorerActionProviderRegistry getInstance() {
		if (instance == null) {
			instance = new GMPExplorerActionProviderRegistry();
		}
		return instance;
	}

	private HashSet<IExplorerActionProvider> set 
			= new HashSet<IExplorerActionProvider>();
	
	/**
	 * 向Action注册表中注册一个{@link IExplorerActionProvider}。
	 * 
	 * @param actionProvider
	 */
	public void registerActionProvider(IExplorerActionProvider actionProvider) {
		set.add(actionProvider);
	}
	
	public ArrayList<IExplorerActionProvider> getActionProviders(String projectNature) {
		ArrayList<IExplorerActionProvider> providers = new ArrayList<IExplorerActionProvider>();
		Iterator<IExplorerActionProvider> i = set.iterator();
		while(i.hasNext()){
			IExplorerActionProvider provider = (IExplorerActionProvider) i.next();
			if(provider.getProjectNature().equals(projectNature))
				providers.add(provider);
		}
		return providers;
	}
}

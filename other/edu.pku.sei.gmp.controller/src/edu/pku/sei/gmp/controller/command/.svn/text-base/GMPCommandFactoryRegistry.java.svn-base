package edu.pku.sei.gmp.controller.command;

import java.util.HashMap;

public class GMPCommandFactoryRegistry {
	private GMPCommandFactoryRegistry() {
		
	}
	
	private static GMPCommandFactoryRegistry instance;
	
	public static GMPCommandFactoryRegistry getInstance() {
		if (instance == null) {
			instance = new GMPCommandFactoryRegistry();
		}
		return instance;
	}
	
	private HashMap<String, GMPCommandFactory> factoryMap = 
		new HashMap<String, GMPCommandFactory>();
	
	public void registerCommandFactory(String projectNature, GMPCommandFactory factory) {
		factoryMap.put(projectNature, factory);
	}
	
	public GMPCommandFactory getCommandFactory(String projectNature) {
		return factoryMap.get(projectNature);
	}
}

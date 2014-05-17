package edu.pku.sei.gmp.project.registry;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.CoreException;

import edu.pku.sei.gmp.project.GMPProject;
import edu.pku.sei.gmp.project.IProjectFactory;


public class GMPProjectRegistry {
	
	private GMPProjectRegistry() {}
	
	private static GMPProjectRegistry instance = null;
	
	public static GMPProjectRegistry getInstance() {
		if (instance == null) {
			instance = new GMPProjectRegistry();
		}
		return instance;
	}
	
	private List<GMPProject> projects = new ArrayList<GMPProject>();
	private List<IProjectFactory> factories = new ArrayList<IProjectFactory>();
	
	public void registerFactory(IProjectFactory factory) {
		for (IProjectFactory f : factories) {
			if (f.getNature().equals(factory.getNature())) {
				throw new RuntimeException("project nature conflicts!");
			}
		}
		factories.add(factory);
	}
	
	public GMPProject createProject(IProject proj) throws CoreException {
		for (IProjectFactory f : factories) {
			if (proj.hasNature(f.getNature())) {
				return createProject(proj, f.getNature());
			}
		}
		return null;
	}
	
	public GMPProject createProject(IProject proj, String nature) {
		for (IProjectFactory f : factories) {
			if (f.getNature().equals(nature)) {
				GMPProject p = f.createProject(proj);
				projects.add(p);
				return p;
			}
		}
		return null;
	}
	
	public void deleteProject(IProject project) {
		List<GMPProject> projects = GMPProjectRegistry.getInstance().getAllProjects();
		for (GMPProject p : projects) {
			if (p.getProject().equals(project)) {
				projects.remove(p);
			}
		}
		
	}
	
	public List<String> getNatures() {
		List<String> natures = new ArrayList<String>();
		for (IProjectFactory f : factories) {
			natures.add(f.getNature());
		}
		return natures;
	}

	public List<GMPProject> getAllProjects() {
		return projects;
	}
}

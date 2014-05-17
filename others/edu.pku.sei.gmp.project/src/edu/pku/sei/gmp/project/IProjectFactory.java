package edu.pku.sei.gmp.project;

import org.eclipse.core.resources.IProject;

public interface IProjectFactory {
	public String getNature();

	public GMPProject createProject(IProject proj);
}

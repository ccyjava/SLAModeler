package edu.pku.sei.gmp.ide.wizard;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IProjectDescription;
import org.eclipse.core.resources.IWorkspaceRunnable;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;

import edu.pku.sei.gmp.project.GMPProject;
import edu.pku.sei.gmp.project.exception.ProjectSaveException;
import edu.pku.sei.gmp.project.registry.GMPProjectRegistry;

public class CreateProjectOperation implements IWorkspaceRunnable {
	private String projectName;
	private String projectType;

	public CreateProjectOperation(String projectName, String projectType) {
		super();
		this.projectName = projectName;
		this.projectType = projectType;
	}

	@Override
	public void run(IProgressMonitor monitor) throws CoreException {
		monitor.worked(1);
		IProject project = createProject(monitor);
		monitor.worked(1);
		GMPProject mProject = GMPProjectRegistry.getInstance().createProject(
				project, projectType);
		mProject.initProject();
		if (mProject != null) {
			mProject.setProject(project);
			try {
				mProject.save();
			} catch (ProjectSaveException e) {
				e.printStackTrace();
			}
		} else {
			// TODO: open a dialog to notify the user
			// that no Modeling plugin is installed to edit the project
		}
	}

	protected IProject getProject(String project) {
		return ResourcesPlugin.getWorkspace().getRoot().getProject(project);
	}

	private IProject createProject(IProgressMonitor monitor)
			throws CoreException {
		final IProject project = getProject(projectName);
		IProjectDescription desc = project.getWorkspace()
				.newProjectDescription(projectName);
		desc.setNatureIds(new String[] {GMPProject.GMP_COMMON_NATURE,
		 projectType});
		project.create(desc, monitor);
		project.open(monitor);
		return project;
	}

}

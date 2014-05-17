/**
 * Copyright (c) Software Institute of PKU
 * All rights reserved. 
 * This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 */
package edu.pku.sei.gmp.ide.wizard;

import java.lang.reflect.InvocationTargetException;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IWorkspaceRunnable;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.INewWizard;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchWizard;
import org.eclipse.ui.wizards.newresource.BasicNewProjectResourceWizard;

import edu.pku.sei.gmp.project.registry.GMPProjectRegistry;

/**
 * @author zl
 * 
 */
public class NewProjectWizard extends BasicNewProjectResourceWizard implements
		INewWizard {
	private NewProjectWizardPage page;

	public NewProjectWizard() {
		super();
		setNeedsProgressMonitor(true);
	}

	public void addPages() {
		page = new NewProjectWizardPage();
		addPage(page);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.jface.wizard.Wizard#performFinish()
	 */
	public boolean performFinish() {
		final String projectName = page.getProjectName();
		final String projectType = page.getProjectType();
		IRunnableWithProgress op = new IRunnableWithProgress() {
			public void run(IProgressMonitor monitor)
					throws InvocationTargetException {
				try {
					doFinish(projectName, projectType, monitor);
				} catch (CoreException e) {
					e.printStackTrace();
					throw new InvocationTargetException(e);
				} finally {
					monitor.done();
				}
			}
		};
		try {
			if (GMPProjectRegistry.getInstance().getNatures().isEmpty()) {
				if (MessageDialog
						.openConfirm(getShell(), "confirm",
								"No modeling plugin found in the current plugin set. Continue?")) {
					getContainer().run(true, false, op);
				} else
					return false;
			}
			getContainer().run(true, false, op);

		} catch (InterruptedException e) {
			e.printStackTrace();
			return false;
		} catch (InvocationTargetException e) {
			e.printStackTrace();
			Throwable realException = e.getTargetException();
			StackTraceElement[] eles = realException.getStackTrace();
			String trace = "";
			for (int i = 0; i < eles.length; i++) {
				trace += eles[i].toString() + "\r\n";
			}

			MessageDialog.openError(getShell(), "Error", trace);
			return false;
		}
		try {
			updatePerspective();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return true;
	}

	private void doFinish(String projectName, String projectType,
			IProgressMonitor monitor) throws CoreException {
		// create a new project
		monitor.beginTask("Creating " + projectName, 6);
		IWorkspaceRunnable create = new CreateProjectOperation(projectName,
				projectType);
		ResourcesPlugin.getWorkspace().run(create, monitor);
		monitor.worked(1);
		monitor.setTaskName("Opening file for editing...");
		monitor.worked(1);
	}

	protected IProject getProject(String project) {
		return ResourcesPlugin.getWorkspace().getRoot().getProject(project);
	}

	/**
	 * We will accept the selection in the workbench to see if we can initialize
	 * from it.
	 * 
	 * @see IWorkbenchWizard#init(IWorkbench, IStructuredSelection)
	 */
	public void init(IWorkbench workbench, IStructuredSelection selection) {
		// TODO Auto-generated method stub

	}

}

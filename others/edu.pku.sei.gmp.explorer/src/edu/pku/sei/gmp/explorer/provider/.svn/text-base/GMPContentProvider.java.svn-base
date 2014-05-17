package edu.pku.sei.gmp.explorer.provider;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IResourceChangeEvent;
import org.eclipse.core.resources.IResourceChangeListener;
import org.eclipse.core.resources.IResourceDelta;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.StructuredViewer;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.swt.widgets.Control;

import edu.pku.sei.gmp.explorer.registry.GMPExplorerProviderRegistry;
import edu.pku.sei.gmp.model.common.GMPModel;
import edu.pku.sei.gmp.model.concept.GMPElement;
import edu.pku.sei.gmp.project.GMPProject;
import edu.pku.sei.gmp.project.exception.ProjectLoadException;
import edu.pku.sei.gmp.project.registry.GMPProjectRegistry;
import edu.pku.sei.gmp.project.util.GMPProjectUtils;

public class GMPContentProvider implements ITreeContentProvider, 
		IResourceChangeListener{

	private TreeViewer viewer;
	
	public GMPContentProvider(TreeViewer viewer) {
		this.viewer = viewer;
	}
	
	private PropertyChangeListener modelListener = new PropertyChangeListener() {
		public void propertyChange(PropertyChangeEvent event) {
			handlePropertyChanged(event);
		}
	};

	public PropertyChangeListener getModelListener() {
		return modelListener;
	}
	
	protected void handlePropertyChanged(PropertyChangeEvent event) {
		Object src = event.getSource();
		Object parent = getParent(src);
		
		if (src instanceof GMPModel) {
			viewer.refresh();
			viewer.expandToLevel(src, 1);
		}
		
		if (parent != null) {
			if (viewer != null) {
				viewer.refresh(src);
				viewer.expandToLevel(src, 1);
			}
		}
	}
	
	@Override
	public Object[] getChildren(Object parent) {
		if (parent instanceof GMPElement) {
			GMPElement element = (GMPElement)parent;
			element.addPropertyChangeListener(modelListener);
		}
		
		if (parent instanceof IProject) {
			IProject proj = (IProject) parent;
			try {
				if (!proj.isOpen())
					return new Object[0];
				return proj.members();
			} catch (CoreException e) {
				e.printStackTrace();
			}
		} else if (parent instanceof IFolder) {
			try {
				return ((IFolder) parent).members();
			} catch (CoreException e) {
				e.printStackTrace();
			}
		} else if (parent instanceof GMPProject) {
			GMPProject p = (GMPProject) parent;
			if (p.getModels().size() == 0) {
				try {
					p.load();
				} catch (ProjectLoadException e) {
					e.printStackTrace();
					return new Object[0];
				}
			}
			for (GMPModel model : p.getModels()) {
				model.addPropertyChangeListener(modelListener);
			}
			ITreeContentProvider contentProvider = GMPExplorerProviderRegistry
					.getInstance().getContentProvider(p.getProjectNature());
			if (contentProvider != null) {
				return contentProvider.getChildren(p);
			} else {
				// TODO default project.
			}
		} else if (parent instanceof GMPElement) {
			GMPModel model = ((GMPElement) parent).getModel();
			if (model != null) {
				GMPProject p = GMPProjectUtils.model2project(model);
				if (p != null) {
					ITreeContentProvider contentProvider = GMPExplorerProviderRegistry
							.getInstance().getContentProvider(
									p.getProjectNature());
					if (contentProvider != null) {
						return contentProvider.getChildren(parent);
					}
				}
			}
			// TODO return default children.
		}
		return new Object[0];
	}

	@Override
	public Object getParent(Object element) {
		if (element instanceof GMPElement) {
			return ((GMPElement)element).getContainer();
		}
		return null;
	}

	@Override
	public boolean hasChildren(Object element) {
		return getChildren(element).length > 0;
	}

	@Override
	public Object[] getElements(Object inputElement) {
		if (inputElement instanceof IWorkspaceRoot) {
			IWorkspaceRoot root = (IWorkspaceRoot) inputElement;
			root.getWorkspace().addResourceChangeListener(this);
			IProject[] projs = root.getProjects();
			Object[] objs = new Object[projs.length];
			
			// TODO ugly!!! need refactor
			for (int i = 0; i < projs.length; i++) {
				IProject proj = projs[i];
				try {
					if (proj.isOpen()
							&& proj.hasNature(GMPProject.GMP_COMMON_NATURE)) {
						GMPProject p = GMPProjectUtils.getGMPProject(proj);
						if (p == null) {
							p = GMPProjectRegistry.getInstance().createProject(
									proj);
							if (p != null) {
								try {
									p.load();
								} catch (ProjectLoadException e) {
									e.printStackTrace();
									return new Object[0];
								}
								objs[i] = p;
							} else {
								objs[i] = proj;
							}
						} else {
							objs[i] = p;
						}
					} else {
						objs[i] = proj;
					}
				} catch (CoreException e) {
					e.printStackTrace();
				}
			}
			return objs;
		}
		return new Object[0];
	}

	@Override
	public void dispose() {
		if (viewer != null) {
			IWorkspaceRoot workspace = null;
			Object obj = viewer.getInput();
			if (obj instanceof IWorkspaceRoot) {
				workspace = (IWorkspaceRoot) obj;
			}
			if (workspace != null) {
				workspace.getWorkspace().removeResourceChangeListener(this);
			}
		}
	}

	@Override
	public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
		
	}

	@Override
	public void resourceChanged(IResourceChangeEvent event) {
		final IResourceDelta delta = event.getDelta();
		Control ctrl = viewer.getControl();
		if (ctrl != null && !ctrl.isDisposed()) {
			ctrl.getDisplay().syncExec(new Runnable() {
				public void run() {
					processDelta(delta);
				}
			});
		}
	}
	
	protected void processDelta(IResourceDelta delta) {
		// This method runs inside a syncExec. The widget may have been
		// destroyed
		// by the time this is run. Check for this and do nothing if so.
		Control ctrl = viewer.getControl();
		if (ctrl == null || ctrl.isDisposed()||delta==null)
			return;

		// Get the affected resource
		IResource resource = delta.getResource();

		IResourceDelta[] affectedChildren = delta
				.getAffectedChildren(IResourceDelta.CHANGED);
		for (int i = 0; i < affectedChildren.length; i++) {
			if ((affectedChildren[i].getFlags() & IResourceDelta.TYPE) != 0) {
				((StructuredViewer) viewer).refresh(resource);
				return;
			}
		}

		// Check the flags for changes the Navigator cares about.
		// See ResourceLabelProvider for the aspects it cares about.
		// Notice we don't care about F_CONTENT or F_MARKERS currently.
		int changeFlags = delta.getFlags();
		if ((changeFlags & (IResourceDelta.OPEN | IResourceDelta.SYNC)) != 0) {
			((StructuredViewer) viewer).update(resource, null);
		}
		// Replacing a resource may affect its label and its children
		if ((changeFlags & IResourceDelta.REPLACED) != 0) {
			((StructuredViewer) viewer).refresh(resource, true);
			return;
		}

		// Handle changed children .
		for (int i = 0; i < affectedChildren.length; i++) {
			processDelta(affectedChildren[i]);
		}

		boolean addedAndRemoved = false;
		try {
			IResourceDelta[] addedChildren = delta
					.getAffectedChildren(IResourceDelta.ADDED);
			IResourceDelta[] removedChildren = delta
					.getAffectedChildren(IResourceDelta.REMOVED);
			addedAndRemoved = addedChildren.length > 0
					& removedChildren.length > 0;

			// Disable redraw until the operation is finished so we don't get a
			// flash of both the new and old item (in the case of rename)
			// Only do this if we're both adding and removing files (the rename
			// case)
			if (addedAndRemoved)
				viewer.getControl().setRedraw(false);

			// Process additions before removals as to not cause selection
			// preservation prior to new objects being added
			// Handle added children. Issue one update for all insertions.
			if (addedChildren.length > 0) {
				Object[] affected = new Object[addedChildren.length];
				for (int i = 0; i < addedChildren.length; i++)
					affected[i] = addedChildren[i].getResource();
				((StructuredViewer) viewer).refresh(resource);
			}

			// Handle removed children. Issue one update for all removals.
			if (removedChildren.length > 0) {
				Object[] affected = new Object[removedChildren.length];
				for (int i = 0; i < removedChildren.length; i++) {
					affected[i] = removedChildren[i].getResource();
					
					if (affected[i] instanceof IProject) {
						GMPProjectRegistry.getInstance().deleteProject((IProject)affected[i]);
					}
					
				}
				((StructuredViewer) viewer).refresh(resource);
			}
		} finally {
			if (addedAndRemoved)
				viewer.getControl().setRedraw(true);
		}
	}

}

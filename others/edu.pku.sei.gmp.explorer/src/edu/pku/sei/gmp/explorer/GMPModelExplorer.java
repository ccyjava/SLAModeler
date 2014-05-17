package edu.pku.sei.gmp.explorer;

import java.util.ArrayList;
import java.util.EventObject;
import java.util.List;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.gef.commands.CommandStack;
import org.eclipse.gef.commands.CommandStackListener;
import org.eclipse.gef.dnd.TemplateTransfer;
import org.eclipse.gef.ui.properties.UndoablePropertySheetEntry;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.action.IMenuListener;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.action.Separator;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.DoubleClickEvent;
import org.eclipse.jface.viewers.IDoubleClickListener;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.dnd.DND;
import org.eclipse.swt.dnd.Transfer;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.ui.IActionBars;
import org.eclipse.ui.IPartListener;
import org.eclipse.ui.ISaveablePart;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.actions.ActionFactory;
import org.eclipse.ui.part.ViewPart;
import org.eclipse.ui.views.properties.IPropertySheetPage;
import org.eclipse.ui.views.properties.PropertySheetPage;

import edu.pku.sei.gmp.common.cmdstack.GMPCommandStack;
import edu.pku.sei.gmp.explorer.actions.GMPExplorerActionGroup;
import edu.pku.sei.gmp.explorer.actions.GMPExplorerUpdateActionManager;
import edu.pku.sei.gmp.explorer.actions.GMPRedoAction;
import edu.pku.sei.gmp.explorer.actions.GMPSaveAction;
import edu.pku.sei.gmp.explorer.actions.GMPUndoAction;
import edu.pku.sei.gmp.explorer.dnd.GMPDragSourceListener;
import edu.pku.sei.gmp.explorer.dnd.GMPViewerDropAdapter;
import edu.pku.sei.gmp.explorer.provider.GMPContentProvider;
import edu.pku.sei.gmp.explorer.provider.GMPLabelProvider;
import edu.pku.sei.gmp.explorer.util.GMPExplorerUtils;
import edu.pku.sei.gmp.model.concept.GMPElement;
import edu.pku.sei.gmp.project.GMPProject;
import edu.pku.sei.gmp.project.exception.ProjectSaveException;
import edu.pku.sei.gmp.project.util.GMPProjectUtils;
import edu.pku.sei.gmp.resource.image.GMPImageProvider;

public class GMPModelExplorer extends ViewPart implements CommandStackListener, ISaveablePart,IPartListener {

	private TreeViewer viewer;
	private PropertySheetPage page = new PropertySheetPage();
	private GMPExplorerActionGroup defaultActionGroup;
	private CommandStack cmdStack;
	private ArrayList<CommandStack> commandStacks = new ArrayList<CommandStack>();

	@Override
	public void createPartControl(Composite parent) {
		viewer = new TreeViewer(parent, SWT.MULTI | SWT.H_SCROLL | SWT.V_SCROLL);
		defaultActionGroup = new GMPExplorerActionGroup(viewer);

		// set drag support
		viewer.addDragSupport(DND.DROP_MOVE | DND.DROP_COPY,
				new Transfer[] { TemplateTransfer.getInstance() },
				new GMPDragSourceListener(viewer));

		// set drop support
		viewer.addDropSupport(DND.DROP_MOVE | DND.DROP_COPY,
				new Transfer[] { TemplateTransfer.getInstance() },
				new GMPViewerDropAdapter(viewer));
		
		// set content provider
		GMPContentProvider contentProvider = new GMPContentProvider(viewer);
		viewer.setContentProvider(contentProvider);

		// set label provider
		GMPLabelProvider labelProvider = new GMPLabelProvider();
		viewer.setLabelProvider(labelProvider);
		
		// create undo redo save action
		createUpdateActions();
		// add tool bar actions
		contributeToActionBars();
		
		// register actions
		viewer.addSelectionChangedListener(new ISelectionChangedListener() {
			@Override
			public void selectionChanged(SelectionChangedEvent event) {
				if (event.getSelection() instanceof IStructuredSelection) {
					final List<?> treeList = ((IStructuredSelection) event
							.getSelection()).toList();

					if (!treeList.isEmpty()) {
						Object item = treeList.get(0);
						if (item instanceof GMPElement) {
							if (cmdStack != null)
								cmdStack.removeCommandStackListener(GMPModelExplorer.this);
							cmdStack = ((GMPElement) item).getCommandStack();
							if(!commandStacks.contains(cmdStack))
								commandStacks.add(cmdStack);
							cmdStack.addCommandStackListener(GMPModelExplorer.this);
							page.setRootEntry(new UndoablePropertySheetEntry(
									cmdStack));
						}
						GMPExplorerUpdateActionManager.getInstance()
						.updateActions();
					}
					
					MenuManager mManager = new MenuManager();
					defaultActionGroup.fillContextMenu(mManager);

					List<GMPExplorerActionGroup> groups = GMPExplorerUtils
							.getActionGroups(treeList, viewer);
					for (GMPExplorerActionGroup group : groups) {
						mManager.add(new Separator());
						group.fillContextMenu(mManager);
					}

					Menu menu = mManager.createContextMenu(viewer.getControl());
					menu.getItems();
					viewer.getTree().setMenu(menu);
				}
				updateInput();
			}
		});

		viewer.addDoubleClickListener(new IDoubleClickListener() {
			public void doubleClick(DoubleClickEvent event) {
				final Object item = ((IStructuredSelection) event
						.getSelection()).getFirstElement();
				Action action = GMPExplorerUtils.getDoubleClickAction(item);
				if (action != null) {
					action.run();
				}
			}
		});
		
		// create the menu when select nothing.
		hookContextMenu();
		
		IWorkspaceRoot root = ResourcesPlugin.getWorkspace().getRoot();
		if (root == null) {
			MessageDialog.openInformation(null, "debug_information",
					"workspace root is null!");
		} else {
			viewer.setInput(root);
		}

		getSite().setSelectionProvider(viewer);
		
		// listening to part lifecycle events
		getSite().getWorkbenchWindow(). getPartService().addPartListener(this);
	}

	@Override
	public void setFocus() {
		viewer.getControl().setFocus();
	}

	/**
	 * update the EditorInput, reload the workspace.
	 */
	public void updateInput() {
		IWorkspaceRoot root = ResourcesPlugin.getWorkspace().getRoot();
		try {
			root.refreshLocal(5, null);
			refreshPullDown();
		} catch (CoreException e) {
			e.printStackTrace();
		}
		if (root == null) {
			MessageDialog.openInformation(null, "debug_information",
					"workspace root is null!");
		} else {
			viewer.setInput(root);
			viewer.refresh(true);
		}
	}

	/**
	 * hook up the context menu for the viewer, that is, the menu appeared when
	 * user right click the viewer, not any of the items.
	 */
	private void hookContextMenu() {
		MenuManager menuMgr = new MenuManager("#PopupMenu");
		menuMgr.setRemoveAllWhenShown(true);
		menuMgr.addMenuListener(new IMenuListener() {
			public void menuAboutToShow(IMenuManager manager) {
			}
		});
		Menu menu = new Menu(viewer.getControl());
		MenuItem update = new MenuItem(menu, SWT.None);
		update.setText("Reload workspace");
		update.setImage(GMPImageProvider.getImage(GMPImageProvider.MODEL_VIEW));
		update.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				updateInput();
			}
		});
		viewer.getTree().setMenu(menu);
		getSite().registerContextMenu(menuMgr, viewer);

	}
	
	private void createUpdateActions(){
		GMPExplorerUpdateActionManager.getInstance().addAction(GMPUndoAction.ACTION_ID,new GMPUndoAction(viewer) );
		GMPExplorerUpdateActionManager.getInstance().addAction(GMPRedoAction.ACTION_ID,new GMPRedoAction(viewer) );
		GMPExplorerUpdateActionManager.getInstance().addAction(GMPSaveAction.ACTION_ID,new GMPSaveAction(viewer) );
	}
	
	private void refreshPullDown(){
		getViewSite().getActionBars().getMenuManager().removeAll();
		fillLocalPullDown(getViewSite().getActionBars().getMenuManager());
	}
	
	
	private void contributeToActionBars() {
		IActionBars bars = getViewSite().getActionBars();
		fillLocalPullDown(bars.getMenuManager());
		fillLocalToolBar(bars.getToolBarManager());
		hookGlobalActions(bars);
	}

	private void fillLocalPullDown(IMenuManager manager) {
		manager.add((IAction) GMPExplorerUpdateActionManager.getInstance().getAction(GMPUndoAction.ACTION_ID));
		manager.add((IAction) GMPExplorerUpdateActionManager.getInstance().getAction(GMPRedoAction.ACTION_ID));
		manager.add(new Separator());
		manager.add((IAction) GMPExplorerUpdateActionManager.getInstance().getAction(GMPSaveAction.ACTION_ID));
		List<GMPExplorerActionGroup> groups = GMPExplorerUtils
				.getPullDownActionGroups(viewer);
		for (GMPExplorerActionGroup group : groups) {
			manager.add(new Separator());
			group.fillContextMenu(manager);
		}
	}
	
	private void fillLocalToolBar(IToolBarManager manager) {
		manager.add((IAction) GMPExplorerUpdateActionManager.getInstance().getAction(GMPUndoAction.ACTION_ID));
		manager.add((IAction) GMPExplorerUpdateActionManager.getInstance().getAction(GMPRedoAction.ACTION_ID));
		manager.add((IAction) GMPExplorerUpdateActionManager.getInstance().getAction(GMPSaveAction.ACTION_ID));
	}
	
	private void hookGlobalActions(IActionBars bars){
		bars.setGlobalActionHandler(ActionFactory.UNDO.getId(), (IAction) GMPExplorerUpdateActionManager.getInstance().getAction(GMPUndoAction.ACTION_ID));
		bars.setGlobalActionHandler(ActionFactory.REDO.getId(), (IAction) GMPExplorerUpdateActionManager.getInstance().getAction(GMPRedoAction.ACTION_ID));
//		bars.setGlobalActionHandler(ActionFactory.SAVE.getId(), (IAction) GMPExplorerUpdateActionManager.getInstance().getAction(GMPSaveAction.ACTION_ID));
	}
	@SuppressWarnings("unchecked")
	@Override
	public Object getAdapter(Class adapter) {
		if (adapter == IPropertySheetPage.class) {
			CommandStack cmdStack = GMPCommandStack.getCommandStack();
			page.setRootEntry(new UndoablePropertySheetEntry(cmdStack));
			return page;
		}
		return null;
	}

	@Override
	public void commandStackChanged(EventObject event) {
		GMPExplorerUpdateActionManager.getInstance().updateActions();
	}
	
	public CommandStack getCmdStack() {
		return cmdStack;
	}

	public void setCmdStack(CommandStack cmdStack) {
		this.cmdStack = cmdStack;
	}

	public void dispose() { 
        getSite().getWorkbenchWindow(). getPartService().removePartListener(this);
	}
	
	@Override
	public void doSave(IProgressMonitor monitor) {
	}

	@Override
	public void doSaveAs() {
	}

	@Override
	public boolean isDirty() {
		for(CommandStack c : commandStacks){
			if(c.isDirty())
				return true;
		}
		return false;
	}

	@Override
	public boolean isSaveAsAllowed() {
		return false;
	}

	@Override
	public boolean isSaveOnCloseNeeded() {
		return isDirty();
	}

	@Override
	public void partActivated(IWorkbenchPart part) {
	}

	@Override
	public void partBroughtToTop(IWorkbenchPart part) {
	}

	@Override
	public void partClosed(IWorkbenchPart part) {
		IWorkspaceRoot root = (IWorkspaceRoot) viewer.getInput();
		IProject[] projs = root.getProjects();
		for (IProject proj : projs) {
			try {
				if (proj.isOpen() && proj.hasNature(GMPProject.GMP_COMMON_NATURE)) {
					GMPProject p = GMPProjectUtils.getGMPProject(proj);
					if (p != null) 
						p.save();
				}
			} catch (CoreException e) {
				e.printStackTrace();
			} catch (ProjectSaveException e) {
				e.printStackTrace();
			} 
		}
		for(CommandStack c : commandStacks){
			if(c.isDirty())
				c.markSaveLocation();
		}
	}

	@Override
	public void partDeactivated(IWorkbenchPart part) {	
	}

	@Override
	public void partOpened(IWorkbenchPart part) {
	}
}

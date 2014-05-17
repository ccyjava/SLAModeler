package edu.pku.sei.gmp.editor;

import java.util.ArrayList;
import java.util.EventObject;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.gef.DefaultEditDomain;
import org.eclipse.gef.EditPartFactory;
import org.eclipse.gef.GraphicalViewer;
import org.eclipse.gef.KeyHandler;
import org.eclipse.gef.KeyStroke;
import org.eclipse.gef.editparts.ScalableFreeformRootEditPart;
import org.eclipse.gef.editparts.ZoomManager;
import org.eclipse.gef.palette.PaletteRoot;
import org.eclipse.gef.ui.actions.ActionRegistry;
import org.eclipse.gef.ui.actions.DirectEditAction;
import org.eclipse.gef.ui.actions.GEFActionConstants;
import org.eclipse.gef.ui.parts.GraphicalEditorWithFlyoutPalette;
import org.eclipse.gef.ui.parts.SelectionSynchronizer;
import org.eclipse.gef.ui.parts.TreeViewer;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.swt.SWT;
import org.eclipse.ui.IActionBars;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorSite;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.actions.ActionFactory;
import org.eclipse.ui.views.contentoutline.IContentOutlinePage;

import edu.pku.sei.gmp.common.cmdstack.GMPCommandStack;
import edu.pku.sei.gmp.editor.action.GMPEditorContextMenuProvider;
import edu.pku.sei.gmp.editor.action.common.GMPCopyAction;
import edu.pku.sei.gmp.editor.action.common.GMPCutAction;
import edu.pku.sei.gmp.editor.action.common.GMPMoveNodesAction;
import edu.pku.sei.gmp.editor.action.common.GMPPasteAction;
import edu.pku.sei.gmp.editor.dnd.GMPEditorDropTargetListener;
import edu.pku.sei.gmp.editor.palette.GMPPaletteFactory;
import edu.pku.sei.gmp.model.common.GMPModel;
import edu.pku.sei.gmp.model.shape.GMPDiagram;
import edu.pku.sei.gmp.project.exception.ProjectSaveException;
import edu.pku.sei.gmp.project.util.GMPProjectUtils;

public class GMPModelerEditor extends GraphicalEditorWithFlyoutPalette {

	private GMPDiagram diagram;

	private GMPPaletteFactory paletteFactory;
	private EditPartFactory editPartFactory;

	public EditPartFactory getEditPartFactory() {
		return editPartFactory;
	}

	public void setEditPartFactory(EditPartFactory editPartFactory) {
		this.editPartFactory = editPartFactory;
	}

	public GMPDiagram getDiagram() {
		return diagram;
	}

	public void setDiagram(GMPDiagram diagram) {
		this.diagram = diagram;
	}

	public ActionRegistry getActionRegistry() {
		return super.getActionRegistry();
	}

	public void init(IEditorSite site, IEditorInput input)
			throws PartInitException {
		setSite(site);
		setInput(input);
		setPartName(input.getName());
		DefaultEditDomain editDomain = new DefaultEditDomain(this);
		editDomain.setCommandStack(GMPCommandStack
				.getCommandStack(((GMPEditorInput) input).getDiagram()
						.getModel()));
		setEditDomain(editDomain);
		super.init(site, input);
	}

	protected void initializeGraphicalViewer() {
		GraphicalViewer viewer = getGraphicalViewer();
		viewer.setRootEditPart(new ScalableFreeformRootEditPart());
		viewer.setContents(diagram);
		viewer.addDropTargetListener(new GMPEditorDropTargetListener(viewer));
	}

	protected void configureGraphicalViewer() {
		super.configureGraphicalViewer();
		GraphicalViewer viewer = getGraphicalViewer();
		viewer.setEditPartFactory(editPartFactory);

		// setup all actions
		// add all the actions in GMPActionRegistry into the System
		// ActionRegistry
		viewer = getGraphicalViewer();
		viewer.setContextMenu(new GMPEditorContextMenuProvider(viewer, diagram,
				getActionRegistry()));

		// set key handler
		KeyHandler keyHandler = new KeyHandler();
		keyHandler.put(KeyStroke.getPressed(SWT.DEL, 127, 0),
				getActionRegistry().getAction(ActionFactory.DELETE.getId()));
		keyHandler.put(KeyStroke.getPressed(SWT.F2, 0), getActionRegistry()
				.getAction(GEFActionConstants.DIRECT_EDIT));
		keyHandler.put(KeyStroke.getPressed(SWT.ARROW_UP, 0),
				getActionRegistry().getAction(GMPMoveNodesAction.UP));
		keyHandler.put(KeyStroke.getPressed(SWT.ARROW_DOWN, 0),
				getActionRegistry().getAction(GMPMoveNodesAction.DOWN));
		keyHandler.put(KeyStroke.getPressed(SWT.ARROW_LEFT, 0),
				getActionRegistry().getAction(GMPMoveNodesAction.LEFT));
		keyHandler.put(KeyStroke.getPressed(SWT.ARROW_RIGHT, 0),
				getActionRegistry().getAction(GMPMoveNodesAction.RIGHT));
		keyHandler.put(KeyStroke.getPressed(SWT.ARROW_UP, SWT.CTRL),
				getActionRegistry().getAction(GEFActionConstants.ZOOM_IN));

		getGraphicalViewer().setKeyHandler(keyHandler);
	}

	@SuppressWarnings("unchecked")
	protected void createActions() {
		super.createActions();
		ActionRegistry registry = getActionRegistry();

		IAction actionDirectEdit = new DirectEditAction((IWorkbenchPart) this);
		registry.registerAction(actionDirectEdit);
		getSelectionActions().add(actionDirectEdit.getId());

		IAction actionCopy = new GMPCopyAction(this);
		actionCopy.setId(ActionFactory.COPY.getId());
		registry.registerAction(actionCopy);
		getSelectionActions().add(actionCopy.getId());

		IAction actionCut = new GMPCutAction(this);
		actionCut.setId(ActionFactory.CUT.getId());
		registry.registerAction(actionCut);
		getSelectionActions().add(actionCut.getId());

		IAction actionPaste = new GMPPasteAction(this);
		actionPaste.setId(ActionFactory.PASTE.getId());
		registry.registerAction(actionPaste);
		getSelectionActions().add(actionPaste.getId());

		IAction actionUp = new GMPMoveNodesAction(this);
		actionUp.setId(GMPMoveNodesAction.UP);
		registry.registerAction(actionUp);
		getSelectionActions().add(actionUp.getId());

		IAction actionDown = new GMPMoveNodesAction(this);
		actionDown.setId(GMPMoveNodesAction.DOWN);
		registry.registerAction(actionDown);
		getSelectionActions().add(actionDown.getId());

		IAction actionLeft = new GMPMoveNodesAction(this);
		actionLeft.setId(GMPMoveNodesAction.LEFT);
		registry.registerAction(actionLeft);
		getSelectionActions().add(actionLeft.getId());

		IAction actionRight = new GMPMoveNodesAction(this);
		actionRight.setId(GMPMoveNodesAction.RIGHT);
		registry.registerAction(actionRight);
		getSelectionActions().add(actionRight.getId());

		registry = getActionRegistry();
		IActionBars bars = this.getEditorSite().getActionBars();
		String id = ActionFactory.UNDO.getId();
		bars.setGlobalActionHandler(id, registry.getAction(id));
		id = ActionFactory.REDO.getId();
		bars.setGlobalActionHandler(id, registry.getAction(id));
		id = ActionFactory.DELETE.getId();
		bars.setGlobalActionHandler(id, registry.getAction(id));
		id = ActionFactory.COPY.getId();
		bars.setGlobalActionHandler(id, registry.getAction(id));
		id = ActionFactory.CUT.getId();
		bars.setGlobalActionHandler(id, registry.getAction(id));
		id = ActionFactory.PASTE.getId();
		bars.setGlobalActionHandler(id, registry.getAction(id));

		bars.updateActionBars();
	}

	// 得到控制焦点时，更新全局的action
	public void setFocus() {
		super.setFocus();
		ActionRegistry registry = getActionRegistry();
		registry = getActionRegistry();
		IActionBars bars = this.getEditorSite().getActionBars();
		String id = ActionFactory.UNDO.getId();
		bars.setGlobalActionHandler(id, registry.getAction(id));
		id = ActionFactory.REDO.getId();
		bars.setGlobalActionHandler(id, registry.getAction(id));
		id = ActionFactory.DELETE.getId();
		bars.setGlobalActionHandler(id, registry.getAction(id));
		id = ActionFactory.COPY.getId();
		bars.setGlobalActionHandler(id, registry.getAction(id));
		id = ActionFactory.CUT.getId();
		bars.setGlobalActionHandler(id, registry.getAction(id));
		id = ActionFactory.PASTE.getId();
		bars.setGlobalActionHandler(id, registry.getAction(id));
		bars.updateActionBars();
	}

	public void updatePaste() {
		ArrayList<String> list = new ArrayList<String>();
		list.add(ActionFactory.PASTE.getId());
		updateActions(list);
	}

	public GraphicalViewer getGraphicalViewer() {
		return super.getGraphicalViewer();
	}

	protected void setInput(IEditorInput input) {
		super.setInput(input);
		if (input instanceof GMPEditorInput) {
			GMPEditorInput mInput = (GMPEditorInput) input;
			this.diagram = mInput.getDiagram();
			this.paletteFactory = mInput.getPaletteFactory();
			this.editPartFactory = mInput.getEditPartFactory();
		}
	}

	@Override
	protected PaletteRoot getPaletteRoot() {
		assert (paletteFactory != null);
		return paletteFactory.createPalette(diagram.getType());
	}

	@Override
	public void doSave(IProgressMonitor monitor) {
		GMPModel model = diagram.getModel();
		try {
			GMPProjectUtils.model2project(model).save();
			getCommandStack().markSaveLocation();
		} catch (ProjectSaveException e) {
			e.printStackTrace();
		}
	}

	public DefaultEditDomain getEditDomain() {
		return super.getEditDomain();
	}

	protected SelectionSynchronizer getSelectionSynchronizer() {
		return super.getSelectionSynchronizer();
	}

	@SuppressWarnings("unchecked")
	public Object getAdapter(Class type) {
		if (type == IContentOutlinePage.class) {
			return new GMPContentOutlinePage(new TreeViewer(), this);
		}
		if (type == ZoomManager.class) {
			return getGraphicalViewer().getProperty(
					ZoomManager.class.toString());
		}
		return super.getAdapter(type);
	}

	public boolean isSaveAsAllowed() {
		return false;
	}

	public boolean isDirty() {
		return getCommandStack().isDirty();
	}

	public void commandStackChanged(EventObject event) {
		GMPModel model = diagram.getModel();
		if (!model.getDiagrams().contains(diagram)) {
			PlatformUI.getWorkbench().getActiveWorkbenchWindow()
					.getActivePage().closeEditor(this, false);
		}
		firePropertyChange(PROP_DIRTY);
		setPartName(diagram.getName());
		super.commandStackChanged(event);
	}

	public void selectionChanged(IWorkbenchPart part, ISelection selection) {
		if (part.getSite().getWorkbenchWindow().getActivePage() == null)
			return;
		super.selectionChanged(part, selection);
	}

}

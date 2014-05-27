package edu.pku.sei.gmp.editor;

import org.eclipse.draw2d.FigureCanvas;
import org.eclipse.draw2d.LightweightSystem;
import org.eclipse.draw2d.MarginBorder;
import org.eclipse.draw2d.Viewport;
import org.eclipse.draw2d.parts.ScrollableThumbnail;
import org.eclipse.draw2d.parts.Thumbnail;
import org.eclipse.gef.EditPartViewer;
import org.eclipse.gef.LayerConstants;
import org.eclipse.gef.RootEditPart;
import org.eclipse.gef.editparts.ScalableFreeformRootEditPart;
import org.eclipse.gef.editparts.ZoomManager;
import org.eclipse.gef.ui.parts.ContentOutlinePage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.events.DisposeListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Canvas;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.ui.IEditorPart;

public class GMPContentOutlinePage extends ContentOutlinePage {

	private GMPModelerEditor editor;
	private Canvas overview;
	private Thumbnail thumbnail;
	private DisposeListener disposeListener;
	Composite composite;

	public GMPContentOutlinePage(EditPartViewer viewer, IEditorPart editor) {
		super(viewer);
		this.editor = (GMPModelerEditor) editor;
	}

	protected void initializeOverview() {
		LightweightSystem lws = new LightweightSystem(overview);
		RootEditPart rep = getGraphicalViewer().getRootEditPart();
		if (rep instanceof ScalableFreeformRootEditPart) {
			ScalableFreeformRootEditPart root = (ScalableFreeformRootEditPart) rep;
			thumbnail = new ScrollableThumbnail((Viewport) root.getFigure());
			thumbnail.setBorder(new MarginBorder(3));
			thumbnail.setSource(root.getLayer(LayerConstants.PRINTABLE_LAYERS));
			lws.setContents(thumbnail);
			disposeListener = new DisposeListener() {
				public void widgetDisposed(DisposeEvent e) {
					if (thumbnail != null) {
						thumbnail.deactivate();
						thumbnail = null;
					}
				}
			};
			getEditor().addDisposeListener(disposeListener);
		}
	}

	protected FigureCanvas getEditor() {
		return (FigureCanvas) getGraphicalViewer().getControl();
	}

	private EditPartViewer getGraphicalViewer() {
		return editor.getGraphicalViewer();
	}

	public void createControl(Composite parent) {

		composite = new Composite(parent, SWT.NULL);
		GridLayout gridLayout = new GridLayout();
		composite.setLayout(gridLayout);
		overview = new Canvas(composite, SWT.NONE);
		overview.setLayoutData(new GridData(GridData.FILL_BOTH));
		initializeOverview();
		getSite().setSelectionProvider(getGraphicalViewer());
	}

	protected void configureOutlineViewer() {
		getViewer().setEditDomain(editor.getEditDomain());
		getViewer().setEditPartFactory(editor.getEditPartFactory());
	}

	protected void hookOutlineViewer() {
		editor.getSelectionSynchronizer().addViewer(getViewer());
	}

	protected void initializeOutlineViewer() {
		getViewer().setEditDomain(editor.getEditDomain());
		getViewer().setEditPartFactory(editor.getEditPartFactory());
		getViewer().setContents(editor.getDiagram());
	}

	public Control getControl() {
		return composite;
	}

	protected void unhookOutlineViewer() {
		editor.getSelectionSynchronizer().removeViewer(getViewer());
		if (disposeListener != null && getEditor() != null
				&& !getEditor().isDisposed())
			getEditor().removeDisposeListener(disposeListener);
	}

	public void dispose() {
		unhookOutlineViewer();
		if (thumbnail != null) {
			thumbnail.deactivate();
			thumbnail = null;
		}
		super.dispose();
	}

	@SuppressWarnings("unchecked")
	public Object getAdapter(Class adapter) {
		if (adapter == ZoomManager.class)
			return getGraphicalViewer().getProperty(
					ZoomManager.class.toString());
		return null;
	}

}

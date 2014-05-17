package edu.pku.sei.gmp.editor.action;

import org.eclipse.jface.action.Action;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;

import edu.pku.sei.gmp.editor.GMPEditorInput;
import edu.pku.sei.gmp.editor.registry.DiagramEditorMap;
import edu.pku.sei.gmp.model.shape.GMPDiagram;
import edu.pku.sei.gmp.resource.image.GMPImageProvider;

public abstract class AbstractOpenDiagramAction extends Action {
	private Object treeObject = null;
	
	public AbstractOpenDiagramAction() {
		this.setText("Open Diagram");
		this.setImageDescriptor(GMPImageProvider
				.getImageDescriptor(GMPImageProvider.DIAGRAM));
	}
	
	public AbstractOpenDiagramAction(Object treeObject) {
		this.treeObject = treeObject;
		this.setText("Open Diagram");
		this.setImageDescriptor(GMPImageProvider
				.getImageDescriptor(GMPImageProvider.DIAGRAM));
	}
	
	public void setTreeObject(Object treeObject) {
		this.treeObject = treeObject;
	}
	
	public void run() {
		if (treeObject instanceof GMPDiagram) {
			GMPDiagram diagram = (GMPDiagram) treeObject;
			GMPEditorInput input = DiagramEditorMap.getInstance().get(diagram);
			if (input == null) {
				input = new GMPEditorInput();
				input.setDiagram(diagram);
				this.configureEditorInput(input);
				DiagramEditorMap.getInstance().put(diagram, input);
			}
			String editorId = input.getEditorId();
			if (editorId == null)
				return;

			// 取得active IWorkbenchPage,并搜索使用editorInput对象对应的编辑器
			IWorkbench wb = PlatformUI.getWorkbench();
			IWorkbenchWindow win = wb.getActiveWorkbenchWindow();
			IWorkbenchPage page = win.getActivePage();
			IEditorPart editor = page.findEditor(input);

			// 如果该编辑器已经存在，则将它设为当前的编辑器，否则重新打开一个
			if (editor != null) {
				page.bringToTop(editor);
			} else {
				try {
					editor = page.openEditor(input, editorId);
				} catch (PartInitException exception) {
					exception.printStackTrace();
				}
			}
		}
	}
	
	/**
	 * set EditPartFactory, PaletteFactory
	 * @param input
	 */
	abstract public void configureEditorInput(GMPEditorInput input);
}

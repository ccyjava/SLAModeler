package edu.pku.sei.gmp.editor;

import org.eclipse.gef.EditPartFactory;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IPersistableElement;

import edu.pku.sei.gmp.editor.palette.GMPPaletteFactory;
import edu.pku.sei.gmp.model.shape.GMPDiagram;

public class GMPEditorInput implements IEditorInput {

	private String editorId = "";
	
	private GMPDiagram diagram;
	
	private GMPPaletteFactory paletteFactory;
	
	private EditPartFactory editPartFactory;
	
	public static final String DEFAULT_EDITOR_ID = "edu.pku.sei.modeler.editor";
	
	public GMPEditorInput() {
		editorId = DEFAULT_EDITOR_ID;
	}
	
	public String getEditorId() {
		return editorId;
	}
	
	public void setEditorId(String editId) {
		this.editorId = editId;
	}
	
	@Override
	public boolean exists() {
		return false;
	}

	@Override
	public ImageDescriptor getImageDescriptor() {
		return null;
	}

	@Override
	public String getName() {
		return diagram.getName();
	}

	@Override
	public IPersistableElement getPersistable() {
		return null;
	}

	@Override
	public String getToolTipText() {
		return "Model Editor";
	}

	@SuppressWarnings("unchecked")
	@Override
	public Object getAdapter(Class adapter) {
		return null;
	}

	public GMPDiagram getDiagram() {
		return diagram;
	}
	
	public void setDiagram(GMPDiagram diagram) {
		this.diagram = diagram;
	}
	
	public GMPPaletteFactory getPaletteFactory() {
		return this.paletteFactory;
	}
	
	public void setPaletteFactory(GMPPaletteFactory paletteFactory) {
		this.paletteFactory = paletteFactory;
	}
	
	public EditPartFactory getEditPartFactory() {
		return this.editPartFactory;
	}
	
	public void setEditPartFactory(EditPartFactory editPartFactory) {
		this.editPartFactory = editPartFactory;
	}
}

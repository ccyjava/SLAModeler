package edu.pku.sei.gmp.editor.registry;

import java.util.HashMap;

import edu.pku.sei.gmp.editor.GMPEditorInput;
import edu.pku.sei.gmp.model.shape.GMPDiagram;

public class DiagramEditorMap {
	private HashMap<GMPDiagram, GMPEditorInput> map = new HashMap<GMPDiagram, GMPEditorInput>();
	
	private DiagramEditorMap() {}
	
	private static DiagramEditorMap instance = null;
	
	public static DiagramEditorMap getInstance() {
		if (instance == null) {
			instance = new DiagramEditorMap();
		}
		return instance;
	}
	
	public void put(GMPDiagram diagram, GMPEditorInput input) {
		map.put(diagram, input);
	}
	
	public GMPEditorInput get(GMPDiagram diagram) {
		return map.get(diagram);
	}
}

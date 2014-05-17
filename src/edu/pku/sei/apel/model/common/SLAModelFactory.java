package edu.pku.sei.apel.model.common;


import edu.pku.sei.apel.model.sla.ComputeService;
import edu.pku.sei.apel.model.sla.SLAAgreement;
import edu.pku.sei.apel.model.sla.SLAModelElement;
import edu.pku.sei.gmp.model.common.GMPModel;
import edu.pku.sei.gmp.model.common.GMPModelFactory;
import edu.pku.sei.gmp.model.concept.GMPModelElement;
import edu.pku.sei.gmp.model.shape.GMPDiagram;
import edu.pku.sei.gmp.model.shape.GMPNode;
import edu.pku.sei.gmp.model.shape.GMPShapeElement;

public class SLAModelFactory extends GMPModelFactory {
	private int diagramNo = 1;
	private int computeServiceNo = 1;
	private int slaagreementNo = 1;

	@Override
	public GMPModelElement createModelElement(String type, boolean needRegister) {

		GMPModelElement element = null;
		if (type.equals(SLAModelConst.__SLAMODEL__)) {
			element = new SLAModel();
			this.setModel((GMPModel) element);
		} else if (type.equals(SLAModelConst.__COMPUTESERVICE__)) {
			element = new ComputeService();
			((ComputeService) element).setName(type + computeServiceNo);
			computeServiceNo++;
		} else if (type.equals(SLAModelConst.__SLAAGREEMENT__)) {
			element = new SLAAgreement();
			((SLAAgreement) element).setName(type + slaagreementNo);
			slaagreementNo++;
		}

		else if (type.equals(SLAModelConst.__SLAMODELELEMENT__)) {
			element = new SLAModelElement();
		}
		if (element == null)
			return null;
		element.setModel(this.getModel());

		if (needRegister) {
			element.setId(this.generateId());
			register(element, type);
		}
		return element;
	}

	@Override
	public GMPShapeElement createShapeElement(String type, boolean needRegister) {
		GMPShapeElement element = null;
		if (type.equals(SLAModelConst.__SLAMODELDIAGRAM__)) {
			element = new GMPDiagram();
			GMPDiagram sLADiagram = (GMPDiagram) element;
			sLADiagram.setType(type);
			sLADiagram.setName(type + diagramNo);
			diagramNo++;

		} else if (type.equals(SLAModelConst.__COMPUTESERVICE__)) {
			element = new GMPNode();
		} else if (type.equals(SLAModelConst.__SLAAGREEMENT__)) {
			element = new GMPNode();
		}
		if (element == null)
			return null;
		element.setModel(this.getModel());
		if (needRegister) {
			element.setId(this.generateId());
			register(element, type);
		}
		return element;
	}
}

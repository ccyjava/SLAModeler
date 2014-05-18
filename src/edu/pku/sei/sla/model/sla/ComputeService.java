package edu.pku.sei.sla.model.sla;



import edu.pku.sei.gmp.model.util.GMPTypedList;
import edu.pku.sei.gmp.properties.annotation.GMPAnnotation;
import edu.pku.sei.sla.model.common.SLAModelConst;

public class ComputeService extends SLAModelElement {
	@GMPAnnotation(
			id = "sla.ComputeService.name",
			name = SLAModelConst.COMPUTESERVICE_NAME,
			category = "Model",
			getter = "getName",
			setter = "setName",
			visible = true,
			serialize = true
			)
	private String name= "computer service";

//	@GMPAnnotation(id = "sla.ComputeService.agreements", name = SLAModelConst.COMPUTESERVICE_AGREEMENTS, category = "Model", getter = "getAgreements", setter = "setAgreements", visible = true, serialize = true)
//	private GMPTypedList<SLAAgreement> agreements = new GMPTypedList<SLAAgreement>(
//			SLAModelConst.COMPUTESERVICE_AGREEMENTS, GMPTypedList.BAG, this,
//			SLAAgreement.class, true);

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

//	public GMPTypedList<SLAAgreement> getAgreements() {
//		return agreements;
//	}
//
//	public void setAgreements(GMPTypedList<SLAAgreement> agreements) {
//		this.agreements = agreements;
//	}
}

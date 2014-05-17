package edu.pku.sei.apel.model.sla;

import edu.pku.sei.apel.model.common.SLAModelConst;
import edu.pku.sei.gmp.properties.annotation.GMPAnnotation;

public class SLAAgreement extends SLAModelElement {
	@GMPAnnotation(
			id = "sla.SLAAgreement.name",
			name = SLAModelConst.SLAAGREEMENT_NAME,
			category = "Model",
			getter = "getName",
			setter = "setName",
			visible = true,
			serialize = true
			)
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}

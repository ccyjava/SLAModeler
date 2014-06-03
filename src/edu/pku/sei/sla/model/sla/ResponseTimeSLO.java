package edu.pku.sei.sla.model.sla;

import edu.pku.sei.gmp.properties.annotation.GMPAnnotation;

public class ResponseTimeSLO extends SLAModelElement {
	@GMPAnnotation(
		id = "sla.ResponseTimeSLO.time",
		name = "ResPonseTimeSLO_TIME",
		category = "Model",
		getter = "getTime",
		setter = "setTame",
		visible = true,
		serialize = true
	)
	private String time;

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}
}

package edu.pku.sei.gmp.model.shape;

import edu.pku.sei.gmp.model.common.GMPConst;
import edu.pku.sei.gmp.model.util.GMPTypedList;
import edu.pku.sei.gmp.properties.annotation.GMPAnnotation;

public class GMPLink extends GMPShapeElement {
	@GMPAnnotation(
			id = "GMPLink.source",
			name = GMPConst.LINK_SOURCE,
			getter = "getSource",
			setter = "setSource",
			reference = true
			)
	private GMPNode source;

	@GMPAnnotation(
			id = "GMPLink.target",
			name = GMPConst.LINK_TARGET,
			getter = "getTarget",
			setter = "setTarget",
			reference = true
			)
	private GMPNode target;
	
	@GMPAnnotation(
			id = "GMPLink.bendpoints",
			name = GMPConst.LINK_BENDPOINTS,
			getter = "getBendpoints",
			setter = "setBendpoints")
	private GMPTypedList<GMPBendpoint> bendpoints = new GMPTypedList<GMPBendpoint>(
			GMPConst.LINK_BENDPOINTS,GMPTypedList.BAG, this,GMPBendpoint.class, true);
	
	public GMPTypedList<GMPBendpoint> getBendpoints() {
		return bendpoints;
	}

	public void setBendpoints(GMPTypedList<GMPBendpoint> bendPoints) {
		this.bendpoints = bendPoints;
	}

	public GMPNode getSource() {
		return source;
	}

	public void setSource(GMPNode source) {
		this.source = source;
	}

	public GMPNode getTarget() {
		return target;
	}

	public void setTarget(GMPNode target) {
		this.target = target;
	}

}

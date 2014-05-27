package edu.pku.sei.gmp.model.shape;

import edu.pku.sei.gmp.model.common.GMPConst;
import edu.pku.sei.gmp.model.util.GMPTypedList;
import edu.pku.sei.gmp.properties.annotation.GMPAnnotation;

public class GMPShapeContainer extends GMPShapeElement {
	
	@GMPAnnotation(
			id = "GMPShapeContainer.subNodes",
			name = GMPConst.SHAPECONTAINER_SUBNODES,
			getter = "getSubNodes"
			)
	private GMPTypedList<GMPNode> subNodes = new GMPTypedList<GMPNode>(
			GMPConst.SHAPECONTAINER_SUBNODES, GMPTypedList.BAG, this,
			GMPNode.class, true);

	/**
	 * @return Returns the subNodes.
	 */
	public GMPTypedList<GMPNode> getSubNodes() {
		return subNodes;
	}
}

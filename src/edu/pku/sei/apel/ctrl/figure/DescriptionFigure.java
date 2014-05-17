package edu.pku.sei.apel.ctrl.figure;

import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.Figure;
import org.eclipse.draw2d.MarginBorder;
import org.eclipse.draw2d.ToolbarLayout;
import org.eclipse.draw2d.text.FlowPage;
import org.eclipse.draw2d.text.ParagraphTextLayout;
import org.eclipse.draw2d.text.TextFlow;

import edu.pku.sei.gmp.resource.font.GMPFontProvider;

public class DescriptionFigure extends Figure {
  
    protected TextFlow textFlow;
    
    public DescriptionFigure() {
		this(1);
	}
    
	/**
	 * Creates a new DescriptionFigure with a MarginBorder that is the given size and a
	 * FlowPage containing a TextFlow with the style WORD_WRAP_SOFT.
	 * 
	 * @param borderSize the size of the MarginBorder
	 */
	public DescriptionFigure(int borderSize) {
		setLayoutManager(new ToolbarLayout());
		setBorder(new MarginBorder(borderSize));
		FlowPage flowPage = new FlowPage();
		this.textFlow = new TextFlow();
		this.textFlow.setForegroundColor(ColorConstants.lightBlue);
		this.textFlow.setFont(GMPFontProvider.getHeadFont());
		this.textFlow.setLayoutManager(new ParagraphTextLayout(this.textFlow,
				ParagraphTextLayout.WORD_WRAP_TRUNCATE));

		flowPage.add(this.textFlow);
		add(flowPage);
	}

	/**
	 * @return the text flow where text is displayed
	 */
	public TextFlow getTextFigure() {
		return textFlow;
	}
}

// Class: QuestionPanel.java
// Lead Contributor: Tyler Cole
// Description: Holds the diagram panel and the text panel

package pack;

import java.awt.FlowLayout;
import javax.swing.*;

public class QuestionPanel extends JPanel {
	
	private static final long serialVersionUID = 1L;
	
	public DiagramPanel dPanel;
	
	// constructor
	public QuestionPanel()
	{
		this.setLayout(new FlowLayout(FlowLayout.CENTER,0,0));
		
		dPanel = new DiagramPanel();
		add(dPanel);
	}
}

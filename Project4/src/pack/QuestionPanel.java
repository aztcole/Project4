// Class: QuestionPanel.java
// Lead Contributor: Tyler Cole
// Description: Holds the diagram panel and the text panel

package pack;

import javax.swing.*;

public class QuestionPanel extends JPanel {
	
	private static final long serialVersionUID = 1L;
	
	public DiagramPanel dPanel;
	
	// constructor
	public QuestionPanel()
	{
		this.setLayout(null);
		dPanel = new DiagramPanel();
		add(dPanel);
	}
}

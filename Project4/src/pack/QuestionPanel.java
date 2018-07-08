// Class: QuestionPanel.java
// Lead Contributor: Tyler Cole
// Description: Holds the diagram panel and the text panel

package pack;

import java.awt.Color;
import java.util.ArrayList;
import javax.swing.*;

public class QuestionPanel extends JPanel {
	
	private static final long serialVersionUID = 1L;
	
	private ControlPanel cPanel;
	private DiagramPanel dPanel;
	private CodePanel codePanel;
	
	public ArrayList<String> questionInfo;
	
	// constructor
	public QuestionPanel()
	{
		// sets default settings
		this.setLayout(null);
		this.setBackground(Color.WHITE);
		
		// initalizes Control panel
		cPanel = new ControlPanel();
		add(cPanel);
		
		// initalizes diagram panel
		dPanel = new DiagramPanel();
		dPanel.cPanel = cPanel;
		add(dPanel);
		
		// initalizes the code panel
		codePanel = new CodePanel();
		add(codePanel);
	}
}

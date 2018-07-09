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
	}
	
	// checks what type of panel this is based on questionInfo
	public void checkType()
	{
		if(questionInfo.get(0).contains("Diagram"))
		{
			isDiagramPanel();
		}
		else if(questionInfo.get(0).contains("Code"))
		{
			isCodePanel();
		}
	}
	
	// user has to generate the code
	private void isDiagramPanel()
	{
		// initializes the code panel
		codePanel = new CodePanel();
		this.add(codePanel);
	}
	
	// user has to make the diagram
	private void isCodePanel()
	{
		// initializes Control panel
		cPanel = new ControlPanel();
				
		// initializes diagram panel
		dPanel = new DiagramPanel();
		
		// connect the panels
		cPanel.dPanel = dPanel;
		dPanel.cPanel = cPanel;
		
		// add the panels
		this.add(cPanel);
		this.add(dPanel);
	}
}

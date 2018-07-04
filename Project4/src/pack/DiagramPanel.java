// Class: DiagramPanel.java
// Lead Contributor: Tyler Cole
// Description: Holds all the essential elements of the diagrams 
//			    (i.e. the upper/lower panels, and line panel)

package pack;

import java.awt.Color;
import javax.swing.*;

public class DiagramPanel extends JPanel {
	
	private static final long serialVersionUID = 1L;
	
	public DrawPanelOne dPanelOne;
	public DrawPanelTwo dPanelTwo;
	
	
	// constructor
	public DiagramPanel()
	{
		initalizePanels();
	}
	
	
	// initializes panels in the project as well as sets default settings for them
	private void initalizePanels()
	{
		// Diagram Panel is given default settings
		this.setBackground(Color.BLUE);
		
		// initializes draw panels
		dPanelOne = new DrawPanelOne();
		dPanelTwo = new DrawPanelTwo();
		
		// adds in the panels
		this.add(dPanelOne);
		this.add(dPanelTwo);
	}
}

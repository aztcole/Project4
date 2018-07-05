// Class: DrawPanelOne.java
// Lead Contributor: Tyler Cole
// Description: The top most panel of the diagram, where you are able to drag the icons from.

package pack;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.*;

public class DrawPanelOne extends JPanel {
	
	private static final long serialVersionUID = 1L;
	
	// constructor
	public DrawPanelOne()
	{
		// sets the default properties of the panel
		this.setBackground(Color.white);
		this.setSize(new Dimension(800,200));
		this.setBorder(BorderFactory.createLineBorder(Color.black));
		this.setLocation(10, 0);
		this.setOpaque(false);
	}
}

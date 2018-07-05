// Class: DrawPanelTwo.java
// Lead Contributor: Tyler Cole
// Description: The canvas part of the diagram panel. This is where icons are dropped and lines appear.

package pack;

import java.awt.*;
import javax.swing.*;

public class DrawPanelTwo extends JPanel{
	
	private static final long serialVersionUID = 1L;
	
	// constructor
	public DrawPanelTwo()
	{
		// initializes the panel to default settings
		this.setBackground(Color.WHITE);
		this.setSize(new Dimension(800,800));
		this.setBorder(BorderFactory.createLineBorder(Color.black));
		this.setLocation(0, 200);
		this.setOpaque(false);
	}

}

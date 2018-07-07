// Class: ControlPanel.java
// Lead Contributor: Tyler Cole
// Description: A panel that has multiple options to control the graphics in the Diagram Panel, specifically
// 				the line graphics.

package pack;

import java.awt.Color;
import javax.swing.*;

public class ControlPanel extends JPanel{
	
	private static final long serialVersionUID = 1L;
	
	public boolean aggregate, inherit, associate, bold;
	public Color color;
	
	// constructor
	public ControlPanel()
	{
		// initialize default settings
		this.setBackground(Color.WHITE);
		this.setSize(350, 200);
		this.setLocation(820, 0);
		this.setBorder(BorderFactory.createLineBorder(Color.black));
	}
	
}

// Class: DrawPanelOne.java
// Lead Contributor: Tyler Cole
// Description: The top most panel of the diagram, where you are able to drag the icons from.

package pack;

import java.awt.Color;
import java.awt.FlowLayout;
import javax.swing.*;

public class DrawPanelOne extends JPanel {
	
	private static final long serialVersionUID = 1L;
	
	// constructor
	public DrawPanelOne()
	{
		// sets the default properties of the panel
		this.setBackground(Color.white);
		setLayout(new FlowLayout(FlowLayout.CENTER,50,18));
		
		// initializes the draggable icons
		iconCircle dragCircle = new iconCircle();
		iconRectangle dragRect = new iconRectangle();
		
		// adds the draggable icons to the panel
		this.add(dragCircle);
		this.add(dragRect);
	}
}

// Class: Connection.java
// Lead Contributor: Tyler Cole
// Description: This class is used to represent the connections between icons. The draw method will draw
//              the lines.

package pack;

import java.awt.Color;
import java.awt.Graphics2D;
import java.util.Observable;

public class Connection extends Observable {

	private boolean aggregate, inherit, associate;
	private Color color;
	
	public Connection(boolean ag, boolean inh, boolean assoc, Color c)
	{
		// read arguments into variables
		aggregate = ag;
		inherit = inh;
		associate = assoc;
		color = c;
	}
	
	// this method draws the lines between the icons
	public void draw(Graphics2D g2d)
	{
		
	}
}

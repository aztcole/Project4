// Class: Connection.java
// Lead Contributor: Tyler Cole
// Description: This class is used to represent the connections between icons. The draw method will draw
//              the lines.

package pack;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Point;
import java.util.Observable;

public class Connection extends Observable {
	
	public IconCircle iconC1, iconC2;
	public IconSquare iconS1, iconS2;
	
	private Point point1, point2;
	
	private boolean aggregate, inherit, associate, bold;
	private Color color;
	
	// constructor
	public Connection(boolean ag, boolean inh, boolean assoc, boolean isBold, Color c)
	{
		// read arguments into variables
		aggregate = ag;
		inherit = inh;
		associate = assoc;
		color = c;
		bold = isBold;
	}
	
	// this method draws the lines between the icons
	public void draw(Graphics2D g2d)
	{
		g2d.setColor(color);
		
		if(point1 != null && point2 != null)
		{
			g2d.drawLine(point1.x, point1.y, point2.x, point2.y);
		}
	}
	
	// adds a circle into the connection
	public void AddCircle(IconCircle newCircle)
	{
		// if no Icon 1, argument becomes icon 1
		if(iconC1 == null && iconS1 == null)
		{
			iconC1 = newCircle;
			point1 = new Point(newCircle.getX() + 50, newCircle.getY() + 50);
		}
		
		// if no Icon 2, argument becomes icon 2
		else if(iconC2 == null && iconS2 == null)
		{
			iconC2 = newCircle;
			point2 = new Point(newCircle.getX() + 50, newCircle.getY() + 50);
		}
	}
	
	// adds a square into the connection
	public void AddSquare(IconSquare newSquare)
	{
		// if no Icon 1, argument becomes icon 1
		if(iconC1 == null && iconS1 == null)
		{
			iconS1 = newSquare;
			point1 = new Point(newSquare.getX() + 50, newSquare.getY() + 50);
		}
		
		// if no Icon 2, argument becomes icon 2
		else if(iconC2 == null && iconS2 == null)
		{
			iconS2 = newSquare;
			point2 = new Point(newSquare.getX() + 50, newSquare.getY() + 50);
		}
	}
}

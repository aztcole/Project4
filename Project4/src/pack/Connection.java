// Class: Connection.java
// Lead Contributor: Tyler Cole
// Description: This class is used to represent the connections between icons. The draw method will draw
//              the lines.

package pack;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Polygon;
import java.awt.Stroke;
import java.awt.geom.AffineTransform;
import java.util.Observable;

public class Connection extends Observable {
	
	public IconCircle iconC1, iconC2;
	public IconSquare iconS1, iconS2;
	
	private Point point1, point2;
	
	private boolean aggregate, inherit, associate, bold, dashed;
	private Color color;
	
	private int lineStrokeInt = 1;
	// constructor
	public Connection(boolean ag, boolean inh, boolean assoc, boolean isBold, boolean isDashed, Color c)
	{
		// read arguments into variables
		aggregate = ag;
		inherit = inh;
		associate = assoc;
		bold = isBold;
		dashed = isDashed;
		color = c;
		this.addObserver(new CodePanel());
	}
	
	// this method draws the lines between the icons
	public void draw(Graphics g)
	{
		// convert to 2D graphics
		Graphics2D g2d = (Graphics2D) g.create();
		
		// set color
		g2d.setColor(color);
		
		// create the polygon Arrow Head to be used for creating arrows
        Polygon arrowHead = new Polygon();  
        arrowHead.addPoint( 0,5);
        arrowHead.addPoint( -5, -5);
        arrowHead.addPoint( 5,-5);
        
        // create diamond head polygon to be used for aggregation
        Polygon diamondHead = new Polygon();
        diamondHead.addPoint( 0,5);
        diamondHead.addPoint( -5, -5);
        diamondHead.addPoint( 0,-15);
        diamondHead.addPoint( 5,-5);
        
        // transformation
        AffineTransform tx = new AffineTransform();
		
		// draws the line
		if(point1 != null && point2 != null)
		{
			// bold / dashed settings
			if(bold && dashed)
			{
				lineStrokeInt = 3;
				Stroke boldDashed = new BasicStroke(lineStrokeInt, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL, 0, new float[]{9}, 0);
				g2d.setStroke(boldDashed);
			}
			
			else if(bold)
			{
				lineStrokeInt = 3;
				g2d.setStroke(new BasicStroke(lineStrokeInt));
			}
			
			else if(dashed)
			{
				lineStrokeInt = 1;
				Stroke dashed = new BasicStroke(lineStrokeInt, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL, 0, new float[]{9}, 0);
				g2d.setStroke(dashed);
			}
			
			else
			{
				lineStrokeInt = 1;
				g2d.setStroke(new BasicStroke(lineStrokeInt));
			}
			
			g2d.drawLine(point1.x, point1.y, point2.x, point2.y);
			
			// Connection settings
			if(aggregate)
			{
				g2d.setStroke(new BasicStroke(lineStrokeInt));
				tx.setToIdentity();
	        	double angle = Math.atan2(point2.y-point1.y, point2.x-point1.x);
	            tx.translate(point2.x, point2.y);
	            tx.rotate((angle-Math.PI/2d));
	            g2d.setTransform(tx); 
	            g2d.drawPolygon(diamondHead);
			}
			
			else if(inherit)
			{
				g2d.setStroke(new BasicStroke(lineStrokeInt));
				tx.setToIdentity();
	        	double angle = Math.atan2(point2.y-point1.y, point2.x-point1.x);
	            tx.translate(point2.x, point2.y);
	            tx.rotate((angle-Math.PI/2d));
	            g2d.setTransform(tx);   
	            g2d.drawPolygon(arrowHead);
			}
			
			else if(associate)
			{
				g2d.setStroke(new BasicStroke(lineStrokeInt));
				tx.setToIdentity();
	        	double angle = Math.atan2(point2.y-point1.y, point2.x-point1.x);
	            tx.translate(point2.x, point2.y);
	            tx.rotate((angle-Math.PI/2d));
	            g2d.setTransform(tx);
	            g2d.drawLine(0, 5, 5, -5);
	            g2d.drawLine(0, 5, -5, -5);
			}
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

// Class: DiagramPanel.java
// Lead Contributor: Tyler Cole
// Description: Holds all the essential elements of the diagrams. 
//			    (i.e. the upper/lower panels, and line panel)

package pack;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.swing.*;

public class DiagramPanel extends JPanel {
	
	private static final long serialVersionUID = 1L;
	public IconCircle dragCircle;
	public ControlPanel cPanel;
	public DrawPanelOne dPanelOne;
	public DrawPanelTwo dPanelTwo;
	
	public ArrayList<Connection> connecArr = new ArrayList<Connection>();
	
	// constructor
	public DiagramPanel()
	{
		initalizePanels();
		
		// add a mouse listener to update the panel (fixes arrowheads moving around)
		DiagramPanel thisPanel = this;
		thisPanel.addMouseMotionListener(new MouseAdapter()
				{
					public void mouseMoved(MouseEvent e)
					{
						thisPanel.repaint();
					}
				});
	}
	
	
	// initializes panels in the project as well as sets default settings for them
	private void initalizePanels()
	{
		// Diagram Panel is given default settings
		this.setBackground(Color.WHITE);
		this.setLayout(null);
		this.setSize(new Dimension(810, 600));
		
		// initializes the draggable circle
		dragCircle = new IconCircle(true);
		dragCircle.connectArr = connecArr;
		dragCircle.parentPane = this;
		
		// initializes the draggable square
		IconSquare dragSquare = new IconSquare(true);
		dragSquare.connectArr = connecArr;
		dragSquare.parentPane = this;
		
		// initializes draw panels
		dPanelOne = new DrawPanelOne();
		dPanelTwo = new DrawPanelTwo();
		
		// adds in the panels
		this.add(dPanelOne);
		this.add(dPanelTwo);
		
		// adds the draggable icons to the panel
		this.add(dragCircle);
		this.add(dragSquare);
		
	}
	
	// paint component to draw lines
	protected void paintComponent(Graphics g)
	{
		// access paint component
		super.paintComponent(g);
		
		// draws connections
		for(int i = 0; i<connecArr.size(); i++)
		{
			connecArr.get(i).draw(g);
		}
		
	}
}

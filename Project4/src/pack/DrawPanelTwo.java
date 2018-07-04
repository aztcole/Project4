// Class: DrawPanelTwo.java
// Lead Contributor: Tyler Cole
// Description: The canvas part of the diagram panel. This is where icons are dropped and lines appear.

package pack;

import java.awt.Color;
import java.awt.dnd.*;
import javax.swing.*;

public class DrawPanelTwo extends JPanel implements DropTargetListener{
	
	private static final long serialVersionUID = 1L;
	
	// constructor
	public DrawPanelTwo()
	{
		// initializes the panel to default settings
		this.setBackground(Color.WHITE);
		this.setLayout(null);
		
		new DropTarget(this, this);
	}
	
	
	
	@Override
	public void dragEnter(DropTargetDragEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void dragExit(DropTargetEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void dragOver(DropTargetDragEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void drop(DropTargetDropEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void dropActionChanged(DropTargetDragEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}

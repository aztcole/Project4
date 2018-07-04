// Class: DraggableIcon.java
// Lead Contributor: Tyler Cole
// Description: This class is the parent class for all draggable icons. It allows a user to drag a JLabel
//				and drop it into draw panel two.

package pack;

import java.awt.Point;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Transferable;
import java.awt.dnd.*;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;

public class DraggableIcon extends JLabel implements DragGestureListener, DragSourceListener {
	
	private static final long serialVersionUID = 1L;
	
	DragSource dSource;
	public String iconClass;
	private String imgSource;
	public String persistantName;
	
	
	// constructor
	public DraggableIcon(String ImageSource, boolean draggable, String iconType)
	{
		
		iconClass = iconType;
		setImageSource(ImageSource);
		
		
		// Create Drag and Drop listener if specified as draggable 
		if(draggable)
		{
			dSource = new DragSource();
			dSource.createDefaultDragGestureRecognizer(this, DnDConstants.ACTION_MOVE, this);
		}
		
		
		// set the icon image, and check for IO exceptions
		try
		{
			this.setIcon(new ImageIcon(ImageIO.read(new File(imgSource))));
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		
		
		// testing icon text (TO BE DELETED)
		this.setText("Test Icon Text");
	}
	
	
	// returns the location of the point
	public Point dragPoint()
	{
		return this.getLocation();
	}
	
	
	// setter for the image source
	public void setImageSource(String srcImg)
	{
		imgSource = srcImg;
	}

	
	@Override
	public void dragGestureRecognized(DragGestureEvent dge) 
	{
		Transferable txfr = new StringSelection(imgSource);
		dSource.startDrag(dge, DragSource.DefaultCopyDrop, txfr, this);
	}
	
	
	@Override
	public void dragDropEnd(DragSourceDropEvent arg0) {}

	@Override
	public void dragEnter(DragSourceDragEvent arg0) {}

	@Override
	public void dragExit(DragSourceEvent arg0) {}

	@Override
	public void dragOver(DragSourceDragEvent arg0) {}

	@Override
	public void dropActionChanged(DragSourceDragEvent arg0) {}
}

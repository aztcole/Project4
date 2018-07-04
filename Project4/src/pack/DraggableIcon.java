package pack;

import java.awt.Point;
import java.awt.dnd.DragGestureEvent;
import java.awt.dnd.DragGestureListener;
import java.awt.dnd.DragSourceDragEvent;
import java.awt.dnd.DragSourceDropEvent;
import java.awt.dnd.DragSourceEvent;
import java.awt.dnd.DragSourceListener;
import javax.swing.*;

public class DraggableIcon extends JLabel implements DragGestureListener, DragSourceListener {
	
	private static final long serialVersionUID = 1L;
	
	// constructor
	public DraggableIcon(String ImageSource, boolean draggable, String s)
	{
		
	}
	
	
	// returns the location of the point
	public Point dragPoint()
	{
		return this.getLocation();
	}
	

	@Override
	public void dragGestureRecognized(DragGestureEvent arg0) {}
	
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

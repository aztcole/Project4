// Class: DrawPanelTwo.java
// Lead Contributor: Tyler Cole
// Description: The canvas part of the diagram panel. This is where icons are dropped and lines appear.

package pack;

import java.awt.Color;
import java.awt.Point;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.dnd.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.*;

public class DrawPanelTwo extends JPanel implements DropTargetListener{
	
	private static final long serialVersionUID = 1L;
	
	private boolean twoPoints;
	private Point prevPoint = new Point();
	private Point nextPoint = new Point();
	private Point mousePos = new Point();
	private MouseHandler mouseHandler = new MouseHandler();
	private ArrayList<DraggableIcon> iconArr = new ArrayList<DraggableIcon>();
	private int iconArrLength = 0;
	
	// constructor
	public DrawPanelTwo()
	{
		// initializes the panel to default settings
		this.setBackground(Color.WHITE);
		this.setLayout(null);
		
		new DropTarget(this, this);
		this.addMouseListener(mouseHandler);
		this.addMouseMotionListener(mouseHandler);
	}
	
	DraggableIcon icon1;
	DraggableIcon icon2;
	
	private class MouseHandler extends MouseAdapter
	{
		boolean twoPoints = false;
		
		@Override
		public void mousePressed(MouseEvent e)
		{
			Object obj = e.getSource();
			
			if(obj.getClass().getSimpleName().equals("DraggableIcon"))
			{
				DraggableIcon thisIcon = (DraggableIcon)obj;
				if(twoPoints == false)
				{
					icon1 = thisIcon;
					nextPoint = thisIcon.dragPoint();
					twoPoints = true;
				}
				
				else
				{
					icon2 = thisIcon;
					prevPoint = nextPoint;
					nextPoint = thisIcon.dragPoint();
					twoPoints = false;
				}
				
				System.out.println("Ya done did it");
			}
			
			else
			{
				twoPoints = false;
			}
		}
	}
	
	
	public void updatePanel()
	{
		this.removeAll();
		
		for(int i = 0; i < iconArrLength; i++)
		{
			this.add(iconArr.get(i));
		}
		
		this.repaint();
	}
	
	
	@Override
	// controls the aspect of dropping the object
	public void drop(DropTargetDropEvent dropTarg) {
		
		// 
		DraggableIcon temp;
		String imgpth;
		twoPoints = false;
		String name = null;
		
		// catches any exceptions
		try
		{
			Transferable recvData = dropTarg.getTransferable();
			
			if(recvData.isDataFlavorSupported(DataFlavor.stringFlavor))
			{
				dropTarg.acceptDrop(DnDConstants.ACTION_MOVE);
				imgpth = (String) recvData.getTransferData(DataFlavor.stringFlavor);
				dropTarg.getDropTargetContext().dropComplete(true);
				
				if((imgpth).contains("circle"))
				{
					name = "circle";
				}
				
				else if((imgpth).contains("rectangle"))
				{
					name = "rectangle";
				}
				
				temp = new DraggableIcon(imgpth, false, name);
				temp.setBounds(mousePos.x-50, mousePos.y-50, 100, 100);
				temp.addMouseListener(mouseHandler);
				
				iconArr.add(temp);
				iconArrLength++;
				
				updatePanel();
			}
			
			else
			{
				dropTarg.rejectDrop();
			}
			
		}
		
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
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
	public void dragOver(DropTargetDragEvent dropTarg) {
		
		mousePos = dropTarg.getLocation();
	}

	@Override
	public void dropActionChanged(DropTargetDragEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}

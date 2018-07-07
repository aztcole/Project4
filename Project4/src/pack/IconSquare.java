// Class: IconSquare.java
// Lead Contributor: Andrew Durkiewicz
// Description: Creates a draggable rectangle that represents a class.

package pack;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class IconSquare extends JPanel {
	
	private static final long serialVersionUID = 1L;
	
	public ArrayList<Connection> connectArr;
	public DiagramPanel parentPane;
	
    private BufferedImage image;
    private String name = "Icon";
    final int spawnx = 500;
    final int spawny = 50;
    private int x = 500;
    private int y = 50;
    
    public int getX() {
    	return this.x;
    }
    
    public int getY() {
    	return this.y;
    }
    
    public void setX(int x) {
    	this.x = x;
    	this.repaint();
    }
    
    public void setY(int y) {
    	this.y = y;
    	this.repaint();

    }
    
    static boolean repaintedCheck; // checks if already repainted 
   
	public IconSquare() {
		
		// calls constructor of JPanel
	    super();
	    
	    // sets name
	    // default settings
	    this.setSize(new Dimension(100,100));
	    this.setLocation(this.getX(),this.getY());
	    this.setOpaque(false);
	    this.setVisible(true);
	    
	    try {
	    	image = ImageIO.read(new File("resources//rectangle.png"));
	    } 
	    catch (IOException ex) {
        // handle exception...
	    }
	    
	    
	    MouseAdapter onDrag = new MouseAdapter(){
	    	public void mouseDragged(MouseEvent e){
	    		repaintedCheck = false;
	    		JPanel contentPane = (JPanel) ((JPanel) e.getSource()).getParent();
	    		IconSquare thisSquare = (IconSquare) e.getSource();
	    		Point p = contentPane.getMousePosition();
	    		contentPane.repaint();
	    		thisSquare.setLocation(thisSquare.getX(),thisSquare.getY());
	    		thisSquare.setX(p.x -50);
	    		thisSquare.setY(p.y-50 );
	    		thisSquare.setLocation(p.x-50 ,p.y-25);

	    		contentPane.repaint();
	    	}
	    };
	    
		MouseAdapter afterListenerRemove = new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				IconSquare thissquare = (IconSquare) e.getSource(); //will use for arrows. This gives us coordinates of each icon.
				System.out.println(thissquare.name + " is located at " + thissquare.getX() + "," + thissquare.getY());
				
				// if empty connection array list or last item of array list has both items add a new one to the list
				if(connectArr.size() == 0 || connectArr.get(connectArr.size()-1).iconC2 != null || connectArr.get(connectArr.size()-1).iconS2 != null)
				{
					System.out.println("New connection added\n");
					Connection tempConnec = new Connection(parentPane.cPanel.aggregate, parentPane.cPanel.inherit, parentPane.cPanel.associate, parentPane.cPanel.bold, parentPane.cPanel.dashed, parentPane.cPanel.color);
					tempConnec.AddSquare(thissquare);
					connectArr.add(tempConnec);
				}
				
				// otherwise add a square to the last item of the connection list
				else
				{
					System.out.println("Square added to last connection\n");
					connectArr.get(connectArr.size() - 1).AddSquare(thissquare);
				}
				
				// repaint parent
				parentPane.repaint();
			}
		};
        
        MouseAdapter removeListeners = new MouseAdapter() {
	   		
	   		/*public void mousePressed(MouseEvent e) {
	        	JPanel contentPane = (JPanel) ((JPanel) e.getSource()).getParent();
	        	contentPane.add(new IconSquare());
	   		}*/
	   		
	   		public void mouseReleased(MouseEvent e) {
	   			IconSquare thisSquare = (IconSquare) e.getSource();
	   			JPanel contentPane = (JPanel) ((JPanel) e.getSource()).getParent();
	   			if(contentPane.getComponent(1).getBounds().contains(thisSquare.getBounds())) {
	   				
	   			    thisSquare.name = name + (contentPane.getComponentCount() - 3);
	   			    
	   			    IconSquare tempSquare = new IconSquare();
	   			    tempSquare.connectArr = connectArr;
	   			    tempSquare.parentPane = parentPane;
	   			    
	   				contentPane.add(tempSquare);
	   				
		   			thisSquare.removeMouseMotionListener(onDrag);
		   			//on drop, this listener will be deleted to implement the other listener 
		   			//which prevents more dragging 
		   			thisSquare.removeMouseListener(this); //remove this listener since we are done with it
		        	thisSquare.addMouseListener(afterListenerRemove);

	   			}
	   			else { //teleport back to start
	   				thisSquare.setLocation(spawnx, spawny);
	   				thisSquare.setX(spawnx);
	   				thisSquare.setY(spawny);
		        	contentPane.repaint();

	   			}
	        	contentPane.repaint();

	   		}
	   	};
	   	
		// add the mouse and motion listeners to the panel
	   	this.addMouseMotionListener(onDrag);
	   	this.addMouseListener(removeListeners);
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(image, 0, 0, this); // see javadoc for more info on the parameters            
	}
	
}

// Class: IconCircle.java
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
import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class IconCircle extends JPanel {
	
	private static final long serialVersionUID = 1L;
	
    private BufferedImage image;
    private String name = "Circle-";
    final int spawnx = 200;
    final int spawny = 50;
    private int x = 200;
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
   
	public IconCircle() {
		
		// calls constructor of JPanel
	    super();
	    
	    // sets name
	    // default settings
	    this.setSize(new Dimension(100,100));
	    this.setLocation(this.getX(),this.getY());
	    this.setOpaque(false);
	    this.setVisible(true);
	    
	    try {
	    	image = ImageIO.read(new File("resources//circle.png"));
	    } 
	    catch (IOException ex) {
        // handle exception...
	    }
	    
	    MouseAdapter onDrag = new MouseAdapter(){
	    	public void mouseDragged(MouseEvent e){
	    		repaintedCheck = false;
	    		JPanel contentPane = (JPanel) ((JPanel) e.getSource()).getParent();
	    		IconCircle thisCircle = (IconCircle) e.getSource();
	    		Point p = contentPane.getMousePosition();
	    		contentPane.repaint();
	    		thisCircle.setLocation(thisCircle.getX(),thisCircle.getY());
	    		thisCircle.setX(p.x -50);
	    		thisCircle.setY(p.y-50 );
	    		thisCircle.setLocation(p.x-50 ,p.y-25);

	    		contentPane.repaint();
	    	}
	    };
	    
		MouseAdapter afterListenerRemove = new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				IconCircle thissquare = (IconCircle) e.getSource(); //will use for arrows. This gives us coordinates of each icon.
				System.out.println(thissquare.name + " is located at " + thissquare.getX() + "," + thissquare.getY());
			}
		};
        
        MouseAdapter removeListeners = new MouseAdapter() {
	   		
	   		/*public void mousePressed(MouseEvent e) {
	        	JPanel contentPane = (JPanel) ((JPanel) e.getSource()).getParent();
	        	contentPane.add(new IconCircle());
	   		}*/
	   		
	   		public void mouseReleased(MouseEvent e) {
	   			IconCircle thisCircle = (IconCircle) e.getSource();
	   			JPanel contentPane = (JPanel) ((JPanel) e.getSource()).getParent();
	   			if(contentPane.getComponent(1).getBounds().contains(thisCircle.getBounds())) {
	   				thisCircle.name = name + (contentPane.getComponentCount() - 3);
	   				contentPane.add(new IconCircle());
		   			thisCircle.removeMouseMotionListener(onDrag);
		   			//on drop, this listener will be deleted to implement the other listener 
		   			//which prevents more dragging 
		   			thisCircle.removeMouseListener(this); //remove this listener since we are done with it
		        	thisCircle.addMouseListener(afterListenerRemove);

	   			}
	   			else { //teleport back to start
	   				thisCircle.setLocation(spawnx, spawny);
	   				thisCircle.setX(spawnx);
	   				thisCircle.setY(spawny);
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

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
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class IconCircle extends JPanel {
	
	private static final long serialVersionUID = 1L;
	
	public ArrayList<Connection> connectArr;
	public DiagramPanel parentPane;
	
    private BufferedImage image;
    private String name = "Icon";
    final int spawnx = 200;
    final int spawny = 50;
    private int x = 200;
    private int y = 50;
    
    JLabel showName;
    
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
   
	public IconCircle(boolean clickable) {
		
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
				IconCircle thisCircle = (IconCircle) e.getSource(); //will use for arrows. This gives us coordinates of each icon.
				
				if(Universe.toggledown) {
					JPanel panel2 = (JPanel) thisCircle.getParent();
					panel2.remove(thisCircle);
					
				}
				// if empty connection array list or last item of array list has both items add a new one to the list
				if(connectArr.size() == 0 || connectArr.get(connectArr.size()-1).iconC2 != null || connectArr.get(connectArr.size()-1).iconS2 != null)
				{
					System.out.println("New connection added\n");
					Connection tempConnec = new Connection(parentPane.cPanel.aggregate, parentPane.cPanel.inherit, parentPane.cPanel.associate, parentPane.cPanel.bold, parentPane.cPanel.dashed, parentPane.cPanel.color);
					tempConnec.AddCircle(thisCircle);
					connectArr.add(tempConnec);
				}
				
				// otherwise add a circle to the last item of the connection list
				else
				{
					System.out.println("Circle added to last connection\n");
					connectArr.get(connectArr.size() - 1).AddCircle(thisCircle);
				}
				
				// repaint parent
				parentPane.repaint();
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
	   				thisCircle.setName(name + (contentPane.getComponentCount() - 3));
	   				
	   				IconCircle tempCircle = new IconCircle(true);
	   				tempCircle.connectArr = connectArr;
	   				tempCircle.parentPane = parentPane;
	   				
	   				contentPane.add(tempCircle);
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
	   	if(clickable)
	   	{
	   		this.addMouseMotionListener(onDrag);
	   		this.addMouseListener(removeListeners);
	   	}
	   	
	   	// name displayed on label
	   	showName = new JLabel("Interface");
	   	this.add(showName);
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(image, 0, 0, this); // see javadoc for more info on the parameters            
	}
	
	// sets the name
	public void setName(String s)
	{
		name = s;
		showName.setText(name);
	}
	
	// returns name
	public String getName()
	{
		return name;
	}
	
}

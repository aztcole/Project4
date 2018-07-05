package pack;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.JPanel;

public class IconCircle extends JPanel {
    private BufferedImage image;
    private String name = "Circle-";
    private int x = 300;
    private int y = 50;
    static int iconCount = 1;

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
    static boolean repaintedCheck; //this checks if already repainted 
    
	public IconCircle() {
	    super();
	    this.name = name + iconCount;
	    iconCount++;
	    this.setLocation(this.getX(),this.getY());
	    this.setSize(new Dimension(100,100));
	    this.setOpaque(false);
	    this.setVisible(true);
	    try {                
      image = ImageIO.read(new File("resources//circle.png"));
   } catch (IOException ex) {
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
        	thisCircle.setLocation(p.x - 50,p.y -50);
        	thisCircle.setX(p.x - 50);
        	thisCircle.setY(p.y - 50);



        	contentPane.repaint();
        	
        }};
		MouseAdapter afterListenerRemove = new MouseAdapter() {
			   		
			   		public void mouseClicked(MouseEvent e) {
			        	IconCircle thisCircle = (IconCircle) e.getSource();
			        	System.out.println(thisCircle.name + " is located at " + thisCircle.getX() + "," + thisCircle.getY());
			}
		
		};
        
        MouseAdapter removeListeners = new MouseAdapter() {
	   		
	   		public void mousePressed(MouseEvent e) {
	        	JPanel contentPane = (JPanel) ((JPanel) e.getSource()).getParent();
	        	contentPane.add(new IconCircle());
	   		}
	   		public void mouseReleased(MouseEvent e) {
	   			IconCircle thisCircle = (IconCircle) e.getSource();
	   			thisCircle.removeMouseMotionListener(onDrag);
	   			//on drop, this listener will be deleted to implement the other listener 
	   			//which prevents more dragging 
	   			thisCircle.removeMouseListener(this);
	        	thisCircle.addMouseListener(afterListenerRemove);
	        	
	   		}
	   	};
	   	
		
	   	this.addMouseMotionListener(onDrag);
	   	this.addMouseListener(removeListeners);

	    }

	    @Override
	    protected void paintComponent(Graphics g) {
	        super.paintComponent(g);
	        g.drawImage(image, 0, 0, this); // see javadoc for more info on the parameters            
	    }
}
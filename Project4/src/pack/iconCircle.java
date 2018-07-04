// Class: iconCircle.java
// Lead Contributor: Tyler Cole
// Description: A child class of DraggableIcon. This class defines the circle image that represents
//				an interface in the diagram.

package pack;

public class iconCircle extends DraggableIcon{
	
	private static final long serialVersionUID = 1L;
	private static String name = "circle";
	
	// constructor
	public iconCircle()
	{
		super("resources//circle.png", true, name);
	}
}

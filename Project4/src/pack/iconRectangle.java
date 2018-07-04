// Class: iconRectangle.java
// Lead Contributor: Tyler Cole
// Description: A child class of DraggableIcon. This class defines the rectangle image that represents
//				a class in the diagram.

package pack;

public class iconRectangle extends DraggableIcon{
	
	private static final long serialVersionUID = 1L;
	private static String name = "rectangle";
	
	// constructor
	public iconRectangle()
	{
		super("resources//rectangle.png", true, name);
	}
}

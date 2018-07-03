// Class: Universe.java
// Author: Tyler Cole
// Description: Runs the program, creates the frame, adds panels to the frame.

package pack;

import java.awt.Dimension;
import javax.swing.*;

public class Universe extends JFrame {
	
	private JFrame frameWindow;
	
	
	// main method that runs the program
	public static void main(String[] args)
	{
		// try statement to catch possible errors
		try 
		{
			new Universe();
		}
		
		catch(Exception e) 
		{
			throw e;
		}
	}
	
	
	// constructor (creates the default frame and adds panels)
	public Universe()
	{
		// initializes frameWindow and sets some default requirements
		frameWindow = new JFrame();
		frameWindow.setVisible(true);
		frameWindow.setSize(new Dimension(1200, 700));
		frameWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frameWindow.setTitle("Project 4");
		
		// Creates a tab system to hold the question panels
		JTabbedPane tabbyPane = new JTabbedPane();
		frameWindow.add(tabbyPane);
		
		//Example tab
		tabbyPane.addTab("Example Tab 1", null); // null is where the component should be
		tabbyPane.addTab("Example Tab 2", null);
	}
}

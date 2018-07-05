// Class: Universe.java
// Lead Contributor: Tyler Cole
// Description: Runs the program, creates the frame, adds panels to the frame.

package pack;

import java.awt.Dimension;
import javax.swing.*;

public class Universe extends JFrame {
	
	private static final long serialVersionUID = 1L;
	
	private JFrame frameWindow;
	private JTabbedPane tabbyPane;
	public QuestionPanel[] questArr; // Array to hold the 10 question panels
	
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
			e.printStackTrace();
		}
	}
	
	
	// constructor (creates the default frame and adds panels)
	public Universe()
	{
		// initializes frameWindow and sets some default requirements
		frameWindow = new JFrame();
		frameWindow.setVisible(true);
		frameWindow.setSize(new Dimension(1200, 1200));
		frameWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frameWindow.setTitle("Project 4");
		
		//frameWindow.add(new DiagramPanel());
		
		// Creates a tab system to hold the question panels
		tabbyPane = new JTabbedPane();
		frameWindow.add(tabbyPane);
		
		//Example tabs (TO BE DELETED)
		tabbyPane.addTab("Example Tab 1", new QuestionPanel());
		tabbyPane.addTab("Example Tab 2", new QuestionPanel());
	}
}

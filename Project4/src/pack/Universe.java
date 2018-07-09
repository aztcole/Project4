// Class: Universe.java
// Lead Contributor: Tyler Cole
// Description: Runs the program, creates the frame, adds panels to the frame.

package pack;

import java.awt.Dimension;
import java.io.IOException;
import javax.swing.*;

public class Universe extends JFrame {
	
	private static final long serialVersionUID = 1L;
	
	private JFrame frameWindow;
	private JTabbedPane tabbyPane;
	private QuestionPool qPool;
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
		frameWindow.setLocationRelativeTo(null);
		
		// try/catch block to get an instance of the question pool
		try
		{
			qPool = QuestionPool.getInstance();
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		
		// calls set tabs to read the qPool and create tabs accordingly
		setTabs();
	}
	
	// creates a JTabbed pane and sets it's tabs to the questions read by QPool
	private void setTabs()
	{
		// Creates a tab system to hold the question panels
		tabbyPane = new JTabbedPane();
		
		// adds the tabs to the frame (comes before adding the tabs so that each tab is loaded as it comes instead of after all the others are loaded)
		frameWindow.add(tabbyPane);
		
		// for every question in the question pool, a tab is created
		for(int i = 0; i < qPool.questions.size(); i++)
		{
			// creates a temporary question panel
			QuestionPanel tempQPanel = new QuestionPanel();
			
			// questionInfo is set to the question item at qPool's index
			tempQPanel.questionInfo = qPool.questions.get(i);
			tempQPanel.checkType();
			
			// tempQPanel is added to a tab labeled "Question [index]"
			tabbyPane.addTab("Question " + (i+1), tempQPanel);
		}
	}
}

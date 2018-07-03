package pack;

import java.awt.Dimension;

import javax.swing.*;

public class Universe extends JFrame {
	
	private JFrame frameWindow;
	
	public static void main(String[] args)
	{
		// runs the program
		new Universe();
	}

	public Universe()
	{
		// initializes frameWindow and sets some default requirements
		frameWindow = new JFrame();
		frameWindow.setVisible(true);
		frameWindow.setSize(new Dimension(1200, 700));
		frameWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frameWindow.setTitle("Project 4 Question Frame");
		
		/* ADD PANELS TO FRAMEWINDOW HERE */
	}
}

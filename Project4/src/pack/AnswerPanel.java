// Class: AnswerPanel.java
// Lead Contributor: Tyler Cole
// Description: This class displays a picture in the bottom corner that changes based on whether your
//				answer is correct or wrong.

package pack;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class AnswerPanel extends JPanel{
	
	private static final long serialVersionUID = 1L;
	
	JLabel face;
	private BufferedImage image;
	
	// constructor
	public AnswerPanel()
	{
		// default settings
		this.setBackground(Color.WHITE);
		this.setSize(new Dimension(800,400));
		this.setLocation(10, 610);
		this.setBorder(BorderFactory.createLineBorder(Color.black));
		
		// set default image to frown
		setState(false);
	}
	
	public void setState(boolean state) {
		if(state) {
			CorrectAnswer();
		}
		else if(state == false) {
			IncorrectAnswer();
		}
	}
	// changes image to smiley face
	public void CorrectAnswer()
	{
		try
		{
			image = ImageIO.read(new File("resources//smile.png"));
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		this.repaint();
	}
	
	// changes image to frowny face
	public void IncorrectAnswer()
	{
		try
		{
			image = ImageIO.read(new File("resources//frown.png"));
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		this.repaint();
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(image, 0, 0, this);          
	}
}

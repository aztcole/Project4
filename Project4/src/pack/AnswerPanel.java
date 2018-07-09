// Class: AnswerPanel.java
// Lead Contributor: Tyler Cole
// Description: This class displays a picture in the bottom corner that changes based on whether your
//				answer is correct or wrong.

package pack;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.BorderFactory;
import javax.swing.JPanel;

public class AnswerPanel extends JPanel{
	
	private static final long serialVersionUID = 1L;
	
	// constructor
	public AnswerPanel()
	{
		// default settings
		this.setBackground(Color.WHITE);
		this.setSize(new Dimension(800,400));
		this.setLocation(10, 610);
		this.setBorder(BorderFactory.createLineBorder(Color.black));
	}
}

// Class: CodePanel.java
// Lead Contributor: Tyler Cole
// Description: The panel directly to the right of the diagram panel. This panel formerly displayed the code
//				created when adding shapes, but now is used for someone answering the question to either
//				write the code of a diagram they see, or attempt to create a diagram based on the code
//				written in this panel.

package pack;

import java.awt.Dimension;
import java.util.Observable;
import java.util.Observer;
import javax.swing.*;

public class CodePanel extends JPanel implements Observer {
	
	private static final long serialVersionUID = 1L;
	
	JTextArea text;
	JScrollPane scroll;
	
	// constructor
	public CodePanel()
	{
		this.setSize(350, 750);
		this.setLocation(820, 200);
		
		text = new JTextArea(46,31);
		text.setEditable(true);
		text.setSize(350, 750);
		text.setEditable(false);
		text.setLineWrap(true);

		scroll = new JScrollPane(text); //add a scrollbar to the text 
		scroll.setSize(350, 750);
		scroll.setSize(new Dimension(200,400));
		scroll.setWheelScrollingEnabled(true);
		scroll.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
		scroll.setVisible(true);
		scroll.getVerticalScrollBar().setUnitIncrement(16);
		
		this.add(scroll);
		
	}

	@Override
	public void update(Observable arg0, Object arg1) {
		
	}
}

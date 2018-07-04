// Class: CodePanel.java
// Lead Contributor: Tyler Cole
// Description: The panel directly to the right of the diagram panel. This panel formerly displayed the code
//				created when adding shapes, but now is used for someone answering the question to either
//				write the code of a diagram they see, or attempt to create a diagram based on the code
//				written in this panel.

package pack;

import java.util.Observable;
import java.util.Observer;
import javax.swing.*;

public class CodePanel extends JPanel implements Observer {
	
	private static final long serialVersionUID = 1L;
	
	// constructor
	public CodePanel()
	{
		
	}

	@Override
	public void update(Observable arg0, Object arg1) {
		
	}
}

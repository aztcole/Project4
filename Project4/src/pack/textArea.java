package pack;
import java.awt.*;
import javax.swing.*;
public class textArea extends JPanel{
	private static final long serialVersionUID = 1L;
	JTextArea text;
	JScrollPane scroll;
	
	public textArea(){
		this.setSize(350, 750);
		this.setLocation(820, 200);
		this.setOpaque(false);
		
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
		

		
}}
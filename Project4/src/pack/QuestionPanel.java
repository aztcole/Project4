// Class: QuestionPanel.java
// Lead Contributor: Tyler Cole
// Description: Holds the diagram panel and the text panel

package pack;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.swing.*;

public class QuestionPanel extends JPanel {
	
	private static final long serialVersionUID = 1L;
	private int cCount = 0;
	private ControlPanel cPanel;
	private DiagramPanel dPanel;
	private CodePanel codePanel;
	private AnswerPanel answerPanel;
	private Point spawn = new Point(10, 30);
	private String codeToText;
	private boolean isDiagram;
	// Array lists
	public ArrayList<String> questionInfo;

	private ArrayList<Connection> connecArr = new ArrayList<Connection>();
	
	// constructor
	public QuestionPanel()
	{
		// sets default settings
		this.setLayout(null);
		this.setBackground(Color.WHITE);
		
		// answer panel
		answerPanel = new AnswerPanel();
		this.add(answerPanel);
	}
	
	
	// checks what type of panel this is based on questionInfo
	public void checkType()
	{
		if(questionInfo.get(0).contains("Diagram"))
		{
			setDiagram(false);
			isDiagramPanel();
		}
		else if(questionInfo.get(0).contains("Code"))
		{
			setDiagram(true);
			isCodePanel();
		}
	}
	
	// user has to generate the code
	private void isDiagramPanel()
	{
		JPanel staticDiagramPanel = new JPanel()
				{
					private static final long serialVersionUID = 1L;
					
					// paint component to draw lines
					protected void paintComponent(Graphics g)
						{
							// access paint component
							super.paintComponent(g);
								
							// draws connections
							for(int i = 0; i < connecArr.size(); i++)
							{
								connecArr.get(i).draw(g);
							}
					
						}
				};
		staticDiagramPanel.setBackground(Color.WHITE);
		staticDiagramPanel.setSize(new Dimension(800,600));
		staticDiagramPanel.setBorder(BorderFactory.createLineBorder(Color.black));
		staticDiagramPanel.setLocation(10, 0);
		staticDiagramPanel.setLayout(null);
		
		// initializes the code panel
		codePanel = new CodePanel(true);
		codePanel.setLocation(820, 0);
		
		// repaints when you move the mouse (to fix arrow heads moving)
		staticDiagramPanel.addMouseMotionListener(new MouseAdapter()
				{
					public void mouseMoved(MouseEvent e)
					{
						staticDiagramPanel.repaint();
					}
				});
		
		// adds panels
		this.add(staticDiagramPanel);
		this.add(codePanel);
		
		// parse in the icons from the qPool
		parseIcons(staticDiagramPanel);
	}
	
	
	// user has to make the diagram
	private void isCodePanel()
	{
		// initializes Control panel
		cPanel = new ControlPanel();
				
		// initializes diagram panel
		dPanel = new DiagramPanel();
		
		// connect the panels
		cPanel.dPanel = dPanel;
		dPanel.cPanel = cPanel;
		
		// static texts created to show the user the text
		JPanel staticTextPanel = new JPanel();
		JTextArea staticTextArea = new JTextArea();
		
		// text panel defaults
		staticTextPanel.setLayout(null);
		staticTextPanel.setSize(350, 480);
		staticTextPanel.setLocation(820, 210);
		staticTextPanel.setBorder(BorderFactory.createLineBorder(Color.black));
		staticTextPanel.add(staticTextArea);
		
		// text area defaults
		staticTextArea.setEditable(false);
		staticTextArea.setSize(348, 478);
		staticTextArea.setLocation(1,1);
		
		// parses code into a string (codeToText)
		ParseCode();
		
		// puts parsed code into the text area
		staticTextArea.setText(codeToText);
		
		// add the panels
		this.add(staticTextPanel);
		this.add(cPanel);
		this.add(dPanel);
	}
	
	// creates the shapes and connections for the unchangeable diagram
	private void parseIcons(JPanel panel)
	{
		ArrayList<IconCircle> circleArr = new ArrayList<IconCircle>();
		ArrayList<IconSquare> squareArr = new ArrayList<IconSquare>();
		
		// parse the string
		String delims = "[ ]";
		String[] parsedStringClasses = questionInfo.get(1).split(delims);
		
		// create the unchangeable icons
		for(int i = 0; i < parsedStringClasses.length; i++)
		{
			if(parsedStringClasses[i].equals("i"))
			{
				// creates a temporary unchangeable circle
				IconCircle tempCircle = new IconCircle(false);
				
				// stagger the spawns
				if(spawn.x> 600 && ((spawn.y/100) % 2) == 0)
				{
					spawn.x = 110;
					spawn.y = spawn.y + 100;
				}
				else if(spawn.x > 600)
				{
					spawn.x = 10;
					spawn.y = spawn.y + 100;
				}
				
				tempCircle.setX(spawn.x);
				tempCircle.setY(spawn.y);
				tempCircle.setName(parsedStringClasses[i+1]);
				
				// add to array list and panel
				circleArr.add(tempCircle);
				panel.add(tempCircle);
				
				// increment spawn x
				spawn.x = spawn.x+400;
			}
			else if(parsedStringClasses[i].equals("c"))
			{
				// creates a temporary unchangeable square
				IconSquare tempSquare = new IconSquare(false);
				
				// stagger the spawns
				if(spawn.x> 600 && ((spawn.y/100) % 2) == 0)
				{
					spawn.x = 110;
					spawn.y = spawn.y + 100;
				}
				else if(spawn.x > 600)
				{
					spawn.x = 10;
					spawn.y = spawn.y + 100;
				}
				
				tempSquare.setX(spawn.x);
				tempSquare.setY(spawn.y);
				tempSquare.setName(parsedStringClasses[i+1]);
				
				// add to array list and panel
				squareArr.add(tempSquare);
				panel.add(tempSquare);
				
				//increment spawn
				spawn.x = spawn.x+400;
			}
		}
		
		// creating connections
		if(questionInfo.size() >= 3)
		{
			for(int j = 2; j < questionInfo.size(); j++)
			{
				String delimer = "[ ]";
				String[] parsedStringConnec = questionInfo.get(j).split(delimer);
				
				Connection tempConnec;
				
				// create the temporary connection with the specified connection type
				if(parsedStringConnec[1].equals("g"))
				{
					tempConnec = new Connection(true, false, false, false, false, Color.BLACK);
				}
				else if(parsedStringConnec[1].equals("i"))
				{
					tempConnec = new Connection(false, true, false, false, false, Color.BLACK);
				}
				else if(parsedStringConnec[1].equals("s"))
				{
					tempConnec = new Connection(false, false, true, false, false, Color.BLACK);
				}
				else
				{
					tempConnec = new Connection(false, false, false, false, false, Color.BLACK);
				}
				
				connecArr.add(tempConnec);
				
				// reads in the first circle
				if(circleArr.size() > 0)
				{
					for(int z = 0; z < circleArr.size(); z++)
					{
						if(circleArr.get(z).getName().equals(parsedStringConnec[0]))
						{
							tempConnec.AddCircle(circleArr.get(z));
						}
					}
				}
				
				// reads in the first square
				if(squareArr.size() > 0)
				{
					for(int p = 0; p < squareArr.size(); p++)
					{
						if(squareArr.get(p).getName().equals(parsedStringConnec[0]))
						{
							tempConnec.AddSquare(squareArr.get(p));
						}
					}
				}
				
				// reads in the second object (circle)
				if(circleArr.size() > 0)
				{
					for(int k = 0; k < circleArr.size(); k++)
					{
						if(circleArr.get(k).getName().equals(parsedStringConnec[2]))
						{
							tempConnec.AddCircle(circleArr.get(k));
						}
					}
				}
				
				// reads in the second object (square)
				if(squareArr.size() > 0)
				{
					for(int l = 0; l < squareArr.size(); l++)
					{
						if(squareArr.get(l).getName().equals(parsedStringConnec[2]))
						{
							tempConnec.AddSquare(squareArr.get(l));
						}
					}
				}
			}
		}
		
		panel.repaint();
	}
	
	private void ParseCode()
	{
		codeToText = "RECREATE THIS CODE WITH THE PROVIDED DIAGRAM\n\n";
		
		ArrayList<CodeToString> codeArr = new ArrayList<CodeToString>();
		
		// parse the string
		String delims = "[ ]";
		String[] parsedStringClasses = questionInfo.get(1).split(delims);
		
		// passes parsed data into CodeToString objects
		for(int w = 0; w < parsedStringClasses.length; w++)
		{
			if(parsedStringClasses[w].equals("i"))
			{
				// temporary interface codetostring created and added to array
				CodeToString tempCode = new CodeToString("interface", parsedStringClasses[w + 1]);
				codeArr.add(tempCode);
			}
			
			else if(parsedStringClasses[w].equals("c"))
			{
				// temporary class codetostring created and added to array
				CodeToString tempCode = new CodeToString("class", parsedStringClasses[w + 1]);
				codeArr.add(tempCode);
			}
		}
		
		// passes connection data into code array
		for(int u = 2; u < questionInfo.size(); u++)
		{
			String delimer = "[ ]";
			String[] parsedStringConnec = questionInfo.get(u).split(delimer);
			CodeToString temp1 = new CodeToString("placeholder1", "placeholder2");
			CodeToString temp2 = new CodeToString("placeholder1", "placeholder2");
			
			for(int h = 0; h < codeArr.size(); h++)
			{
				if(codeArr.get(h).getName().equals(parsedStringConnec[0]))
				{
					temp1 = codeArr.get(h);
				}
				
				if(codeArr.get(h).getName().equals(parsedStringConnec[2]))
				{
					temp2 = codeArr.get(h);
				}
			}
			
			// sets the connections
			if(parsedStringConnec[1].equals("g"))
			{
				temp1.setAggregate(temp2);
			}
			
			if(parsedStringConnec[1].equals("s"))
			{
				temp1.setAssociate(temp2);
			}
			
			if(parsedStringConnec[1].equals("i"))
			{
				temp1.setInherit(temp2);
			}
		}
		
		for(int o = 0; o < codeArr.size(); o++)
		{
			codeToText = codeToText + codeArr.get(o).ToString() + "\n";
		}
	}


	public boolean getDiagram() {
		return isDiagram;
	}


	public void setDiagram(boolean isDiagram) {
		this.isDiagram = isDiagram;
	}
	
	public void iterateCount() {
		cCount++;
	}
	
	public int getCount() {
		return cCount;
	}
	
	public int getConnectionCount() {
		return questionInfo.size();
	}
}

// Class: ControlPanel.java
// Lead Contributor: Tyler Cole
// Description: A panel that has multiple options to control the graphics in the Diagram Panel, specifically
// 				the line graphics.

package pack;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.*;

public class ControlPanel extends JPanel{
	
	private static final long serialVersionUID = 1L;
	
	public DiagramPanel dPanel;
	public boolean aggregate, inherit, associate, bold, dashed;
	public Color color;
	
	private JPanel ButtonsPanel;
	
	// constructor
	public ControlPanel()
	{
		// initialize variables
		color = Color.BLACK;
				
		// initialize default settings
		this.setBackground(Color.WHITE);
		this.setSize(350, 200);
		this.setLocation(820, 0);
		this.setBorder(BorderFactory.createLineBorder(Color.black));
		this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
		
		// Buttons Panel defaults set
		ButtonsPanel = new JPanel();
		ButtonsPanel.setBackground(Color.WHITE);
		ButtonsPanel.setLayout(new BorderLayout());
		
		// panels added
		CreateColorPanel();
		this.add(new JLabel(" ")); // formatting new line
		CreateConnectionPanel();
		CreateLinePanel();
		UndoPanel();
		add(ButtonsPanel);
	}
	
	
	// creates a panel that manages color
	private void CreateColorPanel()
	{
		// color panel created to hold color button
		JPanel colorPanel = new JPanel();
		colorPanel.setBackground(Color.WHITE);
		colorPanel.add(new JLabel("Line Color: "));
		
		// initializes color button
		JButton colorButton = new JButton(" ");
		colorButton.setBackground(color);
		
		// listener for color button added
		colorButton.addActionListener(new ActionListener()
			{
				@Override
				public void actionPerformed(ActionEvent e) 
				{
					Color newColor = JColorChooser.showDialog(null, "Choose Color", Color.black);
					color = newColor;
					
					// update background
					colorButton.setBackground(color);
				}
			}
		);
		
		
		// adds to panels
		colorPanel.add(colorButton);
		this.add(colorPanel);
	}
	
	
	private void CreateConnectionPanel()
	{
		// connection panel created to hold the radio buttons
		JPanel connectionPanel = new JPanel();
		connectionPanel.setBackground(Color.WHITE);
		connectionPanel.setLayout(new BoxLayout(connectionPanel, BoxLayout.PAGE_AXIS));
		connectionPanel.add(new JLabel("Connections"));
		
		// class to control radio buttons
		class RadioListener implements ItemListener
		{
			public void itemStateChanged(ItemEvent ev)
			{
				boolean selected = (ev.getStateChange() == ItemEvent.SELECTED);
				AbstractButton b1 = (AbstractButton) ev.getItemSelectable();
				String command = b1.getActionCommand();
				
				if(selected)
				{
					if(command.equals("aggregate"))
					{
						aggregate = true;
					}
					
					if(command.equals("associate"))
					{
						associate = true;
					}
					
					if(command.equals("inherit"))
					{
						inherit = true;
					}
				}
				
				else
				{
					if(command.equals("aggregate"))
					{
						aggregate = false;
					}
					
					if(command.equals("associate"))
					{
						associate = false;
					}
					
					if(command.equals("inherit"))
					{
						inherit = false;
					}
				}
			}
		}
		
		// instantiate radio listener
		RadioListener radioListener = new RadioListener();
		
		
		// Buttons
		JRadioButton plainButton = new JRadioButton("None");
		plainButton.addItemListener(radioListener);
		plainButton.setSelected(true);
		plainButton.setBackground(Color.WHITE);
		
		JRadioButton inheritButton = new JRadioButton("Inheritance");
		inheritButton.addItemListener(radioListener);
		inheritButton.setActionCommand("inherit");
		inheritButton.setBackground(Color.WHITE);
		
		JRadioButton aggregateButton = new JRadioButton("Aggregation");
		aggregateButton.addItemListener(radioListener);
		aggregateButton.setActionCommand("aggregate");
		aggregateButton.setBackground(Color.WHITE);
		
		JRadioButton associateButton = new JRadioButton("Association");
		associateButton.addItemListener(radioListener);
		associateButton.setActionCommand("associate");
		associateButton.setBackground(Color.WHITE);
		
		
		// Button group
		ButtonGroup radioButtonsGroup = new ButtonGroup();
		radioButtonsGroup.add(plainButton);
		radioButtonsGroup.add(inheritButton);
		radioButtonsGroup.add(aggregateButton);
		radioButtonsGroup.add(associateButton);
		
		
		// Add to panel
		connectionPanel.add(plainButton);
		connectionPanel.add(inheritButton);
		connectionPanel.add(aggregateButton);
		connectionPanel.add(associateButton);
		ButtonsPanel.add(connectionPanel, BorderLayout.WEST);
	}
	
	
	private void CreateLinePanel()
	{
		// connection panel created to hold the radio buttons
		JPanel linePanel = new JPanel();
		linePanel.setBackground(Color.WHITE);
		linePanel.setLayout(new BoxLayout(linePanel, BoxLayout.PAGE_AXIS));
		linePanel.add(new JLabel("Line Settings"));
		
		// class to control radio buttons
		class RadioListener implements ItemListener
		{
			public void itemStateChanged(ItemEvent ev)
			{
				boolean selected = (ev.getStateChange() == ItemEvent.SELECTED);
				AbstractButton b1 = (AbstractButton) ev.getItemSelectable();
				String command = b1.getActionCommand();
						
				if(selected)
				{
					if(command.equals("bold & dashed"))
					{
						bold = true;
						dashed = true;
					}
					
					if(command.equals("bold"))
					{
						bold = true;
						dashed = false;
					}
							
					if(command.equals("dashed"))
					{
						dashed = true;
						bold = false;
					}
					
					if (command.equals("plain"))
					{
						bold = false;
						dashed = false;
					}
				}
						
			}
		}
		
		// instantiate radio listener
		RadioListener radioListener = new RadioListener();
		
		
		// Creating Radio Buttons
		JRadioButton plainButton = new JRadioButton("Plain");
		plainButton.addItemListener(radioListener);
		plainButton.setSelected(true);
		plainButton.setActionCommand("plain");
		plainButton.setBackground(Color.WHITE);
		
		JRadioButton boldButton = new JRadioButton("Bold");
		boldButton.addItemListener(radioListener);
		boldButton.setActionCommand("bold");
		boldButton.setBackground(Color.WHITE);
		
		JRadioButton dashedButton = new JRadioButton("Dashed");
		dashedButton.addItemListener(radioListener);
		dashedButton.setActionCommand("dashed");
		dashedButton.setBackground(Color.WHITE);
		
		JRadioButton boldAndDashedButton = new JRadioButton("Bold and Dashed");
		boldAndDashedButton.addItemListener(radioListener);
		boldAndDashedButton.setActionCommand("bold & dashed");
		boldAndDashedButton.setBackground(Color.WHITE);
		
		
		// Button Group
		ButtonGroup radioButtonsGroup = new ButtonGroup();
		radioButtonsGroup.add(plainButton);
		radioButtonsGroup.add(boldButton);
		radioButtonsGroup.add(dashedButton);
		radioButtonsGroup.add(boldAndDashedButton);
		
		// Add to panel
		linePanel.add(plainButton);
		linePanel.add(boldButton);
		linePanel.add(dashedButton);
		linePanel.add(boldAndDashedButton);
		ButtonsPanel.add(linePanel, BorderLayout.CENTER);
	}
	
	
	// creates an undo button that deletes the last connection
	private void UndoPanel()
	{
		JPanel undoPanel = new JPanel();
		undoPanel.setBackground(Color.WHITE);
		undoPanel.setLayout(new BoxLayout(undoPanel, BoxLayout.PAGE_AXIS));
		undoPanel.add(new JLabel("Undo Last Line"));
		
		JButton undoButton = new JButton("UNDO");
		
		// listener for undo button added
		undoButton.addActionListener(new ActionListener()
			{
				@Override
				public void actionPerformed(ActionEvent e) 
				{
					// removes last item of connections list
					if(dPanel.connecArr != null && dPanel.connecArr.size() > 0)
					{
						dPanel.connecArr.remove(dPanel.connecArr.size() - 1);
						dPanel.repaint();
					}
				}
			}
		);
		
		// adds to panels
		undoPanel.add(undoButton);
		ButtonsPanel.add(undoPanel, BorderLayout.EAST);
		
		JToggleButton deleteIcon = new JToggleButton("Delete");
		deleteIcon.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AbstractButton thisToggleButton = (AbstractButton) e.getSource();
				if(thisToggleButton.getModel().isSelected()) {
					
					Universe.settoggle(true);
				}
				else {
					Universe.settoggle(false);
				}
				
				
			}
		});
		ButtonsPanel.add(deleteIcon, BorderLayout.SOUTH);
	}
}

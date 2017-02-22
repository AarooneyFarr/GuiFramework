package gui.view;

import javax.swing.JFrame;
import java.awt.Color;

import java.awt.Dimension;

import gui.controller.GuiController;

public class GuiFrame extends JFrame
{
	private GuiController baseController;
	private GuiPanel appPanel;
	
	
	public GuiFrame(GuiController baseController)
	{
		super();
		this.baseController = baseController;
		appPanel = new GuiPanel(baseController);
		
		setupFrame(500,500);
		setupListeners();
	}
	
	private void setupFrame(int width, int height)
	{
		this.setContentPane(appPanel);
		this.setTitle("Base Frame");
		this.setSize(new Dimension(width, height));
		this.setVisible(true);
		this.setBackground(Color.GREEN);
	}
	
	private void setupListeners()
	{
		this.addWindowListener(new java.awt.event.WindowAdapter()
		{
			
		@Override
		public void windowClosing(java.awt.event.WindowEvent windowEvent)
		{
			System.exit(0);
		}
				
			
				
		});
	}
}
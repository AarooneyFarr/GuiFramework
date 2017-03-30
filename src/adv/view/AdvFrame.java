package adv.view;

import javax.swing.JFrame;

import adv.controller.AdvController;

import java.awt.Color;

import java.awt.Dimension;

public class AdvFrame extends JFrame
{
	private AdvController baseController;
	private AdvPanel appPanel;
	
	
	public AdvFrame(AdvController baseController)
	{
		super();
		this.baseController = baseController;
		appPanel = new AdvPanel(baseController);
		
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
package drawing.view;

import javax.swing.JFrame;

import drawing.controller.DrawingController;

import java.awt.Color;

import java.awt.Dimension;

public class DrawingFrame extends JFrame
{
	private DrawingController baseController;
	private DrawingPanel appPanel;
	
	
	public DrawingFrame(DrawingController baseController)
	{
		super();
		this.baseController = baseController;
		appPanel = new DrawingPanel(baseController);
		
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
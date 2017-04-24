package drawing.view;

import javax.swing.*;

import drawing.controller.DrawingController;
import drawing.model.*;
import java.util.ArrayList;
import java.awt.*;
import java.awt.event.MouseListener;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;


public class ShapePanel extends JPanel
	{

		private DrawingController baseController;
		private ArrayList<Rectangle> rectangleList;
		
		public ShapePanel(DrawingController baseController)
		{
			super();
			this.baseController = baseController;
			
			setupPanel();
		}
		
		private void setupPanel()
		{
			this.setBackground(Color.CYAN);
			this.setMinimumSize(new Dimension(250,500));
		}
		
		private Color getRandomColor()
		{
			int alpha = (int) (Math.random() * 255);
			int red = (int) (Math.random() * 255);
			int green = (int) (Math.random() * 255);
			int blue = (int) (Math.random() * 255);
			
			return new Color( red, green, blue, alpha);
		}
		
		public void addRectangles()
		{
			for(int index = 0; index < 500; index++)
				{
					int width = (int) (Math.random() * 120) + 1;
					int height =  (int) (Math.random() * 120) + 15;
					int xCorner = (int) (Math.random() * this.getWidth() - 30);
					int yCorner = (int) (Math.random() * this.getHeight() - 30);
					
					Color currentColor = getRandomColor();
					
					Rectangle currentRectangle = new Rectangle(xCorner, yCorner, width, height);
					rectangleList.add(currentRectangle);
					
				}
			this.repaint();
			
		}
	}

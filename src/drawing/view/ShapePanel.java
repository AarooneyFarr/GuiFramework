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
		private ArrayList<Shape> rectangleList;
		private ArrayList<Shape> triangleList;
		private ArrayList<Shape> circleList;
		private ArrayList<Shape> ellipseList;
		private ArrayList<Shape> polygonList;
		private ArrayList<ArrayList<Shape>> shapes;

		public ShapePanel(DrawingController baseController)
			{
				super();
				this.baseController = baseController;
				rectangleList = new ArrayList<Shape>();
				triangleList = new ArrayList<Shape>();
				circleList = new ArrayList<Shape>();
				ellipseList = new ArrayList<Shape>();
				polygonList = new ArrayList<Shape>();
				shapes = new ArrayList<ArrayList<Shape>>();

				setupPanel();
			}

		private void setupPanel()
			{
				this.setBackground(Color.CYAN);
				this.setMinimumSize(new Dimension(250, 500));
			}

		private Color getRandomColor()
			{
				int alpha = (int) (Math.random() * 255);
				int red = (int) (Math.random() * 255);
				int green = (int) (Math.random() * 255);
				int blue = (int) (Math.random() * 255);

				return new Color(red, green, blue, alpha);
			}
		public void setupShapes()
		{
			shapes.add(rectangleList);
		}

		public void addRectangles()
			{
				for (int index = 0; index < 500; index++)
					{
						int width = (int) (Math.random() * 120) + 1;
						int height = (int) (Math.random() * 120) + 15;
						int xCorner = (int) (Math.random() * this.getWidth() - 30);
						int yCorner = (int) (Math.random() * this.getHeight() - 30);

						Color currentColor = getRandomColor();

						Shape currentRectangle = new Rectangle(xCorner, yCorner, width, height);
						rectangleList.add(currentRectangle);

					}
				this.repaint();

			}
		
		private void drawShapes(ArrayList<Shape> shapeList, Graphics2D graphics)
		{
			for(Shape currentShape : shapeList)
				{
					graphics.setColor(getRandomColor());
					int strokeWidth = (int) (Math.random() * 35);
					graphics.setStroke(new BasicStroke(strokeWidth));
					
					int randomness = (int) (Math.random() * 10) + 1;
					
					if(randomness % 5 == 00 || randomness % 7 == 0)
						{
							graphics.fill(currentShape);
							graphics.setColor(getRandomColor());
							graphics.draw(currentShape);
						}
					else
						{
							graphics.draw(currentShape);
						}
					
					
				}
		}

		@Override
		protected void paintComponent(Graphics graphics)
			{
			
				Graphics2D drawingGraphics = (Graphics2D) graphics;

				for (ArrayList<Shape> currentList : shapes)
					{
						drawShapes(currentList, drawingGraphics);
					}
			}
	}

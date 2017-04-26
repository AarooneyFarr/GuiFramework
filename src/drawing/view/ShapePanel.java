package drawing.view;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;

import drawing.controller.DrawingController;
import drawing.model.*;
import java.util.ArrayList;
import java.util.Vector;
import java.util.List;
import java.awt.*;
import java.awt.event.MouseListener;
import java.awt.geom.Ellipse2D;
import java.awt.image.BufferedImage;
import java.time.LocalDateTime;
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
				
				
				
				setupShapes();
				setupPanel();
			}

		private void setupPanel()
			{
				this.setBackground(Color.CYAN);
				this.setMinimumSize(new Dimension(250, 500));
			}
		
		private void setupListeners()
		{
			
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
				shapes.add(polygonList);
				shapes.add(triangleList);
				shapes.add(rectangleList);
				
				shapes.add(circleList);
				shapes.add(ellipseList);
				
			}

		public void addRectangles()
			{
				if (rectangleList.size() > 500)
					{
						rectangleList.clear();
					}

				for (int index = 0; index < 30; index++)
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

		public void addCircles()
			{
				if (circleList.size() > 500)
					{
						circleList.clear();
					}

				for (int index = 0; index < 30; index++)
					{
						int radius = (int) (Math.random() * 25) + 2;
						int xCorner = (int) (Math.random() * this.getWidth() - 15);
						int yCorner = (int) (Math.random() * this.getHeight() - 15);
						Ellipse2D.Double current = new Ellipse2D.Double(xCorner, yCorner, radius, radius);
						circleList.add(current);
					}
				this.repaint();
			}

		public void addTriangles()
			{
				if (triangleList.size() > 500)
					{
						triangleList.clear();
					}
				
				for(int index = 0; index < 30; index ++ )
					{
						int vertexCount = 3;
						int [] xVertices = new int [vertexCount];
						int [] yVertices = new int [vertexCount];
						for(int vertex = 0; vertex < vertexCount; vertex++)
							{
								int xCorner = (int) (Math.random() * this.getWidth());
								int yCorner = (int) (Math.random() * this.getHeight());
								xVertices[vertex] = xCorner;
								yVertices[vertex] = yCorner;
							}
						Polygon current = new Polygon(xVertices, yVertices, vertexCount);
						polygonList.add(current);
					}
				this.repaint();
			}

		public void addEllipses()
			{
				if (ellipseList.size() > 500)
					{
						ellipseList.clear();
					}

				for (int index = 0; index < 30; index++)
					{
						int height = (int) (Math.random() * 25) + 2;
						int width = (int) (Math.random() * 25) + 2;
						int xCorner = (int) (Math.random() * this.getWidth() - 15);
						int yCorner = (int) (Math.random() * this.getHeight() - 15);
						Ellipse2D.Double current = new Ellipse2D.Double(xCorner, yCorner, height, width);
						ellipseList.add(current);
					}
				this.repaint();
			}

		public void addPolygons()
			{
				if (polygonList.size() > 500)
					{
						polygonList.clear();
					}
				
				for(int index = 0; index < 30; index ++ )
					{
						int vertexCount = (int) (Math.random() * 7) + 4;
						int [] xVertices = new int [vertexCount];
						int [] yVertices = new int [vertexCount];
						for(int vertex = 0; vertex < vertexCount; vertex++)
							{
								int xCorner = (int) (Math.random() * this.getWidth());
								int yCorner = (int) (Math.random() * this.getHeight());
								xVertices[vertex] = xCorner;
								yVertices[vertex] = yCorner;
							}
						Polygon current = new Polygon(xVertices, yVertices, vertexCount);
						polygonList.add(current);
					}
				this.repaint();
			}

		private void drawShapes(ArrayList<Shape> shapeList, Graphics2D graphics)
			{
				for (Shape currentShape : shapeList)
					{
						graphics.setColor(getRandomColor());
						int strokeWidth = (int) (Math.random() * 15);
						graphics.setStroke(new BasicStroke(strokeWidth));

						int randomness = (int) (Math.random() * 10) + 1;

						if (randomness % 5 == 00 || randomness % 7 == 0)
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
		
		public void savePanel()
		{
			BufferedImage panelImage = new BufferedImage(this.getSize().width, this.getSize().height, BufferedImage.TYPE_INT_ARGB);
			Graphics fileGraphics = panelImage.getGraphics();
			
			Color background = new Color(getBackground().getRed(), getBackground().getGreen(), getBackground().getBlue());
			fileGraphics.setColor(background);;
			fileGraphics.fillRect(0, 0,  this.getSize().width, this.getSize().height);
			this.printAll(fileGraphics);
			fileGraphics.dispose();
			
			try
				{
					ImageIO.write(panelImage,  "png", new File("My Modern Art " + LocalDateTime.now().getHour() + "-" + LocalDateTime.now().getMinute() + ".png"));
				}
			catch (IOException errror)
				{
					JOptionPane.showMessageDialog(this, "Save Failed");
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

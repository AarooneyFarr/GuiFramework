package drawing.view;

import javax.swing.*;

import drawing.controller.DrawingController;
import drawing.model.*;

import java.awt.*;
import java.awt.event.MouseListener;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;

public class DrawingPanel extends JPanel
	{
		private ShapePanel shapePanel;
		private JButton rectangleButton;
		private JButton triangleButton;
		private JButton circleButton;
		private JButton ellipseButton;
		private JButton polygonButton;
		private JButton saveButton;
		private DrawingController baseController;
		
		
		public DrawingPanel(DrawingController baseController)
			{
				super();
				this.baseController = baseController;

				shapePanel = new ShapePanel(baseController);
				rectangleButton = new JButton("Draw Rectangles");
				triangleButton = new JButton("Draw Triangles");
				circleButton = new JButton("Draw Circles");
				polygonButton = new JButton("Draw Polygons");
				ellipseButton = new JButton("Draw Ovals");
				saveButton = new JButton("Save");
				
				
				
				setupPanel();
				setupLayout();
				setupListeners();
			}

		public void setupPanel()
			{
				this.setLayout(null);
				this.setBackground(Color.GRAY);
				this.add(rectangleButton);
				this.add(triangleButton);
				this.add(circleButton);
				this.add(ellipseButton);
				this.add(polygonButton);
				this.add(shapePanel);
				this.add(saveButton);
			}

		public void setupLayout()
			{
				rectangleButton.setBounds(176,391,148,54);
				triangleButton.setBounds(14, 391, 148, 54);
				circleButton.setBounds(338, 391, 148, 54);
				polygonButton.setBounds(338, 325, 148, 54);
				ellipseButton.setBounds(176, 325, 148, 54);
				saveButton.setBounds(14,325,148,54);



				
				
				shapePanel.setBounds(0,0,500,250);
			}

		public void setupListeners()
			{
				rectangleButton.addActionListener(new ActionListener()
					{

						public void actionPerformed(ActionEvent e)
							{
								shapePanel.addRectangles();
								
							}
					});
				triangleButton.addActionListener(new ActionListener()
					{

						public void actionPerformed(ActionEvent e)
							{
								shapePanel.addTriangles();
								
							}
					});
				circleButton.addActionListener(new ActionListener()
					{

						public void actionPerformed(ActionEvent e)
							{
								shapePanel.addCircles();
								
							}
					});
				ellipseButton.addActionListener(new ActionListener()
					{

						public void actionPerformed(ActionEvent e)
							{
								shapePanel.addEllipses();
								
							}
					});
				polygonButton.addActionListener(new ActionListener()
					{

						public void actionPerformed(ActionEvent e)
							{
								shapePanel.addPolygons();
								
							}
					});
				saveButton.addActionListener(new ActionListener()
					{

						public void actionPerformed(ActionEvent e)
							{
								shapePanel.savePanel();
								
							}
					});
				
				
			}
	}

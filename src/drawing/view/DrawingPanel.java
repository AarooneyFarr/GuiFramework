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
		private DrawingController baseController;

		public DrawingPanel(DrawingController baseController)
			{
				super();
				this.baseController = baseController;

				shapePanel = new ShapePanel(baseController);
				rectangleButton = new JButton("Draw Rectangles");
				
				
				setupPanel();
				setupLayout();
				setupListeners();
			}

		public void setupPanel()
			{
				this.setLayout(null);
				this.setBackground(Color.GRAY);
				this.add(rectangleButton);
				this.add(shapePanel);
			}

		public void setupLayout()
			{
				rectangleButton.setBounds(180,391,148,54);
				shapePanel.setBounds(0,0,500,250);
			}

		public void setupListeners()
			{
				rectangleButton.addActionListener(new ActionListener()
					{

						public void actionPerformed(ActionEvent e)
							{
								shapePanel.addRectangles();
								shapePanel.setupShapes();
							}
					});
			}
	}

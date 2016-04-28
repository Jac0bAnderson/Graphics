package graphics.view;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import graphics.controller.GraphicController;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.SpringLayout;

	public class DrawingPanel extends JPanel
	{
		private SpringLayout baseLayout;
		private GraphicController baseController;
		private ShapePanel shapePanel;
		private JButton drawRectangle;
		private JButton drawCircle;
		private JButton drawTriangle;
		private JButton clearButton;
		private JButton drawEllipse;
		private JButton drawSquare;
		private ArrayList<Rectangle> rectangleList;
		public String recString;
		
		

		public DrawingPanel(GraphicController baseController)
		{
			this.baseController = baseController;
			baseLayout = new SpringLayout();
			rectangleList = new ArrayList<Rectangle>();
			drawRectangle = new JButton("Rectangle");
	
			drawCircle = new JButton("Circle");
			drawTriangle = new JButton("Triangle");
			shapePanel = new ShapePanel();
			drawEllipse = new JButton("Ellipse");
			clearButton = new JButton("clear");
			drawSquare = new JButton("Square");
			

			
			
			setupPanel();
			setupLayout();
			setupListeners();
		}
		private void setupPanel()
		{
			this.add(drawSquare);
			this.setBackground(Color.WHITE);
			this.add(shapePanel);
			this.add(drawCircle);
			this.add(drawTriangle);
			this.add(drawRectangle );
			this.setLayout(baseLayout);
			
						
		}
		private void setupLayout()
		{
			baseLayout.putConstraint(SpringLayout.NORTH, clearButton, 0, SpringLayout.NORTH, drawSquare);
			baseLayout.putConstraint(SpringLayout.EAST, clearButton, -6, SpringLayout.WEST, drawSquare);
			baseLayout.putConstraint(SpringLayout.NORTH, drawSquare, 0, SpringLayout.NORTH, drawCircle);
			baseLayout.putConstraint(SpringLayout.EAST, drawSquare, -6, SpringLayout.WEST, drawEllipse);
			baseLayout.putConstraint(SpringLayout.NORTH, shapePanel, 10, SpringLayout.NORTH, this);
			baseLayout.putConstraint(SpringLayout.WEST, shapePanel, 23, SpringLayout.WEST, this);
			baseLayout.putConstraint(SpringLayout.SOUTH, shapePanel, 478, SpringLayout.NORTH, this);
			baseLayout.putConstraint(SpringLayout.EAST, shapePanel, -73, SpringLayout.EAST, this);
			baseLayout.putConstraint(SpringLayout.NORTH, drawTriangle, 0, SpringLayout.NORTH, drawCircle);
			baseLayout.putConstraint(SpringLayout.WEST, drawTriangle, 4, SpringLayout.EAST, drawRectangle);
			baseLayout.putConstraint(SpringLayout.NORTH, drawTriangle, 0, SpringLayout.NORTH, drawCircle);
			baseLayout.putConstraint(SpringLayout.WEST, drawTriangle, 4, SpringLayout.EAST, drawRectangle);
			baseLayout.putConstraint(SpringLayout.NORTH, drawCircle, 0, SpringLayout.NORTH, drawRectangle);
			baseLayout.putConstraint(SpringLayout.EAST, drawCircle, -6, SpringLayout.WEST, drawRectangle);
			baseLayout.putConstraint(SpringLayout.SOUTH, drawRectangle, -82, SpringLayout.SOUTH, this);
			baseLayout.putConstraint(SpringLayout.EAST, drawRectangle, -151, SpringLayout.EAST, this);
			add(clearButton);
			baseLayout.putConstraint(SpringLayout.NORTH, drawEllipse, 0, SpringLayout.NORTH, drawCircle);
			baseLayout.putConstraint(SpringLayout.EAST, drawEllipse, -6, SpringLayout.WEST, drawCircle);
			add(drawEllipse);
		}
		private void setupListeners()
		{
			drawRectangle.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent click)
				{ /**
				int xPosition = (int)(Math.random()* 800);
					int yPosition = (int) (Math.random()* 800);
					int width = (int) (Math.random()* 50);
					int height = (int) (Math.random()* 50);
					rectangleList.add(new Rectangle(xPosition, yPosition, width, height));
					repaint();
					recCount++;
					recString = Integer.toString(recCount);
					drawRectangle.setText(recString);
				**/
					shapePanel.addRectangle();
					//shapePanel.addTriangle();
					repaint();
					
				}
				
			});
			drawCircle.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent click)
				{ 
					shapePanel.addCircle();
					repaint();
				}
				
			});
			drawTriangle.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent click)
				{ 
					shapePanel.addTriangle();
					repaint();
				}
				
			});
			clearButton.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent click)
				{ 
					shapePanel.clear();
					repaint();
				}
				
			});		
			drawEllipse.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent click)
				{ 
					shapePanel.addEllipse();
					repaint();
				}
				
			});	
			drawRectangle.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent click)
				{ 
					shapePanel.addSquare();
					repaint();
				}
				
			});	
			
			}
		@Override
		protected void paintComponent(Graphics currentGraphics)
		{
			super.paintComponent(currentGraphics);
			Graphics2D mainGraphics = (Graphics2D)currentGraphics;
			mainGraphics.setColor(Color.RED);
			mainGraphics.setStroke(new BasicStroke(1));
			mainGraphics.draw(new Rectangle(30,30,10,17));
			for(Rectangle current : rectangleList)
			{
				int randomStroke = (int) (Math.random()*7);
				int red = (int)(Math.random()* 256);
				int blue = (int)(Math.random()* 256);
				int green = (int)(Math.random()* 256);
				mainGraphics.setColor(new Color(red, green, blue));
				mainGraphics.setStroke(new BasicStroke(randomStroke));
				
				mainGraphics.fill(current);
			}
		}
}

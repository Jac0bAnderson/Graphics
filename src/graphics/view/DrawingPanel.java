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
		private ArrayList<Rectangle> rectangleList;
		public String recString;
		private int recCount;
		

		public DrawingPanel(GraphicController baseController)
		{
			this.baseController = baseController;
			baseLayout = new SpringLayout();
			rectangleList = new ArrayList<Rectangle>();
			drawRectangle = new JButton("Rectangle");
			recCount = 1;
			drawCircle = new JButton("Circle");
			
			drawTriangle = new JButton("Triangle");
			
			
			shapePanel = new ShapePanel();
			baseLayout.putConstraint(SpringLayout.NORTH, shapePanel, 10, SpringLayout.NORTH, this);
			baseLayout.putConstraint(SpringLayout.WEST, shapePanel, 23, SpringLayout.WEST, this);
			baseLayout.putConstraint(SpringLayout.SOUTH, shapePanel, 478, SpringLayout.NORTH, this);
			baseLayout.putConstraint(SpringLayout.EAST, shapePanel, -73, SpringLayout.EAST, this);
			
			setupPanel();
			setupLayout();
			setupListeners();
		}
		private void setupPanel()
		{
			this.setBackground(Color.WHITE);
			this.add(shapePanel);
			this.add(drawCircle);
			this.add(drawTriangle);
			this.add(drawRectangle );
			this.setLayout(baseLayout);
		}
		private void setupLayout()
		{
			baseLayout.putConstraint(SpringLayout.NORTH, drawTriangle, 0, SpringLayout.NORTH, drawCircle);
			baseLayout.putConstraint(SpringLayout.WEST, drawTriangle, 4, SpringLayout.EAST, drawRectangle);
			baseLayout.putConstraint(SpringLayout.NORTH, drawTriangle, 0, SpringLayout.NORTH, drawCircle);
			baseLayout.putConstraint(SpringLayout.WEST, drawTriangle, 4, SpringLayout.EAST, drawRectangle);
			baseLayout.putConstraint(SpringLayout.NORTH, drawCircle, 0, SpringLayout.NORTH, drawRectangle);
			baseLayout.putConstraint(SpringLayout.EAST, drawCircle, -6, SpringLayout.WEST, drawRectangle);
			baseLayout.putConstraint(SpringLayout.SOUTH, drawRectangle, -82, SpringLayout.SOUTH, this);
			baseLayout.putConstraint(SpringLayout.EAST, drawRectangle, -151, SpringLayout.EAST, this);
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
					shapePanel.addTriangle();
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

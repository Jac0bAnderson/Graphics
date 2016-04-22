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
		private ArrayList<Rectangle> rectangleList;
		

		public DrawingPanel(GraphicController baseController)
		{
			this.baseController = baseController;
			baseLayout = new SpringLayout();
			rectangleList = new ArrayList<Rectangle>();
			drawRectangle = new JButton("Click for shapes");
			shapePanel = new ShapePanel();
			setupPanel();
			setupLayout();
			setupListeners();
		}
		private void setupPanel()
		{
	
		}
		private void setupLayout()
		{
	
		}
		private void setupListeners()
		{
			drawRectangle.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent click)
				{
					int xPosition = (int)(Math.random()* 600);
					int yPosition = (int) (Math.random()*600);
					int width = (int) (Math.random()* 50);
					int height = (int) (Math.random()* 50);
					rectangleList.add(new Rectangle(xPosition, yPosition, width, height));
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

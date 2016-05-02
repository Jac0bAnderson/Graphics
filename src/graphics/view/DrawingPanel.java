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
import javax.swing.JCheckBox;
import javax.swing.JPanel;
import javax.swing.SpringLayout;

	public class DrawingPanel extends JPanel
	{
		//Buttons
		private JButton drawRectangle;
		private JButton drawCircle;
		private JButton drawTriangle;
		private JButton clearButton;
		private JButton drawEllipse;
		private JButton drawSquare;
		private JButton drawPolygon;
		//checkboxes
		private JCheckBox clearRectangle;
		private JCheckBox clearCircle;
		private JCheckBox clearTriangle; 
		private JCheckBox clearEllipse;
		private JCheckBox clearSquare;
		private JCheckBox clearPolygon;
		//booleans
		public boolean rectangleClear;
		public boolean cirlceClear;
		public boolean triangleClear;
		public boolean ellipseClear;
		public boolean squareClear;
		public boolean polygonClear;
		//
		private ArrayList<Rectangle> rectangleList;
		public String recString;
		private SpringLayout baseLayout;
		private GraphicController baseController;
		private ShapePanel shapePanel;
		private GraphPanel graphPanel;
		
		

		public DrawingPanel(GraphicController baseController)
		{
			this.baseController = baseController;
			baseLayout = new SpringLayout();
			rectangleList = new ArrayList<Rectangle>();
			
			drawRectangle = new JButton("Rectangle");
			drawCircle = new JButton("Circle");
			drawTriangle = new JButton("Triangle");
			shapePanel = new ShapePanel();
			graphPanel = new GraphPanel();
			drawEllipse = new JButton("Ellipse");
			clearButton = new JButton("clear");
			drawSquare = new JButton("Square");
			drawPolygon = new JButton("Polygon");
			
			clearRectangle = new JCheckBox("Clear");
			clearCircle = new JCheckBox("Clear");
			clearTriangle = new JCheckBox("Clear");
			clearEllipse = new JCheckBox("clear");
			clearSquare = new JCheckBox("Clear");
			clearPolygon = new JCheckBox("Clear");
			
			rectangleClear = false;
			cirlceClear = false;
			triangleClear =false;
			ellipseClear = false;
			squareClear = false;
			polygonClear = false;
			
			
			
			
			
			
			

			
			
			setupPanel();
			setupLayout();
			setupListeners();
			cleared();
		}
		private void setupPanel()
		{
			this.add(clearCircle);
			this.add(clearTriangle);
			this.add(clearRectangle );
			this.add(clearSquare);
			this.add(clearPolygon);
			this.add(clearEllipse);
			this.setBackground(Color.WHITE);
			this.add(drawSquare);
			this.add(drawPolygon);
			this.add(shapePanel);
			this.add(drawCircle);
			this.add(drawTriangle);
			this.add(drawRectangle );
			this.setLayout(baseLayout);
			
						
		}
		private void setupLayout()
		{
			baseLayout.putConstraint(SpringLayout.NORTH, clearPolygon, 0, SpringLayout.NORTH, clearCircle);
			baseLayout.putConstraint(SpringLayout.WEST, clearPolygon, 0, SpringLayout.WEST, drawPolygon);
			baseLayout.putConstraint(SpringLayout.NORTH, clearSquare, 0, SpringLayout.NORTH, clearCircle);
			baseLayout.putConstraint(SpringLayout.EAST, clearSquare, -32, SpringLayout.WEST, clearEllipse);
			baseLayout.putConstraint(SpringLayout.NORTH, clearEllipse, 0, SpringLayout.NORTH, clearCircle);
			baseLayout.putConstraint(SpringLayout.EAST, clearEllipse, -23, SpringLayout.WEST, clearCircle);
			
			baseLayout.putConstraint(SpringLayout.NORTH, clearTriangle, 0, SpringLayout.NORTH, clearCircle);
			baseLayout.putConstraint(SpringLayout.EAST, clearTriangle, 0, SpringLayout.EAST, shapePanel);
			baseLayout.putConstraint(SpringLayout.NORTH, clearCircle, 0, SpringLayout.NORTH, clearRectangle);
			baseLayout.putConstraint(SpringLayout.EAST, clearCircle, -30, SpringLayout.WEST, clearRectangle);
			
			baseLayout.putConstraint(SpringLayout.SOUTH, clearRectangle, -4, SpringLayout.NORTH, drawRectangle);
			baseLayout.putConstraint(SpringLayout.EAST, clearRectangle, -179, SpringLayout.EAST, this);
			baseLayout.putConstraint(SpringLayout.NORTH, clearButton, 19, SpringLayout.SOUTH, drawSquare);
			baseLayout.putConstraint(SpringLayout.EAST, clearButton, 0, SpringLayout.EAST, drawSquare);
			baseLayout.putConstraint(SpringLayout.NORTH, drawPolygon, 0, SpringLayout.NORTH, drawSquare);
			baseLayout.putConstraint(SpringLayout.EAST, drawPolygon, -3, SpringLayout.WEST, drawSquare);
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
					isCleared();
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
			drawPolygon.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent click)
				{ 
					shapePanel.addPolygon();
					repaint();
				}
				
			});	
			
			drawSquare.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent click)
				{ 
					shapePanel.addRectangle();
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
		public void cleared()
		{
			//rectangle
			if(clearRectangle.isSelected())
			{
				rectangleClear = true; //true
			}
			else
			{
				rectangleClear = false; //false
			}
			//circle
			if(clearCircle.isSelected())
			{
				cirlceClear = true; //true
			}
			else
			{
				cirlceClear = false; // false
			}
			//ellipse
			if(clearEllipse.isSelected())
			{
				ellipseClear = true; //true
			}
			else
			{
				ellipseClear = false; //false
			}
			//square
			if(clearSquare.isSelected())
			{
				squareClear = true; //true
			}
			else
			{
				squareClear = false;//false
			}
			//polygon
			if(clearPolygon.isSelected())
			{
				polygonClear = true;// true
			}
			else
			{
				polygonClear = false; //false
			}
			//triangle
			if(clearTriangle.isSelected())
			{
				triangleClear = true; //true
			}
			else
			{
				triangleClear = false ; //false
			}
			
			
		}
		public void isCleared()
		{
			cleared();
			shapePanel.clear(rectangleClear, cirlceClear, ellipseClear, squareClear, polygonClear, triangleClear);
		}
}
	

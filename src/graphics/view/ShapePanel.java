package graphics.view;

import graphics.controller.GraphicController;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Polygon;
import java.awt.Rectangle;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import java.awt.geom.RoundRectangle2D;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.SpringLayout;

public class ShapePanel extends JPanel
{
	private GraphicController baseController;
	private SpringLayout baseLayout;
private ArrayList<Rectangle> rectangleList; 
private ArrayList<Rectangle> squareList;
private ArrayList<Ellipse2D> circleList;
private ArrayList<Ellipse2D> ellipseList;
private ArrayList<Polygon> triangleList;
private ArrayList<Polygon> polygonList;


public ShapePanel()
{
	
	baseLayout = new SpringLayout();
	
	rectangleList = new ArrayList<Rectangle>();
	triangleList = new ArrayList<Polygon>();
	polygonList = new ArrayList<Polygon>();
	ellipseList = new ArrayList<Ellipse2D>();
	circleList = new ArrayList<Ellipse2D>();
	squareList = new ArrayList<Rectangle>();
	
	
	setUpPane();
	setUpPanel();
	setUpLayout();
	setUpListeners();
}
public void addCircle()
{
	int xPoint = (int) (Math.random()* 650);
	int yPoint = (int) (Math.random()* 500);
	int diameter = (int) (Math.random()* 100);
	Ellipse2D circle = new Ellipse2D.Double(xPoint, yPoint, diameter, diameter);
	ellipseList.add(circle);
	repaint();
}
public void addEllipse()
{
	int xPoint = (int) (Math.random()* 650);
	int yPoint = (int) (Math.random()* 500);
	int diameter = (int) (Math.random()* 100);
	int diameter2 = (int) (Math.random()* 100);
	Ellipse2D ellipse = new Ellipse2D.Double(xPoint, yPoint, diameter, diameter2);
	circleList.add(ellipse);
	repaint();
	
}
public void addTriangle()
{
	int [] xPoints = new int [3];
	int [] yPoints = new int [3];
	xPoints = new int []{(int)(Math.random() * 650), (int)(Math.random() * 650), (int)(Math.random() * 650)};
	yPoints = new int []{(int)(Math.random() * 500), (int)(Math.random() * 500), (int)(Math.random() * 500)};
	Polygon triangle = new Polygon(xPoints, yPoints, 3);
	triangleList.add(triangle);
}
public void addPolygon()
{
	int numberOfSides = (int)(Math.random()* 100) + 3;
	int [] xPoints = new int [numberOfSides];
	int [] yPoints = new int [numberOfSides];
	for(int sides = 0; sides < numberOfSides; sides++)
	{
		xPoints[sides] = (int) (Math.random()* 650);
		yPoints[sides] = (int) (Math.random()* 500);
	}
	Polygon myPolygon = new Polygon(xPoints, yPoints, numberOfSides);
	polygonList.add(myPolygon);
	repaint();
}
public void addRectangle()
{
	int xPosition = (int)(Math.random()* 650);
	int yPosition = (int) (Math.random()* 500);
	int width = (int) (Math.random()* 50);
	int height = (int) (Math.random()* 50);
	//Rectangle2D rectangle(xPosition, yPosition, width, height);
	
	rectangleList.add(new Rectangle(xPosition, yPosition, width, height));
	
	repaint();
}
public void addSquare()
{
	int xPosition = (int)(Math.random()* 650);
	int yPosition = (int) (Math.random()* 500);
	int width = (int) (Math.random()* 50);
	
	
	squareList.add(new Rectangle(xPosition, yPosition, width, width));
	repaint();
}
	
	

protected void paintComponent(Graphics currentGraphics)
{
	super.paintComponent(currentGraphics);
	Graphics2D mainGraphics =(Graphics2D) currentGraphics;
	//circle
	for(Ellipse2D circle : circleList)
	{
		int red = (int)(Math.random()* 256);
		int blue = (int)(Math.random()* 256);
		int green = (int)(Math.random()* 256);
		int pencilSize = (int) (Math.random()*15)+5;
		mainGraphics.setColor(new Color(red, green, blue));
		mainGraphics.setStroke(new BasicStroke(pencilSize));
		mainGraphics.draw(circle);
	}
	//triangle
	for(Polygon triangle : triangleList)
	{
		int red = (int)(Math.random()* 256);
		int blue = (int)(Math.random()* 256);
		int green = (int)(Math.random()* 256);
		int pencilSize = (int) (Math.random()*10)+5;
		mainGraphics.setColor(new Color(red, green, blue));
		mainGraphics.setStroke(new BasicStroke(pencilSize));
		mainGraphics.draw(triangle);
	}
	//polygon
	for(Polygon polygon : polygonList)
	{
		int red = (int)(Math.random()* 256);
		int blue = (int)(Math.random()* 256);
		int green = (int)(Math.random()* 256);
		int pencilSize = (int) (Math.random()*1)+5;
		mainGraphics.setColor(new Color(red, green, blue));
		mainGraphics.setStroke(new BasicStroke(pencilSize));
		mainGraphics.draw(polygon);
	}
	//ellipse
	for(Ellipse2D ellipse : ellipseList )
	{
		int red = (int)(Math.random()* 256);
		int blue = (int)(Math.random()* 256);
		int green = (int)(Math.random()* 256);
		int pencilSize = (int) (Math.random()*15)+5;
		mainGraphics.setColor(new Color(red, green, blue));
		mainGraphics.setStroke(new BasicStroke(pencilSize));
		mainGraphics.draw(ellipse);
	}
	//Rectangle
	for(Rectangle2D rectangle : rectangleList)
	{
		int red = (int)(Math.random()* 256);
		int blue = (int)(Math.random()* 256);
		int green = (int)(Math.random()* 256);
		int pencilSize = (int) (Math.random()*15)+5;
		mainGraphics.setColor(new Color(red, green, blue));
		mainGraphics.setStroke(new BasicStroke(pencilSize));
		mainGraphics.draw(rectangle);
	}
	//Square
	for(Rectangle2D square : squareList)
	{
		int red = (int)(Math.random()* 256);
		int blue = (int)(Math.random()* 256);
		int green = (int)(Math.random()* 256);
		int pencilSize = (int) (Math.random()*15)+5;
		mainGraphics.setColor(new Color(red, green, blue));
		mainGraphics.setStroke(new BasicStroke(pencilSize));
		mainGraphics.draw(square);
	}
}

public void clear(boolean rectangleClear, boolean cirlceClear, boolean ellipseClear, boolean squareClear, boolean polygonClear, boolean triangleClear)
{
	if(rectangleClear == true)
	{
		rectangleList.clear();
	}
	if(cirlceClear == true)
	{
		circleList.clear();
	}
	if(ellipseClear == true)
	{
		ellipseList.clear();
	}
	if(squareClear == true)
	{
		squareList.clear();
	}
	if(polygonClear == true)
	{
		polygonList.clear();
	}
	if(triangleClear == true)
	{
		triangleList.clear();
	}
		
}
private void setUpPane()
{
	
}


private void setUpPanel()
{
	
}


private void setUpLayout()
{
	
}

private void setUpListeners()
{
	
}
}


package graphics.view;

import graphics.controller.GraphicController;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Polygon;
import java.awt.Rectangle;
import java.awt.geom.Ellipse2D;
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
	int xPoint = (int) (Math.random()* 1000);
	int yPoint = (int) (Math.random()* 1000);
	int diameter = (int) (Math.random()* 100);
	
	Ellipse2D circle = new Ellipse2D.Double(xPoint, yPoint, diameter, diameter);
	circleList.add(circle);
	repaint();
}
public void addTriangle()
{
	int [] xPoints = new int [3];
	int [] yPoints = new int [3];
	xPoints = new int []{(int)(Math.random() * 500), (int)(Math.random() * 500), (int)(Math.random() * 500)};
	yPoints = new int []{(int)(Math.random() * 500), (int)(Math.random() * 500), (int)(Math.random() * 500)};
	Polygon triangle = new Polygon(xPoints, yPoints, 3);
	triangleList.add(triangle);
}
public void addPolygon()
{
	int numberOfSides = (int)(Math.random()* 101);
	int [] xPoints = new int [numberOfSides];
	int [] yPoints = new int [numberOfSides];
	for(int sides = 0; sides < numberOfSides; sides++)
	{
		xPoints[sides] = (int) (Math.random()* 300);
		yPoints[sides] = (int) (Math.random()* 300);
	}
	Polygon myPolygon = new Polygon(xPoints, yPoints, numberOfSides);
	polygonList.add(myPolygon);
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
		int pencilSize = (int) (Math.random()*15)+5;
		mainGraphics.setColor(new Color(red, green, blue));
		mainGraphics.setStroke(new BasicStroke(pencilSize));
		mainGraphics.draw(triangle);
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


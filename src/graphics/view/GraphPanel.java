package graphics.view;

import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.SpringLayout;
import java.util.ArrayList;
public class GraphPanel extends JPanel
{
	private SpringLayout baseLayout;
	private ArrayList<Integer> graphs;
	
	public GraphPanel()
	{
		baseLayout = new SpringLayout();
		ArrayList<Integer> graphs = new ArrayList<Integer>();
		setupGraph();
		setupPanel();
		setupLayout();
		setupListeners();
	}
	private void setupGraph()
	{
		graphs.add(5);
		graphs.add(10);
		graphs.add(3);
		graphs.add(5);
	}
	private void setupPanel()
	{
		this.setBackground(Color.GRAY);
		this.setLayout(baseLayout);
	}
	
	private void setupLayout()
	{
		
	}
	
	private void setupListeners()
	{
		
	}
}

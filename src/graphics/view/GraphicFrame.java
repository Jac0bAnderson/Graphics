package graphics.view;
import javax.swing.JFrame;
import graphics.controller.GraphicController;
public class GraphicFrame  extends JFrame
{
	private DrawingPanel basePanel;
	private GraphicController baseController;
	public GraphicFrame(GraphicController baseController)
	{
		this.baseController = baseController;
		basePanel = new DrawingPanel(baseController);
		setupFrame();
	
	}
	private void setupFrame()
	{
		this.setContentPane(basePanel);
		this.setSize(800, 800);
		this.setResizable(false);
		this.setTitle("But The Graphics");
		this.setVisible(true);
	}
}

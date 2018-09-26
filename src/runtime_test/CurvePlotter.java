package runtime_test;

import javax.swing.*;

import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;
import java.awt.*;
import java.awt.geom.Point2D;



public class CurvePlotter {
	JFrame frame;
	GraphicsPanel panel;
	
    //Float xLower, xUpper;
    //Float yLower, yUpper;
	int xWindowSize;
	int yWindowSize;
	int padding;
	int x0, y0, x1, y1;   // Coords of the panel
	
	/**
	 * Default constructor (size 1000x1000 with margin of 100)
	 * @param xLower x-axis lower-bound
	 * @param xUpper x-axis upper-bound
	 * @param yLower y-axis lower-bound
	 * @param yUpper y-axis upper-bound
	 * @param title  Title of chard
	 */
	public CurvePlotter(int xLower, int xUpper, int yLower, int yUpper, String title) {
		this(800, 800, 80, xLower, xUpper, yLower, yUpper, title);
	}
	
	/**
	 * Constructor: specify the Canvis size.
	 * @param xWindowSize  height of panel
	 * @param yWindowSize  width of panel
	 * @param padding  padding in panel
	 * @param xLower x-axis lower-bound
	 * @param xUpper x-axis upper-bound
	 * @param yLower y-axis lower-bound
	 * @param yUpper y-axis upper-bound
	 * @param title  Title of chard
	 */
	public CurvePlotter(int xWindowSize, int yWindowSize, int padding, 
						int xLower, int xUpper, 
						int yLower, int yUpper, String title) {
		
		frame = new JFrame("Plot");
        frame.getContentPane().setLayout(new BorderLayout());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       
        this.xWindowSize = xWindowSize;
        this.yWindowSize = yWindowSize;
        this.padding = padding;
        x0 = padding;
        y0 = padding;
        x1 = Math.min(xWindowSize, yWindowSize)-padding;
        y1 = x1;
        
        panel = new GraphicsPanel(new Integer(xLower), new Integer(xUpper), 
        						  new Integer(yLower), new Integer(yUpper),
        						  x0, y0, x1, y1, title);
		frame.getContentPane().add(panel, "Center");  
		frame.setSize(xWindowSize, yWindowSize);
		frame.setVisible(true);
	}
	
	
	public void add_point(int n, int f_n, String color) {
		add_point(new Point2D.Float((float)n, (float)f_n), color);
	}

		
	/**
	 * Add a point for plotting.
	 * @param n        x coordinate.
	 * @param fn       y coordinate.
	 * @param color    color of point.
	 */
	public void add_point(Point2D.Float point, String color) {
		
		Color c = Color.black;
		if (color == "red") 
			c = Color.red;
		else if (color == "blue")
			c = Color.blue;
		else if (color == "green")
			c = Color.green;
		else if (color == "yellow")
			c = Color.yellow;
		else if (color == "orange")
			c = Color.orange;
		else if (color == "cyan")
			c = Color.cyan;
		else if (color == "magenta")
			c = Color.magenta;
		else {
			System.err.println("add_points: Bad color (" + color + ")");
			System.exit(1);
		}
		
		panel.add_point(point, c);
	}
	
	public void draw() {	        
		panel.update(panel.getGraphics());
		//frame.pack();
	}
	
}



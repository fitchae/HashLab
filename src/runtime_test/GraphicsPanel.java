package runtime_test;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.font.FontRenderContext;
import java.awt.font.LineMetrics;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;

@SuppressWarnings("serial")
class GraphicsPanel extends JPanel {
	Integer xLower, xUpper;
    Integer yLower, yUpper;
    Integer dx, dy;
    Integer default_diam;
    
    int x0, y0, x1, y1;
    
    String title;
    String xTitle;
    String yTitle;
    
    List<Point2D.Float> point_list;
    List<Color> colors;
    
    GraphicsPanel(Integer xLower, Integer xUpper,
    		     Integer yLower, Integer yUpper,
    		     int x0, int y0, int x1, int y1,
    		     String title) {
    	this.xLower = xLower;
    	this.xUpper = xUpper;
    	this.yLower = yLower;
    	this.yUpper = yUpper;
    	this.x0 = x0;
    	this.y0 = y0;
    	this.x1 = x1;
    	this.y1 = y1;
    	dx = xUpper - xLower;
    	dy = yUpper - yLower;
    	    	
    	this.title = title;
    	xTitle = "n";
    	yTitle = "f(n)";
    	
    	point_list = new ArrayList<Point2D.Float>();
    	colors = new ArrayList<Color>();
    	
    }
    
    public void add_point(int x, int y, Color color) {
    	add_point(new Point2D.Float(new Float(x), new Float(y)), color);
    }
    
    public void add_point(float x, float y, Color color) {
    	add_point(new Point2D.Float(new Float(x), new Float(y)), color);
    }
       
    public <x_type, y_type> void add_point(x_type x, y_type y, Color color) {
    	Point2D.Float point = new Point2D.Float((float)x, (float)y);
    	add_point(point, color);
    }
    
 
    public void add_point(Point2D.Float point, Color color) {
    	point_list.add(point);
    	colors.add(color);
    }
    
    
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setPaint(Color.black);
        g2d.setStroke(new BasicStroke());
        g2d.setFont(new Font("Century Schoolbook", Font.PLAIN, 12));
        int diam = 8;
 
        drawCenteredString(g2d, title, (x0+x1)/2, 25, (float) 0.);
        drawCenteredString(g2d, xTitle, (x0+x1)/2, x1+25, (float) 0.);
        drawCenteredString(g2d, yTitle, 25, (y0+y1)/2, (float) -Math.PI / 2);
        drawCenteredString(g2d, xLower.toString(), x0, y1+25, (float) 0);
        drawCenteredString(g2d, xUpper.toString(), x1, y1+25, (float) 0);
        drawCenteredString(g2d, yLower.toString(), x0-25, y1, (float) 0);
        drawCenteredString(g2d, yUpper.toString(), x0-25, y0, (float) 0);
 
        g2d.setPaint(Color.gray);
        g2d.draw(new Line2D.Float(x0, y0, x0, y1));
        g2d.draw(new Line2D.Float(x0, y1, x1, y1));
 
        for (int j=0; j < point_list.size(); j++) {
        	Point2D.Float point = point_list.get(j);
        	Color c = colors.get(j);

        	g2d.setPaint(c);
	        Float ex = (x1-x0) * (point.x - xLower) / dx + x0;
	        ex -= diam / 2;
	        Float ey = -(y1-y0) * (point.y - yLower) / dy + y1;
	        ey -= diam / 2;
	        if (ex >= x0 && ex <= x1 && ey >= y0 && ey <= y1)
	        	g2d.fill(new Ellipse2D.Float(ex, ey, 8, 8));	            
        }
    }
 
 
    void drawCenteredString(Graphics2D g2d, String string,
                            int x0, int y0, float angle) {
        FontRenderContext frc = g2d.getFontRenderContext();
        Rectangle2D bounds = g2d.getFont().getStringBounds(string, frc);
        LineMetrics metrics = g2d.getFont().getLineMetrics(string, frc);
        if (angle == 0) {
            g2d.drawString(string, x0 - (float) bounds.getWidth() / 2,
                    y0 + metrics.getHeight() / 2);
        } else {
            g2d.rotate(angle, x0, y0);
            g2d.drawString(string, x0 - (float) bounds.getWidth() / 2,
                    y0 + metrics.getHeight() / 2);
            g2d.rotate(-angle, x0, y0);
        }
    }
}



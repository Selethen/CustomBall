import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class BouncingBall extends JPanel{
	
	private int X;
	private int Y;
	private int radius;
	
	private Color color;
	
	private int dx;
	private int dy;
	
	public BouncingBall(int X, int Y, int radius, int dx, int dy, int R, int G, int B) {
		this.X = X;
		this.Y = Y;
		this.radius = radius;
		this.dx=dx;
		this.dy=dy;
		this.color = new Color(R, G, B);
		
	}
	
	public void letsBounce() {
		Thread thread = new Thread() {
		      public void run() {
		    	  int width;
		    	  int height;
		    	  
		    	  while(true) {
		    		  width = getWidth();
		              height = getHeight();
		     
		              X = X + dx ;
		              Y = Y + dy;
		     
		              if (X - radius < 0) {
		                dx = -dx; 
		                X = radius; 
		              } else if (X + radius > width) {
		                dx = -dx;
		                X = width - radius;
		              }
		     
		              if (Y - radius < 0) {
		                dy = -dy;
		                Y = radius;
		              } else if (Y + radius > height) {
		                dy = -dy;
		                Y = height - radius;
		              }
		    		  
		    		  repaint();
		    		  
		    		  try {
			              Thread.sleep(10);
			          } catch (InterruptedException ex) {
			        	  ex.printStackTrace();
			          }  
		    	  }
		      }
		};
		thread.start();
	}
	
	public void paintComponent(Graphics g) {
	    super.paintComponent(g);
	    g.setColor(color);
	    g.fillOval((int)(X-radius), (int)(Y-radius), (int)radius*2, (int)radius*2);
	}
	
	public void setRadius(int radius) {
		this.radius = radius;
	}
	
	public void setColor(int r, int g, int b) {
		this.color = new Color(r, g, b);
	}
	
	public void setVelocity(int dx, int dy) {
		this.dx = dx;
		this.dy = dy;
	}
	
	public Color getColor() {
		return color;
	}
	
	public int getRadius() {
		return radius;
	}
	
	public int getXSpeed() {
		return dx;
	}
	
	public int getYSpeed() {
		return dy;
	}
	
}

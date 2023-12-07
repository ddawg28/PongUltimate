import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.geom.Ellipse2D;
import java.util.Random;

import javax.swing.Icon;
import javax.swing.JPanel;

public class Ball extends JPanel {
	int xPos;
	int yPos;
	int xVelocity = 4;
	int yVelocity = 4;
	Random random = new Random();
	
	public Ball(int xPos, int yPos) {
		this.xPos = xPos;
		this.yPos = yPos;
		this.setPreferredSize(new Dimension(20,20));
		this.setBounds(xPos, yPos, 20, 20);
	}
	
	public void move() {
		this.xPos += xVelocity;
		this.yPos += yVelocity;
		this.setBounds(xPos, yPos, 20, 20);
	}
	
	public void setXVelocity() {
		xVelocity *= -1;
		if (xVelocity < 0) {
			xVelocity -= random.nextInt(3);
		}
		if (xVelocity > 0) {
			xVelocity += random.nextInt(3);
		}
	}
	
	public void setYVelocity() {
		yVelocity *= -1;
		if (yVelocity < 0)
			yVelocity = (random.nextInt(5) + 2) * -1;
		if (yVelocity > 0)
			yVelocity = (random.nextInt(5) + 2);
	}
	
	protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        // Set the panel background color
        g.setColor(getBackground());
        g.fillOval(0, 0, 20, 20);
    }
	
	public void reset(int xPos, int yPos) {
		this.xPos = xPos;
		this.yPos = yPos;
		this.xVelocity = 4;
		this.yVelocity = 4;
		
		this.setBounds(xPos, yPos, 20, 20);
	}
	
	public int getXPos() {
		return xPos;
	}
	
	public void setXPos(int xPos) {
		this.xPos = xPos;
	}
	
	public int getYPos() {
		return yPos;
	}
}

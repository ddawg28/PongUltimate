import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.geom.Ellipse2D;

import javax.swing.Icon;
import javax.swing.JPanel;

public class Ball extends JPanel {
	int xPos;
	int yPos;
	int direction = 4;
	
	
	public Ball(int xPos, int yPos) {
		this.xPos = xPos;
		this.yPos = yPos;
		this.setPreferredSize(new Dimension(20,20));
		this.setBounds(xPos, yPos, 20, 20);
	}
	
	public void move() {
		this.xPos += direction;
		this.setBounds(xPos, yPos, 20, 20);
	}
	
	public void setDirection(int direction) {
		this.direction = direction;
	}
	
	protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        // Set the panel background color
        g.setColor(getBackground());
        g.fillOval(0, 0, 20, 20);
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

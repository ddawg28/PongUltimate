import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.KeyEvent;

import javax.swing.JPanel;

public class Paddle extends JPanel {
	int xPos;
	int yPos;
	int paddleNum;
	int paddleSpeed = 10;
	int paddleVelocity = 0;
	int width;
	int height;
	
	public Paddle(int xPos, int yPos, int width, int height, Color color, int paddleNum) {
		this.xPos = xPos;
		this.yPos = yPos;
		this.width = width;
		this.height = height;
		this.paddleNum = paddleNum;
		this.setPreferredSize(new Dimension(width, height));
		this.setBackground(color);
		this.setBounds(xPos, yPos, width, height);
		System.out.println("Paddle created");
	}
	
	public void keyPressed(KeyEvent e) {
		if(paddleNum == 1) {
			if(e.getKeyCode()==KeyEvent.VK_W) {
				System.out.println("Swag");
				setYDirection(-paddleSpeed);
//				yPos -= paddleVelocity;
//				System.out.println(yPos);
//				this.setBounds(xPos, yPos, width, height);
			}
			if(e.getKeyCode()==KeyEvent.VK_S) {
				setYDirection(paddleSpeed);
			}
		}
		if(paddleNum == 2) {
			if(e.getKeyCode()==KeyEvent.VK_UP) {
				setYDirection(-paddleSpeed);
//				yPos -= paddleVelocity;
//				System.out.println(yPos);
//				this.setBounds(xPos, yPos, width, height);
			}
			if(e.getKeyCode()==KeyEvent.VK_DOWN) {
				setYDirection(paddleSpeed);
			}
		}
	}
	
	public void keyReleased(KeyEvent e) {
		if(paddleNum == 1) {
			if(e.getKeyCode()==KeyEvent.VK_W) {
				setYDirection(0);
			}
			if(e.getKeyCode()==KeyEvent.VK_S) {
				setYDirection(0);
			}
		}
		if(paddleNum == 2) {
			if(e.getKeyCode()==KeyEvent.VK_UP) {
				setYDirection(0);
			}
			if(e.getKeyCode()==KeyEvent.VK_DOWN) {
				setYDirection(0);
			}
		}
	}
	
	public void setYDirection(int direction) {
		paddleVelocity = direction;
	}
	
	public void move() {
		yPos += paddleVelocity;
		this.setBounds(xPos, yPos, width, height);
		this.revalidate();
	}
	
	public int getXPos() {
		return xPos;
	}
	
	public int getYPos() {
		return yPos;
	}
}

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;

public class PongBoard extends JPanel implements Runnable {
	static final int PADDLE_WIDTH = 20;
	static final int PADDLE_HEIGHT = 100;
	static final int START_POS_X = 20;
	static final int START_POS_Y = 320;
	int paddle1Y = 320;
	int paddle2Y = 320;
	int playerOneScore = 0;
	int playerTwoScore = 0;
	
	Paddle paddle1 = new Paddle(START_POS_X, paddle1Y, PADDLE_WIDTH, PADDLE_HEIGHT, Color.blue, 1);
	Paddle paddle2 = new Paddle((1200 - (START_POS_X * 2)), START_POS_Y, PADDLE_WIDTH, PADDLE_HEIGHT, Color.blue, 2);
	Ball pongBall = new Ball(600, 350);
	Thread thread = new Thread(this);
	JPanel test = new JPanel();
	
	Graphics graphics;
	
	public PongBoard() {
		this.setPreferredSize(new Dimension(1200, 700));
		this.setBackground(Color.orange);
		
		this.add(paddle1);
		this.add(paddle2);
		this.add(pongBall);
		this.addKeyListener(new ActionListener());
		this.setFocusable(true);
		thread.start();
	}
	
	public class ActionListener extends KeyAdapter {
		public void keyPressed(KeyEvent e) {
			paddle1.keyPressed(e);
			paddle2.keyPressed(e);
		}
		public void keyReleased(KeyEvent e) {
			paddle1.keyReleased(e);
			paddle2.keyReleased(e);
		}
	}
	
	public void update(double dt) {
		System.out.println(dt);
	}
	
	public void checkForCollision() {
		if (pongBall.getBounds().intersects(paddle2.getBounds()) || pongBall.getBounds().intersects(paddle1.getBounds())) {
			pongBall.setXVelocity();
			System.out.println("Collision Detected");
		}
		if (pongBall.xPos > 1180 || pongBall.xPos < 0) {
			pongBall.reset(600,350);
		}
		if (pongBall.yPos > 680 || pongBall.yPos < 0) {
			pongBall.setYVelocity();
		}
	}

	public void run() {
		long lastTime = System.nanoTime();
		double amountOfTicks = 60.0;
		double ns = 1000000000 / amountOfTicks;
		double delta = 0;
		while (true) {
			long now = System.nanoTime();
			delta += (now -lastTime)/ns;
			lastTime = now;
			if (delta >= 1) {
				paddle1.move();
				paddle2.move();
				pongBall.move();
				repaint();
				System.out.println(pongBall.yVelocity);
				//pongBall.move();
				checkForCollision();
				delta--;
			}
		}
	}
}

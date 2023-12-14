import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JLabel;
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
	int collisionBuffer = 0;
	
	Paddle paddle1 = new Paddle(START_POS_X, paddle1Y, PADDLE_WIDTH, PADDLE_HEIGHT, Color.blue, 1);
	Paddle paddle2 = new Paddle((1200 - (START_POS_X * 2)), START_POS_Y, PADDLE_WIDTH, PADDLE_HEIGHT, Color.blue, 2);
	Ball pongBall = new Ball(600, 350);
	Thread thread = new Thread(this);
	JPanel test = new JPanel();
	Score score = new Score(560, 20);
	String imagePath;
	Integer winner = 0;
	
	
	Graphics graphics;
	
	public PongBoard(String imagePath) {
		this.setPreferredSize(new Dimension(1200, 700));
		ImagePanel background = new ImagePanel(imagePath);
		this.imagePath = imagePath;
		background.setPreferredSize(new Dimension(1200,700));
		background.setBounds(0,0,1200,700);
		this.setBackground(Color.orange);
		
		
		this.add(paddle1);
		this.add(paddle2);
		this.add(pongBall);
		this.add(score);
		this.add(background);
		
		this.addKeyListener(new ActionListener());
		this.setFocusable(true);
		thread.start();
	}
	
	public void winnerScreen(Integer player) {
		thread.interrupt();
		JLabel winnerLabel = new JLabel("Player " + player + " Wins! ");
		winnerLabel.setBounds(400,100,600,70);
		winnerLabel.setFont(new Font("Dialog", Font.PLAIN, 60));
		
		this.add(winnerLabel);
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
		if (collisionBuffer >= 4) {
			if (pongBall.getBounds().intersects(paddle2.getBounds()) || pongBall.getBounds().intersects(paddle1.getBounds())) {
				pongBall.setXVelocity(); 
				System.out.println("Collision Detected");
				collisionBuffer = 0;
			}
			if (pongBall.xPos >= 1180) {
				score.scored(1);
				winner = score.checkWinner();
				if (winner == 1) {
					this.removeAll();
					winnerScreen(1);
				}
				pongBall.reset(600,350);
				collisionBuffer = 0;
			}
			if (pongBall.xPos <= 0) {
				score.scored(2);
				winner = score.checkWinner();
				if (winner == 2) {
					this.removeAll();
					winnerScreen(2);
				}
				pongBall.reset(600,350);
				pongBall.setXVelocity();
				pongBall.setYVelocity();
				collisionBuffer = 0;
			}
			if (pongBall.yPos >= 680) {
				pongBall.yPos = 680;
				pongBall.setYVelocity();
				collisionBuffer = 0;
			}
			if (pongBall.yPos <= 0) {
				pongBall.yPos = 0;
				pongBall.setYVelocity();
			}
		}
		if (paddle1.yPos <= 0) {
			paddle1.yPos = 0;
		}
		if (paddle2.yPos <= 0) {
			paddle2.yPos = 0;
		}
		if (paddle1.yPos >= (700 - PADDLE_HEIGHT)) {
			paddle1.yPos = (700 - PADDLE_HEIGHT);
		}
		if (paddle2.yPos >= (700 - PADDLE_HEIGHT)) {
			paddle2.yPos = (700 - PADDLE_HEIGHT);
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
				checkForCollision();
				collisionBuffer++;
				delta--;
			}
		}
	}
}

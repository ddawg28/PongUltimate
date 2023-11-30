import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;


public class Driver {
	public static void main(String[] args) {
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setPreferredSize(new Dimension(1200,700));
		
		JPanel ball = new JPanel();
		ball.setPreferredSize(new Dimension(20,20));
		ball.setBackground(Color.green);
		ball.setBounds(600,350,20,20);
		
		JPanel paddlePlayerOne = new JPanel();
		paddlePlayerOne.setBackground(Color.black);
		paddlePlayerOne.setPreferredSize(new Dimension(20,200));
		paddlePlayerOne.setBounds(100, 200, 20, 200);
		
		JPanel paddlePlayerTwo = new JPanel();
		paddlePlayerTwo.setBackground(Color.red);
		paddlePlayerTwo.setPreferredSize(new Dimension(20,200));
		paddlePlayerTwo.setBounds(1100, 200, 20, 200);
		
		// Left side positioning (X, Y, Width, Height)
		//searchLabel.setBounds(60,10,60,20);
		
		
		frame.add(panel);
		panel.add(paddlePlayerOne);
		panel.add(paddlePlayerTwo);
		panel.add(ball);
		frame.pack();
		frame.getContentPane();
		frame.setVisible(true);
	}
}

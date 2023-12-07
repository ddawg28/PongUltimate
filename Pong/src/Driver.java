import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;


public class Driver {
	public static void main(String[] args) {
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		PongBoard board = new PongBoard();
		board.setLayout(null);
		board.setPreferredSize(new Dimension(1200,700));
		
		
		frame.add(board);
		frame.setResizable(false);
		frame.setTitle("Pong Ultimate");
		frame.pack();
		frame.getContentPane();
		frame.setVisible(true);
		frame.setLocationRelativeTo(null);
	}
}

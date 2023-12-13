import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class Driver {
	public static void main(String[] args) {
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//PongBoard board = new PongBoard();
		//board.setLayout(null);
		//board.setPreferredSize(new Dimension(1200,700));
		
		// -----------------------------
		// Title Screen
		// -----------------------------
		
		JPanel mainMenu = new JPanel();
		mainMenu.setPreferredSize(new Dimension(1200, 700));
		mainMenu.setLayout(null);
		
		String imagePath = "background2.jpg";
		ImagePanel background = new ImagePanel(imagePath);
		background.setBackground(Color.white);
		background.setPreferredSize(new Dimension(1200,700));
		background.setBounds(0,0,1200,700);
		
		JLabel title = new JLabel();
		title.setText("Pong Ultimate");
		title.setFont(new Font("Monospaced", Font.PLAIN, 60));
		title.setForeground(Color.white);
		title.setBounds(370,100, 600, 70);
		
		// -----------------------------
		// Level Select Screen
		// -----------------------------
		
		JPanel selectScreen = new JPanel();
		selectScreen.setPreferredSize(new Dimension(1200, 700));
		selectScreen.setLayout(null);
		
		String imagePath2 = "background4.jpg";
		ImagePanel background2 = new ImagePanel(imagePath2);
		background2.setPreferredSize(new Dimension(1200,700));
		background2.setBounds(0,0,1200,700);
		
		JLabel selectTitle = new JLabel();
		selectTitle.setText("Select Level");
		selectTitle.setFont(new Font("Monospaced", Font.PLAIN, 40));
		selectTitle.setBounds(450,60, 600, 70);
		selectTitle.setForeground(Color.white);
		
		JPanel defaultLevel = new JPanel();
		defaultLevel.setPreferredSize(new Dimension(200, 150));
		defaultLevel.setBackground(Color.orange);
		defaultLevel.setBounds(225, 200, 200, 150);
		defaultLevel.addMouseListener(new MouseListener() {
			public void mouseClicked(MouseEvent e) {
				frame.remove(selectScreen);
				PongBoard board = new PongBoard();
				board.setLayout(null);
				board.requestFocus();
				board.revalidate();
				frame.add(board);
				frame.revalidate();
				frame.repaint();
			}
			// Filler methods to avoid error
			public void mousePressed(MouseEvent e) {
			}
			public void mouseReleased(MouseEvent e) {
			}
			public void mouseEntered(MouseEvent e) {
			}
			public void mouseExited(MouseEvent e) {
			}
		});
		
		JPanel fillerLevel1 = new JPanel();
		fillerLevel1.setPreferredSize(new Dimension(200, 150));
		fillerLevel1.setBackground(Color.orange);
		fillerLevel1.setBounds(500, 200, 200, 150);
		
		JPanel fillerLevel2 = new JPanel();
		fillerLevel2.setPreferredSize(new Dimension(200, 150));
		fillerLevel2.setBackground(Color.orange);
		fillerLevel2.setBounds(775, 200, 200, 150);
		
		JPanel fillerLevel3 = new JPanel();
		fillerLevel3.setPreferredSize(new Dimension(200, 150));
		fillerLevel3.setBackground(Color.orange);
		fillerLevel3.setBounds(225, 400, 200, 150);
		
		JPanel fillerLevel4 = new JPanel();
		fillerLevel4.setPreferredSize(new Dimension(200, 150));
		fillerLevel4.setBackground(Color.orange);
		fillerLevel4.setBounds(500, 400, 200, 150);
		
		JPanel fillerLevel5 = new JPanel();
		fillerLevel5.setPreferredSize(new Dimension(200, 150));
		fillerLevel5.setBackground(Color.orange);
		fillerLevel5.setBounds(775, 400, 200, 150);
		
		// Buttons
		JButton playButton = new JButton("Play Game");
		playButton.setPreferredSize(new Dimension(200, 50));
		playButton.setBounds(500, 300, 200,50);
		playButton.addActionListener(e -> {
			frame.remove(mainMenu);
			frame.add(selectScreen);
			frame.revalidate();
			frame.repaint();
		});
		
//		String buttonImagePath = "playButton3.jpg";
//		ImagePanel playButtonImage = new ImagePanel(buttonImagePath);
//		playButtonImage.setPreferredSize(new Dimension(200,200));
//		playButtonImage.setBounds(200,200,100,100);
		
		mainMenu.add(title);
		mainMenu.add(playButton);
		//mainMenu.add(playButtonImage);
		mainMenu.add(background);
		
		selectScreen.add(selectTitle);
		selectScreen.add(defaultLevel);
		selectScreen.add(fillerLevel1);
		selectScreen.add(fillerLevel2);
		selectScreen.add(fillerLevel3);
		selectScreen.add(fillerLevel4);
		selectScreen.add(fillerLevel5);
		selectScreen.add(background2);
		
		
		frame.add(mainMenu);
		//frame.add(board);
		frame.setResizable(false);
		frame.setTitle("Pong Ultimate");
		frame.pack();
		frame.getContentPane();
		frame.setVisible(true);
		frame.setLocationRelativeTo(null);
	}
	
	
}

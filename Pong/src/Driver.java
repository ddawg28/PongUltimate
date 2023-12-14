import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.sound.sampled.*;

public class Driver {
	public static void main(String[] args) {
		File track = new File("menuTrack.wav");
		AudioInputStream audioStreamGlobal;
		try {
			audioStreamGlobal = AudioSystem.getAudioInputStream(track);
			Clip clip = AudioSystem.getClip();
			clip.open(audioStreamGlobal);
			clip.start();
		} catch (UnsupportedAudioFileException | IOException | LineUnavailableException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
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
		
		ImagePanel defaultLevel = new ImagePanel("defaultLevel.jpg");
		defaultLevel.setPreferredSize(new Dimension(200, 150));
		defaultLevel.setBackground(Color.orange);
		defaultLevel.setBounds(225, 200, 200, 150);
		defaultLevel.addMouseListener(new MouseListener() {
			public void mouseClicked(MouseEvent e) {
				File blip = new File("blip.wav");
				AudioInputStream audioStream;
				try {
					audioStream = AudioSystem.getAudioInputStream(blip);
					Clip clip = AudioSystem.getClip();
					clip.open(audioStream);
					clip.start();
				} catch (UnsupportedAudioFileException | IOException | LineUnavailableException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				frame.remove(selectScreen);
				PongBoard board = new PongBoard("defaultLevel.jpg");
				board.setLayout(null);
				frame.add(board);
				board.requestFocusInWindow();
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
		
		ImagePanel tennisPanel = new ImagePanel("tennisLevel.png");
		tennisPanel.setPreferredSize(new Dimension(200, 150));
		tennisPanel.setBackground(Color.orange);
		tennisPanel.setBounds(500, 200, 200, 150);
		tennisPanel.addMouseListener(new MouseListener() {
			public void mouseClicked(MouseEvent e) {
				File blip = new File("blip.wav");
				AudioInputStream audioStream;
				try {
					audioStream = AudioSystem.getAudioInputStream(blip);
					Clip clip = AudioSystem.getClip();
					clip.open(audioStream);
					clip.start();
				} catch (UnsupportedAudioFileException | IOException | LineUnavailableException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				frame.remove(selectScreen);
				PongBoard board = new PongBoard("tennisLevel.png");
				board.setLayout(null);
				frame.add(board);
				board.requestFocusInWindow();
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
			File blip = new File("blip.wav");
			AudioInputStream audioStream;
			try {
				audioStream = AudioSystem.getAudioInputStream(blip);
				Clip clip = AudioSystem.getClip();
				clip.open(audioStream);
				clip.start();
			} catch (UnsupportedAudioFileException | IOException | LineUnavailableException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			frame.remove(mainMenu);
			frame.add(selectScreen);
			frame.revalidate();
			frame.repaint();
		});
		
		mainMenu.add(title);
		mainMenu.add(playButton);
		mainMenu.add(background);
		
		selectScreen.add(selectTitle);
		selectScreen.add(defaultLevel);
		selectScreen.add(tennisPanel);
		selectScreen.add(fillerLevel2);
		selectScreen.add(fillerLevel3);
		selectScreen.add(fillerLevel4);
		selectScreen.add(fillerLevel5);
		selectScreen.add(background2);
		
		frame.add(mainMenu);
		frame.setResizable(false);
		frame.setTitle("Pong Ultimate");
		frame.pack();
		frame.getContentPane();
		frame.setVisible(true);
		frame.setLocationRelativeTo(null);
	}
}

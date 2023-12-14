import java.awt.Color;
import java.awt.Font;
import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.JLabel;

public class Score extends JLabel {
	Integer playerOneScore = 0;
	Integer playerTwoScore = 0;
	Integer lastScored;
	Integer maxScore = 3;
	
	public Score(int xPos, int yPos) {
		super.setText(playerOneScore.toString() + " " + playerTwoScore.toString());
		super.setFont(new Font("Dialog", Font.PLAIN, 60));
		super.setForeground(Color.WHITE);
		this.setBounds(xPos, yPos, 200, 50);
	}
	
	public void scored(int player) {
		File cheer = new File("cheer.wav");
		AudioInputStream audioStream;
		try {
			audioStream = AudioSystem.getAudioInputStream(cheer);
			Clip clip = AudioSystem.getClip();
			clip.open(audioStream);
			clip.start();
		} catch (UnsupportedAudioFileException | IOException | LineUnavailableException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		if (player == 1) {
			playerOneScore += 1;
			
		} else if (player == 2) {
			playerTwoScore += 1;
			
		}
		this.setText(playerOneScore.toString() + " " + playerTwoScore.toString());
	}
	
	public Integer checkWinner() {
		Integer winner = 0;
		if (playerOneScore >= maxScore) {
			winner = 1;
		} else if (playerTwoScore >= maxScore) {
			winner = 2;
		}
		
		return winner;
	}
}

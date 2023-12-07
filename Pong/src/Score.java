import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;

public class Score extends JLabel {
	Integer playerOneScore = 0;
	Integer playerTwoScore = 0;
	Integer lastScored;
	
	public Score(int xPos, int yPos) {
		super.setText(playerOneScore.toString() + " " + playerTwoScore.toString());
		super.setFont(new Font("Dialog", Font.PLAIN, 60));
		super.setForeground(Color.WHITE);
		this.setBounds(xPos, yPos, 200, 50);
	}
	
	public void scored(int player) {
		if (player == 1) {
			playerOneScore += 1;
			
		} else if (player == 2) {
			playerTwoScore += 1;
			
		}
		this.setText(playerOneScore.toString() + " " + playerTwoScore.toString());
	}
}

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.geom.Ellipse2D;
import java.io.File;
import java.io.IOException;
import java.util.Random;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.Icon;
import javax.swing.JPanel;

public class Ball extends JPanel {
	int xPos;
	int yPos;
	int xVelocity = 4;
	int yVelocity = 4;
	Random random = new Random();
	
	public Ball(int xPos, int yPos) {
		this.xPos = xPos;
		this.yPos = yPos;
		this.setPreferredSize(new Dimension(20,20));
		this.setBounds(xPos, yPos, 20, 20);
	}
	
	public void move() {
		this.xPos += xVelocity;
		this.yPos += yVelocity;
		this.setBounds(xPos, yPos, 20, 20);
	}
	
	public void setXVelocity() {
		File blip = new File("one_beep.wav");
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
		
		xVelocity *= -1;
		if (xVelocity < 0) {
			xVelocity -= (random.nextInt(4) + 1);
		}
		if (xVelocity > 0) {
			xVelocity += (random.nextInt(4) + 1);
		}
	}
	
	public void setYVelocity() {
		File blip = new File("one_beep.wav");
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
		
		yVelocity *= -1;
		if (yVelocity < 0)
			yVelocity = (random.nextInt(7) + 2) * -1;
		if (yVelocity > 0)
			yVelocity = (random.nextInt(7) + 2);
	}
	
	public void reset(int xPos, int yPos) {
		this.xPos = xPos;
		this.yPos = yPos;
		this.xVelocity = 4;
		this.yVelocity = 4;
		
		this.setBounds(xPos, yPos, 20, 20);
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

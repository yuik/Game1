package sysD_game;

import java.awt.Container;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;

public class MainFrame implements KeyListener{
	int FRAME_WIDTH = 500;
	int FRAME_HEIGHT = 500;
	MainPanel p1;
	// Flag for pressed keys
	boolean left = false;
	boolean right = false;
	boolean up = false;
	boolean down = false;
	
	public MainFrame() {
		JFrame frame = new JFrame();
		frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
		frame.setTitle("Game Test");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		p1 = new MainPanel();
		// Defeasance layout manager
		p1.setLayout(null);
		p1.drawCharacter();
		
		Container content = frame.getContentPane();
		content.add(p1);

		p1.letsGetMovin();
		frame.addKeyListener(this);
		
		// For Mac this must be stated after adding panels to the frame
		frame.setVisible(true);
	}
	

	private void startMovin() {
		p1.letsGetMovin();
	}

	public void keyPressed(KeyEvent e) {
		int keyCode = e.getKeyCode();
		
		if (keyCode == KeyEvent.VK_LEFT) {
			left = true;
		}		
		if (keyCode == KeyEvent.VK_RIGHT) {
			right = true;
		}
		if (keyCode == KeyEvent.VK_UP) {
			up = true;
		}
		if (keyCode == KeyEvent.VK_DOWN) {
			down = true;
		}
		
		if (left == true && up == true) {
			p1.chara.goLeftUp();
		} else if (left == true && down == true) {
			p1.chara.goLeftDown();
		} else if (right == true && up == true) {
			p1.chara.goRightUp();
		} else if (right == true && down == true) {
			p1.chara.goRightDown();
		} else if (left == true) {
			p1.chara.goLeft();
		} else if (right == true) {
			p1.chara.goRight();
		} else if (up == true) {
			p1.chara.goUp();
		} else if (down == true) {
			p1.chara.goDown();
		}
	}
	
	public void keyReleased(KeyEvent e) {
		int keyCode = e.getKeyCode();
		
		if (keyCode == KeyEvent.VK_LEFT) {
			left = false;
		}		
		if (keyCode == KeyEvent.VK_RIGHT) {
			right = false;
		}
		if (keyCode == KeyEvent.VK_UP) {
			up = false;
		}
		if (keyCode == KeyEvent.VK_DOWN) {
			down = false;
		}
	}
	
	public void keyTyped(KeyEvent e) {
		
	}
	
}
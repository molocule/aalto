package claudsGame;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyInput extends KeyAdapter{ 
	
	private Handle handle;
	
	// make methods that are part of KeyAdapter
	
	public KeyInput(Handle handle) {
		this.handle = handle;
	}
	
	
	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();
		//System.out.println("You typed" + key); 
		
		 for (int i = 0; i < handle.object.size(); i++) {
			// loop through all the objects to find player
			GameObject tempObject = handle.object.get(i);
			
			
			if (tempObject.getId() == ID.Player) {
				// the keys to press that will do something for enemy
				if (key == KeyEvent.VK_UP) tempObject.setvy(-5);
				if (key == KeyEvent.VK_DOWN) tempObject.setvy(5);
				if (key == KeyEvent.VK_LEFT) tempObject.setvx(-5);
				if (key == KeyEvent.VK_RIGHT) tempObject.setvx(5);
			}
		}
		
	}
	
	public void keyReleased(KeyEvent e) {
		int key = e.getKeyCode();
		
		for (int i = 0; i < handle.object.size(); i++) {
			// loop through all the objects to find player
			GameObject tempObject = handle.object.get(i);
			
			if (tempObject.getId() == ID.Player) {
				// the keys to press that will do something for Player
				if (key == KeyEvent.VK_UP) tempObject.setvy(0);
				if (key == KeyEvent.VK_DOWN) tempObject.setvy(0);
				if (key == KeyEvent.VK_LEFT) tempObject.setvx(0);
				if (key == KeyEvent.VK_RIGHT) tempObject.setvx(0);
			}
			

		}
		
		if (key == KeyEvent.VK_ESCAPE) System.exit(1);
	} 

}


/*
 * Player 2 code
 * 
 * PRESSED
 * 			if (tempObject.getId() == ID.Player2) {
				// the keys to press that will do something for Player
				
				if (key == KeyEvent.VK_W) tempObject.setvy(-5);
				if (key == KeyEvent.VK_S) tempObject.setvy(5);
				if (key == KeyEvent.VK_D) tempObject.setvx(5);
				if (key == KeyEvent.VK_A) tempObject.setvx(-5);
			}
 * 
 * 
 *RELEASED
 * 			if (tempObject.getId() == ID.Player2) {
				// the keys to press that will do something for enemy

				if (key == KeyEvent.VK_W) tempObject.setvy(0);
				if (key == KeyEvent.VK_S) tempObject.setvy(0);
				if (key == KeyEvent.VK_D) tempObject.setvx(0);
				if (key == KeyEvent.VK_A) tempObject.setvx(0);
			}
 */

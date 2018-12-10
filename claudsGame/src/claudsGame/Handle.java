package claudsGame;

import java.awt.Graphics;
import java.util.LinkedList;

// since we have multiple objects
// we can just make a class to maintain
// and render all of the objects
// in the game
// This handler class will loop through all objects
// to individually render them and stuff

public class Handle {
	
	// this is the linkedlist !
	// it is a collection
	LinkedList<GameObject> object = new LinkedList<GameObject>();
	/*
	 * this is one of the core concepts that I am 
	 * implementing in my project
	 */
	
	public void tick() {
		for (int i = 0; i < object.size(); i++) {
			// typical for list 
			// the tick is just for every instant
			GameObject tempObject = object.get(i);
			// function within linkedlist
			// get ID of what object we are at
			// will iterate through the entire list
			
			tempObject.tick();
		}
	}
	
	public void render (Graphics g) {
		// do the same thing with graphics
		for (int i = 0; i<object.size(); i++) {
			// render every object in the list
			GameObject tempObject = object.get(i);
			tempObject.render(g);
		}
	}
	
	public void addObject(GameObject object) {
		// add an object
		this.object.add(object);
		// very easy for LinkedList. 
	}
	
	public void removeObject(GameObject object) {
		// to add is to need to remove
		this.object.remove(object);
	}
	
	public void clear() {
		// to clear off all enemies
		for (int i = 0; i<object.size(); i++) {
			// render every object in the list
			GameObject tempObject = object.get(i);
			if(tempObject.getId() != ID.Player) {
				this.removeObject(tempObject);
				// we need to shorten index by 1
				i--;
			}
		}
	}
}

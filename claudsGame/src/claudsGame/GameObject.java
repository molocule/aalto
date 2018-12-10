package claudsGame;

import java.awt.Graphics;
import java.awt.Rectangle;

/*
 * All objects in the game 
 * that inherit functions in the game
 * will be game objects
 */

public abstract class GameObject {
	// note that this is an abstract class
	// it will extend functions of the game
	//2D array
	
	
	protected float x, y;
	
	// we need a way to ID players vs enemies vs etc.
	// we will do this in the ID enum
	protected ID id;
	protected float vx, vy;
	// meaning velocity in x dir and y dir
	
	public GameObject(float x, float y, ID id) {
		this.x = x;
		this.y = y;
		this.id = id;

	}

	public abstract Rectangle getBounds();
	public abstract void tick();
	public abstract void render (Graphics g);
	
	/*
	 * for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[0].length; j++) {
				if (map[i][j] > 0) {
					// if value is correct
					// create particular brick inside particular position
					g.setColor(Color.BLACK);
					g.fillRect(j*brickWidth + 80, i*brickHeight + 50, brickWidth, brickHeight);
				
					// make borders between the bricks
					g.setStroke(new BasicStroke(5));
					g.setColor(Color.GRAY);
					g.drawRect(j*brickWidth + 80, i*brickHeight + 50, brickWidth, brickHeight);
					
				}
					
				
			}
		}
	 */
	
	// set everything for x position and velocity
	
	public void setx(float x) {
		this.x = x;
	}
	
	public float getx() {
		return x;
	}
	
	public void setvx(float vx) {
		this.vx = vx;
	}
	
	public float getvx() {
		return vx;
	}
	
	// now we do the same for y dir
	public void sety(float y) {
		this.y = y;
	}
	
	public float gety() {
		return y;
	}
	
	public void setvy(float vy) {
		this.vy = vy;
	}
	
	public float getvy() {
		return vy;
	}
	
	public void setId(ID id) {
		this.id = id;
	}

	public ID getId() {
		return id;
	}
	
	
}

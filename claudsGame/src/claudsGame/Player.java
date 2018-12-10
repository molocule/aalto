package claudsGame;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Player extends GameObject{

	private Handle handle;
	// so this class, Player, extends Gameobj
	/*
	 * what this does is that it creates some object in
	 * the game, in this case, it makes players
	 * which are just game objects
	 * they take on all atributes described by game object
	 * as described in game object class
	 * and wow, this is really the beauty of object 
	 * oriented programming, and at times like these you stop
	 * and you think, this is pretty neat
	 * we just saved so much time and typing because player class
	 * extends the game object class and yeah
	 */
	
	public Player(int x, int y, ID id, Handle handle) {
		super (x, y, id);
		this.handle = handle;
				
	}
	
	public void tick() {
		x += vx;
		x = Game.restrict(x, 0, Game.W - 37);
		y += vy;
		y = Game.restrict(y, 0, Game.H - 60);
		
		collide();
		
	}
	
	
	
	
	public Rectangle getBounds() {
		return new Rectangle( (int)x, (int)y, 32, 32);
	}
	
	private void collide() {
		for(int i=0; i<handle.object.size(); i++) {
			GameObject tempObject = handle.object.get(i);
			 
			// code for collisions
			if (tempObject.getId() == ID.Enemy1 || 
					tempObject.getId() == ID.Enemy2 ||
					tempObject.getId() == ID.Enemy3
					) {
				if (getBounds().intersects(tempObject.getBounds())) {
					HUD.health -= 2;
				}
			}
		}
	}
	
	
	//HELP
	public float getx() {
		return x;
	}
	
	
	public float gety() {
		return y;
	}
	
	public void render (Graphics g) {
		//if (id == ID.Player) 
		
		g.setColor(Color.PINK);
		g.fillRect((int) x, (int) y, 32, 32);
		
		/*
		 * Test to see whether the boundaries work
		 * This is really important for collisions
		 * UNCOMMENT THE FOLLOWING CODE TO SEE THE 
		 * collision box:
		 * 
		 * Graphics2D gg = (Graphics2D) g;
		 * g.setColor(Color.CYAN);
		 * gg.draw(getBounds());
		 */
		
	}
	


}

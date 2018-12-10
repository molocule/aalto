package claudsGame;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Enemy1 extends GameObject{
	
	private Handle handle;
	
	public Enemy1(int x, int y, ID id, Handle handle) {
		super (x, y, id);
		vx = 8;
		vy = 8;
		this.handle = handle;
	}

	
	public void tick() {
		
		handle.addObject(new Trail((int) x, (int) y, ID.Trail, Color.RED, handle, 16, 16, 0.05f));
		
		x += vx;
		y += vy;
		
		if (y <= 0 || y >= Game.H - 32) vy = -vy; 
		if (x <= 0 || x >= Game.W - 32) vx = -vx; 
		
		
		
	}
	
	public void render (Graphics g) {
		g.setColor(Color.RED);
		g.fillRect((int) x, (int)  y, 16, 16);
	}
	
	public Rectangle getBounds() {
		return new Rectangle((int) x, (int) y, 16, 16);
	}
}

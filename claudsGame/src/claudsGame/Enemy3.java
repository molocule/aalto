package claudsGame;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Enemy3 extends GameObject{
	// this enemy will follow you around!
	
	private Handle handle;
	
	private GameObject player;
	
	public Enemy3(int x, int y, ID id, Handle handle) {
		super (x, y, id);
		this.handle = handle;
		
		for(int i = 0; i < handle.object.size(); i++) {
			if (handle.object.get(i).getId() == ID.Player) 
				player =  handle.object.get(i);
		}
	}

	
	public void tick() {
		
		handle.addObject(new Trail(x, y, ID.Trail, Color.BLUE, handle, 16, 16, 0.05f));
		
		float dx = -8 + x - player.getx();
		float dy = -8 +  y - player.gety();
		
		float dist = (float) Math.sqrt((x - player.getx()) * (x - player.getx()) 
				+ (y - player.gety())*(y - player.gety()) );
		
		vx = (float) ((-1/dist) * dx);  
		vy = (float) ((-1/dist) * dy); 
		
		x += vx;
		y += vy;
		
		if (y <= 0 || y >= Game.H - 32) vy = -vy; 
		if (x <= 0 || x >= Game.W - 32) vx = -vx; 
		
		
		
	}
	
	public void render (Graphics g) {
		g.setColor(Color.BLUE);
		g.fillRect((int) x, (int) y, 16, 16);
	}
	
	public Rectangle getBounds() {
		return new Rectangle((int) x, (int) y, 16, 16);
	}
}

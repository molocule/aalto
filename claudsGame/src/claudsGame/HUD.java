package claudsGame;

import java.awt.Color;
import java.awt.Graphics;

public class HUD {
	// health bar
	
	public static float health = 100;
	
	private Color healthCol = Color.GREEN;
	
	private int score = 0;
	
	private int level = 1;
	
	public void tick() {
		
		health  = Game.restrict(health, 0, 100);
		
		if (health <= 20 ) {
			// do the thing in video games where
			// if you're close to dying the health
			// bar turns red
			healthCol = (Color.RED);
		}
		
		score++;
		
	}
	
	public void setScore(int score) {
		this.score = score;
	}
	
	public int getScore() {
		return score;
	}
	
	public void setLevel(int level) {
		this.level = level;
	}
	
	public int getLevel() {
		return level;
	}
	
	public void render(Graphics g) {
		
		// background
		g.setColor(Color.GRAY);
		g.fillRect(15, 15, 200, 32);
		
		// health status
		g.setColor(healthCol);
		g.fillRect(15, 15, (int) health*2, 32);

		// border
		g.setColor(Color.DARK_GRAY);
		g.drawRect(15, 15, 200, 32);
		
		// draw score and draw level
		g.setColor(Color.WHITE);
		g.drawString("Your Score: " + score, 15, 64);
		g.drawString("Your Level: " + level, 15, 80);

		
	}

}

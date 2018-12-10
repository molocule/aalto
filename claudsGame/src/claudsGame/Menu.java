package claudsGame;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Menu extends MouseAdapter{
	
	private Game game;
	private Handle handle;
	
	public Menu(Game game, Handle handle) {
		this.game = game;
		this.handle = handle;
	}
	
	private boolean mouseOver(int mx, int my, int x, int y, int w, int h) {
		if (mx > x && mx < x+w) {
			return (my > y && my < y +h); 
		}
		else {
			return false;
		}
	}
	
	public void mousePressed(MouseEvent e) {
		int mx = e.getX();
		int my = e.getY();
		
		if (mouseOver(mx, my, 210, 150, 200, 64)) {
			  game.gameStat = Game.status.Menu;
			  //HELP
			
		}
		//if mouseOver(mx, my, 210, 150, 200, 64) {
		//	this.handle = handle;
			
			//game.gameStat = status.Game;
		//}
	}
	
	
	public void mouseReleased(MouseEvent e) {
		
		
	}
	
	public void tick() {
		
	}
	
	public void render(Graphics g) {
		
		Font f = new Font("sans serif", 1, 50);
		g.setFont(f);
		g.setColor(Color.WHITE);
		
		g.drawString("Menu", 240, 70);
		g.drawRect(210, 150, 200, 64);
		
		
		g.drawString("Play", 270, 190);
		g.drawRect(210, 250, 200, 64);
		
		
		g.drawString("Instructions", 240, 290);
		g.drawRect(210, 350, 200, 64);
		
		g.drawString("Quit", 270, 390);
		
	}


}

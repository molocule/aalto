package claudsGame;

import java.util.Random;

public class Regen {
	
	/*
	 * this is the class to spawn more whatevers
	 * 
	 */

	private HUD hud;	
	private Handle handle;
	// note that this scoring is different from score
	// it will be used to track what level we are on 
	private int scoring = 0;
	
	public Regen(Handle handle, HUD hud) {
		this.handle = handle;
		this.hud = hud;
	}
	
	public void tick() {
		
		scoring++;

		 if(scoring >= 200) {
			hud.setLevel(hud.getLevel() + 1);
			scoring = 0;
			Random r = new Random();
			
			
			
			//introduce enemies for every level
			

			
			if (hud.getLevel() == 2) {
				// n represents number of enemies I want to make
				handle.clear();
				int n1 =2;
				for (int i = 0; i < n1; i++) {
				 //for creating multiple enemies
				handle.addObject(new Enemy1(r.nextInt(Game.W - 50)+1, r.nextInt(Game.H - 50)+1, ID.Enemy1, handle));
				}
			}
			
			if (hud.getLevel() == 3) {
			handle.addObject(new Enemy2(r.nextInt(Game.W)+1, r.nextInt(Game.H)+1, ID.Enemy2, handle));
			}
			
			if (hud.getLevel() == 4) {
				handle.clear();
				handle.addObject(new Enemy2(r.nextInt(Game.W)+1, r.nextInt(Game.H)+1, ID.Enemy2, handle));
				handle.addObject(new Enemy2(r.nextInt(Game.W)+1, r.nextInt(Game.H)+1, ID.Enemy2, handle));
				}
			
			if (hud.getLevel() == 5) { 
				handle.clear();
			handle.addObject(new Enemy3(r.nextInt(Game.W)+1, r.nextInt(Game.H)+1, ID.Enemy3, handle));
			}
			
			if (hud.getLevel() == 6) { 
				handle.addObject(new Enemy3(r.nextInt(Game.W)+1, r.nextInt(Game.H)+1, ID.Enemy3, handle));
				handle.addObject(new Enemy3(r.nextInt(Game.W)+1, r.nextInt(Game.H)+1, ID.Enemy3, handle));
				handle.addObject(new Enemy3(r.nextInt(Game.W)+1, r.nextInt(Game.H)+1, ID.Enemy3, handle));
				}
		}
		// make a score board
		//
		//for (int i = 0; i < getNumberOfEnemies(); i++) {
		// for creating multiple enemies
		//handle.addObject(new Enemy1(r.nextInt(W - 50)+1, r.nextInt(H - 50)+1, ID.Enemy1, handle));
		//}
	}

}

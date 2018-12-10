package claudsGame;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.util.Random;

public class Game extends Canvas implements Runnable{
	
	/**
	 * Welcome to Claudia's Game!
	 */
	private static final long serialVersionUID = 1L;
	// required for game
	
	public enum status {
		Menu,
		Instructions,
		Game,
		End
	};
	
	//ADD GAME STATES HERE
	private Menu menu;
	
	
	public status gameStat = status.Game;
	
	public static final int W = 640, H = 480; // 3/4 of W;
	// set width and height for the game
	public Thread thread;
	// the entire game will run in this thread
	// this might not be the best idea for a really
	// complex game, but as long as we check for 
	// errors in this thread, we are fine since this
	// is a more simple game
	
	private boolean run = false;
	// don't start the game immediately 
	
	private HUD hud;
	
	private Handle handle;
	// create handle variable *private*
	private Regen regen;
	
	private int numberOfEnemies = 1;
	
	public Game() {
		// THIS IS THE GAME CLASS 

		// create new handle function for handling object
		// Game objects as linked list
		handle = new Handle();
		/*
		 * note that this handle class is above the window class
		 * this is because sometimes when I ran it in the opposite 
		 * order, I would get a null pointer exception because, 
		 * I think, the game did not recognize that I actually had a game
		 * so then the window didn't really know what to do
		 * This then subsequently resulted in an error. 
		 */
		this.addKeyListener(new KeyInput(handle));
		hud = new HUD();
		// these are some pretty key stuff, so we need to add newer stuff
		// that I want to implement in the game below

		
		// ADD NEW STUFF HERE
		
		regen = new Regen(handle, hud);
		
		//
		
		//ADD GAME STATES HERE
		gameStat = status.Game;
		
		
		//
		
		// creates new window to see the game 
		new Window(W, H, "Claudia's Game", this);
		
		// make a key listener!
		
		
		if (gameStat == status.Game) {
			Random r = new Random();
		handle.addObject(new Player(W/2 - 32, H/2-32, ID.Player, handle));
		handle.addObject(new Enemy1(r.nextInt(Game.W - 50)+1, r.nextInt(Game.H - 50)+1, ID.Enemy1, handle));

		
		//for (int i = 0; i < getNumberOfEnemies(); i++) {
		// for creating multiple enemies
			//Random r = new Random();
		//handle.addObject(new Enemy1(r.nextInt(W - 50)+1, r.nextInt(H - 50)+1, ID.Enemy1, handle));
		//}
		}
		//handle.addObject(new Player(100, 100, ID.Player));
		// add an object to linkedList to display
		
	}
	
	public synchronized void start() {
		// start thread, start game
		thread = new Thread(this);
		thread.start(); 
		run = true;
		// start the game!! ^
		
	}
	
	public synchronized void stop() {
		// we want to catch any errors, if something
		// happens, let's find it early on
		try {
			thread.join();
			run = false;
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void run() {
		// following line found on internet to avoid clicking to start
		this.requestFocus();
		// this is the game loop
		// this is a pretty popular game loop 
		// because it works well
		
		// so after reading some stuff, this is what 
		// I think it does:
		
		/*
		 * We need a loop that does two things: 
		 * First is that it checks whether enough time has passed 
		 * in ms to refresh the game (discrete vs continuous)
		 * and second, whether enough time has passed (1 sec) to 
		 * refresh the frames per second counter
		 * so we use this gameloop
		 */
		long timer = System.currentTimeMillis();
		double ticks = 60.0;
		double ns = 1000000000 / ticks;
		int frames = 0;
		long lastTime = System.nanoTime();
		double delta = 0;
		while (run) { 
			long now = System.nanoTime();
			delta += (now - lastTime)/ns;
			lastTime = now;
			while (delta >= 1) {
				tick();
				delta -- ;
				
			}
			if (run) {
				render();
				frames++;
			}
			
			if (System.currentTimeMillis() - timer > 1000) {
				timer += 1000;
				// System.out.println("Frames per second: " + frames);
				frames = 0;
			}

		}
		stop();
		
	}
	
	private void tick() {
		// here we just make sure that each of the classes we made 
		// also goes along as we go along!
		
		handle.tick();
		
		if (gameStat == status.Game) {
		hud.tick();
		regen.tick();
		}
		
		else if(gameStat == status.Menu) {
			menu.tick();
		}
		
	}
	
	public static float restrict(float x, float min, float max) {
		// helper function to make sure that players can't move
		// of the screen
		if (x >= max) 
			return x = max;
		else if (x <= min)
			return x = min;
		else 
			return (float) x;
	}
	
	private void render() {
		BufferStrategy bust = this.getBufferStrategy();
		if (bust == null) {
			this.createBufferStrategy(3);
			// this reduces the frames per second, makes 
			// it something that's more in my range
			return;
		}
		Graphics g = bust.getDrawGraphics();
		
		// this is just a test to see whether we can
		// make our window and to see if it does anything
		g.setColor(Color.BLACK);
		// this is to test to see if the code was executed
		g.fillRect(0, 0, W, H);
		// GUHHH who knew that there are layers!! <- not I
		// in order to have the game objects over the background
		// it is important to list it in order! 
		// WHAT A STRUGGLE 
		
		
		handle.render(g);
		//display HUD after game things, don't go in the corner! you're 
		// gonna get blocked!
		
		if (gameStat == status.Game) {
		hud.render(g);
		
		// display all objects contained in handle on the game
		}
		else if(gameStat == status.Menu) {
			menu.render(g);
		}
		
		g.dispose();
		bust.show();

	}
	
	public static void main(String args[]) {
		new Game();
		
	}

	public int getNumberOfEnemies() {
		return numberOfEnemies;
	}

	public void setNumberOfEnemies(int numberOfEnemies) {
		this.numberOfEnemies = numberOfEnemies;
	}
}

package claudsGame;

import java.awt.Canvas;
import java.awt.Dimension;

import javax.swing.JFrame;

public class Window extends Canvas{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Window(int width, int height, String title, Game game) {
		JFrame frame = new JFrame(title);
		// this creates the JFrame that is basically the visual 
		// of the entire game
		// all of the following frame.XXX will refer to this JFrame
		// and they are all basically setting various attributes of 
		// this JFrame
		
		frame.setPreferredSize(new Dimension(width, height));
		// this sets the preferred or default size 
		// below we set the Min/Max size, which is just the same
		frame.setMaximumSize(new Dimension(width, height));
		frame.setMinimumSize(new Dimension(width, height));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// HELP frame.setDefaultCloseOperation(Game.run == false);
		// this is important as it closes the game and game 
		// operations upon exiting out of the JFrame or window
		frame.setResizable(false);
		// we need to set resizable to false otherwise it will 
		// become pretty difficult to work with and 
		// especially with people who try edge cases and weird
		// dimmensions (guilty)
		frame.setLocationRelativeTo(null);
		// nah. So I believe this will set specific things 
		// relative to parts of your screen, for example, if you
		// toggle perspective mode on your iPhone or whatever
		// we don't need this, we aren't that aesthetic for this game
		frame.add(game);
		// this is really important. If we don't have this, then there 
		// would be no game in this window LOL and then what would
		// be the point?
		frame.setVisible(true);
		// This is important (some people need it some don't, not really
		// sure why) but it makes everything visible
		game.start();
		// lez start
		
		
	}
	

}

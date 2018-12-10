package claudsGame;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

public class Trail extends GameObject{
	
	private Handle handle;
	private Color color;
	private float a = 1;
	private int w;
	private int h;
	private float lyfe;
	
	// life = 0.001 - 0.1
	
	public Trail(float x, float y, ID id, Color color, Handle handle, int w, int h, float lyfe) {
		super(x, y, id);
		this.handle = handle;
		this.color = color;
		this.w = w;
		this.h = h;
		this.lyfe = lyfe;
		
	}
	
	private AlphaComposite transparent(float a) {
		int style = AlphaComposite.SRC_OVER;
		return(AlphaComposite.getInstance(style, a));
	}

	@Override
	public Rectangle getBounds() {
		// TODO Auto-generated method stub
		return null;
		// no need for this one. 
	}

	@Override
	public void tick() {
		if (a > lyfe) {
			a -= lyfe - 0.0001f;
			
		}
		
		else {
			handle.removeObject(this);
		}
		
	}

	@Override
	public void render(Graphics g) {
		Graphics2D gd = (Graphics2D) g;
		gd.setComposite(transparent(a));
		// these are the transparent squares
		g.setColor(color);
		g.fillRect((int) x, (int) y, w, h);
		
		gd.setComposite(transparent(1));
		
	}
	
	

}

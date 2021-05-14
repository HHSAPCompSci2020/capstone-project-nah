package Enemy;

import actor.Actor;
import processing.core.PApplet;

import java.awt.Color;
import java.util.ArrayList;

import Projectile.Projectile;

public abstract class Enemy extends Actor{

	private int MAX_HP, angle;
	private boolean isRotate;
	/**
	 * @author Michael
	 */
	public Enemy() {
		super();
	}
	
	/**
	 * 
	 * @param hp starting hp of the actor
	 * @param x x coord
	 * @param y y coord
	 * @author Michael
	 */
	public Enemy(int hp, double x, double y) {
		super(hp, x, y, 0, 0);
		MAX_HP = hp;
	//	setFill(Color.BLACK);
	}
	
	/**A drawing surface that will set a random color of the shape.
	 * @param surface The surface PApplet draws on.
	 * @author Michael
	 */
	public void draw(PApplet marker) {
		super.draw(marker);
		updateColor();//?????
//		marker.push();
		marker.circle((float)getX(),(float)getY(),(float)(getRadius()));
//		marker.pop();
	}
	
	/**
	 * indicates action of the actor in 1 frame
	 * @author Nont & Michael
	 */
	public void act(ArrayList<Actor> actors, PApplet surface, int time) {
		super.act(actors, surface, time);
		moveAround(time);
		
		for(int a = 0; a < actors.size(); a++) {
			if(intersects(actors.get(a))) {
				if(!(actors.get(a) instanceof Projectile) && !(actors.get(a) == this)) {
//					bounce();
//					setBounce(true);
					actors.get(a).bounce(this);
				}
				continue;
			}
			else {
//				setBounce(false);
			}
		
		}
	}
	
	public abstract void moveAround(int time);
	
	/**
	 * Update color based on hp
	 */
	public void updateColor() {
		setFill(new Color(255*((getHp()-MAX_HP)/MAX_HP)));
	}
	
}

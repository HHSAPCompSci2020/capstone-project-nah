package actor;

import java.awt.Color;
import java.util.ArrayList;

import Enemy.Enemy;
import Projectile.Projectile;
import Reactable.Wall;
import processing.core.PApplet;

public class Player extends Actor{
	
	private static int hp = 10;
	private double friction;
	
	public Player() {
		super();
	}
	
	/**
	 * 
	 * @param x x coord
	 * @param y y coord
	 * @author Michael
	 */
	public Player(double x, double y) {
		super(hp, x, y, 0, 0);
		setFill(new Color(233, 205, 76));
		friction = 0.75;
		setRadius(30);
	}
	

	/**A drawing surface that will set a random color of the shape.
	 * @param surface The surface PApplet draws on.
	 * @author Nont & Michael
	 */
	public void draw(PApplet marker) {
        super.draw(marker);
        marker.circle((float)getX(),(float)getY(),(float)(getRadius()));
        marker.push();
        marker.translate((float)getX(), (float)getY());
        marker.rotate((float) getDir());
        marker.rect(0, -3, 30, 5, 5);
        marker.pop();

    }
	
	/**
	 * indicates action of the actor in 1 frame
	 * @author Michael
	 */
	public void act(ArrayList<Actor> actors, PApplet surface, int time) {
		super.act(actors, surface, time);
		setvx(getvx()*friction);
		setvy(getvy()*friction);
		
		for(Actor a : actors) {
			if(intersects(a)) {
				if(!(a instanceof Projectile) && !(a == this) && !(a instanceof Wall)) {
					if(a.getvx()!=0 || a.getvy()!=0) {
						setvx(-a.getvx());
						setvy(-a.getvy());
					}else {
						bounce(a);
						setBounce(true);
					}
				}
				continue;
			}
			else {
				setBounce(false);
			}
		}
		
	}

	
	
	
	
	
	
	
	
}

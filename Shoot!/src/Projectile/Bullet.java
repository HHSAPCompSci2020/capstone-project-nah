package Projectile;

import java.awt.Color;
import java.util.ArrayList;

import Enemy.Enemy;
import actor.Actor;
import actor.Player;
import processing.core.PApplet;

public class Bullet extends Projectile{

	private static int hp = 1;
	private static double MAXSPEED;
	
	/**
	 * Bullet class default constructor
	 * @author Michael
	 * 
	 */
	public Bullet() {
		super();
	}
	
	/**
	 * Bullet class constructor for enemies
	 * @author Michael
	 * @param x x coord
	 * @param y y coord
	 * @param vx x speed
	 * @param vy y speed
	 * 
	 */
	public Bullet(double x, double y, double vx, double vy) {
		super(hp, x, y, vx, vy);
		super.setSpeed(2);
		setFill(new Color(153, 70, 57));
		setRadius(25);
	}

	/**
	 * make bullet move
	 * check if it hits other actors
	 * @author Michael
	 * 
	 */
	public void act(ArrayList<Actor> other, PApplet surface, int time) {
		super.act(other, surface, time);
		
		for(int a = 0; a < other.size(); a++) {
			if(intersects(other.get(a))) {
				if(other.get(a) instanceof Player) {
					setHp(getHp()-1);
					other.get(a).setHp(other.get(a).getHp()-1);
				}
				continue;
			}
		
		}
	}
	
	public void actProjectile(ArrayList<Actor> other, PApplet surface, int time) {
		super.act(other, surface, time);
	}

	
	
	/**
	 * Draw the bullets
	 * @author Nont
	 */
	public void draw(PApplet marker) {
		super.draw(marker);
		marker.circle((float)getX(),(float)getY(),(float)(getRadius()));
	}
	

}
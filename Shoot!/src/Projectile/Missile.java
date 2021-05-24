package Projectile;

import java.awt.Color;
import java.util.ArrayList;

import actor.Actor;
import processing.core.PApplet;

public class Missile extends PlayerBullet {
	
	private static int hp = 1;
	private double dir = 0;
//	public Missile() {
//		super();
//	}
	
	public Missile(double x, double y, double vx, double vy) {
		super(x, y, vx, vy, true);
		super.setSpeed(3);
		setFill(new Color(153, 70, 57));
		setRadius(25);
	}

//	public Missile(double x, double y, double vx, double vy) {
//		super(hp, x, y, vx, vy);
//		super.setSpeed(5);
//		setFill(new Color(153, 70, 57));
//		setRadius(20);
//	}
//	
//	public Missile(double x, double y, double vx, double vy, boolean ignorePlayer) {
//		super(hp, x, y, vx, vy, ignorePlayer);
//		super.setSpeed(15);
//		setRadius(5);
//	}
	
	public void act(ArrayList<Actor> other, PApplet surface, int time) {
		super.moveTowards(surface.mouseX, surface.mouseY);
		super.act(other, surface, time);
		
	}
	
	/**
	 * Draw the missile
	 * @author Nont
	 */
	public void draw(PApplet marker) {
		//super.draw(marker);
		float xDist = (float) (1.01*getRadius()*Math.sin(25.0*Math.PI/180)/Math.tan(50.0*Math.PI/180));
		float yDist = (float) (1.01*getRadius()*Math.sin(25.0*Math.PI/180));
		marker.push();
		turnToward(marker.mouseX, marker.mouseY);
		marker.translate((float)getX(), (float)getY());
		marker.rotate((float) dir);
		marker.triangle((float) (getRadius()), 0, -xDist, -yDist, -xDist, yDist);
		marker.pop();
	}
	
	public void turnToward(int x, int y) {
		dir = Math.atan(((double)getY()-y)/(getX()-x));
		if (getX() > x)
			dir += Math.PI;
	}
}

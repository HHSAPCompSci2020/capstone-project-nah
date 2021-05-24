package Projectile;

import java.awt.Color;
import java.util.ArrayList;

import Enemy.Enemy;
import actor.Actor;
import actor.Player;
import processing.core.PApplet;

public abstract class Projectile extends Actor{

	private boolean ignorePlayer;
	private double speed;
	
	public Projectile() {
		super();
	}
	
	/**
	 * 
	 * @param hp starting hp
	 * @param x x coord
	 * @param y y coord
	 * @param vx starting x velocity
	 * @param vy starting y velocity
	 * @author Michael
	 */
	public Projectile(int hp, double x, double y, double vx, double vy) {
		super(hp, x, y , vx, vy);
	//	setFill(Color.YELLOW);
	}
	
	/**
	 * Projectile class constructor for player
	 * @author Michael
	 * @param x x coord
	 * @param y y coord
	 * @param vx x speed
	 * @param vy y speed
	 * 
	 */
	public Projectile(int hp, double x, double y, double vx, double vy, boolean ignorePlayer) {
		super(hp, x, y, vx, vy);
		this.ignorePlayer = ignorePlayer;
		setFill(Color.YELLOW);
	}
	
	/**
	 * set x coord
	 * @author Nont
	 */
	public void setX(double x) {
		super.setX(x);
	}
	
	/**
	 * set y coord
	 * @author Nont
	 */
	public void setY(double y) {
		super.setY(y);
	}
	
	/**
	 * get x coord
	 * @author Nont
	 */
	public double getX() {
		return super.getX();
	}
	
	/**
	 * get y coord
	 * @author Nont
	 */
	public double getY() {
		return super.getY();
	}
	

	/**
	 * Bounce bullet, and -1 hp at the same time.
	 * @author Michael
	 */
	public boolean bounceX() {
		setvx(-getvx());
		setHp(getHp()-1);
		return true;
	}
	
	public boolean bounceY() {
		setvy(-getvy());
		setHp(getHp()-1);
		return true;
	}
	
	public boolean bounce() {
		setvx(-getvx());
		setvy(-getvy());
		setHp(getHp()-1);
		return true;
	}
	
	
	public void bounceOffWindow(PApplet surface) {
		if(getX() < getRadius()/2 || getX() > surface.displayWidth - getRadius()/2) {
			bounceX();
		}else if(getY() < getRadius()/2 || getY() > surface.displayHeight - getRadius()/2) {
			bounceY();
		}
	}
	
	
	
	/**
	 * set velocity towards target coordinate
	 * @author Nont
	 * @param x2 x coord of target
	 * @param y2 y coord of target
	 */
	public void moveTowards(double x2, double y2) {
		double angle = Math.atan((y2-getY())/(x2-getX()));
		if (x2-getX() < 0) {
				setvx(-speed*Math.cos(angle));
				setvy(-speed*Math.sin(angle));

		}else {
				setvx(speed*Math.cos(angle));
				setvy(speed*Math.sin(angle));
		}
	}
	
	/**
	 * setter for speed
	 * @param speed speed of projectile
	 */
	public void setSpeed(double speed) {
		this.speed = speed;
	}
	
	/**
	 * getter for speed
	 * @return speed of projectile
	 */
	public double getSpeed() {
		return speed;
	}
	
	public boolean getIgnore() {
		return ignorePlayer;
	}
	
	public void setIgnorePlayer(boolean a) {
		ignorePlayer = a;
	}
}

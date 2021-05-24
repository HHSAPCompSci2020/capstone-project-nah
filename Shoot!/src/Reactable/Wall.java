package Reactable;

import java.awt.Color;
import java.awt.Rectangle;
import java.util.ArrayList;

import Projectile.PlayerBullet;
import Projectile.Projectile;
import actor.Actor;
import actor.Player;
import processing.core.PApplet;

public class Wall extends Actor{

	private double width;
	private double height;
	
	public Wall() {
		super();
	}
	
	/**
	 * 
	 * @param x x coord
	 * @param y y coord
	 * @param width width of the rect
	 * @param height height of the rect
	 * @author Michael
	 */
	public Wall(int x, int y, double width, double height) {
		super(1, x, y, 0, 0);
		this.width = width;
		this.height = height;
		setFill(Color.black);
		setInvincible(true);
	}
	
	/**
	 *  @param surface The surface PApplet draws on.
	 *  @author Michael
	 */
	public void draw(PApplet marker) {
		super.draw(marker);
		marker.rect((float)(getX()),(float)(getY()),(float)width, (float)height);
	}
	
	/**
	 * indicates action of the actor in 1 frame
	 * @author Nont & Michael
	 */
	public void act(ArrayList<Actor> actors, PApplet surface, int time) {
		super.act(actors, surface, time);
		
		for(int a = 0; a < actors.size(); a++) {
			if(intersects(actors.get(a))) {
				if(!(actors.get(a) == this)) {
					bounceOnWall(actors.get(a));
					if(actors.get(a) instanceof Projectile) {
						actors.get(a).setHp(actors.get(a).getHp()-1);
					}
				}
				continue;
			}
		}
	}
	
	
	public boolean intersects(Actor other) {
//		if(((other.getX()+other.getRadius()/2) >= (this.getX()-width/2)) && 
//			((other.getX()-other.getRadius()/2) <= (this.getX()+width/2)) && 
//			((other.getY()+other.getRadius()/2) >= (this.getY()-height/2)) && 
//			((other.getY()-other.getRadius()/2) <= (this.getY()+height/2))){
		Rectangle bounds = new Rectangle((int)(getX()),(int)(getY()),(int)width, (int)height);
		if(bounds.contains(other.getX(), other.getY())) {
			return true;
		}else {
			return false;	
		}
	}
	
	
	public void bounceOnWall(Actor other) {
		if(width>height) {	//horizontal wall
			if(getX() < other.getX() && getX()+width > other.getX()) {
				other.setvy(-other.getvy());
			}
		}else {	//vertical wall
			if(getY() < other.getY() && getY()+height > other.getY()) {
				other.setvx(-other.getvx());
			}
		}
	}
}

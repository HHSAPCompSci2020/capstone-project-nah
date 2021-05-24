package actor;

import java.awt.Color;
import java.util.ArrayList;

import Projectile.Projectile;
import Surfaces.DrawingSurface;
import processing.core.PApplet;


public abstract class Actor {	
	
	//field
	private int hp, strokeWidth;
	private double x, y, vx, vy, radius, dir, ax, ay;
	private Color strokeColor, fillColor;
	private boolean filled, isBouncing, invincible;
	private int windowWidth, windowHeight;
	
	/**
	 * Initialize actor with default values
	 * @author Michael
	 */
	public Actor() {
		hp = -1;
		x = 0;
		y = 0;
		vx = 0;
		vy = 0;
		ax = 0;
		ay = 0;
		radius = 0;
		dir = 0;
		filled = false;
		invincible = false;
	}
	
	/**
	 * Initialize actor with parameter values
	 * 
	 * @param hp Hitpoint
	 * @param x x-coordinate
	 * @param y y-coordinate
	 * @param vx velocity in x axis
	 * @param vy velocity in y axis
	 * @author Michael
	 */
	public Actor(int hp, double x, double y, double vx, double vy) {
		this.hp = hp;
		this.x = x;
		this.y = y;
		this.vx = vx;
		this.vy = vy;
		ax = 0;
		ay = 0;
		radius = 0;
		dir = 0;
		strokeColor = Color.BLACK;
		filled = true;
		fillColor = Color.WHITE;
		strokeWidth = 1;
		invincible = false;
	}
	
	
	/**
	 * indicates action of the actor in 1 frame
	 * @author Michael
	 */
	public void act(ArrayList<Actor> actors, PApplet surface, int time) { //physical behavior
		double x = getX();
		double y = getY();
		x += vx;
		y += vy;
		setX(x);
		setY(y);
		
		bounceOffWindow(surface);

	}


	/**
	 * bounces off object when hit
	 * @author Michael
	 */
	public boolean bounce(Actor other) {
//		vx = -1.5*vx;
//		x += vx;
//		vy = -1.5*vy;
//		y += vy;
//		
//		return true;

		double angle = getAngle(other);
		if(angle == 0 || angle == 360) {
//			if(vx == 0) {
//				vx = 2;
//			}else {
//				vx = -vx;
//			}
			vx = -vx;
			x += vx;
		}else if(angle>0 && angle<90) {
//			if(vx == 0) {
//				vx = -2;
//			}else {
//				vx = -vx;
//			}
			vx = -vx;
			x += vx;
//			if(vy == 0) {
//				vy = 2;
//			}else {
//				vy = -vy;
//			}
			vy = -vy;
			y += vy;
		}else if(angle == 90) {
//			if(vy == 0) {
//				vy = -2;
//			}else {
//				vy = -vy;
//			}
			vy = -vy;
			y += vy;
		}else if(angle>90 && angle<180) {
//			if(vx == 0) {
//				vx = 2;
//			}else {
//				vx = -vx;
//			}
			vx = -vx;
			x += vx;
//			if(vy == 0) {
//				vy = 2;
//			}else {
//				vy = -vy;
//			}
			vy = -vy;
			y += vy;
		}else if(angle == 180) {
//			if(vx == 0) {
//				vx = -2;
//			}else {
//				vx = -vx;
//			}
			vx = -vx;
			x += vx;
		}else if(angle>180 && angle<270) {	
//			if(vx == 0) {
//				vx = -2;
//			}else {
//				vx = -vx;
//			}
			vx = -vx;
			x += vx;
//			if(vy == 0) {
//				vy = 2;
//			}else {
//				vy = -vy;
//			}
			vy = -vy;
			y += vy;
		}else if(angle == 270) {
//			if(vy == 0) {
//				vy = 2;
//			}else {
//				vy = -vy;
//			}
			vy = -vy;
			y += vy;
		}else if(angle>270 && angle <360) {
//			if(vx == 0) {
//				vx = 2;
//			}else {
//				vx = -vx;
//			}
			vx = -vx;
			x += vx;
//			if(vy == 0) {
//				vy = 2;
//			}else {
//				vy = -vy;
//			}
			vy = -vy;
			y += vy;
		}
		
		return true;
	}
	
	
	public double getAngle(Actor other) {
	    double angle = Math.toDegrees(Math.atan2(other.getY() - y, other.getX() - x));

	    if(angle < 0){
	        angle += 360;
	    }

	    return angle;
	}
	
	
	/**
	 * bounces off window when hit to prevent getting out of the grid
	 * @author Michael
	 */
	public void bounceOffWindow(PApplet surface) {
//		if(x <= getRadius()/2 || y <= getRadius()/2 || x >= surface.displayWidth - getRadius()/2 || y >= surface.displayHeight - getRadius()/2) {
//			bounce();
//		}
		
		
		//x
		if(x < getRadius()/2 || x > surface.width - getRadius()/2) {
			vx = -vx;
			x += vx;
		}
		//y
		if(y < getRadius()/2 || y > surface.height - getRadius()/2) {
			vy = -vy;
			y += vy;
		}
//		
//		if(!((x>=this.getX()) && (x<=(this.getX()+surface.displayWidth)) && (y>=this.getY()) && (y<=(this.getY()+surface.displayHeight)))) {
//			if(this instanceof Projectile) {
//				bounce(null);
//			}
//		}
		
		
	}

	/**
	 * To get if the actor isBouncing
	 * @return isBouncing
	 * @author Nont
	 */
	public boolean getBounce() {
		return isBouncing;
	}
	
	/**
	 * To set the bouncing state
	 * @param newBounce
	 * @author Nont
	 */
	public void setBounce(boolean newBounce) {
		isBouncing = newBounce;
	}
	
	/**
	 * To get the HP of a actor
	 * @return hp
	 * @author Michael
	 */
	public int getHp() {
		return hp;
	}
	
	/**
	 * To set a new HP for a actor
	 * @param newHp
	 * @author Michael
	 */
	public void setHp(int newHp) {
		hp = newHp;
	}
	
	/**Return the x-coordinate of the shape.
	 * 
	 * @return x-coordinate.
	 * @author Michael
	 */
	public double getX() {
		return x;
	}
	
	/**Return the y-coordinate of the shape.
	 * 
	 * @return y-coordinate.
	 * @author Michael
	 */
	public double getY() {
		return y;
	}
	
	/**Set the x-coordinate as x.
	 * 
	 * @param x the new x-coordinate.
	 * @post Side affect: The x-coordinate changes to x.
	 * @author Michael
	 */
	public void setX(double x) {
		this.x = x;
	}
	
	/**Set the y-coordinate as y.
	 * 
	 * @param y the new y-coordinate.
	 * @post Side affect: The y-coordinate changes to y.
	 * @author Michael
	 */
	public void setY(double y) {
		this.y = y;
	}
	
	/**Set the stroke color.
	 * 
	 * @param c The new stroke color.
	 * @post Side affect: Stroke color changes to c.
	 * @author Michael
	 */
	public void setStroke(Color c) {
		this.strokeColor = c;
	}
	
	/**Set the fill color.
	 * 
	 * @param c The new fill color.
	 * @post Side affect: fill color changes to c.
	 * @author Michael
	 */
	public void setFill(Color c) {
		this.fillColor = c;
	}
	
	/**Set the shape filled.
	 * 
	 * @param f a boolean that tells if the shape is filled.
	 * @post the fill state will be updated.
	 * @author Michael
	 */
	public void setFilled(boolean f) {
		this.filled = f;
	}
	
	/**Set the width of the stroke width.
	 * 
	 * @param w width of the stroke.
	 * @post width of stroke become w.
	 * @author Michael
	 */
	public void setStrokeWidth(int w) {
		this.strokeWidth = w;
	}
	
	/**To get vx of this actor
	 * 
	 * @return vx
	 * @author Michael
	 */
	public double getvx() {
		return vx;
	}
	
	/**To get vy of this actor
	 * 
	 * @return vy
	 * @author Michael
	 */
	public double getvy() {
		return vy;
	}
	

	/**
	 * To set the actor's vx to a new value
	 * @param vxNew changes to new value
	 * @author Michael
	 */
	public void setvx(double vxNew) {
		vx = vxNew;
	}
	
	
	/**
	 * To set the actor's vy to a new value
	 * @param vyNew changes to new vlaue
	 * @author Michael
	 */
	public void setvy(double vyNew) {
		vy = vyNew;
	}
	
	/**
	 * To get the diameter of a circle
	 * @return diameter
	 * @author Michael
	 */
	public double getRadius() {
		return radius;
	}
	
	/**
	 * To set the diameter of a circle
	 * @param r
	 * @author Michael
	 */
	public void setRadius(double r) {
		radius = r;
	}
	
	/**
	 * Add changes to the velocity
	 * @param ax
	 * @param ay
	 * @author Michael
	 */
	public void accelerate(double ax, double ay) {
		vx += ax;
		vy += ay;
	}
	
	/**A drawing surface that will set a random color of the shape.
	 * @param surface The surface PApplet draws on.
	 * @author Michael
	 */
	public void draw(PApplet surface) {
		if (filled) {
			surface.fill(fillColor.getRed(), 
					fillColor.getGreen(),
					fillColor.getBlue());
		} else {
			surface.noFill();
		}
		surface.strokeWeight(strokeWidth);
//		surface.stroke(strokeColor.getRed(), 
//				strokeColor.getGreen(), 
//				strokeColor.getBlue());

	}
	
	/**
	 * Get the distance between two actors
	 * @param other the other shape
	 * @return distance between the two actors
	 * @author Michael
	 */
	public double getDistance(Actor other) {
		return Math.sqrt(Math.pow(x-other.x, 2)+Math.pow(y-other.y, 2));
	}
	
	/**
	 * find whether or not the actor intersects with others
	 *
	 * @return true if intersects with other actors, false if not
	 * @author Michael
	 */
	public boolean intersects(Actor other) {
		double d = getDistance(other);
		if(d <= (getRadius()+other.getRadius())/2) {
			return true;
		}else {
			return false;
		}
	}

	
	/**
	 * Determines whether the point x,y is contained inside this actor.
	 * @param x The X-coordinate of the point.
	 * @param y The Y-coordinate of the point.
	 * @return True if point is inside, false if point is outside.
	 * @author Michael
	 */
	public boolean isPointInside(double x, double y) {
        if(Math.sqrt(Math.pow(this.getX()-x, 2.0)+Math.pow(this.getY()-y, 2.0)) <= getRadius())
            return true;
        else
            return false;
    }
	
	/**
	 * Changes the direction of the actor
	 * @param dir new direction
	 * @author Michael
	 */
	public void turn(double dir) {
		this.dir = dir;
	}
	
	/**
	 * Turn the actor towards a location
	 * @param x x coord of the location
	 * @param y y coord of the location
	 * @author Michael
	 */
	public void turnToward(int x, int y) {
		dir = Math.atan(((double)this.y-y)/(this.x-x));
		if (this.x > x)
			dir += Math.PI;
	}
	
	/**
	 * To get the direction of the actor
	 * @return direction
	 * @author Michael
	 */
	public double getDir() {
		return dir;
	}
	
	/**
	 * Set the window size
	 * @author Nont
	 * @param width new width
	 * @param height new height
	 */
	public void setWindowSizeActor(int width, int height) {
		windowWidth = width;
		windowHeight = height;
	}
	
	/**
	 * set this actor's invincibility
	 */
	public void setInvincible(boolean a) {
		invincible = a;
	}
	
	/**
	 * get the invincibility of the actor
	 * @return invincible
	 */
	public boolean getInvincible() {
		return invincible;
	}
	

	
}

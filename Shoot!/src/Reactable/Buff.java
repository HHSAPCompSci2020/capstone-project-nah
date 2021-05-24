package Reactable;

import java.util.ArrayList;

import actor.Actor;
import actor.Player;
import processing.core.PApplet;

public abstract class Buff extends Actor{

	public Buff(int x, int y) {
		super(1, x, y, 0, 0);
		setRadius(35);
	}

	
	public void draw(PApplet marker) {
		super.draw(marker);
		marker.circle((float)getX(),(float)getY(),(float)(getRadius()));
	}
	
	public void act(ArrayList<Actor> actors) {
		
	}
	
}

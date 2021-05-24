package Reactable;

import java.awt.Color;
import java.util.ArrayList;

import actor.Actor;
import actor.Player;
import processing.core.PApplet;

public class Medkit extends Buff{

	private int healthAmount;
	
	public Medkit(int x, int y) {
		super(x, y);
		healthAmount = 5;
		setFill(Color.GREEN);
	}
	
	public void act(ArrayList<Actor> actors) {
		for(int a = 0; a < actors.size(); a++) {
			if(intersects(actors.get(a)) && actors.get(a) instanceof Player) {
				actors.get(a).setHp(actors.get(a).getHp()+healthAmount);
				setHp(0);
			}
		}
	}
	
	
	public void draw(PApplet marker) {
		super.draw(marker);
		float x = (float) (getX()-getRadius()/2+3);
		float y = (float) (getY()-3);
		float x2 = (float) (getX()-3);
		float y2 = (float) (getX()-getRadius()/2+3);
		float length = (float) (getRadius()-6);
		float width = 6;
		marker.push();
		marker.fill(232, 48, 21);
		marker.noStroke();
		marker.rect(x, y, length, width, 8);
		marker.rect((int)(x+length/2.0-0.5*width), (int)(y-length/2.0 + 0.5*width), width, length, 8);
        marker.pop();
	}
	
	
	
}

package Reactable;

import java.awt.Color;
import java.util.ArrayList;

import Projectile.PlayerBullet;
import actor.Actor;
import actor.Player;

public class StrongBullet extends Buff{

	private int health;
	
	public StrongBullet(int x, int y) {
		super(x, y);
		health = 3;
		setFill(Color.BLUE);
	}

	public void act(ArrayList<Actor> actors) {
		for(int a = 0; a < actors.size(); a++) {
			if(intersects(actors.get(a)) && actors.get(a) instanceof Player) {
				PlayerBullet.setHealth(2);
				setHp(0);
			}
		}
	}
	
}

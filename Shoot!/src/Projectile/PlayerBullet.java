package Projectile;

import java.awt.Color;
import java.util.ArrayList;

import Enemy.Enemy;
import Reactable.Wall;
import actor.Actor;
import actor.Player;
import processing.core.PApplet;

public class PlayerBullet extends Bullet{

	private static int health = 1;
	private static boolean cancelBullet;
	
	public PlayerBullet(double x, double y, double vx, double vy, boolean ignorePlayer) {	
		super(x, y, vx, vy);
		super.setSpeed(8);
		setRadius(10);
		setFill(new Color(233, 205, 76));
		setIgnorePlayer(true);
		setHp(health);
	}
	
	
	
	public void act(ArrayList<Actor> other, PApplet surface, int time) {
		super.actProjectile(other, surface, time);
		
		actPlayerBullet(other);
	}
	
	public void actPlayerBullet(ArrayList<Actor> other) {
		for(int a = 0; a < other.size(); a++) {
			if(other.get(a).intersects(this)) {
				if(!(other.get(a) instanceof Player) && !(other.get(a) instanceof PlayerBullet) && !(other.get(a) instanceof Wall)) {
					if(getCancelBullet()) {
						setHp(getHp()-1);
						other.get(a).setHp(other.get(a).getHp()-1);
					}else if(!(other.get(a) instanceof Projectile)){
						setHp(getHp()-1);
						other.get(a).setHp(other.get(a).getHp()-1);
					}
				}
				continue;
			}
		
		}
	}
	
	public boolean getCancelBullet() {
		return cancelBullet;
	}
	
	public static void setCancelBullet(boolean a) {
		cancelBullet = a;
	}
	
	public static void cancelBullet() {
		cancelBullet = true;
	}
	
	public static void setHealth(int a) {
		health = a;
	}
	
}

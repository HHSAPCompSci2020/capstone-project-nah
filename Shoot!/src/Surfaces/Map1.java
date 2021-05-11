package Surfaces;

import java.awt.event.KeyEvent;
import java.util.ArrayList;

import Enemy.Turret;
import Projectile.Bullet;
import actor.Actor;
import actor.Player;
import processing.core.PImage;

public class Map1 extends DrawingSurface{
	private Player player;
	private Bullet bullet;
	private ArrayList<Actor> actors;
	private ArrayList<Integer> keys;
	private PImage cursor;
	
	public Map1() {
		super();
		keys = new ArrayList<Integer>();
		actors = new ArrayList<Actor>();
		player = new Player(100,100);
		actors.add(new Turret(300,300));
		actors.add(new Turret(400,300));
		actors.add(new Turret(300,400));
		actors.add(new Turret(400,400));
	}

	/**
	 * Set up when first open
	 */
	public void setUp() {
//		size(600, 400);
//		pixelDensity(displayDensity());
//		frameRate(170);
//		cursor = super.loadImage("img/bullseye.png");
//		cursor(cursor);
//		smooth(5);
	}
	
	/**
	 * draw the game with white background
	 */
	public void draw() {
		background(255);
		for(Actor a : actors) {
			a.draw(this);
		}
		player.draw(this);
		

		player.act(actors, this);
		if (!player.getBounce()) {
			if (isPressed(KeyEvent.VK_W)) {
				player.setvy(player.getvy() - 1);
				// player.setY(player.getY()-1);
			}
			if (isPressed(KeyEvent.VK_A)) {
				player.setvx(player.getvx() - 1);
				// player.setX(player.getX()-1);
			}
			if (isPressed(KeyEvent.VK_S)) {
				player.setvy(player.getvy() + 1);
				// player.setY(player.getY()+1);
			}
			if (isPressed(KeyEvent.VK_D)) {
				player.setvx(player.getvx() + 1);
				// player.setX(player.getX()+1);
			}
			if (mousePressed) {
				bullet = new Bullet(player.getX(), player.getY(), player.getvx(), player.getvy());
				actors.add(bullet);
				bullet.moveTowards(mouseX, mouseY);
				bullet.draw(this);
			}
		}
		
		pushMatrix();
		player.turnToward(mouseX, mouseY);
		popMatrix();
		checkDeath();


		
		fill(0);
		text("WASD to move",300, 50);
		text("Hit the black circles to kill them",300, 65);
		
		//debug
		text("x: " + (double)Math.round(player.getX()* 100000d) / 100000d, 600, 60);
		text("y: " + (double)Math.round(player.getY()* 100000d) / 100000d, 600, 70);
		text("vx: " + (double)Math.round(player.getvx()* 100000d) / 100000d, 600, 80);
		text("vy: " + (double)Math.round(player.getvy()* 100000d) / 100000d, 600, 90);
		text("mouseX: " + mouseX, 600, 100);
		text("mouseY: " + mouseY, 600, 110);
		text("Player HP: " + player.getHp(), 600, 120);
		for(int a = 0; a < actors.size(); a++) {
			text("Num: " + a + " HP: " + actors.get(a).getHp(), 600, 130+a*10);
		}
	}
	
	
	
	public void checkDeath() {
		if(player.getHp() == 0) {
			player = new Player(100,100);
		}
		for(int a = 0; a < actors.size(); a++) {
			if(actors.get(a).getHp() == 0) {
				actors.remove(a);
				a--;
			}
		}
	}
}
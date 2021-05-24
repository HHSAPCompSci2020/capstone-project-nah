package Surfaces;


import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.*;


public class FirstMap extends Screen {
	
	private DrawingSurface surface;
	
	private Rectangle button;

	public FirstMap(DrawingSurface surface) {
		super(800,600);
		this.surface = surface;

		button = new Rectangle(0,0,50,25);
	}
	
	public void draw() {
		
//		// Draw stuff
//		
//		surface.pushStyle();
//		
//		surface.background(255);   // Clear the screen with a white background
//		surface.stroke(0);     // Set line drawing color to white
//		surface.noFill();
//
//		surface.rect(x,y,30,30);
//		
//		surface.fill(0);
//		surface.text("Move: Arrow keys",10,30);
//		surface.text("Menu: Space",10,50);
//
//		surface.popStyle();
//
//		
//		
//		// Change stuff
//
//		if (surface.isPressed(KeyEvent.VK_LEFT))
//			x -= 5;
//		if (surface.isPressed(KeyEvent.VK_RIGHT))
//			x += 5;
//		if (surface.isPressed(KeyEvent.VK_UP))
//			y -= 5;
//		if (surface.isPressed(KeyEvent.VK_DOWN))
//			y += 5;
//
//
//		if (surface.isPressed(KeyEvent.VK_SPACE)) {
//			surface.switchScreen(ScreenSwitcher.SCREEN1);
//		}
//		surface.scale((float)(surface.width/1000.0), (float)(surface.height/800.0));
		surface.draw2();
		surface.pushStyle();
		surface.fill(0);
		surface.rect(button.x, button.y, button.width, button.height, 10, 10, 10, 10);
		surface.fill(255);
		surface.textSize(15);
		String str = "back";
		float w = surface.textWidth(str);
		surface.text(str, (float)(button.x+button.width/1.5-w/1.5), (float)(button.y+button.height/1.5));
		
		surface.popStyle();
	}
	
	public void buttonPressed() {
		Point p = /*surface.actualCoordinatesToAssumed(*/new Point(surface.mouseX,surface.mouseY);
		if (button.contains(p)) {
			surface.switchScreen(ScreenSwitcher.MENU_SCREEN);
		}
	}
	
}
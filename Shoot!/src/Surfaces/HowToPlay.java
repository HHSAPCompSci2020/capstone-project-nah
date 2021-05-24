package Surfaces;



import java.awt.Point;
import java.awt.Rectangle;


public class HowToPlay extends Screen {

	private DrawingSurface surface;
	
	private Rectangle button;

	public HowToPlay(DrawingSurface surface) {
		super(800,600);
		this.surface = surface;

		button = new Rectangle(0,0,50,25);
	}


	public void draw() {
		surface.scale((float)(surface.width/1000.0), (float)(surface.height/800.0));
		surface.pushStyle();
		surface.fill(0);
		surface.background(255);
		surface.rect(button.x, button.y, button.width, button.height, 10, 10, 10, 10);
		surface.fill(255);
		surface.textSize(15);
		String str = "back";
		float w = surface.textWidth(str);
		surface.text(str, (float)(button.x+button.width/1.5-w/1.5), (float)(button.y+button.height/1.5));
		
		
		surface.fill(0);
		surface.textSize(40);
		String str2 = "Click \"Start\" to play\r\n"
				+ "Click \"back\" to go back to menu\r\n"
				+ "Click \"B\" to change to missile, \nclick again to change it back\r\n"
				+ "Move on top of colored circle for power ups.\r\n"
				+ "Use WASD to move, move mouse to turn turret \nand mouse click to shoot.\r\n"
				+ "The longer you play, \nthe harder the game gets.";
		surface.text(str2, 50, 120);
		
		surface.popStyle();
	}



	
	public void buttonPressed() {
		Point p = /*surface.actualCoordinatesToAssumed(*/new Point(surface.mouseX,surface.mouseY);
		if (button.contains(p))
			surface.switchScreen(ScreenSwitcher.MENU_SCREEN);
	}
	

}


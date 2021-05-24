package Surfaces;



import java.awt.Point;
import java.awt.Rectangle;


public class MenuScreen extends Screen {

	private DrawingSurface surface;
	
	private Rectangle startButton, howToPlayButton;

	public MenuScreen(DrawingSurface surface) {
		super(800,600);
		this.surface = surface;

		startButton = new Rectangle(1250/2-100,900/2-50,200,100);
		howToPlayButton = new Rectangle(1250/2-100-250,900/2-50,200,100);
	}


	public void draw() {

		surface.scale((float)(surface.width/1000.0), (float)(surface.height/800.0));
		surface.pushStyle();
		
		surface.background(255,255,255);
		
		surface.fill(255);
		surface.rect(startButton.x, startButton.y, startButton.width, startButton.height, 10, 10, 10, 10);
		surface.rect(howToPlayButton.x, howToPlayButton.y, howToPlayButton.width, howToPlayButton.height, 10, 10, 10, 10);
		surface.fill(0);
		surface.textSize(20);
		String str = "Start";
		float w = surface.textWidth(str);
		surface.text(str, startButton.x+startButton.width/2-w/2, startButton.y+startButton.height/2);
		String str2 = "How To Play";
		float w2 = surface.textWidth(str2);
		surface.text(str2, howToPlayButton.x+howToPlayButton.width/2-w2/2, howToPlayButton.y+howToPlayButton.height/2);
		
//		surface.popStyle();
//		
//		surface.pushStyle();
//		surface.textSize(20);
		surface.textSize(100);
		surface.text("Shoot!", 1250/2-275, 650/2-50);
		surface.popStyle();
	}



	
	public void buttonPressed() {
		Point p = /* surface.actualCoordinatesToAssumed( */new Point(surface.mouseX, surface.mouseY);
			if (startButton.contains(p))
				surface.switchScreen(ScreenSwitcher.FIRST_MAP);
			if (howToPlayButton.contains(p))
				surface.switchScreen(ScreenSwitcher.HOW_TO_PLAY);
	}
	

}


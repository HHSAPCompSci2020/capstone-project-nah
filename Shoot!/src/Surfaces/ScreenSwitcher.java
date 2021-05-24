package Surfaces;


public interface ScreenSwitcher {
	public static final int MENU_SCREEN = 0;
	public static final int FIRST_MAP = 1;
	public static final int HOW_TO_PLAY = 2;
	
	/**
	 * switch screen
	 * @param i screen number
	 */
	public void switchScreen(int i);
}
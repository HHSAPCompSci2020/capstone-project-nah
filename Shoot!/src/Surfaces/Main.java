package Surfaces;
import java.awt.*;

import javax.swing.*;

import Surfaces.DrawingSurface;
import processing.awt.PSurfaceAWT;
import processing.core.PApplet;


public class Main{
	/**
	 * executes the program
	 * 
	 * @param args argument for the main method
	 */
	
	public static void main(String args[]) {
		DrawingSurface drawing = new DrawingSurface();
		PApplet.runSketch(new String[]{""}, drawing);
		PSurfaceAWT surf = (PSurfaceAWT) drawing.getSurface();
		PSurfaceAWT.SmoothCanvas canvas = (PSurfaceAWT.SmoothCanvas) surf.getNative();
		JFrame window = (JFrame)canvas.getFrame();

		window.setLocation(300,150);
		window.setSize(1000, 800);
		window.setMinimumSize(new Dimension(500,500));
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setResizable(true);

		window.setVisible(true);
		canvas.requestFocus();
	}
}

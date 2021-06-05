package controller;

import model.World;
import processing.core.PApplet;

public class Controller {
	private World logic;
	
	public Controller(PApplet app) {
		logic = new World(app);
	}
	
	public void draw() {
		logic.draw();
	}
}

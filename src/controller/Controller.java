package controller;

import model.World;
import processing.core.PApplet;

public class Controller {
	private World world;
	
	public Controller(PApplet app) {
		world = new World(app);
	}
	
	public void draw() {
		world.draw();
	}
}

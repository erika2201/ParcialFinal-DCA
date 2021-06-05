package controller;

import model.Mundo;
import processing.core.PApplet;

public class Controller {
	private Mundo logic;
	
	public Controller(PApplet app) {
		logic = new Mundo(app);
	}
	
	public void draw() {
		logic.draw();
	}
}

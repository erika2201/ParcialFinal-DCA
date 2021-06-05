package model;

import processing.core.PApplet;

public abstract class Character implements Runnable {
	
	protected float posX;
	protected float posY;
	protected int dirBounceX, dirBounceY;
	protected PApplet app;
	protected final int TAM = 20; //Final para constante
	
	public Character (float posX, float posY, PApplet app) {
		this.posX = posX;
		this.posY = posY;
		this.app = app;
		dirBounceX = 1;
		dirBounceY = 1;
	}

}

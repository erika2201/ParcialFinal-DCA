package model;

import processing.core.PApplet;

public class Polo extends Character {

	public Polo(float posX, float posY, PApplet app) {
		super(posX, posY, app);
	}

	public void draw() {
		app.fill(14, 225, 131);
		app.noStroke();
		app.circle(posX, posY, TAM);
	}

	public void mov() {

		posX += 1 * dirBounceX;
		posY += 1 * dirBounceY;

		if (posX < 0 || posX > app.width) { // si llega a bordes de lados
			dirBounceX *= -1;
		}
		if (posY < 0 || posY > app.height) { // Si llega a bordes de arriba o abajo
			dirBounceY *= -1;
		}

	}

	@Override
	public void run() {
		mov();
	}

	// Los getter y setter para ponder comunicar en el mundo
	public float getPosX() {
		return posX;
	}

	public float getPosY() {
		return posY;
	}

	public int getDirBounceX() {
		return dirBounceX;
	}

	public int getDirBounceY() {
		return dirBounceY;
	}

}

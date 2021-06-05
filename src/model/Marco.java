package model;

import processing.core.PApplet;

public class Marco extends Character {

	public Marco(float posX, float posY, PApplet app) {
		super(posX, posY, app);
	}
	
	public void draw () {
		app.fill(168, 14, 225);
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
		try {
			  Thread.sleep(2000);
			  mov(); //al llamarlo acá, solo basta llamar run en el mundo, y no al mov, run lo llamo con start
			  //System.out.println("funciono");
			  
		} catch (InterruptedException e) {
			 e.printStackTrace();
		}
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
		
		public void setDirBounceX(int dirBounceX) {
			this.dirBounceX = dirBounceX;
		}
		
		public void setDirBounceY(int dirBounceY) {
			this.dirBounceY = dirBounceY;
		}


}

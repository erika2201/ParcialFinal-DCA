package model;

import processing.core.PApplet;

public class Marco extends Character {

	public Marco(float posX, float posY, PApplet app) {
		super(posX, posY, app);
	}
	
	public void draw () {
		app.fill(168, 14, 225);
		app.circle(posX, posY, TAM);
		
		if(app.second() % 2 == 0) {
			app.text("Marco",posX, posY);
		}
	}
	
	private void mov() {
		posX += 2 * dirBounceX;
		posY += 2 * dirBounceY;
		
		if (posX < 0 || posX > app.width) { // si llega a bordes de lados
			dirBounceX *= -1;
		}
		if (posY < 0 || posY > app.height) { // Si llega a bordes de arriba o abajo
			dirBounceY *= -1;
		}
	
	}
	

		
	public void mov2(float poloX, float poloY) {
		
		dirBounceX= (int) (poloX-this.posX);
		dirBounceY= (int) (poloY-this.posY);
		
		float dist = (float) Math.sqrt(dirBounceX * dirBounceX + dirBounceY * dirBounceY); 
		if(dist != 0.0) {
			dirBounceX /= dist;
			dirBounceY /= dist;
		}
		
		
	}
	
	@Override
	public void run() {
		 mov(); //al llamarlo acá, solo basta llamar run en el mundo, y no al mov, run lo llamo con start
		 try {
			  Thread.sleep(2000);
			  message();
		} catch (InterruptedException e) {
			 e.printStackTrace();
		}
	}
	
	public void message () {
		if(app.second() % 2 == 0) {
			System.out.println("marco");
			//app.text("Marco",posX, posY);
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

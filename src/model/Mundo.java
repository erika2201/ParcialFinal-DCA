package model;

import java.util.ArrayList;

import processing.core.PApplet;

public class Mundo {

	private ArrayList<Polo> polos;
	Marco marco;
	
	public Mundo(PApplet app) {
		polos = new ArrayList<Polo>();
		marco = new Marco (300,300,app);

		for (int i = 0; i <20; i++) {
			float posX = app.random (5,690);
			float posY = app.random (5,690);
			
			polos.add(new Polo (posX, posY, app));
		}
	}
	
	public void draw() {
		marco.draw();
		
		for (Polo politos : polos) {
			politos.draw();
			//politos.mov();
			new Thread(politos).start(); //con run corre, pero no como el hilo aparte, con start sí
		}
	}
}


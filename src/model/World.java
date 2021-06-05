package model;

import java.util.ArrayList;

import controlP5.FrameRate;
import processing.core.PApplet;

public class World {

	private PApplet app;
	private ArrayList<Polo> polos;
	Marco marco;
	
	public World(PApplet app) {
		this.app = app;
		
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
		marco.message();
		new Thread (marco).start(); //Llamo al run de marco
		
		for (Polo politos : polos) {
			politos.draw();
			//politos.mov();
			new Thread(politos).start(); //con run corre, pero no como el hilo aparte, con start sí
		}
		
		movMarco();
	}
	
	
	
	//todo el movimiento de perseguir
	public void movMarco () {
		
		for (int i = 0; i <polos.size(); i++) {
			if(PApplet.dist(marco.getPosX(),marco.getPosY(),polos.get(i).posX, polos.get(i).getPosY())<20) {//Distancia entre polo y marco es pequeña
				polos.remove(i);
			}
		}
		
		
		try {						
			
		} catch (IndexOutOfBoundsException e) {
			e.getLocalizedMessage();
		}
	}
}


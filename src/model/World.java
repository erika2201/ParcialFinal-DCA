package model;

import java.util.ArrayList;
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
		movMarco();
		new Thread (marco).start(); //Llamo al run de marco
		
		for (Polo politos : polos) {
			politos.draw();
			new Thread(politos).start(); //con run corre, pero no como el hilo aparte, con start sí
		}	
	}
	
	
	//todo el movimiento de perseguir
	public void movMarco () {
		
		int distMP = 700;
		int calculateDistMP = 0;
		int positions = 0;
		
		if(polos.size() == 0) {
			marco.setDirBounceX(0);
			marco.setDirBounceY(0);
		}
		
		for(int i = 0; i < polos.size();i++) {
			calculateDistMP = (int) PApplet.dist(marco.getPosX(), marco.getPosY(), polos.get(i).getPosX(), polos.get(i).getPosY());
			if(calculateDistMP < distMP) {
				distMP = calculateDistMP;
				positions = i;
			}
		}
		
		try {
			if(PApplet.dist(marco.getPosX(),marco.getPosY(),polos.get(positions).posX, polos.get(positions).getPosY())<20) {//Distancia entre polo y marco es pequeña
				polos.remove(positions);
			}
		}
		catch(IndexOutOfBoundsException e) {
			e.getLocalizedMessage();
		}

	}
}


package juankyBird;

import fge.Color;
import fge.Render;
import fge.Service;
import fge.Window;

public class Game extends Service {
	
	private int esquinaX;
	private int altura;
	private int largo;
	private int ancho;
	
	public void onStart() {
		ancho = 100;
		largo = 100;
		esquinaX = (Window.getW() - ancho) / 2;
		altura = (Window.getH() - largo) / 2;
	}
	
	public void onStop() {
		
	}

	public void onMove() {//constante descendente y implementacion de  onUp
		
	}
	public void onUp(){//per a cuan pulses cap a dalt
		
	}
	public void onDown(){//per a no parar de baixar fins tocar terra.
		altura=
	}
	
	public void onDraw() {
		Render.DrawBox(esquinaX, esquinaY, ancho, largo, new Color(255,0,0));
	}

}

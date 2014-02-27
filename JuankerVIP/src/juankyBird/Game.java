package juankyBird;

import fge.App;
import fge.Color;
import fge.Render;
import fge.Service;
import fge.Window;

public class Game extends Service {
	
	private int esquinaX;
	private double altura;
	private int largo;
	private int ancho;
	
	public void onStart() {
		ancho = 64;
		largo = 64;
		esquinaX = (Window.getW() - ancho) / 2;
		altura =0;// Window.getH() / 2;
	}
	
	public void onStop() {
		
	}
//app.getFTime temps per frame
	public void onMove() {//constante descendente y implementacion de  onUp
		altura=0.01*App.getFTime();
	}
	public void onUp(){//per a cuan pulses cap a dalt
		
	}
	public void onDown(){//per a no parar de baixar fins tocar terra.
		altura=Window.getH()-altura;
	}
	
	public void onDraw() {
		Render.DrawBox(esquinaX, Window.getH()-largo-altura, ancho, largo, new Color(255,0,0));
	}

}

package juankyBird;

import fge.App;
import fge.Color;
import fge.Render;
import fge.Service;
import fge.Window;

public class Game extends Service {
	
	private float esquinaX;
	private float altura;
	private int largo;
	private int ancho;
	
	public void onStart() {
		ancho = 64;
		largo = 64;
		esquinaX = (Window.getW() - ancho) / 2;
		altura = 0.0f;
	}
	
	public void onStop() {
		
	}
	
	//app.getFTime temps per frame
	public void onMove() {//constante descendente y implementacion de  onUp
		altura -= 8.0f * App.getFTime();
		System.out.println(altura);
	}
	
	public void onDraw() {
		Render.DrawBox(esquinaX, Window.getH()-largo-altura, ancho, largo, new Color(255,0,0));
	}

}

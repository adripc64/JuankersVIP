package juankyBird;

import fge.App;
import fge.Color;
import fge.Event;
import fge.EventMan;
import fge.Mouse;
import fge.Render;
import fge.Service;
import fge.Window;

public class Game extends Service {
	
	private float esquinaX;
	private float altura;
	private int largo;
	private int ancho;
	private float aceleracion;
	
	public void onStart() {
		ancho = 64;
		largo = 64;
		esquinaX = (Window.getW() - ancho) / 2;
		altura = Window.getH()/2;//0.0f;
		aceleracion = 0.0f;
		
		EventMan.addListener(this);
	}
	
	public void onStop() {
		
	}
	
	//app.getFTime temps per frame
	public void onMove() {//constante descendente y implementacion de  onUp
		if(altura>0){
			aceleracion += 750.0f * App.getFTime();
			if (aceleracion > 250) aceleracion = 250.0f;
			altura -= aceleracion * App.getFTime();
		}
		else{
			//com se fa per a parar?
			altura = 0.0f;
		}
	}

	public void onDraw() {
		Render.DrawBox(esquinaX, Window.getH()-largo-altura, ancho, largo, new Color(255,0,0));
	}
	
	public boolean doEvent(Event e) {
		
		if (e.getType() == Event.MOUSE_PRESSED) {
			
			//int mx = Mouse.getX();
			//int my = Mouse.getY();
			
			// Ací es cuan li has de donar el empuje...
			aceleracion = -300.0f;
			
		}
		
		return false;
		
	}

}

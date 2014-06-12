package juankyBird;

import fge.App;
import fge.Color;
import fge.Event;
import fge.Event.EventType;
import fge.EventListener;
import fge.EventMan;

import fge.Font;
import fge.Render;
import fge.Service;
import fge.ServiceMan;
import fge.Sprite;
import fge.SpriteAnimation;
import fge.Texture;
import fge.Window;

public class Game extends Service implements EventListener {
	
	private Font font;
	private Pardal pardal;
	private Tuberia tuberia;
	private Tuberia tuberia2;
	private float aceleracion;
	private Texture texBackground;
	private float backgroundUX = 0.0f;
	private float backgroundSpeed = 40.0f;
	private float tubSpeed = 200.0f;
	private float separacionTuberias = 400.0f;
	private int marcador;

	public Game() {
		EventMan.addListener(this);
		
		pardal = new Pardal();
		tuberia=new Tuberia();
		tuberia2=new Tuberia();
		font = new Font("data/COMIC.ttf", 48.0f);
		texBackground = new Texture("data/tumblr_mbhiex4zoj1r1x7rso1_1280.jpg");
	}
	
	@Override
	public void onStart() {
		aceleracion = 0.0f;
		tuberia.setX(Window.getW());
		tuberia2.setX(Window.getW()+Window.getW()/1.2f);
		pardal.setX(100);		
		pardal.setAltura(Window.getH() / 2.0f);
	}

	@Override
	public void onStop() {
	}
	
	@Override
	protected void onPause() {
		Service pausa = ServiceMan.getService("menu_pausa");
		pausa.start();
	}
	
	@Override
	protected void onResume() {
	}
	
	@Override
	public void onMove() { // Constante descendente e implementacion de onUp
		// Movimiento del background
		backgroundUX += (backgroundSpeed / Window.getW()) * App.getFTime();
		
		// Movimiento del pajaro
		pardal.move(); // Este es para que se mueva su sprite (animacion)
		aceleracion += 750.0f * App.getFTime();
		if (aceleracion >500)
			aceleracion = 500.0f;
		pardal.setAltura(pardal.getAltura() + aceleracion * App.getFTime());
		// Si sale por arriba de la pantalla el pajaro
		if(pardal.getAltura()-pardal.getH() <0) { 
			aceleracion = 0.0f;
			pardal.setAltura(pardal.getH());
		}
		// Si sale por abajo
		if (pardal.getAltura() >= Window.getH()) {
			pardal.setAltura(Window.getH());
			pause();
		}
		
		// Movimiento de las tuberias
		tuberia.setX(tuberia.getX() - tubSpeed * App.getFTime());
		tuberia2.setX(tuberia2.getX() - tubSpeed * App.getFTime());
		if (tuberia.getX() < -tuberia.getW()) {
			tuberia.setX(tuberia2.getX()+separacionTuberias);
			tuberia.randomEspacio();
		}
		if (tuberia2.getX() < -tuberia2.getW()) {
			tuberia2.setX(tuberia.getX()+separacionTuberias);
			tuberia2.randomEspacio();
		}
		
		if (tuberia.chocaElPardalet(pardal.getX(), pardal.getAltura()-pardal.getH(), pardal.getW(), pardal.getH())) {
			System.out.print("Tubo1");
			pause();
		}
		if (tuberia2.chocaElPardalet(pardal.getX(), pardal.getAltura(), pardal.getW(), pardal.getH())) {
			System.out.print("Tubo2");
			pause();
		}
		
	}

	@Override
	public void onDraw() {
		Render.DrawTexture(texBackground, 0, 0, Window.getW(), Window.getH(), 0,
				new Color(255, 255, 255), backgroundUX, 0.0f, 1.0f, 1.0f);

		// Dibujando tuberia
		tuberia.DibujarTuberia();
		tuberia2.DibujarTuberia();
	
		// Dibuixe el pardal
		pardal.draw();
	}

	@Override
	public boolean doEvent(Event e) {
		if (e.getType() == EventType.MOUSE_PRESSED
				|| e.getType() == EventType.KEY_PRESSED) {

			aceleracion = -350.0f;
		}
		return false;
	}
	
}

package juankyBird;

import fge.App;
import fge.Color;
import fge.Event;
import fge.Event.EventType;
import fge.EventListener;
import fge.EventMan;
import fge.Render;
import fge.Service;
import fge.Texture;
import fge.Window;

public class Game extends Service implements EventListener {

	private Pardal pardal;
	private Tuberia tuberia;
	private float aceleracion;
	private float tubSpeed = 200.0f;
	private Texture texBackground;
	private float backgroundUX = 0.0f;
	private float backgroundSpeed = 30.0f;
	
	private Texture texTuboCuerpo;
	private Texture texTuboCuerpoInv;

	@Override
	public void onStart() {
		aceleracion = 0.0f;
		pardal = new Pardal();
		tuberia=new Tuberia();
		tuberia.setX(Window.getW()+tuberia.getTextura().getW());

		texBackground = new Texture("PNG", "data/paisaje.png"); // a�o es molt xapussa sa darreglar
		pardal.setAltura(Window.getH() / 2.0f); // Aparece en medio de la pantalla el p�jaro
		
		texTuboCuerpo = new Texture("PNG", "data/tubo_cuerpo.png");
		texTuboCuerpoInv = new Texture("PNG", "data/tubo_cuerpoInv.png");
		EventMan.addListener(this);
	}

	@Override
	public void onStop() {
		
	}

	@Override
	protected void onPause() {
		// TODO Auto-generated method stub

	}

	@Override
	protected void onResume() {
		// TODO Auto-generated method stub

	}
 
	@Override
	public void onMove() { // Constante descendente e implementacion de onUp
		// Movimiento del background
		backgroundUX += (backgroundSpeed / Window.getW()) * App.getFTime();
		
		// Movimiento del pajaro
		if(pardal.getAltura() >= Window.getH() - 60){ // Llega arriba de la pantalla el pajaro
			aceleracion = 250.0f;
			pardal.setAltura(pardal.getAltura() - aceleracion * App.getFTime());
		}
		if (pardal.getAltura() >= 0 && pardal.getAltura() < Window.getH()) {
			aceleracion += 750.0f * App.getFTime();
			if (aceleracion > 250)
				aceleracion = 250.0f;
			pardal.setAltura(pardal.getAltura() - aceleracion * App.getFTime());
		}
		if (pardal.getAltura() < 0) {
			pardal.setAltura(0);
		}
		
		// Movimiento de las tuberias
		if(tuberia.getX() > 0-tuberia.getTextura().getW()){
			float tubx = tuberia.getX() - tubSpeed * App.getFTime();
			tuberia.setX(tubx);
		} else {
			tuberia.setX(Window.getH()+tuberia.getTextura().getW()+50);
			float tuby = (float) (Math.random() * (Window.getH()-tuberia.getSeparacion())-tuberia.getSeparacion()-100);
			tuberia.setYT(tuby);
		}
	}

	@Override
	public void onDraw() {
		Render.DrawTex(texBackground, 0, 0, Window.getW(), Window.getH(),
				new Color(255, 255, 255), backgroundUX, 0.0f, 1.0f, 1.0f);

		// Render.DrawTex(texTuboCuerpo, 0, 0, 128, 512, new Color(255,255,255), 0, 0, 1, 512/8.f);
		
		// Dibujando tuber�a 
		int wT=tuberia.getTextura().getW();
		int hT=tuberia.getTextura().getH();
		float xT=tuberia.getX(); // Constante
		float yT=tuberia.getYT();
		Render.DrawTex(tuberia.getTexturaInv(), xT, yT, wT, hT, new Color(255, 255, 255));
		Render.DrawTex(texTuboCuerpoInv, xT, 0, wT, yT+hT-70, new Color(255, 255, 255));
			
		yT+=hT+tuberia.getSeparacion();
		Render.DrawTex(tuberia.getTextura(), xT, yT, wT, hT, new Color(255, 255, 255));
		Render.DrawTex(texTuboCuerpo, xT, Window.getH(), wT,yT-Window.getH()+80, new Color(255, 255, 255));
		// Dibujando pajaro
		int w = pardal.getTextura().getW();
		int h = pardal.getTextura().getH();
		float x = (Window.getW() - w) / 3.0f;
		float y = Window.getH() - h - pardal.getAltura();
		Render.DrawTex(pardal.getTextura(), x, y, w, h,
				new Color(255, 255, 255));	
	}

	@Override
	public boolean doEvent(Event e) {
		if (e.getType() == EventType.MOUSE_PRESSED
				|| e.getType() == EventType.KEY_PRESSED) {

			// int mx = Mouse.getX();
			// int my = Mouse.getY();

			// Ací es cuan li has de donar el empuje...
			aceleracion = -350.0f;

		}
		return false;
	}
	
}

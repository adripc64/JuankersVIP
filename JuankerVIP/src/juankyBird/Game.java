package juankyBird;

import fge.App;
import fge.Color;
import fge.Event;
import fge.EventMan;
import fge.Render;
import fge.Service;
import fge.Texture;
import fge.Window;

public class Game extends Service {

	private Pardal pardal;
	private Tuberia tuberia;
	private float aceleracion;
	private float desplazamiento;
	private Texture texBackground;

	@Override
	public void onStart() {

		aceleracion = 0.0f;
		desplazamiento=0.0f;
		pardal = new Pardal();
		pardal.setAltura(Window.getH() / 2.0f);
		tuberia=new Tuberia();

		texBackground = new Texture("PNG", "data/paisaje.png");//aço es molt xapussa sa darreglar

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
	public void onMove() {// constante descendente y implementacion de onUp
		if(pardal.getAltura()>=Window.getH()-60){
			aceleracion = 250.0f;
			pardal.setAltura(pardal.getAltura() - aceleracion * App.getFTime());
		}
		if (pardal.getAltura() >= 0 && pardal.getAltura()<Window.getH()) {
			aceleracion += 750.0f * App.getFTime();
			if (aceleracion > 250)
				aceleracion = 250.0f;
			pardal.setAltura(pardal.getAltura() - aceleracion * App.getFTime());
		}
		if (pardal.getAltura() < 0) {
			pardal.setAltura(0);
		}
	
		if(tuberia.getX()>=0){
			desplazamiento +=100.0f*App.getFTime();
			if(desplazamiento > 100) desplazamiento=100.0f;
			tuberia.setX(tuberia.getX() +desplazamiento *App.getFTime());
		}
		System.out.println(tuberia.getX());
	}

	@Override
	public void onDraw() {
		Render.DrawTex(texBackground, 0, 0, Window.getW(), Window.getH(),
				new Color(255, 255, 255));//aço davant que es lo que primer se te que fer.
		
		int w = pardal.getTextura().getW();
		int h = pardal.getTextura().getH();
		float x = (Window.getW() - w) / 3.0f;
		float y = Window.getH() - h - pardal.getAltura();

		int wT=tuberia.getTextura().getW();
		int hT=tuberia.getTextura().getH();
		float xT=Window.getW()-wT-tuberia.getX();//constante
		float yT=tuberia.getYT();
		Render.DrawTex(tuberia.getTextura(), xT, yT, wT, hT,
				new Color(255, 255, 255));
		
		Render.DrawTex(pardal.getTextura(), x, y, w, h,
				new Color(255, 255, 255));
		
		
		
	
	}

	public boolean doEvent(Event e) {

		if (e.getType() == Event.MOUSE_PRESSED
				|| e.getType() == Event.KEY_PRESSED) {

			// int mx = Mouse.getX();
			// int my = Mouse.getY();

			// AcÃ­ es cuan li has de donar el empuje...
			aceleracion = -400.0f;

		}

		return false;

	}

}

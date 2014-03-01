package juankyBird;

import fge.App;
import fge.Color;
import fge.Event;
import fge.Event.EventType;
import fge.EventListener;
import fge.EventMan;
import fge.Mouse;
import fge.Render;
import fge.Service;
import fge.ServiceMan;
import fge.Texture;
import fge.Window;

public class Game extends Service implements EventListener {
	
	private MenuPausa pausa;

	private Pardal pardal;
	private Tuberia tuberia;
	private Tuberia tuberia2;
	private float aceleracion;
	private float tubSpeed = 200.0f;
	private Texture texBackground;
	private float backgroundUX = 0.0f;
	private float backgroundSpeed = 40.0f;
	private boolean contador=false;
	private int buro;
	private float posPardal;
	
	private Texture texTuboCuerpo;
	private Texture texTuboCuerpoInv;


	@Override
	public void onStart() {
		aceleracion = 0.0f;
		pardal = new Pardal();
		tuberia=new Tuberia();
		tuberia2=new Tuberia();
		tuberia.setX(Window.getW()+tuberia.getTextura().getW());
		buro=0;
		posPardal=(Window.getW() - pardal.getTextura().getW()) / 3.0f;
			
		texBackground = new Texture("data/paisaje.png"); // a�o es molt xapussa sa darreglar
		pardal.setAltura(Window.getH() / 2.0f); // Aparece en medio de la pantalla el p�jaro
		
		texTuboCuerpo = new Texture("data/tubo_cuerpo.png");
		texTuboCuerpoInv = new Texture("data/tubo_cuerpoInv3.png");
		EventMan.addListener(this);
		
		pausa = new MenuPausa();
		ServiceMan.addService(pausa);
		EventMan.addListener(pausa);
	}

	@Override
	public void onStop() {
		
	}

	@Override
	protected void onPause() {
		pausa.start();
	}

	@Override
	protected void onResume() {
		// TODO Auto-generated method stub

	}
 
	@Override
	public void onMove() { // Constante descendente e implementacion de onUp
		// Movimiento del background
		backgroundUX += (backgroundSpeed / Window.getW()) * App.getFTime();
		buro++;
		// Movimiento del pajaro
		if(pardal.getAltura() >= Window.getH() - 60){ // Llega arriba de la pantalla el pajaro
			aceleracion = 250.0f;
			pardal.setAltura(pardal.getAltura() - aceleracion * App.getFTime());
		}
		if (pardal.getAltura() >= 0 && pardal.getAltura() < Window.getH()) {
			aceleracion += 750.0f * App.getFTime();
			if (aceleracion > 300)
				aceleracion = 300.0f;
			pardal.setAltura(pardal.getAltura() - aceleracion * App.getFTime());
		}
		if (pardal.getAltura() < 0) {
			pardal.setAltura(0);
			pause();
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
		//tuberia 2
		
		if((tuberia.getX()<=(Window.getW()/2+tuberia.getTextura().getW()/2)) && contador==false){
			contador=true;
		}
		if(tuberia2.getX() > 0-tuberia2.getTextura().getW()&&contador==true){
			float tubx2 = tuberia2.getX() - tubSpeed * App.getFTime();
			tuberia2.setX(tubx2);
		} else {
			tuberia2.setX(Window.getH()+tuberia2.getTextura().getW()+50);
			float tuby2 = (float) (Math.random() * (Window.getH()-tuberia2.getSeparacion())-tuberia.getSeparacion()-100);
			tuberia2.setYT(tuby2);
		}
		//vamos a empezar con las colisiones
		//colisio amb la primera tuberia inferior
		if(pardal.getAltura()<=(tuberia.getTextura().getH()-40-tuberia.getYT())&&(tuberia.getX()-tuberia.getTextura().getW()/2+10)<=(posPardal)&&posPardal<=(tuberia.getX()+tuberia.getTextura().getW()/2)){
			pause();
		}
		//colisio amb la primera tuberia superior
		if(pardal.getAltura()>=(tuberia.getTexturaInv().getH()+90-tuberia.getYT())&&(tuberia.getX()-tuberia.getTexturaInv().getW()/2)<=(posPardal)&&posPardal<=(tuberia.getX()+tuberia.getTexturaInv().getW()/2+50)){
			pause();
		}
		//colisio amb la segona tuberia inferior
		if(pardal.getAltura()<=(tuberia2.getTextura().getH()-30-tuberia2.getYT())&&(tuberia2.getX()-tuberia2.getTextura().getW()/2+10)<=(posPardal)&&posPardal<=(tuberia2.getX()+tuberia2.getTextura().getW()/2)){
			pause();
		}
		//colisio amb la segona tuberia superior
		if(pardal.getAltura()>=(tuberia2.getTexturaInv().getH()+90-tuberia2.getYT())&&(tuberia2.getX()-tuberia2.getTexturaInv().getW()/2)<=(posPardal)&&posPardal<=(tuberia2.getX()+tuberia2.getTexturaInv().getW()/2+50)){
			pause();
		}
	}

	@Override
	public void onDraw() {
		Render.DrawTexture(texBackground, 0, 0, Window.getW(), Window.getH(), 0,
				new Color(255, 255, 255), backgroundUX, 0.0f, 1.0f, 1.0f);

		// Dibujando tuberia 
		int wT=tuberia.getTextura().getW();
		int hT=tuberia.getTextura().getH();
		float xT=tuberia.getX(); // Constante
		float yT=tuberia.getYT();
		Render.DrawTexture(tuberia.getTexturaInv(), xT, yT, wT, hT, 0, new Color(255, 255, 255));
		Render.DrawTexture(texTuboCuerpoInv, xT, 0, wT, yT+hT-70, 0, new Color(255, 255, 255));
			
		yT+=hT+tuberia.getSeparacion();
		Render.DrawTexture(tuberia.getTextura(), xT, yT, wT, hT, 0, new Color(255, 255, 255));
		Render.DrawTexture(texTuboCuerpo, xT, Window.getH(), wT,yT-Window.getH()+80, 0, new Color(255, 255, 255));
		//tuberia2
		int wT2=tuberia2.getTextura().getW();
		int hT2=tuberia2.getTextura().getH();
		float xT2=tuberia2.getX(); // Constante
		float yT2=tuberia2.getYT();
		Render.DrawTexture(tuberia2.getTexturaInv(), xT2, yT2, wT2, hT2, 0, new Color(255, 255, 255));
		Render.DrawTexture(texTuboCuerpoInv, xT2, 0, wT2, yT2+hT2-70, 0, new Color(255, 255, 255));
			
		yT2+=hT2+tuberia2.getSeparacion();
		Render.DrawTexture(tuberia2.getTextura(), xT2, yT2, wT2, hT2, 0, new Color(255, 255, 255));
		Render.DrawTexture(texTuboCuerpo, xT2, Window.getH(), wT2,yT2-Window.getH()+80, 0, new Color(255, 255, 255));
		
		
		// Dibujando pajaro
		int w = pardal.getTextura().getW();
		int h = pardal.getTextura().getH();
		float x = posPardal;
		float y = Window.getH() - h - pardal.getAltura();
		Render.DrawTexture(pardal.getTextura(), x, y, w, h, 0,
				new Color(255, 255, 255));	
	}

	@Override
	public boolean doEvent(Event e) {
		if (e.getType() == EventType.MOUSE_PRESSED
				|| e.getType() == EventType.KEY_PRESSED) {

//			int mx = Mouse.getX();
//			int my = Mouse.getY();

			// Ací es cuan li has de donar el empuje...
			aceleracion = -350.0f;

		}
		return false;
	}
	
}

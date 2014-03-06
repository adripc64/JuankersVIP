package juankyBird;

import java.util.LinkedList;
import java.util.List;

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
	private Tuberia tuberia3;
	private float aceleracion;
	private Texture texBackground;
	private float backgroundUX = 0.0f;
	private float backgroundSpeed = 40.0f;
	private boolean contador=false;
	private boolean contador2=false;
	private float posPardal;
	private int marcador;
		
	private Texture texTuboCuerpo;
	private Texture texTuboCuerpoInv;

	public Game() {
		EventMan.addListener(this);
		
		pardal = new Pardal();
		tuberia=new Tuberia();
		tuberia2=new Tuberia();
		tuberia3=new Tuberia();
		font = new Font("data/COMIC.ttf", 48.0f);
		texBackground = new Texture("data/tumblr_mbhiex4zoj1r1x7rso1_1280.jpg"); // a�o es molt xapussa sa darreglar
		texTuboCuerpo = new Texture("data/tubo_cuerpo.png");
		texTuboCuerpoInv = new Texture("data/tubo_cuerpoInv3.png");
	}
	
	@Override
	public void onStart() {
		aceleracion = 0.0f;
		tuberia.setX(Window.getW()+tuberia.getTextura().getW());
		tuberia2.setX(0);
		tuberia3.setX((Window.getW()+tuberia.getTextura().getW())/2);
		pardal.setX((Window.getW() - pardal.getW()) / 3.0f);		
		pardal.setAltura(Window.getH() / 2.0f); // Aparece en medio de la pantalla el p�jaro
		posPardal=pardal.getX();
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
		if(pardal.getAltura() >= Window.getH() - 60){ // Llega arriba de la pantalla el pajaro
			aceleracion = 250.0f;
			pardal.setAltura(pardal.getAltura() - aceleracion * App.getFTime());
		}
		if (pardal.getAltura() >= 0 && pardal.getAltura() < Window.getH()) {
			aceleracion += 750.0f * App.getFTime();
			if (aceleracion >500)
				aceleracion = 500.0f;
			pardal.setAltura(pardal.getAltura() - aceleracion * App.getFTime());
		}
		if (pardal.getAltura() < 0) {
			pardal.setAltura(0);
			pause();
		}
		
		// Movimiento de las tuberias
		tuberia.MoureTuberia();
		tuberia2.MoureTuberia();
		tuberia3.MoureTuberia();
	
		//vamos a empezar con las colisiones
		//colisio amb la primera tuberia inferior
		if(pardal.getAltura()<=(tuberia.getTextura().getH()-40-tuberia.getYT())&&(tuberia.getX()-tuberia.getTextura().getW()/2+10)<=(posPardal)&&posPardal<=(tuberia.getX()+tuberia.getTextura().getW()/2)){
			pause();
		}
		//colisio amb la primera tuberia superior
		if(pardal.getAltura()>=(tuberia.getTexturaInv().getH()+90-tuberia.getYT())&&(tuberia.getX()-tuberia.getTexturaInv().getW()/2)<=(posPardal)&&posPardal<=(tuberia.getX()+tuberia.getTexturaInv().getW()/2+20)){
			pause();
		}
		//colisio amb la segona tuberia inferior
		if(pardal.getAltura()<=(tuberia2.getTextura().getH()-30-tuberia2.getYT())&&(tuberia2.getX()-tuberia2.getTextura().getW()/2+10)<=(posPardal)&&posPardal<=(tuberia2.getX()+tuberia2.getTextura().getW()/2)){
			pause();
		}
		//colisio amb la segona tuberia superior
		if(pardal.getAltura()>=(tuberia2.getTexturaInv().getH()+90-tuberia2.getYT())&&(tuberia2.getX()-tuberia2.getTexturaInv().getW()/2)<=(posPardal)&&posPardal<=(tuberia2.getX()+tuberia2.getTexturaInv().getW()/2+20)){
			pause();
		}
	
		if(tuberia.getX()<=(Window.getW() - pardal.getW()) / 3.0f || tuberia2.getX()<=(Window.getW() - pardal.getW()) / 3.0f ){
			marcador+=1;
		}
		//colisio amb la tercera tuberia inferior
		if(pardal.getAltura()<=(tuberia3.getTextura().getH()-30-tuberia3.getYT())&&contador2==true&&(tuberia3.getX()-tuberia3.getTextura().getW()/2+10)<=(posPardal)&&posPardal<=(tuberia3.getX()+tuberia3.getTextura().getW()/2)){
			System.out.println("Tuberia3");
			pause();
		}
		//colicio amb la tercera tuberia superior
		if(pardal.getAltura()>=(tuberia3.getTexturaInv().getH()+90-tuberia3.getYT())&&contador2==true&&(tuberia3.getX()-tuberia3.getTexturaInv().getW()/2)<=(posPardal)&&posPardal<=(tuberia3.getX()+tuberia3.getTexturaInv().getW()/2+20)){
			pause();
		}
	
		if(tuberia.getX()<=(Window.getW() - pardal.getW()) / 3.0f || tuberia2.getX()<=(Window.getW() - pardal.getW()) / 3.0f || tuberia2.getX()<=(Window.getW() - pardal.getW()) / 3.0f ){
			marcador+=1;
		}
		
		// Moc el pardal
		pardal.move();
	}

	@Override
	public void onDraw() {
		Render.DrawTexture(texBackground, 0, 0, Window.getW(), Window.getH(), 0,
				new Color(255, 255, 255), backgroundUX, 0.0f, 1.0f, 1.0f);

		// Dibujando tuberia
		tuberia.DibujarTuberia();
		if(tuberia.getX()<=(Window.getW()/2)+tuberia.getTextura().getW()/2){
			contador=true;
		}
		if(tuberia2.getX()<=(Window.getW()/2)+tuberia2.getTextura().getW()/2&&contador==true){
			contador2=true;
		}
		if(contador==true)tuberia2.DibujarTuberia();
		if(contador2==true)tuberia3.DibujarTuberia();
	
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

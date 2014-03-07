package airHockey;

/***
 * Nota mental:
 * 1. Aplicar un rozamiento cuando choca contra las paredes la pelota
 * 2. Dejar que la velocidad de la bola vaya aumentando hasta un tope fijado, 
 * 		el cual podría ser por ejemplo 500, de los cuales esos 1000 se van repartiendo 
 * 		entre las constantes x e y.
 * 3. Tomar en cuenta en las colisiones cuando colisiona con el mazo la pelota de forma
 * 		inversa a a la que quiere ir.
 * 4. Si choca la pelota contra el mazo parado debe rebotar como contra la pared
 */

import fge.App;
import fge.Color;
import fge.Event;
import fge.EventListener;
import fge.EventMan;
import fge.Font;
import fge.Intersect;
import fge.Keyboard;
import fge.Render;
import fge.Service;
import fge.Texture;
import fge.Window;
import fge.Event.EventType;

public class Game extends Service implements EventListener {
	private Font font;
	private Texture texBackground;
	private Ball ball;
	private Mazo mazo1;
	private Mazo mazo2;
	private float acceleracionX;
	private float acceleracionY;
	
	public Game(){
		font = new Font("data/COMIC.ttf", 48.0f);
		
		// Fondo de pantalla
		texBackground = new Texture("data/airhockey/campo.png");

		// Inicializando variables
		ball = new Ball();
		mazo1 = new Mazo();
		mazo2 = new Mazo();
		// Cambar color del mazo 2
		Texture texturaAux = new Texture("data/airhockey/mazo_negro.png");
		mazo2.setTex(texturaAux);
		
		EventMan.addListener(this);
	}
	
	@Override
	public void onStart() {		
		// Ponemos los objetos en su posicion inicial
		posicionInicialObjetos();
	}

	@Override
	protected void onStop() {
		// TODO Auto-generated method stub
		
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
	protected void onMove() {
		// Movimiento de la pelota
		moveBall();
		
		// Movimiento del mazo 1
		moveMazo1();
		
		// Movimiento del mazo 2
		moveMazo2();
	}
	
	private void moveBall(){
		// Parte de ARRIBA de la pantalla
		if(ball.getyBall() < 0)										
			acceleracionY = acceleracionY * (-1);		// Rebota

		// Parte de ABAJO de la pantalla
		if(ball.getyBall() > Window.getH() - ball.getTex().getH()) 
			acceleracionY = acceleracionY * (-1);		// Rebota
		
		// Parte DERECHA de la pantalla
		if(ball.getxBall() > Window.getW() - ball.getTex().getW()) {	
			// Marca gol mazo1 SII x: Window.getW() y: 180 - 332 --> Tamaño porteria: 152
			if(ball.getyBall() > 180 && ball.getyBall() + ball.getTex().getH() < 332) {
				mazo1.setGoles(mazo1.getGoles() + 1);
				posicionInicialObjetos();
			}
			else
				acceleracionX = acceleracionX * (-1);	// Rebota
		}
		
		// Parte IZQUIERDA de la pantalla
		if(ball.getxBall() < 0)	{										
			// Marca gol mazo2 SII x: 0  y: 180 - 332 --> Tamaño porteria: 152
			if(ball.getyBall() > 180 && ball.getyBall() + ball.getTex().getH() < 332) {
				mazo2.setGoles(mazo2.getGoles() + 1);
				posicionInicialObjetos();
			} else
				acceleracionX = acceleracionX * (-1);	// Rebota
		}
		
		// http://www.fis.puc.cl/~rbenguri/ESTATICADINAMICA/cap4.pdf
		// http://stackoverflow.com/questions/1736734/circle-circle-collision
		
		// sen A = b / r1 + r2
		// sen A = 0.5 --> A = 30º
		// x = 0.5y
		
		// Choca el mazo 1 con la pelota 
		if(Intersect.CircleWithCircle(mazo1.getxMazo(), mazo1.getyMazo(), 
				mazo1.getTex().getH() / 2, ball.getxBall(), ball.getyBall(), 
				ball.getTex().getH() / 2)) {
			acceleracionX = 300.0f * mazo1.getvX();
			acceleracionY = 75.0f * mazo1.getvY();
		}

		// Moviendo la pelota
		ball.setxBall(ball.getxBall() + acceleracionX * App.getFTime());	// Componente X
		ball.setyBall(ball.getyBall() + acceleracionY * App.getFTime());	// Componente Y

	}
	
	private void moveMazo1(){
		if(Keyboard.isKeyPressed(Keyboard.KEY_A)) { // Izquierda
			mazo1.setxMazo(mazo1.getxMazo() - 5.0f);
			mazo1.setvX(-1.0f);
		}
		if(Keyboard.isKeyPressed(Keyboard.KEY_D)) { // Derecha
			mazo1.setxMazo(mazo1.getxMazo() + 5.0f);
			mazo1.setvX(1.0f);
		}
		if(Keyboard.isKeyPressed(Keyboard.KEY_W)) { // Arriba
			mazo1.setyMazo(mazo1.getyMazo() - 5.0f);
			mazo1.setvY(-1.0f);
		}
		if(Keyboard.isKeyPressed(Keyboard.KEY_S)) { // Abajo
			mazo1.setyMazo(mazo1.getyMazo() + 5.0f);
			mazo1.setvY(1.0f);
		}
		
		if(mazo1.getxMazo() < 0)										// Parte izquierda de la pantalla
			mazo1.setxMazo(0);
		if(mazo1.getxMazo() + mazo1.getTex().getW() > Window.getW()/2)	// Si se sale de su CAMPO
			mazo1.setxMazo(Window.getW() / 2 - mazo1.getTex().getW());
		if(mazo1.getyMazo() < 0)										// Parte de ARRIBA de la pantalla
			mazo1.setyMazo(0);
		if(mazo1.getyMazo() > Window.getH() - mazo1.getTex().getH())	// Parte de ABAJO de la pantalla
			mazo1.setyMazo(Window.getH() - mazo1.getTex().getH());
	}
	
	private void moveMazo2(){
		if(Keyboard.isKeyPressed(Keyboard.KEY_LEFT)) {
			mazo2.setxMazo(mazo2.getxMazo() - 5.0f);
			mazo2.setvX(-1.0f);
		}
		if(Keyboard.isKeyPressed(Keyboard.KEY_RIGHT)) {
			mazo2.setxMazo(mazo2.getxMazo() + 5.0f);
			mazo1.setvX(1.0f);
		}
		if(Keyboard.isKeyPressed(Keyboard.KEY_UP)) {
			mazo2.setyMazo(mazo2.getyMazo() - 5.0f);
			mazo1.setvY(-1.0f);
		}
		if(Keyboard.isKeyPressed(Keyboard.KEY_DOWN)) {
			mazo2.setyMazo(mazo2.getyMazo() + 5.0f);
			mazo1.setvX(1.0f);
		}
		
		if(mazo2.getxMazo() > Window.getW() - mazo2.getTex().getW())	// Parte DERECHA de la pantalla
			mazo2.setxMazo(Window.getW() - mazo2.getTex().getW());
		if(mazo2.getxMazo() < Window.getW()/2)							// Si se sale de su CAMPO
			mazo2.setxMazo(Window.getW() / 2);
		if(mazo2.getyMazo() < 0)										// Parte de ARRIBA de la pantalla
			mazo2.setyMazo(0);
		if(mazo2.getyMazo() > Window.getH() - mazo2.getTex().getH())	// Parte de ABAJO de la pantalla
			mazo2.setyMazo(Window.getH() - mazo2.getTex().getH());
	}

	@Override
	protected void onDraw() {
		// Dibujando fondo
		Render.DrawTexture(texBackground, 0, 0, Window.getW(), Window.getH(), 0, new Color(255, 255, 255));
		
		// Dibujando pelota
		int wB = ball.getTex().getW();
		int hB = ball.getTex().getH();
		float xB = ball.getxBall();
		float yB = ball.getyBall();
		Render.DrawTexture(ball.getTex(), xB, yB, wB, hB, 0, new Color(255, 255, 255));
		
		// Dibujando mazo 1
		int wM1 = mazo1.getTex().getW();
		int hM1 = mazo1.getTex().getH();
		float xM1 = mazo1.getxMazo();
		float yM1 = mazo1.getyMazo();
		Render.DrawTexture(mazo1.getTex(), xM1, yM1, wM1, hM1, 0, new Color(255, 255, 255));
		
		// Dibujando mazo 2
		int wM2 = mazo2.getTex().getW();
		int hM2 = mazo2.getTex().getH();
		float xM2 = mazo2.getxMazo();
		float yM2 = mazo2.getyMazo();
		Render.DrawTexture(mazo2.getTex(), xM2, yM2, wM2, hM2, 0, new Color(255, 255, 255));
		
		// Dibujando marcador
		Render.DrawText(font, (Window.getW() / 2) - 52, 10, mazo1.getGoles() + " - " + mazo2.getGoles(), 
				new Color(255, 255, 255));
	}

	public boolean doEvent(Event e){

		switch(e.getType()) {
		
		case KEY_PRESSED:
			if (e.getValue() == Keyboard.KEY_Q) 
				App.exit(); 
			break;
		
		default:
			break;
		}
		
		return false;
	}

	private void posicionInicialObjetos(){
		acceleracionX = 0.0f;
		acceleracionY = 0.0f;
		
		// Pelota
		ball.setxBall((Window.getW() / 2.0f) - (ball.getTex().getW() / 2));
		ball.setyBall((Window.getH() / 2.0f) - (ball.getTex().getH() / 2));
				
		// Mazo 1
		mazo1.setxMazo(Window.getW() / 4.0f - mazo1.getTex().getW() / 2);
		mazo1.setyMazo(Window.getH() / 2.0f - mazo1.getTex().getH() / 2);
				
		// Mazo 2
		mazo2.setxMazo(Window.getW() / 4.0f + Window.getW() / 2.0f - mazo2.getTex().getW() / 2);
		mazo2.setyMazo(Window.getH() / 2.0f - mazo2.getTex().getH() / 2);
	}
}

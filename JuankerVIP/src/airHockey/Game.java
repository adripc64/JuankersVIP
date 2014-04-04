package airHockey;

/***
 * Nota mental:
 * 1. 
 * 2. Menu principal.
 * 3. Menu cuando ganas la partida.
 * 4. Revisar cuando los dos mazos chocan con la pelota a la vez.
 * 5. Parpadear el texto.
 * 6. Colisiones 
 * 		// http://www.fis.puc.cl/~rbenguri/ESTATICADINAMICA/cap4.pdf
		// http://stackoverflow.com/questions/1736734/circle-circle-collision
 * 7. 
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
import fge.Sound;
import fge.Texture;
import fge.Window;

public class Game extends Service implements EventListener {
	private Font font;
	private Texture texBackground;
	
	private Ball ball;
	private float componenteXBall;
	private float componenteYBall;
	
	private Mazo mazo1;
	private Mazo mazo2;
	private int velocidadMazo;
	
	private Sound sonidoGol;
	private int durationGol = 5000;
	private long timeGol1 = 0;
	private long timeGol2 = 0;
	
	public Game(){
		font = new Font("data/COMIC.ttf", 48.0f);
		
		// Fondo de pantalla
		texBackground = new Texture("data/airhockey/campo2.0.png");

		// Inicializando pelota
		ball = new Ball(100.0f);	//Rozamiento que se le aplica a la pelota
		
		// Inicializando mazos
		mazo1 = new Mazo(new Color(255, 255, 255));
		mazo2 = new Mazo(new Color(255, 255, 0));
		
		velocidadMazo = 350;		// Constante
		sonidoGol = new Sound("data/airhockey/sounds/gol.ogg");
		
		EventMan.addListener(this);
	}
	
	@Override
	public void onStart() {		
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
		if( ball.getyBall() < ball.getRadius() )	{
			ball.setyBall(ball.getRadius());
			componenteYBall = componenteYBall * (-1);		// Rebota
		}

		// Parte de ABAJO de la pantalla
		if( ball.getyBall() > Window.getH() - ball.getRadius() ) {
			ball.setyBall( Window.getH() - ball.getRadius() );
			componenteYBall = componenteYBall * (-1);		// Rebota
		}
		
		// Parte DERECHA de la pantalla
		if(ball.getxBall() > Window.getW() - ball.getRadius()) {	
			// Marca gol mazo1 SII x: Window.getW() y: desde (180 - alturaPelota / 2) 
			// hasta (332 + alturaPelota / 2) --> Tamaño porteria: 152 + alturaPelota
			if(ball.getyBall() > (180 - ball.getTex().getH() / 2 ) && (ball.getyBall() + ball.getTex().getH() / 2 ) < 332) {
				posicionInicialObjetos();		// Volver a posicion inicial
				golMazo1();						// Realizar las operaciones al marcar
			}
			else
				ball.setxBall(Window.getW() - ball.getRadius());
				componenteXBall = componenteXBall * (-1);	// Rebota
		}
		
		// Parte IZQUIERDA de la pantalla
		if(ball.getxBall() < ball.getRadius())	{										
			// Marca gol mazo2 SII x: 0 y: desde (180 - alturaPelota / 2) 
			// hasta (332 + alturaPelota / 2) --> Tamaño porteria: 152 + alturaPelota
			if(ball.getyBall() > (180 - ball.getTex().getH() / 2 ) && (ball.getyBall() + ball.getTex().getH() / 2 ) < 332) {
				posicionInicialObjetos();		// Volver a posicion inicial
				golMazo2();						// Realizar las operaciones al marcar
			} else
				ball.setxBall(ball.getRadius());
				componenteXBall = componenteXBall * (-1);	// Rebota
		}
		
		// Choca el mazo 1 con la pelota 
		if(Intersect.CircleWithCircle(mazo1.getxMazo(), mazo1.getyMazo(), mazo1.getTex().getH() / 2, ball.getxBall(), ball.getyBall(), ball.getTex().getH() / 2)) {
			ball.setVelocidad( ball.getVelocidad() + 100 );
			// Formula: senB = b / (R1 + R2)
			float anguloColision = ( ball.getyBall() - mazo1.getyMazo() ) / ( mazo1.getTex().getW() / 2.0f + ball.getTex().getW() / 2.0f );
		
			// Direccion de la pelota X
			if( mazo1.getxMazo() < ball.getxBall() ) 
				componenteXBall = (1 - Math.abs(anguloColision));
			else
				componenteXBall = (1 - Math.abs(anguloColision)) * (-1);
			
			// Direccion de la pelota Y, especificada la direccion en la formula al hacer la resta de Y1 e Y2
			componenteYBall = anguloColision;
		}
		
		// Choca el mazo 2 con la pelota 
		if(Intersect.CircleWithCircle(mazo2.getxMazo(), mazo2.getyMazo(), mazo2.getTex().getH() / 2.0f, ball.getxBall(), ball.getyBall(), ball.getTex().getH() / 2.0f)) {
			ball.setVelocidad( ball.getVelocidad() + 100 );	
			// Formula: senB = b / (R1 + R2)
			float anguloColision2 = (ball.getyBall() - mazo2.getyMazo() ) 
					/ ( mazo2.getTex().getW() / 2 + ball.getTex().getW() / 2);
			
			// Direccion de la pelota X
			if( mazo2.getxMazo() < ball.getxBall() ) 
				componenteXBall = (1 - Math.abs(anguloColision2));
			else
				componenteXBall = (1 - Math.abs(anguloColision2)) * (-1);
			
			// Direccion de la pelota Y, especificada la direccion en la formula al hacer la resta de Y1 e Y2
			componenteYBall = anguloColision2;
		}		
		
		// Topes para la velocidad de la pelota
		if(ball.getVelocidad() > 1000)	// Tope por arriba de la velocidad
			ball.setVelocidad(1000);
		if(ball.getVelocidad() < 0)		// Tope por abajo de la velocidad
			ball.setVelocidad(0);
		if(ball.isMoving())	// Rozamiento de la pelota
			ball.setVelocidad( ball.getVelocidad() - ball.getRozamiento() * App.getFTime() );		
		
		// Moviendo la pelota		
		ball.setxBall(ball.getxBall() + componenteXBall * ball.getVelocidad() * App.getFTime());	// Componente X
		ball.setyBall(ball.getyBall() + componenteYBall * ball.getVelocidad() * App.getFTime());	// Componente Y
	}

	private void moveMazo1(){
//		
//		mazo1.setxMazo(Mouse.getX());
//		mazo1.setyMazo(Mouse.getY());
		
		// Moviendo el mazo 1
		mazo1.setxMazo(mazo1.getxMazo() + mazo1.getvX() * App.getFTime());	// Componente X
		mazo1.setyMazo(mazo1.getyMazo() + mazo1.getvY() * App.getFTime());	// Componente Y
			
		// Colisiones de pantalla
		if(mazo1.getxMazo() < mazo1.getRadius())					// Parte izquierda de la pantalla
			mazo1.setxMazo(mazo1.getRadius());
		if(mazo1.getxMazo() > Window.getW()/2 - mazo1.getRadius())	// Si se sale de su CAMPO
			mazo1.setxMazo(Window.getW()/2 - mazo1.getRadius());
		if(mazo1.getyMazo() < mazo1.getRadius())					// Parte de ARRIBA de la pantalla
			mazo1.setyMazo(mazo1.getRadius());
		if(mazo1.getyMazo() > Window.getH() - mazo1.getRadius())	// Parte de ABAJO de la pantalla
			mazo1.setyMazo(Window.getH() - mazo1.getRadius());
	}
	
	private void moveMazo2(){
		// Moviendo el mazo 1
		mazo2.setxMazo(mazo2.getxMazo() + mazo2.getvX() * App.getFTime());	// Componente X
		mazo2.setyMazo(mazo2.getyMazo() + mazo2.getvY() * App.getFTime());	// Componente Y
				
		// Colisiones de pantalla
		if(mazo2.getxMazo() > Window.getW() - mazo2.getRadius())	// Parte DERECHA de la pantalla
			mazo2.setxMazo(Window.getW() - mazo2.getRadius());
		if(mazo2.getxMazo() < Window.getW()/2 + mazo2.getRadius())	// Si se sale de su CAMPO
			mazo2.setxMazo(Window.getW()/2 + mazo2.getRadius());
		if(mazo2.getyMazo() < mazo2.getRadius())						// Parte de ARRIBA de la pantalla
			mazo2.setyMazo(mazo2.getRadius());
		if(mazo2.getyMazo() > Window.getH() - mazo2.getRadius())	// Parte de ABAJO de la pantalla
			mazo2.setyMazo(Window.getH() - mazo2.getRadius());
	}

	@Override
	protected void onDraw() {
		Color color = new Color(255, 255, 255);	// Color por defecto al dibujar
		
		// Dibujando fondo
		Render.DrawTexture(texBackground, 0, 0, Window.getW(), Window.getH(), 0, color);
		
		// Dibujando pelota
		ball.draw();
		
		// Dibujando los mazos
		mazo1.draw();		
		mazo2.draw();
		
		// Dibujando marcador
		Render.DrawText(font, (Window.getW() / 2) - 52, 10, mazo1.getGoles() + " - " + mazo2.getGoles(), color);
			
		// Dibujando cuando se marca un gol
		Color colorGol = new Color(255,255,0);
		String mensajeGol = "¡¡GOL!!";
		int tamañoLetrero = mensajeGol.length() * font.getFontSize();
		if(App.getTime() - timeGol1 < durationGol)
			Render.DrawText(font, (Window.getW()/4) - (tamañoLetrero / 4), 25, mensajeGol, colorGol);
		if(App.getTime() - timeGol2 < durationGol)
			Render.DrawText(font, (Window.getW()/2) + (Window.getW()/4) - (tamañoLetrero / 4), 25, mensajeGol, colorGol);
	}

	public boolean doEvent(Event e){

		switch(e.getType()) {
		
		case KEY_PRESSED:
			if (e.getValue() == Keyboard.KEY_Q) {	// Finalizar juego
				App.exit();
			}
			
			if (e.getValue() == Keyboard.KEY_SPACE){
				if (isPaused()) resume();
				else pause();
			}
			
			// Movimiento Mazo 1
			if (e.getValue() == Keyboard.KEY_A)
				mazo1.setvX(-velocidadMazo);
			
			if (e.getValue() == Keyboard.KEY_W)
				mazo1.setvY(-velocidadMazo);
			
			if (e.getValue() == Keyboard.KEY_D)
				mazo1.setvX(velocidadMazo);
			
			if (e.getValue() == Keyboard.KEY_S)
				mazo1.setvY(velocidadMazo);
			
			// Movimiento Mazo 2
			if (e.getValue() == Keyboard.KEY_LEFT)
				mazo2.setvX(-velocidadMazo);
			
			if (e.getValue() == Keyboard.KEY_RIGHT)
				mazo2.setvX(velocidadMazo);
			
			if (e.getValue() == Keyboard.KEY_UP)
				mazo2.setvY(-velocidadMazo);
			
			if (e.getValue() == Keyboard.KEY_DOWN)
				mazo2.setvY(velocidadMazo);
			break;
			
		case KEY_RELEASED:
			
			// Movimiento mazo 1
			if (e.getValue() == Keyboard.KEY_A)
				mazo1.setvX(0);
			
			if (e.getValue() == Keyboard.KEY_W)
				mazo1.setvY(0);
			
			if (e.getValue() == Keyboard.KEY_D)
				mazo1.setvX(0);
			
			if (e.getValue() == Keyboard.KEY_S)
				mazo1.setvY(0);
			
			// Movimiento mazo 2
			if (e.getValue() == Keyboard.KEY_LEFT)
				mazo2.setvX(0);
			
			if (e.getValue() == Keyboard.KEY_RIGHT)
				mazo2.setvX(0);
			
			if (e.getValue() == Keyboard.KEY_UP)
				mazo2.setvY(0);
			
			if (e.getValue() == Keyboard.KEY_DOWN)
				mazo2.setvY(0);	
			break;
		
		default:
			break;
		}
		
		return false;
	}

	private void posicionInicialObjetos(){
		componenteXBall = 0.0f;
		componenteYBall = 0.0f;
		
		// Pelota
		ball.setxBall((Window.getW() * 0.5f));
		ball.setyBall((Window.getH() * 0.5f));		
		// Mazo 1
		mazo1.setxMazo(Window.getW() * 0.25f);
		mazo1.setyMazo(Window.getH() * 0.5f);			
		// Mazo 2
		mazo2.setxMazo(Window.getW() * 0.75f);
		mazo2.setyMazo(Window.getH() * 0.5f);
	}
	
	private void golMazo1() {
		sonidoGol.play(false);					// Lanzar sonido de gol
		timeGol1 = App.getTime();				// Momento en el que se marca el gol
		mazo1.setGoles(mazo1.getGoles() + 1);	// Incrementar los goles
		
		ball.setxBall((Window.getW()/8) + (Window.getW()/2)); // Pelota en el campo del mazo 2
		mazo1.cambiarImagenGol(mazo1.getGoles());
	}
	
	private void golMazo2() {
		sonidoGol.play(false);					// Lanzar sonido de gol
		timeGol2 = App.getTime();				// Momento en el que se marca el gol
		mazo2.setGoles(mazo2.getGoles() + 1);	// Incrementar los goles
		
		ball.setxBall((Window.getW()/8) + (Window.getW()/4) - ball.getTex().getW()); // Pelota en el campo del mazo 1
		mazo2.cambiarImagenGol(mazo2.getGoles());
	}
}

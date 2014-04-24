package airHockey4;

/***
 * Nota mental:
 * - Colisiones 
 * 		// http://www.fis.puc.cl/~rbenguri/ESTATICADINAMICA/cap4.pdf
		// http://stackoverflow.com/questions/1736734/circle-circle-collision
 * - Los eventos de las teclas no van bien, se mezclan y si apreto por ejemplo a la izquierda y
 * 	 a la derecha debería de quedarse quieto y no es así.
 * 
 * - FORMA DE JUEGO: A los 5 goles los jugadores (mazos) se van eliminando, al que no le metan 
 *   los 5 goles gana la partida. Una vez un contrincante está eliminado se elimina el objeto 
 *   (portería) y así este ya no puede contabilizar más goles.
 */

import fge.App;
import fge.Color;
import fge.Event;
import fge.EventListener;
import fge.EventMan;
import fge.Font;
import fge.Intersect;
import fge.Keyboard;
import fge.Mouse;
import fge.Render;
import fge.Service;
import fge.Sound;
import fge.Texture;
import fge.Window;

public class Game extends Service implements EventListener {
	private Font font;
	private Texture texBackground;
	
	// Pelota
	private Ball ball;
	private float componenteXBall;
	private float componenteYBall;
	
	// Mazos
	private Mazo mazo1;
	private Mazo mazo2;
	private Mazo mazo3;
	private Mazo mazo4;
	private int velocidadMazo;
	
	// Cuando se marca un gol
	private Sound sonidoGol;
	private int durationGol = 5000;
	private long timeGol1 = 0;
	private long timeGol2 = 0;
	
	private boolean ratonApretado;
	
	public Game() {
		font = new Font("data/COMIC.ttf", 48.0f);
		
		// Fondo de pantalla
		texBackground = new Texture("data/airhockey/campo2.0.png");

		// Inicializando pelota
		ball = new Ball(100.0f);
		
		// Inicializando mazos
		mazo1 = new Mazo(new Color(255, 255, 255));
		mazo2 = new Mazo(new Color(255, 255, 0));
		mazo3 = new Mazo(new Color(255, 0, 0));
		mazo4 = new Mazo(new Color(255, 0, 255));
		velocidadMazo = 350;		// Constante
		
		sonidoGol = new Sound("data/airhockey/sounds/gol.ogg");
		ratonApretado = false;
		
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
		
		moveBall();		// Movimiento de la pelota
		moveMazo1();	// Movimiento del mazo 1
		moveMazo2();	// Movimiento del mazo 2
		moveMazo3();	// Movimiento del mazo 3
		moveMazo4();	// Movimiento del mazo 4
	
		// Que los mazos no se puedan alinear nunca
		if(mazo1.gety() == mazo2.gety()) {
			mazo2.sety(mazo2.gety() + 0.01f);
			mazo1.sety(mazo1.gety() - 0.01f);
		}
		
		if(mazo3.getx() == mazo4.getx()) {
			mazo4.setx(mazo4.getx() + 0.01f);
			mazo3.setx(mazo3.getx() - 0.01f);
		}
	}
	
	private void moveBall() {		
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
		
		if(Intersect.CircleWithCircle(mazo1.getx(), mazo1.gety(), mazo1.getTex().getH() * 0.5f, ball.getxBall(), ball.getyBall(), ball.getTex().getH() * 0.5f))
			chocaMazo1Pelota();
		
		if(Intersect.CircleWithCircle(mazo2.getx(), mazo2.gety(), mazo2.getTex().getH() * 0.5f, ball.getxBall(), ball.getyBall(), ball.getTex().getH() * 0.5f))
			chocaMazoPelota(mazo2);
		
		if(Intersect.CircleWithCircle(mazo3.getx(), mazo3.gety(), mazo3.getTex().getH() * 0.5f, ball.getxBall(), ball.getyBall(), ball.getTex().getH() * 0.5f))
			chocaMazoPelota(mazo3);
		
		if(Intersect.CircleWithCircle(mazo4.getx(), mazo4.gety(), mazo4.getTex().getH() * 0.5f, ball.getxBall(), ball.getyBall(), ball.getTex().getH() * 0.5f))
			chocaMazoPelota(mazo4);
		
		// Topes para la velocidad de la pelota
		if(ball.getVelocidad() > 1500)	// Tope por arriba de la velocidad
			ball.setVelocidad(1500);
		if(ball.getVelocidad() < 0)		// Tope por abajo de la velocidad
			ball.setVelocidad(0);
		if(ball.isMoving())	// Rozamiento de la pelota
			ball.setVelocidad( ball.getVelocidad() - ball.getRozamiento() * App.getFTime() );		
		
		// Moviendo la pelota		
		ball.setxBall(ball.getxBall() + componenteXBall * ball.getVelocidad() * App.getFTime());	// Componente X
		ball.setyBall(ball.getyBall() + componenteYBall * ball.getVelocidad() * App.getFTime());	// Componente Y
	}

	private void chocaMazo1Pelota() {
		float anguloColision;
		// Incrementar velocidad de la pelota
		if(ratonApretado)
			ball.setVelocidad( ball.getVelocidad() + Mouse.getDX() * 50 + Mouse.getDY() * 50 );
		else
			ball.setVelocidad( ball.getVelocidad() + 100 );

		// Formula colision: senB = b / (R1 + R2)
		anguloColision = ( ball.getyBall() - mazo1.gety() ) / ( mazo1.getTex().getW() / 2.0f + ball.getTex().getW() / 2.0f );

		// Direccion de la pelota X
		if( mazo1.getx() < ball.getxBall() ) 
			componenteXBall = (1 - Math.abs(anguloColision));
		else
			componenteXBall = (1 - Math.abs(anguloColision)) * (-1);
		
		// Direccion de la pelota Y, especificada la direccion en la formula al hacer la resta de Y1 e Y2
		componenteYBall = anguloColision;
	}

	private void chocaMazoPelota(Mazo mazo) {
		float anguloColision;
		ball.setVelocidad( ball.getVelocidad() + 100 );		// Incrementar velocidad de la pelota
		
		// Formula colision: senB = b / (R1 + R2)
		anguloColision = (ball.getyBall() - mazo.gety() ) / ( mazo.getTex().getW() / 2 + ball.getTex().getW() / 2);
		
		// Direccion de la pelota X
		if( mazo.getx() < ball.getxBall() ) 
			componenteXBall = (1 - Math.abs(anguloColision));
		else
			componenteXBall = (1 - Math.abs(anguloColision)) * (-1);
		
		// Direccion de la pelota Y, especificada la direccion en la formula al hacer la resta de Y1 e Y2
		componenteYBall = anguloColision;
	}

	private void moveMazo1() {
		// Moviendo el mazo 1
//		if(ratonApretado) {
//			mazo1.setx(Mouse.getX());
//			mazo1.sety(Mouse.getY());
//		}
		
		mazo1.setx(mazo1.getx() + mazo1.getvX() * App.getFTime());	// Componente X
		mazo1.sety(mazo1.gety() + mazo1.getvY() * App.getFTime());	// Componente Y	
		
		// Colisiones de pantalla
		mazo1.limitesPantalla(0, Window.getW()/2, 0, Window.getH());
	}
	
	private void moveMazo2() {
		// Moviendo el mazo 2
		mazo2.setx(mazo2.getx() + mazo2.getvX() * App.getFTime());	// Componente X
		mazo2.sety(mazo2.gety() + mazo2.getvY() * App.getFTime());	// Componente Y
		
		// Colisiones de pantalla
		mazo2.limitesPantalla(Window.getW()/2, Window.getW(), 0, Window.getH());
	}
	
	private void moveMazo3() {
		// Moviendo el mazo 2
		mazo3.setx(mazo3.getx() + mazo3.getvX() * App.getFTime());	// Componente X
		mazo3.sety(mazo3.gety() + mazo3.getvY() * App.getFTime());	// Componente Y
		
		// Colisiones de pantalla
		mazo3.limitesPantalla(0, Window.getW(), 0, Window.getH()/2);
	}
	
	private void moveMazo4() {
		// Moviendo el mazo 2
		mazo4.setx(mazo4.getx() + mazo4.getvX() * App.getFTime());	// Componente X
		mazo4.sety(mazo4.gety() + mazo4.getvY() * App.getFTime());	// Componente Y
		
		// Colisiones de pantalla
		mazo4.limitesPantalla(0, Window.getW(), Window.getH()/2, Window.getH());
	}

	@Override
	protected void onDraw() {
		Color color = new Color(255, 255, 255);	// Color por defecto al dibujar
		
		// Dibujando fondo
		Render.DrawTexture(texBackground, 0, 0, color);

		// Dibujando pelota
		ball.draw();
		
		// Dibujando los mazos
		mazo1.draw();		
		mazo2.draw();
		mazo3.draw();
		mazo4.draw();
		
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

	public boolean doEvent(Event e) {

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
			
			// Movimiento Mazo 3
			if (e.getValue() == Keyboard.KEY_I)
				mazo3.setvX(-velocidadMazo);
			if (e.getValue() == Keyboard.KEY_P)
				mazo3.setvX(velocidadMazo);
			if (e.getValue() == Keyboard.KEY_9)
				mazo3.setvY(-velocidadMazo);
			if (e.getValue() == Keyboard.KEY_O)
				mazo3.setvY(velocidadMazo);
			
			// Movimiento Mazo 4
			if (e.getValue() == Keyboard.KEY_V)
				mazo4.setvX(-velocidadMazo);
			if (e.getValue() == Keyboard.KEY_N)
				mazo4.setvX(velocidadMazo);
			if (e.getValue() == Keyboard.KEY_G)
				mazo4.setvY(-velocidadMazo);
			if (e.getValue() == Keyboard.KEY_B)
				mazo4.setvY(velocidadMazo);
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
			
			// Movimiento Mazo 3
			if (e.getValue() == Keyboard.KEY_I)
				mazo3.setvX(0);
			if (e.getValue() == Keyboard.KEY_P)
				mazo3.setvX(0);
			if (e.getValue() == Keyboard.KEY_9)
				mazo3.setvY(0);
			if (e.getValue() == Keyboard.KEY_O)
				mazo3.setvY(0);
			
			// Movimiento Mazo 4
			if (e.getValue() == Keyboard.KEY_V)
				mazo4.setvX(0);
			if (e.getValue() == Keyboard.KEY_N)
				mazo4.setvX(0);
			if (e.getValue() == Keyboard.KEY_G)
				mazo4.setvY(0);
			if (e.getValue() == Keyboard.KEY_B)
				mazo4.setvY(0);
			break;
			
		case MOUSE_PRESSED:
			ratonApretado = true;
			break;
			
		case MOUSE_RELEASED:	
			ratonApretado = false;
			break;
		
		default:
			break;
		}
		
		return false;
	}

	private void posicionInicialObjetos() {
		componenteXBall = 0.0f;
		componenteYBall = 0.0f;
		
		ratonApretado = false;
		
		// Pelota
		ball.setxBall((Window.getW() * 0.5f));
		ball.setyBall((Window.getH() * 0.5f));		
		// Mazo 1
		mazo1.setx(Window.getW() * 0.25f);
		mazo1.sety(Window.getH() * 0.5f);			
		// Mazo 2
		mazo2.setx(Window.getW() * 0.75f);
		mazo2.sety(Window.getH() * 0.5f);
		// Mazo 3
		mazo3.setx(Window.getW() * 0.5f);
		mazo3.sety(Window.getH() * 0.25f);
		// Mazo 4
		mazo4.setx(Window.getW() * 0.5f);
		mazo4.sety(Window.getH() * 0.75f);
	}
	
	private void golMazo1() {
		sonidoGol.play(false);					// Lanzar sonido de gol
		timeGol1 = App.getTime();				// Momento en el que se marca el gol
		mazo1.setGoles(mazo1.getGoles() + 1);	// Incrementar los goles
		
		ball.setxBall( Window.getW() * 0.125f  + Window.getW() * 0.5f ); // Pelota en el campo del mazo 2
		ball.setVelocidad(0.0f);
		mazo1.cambiarImagenGol(mazo1.getGoles());
	}
	
	private void golMazo2() {
		sonidoGol.play(false);					// Lanzar sonido de gol
		timeGol2 = App.getTime();				// Momento en el que se marca el gol
		mazo2.setGoles(mazo2.getGoles() + 1);	// Incrementar los goles
		
		ball.setxBall( Window.getW() * 0.125f + Window.getW() * 0.25f ); // Pelota en el campo del mazo 1
		ball.setVelocidad(0.0f);
		mazo2.cambiarImagenGol(mazo2.getGoles());
	}
}

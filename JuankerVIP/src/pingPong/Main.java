package pingPong;

import fge.*;

public class Main extends Service implements EventListener{
	private final static int WINDOW_WIDTH = 640;
	private final static int WINDOW_HEIGHT = 640;
	Color blanco = new Color(255,255,255);
	private Font font;
	private Color fontColor;
	private Texture bola;
	private Texture player1;
	private Texture player2;
	private Texture fondo;
	private Marcador marcador;
	private boolean outOfScreen = false;
	
	Raqueta jugador1 = new Raqueta(1);
	Raqueta jugador2 = new Raqueta(2);
	Pelota pelota = new Pelota();
	
	public static void main(String[] args) {
		App.run(new Main(), WINDOW_WIDTH, WINDOW_HEIGHT);

	}

	@Override
	protected void onStart() {
		EventMan.addListener(this);
		font = new Font("data/COMIC.TTF", 18);
		fontColor = new Color(255,255,0);
		bola = new Texture("data/ping pong/Bola.png");
		player1 = new Texture("data/ping pong/Raqueta1.png");
		player2 = new Texture("data/ping pong/Raqueta2.png");
		fondo = new Texture("data/ping pong/background1.jpg");
		marcador = new Marcador(0, 0);

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
		
//		jugador2.posY = (pelota.posY-75);
//		jugador1.posY = (pelota.posY-75);
		
		//PLAYER 1
		if (Keyboard.isKeyPressed(Keyboard.KEY_W)) jugador1.posY -= Raqueta.velocidad;
		if (Keyboard.isKeyPressed(Keyboard.KEY_S)) jugador1.posY += Raqueta.velocidad;
		if (jugador1.posY < 0) jugador1.posY = 0;
		if (jugador1.posY > WINDOW_HEIGHT - Raqueta.alturaRaqueta) jugador1.posY = WINDOW_HEIGHT - Raqueta.alturaRaqueta;

		//PLAYER 2
		if (Keyboard.isKeyPressed(Keyboard.KEY_UP)) jugador2.posY -= Raqueta.velocidad;
		if (Keyboard.isKeyPressed(Keyboard.KEY_DOWN)) jugador2.posY += Raqueta.velocidad;
		if (jugador2.posY < 0) jugador2.posY = 0;
		if (jugador2.posY > WINDOW_HEIGHT - Raqueta.alturaRaqueta) jugador2.posY = WINDOW_HEIGHT - Raqueta.alturaRaqueta;
		
		//PELOTA
		pelota.posX += Math.cos(Misc.DegToRad(Pelota.angulo)) * Pelota.velocidad * App.getFTime();
		pelota.posY -= Math.sin(Misc.DegToRad(Pelota.angulo)) * Pelota.velocidad * App.getFTime();
		if (pelota.posY <= 0) Pelota.angulo = 360 - Pelota.angulo; 
		if (pelota.posY >= WINDOW_HEIGHT - Pelota.diametro) Pelota.angulo = 360 - Pelota.angulo;
		
		
		// Colisiones con las raquetas
		if (pelota.posX <= Raqueta.getGrosorRaqueta() && pelota.posY >= jugador1.posY && pelota.posY <= jugador1.posY + Raqueta.alturaRaqueta){
			Pelota.angulo = 180 - Pelota.angulo;
			pelota.posX = Raqueta.getGrosorRaqueta();
			outOfScreen = false;
		}
		
		if (pelota.posX + Pelota.diametro >= WINDOW_WIDTH - Raqueta.getGrosorRaqueta() && pelota.posY >= jugador2.posY && pelota.posY <= jugador2.posY + Raqueta.alturaRaqueta){
			Pelota.angulo = 180- Pelota.angulo;
			pelota.posX = WINDOW_WIDTH - Raqueta.getGrosorRaqueta() - Pelota.diametro;
			outOfScreen = false;
		}
		
		if (!outOfScreen && pelota.posX <= 0){
			marcador.incrementarScore2();
			outOfScreen = true;
			pelota.posX = Raqueta.getGrosorRaqueta();
			pelota.posY = (jugador1.posY - Pelota.diametro) /2;
		}
		if (!outOfScreen && pelota.posX >= WINDOW_WIDTH){
			marcador.incrementarScore1();
			outOfScreen = true;
		}
		
		System.out.println(marcador.mostrarMarcador());
		
	}

	@Override
	protected void onDraw() {
		Render.DrawTexture(fondo, 0, 0, blanco);
		Render.DrawTexture(player1, jugador1.posX, jugador1.posY, blanco);
		Render.DrawTexture(player2, jugador2.posX, jugador2.posY, blanco);
		Render.DrawTexture(bola, pelota.getX(), pelota.getY(), blanco);
		Render.DrawText(font, WINDOW_WIDTH /2 -5, 25, marcador.mostrarMarcador(), fontColor);
	}

	@Override
	public boolean doEvent(Event e) {
		// TODO Auto-generated method stub
		return false;
	}

//	public boolean doEvent(Event e) {
//
//		switch (e.getType()) {
//			case KEY_PRESSED:
//				if (e.getValue() == Keyboard.KEY_LEFT) playerSpeedX -= horizontalSpeed;
//				if (e.getValue() == Keyboard.KEY_RIGHT) playerSpeedX += horizontalSpeed;
//				if (e.getValue() == Keyboard.KEY_UP && !playerFalling) {
//					playerFalling = true;
//					playerSpeedY -= jumpSpeed; 
//				}
//				break;
//			case KEY_RELEASED:
//				if (e.getValue() == Keyboard.KEY_LEFT) playerSpeedX += horizontalSpeed;
//				if (e.getValue() == Keyboard.KEY_RIGHT) playerSpeedX -= horizontalSpeed;
//				break;
//			default:
//				break;
//		}
		
//		return false;
//	}
	
	
	
	public static float getHeight(){
		return WINDOW_HEIGHT;
	}

	public static float getWidth() {
		return WINDOW_WIDTH;
	}
	
}

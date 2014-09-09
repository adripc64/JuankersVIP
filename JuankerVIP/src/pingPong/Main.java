package pingPong;

import fge.*;

public class Main extends Service implements EventListener{
	private final static int WINDOW_WIDTH = 640;
	private final static int WINDOW_HEIGHT = 640;
	float grosorRaqueta = 20;
	float alturaRaqueta = 150;
	float player1X = 0;
	float player1Y = WINDOW_HEIGHT/2 - alturaRaqueta/2;
	float player2X = WINDOW_WIDTH - grosorRaqueta;
	float player2Y = WINDOW_HEIGHT/2 - alturaRaqueta/2;
	Color rojo = new Color(255, 0, 0);
	Color azul = new Color(0, 0, 255);
	Color blanco = new Color(255,255,255);
	float radioPelota = 12.5f;
	float velocidadRaqueta = 15;
	float velocidadPelota = 500;
	float pelotaX = player1X + grosorRaqueta + radioPelota;
	float pelotaY = WINDOW_HEIGHT/2;
	float anguloDireccion = 60;
	private Font font;
	private Color fontColor;
	private Texture bola;
	private Texture player1;
	private Texture player2;
	
	
	
	
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
		
		//PLAYER 1
		if (Keyboard.isKeyPressed(Keyboard.KEY_W)) player1Y -= velocidadRaqueta;
		if (Keyboard.isKeyPressed(Keyboard.KEY_S)) player1Y += velocidadRaqueta;
		if (player1Y < 0) player1Y = 0;
		if (player1Y > WINDOW_HEIGHT - alturaRaqueta) player1Y = WINDOW_HEIGHT - alturaRaqueta;

		//PLAYER 2
		if (Keyboard.isKeyPressed(Keyboard.KEY_UP)) player2Y -= velocidadRaqueta;
		if (Keyboard.isKeyPressed(Keyboard.KEY_DOWN)) player2Y += velocidadRaqueta;
		if (player2Y < 0) player2Y = 0;
		if (player2Y > WINDOW_HEIGHT - alturaRaqueta) player2Y = WINDOW_HEIGHT - alturaRaqueta;
		
		//PELOTA
		pelotaX += Math.cos(Misc.DegToRad(anguloDireccion)) * velocidadPelota * App.getFTime();
		pelotaY -= Math.sin(Misc.DegToRad(anguloDireccion)) * velocidadPelota * App.getFTime();
		if (pelotaY <= 0 + radioPelota) anguloDireccion = 360 - anguloDireccion; 
		if (pelotaY >= WINDOW_HEIGHT - radioPelota) anguloDireccion = 360 - anguloDireccion;
		// Colisiones con las raquetas
		if (pelotaX - radioPelota <= grosorRaqueta && pelotaY >= player1Y && pelotaY <= player1Y + alturaRaqueta){
			if (hemisferioAngulo(anguloDireccion) == 1){
				anguloDireccion = 180 - anguloDireccion;
				pelotaX = radioPelota + grosorRaqueta;
			} else {
				anguloDireccion = 180 - anguloDireccion;
				pelotaX = radioPelota + grosorRaqueta;
			}
		
		}
		
		if (pelotaX + radioPelota >= WINDOW_WIDTH - grosorRaqueta && pelotaY >= player2Y && pelotaY <= player2Y + alturaRaqueta){
			if (hemisferioAngulo(anguloDireccion) == 1){
				anguloDireccion = 180 - anguloDireccion;
				pelotaX = WINDOW_WIDTH - grosorRaqueta - radioPelota;
			} else {
				anguloDireccion = 180 - anguloDireccion;
				pelotaX = WINDOW_WIDTH - grosorRaqueta - radioPelota;
			}
		}
		
	}

	@Override
	protected void onDraw() {
		Render.DrawTexture(player1, player1X, player1Y, blanco);
//		Render.DrawFilledRectangle(player1X, player1Y, grosorRaqueta, alturaRaqueta, azul);
		Render.DrawTexture(player2, player2X, player2Y, blanco);
//		Render.DrawFilledRectangle(player2X, player2Y, grosorRaqueta, alturaRaqueta, rojo);
		Render.DrawTexture(bola, pelotaX-radioPelota, pelotaY-radioPelota, blanco);
//		Render.DrawFilledCircle(pelotaX, pelotaY, radioPelota, blanco);	
		
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
	
	
	public int hemisferioAngulo(float angulo){
		if (angulo >= 0 && angulo <= 180) return 1;
		else return 2;
	}
	
}

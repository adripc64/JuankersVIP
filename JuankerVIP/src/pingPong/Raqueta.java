package pingPong;

public class Raqueta {
	static float grosorRaqueta = 25;
	static float alturaRaqueta = 150;
	float posX;
	float posY;
	static float velocidad = 15;
	
	public Raqueta(int jugador){
		switch (jugador){
		case 1:
			posX = 0;
			posY = Main.getHeight()/2 - alturaRaqueta/2;
			break;
		case 2:
			posX =  Main.getWidth() - grosorRaqueta;
			posY =  Main.getHeight()/2 - alturaRaqueta/2;
			break;
		}
	}
	
	public static float getGrosorRaqueta(){
		return grosorRaqueta;
	}

	public static float getAlturaRaqueta(){
		return alturaRaqueta;
	}
	
	
	
	
	
	
}

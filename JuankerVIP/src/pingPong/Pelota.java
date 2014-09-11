package pingPong;

public class Pelota {
	static float diametro = 25;
	static float velocidad = 500;
	float posX = Raqueta.getGrosorRaqueta();
	float posY = Main.getHeight()/2;
	static float angulo = 60;
	
	
	public float getX() {
		return posX;
	}
	public float getY() {
		return posY;
	}
}

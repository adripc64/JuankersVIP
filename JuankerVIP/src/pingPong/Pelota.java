package pingPong;

public class Pelota {
	static float diametro = 25;
	static float velocidad = 10;
	float posX = Raqueta.getGrosorRaqueta();
	float posY = Main.getHeight()/2;
	float angulo = 60;
	
	
	public float getX() {
		return posX;
	}
	public float getY() {
		return posY;
	}
	
	public float getAngulo(){
		while (angulo < 0) angulo += 360;
		while (angulo >= 360) angulo -= 360;
		return angulo;
	}
	
}

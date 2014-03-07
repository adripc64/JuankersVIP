package airHockey;

import fge.Texture;

public class Mazo {
	private Texture tex;
	private float xMazo;		// Posicion x del mazo
	private float yMazo;		// Posicion y del mazo
	private int goles = 0;		// Numero de goles
	private float vX = 0;		// Volicidad x del mazo
	private float vY = 0;		// Velocidad y del mazo
	
	public float getvX() {
		return vX;
	}

	public void setvX(float vX) {
		this.vX = vX;
	}

	public float getvY() {
		return vY;
	}

	public void setvY(float vY) {
		this.vY = vY;
	}

	public int getGoles() {
		return goles;
	}

	public void setGoles(int goles) {
		this.goles = goles;
	}
 
	public Mazo(){
		tex = new Texture("data/airhockey/mazo_blanco.png");
	}

	public Texture getTex() {
		return tex;
	}

	public void setTex(Texture tex) {
		this.tex = tex;
	}

	public float getxMazo() {
		return xMazo;
	}

	public void setxMazo(float xMazo) {
		this.xMazo = xMazo;
	}

	public float getyMazo() {
		return yMazo;
	}

	public void setyMazo(float yMazo) {
		this.yMazo = yMazo;
	}
}

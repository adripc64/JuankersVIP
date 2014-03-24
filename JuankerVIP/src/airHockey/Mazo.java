package airHockey;

import fge.Texture;

public class Mazo {
	private Texture tex;
	private float xMazo;	// Posicion X del mazo
	private float yMazo;	// Posicion Y del mazo
	private int goles;		// Goles del mazo
	private float vX;		// Velocidad X del mazo
	private float vY;		// Velocidad Y del mazo
	
	public Mazo(){
		goles = 0;
		tex = new Texture("data/airhockey/mazo_blanco.png");
	}
	
	public int getGoles() {
		return goles;
	}

	public void setGoles(int goles) {
		this.goles = goles;
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
}

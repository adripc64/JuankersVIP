package airHockey;

import fge.Texture;

public class Mazo {
	private Texture tex;
	private float xMazo;
	private float yMazo;
	private int goles = 0;
	
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

package airHockey;

import fge.Texture;

public class Mazo {
	private Texture tex;
	private float xMazo;
	private float yMazo;
	
	public Mazo(){
		tex = new Texture("PNG", "data/airhockey/mazo_blanco.png");
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

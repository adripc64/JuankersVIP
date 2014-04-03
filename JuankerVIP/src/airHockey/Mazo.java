package airHockey;

import fge.Color;
import fge.Render;
import fge.Texture;

public class Mazo {
	private Texture tex;
	private float xMazo;	// Posicion X del mazo
	private float yMazo;	// Posicion Y del mazo
	private float vX;		// Velocidad X del mazo
	private float vY;		// Velocidad Y del mazo
	private int goles;		// Goles del mazo
	private Color color;	// Color del mazo
	
	public Mazo() {
		color = new Color(255,255,255);
		this.tex = new Texture("data/airhockey/mazo_blanco.png");
	}
	
	public Mazo(Color color) {
		this.color = color;
		// Default
		this.tex = new Texture("data/airhockey/mazo_blanco.png");
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
	
	public void draw() {
		// Dibujando el mazo
		int wM1 = tex.getW();
		int hM1 = tex.getH();
		float xM1 = xMazo;
		float yM1 = yMazo;
		Render.DrawTexture(tex, xM1, yM1, wM1, hM1, 0, color);
	}
	
	public void cambiarImagenGol(int goles) {
		Texture textura;
		
		switch (goles) {
		case 1:
			textura = new Texture("data/airhockey/mazo_blanco_1.png");
			this.tex = textura;
			break;
		
		case 2:
			textura = new Texture("data/airhockey/mazo_blanco_2.png");
			this.tex = textura;
			break;

		case 3:
			textura = new Texture("data/airhockey/mazo_blanco_3.png");
			this.tex = textura;
			break;
			
		case 4:
			textura = new Texture("data/airhockey/mazo_blanco_4.png");
			this.tex = textura;
			break;
			
		default:
			// Has ganado
			break;
		}
		
	}
}

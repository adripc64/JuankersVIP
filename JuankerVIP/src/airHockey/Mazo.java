package airHockey;

import fge.Color;
import fge.Render;
import fge.Texture;

public class Mazo {
	private Texture tex;
	private Texture texArray[];
	private float xMazo;	// Posicion X del mazo
	private float yMazo;	// Posicion Y del mazo
	private float vX;		// Velocidad X del mazo
	private float vY;		// Velocidad Y del mazo
	private int goles;		// Goles del mazo
	private Color color;	// Color del mazo
	
	public Mazo() {
		color = new Color(255,255,255);
		texArray = new Texture[5];
		for (int i = 0; i < 5; i++)
			texArray[i] = new Texture(String.format("data/airhockey/mazo_blanco_%d.png", i));
		tex = texArray[0];
	}
	
	public Mazo(Color color) {
		this();
		this.color = color;
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
	
	// Solo vale si el circulo se ajusta a la imagen
	public float getRadius() {
		return tex.getW() / 2.0f;
	}
	
	public void draw() {
		// Dibujando el mazo
		int wM = tex.getW();
		int hM = tex.getH();
		float xM = xMazo-wM/2;
		float yM = yMazo-hM/2;
		Render.DrawTexture(tex, xM, yM, wM, hM, 0, color);
	}
	
	public void cambiarImagenGol(int goles) {
		if (goles < 0 || goles >= texArray.length) goles = 0;
		tex = texArray[goles];
	}
}

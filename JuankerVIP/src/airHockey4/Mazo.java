package airHockey4;

import fge.Color;
import fge.Render;
import fge.Texture;

public class Mazo {
	private Texture tex;
	private Texture texArray[];
	private float x;		// Posicion X del mazo
	private float y;		// Posicion Y del mazo
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
	
	public void draw() {
		// Dibujando el mazo
		float xM = x - (tex.getW()/2);
		float yM = y - (tex.getH()/2);
		Render.DrawTexture(tex, xM, yM, color);
	}
	
	public void cambiarImagenGol(int goles) {
		if (goles < 0 || goles >= texArray.length) goles = 4;
		tex = texArray[goles];
	}
	
	public void limitesPantalla(float left, float right, float up, float down) {
		// Colisiones de pantalla
		if(getx() < left + getRadius())		// Left
			x = left + getRadius();
		if(getx() > right - getRadius())	// Right
			x = right - getRadius();
		if(gety() < up + getRadius())			// Up
			y = up + getRadius();
		if(gety() > down - getRadius())		// Down
			y = down - getRadius();
	}
	
	// Solo vale si el circulo se ajusta a la imagen
	public float getRadius() {
		return tex.getW() / 2.0f;
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

	public float getx() {
		return x;
	}

	public void setx(float xMazo) {
		this.x = xMazo;
	}

	public float gety() {
		return y;
	}

	public void sety(float yMazo) {
		this.y = yMazo;
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

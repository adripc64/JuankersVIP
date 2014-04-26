package airHockey;

import fge.Color;
import fge.Render;
import fge.Texture;

public class Ball {

	private Texture tex;
	private float xBall;
	private float yBall;
	
	private float velocidad;
	private float rozamiento;
	private Color color;
	
	public Ball() {
		color = new Color(255,255,255);
		tex = new Texture("data/airHockey/ball48-36.png");
	}
	
	public Ball(float rozamiento){
		this();
		this.rozamiento = rozamiento;
	}
	
	public boolean isMoving() {
		if(velocidad > 0) 
			return true;
		else 
			return false;
	}
	
	// Solo vale si el circulo se ajusta a la imagen
	public float getRadius() {
		return tex.getW() / 2.0f;
	}
	
	public void draw() {
		// Dibujando pelota
		int wB = tex.getW();
		int hB = tex.getH();
		float xB = xBall - wB/2;
		float yB = yBall - hB/2;
		Render.DrawTexture(tex, xB, yB, wB, hB, color, -velocidad, 0.5f, 0.5f);
	}

	public Texture getTex() {
		return tex;
	}

	public void setTex(Texture tex) {
		this.tex = tex;
	}

	public float getxBall() {
		return xBall;
	}

	public void setxBall(float xBall) {
		this.xBall = xBall;
	}

	public float getyBall() {
		return yBall;
	}

	public void setyBall(float yBall) {
		this.yBall = yBall;
	}

	public float getVelocidad() {
		return velocidad;
	}

	public void setVelocidad(float velocidad) {
		this.velocidad = velocidad;
	}

	public float getRozamiento() {
		return rozamiento;
	}

	public void setRozamiento(float rozamiento) {
		this.rozamiento = rozamiento;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

}

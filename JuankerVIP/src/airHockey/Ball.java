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
	
	public Ball() {
		this.rozamiento = 0;
		tex = new Texture("data/airHockey/ball48-36.png");
	}
	
	public Ball(float rozamiento){
		this.rozamiento = rozamiento;
		
		// Default
		tex = new Texture("data/airHockey/ball48-36.png");
	}
	
	public boolean isMoving() {
		if(velocidad > 0) 
			return true;
		else 
			return false;
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
	
	// Solo vale si el circulo se ajusta a la imagen
	public float getRadius() {
		return tex.getW() / 2.0f;
	}
	
	public void draw() {
		// Dibujando pelota
		Color color = new Color(255,255,255);
		int wB = tex.getW();
		int hB = tex.getH();
		float xB = xBall-wB/2;
		float yB = yBall-hB/2;
		Render.DrawTexture(tex, xB, yB, wB, hB, 0, color);
	}

}

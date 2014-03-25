package airHockey;

import fge.Texture;

public class Ball {

	private Texture tex;
	private float xBall;
	private float yBall;
	
	private float velocidad;
	private float rozamiento;
	
	public Ball(float rozamiento){
		tex = new Texture("data/ball64.png");
		this.rozamiento = rozamiento;
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
	
	
}

package airHockey;

import fge.Texture;

public class Ball {

	private Texture tex;
	private float xBall;
	private float yBall;
	
	public Ball(){
		tex = new Texture("data/ball64.png");
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
	
	
}

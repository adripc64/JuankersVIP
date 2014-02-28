package spaceInvaders;

import fge.Texture;

public class Cannon {

	private float coordinateX;
	private Texture cannonTexture;
	private int lives;

	public Cannon() {
		cannonTexture = new Texture("PNG", "data/spaceInvaders/cannon.png");
		lives = 3;
	}

	public float getX() {
		return coordinateX;
	}

	public void setX(float altura) {
		this.coordinateX = altura;
	}

	public Texture getTextura() {
		return cannonTexture;
	}
	
	public void die(){
		lives-=1;
	}

	public void setLive(){
		lives+=1;
	}
	
	public int getLives(){
		return  lives;
	}
}

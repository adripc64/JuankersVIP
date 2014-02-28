package spaceInvaders;

import fge.Texture;

public class Cannon {

	private float coordinateX;
	private float coordinateY;
	private Texture cannonTexture;
	private int lives;

	public Cannon() {
		cannonTexture = new Texture("PNG", "data/spaceInvaders/cannon.png");
		lives = 3;
	}

	public float getX() {
		return coordinateX;
	}

	public void setX(float x) {
		this.coordinateX = x;
	}

	public float getY() {
		return coordinateY;
	}

	public void setY(float y) {
		this.coordinateY = y;
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

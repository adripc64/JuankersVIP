package spaceInvaders;

import fge.Texture;

public abstract class Invader implements Drawable {

	private float coordinateX;
	private float coordinateY;

	public abstract int getScore();

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

	public abstract Texture getTexture();

}

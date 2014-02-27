package juankyBird;

import fge.Texture;
import fge.Window;

public class Tuberia {
	private Texture tex;
	private float x;
	private float yT;
	public Tuberia(){
		tex=new Texture("PNG","data/ball64.png");
		yT=((float) Math.random()*Window.getH());//random
	}
	
	public Texture getTextura(){
		return tex;
	}
	public float getX(){
		return x;
	}
	public float getYT(){
		return yT;
	}
	public void setX(float X){
		this.x=X;
	}

}

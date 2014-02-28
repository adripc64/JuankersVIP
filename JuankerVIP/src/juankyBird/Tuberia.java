package juankyBird;

import fge.Texture;
import fge.Window;

public class Tuberia {
	private Texture tex;
	private float x;
	private float yT;
	private int separacion;
	
	public Tuberia(){
		tex=new Texture("PNG","data/tubo.png");
		// yT=((float) Math.random() * (Window.getH() - tex.getH()));
		yT=0;
		separacion = 130;
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
	
	public void setYT(float YT){
		this.yT=YT;
	}
	public void setX(float X){
		this.x=X;
	}

	public float getSeparacion() {
		return separacion;
	}

}

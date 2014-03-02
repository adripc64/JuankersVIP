package breakoutAitor;

import fge.Texture;

public class Bola {
	
	private float altura;
	private float anchura;
	private float speed;
	private Texture textureBola;
	
	public Bola() {
		textureBola = new Texture("data/bolaBreakOut.png");
	}
	
	public float getAltura(){
		return altura;
	}
	
	public void setAltura(float altura){
		this.altura = altura;
	}
	
	public float getAnchura(){
		return anchura;
	}
	
	public void setAnchura(float anchura){
		this.anchura = anchura;
	}
	
	public float getSpeed(){
		return speed;
	}
	
	public void setSpeed(float speed){
		this.speed = speed;
	}
	
	public Texture getTextura(){
		return textureBola;
	}

}

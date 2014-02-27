package juankyBird;

import fge.Texture;

public class Pardal {
//guardar la altura i la textura
	private float altura;
	private Texture textura=new Texture("PNG", "data/bird.png");
	
	public float getAltura(){
		return altura;
	}
	public void setAltura(float altura){
		this.altura=altura;
	}
	public Texture getTextura(){
		return textura;
	}
}

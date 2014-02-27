package juankyBird;

import fge.Texture;

public class Pardal {

	private float altura;
	private Texture tex;
	
	public Pardal() {
		tex = new Texture("PNG", "data/bird.png");
	}
	
	public float getAltura(){
		return altura;
	}
	
	public void setAltura(float altura){
		this.altura = altura;
	}
	
	public Texture getTextura(){
		return tex;
	}
}

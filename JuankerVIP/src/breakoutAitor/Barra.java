package breakoutAitor;

import fge.Texture;

public class Barra {
	
	private float altura = 0;
	private Texture textureBar;
	
	public Barra() {
		textureBar = new Texture("data/barraBreakOut.png");
	}
	
	public float getAltura(){
		return altura;
	}
	
	public void setAltura(float altura){
		this.altura = altura;
	}
	
	public Texture getTextura(){
		return textureBar;
	}


}

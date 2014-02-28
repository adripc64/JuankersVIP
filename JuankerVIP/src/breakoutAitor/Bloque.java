package breakoutAitor;

import fge.Texture;

public class Bloque {

	private float altura;
	private float anchura;
	private int golpes;
	private Texture textureBlock;
	
	public Bloque() {
		textureBlock = new Texture("PNG", "data/blockBreakOut.png");
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
	
	public float getGolpes(){
		return golpes;
	}
	
	public void setGolpes(int golpes){
		this.golpes = golpes;
	}
	
	public Texture getTextura(){
		return textureBlock;
	}
	
	public void setTextura(Texture textureBar){
		this.textureBlock = textureBar;
	}
}

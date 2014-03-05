package juankyBird;

import java.util.LinkedList;
import java.util.List;

import fge.Sprite;
import fge.SpriteAnimation;
import fge.Texture;
import fge.Window;

public class Pardal {

	private float altura;
	private Sprite sprite;
	
	public Pardal() {
		
		sprite = new Sprite();
	
		List<Texture> listaTexturas = new LinkedList<Texture>();
		listaTexturas.add(new Texture("data/bird_00.png"));
		listaTexturas.add(new Texture("data/bird_01.png"));
		
		sprite.addAnimation(new SpriteAnimation("volant", 24, listaTexturas));
		sprite.setAnimation("volant");
		
	}
	
	public float getW() {
		return sprite.getW();
	}
	
	public float getH() {
		return sprite.getH();
	}
	
	public float getAltura(){
		return altura;
	}
	
	public void setAltura(float altura){
		this.altura = altura;
		sprite.setY(Window.getH() - sprite.getH() - altura);
	}
	
	public void move() {
		sprite.move();
	}
	
	public void draw() {
		sprite.draw();
	}
}

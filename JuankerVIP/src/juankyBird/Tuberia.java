package juankyBird;

import fge.App;
import fge.Color;
import fge.Intersect;
import fge.Render;
import fge.Texture;
import fge.Window;

public class Tuberia {
	private Texture texTubeBottom;
	private Texture texTubeBottomBody;
	private Texture texTubeTop;
	private Texture texTubeTopBody;
	private float x;
	private float yEspacio;
	private float hEspacio;
	
	public Tuberia(){
		texTubeBottom=new Texture("data/tubo.png");
		texTubeTop=new Texture("data/tuboInv3.png");
		texTubeBottomBody = new Texture("data/tubo_cuerpo.png");
		texTubeTopBody = new Texture("data/tubo_cuerpoInv3.png");
		yEspacio = 100;
		hEspacio = 150;
	}
	public void DibujarTuberia(){
		// Tuberia de arriba
		float y = 0;
		
		Render.DrawRectangle(x, 0, texTubeTop.getW(),yEspacio+10, 0, new Color(255,0,0));
		
		Render.DrawTexture(texTubeTopBody, x, y, texTubeTopBody.getW(), yEspacio-texTubeTop.getH(), 0, new Color(255,255,255));
		y += yEspacio-texTubeTop.getH();
		Render.DrawTexture(texTubeTop, x, y, new Color(255,255,255));
		Render.DrawRectangle(x, 0, texTubeTop.getW(), yEspacio, 0, new Color(255,0,0));
		// Tuberia de abajo
		y += texTubeTop.getH()+hEspacio;
		Render.DrawTexture(texTubeBottom, x, y, new Color(255,255,255));
		y += texTubeBottom.getH();
		Render.DrawTexture(texTubeBottomBody, x, y, texTubeBottomBody.getW(), Window.getH()-y, 0, new Color(255,255,255));
		Render.DrawRectangle(x, y-texTubeBottom.getH(), texTubeTop.getW(), Window.getH(), 0, new Color(255,0,0));
	}
	
	public float getX(){
		return x;
	}

	public void setX(float X){
		this.x=X;
	}

	public float getW() {
		return texTubeTop.getW();
	}
	
	public float getSeparacion() {
		return hEspacio;
	}
	
	public void randomEspacio() {
		yEspacio = (float) (Math.random() * (Window.getH()-hEspacio-100)+50);
	}
	
	public boolean chocaElPardalet(float px, float py, float pw, float ph) {
		
		if(Intersect.RectWithRect(px, py, pw, ph, x, 0, texTubeTop.getW(),0 )){
			System.out.println("part de dalt");
			System.out.println("altura pardal "+py+"  altura tuberia "+yEspacio);
			return true;
		}
		/*
		if(Intersect.RectWithRect(px, py, pw, ph, x, yEspacio+hEspacio, getW(), Window.getH())){
			System.out.println("Part de baix");
			return true;
		}*/
		return false;
		//return Intersect.RectWithRect(px, py, pw, ph, x, 0, getW(), yEspacio)/*part de dalt*/ || 
			//	Intersect.RectWithRect(px, py, pw, ph, x, yEspacio+hEspacio, getW(), Window.getH());//part de baix
		
	}

}

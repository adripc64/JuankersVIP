package juankyBird;

import fge.App;
import fge.Color;
import fge.Render;
import fge.Texture;
import fge.Window;

public class Tuberia {
	private Texture tex;
	private Texture texInv;
	private Texture texTuboCuerpoInv;
	private Texture texTuboCuerpo;
	private float x;
	private float x_2;
	private float yT;
	private float yT_2;
	private float yT2;
	private float yT2_2;
	private int separacion;
	private float tubSpeed = 200.0f;
	private boolean contador=false;
	
	public Tuberia(){
		tex=new Texture("data/tubo.png");
		texInv=new Texture("data/tuboInv3.png");
		texTuboCuerpo = new Texture("data/tubo_cuerpo.png");
		texTuboCuerpoInv = new Texture("data/tubo_cuerpoInv3.png");
		yT=0;//modificar
		separacion = 150;
	}
	public void DibujarTuberia(){
		int wT=tex.getW()-35;
		int hT=tex.getH();
		
		Render.DrawTexture(texInv, x, yT, wT, hT, 0, new Color(255, 255, 255));
		Render.DrawTexture(texTuboCuerpoInv, x, 0, wT, yT+hT-70, 0, new Color(255, 255, 255));
			
		yT2=yT+hT+separacion;
		
		Render.DrawTexture(tex, x, yT2, wT, hT, 0, new Color(255, 255, 255));
		Render.DrawTexture(texTuboCuerpo, x,Window.getH(), wT,yT2-Window.getH()+80, 0, new Color(255, 255, 255));
		
	}
	public void MoureTuberia(){
		if(x > 0-tex.getW()){
			float tubx = x- tubSpeed * App.getFTime();
			x=tubx;
		} else {
			x=Window.getH()+tex.getW()+50;
			float tuby = (float) (Math.random() * (Window.getH()-separacion)-separacion-100);
			yT=tuby;
		}		
	}
	
	public Texture getTextura(){
		return tex;
	}
	public Texture getTexturaInv(){
		return texInv;
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

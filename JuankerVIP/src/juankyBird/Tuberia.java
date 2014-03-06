package juankyBird;

import fge.App;
import fge.Color;
import fge.Intersect;
import fge.Render;
import fge.Texture;
import fge.Window;

public class Tuberia {
	private Texture tex;
	private Texture texInv;
	private Texture texTuboCuerpoInv;
	private Texture texTuboCuerpo;
	private float x;
	private float yT;
	private float yEspacio;
	private float hEspacio;
	private int separacion;
	private float tubSpeed = 200.0f;
	
	public Tuberia(){
		tex=new Texture("data/tubo.png");
		texInv=new Texture("data/tuboInv3.png");
		texTuboCuerpo = new Texture("data/tubo_cuerpo.png");
		texTuboCuerpoInv = new Texture("data/tubo_cuerpoInv3.png");
		yT=0;//modificar
		separacion = 150;
	}
	public void DibujarTuberia(){
		/*int wT=tex.getW()-35;
		int hT=tex.getH();
		
		Render.DrawTexture(texInv, x, yT, wT, hT, 0, new Color(255, 255, 255));
		Render.DrawTexture(texTuboCuerpoInv, x, 0, wT, yT+hT-70, 0, new Color(255, 255, 255));
		Render.DrawRectangle(x,yT-60, wT, hT-10, 0, new Color(255,0,0));
			
		yT2=yT+hT+separacion;
		
		Render.DrawTexture(tex, x, yT2, wT, hT, 0, new Color(255, 255, 255));
		Render.DrawTexture(texTuboCuerpo, x,Window.getH(), wT,yT2-Window.getH()+80, 0, new Color(255, 255, 255));
		//Render.DrawRectangle(x, tex.getH()+40+yT, tex.getW(), 100, 0, new Color(255,0,0));*/
		
		Render.DrawTexture(texInv, x, 0, texInv.getW(), yEspacio, 0, new Color(255,255,255));
		Render.DrawTexture(texInv, x, 0, texInv.getW(), yEspacio, 0, new Color(255,255,255));
		Render.DrawRectangle(x, 0, texInv.getW(), yEspacio, 0, new Color(255,0,0));
		
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
	
	public boolean chocaElPardalet(float px, float py, float pw, float ph) {
		//return Intersect.RectWithRect(px, py, pw, ph, x, yT+tex.getH()+70, tex.getW(), yT+tex.getH()+70)/*part de dalt*/ || 
			//	Intersect.RectWithRect(px, py, pw, ph, x, yT, w2, h2);//part de baix
		return false;
	}

}

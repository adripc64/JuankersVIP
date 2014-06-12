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
		Render.DrawRectangle(x, yEspacio, texTubeTop.getW(),-texTubeTop.getH(), 0, new Color(255,0,0));
		
		Render.DrawTexture(texTubeTopBody, x, y, texTubeTopBody.getW(), yEspacio-texTubeTop.getH(), 0, new Color(255,255,255));
		y += yEspacio-texTubeTop.getH();
		Render.DrawTexture(texTubeTop, x, y, new Color(255,255,255));
		
	// Tuberia de abajo
		y += texTubeTop.getH()+hEspacio;
	//	Render.DrawTexture(texTubeBottom, x, y, new Color(255,255,255));
		y += texTubeBottom.getH();
	//	Render.DrawTexture(texTubeBottomBody, x, y, texTubeBottomBody.getW(), Window.getH()-y, 0, new Color(255,255,255));
	//	Render.DrawRectangle(x, y-texTubeBottom.getH(), texTubeTop.getW(), Window.getH(), 0, new Color(255,0,0));
		
		Render.DrawRectangle(x, yEspacio, getW(), hEspacio, 0, new Color(255,255,0));
		
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
		//System.out.println(py+"  "+yEspacio);
		
		if(px>x+getW()){
		System.out.println("estem a lesquerra");
		}
		if(px+pw<x) System.out.println("estem a la dreta");
		if(px+pw>x) System.out.println("Dreta: "+px+" "+pw+", "+x);
		if(py>yEspacio+yEspacio+hEspacio)System.out.println("entem a sota");
		if(py>yEspacio+yEspacio+hEspacio)System.out.println(" baix: "+ py+", "+yEspacio+" " +hEspacio);
		if(py+ph<yEspacio)System.out.println("estem a sobre");
		return RectWithRect(x, yEspacio, getW(), hEspacio,px, py, pw, ph);
		
	}
	public boolean RectWithRect(float x1, float y1, float w1, float h1, float x2, float y2, float w2, float h2) {
		//intent d'un altre comprovador d'interseccio
//		if(x1+w1>x2){
//			if(y1+h1<y2 && y1>y2+h2) return false;
//			System.out.println("1");
//		}else{
//			if(y2+h2<y1){
//				System.out.println(2);
//				if(x1+w1<x2 && x1>x2+h2) return false;
//			}else{
//				if(y1+h1>y2){
//					System.out.println(3);
//					if(x1+w1<x2 && x1>x2+h2) return false;
//				}else{
//					if(x1<x2+w2){
//						System.out.println(4);
//						if(y1+h1<y2 && y1>y2+h2) return false;
//					}
//				}
//			}
//		}
	
	if (x1 > x2+w2 || x1+w1 < x2 || y1 > y2+h2 || y1+h1 < y2) return false;
		return true;
	}
		
}

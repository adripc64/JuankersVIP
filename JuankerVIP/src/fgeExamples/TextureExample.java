package fgeExamples;

import fge.App;
import fge.Color;
import fge.Render;
import fge.Service;
import fge.Texture;
import fge.Window;

public class TextureExample extends Service {

	private Texture tex;
	private Texture tex2;

	public static void main(String[] args) {
		App.run(new TextureExample(), 640, 480);
	}

	@Override
	protected void onStart() {
		// TODO Auto-generated method stub
		tex = new Texture("data/bird.png");
		tex2 = new Texture("data/logochrome.jpg");
	}

	@Override
	protected void onStop() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void onMove() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void onDraw() {
		Render.DrawBox(0, 0, Window.getW(), Window.getH(), new Color(255,0,0));
		Render.DrawTex(tex, 100, 100, tex.getW(), tex.getH(), new Color(255,255,255));
		Render.DrawTex(tex2, 250, 100, tex2.getW(), tex2.getH(), new Color(255,255,255));
		Render.DrawBox(0, 0, Window.getW(), Window.getH(), new Color(255,255,0,128));
	}

}

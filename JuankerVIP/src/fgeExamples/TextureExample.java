package fgeExamples;

import fge.App;
import fge.Color;
import fge.Render;
import fge.Service;
import fge.Texture;

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
		Render.DrawTexture(tex, 100, 100, tex.getW(), tex.getH(), 45, new Color(255,255,255));
		Render.DrawTexture(tex2, 250, 100, new Color(255,255,255));
	}

}

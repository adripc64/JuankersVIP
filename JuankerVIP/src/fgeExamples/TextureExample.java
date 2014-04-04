package fgeExamples;

import fge.App;
import fge.Color;
import fge.Render;
import fge.Service;
import fge.Texture;

public class TextureExample extends Service {

	private Texture tex;
	
	private Texture birdTex;
	private float birdAngle = 0.0f;
	private float birdRotateSpeed = 128.0f;

	public static void main(String[] args) {
		App.run(new TextureExample(), 640, 480);
	}

	@Override
	protected void onStart() {		
		tex = new Texture("data/logochrome.jpg");
		birdTex = new Texture("data/bird_00.png");
	}

	@Override
	protected void onStop() {
		
	}

	@Override
	protected void onPause() {
		
	}

	@Override
	protected void onResume() {
		
	}

	@Override
	protected void onMove() {
		birdAngle += birdRotateSpeed * App.getFTime();
	}

	@Override
	protected void onDraw() {
		Render.DrawTexture(tex, 250, 100, new Color(255,255,255));
		
		Render.DrawRectangle(100, 100, birdTex.getW(), birdTex.getH(), new Color(255,0,0));
		Render.DrawRectangle(100, 200, birdTex.getW(), birdTex.getH(), new Color(255,0,0));
		Render.DrawRectangle(100, 300, birdTex.getW(), birdTex.getH(), new Color(255,0,0));
		
		Render.DrawTexture(birdTex, 100, 100, birdTex.getW(), birdTex.getH(), new Color(255,255,255), birdAngle, 0.0f, 0.0f);
		Render.DrawTexture(birdTex, 100, 200, birdTex.getW(), birdTex.getH(), new Color(255,255,255), birdAngle, 0.5f, 0.5f);
		Render.DrawTexture(birdTex, 100, 300, birdTex.getW(), birdTex.getH(), new Color(255,255,255), birdAngle, 1.0f, 1.0f);
		
		Render.DrawRectangle(100, 100, birdTex.getW(), birdTex.getH(), new Color(255,0,255), birdAngle, 0.0f, 0.0f);
		Render.DrawRectangle(100, 200, birdTex.getW(), birdTex.getH(), new Color(255,0,255), birdAngle, 0.5f, 0.5f);
		Render.DrawRectangle(100, 300, birdTex.getW(), birdTex.getH(), new Color(255,0,255), birdAngle, 1.0f, 1.0f);
	}

}

package fgeExamples;

import fge.App;
import fge.Color;
import fge.Intersect;
import fge.Keyboard;
import fge.Render;
import fge.Service;

public class IntersectRectWithRectExample extends Service {
	
	private float x1 = 200;
	private float y1 = 90;
	private float w1 = 50;
	private float h1 = 50;
	private float x2 = 200;
	private float y2 = 150;
	private float w2 = 80;
	private float h2 = 120;
	
	private float moveSpeed = 20.0f;
	
	private Color colorDefault = new Color(0,255,0);
	private Color colorIntersect = new Color(255,0,0);

	public static void main(String[] args) {
		App.run(new IntersectRectWithRectExample(), 640, 480);
	}

	@Override
	protected void onStart() {
		// TODO Auto-generated method stub
		
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

		if (Keyboard.isKeyPressed(Keyboard.KEY_LEFT)) x1 -= moveSpeed * App.getFTime();
		if (Keyboard.isKeyPressed(Keyboard.KEY_RIGHT)) x1 += moveSpeed * App.getFTime();
		if (Keyboard.isKeyPressed(Keyboard.KEY_UP)) y1 -= moveSpeed * App.getFTime();
		if (Keyboard.isKeyPressed(Keyboard.KEY_DOWN)) y1 += moveSpeed * App.getFTime();
		
	}

	@Override
	protected void onDraw() {
		Color color;
		
		if (Intersect.RectWithRect(x1, y1, w1, h1, x2, y2, w2, h2)) color = colorIntersect;
		else color = colorDefault;

		Render.DrawRectangle(x1, y1, w1, h1, 0, color);
		Render.DrawRectangle(x2, y2, w2, h2, 0, color);
	}

}

package fgeExamples;

import fge.App;
import fge.Color;
import fge.Intersect;
import fge.Keyboard;
import fge.Render;
import fge.Service;

public class IntersectCircleWithCircleExample extends Service {
	
	private float cx1 = 100;
	private float cy1 = 100;
	private float cr1 = 25;
	private float cx2 = 200;
	private float cy2 = 150;
	private float cr2 = 50;
	
	private float moveSpeed = 20.0f;
	
	private Color colorDefault = new Color(0,255,0);
	private Color colorIntersect = new Color(255,0,0);

	public static void main(String[] args) {
		App.run(new IntersectCircleWithCircleExample(), 640, 480);
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

		if (Keyboard.isKeyPressed(Keyboard.KEY_LEFT)) cx1 -= moveSpeed * App.getFTime();
		if (Keyboard.isKeyPressed(Keyboard.KEY_RIGHT)) cx1 += moveSpeed * App.getFTime();
		if (Keyboard.isKeyPressed(Keyboard.KEY_UP)) cy1 -= moveSpeed * App.getFTime();
		if (Keyboard.isKeyPressed(Keyboard.KEY_DOWN)) cy1 += moveSpeed * App.getFTime();
		
	}

	@Override
	protected void onDraw() {
		Color color;
		
		if (Intersect.CircleWithCircle(cx1, cy1, cr1, cx2, cy2, cr2)) color = colorIntersect;
		else color = colorDefault;

		Render.DrawCircle(cx1, cy1, cr1, color);
		Render.DrawCircle(cx2, cy2, cr2, color);
	}

}

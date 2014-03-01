package fgeExamples;

import fge.App;
import fge.Color;
import fge.Event;
import fge.EventListener;
import fge.EventMan;
import fge.Keyboard;
import fge.Misc;
import fge.Render;
import fge.Service;

public class AngleBetweenPointsExample extends Service implements EventListener {
	
	private float x1 = 320.0f;
	private float y1 = 240.0f;
	private float x2 = 360.0f;
	private float y2 = 240.0f;
	private float speed = 5.0f;

	public static void main(String[] args) {
		App.run(new AngleBetweenPointsExample(), 640, 480);
	}

	@Override
	protected void onStart() {
		EventMan.addListener(this);
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
		
		if (Keyboard.isKeyPressed(Keyboard.KEY_LEFT)) x2 -= speed * App.getFTime();
		if (Keyboard.isKeyPressed(Keyboard.KEY_RIGHT)) x2 += speed * App.getFTime();
		if (Keyboard.isKeyPressed(Keyboard.KEY_UP)) y2 -= speed * App.getFTime();
		if (Keyboard.isKeyPressed(Keyboard.KEY_DOWN)) y2 += speed * App.getFTime();
		
		System.out.println(Misc.RadToDeg(Misc.getAngleBetweenPoints(x1, y1, x2, y2)));
				
	}

	@Override
	protected void onDraw() {
		
		Render.DrawPoint(x1, y1, new Color(255,0,0));
		Render.DrawPoint(x2, y2, new Color(0,255,0));
		
	}

	@Override
	public boolean doEvent(Event e) {
		
		/*if (e.getType() == Event.KEY_PRESSED) {
			if (e.getValue() == Keyboard.KEY_LEFT) x2 -= 1.0f * App.getFTime();
			if (e.getValue() == Keyboard.KEY_RIGHT) x2 += 1.0f * App.getFTime();
			if (e.getValue() == Keyboard.KEY_UP) y2 -= 1.0f * App.getFTime();
			if (e.getValue() == Keyboard.KEY_DOWN) y2 += 1.0f * App.getFTime();
		}*/
		
		return false;
	}

}

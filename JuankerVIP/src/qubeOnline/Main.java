package qubeOnline;

import fge.App;
import fge.Color;
import fge.Keyboard;
import fge.Render;
import fge.Service;

public class Main extends Service {
	int x = 100;
	int y = 100;
	int w = 50;
	int h = 50;
	Color color = new Color(0, 255, 0);
	float speed = 50;
	
	
	
	public static void main(String[] args) {
		App.run(new Main(), 600, 800);


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
		if (Keyboard.isKeyPressed(Keyboard.KEY_LEFT)) x -= speed * App.getFTime();
		if (Keyboard.isKeyPressed(Keyboard.KEY_RIGHT)) x += speed * App.getFTime();
		if (Keyboard.isKeyPressed(Keyboard.KEY_UP)) y -= speed * App.getFTime();
		if (Keyboard.isKeyPressed(Keyboard.KEY_DOWN)) y += speed * App.getFTime();
	}

	@Override
	protected void onDraw() {
		Render.DrawFilledRectangle(x, y, w, h, color);
	}

}

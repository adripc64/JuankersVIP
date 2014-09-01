package qubeOnline;

import org.omg.CORBA.TIMEOUT;

import fge.App;
import fge.Color;
import fge.Keyboard;
import fge.Render;
import fge.Service;

public class Main extends Service {
	float x = 100;
	float y = 500;
	int w = 50;
	int h = 50;
	Color color = new Color(0, 255, 0);
	float speed = 100;
	boolean falling = true;
	float gravity = 300;
	float jumpSpeed = 500;
	final float MAX_JUMP_HEIGHT = 300;
	boolean jump = false;
	float jumpingHeight = 0;
	
	
	
	
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
		if (!Keyboard.isKeyPressed(Keyboard.KEY_UP)){
			falling = true;
			jumpingHeight = 0;
		}
		if (falling && y < 650) y += gravity * App.getFTime();
		if (Keyboard.isKeyPressed(Keyboard.KEY_LEFT) && x > 0) x -= speed * App.getFTime();
		if (Keyboard.isKeyPressed(Keyboard.KEY_RIGHT) && x < 550 ) x += speed * App.getFTime();
		if (Keyboard.isKeyPressed(Keyboard.KEY_UP) && jump == false ) {
			falling = false;
			if (jumpingHeight <= MAX_JUMP_HEIGHT){
				y -= jumpSpeed * App.getFTime();
				jumpingHeight = 650-y;
				System.out.println(jumpingHeight);
				}
			}
//			falling = false;
//			if(jumping <= MAX_JUMP_HEIGHT) {
//				
//				System.out.println(jumping);
//			}
//			else {
//				jump = false;

//			}
	}


	@Override
	protected void onDraw() {
		Render.DrawFilledRectangle(x, y, w, h, color);
		Render.DrawFilledRectangle(0, 700, 600, 10, color);
	}

}

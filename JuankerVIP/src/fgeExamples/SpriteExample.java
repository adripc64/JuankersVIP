package fgeExamples;

import java.util.LinkedList;
import java.util.List;

import fge.App;
import fge.Event;
import fge.EventListener;
import fge.EventMan;
import fge.Intersect;
import fge.Keyboard;
import fge.Mouse;
import fge.Service;
import fge.Sprite;
import fge.SpriteAnimation;
import fge.Texture;

public class SpriteExample extends Service implements EventListener {
	
	private Sprite sprZombie;

	public static void main(String[] args) {
		App.run(new SpriteExample(), 800, 600);
	}

	@Override
	protected void onStart() {
		
		EventMan.addListener(this);

		sprZombie = new Sprite();
		sprZombie.setX(400);
		sprZombie.setY(200);
		
		List<Texture> frames = new LinkedList<Texture>();
		for (int i = 0; i <= 23; i++) frames.add(new Texture(String.format("data/zombie_R/zombie_R_quiet_%04d.png", i)));
		sprZombie.addAnimation(new SpriteAnimation("quiet", 24, frames));
		
		frames = new LinkedList<Texture>();
		for (int i = 0; i <= 23; i++) frames.add(new Texture(String.format("data/zombie_R/zombie_R_walk_%04d.png", i)));
		sprZombie.addAnimation(new SpriteAnimation("walk", 24, frames));
		
		frames = new LinkedList<Texture>();
		for (int i = 0; i <= 19; i++) frames.add(new Texture(String.format("data/zombie_R/zombie_R_bite_%04d.png", i)));
		sprZombie.addAnimation(new SpriteAnimation("bite", 24, frames));
		
		frames = new LinkedList<Texture>();
		for (int i = 0; i <= 20; i++) frames.add(new Texture(String.format("data/zombie_R/zombie_R_hit_%04d.png", i)));
		sprZombie.addAnimation(new SpriteAnimation("hit", 24, frames));
		
		sprZombie.setAnimation("quiet");
		
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
		
		if (Keyboard.isKeyPressed(Keyboard.KEY_LEFT)) {
			if (sprZombie.getCurrentAnimationName() == "quiet")
				sprZombie.setAnimation("walk");
		} else {
			if (sprZombie.getCurrentAnimationName() == "walk" && sprZombie.getCurrentAnimationNumLoops() >= 1)
				sprZombie.setAnimation("quiet");
		}
		
		if (sprZombie.getCurrentAnimationName() == "hit" && sprZombie.getCurrentAnimationNumLoops() >= 1)
			sprZombie.setAnimation("quiet");
		
		if (sprZombie.getCurrentAnimationName() == "bite" && sprZombie.getCurrentAnimationNumLoops() >= 1)
			sprZombie.setAnimation("quiet");

		sprZombie.move();
		
	}

	@Override
	protected void onDraw() {

		sprZombie.draw();
		
	}

	@Override
	public boolean doEvent(Event e) {
		
		switch (e.getType()) {
		case MOUSE_PRESSED:
			int mx = Mouse.getX();
			int my = Mouse.getY();

			if (Intersect.PointWithRect(mx, my, sprZombie.getX(), sprZombie.getY(), sprZombie.getW(), sprZombie.getH())) {
				sprZombie.setAnimation("hit");
			}
			
			break;
		case KEY_PRESSED:
			
			if (e.getValue() == Keyboard.KEY_SPACE && sprZombie.getCurrentAnimationName() != "hit") {
				sprZombie.setAnimation("bite");
			}				
						
			break;
		default:
			break;
		}
		
		return false;
	}

}

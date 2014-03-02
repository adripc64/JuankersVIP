package fge;

import java.util.HashMap;
import java.util.Map;

public class Sprite {
	
	private float x;
	private float y;
	
	private Color color;
	
	private Map<String,SpriteAnimation> animations;
	private SpriteAnimation currentAnimation;
	private int currentAnimationNumLoops;
	
	private int currentFrame;
	private long lastFrameTime;
	
	public Sprite() {
		x = 0;
		y = 0;
		color = new Color(255,255,255);
		animations = new HashMap<String,SpriteAnimation>();
	}
	
	public void addAnimation(SpriteAnimation animation) {
		if (animation != null) {
			animations.put(animation.getName(), animation);
		}
	}
	
	public void setX(float x) {
		this.x = x;
	}
	
	public float getX() {
		return x;
	}
	
	public void setY(float y) {
		this.y = y;
	}
	
	public float getY() {
		return y;
	}
	
	public float getW() {
		if (currentAnimation != null) return currentAnimation.getFrame(currentFrame).getW();
		return 0;
	}
	
	public float getH() {
		if (currentAnimation != null) return currentAnimation.getFrame(currentFrame).getH();
		return 0;
	}
	
	public void setAnimation(String animationName) {
		SpriteAnimation sprAni = animations.get(animationName);
		if (sprAni != null) {
			currentAnimation = sprAni;
			currentAnimationNumLoops = 0;
			currentFrame = 0;
			lastFrameTime = App.getTime();
		}
	}
	
	public String getCurrentAnimationName() {
		if (currentAnimation != null) return currentAnimation.getName();
		return null;
	}
	
	public int getCurrentAnimationNumLoops() {
		return currentAnimationNumLoops;
	}
	
	public void move() {
		if (currentAnimation != null) {
			long currentTime = App.getTime();
			if (currentTime - lastFrameTime > 1000.0f / currentAnimation.getFPS()) {
				if (++currentFrame >= currentAnimation.getTotalFrames()) {
					currentAnimationNumLoops++;
					currentFrame = 0;
				}
				lastFrameTime = currentTime;
			}
		}
	}
	
	public void draw() {
		if (currentAnimation != null) {
			Texture tex = currentAnimation.getFrame(currentFrame);
			if (tex != null) Render.DrawTexture(tex, x, y, tex.getW(), tex.getH(), 0, color);
		}
	}

}

package fge;

import java.util.ArrayList;
import java.util.List;

public class SpriteAnimation {
	
	private String name;
	private int fps;
	private List<Texture> frames;
	
	public SpriteAnimation(String name, int fps) {
		this.name = name;
		this.fps = fps;
		this.frames = new ArrayList<Texture>();
	}
	
	public SpriteAnimation(String name, int fps, List<Texture> frames) {
		this.name = name;
		this.fps = fps;
		this.frames = new ArrayList<Texture>(frames);
	}
	
	public String getName() {
		return name;
	}
	
	public void setFPS(int fps) {
		this.fps = fps;
	}
	
	public int getFPS() {
		return fps;
	}
	
	public void addFrame(Texture tex) {
		frames.add(tex);
	}
	
	public Texture getFrame(int index) {
		if (index >= 0 && index < frames.size()) return frames.get(index);
		return null;
	}
	
	public int getTotalFrames() {
		return frames.size();
	}

}

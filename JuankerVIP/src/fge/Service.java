package fge;

public class Service {
	
	private boolean stopped = true;
	private boolean paused = false;
	
	
	public final void move() {
		if (!paused && !stopped) onMove();
	}
	
	public final void draw() {
		if (!stopped) onDraw();
	}
	
	public final void start() {
		stopped = false;
		paused = false;
		onStart();
	}
	
	public final void stop() {
		stopped = true;
		paused = false;
		onStop();
	}
	
	public final void pause() {
		paused = true;
		onPause();
	}
	
	public final void resume() {
		paused = false;
		onResume();
	}
	

	public void onMove() {}
	public void onDraw() {}
	public void onStart() {}
	public void onStop() {}
	public void onPause() {}
	public void onResume() {}
	
	public boolean doEvent(Event e) {
		return false;
	}
	
}

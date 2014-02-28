package fge;

public abstract class Service  {
	
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
	
	protected abstract void onStart();
	protected abstract void onStop();
	
	protected abstract void onPause();
	protected abstract void onResume();
	
	protected abstract void onMove();
	protected abstract void onDraw();
	
}

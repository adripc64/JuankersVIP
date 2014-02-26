package fge;

import org.lwjgl.Sys;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.GL11;

public final class App {
		
	private static long time;
	private static float ftime;
	private static int fps;
	
	private static long lastTime = 0;
	private static long lastFPS = 0;
	
	@SuppressWarnings("unused")
	private static Window window;
		
	public static void run(Service s, int w, int h) {
		
		window = new Window(w, h);
		ServiceMan.runService(s);
		
		start();
		while (!Display.isCloseRequested()) {
			loop();
		}
		end();
		
	}
	
	public static void start() {
		
	}
	
	public static void loop() {
		time = getTime();
		ftime = (time - lastTime) / 1000.0f;
		
		move();
		draw();
		
		lastTime = time;

		Display.update();
		Display.sync(60); // cap fps to 60fps
	}
	
	public static void end() {
		Display.destroy();
	}
	
	private static void move() {
		EventMan.move();
		ServiceMan.move();
		updateFPS(); // update FPS Counter
	}
	
	private static void draw() {
		// Clear The Screen And The Depth Buffer
		GL11.glClear(GL11.GL_COLOR_BUFFER_BIT | GL11.GL_DEPTH_BUFFER_BIT);
		ServiceMan.draw();
	}
	
	public static float getFTime() { return ftime; }
	
	/**
	 * Get the accurate system time
	 * 
	 * @return The system time in milliseconds
	 */
	public static long getTime() {
	    return (Sys.getTime() * 1000) / Sys.getTimerResolution();
	}
	
	/**
	 * Calculate the FPS and set it in the title bar
	 */
	private static void updateFPS() {
		if (getTime() - lastFPS > 1000) {
			Display.setTitle("FPS: " + fps);
			fps = 0;
			lastFPS += 1000;
		}
		fps++;
	}
}

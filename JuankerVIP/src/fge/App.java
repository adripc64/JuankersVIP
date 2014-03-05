package fge;

import org.lwjgl.Sys;
import org.lwjgl.openal.AL;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.GL11;

public final class App {
	
	private static boolean running;
		
	private static long time;
	private static float ftime;
	private static int fps;
	
	private static long lastTime = 0;
	private static long lastFPS = 0;
	
	@SuppressWarnings("unused")
	private static Window window;
	
	/***
	 * Empieza al ejecución de la apliación.
	 * 
	 * @param s
	 * @param w
	 * @param h
	 */
	public static void run(Service s, int w, int h) {
		
		window = new Window(w, h);
		ServiceMan.runService("main", s);
		
		running = true;
		
		start();
		while (running && !Display.isCloseRequested()) {
			loop();
		}
		end();
		
	}
	
	/***
	 * Termina la ejecución de la aplicación.
	 */
	public static void exit() {
		running = false;
	}
	
	public static void start() {
		initGL();
		lastFPS = lastTime = time = getTime();
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
		AL.destroy();
	}
	
	private static void move() {
		EventMan.move();
		ServiceMan.move();
		updateFPS(); // update FPS Counter
	}
	
	private static void draw() {
		initGL();
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
	
	private static void initGL() {
		GL11.glEnable(GL11.GL_TEXTURE_2D);
		GL11.glShadeModel(GL11.GL_SMOOTH);
		
		GL11.glDisable(GL11.GL_DEPTH_TEST);
		GL11.glDisable(GL11.GL_LIGHTING);
		
		// Enable transparency
		GL11.glEnable(GL11.GL_BLEND);
		GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
		
		GL11.glClearColor(0, 0, 0, 0);
		GL11.glClearDepth(1);
		
		GL11.glViewport(0, 0, Window.getW(), Window.getH());
		
		GL11.glMatrixMode(GL11.GL_PROJECTION);
		GL11.glLoadIdentity();
		GL11.glOrtho(0, Window.getW(), Window.getH(), 0, 1, -1);
		
		// Para evitar que la primera vez que se renderiza texto oculte las primitivas renderizadas antes
		Font font = new Font("data/COMIC.TTF",20);
		Render.DrawText(font, 0, -20, ".", new Color(0,0,0,0));
	}
}

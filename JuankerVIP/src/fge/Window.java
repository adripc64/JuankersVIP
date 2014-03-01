package fge;

import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;

public class Window {
	
	private int m_W;
	private int m_H;

	public Window(int _w, int _h) {
		m_W = _w;
		m_H = _h;
		
		try {
			Display.setDisplayMode(new DisplayMode(m_W, m_H));
			Display.create();
		} catch (LWJGLException e) {
			e.printStackTrace();
			System.exit(0);
		}
		
	}
	
	public static int getW() { return org.lwjgl.opengl.Display.getWidth(); }
	public static int getH() { return org.lwjgl.opengl.Display.getHeight(); }
	
}

package fge;

import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.lwjgl.opengl.GL11;

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
		
		initGL();
	}
	
	public static int getW() { return org.lwjgl.opengl.Display.getWidth(); }
	public static int getH() { return org.lwjgl.opengl.Display.getHeight(); }
	
	private void initGL() {
		GL11.glMatrixMode(GL11.GL_PROJECTION);
		GL11.glLoadIdentity();
		GL11.glOrtho(0, m_W, m_H, 0, 1, -1);
		GL11.glMatrixMode(GL11.GL_MODELVIEW);
		
		// Enable transparency
		GL11.glEnable(GL11.GL_BLEND);
		GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
	}
	
}

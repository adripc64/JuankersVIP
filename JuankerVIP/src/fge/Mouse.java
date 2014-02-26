package fge;

public class Mouse {
	
	public static int getX() { return org.lwjgl.input.Mouse.getX(); }
	public static int getY() { return org.lwjgl.opengl.Display.getHeight() - org.lwjgl.input.Mouse.getY(); }
	
}

package fge;

public class Mouse {
	
	public enum MouseButton {
		LEFT,
		RIGHT,
		CENTER;
	}
	
	/**
	 * 
	 * @return Devuelve la coordenada x del cursor.
	 */
	public static int getX() { return org.lwjgl.input.Mouse.getX(); }
	
	/***
	 * 
	 * @return Devuelve la coordenada y del cursor.
	 */
	public static int getY() { return org.lwjgl.opengl.Display.getHeight() - org.lwjgl.input.Mouse.getY(); }
	
	/***
	 * 
	 * @return Devuelve el desplazamiento en el eje x del cursor relativo a la anterior posición.
	 */
	public static int getDX() { return org.lwjgl.input.Mouse.getDX(); }
	
	/***
	 * 
	 * @return Devuelve el desplazamiento en el eje y del cursor relativo a la anterior posición.
	 */
	public static int getDY() { return -org.lwjgl.input.Mouse.getDY(); }
	
}

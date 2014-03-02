package fge;

public class Intersect {
	
	// Point
	
	/***
	 * Comprueba si un punto está en una línea.
	 * 
	 * @param px Coordenada x del punto.
	 * @param py Coordenada y del punto.
	 * @param x1 Coordenada x del extremo inicial de la línea.
	 * @param y1 Coordenada y del extremo inicial de la línea.
	 * @param x2 Coordenada x del extremo final de la línea.
	 * @param y2 Coordenada y del extremo final de la línea.
	 * @return Devuelve true si el punto está en la línea.
	 */
	public static boolean PointWithLine(float px, float py, float x1, float y1, float x2, float y2) {
		return (Misc.getAngleBetweenPoints(x1, y1, x2, y2) == Misc.getAngleBetweenPoints(x1, y1, px, py));
	}
	
	/***
	 * Comprueba si un punto está en un rectángulo.
	 * 
	 * @param px Coordenada x del punto.
	 * @param py Coordenada y del punto.
	 * @param rx Coordenada x del rectángulo.
	 * @param ry Coordenada y del rectángulo.
	 * @param rw Anchura del rectángulo.
	 * @param rh Altura del rectángulo.
	 * @return Devuelve true si el punto está en el rectángulo.
	 */
	public static boolean PointWithRect(float px, float py, float rx, float ry, float rw, float rh) {
		return (px >= rx && px <= (rx + rw) && py >= ry && py <= (ry + rh));
	}
	
	/***
	 * Comprueba si un punto está en un círculo.
	 * 
	 * @param px Coordenada x del punto.
	 * @param py Coordenada y del punto.
	 * @param cx Coordenada x del centro del círculo.
	 * @param cy Coordenada y del centro del círculo.
	 * @param cr Radiod del círculo.
	 * @return Devuelve tru si el punto está en el círculo.
	 */
	public static boolean PointWithCircle(float px, float py, float cx, float cy, float cr) {
		return ((Math.pow(px - cx, 2) + Math.pow(py - cy, 2)) <= Math.pow(cr, 2));
	}
	
	/***
	 * Comprueba si un punto está en un triángulo.
	 * 
	 * @param px Coordenada x del punto.
	 * @param py Coordenada y del punto.
	 * @param ax Coordenada x del vértice a.
	 * @param ay Coordenada y del vértice a.
	 * @param bx Coordenada x del vértice b.
	 * @param by Coordenada y del vértice b.
	 * @param cx Coordenada x del vértice c.
	 * @param cy Coordenada y del vértice c.
	 * @return Devuelve true si está en el triángulo.
	 */
	public static boolean PointWithTriangle(float px, float py, float ax, float ay, float bx, float by, float cx, float cy) {
		return false;
	}
	
	// Line
	
	public static boolean LineWithLine() {
		return false;
	}
	
	public static boolean LineWithRect() {
		return false;
	}
	
	public static boolean LineWithCircle() {
		return false;
	}
	
	public static boolean LineWithTriangle() {
		return false;
	}
	
	// Rectangle
	
	public static boolean RectWithLine() {
		return false;
	}
	
	/***
	 * Comprueba si dos rectángulos se tocan.
	 * 
	 * @param x1 Coordenada x del primer rectángulo.
	 * @param y1 Coordenada y del primer rectángulo.
	 * @param w1 Anchura del primer rectángulo.
	 * @param h1 Altura del primer rectángulo.
	 * @param x2 Coordenada x del segundo rectángulo.
	 * @param y2 Coordenada y del segundo rectángulo.
	 * @param w2 Anchura del segundo rectángulo.
	 * @param h2 Altura del segundo rectángulo.
	 * @return Devuelve true si los rectángulos se tocan.
	 */
	public static boolean RectWithRect(float x1, float y1, float w1, float h1, float x2, float y2, float w2, float h2) {
		if (x1 > x2+w2	|| x1+w1 < x2 || y1 > y2+h2 || y1+h1 < y2) return false;
		return true;
	}
	
	public static boolean RectWithCircle() {
		return false;
	}
	
	public static boolean RectWithTriangle() {
		return false;
	}
	
	// Circle
	
	public static boolean CircleWithLine() {
		return false;
	}
	
	public static boolean CircleWithRect() {
		return false;
	}
	
	public static boolean CircleWithCircle() {
		return false;
	}
	
	public static boolean CircleWithTriangle() {
		return false;
	}
	
	// Triangle
	
	// Polygon

}

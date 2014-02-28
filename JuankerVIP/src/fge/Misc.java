package fge;

public class Misc {

	/***
	 * Convierte de grados a radianes.
	 * 
	 * @param deg Valor en grados.
	 * @return Devuelve el resultado en radianes.
	 */
	public static double DegToRad(double deg) {
		return deg * Math.PI / 180;
	}
	
	/***
	 * Convierte de radianes a grados.
	 * 
	 * @param rad Valor en radianes.
	 * @return Devuelve el resultado en grados.
	 */
	public static double RadToDeg(double rad) {
		return rad * 180 / Math.PI;
	}
	
	/***
	 * Obtiene el ángulo entre dos puntos.
	 * 
	 * @param x1 Coordenada x del punto 1.
	 * @param y1 Coordenada y del punto 1.
	 * @param x2 Coordenada x del punto 2.
	 * @param y2 Coordenada y del punto 2.
	 * @return Devuelve el ángulo entre ambos puntos.
	 */
	public static double AngleBetweenPoints(float x1, float y1, float x2, float y2) {
		double angle = -Math.atan2(y2 - y1, x2 - x1);
		return (angle >= 0) ? angle : angle + 2 * Math.PI;
	}
	
}

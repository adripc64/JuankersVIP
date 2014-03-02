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
	public static double getAngleBetweenPoints(float x1, float y1, float x2, float y2) {
		double angle = -Math.atan2(y2 - y1, x2 - x1);
		return (angle >= 0) ? angle : angle + 2 * Math.PI;
	}
	
	/***
	 * Obtiene la distancia entre dos puntos.
	 * 
	 * @param x1 Coordenada x del punto 1.
	 * @param y1 Coordenada y del punto 1.
	 * @param x2 Coordenada x del punto 2.
	 * @param y2 Coordenada y del punto 2.
	 * @return Devuelve la distancia entre ambos puntos.
	 */
	public static double getDistance(float x1, float y1, float x2, float y2) {
		float dx = x2 - x1;
		float dy = y2 - y1;
		return Math.sqrt(dx * dx + dy * dy);
	}
	
	/***
	 * Obtiene el producto escalar entre dos vectores.
	 * 
	 * @param x1 Coordenada x del primer vector.
	 * @param y1 Coordenada y del primer vector.
	 * @param z1 Coordenada z del primer vector.
	 * @param x2 Coordenada x del segundo vector.
	 * @param y2 Coordenada y del segundo vector.
	 * @param z2 Coordenada z del segundo vector.
	 * @return Devuelve el producto escalar entre ambos vectores.
	 */
	public static double dotProduct(float x1, float y1, float z1, float x2, float y2, float z2) {
		return x1*x2 + y1*y2 + z1*z2;
	}
	
	/***
	 * Obtiene el producto vectorial entre dos vectores.
	 */
	public static void crossProduct() {
		
	}
}

package fge;

public class Misc {

	public static double DegToRad(double _deg) {
		return _deg * Math.PI / 180;
	}
	
	public static double RadToDeg(double _rad) {
		return _rad * 180 / Math.PI;
	}
	
	public static double AngleBetweenPoints(float _x1, float _y1, float _x2, float _y2) {
		double _angle = -Math.atan2(_y2 - _y1, _x2 - _x1);
		return (_angle >= 0) ? _angle : _angle + 2 * Math.PI;
	}
	
}

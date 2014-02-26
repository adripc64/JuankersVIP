package fge;

public class Intersect {
	
	// Point
	
	public static boolean PointWithLine(float _px, float _py, float _x1, float _y1, float _x2, float _y2) {
		return (Misc.AngleBetweenPoints(_x1, _y1, _x2, _y2) == Misc.AngleBetweenPoints(_x1, _y1, _px, _py));
	}
	
	public static boolean PointWithRect(float _px, float _py, float _rx, float _ry, float _rw, float _rh) {
		return (_px >= _rx && _px <= (_rx + _rw) && _py >= _ry && _py <= (_ry + _rh));
	}
	
	public static boolean PointWithCircle(float _px, float _py, float _cx, float _cy, float _cr) {
		return ((Math.pow(_px - _cx, 2) + Math.pow(_py - _cy, 2)) <= Math.pow(_cr, 2));
	}
	
	public static boolean PointWithTriangle(float _px, float _py, float _ax, float _ay, float _bx, float _by, float _cx, float _cy) {
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
	
	public static boolean RectWithRect() {
		return false;
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

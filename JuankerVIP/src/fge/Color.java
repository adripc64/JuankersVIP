package fge;

public class Color {
	
	private int m_R;
	private int m_G;
	private int m_B;
	private int m_A;
	
	public Color(int _r, int _g, int _b) {
		m_R = _r;
		m_G = _g;
		m_B = _b;
		m_A = 255;
	}
	
	public Color(int _r, int _g, int _b, int _a) {
		m_R = _r;
		m_G = _g;
		m_B = _b;
		m_A = _a;
	}
	
	public int getR() { return m_R; }
	public int getG() { return m_G; }
	public int getB() { return m_B; }
	public int getA() { return m_A; }
	
	public float getRf() { return m_R / 255.0f; }
	public float getGf() { return m_G / 255.0f; }
	public float getBf() { return m_B / 255.0f; }
	public float getAf() { return m_A / 255.0f; }
}

package fge;

import org.newdawn.slick.TrueTypeFont;
import org.newdawn.slick.util.ResourceLoader;

public class Font {
	
	private TrueTypeFont m_Font;
	
	public Font(String _fontPath, float _size) {
		try {
			java.awt.Font awtFont = java.awt.Font.createFont(java.awt.Font.TRUETYPE_FONT, ResourceLoader.getResourceAsStream(_fontPath));
			awtFont = awtFont.deriveFont(_size);
			m_Font = new TrueTypeFont(awtFont, false);
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}
	
	public void Draw(float _x, float _y, String _text, Color _c) {
		org.newdawn.slick.Color _color = new org.newdawn.slick.Color(_c.getR(),	_c.getG(), _c.getB(), _c.getA());
		m_Font.drawString(_x, _y, _text, _color);
	}

}
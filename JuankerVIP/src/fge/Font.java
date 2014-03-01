package fge;

import java.awt.FontFormatException;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.IOException;

public class Font {

	private java.awt.Font font;
	private float fontSize;

	public Font(String _fontPath, float _size) {
		
		try {
			font = java.awt.Font.createFont(java.awt.Font.TRUETYPE_FONT, new FileInputStream(_fontPath));
			font = font.deriveFont(_size);
			fontSize = _size;
		} catch (IOException e) {
			e.printStackTrace();
		} catch (FontFormatException e) {
			e.printStackTrace();
		}

	}

	public Texture getStringTexture(String str) {
		
		BufferedImage bufImg = new BufferedImage(1024, (int) fontSize, BufferedImage.TYPE_INT_ARGB);
		Graphics2D g2d = bufImg.createGraphics();
		g2d.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
		g2d.setFont(font);
		g2d.setColor(java.awt.Color.white);	
		g2d.drawString(str, 0, fontSize);
		g2d.dispose();
		
		return new Texture(bufImg);		
	}
}
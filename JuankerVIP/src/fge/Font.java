package fge;

import java.awt.FontFormatException;
import java.awt.FontMetrics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.IOException;

public class Font {

	private java.awt.Font font;
	private float fontSize;
	private FontMetrics fontMetrics;

	public Font(String path, float size) {
		
		try {
			font = java.awt.Font.createFont(java.awt.Font.TRUETYPE_FONT, new FileInputStream(path));
			font = font.deriveFont(size);
			fontSize = size;
			
			BufferedImage bufImg = new BufferedImage(1, (int) fontSize, BufferedImage.TYPE_INT_ARGB);
			Graphics2D g2d = bufImg.createGraphics();
			g2d.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
			g2d.setFont(font);
			fontMetrics = g2d.getFontMetrics();
			g2d.dispose();
			
		} catch (IOException e) {
			e.printStackTrace();
		} catch (FontFormatException e) {
			e.printStackTrace();
		}

	}
	
	public int getFontSize() {
		return (int) fontSize;
	}
	
	public int getStringWidth(String str) {
		return fontMetrics.stringWidth(str);
	}

	public Texture getStringTexture(String str) {
		
		BufferedImage bufImg = new BufferedImage(getStringWidth(str), (int) fontSize, BufferedImage.TYPE_INT_ARGB);
		Graphics2D g2d = bufImg.createGraphics();
		g2d.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
		g2d.setFont(font);
		g2d.setColor(java.awt.Color.white);	
		g2d.drawString(str, 0, fontSize-4);
		g2d.dispose();
		
		return new Texture(bufImg);		
	}
}
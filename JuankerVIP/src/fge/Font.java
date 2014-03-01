package fge;

import org.lwjgl.opengl.GL11;
import org.newdawn.slick.TrueTypeFont;
import org.newdawn.slick.UnicodeFont;
import org.newdawn.slick.font.effects.ColorEffect;
import org.newdawn.slick.util.ResourceLoader;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;

public class Font {

	private TrueTypeFont m_Font;
	private UnicodeFont unicodeFont;
	BitmapFont bmFont;

	public Font(String _fontPath, float _size) {
		
		FreeTypeFontGenerator ftfgen = new FreeTypeFontGenerator(Gdx.files.internal(_fontPath));
		bmFont = ftfgen.generateFont((int) _size);
		ftfgen.dispose();
		
		/*try {
			java.awt.Font awtFont = java.awt.Font.createFont(
					java.awt.Font.TRUETYPE_FONT,
					ResourceLoader.getResourceAsStream(_fontPath));
			awtFont = awtFont.deriveFont(_size);
			unicodeFont = new UnicodeFont(awtFont);
			unicodeFont.getEffects().add(new ColorEffect(java.awt.Color.white));
			unicodeFont.addAsciiGlyphs();
			GL11.glDisable(GL11.GL_TEXTURE_2D);
			GL11.glPushAttrib(GL11.GL_ALL_ATTRIB_BITS);
			unicodeFont.loadGlyphs();
			GL11.glPopAttrib();
			GL11.glEnable(GL11.GL_TEXTURE_2D);
			//m_Font = new TrueTypeFont(awtFont, false);
			
		} catch (Exception e) {
			e.printStackTrace();
		}*/
	}

	public void Draw(float _x, float _y, String _text, Color _c) {
		/*org.newdawn.slick.Color _color = new org.newdawn.slick.Color(_c.getR(),	_c.getG(), _c.getB(), _c.getA());
		GL11.glEnable(GL11.GL_TEXTURE_2D);
		unicodeFont.drawString(_x, _y, _text, _color);
		GL11.glDisable(GL11.GL_TEXTURE_2D);*/
		SpriteBatch sprBatch = new SpriteBatch();
		sprBatch.begin();
		bmFont.setColor(_c.getR(),	_c.getG(), _c.getB(), _c.getA());
		bmFont.draw(sprBatch, _text, _x, _y);
		sprBatch.end();
	}
}
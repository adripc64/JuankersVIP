package fge;

import org.lwjgl.opengl.GL11;

public class Render {
	
	public static void DrawText(Font _font, float _x, float _y, String _text, Color _c) {
		DrawTex(_font.getStringTexture(_text), _x, _y, _c);
	}
	
	public static void DrawTex(Texture _tex, float _x, float _y, Color _c) {
		DrawTex(_tex, _x, _y, _tex.getW(), _tex.getH(), _c);
	}
	
	public static void DrawTex(Texture _tex, float _x, float _y, float _w, float _h, Color _c) {
		DrawTex(_tex, _x, _y, _w, _h, _c, 0.0f, 0.0f, 1.0f, 1.0f);
	}
	
	public static void DrawTex(Texture _tex, float _x, float _y, float _w, float _h, Color _c, float _ux, float _uy, float _uw, float _uh) {
		
		GL11.glColor4f(_c.getRf(), _c.getGf(), _c.getBf(), _c.getAf());
		
		GL11.glEnable(GL11.GL_TEXTURE_2D);
		GL11.glBindTexture(GL11.GL_TEXTURE_2D, _tex.getTextureId());
		 
		GL11.glBegin(GL11.GL_QUADS);
			GL11.glTexCoord2f(_ux,_uy);
			GL11.glVertex2f(_x, _y);
			GL11.glTexCoord2f(_ux+_uw,_uy);
			GL11.glVertex2f(_x + _w, _y);
			GL11.glTexCoord2f(_ux+_uw,_uy+_uh);
			GL11.glVertex2f(_x + _w, _y + _h);
			GL11.glTexCoord2f(_ux,_uy+_uh);
			GL11.glVertex2f(_x , _y + _h);
		GL11.glEnd();
		
		GL11.glDisable(GL11.GL_TEXTURE_2D);
	}
	
	/***
	 * Renderiza un punto en la pantalla.
	 * 
	 * @param x Coordenada x del punto.
	 * @param y Coordenada y del punto.
	 * @param color Color del punto.
	 */
	public static void DrawPoint(float x, float y, Color color) {
		
		GL11.glMatrixMode(GL11.GL_MODELVIEW);
		GL11.glColor4f(color.getRf(), color.getGf(), color.getBf(), color.getAf());
		
		GL11.glPushMatrix();			
			GL11.glBegin(GL11.GL_POINTS);
				GL11.glVertex2f(x, y);
			GL11.glEnd();
		GL11.glPopMatrix();
	}
	
	/***
	 * Renderiza una línea en la pantalla.
	 * 
	 * @param x1 Coordenada x del extremo inicial de la línea.
	 * @param y1 Coordenada y del extremo inicial de la línea.
	 * @param x2 Coordenada x del extremo final de la línea.
	 * @param y2 Coordenada y del extremo final de la línea.
	 * @param color Color de la línea.
	 */
	public static void DrawLine(float x1, float y1, float x2, float y2, Color color) {
		DrawLine(x1, y1, x2, y2, color, 1.0f);
	}
	
	/***
	 * Renderiza una línea en la pantalla.
	 * 
	 * @param x1 Coordenada x del extremo inicial de la línea.
	 * @param y1 Coordenada y del extremo inicial de la línea.
	 * @param x2 Coordenada x del extremo final de la línea.
	 * @param y2 Coordenada y del extremo final de la línea.
	 * @param color Color de la línea.
	 * @param width Grosor de la línea.
	 */
	public static void DrawLine(float x1, float y1, float x2, float y2, Color color, float width) {
		
		GL11.glMatrixMode(GL11.GL_MODELVIEW);
		GL11.glColor4f(color.getRf(), color.getGf(), color.getBf(), color.getAf());
		GL11.glLineWidth(width);
		
		GL11.glPushMatrix();			
			GL11.glBegin(GL11.GL_LINES);
				GL11.glVertex2f(x1, y1);
				GL11.glVertex2f(x2, y2);
			GL11.glEnd();
		GL11.glPopMatrix();
	}
	
	public static void DrawRect(float _x, float _y, float _w, float _h, Color _c) {
		DrawRect( _x, _y, _w, _h, _c, 1.0f);
	}
	
	public static void DrawRect(float _x, float _y, float _w, float _h, Color _c, float _width) {
		
		GL11.glColor4f(_c.getRf(), _c.getGf(), _c.getBf(), _c.getAf());
		GL11.glLineWidth(_width);
		
		GL11.glPushMatrix();			
			GL11.glBegin(GL11.GL_LINE_LOOP);
				GL11.glVertex2f(_x, _y);
				GL11.glVertex2f(_x + _w, _y);
				GL11.glVertex2f(_x + _w, _y + _h);
				GL11.glVertex2f(_x, _y + _h);
			GL11.glEnd();
		GL11.glPopMatrix();
	}
	
	public static void DrawBox(float _x, float _y, float _w, float _h, Color _c) {
		DrawBox(_x, _y, _w, _h, _c, 0.0f);
	}
	
	public static void DrawBox(float _x, float _y, float _w, float _h, Color _c, float _angle) {
		
		GL11.glColor4f(_c.getRf(), _c.getGf(), _c.getBf(), _c.getAf());
		
		GL11.glPushMatrix();
			GL11.glTranslatef(_x, _y, 0);
			GL11.glRotatef(_angle, 0f, 0f, 1f);
			GL11.glTranslatef(-_x, -_y, 0);
			
			GL11.glBegin(GL11.GL_QUADS);
				GL11.glVertex2f(_x, _y);
				GL11.glVertex2f(_x + _w, _y);
				GL11.glVertex2f(_x + _w, _y + _h);
				GL11.glVertex2f(_x, _y + _h);
			GL11.glEnd();
		GL11.glPopMatrix();
	}
	
	/**
	 * 
	 * @param x
	 * @param y
	 * @param r
	 * @param c
	 */
	public static void DrawCircle(float x, float y, float r, Color c) {
		
		GL11.glColor4f(c.getRf(), c.getGf(), c.getBf(), c.getAf());
		
		GL11.glPushMatrix();
			GL11.glTranslatef(x, y, 0);
			
			GL11.glBegin(GL11.GL_LINE_LOOP);
				for (int angle = 0; angle <= 360; angle += 5) {
					double _a = angle * Math.PI / 180;
					GL11.glVertex2d(x + r * Math.cos(_a), y + r * Math.sin(_a));
				}
			GL11.glEnd();
		GL11.glPopMatrix();
	}

	/***
	 * 
	 * @param x
	 * @param y
	 * @param r
	 * @param c
	 */
	public static void DrawFilledCircle(float x, float y, float r, Color c) {
		
		GL11.glColor4f(c.getRf(), c.getGf(), c.getBf(), c.getAf());
		
		GL11.glPushMatrix();
			//GL11.glTranslatef(_x, _y, 0);
			
			GL11.glBegin(GL11.GL_TRIANGLE_FAN);
				for (int angle = 0; angle <= 360; angle += 5) {
					double _a = angle * Math.PI / 180;
					GL11.glVertex2d(x + r * Math.cos(_a), y + r * Math.sin(_a));
				}
			GL11.glEnd();
		GL11.glPopMatrix();
	}
	
}

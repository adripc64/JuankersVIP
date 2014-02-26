package fge;

import org.lwjgl.opengl.GL11;

public class Render {
	
	public static void DrawText(Font _font, float _x, float _y, String _text, Color _c) {
		_font.Draw(_x, _y, _text, _c);
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
		
		_tex.bind(); // or GL11.glBind(texture.getTextureID());
		 
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
	
	public static void DrawPoint(float _px, float _py, Color _c) {
		
		GL11.glColor4f(_c.getRf(), _c.getGf(), _c.getBf(), _c.getAf());
		
		GL11.glPushMatrix();			
			GL11.glBegin(GL11.GL_POINTS);
				GL11.glVertex2f(_px, _py);
			GL11.glEnd();
		GL11.glPopMatrix();
	}
	
	public static void DrawLine(float _x1, float _y1, float _x2, float _y2, Color _c) {
		DrawLine(_x1, _y1, _x2, _y2, _c, 1.0f);
	}
	
	public static void DrawLine(float _x1, float _y1, float _x2, float _y2, Color _c, float _width) {
		
		GL11.glColor4f(_c.getRf(), _c.getGf(), _c.getBf(), _c.getAf());
		GL11.glLineWidth(_width);
		
		GL11.glPushMatrix();			
			GL11.glBegin(GL11.GL_LINES);
				GL11.glVertex2f(_x1, _y1);
				GL11.glVertex2f(_x2, _y2);
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
	
	
	public static void DrawCircle(float _x, float _y, float _r, Color _c) {
		
		GL11.glColor4f(_c.getRf(), _c.getGf(), _c.getBf(), _c.getAf());
		
		GL11.glPushMatrix();
			GL11.glTranslatef(_x, _y, 0);
			
			GL11.glBegin(GL11.GL_LINE_LOOP);
				for (int angle = 0; angle <= 360; angle += 5) {
					double _a = angle * Math.PI / 180;
					GL11.glVertex2d(_x + _r * Math.cos(_a), _y + _r * Math.sin(_a));
				}
			GL11.glEnd();
		GL11.glPopMatrix();
	}

	public static void DrawFilledCircle(float _x, float _y, float _r, Color _c) {
		
		GL11.glColor4f(_c.getRf(), _c.getGf(), _c.getBf(), _c.getAf());
		
		GL11.glPushMatrix();
			//GL11.glTranslatef(_x, _y, 0);
			
			GL11.glBegin(GL11.GL_TRIANGLE_FAN);
				for (int angle = 0; angle <= 360; angle += 5) {
					double _a = angle * Math.PI / 180;
					GL11.glVertex2d(_x + _r * Math.cos(_a), _y + _r * Math.sin(_a));
				}
			GL11.glEnd();
		GL11.glPopMatrix();
	}
	
}

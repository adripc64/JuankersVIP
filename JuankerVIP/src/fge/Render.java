package fge;

import org.lwjgl.opengl.GL11;

public class Render {
	
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
		
		GL11.glMatrixMode(GL11.GL_MODELVIEW);
		GL11.glColor4f(color.getRf(), color.getGf(), color.getBf(), color.getAf());
		//GL11.glLineWidth(width);
		
		GL11.glPushMatrix();			
			GL11.glBegin(GL11.GL_LINES);
				GL11.glVertex2f(x1, y1);
				GL11.glVertex2f(x2, y2);
			GL11.glEnd();
		GL11.glPopMatrix();
	}
	
	/***
	 * Renderiza un rectángulo.
	 * 
	 * @param x	Coordenada x de la esquina superior izquierda.
	 * @param y Coordenada y de la esquina superior izquierda.
	 * @param w Anchura del rectángulo.
	 * @param h Altura del rectángulo.
	 * @param angle Ángulo de rotación con pivote en la esquina superior izquierda.
	 * @param color Color del rectángulo.
	 * 
	 * @deprecated No usar!! Será eliminada más adelante.
	 */
	public static void DrawRectangle(float x, float y, float w, float h, float angle, Color color) {
		DrawRectangle(x, y, w, h, color, angle, 0.0f, 0.0f);
	}
	
	/***
	 * Renderiza un rectángulo.
	 * 
	 * @param x	Coordenada x de la esquina superior izquierda.
	 * @param y Coordenada y de la esquina superior izquierda.
	 * @param w Anchura del rectángulo.
	 * @param h Altura del rectángulo.
	 * @param color Color del rectángulo.
	 */
	public static void DrawRectangle(float x, float y, float w, float h, Color color) {
		DrawRectangle(x, y, w, h, color, 0.0f, 0.0f, 0.0f);
	}
	
	/***
	 * Renderiza un rectángulo.
	 * 
	 * @param x	Coordenada x de la esquina superior izquierda.
	 * @param y Coordenada y de la esquina superior izquierda.
	 * @param w Anchura del rectángulo.
	 * @param h Altura del rectángulo.
	 * @param color Color del rectángulo.
	 * @param angle Ángulo de rotación.
	 * @param px Coordenada x normalizada (0.0f-1.0f) para el pivote de rotación.
	 * @param py Coordenada y normalizada (0.0f-1.0f) para el pivote de rotación.
	 */
	public static void DrawRectangle(float x, float y, float w, float h, Color color, float angle, float px, float py) {
		
		GL11.glMatrixMode(GL11.GL_MODELVIEW);
		GL11.glColor4f(color.getRf(), color.getGf(), color.getBf(), color.getAf());
		
		GL11.glPushMatrix();
			GL11.glTranslatef(x+w*px, y+h*py, 0);
			GL11.glRotatef(-angle, 0f, 0f, 1f);
			GL11.glTranslatef(-x-w*px, -y-h*py, 0);
		
			GL11.glBegin(GL11.GL_LINE_LOOP);
				GL11.glVertex2f(x, y);
				GL11.glVertex2f(x + w, y);
				GL11.glVertex2f(x + w, y + h);
				GL11.glVertex2f(x, y + h);
			GL11.glEnd();
		GL11.glPopMatrix();
	}
	
	/***
	 * Renderiza un rectángulo con relleno.
	 * 
	 * @param x	Coordenada x de la esquina superior izquierda.
	 * @param y Coordenada y de la esquina superior izquierda.
	 * @param w Anchura del rectángulo.
	 * @param h Altura del rectángulo.
	 * @param angle Ángulo de rotación con pivote en la esquina superior izquierda.
	 * @param color Color del rectángulo.
	 * 
	 * @deprecated No usar!! Será eliminada más adelante.
	 */
	public static void DrawFilledRectangle(float x, float y, float w, float h, float angle, Color color) {
		DrawFilledRectangle(x, y, w, h, color, angle, 0.0f, 0.0f);
	}
	
	/***
	 * Renderiza un rectángulo con relleno.
	 * 
	 * @param x	Coordenada x de la esquina superior izquierda.
	 * @param y Coordenada y de la esquina superior izquierda.
	 * @param w Anchura del rectángulo.
	 * @param h Altura del rectángulo.
	 * @param color Color del rectángulo.
	 */
	public static void DrawFilledRectangle(float x, float y, float w, float h, Color color) {
		DrawFilledRectangle(x, y, w, h, color, 0.0f, 0.0f, 0.0f);
	}	
	
	/***
	 * Renderiza un rectángulo con relleno.
	 * 
	 * @param x	Coordenada x de la esquina superior izquierda.
	 * @param y Coordenada y de la esquina superior izquierda.
	 * @param w Anchura del rectángulo.
	 * @param h Altura del rectángulo.
	 * @param color Color del rectángulo.
	 * @param angle Ángulo de rotación.
	 * @param px Coordenada x normalizada (0.0f-1.0f) para el pivote de rotación.
	 * @param py Coordenada y normalizada (0.0f-1.0f) para el pivote de rotación.
	 */
	public static void DrawFilledRectangle(float x, float y, float w, float h, Color color, float angle, float px, float py) {
	
		GL11.glMatrixMode(GL11.GL_MODELVIEW);
		GL11.glColor4f(color.getRf(), color.getGf(), color.getBf(), color.getAf());
		
		GL11.glPushMatrix();
			GL11.glTranslatef(x+w*px, y+h*py, 0);
			GL11.glRotatef(-angle, 0f, 0f, 1f);
			GL11.glTranslatef(-x-w*px, -y-h*py, 0);
			
			GL11.glBegin(GL11.GL_QUADS);
				GL11.glVertex2f(x, y);
				GL11.glVertex2f(x + w, y);
				GL11.glVertex2f(x + w, y + h);
				GL11.glVertex2f(x, y + h);
			GL11.glEnd();
		GL11.glPopMatrix();
	}
	
	/**
	 * Renderiza un círculo.
	 * 
	 * @param x Coordenada x del centro del círculo.
	 * @param y Coordenada y del centro del círculo.
	 * @param radius Radio del círculo.
	 * @param color Color del círculo.
	 */
	public static void DrawCircle(float x, float y, float radius, Color color) {
		
		GL11.glMatrixMode(GL11.GL_MODELVIEW);
		GL11.glColor4f(color.getRf(), color.getGf(), color.getBf(), color.getAf());
		
		GL11.glPushMatrix();
			GL11.glTranslatef(x, y, 0);
			
			GL11.glBegin(GL11.GL_LINE_LOOP);
				for (int angle = 0; angle <= 360; angle += 5) {
					double _a = Misc.DegToRad(angle);
					GL11.glVertex2d(radius * Math.cos(_a), radius * Math.sin(_a));
				}
			GL11.glEnd();
		GL11.glPopMatrix();
	}

	/***
	 * Renderiza un círculo con relleno.
	 * 
	 * @param x Coordenada x del centro del círculo.
	 * @param y Coordenada y del centro del círculo.
	 * @param radius Radio del círculo.
	 * @param color Color del círculo.
	 */
	public static void DrawFilledCircle(float x, float y, float radius, Color color) {
		
		GL11.glMatrixMode(GL11.GL_MODELVIEW);
		GL11.glColor4f(color.getRf(), color.getGf(), color.getBf(), color.getAf());
		
		GL11.glPushMatrix();
			GL11.glTranslatef(x, y, 0);
			
			GL11.glBegin(GL11.GL_TRIANGLE_FAN);
				for (int angle = 0; angle <= 360; angle += 5) {
					double _a = Misc.DegToRad(angle);
					GL11.glVertex2d(radius * Math.cos(_a), radius * Math.sin(_a));
				}
			GL11.glEnd();
		GL11.glPopMatrix();
	}
	
	/***
	 * Renderiza una textura.
	 * 
	 * @param tex Textura a renderizar.
	 * @param x Coordenada x.
	 * @param y Coordenada y.
	 * @param color Color a aplicar.
	 */
	public static void DrawTexture(Texture tex, float x, float y, Color color) {
		DrawTexture(tex, x, y, tex.getW(), tex.getH(), 0, color);
	}
	
	/***
	 * Renderiza una textura.
	 * 
	 * @param tex Textura a renderizar.
	 * @param x Coordenada x.
	 * @param y Coordenada y.
	 * @param w Anchura.
	 * @param h Altura.
	 * @param angle Ángulo de rotación con pivote en la esquina superior izquierda.
	 * @param color Color a aplicar.
	 * 
	 * @deprecated No usar!! Será eliminada más adelante.
	 */
	public static void DrawTexture(Texture tex, float x, float y, float w, float h, float angle, Color color) {
		DrawTexture(tex, x, y, w, h, color, angle, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 1.0f);
	}
	
	/***
	 * Renderiza una textura.
	 * 
	 * @param tex Textura a renderizar.
	 * @param x Coordenada x.
	 * @param y Coordenada y.
	 * @param w Anchura.
	 * @param h Altura.
	 * @param color Color a aplicar.
	 * @param angle Ángulo de rotación.
	 * @param px Coordenada x normalizada (0.0f-1.0f) para el pivote de rotación.
	 * @param py Coordenada y normalizada (0.0f-1.0f) para el pivote de rotación.
	 */
	public static void DrawTexture(Texture tex, float x, float y, float w, float h, Color color, float angle, float px, float py) {
		DrawTexture(tex, x, y, w, h, color, angle, px, py, 0.0f, 0.0f, 1.0f, 1.0f);
	}
	
	/***
	 * Renderiza una textura.
	 * 
	 * @param tex Textura a renderizar.
	 * @param x Coordenada x.
	 * @param y Coordenada y.
	 * @param w Anchura.
	 * @param h Altura.
	 * @param angle Ángulo de rotación con pivote en la esquina superior izquierda.
	 * @param color Color a aplicar.
	 * @param ux
	 * @param uy
	 * @param uw
	 * @param uh
	 * 
	 * @deprecated No usar!! Será eliminada más adelante.
	 */
	public static void DrawTexture(Texture tex, float x, float y, float w, float h, float angle, Color color, float ux, float uy, float uw, float uh) {
		DrawTexture(tex, x, y, w, h, color, angle, 0.0f, 0.0f, ux, uy, uw, uh);
	}
	
	/***
	 * Renderiza una textura.
	 * 
	 * @param tex Textura a renderizar.
	 * @param x Coordenada x.
	 * @param y Coordenada y.
	 * @param w Anchura.
	 * @param h Altura.
	 * @param color Color a aplicar.
	 * @param angle Ángulo de rotación.
	 * @param px Coordenada x normalizada (0.0f-1.0f) para el pivote de rotación.
	 * @param py Coordenada y normalizada (0.0f-1.0f) para el pivote de rotación.
	 * @param ux
	 * @param uy
	 * @param uw
	 * @param uh
	 */
	public static void DrawTexture(Texture tex, float x, float y, float w, float h, Color color, float angle, float px, float py, float ux, float uy, float uw, float uh) {
		
		GL11.glMatrixMode(GL11.GL_MODELVIEW);
		GL11.glColor4f(color.getRf(), color.getGf(), color.getBf(), color.getAf());
		
		GL11.glEnable(GL11.GL_TEXTURE_2D);
		GL11.glBindTexture(GL11.GL_TEXTURE_2D, tex.getTextureId());
		 
		GL11.glPushMatrix();
			GL11.glTranslatef(x+w*px, y+h*py, 0);
			GL11.glRotatef(-angle, 0f, 0f, 1f);
			GL11.glTranslatef(-x-w*px, -y-h*py, 0);
			
			GL11.glBegin(GL11.GL_QUADS);
				GL11.glTexCoord2f(ux,uy);
				GL11.glVertex2f(x, y);
				GL11.glTexCoord2f(ux+uw,uy);
				GL11.glVertex2f(x + w, y);
				GL11.glTexCoord2f(ux+uw,uy+uh);
				GL11.glVertex2f(x + w, y + h);
				GL11.glTexCoord2f(ux,uy+uh);
				GL11.glVertex2f(x , y + h);
			GL11.glEnd();
		GL11.glPopMatrix();
		
		GL11.glDisable(GL11.GL_TEXTURE_2D);
	}
	
	/***
	 * Renderiza texto.
	 * 
	 * @param font Fuente a utilizar.
	 * @param x Coordenada x.
	 * @param y Coordenada y.
	 * @param text Texto a renderizar.
	 * @param color Color del texto.
	 */
	public static void DrawText(Font font, float x, float y, String text, Color color) {
		DrawTexture(font.getStringTexture(text), x, y, color);
	}
	
}

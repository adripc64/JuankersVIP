package fge;

import java.io.IOException;

import org.newdawn.slick.opengl.TextureLoader;
import org.newdawn.slick.util.ResourceLoader;

public class Texture {
	
	private org.newdawn.slick.opengl.Texture m_Tex;
	private int m_W;
	private int m_H;
	
	public Texture(String _type, String _texPath) {
		try {
			m_Tex = TextureLoader.getTexture(_type, ResourceLoader.getResourceAsStream(_texPath));
			m_W = m_Tex.getImageWidth();
			m_H = m_Tex.getImageHeight();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public int getW() { return m_W; }
	public int getH() { return m_H; }
	
	public void bind() { m_Tex.bind(); }
	
}

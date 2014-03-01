package fge;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;

import javax.imageio.ImageIO;

import org.lwjgl.BufferUtils;
import org.lwjgl.opengl.GL11;

public class Texture {
	
	private int texId;
	private int texWidth;
	private int texHeight;
	
	public Texture(String path) {
		
		try {
			loadTexture(ImageIO.read(new File(path)));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public Texture(BufferedImage bufImg) {
		loadTexture(bufImg);
	}
	
	public int getTextureId() { return texId; }
	public int getW() { return texWidth; }
	public int getH() { return texHeight; }
	
	private static final int BYTES_PER_PIXEL = 4;
	
	private void loadTexture(BufferedImage image) {
		
		texWidth = image.getWidth();
		texHeight = image.getHeight();
      
		int[] pixels = new int[texWidth * texHeight];
        image.getRGB(0, 0, texWidth, texHeight, pixels, 0, texWidth);

        ByteBuffer buffer = BufferUtils.createByteBuffer(texWidth * texHeight * BYTES_PER_PIXEL);

        for (int y = 0; y < texHeight; y++) {
        	for (int x = 0; x < texWidth; x++) {
        		int pixel = pixels[y * texWidth + x];
        		buffer.put((byte) ((pixel >> 16) & 0xFF));		// Red component
				buffer.put((byte) ((pixel >> 8) & 0xFF));		// Green component
				buffer.put((byte) (pixel & 0xFF));				// Blue component
				buffer.put((byte) ((pixel >> 24) & 0xFF));		// Alpha component. Only for RGBA
        	}
        }

        buffer.flip();

        texId = GL11.glGenTextures();
        GL11.glBindTexture(GL11.GL_TEXTURE_2D, texId);

		//Setup wrap mode
        //GL11.glTexParameteri(GL11.GL_TEXTURE_2D, GL11.GL_TEXTURE_WRAP_S, GL11.GL_CLAMP_TO_EDGE);
        //GL11.glTexParameteri(GL11.GL_TEXTURE_2D, GL11.GL_TEXTURE_WRAP_T, GL11.GL_CLAMP_TO_EDGE);
		
		//Setup texture scaling filtering
        GL11.glTexParameteri(GL11.GL_TEXTURE_2D, GL11.GL_TEXTURE_MIN_FILTER, GL11.GL_LINEAR);
        GL11.glTexParameteri(GL11.GL_TEXTURE_2D, GL11.GL_TEXTURE_MAG_FILTER, GL11.GL_LINEAR);

		//Send texel data to OpenGL
        GL11.glTexImage2D(GL11.GL_TEXTURE_2D, 0, GL11.GL_RGBA8, texWidth, texHeight, 0, GL11.GL_RGBA, GL11.GL_UNSIGNED_BYTE, buffer);
	}
	
}

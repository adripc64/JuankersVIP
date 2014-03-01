package fge;

import java.io.IOException;

import org.newdawn.slick.openal.Audio;
import org.newdawn.slick.openal.AudioLoader;
import org.newdawn.slick.util.ResourceLoader;

public class Sound {
	
	private Audio audio;
	
	public Sound(String path) {
		
		try {
			audio = AudioLoader.getAudio("OGG", ResourceLoader.getResourceAsStream(path));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	/***
	 * Empieza la reproducción de un sonido.
	 * 
	 * @param loop Si se desea que el sonido se reproduzca en bucle.
	 */
	public void play(boolean loop) {
		if (audio != null) audio.playAsSoundEffect(1.0f, 1.0f, loop);
	}
	
	/***
	 * Termina la reproducción del sonido.
	 */
	public void stop() {
		if (audio != null) audio.stop();
	}
	
	/***
	 * Comprueba si un sonido está reproduciendose.
	 * 
	 * @return Devuelve true si está reproduciendose.
	 */
	public boolean isPlaying() {
		if (audio != null) return audio.isPlaying();
		return false;
	}
}

package fgeExamples;

import fge.App;
import fge.Color;
import fge.Event;
import fge.Event.EventType;
import fge.EventListener;
import fge.EventMan;
import fge.Font;
import fge.Keyboard;
import fge.Render;
import fge.Service;
import fge.Sound;

public class SoundExample extends Service implements EventListener {
	
	private Sound sound;
	private Font font;
	
	public static void main(String[] args) {
		App.run(new SoundExample(), 640, 480);
	}

	@Override
	protected void onStart() {
		sound = new Sound("data/sounds/sonido.ogg");
		font = new Font("data/andrewsc.ttf", 24.0f);
		EventMan.addListener(this);
	}

	@Override
	protected void onStop() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void onMove() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void onDraw() {
		
		int x = 10;
		int y = 10;
		Color color = new Color(255,255,0);
		Render.DrawText(font, x, y, "Pulsa SPACE para reproducir el sonido.", color);
		y += 40;
		Render.DrawText(font, x, y, "Pulsa S para parar la reproducción del sonido.", color);
		y += 40;
		Render.DrawText(font, x, y, "Pulsa L para reproducir el sonido en bucle.", color);
		y += 40;
		if (sound.isPlaying())
			Render.DrawText(font, x, y, "Sonando...", new Color(0,255,0));
		
	}
	
	@Override
	public boolean doEvent(Event e) {
		if (e.getType() == EventType.KEY_PRESSED) {
			if (e.getValue() == Keyboard.KEY_SPACE) sound.play(false);
			if (e.getValue() == Keyboard.KEY_S) sound.stop();
			if (e.getValue() == Keyboard.KEY_L) sound.play(true);
		}
		return false;
	}
	
}

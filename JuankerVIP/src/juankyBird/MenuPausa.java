package juankyBird;

import fge.Color;
import fge.Event;
import fge.EventListener;
import fge.EventMan;
import fge.Mouse;
import fge.Render;
import fge.Service;
import fge.ServiceMan;
import fge.Texture;
import fge.Window;
import fge.Event.EventType;

public class MenuPausa extends Service implements EventListener {
	private Texture texReini;
	private Game game;
	
	public MenuPausa() {
		texReini = new Texture("PNG", "data/reiniciar.png");
	}
	
	@Override
	public void onStart() {
		game = new Game();
		ServiceMan.addService(game);
		EventMan.addListener(game);
	}

	@Override
	public boolean doEvent(Event e) {
		if (!isRunning()) return false;
		if (e.getType() == EventType.MOUSE_PRESSED) {

			int mx = Mouse.getX();
			int my = Mouse.getY();
			if(mx>=(Window.getW()-30)/2&&mx<(Window.getW()-30)-30 && my>=(Window.getH()-30)/2 && my<(Window.getH()-30)+30 ){
				stop();
				// Aquí lo que vullges que pase quan fas click al boto... reiniciar el joc per exemple?
				game.start();
			}

		}
		return false;
	}

	@Override
	protected void onStop() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void onPause() {
		
		
	}

	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void onMove() {
		
	}

	@Override
	protected void onDraw() {
		Render.DrawTex(texReini, (Window.getW()-30)/2, (Window.getH()-30)/2, 100, 100, new Color(255, 255, 255));
		
	}
}

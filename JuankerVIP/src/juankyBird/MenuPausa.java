package juankyBird;

import fge.App;
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
	private Texture texApa;
	private Game game;
	
	public MenuPausa() {
		texReini = new Texture("data/reiniciar.png");
		texApa= new Texture("data/apagar.png");
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
			if(mx>=(Window.getW()-100)/2 && mx<=(Window.getW())/2 && (my>=(Window.getH()-30)/2 && my<=(Window.getH()/2+30) )){
				System.out.println("reinicia");
				stop();
				// Aquí lo que vullges que pase quan fas click al boto... reiniciar el joc per exemple?
				game.start();
			}
			if(mx>=(Window.getW()+50)/2&&mx<=(Window.getW()+165)/2 && my>=(Window.getH())/2-25 && my<(Window.getH())/2+35 ){
				// Aquí lo que vullges que pase quan fas click al boto... reiniciar el joc per exemple?
				App.exit();
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
		Render.DrawTexture(texReini, (Window.getW()-100)/2, (Window.getH()-30)/2, 55, 55, 0, new Color(255, 255, 255));
		Render.DrawTexture(texApa, (Window.getW()+50)/2, (Window.getH()-35)/2, 60, 60, 0, new Color(255, 255, 255));
	}
}

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

public class MenuInici extends Service implements EventListener {
	private Texture texEnc;
	private Game game;
	
	public MenuInici(){
		texEnc=new Texture("data/encendre.png");
	}
	@Override
	public boolean doEvent(Event e) {
		
		if (e.getType() == EventType.MOUSE_PRESSED) {

			int mx = Mouse.getX();
			int my = Mouse.getY();
			
			if(mx>=(Window.getW()-20)/2 && mx<=(Window.getW()+20)/2 && (my>=(Window.getH()-30)/2 && my<=(Window.getH()+30/2) )){
				// Aquí lo que vullges que pase quan fas click al boto... reiniciar el joc per exemple?
				game.start();
			}
		}
		return false;
	}

	@Override
	protected void onStart() {
		game = new Game();
		ServiceMan.addService(game);
		EventMan.addListener(game);
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
		Render.DrawTexture(texEnc, (Window.getW()-20)/2, (Window.getH()-20)/2, 55, 55, 0, new Color(255, 255, 255));
		
	}
	
}

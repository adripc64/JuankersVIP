package breakoutAitor;

import juankyBird.Pardal;
import juankyBird.Tuberia;
import fge.App;
import fge.Color;
import fge.Event;
import fge.EventListener;
import fge.EventMan;
import fge.Render;
import fge.Service;
import fge.Texture;
import fge.Window;

public class Game extends Service implements EventListener {
	
	private Barra barra;
	private Bola bola;
	private Bloque block;
	private Texture background;
	private BlockBoard board;
	
	@Override
	public void onStart() {
		
		barra = new Barra();
		bola = new Bola();
		background = new Texture("data/backgroundBreakOut.png"); 	
		board = new BlockBoard(5, 5);		
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
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean doEvent(Event e) {
		// TODO Auto-generated method stub
		return false;
	}

}

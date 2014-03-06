package juankyBird;

import fge.App;
import fge.Service;
import fge.ServiceMan;

public class Main extends Service {
	
	public static void main(String[] args) {
		App.run(new Main(), 480, 640);
	}
	
	@Override
	public void onStart() {
		ServiceMan.runService("game", new Game());
		ServiceMan.addService("menu_pausa", new MenuPausa());
	}

	@Override
	protected void onStop() {
		
		
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
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void onDraw() {
		// TODO Auto-generated method stub
		
	}
}

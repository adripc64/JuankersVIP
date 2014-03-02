package juankyBird;

import fge.App;
import fge.Service;
import fge.ServiceMan;

public class Main extends Service {
	
	public static Main main;
	public static Game game;
	
	public static void main(String[] args) {
		main = new Main();
		App.run(main, 480, 640);
	}
	
	@Override
	public void onStart() {
		
		game=new Game();
		ServiceMan.runService(game);
		
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

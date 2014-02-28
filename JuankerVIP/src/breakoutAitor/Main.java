package breakoutAitor;

import breakoutAitor.Game;
import breakoutAitor.Main;
import fge.App;
import fge.Service;
import fge.ServiceMan;

public class Main extends Service {
	public static Main main = new Main();
	public static Game game = new Game();
	
	public static void main(String[] args) {
		App.run(main, 480, 640); 				//Start game with a 480x640 configuration window and a Main Service.
	}
	
	@Override
	public void onStart() {
		//ServiceMan.runService(game);
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
}

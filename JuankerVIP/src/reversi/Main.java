package reversi;

import fge.App;
import fge.Service;
import fge.ServiceMan;

public class Main extends Service {
	
	public static void main(String[] args) {
		App.run(new Main(), 600, 800);
	}
	
	@Override
	public void onStart() {
		ServiceMan.runService("game", new Game());
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

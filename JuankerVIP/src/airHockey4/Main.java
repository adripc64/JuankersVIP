package airHockey4;

import fge.App;
import fge.Service;
import fge.ServiceMan;

public class Main extends Service{
	
	public static void main(String[] args) {
		App.run(new Main(), 700, 700);
	}
	
	@Override
	public void onStart() {
		String juego = "juego";
		ServiceMan.runService(juego, new Game());
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
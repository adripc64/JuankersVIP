package reversi;

import fge.App;
import fge.Service;
import fge.ServiceMan;

public class Main extends Service {
	
	public static Main main = new Main();
	public static Game game = new Game();
	
	public static void main(String[] args) {
		App.run(main, 600, 800);
	}
	
	public void onStart() {
		ServiceMan.runService(game);
	}
	
}

package fgeExamples;

import fge.App;
import fge.Event;
import fge.Event.EventType;
import fge.EventListener;
import fge.EventMan;
import fge.Mouse;
import fge.Service;

public class MouseEventsExample extends Service implements EventListener {

	public static void main(String[] args) {
		App.run(new MouseEventsExample(), 640, 480);
	}

	@Override
	protected void onStart() {
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
		
		if (e.getType() == EventType.MOUSE_MOVE) System.out.println("lalala");
		
		switch(e.getType()) {
		case MOUSE_PRESSED:
			System.out.println("Mouse pressed " + e.getValue());
			break;
		case MOUSE_RELEASED:
			System.out.println("Mouse released " + e.getValue());
			break;
		case MOUSE_MOVE:
			System.out.println("Mouse move x: " + Mouse.getX() + ", y: " + Mouse.getY() + ", dx: " + Mouse.getDX() + ", dy: " + Mouse.getDY());
			break;
		case MOUSE_WHEEL:
			System.out.println("Mouse wheel");
			break;
		default:
			System.out.println("Another event");
			break;
		}
		
		return false;
	}

}

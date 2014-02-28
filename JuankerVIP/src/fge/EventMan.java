package fge;

import java.util.ArrayList;

import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;

public final class EventMan {
	
	private static ArrayList<EventListener> serviceList = new ArrayList<EventListener>();
	
	public static void addListener(EventListener s) {
		serviceList.add(s);
	}
	
	public static void move() {
		
		Event e;
		while ((e = nextEvent()) != null) {
			for (int i = 0; i < serviceList.size(); i++) {
				if (serviceList.get(i).doEvent(e)) break;
			}
		}
		
	}
	
	private static Event nextEvent() {
		
		Event _e = null;
		
		if (Keyboard.next()) {
			if (Keyboard.getEventKeyState()) {
				_e = new Event(Event.KEY_PRESSED, Keyboard.getEventKey());
			} else {
				_e = new Event(Event.KEY_RELEASED, Keyboard.getEventKey());
			}			
		}
		
		if (Mouse.next()) {
		    if (Mouse.getEventButtonState()) {
		    	_e = new Event(Event.MOUSE_PRESSED, Mouse.getEventButton());
		    } else {
		    	_e = new Event(Event.MOUSE_RELEASED, Mouse.getEventButton());
		    }
		}
		
		
		return _e;
	}

}

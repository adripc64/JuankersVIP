package fge;

import java.util.ArrayList;

import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;

import fge.Event.EventType;

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
		
		Event e = null;
		
		if (Keyboard.next()) {
			if (Keyboard.getEventKeyState()) {
				e = new Event(EventType.KEY_PRESSED, Keyboard.getEventKey());
			} else {
				e = new Event(EventType.KEY_RELEASED, Keyboard.getEventKey());
			}			
		}
		
		if (Mouse.next()) {
			if (Mouse.getEventDX() != 0 || Mouse.getEventDY() != 0)
				e = new Event(EventType.MOUSE_MOVE, 0);
			else if (Mouse.getEventButtonState())
		    	e = new Event(EventType.MOUSE_PRESSED, Mouse.getEventButton());
			else
		    	e = new Event(EventType.MOUSE_RELEASED, Mouse.getEventButton());
		    
		}
		
		
		return e;
	}

}

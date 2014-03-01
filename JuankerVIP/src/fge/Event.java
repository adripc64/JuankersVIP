package fge;

import fge.Mouse.MouseButton;

public class Event {
	
	public enum EventType {
		KEY_PRESSED,
		KEY_RELEASED,
		MOUSE_PRESSED,
		MOUSE_RELEASED,
		MOUSE_MOVE,
		MOUSE_WHEEL;
	}
	
	private EventType type;
	private int value;
	//private MouseButton mouseButton;
	
	public Event(EventType type, int value) {
		this.type = type;
		this.value = value;
	}
	
	/**
	 * Obtiene el tipo de evento.
	 * 
	 * @return Devuelve el tipo de evento.
	 */
	public EventType getType() { return type; }
	
	/***
	 * 
	 * @return Devuelve el valor.
	 */
	public int getValue() { return value; }
	
	/***
	 * 
	 * @return
	 */
	public MouseButton getMouseButton() {
		//return MouseButton.values()[];
		return null;
	}
		
}

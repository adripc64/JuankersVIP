package fge;

public class Event {
	
	public final static int KEY_PRESSED = 0;
	public final static int KEY_RELEASED = 1;
	public final static int MOUSE_PRESSED = 2;
	public final static int MOUSE_RELEASED = 3;
	public final static int MOUSE_MOVE = 4;
	public final static int MOUSE_WHEEL = 5;
	
	private int m_EventType;
	private int m_EventValue;
	
	public Event(int _eventType, int _eventValue) {
		m_EventType = _eventType;
		m_EventValue = _eventValue;
	}
	
	public int getType() { return m_EventType; }
	public int getValue() { return m_EventValue; }
		
}

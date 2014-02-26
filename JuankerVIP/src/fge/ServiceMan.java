package fge;

import java.util.ArrayList;

public final class ServiceMan {
	
	private static ArrayList<Service> serviceList = new ArrayList<Service>();
	
	public static void runService(Service s) {
		serviceList.add(s);
		s.start();
	}
	
	public static void move() {
		for (int i = 0; i < serviceList.size(); i++) {
			serviceList.get(i).move();
		}
	}
	
	public static void draw() {
		for (int i = 0; i < serviceList.size(); i++) {
			serviceList.get(i).draw();
		}
	}
	
}

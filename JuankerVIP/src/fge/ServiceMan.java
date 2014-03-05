package fge;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public final class ServiceMan {
	
	private static Map<String,Service> serviceMap = new HashMap<String,Service>();
	private static ArrayList<Service> serviceList = new ArrayList<Service>();
	
	/***
	 * Registra un servicio.
	 * 
	 * @param name Nombre del servicio.
	 * @param s Servicio a registrar.
	 */
	public static void addService(String name, Service s) {
		// TODO: verificar que no sea nulo o que no exista ya...
		serviceList.add(s);
		serviceMap.put(name, s);
	}
	
	/***
	 * Registra y empieza un servicio.
	 * 
	 * @param name Nombre del servicio.
	 * @param s Servicio a registrar.
	 */
	public static void runService(String name, Service s) {
		// TODO: verificar que no sea nulo o que no exista ya...
		addService(name, s);
		s.start();
	}
	
	/***
	 * Obtiene un servicio registrado.
	 * 
	 * @param name Nombre del servicio que se quiere obtener.
	 * @return Devuelve el servicio o null si no existe.
	 */
	public static Service getService(String name) {
		return serviceMap.get(name);
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

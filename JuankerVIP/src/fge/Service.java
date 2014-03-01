package fge;

public abstract class Service  {
	
	private boolean stopped = true;
	private boolean paused = false;
	
	/***
	 * Empieza el servicio.
	 */
	public final void start() {
		stopped = false;
		paused = false;
		onStart();
	}
	
	/***
	 * Para el servicio.
	 */
	public final void stop() {
		stopped = true;
		paused = false;
		onStop();
	}
	
	/***
	 * Pausa el servicio.
	 */
	public final void pause() {
		paused = true;
		onPause();
	}
	
	/***
	 * Reanuda el servicio. 
	 */
	public final void resume() {
		paused = false;
		onResume();
	}
	
	/***
	 * Mueve el servicio.
	 */
	public final void move() {
		if (!paused && !stopped) onMove();
	}
	
	/***
	 * Dibuja el servicio.
	 */
	public final void draw() {
		if (!stopped) onDraw();
	}
	
	/***
	 * Será llamado al empezar un servicio.
	 */
	protected abstract void onStart();
	
	/***
	 * Será llamado al parar un servicio.
	 */
	protected abstract void onStop();
	
	/***
	 * Será llamado al pausar un servicio.
	 */
	protected abstract void onPause();
	
	/***
	 * Será llamado al reanudar un servicio tras ser pausado.
	 */
	protected abstract void onResume();
	
	/***
	 * Será llamado en cada frame si el servicio no está parado ni pausado.
	 */
	protected abstract void onMove();
	
	/***
	 * Será llamado en cada frame si el servicio no está parado.
	 */
	protected abstract void onDraw();
	
	/***
	 * Consulta si el servicio está pausado.
	 * 
	 * @return Devuelve true si el servicio está pausado.
	 */
	public boolean isPaused() {
		return paused;
	}
	
	/***
	 * Consulta si el servicio está en ejecución.
	 * 
	 * @return Devuelve true si el servicio no está parado.
	 */
	public boolean isRunning() {
		return !stopped;
	}
	
}

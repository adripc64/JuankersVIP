package pingPong;

public class Marcador {
	private int score1;
	private int score2;
	
	
	public Marcador(int score1, int score2){
		this.score1 = score1;
		this.score2 = score2;
	}
	
	public int incrementarScore1(){
		return ++score1;
	}
	
	public int incrementarScore2(){
		return ++score2;
	}
	
	public String mostrarMarcador(){
		return score1 + " - " + score2;
	}
	
	
	
	
}

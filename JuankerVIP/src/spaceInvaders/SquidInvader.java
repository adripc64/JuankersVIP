package spaceInvaders;

import fge.Texture;

public class SquidInvader extends Invader {

	private int score;
	private Texture invaderTexture1;
	private Texture invaderTexture2;
	private boolean animation = true;
	
	public SquidInvader() {
		score = 10;
		invaderTexture1 = new Texture("data/spaceInvaders/cannon.png");
	}

	@Override
	public int getScore() {
		return score;
	}

	@Override
	public Texture getTexture() {
		if(animation){
			animation=false;
			return invaderTexture1;
		}
		animation=true;
		return invaderTexture2;
	}

}

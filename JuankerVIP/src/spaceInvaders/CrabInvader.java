package spaceInvaders;

import fge.Texture;

public class CrabInvader extends Invader {

	private int score;
	private Texture invaderTexture1;
	private Texture invaderTexture2;
	private boolean animation = true;
	
	public CrabInvader() {
		score = 20;
		invaderTexture1 = new Texture("data/spaceInvaders/invaderCrab_01.png");
		invaderTexture1 = new Texture("data/spaceInvaders/invaderCrab_02.png");
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

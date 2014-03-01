package spaceInvaders;

import fge.Texture;

public class CrabInvader extends Invader {

	private int score;
	private Texture invaderTexture;
	
	public CrabInvader() {
		score = 20;
		invaderTexture = new Texture("data/spaceInvaders/cannon.png");
	}

	@Override
	public int getScore() {
		return score;
	}

	@Override
	public Texture getTexture() {
		return invaderTexture;
	}

}

package spaceInvaders;

import fge.Texture;

public class SquidInvader extends Invader {

	private int score;
	private Texture invaderTexture1;
	private Texture invaderTexture2;

	public SquidInvader() {
		score = 10;
		invaderTexture1 = invaderTexture2 = new Texture(
				"data/spaceInvaders/cannon.png");
	}

	@Override
	public int getScore() {
		return score;
	}

	@Override
	public Texture getTexture() {

		return invaderTexture1;

	}

}

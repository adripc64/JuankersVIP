package spaceInvaders;

import fge.Texture;

public class OctopusInvader extends Invader {

	private int score;
	private Texture invaderTexture1;
	private Texture invaderTexture2;

	public OctopusInvader() {
		score = 30;
		invaderTexture1 = invaderTexture2 = new Texture(
				"data/spaceInvaders/invaderOctopus_01x04.png");
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

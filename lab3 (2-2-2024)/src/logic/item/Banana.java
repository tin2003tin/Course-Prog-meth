package logic.item;

import logic.game.GameController;
import logic.ghost.Ghost;
import utils.Config;

public class Banana extends Item{

	public Banana() {
	}

	@Override
	public int getLevel() {
		return Config.BananaLevel;
	}

	@Override
	public void effect() {
		for(Ghost ghost : GameController.getInstance().getGhosts()) {
			System.out.print(ghost + " ");
		}
		System.out.print("\n");
	}

	@Override
	public String toString() {
		String className = getClass().getSimpleName();
		return className.substring(0, 1).toUpperCase() + className.substring(1);
	}

}

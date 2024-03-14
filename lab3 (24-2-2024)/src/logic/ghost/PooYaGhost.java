package logic.ghost;

import logic.game.GameController;
import utils.Config;

public class PooYaGhost extends HighGhost{
	private int power;

    public PooYaGhost(int power) {
        super();
        this.power = power;
    }
    public int getLevel() {
        return Config.PooYaGhostLevel;
    }

    @Override
    public String toString() {
        return "PooYaGhost [" +
                "HP: " + super.getHp() +
                " , Power: " + this.power +
                ']';
    }
    public void attack() {
        int new_hp = GameController.getInstance().getHp() - this.power;
        if (new_hp < 0) {
            new_hp = 0;
        }
        GameController.getInstance().setHp(new_hp);
        int new_score = GameController.getInstance().getScore() - this.power;
        if (new_score < 0) {
            new_score = 0;
        }
        GameController.getInstance().setScore(new_score);
    }
    @Override
    public void damage() {
    for (Ghost ghost : GameController.getInstance().getGhosts()) {
        ghost.decreaseHp(-this.power);
    }
    }
}

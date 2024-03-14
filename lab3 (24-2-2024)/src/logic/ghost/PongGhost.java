package logic.ghost;

import logic.game.GameController;
import utils.Config;

public class PongGhost extends HighGhost{
    private  int power;

    public PongGhost() {
        super();
        this.power = Config.PongGhostPower;
    }
    public PongGhost(int power) {
        super();
        this.power = power;
    }
    public int getLevel() {
        return  Config.PongGhostLevel;
    }
    @Override
    public String toString() {
        return "PongGhost [" +
                "HP: " + super.getHp() +
                " , Power: " + this.power +
                ']';
    }
    public void attack() {
        int new_hp = GameController.getInstance().getHp() - this.power;
        if (new_hp < 0 ) {
            new_hp = 0;
        }
        GameController.getInstance().setHp(new_hp);
    }

    @Override
    public void damage() {
        for (Ghost ghost : GameController.getInstance().getGhosts()) {
            if (ghost instanceof  LowGhost) {
                ghost.decreaseHp(-this.power);
            }
        }
    }

}

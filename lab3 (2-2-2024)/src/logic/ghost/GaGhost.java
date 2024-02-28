package logic.ghost;

import logic.game.GameController;
import utils.Config;

public class GaGhost extends LowGhost {
    private int energy;

    public GaGhost() {
        super();
        this.energy = Config.GaGhostEnergy;
    }

    public GaGhost(int energy) {
        super();
        this.energy = energy;
    }

    @Override
    public String toString() {
        return "GaGhost [HP: " +
                super.getHp() +
                " , Energy: " +
                this.energy +
                "]";
    }
    public void attack() {
        int new_hp = GameController.getInstance().getHp() - energy;
        if (new_hp < 0) {
            new_hp = 0;
        }
        GameController.getInstance().setHp(new_hp);
    }
}

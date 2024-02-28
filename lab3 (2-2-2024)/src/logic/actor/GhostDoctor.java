package logic.actor;

import logic.game.GameController;
import logic.ghost.GaGhost;
import logic.ghost.Ghost;
import logic.ghost.HighGhost;
import logic.ghost.LowGhost;
import logic.item.Amulet;
import logic.item.Banana;
import logic.item.Item;
import utils.Config;

public class GhostDoctor extends Actor{
    public GhostDoctor() {

    }
    @Override
    public int getLevel() {
        return Config.GhostDoctorLevel;
    }
    @Override
    public void attack() {
        if (GameController.getInstance().getGhosts().size() > 0 && GameController.getInstance().getGhosts().get(0) instanceof LowGhost)  {
            Ghost ghost = GameController.getInstance().getGhosts().get(0);
            ghost.decreaseHp(ghost.getHp());
        }
    }
    @Override
    public String toString() {
        String className = getClass().getSimpleName();
        return className.substring(0, 1).toUpperCase() + className.substring(1);
    }
}
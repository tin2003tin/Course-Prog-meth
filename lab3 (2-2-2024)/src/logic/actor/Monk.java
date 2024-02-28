package logic.actor;

import logic.game.GameController;
import logic.ghost.Ghost;
import logic.ghost.HighGhost;
import logic.ghost.LowGhost;
import logic.item.Item;
import utils.Config;

public class Monk extends Actor{
    public Monk() {

    }
    @Override
    public int getLevel() {
        return Config.MonkLevel;
    }
    @Override
    public void attack() {
        if (GameController.getInstance().getGhosts().size() > 0 && GameController.getInstance().getGhosts().get(0) instanceof HighGhost)  {
            Ghost ghost = GameController.getInstance().getGhosts().get(0);
            ghost.decreaseHp(this.getLevel());
        }
    }
    @Override
    public String toString() {
        String className = getClass().getSimpleName();
        return className.substring(0, 1).toUpperCase() + className.substring(1);
    }
}
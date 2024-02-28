package logic.actor;

import logic.game.GameController;
import logic.ghost.Ghost;
import logic.ghost.HighGhost;
import logic.ghost.LowGhost;
import logic.item.Amulet;
import logic.item.Item;
import utils.Config;

public class Villager extends Actor{
    public Villager() {
    }
    public int getLevel() {
        return Config.VillagerLevel;
    }
    public void attack() {
        if (GameController.getInstance().getGhosts().size() > 0 && GameController.getInstance().getGhosts().get(0) instanceof LowGhost) {
            Ghost ghost = GameController.getInstance().getGhosts().get(0);
            for (Item item : GameController.getInstance().getItems()) {
                if (item.toString() == "Amulet") {
                    ghost.decreaseHp(this.getLevel() + 1);
                    return;
                }
            }
            ghost.decreaseHp(this.getLevel());
        }
    }
    @Override
    public String toString() {
        String className = getClass().getSimpleName();
        return className.substring(0, 1).toUpperCase() + className.substring(1);
    }
}
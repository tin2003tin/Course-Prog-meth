package logic.ghost;

import utils.Config;
public abstract class LowGhost extends Ghost {
    public LowGhost() {
        super(Config.LowGhostHp);
    }
    @Override
    public int getLevel() {
        return Config.LowGhostLevel;
    }

}

package monkey;

import static logic.game.GameSystem.*;

public class Ape extends BaseMonkey{
    public Ape(int maxHP, int atk, int def) {
        super(maxHP, atk, def);
    }

    @Override
    public void attack(BaseMonkey m) {
        super.attack(m);
    }
    public void attackAOE() {
        for (BaseMonkey monkey: monkeyContainer) {
            if (monkey.getHp() == 0 ) {
                return;
            }
            int pure_damage = this.getAtk() - monkey.getDef();
            if (pure_damage < 0 ) {
                return;
            }
            int damaged_hp = monkey.getHp() - pure_damage;
            if (damaged_hp < 0) {
                damaged_hp = 0;
            }
            monkey.setHp(damaged_hp);
        }
    }

    public int getMaxHp() {
        return super.getMaxHp();
    }
    public int getHp() {
        return super.getHp();
    }
}

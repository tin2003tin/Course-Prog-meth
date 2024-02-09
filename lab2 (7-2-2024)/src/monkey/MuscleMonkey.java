package monkey;

public class MuscleMonkey extends BaseMonkey {

    final int POWER_UP = 4;
    public MuscleMonkey(int maxHp, int atk, int def) {
        super(maxHp,atk,def);
    }

    @Override
    public void attack(BaseMonkey m) {
        super.attack(m);
        super.attack(m);
    }
    public void buff() {
            this.setAtk(this.getAtk() + POWER_UP);
            this.setDef(this.getDef() + POWER_UP);
    }
}

package monkey;

public class UgabugagaMonkey extends BaseMonkey {
    final int DEFBUFF = 1;
    final  int HEAL = 10;
    public UgabugagaMonkey(int maxHP, int atk, int def) {
        super(maxHP, atk, def);
    }

    @Override
    public void attack(BaseMonkey m) {
        super.attack(m);
        int new_atk = m.getAtk() - DEFBUFF;
        if (new_atk < 0) {
            new_atk = 0;
        }
        int new_def = m.getDef() - DEFBUFF;
        if (new_def < 0) {
            new_def = 0;
        }
        m.setAtk(new_atk);
        m.setDef(new_def);
    }
    public void heal(BaseMonkey m) {
        int healed_hp = m.getHp() + this.HEAL;
        if (healed_hp > m.getMaxHp()) {
            healed_hp = m.getMaxHp();
        }
        m.setHp(healed_hp);
    }
}

package monkey;

public class BaseMonkey {
    int maxHp;
    int hp;
    int atk;
    int def;

    public  BaseMonkey() {
        this.setMaxHp(30);
        this.setHp(30);
        this.setAtk(20);
        this.setDef(5);
    }
    public BaseMonkey(int maxHp, int atk, int def) {
        this.setMaxHp(maxHp);
        this.setHp(maxHp);
        this.setAtk(atk);
        this.setDef(def);
    }

    public int getMaxHp() {
        return maxHp;
    }

    public void setMaxHp(int maxHp) {
        if (maxHp < 0) {
            maxHp = 0;
        }
        this.maxHp = maxHp;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        if (hp < 0 ) {
            hp = 0;
        }
        if (hp > maxHp) {
            hp = maxHp;
        }
        this.hp = hp;
    }

    public int getAtk() {
        return atk;
    }

    public void setAtk(int atk) {
        if (atk < 0) {
            atk = 0;
        }
        this.atk = atk;
    }

    public int getDef() {
        return def;
    }

    public void setDef(int def) {
        if (def < 0) {
            def = 0;
        }
        this.def = def;
    }
    public void attack(BaseMonkey m) {
        if (m.getHp() <= 0) {
            return;
        }
        int pure_damge = this.atk - m.getDef();
        if(pure_damge < 0) {
            return;
        }
        int damaged_hp = m.getHp()-pure_damge;
        if (damaged_hp < 0) {
            damaged_hp = 0;
        }
        m.setHp(damaged_hp);
    }
    public String getType() {
        return this.getClass().getSimpleName();
    }

    @Override
    public String toString() {
        return this.getType() + " hp="+ this.hp + " atk=" + this.atk + " def=" + this.def;
    }
}

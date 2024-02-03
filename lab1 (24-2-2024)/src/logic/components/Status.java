package logic.components;

import exception.BadStatusException;

public class Status {
    private int hp;
    private int durability;
    private int attack;
    private int magic;

    public Status(int hp, int durability, int attack, int magic) throws BadStatusException {
        if (magic < 0 || attack < 0 || durability < 0 || hp < 0 ) {
            throw new BadStatusException();
        }
        this.magic = magic;
        this.attack = attack;
        this.durability = durability;
        this.hp = hp;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Status status = (Status) o;
        return this.hp == status.getHp() && this.durability == status.getDurability() && this.attack == status.getAttack() && this.magic == status.getMagic();
    }
    public void addStatus(Status another) throws BadStatusException {
        this.setAttack(this.attack + another.getAttack());
        this.setDurability(this.durability + another.getDurability());
        this.setHp(this.hp + another.getHp());
        this.setMagic(this.magic + another.getMagic());
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) throws BadStatusException {
        if (hp < 0) {
            throw new BadStatusException();
        }
        this.hp = hp;
    }

    public int getDurability() {
        return durability;
    }

    public int getDurable() {return  durability;}

    public void setDurability(int durability) throws BadStatusException  {
        if (durability < 0) {
            throw new BadStatusException();
        }
        this.durability = durability;
    }

    public int getAttack() {
        return attack;
    }

    public void setAttack(int attack) throws BadStatusException  {
        if (attack < 0) {
            throw new BadStatusException();
        }
        this.attack = attack;
    }

    public int getMagic() {
        return magic;
    }

    public void setMagic(int magic) throws BadStatusException  {
        if (magic < 0) {
            throw new BadStatusException();
        }
        this.magic = magic;
    }
}

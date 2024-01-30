package logic.components;

import exception.BadStatusException;

public class Monster{

    public String monsterName;
    private Status status;
    private Food food;
    private Potion potion;
    public Monster(String monsterName, Status status) throws BadStatusException {
        if (status.getHp() < 0 || status.getMagic() < 0 || status.getAttack() < 0 || status.getDurability() < 0) {
            throw  new BadStatusException();
        }
        this.setName(monsterName);
        if (status.getHp() < 1) {
            status.setHp(1);
        }
        this.setStatus(status);
        this.food = null;
        this.potion = null;
    }
    public void attack(Player player) throws BadStatusException {
        int pure_damage = this.status.getAttack() - player.getStatus().getDurability();
        if (pure_damage < 0) {
            return;
        }
        int new_hp = player.getStatus().getHp() - pure_damage;
        if (new_hp < 0) {
            new_hp = 0;
        }
        player.getStatus().setHp(new_hp);
    }
    public void magicAttack(Player player) throws BadStatusException {
        int new_hp = player.getStatus().getHp() - this.status.getMagic();
        if (new_hp < 0) {
            new_hp = 0;
        }
        player.getStatus().setHp(new_hp);
    }
    public String getName() {
        return monsterName;
    }

    public void setName(String monsterName) {
        this.monsterName = monsterName;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Food getFood() {
        return food;
    }

    public void setFood(Food food) {
        this.food = food;
    }

    public Potion getPotion() {
        return potion;
    }

    public void setPotion(Potion potion) {
        this.potion = potion;
    }

}

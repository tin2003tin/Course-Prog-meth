package logic.components;

import exception.BadStatusException;

import java.util.ArrayList;

public class Player {
    public String name;
    private  Status status;
    private int energy;
    private int money;
    private ArrayList<Food> foods;
    private ArrayList<Potion> potions;
    private ArrayList<Ore> ores;

    public Player(String name, Status status) throws BadStatusException {
        if (status.getHp() < 0 || status.getMagic() < 0 || status.getAttack() < 0 || status.getDurability() < 0) {
            throw  new BadStatusException();
        }
        this.setName(name);
        if (status.getHp() < 1) {
            status.setHp(1);
        }
        this.setStatus(status);
        this.setEnergy(10);
        this.setMoney(100);
        this.setOres(new ArrayList<Ore>());
        this.setFoods(new ArrayList<Food>());
        this.setPotions(new ArrayList<Potion>());
    }

    public Player(String name, Status status, int energy, int money) throws BadStatusException {
        if (status.getHp() < 0 || status.getMagic() < 0 || status.getAttack() < 0 || status.getDurability() < 0) {
            throw  new BadStatusException();
        }
        this.setName(name);
        if (status.getHp() < 1) {
            status.setHp(1);
        }
        this.setStatus(status);
        this.setEnergy(energy);
        this.setMoney(money);
        this.setOres(new ArrayList<Ore>());
        this.setFoods(new ArrayList<Food>());
        this.setPotions(new ArrayList<Potion>());
    }
    public boolean buyOre(Ore ore) {
        if (this.money > ore.getCost()) {
            this.money -= ore.getCost();
            this.ores.add(ore);
            return true;
        }
        return false;
    }
    public void drinkPotion(int index) throws BadStatusException {
        if (index >= 0 && index < potions.size()) {
            this.status.addStatus(potions.get(index).getIncreasingStatus());
            potions.remove(index);
        }
    }

    public void eatFood(int index)  throws BadStatusException {
        if (index >= 0 && index < foods.size()) {
            this.energy += foods.get(index).getEnergy();
            foods.remove(index);
        }
    }
    public void sellPotion(int index) throws  BadStatusException {
        if (index >= 0 && index < potions.size()) {
            this.money += potions.get(index).getPrice();
            potions.remove(index);
        }
    }
    public void sellFood(int index) throws BadStatusException {
        if (index >=0 && index < foods.size()) {
            this.money += foods.get(index).getPrice();
            foods.remove(index);
        }
    }
    public void attack(Monster monster) throws BadStatusException {
        int pure_damage = this.status.getAttack() - monster.getStatus().getDurability();
        if (pure_damage < 0) {
            return;
        }
        int new_hp = monster.getStatus().getHp() - pure_damage;
        if (new_hp < 0) {
            new_hp = 0;
        }
        monster.getStatus().setHp(new_hp);
    }
    public void magicAttack(Monster monster) throws BadStatusException {
        int new_hp = monster.getStatus().getHp() - this.status.getMagic();
        if (new_hp < 0) {
            new_hp = 0;
        }
        monster.getStatus().setHp(new_hp);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public int getEnergy() {
        return energy;
    }

    public void setEnergy(int energy) {
        if (energy < 0){
            this.energy = 0;
            return;
        }
        this.energy = energy;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        if (money < 0) {
            this.money = 0;
            return;
        }
        this.money = money;
    }

    public ArrayList<Food> getFoods() {
        return foods;
    }

    public void setFoods(ArrayList<Food> foods) {
        this.foods = foods;
    }

    public ArrayList<Potion> getPotions() {
        return potions;
    }

    public void setPotions(ArrayList<Potion> potions) {
        this.potions = potions;
    }

    public ArrayList<Ore> getOres() {
        return ores;
    }

    public void setOres(ArrayList<Ore> ores) {
        this.ores = ores;
    }

}

package logic.components;

import java.util.Objects;

public class Food {
    public String name;
    public int price;
    public int energy;

    public Food(String name, int price, int energy) {
        this.setName(name);
        this.setPrice(price);
        this.setEnergy(energy);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Food food = (Food) o;
        return price == food.getPrice() && energy == food.getEnergy() && Objects.equals(name, food.getName());
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        if (price < 1) {
            this.price = 1;
            return;
        }
        this.price = price;
    }

    public int getEnergy() {
        return energy;
    }

    public void setEnergy(int energy) {
        if (energy < 1) {
            this.energy = 1;
            return;
        }
        this.energy = energy;
    }
}

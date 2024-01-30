package logic.components;

import java.util.Objects;

public class Ore {
    public String name;
    public int cost;

    public Ore(String name, int cost) {
        this.setName(name);
        this.setCost(cost);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ore ore = (Ore) o;
        return cost == ore.getCost() && Objects.equals(name, ore.getName());
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        if (cost < 1) {
            this.cost = 1;
            return;
        }
        this.cost = cost;
    }
}
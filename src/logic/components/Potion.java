package logic.components;

import java.util.Objects;

public class Potion {
    public String name;
    public int price;
    Status increasingStatus;

    public Potion(String name, int price, Status increasingStatus) {
        setName(name);
        setPrice(price);
        setIncreasingStatus(increasingStatus);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Potion potion = (Potion) o;
        return price == potion.getPrice() && Objects.equals(name, potion.getName()) && Objects.equals(increasingStatus, potion.getIncreasingStatus());
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

    public Status getIncreasingStatus() {
        return increasingStatus;
    }

    public void setIncreasingStatus(Status increasingStatus) {
        this.increasingStatus = increasingStatus;
    }
}

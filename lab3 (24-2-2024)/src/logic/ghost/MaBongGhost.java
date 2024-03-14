package logic.ghost;

import logic.game.GameController;
import utils.Config;

public class MaBongGhost extends LowGhost{

    private int power;
    private int speed;

    public MaBongGhost() {
        super();
        this.power = Config.MaBongGhostPower;
        this.speed = Config.MaBongGhostSpeed;
    }
    public MaBongGhost(int power) {
        super();
        this.power = power;
        this.speed = Config.MaBongGhostSpeed;
    }
    public MaBongGhost(int power, int speed) {
        super();
        this.power = power;
        this.speed = speed;
    }

    @Override
    public String toString() {
        return "MaBongGhost [" +
                "HP: " + super.getHp() +
                " , Power: " + this.power +
                " , Speed: " + this.speed +
                ']';
    }
    public void attack() {
        int new_hp = GameController.getInstance().getHp() - power*speed;
        if (new_hp < 0 ) {
            new_hp = 0;
        }
        GameController.getInstance().setHp(new_hp);
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }
}

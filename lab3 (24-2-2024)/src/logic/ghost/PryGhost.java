package logic.ghost;

import logic.game.GameController;
import utils.Config;

public class PryGhost extends LowGhost{
	private int power;
	private int ppt;
	public PryGhost() {
		super();
		this.power = Config.PryGhostPower;
		this.ppt = 0;
	}
	public PryGhost(int power) {
		super();
		this.power = power;
		this.ppt = 0;
	}

	public PryGhost(int power, int ppt) {
		super();
		this.power = power;
		this.ppt = ppt;
	}
	@Override
	public String toString() {
		return "PryGhost [" +
				"HP: " + super.getHp() +
				" , Power: " + this.power +
				" , PPT: " + this.ppt +
				']';
	}
	public void attack() {
		int damage = this.power - this.ppt;
		if (damage < 0) {
			damage = 0;
		}
		int new_hp = GameController.getInstance().getHp() - damage;
		if (new_hp < 0 ) {
			new_hp = 0;
		}
		GameController.getInstance().setHp(new_hp);
	}

	public int getPpt() {
		return ppt;
	}

	public void setPpt(int ppt) {
		this.ppt = ppt;
	}
}

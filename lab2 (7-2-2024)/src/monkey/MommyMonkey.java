package monkey;

import static logic.game.GameSystem.*;

public class MommyMonkey extends BaseMonkey {
    public MommyMonkey(int hp, int atk, int def) {
        super(hp,atk,def);
    }

    @Override
    public void attack(BaseMonkey m){
        return;
    }
    public void birth() {
        BaseMonkey m = new BaseMonkey();
        System.out.println(m);
        monkeyContainer.add(m);
    }
}

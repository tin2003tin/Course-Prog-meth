package logic.ghost;

 public abstract class Ghost{
    private int hp;
     public Ghost(int hp) {
         this.hp = hp;
     }
     public boolean isDestroyed() {
         return hp <= 0;
     }
     public  void decreaseHp(int amount) {
         int new_hp = this.hp-amount;
         if (new_hp < 0) {
             new_hp = 0;
         }
         this.hp = new_hp;
     }
     public int getHp() {
         return hp;
     }
     public abstract int getLevel();
     public abstract void attack();

 }

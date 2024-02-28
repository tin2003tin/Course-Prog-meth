package logic.game;

import java.util.ArrayList;
import java.util.List;

import logic.actor.Actor;
import logic.actor.Villager;
import logic.ghost.Ghost;
import logic.item.Item;
import utils.GameUtils;

public class GameController {
    
    private int hp;
    private int score;
    private static GameController instance;
    private ArrayList <Actor> actors;
    private ArrayList <Ghost> ghosts;
    private ArrayList <Item> items;
    
    
    public GameController() {
        
        this.actors = new ArrayList <Actor> ();
        this.ghosts = new ArrayList <Ghost> ();
        this.items = new ArrayList <Item> ();

        initGame();
        
    }
    private void initGame() {
        this.setHp(10);
        this.setScore(0);
        actors.add(new Villager());
         for (int i = 0 ; i < 10; i++) {
             ghosts.add(GameUtils.getRandomGhost(false));
         }
    }
    
    public static GameController getInstance() {
        if(instance == null)
            instance = new GameController();
        return instance;
    }

    public void play(Actor selectedActor) {
       for (Item item : this.getItems()) {
           item.effect();
       }
       Ghost currentGhost = this.getGhosts().get(0);
       currentGhost.attack();
       selectedActor.attack();
        List<Ghost> ghostsToRemove = new ArrayList<>();
        int count = 0;
        for (Ghost ghost : this.getGhosts()) {
            if (ghost.isDestroyed()) {
                this.setScore(this.score + ghost.getLevel());
                ghostsToRemove.add(ghost);
                count++;
            }
        }
        for (int i =0 ; i < count; i++) {
            this.addNewGhost(GameUtils.getRandomGhost(true));
        }
        this.getGhosts().removeAll(ghostsToRemove);
    }
    public boolean isGameOver() {
        return actors.isEmpty() || this.getHp() <= 0 ;
    }

    public void updateGameController() {
        GameIO.showGameState();
        GameIO.showCurrentGhost(ghosts);
        Actor selectedActor = GameIO.selectActor(this.actors);
        GameIO.showItemList(this.items);
        play(selectedActor);
    }

    public int getHp() {
        return hp;
    }
    public void setHp(int hp) {
        this.hp = hp;
    }
    public int getScore() {
        return score;
    }
    public ArrayList<Ghost> getGhosts() {
        return ghosts;
    }
    public ArrayList<Item> getItems() {
        return items;
    }
    public void setScore(int score) {
        this.score = score;
    }
    public void addNewActor(Actor actor) {
        this.actors.add(actor);
    }
    public void addNewItem(Item item) {
        this.items.add(item);
    }
    public void addNewGhost(Ghost ghost) {
        this.ghosts.add(ghost);
    }
    
    public ArrayList<Actor> getActor() {return actors;}
    
    //===========================
    
}
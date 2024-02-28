package grader.student;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import logic.actor.Actor;
import logic.actor.GhostDoctor;
import logic.actor.Villager;
import logic.game.GameController;
import logic.game.GameIO;
import logic.ghost.GaGhost;
import logic.ghost.Ghost;
import logic.ghost.PooYaGhost;
import logic.ghost.PryGhost;
import logic.item.Item;
import logic.item.Leklai;

import static org.junit.jupiter.api.Assertions.*;

class GameControllerTest {
    @Test
    void testPlayNotDestroyedGhost() {
        Actor actor = new Villager();
        
        Ghost g1 = new PooYaGhost(8);
        Ghost g2 = new GaGhost();
        Ghost g3 = new PryGhost();
        
        GameController.getInstance().getGhosts().clear();
        GameController.getInstance().getItems().clear();
        GameController.getInstance().addNewGhost(g1);
        GameController.getInstance().addNewGhost(g2);

        GameController.getInstance().addNewGhost(g3);
        
        GameController.getInstance().play(actor);
        
        assertEquals(g1, GameController.getInstance().getGhosts().get(0));
        assertEquals(3, GameController.getInstance().getGhosts().size());
    }
    
    @Test
    void testPlayDestroyedGhost() {
    	Actor actor = new GhostDoctor();

        Ghost g1 = new GaGhost();
        Ghost g2 = new PooYaGhost(8);
        Ghost g3 = new GaGhost();
        GameController.getInstance().getGhosts().clear();
        GameController.getInstance().getItems().clear();
        GameController.getInstance().addNewGhost(g1);
        GameController.getInstance().addNewGhost(g2);
        GameController.getInstance().addNewGhost(g3);
        GameController.getInstance().play(actor);
        assertEquals(g1,GameController.getInstance().getGhosts().get(0));
        assertEquals(3,GameController.getInstance().getGhosts().size());
    }
    
    @Test
    void testPlayWithItem() {
    	Actor actor = new Villager();
        Item item = new Leklai();

        Ghost g1,g2,g3;
        g1 = new GaGhost();
        g2 = new PryGhost();
        g3 = new PooYaGhost(5);
        GameController.getInstance().getGhosts().clear();
        GameController.getInstance().getItems().clear();
        GameController.getInstance().addNewItem(item);
        GameController.getInstance().addNewGhost(g1);
        GameController.getInstance().addNewGhost(g2);
        GameController.getInstance().addNewGhost(g3);
        GameController.getInstance().play(actor);
        assertEquals(0,g1.getHp());
        assertEquals(0,g2.getHp());
        assertEquals(10,g3.getHp());
}
    @Test
    void testIsGameOver() {
        //The game ends when the actors list is empty or the player’s hp is lower than or equal to 0 (you lose).
        // 1. no actor is actors
        GameController.getInstance().getActor().clear();
        assertTrue(GameController.getInstance().isGameOver());
        // 2. play's hp is lower than 0
        GameController.getInstance().addNewActor(new Villager());
        GameController.getInstance().setHp(0);
        assertTrue(GameController.getInstance().isGameOver());
        // 3. player is killed by ghost
        GameController.getInstance().setHp(1);
        GameController.getInstance().play(GameController.getInstance().getActor().get(0));
        assertTrue(GameController.getInstance().isGameOver());
        // 4. player is killed by ghosts. I mean a lot of ghosts
        GameController.getInstance().setHp(10);
        GameController.getInstance().play(GameController.getInstance().getActor().get(0));
        GameController.getInstance().play(GameController.getInstance().getActor().get(0));
        GameController.getInstance().play(GameController.getInstance().getActor().get(0));
        GameController.getInstance().play(GameController.getInstance().getActor().get(0));
        GameController.getInstance().play(GameController.getInstance().getActor().get(0));
        GameController.getInstance().play(GameController.getInstance().getActor().get(0));
        assertTrue(GameController.getInstance().isGameOver());
    }

}
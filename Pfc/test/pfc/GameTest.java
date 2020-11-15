package pfc;
import pfc.strategy.*;

import static org.junit.Assert.*;

import org.junit.Test;

public class GameTest {

  @Test
  public void testPlayWithAWinner(){
    Player p1 = new Player("test1",new RockStrategy());
    Player p2 = new Player("test2",new PaperStrategy());
    Game g = new Game(p1,p2,3);
    assertSame(g.play(g.getNbRounds()),p2);
    assertTrue(g.getPlayerOne().getScore()<g.getPlayerTwo().getScore());
  }

  @Test
  public void testPlayDraw(){
    Player p1 = new Player("test1",new RockStrategy());
    Player p2 = new Player("test2",new RockStrategy());
    Game g = new Game(p1,p2,3);
    Player w = g.play(3);
    assertNotSame(w,p1);
    assertNotSame(w,p2);
    assertEquals(w.getName(),"any of them");
  }

   // ---Pour permettre l'exécution des test----------------------
    public static junit.framework.Test suite() {
        return new junit.framework.JUnit4TestAdapter(pfc.GameTest.class);
    }

}

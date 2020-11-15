package pfc;
import pfc.strategy.*;

import static org.junit.Assert.*;

import org.junit.Test;

public class PlayerTest {

  @Test
  public void testShapeWhenAStrategyChosen(){
    Player p = new Player("test",new RockStrategy());
    assertSame(p.play(),Shape.ROCK);
	}

  @Test
  public void testWithoutAddPoints(){
    Player p = new Player("test",new RockStrategy());
    assertEquals(p.getScore(),0);
	}

  @Test
  public void testAddPoints(){
    Player p = new Player("test",new RockStrategy());
    p.addPoints(2);
    p.addPoints(1);
    assertEquals(p.getScore(),3);
	}

   // ---Pour permettre l'exécution des test----------------------
    public static junit.framework.Test suite() {
        return new junit.framework.JUnit4TestAdapter(pfc.PlayerTest.class);
    }

}

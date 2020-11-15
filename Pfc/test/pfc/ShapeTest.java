package pfc;

import static org.junit.Assert.*;

import org.junit.Test;

public class ShapeTest {

  @Test
  public void rockBeatsScissors(){
    Shape s1 = Shape.ROCK;
    Shape s2 = Shape.SCISSORS;
    assertTrue(s1.beats(s2));
    assertFalse(s2.beats(s1));
	}

  @Test
  public void scissorsBeatsPaper(){
    Shape s1 = Shape.SCISSORS;
    Shape s2 = Shape.PAPER;
    assertTrue(s1.beats(s2));
    assertFalse(s2.beats(s1));
	}

  @Test
  public void paperBeatsRock(){
    Shape s1 = Shape.PAPER;
    Shape s2 = Shape.ROCK;
    assertTrue(s1.beats(s2));
    assertFalse(s2.beats(s1));
	}

  @Test
  public void rockBeatsRockIsFalse(){
    Shape s1 = Shape.ROCK;
    Shape s2 = Shape.ROCK;
    assertFalse(s1.beats(s2));
    assertFalse(s2.beats(s1));
	}

  @Test
  public void paperBeatsPaperIsFalse(){
    Shape s1 = Shape.PAPER;
    Shape s2 = Shape.PAPER;
    assertFalse(s1.beats(s2));
    assertFalse(s2.beats(s1));
	}

  @Test
  public void scissorsBeatsScissorsIsFalse(){
    Shape s1 = Shape.SCISSORS;
    Shape s2 = Shape.SCISSORS;
    assertFalse(s1.beats(s2));
    assertFalse(s2.beats(s1));
	}

   // ---Pour permettre l'exécution des test----------------------
    public static junit.framework.Test suite() {
        return new junit.framework.JUnit4TestAdapter(pfc.ShapeTest.class);
    }

}

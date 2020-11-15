import org.junit.*;
import static org.junit.Assert.*;
import example.Robot;
import example.util.*;

public class RobotTest {

  @Test
  public void takeWhenRobotIsNotCarryingABox(){
    Box b = new Box(1);
    Robot r = new Robot();
    r.take(b);
    assertSame(r.getCarriedBox(),b);
  }

  @Test
  public void takeWhenRobotIsAlreadyCarryingABox(){
    Box b1 = new Box(1);
    Box b2 = new Box(2);
    Robot r = new Robot();
    r.take(b1);
    r.take(b2);
    assertSame(r.getCarriedBox(),b1);
  }

  @Test
  public void carryBoxWhenTheRobotIsNotCarryingABox(){
    Robot r = new Robot();
    assertFalse(r.carryBox());
  }

  @Test
  public void carryBoxWhenTheRobotIsAlreadyCarryingABox(){
    Box b = new Box(1);
    Robot r = new Robot();
    r.take(b);
    assertTrue(r.carryBox());
  }

  @Test
  public void robotDoesNotCarryBoxAfterPutOn(){
    Box b = new Box(1);
    Robot r = new Robot();
    ConveyerBelt c = new ConveyerBelt(10);
    r.take(b);
    r.putOn(c);
    assertNull(r.getCarriedBox());
  }

  @Test
  public void robotCarriesTheSameBoxAfterImpossiblePutOn(){
    Box b = new Box(20);
    Robot r = new Robot();
    ConveyerBelt c = new ConveyerBelt(10);
    r.take(b);
    r.putOn(c);
    assertSame(r.getCarriedBox(),b);
  }

  // ---Pour permettre l'exécution des test----------------------
  public static junit.framework.Test suite() {
    return new junit.framework.JUnit4TestAdapter(RobotTest.class);
  }
}

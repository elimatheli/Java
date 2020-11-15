package battleship;

import static org.junit.Assert.*;

import org.junit.Test;

public class CellTest {

  @Test
  public void whenCellCreatedCellIsEmpty(){
    Cell c = new Cell();
    assertTrue(c.isEmpty());
  }

  @Test
  public void firstTimeSetShip(){
    Cell c = new Cell();
    Ship s = new Ship(2);
    c.setShip(s);
    assertFalse(c.isEmpty());
  }

  @Test
  public void secondTimeSetShip(){
    Cell c = new Cell();
    Ship s = new Ship(2);
    Ship s2 = new Ship(3);
    c.setShip(s);
    c.setShip(s2);
    assertSame(c.getShip(),s);
  }

	@Test
	public void firstShotOnBusyCellHitTheShip() {
		Cell c = new Cell();
		Ship s = new Ship(4);
		c.setShip(s);
		assertEquals(c.shoot() , Answer.HIT) ;
	}

	@Test
	public void secondShotOnBusyCellDoesNotHitTheShip() {
		Cell c = new Cell();
		Ship s = new Ship(4);
		c.setShip(s);
		c.shoot();
		assertEquals(c.shoot() , Answer.MISSED) ;
	}

   // ---Pour permettre l'exécution des test----------------------
    public static junit.framework.Test suite() {
        return new junit.framework.JUnit4TestAdapter(battleship.CellTest.class);
    }

}

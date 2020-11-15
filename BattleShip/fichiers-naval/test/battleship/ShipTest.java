package battleship;

import static org.junit.Assert.* ;
import org.junit.Test;

public class ShipTest {


	@Test
	public void testLifePointsDecreaseWhenHitted() {
		Ship s = new Ship(3);
		s.hit();
		assertEquals(2, s.getLifePoints());
	}

	@Test
	public void testHasBeenSunk() {
		Ship s = new Ship(3);
		s.hit();
		s.hit();
		s.hit();
		assertTrue(s.hasBeenSunk());
	}

	@Test
	public void legnthNoChangeWhenHit(){
		Ship s = new Ship(3);
		s.hit();
		s.hit();
		s.hit();
		assertEquals(3,s.getLength());
	}




   // ---Pour permettre l'exécution des test----------------------
    public static junit.framework.Test suite() {
        return new junit.framework.JUnit4TestAdapter(battleship.ShipTest.class);
    }

}

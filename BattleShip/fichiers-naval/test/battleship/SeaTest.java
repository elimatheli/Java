package battleship;

import static org.junit.Assert.*;

import battleship.util.Position ;

import org.junit.Test;

public class SeaTest {


	@Test(expected=ArrayIndexOutOfBoundsException.class)
	public void shootWithBadPositionThrowsException() {
    Sea board = new Sea(6,6);
    Position p = new Position(7,3);
    board.shoot(p);
	}

  @Test(expected=ArrayIndexOutOfBoundsException.class)
	public void shootWithNegativePositionThrowsException() {
    Sea board = new Sea(6,6);
    Position p = new Position(5,-3);
    board.shoot(p);
	}

  @Test
  public void totalLifePointsIsCorrectAfterAddingShips(){
    Sea board = new Sea(6,6);
    Ship s1 = new Ship(5);
    Ship s2 = new Ship(4);
    Ship s3 = new Ship(3);
    Position p1 = new Position(0,0);
    Position p2 = new Position(1,0);
    Position p3 = new Position(5,0);
    board.addShipVertically(s1,p1);
    board.addShipHorizontally(s2,p2);
    board.addShipVertically(s3,p3);
    assertEquals(12,board.getTotalLifePoints());
  }

  @Test
  public void totalLifePointsIsCorrectAfterAddingShipsAndShooting(){
    Sea board = new Sea(6,6);
    Ship s1 = new Ship(5);
    Ship s2 = new Ship(4);
    Ship s3 = new Ship(3);
    Position p1 = new Position(0,0);
    Position p2 = new Position(1,0);
    Position p3 = new Position(5,0);
    board.addShipVertically(s1,p1);
    board.addShipHorizontally(s2,p2);
    board.addShipVertically(s3,p3);
    board.shoot(p1);
    board.shoot(p2);
    assertEquals(10,board.getTotalLifePoints());
  }

  @Test(expected=IllegalStateException.class)
  public void addShipVerticallyThrowsExceptionWhenShipOutsideOfSea(){
    Sea board = new Sea(6,6);
    Ship s1 = new Ship(5);
    Position p1 = new Position(0,2);
    board.addShipVertically(s1,p1);
  }

  @Test(expected=IllegalStateException.class)
  public void addShipVerticallyThrowsExceptionWhenCellIsBusy(){
    Sea board = new Sea(6,6);
    Ship s1 = new Ship(5);
    Ship s2 = new Ship(4);
    Position p1 = new Position(0,2);
    Position p2 = new Position(3,0);
    board.addShipHorizontally(s1,p1);
    board.addShipVertically(s2,p2);
  }

  @Test(expected=IllegalStateException.class)
  public void addShipHorizontallyThrowsExceptionWhenShipOutsideOfSea(){
    Sea board = new Sea(6,6);
    Ship s1 = new Ship(5);
    Position p1 = new Position(3,0);
    board.addShipHorizontally(s1,p1);
  }

  @Test(expected=IllegalStateException.class)
  public void addShipHorizontallyThrowsExceptionWhenCellIsBusy(){
    Sea board = new Sea(6,6);
    Ship s1 = new Ship(5);
    Ship s2 = new Ship(4);
    Position p1 = new Position(0,2);
    Position p2 = new Position(3,0);
    board.addShipVertically(s2,p2);
    board.addShipHorizontally(s1,p1);
  }


   // ---Pour permettre l'exécution des test----------------------
    public static junit.framework.Test suite() {
        return new junit.framework.JUnit4TestAdapter(battleship.SeaTest.class);
    }

}

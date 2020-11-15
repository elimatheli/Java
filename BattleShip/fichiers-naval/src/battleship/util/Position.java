package battleship.util;

/**
* a class that describes the position of a Cell in the gaming board Sea
* @author VISEUX et HWANG
*/

public class Position{
  //position x and y of the Cell
  private final int x;
  private final int y;

  /**
  * creates a Position with an abciss and an ordonate
  * @param x the absciss of the Cell
  * @param y the ordinate of the Cell
  */
  public Position(int x,int y) {
    this.x = x;
    this.y = y;
  }

  /**
	* returns the absciss of the Cell
	* @return the absciss of the Cell
	*/
	public int getX() {
		return this.x;
  }

  /**
	* returns the ordonate of the Cell
	* @return the ordonate of the Cell
	*/
	public int getY() {
		return this.y;
  }

  @Override
	public boolean equals(Object o) {
    if (! (o instanceof Position)) return false ;
		Position other = (Position) o;
		return this.x == other.x && this.y == other.y;
  }

  @Override
	public String toString() {
		return "("+this.x+","+this.x+")";
  }
}

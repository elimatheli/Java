package battleship;

/**
* a class that describes a Ship in the game battleship
* @author VISEUX et HWANG
*/
public class Ship {

	// invariable int describing the length of the Ship
	private final int length;
	// integer describing the life points of the Ship
	private int life;

	/**
	* creates a Ship with a length and some life points
	* @param length the length of the ship
	*/
	public Ship(int length) {
		this.length = length;
		this.life = length;
  }

	/**
	* returns true if the Ship has been sunk, false otherwise
	* @return true if the Ship hasn't any life points, false otherwise
	*/
  public boolean hasBeenSunk() {
		return this.getLifePoints()==0;
  }

	/**
	* decreases by 1 the life points of this Ship
	*/
	public void hit() {
		if (this.getLifePoints()>0){
			this.life--;
		}
	}

	/**
	* returns the life points of this Ship
	* @return the life points of this Ship
	*/
	public int getLifePoints() {
		return this.life;
  }

	/**
	* returns the length of this Ship
	* @return the length of this Ship
	*/
  public int getLength() {
		return this.length;
  }
}

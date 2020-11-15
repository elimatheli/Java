package battleship;
import battleship.util.Position;

/**
* a class that represents the gaming board for the game battleship
* @author VISEUX et HWANG
*/
public class Sea {

	// tab of tabs composed of Cells representing the Sea
	private Cell[][] cells;
	// integer describing the total amount of life points of all the Ships on the Sea
	private int totalLifePoints;

	/**
	* creates a Sea with 2 dimentions
	*	@param width the width of the Sea
	* @param height the heightof the Sea
	*/
	public Sea(int width, int height) {
		this.cells = new Cell[width][height];
		for (int i = 0; i < width; i++) {
			for (int j = 0; j < height; j++) {
				this.cells[i][j] = new Cell();
			}
		}
		this.totalLifePoints = 0;
	}

	/** returns the totalLifePoints
	 * @return the totalLifePoints
	 */
	public int getTotalLifePoints(){
		return this.totalLifePoints;
	}

	/** returns the answer of a shot on a given position
	 * @param p the position to shoot
	 * @return the result of the shoot, depending on whether there is a ship or
	 * not in the cell corresponding to p
	 * @throws ArrayIndexOutOfBoundsException
	 * if Position is out of the Sea
	 */
	public Answer shoot(Position p) throws ArrayIndexOutOfBoundsException {
		Cell c = getCell(p);
		Answer ans = c.shoot();
		if (ans!=Answer.MISSED) this.totalLifePoints -=1;
		return ans;
 	}

	/** returns the Cell a given position
	 * @param p the position of the Cell
	 * @return the Cell corresponding to the position
	 * @throws ArrayIndexOutOfBoundsException
	 * if Position is out of the Sea
	 */
	public Cell getCell(Position p) throws ArrayIndexOutOfBoundsException {
		int x = p.getX();
		int y = p.getY();
		return this.cells[x][y];
	}

	/** tests if a Position is valid are not
	 * @param p the Position to be checked
	 * @return true iff the Position is in the Sea and doesn't contain a Ship
	 */
	private boolean isValid(Position p) {
		try {
			this.getCell(p) ;
			return true ;
		} catch (ArrayIndexOutOfBoundsException e) {
			// e.printStackTrace() ;
			// utile en phase de débugage d'un projet : cette instruction affiche sur la sortie
			// standard la trace de propagation de l'exception e (sans propager
			// l'exception e elle-même bien sûr.)
			return false ;
		}
	}

	/**
	 * adds a ship vertically down from a given position.
	 * The number of cells is determined by the ship length.
	 * @param shipToPlace the ship to be placed
	 * @param position the position of the first cell occupied by the ship
	 * @throws IllegalStateException
	 *    if the ship b can not be placed on the sea
	 * (because it would be outside of the board or on some cell that is not empty)
	 */
	public void addShipVertically(Ship shipToPlace, Position position) throws IllegalStateException {
		int x = position.getX();
		int y = position.getY();
		int l=shipToPlace.getLength();
		try {
			for (int i=0;i<l;i++){
				if (!this.cells[x][y+i].isEmpty()) throw new ArrayIndexOutOfBoundsException();
			}
		}catch (ArrayIndexOutOfBoundsException e){
			throw new IllegalStateException();
		}
		for (int i=0;i<l;i++){
			this.cells[x][y+i].setShip(shipToPlace);
		}
		this.totalLifePoints += shipToPlace.getLifePoints();
	}
	/**
	 * adds a ship horizontally rigth from a given position.
	 * The number of cells is determined by the ship length.
	 * @param shipToPlace the ship to be placed
	 * @param position the position of the first cell occupied by the ship
	 * @throws IllegalStateException
	 *    if the ship b can not be placed on the sea
	 * (because it would be outside of the board or on some cell that is not empty)
	 */
	public void addShipHorizontally(Ship shipToPlace, Position position) throws IllegalStateException {
		int x = position.getX();
		int y = position.getY();
		int l=shipToPlace.getLength();
		try {
			for (int i=0;i<l;i++){
				if (!this.cells[x+i][y].isEmpty()) throw new ArrayIndexOutOfBoundsException();
			}
		}catch (ArrayIndexOutOfBoundsException e){
			throw new IllegalStateException();
		}
		for (int i=0;i<l;i++){
			this.cells[x+i][y].setShip(shipToPlace);
		}
		this.totalLifePoints += shipToPlace.getLifePoints();
	}


	/** displays the board line by line and cell by cell,
	* the display changes for the defender or the opponent, defined
	*	by the <code>defender</code> argument
	* @param defender <code>true</code> if display is for defender,
	*	<code>false</code> if for opponent
	*/
	public void display(boolean defender) {
		String str="";
		for (int line = 0; line < this.cells[0].length; line++) {
			for (int largeur = 0; largeur < this.cells.length; largeur++) {
				str += " "+ this.cells[largeur][line].getCharacter(defender);
			}
			System.out.println(str);
			str="";
		}
	}

}

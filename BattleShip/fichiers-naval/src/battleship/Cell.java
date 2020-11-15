package battleship;

/**
* a class that represents the cells of the gaming board Sea
* @author VISEUX et HWANG
*/
public class Cell {

  // the Ship of the Cell
  private Ship ship;
  // indicates wether this Cell has been shot or not
  private boolean shot;

  /**
  * creates an empty Cell that hasn't been shot
  */
  public Cell() {
    this.ship = null;
    this.shot = false;
  }

  /**
  * returns the Ship of this Cell (null if this Cell is empty)
  * @return the Ship of this Cell (null if this Cell is empty)
  */
  public Ship getShip() {
    return this.ship;
  }

  /**
  * sets a Ship on this Cell iff this Cell is empty
  * @param ship the Ship we want to set on this Cell
  */
  public void setShip(Ship ship){
    if (this.getShip()==null){
      this.ship = ship;
    }
  }

  /**
  * returns true iff this Cell isEmpty
  * @return true iff this Cell isEmpty
  */
  public boolean isEmpty() {
    return this.ship==null;
  }

  /**
  * returns true iff this Cell has been shot
  * @return true iff this Cell has been shot
  */
  public boolean hasBeenShot() {
    return this.shot;
  }

  /** shoots this Cell
  * returns a feedback after shooting this Cell
  * @return the feedback after shooting this Cell
  *   - Answer.MISSED if this Cell was empty or already shot
  *   - Answer.HIT if the Ship on this Cell was hit but not sunk
  *   - Answer.SUNK if the Ship on this Cell sunk
  */
  public Answer shoot() {
    if(this.hasBeenShot()){
      return Answer.MISSED;
    }else{
      this.shot=true;
      if(this.isEmpty()){
        return Answer.MISSED;
      }else{
        this.ship.hit();
        if(this.ship.hasBeenSunk()){
          return Answer.SUNK;
        }else{
          return Answer.HIT;
        }
      }
    }
  }

  /** returns the character representing this Cell
  * the display changes for the defender or the opponent, defined
  * by the <code>defender</code> argument
  * @param defender <code>true</code> for defender,
  * <code>false</code> for opponent
  * @return the character representing this Cell
  */
  public String getCharacter(boolean defender) {
    if (defender){
      if (this.isEmpty()){
        return "~";
      }else{
        if (hasBeenShot()) return "*";
        else return "B";
      }
    }else{
      if (this.hasBeenShot()){
        if (this.isEmpty()) return "~";
        else return "*";
      }else{
        return ".";
      }
    }
  }

}

package battleship;
import io.Input;
import battleship.util.Position;


/**
* a class implementing the game battleship
* @author VISEUX et HWANG
*/
public class Game {

  // the gaming board Sea
  private Sea board;

  /**
  * creates a Game with a board Sea
  * @param board the Sea we play on
  */
  public Game(Sea board) {
    this.board = board;
  }

  /** returns the state of the Game
   * @return the state of the Game
   */
  public int getGameState(){
    return this.board.getTotalLifePoints();
  }

  /**
   * shoots the Cell corresponding to the Position given by the user
   */
  public void playerAttack(){
    try{
      System.out.print("Give the abciss of the Cell you want to shoot : ");
      int x = Input.readInt();
      System.out.print("Give the ordinate of the Cell you want to shoot : ");
      int y = Input.readInt();
      Answer ans = this.board.shoot(new Position(x,y));
      System.out.println("Shoot : "+ans+" & Life points : "+this.getGameState());
    }catch(java.io.IOException e){
      System.out.println("The position must be integers");
    }catch(ArrayIndexOutOfBoundsException ee){
      System.out.println("The position is out if bounds of the Sea");
    }
  }

  /**
   * plays the Game as the player who attacks till the end (TotalLifePoints == 0)
   */
  public void playGame(){
    while (this.getGameState()!=0){
      playerAttack();
      this.board.display(false);
    }
    System.out.println("Congratulation! You win!");
  }
}

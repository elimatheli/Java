package battleship;
import battleship.util.Position;

public class GameMain{
  public static void main(String[] args){
    Sea board = new Sea(6,6);
    Ship s1 = new Ship(4);
    Ship s2 = new Ship(3);
    Ship s3 = new Ship(2);
    Position p1 = new Position(0,0);
    Position p2 = new Position(2,3);
    Position p3 = new Position(5,4);
    board.addShipVertically(s1,p1);
    board.addShipHorizontally(s2,p2);
    board.addShipVertically(s3,p3);
    Game game = new Game(board);
    game.playGame();
  }
}

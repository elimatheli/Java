package pfc;
import pfc.strategy.*;
import java.util.*;
import java.lang.Integer;
import io.*;

/**
 * main class for GameMain
 * @author Viseux Eliot - Hwang Ju-Chan
 * @version 1.0
 */
public class GameMain{

  public static void main(String[] args) {
    int nbOfRounds = Integer.parseInt(args[0]);
    System.out.println("What is your Name ? ");
    String playerName = Input.readString();

    System.out.println("Choose PAPER, ROCK or SCISSORS");
    String shapeChosen;
    Shape[] listOfShapes = new Shape[nbOfRounds];
    int index = 0;
    while(index<nbOfRounds){
      System.out.println("Choose shape "+(index+1));
      shapeChosen = Input.readString();
      switch(shapeChosen){
        case "PAPER" : listOfShapes[index]=Shape.PAPER; index++; break;
        case "ROCK" : listOfShapes[index]=Shape.ROCK; index++; break;
        case "SCISSORS" : listOfShapes[index]=Shape.SCISSORS; index++; break;
        default : System.out.println("Please enter a valid shape (exactly as shown)");
      }
    }
    Strategy playerStrat = new ConstantStrategy(listOfShapes);

    Player playerOne = new Player(playerName,playerStrat);
    Player playerTwo = new Player("Computer",new RandomStrategy());
    Game currentGame = new Game(playerOne,playerTwo,nbOfRounds);
    currentGame.play(currentGame.getNbRounds());
  }
}

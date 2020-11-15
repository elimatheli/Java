package pfc;
import pfc.strategy.*;

/**
 *
 * @author Viseux Eliot - Hwang Ju-Chan
 * @version 1.0
 */
public class Player{

	private String name;
	private int score;
	private Strategy strategy;

	/**
   * creates a Player of the game "rock - paper - scissors".
   * @param name The Name of the player.
   * @param strategy the strategy pattern used by the player.
   */
	public Player(String name, Strategy strategy){

		this.name = name;
		this.score = 0;
		this.strategy = strategy;
	}

	/**
	 * Return the name of the player.
	 * @return The name score of the player.
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * Return the score of the player.
	 * @return The current score of the player.
   */
	public int getScore(){
		return this.score;
	}

	/**
   * Return the next shapes used by the player.
   * @return The shape played by the player
   */
	public Shape play(){
		return this.strategy.chooseShape();
	}

	/**
   * Add a certain number of points to the player's score.
   */
	public void addPoints(int p){
		this.score += p;
	}


	/**
   * Return the name of the player.
   * @return The name of the player.
   */
	public String toString(){
		return "Player "+this.name;
	}

	/**
   * Set the strategy used by the player.
   * @param newStrategy The new strategy to used by the player.
   */
	public void setStrategy(Strategy newStrategy){
		this.strategy = newStrategy;
	}
}

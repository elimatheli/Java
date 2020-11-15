package pfc;
import pfc.strategy.*;

/**
 * a game class for the game rock-paper-scissors
 * @author Viseux Eliot - Hwang Ju-Chan
 * @version 1.0
 */


public class Game{

	private Player p1;
	private Player p2;
	private int nbRounds;
	public static final int VICTORY_POINTS = 2;
	public static final int TIE_POINTS = 1;


	 /**
     * creates a Game of "rock - paper - scissors" with two players.
     * @param p1 The player one in the game.
     * @param p2 The player two in the game.
     * @param nbRounds The Number of rounds of the game.
     */

	public Game(Player p1,Player p2,int nbRounds){
		this.p1 = p1;
		this.p2 = p2;
		this.nbRounds = nbRounds;
	}

	/**
   * Play rounds of the game a certain number of time and return the winner.
   * @param nbRounds The Number of rounds of the game.
   * @return The winner of the Game.
   */
	public Player play(int nbRounds){
		for(int i =0;i<nbRounds;i++){
			this.playOneRound();
		}
		System.out.print("The winner is : ");
		if(this.p1.getScore() < this.p2.getScore()){
			System.out.println(this.p2.getName());
			return this.p2;
		}else if (this.p1.getScore() > this.p2.getScore()){
			System.out.println(this.p1.getName());
			return this.p1;
		}else{
			Player draw = new Player("any of them",new RockStrategy());
			System.out.println(draw.getName());
			return draw;
		}
	}

	/**
   * Plays one round of the game and adds the points of the round
   * Prints the shapes and the results
   */
	private void playOneRound(){
		Shape c1 = this.p1.play();
		Shape c2 = this.p2.play();
		System.out.println(this.p1.getName()+" played "+c1.name()+" and "+this.p2.getName()+" played "+c2.name());
		if(c1.beats(c2)){
			this.p1.addPoints(Game.VICTORY_POINTS);
			System.out.println(this.p1.getName()+" won and got "+Game.VICTORY_POINTS+" points");
		}else if(c2.beats(c1)){
			this.p2.addPoints(Game.VICTORY_POINTS);
			System.out.println(this.p2.getName()+" won and got "+Game.VICTORY_POINTS+" points");
		}else{
			this.p1.addPoints(Game.TIE_POINTS);
			this.p2.addPoints(Game.TIE_POINTS);
			System.out.println("It's draw, they both got "+Game.TIE_POINTS+" point(s)");
		}
		System.out.println("The score is now : "+this.p1.getName()+" = "+this.p1.getScore()+" points - "+this.p2.getName()+" = "+this.p2.getScore()+" points");
	}

	/**
   * Returns the player one.
   * @return the player one.
   */
	public Player getPlayerOne(){
		return this.p1;
	}

	/**
   * Returns the player two.
   * @return the player two.
   */
	public Player getPlayerTwo(){
		return this.p2;
	}

	/**
   * Returns the number of rounds.
   * @return the number of rounds.
   */
	public int getNbRounds(){
		return this.nbRounds;
	}
}

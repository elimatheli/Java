package pfc.strategy;
import pfc.Shape;

/**
 * a Strategy only using Rock
 * @author Viseux Eliot - Hwang Ju-Chan
 * @version 1.0
 */
public class RockStrategy implements Strategy{

  private Shape shape;

	/**
   * Create a strategy only using rock
   */
	public RockStrategy(){
		this.shape = Shape.ROCK;
	}

	/**
   * chooses always the rock shape
   * @return the rock shape
   */
	public Shape chooseShape(){
    return this.shape;
  }
}

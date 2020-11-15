package pfc.strategy;
import pfc.Shape;

/**
 * a Strategy only using scissors
 * @author Viseux Eliot - Hwang Ju-Chan
 * @version 1.0
 */
public class ScissorsStrategy implements Strategy{

  private Shape shape;

	/**
   * Create a strategy only using scissors
   */
	public ScissorsStrategy(){
		this.shape = Shape.SCISSORS;
	}

	/**
   * chooses always the scissors shape
   * @return the scissors shape
   */
	public Shape chooseShape(){
    return this.shape;
  }
}

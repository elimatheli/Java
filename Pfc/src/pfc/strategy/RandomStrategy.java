package pfc.strategy;
import pfc.Shape;
import java.util.Random;

/**
 *
 * @author Viseux Eliot - Hwang Ju-Chan
 * @version 1.0
 */
public class RandomStrategy implements Strategy{

  private Random randShape;

	/**
   * Create a random strategy
   */
	public RandomStrategy(){
		this.randShape = new Random();
	}

	/**
   * chooses a shape randomly
   * @return a shape chosen randomly
   */
	public Shape chooseShape(){
    int chosenShape = this.randShape.nextInt(3);
    return Shape.values()[chosenShape];
  }
}

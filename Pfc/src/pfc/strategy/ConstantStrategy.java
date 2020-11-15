package pfc.strategy;
import pfc.Shape;

/**
 *
 * @author Viseux Eliot - Hwang Ju-Chan
 * @version 1.0
 */
public class ConstantStrategy implements Strategy{

	private Shape[] shapes;
	private int index;

	/**
   * Create a pattern of shapes.
   * @param shapes The pattern of shapes used by the player.
   */
	public ConstantStrategy(Shape...shapes){

		this.shapes = shapes;
		this.index = 0;
	}

	/**
   * choose the next shape of the pattern strategy.
   * @return The shape played by the player.
   */
	public Shape chooseShape(){
		if(this.index == this.shapes.length){this.index = 0;}
		return this.shapes[index++];
	}
}

package pfc.strategy;
import pfc.Shape;

/**
 * a Strategy only using Paper
 * @author Viseux Eliot - Hwang Ju-Chan
 * @version 1.0
 */
public class PaperStrategy implements Strategy{

  private Shape shape;

	/**
   * Create a strategy only using paper
   */
	public PaperStrategy(){
		this.shape = Shape.PAPER;
  }

	/**
   * chooses always the paper shape
   * @return a paper shape
   */
	public Shape chooseShape(){
    return this.shape;
  }
}

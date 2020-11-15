package pfc;

/**
 *
 * @author Viseux Eliot - Hwang Ju-Chan
 * @version 1.0
 */


public enum Shape{

	ROCK,
	PAPER,
	SCISSORS;

	/**
   * Compare two shapes
   * @param other another Shape
   * @return true iff this beats0 other
   */
	public boolean beats(Shape other){

		int cmp = this.compareTo(other);
		if(cmp == 2) {cmp = -1;}
		if(cmp == -2) {cmp = 1;}
		return cmp > 0;
	}
}

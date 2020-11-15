package pfc.strategy;
import pfc.Shape;

/**
 * interface for Stategies of games
 * @author Viseux Eliot - Hwang Ju-Chan
 * @version 1.0
 */


public interface Strategy{

	/** choose the strategy to use */
	public Shape chooseShape();

	}

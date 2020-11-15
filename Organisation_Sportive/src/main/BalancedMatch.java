package main;

import java.util.Random;

/**
 * The BalancedMatch class implements the Match interface and represents one type of match.
 *
 * @author Eliot Viseux , Thomas Vanderplancke
 * @see Match
 */
public class BalancedMatch implements Match {

    public void doMatch(Competitor c1, Competitor c2) {
        //If random boolean is true, winner equals to c1, if false c2.
        Competitor winner = new Random().nextBoolean() ? c1 : c2;
        //Updating the points of the winner
        winner.setPoints(winner.getPoints() + 1);
    }
}

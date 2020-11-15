package main;

/**
 * The Interface Match that represents the methods of a match. An interface was more appropriate than an abstract class beacause every match works the same way.
 *
 * @author Eliot Viseux , Thomas Vanderplancke
 */

public interface Match {

    /**
     * A method that makes compete two competitors, depending on the type of match it will act differently.
     *
     * @param c1 The first competitor.
     * @param c2 The second competitor.
     */
    void doMatch(Competitor c1, Competitor c2);

}

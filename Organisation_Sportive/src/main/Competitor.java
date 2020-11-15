package main;

/**
 * Represents a competitor that participates in a competition. As she wins she will increase her points.
 *
 * @author Eliot Viseux, Thomas Vanderplancke
 */
public class Competitor {

    /**
     * The name of the competitor.
     */
    private final String name;

    /**
     * The victory points count associated to a competitor.
     */
    private int points = 0;

    /**
     * The constructor of Competitor that takes a name as an argument.
     *
     * @param name The name of the competitor.
     */
    public Competitor(String name) {
        this.name = name;
    }

    /**
     * Provides the name of the competitor.
     *
     * @return The name of the competitor.
     */
    public String getName() {
        return this.name;
    }

    /**
     * Provides the amount of points of a competitor.
     *
     * @return the victory points of a competitor.
     */
    public int getPoints() {
        return this.points;
    }

    /**
     * Sets the victory points of a competitor.
     *
     * @param points The new amount of victory points.
     */
    public void setPoints(int points) {
        this.points = points;
    }
}

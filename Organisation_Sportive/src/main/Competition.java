package main;

import utils.MapUtil;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * The abstract class Competition that represents the type of competition we want.
 *
 * @author Eliot Viseux, Thomas Vanderplancke
 */
public abstract class Competition {

    /**
     * The type of match wanted.
     */
    private final BalancedMatch match = new BalancedMatch();

    /**
     * The list of the competitors to participate.
     */
    private final List<Competitor> competitors;


    /**
     * The constructor of Competition that takes a list of competitors.
     *
     * @param competitorList a list of competitors.
     * @see Competitor
     */
    public Competition(List<Competitor> competitorList) {
        competitors = competitorList;
    }


    /**
     * Getter for the competitors attribute.
     *
     * @return a list of the current competitors.
     */
    public List<Competitor> getCompetitors() {
        return competitors;
    }


    /**
     * The method that calls the abstract method play(List<Competitor> competitors).
     */
    public void play() {
        play(getCompetitors());
    }


    /**
     * Launches the competition, depending on the chosen mode, it will act differently.
     *
     * @param competitors a list of competitors.
     */
    abstract protected void play(List<Competitor> competitors);

    /**
     * An abstract method that calls the method from Match to make 2 competitors compete , depending on the type of match chosen, it will act differently.
     *
     * @param c1 The first competitor.
     * @param c2 The second competitor.
     */
    protected void playMatch(Competitor c1, Competitor c2) {
        this.match.doMatch(c1, c2);
    }

    /**
     * Combines each competitor to its points and displays competitors ranking.
     *
     * @return the map with competitors as key and its points as value, sorted by descending values.
     * @see MapUtil
     */
    public Map<Competitor, Integer> ranking() {

        Map<Competitor, Integer> rank = new HashMap<>();
        for (Competitor comp : this.competitors) {
            rank.put(comp, comp.getPoints());
        }

        return MapUtil.sortByDescendingValue(rank);
    }

    protected void displayRankings(Map<Competitor, Integer> res) {
        System.out.println("\n*** Rankings ***");
        for (Competitor key : res.keySet()) {
            System.out.println(key.getName() + " - " + key.getPoints());
        }
    }
}

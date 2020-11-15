package main;

import java.util.List;

/**
 * The League class extends the super class Competition and represents a competition in which every competitor fights each other.
 * The competitor with the most points (victories) is the winner.
 *
 * @author Eliot Viseux, Thomas Vanderplancke
 * @see Competition
 */
public class League extends Competition {

    /**
     * The constructor of League that takes a list of competitors as an argument.
     *
     * @param competitorList the list of competitors.
     * @see Competitor
     */
    public League(List<Competitor> competitorList) {
        super(competitorList);
    }

    /**
     * Concrete implementation of Competition play() for League case
     */
    @Override
    public void play(List<Competitor> competitors) {
        for (int i = 0; i < competitors.size(); i++) {
            for (Competitor competitor : competitors) {
                //Verify that a competitor will not face himself
                if (competitors.get(i) != competitor) {
                    int retScoreCompOne = competitors.get(i).getPoints();
                    this.playMatch(competitors.get(i), competitor);
                    //Display of the winner of the match
                    if (competitors.get(i).getPoints() == retScoreCompOne) {
                        System.out.println(competitors.get(i).getName() + " vs " + competitor.getName() + " --> " + competitor.getName() + " wins!");
                    } else {
                        System.out.println(competitors.get(i).getName() + " vs " + competitor.getName() + " --> " + competitors.get(i).getName() + " wins!");
                    }
                }
            }
        }
        displayRankings(this.ranking());
    }
}

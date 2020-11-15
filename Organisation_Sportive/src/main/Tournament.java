package main;

import utils.Numbers;

import java.util.List;

/**
 * The Tournament class extends the super class Competition and represents a competition in which competitors compete 2 by 2. The looser is instantly eliminated
 * from the competition, and the competitors that remains after first round play the second between them and so on until it remains only one, the winner.
 *
 * @author Eliot Viseux, Thomas Vanderplancke
 * @see Competition
 */
public class Tournament extends Competition {

    /**
     * The constructor of Tournament that takes a list of competitors as argument.
     *
     * @param competitorList the list of competitors.
     * @throws Exception number of Competitors must be power of 2
     * @see Competitor
     */
    public Tournament(List<Competitor> competitorList) throws Exception {
        super(competitorList);
        //Throws an exception if the number of competitors in not a power of 2.
        if (!Numbers.isPowerOf2(competitorList.size())) {
            throw new Exception("Number of Competitors must be power of 2");
        }
    }

    /**
     * Concrete implementation of Competition play() for Tournament case
     */
    @Override
    public void play(List<Competitor> competitors) {
        //While we don't have our winner
        while (competitors.size() != 1) {
            //Display feature depending on the remaining number of competitors.
            switch (competitors.size()) {
                case 2:
                    System.out.println("\nFinal :");
                    break;
                case 4:
                    System.out.println("\nSemi-finals :");
                    break;
                case 8:
                    System.out.println("\nQuarters finals :");
                    break;
            }

            for (int i = 0; i < competitors.size(); i++) {
                //Match between two competitors
                this.playMatch(competitors.get(i), competitors.get(i + 1));
                //If competitor A won, then he has more points.
                if (competitors.get(i).getPoints() > competitors.get(i + 1).getPoints()) {
                    System.out.println(competitors.get(i).getName() + " vs " + competitors.get(i + 1).getName() + " --> " + competitors.get(i).getName() + " wins!");
                    //Then competitor B is no longer in the tournament.
                    competitors.remove(competitors.get(i + 1));
                }
                //Otherwise, it means B won.
                else {
                    System.out.println(competitors.get(i).getName() + " vs " + competitors.get(i + 1).getName() + " --> " + competitors.get(i + 1).getName() + " wins!");
                    competitors.remove(competitors.get(i));
                }
            }

        }
        //Display of the final winner
        System.out.println("\n*** Rankings ***");
        System.out.println(competitors.get(0).getName() + " wins!");
    }
}

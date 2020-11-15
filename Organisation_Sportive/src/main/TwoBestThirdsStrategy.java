package main;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/**
 * The TwoBestThirdsStrategy class implements the interface SelectionStrategy and allows the selection of competitors
 * participating in the tournament phase. In this selection, the 2 best thirds, all groups combined are added to the selection result.
 *
 * @author Eliot Viseux, Thomas Vanderplancke
 * @see SelectionStrategy
 */
public class TwoBestThirdsStrategy implements SelectionStrategy {

    /**
     * Provides according to the parameters a list of competitors for the tournament phase.
     *
     * @param generalRankingByGroupAndScore the overall ranking sorted by group order and score.
     * @param numberOfWinners               the chosen number of winners in each group.
     * @param numberOfGroups                the chosen number of groups (number of leagues executed).
     * @return a list with the competitors who will participate in the tournament.
     */
    @Override
    public List<Competitor> selectCompetitorsForTournament(Map<Competitor, Integer> generalRankingByGroupAndScore, int numberOfWinners, int numberOfGroups) {

        List<Competitor> winnersList = new ArrayList<>();
        List<Competitor> bestLosersList = new ArrayList<>();
        List<Competitor> competitorsByRankingOrder = new ArrayList<>(generalRankingByGroupAndScore.keySet());
        List<List<Competitor>> partitions = new ArrayList<>();

        //Number of competitors in each group.
        int partitionSize = generalRankingByGroupAndScore.size() / numberOfGroups;

        //We put each group(list of competitors) in a list.
        for (int i = 0; i < competitorsByRankingOrder.size(); i += partitionSize) {
            partitions.add(competitorsByRankingOrder.subList(i, Math.min(i + partitionSize, competitorsByRankingOrder.size())));
        }

        //For each group, we add the right number of winners in the result list, and the first loser(the highest score) of each group in bestLosersList.
        for (List<Competitor> group : partitions) {
            winnersList.addAll(group.subList(0, numberOfWinners));
            bestLosersList.addAll(group.subList(numberOfWinners, numberOfWinners + 1));
        }

        //Getting the 2 best thirds with shuffleAndGetTwoBest() method.
        List<Competitor> TwoBestThirds = shuffleAndGetTwoBest(bestLosersList);

        winnersList.addAll(TwoBestThirds);
        return winnersList;
    }

    /**
     * Provides the 2 best thirds through a shuffle.
     *
     * @param thirds the list of all the thirds.
     * @return a list of two competitors.
     */
    public List<Competitor> shuffleAndGetTwoBest(List<Competitor> thirds) {

        Collections.shuffle(thirds);

        //We take the first two competitors
        List<Competitor> bestThirdsList = thirds.subList(0, 2);

        //Display
        System.out.println("\nBest Thirds :");
        for (Competitor comp : bestThirdsList) {
            System.out.println(comp.getName());
        }

        return bestThirdsList;
    }
}

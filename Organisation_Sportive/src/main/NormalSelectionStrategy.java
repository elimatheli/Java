package main;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * The NormalSelectionStrategy class implements the interface SelectionStrategy and allows the selection of competitors
 * participating in the tournament phase. No specific option for the selection.
 *
 * @author Eliot Viseux, Thomas Vanderplancke
 * @see SelectionStrategy
 */
public class NormalSelectionStrategy implements SelectionStrategy {

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
        List<Competitor> competitorsByRankingOrder = new ArrayList<>(generalRankingByGroupAndScore.keySet());
        List<List<Competitor>> partitions = new ArrayList<>();

        //Number of competitors in each group.
        int partitionSize = generalRankingByGroupAndScore.size() / numberOfGroups;

        //We put each group(list of competitors) in a list.
        for (int i = 0; i < competitorsByRankingOrder.size(); i += partitionSize) {
            partitions.add(competitorsByRankingOrder.subList(i, Math.min(i + partitionSize, competitorsByRankingOrder.size())));
        }

        //For each group, we add the right number of winners in the result list.
        for (List<Competitor> group : partitions) {
            winnersList.addAll(group.subList(0, numberOfWinners));
        }

        return winnersList;
    }
}

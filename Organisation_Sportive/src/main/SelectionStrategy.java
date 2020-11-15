package main;

import java.util.List;
import java.util.Map;

/**
 * Interface for the selection of competitors for the Tournament Phase in Masters competition.
 *
 * @author Eliot Viseux, Thomas Vanderplancke
 */
public interface SelectionStrategy {

    /**
     * Provides according to the parameters a list of competitors for the tournament phase.
     *
     * @param generalRankingByGroupAndScore the overall ranking sorted by group order and score.
     * @param numberOfWinners               the chosen number of winners in each group.
     * @param numberOfGroups                the chosen number of groups (number of leagues executed).
     * @return a list with the competitors who will participate in the tournament.
     */
    List<Competitor> selectCompetitorsForTournament(Map<Competitor, Integer> generalRankingByGroupAndScore, int numberOfWinners, int numberOfGroups);
}

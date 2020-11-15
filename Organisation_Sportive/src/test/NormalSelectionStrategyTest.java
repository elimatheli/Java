package test;

import main.Competitor;
import main.NormalSelectionStrategy;
import org.junit.jupiter.api.Test;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

class NormalSelectionStrategyTest {
    @Test
    void ShouldReturnNumberOfWinnersWanted() {

        NormalSelectionStrategy strategy = new NormalSelectionStrategy();
        Map<Competitor, Integer> generalRankingByGroupAndScore = new LinkedHashMap<>();

        generalRankingByGroupAndScore.put(new Competitor("Lakers"), 10);
        generalRankingByGroupAndScore.put(new Competitor("Toronto"), 2);
        generalRankingByGroupAndScore.put(new Competitor("Dallas"), 8);
        generalRankingByGroupAndScore.put(new Competitor("Phoenix"), 4);

        List<Competitor> winnersList = strategy.selectCompetitorsForTournament(generalRankingByGroupAndScore, 1, 2);

        assertEquals(2, winnersList.size());
    }
}
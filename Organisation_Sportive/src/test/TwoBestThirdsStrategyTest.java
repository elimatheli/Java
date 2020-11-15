package test;

import main.Competitor;
import main.TwoBestThirdsStrategy;
import org.junit.jupiter.api.Test;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TwoBestThirdsStrategyTest {
    @Test
    void ShouldReturnNumberOfWinnersWanted() {

        TwoBestThirdsStrategy strategy = new TwoBestThirdsStrategy();
        Map<Competitor, Integer> generalRankingByGroupAndScore = new LinkedHashMap<>();

        generalRankingByGroupAndScore.put(new Competitor("Lakers"), 10);
        generalRankingByGroupAndScore.put(new Competitor("Lakers"), 3);
        generalRankingByGroupAndScore.put(new Competitor("Toronto"), 2);
        generalRankingByGroupAndScore.put(new Competitor("Cavaliers"), 0);
        generalRankingByGroupAndScore.put(new Competitor("Dallas"), 8);
        generalRankingByGroupAndScore.put(new Competitor("Phoenix"), 4);
        generalRankingByGroupAndScore.put(new Competitor("Celtics"), 3);
        generalRankingByGroupAndScore.put(new Competitor("Spurs"), 1);

        List<Competitor> winnersList = strategy.selectCompetitorsForTournament(generalRankingByGroupAndScore, 1, 2);

        assertEquals(4, winnersList.size());
    }
}
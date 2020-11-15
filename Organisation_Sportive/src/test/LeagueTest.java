package test;

import main.Competition;
import main.Competitor;
import main.League;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class LeagueTest {
    @Test
    void createLeagueAndReturnFirstCompetitor() {
        List<Competitor> competitorList = new ArrayList<>();
        competitorList.add(new Competitor("Lakers"));
        competitorList.add(new Competitor("Bulls"));
        competitorList.add(new Competitor("Celtics"));

        Competition leagueCompetition = new League(competitorList);

        assertEquals("Lakers", leagueCompetition.getCompetitors().get(0).getName());
    }

    @Test
    void createLeagueMatchAndScoreMustBeIncreased() {
        List<Competitor> competitorList = new ArrayList<>();
        competitorList.add(new Competitor("Lakers"));
        competitorList.add(new Competitor("Bulls"));
        League leagueCompetition = new League(competitorList);

        leagueCompetition.play();

        Map<Competitor, Integer> rank = new HashMap<>();
        for (Competitor comp : leagueCompetition.getCompetitors()) {
            rank.put(comp, comp.getPoints());
        }

        assertTrue(leagueCompetition.getCompetitors().get(0).getPoints() >= 1 || leagueCompetition.getCompetitors().get(1).getPoints() >= 1);
    }

    @Test
    void DoTwoMatchesAndDisplayResults() {
        List<Competitor> competitorList = new ArrayList<>();
        competitorList.add(new Competitor("Lakers"));
        competitorList.add(new Competitor("Bulls"));
        competitorList.add(new Competitor("Celtics"));
        League leagueCompetition = new League(competitorList);

        leagueCompetition.play();

        assertEquals(3, leagueCompetition.ranking().size());
    }

    @Test
    void DoAllTheMatchesAndListShouldHaveAllTheTeams() {
        List<Competitor> competitorList = new ArrayList<>();
        competitorList.add(new Competitor("Lakers"));
        competitorList.add(new Competitor("Bulls"));
        competitorList.add(new Competitor("Celtics"));
        competitorList.add(new Competitor("Cavaliers"));
        competitorList.add(new Competitor("Raptors"));
        competitorList.add(new Competitor("Spurs"));
        League leagueCompetition = new League(competitorList);

        leagueCompetition.play();
        assertEquals(6, competitorList.size());
    }
}

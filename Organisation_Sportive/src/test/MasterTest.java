package test;

import main.Competitor;
import main.Master;
import main.NormalSelectionStrategy;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MasterTest {

    @Test
    void createMasterAndReturnFirstCompetitor() throws Exception {
        List<Competitor> competitorList = new ArrayList<>();
        competitorList.add(new Competitor("Lakers"));
        competitorList.add(new Competitor("Bulls"));
        competitorList.add(new Competitor("Celtics"));
        competitorList.add(new Competitor("Spurs"));

        Master masterCompetition = new Master(competitorList);
        assertEquals("Lakers", masterCompetition.getCompetitors().get(0).getName());
    }

    @Test
    void doesLeaguePhaseAndReturnsGoodNumberOfWinners() {
        int numberOfWinners = 1;
        List<Competitor> competitorList = new ArrayList<>();
        competitorList.add(new Competitor("Lakers"));
        competitorList.add(new Competitor("Bulls"));
        competitorList.add(new Competitor("Celtics"));
        Master masterCompetition = new Master(competitorList);

        Map<Competitor, Integer> groups = new HashMap<>();

        groups.put(new Competitor("Lakers"), 1);
        groups.put(new Competitor("Celtics"), 1);
        groups.put(new Competitor("Chicago"), 2);
        groups.put(new Competitor("Cavalier"), 2);
        Map<Competitor, Integer> LeagueWinnersList = masterCompetition.playLeague(groups, 2);
        assertEquals(4, LeagueWinnersList.size());
    }

    @Test
    void doesAllTheCompetition() throws Exception {

        int numberOfWinners = 1;
        int numberOfGroups = 2;
        NormalSelectionStrategy strategy = new NormalSelectionStrategy();
        List<Competitor> competitorList = new ArrayList<>();
        competitorList.add(new Competitor("Lakers"));
        competitorList.add(new Competitor("Bulls"));
        competitorList.add(new Competitor("Celtics"));
        competitorList.add(new Competitor("Chicago"));

        Master masterCompetition = new Master(competitorList);
        Map<Competitor, Integer> allGroups = masterCompetition.createGroups(competitorList, numberOfGroups);
        Map<Competitor, Integer> generalRankingByGroupAndScore = masterCompetition.playLeague(allGroups, 2);
        List<Competitor> leagueWinners = strategy.selectCompetitorsForTournament(generalRankingByGroupAndScore, numberOfWinners, numberOfGroups);
        masterCompetition.playTournament(leagueWinners);
    }
}

package test;

import main.Competition;
import main.Competitor;
import main.Tournament;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class TournamentTest {
    @Test
    void createTournamentAndReturnFirstCompetitor() throws Exception {
        List<Competitor> competitorList = new ArrayList<>();
        competitorList.add(new Competitor("Lakers"));
        competitorList.add(new Competitor("Bulls"));
        competitorList.add(new Competitor("Celtics"));
        competitorList.add(new Competitor("Spurs"));
        Competition tournamentCompetition = new Tournament(competitorList);
        assertEquals("Lakers", tournamentCompetition.getCompetitors().get(0).getName());
    }

    @Test
    void createTournamentNumberOfTeamsIncorrectAndReturnException() {
        List<Competitor> competitorList = new ArrayList<>();

        assertThrows(Exception.class, () -> {
            competitorList.add(new Competitor("Lakers"));
            competitorList.add(new Competitor("Bulls"));
            competitorList.add(new Competitor("Celtics"));

            Competition tournamentCompetition = new Tournament(competitorList);
        });
    }

    @Test
    void createTournamentMatchAndScoreMustBeIncreased() throws Exception {
        List<Competitor> competitorList = new ArrayList<>();
        competitorList.add(new Competitor("Lakers"));
        competitorList.add(new Competitor("Bulls"));
        Tournament tournamentCompetition = new Tournament(competitorList);

        tournamentCompetition.play();
        assertTrue(tournamentCompetition.getCompetitors().get(0).getPoints() >= 1 || tournamentCompetition.getCompetitors().get(1).getPoints() >= 1);
    }

    @Test
    void DoAllTheMatchesAndListShouldHaveOnlyTheWinner() throws Exception {
        List<Competitor> competitorList = new ArrayList<>();
        competitorList.add(new Competitor("Lakers"));
        competitorList.add(new Competitor("Bulls"));
        competitorList.add(new Competitor("Celtics"));
        competitorList.add(new Competitor("Spurs"));
        competitorList.add(new Competitor("Phoenix"));
        competitorList.add(new Competitor("Raptors"));
        competitorList.add(new Competitor("Dallas"));
        competitorList.add(new Competitor("Clippers"));
        Tournament tournamentCompetition = new Tournament(competitorList);

        tournamentCompetition.play();
        assertEquals(1, tournamentCompetition.getCompetitors().size());
    }
}

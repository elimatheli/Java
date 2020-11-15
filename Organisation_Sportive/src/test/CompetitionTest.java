package test;

import main.Competition;
import main.Competitor;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CompetitionTest {
    @Test
    void CreateCompetitionAndReturnFirstCompetitor() {
        List<Competitor> competitorList = new ArrayList<>();
        competitorList.add(new Competitor("Lakers"));
        competitorList.add(new Competitor("Bulls"));
        competitorList.add(new Competitor("Celtics"));

        Competition mockCompetition = new MockCompetition(competitorList);

        assertEquals("Lakers", mockCompetition.getCompetitors().get(0).getName());
    }
}

package test;

import main.Application;
import main.Competitor;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class ApplicationTest {
    @Test
    void runCompetitionAndShouldReturnCorrectCompetitorsSize() throws Exception {
        List<Competitor> competitorList = new ArrayList<>();
        competitorList.add(new Competitor("Lakers"));
        competitorList.add(new Competitor("Bulls"));
        competitorList.add(new Competitor("Celtics"));
        competitorList.add(new Competitor("Spurs"));
        competitorList.add(new Competitor("Phoenix"));
        competitorList.add(new Competitor("Limonade"));
        competitorList.add(new Competitor("Raptors"));
        competitorList.add(new Competitor("Golden States"));
        Application.runCompetition(2, competitorList);

        assertEquals(1, competitorList.size());
    }
}

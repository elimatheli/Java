package test;

import main.Competitor;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CompetitorTest {

    @Test
    void createCompetitorAndReturnName() {
        Competitor competitorA = new Competitor("Lakers");

        String competitorName = competitorA.getName();

        assertEquals("Lakers", competitorName);
    }

    @Test
    void createCompetitorWithNameEmpty() {
        Competitor competitorA = new Competitor("");
        String competitorName = competitorA.getName();
        assertEquals("", competitorName);
    }

    @Test
    void createListCompetitorsAndReturnSize() {
        ArrayList<Competitor> competitorList = new ArrayList<>();

        competitorList.add(new Competitor("Lakers"));
        competitorList.add(new Competitor("Bulls"));
        competitorList.add(new Competitor("Celtics"));

        assertEquals(3, competitorList.size());
    }

    @Test
    void getCompetitorPoints() {
        Competitor competitorA = new Competitor("Lakers");

        competitorA.setPoints(5);
        assertEquals(5, competitorA.getPoints());
    }
}

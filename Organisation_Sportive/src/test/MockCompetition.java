package test;

import main.Competition;
import main.Competitor;

import java.util.List;
import java.util.Map;

public class MockCompetition extends Competition {

    public MockCompetition(List<Competitor> competitorList) {
        super(competitorList);
    }

    @Override
    public void playMatch(Competitor competitor, Competitor competitor1) {
    }

    @Override
    public Map<Competitor, Integer> ranking() {
        return null;
    }

    @Override
    protected void play(List<Competitor> competitors) {
    }
}

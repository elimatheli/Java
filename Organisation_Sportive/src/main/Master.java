package main;

import utils.Numbers;

import java.util.*;

/**
 * The Master class extends the super class Competition. This competition begins with a group stage at the end of which some competitors are selected to play in the final stage of the tournament.
 * The pools are organized in the form of a League while the final phase takes place in the form of a Tournament.
 *
 * @author Eliot Viseux, Thomas Vanderplancke
 * @see Competition
 */
public class Master extends Competition {

    /**
     * The constructor of Master that takes a list of competitors as argument.
     *
     * @param competitorList the list of competitors.
     * @see Competitor
     */
    public Master(List<Competitor> competitorList) {
        super(competitorList);
    }

    /**
     * Concrete implementation of Competition play() for Master case
     */
    @Override
    public void play(List<Competitor> competitors) {

        //We choose the options we want for the selection of competitors for the tournament Phase
        int option = chooseOptions();
        //Selection of the number of winners we want in each group
        int numberOfWinners = enterNumberOfWinners(competitors.size(), option);
        //Selection of the number of groups we want
        int numberOfGroups = enterNumberOfGroups(numberOfWinners, option);
        //Creation of all groups
        Map<Competitor, Integer> allGroups = createGroups(getCompetitors(), numberOfGroups);

        List<Competitor> leagueWinners = new ArrayList<>();

        System.out.println("\n*************************");
        System.out.println("-BEGINNING OF THE MASTER-");
        System.out.println("*************************");

        //Executing League phase. Overall ranking sorted by group order and score stored.
        Map<Competitor, Integer> generalRankingByGroupAndScore = playLeague(allGroups, numberOfGroups);
        //Depending on the options chosen, different strategy of selection for tournament phase.
        if (option == 1) {
            leagueWinners = selectCompetitorsForTournament(new NormalSelectionStrategy(), generalRankingByGroupAndScore, numberOfWinners, numberOfGroups);
        } else if (option == 2) {
            leagueWinners = selectCompetitorsForTournament(new TwoBestThirdsStrategy(), generalRankingByGroupAndScore, numberOfWinners, numberOfGroups);
        }

        //Display competitors doing the tournament
        System.out.println("\nLEAGUE RESULTS :");
        for (Competitor comp : leagueWinners) {
            System.out.println(comp.getName() + " goes to the Tournament Phase !");
        }

        //Executing Tournament phase.
        try {
            playTournament(leagueWinners);
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("\n**************************");
        System.out.println("----END OF THE MASTER----");
        System.out.println("**************************");
    }

    /**
     * Provides according to the parameters a list of competitors for the tournament phase.
     * (Strategy pattern design implementation)
     *
     * @param strategy                      an object which implements SelectionStrategy
     * @param generalRankingByGroupAndScore the overall ranking sorted by group order and score.
     * @param numberOfWinners               the chosen number of winners in each group.
     * @param numberOfGroups                the chosen number of groups (number of leagues executed).
     * @return a list with the competitors who will participate in the tournament.
     */
    private List<Competitor> selectCompetitorsForTournament(SelectionStrategy strategy, Map<Competitor, Integer> generalRankingByGroupAndScore, int numberOfWinners, int numberOfGroups) {
        return strategy.selectCompetitorsForTournament(generalRankingByGroupAndScore, numberOfWinners, numberOfGroups);
    }


    /**
     * Executes the League phase.
     *
     * @param allGroups      the map of the competitors and their groups.
     * @param numberOfGroups the chosen number of groups (number of leagues executed).
     * @return the list of the competitors who will do the Tournament phase.
     */
    public Map<Competitor, Integer> playLeague(Map<Competitor, Integer> allGroups, int numberOfGroups) {

        Map<Competitor, Integer> generalRankings = new LinkedHashMap<>();

        //For each group, we do a League between competitors, and we add the results (competitors, and their score) in the returning map.
        for (int groupNumber = 1; groupNumber <= numberOfGroups; groupNumber++) {
            System.out.println("\n*************************");
            System.out.println("---------GROUP " + groupNumber + "---------");
            System.out.println("*************************\n");

            //List which represents the competitors of one group.
            List<Competitor> groupCompetitors = new ArrayList<>();

            //Adding the right competitors in the list of their group
            for (Competitor comp : allGroups.keySet()) {
                if (allGroups.get(comp) == groupNumber) {
                    groupCompetitors.add(comp);
                }
            }

            //We do a League between the competitors of the group.
            League league = new League(groupCompetitors);
            league.play();

            //Adding the results of the group (competitors, and their score) in the returning map.
            generalRankings.putAll(league.ranking());
        }

        return generalRankings;
    }

    /**
     * Executes the Tournament competition.
     *
     * @param leagueWinnersList the list of the competitors.
     */
    public void playTournament(List<Competitor> leagueWinnersList) throws Exception {
        Tournament tournament = new Tournament(leagueWinnersList);
        System.out.println("\n*****************************\nBEGINNING OF THE TOURNAMENT-\n*****************************");

        //Does the tournament and displays the winner
        tournament.play();

        System.out.println("\n**************************\n--END OF THE TOURNAMENT--\n**************************");
    }

    /**
     * Provides a map of the competitors associated with groups.
     *
     * @param competitorList the list of the competitors.
     * @param numberOfGroups the chosen number of groups for the League phase.
     * @return the map of the competitors associated with their groups.
     */
    public Map<Competitor, Integer> createGroups(List<Competitor> competitorList, int numberOfGroups) {

        //The map which contains the competitor followed by his group number.
        Map<Competitor, Integer> allGroups = new HashMap<>();

        int teamNumber = 0;
        //For each competitor...
        for (Competitor comp : competitorList) {
            //Assignment of one group.
            allGroups.put(comp, ((teamNumber % numberOfGroups) + 1));
            teamNumber++;
        }

        //Display of each group.
        for (int i = 1; i <= numberOfGroups; i++) {
            System.out.println("\nGROUP NUMBER " + i + ":");
            for (Competitor key : allGroups.keySet()) {
                if (allGroups.get(key) == i) {
                    System.out.println("TEAM: " + key.getName() + "");
                }
            }
        }

        return allGroups;
    }

    /**
     * Provides a number of groups for the League phase.
     *
     * @param numberOfWinnersByGroup the chosen number of winners in each group.
     * @param option                 the option for the selection process.
     * @return the number of groups.
     */
    private int enterNumberOfGroups(int numberOfWinnersByGroup, int option) {
        Scanner myScanner = new Scanner(System.in);
        int numberOfGroups = 0;
        boolean keepRunning = true;
        System.out.println("\nPLEASE ENTER THE NUMBER OF GROUPS :");
        do {
            try {
                numberOfGroups = myScanner.nextInt();
                // New input while number of groups > number of competitors (possibility of one group being empty).
                if (numberOfGroups < 2) {
                    System.out.println("The number of groups must be equal or higher than 2");
                    keepRunning = true;
                }
                // New input while number of groups > number of competitors (possibility of one group being empty).
                else if (numberOfGroups > getCompetitors().size()) {
                    System.out.println("The number of groups must be lower than the number of teams\nNumber of competitors :" + getCompetitors().size());
                    keepRunning = true;
                }
                // New input while number total of winners wanted > number of competitors (example : 16 winners for 8 competitors).
                else if (numberOfWinnersByGroup * numberOfGroups > getCompetitors().size()) {
                    System.out.println("Too high number of winners : " + numberOfWinnersByGroup * numberOfGroups + "number total of winners >" + getCompetitors().size() + " number of competitors");
                    keepRunning = true;
                }
                // New input while number of winners wanted not power of 2 (No option scenario).
                else if (option != 2 && !Numbers.isPowerOf2(numberOfWinnersByGroup * numberOfGroups)) {
                    System.out.println("Number of competitors in a tournament must be a power of 2 (2, 4, 8, 16, 32,...)");
                    keepRunning = true;
                }
                // New input while number of winners + 2 best thirds not power of 2 (TwoBestThirdsSelection scenario).
                else if (option == 2 && !Numbers.isPowerOf2((numberOfWinnersByGroup * numberOfGroups) + 2)) {
                    System.out.println("Number of competitors in a tournament must be a power of 2 (2, 4, 8, 16, 32,...)");
                    keepRunning = true;
                }
                // New input while size of all groups not equal (example : group A - 8 competitors, group B - 10 competitors).
                else if ((getCompetitors().size() % numberOfGroups) != 0) {
                    System.out.println("Groups with different sizes");
                    keepRunning = true;
                } else {
                    keepRunning = false;
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input type");
                myScanner.next();
            }
        }
        while (keepRunning);

        return numberOfGroups;
    }

    /**
     * Provides the number of winners in each group for the League phase.
     *
     * @param numberOfTeams the chosen number of teams.
     * @param option        the option for the selection process.
     * @return the number of winners in each group.
     */
    private int enterNumberOfWinners(int numberOfTeams, int option) {

        int numberOfWinnersByGroup = 0;
        boolean keepRunning = true;
        Scanner myScanner = new Scanner(System.in);

        System.out.println("\nPLEASE ENTER THE NUMBER OF WINNERS IN EACH GROUP : \n( > 0 && < number of competitors) :");

        do {
            try {
                numberOfWinnersByGroup = myScanner.nextInt();
                // New input while numberOfTeams <= numberOfWinnersByGroup (example : 6 winners by group but only 3 teams participating in the competition).
                if (numberOfTeams <= numberOfWinnersByGroup) {
                    System.out.println("Error : number of groups > number of winners by group\nPlease enter a correct number of winners by group (> 0 && < number of competitors) :");
                    keepRunning = true;
                }
                // New input while numberOfWinnersByGroup not a power of 2.
                else if (!Numbers.isPowerOf2(numberOfWinnersByGroup) && option != 2) {
                    System.out.println("Number of competitors in a tournament must be a power of 2 (2, 4, 8, 16, 32,...)");
                    keepRunning = true;
                }
                // New input while numberOfWinnersByGroup isn't superior to 0.
                else if (numberOfWinnersByGroup <= 0) {
                    System.out.println("Number of winners in a tournament must be > 0");
                    keepRunning = true;
                } else {
                    keepRunning = false;
                }

            } catch (InputMismatchException e) {
                System.out.println("Invalid input type");
                myScanner.next();
            }
        }
        while (keepRunning);

        return numberOfWinnersByGroup;
    }

    /**
     * Provides the options we want for the selection of competitors for the tournament Phase
     *
     * @return the option selected
     */
    private int chooseOptions() {

        int optionChoose = 0;

        Scanner myScanner = new Scanner(System.in);
        while (optionChoose == 0) {
            try {
                System.out.println("\nDO YOU WANT AN OPTION FOR THE NEXT LEAGUE ? :\n1) No\n2) 2 best thirds");
                optionChoose = myScanner.nextInt();
                //As long as a correct option isn't chosen
                while (optionChoose != 1 && optionChoose != 2) {
                    try {
                        System.out.println("Please choose a correct option.");
                        optionChoose = myScanner.nextInt();
                    } catch (InputMismatchException e) {
                        System.out.println("Invalid input type");
                        myScanner.next();
                    }
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input type");
                myScanner.next();
            }
        }

        return optionChoose;
    }
}

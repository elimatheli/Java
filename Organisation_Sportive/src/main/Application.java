package main;

import utils.Numbers;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

/**
 * The main class to init a competition.
 *
 * @author Eliot Viseux, Thomas Vanderplancke
 */
public class Application {

    public static void main(String[] args) throws Exception {

        //Possibility of doing a demo of one League and one Tournament.
        if (args.length != 0) {
            if (args[0].contentEquals("demo")) {
                List<Competitor> initCompetitorsDemo = new ArrayList<>();
                List<Competitor> initCompetitorsDemo2 = new ArrayList<>();
                for (int i = 1; i < 9; i++) {
                    initCompetitorsDemo.add(new Competitor("Demo " + i));
                    initCompetitorsDemo2.add(new Competitor("Demo " + i));
                }
                Competition demoComp = new Tournament(initCompetitorsDemo);
                Competition demoComp2 = new League(initCompetitorsDemo2);
                demoComp.play();
                demoComp2.play();
            }
        } else {

            int numberOfTeams;
            int competitionChoice = 0;
            Scanner myScanner = new Scanner(System.in);

            //While the input isn't one of the choice specified.
            while (competitionChoice != 1 && competitionChoice != 2 && competitionChoice != 3) {
                try {
                    System.out.println("PLEASE SELECT A COMPETITION: \n\n1) League\n2) Tournament\n3) Master");
                    competitionChoice = myScanner.nextInt();
                } catch (InputMismatchException e) {
                    System.out.println("Invalid input type");
                    myScanner.next();
                }
            }

            //Verifying if the selected numberOfTeams can be used or not.
            numberOfTeams = selectNumberOfTeams(competitionChoice);

            System.out.println("\nPLEASE ENTER THE COMPETITORS: \n(one by one)");

            //Entry of the competitors
            ArrayList<Competitor> competitors = enterCompetitors(numberOfTeams);
            //Execution of the competition
            runCompetition(competitionChoice, competitors);
        }
    }

    /**
     * Checks if the number of teams input is correct, if not the user will have to enter a new one.
     *
     * @param competitionChoice the int which represents the chosen competition
     * @return a correct numberOfTeams value
     */
    public static int selectNumberOfTeams(int competitionChoice) {

        int numberOfTeams = 0;
        Scanner myScanner = new Scanner(System.in);
        boolean keepRunning = true;
        System.out.println("\nPLEASE ENTER THE NUMBER OF TEAMS :\n( >= 2 for League And Tournament, >= 4 for Master)");

        do {
            try {
                numberOfTeams = myScanner.nextInt();
                // New input while number of groups > number of competitors (possibility of one group being empty).
                if (numberOfTeams < 4 && competitionChoice == 3) {
                    System.out.println("Please enter a number of teams >= 4");
                    keepRunning = true;
                }
                // New input while number of groups > number of competitors (possibility of one group being empty).
                else if (numberOfTeams < 2) {
                    System.out.println("Please enter a number of teams >= 2");
                    keepRunning = true;
                }
                // New input while number total of winners wanted > number of competitors (example : 16 winners for 8 competitors).
                else if (!Numbers.isPowerOf2(numberOfTeams) && competitionChoice != 3) {
                    System.out.println("Number of teams in a tournament must be a power of 2 (2, 4, 8, 16, 32,...)");
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

        return numberOfTeams;
    }


    /**
     * Creation of teams one by one through user input until the number of teams equals the param numberOfCompetitors
     *
     * @param numberOfCompetitors the number of teams we want to create
     * @return a list of competitors
     * @see Competitor
     */
    public static ArrayList<Competitor> enterCompetitors(int numberOfCompetitors) {

        ArrayList<Competitor> competitors = new ArrayList<>();
        ArrayList<String> competitorsNames = new ArrayList<>();
        Scanner myScanner = new Scanner(System.in);

        for (int i = 0; i < numberOfCompetitors; i++) {
            String compName = myScanner.nextLine();
            //No empty input allowed.
            while (compName.isEmpty()) {
                System.out.println("Empty value detected. Please enter the name.");
                compName = myScanner.nextLine();
            }
            //No duplicates allowed. That's why we have a list with all the names of the current competitors.
            while (competitorsNames.contains(compName)) {
                System.out.println("Competitor name already exists. Please choose another one.");
                compName = myScanner.nextLine();
            }
            competitorsNames.add(compName);
        }

        for (String s : competitorsNames) {
            competitors.add(new Competitor(s));
        }

        return competitors;
    }

    /**
     * Run the selected competition with the competitors
     *
     * @param competitionChoice the int which represents the chosen competition
     * @param competitorList    a list of competitors
     * @throws Exception if the number of teams is not a power of 2
     * @see Competition
     */
    public static void runCompetition(int competitionChoice, List<Competitor> competitorList) throws Exception {
        //If League...
        if (competitionChoice == 1) {
            League leagueCompetition = new League(competitorList);
            System.out.println("\n*****************************\n-BEGINNING OF THE LEAGUE-\n*****************************");
            leagueCompetition.play();
            System.out.println("\n**************************\nEND OF THE LEAGUE\n**************************");
        }
        //If Tournament...
        else if (competitionChoice == 2) {
            System.out.println("\n*****************************\nBEGINNING OF THE TOURNAMENT\n*****************************");
            Tournament tournamentCompetition = new Tournament(competitorList);
            tournamentCompetition.play();
            System.out.println("\n**************************\n--END OF THE TOURNAMENT--\n**************************");
        }
        //If Master...
        else if (competitionChoice == 3) {
            Master masterCompetition = new Master(competitorList);
            masterCompetition.play();
        }
    }
}

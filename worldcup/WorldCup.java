// Joseph Allen
package worldcup;

import java.util.ArrayList;
import java.util.Random;

public class WorldCup {

    public static String[] teams = {"Brazil", "USA", "Germany", "England", "Ghana", "Mexico", "Spain", "France"}; //Countries playing in world cup

    public static Random number = new Random();

    public static void rankings(String[] teams) { // creating the rankings for each of the teams at random

        
        ArrayList<Integer> randomRanks = new ArrayList<Integer>();
       
        int temp;

        for (int i = 0; i < teams.length; i++) {
            randomRanks.add(i);
        }

        int[] rankings = new int[teams.length];

        for (int i = 0; i < teams.length; i++) {
            rankings[i] = i;
        }

        String teamOrder[] = new String[teams.length];

        for (int i = 0; i < teams.length; i++) {
            temp = randomRanks.get(number.nextInt(randomRanks.size()));
            teamOrder[temp] = teams[temp];
          
            rankings[i] = temp + 1;
            randomRanks.remove(Integer.valueOf(temp));

        }

        System.out.println("Rankings of the teams are as follows:"); // sorting the teams rankings in order
        for (int i = 0; i < teams.length; i++) {
            System.out.print(teams[i] + " is rank " + rankings[i] + "\n");
        }

        for (int i = 0; i < teams.length; i++) {
            switch (rankings[i]) {
                case 1:
                    teamOrder[0] = teams[i];
                    break;
                case 2:
                    teamOrder[1] = teams[i];
                    break;
                case 3:
                    teamOrder[2] = teams[i];
                    break;
                case 4:
                    teamOrder[3] = teams[i];
                    break;
                case 5:
                    teamOrder[4] = teams[i];
                    break;
                case 6:
                    teamOrder[5] = teams[i];
                    break;
                case 7:
                    teamOrder[6] = teams[i];
                    break;
                case 8:
                    teamOrder[7] = teams[i];
                    break;
                default:
                    break;
            }

        }

       
        System.out.println("\nRankings in sorted Order: ");

        for (int i = 0; i < teams.length; i++) {
            System.out.print(teamOrder[i] + " is rank " + (i + 1) + "\n");
        }

        System.out.println();

        orderOfMatches(teamOrder);

        System.out.println();

        resultsOfMatches(teamOrder);
    }
    //////////////// Matches for the world cup//////////////////
    public static void orderOfMatches(String[] teamOrder) {
        System.out.println("Order of Matches(Quarter-Final):");
        System.out.println("[1] " + teamOrder[0] + " Vs. [8]" + teamOrder[7]);
        System.out.println("[2] " + teamOrder[1] + " Vs. [7]" + teamOrder[6]);
        System.out.println("[3] " + teamOrder[2] + " Vs. [6]" + teamOrder[5]);
        System.out.println("[4] " + teamOrder[3] + " Vs. [5]" + teamOrder[4]);
    }

    public static void resultsOfMatches(String[] teamOrder) {
        int team1 = 0,
                team2 = 0,
                team3 = 0,
                team4 = 0;
        System.out.println("Result of matches(Quarter-Final)");
        team1 = simulateMatch(teamOrder, 0, 7);
        team2 = simulateMatch(teamOrder, 1, 6);
        team3 = simulateMatch(teamOrder, 2, 5);
        team4 = simulateMatch(teamOrder, 3, 4);

        System.out.println("\nTeams advanced to Semi-Final:");
        String[][] semiFinals = new String[2][2];
        semiFinals[0][0] = teamOrder[team1];
        semiFinals[0][1] = teamOrder[team2];
        semiFinals[1][0] = teamOrder[team3];
        semiFinals[1][1] = teamOrder[team4];

        System.out.println("[" + (team1 + 1) + "] " + semiFinals[0][0]);
        System.out.println("[" + (team2 + 1) + "] " + semiFinals[0][1]);
        System.out.println("[" + (team3 + 1) + "] " + semiFinals[1][0]);
        System.out.println("[" + (team4 + 1) + "] " + semiFinals[1][1]);

        System.out.println("\nOrder of matches(Semi-Final):");
        System.out.println("[" + (team1 + 1) + "] " + semiFinals[0][0] + " [" + (team2 + 1) + "] " + semiFinals[0][1]);
        System.out.println("[" + (team3 + 1) + "] " + semiFinals[1][0] + " [" + (team4 + 1) + "] " + semiFinals[1][1]);

        int finalsTeam1 = 0, finalsTeam2 = 0;
        System.out.println("\nResults of matches (Semi-Final)");
        finalsTeam1 = simulateMatch(teamOrder, team1, team2);
        finalsTeam2 = simulateMatch(teamOrder, team3, team4);

        System.out.println();
        System.out.println("Teams advanced to the final");
        System.out.println("[" + (finalsTeam1 + 1) + "]" + teamOrder[finalsTeam1]);
        System.out.println("[" + (finalsTeam2 + 1) + "]" + teamOrder[finalsTeam2]);

        System.out.println("\nOrder of matches (Final)");
        System.out.println("[" + (finalsTeam1 + 1) + "]" + teamOrder[finalsTeam1] + " Vs. [" + (finalsTeam2 + 1) + "]" + teamOrder[finalsTeam2]);

        System.out.println("\nResults of Matches(Final)");

        //FINAl WINNER
        int temp1 = 0, temp2 = 0;

        do {
            temp1 = (int) (6 * Math.random() + 0);
            temp2 = (int) (6 * Math.random() + 0);
        } while (temp1 == temp2);

        System.out.println("[" + (finalsTeam1 + 1) + "] " + teamOrder[finalsTeam1] + " Vs. [" + (finalsTeam2 + 1) + "]" + teamOrder[finalsTeam2] + ":" + temp1 + "-" + temp2);

        if (temp1 > temp2) {
            System.out.println("\nWinner: [" + (finalsTeam1 + 1) + "]" + teamOrder[finalsTeam1]);
            System.out.println("Runner-up [" + (finalsTeam2 + 1) + "]" + teamOrder[finalsTeam2]);
        } else {
            System.out.println("\nWinner: [" + (finalsTeam2 + 1) + "]" + teamOrder[finalsTeam2]);
            System.out.println("Runner-up [" + (finalsTeam1 + 1) + "]" + teamOrder[finalsTeam1]);

        }

    }

    public static int simulateMatch(String[] teamOrder, int teamOne, int teamTwo) {
        int temp1 = 0, temp2 = 0;

        do {
            temp1 = (int) (6 * Math.random() + 0);
            temp2 = (int) (6 * Math.random() + 0);
        } while (temp1 == temp2);

        System.out.println("[" + (teamOne + 1) + "] " + teamOrder[teamOne] + " Vs. [" + (teamTwo + 1) + "]" + teamOrder[teamTwo] + ":" + temp1 + "-" + temp2);

        if (temp1 > temp2) {
            System.out.println(teamOrder[teamOne] + " advances");
        } else {
            System.out.println(teamOrder[teamTwo] + " advances");
        }

        if (temp1 > temp2) {
            return teamOne;
        } else {
            return teamTwo;
        }

    }

    public static void main(String[] args) {

        rankings(teams);

    }
}

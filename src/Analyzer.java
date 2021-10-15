/* ============================================================================
 * | 
 * | Author: Armando Ramos Jr
 * |
 * | Description: A program that plays a certain amount of craps games,
 * |    indicated by the user, and prints a report of its findings such as,
 * |    total games played, how many won, win rate, and more.
 * |
 * | Input: The only user inputs the amount of games they wish to play, it can
 * |    be any amount of 1 - 1,000,000.
 * |
 * | Output: The output is formatted into table with total games won, total
 * | 	rolls, average rolls per game, longest game, coming out games won, coming
 * | 	out games (wins and losses), continuing on games, and a table with how many
 * | 	games took rolls singled out from 1-20 and any that took more than 20 put
 * | 	under 21 rolls.
 * |
 * | Process: The program will start off by asking the user for the amount of
 * | 	games to be played, the games are played, the results are computed and then
 * | 	are printed in formatted tables.
 * | 
 * | *======================================================================= */

import java.util.Scanner;   //Read User Input for Amount of Games to be Played

public class Analyzer
{

    public static void main(String[] args)
    {

        Craps gameOfCraps = new Craps();
        Scanner input = new Scanner(System.in); 
        boolean validInput = false;
        int gamesPlayed = 0;

        /*
         * Validates the Users input to be within the given range and that its a
         * integer
         */
        do
        {
            System.out.println("Enter the Amount of Craps Games to be Played, Number of Games must be between 1 and 1,000,000 inclusive.");
            if (input.hasNextInt())
            {
                int userInput = input.nextInt();
                if (((userInput >= gameOfCraps.MIN_NUMBER_OF_GAMES) && (userInput <= gameOfCraps.MAX_NUMBER_OF_GAMES)))
                {
                    gameOfCraps.setNumberOfGames(userInput);
                    validInput = true;//);
                }
                else
                {
                    System.out.println("Input Not Within Range of 1 and 1,000,000 inclusive.");
                    userInput = 0;
                }
            }
            else
            {
                System.out.println("Please Enter an Integer Value.");
                input.next();
            }
        }
        while (validInput == false);

        /*
         * Plays a Game of Crabs teh amount of times the user wants
         */
        for (gamesPlayed = 1; gamesPlayed <= gameOfCraps.getNumberOfGames(); gamesPlayed++)
        {
            gameOfCraps.initialRoll();
            gameOfCraps.play();
        }

        System.out.println("\n Summary of Game Statistics");
        System.out.println("=================================================");
        System.out.println("|(1) Total Games: \t\t" + gameOfCraps.getNumberOfGames() + "\t\t|");
        System.out.println("|(2) Total Rolls: \t\t" + gameOfCraps.getTotalRolls() + "\t\t|");
        System.out.printf("|(3) Average Rolls per Game: \t%.4f\t\t|", gameOfCraps.averageRolls());
        System.out.println("\n|(4) Longest Game: \t\t" + gameOfCraps.getHighestRoll() + "\t\t|");
        System.out.println("=================================================");

        System.out.println("\n Summary of Win Statistics");
        System.out.println("=================================================================================");
        System.out.println("|Stat\t\t\tGames\t\tOutcome\t\tExpected\t\t|");
        System.out.println("=================================================================================");
        System.out.printf("|Total Wins: \t\t" + gameOfCraps.getWins() + " (5)\t%.4f (7)", gameOfCraps.getWiningOutcome());
        System.out.print("\t" + gameOfCraps.EXPECTED_WIN_PROBABILITY + " (6)\t\t|");
        System.out.printf("\n|Coming-Out Wins:\t" + gameOfCraps.getComingOutWins() + " (8)\t%.4f (11)", gameOfCraps.getComingOutWinProbability());
        System.out.printf(" \t%.4f (10)\t\t|", gameOfCraps.EXPECTED_COMING_OUT_WIN_PROBABILITY);
        System.out.printf("\n|Coming-Out Games:\t" + gameOfCraps.getComingOutGames() + " (9)\t%.4f (13)", gameOfCraps.getComingOutGameProbability());
        System.out.printf(" \t%.4f (14)\t\t|", gameOfCraps.EXPECTED_COMING_OUT_GAME_PROBABILITY);
        System.out.println("\n=================================================================================");

        System.out.println("\n Summary of Ending Statistics");
        System.out.println("==================================================================================");
        System.out.println("|Stat\t\t\tGames\t\tOutcome\t\tExpected\t\t|");
        System.out.println("==================================================================================");
        System.out.printf("|Continuing-On Games\t" + gameOfCraps.getContinuingOnGames() + " (14)\t%.4f (16)", gameOfCraps.getContinuingOnProbability());
        System.out.print("\t" + gameOfCraps.EXPECTED_CONTINUING_ON_GAME_PROBABILITY + " (15)\t\t|");
        System.out.println("\n==================================================================================");

        System.out.println("\n Summary of Game Lengths in Rolls (17)");
        System.out.println("=================================");
        System.out.println("|Rolls\t\t# of Games\t|");
        System.out.println("=================================");

        /*
         * Loop to print all indices expect the first (0)
         */
        for (int hasNext = 1; hasNext <= gameOfCraps.MAX_NUMBER_OF_ROLLS_COUNTED; hasNext++)
        {
            System.out.println("| " + hasNext + "\t\t" + gameOfCraps.rolls[hasNext] + "\t\t|");
        }
        System.out.println("=================================");

    }

}

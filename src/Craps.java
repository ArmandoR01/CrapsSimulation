/* =======================================================================
 * | Author:  Armando Ramos Jr
 * |
 * | Purpose:  This class exist because it has all the formulas, that the
 * | 	the main needs in order to calculate the measurements for the triangle.
 * |
 * | +-----------------------------------------------------------------------|
 * | Constants:
 * |    RESET - Resets Counters
 * |    COMING_OUT_WIN_SEVEN - Win Condition on Coming Out
 * |    COMING_OUT_WIN_ELEVEN - Win Condition on Coming Out
 * |    COMING_OUT_LOSE_TWO - Lose Condition on Coming Out
 * |    COMING_OUT_LOSE_THREE - Lose Condition on Coming Out
 * |    COMING_OUT_LOSE_TWELVE - Lose Condition on Coming Out
 * |    CONTINUING_LOSE_SEVEN - Lose Condition on Continuing On
 * |    MAX_NUMBER_OF_ROLLS_COUNTED - Amount of rolls where they stop getting
 * |            a new line and all get added to
 * |    MAX_NUMBER_OF_ROLLS_COUNTED_PLUS_ONE_FOR_ARRAY - Used in the array to
 * |            have the array index match the amount of rolls
 * |    EXPECTED_WIN_PROBABILITY - What the expected win rate is
 * |    EXPECTED_COMING_OUT_WIN_PROBABILITY - What the expected coming out
 * |            win rate is
 * |    EXPECTED_COMING_OUT_GAME_PROBABILITY - What the expected coming out
 * |            rate is, win or lose
 * |    EXPECTED_CONTINUING_ON_GAME_PROBABILITY - What the expected rate of
 * |            continuing after the coming out roll is
 * |    MIN_NUMBER_OF_GAMES - The minimum number games supported
 * |    MAX_NUMBER_OF_GAMES The maximum number of games supported
 * |
 * | +-----------------------------------------------------------------------|
 * | Constructors:
 * |   Craps()
 * |            Constructor for the game of craps
 * |
 * | Class Methods:
 * |   newHighestRoll -
 * |   addToTally -
 * |
 * | Instance Methods:
 * |   setNumberOfGames(int userInput) -
 * |   getNumberOfGames - int
 * |   getInitialRoll - int
 * |   getCurrentRoll - int
 * |   getTotalRolls - int
 * |   getPoint - int
 * |   initialRoll -
 * |   getComingOutGames - int
 * |   getComingOutWins - int
 * |   getWins - int
 * |   getComingOutGameProbability - double
 * |   getComingOutWinProbability - double
 * |   getContinuingOnProbability - double
 * |   getContinuingOnGames - int
 * |   roll -
 * |   getHighestRoll - int
 * |   averageRolls - double
 * |   getWiningOutcome - double
 * |   play -
 * ======================================================================= */


public class Craps
{

    /*
     * The two Die used in Games of Craps
     */
    private Die dieOne = new Die();
    private Die dieTwo = new Die();
    /*
     * boolean to See if Game is Over and needs to be Reset
     */
    private boolean gameOver = false;
    /*
     * Holds the Value of the Initial Roll of the Two Dice
     */
    private int initialRoll = 0;
    /*
     * Holds the Value of the Total Games Won
     */
    private int gamesWon = 0;
    /*
     * Holds the Value of the Total Games Won or Lost with The First Roll
     */
    private int comingOutGames = 0;
    /*
     * Holds the Value of the Total Games Won with The First Roll
     */
    private int comingOutWins = 0;
    /*
     * Holds the Value of the Total Games to be Played
     */
    private int numberOfGames = 0;
    /*
     * Holds the Value of the Total Rolls of all the Games
     */
    private int totalRolls = 0;
    /*
     * Holds the Value of the Highest Roll Total in one Game
     */
    private int highestCurrentRoll = 0;
    /*
     * Holds the Value of the Roll Total in the ongoing Game
     */
    private int currentRoll = 0;
    /*
     * If the Game is Neither Won nor Lost in the First Roll the value of
     * initialRoll is stored here as the new Target to Win
     */
    private int point = 0;
    /*
     * Holds the Value teh Two Dice Together after being Rolled
     */
    private int rollValue = 0;
    /*
     * Resets counters to Simulate a new Game
     */
    public final int RESET = 0;
    /*
     * First Roll 7 or 11 for Automatic Win
     */
    public final int COMING_OUT_WIN_SEVEN = 7;
    public final int COMING_OUT_WIN_ELEVEN = 11;
    /*
     * First Roll 2,3 or 12 for Automatic Loss
     */
    public final int COMING_OUT_LOSE_TWO = 2;
    public final int COMING_OUT_LOSE_THREE = 3;
    public final int COMING_OUT_LOSE_TWELVE = 12;
    /*
     * Every Roll after the First 7 for Automatic Loss
     */
    public final int CONTINUING_LOSE_SEVEN = 7;
    /*
     * Max Number of Roll that will get a new Lindex in Array
     */
    public final int MAX_NUMBER_OF_ROLLS_COUNTED = 21;
    /*
     * Used to match up the Indices with teh number of Rolls
     */
    public final int MAX_NUMBER_OF_ROLLS_COUNTED_PLUS_ONE_FOR_ARRAY = 22;
    /*
     * Online Calculated Win Probability in Craps
     * Citation sources – https://www.mscs.dal.ca/~hoshino/book/ch20craps.pdf
     */
    public final double EXPECTED_WIN_PROBABILITY = 0.4929;
    /*
     * Online Calculated Win With First Roll
     * Citation sources – https://www.mscs.dal.ca/~hoshino/book/ch20craps.pdf
     */
    public final double EXPECTED_COMING_OUT_WIN_PROBABILITY = 0.6666;
    /*
     * Online Calculated game Ending With First Roll
     * Citation sources –
     * https://www.dummies.com/education/math/using-probability-to-calculate-the-odds-in-the-game-of-craps/
     */
    public final double EXPECTED_COMING_OUT_GAME_PROBABILITY = 0.3334;
    /*
     * Online Calculated game Not Ending With First Roll
     * Citation sources –
     * https://www.dummies.com/education/math/using-probability-to-calculate-the-odds-in-the-game-of-craps/
     */
    public final double EXPECTED_CONTINUING_ON_GAME_PROBABILITY = 0.6667;
    /*
     * Min Number of Games Supported
     */
    public final int MIN_NUMBER_OF_GAMES = 1;
    /*
     * Max Number of Games Supported
     */
    public final int MAX_NUMBER_OF_GAMES = 1000000;

    /**
     * Constructor for the craps class.
     * Craps gives access to the Craps Game
     *
     */
    public Craps()
    {

    }

    int rolls[] = new int[MAX_NUMBER_OF_ROLLS_COUNTED_PLUS_ONE_FOR_ARRAY];

    /**
     * Sets the number of games to be played from the users input.
     * setNumberOfGames shows the number of games to be played
     *
     * @param userInput - The User's Input value of the Games to be Played
     */
    public void setNumberOfGames(int userInput)
    {
        numberOfGames = userInput;
    }

    /**
     * Retrieves the amount of games to be played.
     * getNumberOfGames gives the Amount of Games to be Played
     *
     * @return int returns the Amount of Games to be Played
     */
    public int getNumberOfGames()
    {
        return numberOfGames;
    }

    /**
     * Retrieves value of the two die rolled and added together.
     * getInitialRoll Value of the First Set of Die of the Game
     *
     * @return int returns the Value of dieOne and dieTwo Added
     */
    public int getInitialRoll()
    {
        return initialRoll;
    }

    /**
     * Retrieves The amount rolls int the current game.
     * getCurrentRolls Amount of Rolls in Current Game
     *
     * @return int returns the Amount of Rolls in the Current Game
     */
    public int getCurrentRolls()
    {
        return currentRoll;
    }

    /**
     * Retrieves the mount of rolls across all games played.
     * getTotalRolls gives the Amount of Rolls of All games
     *
     * @return int returns the Amount of Rolls in all the Games
     */
    public int getTotalRolls()
    {
        return totalRolls;
    }

    /**
     * If game is not won nor lost point is the new target to win
     * getPoint gives the Required Roll to Win After the First Roll
     *
     * @return int returns The Initial Roll as new target to win if First Roll
     *         did not will or lose
     */
    public int getPoint()
    {
        return point;
    }

    /**
     * Rolls the first set of die.
     * initialRoll Rolls the First set of Die
     *
     */
    public void initialRoll()
    {
        initialRoll = dieOne.roll() + dieTwo.roll();
        currentRoll++;
    }

    /**
     * Retrieves the amount of games that ended after one roll.
     * getComingOutGames gives the Amount of Games that Ended After one Roll
     *
     * @return int returns amount of games won or lost after one roll
     */
    public int getComingOutGames()
    {
        return comingOutGames;
    }

    /**
     * Retrieves the amount of games that were won ended after one roll.
     * getComingOutWins gives the Amount of Games Won After one Roll
     *
     * @return int returns amount of games won after one roll
     */
    public int getComingOutWins()
    {
        return comingOutWins;
    }

    /**
     * Retrieves the amount of games won.
     * getWins gives the Amount of Games that were won
     *
     * @return int returns the Amount of Games won
     */
    public int getWins()
    {
        return gamesWon;
    }

    /**
     * Calculates the probability of a game ended after one roll.
     * getComingOutGameProbability gives the rate of games ending after one game
     *
     * @return double returns the probability of games ending after one roll
     */
    public double getComingOutGameProbability()
    {
        double probability = comingOutGames / (double) numberOfGames;
        return probability;
    }

    /**
     * Calculates the probability of wining a game ended after one roll.
     * getComingOutWinProbability gives the rate of wining a game after one roll
     *
     * @return double returns the probability of games ending after one roll and
     *         wining it
     */
    public double getComingOutWinProbability()
    {
        double probability;
        if (comingOutGames == 0)
        {
            probability = 0;
            return probability;
        }
        else
        {
            probability = comingOutWins / (double) comingOutGames;
            return probability;
        }
    }

    /**
     * Calculates the probability of a game continuing after the first roll.
     * getContinuingOnProbability gives the rate of continuing a game after the
     * first roll
     *
     * @return double returns the probability of games not ending after one roll
     */
    public double getContinuingOnProbability()
    {
        double probability = (numberOfGames - comingOutGames) / (double) numberOfGames;
        return probability;
    }

    /**
     * Retrieves the amount of games that continued after one roll.
     * getNumberOfGames gives the Amount of Games that Continued after one Roll
     *
     * @return int returns the Amount of Games that Continued after One Roll
     */
    public int getContinuingOnGames()
    {
        int continuingOnGames = numberOfGames - comingOutGames;
        return continuingOnGames;
    }

    /**
     * Rolls the two dice and add the result.
     * roll rolls and add the result of the two dice
     *
     */
    public void roll()
    {
        rollValue = dieOne.roll() + dieTwo.roll();
        currentRoll++;
    }

    /**
     * Retrieves the highest roll in a single game.
     * getHighestRoll the highest roll in a single game, if statement to account
     * for a bug that if 1 game is played and it ends at the first roll then the
     * highest roll would be 0
     *
     * @return int returns the highest amount of roll in a single game of craps
     */
    public int getHighestRoll()
    {
        if (highestCurrentRoll == 0)
        {
            highestCurrentRoll++;
            return highestCurrentRoll;
        }
        return highestCurrentRoll;
    }

    /**
     * Calculates the average amount of roll per game.
     * averageRolls gives what the average rolls per game is
     *
     * @return double returns average amount of rolls per game
     */
    public double averageRolls()
    {
        double averageRolls = totalRolls / (double) getNumberOfGames();
        return averageRolls;
    }

    /**
     * Calculates the win rate of the games.
     * getWiningOutcome what the win rate is
     *
     * @return double returns what the win rate is based on the result of this
     *         set of games
     */
    public double getWiningOutcome()
    {
        double winningOutcome = gamesWon / (double) numberOfGames;
        return winningOutcome;
    }

    /**
     * Checks and changes the highest roll per game if the current roll is
     * higher than the previous highest.
     * newHighestRoll if the current roll is higher or not then the highest roll
     * of any game
     *
     */
    private void newHighestRoll(int roll)
    {
        if (roll > highestCurrentRoll)
        {
            highestCurrentRoll = roll;
        }
    }

    /**
     * Keeps track of the amount of games that end after x amount of rolls
     * addToTally Tally mark of rolls after games are done
     *
     */
    private void addToTally(int numberOfRolls)
    {
        if (numberOfRolls >= MAX_NUMBER_OF_ROLLS_COUNTED)
        {
            rolls[MAX_NUMBER_OF_ROLLS_COUNTED]++;
        }
        else
        {
            rolls[numberOfRolls]++;
        }
    }

    /**
     * Plays a game of Crabs.
     * play plays a play of crabs
     *
     */
    public void play()
    {
        if ((initialRoll == COMING_OUT_WIN_SEVEN) || (initialRoll == COMING_OUT_WIN_ELEVEN))
        {
            gamesWon++;
            comingOutGames++;
            comingOutWins++;
            rolls[currentRoll]++;
            totalRolls = totalRolls + currentRoll;
            currentRoll = RESET;
        }
        else if ((initialRoll == COMING_OUT_LOSE_TWO) || (initialRoll == COMING_OUT_LOSE_THREE) || (initialRoll == COMING_OUT_LOSE_TWELVE))
        {
            comingOutGames++;
            rolls[currentRoll]++;
            totalRolls = totalRolls + currentRoll;
            currentRoll = RESET;
        }
        else
        {
            point = initialRoll;
            initialRoll = RESET;
            gameOver = false;

            do
            {
                roll();
                newHighestRoll(currentRoll);

                if (rollValue == CONTINUING_LOSE_SEVEN)
                {
                    gameOver = true;
                    addToTally(currentRoll);
                    totalRolls = totalRolls + currentRoll;
                    currentRoll = RESET;
                }
                else if (rollValue == point)  // player wins!
                {
                    gamesWon++;
                    gameOver = true;
                    addToTally(currentRoll);
                    totalRolls = totalRolls + currentRoll;
                    currentRoll = RESET;
                }
            }
            while (!gameOver);
            point = RESET;
        }

    }

}

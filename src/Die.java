/* =======================================================================
 * | Author:  Armando Ramos Jr
 * |
 * | Purpose:  This class exist because a general purpose dice class to
 * | 	to be called to make a dice with 6 sides as a default if no number of sides
 * | 	is specified or a custom dice with any number of side between 2 and 100.
 * |
 * | Inherits From:  None
 * |
 * | Interfaces:  None
 * |
 * |  +-----------------------------------------------------------------------|
 * | Constants:
 * | 	MIN_NUMBER_OF_SIDES - The minimum number of sides this dice supports
 * |   	MAX_NUMBER_OF_SIDES - The maximum number of sides this dice supports
 * |   	DEFAULT_AMOUNT_OF_SIDES - The Default amount of sides for the dice
 * |    	If no parameters are set then a normal dice with 6 sides with be made.
 * |
 * | +-----------------------------------------------------------------------|
 * | Constructors:
 * | 	Die()
 * |    	Constructor used when number of sides is not specified
 * |
 * |    Die(int numberOfSides)
 * |        Constructor used when the number of sides are specified
 * | 
 * | +-----------------------------------------------------------------------|
 * |  Class Methods:
 * |    roll - int
 * |
 * | 
 * ======================================================================= */


import java.util.Random;

/**
 * A class to implement a standard 6-sided die
 */
public class Die	// die is the singular of "dice"
{

    /*
     * Number of Sides on the Dice
     */
    private int sides;

    /*
     * The min number of sides this dice supports
     *
     */
    private int MIN_NUMBER_OF_SIDES = 2;
    /*
     * The maximum number of sides this dice supports
     */
    private int MAX_NUMBER_OF_SIDES = 100;
    /*
     * Default Number of Sides Given if no Parameters are passed
     */
    private int DEFAULT_AMOUNT_OF_SIZES = 6;

    private static Random die = new Random();

    /**
     * Constructor for a die with the given number of sides.
     * Makes die with given sides unless it less than 2 in which it becomes
     * 2
     * or more than 100 which becomes 100
     *
     * @param numberOfSides User Gives the Number of Sides on the Die
     */
    public Die(int numberOfSides)
    {
        if (numberOfSides < MIN_NUMBER_OF_SIDES)
        {
            sides = MIN_NUMBER_OF_SIDES;
        }
        else if (numberOfSides > MAX_NUMBER_OF_SIDES)
        {
            sides = MAX_NUMBER_OF_SIDES;
        }
        else
        {
            sides = numberOfSides;
        }
        roll();
    }

    /*
     * Constructor for a die with the default numbre of sides 6.
     * No parameters used so a default die ia made
     *
     */
    public Die()
    {
        sides = DEFAULT_AMOUNT_OF_SIZES;
        roll();
    }

    /*
     * Rolls and gets the values of side it lands on.
     * roll rolls die and gets value of the side it lands  
     * 
     * @return int the value of the side the die lands on
     */
    public int roll()
    {
        int value = die.nextInt(sides) + 1;
        return value;
    }

}

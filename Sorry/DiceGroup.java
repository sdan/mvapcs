/**
 * Simulates the action of a group of Dice.  The dice
 * can be rolled and displayed in a row in the terminal window.
 * An individual Dice instance from the array of Dice can
 * be accessed, the dice values can be summed, and subgroups
 * of the Dice array can be rolled.
 *
 * @author Surya Dantuluri
 * @version October 3, 2017
 */

 import java.util.Scanner;
 public class DiceGroup
{
    /**
     * An array of Dice.
     */
     private Dice[] die;

    /**
     * Creates a DiceGroup with 5 Dice.  The Dice array elements are
     * initialized through the Dice constructor.
     */

     public DiceGroup()
     {
         die = new Dice[3];
         for(int i = 0;i<die.length;i++)
         {
             die[i]= new Dice(4);
         }
     }

    /**
     * Creates a DiceGroup with d Dice, where d is passed as a parameter.
     * The Dice array elements are initialized through the Dice constructor.
     *
     * @param d        The number of Dice to be created in the array.
     */
     public DiceGroup(int d)
     {
         die = new Dice[d];
         for(int i = 0;i<die.length;i++)
         {
             die[i]= new Dice();
         }
     }

    /**
     * Creates a DiceGroup with d Dice with n sides each, where d and n are passed as parameters.
     * The Dice array elements are initialized through the Dice constructor.
     *
     * @param d        The number of Dice to be created in the array.
     * @param n        The number of sides for the Dice to be created in the array.
     */
     public DiceGroup(int d, int n)
     {
         die = new Dice[d];
         for(int i = 0;i<die.length;i++)
         {
             die[i]= new Dice(n);
         }
     }

    public static void main (String [] args)
    {
        DiceGroup game = new DiceGroup();

        game.rollDice();
        game.printDice();
    }

    /**
     * Returns the Dice instance at the indicated index.
     *
     * @param  i      The index of the Dice instance to be returned.
     * @return        A Dice instance.
     */
    public Dice getDie (int i)
    {
        return die[i];
    }

    /**
     * Rolls all of the Dice in the Dice array.
     */
    public void rollDice ( )
    {
        for (int i = 0; i < die.length; i++)
        {
            die[i].roll();
        }
    }

    /**
     * Rolls some of the Dice in the array, and does not roll Dice indicated by the String parameter.
     *
     * @param rawHold  String indicating the Dice to be "held" (not to be rolled)
     */
    public void rollDice (String rawHold)
    {
        for (int i = 0; i < die.length; i++)
        {
            boolean doRoll = true;
            for (int j = 0; j < rawHold.length(); j++)
            {
                if ((int)rawHold.charAt(j) - 48 == (i+1))
                {
                    doRoll = false;
                }
            }
            if (doRoll)
            {
                die[i].roll();
            }
        }
    }

    /**
     * Returns the sum of the Dice values ("showing" on the Dice).
     *
     * @return         The sum of the Dice values.
     */
    public int getTotal ( )
    {
        int sum = 0;
        for (int i = 0; i < die.length; i++)
        {
            sum += die[i].getValue();
        }
        return sum;
    }

    /**
     * Print the Dice values, in a row of ASCII art, to the terminal window.
     */
    public void printDice ( )
    {
        printDiceHeadings();

        for (int row = 0; row < 6; row++)
        {
            System.out.print(" ");
            for (int diceindex = 0; diceindex < die.length; diceindex++)
            {
                    findAndPrintCorrectLine(row,diceindex);
            }
            System.out.println();
        }
        System.out.println();
    }

    /**
     * Prints the "index" values for the Dice in the array (offset by 1, so starting at 1, not 0).
     */
    public void printDiceHeadings ( )
    {
        System.out.println();
        for (int i = 0; i < die.length; i++)
        {
            System.out.print("    # " + (i+1) + "       ");
        }
        System.out.println();
    }

    /**
     * Opens the text file "dice.txt" and finds the correct line to be displayed for the
     * portion of the Dice value to be shown.
     *
     * @param row        The row (of 7) to be displayed for this Dice value.
     * @param diceindex  the index of the Dice array element.
     */
    public void findAndPrintCorrectLine (int row, int diceindex)
    {
        int composite = 7 * row + die[diceindex].getValue();
        int linenum = getLineNumber(composite);
        String line = new String("");

        Scanner infile = OpenFile.openToRead("dice.txt");
        for (int filerow = 0; filerow < linenum; filerow++)
        {
            line = infile.nextLine();
        }
        System.out.print(line + "     ");
        infile.close();
    }

    /**
     * Does some math to get the correct line from the text file.
     *
     * @return         The line number to be taken from the text file.
     */
    public int getLineNumber (int value)
    {
        if (value < 14)
            return value / 7 + 1;
        else
        {
            switch(value)
            {
                case 15: case 23: case 25: case 29:
                    return 2;
                case 18: case 19: case 20: case 27: case 32: case 33: case 34:
                    return 3;
                case 22: case 24: case 26:
                    return 4;
                case 16: case 17:
                    return 5;
                case 30: case 31:
                    return 6;
                default:  // for value >= 35
                    return 7;
            }
        }
    }
}

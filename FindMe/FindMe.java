/**
* FindMe.java
* e            d            i            t        h    e    r    e
* @author Surya Dantuluri
* @version 1.0
* @since 9/21/2017
*/
public class FindMe
{
  /**  The int array containing the random "master" key. These are to be filled with random numbers from 1 to 9.  */
  private int [] master;

  /**  The int array used to store the user's guesses.  */
  private int [] guess;

  /**  If this boolean is set to true, then the master key should be shown at each turn.  Otherwise the master is not shown until the end. */
  private boolean show;

  /**
  *  Sets up and runs FindMe.
  *  @param  args     An array of String arguments (the first element,
  *                   at index 0, could be used.  If the user enters
  *                   "show" then the MASTER KEY should be printed
  *                   before every user turn).
  */
  public FindMe ( )
  {
    //  Set up the field variables.
    Dice dice1 = new Dice(8);
    //master = new int[] {dice1.roll()+1,dice1.roll()+1,dice1.roll()+1,dice1.roll()+1};
    master = new int[] {6,1,5,5};
    guess = new int[4];
  }

  public static void main(String [] args)
  {
    FindMe run = new FindMe();
    if(args.length > 0)
    {
      run.setShow(args[0]);
    }
    run.instructions();
    run.play();
  }

  public void setShow(String str)
  {
    if(str.equalsIgnoreCase("show"))
    {
      show = true;
    }
  }

  public void instructions ( )
  {
    System.out.println("\n\n\n");
    System.out.println(" _____ _           _ __  __");
    System.out.println("|  ___(_)_ __   __| |  \\/  | ___");
    System.out.println("| |_  | | '_ \\ / _` | |\\/| |/ _ \\");
    System.out.println("|  _| | | | | | (_| | |  | |  __/");
    System.out.println("|_|   |_|_| |_|\\__,_|_|  |_|\\___|\n");
    System.out.println("Welcome to the game of FINDME (TM).  In this game, an array of 4 ints (the master array)");
    System.out.println("is filled with random numbers from 1 to 9.  The goal of the game is to guess these random");
    System.out.println("numbers, in order.  The user is prompted to enter a 4-digit number, and the input is");
    System.out.println("checked to make sure it is within the range from 1000 to 9999, and contains no 0's.  Then,");
    System.out.println("the user is informed of the number of exact digit matches, and the number of partial digit");
    System.out.println("matches.  For these matches, exact + partial may not exceed 4, because a match may be exact");
    System.out.println("or it may be partial, but it cannot be both.  The user continues to make guesses until four");
    System.out.println("exact matches are made.  Once the puzzle is solved, the game ends, with an exit message,");
    System.out.println("informing the user of how many guesses it took to find the pattern. See the sample run");
    System.out.println("outputs for detailed formatting information.");
    System.out.println("\n  THE MASTER KEY HAS BEEN CHOSEN.  LET THE GAME BEGIN . . .\n\n\n");
  }

  public void play ( )
  {
    //  This method should have a loop, and it should call the methods necessary to
    //  play the game.  This method should not be too long.
    int numberOfGuesses = 0;
    while(calculateExactMatches()!=4)
    {
      getInput();
      showStatus();
      numberOfGuesses++;
    }
    exitMessage(numberOfGuesses);
  }
  public void getInput()
  {
    if(show)
    System.out.printf("\nHERE IS THE MASTER KEY: %d%d%d%d\n",master[0],master[1],master[2],master[3]);
    int guessedNumber = Prompt.getInt("Please enter an integer value, with no zero digits (from 1000 to 9999): ",1000,9999);
    guess[0]=(guessedNumber/1000)%10;
    guess[1]=(guessedNumber/100)%10;
    guess[2]=(guessedNumber/10)%10;
    guess[3]=guessedNumber%10;
    while(guess[0]==0||guess[1]==0||guess[2]==0||guess[3]==0)
    {
       guessedNumber = Prompt.getInt("Please enter an integer value, with no zero digits (from 1000 to 9999): ",1000,9999);
      guess[0]=(guessedNumber/1000)%10;
      guess[1]=(guessedNumber/100)%10;
      guess[2]=(guessedNumber/10)%10;
      guess[3]=guessedNumber%10;
    }
  }
  public void showStatus()
  {
    System.out.printf("\nYOUR GUESS     : %d%d%d%d\n",guess[0],guess[1],guess[2],guess[3]);
    System.out.printf("Exact Matches  : %d\n",calculateExactMatches());
    System.out.printf("Partial Matches: %d\n\n",calculatePartialMatches()-calculateExactMatches());
  }

  public int calculateExactMatches()
  {
    int count = 0;
    for(int i = 0;i<4;i++)
    {
      if(master[i]==guess[i])
      count++;
    }
    return count;
  }

  public int calculatePartialMatches()
  {
    int count = 0;
    for(int i = 0;i<4;i++)
    {
      for(int j = 0;j<4;j++)
      {
        if(master[i]==guess[j]&&i!=j)
        {
          System.out.println("masteri: "+master[i]+"i: "+i);
          System.out.println("masterj: "+master[j]+"j: "+j);
          System.out.println("guess: "+guess[j]);
          j=4;
          if(master[i-2]==2)
          {
            System.out.println("HEllo there jake paulers!");
            count++;
          }

        }

      }
    }
    return count;
  }

  /**
  *  Write the methods necessary to solve the stated problem.  Be sure to keep
  *  your methods relatively small and concise.
  */

  public void exitMessage(int count)
  {

    System.out.println("Congratulations! You found the master key.");
    System.out.println("\n    +-------------+");
    System.out.println("    |   " + master[0] + " " + master[1] + " " + master[2] + " " + master[3] + "   |");
    System.out.println("    +-------------+\n");
    System.out.println("It took you "+count+" guesses to find it.");
    System.out.println("Goodbye for now, and please play again . . . \n\n\n");
    //  This method has been started for you, but it needs to be completed.

  }
}

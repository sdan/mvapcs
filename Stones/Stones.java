/**
* Stones.java
* This program will print out 3 rows, each with a random number of "stones" (3-10).
* The program will then invite the user to choose a row (1, 2, or 3, error checked),
* then a number of Stones (error checked).  It will show the new "gameboard" and have
* the user hit the enter key for the computer to take it's turn.  The game
* continues until all the Stones are gone.  The player to remove the last Stone(s)
* loses!  If there are no more Stones in a row, then the player can't choose that row!
*/
public class Stones
{
  /** Number of stones in each pile.  */
  private int pile1, pile2, pile3;
  /** Toggle for player's turn (playing against the computer).  */
  private boolean playerTurn;
  /** Boolean to determine if game is done (no stones left).  */
  private boolean done;
  /** Name of player.  */
  private String name;
  private Dice piles;
  private boolean zeroSum;
  private int stonesRemove;
  /** Setup field variables, placing from 3 to 10 stones (at random)
  *  in each pile.  Have the user (player) go first against the
  *  computer, and assume that the game has not ended yet (done set
  *  to false
  */
  public Stones ( )
  {
    piles = new Dice(8);
    pile1 = piles.roll() +2;
    pile2 = piles.roll() +2;
    pile3 = piles.roll() +2;

    playerTurn = true;
    done = false;
  }
  /** Play the game.  */
  public static void main (String [] args)
  {
    Stones game = new Stones();
    game.intro();
    game.play();
    game.printWinner();
  }
  /** Introduction, providing the rules, and prompting the player (user) to enter his/her name.  */
  public void intro ( )
  {
    System.out.println("\n        **************************************************************************");
    System.out.println("        * Welcome to the GAME OF STONES(TM)!                                     *");
    System.out.println("        * The Game of Stones(TM) is played between the user and the computer.    *");
    System.out.println("        * First, your program will create 3 piles of stones, with each pile      *");
    System.out.println("        * containing between 3 and 10 stones (the Dice class is used to choose   *");
    System.out.println("        * random values).  Then, the user and the computer will take turns       *");
    System.out.println("        * removing stones from the piles.  The user will always go first.  The   *");
    System.out.println("        * player (user) must choose the pile (1, 2, or 3), and then the number   *");
    System.out.println("        * of stones in the pile to remove (from 1 to the number of stones        *");
    System.out.println("        * remaining in the pile).  Of course, if no stones remain in a pile,     *");
    System.out.println("        * then it is not possible for stones to be removed from that pile.  The  *");
    System.out.println("        * Prompt class is used to get this user input.  The player and the       *");
    System.out.println("        * computer alternate turns until no stones remain.  THE LOSER IS THE     *");
    System.out.println("        * LAST PLAYER TO TAKE A TURN (REMOVING THE LAST STONE).                  *");
    System.out.println("        **************************************************************************");
    System.out.println("\n        GOOD LUCK!\n");
    do
    {
      name = Prompt.getString("Player, please enter your name: ");
    }
    while(name.equals(""));
  }
  /** Plays the game, alternating between the user and the "computer".  When all of the
  *  "rows" have zero stones, the boolean done should be set to true, and the loop will
  *  come to an end.
  */
  public void play()
  {
    while (!done)
    {
      showTable();
      playerMakeChoice();
      if(!done)
      {
        showTable();
        playerTurn = !playerTurn;
        computerMakeChoice();
        if(!done)
        {
          playerTurn = !playerTurn;
        }
      }
    }
  }
  /**  Uses printf to print the stones (represented by O's) in the three rows.  */
  public void showTable()
  {
    System.out.printf("\nPile 1 - %2d STONES: ", pile1);
    for(int i = 0; i < pile1; i++)
    {
      System.out.print("O ");
    }
    System.out.printf("\nPile 2 - %2d STONES: ", pile2);
    for(int i = 0; i < pile2; i++)
    {
      System.out.print("O ");
    }
    System.out.printf("\nPile 3 - %2d STONES: ", pile3);
    for(int i = 0; i < pile3; i++)
    {
      System.out.print("O ");
    }

  }
  /** The player chooses the pile number, and then the number of stones to remove from
  *  the chosen row.  The input from the user should be checked.
  */
  public void playerMakeChoice()
  {
    int removeFromPile = 0;
    int pileSelect = Prompt.getInt("\n\n"+name+", please enter a pile number (1, 2, or 3): ",1,3);
    switch(pileSelect)
    {
      case 1:  removeFromPile = Prompt.getInt("\n\n"+name+", please enter the number of stones to remove in pile 2 (from 1 to "+pile1+"): ",1,pile1);
               pile1 = pile1-removeFromPile;
      break;
      case 2:  removeFromPile = Prompt.getInt("\n\n"+name+", please enter the number of stones to remove in pile 2 (from 1 to "+pile2+"): ",1,pile2);
               pile2 = pile2-removeFromPile;
      break;
      case 3:  removeFromPile = Prompt.getInt("\n\n"+name+", please enter the number of stones to remove in pile 2 (from 1 to "+pile3+"): ",1,pile3);
               pile3 = pile3-removeFromPile;
      break;
    }
    System.out.print("\n"+name+" removed " + removeFromPile + " stone(s) from Pile "+pileSelect);
    if(pile1==0&&pile2==0&&pile3==0)
    done = true;
  }
  /** The "computer" chooses a row and removes stones from this chosen row.  This can be a simple, "dumb"
  *  removal (the method needs to make a valid choice, but it does not need to be a smart choice).  For
  *  up to 3 extra credit points, use an algorithm to make better choices for this method.
  */
  public void computerMakeChoice()
  {
      //greedy optimized
    Prompt.getString("It's the computer's turn. Please hit enter to continue: \n\n");
    System.out.println("\n\ncomputer turn");
    if(pile1==0&&pile2==0&&pile3==0)
    done = true;
    else
    {
      int currentSum = nimSum(pile1,pile2,pile3);
      System.out.println("currentsum"+currentSum);
      if(currentSum>0)
      {
        int maxPile =  Math.max(Math.max(pile1,pile2),pile3);
        //call nimZero 8 times?
        while(zeroSum=false)
        {
          stonesRemove++;
          zeroSum = nimZero(pile1,pile2,pile3,stonesRemove);

        }

      }
    }


  }
    public int nimSum(int pile1, int pile2, int pile3)
    {
      int xorPile1Pile2 = pile1^pile2;
      int xorAllPiles = xorPile1Pile2^pile3;
      return xorAllPiles;
    }
    public boolean nimZero(int pile1, int pile2, int pile3, int stonesRemoved)
    {
      if(nimSum(pile1-stonesRemoved,pile2,pile3)==0)
      {
        pile1 = pile1-stonesRemoved;
        return true;
      }
      else if(nimSum(pile1,pile2-stonesRemoved,pile3)==0)
      {
        pile2 = pile2-stonesRemoved;
        return true;
      }
      else if(nimSum(pile1,pile2,pile3-stonesRemoved)==0)
      {
        pile3 = pile3-stonesRemoved;
        return true;
      }
      else
      return false;

    }

//nim sum should equal 0.
// A B C nim-sum
//
// 3 4 5 0102=210   I take 2 from A, leaving a sum of 000, so I will win.
// 1 4 5 0002=010   You take 2 from C
// 1 4 3 1102=610   I take 2 from B
// 1 2 3 0002=010   You take 1 from C
// 1 2 2 0012=110   I take 1 from A
// 0 2 2 0002=010   You take 1 from C
// 0 2 1 0112=310   The normal play strategy would be to take 1 from B, leaving an even number (2)
//                  heaps of size 1.  For misère play, I take the entire B heap, to leave an odd
//                  number (1) of heaps of size 1.
// 0 0 1 0012=110   You take 1 from C, and lose.





  /** You may create other methods, used by playerMakeChoice and computerMakeChoice.  Be sure to
  *  comment each new method you create.
  */
  /** Shows the table, then tells the user who won, followed by an exit message.  */
  public void printWinner()
  {
    showTable();
    if(playerTurn)
    {
        System.out.println("\nYOU ARE THE WINNER!");
        System.out.println("\nTHANK YOU FOR PLAYING THE GAME OF STONES (TM)");
        System.out.print("\n\n\n");
    }
    else
    {
        System.out.println("\nYOU ARE THE WINNER!");
        System.out.println("\nTHANK YOU FOR PLAYING THE GAME OF STONES (TM)");
        System.out.print("\n\n\n");
    }


  }
}

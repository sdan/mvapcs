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


    int calculateNimSum(int piles[], int n)
    {
        int i, nimsum = piles[0];
        for (i=1; i<n; i++)
            nimsum = nimsum ^ piles[i];
        return(nimsum);
    }


    int i, nim_sum = calculateNimSum(piles, n);

    // The player having the current turn is on a winning
    // position. So he/she/it play optimally and tries to make
    // Nim-Sum as 0
    if (nim_sum != 0)
    {
        for (i=0; i<n; i++)
        {
            // If this is not an illegal move
            // then make this move.
            if ((piles[i] ^ nim_sum) < piles[i])
            {
                (*moves).pile_index = i;
                (*moves).stones_removed =
                                 piles[i]-(piles[i]^nim_sum);
                piles[i] = (piles[i] ^ nim_sum);
                break;
            }
        }
    }

    // The player having the current turn is on losing
    // position, so he/she/it can only wait for the opponent
    // to make a mistake(which doesn't happen in this program
    // as both players are playing optimally). He randomly
    // choose a non-empty pile and randomly removes few stones
    // from it. If the opponent doesn't make a mistake,then it
    // doesn't matter which pile this player chooses, as he is
    // destined to lose this game.

    // If you want to input yourself then remove the rand()
    // functions and modify the code to take inputs.
    // But remember, you still won't be able to change your
    // fate/prediction.
    else
    {
        // Create an array to hold indices of non-empty piles
        int non_zero_indices[n], count;

        for (i=0, count=0; i<n; i++)
            if (piles[i] > 0)
                non_zero_indices [count++] = i;

        (*moves).pile_index = (rand() % (count));
        (*moves).stones_removed =
                 1 + (rand() % (piles[(*moves).pile_index]));
        piles[(*moves).pile_index] =
         piles[(*moves).pile_index] - (*moves).stones_removed;

        if (piles[(*moves).pile_index] < 0)
            piles[(*moves).pile_index]=0;
    }
    return;
  }


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

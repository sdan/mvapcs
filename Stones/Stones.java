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
  /** Defines objects used to assign random values for decision making and initial heap generaption */
  private Dice piles, whichPile, randPile1, randPile2, randPile3;

  /** Setup field variables, placing from 3 to 10 stones (at random)
  *  in each pile.  Have the user (player) go first against the
  *  computer, and assume that the game has not ended yet (done set
  *  to false
  */
  public Stones ( )
  {
    /** Instantiation of Dice class */
    piles = new Dice(8);
    /** Invokes Dice object for random heap values */
    pile1 = piles.roll() +2;
    pile2 = piles.roll() +2;
    pile3 = piles.roll() +2;
    /** Creates more Dice objects */
    whichPile = new Dice(3);
    randPile1 = new Dice(pile1-1);
    randPile2 = new Dice(pile2-1);
    randPile3 = new Dice(pile3-1);

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
    System.out.println("\n");
    if(pile1==0&&pile2==0&&pile3==0)
    {
      done = true;
    }
  }
  /** The player chooses the pile number, and then the number of stones to remove from
  *  the chosen row.  The input from the user should be checked.
  */
  public void playerMakeChoice()
  {
    int removeFromPile =0;
    int pileSelect = 0;
    do
    {
      pileSelect = Prompt.getInt(name+", please enter a pile number (1, 2, or 3): ",1,3);
    } while((pileSelect==1&&pile1==0)||(pileSelect==2&&pile2==0)||(pileSelect==3&&pile3==0));
    System.out.println("pileSelect"+pileSelect);
    System.out.print("\n");
    switch(pileSelect)
    {
      case 1:  removeFromPile = Prompt.getInt(name+", please enter the number of stones to remove in pile "+pileSelect+" (from 1 to "+pile1+"): ",1,pile1);
      pile1 = pile1-removeFromPile;
      break;
      case 2:  removeFromPile = Prompt.getInt(name+", please enter the number of stones to remove in pile "+pileSelect+" (from 1 to "+pile2+"): ",1,pile2);
      pile2 = pile2-removeFromPile;
      break;
      case 3:  removeFromPile = Prompt.getInt(name+", please enter the number of stones to remove in pile "+pileSelect+" (from 1 to "+pile3+"): ",1,pile3);
      pile3 = pile3-removeFromPile;
      break;
    }
    System.out.print("\n"+name+" removed " + removeFromPile + " stone(s) from Pile "+pileSelect+"\n");
    if(pile1==0&&pile2==0&&pile3==0)
    done = true;
  }
  /** The "computer" chooses a row and removes stones from this chosen row.  This can be a simple, "dumb"
  *  removal (the method needs to make a valid choice, but it does not need to be a smart choice).  For
  *  up to 3 extra credit points, use an algorithm to make better choices for this method.
  */
  public void computerMakeChoice()
  {
    Prompt.getString("It's the computer's turn. Please hit enter to continue: ");

    int[] computerHeap = nimZero(pile1,pile2,pile3);
    pile1 = computerHeap[0];
    pile2 = computerHeap[1];
    pile3 = computerHeap[2];
    System.out.println("\nThe computer removed "+computerHeap[4]+" stone(s) from Pile "+computerHeap[3]);

  }

  public int nimSum(int pile1, int pile2, int pile3, int xorTimes)
  {
    if(xorTimes==3)
    {
      int xorPile1Pile2 = pile1^pile2;
      int xorAllPiles = xorPile1Pile2^pile3;
      return xorAllPiles;
    }
    else if(xorTimes==2)
    {
      return pile1^pile2;
    }
    return 0;
  }

  /** Robust method that calculates best possible move
  * to win the Nim game against another player
  *  @param pile1       The String prompt to be displayed to the user.
  *  @param pile2       The minimum integer value to be allowed as input.
  *  @param pile3       The maximum integer value to be allowed as input.
  *  @return            Integer array of 5 that stores updated heap values as well as
  */
  public int[] nimZero(int pile1, int pile2, int pile3)
  {
    int[] heap = new int[5];
    int nimSumValue = nimSum(pile1,pile2,pile3,3);//X
    int pile1Xor = nimSum(pile1,nimSumValue,0,2);
    int pile2Xor = nimSum(pile2,nimSumValue,0,2);
    int pile3Xor = nimSum(pile3,nimSumValue,0,2);
    if(pile1<=2||pile2<=2||pile3<=2)
    {
      System.out.println("NOTICE ME IM UNDER 2");
      for(int i = 0;i<=pile1;i++)
      {
        System.out.println("i"+i);
        for(int j=0;j<=pile2;j++)
        {
          System.out.println("j"+i);
          for(int k=0;k<=pile3;k++)
          {
            System.out.println("k"+k);
            int finalNimSum = nimSum(i,j,k,3);
            if(((i!=pile1)&&(j==pile2)&&(k==pile3))||((j!=pile2)&&(i==pile1)&&(k==pile3))||((k!=pile3)&&(i==pile1)&&(j==pile2)))
            {
              System.out.printf("\n%d,%d,%d,bb%d",i,a,b,bb);
              if(finalNimSum==1)
              {
                System.out.println("finalsum: "+finalNimSum+"awak");
                if(pile1Changed)
                {
                  heap[3] = 1;
                  heap[4] = pile1-i;
                }
                else if(pile2Changed)
                {
                  heap[3] = 2;
                  heap[4] = pile2-j;
                }
                else if(pile3Changed)
                {
                  heap[3] = 3;
                  heap[4] = pile3-k;
                }
                heap[0] = i;
                heap[1] = j;
                heap[2] = k;
                System.out.print("heapy"+heap[0]+heap[1]+heap[2]);
                return heap;
              }
            }

          }
        }

      }
    }
    if(pile1Xor<pile1)
    {
      heap[0] = pile1Xor;
      heap[1] = pile2;
      heap[2] = pile3;
      heap[3] = 1;
      heap[4] = pile1-pile1Xor;
    }
    else if(pile2Xor<pile2)
    {
      heap[0] = pile1;
      heap[1] = pile2Xor;
      heap[2] = pile3;
      heap[3] = 2;
      heap[4] = pile2-pile2Xor;
    }
    else if(pile3Xor<pile3)
    {
      heap[0] = pile1;
      heap[1] = pile2;
      heap[2] = pile3Xor;
      heap[3] = 3;
      heap[4] = pile3-pile3Xor;
    }
    else
    {
      int somePile = whichPile.roll();
      switch(somePile)
      {
        case 1:
        heap[0] = randPile1.roll();
        heap[1] = pile2;
        heap[2] = pile3;
        heap[3] = 1;
        heap[4] = pile1-randPile1.getValue();
        break;
        case 2:
        heap[0] = pile1;
        heap[1] = randPile2.roll();
        heap[2] = pile3;
        heap[3] = 2;
        heap[4] = pile2-randPile2.getValue();
        break;
        case 3:
        heap[0] = pile1;
        heap[1] = pile2;
        heap[2] = randPile3.roll();
        heap[3] = 3;
        heap[4] = pile3-randPile3.getValue();
        break;
      }
    }
    return heap;
  }

  /** You may create other methods, used by playerMakeChoice and computerMakeChoice.  Be sure to
  *  comment each new method you create.
  */
  /** Shows the table, then tells the user who won, followed by an exit message.  */
  public void printWinner()
  {
    showTable();
    if(!playerTurn)
    {
      System.out.println("\nYOU ARE THE WINNER!");
      System.out.println("\nTHANK YOU FOR PLAYING THE GAME OF STONES (TM)");
      System.out.print("\n\n\n");
    }
    else
    {
      System.out.println("\nTHE COMPUTER IS THE WINNER!");
      System.out.println("\nTHANK YOU FOR PLAYING THE GAME OF STONES (TM)");
      System.out.print("\n\n\n");
    }


  }
}

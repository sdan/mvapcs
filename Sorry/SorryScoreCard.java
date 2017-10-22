/**
 * SorryScoreCard.java
 * Prints out current standing of both player's pieces.
 * Uses a player object parameter to move pieces,
 * and to display the current position of both players.
 * No constructors are included.
 * 
 * @author Surya Dantuluri
 * @version 1.0
 * @since 10/22/2017
 */

public class SorryScoreCard
{
  public void printScoreCardHeading ( )
  {
    System.out.println("\n  NAME               1   2   3   4   5   6   7   8   9  10  11  12  13  14  15  16  17  18  19  20");
    System.out.println("+--------------------------------------------------------------------------------------------------+");
  }
  //  To be used in SorryScoreCard.java
  public void printPlayerStatus (SorryPlayer sp)
  {
    if (sp.getName().length() <= 12)
    {
      System.out.printf("| %-12s",sp.getName());
    }
    else
    {
      System.out.printf("| %-12s",sp.getName().substring(0,12));
    }
    System.out.print(" ");
    if(sp.getPieceArrayElement(0) == 0)
    {
      System.out.print("a");
    }
    else
    {
      System.out.print(" ");
    }
    if(sp.getPieceArrayElement(1) == 0)
    {
      System.out.print("b");
    }
    else
    {
      System.out.print(" ");
    }
    if(sp.getPieceArrayElement(2) == 0)
    {
      System.out.print("c");
    }
    else
    {
      System.out.print(" ");
    }
    System.out.print(" |");
    for (int i = 1; i <= 20; i++)
    {
      if (i == sp.getPieceArrayElement(0))
      {
        System.out.printf(" a |");
      }
      else if (i == sp.getPieceArrayElement(1))
      {
        System.out.printf(" b |");
      }
      else if (i == sp.getPieceArrayElement(2))
      {
        System.out.printf(" c |");
      }
      else
      {
        System.out.print("   |");
      }
    }
    System.out.print(" ");
    if(sp.getPieceArrayElement(0) > 20)
    {
      System.out.print("a");
    }
    if(sp.getPieceArrayElement(1) > 20)
    {
      System.out.print("b");
    }
    if(sp.getPieceArrayElement(2) > 20)
    {
      System.out.print("c");
    }
    System.out.println("\n+--------------------------------------------------------------------------------------------------+");
  }
  public void movePieces(SorryPlayer sp, DiceGroup dice, String order)
  {
    for(int i = 0;i<3;i++)
    {
      switch(order.charAt(i))
      {
        case 'a': sp.setScoreArrayElement(0,dice.getDie(i).getValue());
          break;
        case 'b': sp.setScoreArrayElement(1,dice.getDie(i).getValue());
          break;
        case 'c': sp.setScoreArrayElement(2,dice.getDie(i).getValue());
          break;
      }
    }
  }
}

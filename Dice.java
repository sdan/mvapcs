//  Surya Dantuluri
//  8/16/2017
//  Dice.java
//  Simulates a single die.  The die
//  has a number of sides, and it
//  will keep a roll count.  The die
//  also has a face value.  This
//  face value and the rollcount are
//  accessible by calling methods.

public class Dice
{
  //Number of sides of the Dice
  private int sides;
  //Number of times the Dice has been rolled
  private int rollCount;
  //Last rolled value of the Die
  private int faceValue;

  //Establishes Dice object with 6 sides, roll count and value set to 0
  public Dice()
  {
    sides = 6;
    rollCount = 0;
    faceValue = 0;
  }
}

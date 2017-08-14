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
  //Overoading constructor
  public Dice(int sideValue)
  {
    sides = n;
		rollCount = 0;
		faceValue = 0;
  }
//Simulates rolling die (the dice object) adds 1 to the roll count and the faceValue is set to some random number from 1 to the number of sides the dice have
public int roll()
{
  rollCount++;
  faceValue = (int)(Math.random()*sides)+1;
  return faceValue;
}
//Fetches roll count
//@return           Current roll count;
public int getRollCount()
{
  return rollCount;
}
//Fetches face value
//@return           Face value
public int getFaceValue()
{
  return faceValue;
}




}

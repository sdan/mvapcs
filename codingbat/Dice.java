public class Dice
{
  private int numSides;
  private int rollCount;
  private int value;

  public Dice()
  {
    int numSides = 6;
    int rollCount = 0;
    int value = -1;
  }

  public Dice(int n)
  {
    int numSides = n;
    int rollCount = 0;
    int value = -1;
  }

  public int roll()
  {
    value = (int)(Math.random()*numSides)+1;
    return value;
  }

  public int getRollCount()
  {
    return rollCount;
  }

  public int getValue()
  {
    return value;
  }
}

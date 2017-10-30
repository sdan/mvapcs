public class Chapter9
{
  private int num;
  private int denom;
  public Chapter9(Chapter9 other)//copy constructor
  {
    num = other.num;
    denom = other.denom;
  }
  public Chapter9 add(Chapter9 other)
  {
    int newNum = num*other.denom+denom*other.num;
    int newDenom = denom*other.denom;
    return new Fraction(newNum, newDenom);
  }
}

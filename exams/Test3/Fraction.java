// Represents a fraction with an int numerator and int denominator
// and provides methods for adding and multiplying fractions.
public class Fraction
{
  // *** instance variables ***
  private int num;
  private int denom;

  // *** Constructors ***
  public Fraction()       // no-args constructor
  {
    num = 0;
    denom = 1;
  }

  public Fraction(int n)
  {
    num = n;
    denom = 1;
  }

  public Fraction(int n, int d)
  {
    if (d != 0)
    {
      num = n;
      denom = d;
      reduce();
    }
    else
    {
      throw new IllegalArgumentException(
      "Fraction construction error: denominator is 0");
    }
  }

  public Fraction(Fraction other)  // copy constructor
  {
    num = other.num;
    denom = other.denom;
  }

  // *** public methods ***

  public static void main(String [] args)
  {
    System.out.println("\n\n");
    Fraction f1 = new Fraction();
    Fraction f2 = new Fraction(7);
    Fraction f3 = new Fraction(12, -20);
    Fraction f4 = new Fraction(f3);
    System.out.println("f1 = " + f1);
    System.out.println("f2 = " + f2);
    System.out.println("f3 = " + f3);
    System.out.println("f4 = " + f4);
    System.out.println();

    Fraction f5 = new Fraction(1, 2);
    Fraction f6 = new Fraction(4, 7);
    Fraction sum = f5.add(f6);
    System.out.println(f5 + " + " + f6 + " = " + sum);
    Fraction product = f5.multiply(f6);
    System.out.println(f5 + " * " + f6 + " = " + product);
    System.out.println();

    Fraction f7 = new Fraction(2, 3);
    System.out.println(f7 + " = " + f7.getValue());
    System.out.println("\n\n");
  }

  // Returns the sum of this fraction and other
  public Fraction add(Fraction other)
  {
    int newNum = num * other.denom + denom * other.num;
    int newDenom = denom * other.denom;
    return new Fraction(newNum, newDenom);
  }

  // Returns the sum of this fraction and m
  public Fraction add(int m)
  {
    return new Fraction(num + m * denom, denom);
  }

  // Returns the product of this fraction and other
  public Fraction multiply(Fraction other)
  {
    int newNum = num * other.num;
    int newDenom = denom * other.denom;
    return new Fraction(newNum, newDenom);
  }

  // Returns the product of this fraction and m
  public Fraction multiply(int m)
  {
    return new Fraction(num * m, denom);
  }

  public boolean isGreaterThan(Fraction other)
  {
    return (double)num/denom > (double)other.num/other.denom;
  }

  // Returns the value of this fraction as a double
  public double getValue()
  {
    return (double)num / (double)denom;
  }

  // Returns a string representation of this fraction
  public String toString()
  {
    return num + "/" + denom;
  }

  // *** private methods ***

  // Reduces this fraction by the gcf and makes denom > 0
  private void reduce()
  {
    if (num == 0)
    {
      denom = 1;
      return;
    }
    if (denom < 0)
    {
      num = -num;
      denom = -denom;
    }
    int q = gcf(Math.abs(num), denom);
    num /= q;
    denom /= q;
  }

  //  Returns the greatest common factor of two positive integers
  private int gcf(int n, int d)
  {
    if (n <= 0 || d <= 0)
    {
      throw new IllegalArgumentException(
      "gcf precondition failed: " + n + ", " + d);
    }
    if (n % d == 0)
    {
      return d;
    }
    else if (d % n == 0)
    {
      return n;
    }
    else
    {
      return gcf(n % d, d % n);
    }
  }


  public Fraction divide(Fraction other)
  {
    return new Fraction(num * other.denom, denom * other.num);
  }

}

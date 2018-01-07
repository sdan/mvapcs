/**
* Primes.java
* Just for fun.
* @author Surya Dantuluri
* @version 1.0
* @since 1/9/2018
*/

import java.util.Scanner;

public class Primes
{
  private int [][] numbers;

  private final int ROWS = 10;

  public Primes()
  {
    numbers = new int [ROWS][ROWS];
  }
  public static void main(String[]args)
  {
    Primes num = new Primes();
    num.run();

  }

  public void run()
  {
    Scanner input = new Scanner(System.in);
    System.out.print("Please enter the value of the maximum possible prime (9 - 9999) -> ");
    int num = input.nextInt();
    System.out.println("Here is your list of "+calculate(num)+" primes: ");
  }

  public int calculate(int num)
  {
    return 0;
  }

  public void print()
  {
    for (int i = 0;i<numbers.length;i++) {
      System.out.print(i+" |   ");
      for(int j = 0;j<numbers[0].length;j++){
        System.out.print(numbers[i][j]+"  ");
      }
      System.out.println("");
    }
  }
}

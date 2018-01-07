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
    numbers = new int [(num/10)+1][10];
    for (int i = 0;i<numbers.length;i++) {
      for (int j = 0;j<numbers[0].length;j++) {
        if(i==0&&j==1)
        numbers[i][j]=0;
        else
        numbers[i][j] = i*10+j;
      }
    }
    System.out.println("Here is your list of "+calculate(num)+" primes: ");
    print();
  }

  public int calculate(int num)
  {
    int r = 0;
    int c = 0;
    for (int i = 2;i*i<=num;i++) {
      for (int j = i*2;j<=num;j+=i) {
        c=j%10;
        r=j/10;
        //System.out.println("r "+r+" c "+c);
        //System.out.println("j "+j);
        numbers[r][c] = 0;
      }
    }
    int count = 0;
    for (int i = 0;i<numbers.length;i++) {
      for (int j = 0;j<numbers[0].length;j++) {
        if(numbers[i][j]!=0)
        count++;
      }
    }
    return count;
  }

  public void print()
  {
    for (int i = 0;i<numbers.length;i++) {
      System.out.print(i+" |   ");
      for(int j = 0;j<numbers[0].length;j++){
        if(numbers[i][j]!=0)
        System.out.print(numbers[i][j]+"  ");
        else
        System.out.print("   ");
      }
      System.out.println("");
    }
  }
}

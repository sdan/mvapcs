import java.util.Scanner;

public class test
{
  public test ( )
  {
  }
  public static void main(String []args)
  {
    Scanner keyboard = new Scanner(System.in);
		 int pile1 = keyboard.nextInt();
     int pile2 = keyboard.nextInt();
     int pile3 = keyboard.nextInt();


    int hello = pile1^pile2;
    System.out.println("hello"+hello);
    int bye = pile3^hello;
    System.out.println("bye"+bye);
//backtracking
// for 0
// for 0
//for 1 and 2
    for(int i = 0;i<=pile1;i++)
    {
      for(int a=0;a<=pile2;a++)
      {
        for(int b=0;b<=pile3;b++)
        {
          int bb = nimSum(i,a,b,3);
          if(((i!=pile1)&&(a==pile2)&&(b==pile3))||((a!=pile2)&&(i==pile1)&&(b==pile3))||((b!=pile3)&&(i==pile1)&&(a==pile2)))
          {
            System.out.printf("\n%d,%d,%d,bb%d",i,a,b,bb);
          }
        }
      }

    }
    nimZero(pile1,pile2,pile3);
  }

  static int nimZero(int pile1, int pile2, int pile3)
  {
    int nimSumValue = nimSum(pile1,pile2,pile3,3);//X
    int pile1Xor = nimSum(pile1,nimSumValue,0,2);
    int pile2Xor = nimSum(pile2,nimSumValue,0,2);
    int pile3Xor = nimSum(pile3,nimSumValue,0,2);
    System.out.println("\nnimSumValue: "+nimSumValue);
    System.out.println("pile1Xor: "+pile1Xor);
    System.out.println("pile2Xor: "+pile2Xor);
    System.out.println("pile3Xor: "+pile3Xor);
    return 0;
  }

  static int nimSum(int pile1, int pile2, int pile3, int xorTimes)
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
}

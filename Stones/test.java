import java.util.Scanner;

public class test
{
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

  }
}

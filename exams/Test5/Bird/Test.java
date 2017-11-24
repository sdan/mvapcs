import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
public class Test
{
  int num;
  ArrayList<String> name;
  public static void main(String[]args)
  {
    num = 0;

  }
  public Test()
  {
    name = new ArrayList<String>();
  }
  public void run()
  {
    Scanner input = new Scanner(System.in);
    System.out.println("Welcome to the Turkey Game!\n");
    System.out.print("How many turkeys do you want to make? ");
    num = input.nextInt();
    System.out.println("");
    for (int i = 0;i<num;i++) {
      System.out.println("Turkey name "+i+" : ");

    }
  }
}

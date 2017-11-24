import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
public class Test
{
  int num;
  ArrayList<String> name;
  public static void main(String[]args)
  {
    Test mandm = new Test();
    mandm.run();

  }
  public Test()
  {
    num = 0;
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
      name.add(input.next());
      System.out.println("");
    }
    Bird cupertino = new Bird(num, name);
    System.out.println("\nGenerating a Turkey...");
    cupertino.generateTurkey();
    System.out.println("Setting age...");
    cupertino.age();
    System.out.println("Adjusting traits...");
    cupertino.traits();
    System.out.println("Adjusting friends...");
    cupertino.friends();
    System.out.println("Adjusting dimensions...");
    cupertino.dimensions();

  }
}

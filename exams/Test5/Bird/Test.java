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
    for (int i = 0;i<cupertino.food.size();i++) {
      System.out.println("\n\n\n");
      System.out.println("------------Turkey Stats-------------------");
      System.out.println("Name: "+cupertino.food.get(i).getName());
      System.out.println("Age: "+cupertino.food.get(i).getAge());
      System.out.println("Traits------");
      for(int j = 0;j<cupertino.food.get(i).getTraits().length;j++)
      {
        System.out.print(cupertino.food.get(i).getTraits()[j]+" ");
      }
      System.out.println("");
      System.out.println("Friends-------");
      for (int k = 0;k<cupertino.food.get(i).getFriends().size();k++) {
        System.out.print(cupertino.food.get(i).getFriends().get(k)+" ");
      }
      System.out.println("");
      System.out.println("Dimensions-----------");
      for (int l = 0;l<3;l++ ) {
        System.out.println("");
        for (int  m = 0;m<3;m++) {
          System.out.print(cupertino.food.get(i).getDimensions()[l][m]+" ");
        }
      }
      System.out.println("");
    }


  }
}

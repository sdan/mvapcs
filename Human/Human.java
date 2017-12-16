//Human.java
//Made by Sleep deprived, stressed out, and suicidal students at Monta Vista High School
//Have fun with this in depth, multi-layered game of life.
import java.util.Scanner;
interface Homonid
{
   int efficiency(String traits, int length, int lifespan, String chromosomes, String chromatids,  boolean loraApproved, boolean retarded);
   int diversity(int prophase, boolean doubleChromatid, int genes, String whoIsDaddy);
   int score(String school, int population, int income, int cancerRating, int rapeRating, boolean kochleen);
   int huntingAbility(int strength, String name, int grade, int lifespan, int raped);

}
abstract class HomoSapiens implements Homonid
{
   boolean fail(String name, char initial)
  {
    boolean failure = false;
    if(name.toLowerCase().equals("deepak")&&initial=='b')
    {
      failure = true;
      System.out.println("----------------------------------------------------------------------");
      System.out.println("ATTENTION:");
      System.out.println("This thing is a threat to society. Please discard as needed.");
      System.out.println("NO matter the chants, the insults, the jacking off, the grades, this thing");
      System.out.println("is SPREADING CANCER and AIDS throughout these species as fast as anyone can think");
      System.out.println("---------------------------------");
      System.out.println("VERDICT: FAILURE with a NEGATIVE GPA");
      System.out.println("---------------------------------");
      System.out.println("Please be mindfull of others when discarding this object. It MAY contain and radiate toxic elements through fussion, fission, and gamma radiation/decay.");
      System.out.println("----------------------------------------------------------------------");
    }
    return failure;
  }
}

public class Human extends HomoSapiens implements Homonid
{
  private int efficiency(String traits, int length, int lifespan, String chromosomes, String chromatids, boolean loraApproved, boolean retarded)
  {return 0;}
  private int diversity(int prophase, boolean doubleChromatid, int genes, String whoIsDaddy){return 0}
  private int score(String school, int population, int income, int cancerRating, int rapeRating, boolean kochleen){return 0}
  private int huntingAbility(int strength, String name, int grade, int lifespan, int raped){return 0}

  public static void main(String[]args)
  {
    Human degeneration = new Human();
    degeneration.run();
  }

  public void run()
  {
    System.out.println("Welcome!");
  }
}

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
  String name, race, school, autism, chromosomes, chromatids, whoIsDaddy;
  boolean loraApproved, retarded, doubleChromatid, kochleen, raceIsReal, mueller;
  int prophase,genes, population, income, cancerRating, rapeRating, strength, grade, lifespan, raped;
  public int efficiency(String traits, int length, int lifespan, String chromosomes, String chromatids, boolean loraApproved, boolean retarded)
  {return 0;}
  public int diversity(int prophase, boolean doubleChromatid, int genes, String whoIsDaddy){return 0;}
  public int score(String school, int population, int income, int cancerRating, int rapeRating, boolean kochleen){return 0;}
  public int huntingAbility(int strength, String name, int grade, int lifespan, int raped){return 0;}

  public static void main(String[]args)
  {
    Human degeneration = new Human();
    degeneration.run();
  }

  public Human()
  {
     name = "Deepak";
     school = "Monta Vista High School";
     autism = "Arnav";
     chromosomes = "69";
     chromatids = "Plagarism on Essay Dropped Tanabe";
     whoIsDaddy = "Ishani";
     race = "cancerous thing";
     loraApproved = false;
     retarded = true;
     doubleChromatid = false;
     kochleen = false;
      raceIsReal = true;
     prophase = 69;
     genes = 420;
     population = 9001;
     income = 100000;
     cancerRating = 1;
     rapeRating = 6900000;
     strength = 0;
     grade = 0;
     lifespan = 0;
     raped = 10;

  }

  public void printall()
  {
    System.out.println("----------------------------------------------------------------------");
    System.out.println("                  PLAYER                PROFILE");
    System.out.println("----------------------------------------------------------------------");
    System.out.println("                  NAME: "+name);
    System.out.println("                SCHOOL: "+school);
    System.out.println("  AUTISTIC FRIEND NAME: "+autism);
    System.out.println("           CHROMOSOMES: "+chromosomes);
    System.out.println("            CHROMATIDS: "+chromatids);
    System.out.println("          WHO IS DADDY: "+whoIsDaddy);
    System.out.println("                  RACE: "+race);
    System.out.println("----------------------------------------------------------------------");
    System.out.println("  LORA LERNER APPROVED: "+loraApproved);
    System.out.println("    RETARDED AT BIRTH?: "+retarded);
    System.out.println("     DOUBLE CHROMATIDS: "+doubleChromatid);
    System.out.println("  HAS OR HAD KOCHLEEN : "+kochleen);
    if(kochleen)System.out.println("you have been degenerated");
    System.out.println("   HAS OR HAD MUELLER : "+mueller);
    if(mueller)System.out.println("you have been officially raped by a teacher, congrats");
    System.out.println("BELIEVES RACE IS REAL : "+raceIsReal);
    System.out.println("----------------------------------------------------------------------");
    System.out.println("        PROPHASE LEVEL: "+prophase);
    System.out.println("                 GENES: "+genes);
    System.out.println("            POPULATION: "+population);
    System.out.println("                INCOME: "+income);
    System.out.println("          CANCER RAING: "+cancerRating);
    System.out.println("           RAPE RATING: "+rapeRating);
    System.out.println("              STRENGTH: "+strength);
    System.out.println("                 GRADE: "+grade);
    System.out.println("              LIFESPAN: "+lifespan);
    System.out.println(" NUMBER OF TIMES RAPED: "+raped);
    System.out.println("----------------------------------------------------------------------");
  }
  public void run()
  {
    System.out.println("\n\n\nWelcome to the");
    System.out.println("      ___           ___           ___           ___           ___");
    System.out.println("     /__/\'         /__/\'         /__/\'         /  /\'         /__/\'");
    System.out.println("     \'  \':\'        \'  \':\'       |  |::\'       /  /::\'        \'  \':\'   ");
    System.out.println("      \'__\':\'        \'  \':\'      |  |:|:\'     /  /:/\':\'        \'  \':\'  ");
    System.out.println("  ___ /  /::\'   ___  \'  \':\'   __|__|:|\':\'   /  /:/~/::\'   _____\'__\':\' ");
    System.out.println(" /__/\'  /:/\':\' /__/\'  \'__\':\' /__/::::| \':\' /__/:/ /:/\':\' /__/::::::::\'");
    System.out.println("  \'  \'::/       \'  \':\'  /:/   \'  \':\'        \'  \'::/       \'  \':\'  ~~~ ");
    System.out.println("   \'  \':\'        \'  \':\'/:/     \'  \':\'        \'  \':\'        \'  \':\'     ");
    System.out.println("    \'  \':\'        \'  \'::/       \'  \':\'        \'  \':\'        \'  \':\'    ");
    System.out.println("     \'__\'/         \'__\'/         \'__\'/         \'__\'/         \'__\'/    ");
    System.out.println("\ngame.\n\n Monta Vista Students as your host, and we'll be understanding your life through your choices here on the game.\n\n Keep in mind for the audience that cancer, aids, autism, rape, grades, and deepakDisease may occur while playing the game.\n\n Never play without parental supervision and always be mindfull of child predators like teachers who make sure a 89.75 is a B. \n\n\nIf rape is brought up, please be aware that this intimate experience is consensual between teacher and student when they are given the grade contract.\n\n");
    System.out.println("\nNow let's start the game.\n");

    System.out.println("What's your name?");
    Scanner keyboard = new Scanner(System.in);
		 name=keyboard.nextLine();
     if(name.toLowerCase().equals("deepak"))
     {
       System.out.println("\nWhat's your last initial, deepak?");
       if(fail(name,keyboard.next().charAt(0)))
       System.out.println("\n\n\t Currently this game ONLY supports Humans.\n\n\n");
       System.exit(2);
     }
     System.out.println("\n What school do you go to (type in number)?");
     System.out.println("\n\n    Options:");
     System.out.println("     1. Monta Vista High School");
     System.out.println("     2. Homestead High School");
     System.out.println("     3. Fremont High School");
     System.out.println("     4. Lynbrook High School");
     System.out.println("     5. Cupertino High School");
     System.out.println("     6. Another High School");
     switch(keyboard.nextInt())
     {
       case 1: school = "Monta Vista High School";
       System.out.println("Unfortunately your lifespan decreases by 25 YEARS AUTOMATICALLY for choosing MVHS");
       System.out.println("\nStudies have shown students who have been sleep deprived for years");
       System.out.println("and have been raped multiple times decreases life expectancy\n");
       autism = "ARNAV HEMMADY";
       System.out.println("\nYour race has been determined. It just is Asian, there is nothing else");
       race = "ASIAN";
       break;
       case 2: school = "Homestead High School";
       System.out.println("Your lifespan has decreased by 30 YEARS AUTOMATICALLY");
       System.out.println("\nStudies have shown teen pregnancies have been skyrocketing");
       System.out.println("at high schools like this. This causes domestic violence and ");
       System.out.println("causes depression in many cases. Eventually this will DECREASE");
       System.out.println("your life, so remember not to become preganent in middle school");
       System.out.println(", Homestead kids.");
       autism = "Tobias Fork";
       System.out.println("\nYour race has been determined. It is Mexican. Get out. There is no turning back after Big Daddy Donald has cume to town.");
       race = "MEXICAN";
       break;
       case 3: school = "Fremont High School";
       System.out.println("Life is not fair. 50 YEARS AUTOMATIC deduction in lifespan.");
       System.out.println("50 point ec, 80% A, and having the most students arrested causes a shorter life.");
       System.out.println("You also have anand. ;o");
       autism = "ANAND BALAKRISHNAN";
       System.out.println("\nYour race has automatically determined. You are a nibba. Bring up your grades first before you take those drugs.");
       race = "AFRO";
       break;
       case 4: school = "Lynbrook High School";
       System.out.println("No one knows you. 5 YEAR AUTOMATIC deduction because life is not fair");
       autism = "Some dude";
       System.out.println("\nYour race has been determined. It just is Asian, there is nothing else");
       race = "ASIAN"
       break;
       case 5: school = "Cupertino High School";
       System.out.println("45 YEAR AUTONMATIC deduction in lifespan. You get remodelling and easy af teachers. ");
       System.out.println("Another reason: you don't have lora.");
       autism = "ANJU 5^2";
       System.out.println("\nYour race has been determined. It just is Asian, there is nothing else");
       race = "ASIAN";
       break;
       case 6: school = "Another High School";
       System.out.println("60 YEAR AUTOMATIC deduction. Gun violence, domestic abuse, robberies, cheating");
       System.out.println("hard WORKING CONDITIONS and drugs lead to a shorter lifespan.");
       autism = "DEM NIBBAS";
       System.out.println("\nYour race has been determined. It just is a Nibba, there is nothing else considering your skin color and culture and school");
       race = "AFRO";
       break;
     }
  }
}

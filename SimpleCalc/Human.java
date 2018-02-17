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
  int schoolNum, prophase,genes, population, income, cancerRating, rapeRating, strength, grade, lifespan, raped;
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
    schoolNum = 0;
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
     schoolNum = keyboard.nextInt();
     switch(schoolNum)
     {
       case 1: school = "Monta Vista High School";
       System.out.println("Unfortunately your lifespan decreases by 25 YEARS AUTOMATICALLY for choosing MVHS");
       System.out.println("\nStudies have shown students who have been sleep deprived for years");
       System.out.println("and have been raped multiple times decreases life expectancy\n");
       autism = "ARNAV HEMMADY";
       lifespan-=25;
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
       lifespan-=30;
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
       lifespan-=50;

       break;
       case 4: school = "Lynbrook High School";
       System.out.println("No one knows you. 5 YEAR AUTOMATIC deduction because life is not fair");
       autism = "Some dude";
       System.out.println("\nYour race has been determined. It just is Asian, there is nothing else");
       race = "ASIAN";
       lifespan-=5;
       break;
       case 5: school = "Cupertino High School";
       System.out.println("45 YEAR AUTONMATIC deduction in lifespan. You get remodelling and easy af teachers. ");
       System.out.println("Another reason: you don't have lora.");
       autism = "ANJU 5^2";
       System.out.println("\nYour race has been determined. It just is Asian, there is nothing else");
       race = "ASIAN";
       lifespan-=45;
       break;
       case 6: school = "Another High School";
       System.out.println("60 YEAR AUTOMATIC deduction. Gun violence, domestic abuse, robberies, cheating");
       System.out.println("hard WORKING CONDITIONS and drugs lead to a shorter lifespan.");
       autism = "DEM NIBBAS";
       System.out.println("\nYour race has been determined. It just is a Nibba, there is nothing else considering your skin color and culture and school");
       race = "AFRO";
       lifespan-=60;
       break;
       default:
       System.out.println("u nibba choose the god dam correct choices. as a penalty you are classified as a nibba");
       System.out.println("\nu also lose 80 years of your lifespan... because as gould says, 'life is not fair' congratulations you've played yourself");
       school = "Another High School";
       race = "AFRO";
       autism = "DEM NIBBAS";
       lifespan-=80;
       break;
     }
  }
}

class Asian extends Human
{
  public static void main(String[]args)
  {
    Asian baby = new Asian();
  }
  public void run()
  {
    int num = 0;
    Scanner keyboard = new Scanner(System.in);
    String input;
    System.out.println("----------------------------------------------------------------------");
    System.out.println("          YOU ARE NOW ASIAN, "+name);
    System.out.println("----------------------------------------------------------------------");
    System.out.println("          LET'S DETERMINE YOUR LIFESPAN!");
    System.out.println("----------------------------------------------------------------------");
    System.out.println("          HAVE YOU HAD KOCH EVER IN YOUR LIFE? (YES/NO)");
    input=keyboard.nextLine();
    if(input.toLowerCase().equals("YES"))
    kochleen = true;
    else
    {
      kochleen = false;
      System.out.println("          HAVE YOU HAD MUELLER EVER IN YOUR LIFE? (YES/NO)");
      input = keyboard.nextLine();
      if(input.toLowerCase().equals("YES"))
      mueller = true;
      else mueller = false;
    }
    System.out.println("----------------------------------------------------------------------");
    System.out.println("          NOW LET'S FIND YOUR CHROMOSOMES!");
    System.out.println("----------------------------------------------------------------------");
    System.out.println("HOW MANY CLASSES ARE YOU TAKING THIS YEAR?");
    num = keyboard.nextInt();
    System.out.println("OF THE "+num+" CLASSES, HOW MANY CLASSES DID YOU ACTUALLY HAVE TO STUDY FOR?");
    System.out.println("IN OTHER WORDS, WHICH CLASSES DID YOU HAVE TO TALK TO THE TEACHER FOR?");
    int but = keyboard.nextInt();
    System.out.println("\nHAHA IT DOESN'T MATTER! YOU'RE ASIAN! YOU'LL BE SUCKING TO ALL YOUR TEACHERS");
    System.out.println("NO MATTER WHO IT IS.\n\n");
    System.out.println("----------------------------------------------------------------------");
    switch(schoolNum)
    {
      case 1:
      Asian daddy = new Asian();
      System.out.println(daddy+daddy+daddy+daddy+daddy+daddy+daddy+daddy+daddy);
      System.out.println("\nYour chromosomes and chromatids have been determined.\n");
      chromosomes = "AAAA02	WGS		PLN	Oryza sativa Indica Group	PRJNA361	SAMN02953581	cultivar:  93-11		391.7	50,231			3,095	37,358	734	Y	CH398081-CH401163, CM000126-CM000137	2014-08-06	2004-10-21 2	AAAB01	WGS		INV	Anopheles gambiae str. PEST	PRJNA1438	SAMN02952903	strain:  PEST		313.7	69,724	14,089	Y	5		219.8		CM000356-CM000360	2014-08-05	2002-03-22
3	AAAC01	WGS		BCT	Bacillus anthracis str. A2012	PRJNA299	SAMN02435829	strain:  A2012		4.9	1								2013-12-05	2002-05-09
4	AAAK03	WGS		BCT	Enterococcus faecium DO	PRJNA71	SAMN02440386	strain:  DO		2.7	163	2,721	Y						2013-12-12	2004-06-07
5	AAAL02	WGS		BCT	Xylella fastidiosa Dixon	PRJNA260	SAMN02441075	strain:  Dixon		2.5	32	2,358	Y						2013-12-12	2005-07-26
6	AAAM04	WGS		BCT	Xylella fastidiosa subsp. sandyi Ann-1	PRJNA261	SAMN02441076	strain:  Ann-1		2.6	275								2014-01-06	2014-01-06
7	AABF01	WGS		BCT	Fusobacterium nucleatum subsp. vincentii ATCC 49256	PRJNA1419	SAMN02470057	strain:  ATCC 49256		2	302	2,250	Y						2014-01-08	2003-01-24
8	AABL01	WGS		INV	Plasmodium yoelii yoelii	PRJNA1436	SAMN02952904	isolate:  17XNL		22.1	5,687	7,861	Y						2014-08-05	2002-10-03
9	AABM02	WGS		BCT	Bifidobacterium longum DJO10A	PRJNA321	SAMN02441414	strain:  DJO10A		2.3	120								2015-06-25	2003-03-26
10	AABR07	WGS		ROD	Rattus norvegicus	PRJNA10629	SAMN02808228	strain:  mixed		2,460.8	73,554			1,124		5,384.1		CM000072-CM000092, CM002824-CM002824, KL567417-KL568518	2014-07-01	2014-06-30
11	AABS01	WGS		INV	Ciona intestinalis	PRJNA166	SAMN02769623			111.3	2,501								2014-08-01	2002-12-12
12	AABT01	WGS		PLN	Aspergillus terreus ATCC 20542	PRJNA187	SAMN02953582	strain:  ATCC 20542		0.1	175								2014-08-06	2002-12-19
13	AABW01	WGS		BCT	Rickettsia sibirica 246	PRJNA1414	SAMN02393728	strain:  246		1.2	1	1,234	Y						2013-11-06	2003-02-06
14	AABX03	WGS		PLN	Neurospora crassa OR74A	PRJNA13841	SAMN02953583	strain:  OR74A		39.1	411			20	10,785	39.1	Y	CM002236-CM002242, KI440765-KI440777	2014-08-06	2013-10-25
15	AABY01	WGS		PLN	Saccharomyces paradoxus NRRL Y-17217	PRJNA1440	SAMN02953584	strain:  NRRL Y-17217		11.3	832								2014-08-06	2003-03-28
16	AABZ01	WGS		PLN	Saccharomyces mikatae IFO 1815	PRJNA374	SAMN02953585	strain:  IFO 1815		10.9	1,648								2014-08-06	2003-03-28
17	AACA01	WGS		PLN	Saccharomyces uvarum MCYC 623	PRJNA1441	SAMN02953586	strain:  MCYC 623		10.9	1,098								2014-08-06	2003-03-28
18	AACB02	WGS		INV	Giardia lamblia ATCC 50803	PRJNA1439	SAMN02952905	strain:  WB C6		10.7	306	7,364	Y	92		10.7		CH991761-CH991852	2014-08-05	2007-09-24
19	AACC02	WGS		PRI	Homo sapiens	PRJNA10793	SAMN02981216			131.3	171	109	Y	20	709	118	Y	CH236947-CH236966	2014-08-11	2004-07-19
20	AACD01	WGS		PLN	Aspergillus nidulans FGSC A4	PRJNA130	SAMN02953587	strain:  FGSC A4		28.7	248	9,541	Y	17		28.3		CH236920-CH236936	2014-08-06	2003-04-07
21	AACE03	WGS		PLN	Lachancea kluyveri NRRL Y-12651	PRJNA1445	SAMN02953588	strain:  NRRL Y-12651		11	36		Y	8		10.8		CM000687-CM000694	2014-08-06	2011-05-12
22	AACF01	WGS		PLN	Naumovozyma castellii NRRL Y-12630	PRJNA1444	SAMN02953589	strain:  NRRL Y-12630		10.7	570		Y						2014-08-06	2003-05-22
23	AACG02	WGS		PLN	Saccharomyces bayanus 623-6C	PRJNA1443	SAMN02953590	strain:  623-6C		11.3	586		Y						2014-08-06	2005-10-14
24	AACH01	WGS		PLN	Saccharomyces mikatae IFO 1815	PRJNA9601	SAMN02953591	strain:  IFO 1815		10.3	2,808		Y						2014-08-06	2003-05-22
25	AACI03	WGS		PLN	Saccharomyces kudriavzevii IFO 1802	PRJNA1442	SAMN02953592	strain:  IFO 1802		10.7	2,055	3,764	Y	2,054		10.7		JH796010-JH798063	2014-08-06	2012-08-21
26	AACK01	WGS		BCT	Actinobacillus pleuropneumoniae serovar 1 str. 4074	PRJNA198	SAMN02471910	strain:  4074		2.2	140								2014-01-08	2003-04-21
27	AACM02	WGS		PLN	Fusarium graminearum PH-1	PRJNA13839	SAMN02953593	strain:  PH-1; NRRL 31084		34.6	435		Y	37	13,313	69.5	Y	CM000574-CM000577, DS231663-DS231695	2014-08-06	2007-04-11
28	AACN01	WGS		MAM	Canis lupus familiaris	PRJNA10628	SAMN03004377	breed:  poodle		1,447.2	1,089,636								2014-08-26	2003-09-27
29	AACP02	WGS		PLN	Ustilago maydis 521	PRJNA1446	SAMN02900459	strain:  521		18.7	254			27	6,783	18.8	Y	CM003140-CM003162, KN848500-KN848503	2015-02-18	2015-02-10
30	AACR01	WGS		BCT	Pasteuria nishizawae str. North American	PRJNA441	SAMN02471829	strain:  North American	dev_stage:  endospores
host:  Heterodera glycines	0	25								2014-01-08	2003-07-23
31	AACS02	WGS		PLN	Coprinopsis cinerea okayama7#130	PRJNA1447	SAMN02953595	strain:  okayama7#130		34.5	68	13,356	Y						2014-08-06	2010-06-16
32	AACT01	WGS		INV	Ciona savignyi	PRJNA1435	SAMN02952906			382.9	66,800		Y	3,447		522.3		CH000001-CH003011, CH003012-CH003447	2014-08-05	2003-10-24
33	AACU03	WGS		PLN	Magnaporthe oryzae 70-15	PRJNA13840	SAMN02953596	strain:  70-15		39.1	219			53	12,989	39.1	Y	CM001231-CM001237, JH165175-JH165220	2016-03-31	2011-09-19
34	AACV01	WGS		PLN	Oryza sativa Japonica Group	PRJNA13139	SAMN02953597	cultivar:  Nipponbare		356.9	35,047			1,436	35,394	684	Y	CH401164-CH402587, CM000138-CM000149	2014-08-06	2004-10-21
35	AACW02	WGS		PLN	Rhizopus delemar RA 99-880	PRJNA13066	SAMN02953598	strain:  RA 99-880		43.2	391		Y	83	17,459	44	Y	CH476732-CH476759, GG669511-GG669565	2014-08-06	2005-09-19
36	AACX01	WGS		BCT	Burkholderia thailandensis E264	PRJNA19251	SAMN02469820	strain:  ATCC 700388		6	44			2		6.1		CM000438-CM000439	2014-01-08	2007-04-10
37	AACY02	WGS		ENV	marine metagenome	PRJNA13694	SAMN02954345		isolation_source:  isolated as part of a large ";
chromatids = "LORALORALORALORALORALORALORALORALLORALORALORALORALORALORALORALORALORA";
      break;
      case 2: school = "Homestead High School";
      System.out.println("Your chromosomes and chromatids have been determined");
      chromosomes = "dataset composed predominantly from surface water marine samples collected along a voyage from Eastern North American coast to the Eastern Pacific Ocean, including locations in the Sargasso Sea, Panama Canal, and the Galapagos Islands	4,261.5	4,124,495			3,087,206	6,123,395	4,342	Y	EM000001-EM999999, EN000001-EN999999, EP000001-EP999999, EQ000001-EQ087209	2014-08-26	2007-03-16
      38	AACZ04	WGS		PRI	Pan troglodytes	PRJNA13184	SAMN02981217	isolate:  Yerkes chimp pedigree #C0471 (Clint)		2,843.4	72,784			4,301		5,736.9		CM000314-CM000336, CM004190-CM004190, DP000054-DP000054, KV419638-KV423913	2016-05-03	2016-04-26
      39	AADA01	WGS		PRI	Pan troglodytes	PRJNA13184	SAMN02981217	isolate:  Yerkes chimp pedigree #C0471 (Clint)		2,607.3	361,864								2014-08-11	2003-12-05
      40	AADB02	WGS		PRI	Homo sapiens	PRJNA1431	SAMN02981219			2,944.3	401,931			14,095	64,479	5,404.4	Y	CH471051-CH471355, CH471356-CH471786, CH878242-CH878738, CH878739-CH891576, CM000252-CM000275	2014-08-11	2005-08-25
      41	AADC01	WGS		PRI	Homo sapiens	PRJNA1431	SAMN02981219			2,532.9	169,156			2,639		2,834.3		CH003496-CH003519, KE133693-KE136307	2014-08-11	2004-02-04
      42	AADD01	WGS		PRI	Homo sapiens	PRJNA1431	SAMN02981219			2,570.7	211,493			1,372		2,719.9		CH003448-CH003471, KE137324-KE138671	2014-08-11	2004-02-03
      43	AADE01	WGS		INV	Drosophila pseudoobscura pseudoobscura	PRJNA10626	SAMN00779672	strain:  MV2-25		163.4	17,507		Y	4,896	23,456	145.6	Y	CH379058-CH379070, CH475397-CH476252, CH672438-CH676462, CM000070-CM000071	2014-08-04	2003-12-24
      44	AADG06	WGS		INV	Apis mellifera	PRJNA10625	SAMN00002455	strain:  DH4		218.5	16,501			5,660		432.7		CM000054-CM000069, GL630009-GL635652	2014-08-04	2010-11-30
      45	AADK01	WGS		INV	Bombyx mori	PRJNA13125	SAMN02952907	strain:  Dazao		375.1	66,482			16,462		327.8		CH379587-CH396048	2014-08-05	2004-10-12
      46	AADL01	WGS		ENV	mine drainage metagenome	PRJNA13696	SAMN02954273		isolation_source:  pink biofilm microbial community collected from flowing acid mine drainage (pH 0.8, 42C)	12.4	2,534			908	2,543	9.3	Y	CH003545-CH003921, CH003922-CH004070, CH004071-CH004104, CH004105-CH004435, DS995259-DS995275	2014-08-12	2004-02-01
      47	AADM01	WGS		PLN	Lachancea waltii NCYC 2644	PRJNA10734	SAMN02953599	strain:  NCYC 2644		10.4	713								2014-08-06	2004-03-15
      48	AADN05	WGS		VRT	Gallus gallus	PRJNA13342	SAMN02981218	breed:  Red Jungle fowl, inbred line UCD001
      isolate:  RJF #256		1,005.8	1,583								2017-08-29	2017-08-29
      49	AADQ01	WGS		BCT	Listeria monocytogenes serotype 1/2a str. F6854	PRJNA10753	SAMN02415268	strain:  1/2a F6854		2.8	133	2,967	Y						2013-11-20	2004-05-04
      50	AADR01	WGS		BCT	Listeria monocytogenes serotype 4b str. H7858	PRJNA10752"
      chromatids = "NO LORA OR KOCHNO LORA OR KOCHNO LORA OR KOCHNO LORA OR KOCHNO LORA OR KOCHNO LORA OR KOCHNO LORA OR KOCHNO LORA OR KOCHNO LORA OR KOCHNO LORA OR KOCH";
      break;
      case 3: school = "Fremont High School";
      chromosomes = "BBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBB808080808BBBBBBBBBBBBBBBBBBBBBBBBBBBBB8080808080808080808080808BBBBBBBB"
      break;
      case 4: school = "Lynbrook High School";
      System.out.println("No one knows you. 5 YEAR AUTOMATIC deduction because life is not fair");
      autism = "Some dude";
      System.out.println("\nYour race has been determined. It just is Asian, there is nothing else");
      race = "ASIAN";
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
      default:
      System.out.println("u nibba choose the god dam correct choices. as a penalty you are classified as a nibba");
      System.out.println("\nu also lose 80 years of your lifespan... because as gould says, 'life is not fair' congratulations you've played yourself");
      school = "Another High School";
      race = "AFRO";
      autism = "DEM NIBBAS";
      break;
    }

  }
}

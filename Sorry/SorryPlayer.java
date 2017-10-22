public class SorryPlayer
{
    private String name;
    private int[] scoreArray;
    private int totalscore;
    public SorryPlayer ()
    {
        name = new String("NAMETOBECHANGEDLATER");
        scoreArray = new int[3];
        totalscore = 0;
        for(int i = 0;i<scoreArray.length;i++)
        {
            scoreArray[i]=0;
        }
    }
    public void setName(String n)//used
    {
        name= new String(n);
    }
    public String getName()
    {
        return name;
    }
    public void setScoreArrayElement(int n, int value)
    {
      System.out.println("setScore enter with "+n+" val: "+value);
      scoreArray[n]+=value;
      System.out.println("currentVal"+scoreArray[n]);
            System.out.println("AFsetScore enter with "+scoreArray[n]);


      for(int i = 0;i<scoreArray.length;i++)
      {
          System.out.println("for");
          System.out.println("currentVal"+scoreArray[i]);

        if(scoreArray[i]==scoreArray[n]&&i!=n)
        {
            scoreArray[i]=0;
            System.out.println("comapare i: "+scoreArray[i]+" to n "+scoreArray[n]);
        }
      }

System.out.println("jake paul");
System.out.println(scoreArray[n]);

      for(int i = 0;i<scoreArray.length;i++)
      {
          System.out.println("scoreArrayP: "+scoreArray[i]);
        }
                      System.out.println("setScore exit");

    }



    public int calculateScore()
    {
        totalscore = 0;
        for(int i = 0;i<scoreArray.length;i++)
        {
            if(scoreArray[i]!=-1)
            {
                totalscore+=scoreArray[i];
            }
        }
        return totalscore;
    }
    public void printScore()
    {
        calculateScore();
        System.out.printf("%-12s : %4d\n");
    }
    public int getPieceArrayElement(int n)
    {
        return scoreArray[n];
    }
}

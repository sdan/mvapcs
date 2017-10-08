public class YahtzeePlayer
{
    private String name;
    private int[] scoreArray;
    private int totalscore;

    public YahtzeePlayer ()
    {
        name = new String("NAMETOBECHANGEDLATER");
        scoreArray = new int[13];
        totalscore = 0;
        for(int i = 0;i<scoreArray.length;i++)
        {
            scoreArray[i]=-1;
        }
    }

    public void setName(String n)
    {
        name= new String(n);
    }

    public String getName()
    {
        return name;
    }

    public void setScoreArrayElement(int i, int value)
    {
        scoreArray[i]=value;
    }

    public int getScoreArrayElement(int i)
    {
        return scoreArray[i];
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
}

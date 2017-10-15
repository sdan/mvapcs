
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
            scoreArray[i]=-1;
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

    public int getPieceArrayElement(int n)
    {
        return 0;
    }
}

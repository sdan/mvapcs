/**
* SorryPlayer.java
* A class used to store information about the players made in the Sorry class.
* 
* @author Surya Dantuluri
* @version 1.0
* @since 10/22/2017
*/

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

    public void setName(String n)
    {
        name= new String(n);
    }

    public String getName()
    {
        return name;
    }

    public void setScoreArrayElement(int n, int value)
    {
        scoreArray[n]+=value;
        for(int i = 0;i<scoreArray.length;i++)
        {
            if(scoreArray[i]==scoreArray[n]&&i!=n&&scoreArray[i]<21)
            {
                scoreArray[i]=0;
            }
            else if(scoreArray[i]>20)
                scoreArray[i]=21;
        }
    }

    public int getPieceArrayElement(int n)
    {
        return scoreArray[n];
    }
}


import java.util.ArrayList;

public class Stats
{
	private ArrayList<ScoreInfo> scoreList;

	public Stats ( )
	{
		scoreList = new ArrayList<ScoreInfo>();
	}

	public static void main(String [] args)
	{
		int [] allScores = {67,89,67,89,98,94,86,87,88,90,92,93,94,95,95,91,86,83,73,57,89,99,
			78,66,63,89,86,97,94,94,92,91,98,94,85,85,82,83,82,80,54,87,76,73,78,89,46,89,86,
			89,89,57,88,34,89,92,93,87,89,89,67,84,85,82,81,89,89,67,74,89,58,93,94,89,76,90,
			94,82,94,78,94,94,86,94,57,68,73,76,94,82,88,94};
		Stats data = new Stats();
		data.recordScores(allScores);
		System.out.println("\n\n" + data + "\n\n");
	}

	public boolean record(int score)
	{
		for(int i = 0; i < scoreList.size(); i++)
		{
			if(score < scoreList.get(i).getScore())
			{
				scoreList.add(i, new ScoreInfo(score));
				return true;
			}
			else if(score == scoreList.get(i).getScore())
			{
				scoreList.get(i).increment();
				return false;
			}
		}
		scoreList.add(new ScoreInfo(score));
		return true;

//  	OR

//		int i = 0;
//		while(i < scoreList.size() && score > scoreList.get(i).getScore())
//		{
//			i++;
//		}
//		boolean found = (i < scoreList.size() && score == scoreList.get(i).getScore());
//		if(found)
//		{
//			scoreList.get(i).increment();
//		}
//		else
//		{
//			scoreList.add(i, new ScoreInfo(score));
//		}
//		return found;
	}

	public void recordScores(int [] stuScores)
	{
		for(int score : stuScores)
		{
			record(score);
		}

//      OR

//		for(int i = 0; i < stuScores.length; i++)
//		{
//			record(stuScores[i]);
//		}
	}

	public String toString ( )
	{
		String result = new String("");
		for(ScoreInfo info : scoreList)
		{
			result += info + "\n";
		}
		return result;
	}
}

class ScoreInfo
{
	private int score;
	private int numStudents;

	public ScoreInfo(int aScore)
	{
		score = aScore;
		numStudents = 1;
	}

	public void increment ( )
	{
		numStudents++;
	}

	public int getScore ( )
	{
		return score;
	}

	public int getFrequency ( )
	{
		return numStudents;
	}

	public String toString ( )
	{
		return "SCORE: " + score + ", # OF STUDENTS: " + numStudents;
	}
}

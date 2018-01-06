
public class TwoDArray2
{
	int [][] table1 = { {0,0,0,0},
                  	    {0,0,0,0},
                  	    {0,0,0,0} };

	int [][] table2 = { {0,1,2,3,8,45,6,-3,-4,56,8,7},
                 	    {4,5,6,7,7,5,6},
                 	    {8,9,10,11,35} };

	public static void main (String[] args)
	{
		TwoDArray2 thisprog = new TwoDArray2();
		thisprog.runIt();
	}

	public void runIt ( )
	{
		System.out.println("\n\n");
		printOut(table1);
		System.out.println("\n\n");
		printOut(table2);
		System.out.println("\n\n");
		printOut2(table1);
		System.out.println("\n\n");
		printOut2(table2);
		System.out.println("\n\n");
	}

	public void printOut(int [][] table)
	{
		for (int row = 0; row < table.length; row++)
		{
			for (int col = 0; col < table[row].length; col++)
			{
				System.out.printf("%5d", table[row][col]);
			}
			System.out.println();
		}
	}

	public void printOut2(int [][] table)
	{
		for (int [] row : table)
		{
			for (int value : row)
			{
				System.out.printf("%5d", value);
			}
			System.out.println();
		}
	}
}

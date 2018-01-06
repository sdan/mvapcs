
//  here is a possible  data.txt
//
//   17   3   2  13
//    5  10  11   8
//    9   6   7  12
//    4  15  14   1
//

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class TwoDArray4
{
	public static void main (String[] args)
	{
		final int MAX = 4;
    		int[][] grid = new int[MAX][MAX];

		loadTable(grid);
		printTable(grid);
	}

	public static void loadTable (int[][] lTable)
	{
		try
		{
			File myFile = new File("data.txt");
			Scanner fromFile = new Scanner(myFile);

			for (int row = 0; row < lTable.length; row++)
				for (int col = 0; col < lTable[row].length; col++)
					lTable[row][col] = fromFile.nextInt();
		}
		catch (FileNotFoundException e)
		{
			e.printStackTrace();
		}
	}

	public static void printTable (int[][] pTable)
	{
		System.out.println("\n\n\n\n");
		for (int row = 0; row < pTable.length; row++)
		{
			for (int col = 0; col < pTable[row].length; col++)
				System.out.printf("%5d",pTable[row][col]);
			System.out.println();
		}
		System.out.println("\n\n\n\n");
	}
}


public class TwoDArray3
{
	public static void main (String[] args)
	{
		int[][] table = new int[25][18];
		int  row, col;

		for (row = 0; row < table.length; row++)
			for (col = 0; col < table[row].length; col++)
				table[row][col] = row + col;

		System.out.println("\n\n\n\n");

		for (row = 0; row < table.length; row++)
		{
			for (col = 0; col < table[row].length; col++)
				System.out.printf("%5d", table[row][col]);
			System.out.println();
		}

		System.out.println("\n\n\n\n");
	}
}

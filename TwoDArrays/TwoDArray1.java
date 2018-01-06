
public class TwoDArray1
{
	public static void main (String[] args)
	{
		int  row = 8, col = 10;
		int [][] table = new int[row][col];

		System.out.println("\n\n\n\n");

		for (row = 0; row < table.length; row++)
		{
			for (col = 0; col < table[row].length; col++)
				System.out.printf("%4d", table[row][col]);
			System.out.println();
		}

		for (row = 1; row < table.length; row++)
			for (col = 1; col < table[row].length; col++)
				table[row][col] = row * col;

		System.out.println("\n\n\n\n");

		for (row = 0; row < table.length; row++)
		{
			for (col = 0; col < table[row].length; col++)
				System.out.printf("%4d", table[row][col]);
			System.out.println();
		}

		System.out.println("\n\n\n\n");
	}
}

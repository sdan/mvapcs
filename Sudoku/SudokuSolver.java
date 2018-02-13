import java.util.Scanner;

public class SudokuSolver 
{
	private int[][] board;
	private int[][] nextBoard;
	public static final int WIDTH = 9;
	public static final int HEIGHT = 9;
	private String fileName;
	
	public SudokuSolver(String fileName)
	{
		this.fileName = fileName;
		board = new int[HEIGHT][WIDTH];
		nextBoard = new int[HEIGHT][WIDTH];
	}
	
	public static void main(String[] args)
	{
		SudokuSolver ss = new SudokuSolver("a1.txt");
		if(args.length > 0)
			ss = new SudokuSolver(args[0]);
		ss.run();
	}

	public void run ( )
	{
		createBoard();
		nextBoard();
		SudokuUtilities.print(board);
	}
	
	/* Reads a file into a 2D array
	*/
	public void createBoard( )
	{
		Scanner reader = OpenFile.openToRead(fileName);

		for(int i = 0; i < board.length; i++)
		{
			for(int c = 0; c < board[i].length; c++)
			{
				int num = reader.nextInt();
				board[i][c] = num;
				nextBoard[i][c] = num;
			}
		}
	}
	
	public void nextBoard( )
	{
		nextCell(0, 0);
	}
	
	/*
	* Checks if zero exists. 
	* If zero exists, systematically checks numbers to see if 
	* a number can be placed at that position until it finds
	* a valid number. 
	*/
	public boolean nextCell(int row, int col)
	{
		int nextRow = row;
		int nextCol = col;
		int [] numbers = {1,2,3,4,5,6,7,8,9};
		SudokuUtilities.shuffleArray(numbers);
		
		if(nextBoard[row][col] == 0)
			for(int i = 0; i < numbers.length; i++)
			{
				if(SudokuUtilities.legalMove(board, row, col, numbers[i]))
				{
					board[row][col] = numbers[i];
					SudokuUtilities.printInfo(board, row, col, numbers, i);
					if(col == WIDTH-1)
					{
						if(row == HEIGHT-1)
							return true;
						else
						{
							nextCol = 0;
							nextRow = row + 1;
						}
					}
					else
						nextCol = col + 1;				
					if(nextCell(nextRow, nextCol))
						return true;
				}
			}
		else
		{
			if(col == 8)
			{
				if(row == 8)
					return true;
				else
				{
					nextCol = 0;
					nextRow = row + 1;
				}
			}
			else
				nextCol = col + 1;
			if(nextCell(nextRow, nextCol))
				return true;
			else
			{
				SudokuUtilities.printInfo(board, row, col, numbers, -1);
				return false;
			}
		}
		board[row][col] = 0;
		SudokuUtilities.printInfo(board, row, col, numbers, -1);
		return false;
	}
}

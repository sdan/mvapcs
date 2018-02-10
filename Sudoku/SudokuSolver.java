public class SudokuSolver
{
	public static final int WIDTH = 9;
	public static final int HEIGHT = 9;
	private int [][] board;

	public SudokuSolver () 
	{
		board = new int[HEIGHT][WIDTH];
	}

	public static void main(String[] args)
	{
		SudokuSolver sg = new SudokuSolver();
		sg.run();
	}
	
	public void run ( )
	{
		createBoard();
		SudokuUtilities.print(board);
	}
	
	public void createBoard ( )
	{
		nextCell(0,0);
	}
	
	public boolean nextCell(int r, int c)
	{
		int nextRow = r;
		int nextCol = c;
		int [] toCheck = {1,2,3,4,5,6,7,8,9};
		
		SudokuUtilities.shuffleArray(toCheck);
		
		for(int i = 0;i<toCheck.length;i++)
		{
			if(SudokuUtilities.legalMove(board,r,c,toCheck[i]))
			{
				board[r][c] = toCheck[i];
				SudokuUtilities.printInfo(board, r, c, toCheck, i);
				if(c == WIDTH-1)
				{
					if(r == HEIGHT -1)
					return true;
					else
					{
						nextCol = 0;
						nextRow = r+1;
					}
				}
				else
					nextCol = c+1;
				if(nextCell(nextRow,nextCol))
					return true;
			}
		}
		board[r][c] = 0;
		SudokuUtilities.printInfo(board, r, c, toCheck, -1);
		return false;
	}
}

import java.awt.Color;
import java.awt.Font;

public class KnightsTour
{
	KnightCell [][] board;
	int x, y, pause, animPause;
	boolean foundplace, warnsdorff;

	public KnightsTour(int p, int ap, boolean b)
	{
		Font font = new Font("Arial", Font.BOLD, 18);
		StdDraw.setFont(font);
		board = new KnightCell [8][8];
		x = y = 0;
		pause = p;
		animPause = ap;
		warnsdorff = b;
		for ( int i = 0; i < board.length; i++ )
		{
			for ( int j = 0; j < board[i].length; j++ )
			{
				board[i][j] = new KnightCell(i,j);
			}
		}
		setAllDecisionVals();
		board[x][y].turnOn();
		foundplace = true;
	}

	public static void main(String [] args)
	{
		int pause = 100;
		int animPause = 50;
		boolean onOrOff = true;
		if(args.length > 0)
		{
			pause = Integer.parseInt(args[0]);
		}
		if(args.length > 1)
		{
			animPause = Integer.parseInt(args[1]);
		}
		if(args.length > 2)
		{
			onOrOff = Boolean.parseBoolean(args[2]);
		}
		KnightsTour run = new KnightsTour(pause,animPause,onOrOff);
		run.attemptTour();
	}

	public void attemptTour ( )
	{
		drawBoard();
		StdDraw.show(pause);
		boolean foundplace = false;
		do
		{
			foundplace = moveToNext();
			drawBoard();
			StdDraw.show(pause);
		}
		while(foundplace);
	}

	public void drawBoard ( )
	{
		StdDraw.setPenColor(new Color(139,69,19));
		StdDraw.filledSquare(0.5,0.5,0.45);
		for ( int i = 0; i < board.length; i++ )
		{
			for ( int j = 0; j < board[i].length; j++ )
			{
				board[i][j].drawCell();
			}
		}
	}

	public void setAllDecisionVals ( )   {
		int [][] decisionMatrix = {{2,3,4,4,4,4,3,2}, {3,4,6,6,6,6,4,3}, {4,6,8,8,8,8,6,4}, {4,6,8,8,8,8,6,4},
							{4,6,8,8,8,8,6,4}, {4,6,8,8,8,8,6,4}, {3,4,6,6,6,6,4,3}, {2,3,4,4,4,4,3,2}};
		for ( int i = 0; i < board.length; i++ )
		{
			for ( int j = 0; j < board[i].length; j++ )
			{
				board[i][j].setDecisionVal(decisionMatrix[i][j]);
			}
		}
	}

	public boolean moveToNext ( )
	{
		int choice = (int)(Math.random() * 8);
		int countTry = 0;
		int [][] move = {{2,1},{2,-1},{-2,1},{-2,-1},{1,2},{1,-2},{-1,2},{-1,-2}};
		int smalldecision = findSmallestDecisionVal(move);
		do
		{
			foundplace = false;
			if(onBoard(move[choice]))
			{
				makeMoveChoice(move[choice],smalldecision);
			}
			if(!foundplace)
			{
				countTry++;
				choice = (choice + 1) % 8;
			}
		} while(countTry < 8 && !foundplace);
		if(foundplace)
		{
			animateMove(choice,move[choice]);
			return true;
		}
		return false;
	}

	public int findSmallestDecisionVal (int [][] move)
	{
		int smalldecision = 10;
		for(int i = 0; i < move.length; i++)
		{
			if(onBoard(move[i]))
			{
				board[x + move[i][0]][y + move[i][1]].decrementDecisionVal();
				if ( board[x + move[i][0]][y + move[i][1]].getDecisionVal() < smalldecision )
				{
					smalldecision = board[x + move[i][0]][y + move[i][1]].getDecisionVal();
				}
			}
		}
		return smalldecision;
	}

	public boolean onBoard(int [] moveTo)
	{
		return (x + moveTo[0] >= 0 && x + moveTo[0]<= 7 &&
					y + moveTo[1] >= 0 && y + moveTo[1] <= 7);
	}

	public void makeMoveChoice(int [] moveTo,int smalldecision)
	{
		if(!board[x + moveTo[0]][y + moveTo[1]].visited())
		{
			if(!warnsdorff)
			{
				foundplace = true;
			}
			else if(board[x + moveTo[0]][y + moveTo[1]].getDecisionVal() == smalldecision)
			{
				foundplace = true;
			}
		}
	}

	public void animateMove(int choice, int [] moveTo)
	{
		board[x][y].turnOff();
		for(int i = 0; i < 10; i++)
		{
			StdDraw.picture(0.154 + 0.1 * (x + moveTo[0] * i / 10.0),
							0.151 + 0.1 * (y + moveTo[1] * i / 10.0),"knightred.png");
			StdDraw.show(animPause);
			drawBoard();
		}
		x = x + moveTo[0];
		y = y + moveTo[1];
		board[x][y].turnOn();
	}
}

class KnightCell
{
	private int visitnumber;
	private boolean visited;
	private boolean oncell;
	private int x, y;
	private static int keepcount = 0;
	private int decisionval;

	public KnightCell(int i, int j)
	{
		visitnumber = 0;
		visited = false;
		x = i;
		y = j;
		keepcount = 0;
		decisionval = 0;
	}

	public void drawCell ( )
	{
		StdDraw.setPenColor(new Color(255,255,255));
		if((x + y) % 2 == 0)
		{
			StdDraw.setPenColor(new Color(0,0,0));
		}
		StdDraw.filledSquare(0.15 + 0.1 * x, 0.15 + 0.1 * y, 0.05);
		StdDraw.setPenColor(new Color(130,130,130));
		if(decisionval < 10)
		{
			StdDraw.text(0.15 + 0.1 * x, 0.142 + 0.1 * y,"" + decisionval);
		}
		if(oncell || visited)
		{
			if(oncell)
			{
				StdDraw.picture(0.154 + 0.1 * x, 0.151 + 0.1 * y,"knightred.png");
			}
			else if(visited)
			{
				StdDraw.picture(0.154 + 0.1 * x, 0.151 + 0.1 * y,"knightblue.png");
			}
			StdDraw.setPenColor(new Color(255,255,255));
			StdDraw.text(0.149 + 0.1 * x, 0.142 + 0.1 * y,"" + visitnumber);
		}
	}

	public void setDecisionVal(int value)
	{
		decisionval = value;
	}

	public int getDecisionVal ( )
	{
		return decisionval;
	}

	public void decrementDecisionVal ( )
	{
		decisionval--;
	}

	public void turnOn ( )
	{
		oncell = true;
		keepcount++;
		visitnumber = keepcount;
		decisionval = 10;
	}

	public void turnOff ( )
	{
		oncell = false;
		visited = true;
	}

	public boolean visited ( )
	{
		return visited;
	}
}
Back to APCS Main Page

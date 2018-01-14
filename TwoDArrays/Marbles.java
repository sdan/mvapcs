
/**
 * Marbles.java
 * Description Here
 * @author Surya Dantuluri
 * @version 1.0
 * @since 1/9/2018
 */
import java.awt.Color;
import java.awt.Font;

public class Marbles
{
    /**    The board object.  1 represents a marble on the board, 0 is an empty space,
     *     and -1 would indicate that this cell is not part of the board.                  */
    private int [][] board;
    
    /**    How long the GUI should pause, before expecting new input.                      */
    private int pause;
    
    /**    Current x and y values of the user's choice.  The x values count the cells
     *     from the lower left to the right, while the y values count the cells from
     *     the bottom left up.                                                             */
    private int xposition, yposition;
        
    /**
     *  Creates a Marbles object, with the font to be used, current position initially
     *  pause off the board, pause at 50 milliseconds, and the board values initialized
     *  in a 9 x 9 grid.
     */
    public Marbles ( )
    {
        Font font = new Font("Arial", Font.BOLD, 18);
        StdDraw.setFont(font);
        xposition = yposition = -5;
        pause = 50;
        board = new int[][]{{-1,-1,-1,1,1,1,-1,-1,-1},{-1,-1,-1,1,1,1,-1,-1,-1},{-1,-1,-1,1,1,1,-1,-1,-1},
                        {1,1,1,1,1,1,1,1,1},{1,1,1,1,0,1,1,1,1},{1,1,1,1,1,1,1,1,1},
                        {-1,-1,-1,1,1,1,-1,-1,-1},{-1,-1,-1,1,1,1,-1,-1,-1},{-1,-1,-1,1,1,1,-1,-1,-1}};
    }
    
    /**
     *  Sets up and runs the game of Marbles.
     *  @param  args     An array of String arguments (not used here).
     */
    public static void main(String [] args)   
    {
        Marbles run = new Marbles();
        run.playGame();
    }
    
    /**
     *  Comments.
     */
    public void playGame ( )
    {
        boolean done = false;
        do
        {
            drawBoard();
            if(StdDraw.mousePressed())
            {
                double x = StdDraw.mouseX();
                double y = StdDraw.mouseY();
                int checkx = (int)(10 * x - 0.5);
                int checky = (int)(10 * y - 0.5);
                if(reset(x,y))
                {
                    xposition = yposition = -5;
                }
                else if(possibleMoveSpace(xposition,yposition,checkx,checky) && !gameIsFinished())
                {
                    board[checkx][checky] = 1;
                    board[xposition][yposition] = 0;
                    board[(checkx+xposition)/2][(checky+yposition)/2] = 0;
                    
                    StdDraw.show(4 * pause);
                }
                else
                {
                    xposition = checkx;
                    yposition = checky;
                    StdDraw.show(pause);
                }
            }
            StdDraw.show(pause);
        }
        while(!done);
    }
    
    /**
     *  Comments.
     */
    public void drawBoard ( )
    {
        StdDraw.setPenColor(new Color(0,0,0));
        StdDraw.filledSquare(0.5,0.5,0.5);
        StdDraw.setPenColor(new Color(5,25,160));
        StdDraw.filledSquare(0.5,0.5,0.475);
        for ( int i = 0; i < board.length; i++ )
        {
            for ( int j = 0; j < board[i].length; j++ )
            {
                if(board[i][j] != -1)
                {
                    drawCell(i,j);
                }
            }
        }
        drawResetButtons();
        drawWinOrLoseMessage();

    }
    
    /**
     *  Comments.
     */
    public void drawResetButtons ( )
    {
        StdDraw.setPenColor(new Color(0,0,0));
        StdDraw.filledRectangle(0.8, 0.25, 0.125, 0.05);
        StdDraw.filledRectangle(0.8, 0.25-0.125, 0.125, 0.05);
        StdDraw.setPenColor(new Color(255,255,255));
        StdDraw.text(0.8, 0.25, "RESET 7 x 7");
        StdDraw.text(0.8, 0.25-0.125, "RESET 9 x 9");
      }
    
    /**
     *  Comments.
     */
    public void drawWinOrLoseMessage ( )
    {       
     String message = "YOU LOSE!";

        if(countMarbles() == 1)
            message = "YOU WIN!";
        
        if(gameIsFinished())
        {
            StdDraw.setPenColor(new Color(0,0,0));
            StdDraw.filledRectangle(0.8, 0.25-0.125, 0.125, 0.05);
            StdDraw.setPenColor(new Color(255,255,255));
            StdDraw.text(0.8, 0.25-0.125, message);
        }
    }
    
    /**
     *  Comments.
     */
    public boolean reset(double x, double y)
    {
        if((x>0.675&&x<0.925)&&(y>0.08&&y<0.18))
        {
            board = new int[][]{{-1,-1,-1,1,1,1,-1,-1,-1},{-1,-1,-1,1,1,1,-1,-1,-1},{-1,-1,-1,1,1,1,-1,-1,-1},
                        {1,1,1,1,1,1,1,1,1},{1,1,1,1,0,1,1,1,1},{1,1,1,1,1,1,1,1,1},
                        {-1,-1,-1,1,1,1,-1,-1,-1},{-1,-1,-1,1,1,1,-1,-1,-1},{-1,-1,-1,1,1,1,-1,-1,-1}};
            return true;
        }
        else if((x>0.675&&x<0.925)&&(y>0.2&&y<0.3))
        {
            board = new int[][]{{-1,-1,-1,-1,-1,-1,-1,-1,-1},{-1,-1,-1,1,1,1,-1,-1,-1},{-1,-1,-1,1,1,1,-1,-1,-1},
                        {-1,1,1,1,1,1,1,1,-1},{-1,1,1,1,0,1,1,1,-1},{-1,1,1,1,1,1,1,1,-1},
                        {-1,-1,-1,1,1,1,-1,-1,-1},{-1,-1,-1,1,1,1,-1,-1,-1},{-1,-1,-1,-1,-1,-1,-1,-1,-1}};
            return true;   
        }
        return false;

    }
    
    /**
     *  Comments.
     */
    public void drawCell(int x, int y)   
    {
       StdDraw.setPenColor(new Color(0,0,0));
        StdDraw.filledSquare(0.1 + 0.1 * x, 0.1 + 0.1 * y, 0.055);
        StdDraw.setPenColor(new Color(255,255,255));
        StdDraw.filledSquare(0.1 + 0.1 * x, 0.1 + 0.1 * y, 0.0425);
        StdDraw.setPenColor(new Color(200,200,200));
        StdDraw.filledCircle(0.1 + 0.1 * x, 0.1 + 0.1 * y, 0.02);
        if(x == xposition && y == yposition && board[x][y] == 1)
        {
            StdDraw.setPenColor(new Color(0,0,0));
            StdDraw.filledSquare(0.1 + 0.1 * x, 0.1 + 0.1 * y, 0.05);
            StdDraw.setPenColor(new Color(230,30,30));
            StdDraw.filledCircle(0.1 + 0.1 * x, 0.1 + 0.1 * y, 0.04);
        }
        if(possibleMoveSpace(xposition,yposition,x,y))
        {
            StdDraw.setPenColor(new Color(0,0,0));
            StdDraw.filledSquare(0.1 + 0.1 * x, 0.1 + 0.1 * y, 0.05);
            StdDraw.setPenColor(new Color(230,30,30));
            StdDraw.filledCircle(0.1 + 0.1 * x, 0.1 + 0.1 * y, 0.03);
        }
        if(board[x][y] == 1)
        {
            StdDraw.picture(0.1 + 0.1 * x, 0.1 + 0.1 * y,"marble.png");
        }
    }
    
    /**
     *  Comments.
     */
    public boolean possibleMoveSpace(int x, int y, int xval, int yval)
    {

        if(x>=0 && y>=0 && board[x][y] == 1)
        {
            if(x+2 < board.length && x+2==xval && y==yval && board[x+2][y]==0 && board[x+1][y]==1)
            {
                return true;
            }
            else if(x-2 >= 0 && x-2==xval && y==yval && board[x-2][y]==0  && board[x-1][y]==1)
            {
                return true;
            }
            else if(board[0].length>y+2 && x==xval && y+2==yval && board[x][y+2]==0 && board[x][y+1]==1)
            {
                return true;
            }
            else if(y-2 >= 0 && x==xval && y-2==yval &&  board[x][y-2]==0 && board[x][y-1]==1)
            {
                return true;
            }
        }
        // System.out.println("NO POSSIBLE MOVE SPACES: ");
        // System.out.println("x "+x);
        // System.out.println("y "+y);
        // System.out.println("xval "+xval);
        // System.out.println("yval "+yval);
        // System.out.println("\n\n");
        return false;

    }
    
    /**
     *  Comments.
     */
    public boolean gameIsFinished()
    {
        for(int x = 0; x < board.length; x++)
        {
            for(int y = 0; y < board[0].length; y++)
            {
               if(x-2>=1&&possibleMoveSpace(x,y,x-2,y))
               {
                 System.out.println("Possible Move: (" + (x-2) + ", " + (y) + ")");
                    return false;
               }
                if(x+2<board.length&&possibleMoveSpace(x,y,x+2,y))
                {
                 System.out.println("Possible Move: (" + (x+2) + ", " + (y) + ")");
                     return false;
                }
                if(y-2>=1&&possibleMoveSpace(x,y,x,y-2))
                {
                System.out.println("Possible Move: (" + (x) + ", " + (y-2) + ")");
                     return false;
                }
                if(y+2<board[0].length&&possibleMoveSpace(x,y,x,y+2))
                {
                    System.out.println("Possible Move: (" + (x) + ", " + (y+2) + ")");
                     return false;
                }
                    
             }
        }
        return true;
    }
    
    /**
     *  Comments.
     */
    public int countMarbles ( )
    {
        int count = 0;
       for (int i = 0;i<board.length;i++) {
           for (int j = 0; j<board[0].length;j++) {
               if(board[i][j]==1)
                    count++;
           }
       }
       return count;
    }

    public void printArray()
    {
        for (int i = 0;i<board.length;i++) {
            for (int j = 0; j<board[0].length;j++) {
                System.out.print(board[i][j]+" ");
            }
            System.out.println("");
        }
    }
}


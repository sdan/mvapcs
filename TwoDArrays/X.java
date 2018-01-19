/**
* Marbles.java
* An intensive game that utilizes the StdDraw class from Princeton University to create a GUI 
* that allows players to play a classic game of Marbles. The enhanced game shows one of the multitude
* of solutions for the game. An enhanced background is also shown to make the game more intense.
* 
* @author Surya Dantuluri
* @version 1.0
* @since 1/9/2018
*/
import java.awt.Color;
import java.awt.Font;

public class X
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
    public X ( )
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
        X run = new X();
        run.playGame();
    }

    /**
    *  Comments.
    */
    public void playGame ( )
    {
        boolean done = false;
        boolean toggleChangeBackground = true;
        drawBackground(true);
        do
        {
            drawBoard(toggleChangeBackground);
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
                if(resetSolutionButton(x,y))
                {
                    done = true;
                    xposition = yposition = -5;
                    attemptCompute();
                }
                else if(possibleMoveSpace(xposition,yposition,checkx,checky) && !gameIsFinished())
                {
                    board[checkx][checky] = 1;
                    board[xposition][yposition] = 0;
                    board[(checkx+xposition)/2][(checky+yposition)/2] = 0;
                    StdDraw.show(4 * pause);
                    toggleChangeBackground = false;
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


    public void drawBackground(boolean draw)
    {
        if(draw)
        {
            StdDraw.setPenColor(new Color(0,0,0));
            StdDraw.filledSquare(0.5,0.5,0.5);
            draw = false;
        }
        
    }
    /**
    *  Comments.
    */
    public void drawBoard (boolean toggle)
    {
        if(toggle)
        {
            double x = 0.5, y = 0.5;   // center of square
            double size = 0.5;         // side length of square
            draw(6, x, y, size, StdDraw.YELLOW);
   
        }

        for ( int i = 0; i < board.length; i++ )
            for ( int j = 0; j < board[i].length; j++ )
                if(board[i][j] != -1)
                    drawCell(i,j);

        drawResetButtons();
        drawSolutionMessage();
        drawWinOrLoseMessage();
    }

    public void drawSquare(double x, double y, double size, Color color) 
    {
        StdDraw.setPenColor(color);
        StdDraw.filledSquare(x, y, size/2);
        StdDraw.setPenColor(color);
        StdDraw.square(x, y, size/2);
    }

    public void draw(int n, double x, double y, double size, Color color) {
        if (n == 0) 
            return;
        drawSquare(x, y, size, color);
        double ratio = 2.2;
        Color colorful = new Color(0,0,0);
        int randomNum = (int)(Math.random()*13+1);

        if(randomNum==1)
        colorful = StdDraw.BLACK;
        if(randomNum==2)
        colorful = StdDraw.BLUE;
        if(randomNum==3)
        colorful = StdDraw.CYAN;
        if(randomNum==4)
        colorful = StdDraw.DARK_GRAY;
        if(randomNum==5)
        colorful = StdDraw.GRAY;
        if(randomNum==6)
        colorful = StdDraw.GREEN;
        if(randomNum==7)
        colorful = StdDraw.LIGHT_GRAY;
        if(randomNum==8)
        colorful = StdDraw.MAGENTA;
        if(randomNum==9)
        colorful = StdDraw.ORANGE;
        if(randomNum==10)
        colorful = StdDraw.PINK;
        if(randomNum==11)
        colorful = StdDraw.RED;
        if(randomNum==12)
        colorful = StdDraw.WHITE;
        if(randomNum==13)
        colorful = StdDraw.YELLOW;
        draw(n-1, x - size/2, y - size/2, size/ratio, colorful);
        draw(n-1, x - size/2, y + size/2, size/ratio, colorful); 
        draw(n-1, x + size/2, y - size/2, size/ratio, colorful);
        draw(n-1, x + size/2, y + size/2, size/ratio, colorful);
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

    public void drawSolutionMessage()
    {
        StdDraw.setPenColor(new Color(0,0,0));
        StdDraw.filledRectangle(0.2, 0.25, 0.145, 0.05);
        StdDraw.setPenColor(new Color(255,255,255));
        StdDraw.text(0.2, 0.25, "SOLUTION 7 x 7");
        StdDraw.setPenColor(new Color(0,0,0));
        StdDraw.filledRectangle(0.2, 0.25-0.125, 0.145, 0.05);
        StdDraw.setPenColor(new Color(255,255,255));
        StdDraw.text(0.2, 0.25-0.125, "SOLUTION 9 x 9");
    }

    /**
    *  Comments.
    */
    public void drawWinOrLoseMessage ( )
    {       
        if(countMarbles()==1)
        {
            StdDraw.setPenColor(new Color(0,0,0));
            StdDraw.filledRectangle(0.2, 0.8, 0.125, 0.05);
            StdDraw.setPenColor(new Color(255,255,255));
            StdDraw.text(0.2, 0.8, "YOU WIN!");
        }
        else if(gameIsFinished())
        {
            StdDraw.setPenColor(new Color(0,0,0));
            StdDraw.filledRectangle(0.2, 0.8, 0.125, 0.05);
            StdDraw.setPenColor(new Color(255,255,255));
            StdDraw.text(0.2, 0.8, "YOU LOSE!");
        }
    }

    /**
    *  Comments.
    */
    public boolean reset(double x, double y)
    {
        if(x >= 0.8-0.125 && x <= 0.8+0.125 && y >= 0.25-0.05 && y <= 0.25+0.05)
        {
            drawBoard(true);
            drawBackground(true);
            board = new int[][]{{-1,-1,-1,-1,-1,-1,-1,-1,-1},{-1,-1,-1,1,1,1,-1,-1,-1},{-1,-1,-1,1,1,1,-1,-1,-1},
                {-1,1,1,1,1,1,1,1,-1},{-1,1,1,1,0,1,1,1,-1},{-1,1,1,1,1,1,1,1,-1},
                {-1,-1,-1,1,1,1,-1,-1,-1},{-1,-1,-1,1,1,1,-1,-1,-1},{-1,-1,-1,-1,-1,-1,-1,-1,-1}};
            drawBoard(true);

            return true;
        }
        else if(x >= 0.8-0.125 && x <= 0.8+0.125 && y >= 0.25-0.125-0.05 && y <= 0.25-0.125+0.05)
        {
            drawBoard(true);
            drawBackground(true);
            board = new int[][]{{-1,-1,-1,1,1,1,-1,-1,-1},{-1,-1,-1,1,1,1,-1,-1,-1},{-1,-1,-1,1,1,1,-1,-1,-1},
                {1,1,1,1,1,1,1,1,1},{1,1,1,1,0,1,1,1,1},{1,1,1,1,1,1,1,1,1},
                {-1,-1,-1,1,1,1,-1,-1,-1},{-1,-1,-1,1,1,1,-1,-1,-1},{-1,-1,-1,1,1,1,-1,-1,-1}};
            drawBoard(true);

            return true;
        }
        
        return false;
    }
    public boolean resetSolutionButton(double x, double y)
    {
        if(x >= 0.2-0.145 && x <= 0.2+0.145 && y >= 0.25-0.05 && y <= 0.25+0.05)
        {
            drawBoard(true);
            drawBackground(true);
            board = new int[][]{{-1,-1,-1,-1,-1,-1,-1,-1,-1},{-1,-1,-1,1,1,1,-1,-1,-1},{-1,-1,-1,1,1,1,-1,-1,-1},
                {-1,1,1,1,1,1,1,1,-1},{-1,1,1,1,0,1,1,1,-1},{-1,1,1,1,1,1,1,1,-1},
                {-1,-1,-1,1,1,1,-1,-1,-1},{-1,-1,-1,1,1,1,-1,-1,-1},{-1,-1,-1,-1,-1,-1,-1,-1,-1}};
            drawBoard(true);

            return true;
        }
        else if(x >= 0.2-0.145 && x <= 0.2+0.145 && y >= 0.25-0.125-0.05 && y <= 0.25-0.125+0.05)
        {
            drawBoard(true);
            drawBackground(true);
            board = new int[][]{{-1,-1,-1,1,1,1,-1,-1,-1},{-1,-1,-1,1,1,1,-1,-1,-1},{-1,-1,-1,1,1,1,-1,-1,-1},
                {1,1,1,1,1,1,1,1,1},{1,1,1,1,0,1,1,1,1},{1,1,1,1,1,1,1,1,1},
                {-1,-1,-1,1,1,1,-1,-1,-1},{-1,-1,-1,1,1,1,-1,-1,-1},{-1,-1,-1,1,1,1,-1,-1,-1}};
            drawBoard(true);

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
                    return false;
                }
                if(x+2<board.length&&possibleMoveSpace(x,y,x+2,y))
                {
                    return false;
                }
                if(y-2>=1&&possibleMoveSpace(x,y,x,y-2))
                {
                    return false;
                }
                if(y+2<board[0].length&&possibleMoveSpace(x,y,x,y+2))
                {
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
        for (int i = 0;i<board.length;i++)
            for (int j = 0; j<board[0].length;j++)
                if(board[i][j]==1)
                count++;
        return count;
    }

    public void attemptCompute ( )
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

    //right, top, left, bottom
    //[0,1,2,3]
    public boolean findSolution(int n) {
        for (int i = 0; n <= 31 && i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                for (int direction : directions) {
                    if (board.jump(i, j, direction)) {
                        board.copyBoard(board, solution[n]);
                        if (! (n >= 31 && board.isOccupied(3, 3))) {
                            if ( findSolution(n + 1)) {
                                return true;
                            } else {
                                        board.jumpBack(i, j, direction);
                                    }
                                } else {
                            return true;
                                                    }
                                            }
                                    }
                            }                       
                    }
                    
                    return false;
            }

    public boolean jump(int x, int y, int moveSpace) {
                    int newX = getNewX(x, moveSpace);
                    int newY = getNewY(y, moveSpace);
    
                    if ( possibleMoveSpace(x, y, newX, newY)) {
                            setPeg(newX, newY);
                            clearField(x, y);
                            clearField((x + newX) / 2, (y + newY) / 2);
                            
                            return true;
                    }
                    
                    return false;
            }

            public void setPeg(int x, int y) {
                    board[x][y] = 1;
            }

     private int getNewX(int x, int direction) {
                    int newX = x;
                    switch (direction) {
                    case 0: newX += 2;
                                break;
                    case 2: newX -= 2;
                    }
                    return newX;
            }   

    private int getNewY(int y, int direction) {
                    int newY = y;
                    
                    switch (direction) {
                    case 1: newY -= 2;
                                    break;
                    case 3: newY += 2;
                    }
                    
                    return newY;
            }    





}


import java.awt.Color;
import java.awt.Font;
class GameBoard {
            
            private static final int OCCUPIED = 1;
            
            private static final int EMPTY = 0;
    
            private static final int RIGHT = 0;
            private static final int TOP = 1;
            private static final int LEFT = 2;
            private static final int BOTTOM = 3;
            
            /**
             * Contains all directions a peg can be moved according to the rules of the game.
             * In practice one should use an enumeration type.
             */
            private static int [] richtungen = {RIGHT, TOP, LEFT, BOTTOM};
            
            /**
             * the game borad with initial position of all pegs
             */

            private int [] [] board = new int[][]{{-1,-1,-1,1,1,1,-1,-1,-1},{-1,-1,-1,1,1,1,-1,-1,-1},{-1,-1,-1,1,1,1,-1,-1,-1},
                            {1,1,1,1,1,1,1,1,1},{1,1,1,1,0,1,1,1,1},{1,1,1,1,1,1,1,1,1},
                            {-1,-1,-1,1,1,1,-1,-1,-1},{-1,-1,-1,1,1,1,-1,-1,-1},{-1,-1,-1,1,1,1,-1,-1,-1}};

            // private int [] [] board = {
            //                 {0, 0, 0, 1, 1, 1, 0, 0, 0},
            //                 {0, 0, 0, 1, 1, 1, 0, 0, 0},
            //                 {0, 0, 0, 1, 1, 1, 0, 0, 0},
            //                 {1, 1, 1, 1, 1, 1, 1, 1, 1},
            //                 {1, 1, 1, 1, 2, 1, 1, 1, 1},
            //                 {1, 1, 1, 1, 1, 1, 1, 1, 1},
            //                 {0, 0, 0, 1, 1, 1, 0, 0, 0},
            //                 {0, 0, 0, 1, 1, 1, 0, 0, 0},
            //                 {0, 0, 0, 1, 1, 1, 0, 0, 0},
            // };
    
            /**
             * returns the width (always 7) of the board
             */
            public int getWidth() {
                    return board.length;
            }
    
            /**
             * returns the height (always 7) of the board
             */
            public int getHeight() {
                    return board.length;
            }
    
            public void clearField(int x, int y) {
                    board[x][y] = EMPTY;
            }
    
            public void setPeg(int x, int y) {
                    board[x][y] = OCCUPIED;
            }
    
            /**
             * copies the content of the  source to the target
             */
            public void copyBoard(GameBoard source, GameBoard target) {
                    for (int x = 0; x < getWidth(); x++) {
                   for (int y = 0; y < getHeight(); y++) {
                               target.board[x][y] = source.board[x][y];
                       }
                    }
            }
            
            /**
             * Checks whether there is a peg at (x,y), an empty field at (newX, newY),
             * and a peg between both fields.
             */
            private boolean isValidMove(int x, int y, int newX, int newY) {
                    return 0 <= x && x < board.length 
                            && 0 <= y && y < board[x].length
                            && 0 <= newX && newX < board.length 
                            && 0 <= newY && newY < board[newX].length
                            && board[newX][newY] == EMPTY
                            && board[(x + newX) / 2][(y + newY) / 2] == OCCUPIED
                            && board[x][y] == OCCUPIED;
                            
            }
            
            /**
             * Jumps the peg from (x,y) over the neighbouring peg in the given <code>direction</code>
             * and removes the peg we have jumped over. 
             * Returns true if the move was according to the game rules; and false otherwise.
             * The game board only changes state, if the move was valid.
             *       */
            public boolean jump(int x, int y, int direction) {
                    int newX = getNewX(x, direction);
                    int newY = getNewY(y, direction);
    
                    if ( isValidMove(x, y, newX, newY)) {
                            setPeg(newX, newY);
                            clearField(x, y);
                            clearField((x + newX) / 2, (y + newY) / 2);
                            
                            return true;
                    }
                    
                    return false;
            }
            
    
            /**
             * A peg "jumps back" and the previously removed peg is returned at
             * its proper position.
             */
            public void jumpBack(int x, int y, int direction) {
                    int newX = getNewX(x, direction);
                    int newY = getNewY(y, direction);
                    
                    clearField(newX, newY);
                    setPeg(x, y);
                    setPeg((x + newX) / 2, (y + newY) / 2);
            }
            
            private int getNewX(int x, int direction) {
                    int newX = x;
                    switch (direction) {
                    case RIGHT: newX += 2;
                                break;
                    case LEFT: newX -= 2;
                    }
                    return newX;
            }
            
            private int getNewY(int y, int direction) {
                    int newY = y;
                    
                    switch (direction) {
                    case TOP: newY -= 2;
                                    break;
                    case BOTTOM: newY += 2;
                    }
                    
                    return newY;
            }
            /**
             * Prints out the contents of this board with
             * <ul>
             * <li>0 = no valid field</li>
             * <li>1 = field with a peg</li>
             * <li>2 = field without a peg</li>
             * </ul>
             */
            public void print() {
                    for (int x = 0; x < board.length; x++) {
                            for (int y = 0; y < board[x].length; y++) {
                                    System.out.print(board[x][y]);
                            }
                            System.out.println();
                    }
                    System.out.println();
            }
            
            /**
             * Returns true if there is a peg at (x,y).
             */
            public boolean isOccupied(int x, int y) {
                    return board[x][y] == OCCUPIED;
            }
    
            
    }













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


public class A
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
    public A ( )
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
        A run = new A();
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
        drawBoard(true);
        StdDraw.show(pause);
        boolean cool = findSolution(1);
       
    }
            private int [] directions = {0, 1, 2, 3};













/**
             * the game board with values 1 (a peg), 2 (empty field), 0 (unused field)
             */
            
            /**
             * the solution given as a sequence of board situations
             */
            private GameBoard [] solution = new GameBoard[44];
                    private GameBoard original = new GameBoard();

            /**
             * all four possible directions for a move (jump of a peg over another peg)
             */
            
            /**
             * creates a new solitare instance with empty solution
             * and initial start position of all pegs
             */

       /**
        * Starts the backtracking algorithm and prints out the solution
        * as the sequence of all resulting intermediate board situation
            */

    
            /**
             * Backtracking algorithm to solve the solitare puzzle
             * 
             * @param move current number of move, first move must be 1
             */
            public boolean findSolution(int move) {
                    for (int x = 0; move <= 31 && x < original.getWidth(); x++) {
                            for (int y = 0; y < original.getHeight(); y++) {
                                    for (int direction : directions) {
                                            if (original.jump(x, y, direction)) {
                                                    original.copyBoard (original, solution[move]);
                                                    if (! (move >= 31 && original.isOccupied(3, 3))) {
                                                            if ( findSolution(move + 1)) {
                                                                    return true;
                                                            } else {
                                                                    original.jumpBack(x, y, direction);
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











}


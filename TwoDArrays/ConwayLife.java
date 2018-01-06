/**
 * ConwayLife.java
 * The Game of Life is ideally played on an infinite two-dimensional orthogonal grid of
 * square cells, each of which is in one of two possible states, alive or dead, or
 * "populated" or "unpopulated". Every cell interacts with its eight neighbours, which
 * are the cells that are horizontally, vertically, or diagonally adjacent. At each step
 * in time, the following transitions occur:
 * (1) Any live cell with fewer than 2 live neighbours dies, as if caused by underpopulation.
 * (2) Any live cell with 2 or 3 live neighbours lives on to the next generation.
 * (3) Any live cell with more than 3 live neighbours dies, as if by overpopulation.
 * (4) Any dead cell with exactly 3 live neighbours becomes a live cell, as if by reproduction.
 * The initial pattern constitutes the seed of the system. The first generation is created by
 * applying the above rules simultaneously to every cell in the seed - births and deaths occur
 * simultaneously, and the discrete moment at which this happens is sometimes called a tick
 * (in other words, each generation is a pure function of the preceding one). The rules
 * continue to be applied repeatedly to create further generations.
 * @author Surya Dantuluri
 * @version 1.0
 * @since 1/8/2018
 */

import java.util.Scanner;
import java.awt.Color;
import java.awt.Font;
import java.lang.Thread;

public class ConwayLife
{
    /**    The board object.  If a cell is alive, the value of the cell is true, and if
     *     the cell is dead, the value of the cell is false.    */
    private boolean [][] board;

    /**    The number of rows for the board.  Since the board is square, this is also the
     *     number of columns for the board.    */
    private final int NUMBEROFROWS = 150;

    /**    The edge length, to give the entire board a frame.   */
    private final double EDGE = 0.02;

    /**    Since the side length is 1, this SIDE will use everything but the edge for the
     *     drawing area.        */
    private final double SIDE = 1 - 2 * EDGE;

    /*     The width of an individual cell.        */
    private final double CELLWIDTH = SIDE / NUMBEROFROWS;

    /**
     *  Creates a ConwayLife object, with a sized graphics canvas, and a 2D array
     *  of boolean values, with all of them set to false (no live cells) to start with.
     */
    public ConwayLife ( )
    {
        StdDraw.setCanvasSize(800, 800);
        board = new boolean [NUMBEROFROWS][NUMBEROFROWS];
        for(int i = 0; i < board.length; i++)
        {
            for(int j = 0; j < board[i].length; j++)
            {
                board [i][j] = false;
            }
        }
    }

    /**
     *  Sets up and runs the game of Conway's Life.
     *  @param  args     An array of String arguments (the user can pass the name
     *  of a text file that indicates the live cells to start with).  If no argument
     *  is entered, "p1.txt" is the text file used by default.
     */
    public static void main(String [] args)
    {
        String textFile = "p1.txt";
        if(args.length > 0)
        {
            textFile = args[0];
        }
        ConwayLife life = new ConwayLife();
        life.initializeLife(textFile);
        life.runLife();
    }

    public void initializeLife(String textFile)
    {

        Scanner infile = OpenFile.openToRead(textFile);
        String temp = null;
        int col = 0;
        while(infile.hasNext())
        {
            temp = infile.nextLine();
            for(int row = 0; row < temp.length(); row++)
            {
                if(temp.charAt(row) == '*' && row < board.length && col < board[row].length)
                {
                    board[row][col] = true;
                }
            }
            col++;
        }
        infile.close();
/*
        Scanner infile = OpenFile.openToRead(textFile);      //  This block of code could be used
        int row = 0, col = 0;                          //  to read in ordered pairs for live
        while(infile.hasNext())                        //  cells from a text file.
        {
            row = infile.nextInt();
            col = infile.nextInt();
            board[row][col] = true;
        }
        infile.close();
*/
//        int aliveCells = 2000;                         //  This block of code could be used to
//        for(int i = 0; i < aliveCells; i++)            //  generate a random configuration of
//        {                                              //  live cells.
//            int randomRow = (int)(Math.random() * board.length);
//            int randomCol = (int)(Math.random() * board[0].length);
//            board[randomRow][randomCol] = true;
//        }
    }

    /**
     *  Runs a loop to show 1200 generations of Conway's Life.
     */
    public void runLife ( )
    {
        int gencount = 0;
        StdDraw.show(10);
        while(gencount <= 1200)
        {
            showLife(gencount);
            generateNext();
            if(gencount == 0)
            {
                StdDraw.show(500);
            }
            else
            {
                StdDraw.show(50);
            }
            gencount++;
        }
    }

    /**
     *  Draws the current generation of Conway's Life to the canvas.
     *  @param  gencount     The number of the current generation.
     */
    public void showLife(int gencount)
    {
        StdDraw.setPenColor(new Color(0,0,0));
        StdDraw.filledSquare(0.5,0.5,0.5);
        StdDraw.setPenColor(new Color(255,255,255));
        StdDraw.filledSquare(0.5,0.5,SIDE/2);
        for ( int i = 0; i < board.length; i++ )
        {
            for ( int j = 0; j < board[i].length; j++ )
            {
                if(board[i][j] == true)
                {
                    StdDraw.setPenColor(new Color(255,0,0));
                    StdDraw.filledSquare(EDGE + CELLWIDTH * i + CELLWIDTH/2, EDGE + CELLWIDTH * j + CELLWIDTH/2, CELLWIDTH / 2.0);
                }
            }
        }
        StdDraw.setPenColor(new Color(0,0,0));
        StdDraw.text(0.04, 0.96, "" + gencount);
    }

    /**
     *  Uses the rule for Conway's Life to generate the next generation (see the comment
     *  block at the top of this class).  The next generation if saved in a new 2D array,
     *  and, once created, is used to replace the previous generation (previous 2D array).
     */
    public void generateNext ( )
    {
 /*(1) Any live cell with fewer than 2 live neighbours dies, as if caused by underpopulation.
 * (2) Any live cell with 2 or 3 live neighbours lives on to the next generation.
 * (3) Any live cell with more than 3 live neighbours dies, as if by overpopulation.
 * (4) Any dead cell with exactly 3 live neighbours becomes a live cell, as if by reproduction.
 */
        boolean [][] nextboard = new boolean [board.length][board[0].length];

        for(int i = 0; i < board.length; i++)
        {
            for(int j = 0; j < board[i].length; j++)
            {
                int neighbors = countNeighbors(i, j);
                if(neighbors > 0)       //  Apply the rules
                {
                    //System.out.println("r,c "+i+" "+j+" has "+countNeighbors(i,j));     //  here, by changing/modifying
                    if(neighbors<2||neighbors>3)
                    nextboard[i][j] = false;
                    else if(neighbors==2||neighbors==3)
                    nextboard[i][j] = true;
                }
            }
        }
        board = nextboard;
    }

    /**
     *  Counts the neighbors of a given cell, identified by row and col.  The special
     *  cases of edges and corners must be considered.
     *  @param  row     The row of the current cell.
     *  @param  col     The column of the current cell.
     */
    public int countNeighbors(int row, int col)
    {
        //****
        //*A**
        //****
        //****
        int neighborcount = 0;

        for(int i = row-1; i <=row+1; i++)              //  This nested loop template
        {                                         //  is here to help you
            for(int j = col-1; j <=col+1; j++)          //  get started.
            {
                if(board[row][col] == true)
                {
                    System.out.println("row of "+i+" is a neighbor of "+row+" :: col of "+j+" is a neighbor of "+col);
                    neighborcount++;
                }
            }
        }
        return neighborcount;
    }
}

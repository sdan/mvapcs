        import java.util.Arrays;

    /**
     * Solves English peg solitare with 32 field and 31 pegs with the
     * help of a recursive backtring algorithm.
     * I have not checked every move of the solution: only the first few
     * and last few moves. I hope all other are valid moves as well.
     * 
     * @author Christian Pape
     *
     */
    class GameBoard {
            
            private static final int OCCUPIED = 1;
            
            private static final int EMPTY = 2;
    
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
            private int [] [] board = {
                            {0, 0, 1, 1, 1, 0, 0},
                            {0, 0, 1, 1, 1, 0, 0},
                            {1, 1, 1, 1, 1, 1, 1},
                            {1, 1, 1, 2, 1, 1, 1},
                            {1, 1, 1, 1, 1, 1, 1},
                            {0, 0, 1, 1, 1, 0, 0},
                            {0, 0, 1, 1, 1, 0, 0}
            };
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
    
            public int [] getDirections() {
                    return Arrays.copyOf(richtungen, richtungen.length); // JDK 1.6 nötig
            }
    }











































    public class Solitaer {
    
            /**
             * the game board with values 1 (a peg), 2 (empty field), 0 (unused field)
             */
            private GameBoard board = new GameBoard();
            
            /**
             * the solution given as a sequence of board situations
             */
            private GameBoard [] solution = new GameBoard[44];
    
            /**
             * all four possible directions for a move (jump of a peg over another peg)
             */
            private int [] directions = board.getDirections();
            
            /**
             * creates a new solitare instance with empty solution
             * and initial start position of all pegs
             */
            public Solitaer() {
                    for (int i = 0; i < solution.length; i++) {
                            solution[i] = new GameBoard();
                    }
            }
       /**
        * Starts the backtracking algorithm and prints out the solution
        * as the sequence of all resulting intermediate board situation
            */
            public static void main(String[] args) {
                    Solitaer solitaer = new Solitaer();
    
                    long t1 = System.currentTimeMillis();
                    if (solitaer.findSolution(1)) {
                            System.out.println("Solution found in " + (System.currentTimeMillis() - t1) + " [ms]");
    
                            solitaer.printSolution();
                    } else {
                            System.out.println("No solution found!?");
                    }
            }
    
            /**
             * Backtracking algorithm to solve the solitare puzzle
             * 
             * @param move current number of move, first move must be 1
             */
            public boolean findSolution(int move) {
                    for (int x = 0; move <= 31 && x < board.getWidth(); x++) {
                            for (int y = 0; y < board.getHeight(); y++) {
                                    for (int direction : directions) {
                                            if (board.jump(x, y, direction)) {
                                                    board.copyBoard (board, solution[move]);
                                                    if (! (move >= 31 && board.isOccupied(3, 3))) {
                                                            if ( findSolution(move + 1)) {
                                                                    return true;
                                                            } else {
                                                                    board.jumpBack(x, y, direction);
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
    
            /**
             * Gibt die Lösung als Folge von Spielbrettern am Bildschirm aus.
             *
             */
            private void printSolution() {
                    for (int zug = 0; zug < solution.length; zug++) {
                            solution[zug].print();
                    }
            }
    }




























































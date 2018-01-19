   
    import java.util.Arrays;
   

    public class Board {
           
            private static final int OCCUPIED = 1;
           
            private static final int EMPTY = 2;
   
            private static final int RIGHT = 0;
            private static final int UP = 1;
            private static final int LEFT = 2;
            private static final int DOWN = 3;
           
           
            private static int [] directions = {RIGHT, UP, LEFT, DOWN};
           
           
           int [] [] board = {
                            {0, 0, 1, 1, 1, 0, 0},
                            {0, 0, 1, 1, 1, 0, 0},
                            {1, 1, 1, 1, 1, 1, 1},
                            {1, 1, 1, 2, 1, 1, 1},
                            {1, 1, 1, 1, 1, 1, 1},
                            {0, 0, 1, 1, 1, 0, 0},
                            {0, 0, 1, 1, 1, 0, 0}
//                            {0, 0, 2, 2, 2, 0, 0},
//                            {0, 0, 2, 1, 2, 0, 0},
//                            {2, 2, 1, 1, 1, 2, 2},
//                            {2, 2, 2, 1, 2, 2, 2},
//                            {2, 2, 2, 1, 2, 2, 2},
//                            {0, 0, 2, 2, 2, 0, 0},
//                            {0, 0, 2, 2, 2, 0, 0}
            };
           int [] [] numberBoard = {
                   {0, 0, 0, 1, 2, 0, 0},
                   {0, 0, 3, 4, 5, 0, 0},
                   {6, 7, 8, 9, 10, 11, 12},
                   {13, 14, 15, 16, 17, 18, 19},
                   {20, 21, 22, 23, 24, 25, 26},
                   {0, 0, 27, 28, 29, 0, 0},
                   {0, 0, 30, 31, 32, 0, 0}
           };
   
          
           
            public void clearField(int x, int y) {
                    board[x][y] = EMPTY;
            }
   
            public void setPeg(int x, int y) {
                    board[x][y] = OCCUPIED;
            }
   
           
            public void copy(Board source, Board target) {
                    for (int x = 0; x < 7; x++) {
                   for (int y = 0; y < 7; y++) {
                               target.board[x][y] = source.board[x][y];
                       }
                    }
            }
           
           
            private boolean isValidMove(int x, int y, int newX, int newY) {
                    return 0 <= x && x < board.length
                            && 0 <= y && y < board[x].length
                            && 0 <= newX && newX < board.length
                            && 0 <= newY && newY < board[newX].length
                            && board[newX][newY] == EMPTY
                            && board[(x + newX) / 2][(y + newY) / 2] == OCCUPIED
                            && board[x][y] == OCCUPIED;
                          
            }
           
           
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
           
   
           
           public void goBack(int x, int y, int direction) {
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
                    case UP: newY -= 2;
                                    break;
                    case DOWN: newY += 2;
                    }
                  
                   return newY;
           }
           
            public void print() {
                    for (int x = 0; x < board.length; x++) {
                            for (int y = 0; y < board[x].length; y++) {
                                   System.out.print(board[x][y]);
                            }
                            System.out.println();
                    }
                    System.out.println();
            }
           
           
            public boolean isOccupied(int x, int y) {
                    return board[x][y] == OCCUPIED;
            }
   
            public int [] getDirections() {
                    return Arrays.copyOf(directions, directions.length); // JDK 1.6 nötig
            }
    }


//Solitaer.java

package peg;

    public class Solitaer {
   
           
            private Board board = new Board();
           
          
            int sol=Heuristic(board);
           private Board [] solution= new Board[sol+1];
   
           private int [] directions = board.getDirections();
           
          
            public Solitaer() {
//            	sol=Heuristic();
//            	solution = new Board[sol+1];
                    for (int i = 0; i < solution.length; i++) {
                            solution[i] = new Board();
                    }
           }
      
            public static void main(String[] args) {
                   Solitaer solitaer = new Solitaer();
                  
                   long t1 = System.currentTimeMillis();
                    if (solitaer.finalSol(1)) {
                           System.out.println("Solution found in " + (System.currentTimeMillis() - t1) + " [ms]");
   
                            solitaer.solvePuzzle();
                    } else {
                            System.out.println("No solution found!?");
                    }
                    solitaer.printPath();
            }
   
          
            public boolean finalSol(int step) {
//            	System.out.println(sol);
                    for (int x = 0; step <= sol && x < 7; x++) {
                     for (int y = 0; y < 7; y++) {
                       for (int direction : directions) {
                        if (board.jump(x, y, direction)) {
                        	board.copy(board, solution[step]);
//                            if (! (step >= sol && board.isOccupied(3, 3))) {
                        	if (!((Heuristic(board)==0) && board.isOccupied(3, 3))) {
                              if ( finalSol(step + 1)) {
                                                            	
                                    return true;
                                     } else {
                                     board.goBack(x, y, direction);
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
   
           
           
            public int Heuristic(Board board) {//calculate Heuistic Cost
//            	System.out.println("**************************");	
                int cost = 0;
                for (int x = 0; x < 7; x++) {
                    for (int y = 0; y < 7; y++) {
                    	if(board.board[x][y]==1)
                    	{
                    		cost++;
//                    		System.out.println(cost);
                    	}
                       
                    }
                }
                return cost-1;
            }
          
       
            int a, b, count;
            public void printPath()
            {
            	Board[] pathBoard=solution;
            	for(int i=0;i<pathBoard.length-1;i++)
            	{
            	
            		count=0;
            		b=-1;
            		a=0;
            	for (int x = 0; x < 7; x++) {
                    for (int y = 0; y < 7; y++) {
            	if(pathBoard[i].board[x][y]==1&&pathBoard[i+1].board[x][y]==2)
            	{
            		
            		if(x-2>=0)
            		{
//            			System.out.println("1----"+x+"-----");
            		if(pathBoard[i].board[x-2][y]!=pathBoard[i+1].board[x-2][y])
            				{
//            			System.out.println("1----!"+x+"-----");
            			b=board.numberBoard[x-2][y];
            				}
            		}
            		
            			if(x+2<=6)
            			{
//            				System.out.println("2----"+x+"-----");
            			if(pathBoard[i].board[x+2][y]!=pathBoard[i+1].board[x+2][y])
        				{
//            				System.out.println("1----!"+x+"-----");
        			b=board.numberBoard[x+2][y];
        				}
            			}
        		
        			if(y-2>=0)
        			{
//        				System.out.println("3----"+y+"-----");
        			if(pathBoard[i].board[x][y-2]!=pathBoard[i+1].board[x][y-2])
    				{
//        				System.out.println("1----!"+y+"-----");
    			b=board.numberBoard[x][y-2];
    				}
        			}
    		
    			if(y+2<=6)
    			{
//    				System.out.println("4----"+y+"-----");
    			if(pathBoard[i].board[x][y+2]!=pathBoard[i+1].board[x][y+2])
				{
//    				System.out.println("1----!"+y+"-----");
			b=board.numberBoard[x][y+2];
				}
    			}
            		
            		if(b!=-1)
            		{
            			a=board.numberBoard[x][y];
            	count=count+1;
            	break;
            		}
            		
            	}
            	if(count==1)
            		break;
                }  
                    if(count==1)
                		break;

            	}
            	
            	System.out.print("<"+a+","+b+">"+" ");
            	}
            	
            }
            private void solvePuzzle() {
                    for (int i = 0; i < solution.length; i++) {
                            solution[i].print();
                    }
                   
            }
    }

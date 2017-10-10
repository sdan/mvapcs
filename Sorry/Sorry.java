import java.util.Scanner;
public class Sorry
{
    private Scanner keyboard;
    private SorryPlayer player1, player2;
    private DiceGroup dice;
    private SorryScoreCard card;
    private boolean player1turn;

    public Sorry()
    {
        keyboard = new Scanner(System.in);
        player1 = new SorryPlayer();
        player2 = new SorryPlayer();
        dice = new DiceGroup();
        card = new SorryScoreCard();
        player1turn = true;
    }

    public static void main(String[]args)
    {
        Sorry game = new Sorry();
        game.playOneGame();

    }

    public void playOneGame()
    {
        introduction();
        getName(player1,1);
        getName(player2,2);
        chooseWhoGoesFirst();
        card.printScoreCardHeading();
        card.printPlayerStatus(player1);
        card.printPlayerStatus(player2);
        for(int i = 1;i<=13;i++)
        {
            takeATurnForEachPlayer(i);
        }
    }



//  To be used in Sorry.java
    public void introduction ( )
    {
        System.out.println("\n\n+------------------------------------------------------------------------------------+");
        System.out.println("| WELCOME TO SORRY!                                                                  |");
        System.out.println("|                                                                                    |");
        System.out.println("| The game of SORRY(TM) is a battle between two players.  This game is played on a   |");
        System.out.println("| game board of 20 cells, and the players use 3 4-sided dice.  The game starts with  |");
        System.out.println("| the players entering their names, then rolling the dice, attempting to roll the    |");
        System.out.println("| highest sum, to determine who will go first.  Once the starting player is          |");
        System.out.println("| determined, the players alternate turns.  During each turn a player rolls the 3    |");
        System.out.println("| dice, and can reroll the dice (or subsets of the dice) 2 other times.  At the end  |");
        System.out.println("| of the player's turn, the player chooses how to apply the dice values to the 3     |");
        System.out.println("| game pieces.  The game pieces are labeled a, b, and c, and the player tries to     |");
        System.out.println("| move these pieces along the board.  If one or more of the player's pieces lands on |");
        System.out.println("| any other piece, the piece that is landed on goes back to the starting point.      |");
        System.out.println("| This is true even if it is the player's own game piece.  The winning player is the |");
        System.out.println("| one that gets all 3 pieces to the end of the board first.                          |");
        System.out.println("|                                                                                    |");
        System.out.println("| LET'S PLAY SOME SORRY!                                                             |");
        System.out.println("+------------------------------------------------------------------------------------+\n\n");
    }

    public void getName (SorryPlayer sp, int num)
    {
        System.out.print("\nPlayer " + num + ", please enter your first name : ");
        String name = keyboard.nextLine();
        sp.setName(name);
    }

    public void chooseWhoGoesFirst ( )
    {
        int player1Sum, player2Sum;
        do
        {
            System.out.print("\nLet's see who will go first.  " + player1.getName() + ", please hit enter to roll the dice : ");
            keyboard.nextLine();
            dice.rollDice();
            dice.printDice();
            player1Sum = dice.getTotal();
            System.out.print("\n" + player2.getName() + ", it's your turn.  Please hit enter to roll the dice : ");
            keyboard.nextLine();
            dice.rollDice();
            dice.printDice();
            player2Sum = dice.getTotal();
            if (player1Sum == player2Sum)
            {
                System.out.println("Whoops, we have a tie (both rolled " + player1Sum +
                    "). Looks like we'll have to try that again . . .");
            }
        } while (player1Sum == player2Sum);
        setFirstPlayer(player1Sum,player2Sum);
    }

    public void setFirstPlayer (int p1sum, int p2sum)
    {
        System.out.print("\n" + player1.getName() + ", you rolled a sum of " + p1sum);
        System.out.print(", and " + player2.getName() + ", you rolled a sum of " + p2sum + ".");
        if (p1sum > p2sum)
        {
            player1turn = true;
            System.out.println("\n" + player1.getName() + ", since your sum was higher, you'll roll first.\n");
        }
        else
        {
            player1turn = false;
            System.out.println("\n" + player2.getName() + ", since your sum was higher, you'll roll first.\n");
        }
    }

    public void takeATurnForEachPlayer (int turn)
    {
        if (player1turn)
        {
            takeTurn(player1);
            takeTurn(player2);
        }
        else
        {
            takeTurn(player2);
            takeTurn(player1);
        }
    }

    public void takeTurn (SorryPlayer sp)
    {
        System.out.print("\n" + sp.getName() + ", it's your turn to play.  Please hit enter to roll the dice : ");
        keyboard.nextLine();
        dice.rollDice();
        dice.printDice();
        promptForAnotherRoll();
        String rawHold = keyboard.nextLine();
        if (!rawHold.equals("-1"))
        {
            dice.rollDice(rawHold);
            dice.printDice();
            promptForAnotherRoll();
            rawHold = keyboard.nextLine();
            if (!rawHold.equals("-1"))
            {
                dice.rollDice(rawHold);
                dice.printDice();
            }
        }
        makeChoice(sp);
    }

    public void promptForAnotherRoll ( )
    {
        System.out.println("Which di(c)e would you like to keep?  Enter the values you'd like to 'hold' without");
        System.out.println("spaces.  For examples, if you'd like to 'hold' die 1, 2, and 5, enter 125");
        System.out.print("(enter -1 if you'd like to end the turn) : ");
    }

//  To be used in Sorry.java
    public void makeChoice (SorryPlayer sp)
    {
        card.printScoreCardHeading();
        card.printPlayerStatus(player1);
        card.printPlayerStatus(player2);
        boolean badinput = false;
        String order = new String("");
        do
        {
            badinput = false;
            System.out.println("\n" + sp.getName() + ", now it's time to choose the pieces you would like to move with the");
            System.out.println("dice you rolled.  For example, if you'd like your dice score to match up with pieces a, then");
            System.out.println("b, then c, then enter abc.  If you'd like the first two dice to go toward piece a, then the");
            System.out.print("third dice toward piece b, then enter aab: ");
            order = keyboard.nextLine().trim().toLowerCase();
            if(order.length() < 3 || order.length() > 3)
            {
                badinput = true;
            }
            for(int i = 0; i < order.length(); i++)
            {
                if(order.charAt(i) != 'a' && order.charAt(i) != 'b' && order.charAt(i) != 'c')
                {
                    badinput = true;
                }
            }
        }
        while(badinput);

        card.movePieces(sp, dice, order);
    }

    public void finalMessage ( )
    {
        System.out.println("\n\nThanks for playing Monta Vista YAHTZEE!");
        System.out.println("Here are the final results:\n");
        player1.printScore();
        player2.printScore();
        System.out.println("\n\n\n");
    }
}

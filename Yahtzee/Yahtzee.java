import java.util.Scanner;
public class Yahtzee
{
    private Scanner keyboard;
    private YahtzeePlayer player1, player2;
    private DiceGroup dice;
    private YahtzeeScoreCard card;
    private boolean player1turn;

    public Yahtzee()
    {
        keyboard = new Scanner(System.in);
        player1 = new YahtzeePlayer();
        player2 = new YahtzeePlayer();
        dice = new DiceGroup();
        card = new YahtzeeScoreCard();
        player1turn = true;
    }

    public static void main(String[]args)
    {
        Yahtzee game = new Yahtzee();
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

        public void introduction ( )
    {
        System.out.println("\n\n+------------------------------------------------------------------------------------+");
        System.out.println("| WELCOME TO MONTA VISTA YAHTZEE!                                                    |");
        System.out.println("|                                                                                    |");
        System.out.println("| There are 13 rounds in a game of Yahtzee. In each turn, a player can roll his/her  |");
        System.out.println("| dice up to 3 times in order to get the desired combination. On the first roll, the |");
        System.out.println("| player rolls all five of the dice at once. On the second and third rolls, the      |");
        System.out.println("| player can roll any number of dice he/she wants to, including none or all of them, |");
        System.out.println("| trying to get a good combination.                                                  |");
        System.out.println("| The player can choose whether he/she wants to roll once, twice or three times in   |");
        System.out.println("| each turn. After the three rolls in a turn, the player must put his/her score down |");
        System.out.println("| on the scorecard, under any one of the thirteen categories. The score that the     |");
        System.out.println("| player finally gets for that turn depends on the category/box that he/she chooses  |");
        System.out.println("| and the combination that he/she got by rolling the dice. But once a box is chosen  |");
        System.out.println("| on the score card, it can't be chosen again.                                       |");
        System.out.println("|                                                                                    |");
        System.out.println("| LET'S PLAY SOME YAHTZEE!                                                           |");
        System.out.println("+------------------------------------------------------------------------------------+\n\n");
    }

    public void getName (YahtzeePlayer yp, int num)
    {
        System.out.print("\nPlayer " + num + ", please enter your first name : ");
        String name = keyboard.nextLine();
        yp.setName(name);
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
        System.out.println("\nRound " + turn + " of 13 rounds.");
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

    public void takeTurn (YahtzeePlayer yp)
    {
        System.out.print("\n" + yp.getName() + ", it's your turn to play.  Please hit enter to roll the dice : ");
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
        makeChoice(yp);
    }

    public void promptForAnotherRoll ( )
    {
        System.out.println("Which di(c)e would you like to keep?  Enter the values you'd like to 'hold' without");
        System.out.println("spaces.  For examples, if you'd like to 'hold' die 1, 2, and 5, enter 125");
        System.out.print("(enter -1 if you'd like to end the turn) : ");
    }

    public void makeChoice (YahtzeePlayer yp)
    {
        card.printScoreCardHeading();
        card.printPlayerStatus(player1);
        card.printPlayerStatus(player2);
        System.out.println("                  1    2    3    4    5    6    7    8    9   10   11   12   13\n");
        System.out.print(yp.getName() + ", now you need to make a choice.  ");
        int choice;
        do
        {
            System.out.print("Pick a valid integer from the list above : ");
            choice = keyboard.nextInt();
            keyboard.nextLine();
        } while (choice < 1 || choice > 13 || yp.getScoreArrayElement(choice-1) != -1);
        card.changeScore(yp, dice, choice);
        card.printScoreCardHeading();
        card.printPlayerStatus(player1);
        card.printPlayerStatus(player2);
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

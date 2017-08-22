/**
*  Matador.java
*  In this game, the user will start with 200 dollars.
*  The user places a bet (a random number of dollars
*  from 1 to 10), then chooses a possible outcome for
*  the rolling of 3 6-sided dice:
*  (1) Any Triple (betting that all 3 dice will show the same number), at 30 to 1 odds
*  (2) Go Big (betting that the sum of the dice will be 11 or higher, and not a triple), at 1 to 1 odds
*  (3) Go Small (betting that the sum of the dice will be 10 or lower, and not a triple), at 1 to 1 odds
*  (4) Go Extreme (betting that the sum of the dice will be less than 8 or greater than 12), at 1 to 1 odds
*  The dice are then rolled, and the player either wins or loses,
*  with the appropriate amount of money either added or subtracted
*  from the player's total.  The game is then repeated, and this
*  continues until the player winds up with 0 dollars.
*  The number of turns (games played) is then displayed
*  and the game terminates.
*
*  @author Surya Dantuluri
*  @version 1.0
*  @since 8/21/2017
*/
public class Matador
{
	/**    Declare fields here.    */
	private int money;
	private Dice die1, die2, die3, wagerValue, possibleChoice;
	/**
	*  Creates a Matador object, with three six-sided Dice, one
	*  ten-sided die for the money bet, and a four-sided die
	*  for the bet choice.  Sets the amount of money to 200 dollars.
	*/
	public Matador ( )
	{
		money = 200;
		die1 = new Dice(6);//1-6
		die2 = new Dice(6);//1-6
		die3 = new Dice(6);//1-6
		wagerValue = new Dice(10);//1-10
		possibleChoice = new Dice(4);//1-4


	}

	/**
	*  Sets up and runs the rounds of Matador.
	*  @param  args     An array of String arguments (not used here).
	*/
	public static void main (String [] args)
	{
		Matador run = new Matador();
		run.playGames();
	}

	/**
	*  Plays all of the rounds of Matador, until the player has no money left.
	*/
	public void playGames ( )
	{
		System.out.println("\n\n\n");
		do
		{
			int roundNumber = die1.getRollCount()+1;
			System.out.println("+----------------------------------------------------------------+");
			System.out.printf("|  ROUND %5d                                                   |%n",roundNumber);
			playASingleGame();
		}
		while(money > 0);
		System.out.println("+----------------------------------------------------------------+\n");
		System.out.println("\n\nSorry, but you know that the house always wins!\n\n\n\n\n");
	}

	/**
	*  Plays a single game of Matador.
	*/
	public void playASingleGame ( )
	{
		die1.roll();die2.roll();die3.roll();
		int die1RollValue = die1.getValue();
		int die2RollValue = die2.getValue();
		int die3RollValue = die3.getValue();
		boolean possibleChoiceValid = false;
		/** Prints out how much money user currently has */
		System.out.printf("|  Your money total:  $%4d                                      |%n",money);
		/** Prints out how much the user wagers (random int)*/
		wagerValue.roll();
		System.out.printf("|  Your wager      :  $%4d                                      |%n",wagerValue.getValue());
		System.out.print("|  Your choice     :  ");
		switch (possibleChoice.roll())
		{
			case 1:	System.out.println("Any Triple (30 to 1)                       |");
							possibleChoiceValid = possibleChoiceCalculate(1);
			break;
			case 2: System.out.println("Go Big (sum >= 11, not a triple, 1 to 1)   |");
							possibleChoiceValid = possibleChoiceCalculate(2);
			break;
			case 3: System.out.println("Go Small (sum <= 10, not a triple, 1 to 1) |");
							possibleChoiceValid = possibleChoiceCalculate(3);
			break;
			case 4: System.out.println("Go Extreme (sum < 8 or sum > 12, 1 to 1)   |");
							possibleChoiceValid = possibleChoiceCalculate(4);
		}
		System.out.printf("|  Roll            :%3d%3d%3d                                    |%n",die1RollValue,die2RollValue,die3RollValue);
		System.out.printf("|  Sum             :  %-2d             +---------------+           |%n",money);
		System.out.print("|  A Triple        :  ");
		System.out.print("YES            ");
		//System.out.print("NO             ");
		System.out.println("|   YOU WIN!    |           |");
		//System.out.println("|   YOU LOSE!   |           |");
		System.out.printf("|  New money total :  $%4d          +---------------+           |%n",money);
	}

	public boolean possibleChoiceCalculate(int choice)
	{
		boolean tripleTrue = (die1RollValue==die2RollValue)&&(die2RollValue==die3RollValue));
		int sumOfDiceRollValue = die1RollValue+die2RollValue+die3RollValue;
		if(choice==1 && tripleTrue)
		{
			return true;
		}
		else if(choice==2 && sumOfDiceRollValue>=11)
		{
			return true;
		}
		else if(choice==3 && sumOfDiceRollValue<=10)
		{
			return true;
		}
		else if(choice==4 && (sumOfDiceRollValue<8&&sumOfDiceRollValue>12))
		{
			return true;
		}
		else
		{
			return false;
		}
	}

}

/**
 * Jackpot.java
 * Simulates a dice game. The user is prompted to
 * enter the number of sides for the 3 dice, with
 * a minimum of 6 sides and a maximum of 20 sides.
 * The dice are then rolled until they all show
 * the same face value. The total number of rolls
 * is then displayed, and then the program ends.
 * @author Surya Dantuluri
 * @version 1.0
 * @since 8/15/2017
 */
 
 public class Jackpot 
 {
	 /** The 3 dice to be rolled. */
	 private Dice die1, die2, die3;
	 
	 /** The number of sides for the dice. */
	 private int numSides;
	 
	 /** Creates a Jackpot object, setting the dice
	  * and numSides to default values.
	  */
	 public Jackpot()
	 {
		numSides = 6; 
		die1 = new Dice();
		die2 = new Dice();
		die3 = new Dice();
	 }
	 /** Runs the game of Jackpot */
	 public static void main(String [] args)
	 {
		 Jackpot game = new Jackpot();
		 game.getInput();
		 game.rollDice();
	 }
	 /** Gets the number of sides for the dice (user input) */
	 public void getInput()
	 {
		 
	 }
	 
	 /** Rolls the three dice, displaying the group of 3.
	  *  Continues to roll and display the dice until the
	  *  3 dice all show the same value. Then prints an 
	  *  exit message displaying the number of rolls.
	  */
	 public void rollDice()
	 {
		do
		{
			die1.roll();
			die2.roll();
			die3.roll();
			System.out.printf("%4d%4d%4d\n",die1.getValue(),die2.getValue(),die3.getValue());
		}
		while(!(die1.getValue()==die2.getValue()&&die2.getValue()==die3.getValue()));
		 
	 }
 }

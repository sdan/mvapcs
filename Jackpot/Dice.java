/**
 * Dice.java
 * Simulate a single die. An instance of the Dice
 * class has a number of sides, a roll count, and
 * a face value (last rolled value). Two constructors
 * are included, alonog with getter and setter methods.
 * @author Surya Dantuluri
 * @version 1.0
 * @since 8/17/2017
 */

 public class Dice
 {
	 /** The number of sided for the dice. */
	 private int numSides;
	 /** The number of times the die has been rolled. */
	 private int rollCount;
	 /** The last rolled value for the die */
	 private int value;

	 /** Create a Duce object, with 6 sides, roll count
	  * set to 0, value set to -1.
	  */
	  public Dice()
	  {
		  numSides = 6;
		  rollCount = 0;
		  value = -1;
	  }

	  /** Create a Duce object, with n sides, roll count
	  * set to 0, value set to -1.
	  * @param n The number of sides for the Dice object constructed.
	  */
	  public Dice(int n)
	  {
		  numSides = n;
		  rollCount = 0;
		  value = -1;
	  }

	  /** Roll the die. The roll count will be increased by
	   *  one every time this method is called, and the roll
	   *  value is set equal to a random integer from 1 to
	   *  numSides.
	   *  @return The face value that was rolled.
	   */
	   public int roll()
	   {
			rollCount++;
			value = (int)(Math.random()*numSides)+1;
			return value;
	   }

	   /**Get the roll count.
	    * @return The current roll count.
	    */
	    public int getRollCount()
	    {
			return rollCount;
		}

		/** Gets the value of the die.
		 *  @return The current value of the die.
		 */
		 public int getValue()
		 {
			 return value;
		 }
 }

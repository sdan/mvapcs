//  Surya Dantuluri
//  8/20/2017
//  Prompt.java
//  Provide some utilities for user input.  This
//  class enhances the Scanner class, so that our
//  client classes can recover from "bad" input,
//  such as input outside of described parameters
//  and input in the wrong format (such as a
//  String instead of an int).
import java.util.Scanner;

public class Prompt
{
  //Prompts user for a string and returns that String
  public static String getString(String ask)
  {
    Scanner in = new Scanner(System.in);
    System.out.print(ask);
    String input = in.nextLine();
    return input;
  }
  //Prompts user for an int, dynamically checks if user inputs int
  public static int getInt(String ask)
  {
    boolean valid = false;
    String input = "";
    int val = 0;
    do
    {
      bool valid=false;
      input = getString(ask);
      try
      {
         val= Integer.parseInt(input);
      }
      catch(NumberFormatException e)
      {
        valid = true;
      }    }
      while(valid);
    }

    /*  Prompts the user and picks up an int.  Checks for
	 *  "bad" input and reprompts if not an int.  Also checks
	 *  for input within a given range, and reprompts if outside
	 *  that range.
	 *  @param ask       The String prompt to be displayed to the user.
	 *  @param min       The minimum integer value to be allowed as input.
	 *  @param max       The maximum integer value to be allowed as input.
	 *  @return          The int entered by the user.
	 */
	public static int getInt(String ask, int min, int max)
	{
		int val = 0;
		do
		{
			val = getInt(ask + " (from " + min + " to " + max + "): ");
		}
		while(val < min || val > max);
		return val;
	}
  }

/**
 *  Prompt.java
 *  Provides utilities for user input.
 *  "Enhances" the Scanner class, so that
 *  our programs can recover from "bad" input,
 *  and also provide a way to limit numerical
 *  input to a range of values.  Methods for
 *  reading in Strings, ints, and doubles.
 *  @author Surya Dantuluri
 *  @version 1.0
 *  @since 8/22/2017
 */
import java.util.Scanner;
public class Prompt
{
	/**
	 *  Prompts the user and picks up a String.
	 *  @param ask       The String prompt to be displayed to the user.
	 *  @return          The String entered by the user.
	 */
	public static String getString (String ask)
	{
		Scanner keyboard = new Scanner(System.in);
		System.out.print(ask);
		String input = keyboard.nextLine();
		return input;
	}

	/**
	 *  Prompts the user and picks up an int.  Checks for
	 *  "bad" input and reprompts if not an int.
	 *  @param ask       The String prompt to be displayed to the user.
	 *  @return          The int entered by the user.
	 */
	public static int getInt (String ask)
	{
		boolean badinput = false;
		String input = new String("");
		int value = 0;
		do
		{
			badinput = false;
			input = getString(ask);
			try
			{
				value = Integer.parseInt(input);
			}
			catch(NumberFormatException e)
			{
				badinput = true;
			}

		}
		while(badinput);
		return value;
	}

	/**
	 *  Prompts the user and picks up an int.  Checks for
	 *  "bad" input and reprompts if not an int.  Also checks
	 *  for input within a given range, and reprompts if outside
	 *  that range.
	 *  @param ask       The String prompt to be displayed to the user.
	 *  @param min       The minimum integer value to be allowed as input.
	 *  @param max       The maximum integer value to be allowed as input.
	 *  @return          The int entered by the user.
	 */
	public static int getInt (String ask, int min, int max)
	{
		int value = 0;
		do
		{
			value = getInt(ask);
		}
		while(value < min || value > max);
		return value;
	}

/**
	 *  Prompts the user and picks up a.  Checks for
	 *  "bad" input and reprompts if not a double.
	 *  @param ask       The String prompt to be displayed to the user.
	 *  @return          The double entered by the user.
	 */
	public static double getDouble (String ask)
	{
		boolean badinput = false;
		String input = new String("");
		double value = 0.0;
		do
		{
			badinput = false;
			input = getString(ask);
			try
			{
				value = Double.parseDouble(input);
			}
			catch(NumberFormatException e)
			{
				badinput = true;
			}

		}
		while(badinput);
		return value;
	}

		/**
	 *  Prompts the user and picks up a double.  Checks for
	 *  "bad" input and reprompts if not a double.  Also checks
	 *  for input within a given range, and reprompts if outside
	 *  that range.
	 *  @param ask       The String prompt to be displayed to the user.
	 *  @param min       The minimum double value to be allowed as input.
	 *  @param max       The maximum double value to be allowed as input.
	 *  @return          The int entered by the user.
	 */
	public static double getDouble (String ask, double min, double max)
	{
		double value = 0;
		do
		{
			value = getDouble(ask + " (from " + min + " to " + max + "): ");
		}
		while(value < min || value > max);
		return value;
	}

	/**
	 *  Prompts the user and picks up an int.  Checks for
	 *  "bad" input and reprompts if not an int.
	 *  @param ask       The String prompt to be displayed to the user.
	 *  @return          The int entered by the user.
	 */
	public static char getChar (String ask)
	{
		String input = new String("");
		char value = ' ';
		input = getString(ask);
		value = input.charAt(0);
		return value;
	}

	/**
	 *  Prompts the user and picks up an int.  Checks for
	 *  "bad" input and reprompts if not an int.
	 *  @param ask       The String prompt to be displayed to the user.
	 *  @return          The int entered by the user.
	 */
	public static char getChar (String ask, char input[])
	{
		boolean done = false;
		char value = ' ';
		do
		{
			done = false;
			value = getChar(ask);
			for(int i =0; i<input.length; i++){
				if((input[i])==(value)){
				done = true;
				}
			}
		}
		while(!done);
		return value;
	}


}

/**
 * Readability.java
 * E        D           I       T       H E R E
 * @author Surya Dantuluri
 * @version 1.0
 * @since 9/18/2017
 */

import java.util.Scanner;

public class Readability
{
	/**  The String that holds all of the text file contents. */
	private String wholeText;

	/**
	 * Creates a Readability object, creating
	 * a default String object.
	 */
	public Readability ( )
	{
		wholeText = new String("");
	}

	/**
	 *  Sets up and runs Readability for a text file chose by the user.
	 *  @param  args     An array of String arguments (the first element,
	 *                   at index 0, should be the name of the text file).
	 */
	public static void main(String [] args)
	{
		Readability run = new Readability();
		if(args.length > 0)
		{
			run.readInText(args[0]);
      System.out.println("team100");
		}
		else
		{
			run.readInText("gr.txt");
		}
		run.calculateReadability();
	}

  /**
	 *  Write the methods readInText and calculateReadability, along with
	 *  any other methods that are necessary.
	 */

  public void readInText(String inputFileName)
  {
    String fullTextFile = "";
    Scanner infile = OpenFile.openToRead(inputFileName);
    while(infile.hasNextLine())
    {
      fullTextFile+=infile.nextLine();
      System.out.println(infile.nextLine());
    }
    System.out.println("jakepaul ");
  }

  public void calculateReadability()
  {
    System.out.println("loganpaul ");
  }



}

/*
C:\java>java Readability gr.txt



  Text File  : gr.txt

  Sentences  : 140
  Words      : 809
  Syllables  : 825

  Readability: 114.697




C:\java>java Readability under.txt



  Text File  : under.txt

  Sentences  : 20
  Words      : 216
  Syllables  : 307

  Readability: 75.631




C:\java>java Readability h.txt



  Text File  : h.txt

  Sentences  : 43
  Words      : 627
  Syllables  : 814

  Readability: 82.203




C:\java>java Readability s.txt



  Text File  : s.txt

  Sentences  : 11
  Words      : 392
  Syllables  : 694

  Readability: 20.888




C:\java>
*/

/**
* SuperH.java
* EDIT                                                                HERE
* @author Surya Dantuluri
* @version 1.0
* @since 10/24/2017
*/

import java.util.Scanner;

public class SuperH
{
  /** The list of words that are possible solutions to the current "word" being looked for by the user. */
  /** You should start with the simpler game of Hangman, and make this a single String, not an array    */
  /** of String.     */
  private String [] wordlist;
  private char[] guessedCharacters;

  /** A boolean to determine if the list of words should be shown.  True to show, false to hide.        */

  /** A random int, from 5 to 9 (inclusive), representing the length of the chosen word.                */
  private int wordlength;

  /** You may want to create a few more field variables.    */
  private Dice die1;

  public SuperH()
  {
    wordlength = -1;
    die1 = new Dice(4);
    wordlength = die1.roll()+5;
  }
  /** Play the game.  */
  public static void main (String [] args)
  {
    SuperH run;
    run = new SuperH();
    run.loadWords();
    run.playGame();
    //run.exitMessage();
  }
  /** Open up the text file for reading.  Count the number of words of length wordlength in the file.
  *  Close the text file.  Set the size of the wordlist array to be equal to the count you just found
  *  for the number of words.  Open up the text file again, saving the words in the the wordlist
  *  array.  Close the text file.
  */
  public void loadWords ( )
  {
    System.out.println(wordlength);
    Scanner wordScanner = OpenFile.openToRead("words.txt");
    int counter = 0;
    String inputString = "";
    while(wordScanner.hasNextLine())
    {
      inputString = wordScanner.nextLine();
      if(wordlength==inputString.length())
      {
        counter++;
      }
    }
    wordScanner.close();
    String[] wordlist = new String[counter];
    wordScanner = OpenFile.openToRead("words.txt");
    inputString = "";
    counter = 0;
    while(counter<wordlist.length)
    {
      inputString = wordScanner.nextLine();
      if(inputString.length()==wordlength)
      {
        //System.out.println(inputString);
        wordlist[counter] = inputString;
        counter++;
      }
    }
    //printing press
  }

  /** A loop that plays a single game.      */
  public void playGame ( )
  {
    boolean done = false;
    do
    {
      printWordList();
      if(1+1==2)
      return;
      getCharGuess();
      wordlist = eliminateWords();        /** This is the hard part.  Skip this as you get started.  Write a simple    */
      /** version of Hangman first, then add this functionality later.             */
      done = check();
    }
    while(!done);
  }
  /** Prints the list of words.  If you are creating the simple game of Hangman, just print out the
  *  single word that was chosen at random from the text file.
  */
  public void printWordList ( )
  {
    System.out.println("worddd");
    for(int i = 0; i<10; i++)
    {
      if(i % 7 == 0)
      {
        System.out.println();
      }
      System.out.print(wordlist[i] + "  ");
    }
    System.out.print("\n\n" + wordlength + "   " + wordlist.length);
    System.out.println("barnye");
  }

  /** Prompt and receive a letter guess from the user.  Be sure to deal with "bad input" smoothly.
  */
  public void getCharGuess ( )
  {
    Scanner something = new Scanner(System.in);
    String charizard = something.nextLine();
    //printScore();
    //Prompt.getString("\n\nPlaced here to pause the loop for now: ");
  }

  public void printScore()
  {
    for(int i = 0;i<wordlength;i++)
    {
      System.out.println();
    }
    System.out.println("end char");
  }

  /** Reacts to user input, paring down the list of words.  The idea is to keep as many words as possible
  *  (to make it harder for the user), but following the letters input by the user . . .
  *  @return   The String array of words still possible, matching the user's guesses.
  */
  public String [] eliminateWords ( )
  {
    System.out.println("owaidjawd");
    for(int i = 0;wordlist.length;i++)
    {
      if(find that character)
      counter++;
    }
    }
    String [] arr;
    arr = new String [1];

    return newwordlist;
  }

  /** A check to see if the game is finished, either because the user has made
  *  too many wrong guesses, or the word has been found.
  *  @return   true if the game is over, false if the game should continue
  *            with another turn.
  */
  public boolean check ( )
  {
    return false;
  }

  /** A message at the end of the game, letting the user know if they won or lost.
  *  The word should be printed, and the user should be invited to play again.
  */
  public void exitMessage ( )
  {

  }


  /** More methods to write (and comment) . . .  ?    */



}

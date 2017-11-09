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
    private String correctGuess;
    private String wrongGuess;
    private boolean addToGuess;
    private String masterString;
    private int tries;
    /** A boolean to determine if the list of words should be shown.  True to show, false to hide.        */
    private boolean show;

    /** A random int, from 5 to 9 (inclusive), representing the length of the chosen word.                */
    private int wordlength;

    /** You may want to create a few more field variables.    */
    private Dice die1;

    private String inputChar;


    /** Setup field variables, setting show equal to the boolean in the parameter
     *  list, choosing a random number from 5 to 9 for the wordlength, etc.
     */
    public SuperH(boolean peek)
    {
        show = peek;
        wordlength = -1;
        die1 = new Dice(4);
        //wordlength = die1.roll()+5;
        wordlength = 7;
        correctGuess = "";
        wrongGuess = "";
        addToGuess = false;
        tries = 0;
    }

    /** Play the game.  */
    public static void main (String [] args)
    {
        SuperH run;
        if(args.length > 0 && args[0].equalsIgnoreCase("show"))
        {
            run = new SuperH(true);
        }
        else
        {
            run = new SuperH(false);
        }
        run.loadWords();
        run.welcome();
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
        wordlist = new String[counter];
        wordScanner = OpenFile.openToRead("words.txt");
        inputString = "";
        counter = 0;
        while(counter<wordlist.length)
        {
            inputString = wordScanner.nextLine();
            if(inputString.length()==wordlength)
            {
                wordlist[counter] = inputString;
                counter++;
            }
        }
        wordScanner.close();
    }

    /** A loop that plays a single game.      */
    public void playGame ( )
    {
        boolean done = false;
        do
        {
            if(show)
            {
                printWordList();
            }
            getCharGuess();
            wordlist = eliminateWords();
            updateStatus();
            done = check();
        }
        while(!done);
    }

    /** A welcome with some basic instructions.       */
    public void welcome ( )
    {
        System.out.println("\n\n\n");
        System.out.println(" _____                                  __  __                                                           ");
        System.out.println("/\\  __`\\                               /\\ \\/\\ \\                                                          ");
        System.out.println("\\ \\,\\L\\_\\  __  __  _____      __   _ __\\ \\ \\_\\ \\     __      ___      __     ___ ___      __      ___    ");
        System.out.println(" \\/_\\__ \\ /\\ \\/\\ \\/\\ '__`\\  /'__`\\/\\`'__\\ \\  _  \\  /'__`\\  /' _ `\\  /'_ `\\ /' __` __`\\  /'__`\\  /' _ `\\  ");
        System.out.println("   /\\ \\L\\ \\ \\ \\_\\ \\ \\ \\L\\ \\/\\  __/\\ \\ \\/ \\ \\ \\ \\ \\/\\ \\L\\.\\_/\\ \\/\\ \\/\\ \\L\\ \\/\\ \\/\\ \\/\\ \\/\\ \\L\\.\\_/\\ \\/\\ \\ ");
        System.out.println("   \\ `\\____\\ \\____/\\ \\ ,__/\\ \\____\\\\ \\_\\  \\ \\_\\ \\_\\ \\__/.\\_\\ \\_\\ \\_\\ \\____ \\ \\_\\ \\_\\ \\_\\ \\__/.\\_\\ \\_\\ \\_\\");
        System.out.println("    \\/_____/\\/___/  \\ \\ \\/  \\/____/ \\/_/   \\/_/\\/_/\\/__/\\/_/\\/_/\\/_/\\/___L\\ \\/_/\\/_/\\/_/\\/__/\\/_/\\/_/\\/_/");
        System.out.println("                     \\ \\_\\                                            /\\____/                            ");
        System.out.println("                      \\/_/                                            \\_/__/     ");
        System.out.println("\n");
        System.out.println("\n                       WElCOME TO THE GAME OF SUPER HANGMAN.");
        System.out.println("\n     A word, of length 5 to 9 letters, will be chosen at random from the dictionary.");
        System.out.println("     You will be invited to input letter guesses, attempting to spell the word");
        System.out.println("     before making 7 wrong guesses.  If you can choose the correct letters before");
        System.out.println("     making 7 wrong guesses, you win.  If you reach 7 wrong guesses before");
        System.out.println("     completing the word, you lose.  Good luck!\n\n");
        Prompt.getString("     Press the ENTER key to begin the game: ");
    }

    /** Prints the list of words.  If you are creating the simple game of Hangman, just print out the
     *  single word that was chosen at random from the text file.
     */
    public void printWordList ( )
    {
        for(int i = 0; i < wordlist.length; i++)
        {
            if(i % 7 == 0)
            {
                System.out.println();
            }
            System.out.print(wordlist[i] + "  ");
        }
        System.out.print("\n\n" + wordlength + "   " + wordlist.length);
        System.out.println("\n\n");
    }

    /** Prompt and receive a letter guess from the user.  Be sure to deal with "bad input" smoothly.
     */
    public void getCharGuess ( )
    {
        //printScore();
//         _ _ _ _ _ _    The word has 7 letters, and you've guessed:
// Find the word in less than 7 wrong guesses.  So far, you have made 0 wrong guess(es).
// Please enter a new letter guess: e

        String input = "";
        while(input.length()==0||input.length()>1)
        {
          System.out.println("");
          printScore();
          System.out.printf("\tThe word has "+wordlength+" letters, and you've guessed: ");
          System.out.print(wrongGuess);
          System.out.println("\n\nFind the words in less than 7 wrong guesses. So far, you have made "+tries+" wrong guess(es).");
          input = Prompt.getString("\nPlease enter a new letter guess: ");
        }
        tries++;
        inputChar = input;

        // System.out.println("end guess");
    }

    public void printScore()
    {
      if(correctGuess.length()==0)
      {
        for(int i = 0;i<wordlength;i++)
        {
          correctGuess+="_";
        }
      }

    }
    public void updateStatus()
    {
      if(addToGuess)
      {
        for(int i = 0;i<wordlength;i++)
        {
          if(masterString.charAt(i)=='1')
          {
            if(i==wordlength-1)
            correctGuess = correctGuess.substring(0,i)+inputChar;
            else
            correctGuess = correctGuess.substring(0,i)+inputChar+correctGuess.substring(i+1);
          }
      }
    }
  }
    /** Reacts to user input, paring down the list of words.  The idea is to keep as many words as possible
     *  (to make it harder for the user), but following the letters input by the user . . .
     *  @return   The String array of words still possible, matching the user's guesses.
     */
    public String [] eliminateWords ()
    {
      String[] bypass1 = new String[wordlist.length];
      String[] bypass2 = new String[wordlist.length];
      int[] frequency = new int[wordlist.length];
      int humanWin = 0;
      int algoWin = 0;


      for(int i = 0;i<wordlist.length;i++)
      {
        bypass1[i] = wordlist[i];
      }

      for(int i = 0;i<wordlist.length;i++)
      {
        bypass1[i] = exOut(bypass1[i],inputChar,"0");
        bypass1[i] = exOut(bypass1[i],"0","1");
      }

      for(int i = 0;i<bypass1.length;i++)
      {
        bypass2[i] = bypass1[i];
      }

      for(int i = 0;i<bypass1.length;i++)
      {
        for(int j = 0;j<bypass1.length;j++)
        {
          if(bypass1[i].equals(bypass2[j])&&i!=j&&bypass1[i].contains("1"))
          {
            frequency[i]++;
            bypass2[j] = "";
          }
        }
      }

      int best = 0;
      int indexOfBest = 0;
      //find biggest
      for(int i = 0;i<frequency.length;i++)
      {
        if(!(best>frequency[i]))
        {
          best = frequency[i];
          indexOfBest = i;
        }
      }
      String master = bypass1[indexOfBest];
      // System.out.println("most num times: "+frequency[indexOfBest]+"indexOfbest "+indexOfBest+" binarysig: "+master+" string "+wordlist[indexOfBest]);
      int counter = 0;
      int finalArrayLength = 0;

      for (int i = 0;i<wordlist.length;i++)
      {
          if(bypass1[i].equals(master))
          {
            finalArrayLength++;
          }
      }

      humanWin = finalArrayLength;
      String[] clean = new String[finalArrayLength];

      for (int i = 0;i<wordlist.length;i++)
      {
          if(bypass1[i].equals(master))
          {
            clean[counter] = wordlist[i];
            counter++;
          }
      }

      // for(int i = 0;i<clean.length;i++)
      // {
      //   System.out.println(clean[i]);
      // }
      //construct better array
      //for(int i = 0;i<)
      //without the e
      counter = 0;
      for (int i = 0;i<wordlist.length;i++)
      {
        if(!wordlist[i].contains(inputChar))
        counter++;
      }
      String[] cleanAlgoWin = new String[counter];
      algoWin = counter;
      counter = 0;
      for (int i = 0;i<wordlist.length;i++)
      {
        if(!wordlist[i].contains(inputChar))
        {
          cleanAlgoWin[counter] = wordlist[i];
          counter++;
        }
      }
      String algoMaster = cleanAlgoWin[0];
      // System.out.println("endy h" +humanWin);
      // System.out.println("endyy a" +algoWin);
      if(humanWin>algoWin)
      {
        masterString = master;
        addToGuess = false;
        return clean;
      }
      else
      {
        masterString = algoMaster;
        addToGuess = true;
        return cleanAlgoWin;
      }
    }

    public String exOut(String phrase, String keep, String getOut)
    	{
        // System.out.println(phrase);
        // System.out.println(keep);
        // System.out.println(getOut);
    		int index = phrase.indexOf(keep);
    		int start = 0;
    		while(index != -1 && index < phrase.length())
    		{
    		    for(int i = start; i < index; i++)
    			{
    				phrase = phrase.substring(0,i) + getOut + phrase.substring(i+1);
    			}
    			start = index+keep.length();
    			index = phrase.indexOf(keep,index+1);
    		}
    		for(int i = start; i < phrase.length(); i++)
    		{
    			phrase = phrase.substring(0,i) + getOut + phrase.substring(i+1);
    		}
    		return phrase;
    	}



    /** A check to see if the game is finished, either because the user has made
     *  too many wrong guesses, or the word has been found.
     *  @return   true if the game is over, false if the game should continue
     *            with another turn.
     */
    public boolean check ( )
    {
        if(tries>7)
        return false;
    }

    /** A message at the end of the game, letting the user know if they won or lost.
     *  The word should be printed, and the user should be invited to play again.
     */
    public void exitMessage ( )
    {
      System.out.println("try again soon!");
    }


    /** More methods to write (and comment) . . .  ?    */



}

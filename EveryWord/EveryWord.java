/**
 * EveryWord.java
 * Prompt the user to enter a list (a String)
 * of letters.  The list of letters should be
 * from 3 to 10 letters long.  The list of
 * letters should be letters only.  Then, the
 * text file of words should be opened.  Each
 * word in the text file should be collected,
 * and compared against the list of letters
 * entered by the user.  Every word that
 * matches the list should be printed to the
 * terminal window.
 * @author Surya Dantuluri
 * @version 1.0
 * @since 9/11/2017
 */
import java.util.Scanner;
public class EveryWord
{
    /** The String to be entered by the user.  */
    private String input;

    /** Creates an EveryWord object, with a default input String.
     */
    public EveryWord()
    {
        input = new String("");
    }

    /**
     *  The main method, to run the program.
     */
     public static void main(String[]args)
     {
         EveryWord run = new EveryWord();
         run.getInput();
         run.processFile();
         
     }


    /**
     *  Gets the input from the user (a String).  This String
     *  should be from 3 to 10 letters long, and should be
     *  made up of letters only.  Change all letters to lower
     *  case.
     */
     public void getInput()
     {
         System.out.println("\n\n\n");
         boolean badInput = false;
         do
         {
         badInput = false;
         input = Prompt.getString("\nPlease enter a list of letters, from 3 to 10 letters long, without spaces: ");
         input = input.toLowerCase();
         if(input.length()<3||input.length()>10)
         {
             badInput = true;
         }
         for(int i = 0;i<input.length();i++)
         {
             if(input.charAt(i)<'a'||input.charAt(i)>'z')
             {
                 badInput = true;
                 i = input.length();
             }
        }
    }
         while(badInput);

     }


    /**
     *  Opens the file (words.txt), and reads in the words one
     *  by one.  Each word is checked against the String of
     *  letters input by the user.  If the word from the text
     *  file is comprised of a subset of the letters entered
     *  by the user, the word is printed to the terminal
     *  window.
     */
     public void processFile()
     {
         String word = null;
         Scanner infile = OpenFile.openToRead("words.txt");
         while(infile.hasNext())
         {
             word = infile.nextLine();
            if(matched(word))
            {
             System.out.println(word);
            }
         }
         infile.close();
         System.out.println("\n\n\n");
     }

    /**
     *  A helper method, to match the letters of the word
     *  against the letters of the String entered by the
     *  user.  The letters of the word are checked one at
     *  a time.  If a match is made against the letters
     *  entered by the user, this letter is eliminated from
     *  the list of letters entered by the user, and the
     *  next letter is then checked.  If a match is not
     *  made, false is returned.  If all the letters of the
     *  word can be matched with letters from the String
     *  entered by the user, then true is returned.
     *  @param word   The word being checked from the text file.
     *  @return       true if the word can be built from the letters
     *                entered by the user, false otherwise.
     */
     public boolean matched(String word)
     {
         if(word.length()<3||word.length()>input.length())
         {
             return false;
         }
         String copy = new String(input);
         boolean match = false;
         for(int i = 0;i<word.length();i++)
         {
             match = false;
             for(int j=0;i<copy.length();j++)
             {
                 if(word.charAt(i)==copy.charAt(j))
                 {
                     match = true;
                     copy = copy.substring(0,j)+copy.substring(j+1);
                 }
             }

         }
         return true;
     }
}

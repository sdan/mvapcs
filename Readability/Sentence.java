
/**
 *  Sentence.java
 *  A class that models an English sentence.  This class
 *  has at least one field variable, a String that holds
 *  the sentence.  This sentence should be stored with all
 *  punctuation intact.  You may also wish to create another
 *  field variable; an array of Words (see the description
 *  of the Word class).  This array of Words should be
 *  stored with all punctuation removed.  You should create
 *  one or two constructors.  You should create at least
 *  3 methods for this class.
 *  (a) getSentence -> no args, returns the String that
 *      represents the sentence (a field variable).
 *  (b) getNumWords -> no args, counts and returns
 *      the number of words in the sentence.  Words are
 *      defined as letter groups separated by white space.
 *      White space could be tab(s), space(s), and new
 *      line(s).
 *  (c) getNumSyllables -> no args, counts and returns the
 *      number of syllables in the sentence.  The rules for
 *      counting the number of syllables in a Word can be
 *      found in the Word class.  YOU ARE REQUIRED TO MAKE
 *      USE OF (call) THE numSyllables METHOD YOU CREATED
 *      IN THE Word CLASS.
 *  The method stripAllPunctuation may be helpful also, and
 *  is provided for you below.
 *  @author Surya Dantuluri
 *  @version 1.0
 *  @since 9/12/2017
 */
public class Sentence
{
    public String stripAllPunctuation(String temp)
    {
        for(int i = 0; i < temp.length(); i++)
        {
            switch(temp.charAt(i))
            {
                case '.': case ':': case ';': case '?': case '!': case ',': case '\'': case '\"':
                temp = temp.substring(0,i) + " " + temp.substring(i+1);
                break;

                case '\'':
                temp = temp.substring(0,i) + temp.substring(i+1);
                i--;
                break;
            }
        }
        return temp;
    }

    public String getSentence()
    {

    }
    public int getNumWords()
    {

    }
    public int getNumSyllables()
    {
      
    }

}
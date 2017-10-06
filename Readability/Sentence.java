
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
    String modifiedSentence;
    Word [] wordList;
    public Sentence(String originalSentence)
    {
        modifiedSentence = originalSentence;
    }
    public String getSentence()
    {
        return modifiedSentence;
    }
    public int getNumWords()
    {
        int counter = 0;
        modifiedSentence = stripAllPunctuation(modifiedSentence);
        for(int i = 0;i<modifiedSentence.length()-1;i++)
        {
            if(modifiedSentence.charAt(i)<33&&!(modifiedSentence.charAt(i+1)<33))
            {
                counter++;
            }
        }
        if(modifiedSentence.charAt(modifiedSentence.length()-1)<33&&!(modifiedSentence.charAt(0)<33))
            counter++;
        return counter;
    }


    public int getNumSyllables()
    {
        wordList = new Word[getNumWords()];
        int modindexof = 0;
        int count = 0;
        for(int i=0;i<wordList.length;i++)//for loop from 0 to the number of words (up to #ofwords-1)
        //for loop that goes for every word
        {
            while(modifiedSentence.substring(modindexof,modindexof+1).trim().isEmpty())
            {
                modindexof++;
            }//this while loop  removes the white spaces
            wordList[i] = new Word(modifiedSentence.substring(modindexof,modifiedSentence.indexOf(' ',modindexof+1)));//this substring takes the substring of the word from the modindexof variable to the next space(not including the space because of how substring works)
            count+=wordList[i].numSyllables();//adds the syllables of the word to the count variable
            modindexof = modifiedSentence.indexOf(' ',modindexof);//sets the modeindexof variable to the next space for the for loop to continue
        }
        return count;
    }


    public String stripAllPunctuation(String temp)
    {
        for(int i = 0; i < temp.length(); i++)
        {
            switch(temp.charAt(i))
            {
                case '.': case ':': case ';': case '?': case '!': case ',': case '\"': case '-':
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
}
